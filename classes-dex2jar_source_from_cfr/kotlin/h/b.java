/*
 * Decompiled with CFR 0.139.
 */
package kotlin.h;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.h.c;
import kotlin.h.h;

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class b<T>
implements c<T>,
h<T> {
    private final h<T> a;
    private final int b;

    public b(h<? extends T> object, int n2) {
        j.b(object, "sequence");
        this.a = object;
        this.b = n2;
        n2 = this.b >= 0 ? 1 : 0;
        if (n2 != 0) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("count must be non-negative, but was ");
        ((StringBuilder)object).append(this.b);
        ((StringBuilder)object).append('.');
        throw (Throwable)new IllegalArgumentException(((StringBuilder)object).toString().toString());
    }

    @Override
    public Iterator<T> a() {
        return new Iterator<T>(){
            private final Iterator<T> b;
            private int c;
            {
                this.b = b2.a.a();
                this.c = b2.b;
            }

            private final void a() {
                while (this.c > 0 && this.b.hasNext()) {
                    this.b.next();
                    --this.c;
                }
            }

            @Override
            public boolean hasNext() {
                this.a();
                return this.b.hasNext();
            }

            @Override
            public T next() {
                this.a();
                return this.b.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }

    @Override
    public h<T> a(int n2) {
        return new b<T>(this.a, this.b + n2);
    }

}

