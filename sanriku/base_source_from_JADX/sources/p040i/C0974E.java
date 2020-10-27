package p040i;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, mo21739d2 = {"Lokhttp3/Protocol;", "", "protocol", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.E */
public enum C0974E {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    

    /* renamed from: h */
    public static final C0975a f699h = null;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f700a;

    /* renamed from: i.E$a */
    public static final class C0975a {
        public /* synthetic */ C0975a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        /* renamed from: a */
        public final C0974E mo20398a(String str) throws IOException {
            Intrinsics.checkParameterIsNotNull(str, "protocol");
            if (Intrinsics.areEqual((Object) str, (Object) C0974E.HTTP_1_0.f700a)) {
                return C0974E.HTTP_1_0;
            }
            if (Intrinsics.areEqual((Object) str, (Object) C0974E.HTTP_1_1.f700a)) {
                return C0974E.HTTP_1_1;
            }
            if (Intrinsics.areEqual((Object) str, (Object) C0974E.H2_PRIOR_KNOWLEDGE.f700a)) {
                return C0974E.H2_PRIOR_KNOWLEDGE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) C0974E.HTTP_2.f700a)) {
                return C0974E.HTTP_2;
            }
            if (Intrinsics.areEqual((Object) str, (Object) C0974E.SPDY_3.f700a)) {
                return C0974E.SPDY_3;
            }
            if (Intrinsics.areEqual((Object) str, (Object) C0974E.QUIC.f700a)) {
                return C0974E.QUIC;
            }
            throw new IOException(C0681a.m320a("Unexpected protocol: ", str));
        }
    }

    static {
        HTTP_1_0 = new C0974E("HTTP_1_0", 0, "http/1.0");
        HTTP_1_1 = new C0974E("HTTP_1_1", 1, "http/1.1");
        SPDY_3 = new C0974E("SPDY_3", 2, "spdy/3.1");
        HTTP_2 = new C0974E("HTTP_2", 3, "h2");
        H2_PRIOR_KNOWLEDGE = new C0974E("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        QUIC = new C0974E("QUIC", 5, "quic");
        f699h = new C0975a((DefaultConstructorMarker) null);
    }

    private C0974E(String str) {
        this.f700a = str;
    }

    public String toString() {
        return this.f700a;
    }
}
