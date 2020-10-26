/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.o;

public class x
extends AbstractList<String>
implements RandomAccess,
o {
    private final o a;

    public x(o o2) {
        this.a = o2;
    }

    public String a(int n2) {
        return (String)this.a.get(n2);
    }

    @Override
    public List<?> a() {
        return this.a.a();
    }

    @Override
    public void a(d d2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public o b() {
        return this;
    }

    @Override
    public d c(int n2) {
        return this.a.c(n2);
    }

    @Override
    public /* synthetic */ Object get(int n2) {
        return this.a(n2);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>(){
            Iterator<String> a;
            {
                this.a = x.this.a.iterator();
            }

            public String a() {
                return this.a.next();
            }

            @Override
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override
            public /* synthetic */ Object next() {
                return this.a();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public ListIterator<String> listIterator(final int n2) {
        return new ListIterator<String>(){
            ListIterator<String> a;
            {
                this.a = x.this.a.listIterator(n2);
            }

            public String a() {
                return this.a.next();
            }

            public void a(String string2) {
                throw new UnsupportedOperationException();
            }

            @Override
            public /* synthetic */ void add(Object object) {
                this.b((String)object);
            }

            public String b() {
                return this.a.previous();
            }

            public void b(String string2) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean hasNext() {
                return this.a.hasNext();
            }

            @Override
            public boolean hasPrevious() {
                return this.a.hasPrevious();
            }

            @Override
            public /* synthetic */ Object next() {
                return this.a();
            }

            @Override
            public int nextIndex() {
                return this.a.nextIndex();
            }

            @Override
            public /* synthetic */ Object previous() {
                return this.b();
            }

            @Override
            public int previousIndex() {
                return this.a.previousIndex();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public /* synthetic */ void set(Object object) {
                this.a((String)object);
            }
        };
    }

    @Override
    public int size() {
        return this.a.size();
    }

}

