package cn.newworld.springbootcodefellow.util;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

/**
 * 字体颜色工具静态类
 * author: EatFan
 */
public class ColorMessage {
    static {
        AnsiConsole.systemInstall();
    }

    /**
     * 将文本变为指定颜色
     * @param text 文本
     * @param color 颜色
     * @return 带有颜色的文本
     */
    public static String colorize(String text, Ansi.Color color) {
        return Ansi.ansi().fg(color).a(text).reset().toString();
    }

    /**
     * 将文本变为白色
     * @param text 文本
     * @return 带有颜色的文本
     */
    public static String white(String text) {
        return colorize(text, Ansi.Color.WHITE);
    }

    /**
     * 将文本变为黄色
     * @param text 文本
     * @return 带有颜色的文本
     */
    public static String yellow(String text) {
        return colorize(text, Ansi.Color.YELLOW);
    }

    /**
     * 将文本变为红色
     * @param text 文本
     * @return 带有颜色的文本
     */
    public static String red(String text) {
        return colorize(text, Ansi.Color.RED);
    }

    /**
     * 将文本变为绿色
     * @param text 文本
     * @return 带有颜色的文本
     */
    public static String green(String text) {
        return colorize(text, Ansi.Color.GREEN);
    }

    /**
     * 将文本变为蓝色
     * @param text 文本
     * @return 带有颜色的文本
     */
    public static String blue(String text) {
        return colorize(text, Ansi.Color.BLUE);
    }

    /**
     * 将文本变为洋红色
     * @param text 文本
     * @return 带有颜色的文本
     */
    public static String magenta(String text) {
        return colorize(text, Ansi.Color.MAGENTA);
    }

    /**
     * 将文本变为青色
     * @param text 文本
     * @return 带有颜色的文本
     */
    public static String cyan(String text) {
        return colorize(text, Ansi.Color.CYAN);
    }

    /**
     * 将文本变为黑色
     * @param text 文本
     * @return 带有颜色的文本
     */
    public static String black(String text) {
        return colorize(text, Ansi.Color.BLACK);
    }
}
