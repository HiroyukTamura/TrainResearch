package kotlinx.coroutines.internal;

import kotlin.PublishedApi;
import kotlin.TypeCastException;

/* renamed from: kotlinx.coroutines.internal.h */
public final class C2550h {

    /* renamed from: a */
    private static final Object f4182a = new C2563r("CONDITION_FALSE");

    static {
        new C2563r("LIST_EMPTY");
    }

    /* renamed from: a */
    public static final Object m4432a() {
        return f4182a;
    }

    @PublishedApi
    /* renamed from: a */
    public static final C2551i m4433a(Object obj) {
        C2551i iVar;
        C2560o oVar = (C2560o) (!(obj instanceof C2560o) ? null : obj);
        if (oVar != null && (iVar = oVar.f4202a) != null) {
            return iVar;
        }
        if (obj != null) {
            return (C2551i) obj;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }
}
