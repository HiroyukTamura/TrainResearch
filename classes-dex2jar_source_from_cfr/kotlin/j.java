/*
 * Decompiled with CFR 0.139.
 */
package kotlin;

import kotlin.Metadata;
import kotlin.e.a.a;
import kotlin.e.b.g;
import kotlin.i;
import kotlin.l;
import kotlin.m;
import kotlin.p;
import kotlin.q;
import kotlin.x;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a(\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u00a8\u0006\t"}, d2={"lazy", "Lkotlin/Lazy;", "T", "initializer", "Lkotlin/Function0;", "lock", "", "mode", "Lkotlin/LazyThreadSafetyMode;", "kotlin-stdlib"}, k=5, mv={1, 1, 11}, xi=1, xs="kotlin/LazyKt")
class j {
    public static final <T> kotlin.g<T> a(a<? extends T> a2) {
        kotlin.e.b.j.b(a2, "initializer");
        return new q(a2, null, 2, null);
    }

    public static final <T> kotlin.g<T> a(l object, a<? extends T> a2) {
        kotlin.e.b.j.b(object, "mode");
        kotlin.e.b.j.b(a2, "initializer");
        switch (i.a[object.ordinal()]) {
            default: {
                throw new m();
            }
            case 3: {
                object = new x<T>(a2);
                break;
            }
            case 2: {
                object = new p<T>(a2);
                break;
            }
            case 1: {
                object = new q(a2, null, 2, null);
            }
        }
        return (kotlin.g)object;
    }
}

