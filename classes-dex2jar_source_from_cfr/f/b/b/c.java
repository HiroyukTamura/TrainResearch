/*
 * Decompiled with CFR 0.139.
 */
package f.b.b;

import c.ab;
import c.ad;
import f.b.b.a;
import f.b.b.b;
import f.e;
import f.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public final class c
extends e.a {
    private c() {
    }

    public static c a() {
        return new c();
    }

    @Override
    public e<ad, ?> a(Type type, Annotation[] arrannotation, n n2) {
        if (type == String.class) {
            return b.i.a;
        }
        if (type != Boolean.class && type != Boolean.TYPE) {
            if (type != Byte.class && type != Byte.TYPE) {
                if (type != Character.class && type != Character.TYPE) {
                    if (type != Double.class && type != Double.TYPE) {
                        if (type != Float.class && type != Float.TYPE) {
                            if (type != Integer.class && type != Integer.TYPE) {
                                if (type != Long.class && type != Long.TYPE) {
                                    if (type != Short.class && type != Short.TYPE) {
                                        return null;
                                    }
                                    return b.h.a;
                                }
                                return b.g.a;
                            }
                            return b.f.a;
                        }
                        return b.e.a;
                    }
                    return b.d.a;
                }
                return b.c.a;
            }
            return b.b.a;
        }
        return b.a.a;
    }

    @Override
    public e<?, ab> a(Type type, Annotation[] arrannotation, Annotation[] arrannotation2, n n2) {
        if (type != String.class && type != Boolean.TYPE && type != Boolean.class && type != Byte.TYPE && type != Byte.class && type != Character.TYPE && type != Character.class && type != Double.TYPE && type != Double.class && type != Float.TYPE && type != Float.class && type != Integer.TYPE && type != Integer.class && type != Long.TYPE && type != Long.class && type != Short.TYPE && type != Short.class) {
            return null;
        }
        return a.a;
    }
}

