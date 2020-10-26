/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package jp.a;

import android.content.Context;
import jp.a.a;
import jp.a.c;

public abstract class b {
    static a a;

    public static a a(Context context) {
        if (a == null) {
            a = new c();
        }
        return a;
    }
}

