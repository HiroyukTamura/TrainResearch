package p043jp.reifrontier.gym.data.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p040i.C1744A;
import p040i.C1755F;
import p040i.C1758I;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGOAuthInterceptor;", "Lokhttp3/Interceptor;", "tokenType", "", "(Ljava/lang/String;)V", "token", "getToken", "()Ljava/lang/String;", "setToken", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGOAuthInterceptor */
public final class RFGOAuthInterceptor implements C1744A {
    private String token;
    private final String tokenType;

    public RFGOAuthInterceptor(String str) {
        Intrinsics.checkParameterIsNotNull(str, "tokenType");
        this.tokenType = str;
    }

    public final String getToken() {
        return this.token;
    }

    public C1758I intercept(C1744A.C1745a aVar) {
        C1755F request;
        Intrinsics.checkParameterIsNotNull(aVar, "chain");
        String str = this.token;
        if (str != null) {
            C1755F request2 = aVar.request();
            if (request2 != null) {
                C1755F.C1756a aVar2 = new C1755F.C1756a(request2);
                aVar2.mo27550a("Authorization", this.tokenType + ' ' + str);
                request = aVar2.mo27551a();
            } else {
                throw null;
            }
        } else {
            request = aVar.request();
        }
        return aVar.mo27450a(request);
    }

    public final void setToken(String str) {
        this.token = str;
    }
}
