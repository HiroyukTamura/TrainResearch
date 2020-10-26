/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.a.c.e;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ba;

public abstract class b
extends e {
    public b(i i2, m m2, f f2, ba ba2, boolean bl2, int n2, an an2, aq aq2) {
        super(i2, m2, h.a.a(), f2, ba2, bl2, n2, an2, aq2);
    }

    @Override
    public String toString() {
        CharSequence charSequence;
        String string2 = this.l() ? "reified " : "";
        if (this.k() == ba.a) {
            charSequence = "";
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((Object)this.k());
            ((StringBuilder)charSequence).append(" ");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return String.format("%s%s%s", string2, charSequence, this.h_());
    }
}

