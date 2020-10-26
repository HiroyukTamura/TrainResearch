// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import java.io.Writer;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.io.FileOutputStream;
import java.io.File;

public class LogUtils
{
    private static final String TAG = "SeibuApp";
    
    private LogUtils() {
    }
    
    public static void e(final String s, final Exception ex) {
        outputLog(6, s, ex);
    }
    
    public static void outputLog(final int n, final String s) {
        outputLog(n, s, null);
    }
    
    public static void outputLog(final int n, final String s, final Exception ex) {
    }
    
    public static void outputLog(final String s) {
        outputLog(3, s, null);
    }
    
    public static void outputLog(final String s, final String str) {
        final File file = new File(s);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        final File file2 = new File(s + "/log.txt");
        try {
            final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file2, true), Charset.defaultCharset()));
            printWriter.append(str + "\r\n");
            printWriter.flush();
            printWriter.close();
        }
        catch (Exception ex) {
            outputLog(6, "outputLog : Exception", ex);
        }
    }
    
    public static <T> void trace(final T t) {
        v(t.getClass().getSimpleName() + ": " + Thread.currentThread().getStackTrace()[3].getMethodName());
    }
    
    public static void v(final String s) {
        outputLog(s);
    }
    
    public static void w(final String s) {
        outputLog(5, s);
    }
}
