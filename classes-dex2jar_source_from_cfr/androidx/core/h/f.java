/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory
 *  android.view.LayoutInflater$Factory2
 */
package androidx.core.h;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

public final class f {
    private static Field a;
    private static boolean b;

    public static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                f.b(layoutInflater, (LayoutInflater.Factory2)factory);
                return;
            }
            f.b(layoutInflater, factory2);
        }
    }

    private static void b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!b) {
            try {
                a = LayoutInflater.class.getDeclaredField("mFactory2");
                a.setAccessible(true);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                stringBuilder.append(LayoutInflater.class.getName());
                stringBuilder.append("; inflation may have unexpected results.");
                Log.e((String)"LayoutInflaterCompatHC", (String)stringBuilder.toString(), (Throwable)noSuchFieldException);
            }
            b = true;
        }
        if (a != null) {
            try {
                a.set((Object)layoutInflater, (Object)factory2);
                return;
            }
            catch (IllegalAccessException illegalAccessException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
                stringBuilder.append((Object)layoutInflater);
                stringBuilder.append("; inflation may have unexpected results.");
                Log.e((String)"LayoutInflaterCompatHC", (String)stringBuilder.toString(), (Throwable)illegalAccessException);
            }
        }
    }
}

