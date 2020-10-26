/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.aa;
import kotlin.reflect.jvm.internal.impl.j.ab;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.d;
import kotlin.reflect.jvm.internal.impl.j.j;
import kotlin.reflect.jvm.internal.impl.j.p;

final class ae
extends ad {
    private final an a;
    private final List<ap> b;
    private final boolean c;
    private final kotlin.reflect.jvm.internal.impl.h.e.h d;

    public ae(an object, List<? extends ap> list, boolean bl2, kotlin.reflect.jvm.internal.impl.h.e.h h2) {
        kotlin.e.b.j.b(object, "constructor");
        kotlin.e.b.j.b(list, "arguments");
        kotlin.e.b.j.b(h2, "memberScope");
        this.a = object;
        this.b = list;
        this.c = bl2;
        this.d = h2;
        if (!(this.b() instanceof p.b)) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("SimpleTypeImpl should not be created for error type: ");
        ((StringBuilder)object).append(this.b());
        ((StringBuilder)object).append('\n');
        ((StringBuilder)object).append(this.g());
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString());
    }

    @Override
    public List<ap> a() {
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public ad a(boolean bl2) {
        void var2_3;
        if (bl2 == this.c()) {
            return this;
        }
        if (bl2) {
            ab ab2 = new ab(this);
        } else {
            aa aa2 = new aa(this);
        }
        j j2 = (j)var2_3;
        return j2;
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
        kotlin.e.b.j.b(h2, "newAnnotations");
        if (h2.a()) {
            return this;
        }
        return new d(this, h2);
    }

    @Override
    public boolean c() {
        return this.c;
    }

    @Override
    public an g() {
        return this.a;
    }

    @Override
    public h x() {
        return h.a.a();
    }
}

