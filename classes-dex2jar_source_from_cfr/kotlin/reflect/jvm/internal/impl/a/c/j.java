/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import kotlin.reflect.jvm.internal.impl.a.a.b;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.g.c;

public abstract class j
extends b
implements m {
    private final f a;

    public j(h h2, f f2) {
        super(h2);
        this.a = f2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(m m2) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c.h.a(m2));
            stringBuilder.append("[");
            stringBuilder.append(m2.getClass().getSimpleName());
            stringBuilder.append("@");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(m2)));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        catch (Throwable throwable) {}
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m2.getClass().getSimpleName());
        stringBuilder.append(" ");
        stringBuilder.append(m2.h_());
        return stringBuilder.toString();
    }

    @Override
    public f h_() {
        return this.a;
    }

    @Override
    public m m_() {
        return this;
    }

    public String toString() {
        return j.a(this);
    }
}

