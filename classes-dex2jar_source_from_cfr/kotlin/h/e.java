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

@Metadata(bv={1, 0, 2}, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007\u00a2\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class e<T>
implements h<T> {
    private final h<T> a;
    private final boolean b;
    private final b<T, Boolean> c;

    public e(h<? extends T> h2, boolean bl2, b<? super T, Boolean> b2) {
        j.b(h2, "sequence");
        j.b(b2, "predicate");
        this.a = h2;
        this.b = bl2;
        this.c = b2;
    }

    @Override
    public Iterator<T> a() {
        return new Iterator<T>(){
            private final Iterator<T> b;
            private int c;
            private T d;
            {
                this.b = e2.a.a();
                this.c = -1;
            }

            /*
             * Enabled aggressive block sorting
             */
            private final void a() {
                int n2;
                block1 : {
                    while (this.b.hasNext()) {
                        T t2 = this.b.next();
                        if ((Boolean)this.c.a(t2) != this.b) continue;
                        this.d = t2;
                        n2 = 1;
                        break block1;
                    }
                    n2 = 0;
                }
                this.c = n2;
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

