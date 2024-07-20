package cn.newworld.springbootcodefellow.console;

import cn.newworld.springbootcodefellow.manager.CommandManager;
import cn.newworld.springbootcodefellow.util.Logger;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 控制台指令执行器类
 * author: EatFan
 */
@Component
public class ConsoleCommandProcessor implements CommandLineRunner {
    private final AtomicBoolean running = new AtomicBoolean(true);

    private final CommandManager commandManager;
    private final LineReader lineReader;
    @Autowired
    public ConsoleCommandProcessor(CommandManager commandManager) throws IOException {
        this.commandManager = commandManager;
        Terminal terminal = TerminalBuilder.builder().build();
        Set<String> registeredCommands = commandManager.getRegisteredCommands();
        this.lineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                .completer(new ArgumentCompleter(new StringsCompleter(registeredCommands)))
                .build();
    }

    @Override
    public void run(String... args) throws Exception {
        // 单独启用一个线程用于处理控制台指令系统
        Thread consoleThread = new Thread(this::processConsoleCommands);
        consoleThread.setDaemon(true);  // 将线程设置为守护线程，程序关闭时候自动关闭线程
        consoleThread.start();

        // 添加钩子在程序关闭时终止线程
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            running.set(false);
            Logger.info("The console command system has been closed...");
        }));
    }

    /**
     * 处理指令
     */
    private void processConsoleCommands() {
        Logger.info("The console command system is starting...");
        while (running.get()){
            String commandLine = lineReader.readLine("> ");
            if (commandLine == null) {
                continue;
            }
            // 分割指令和参数
            String[] commandStrings = commandLine.split(" ");
            if (commandStrings.length > 0) {
                String command = commandStrings[0];
                String[] args = new String[commandStrings.length - 1];
                System.arraycopy(commandStrings, 1, args, 0, args.length);

                // 执行指令
                executeCommand(command,args);
            } else {
                Logger.warning("No command entered.");
            }


        }
    }

    /**
     * 从commandManager中获取对应的commandExecutor 然后执行指令
     * @param command 指令
     * @param args 指令的参数
     */
    private void executeCommand(String command,String[] args){
        CommandExecutor commandExecutor = commandManager.getCommandExecutor(command);
        if (commandExecutor != null){
            if (!commandExecutor.onCommand(command,args)){
                Logger.error("\"/"+command + "\" Command execution failed!",commandExecutor.getClass());
            }
        } else  {
            Logger.error("Unknown command! The command : \"/"+command+"\"");
        }
    }
}
