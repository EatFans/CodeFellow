package cn.newworld.springbootcodefellow.core;

import cn.newworld.springbootcodefellow.util.ColorMessage;

/**
 * 初始化验证器 类
 * 在Main入口程序开始后，先通过本类的方法，进行服务端验证，初始化后，打开SpringBoot服务，最后进行各种业务逻辑
 * author: EatFan
 */
public class InitializeValidator {
    /**
     * 打印NewWorld字符串Logo
     */
    public void printNewWorldStringLogo(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" _   _              __        __         _     _ ____  _             _ _       ");
        System.out.println("| \\ | | _____      _\\ \\      / /__  _ __| | __| / ___|| |_ _   _  __| (_) ___  ");
        System.out.println("|  \\| |/ _ \\ \\ /\\ / /\\ \\ /\\ / / _ \\| '__| |/ _` \\___ \\| __| | | |/ _` | |/ _ \\ ");
        System.out.println("| |\\  |  __/\\ V  V /  \\ V  V / (_) | |  | | (_| |___) | |_| |_| | (_| | | (_) |");
        System.out.println("|_| \\_|\\___| \\_/\\_/    \\_/\\_/ \\___/|_|  |_|\\__,_|____/ \\__|\\__,_|\\__,_|_|\\___/ ");
        System.out.println("                                                                               ");
        System.out.println(ColorMessage.green(" :: CodeFellow Forum System Server :: "));
        System.out.println(" ");

    }

    /**
     * 初始化文件
     */
    public void initFiles(){
        System.out.println("Preparing to initialize and create server system files...");


        System.out.println("Initialization and creation of server system files was successful!");
    }

     /**
     * 验证启动密钥密码
     * @param password 密钥密码
     * @return 如果验证成功就返回true，否则就返回false
     */
    public boolean verifyKey(String password){
        return password.equalsIgnoreCase("123456");
    }
}
