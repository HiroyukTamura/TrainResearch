/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.j;
import kotlin.reflect.jvm.internal.impl.f.o;
import kotlin.reflect.jvm.internal.impl.f.x;

public class n
extends AbstractList<String>
implements RandomAccess,
o {
    public static final o a = new n().b();
    private final List<Object> b;

    public n() {
        this.b = new ArrayList<Object>();
    }

    public n(o o2) {
        this.b = new ArrayList<Object>(o2.size());
        this.addAll(o2);
    }

    private static String a(Object object) {
        if (object instanceof String) {
            return (String)object;
        }
        if (object instanceof d) {
            return ((d)object).f();
        }
        return j.b((byte[])object);
    }

    private static d b(Object object) {
        if (object instanceof d) {
            return (d)object;
        }
        if (object instanceof String) {
            return d.a((String)object);
        }
        return d.a((byte[])object);
    }

    public String a(int n2) {
        byte[] arrby = this.b.get(n2);
        if (arrby instanceof String) {
            return (String)arrby;
        }
        if (arrby instanceof d) {
            arrby = (d)arrby;
            String string2 = arrby.f();
            if (arrby.g()) {
                this.b.set(n2, string2);
            }
            return string2;
        }
        arrby = arrby;
        String string3 = j.b(arrby);
        if (j.a(arrby)) {
            this.b.set(n2, string3);
        }
        return string3;
    }

    public String a(int n2, String string2) {
        return n.a(this.b.set(n2, string2));
    }

    @Override
    public List<?> a() {
        return Collections.unmodifiableList(this.b);
    }

    @Override
    public void a(d d2) {
        this.b.add(d2);
        ++this.modCount;
    }

    @Override
    public /* synthetic */ void add(int n2, Object object) {
        this.b(n2, (String)object);
    }

    @Override
    public boolean addAll(int n2, Collection<? extends String> collection) {
        Collection<? extends String> collection2 = collection;
        if (collection instanceof o) {
            collection2 = ((o)collection).a();
        }
        boolean bl2 = this.b.addAll(n2, collection2);
        ++this.modCount;
        return bl2;
    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        return this.addAll(this.size(), collection);
    }

    public String b(int n2) {
        Object object = this.b.remove(n2);
        ++this.modCount;
        return n.a(object);
    }

    @Override
    public o b() {
        return new x(this);
    }

    public void b(int n2, String string2) {
        this.b.add(n2, string2);
        ++this.modCount;
    }

    @Override
    public d c(int n2) {
        Object object = this.b.get(n2);
        d d2 = n.b(object);
        if (d2 != object) {
            this.b.set(n2, d2);
        }
        return d2;
    }

    @Override
    public void clear() {
        this.b.clear();
        ++this.modCount;
    }

    @Override
    public /* synthetic */ Object get(int n2) {
        return this.a(n2);
    }

    @Override
    public /* synthetic */ Object remove(int n2) {
        return this.b(n2);
    }

    @Override
    public /* synthetic */ Object set(int n2, Object object) {
        return this.a(n2, (String)object);
    }

    @Override
    public int size() {
        return this.b.size();
    }
}

