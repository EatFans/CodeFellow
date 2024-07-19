package cn.newworld.springbootcodefellow.util;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * 自定义日志类
 */
public class Logger {

    // ANSI 转义码
    private static final String RESET = "\033[0m"; // 重置颜色
    private static final String INFO_COLOR = "\033[97m"; // 白色
    private static final String WARN_COLOR = "\033[33m"; // 黄色
    private static final String ERROR_COLOR = "\033[31m"; // 红色

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

    private static String getLogFormat(String level, String message, String color) {
        return String.format("%s%s [%s] --- [%s] : %s%s",
                color,
                getTimeFormat(),
                level,
                "springboot-codefellow",
                message,
                RESET);
    }

    public static void info(String message) {
        System.out.println(getLogFormat("INFO", message, INFO_COLOR));
    }

    public static void warning(String message) {
        System.out.println(getLogFormat("WARN", message, WARN_COLOR));
    }

    public static void error(String message) {
        System.out.println(getLogFormat("ERROR", message, ERROR_COLOR));
    }

    private static String getLogFormat(String level, Class<?> c, String message, String color) {
        return String.format("%s%s [%s] --- [%s] [%s] : %s%s",
                color,
                getTimeFormat(),
                level,
                "springboot-codefellow",
                getClassName(c),
                message,
                RESET);
    }

    public static void info(String message, Class<?> c) {
        System.out.println(getLogFormat("INFO", c, message, INFO_COLOR));
    }

    public static void warning(String message, Class<?> c) {
        System.out.println(getLogFormat("WARN", c, message, WARN_COLOR));
    }

    public static void error(String message, Class<?> c) {
        System.out.println(getLogFormat("ERROR", c, message, ERROR_COLOR));
    }
}
