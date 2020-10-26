/*
 * Decompiled with CFR 0.139.
 */
package kotlin.g;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ae;
import kotlin.c.c;
import kotlin.e.b.g;
import kotlin.g.b;

@Metadata(bv={1, 0, 2}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2={"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public class a
implements Iterable<Integer>,
kotlin.e.b.a.a {
    public static final a a = new a(null);
    private final int b;
    private final int c;
    private final int d;

    public a(int n2, int n3, int n4) {
        if (n4 != 0) {
            this.b = n2;
            this.c = c.a(n2, n3, n4);
            this.d = n4;
            return;
        }
        throw (Throwable)new IllegalArgumentException("Step must be non-zero");
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final int c() {
        return this.d;
    }

    public ae d() {
        return new b(this.b, this.c, this.d);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean e() {
        if (this.d > 0) {
            if (this.b <= this.c) return false;
            return true;
        }
        if (this.b >= this.c) return false;
        return true;
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (!(object instanceof a)) break block2;
                if (this.e() && ((a)object).e()) break block3;
                int n2 = this.b;
                object = (a)object;
                if (n2 != ((a)object).b || this.c != ((a)object).c || this.d != ((a)object).d) break block2;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.e()) {
            return -1;
        }
        return (this.b * 31 + this.c) * 31 + this.d;
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.d();
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        int n2;
        StringBuilder stringBuilder;
        if (this.d > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append("..");
            stringBuilder.append(this.c);
            stringBuilder.append(" step ");
            n2 = this.d;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append(" downTo ");
            stringBuilder.append(this.c);
            stringBuilder.append(" step ");
            n2 = -this.d;
        }
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    @Metadata(bv={1, 0, 2}, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\t"}, d2={"Lkotlin/ranges/IntProgression$Companion;", "", "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", "", "rangeEnd", "step", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final a a(int n2, int n3, int n4) {
            return new a(n2, n3, n4);
        }
    }

}

