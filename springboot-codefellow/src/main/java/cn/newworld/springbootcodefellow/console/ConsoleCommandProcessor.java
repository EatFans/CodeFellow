package cn.newworld.springbootcodefellow.console;

import cn.newworld.springbootcodefellow.manager.CommandManager;
import cn.newworld.springbootcodefellow.util.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 控制台指令执行器类
 * author: EatFan
 */
@Component
public class ConsoleCommandProcessor implements CommandLineRunner {
    private final AtomicBoolean running = new AtomicBoolean(true);

    private CommandManager commandManager;
    @Autowired
    public ConsoleCommandProcessor(CommandManager commandManager){
        this.commandManager = commandManager;
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
        Scanner scanner = new Scanner(System.in);
        while (running.get()){
            String commandString = scanner.nextLine();
            // 分割指令和参数
            String[] commandStrings = commandString.split(" ");
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
            Logger.error("Unknown command! The command : "+command, this.getClass());
        }
    }
}
