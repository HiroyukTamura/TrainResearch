/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import kotlin.reflect.jvm.internal.impl.j.a.c;
import kotlin.reflect.jvm.internal.impl.j.a.p;
import kotlin.reflect.jvm.internal.impl.j.a.q;
import kotlin.reflect.jvm.internal.impl.j.a.r;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.w;

public class d
implements c {
    private final q b;

    protected d(q q2) {
        this.b = q2;
    }

    public static c a(final c.a a2) {
        return new d(new q(new p(){

            @Override
            public boolean a(an an2, an an3) {
                return an2.equals(an3) || a2.a(an2, an3);
                {
                }
            }
        }));
    }

    @Override
    public boolean a(w w2, w w3) {
        return this.b.d(w2, w3);
    }

    @Override
    public boolean b(w w2, w w3) {
        return this.b.b(w2, w3);
    }

}

