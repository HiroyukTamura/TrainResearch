package kotlinx.coroutines;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.C2549g;
import kotlinx.coroutines.internal.C2551i;

/* renamed from: kotlinx.coroutines.j0 */
public final class C2569j0 extends C2549g implements C2514V {
    /* renamed from: a */
    public final String mo35587a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object c = mo35559c();
        if (c != null) {
            boolean z = true;
            for (C2551i iVar = (C2551i) c; !Intrinsics.areEqual((Object) iVar, (Object) this); iVar = iVar.mo35560d()) {
                if (iVar instanceof C2530e0) {
                    C2530e0 e0Var = (C2530e0) iVar;
                    if (z) {
                        z = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(e0Var);
                }
            }
            sb.append("]");
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* renamed from: a */
    public C2569j0 mo21859a() {
        return this;
    }

    public boolean isActive() {
        return true;
    }

    public String toString() {
        return C2496E.m4307c() ? mo35587a("Active") : super.toString();
    }
}
