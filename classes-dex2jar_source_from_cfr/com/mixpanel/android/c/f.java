/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.mixpanel.android.c;

import android.util.Log;

public class f {
    private static int a = 5;

    public static void a(int n2) {
        a = n2;
    }

    public static void a(String string2, String string3) {
        if (f.b(2)) {
            Log.v((String)string2, (String)string3);
        }
    }

    public static void a(String string2, String string3, Throwable throwable) {
        if (f.b(2)) {
            Log.v((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void b(String string2, String string3) {
        if (f.b(3)) {
            Log.d((String)string2, (String)string3);
        }
    }

    public static void b(String string2, String string3, Throwable throwable) {
        if (f.b(3)) {
            Log.d((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    private static boolean b(int n2) {
        return a <= n2;
    }

    public static void c(String string2, String string3) {
        if (f.b(4)) {
            Log.i((String)string2, (String)string3);
        }
    }

    public static void c(String string2, String string3, Throwable throwable) {
        if (f.b(4)) {
            Log.i((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void d(String string2, String string3) {
        if (f.b(5)) {
            Log.w((String)string2, (String)string3);
        }
    }

    public static void d(String string2, String string3, Throwable throwable) {
        if (f.b(5)) {
            Log.w((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void e(String string2, String string3) {
        if (f.b(6)) {
            Log.e((String)string2, (String)string3);
        }
    }

    public static void e(String string2, String string3, Throwable throwable) {
        if (f.b(6)) {
            Log.e((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void f(String string2, String string3) {
        if (f.b(6)) {
            Log.wtf((String)string2, (String)string3);
        }
    }

    public static void f(String string2, String string3, Throwable throwable) {
        if (f.b(6)) {
            Log.wtf((String)string2, (String)string3, (Throwable)throwable);
        }
    }
}

