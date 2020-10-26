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

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class n<T>
implements h<T> {
    private final h<T> a;
    private final b<T, Boolean> b;

    public n(h<? extends T> h2, b<? super T, Boolean> b2) {
        j.b(h2, "sequence");
        j.b(b2, "predicate");
        this.a = h2;
        this.b = b2;
    }

    @Override
    public Iterator<T> a() {
        return new Iterator<T>(){
            private final Iterator<T> b;
            private int c;
            private T d;
            {
                this.b = n2.a.a();
                this.c = -1;
            }

            private final void a() {
                if (this.b.hasNext()) {
                    T t2 = this.b.next();
                    if (((Boolean)this.b.a(t2)).booleanValue()) {
                        this.c = 1;
                        this.d = t2;
                        return;
                    }
                }
                this.c = 0;
            }

            @Override
            public boolean hasNext() {
                if (this.c == -1) {
                    this.a();
                }
                return this.c == 1;
            }

            @Override
            public T next() {
                if (this.c == -1) {
                    this.a();
                }
                if (this.c != 0) {
                    T t2 = this.d;
                    this.d = null;
                    this.c = -1;
                    return t2;
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

