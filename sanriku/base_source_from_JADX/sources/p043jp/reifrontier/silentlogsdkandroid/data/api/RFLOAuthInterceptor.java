package p043jp.reifrontier.silentlogsdkandroid.data.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p040i.C1744A;
import p040i.C1755F;
import p040i.C1758I;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLOAuthInterceptor;", "Lokhttp3/Interceptor;", "tokenType", "", "(Ljava/lang/String;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLOAuthInterceptor */
public final class RFLOAuthInterceptor implements C1744A {

    /* renamed from: a */
    private final String f3323a;

    public RFLOAuthInterceptor(String str) {
        Intrinsics.checkParameterIsNotNull(str, "tokenType");
        this.f3323a = str;
    }

    public C1758I intercept(C1744A.C1745a aVar) {
        Intrinsics.checkParameterIsNotNull(aVar, "chain");
        String accessToken = RFLSharedHolder.INSTANCE.accessToken();
        C1755F request = aVar.request();
        if (request != null) {
            C1755F.C1756a aVar2 = new C1755F.C1756a(request);
            aVar2.mo27550a("Authorization", this.f3323a + ' ' + accessToken);
            return aVar.mo27450a(aVar2.mo27551a());
        }
        throw null;
    }
}
