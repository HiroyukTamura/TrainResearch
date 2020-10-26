/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.List;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.o;

public final class ay
extends o {
    private final String a;

    public ay(String string2, an an2, h h2, List<? extends ap> list, boolean bl2) {
        j.b(string2, "presentableName");
        j.b(an2, "constructor");
        j.b(h2, "memberScope");
        j.b(list, "arguments");
        super(an2, h2, list, bl2);
        this.a = string2;
    }

    @Override
    public ad a(boolean bl2) {
        return new ay(this.a, this.g(), this.b(), this.a(), bl2);
    }

    @Override
    public /* synthetic */ az b(boolean bl2) {
        return this.a(bl2);
    }

    public final String d() {
        return this.a;
    }
}

