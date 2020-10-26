/*
 * Decompiled with CFR 0.139.
 */
package kotlin;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.e.a.a;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.u;

@Metadata(bv={1, 0, 2}, d1={"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002R\u0014\u0010\n\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2={"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
final class q<T>
implements Serializable,
kotlin.g<T> {
    private a<? extends T> a;
    private volatile Object b;
    private final Object c;

    public q(a<? extends T> object, Object object2) {
        j.b(object, "initializer");
        this.a = object;
        this.b = u.a;
        object = object2 != null ? object2 : this;
        this.c = object;
    }

    public /* synthetic */ q(a a2, Object object, int n2, g g2) {
        if ((n2 & 2) != 0) {
            object = null;
        }
        this(a2, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public T a() {
        Object object = this.b;
        if (object != u.a) {
            return (T)object;
        }
        Object object2 = this.c;
        synchronized (object2) {
            void var1_5;
            Object object3 = this.b;
            if (object3 == u.a) {
                a<T> a2 = this.a;
                if (a2 == null) {
                    j.a();
                }
                T t2 = a2.a();
                this.b = t2;
                this.a = null;
            }
            return var1_5;
        }
    }

    public boolean b() {
        return this.b != u.a;
    }

    public String toString() {
        if (this.b()) {
            return String.valueOf(this.a());
        }
        return "Lazy value not initialized yet.";
    }
}

