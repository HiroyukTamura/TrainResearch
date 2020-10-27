package p040i.p103M.p107f;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: i.M.f.l */
public final class C1810l extends RuntimeException {

    /* renamed from: a */
    private IOException f2404a;

    /* renamed from: b */
    private final IOException f2405b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1810l(IOException iOException) {
        super(iOException);
        Intrinsics.checkParameterIsNotNull(iOException, "firstConnectException");
        this.f2405b = iOException;
        this.f2404a = iOException;
    }

    /* renamed from: a */
    public final IOException mo27772a() {
        return this.f2405b;
    }

    /* renamed from: a */
    public final void mo27773a(IOException iOException) {
        Intrinsics.checkParameterIsNotNull(iOException, "e");
        this.f2405b.addSuppressed(iOException);
        this.f2404a = iOException;
    }

    /* renamed from: b */
    public final IOException mo27774b() {
        return this.f2404a;
    }
}
