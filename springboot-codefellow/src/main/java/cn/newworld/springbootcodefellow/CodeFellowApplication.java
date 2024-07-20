package cn.newworld.springbootcodefellow;

import cn.newworld.springbootcodefellow.core.InitializeValidator;
import cn.newworld.springbootcodefellow.util.ColorMessage;
import cn.newworld.springbootcodefellow.util.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;

@SpringBootApplication
public class CodeFellowApplication {

	public static void main(String[] args) {

		initApplication();

		SpringApplication.run(CodeFellowApplication.class, args);
	}


	private static void initApplication(){
		InitializeValidator initializeValidator = new InitializeValidator();
		initializeValidator.printNewWorldStringLogo();

		// 初始化初始文件
		initializeValidator.initFiles();

		// 验证服务端启动密码
		System.out.println(" ");
		System.out.println(ColorMessage.yellow("In order to ensure that the server will not be leaked and cause security risks, please enter the server startup key for verification. If the verification is successful, the business service can be started. Otherwise, the server will be automatically terminated."));
		System.out.println(" ");
		Console console = System.console();
		if (console == null) {
			System.out.println("No console available. Exiting...");
			System.exit(-1);
		}

		char[] passwordArray = console.readPassword("Enter password > ");
		String password = new String(passwordArray);

		if (!initializeValidator.verifyKey(password)){
			Logger.error("Unable to start server!");
			Logger.error("Reason: Server startup key password verification error! Please check your server startup key password and restart!");
			Logger.error("If you do not know the server activation key password and are not authorized to use this server, sorry! Please do not continue to use this server! Otherwise you will be suspected of infringing our copyright, and we have the right to sue and warn you!");
			Logger.info("Forcefully shutting down the server...");
			System.exit(-1);
		}
		System.out.println(ColorMessage.green("Start key password verification successful! Starting server..."));

	}

}
