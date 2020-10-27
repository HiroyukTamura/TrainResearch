package p040i.p103M.p107f;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import p040i.C1760K;

/* renamed from: i.M.f.k */
public final class C1809k {

    /* renamed from: a */
    private final Set<C1760K> f2403a = new LinkedHashSet();

    /* renamed from: a */
    public final synchronized void mo27769a(C1760K k) {
        Intrinsics.checkParameterIsNotNull(k, "route");
        this.f2403a.remove(k);
    }

    /* renamed from: b */
    public final synchronized void mo27770b(C1760K k) {
        Intrinsics.checkParameterIsNotNull(k, "failedRoute");
        this.f2403a.add(k);
    }

    /* renamed from: c */
    public final synchronized boolean mo27771c(C1760K k) {
        Intrinsics.checkParameterIsNotNull(k, "route");
        return this.f2403a.contains(k);
    }
}
