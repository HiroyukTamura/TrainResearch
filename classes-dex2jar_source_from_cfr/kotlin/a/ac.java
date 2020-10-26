/*
 * Decompiled with CFR 0.139.
 */
package kotlin.a;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.ad;
import kotlin.e.a.a;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0006H\u0096\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lkotlin/collections/IndexingIterable;", "T", "", "Lkotlin/collections/IndexedValue;", "iteratorFactory", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "iterator", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class ac<T>
implements Iterable<ab<? extends T>>,
kotlin.e.b.a.a {
    private final a<Iterator<T>> a;

    public ac(a<? extends Iterator<? extends T>> a2) {
        j.b(a2, "iteratorFactory");
        this.a = a2;
    }

    @Override
    public Iterator<ab<T>> iterator() {
        return new ad<T>(this.a.a());
    }
}

