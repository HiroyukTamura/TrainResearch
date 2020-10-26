/*
 * Decompiled with CFR 0.139.
 */
package kotlin.h;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.h.f;
import kotlin.h.g;
import kotlin.h.h;
import kotlin.h.i;
import kotlin.h.j;
import kotlin.h.o;

@Metadata(bv={1, 0, 2}, d1={"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a+\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\b\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000b\u001a=\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\b2\b\u0010\f\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000bH\u0007\u00a2\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0010\"\u0002H\u0002\u00a2\u0006\u0002\u0010\u0011\u001a\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00050\u000bH\u0002\u00a2\u0006\u0002\b\u0016\u001a)\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u0001H\u0007\u00a2\u0006\u0002\b\u0018\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a@\u0010\u0019\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u001b0\u001a\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0015*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00150\u001a0\u0001\u00a8\u0006\u001c"}, d2={"Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "generateSequence", "", "nextFunction", "seedFunction", "Lkotlin/Function1;", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "R", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, k=5, mv={1, 1, 11}, xi=1, xs="kotlin/sequences/SequencesKt")
class k
extends j {
    public static final <T> h<T> a() {
        return kotlin.h.d.a;
    }

    public static final <T> h<T> a(final T t2, kotlin.e.a.b<? super T, ? extends T> b2) {
        kotlin.e.b.j.b(b2, "nextFunction");
        if (t2 == null) {
            return kotlin.h.d.a;
        }
        return new g<T>(new kotlin.e.a.a<T>(){

            @Override
            public final T a() {
                return (T)t2;
            }
        }, b2);
    }

    public static final <T> h<T> a(final kotlin.e.a.a<? extends T> a2) {
        kotlin.e.b.j.b(a2, "nextFunction");
        return i.b((h)new g<T>(a2, new kotlin.e.a.b<T, T>(){

            @Override
            public final T a(T t2) {
                kotlin.e.b.j.b(t2, "it");
                return (T)a2.a();
            }
        }));
    }

    public static final <T> h<T> a(h<? extends h<? extends T>> h2) {
        kotlin.e.b.j.b(h2, "$receiver");
        return k.a(h2, a.a);
    }

    private static final <T, R> h<R> a(h<? extends T> h2, kotlin.e.a.b<? super T, ? extends Iterator<? extends R>> b2) {
        if (h2 instanceof o) {
            return ((o)h2).a(b2);
        }
        return new f(h2, b.a, b2);
    }

    public static final /* varargs */ <T> h<T> a(T ... arrT) {
        kotlin.e.b.j.b(arrT, "elements");
        boolean bl2 = arrT.length == 0;
        if (bl2) {
            return i.a();
        }
        return kotlin.a.g.l(arrT);
    }

    public static final <T> h<T> b(h<? extends T> h2) {
        kotlin.e.b.j.b(h2, "$receiver");
        if (h2 instanceof kotlin.h.a) {
            return h2;
        }
        return new kotlin.h.a<T>(h2);
    }

}

