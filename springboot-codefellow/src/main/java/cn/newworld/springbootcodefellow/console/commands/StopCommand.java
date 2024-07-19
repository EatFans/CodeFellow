package cn.newworld.springbootcodefellow.console.commands;

import cn.newworld.springbootcodefellow.console.CommandExecutor;
import cn.newworld.springbootcodefellow.util.Logger;


/**
 * 关闭服务器指令处理器
 */
public class StopCommand implements CommandExecutor {


    @Override
    public boolean onCommand(String command, String[] args) {
        if (command.equals("stop")) {
            // 执行关闭操作
            Logger.info("Shutting down the application...");
            System.exit(0); // 正常退出程序
            return true;
        }
        return false; // 指令未处理
    }
}
