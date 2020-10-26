/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.c;

import java.util.ArrayList;
import java.util.List;
import kotlin.e.a.b;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.c.e;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.h.c.a;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.y;

public class ag
extends e {
    private final b<w, Void> a;
    private final List<w> b = new ArrayList<w>(1);
    private boolean c = false;

    private ag(m m2, h h2, boolean bl2, ba ba2, f f2, int n2, an an2, b<w, Void> b2, aq aq2) {
        super(kotlin.reflect.jvm.internal.impl.i.b.a, m2, h2, f2, ba2, bl2, n2, an2, aq2);
        this.a = b2;
    }

    public static as a(m m2, h object, boolean bl2, ba ba2, f f2, int n2) {
        object = ag.a(m2, (h)object, bl2, ba2, f2, n2, an.a);
        ((ag)object).b(a.d(m2).getDefaultBound());
        ((ag)object).o();
        return object;
    }

    public static ag a(m m2, h h2, boolean bl2, ba ba2, f f2, int n2, an an2) {
        return ag.a(m2, h2, bl2, ba2, f2, n2, an2, null, aq.a.a);
    }

    public static ag a(m m2, h h2, boolean bl2, ba ba2, f f2, int n2, an an2, b<w, Void> b2, aq aq2) {
        return new ag(m2, h2, bl2, ba2, f2, n2, an2, b2, aq2);
    }

    private void c(w w2) {
        if (y.a(w2)) {
            return;
        }
        this.b.add(w2);
    }

    private void p() {
        if (this.c) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type parameter descriptor is not initialized: ");
        stringBuilder.append(this.r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void q() {
        if (!this.c) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type parameter descriptor is already initialized: ");
        stringBuilder.append(this.r());
        throw new IllegalStateException(stringBuilder.toString());
    }

    private String r() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.h_());
        stringBuilder.append(" declared in ");
        stringBuilder.append(c.d(this.b()));
        return stringBuilder.toString();
    }

    @Override
    protected void a(w w2) {
        if (this.a == null) {
            return;
        }
        this.a.a(w2);
    }

    public void b(w w2) {
        this.q();
        this.c(w2);
    }

    @Override
    protected List<w> m() {
        this.p();
        return this.b;
    }

    public void o() {
        this.q();
        this.c = true;
    }
}

