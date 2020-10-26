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
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007\u00a2\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
final class g<T>
implements h<T> {
    private final kotlin.e.a.a<T> a;
    private final b<T, T> b;

    public g(kotlin.e.a.a<? extends T> a2, b<? super T, ? extends T> b2) {
        j.b(a2, "getInitialValue");
        j.b(b2, "getNextValue");
        this.a = a2;
        this.b = b2;
    }

    @Override
    public Iterator<T> a() {
        return new Iterator<T>(){
            private T b;
            private int c = -2;

            private final void a() {
                b b2;
                if (this.c == -2) {
                    b2 = this.a.a();
                } else {
                    b2 = this.b;
                    T t2 = this.b;
                    if (t2 == null) {
                        j.a();
                    }
                    b2 = b2.a(t2);
                }
                this.b = b2;
                int n2 = this.b == null ? 0 : 1;
                this.c = n2;
            }

            @Override
            public boolean hasNext() {
                if (this.c < 0) {
                    this.a();
                }
                return this.c == 1;
            }

            @Override
            public T next() {
                if (this.c < 0) {
                    this.a();
                }
                if (this.c != 0) {
                    T t2 = this.b;
                    if (t2 != null) {
                        this.c = -1;
                        return t2;
                    }
                    throw new t("null cannot be cast to non-null type T");
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

