package cn.newworld.springbootcodefellow.console;

/**
 * 指令执行器接口
 * author: EatFan
 */
public interface CommandExecutor {
    /**
     * 指令实现执行的接口统一方法
     * @param command 指令
     * @param args 指令的参数
     * @return 如果执行成功就返回true，否则就返回false
     */
    boolean onCommand(String command,String[] args);
}
