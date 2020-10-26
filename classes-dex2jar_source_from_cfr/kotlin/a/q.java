/*
 * Decompiled with CFR 0.139.
 */
package kotlin.a;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0002\u00a8\u0006\u0004"}, d2={"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, k=5, mv={1, 1, 11}, xi=1, xs="kotlin/collections/CollectionsKt")
class q
extends p {
    public static final <T> Iterator<T> a(final Enumeration<T> enumeration) {
        j.b(enumeration, "$receiver");
        return new Iterator<T>(){

            @Override
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @Override
            public T next() {
                return (T)enumeration.nextElement();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }

}

