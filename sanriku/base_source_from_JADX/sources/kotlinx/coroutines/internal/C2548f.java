package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.C2496E;
import kotlinx.coroutines.internal.C2551i;

/* renamed from: kotlinx.coroutines.internal.f */
public abstract class C2548f<T> extends C2559n {

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater f4181a = AtomicReferenceFieldUpdater.newUpdater(C2548f.class, Object.class, "_consensus");
    private volatile Object _consensus = C2547e.f4180a;

    /* renamed from: a */
    public final Object mo35554a(Object obj) {
        Object obj2 = this._consensus;
        boolean z = true;
        if (obj2 == C2547e.f4180a) {
            obj2 = mo21869b(obj);
            if (C2496E.m4305a()) {
                if (!(obj2 != C2547e.f4180a)) {
                    throw new AssertionError();
                }
            }
            Object obj3 = this._consensus;
            if (obj3 != C2547e.f4180a) {
                obj2 = obj3;
            } else if (!f4181a.compareAndSet(this, C2547e.f4180a, obj2)) {
                obj2 = this._consensus;
            }
        }
        C2551i.C2552a aVar = (C2551i.C2552a) this;
        C2551i iVar = (C2551i) obj;
        if (obj2 != null) {
            z = false;
        }
        C2551i iVar2 = z ? aVar.f4187c : aVar.f4186b;
        if (iVar2 != null && C2551i.f4183a.compareAndSet(iVar, aVar, iVar2) && z) {
            C2551i iVar3 = aVar.f4187c;
            C2551i iVar4 = aVar.f4186b;
            if (iVar4 == null) {
                Intrinsics.throwNpe();
            }
            iVar3.m4436b(iVar4);
        }
        return obj2;
    }

    /* renamed from: b */
    public abstract Object mo21869b(T t);
}
