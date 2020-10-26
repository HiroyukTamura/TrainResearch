/*
 * Decompiled with CFR 0.139.
 */
package kotlin.h;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.h.f;
import kotlin.h.h;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J3\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003\"\u0004\b\u0002\u0010\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000b0\u0006H\u0000\u00a2\u0006\u0002\b\fJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", "E", "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class o<T, R>
implements h<R> {
    private final h<T> a;
    private final b<T, R> b;

    public o(h<? extends T> h2, b<? super T, ? extends R> b2) {
        j.b(h2, "sequence");
        j.b(b2, "transformer");
        this.a = h2;
        this.b = b2;
    }

    @Override
    public Iterator<R> a() {
        return new Iterator<R>(){
            private final Iterator<T> b;
            {
                this.b = o2.a.a();
            }

            @Override
            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override
            public R next() {
                return this.b.a(this.b.next());
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }

    public final <E> h<E> a(b<? super R, ? extends Iterator<? extends E>> b2) {
        j.b(b2, "iterator");
        return new f(this.a, this.b, b2);
    }

}

