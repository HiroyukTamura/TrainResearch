/*
 * Decompiled with CFR 0.139.
 */
package kotlin.a;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.e.b.a.a;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0086\u0002J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class ad<T>
implements Iterator<ab<? extends T>>,
a {
    private int a;
    private final Iterator<T> b;

    public ad(Iterator<? extends T> iterator) {
        j.b(iterator, "iterator");
        this.b = iterator;
    }

    public final ab<T> a() {
        int n2 = this.a;
        this.a = n2 + 1;
        return new ab<T>(n2, this.b.next());
    }

    @Override
    public final boolean hasNext() {
        return this.b.hasNext();
    }

    @Override
    public /* synthetic */ Object next() {
        return this.a();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

