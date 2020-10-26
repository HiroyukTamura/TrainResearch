/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.h;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.e.m;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.w;

public class v
implements an {
    static final /* synthetic */ boolean a;
    private final Set<w> b;
    private final int c;

    static {
        a = v.class.desiredAssertionStatus() ^ true;
    }

    public v(Collection<w> collection) {
        if (!a && collection.isEmpty()) {
            throw new AssertionError((Object)"Attempt to create an empty intersection");
        }
        this.b = new LinkedHashSet<w>(collection);
        this.c = ((Object)this.b).hashCode();
    }

    private static String a(Iterable<w> object) {
        StringBuilder stringBuilder = new StringBuilder("{");
        object = object.iterator();
        while (object.hasNext()) {
            stringBuilder.append(((w)object.next()).toString());
            if (!object.hasNext()) continue;
            stringBuilder.append(" & ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public kotlin.reflect.jvm.internal.impl.h.e.h a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("member scope for intersection type ");
        stringBuilder.append(this);
        return m.a(stringBuilder.toString(), this.b);
    }

    @Override
    public List<as> b() {
        return Collections.emptyList();
    }

    @Override
    public h d() {
        return null;
    }

    @Override
    public KotlinBuiltIns e() {
        return this.b.iterator().next().g().e();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            object = (v)object;
            return !(this.b != null ? !((Object)this.b).equals(((v)object).b) : ((v)object).b != null);
        }
        return false;
    }

    @Override
    public boolean f() {
        return false;
    }

    public int hashCode() {
        return this.c;
    }

    @Override
    public Collection<w> k_() {
        return this.b;
    }

    public String toString() {
        return v.a(this.b);
    }
}

