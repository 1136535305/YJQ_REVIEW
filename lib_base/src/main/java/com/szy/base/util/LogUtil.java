package com.szy.base.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Name: LogUtil
 * Author: YJQ
 * Date: 2020/3/12
 * Desc: 对Logger进行一层封装，使用前续执行init方法进行初始化
 */
public class LogUtil {

    //config
    private static boolean showLog = true;
    private static boolean showThreadInfo = false;

    //static
    private static final String TAG = "LogUtil";


    public static void init() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(showThreadInfo)   //是否显示线程信息，默认为true
                .methodCount(0)         //显示的方法的行数，默认2
                .methodOffset(0)        //隐藏内部方法调用到偏移量，默认5
                .tag(TAG)               //每个日志的全局标记前缀，默认为PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {   //打印日志的条件
                return showLog;
            }
        });
    }


    public static void d(@NonNull String message, @Nullable Object... args) {
        Logger.d(message, args);
    }

    public static void d(String tag, @NonNull String message, @Nullable Object... args) {
        Logger.t(tag).d(message, args);
    }

    public static void d(@Nullable Object object) {
        Logger.d(object);
    }

    public static void e(String tag, @NonNull String message, @Nullable Object... args) {
        Logger.t(tag).e(message, args);
    }

    public static void e(@NonNull String message, @Nullable Object... args) {
        Logger.e(null, message, args);
    }

    public static void e(@Nullable Throwable throwable, @NonNull String message, @Nullable Object... args) {
        Logger.e(throwable, message, args);
    }

    public static void i(@NonNull String message, @Nullable Object... args) {
        Logger.i(message, args);
    }

    public static void i(String tag, @NonNull String message, @Nullable Object... args) {
        Logger.t(tag).i(message, args);
    }

    public static void v(@NonNull String message, @Nullable Object... args) {
        Logger.v(message, args);
    }

    public static void v(String tag, @NonNull String message, @Nullable Object... args) {
        Logger.t(tag).v(message, args);
    }

    public static void w(@NonNull String message, @Nullable Object... args) {
        Logger.w(message, args);
    }

    public static void w(String tag, @NonNull String message, @Nullable Object... args) {
        Logger.t(tag).w(message, args);
    }

    /**
     * Tip: Use this for exceptional situations to log
     * ie: Unexpected errors etc
     */
    public static void wtf(@NonNull String message, @Nullable Object... args) {
        Logger.wtf(message, args);
    }

    /**
     * Formats the given json content and print it
     */
    public static void json(@Nullable String json) {
        Logger.json(json);
    }

    /**
     * Formats the given xml content and print it
     */
    public static void xml(@Nullable String xml) {
        Logger.xml(xml);
    }
}
