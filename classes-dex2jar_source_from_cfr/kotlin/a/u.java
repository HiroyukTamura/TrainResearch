/*
 * Decompiled with CFR 0.139.
 */
package kotlin.a;

import java.util.List;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.m;
import kotlin.a.t;
import kotlin.e.b.j;
import kotlin.g.c;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u00a2\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\b\n\u00a8\u0006\u000b"}, d2={"asReversed", "", "T", "", "asReversedMutable", "reverseElementIndex", "", "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k=5, mv={1, 1, 11}, xi=1, xs="kotlin/collections/CollectionsKt")
class u
extends t {
    public static final /* synthetic */ int a(List list, int n2) {
        return u.c(list, n2);
    }

    public static final /* synthetic */ int b(List list, int n2) {
        return u.d(list, n2);
    }

    private static final int c(List<?> list, int n2) {
        int n3 = m.a(list);
        if (n2 >= 0 && n3 >= n2) {
            return m.a(list) - n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Element index ");
        stringBuilder.append(n2);
        stringBuilder.append(" must be in range [");
        stringBuilder.append(new c(0, m.a(list)));
        stringBuilder.append("].");
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    private static final int d(List<?> list, int n2) {
        int n3 = list.size();
        if (n2 >= 0 && n3 >= n2) {
            return list.size() - n2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position index ");
        stringBuilder.append(n2);
        stringBuilder.append(" must be in range [");
        stringBuilder.append(new c(0, list.size()));
        stringBuilder.append("].");
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public static final <T> List<T> d(List<T> list) {
        j.b(list, "$receiver");
        return new ak<T>(list);
    }
}

