/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007\u00a2\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007\u00a2\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b\u00a2\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k=2, mv={1, 1, 11})
public final class f {
    private static final Object[] a = new Object[0];

    /*
     * Enabled aggressive block sorting
     */
    public static final Object[] a(Collection<?> arrobject) {
        j.b(arrobject, "collection");
        int n2 = arrobject.size();
        if (n2 == 0) {
            return a;
        }
        Iterator iterator = arrobject.iterator();
        if (!iterator.hasNext()) {
            return a;
        }
        arrobject = new Object[n2];
        n2 = 0;
        do {
            Object[] arrobject2;
            int n3 = n2 + 1;
            arrobject[n2] = iterator.next();
            if (n3 >= arrobject.length) {
                int n4;
                if (!iterator.hasNext()) {
                    return arrobject;
                }
                n2 = n4 = n3 * 3 + 1 >>> 1;
                if (n4 <= n3) {
                    if (n3 >= 2147483645) throw (Throwable)new OutOfMemoryError();
                    n2 = 2147483645;
                }
                arrobject2 = Arrays.copyOf(arrobject, n2);
                j.a((Object)arrobject2, "Arrays.copyOf(result, newSize)");
            } else {
                arrobject2 = arrobject;
                if (!iterator.hasNext()) {
                    arrobject = Arrays.copyOf(arrobject, n3);
                    j.a((Object)arrobject, "Arrays.copyOf(result, size)");
                    return arrobject;
                }
            }
            n2 = n3;
            arrobject = arrobject2;
        } while (true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static final Object[] a(Collection<?> object, Object[] arrobject) {
        void var0_8;
        void var1_10;
        j.b(object, "collection");
        if (var1_10 == null) throw (Throwable)new NullPointerException();
        int n2 = object.size();
        int n3 = 0;
        if (n2 == 0) {
            void var0_1 = var1_10;
            if (((void)var1_10).length <= 0) return var0_8;
            var1_10[0] = null;
            return var1_10;
        }
        Iterator iterator = object.iterator();
        if (!iterator.hasNext()) {
            void var0_2 = var1_10;
            if (((void)var1_10).length <= 0) return var0_8;
            var1_10[0] = null;
            return var1_10;
        }
        if (n2 <= ((void)var1_10).length) {
            void var0_3 = var1_10;
        } else {
            Object object2 = Array.newInstance(var1_10.getClass().getComponentType(), n2);
            if (object2 == null) throw new t("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            Object[] arrobject2 = (Object[])object2;
        }
        do {
            void var0_6;
            T[] arrT;
            n2 = n3 + 1;
            var0_6[n3] = iterator.next();
            if (n2 >= ((void)var0_6).length) {
                int n4;
                if (!iterator.hasNext()) {
                    return var0_6;
                }
                n3 = n4 = n2 * 3 + 1 >>> 1;
                if (n4 <= n2) {
                    if (n2 >= 2147483645) throw (Throwable)new OutOfMemoryError();
                    n3 = 2147483645;
                }
                arrT = Arrays.copyOf(var0_6, n3);
                j.a(arrT, "Arrays.copyOf(result, newSize)");
            } else {
                arrT = var0_6;
                if (!iterator.hasNext()) {
                    if (var0_6 == var1_10) {
                        var1_10[n2] = null;
                        return var1_10;
                    }
                    T[] arrT2 = Arrays.copyOf(var0_6, n2);
                    j.a(arrT2, "Arrays.copyOf(result, size)");
                    return var0_8;
                }
            }
            n3 = n2;
            void var0_9 = arrT;
        } while (true);
    }
}

