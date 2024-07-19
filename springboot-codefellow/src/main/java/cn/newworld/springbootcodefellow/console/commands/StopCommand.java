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
            // 检查 args 数组的长度是否大于 0
            if (args.length > 0) {
                if (args[0].equals("confirm")) {
                    // 执行关闭操作
                    Logger.info("Shutting down the application...");
                    System.exit(0); // 正常退出程序
                    return true; // 指令已处理
                } else {
                    Logger.info("Invalid argument. Please use 'shutdown confirm' to shut down.");
                    return true; // 指令已处理
                }
            } else {
                Logger.info("请输入 'shutdown confirm' 确定关机");
                return true; // 指令已处理
            }
        }
        return false; // 指令未处理
    }
}
