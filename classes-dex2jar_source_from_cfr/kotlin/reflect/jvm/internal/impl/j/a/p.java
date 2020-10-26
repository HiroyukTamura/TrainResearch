/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import kotlin.reflect.jvm.internal.impl.j.a.q;
import kotlin.reflect.jvm.internal.impl.j.a.r;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.w;

class p
implements r {
    p() {
    }

    @Override
    public boolean a(an an2, an an3) {
        return an2.equals(an3);
    }

    @Override
    public boolean a(w w2, ap ap2) {
        return false;
    }

    @Override
    public boolean a(w w2, w w3) {
        return false;
    }

    @Override
    public boolean a(w w2, w w3, q q2) {
        return q2.b(w2, w3);
    }

    @Override
    public boolean b(w w2, w w3, q q2) {
        return q2.d(w2, w3);
    }
}

