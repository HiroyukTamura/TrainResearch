/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;

public final class aj
extends ad {
    private final an a;
    private final boolean b;
    private final an c;
    private final kotlin.reflect.jvm.internal.impl.h.e.h d;

    public aj(an an2, boolean bl2, an an3, kotlin.reflect.jvm.internal.impl.h.e.h h2) {
        j.b(an2, "originalTypeVariable");
        j.b(an3, "constructor");
        j.b(h2, "memberScope");
        this.a = an2;
        this.b = bl2;
        this.c = an3;
        this.d = h2;
    }

    @Override
    public List<ap> a() {
        return m.a();
    }

    @Override
    public ad a(boolean bl2) {
        if (bl2 == this.c()) {
            return this;
        }
        return new aj(this.a, bl2, this.g(), this.b());
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h b() {
        return this.d;
    }

    @Override
    public /* synthetic */ az b(h h2) {
        return this.c(h2);
    }

    @Override
    public /* synthetic */ az b(boolean bl2) {
        return this.a(bl2);
    }

    @Override
    public ad c(h h2) {
        j.b(h2, "newAnnotations");
        throw (Throwable)new IllegalStateException("Shouldn't be called on non-fixed type".toString());
    }

    @Override
    public boolean c() {
        return this.b;
    }

    @Override
    public an g() {
        return this.c;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NonFixed: ");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }

    @Override
    public h x() {
        return h.a.a();
    }
}

