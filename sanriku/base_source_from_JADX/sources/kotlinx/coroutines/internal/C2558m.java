package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.C2537i0;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: kotlinx.coroutines.internal.m */
final class C2558m extends C2537i0 {

    /* renamed from: a */
    private final Throwable f4200a;

    /* renamed from: b */
    private final String f4201b;

    public C2558m(Throwable th, String str) {
        this.f4200a = th;
        this.f4201b = str;
    }

    /* renamed from: p */
    private final Void m4455p() {
        String str;
        if (this.f4200a != null) {
            StringBuilder a = C0681a.m330a("Module with the Main dispatcher had failed to initialize");
            String str2 = this.f4201b;
            if (str2 == null || (str = C0681a.m320a(". ", str2)) == null) {
                str = "";
            }
            a.append(str);
            throw new IllegalStateException(a.toString(), this.f4200a);
        }
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        m4455p();
        throw null;
    }

    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        m4455p();
        throw null;
    }

    /* renamed from: o */
    public C2537i0 mo35536o() {
        return this;
    }

    public String toString() {
        String str;
        StringBuilder a = C0681a.m330a("Main[missing");
        if (this.f4200a != null) {
            StringBuilder a2 = C0681a.m330a(", cause=");
            a2.append(this.f4200a);
            str = a2.toString();
        } else {
            str = "";
        }
        return C0681a.m323a(a, str, ']');
    }
}
