/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.Handler
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.c.e;
import androidx.core.a.a.c;
import androidx.core.a.a.f;
import androidx.core.e.a;
import androidx.core.e.b;
import androidx.core.graphics.d;
import androidx.core.graphics.f;
import androidx.core.graphics.g;
import androidx.core.graphics.h;

public class c {
    private static final h a;
    private static final e<String, Typeface> b;

    /*
     * Enabled aggressive block sorting
     */
    static {
        void var0_1;
        if (Build.VERSION.SDK_INT >= 28) {
            g g2 = new g();
        } else if (Build.VERSION.SDK_INT >= 26) {
            f f2 = new f();
        } else if (Build.VERSION.SDK_INT >= 24 && androidx.core.graphics.e.a()) {
            androidx.core.graphics.e e2 = new androidx.core.graphics.e();
        } else if (Build.VERSION.SDK_INT >= 21) {
            d d2 = new d();
        } else {
            h h2 = new h();
        }
        a = var0_1;
        b = new e(16);
    }

    public static Typeface a(Context context, Resources object, int n2, String string2, int n3) {
        if ((context = a.a(context, (Resources)object, n2, string2, n3)) != null) {
            object = c.b(object, n2, n3);
            b.a((String)object, (Typeface)context);
        }
        return context;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b.b[] arrb, int n2) {
        return a.a(context, cancellationSignal, arrb, n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Typeface a(Context object, c.a a2, Resources resources, int n2, int n3, f.a a3, Handler handler, boolean bl2) {
        void var5_10;
        void var4_9;
        void var6_11;
        void var2_7;
        void var0_5;
        c.d d2;
        if (d2 instanceof c.d) {
            void var7_12;
            d2 = d2;
            boolean bl3 = false;
            if (var7_12 != false ? d2.b() == 0 : var5_10 == null) {
                bl3 = true;
            }
            int n4 = var7_12 != false ? d2.c() : -1;
            Typeface typeface = b.a(object, d2.a(), (f.a)var5_10, (Handler)var6_11, bl3, n4, (int)var4_9);
        } else {
            c.d d3 = d2 = a.a((Context)object, (c.b)((Object)d2), (Resources)var2_7, (int)var4_9);
            if (var5_10 != null) {
                if (d2 != null) {
                    var5_10.a((Typeface)d2, (Handler)var6_11);
                    c.d d4 = d2;
                } else {
                    var5_10.a(-3, (Handler)var6_11);
                    c.d d5 = d2;
                }
            }
        }
        if (var0_5 != null) {
            void var3_8;
            b.a(c.b((Resources)var2_7, (int)var3_8, (int)var4_9), (Typeface)var0_5);
        }
        return var0_5;
    }

    public static Typeface a(Resources resources, int n2, int n3) {
        return b.a(c.b(resources, n2, n3));
    }

    private static String b(Resources resources, int n2, int n3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resources.getResourcePackageName(n2));
        stringBuilder.append("-");
        stringBuilder.append(n2);
        stringBuilder.append("-");
        stringBuilder.append(n3);
        return stringBuilder.toString();
    }
}

