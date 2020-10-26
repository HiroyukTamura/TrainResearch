/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import java.lang.reflect.Type;
import kotlin.e.b.e;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.e.b.k;
import kotlin.e.b.m;
import kotlin.e.b.o;
import kotlin.e.b.q;
import kotlin.e.b.s;
import kotlin.reflect.c;
import kotlin.reflect.f;
import kotlin.reflect.n;

public class w {
    public String a(h object) {
        String string2 = object.getClass().getGenericInterfaces()[0].toString();
        object = string2;
        if (string2.startsWith("kotlin.jvm.functions.")) {
            object = string2.substring("kotlin.jvm.functions.".length());
        }
        return object;
    }

    public String a(k k2) {
        return this.a((h)k2);
    }

    public c a(Class class_) {
        return new e(class_);
    }

    public kotlin.reflect.e a(Class class_, String string2) {
        return new o(class_, string2);
    }

    public f a(i i2) {
        return i2;
    }

    public kotlin.reflect.i a(m m2) {
        return m2;
    }

    public kotlin.reflect.m a(q q2) {
        return q2;
    }

    public n a(s s2) {
        return s2;
    }
}

