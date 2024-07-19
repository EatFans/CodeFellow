package cn.newworld.springbootcodefellow.manager;

import cn.newworld.springbootcodefellow.console.CommandExecutor;
import cn.newworld.springbootcodefellow.console.commands.StopCommand;
import cn.newworld.springbootcodefellow.console.commands.TestCommand;
import cn.newworld.springbootcodefellow.util.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 指令管理器类，用于自动管理指令，随着springboot启动自动初始化注册指令以及对应的指令处理器对象
 * author: EatFan
 */
@Component
public class CommandManager {
    private final Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandManager(){
        initCommands();
    }

    /**
     * 初始化注册服务端默认的指令执行器
     */
    private void initCommands() {
        Logger.info("Initializing registration server default commands...",this.getClass());
        registerCommand("stop",new StopCommand());
        registerCommand("test",new TestCommand());
        Logger.info("Server default commands initialization registration completed！",this.getClass());
    }

    /**
     * 初始化注册服务端默认的tab补全
     */
    private void initTabCompleters() {
        Logger.info("Initializing registration server default tab completer...",this.getClass());

        Logger.info("Server default tab completer initialization registration completed！",this.getClass());
    }

    /**
     * 注册指令
     * @param command 指令主名称
     * @param commandExecutor 指令对应的执行器
     */
    public void registerCommand(String command, CommandExecutor commandExecutor){
        commands.put(command,commandExecutor);
    }


    /**
     * 通过指令主名称来获取指令对应的指令执行器
     * @param command 指令的主名称
     * @return 返回指令的执行器
     */
    public CommandExecutor getCommandExecutor(String command){
        return commands.get(command);
    }

    /**
     * 获取所有已经注册的指令
     * @return 返回所有已经注册的指令
     */
    public Set<String> getRegisteredCommands() {
        return commands.keySet();
    }


}
