/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;

public class o
extends ad {
    private final an a;
    private final kotlin.reflect.jvm.internal.impl.h.e.h b;
    private final List<ap> c;
    private final boolean d;

    public o(an an2, kotlin.reflect.jvm.internal.impl.h.e.h h2) {
        this(an2, h2, null, false, 12, null);
    }

    public o(an an2, kotlin.reflect.jvm.internal.impl.h.e.h h2, List<? extends ap> list, boolean bl2) {
        j.b(an2, "constructor");
        j.b(h2, "memberScope");
        j.b(list, "arguments");
        this.a = an2;
        this.b = h2;
        this.c = list;
        this.d = bl2;
    }

    public /* synthetic */ o(an an2, kotlin.reflect.jvm.internal.impl.h.e.h h2, List list, boolean bl2, int n2, g g2) {
        if ((n2 & 4) != 0) {
            list = m.a();
        }
        if ((n2 & 8) != 0) {
            bl2 = false;
        }
        this(an2, h2, list, bl2);
    }

    @Override
    public List<ap> a() {
        return this.c;
    }

    @Override
    public ad a(boolean bl2) {
        return new o(this.g(), this.b(), this.a(), bl2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h b() {
        return this.b;
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
        return this;
    }

    @Override
    public boolean c() {
        return this.d;
    }

    @Override
    public an g() {
        return this.a;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.g().toString());
        String string2 = this.a().isEmpty() ? "" : m.a((Iterable)this.a(), ", ", "<", ">", -1, "...", null);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    @Override
    public h x() {
        return h.a.a();
    }
}

