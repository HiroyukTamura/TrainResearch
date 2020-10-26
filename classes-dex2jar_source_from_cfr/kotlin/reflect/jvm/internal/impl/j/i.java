/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;

public abstract class i
extends ad {
    @Override
    public List<ap> a() {
        return this.d().a();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.h.e.h b() {
        return this.d().b();
    }

    @Override
    public boolean c() {
        return this.d().c();
    }

    protected abstract ad d();

    @Override
    public an g() {
        return this.d().g();
    }

    @Override
    public h x() {
        return this.d().x();
    }
}

