/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.e.b.a;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2={"iterator", "", "T", "array", "", "([Ljava/lang/Object;)Ljava/util/Iterator;", "kotlin-stdlib"}, k=2, mv={1, 1, 11})
public final class b {
    public static final <T> Iterator<T> a(T[] arrT) {
        j.b(arrT, "array");
        return new a<T>(arrT);
    }
}

