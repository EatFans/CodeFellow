package cn.newworld.springbootcodefellow.util;

import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 自定义日志类
 */
public class Logger {

    /**
     * 获取系统时间并保存格式返回
     * @return 返回已经设定好的时间格式
     */
    private static String getTimeFormat() {
        OffsetDateTime now = LocalDateTime.now().atOffset(ZoneOffset.ofHours(8)); // 假设时区为+08:00
        return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"));
    }

    private static String getClassName(Class<?> c) {
        return c.getName();
    }

    private static String getProcessId(){
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        return processName.split("@")[0];
    }

    private static String getLogFormat(String level, String message) {
        return String.format("%s  %s %s --- [%s] : %s",
                getTimeFormat(),
                level,
                getProcessId(),
                "springboot-codefellow",
                message);
    }

    public static void info(String message) {
        System.out.println(ColorMessage.white(getLogFormat("INFO", message)));
    }

    public static void warning(String message) {
        System.out.println(ColorMessage.yellow(getLogFormat("WARN", message)));
    }

    public static void error(String message) {
        System.out.println(ColorMessage.red(getLogFormat("ERROR", message)));
    }

    private static String getLogFormat(String level, Class<?> c, String message) {
        return String.format("%s  %s %s --- [%s] [%s] : %s",
                getTimeFormat(),
                level,
                getProcessId(),
                "springboot-codefellow",
                getClassName(c),
                message);
    }

    public static void info(String message, Class<?> c) {
        System.out.println(ColorMessage.white(getLogFormat("INFO", c, message)));
    }

    public static void warning(String message, Class<?> c) {
        System.out.println(ColorMessage.yellow(getLogFormat("WARN", c, message)));
    }

    public static void error(String message, Class<?> c) {
        System.out.println(ColorMessage.red(getLogFormat("ERROR", c, message)));
    }
}
