/*
 * Decompiled with CFR 0.139.
 */
package kotlin.c;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002\u00a8\u0006\u000b"}, d2={"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k=2, mv={1, 1, 11})
public final class c {
    private static final int a(int n2, int n3) {
        if ((n2 %= n3) >= 0) {
            return n2;
        }
        return n2 + n3;
    }

    public static final int a(int n2, int n3, int n4) {
        if (n4 > 0) {
            if (n2 >= n3) {
                return n3;
            }
            return n3 - c.b(n3, n2, n4);
        }
        if (n4 < 0) {
            if (n2 <= n3) {
                return n3;
            }
            return n3 + c.b(n2, n3, -n4);
        }
        throw (Throwable)new IllegalArgumentException("Step is zero.");
    }

    private static final int b(int n2, int n3, int n4) {
        return c.a(c.a(n2, n4) - c.a(n3, n4), n4);
    }
}

