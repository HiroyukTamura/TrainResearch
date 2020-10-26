/*
 * Decompiled with CFR 0.139.
 */
package kotlin.g;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.a.ae;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2={"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class b
extends ae {
    private final int a;
    private boolean b;
    private int c;
    private final int d;

    /*
     * Enabled aggressive block sorting
     */
    public b(int n2, int n3, int n4) {
        this.d = n4;
        this.a = n3;
        n4 = this.d;
        boolean bl2 = false;
        if (n4 > 0 ? n2 <= n3 : n2 >= n3) {
            bl2 = true;
        }
        this.b = bl2;
        if (!this.b) {
            n2 = this.a;
        }
        this.c = n2;
    }

    @Override
    public int b() {
        int n2 = this.c;
        if (n2 == this.a) {
            if (this.b) {
                this.b = false;
                return n2;
            }
            throw (Throwable)new NoSuchElementException();
        }
        this.c += this.d;
        return n2;
    }

    @Override
    public boolean hasNext() {
        return this.b;
    }
}

