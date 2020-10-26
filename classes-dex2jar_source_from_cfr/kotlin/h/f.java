/*
 * Decompiled with CFR 0.139.
 */
package kotlin.h;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.e.a.b;
import kotlin.e.b.j;
import kotlin.h.h;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004BA\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0096\u0002R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class f<T, R, E>
implements h<E> {
    private final h<T> a;
    private final b<T, R> b;
    private final b<R, Iterator<E>> c;

    public f(h<? extends T> h2, b<? super T, ? extends R> b2, b<? super R, ? extends Iterator<? extends E>> b3) {
        j.b(h2, "sequence");
        j.b(b2, "transformer");
        j.b(b3, "iterator");
        this.a = h2;
        this.b = b2;
        this.c = b3;
    }

    @Override
    public Iterator<E> a() {
        return new Iterator<E>(){
            private final Iterator<T> b;
            private Iterator<? extends E> c;
            {
                this.b = f2.a.a();
            }

            private final boolean a() {
                Iterator<E> iterator = this.c;
                if (iterator != null && !iterator.hasNext()) {
                    this.c = null;
                }
                while (this.c == null) {
                    if (!this.b.hasNext()) {
                        return false;
                    }
                    iterator = this.b.next();
                    iterator = (Iterator<E>)this.c.a(this.b.a(iterator));
                    if (!iterator.hasNext()) continue;
                    this.c = iterator;
                    break;
                }
                return true;
            }

            @Override
            public boolean hasNext() {
                return this.a();
            }

            @Override
            public E next() {
                if (this.a()) {
                    Iterator<E> iterator = this.c;
                    if (iterator == null) {
                        j.a();
                    }
                    return iterator.next();
                }
                throw (Throwable)new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }

}

