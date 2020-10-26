// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.log;

import android.util.Log;
import jp.co.ncdc.apppot.stew.APService;

public class Logger
{
    private static final String TAG = "ApPot";
    private static APService as;
    
    static {
        Logger.as = APService.getInstance();
    }
    
    private Logger() {
    }
    
    public static void d(final String str) {
        if (isDebugEnabled()) {
            Log.d("ApPot", "[" + Thread.currentThread().getName() + "]" + str);
        }
    }
    
    public static void d(final String s, final String str) {
        if (isDebugEnabled()) {
            Log.d(s, "[" + Thread.currentThread().getName() + "]" + str);
        }
    }
    
    public static void d(final String s, final String str, final Throwable t) {
        if (isDebugEnabled()) {
            Log.d(s, "[" + Thread.currentThread().getName() + "]" + str, t);
        }
    }
    
    public static void d(final String s, final String format, final Object... args) {
        if (isDebugEnabled()) {
            Log.d(s, "[" + Thread.currentThread().getName() + "]" + String.format(format, args));
        }
    }
    
    public static void d(final String str, final Throwable t) {
        if (isDebugEnabled()) {
            Log.d("ApPot", "[" + Thread.currentThread().getName() + "]" + str, t);
        }
    }
    
    public static void e(final String str) {
        if (isErrorEnabled()) {
            Log.e("ApPot", "[" + Thread.currentThread().getName() + "]" + str);
        }
    }
    
    public static void e(final String s, final String str) {
        if (isErrorEnabled()) {
            Log.e(s, "[" + Thread.currentThread().getName() + "]" + str);
        }
    }
    
    public static void e(final String s, final String str, final Throwable t) {
        if (isErrorEnabled()) {
            Log.e(s, "[" + Thread.currentThread().getName() + "]" + str, t);
        }
    }
    
    public static void e(final String s, final String format, final Object... args) {
        if (isErrorEnabled()) {
            Log.e(s, "[" + Thread.currentThread().getName() + "]" + String.format(format, args));
        }
    }
    
    public static void e(final String str, final Throwable t) {
        if (isErrorEnabled()) {
            Log.e("ApPot", "[" + Thread.currentThread().getName() + "]" + str, t);
        }
    }
    
    public static void i(final String str) {
        if (isInfoEnabled()) {
            Log.i("ApPot", "[" + Thread.currentThread().getName() + "]" + str);
        }
    }
    
    public static void i(final String s, final String str) {
        if (isInfoEnabled()) {
            Log.i(s, "[" + Thread.currentThread().getName() + "]" + str);
        }
    }
    
    public static void i(final String s, final String str, final Throwable t) {
        if (isInfoEnabled()) {
            Log.i(s, "[" + Thread.currentThread().getName() + "]" + str, t);
        }
    }
    
    public static void i(final String s, final String format, final Object... args) {
        if (isInfoEnabled()) {
            Log.i(s, "[" + Thread.currentThread().getName() + "]" + String.format(format, args));
        }
    }
    
    public static void i(final String str, final Throwable t) {
        if (isInfoEnabled()) {
            Log.i("ApPot", "[" + Thread.currentThread().getName() + "]" + str, t);
        }
    }
    
    public static boolean isDebugEnabled() {
        return isLoggable(LogLevel.debug.level());
    }
    
    public static boolean isErrorEnabled() {
        return isLoggable(LogLevel.error.level());
    }
    
    public static boolean isInfoEnabled() {
        return isLoggable(LogLevel.info.level());
    }
    
    private static boolean isLoggable(final int n) {
        return Logger.as.getLogLevel().level() <= n;
    }
    
    public static boolean isVerboseEnabled() {
        return isLoggable(LogLevel.verbose.level());
    }
    
    public static boolean isWarnEnabled() {
        return isLoggable(LogLevel.warn.level());
    }
    
    public static void v(final String str) {
        if (isVerboseEnabled()) {
            Log.v("ApPot", "[" + Thread.currentThread().getName() + "]" + str);
        }
    }
    
    public static void v(final String s, final String str) {
        if (isVerboseEnabled()) {
            Log.v(s, "[" + Thread.currentThread().getName() + "]" + str);
        }
    }
    
    public static void v(final String s, final String str, final Throwable t) {
        if (isVerboseEnabled()) {
            Log.v(s, "[" + Thread.currentThread().getName() + "]" + str, t);
        }
    }
    
    public static void v(final String s, final String format, final Object... args) {
        if (isVerboseEnabled()) {
            Log.v(s, "[" + Thread.currentThread().getName() + "]" + String.format(format, args));
        }
    }
    
    public static void v(final String str, final Throwable t) {
        if (isVerboseEnabled()) {
            Log.v("ApPot", "[" + Thread.currentThread().getName() + "]" + str, t);
        }
    }
    
    public static void w(final String str) {
        if (isWarnEnabled()) {
            Log.w("ApPot", "[" + Thread.currentThread().getName() + "]" + str);
        }
    }
    
    public static void w(final String s, final String str) {
        if (isWarnEnabled()) {
            Log.w(s, "[" + Thread.currentThread().getName() + "]" + str);
        }
    }
    
    public static void w(final String s, final String str, final Throwable t) {
        if (isWarnEnabled()) {
            Log.w(s, "[" + Thread.currentThread().getName() + "]" + str, t);
        }
    }
    
    public static void w(final String s, final String format, final Object... args) {
        if (isWarnEnabled()) {
            Log.w(s, "[" + Thread.currentThread().getName() + "]" + String.format(format, args));
        }
    }
    
    public static void w(final String str, final Throwable t) {
        if (isWarnEnabled()) {
            Log.w("ApPot", "[" + Thread.currentThread().getName() + "]" + str, t);
        }
    }
}
