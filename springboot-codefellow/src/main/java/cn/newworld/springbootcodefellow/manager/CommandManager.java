package cn.newworld.springbootcodefellow.manager;

import cn.newworld.springbootcodefellow.console.CommandExecutor;
import cn.newworld.springbootcodefellow.console.command.TestCommand;
import cn.newworld.springbootcodefellow.util.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

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
        Logger.info("CommandManager 正在注册指令初始化中...",this.getClass());
        registerCommand("test",new TestCommand());
        Logger.info("CommandManager 指令注册初始化完毕！",this.getClass());
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
}
