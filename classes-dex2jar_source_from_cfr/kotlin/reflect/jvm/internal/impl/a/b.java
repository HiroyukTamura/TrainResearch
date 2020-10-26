/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.v;
import kotlin.reflect.jvm.internal.impl.a.w;

public interface b
extends kotlin.reflect.jvm.internal.impl.a.a,
v {
    public b a(m var1, w var2, ba var3, a var4, boolean var5);

    public void a(Collection<? extends b> var1);

    public Collection<? extends b> k();

    public b l();

    public a n();

    public static enum a {
        a,
        b,
        c,
        d;
        

        public boolean a() {
            return this != b;
        }
    }

}

