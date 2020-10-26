/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.h.c;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.b;
import kotlin.reflect.jvm.internal.impl.j.w;

public class e
extends b
implements an {
    private final kotlin.reflect.jvm.internal.impl.a.e a;
    private final List<as> b;
    private final Collection<w> c;

    public e(kotlin.reflect.jvm.internal.impl.a.e e2, List<? extends as> list, Collection<w> collection, i i2) {
        super(i2);
        this.a = e2;
        this.b = Collections.unmodifiableList(new ArrayList<as>(list));
        this.c = Collections.unmodifiableCollection(collection);
    }

    @Override
    protected Collection<w> a() {
        return this.c;
    }

    @Override
    public List<as> b() {
        return this.b;
    }

    @Override
    public /* synthetic */ h d() {
        return this.j_();
    }

    @Override
    public boolean f() {
        return true;
    }

    @Override
    protected aq g() {
        return aq.a.a;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.e j_() {
        return this.a;
    }

    public String toString() {
        return c.d(this.a).a();
    }
}

