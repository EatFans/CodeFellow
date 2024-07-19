package cn.newworld.springbootcodefellow.console.command;

import cn.newworld.springbootcodefellow.console.CommandExecutor;
import cn.newworld.springbootcodefellow.util.Logger;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(String command, String[] args) {
        if (command.equalsIgnoreCase("test")){
            Logger.info("测试指令已经执行成功！");
            return false;
        }
        return false;
    }
}
