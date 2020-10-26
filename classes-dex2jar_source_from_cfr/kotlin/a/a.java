/*
 * Decompiled with CFR 0.139.
 */
package kotlin.a;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.a.b;
import kotlin.e.b.f;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u00a6\u0002J\u0015\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0014\u00a2\u0006\u0002\u0010\u0014J'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0012\"\u0004\b\u0001\u0010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0012H\u0014\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u001a"}, d2={"Lkotlin/collections/AbstractCollection;", "E", "", "()V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public abstract class a<E>
implements Collection<E>,
kotlin.e.b.a.a {
    protected a() {
    }

    public abstract int a();

    @Override
    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean contains(Object object) {
        boolean bl2;
        block2 : {
            bl2 = this instanceof Collection;
            boolean bl3 = false;
            if (bl2 && ((Collection)this).isEmpty()) {
                return false;
            }
            Iterator<T> iterator = this.iterator();
            do {
                bl2 = bl3;
                if (!iterator.hasNext()) break block2;
            } while (!j.a(iterator.next(), object));
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public boolean containsAll(Collection<? extends Object> object) {
        boolean bl2;
        block2 : {
            j.b(object, "elements");
            object = (Iterable)object;
            bl2 = object.isEmpty();
            boolean bl3 = true;
            if (bl2) {
                return true;
            }
            object = object.iterator();
            do {
                bl2 = bl3;
                if (!object.hasNext()) break block2;
            } while (this.contains(object.next()));
            bl2 = false;
        }
        return bl2;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean remove(Object object) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return this.a();
    }

    @Override
    public Object[] toArray() {
        return f.a(this);
    }

    @Override
    public <T> T[] toArray(T[] arrobject) {
        j.b(arrobject, "array");
        arrobject = f.a(this, arrobject);
        if (arrobject != null) {
            return arrobject;
        }
        throw new t("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public String toString() {
        return m.a(this, ", ", "[", "]", 0, null, new b<E, CharSequence>(){

            @Override
            public /* synthetic */ Object a(Object object) {
                return this.b(object);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final CharSequence b(E object) {
                void var1_3;
                if (object == this) {
                    return (CharSequence)var1_3;
                }
                String string2 = String.valueOf(object);
                return (CharSequence)var1_3;
            }
        }, 24, null);
    }

}

