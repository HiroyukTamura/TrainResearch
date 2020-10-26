/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import kotlin.e.b.i;
import kotlin.e.b.k;
import kotlin.e.b.m;
import kotlin.e.b.q;
import kotlin.e.b.s;
import kotlin.e.b.w;
import kotlin.reflect.c;
import kotlin.reflect.e;
import kotlin.reflect.f;
import kotlin.reflect.n;

public class v {
    private static final w a;
    private static final c[] b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        w w2;
        w2 = null;
        try {
            w w3;
            w2 = w3 = (w)Class.forName("kotlin.reflect.jvm.internal.ad").newInstance();
        }
        catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException exception) {}
        if (w2 == null) {
            w2 = new w();
        }
        a = w2;
        b = new c[0];
    }

    public static String a(k k2) {
        return a.a(k2);
    }

    public static c a(Class class_) {
        return a.a(class_);
    }

    public static e a(Class class_, String string2) {
        return a.a(class_, string2);
    }

    public static f a(i i2) {
        return a.a(i2);
    }

    public static kotlin.reflect.i a(m m2) {
        return a.a(m2);
    }

    public static kotlin.reflect.m a(q q2) {
        return a.a(q2);
    }

    public static n a(s s2) {
        return a.a(s2);
    }
}

