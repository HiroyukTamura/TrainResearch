package kotlinx.coroutines;

import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.C1111a0;

/* renamed from: kotlinx.coroutines.e0 */
public abstract class C2530e0<J extends C1111a0> extends C2585s implements C1110L, C2514V {
    @JvmField

    /* renamed from: d */
    public final J f4144d;

    public C2530e0(J j) {
        this.f4144d = j;
    }

    /* renamed from: a */
    public C2569j0 mo21859a() {
        return null;
    }

    /* renamed from: b */
    public void mo21829b() {
        J j = this.f4144d;
        if (j != null) {
            ((C1113f0) j).mo21840a((C2530e0<?>) this);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
    }

    public boolean isActive() {
        return true;
    }
}
