/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package f.a.a;

import b.a.b;
import b.a.d;
import b.a.i;
import f.a.a.e;
import f.a.a.g;
import f.c;
import f.m;
import f.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public final class h
extends c.a {
    @Nullable
    private final b.a.h a;
    private final boolean b;

    private h(@Nullable b.a.h h2, boolean bl2) {
        this.a = h2;
        this.b = bl2;
    }

    public static h a() {
        return new h(null, false);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public c<?, ?> a(Type object, Annotation[] object2, n n2) {
        boolean bl2;
        boolean bl3;
        object2 = h.a((Type)object);
        if (object2 == b.class) {
            return new g((Type)((Object)Void.class), this.a, this.b, false, true, false, false, false, true);
        }
        boolean bl4 = object2 == b.a.c.class;
        boolean bl5 = object2 == i.class;
        boolean bl6 = object2 == d.class;
        if (!(object2 == b.a.e.class || bl4 || bl5 || bl6)) {
            return null;
        }
        if (!(object instanceof ParameterizedType)) {
            object = !bl4 ? (!bl5 ? (bl6 ? "Maybe" : "Observable") : "Single") : "Flowable";
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" return type must be parameterized as ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("<Foo> or ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("<? extends Foo>");
            throw new IllegalStateException(((StringBuilder)object2).toString());
        }
        object2 = h.a((Type)(object = h.a(0, (ParameterizedType)object)));
        if (object2 == m.class) {
            if (!(object instanceof ParameterizedType)) throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            object = h.a(0, (ParameterizedType)object);
            bl3 = false;
        } else {
            if (object2 != e.class) {
                bl3 = false;
                bl2 = true;
                return new g((Type)object, this.a, this.b, bl3, bl2, bl4, bl5, bl6, false);
            }
            if (!(object instanceof ParameterizedType)) throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            object = h.a(0, (ParameterizedType)object);
            bl3 = true;
        }
        bl2 = false;
        return new g((Type)object, this.a, this.b, bl3, bl2, bl4, bl5, bl6, false);
    }
}

