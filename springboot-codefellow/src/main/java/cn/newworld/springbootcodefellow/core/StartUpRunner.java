package cn.newworld.springbootcodefellow.core;

import cn.newworld.springbootcodefellow.util.ColorMessage;
import cn.newworld.springbootcodefellow.util.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *  主要目的是在所有 Spring Boot 应用上下文中的 Bean 被完全初始化和加载后，执行特定的逻辑。
 *  StartupRunner 类中的 run 方法会在 Spring Boot 应用启动完成并且所有 Bean 已经加载之后被自动调用。这可以用来执行一些需要在应用启动时进行的初始化操作
 *  在应用启动后立即执行的任务。例如，检查日志配置、预加载某些数据、启动后台线程、设置定时任务等。
 *
 */
@Component
public class StartUpRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Logger.info(ColorMessage.green("SpringBoot 服务端中的所有Bean 已经加载完毕！"));
        Logger.info(ColorMessage.green("服务端启动成功！"));
    }
}
