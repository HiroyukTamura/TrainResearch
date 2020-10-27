package p040i;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0006R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, mo21739d2 = {"Lokhttp3/TlsVersion;", "", "javaName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.L */
public enum C1761L {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    

    /* renamed from: g */
    public static final C1762a f2211g = null;

    /* renamed from: a */
    private final String f2212a;

    /* renamed from: i.L$a */
    public static final class C1762a {
        public /* synthetic */ C1762a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        @JvmStatic
        /* renamed from: a */
        public final C1761L mo27596a(String str) {
            Intrinsics.checkParameterIsNotNull(str, "javaName");
            int hashCode = str.hashCode();
            if (hashCode != 79201641) {
                if (hashCode != 79923350) {
                    switch (hashCode) {
                        case -503070503:
                            if (str.equals("TLSv1.1")) {
                                return C1761L.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (str.equals("TLSv1.2")) {
                                return C1761L.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (str.equals("TLSv1.3")) {
                                return C1761L.TLS_1_3;
                            }
                            break;
                    }
                } else if (str.equals("TLSv1")) {
                    return C1761L.TLS_1_0;
                }
            } else if (str.equals("SSLv3")) {
                return C1761L.SSL_3_0;
            }
            throw new IllegalArgumentException(C0681a.m320a("Unexpected TLS version: ", str));
        }
    }

    static {
        TLS_1_3 = new C1761L("TLS_1_3", 0, "TLSv1.3");
        TLS_1_2 = new C1761L("TLS_1_2", 1, "TLSv1.2");
        TLS_1_1 = new C1761L("TLS_1_1", 2, "TLSv1.1");
        TLS_1_0 = new C1761L("TLS_1_0", 3, "TLSv1");
        SSL_3_0 = new C1761L("SSL_3_0", 4, "SSLv3");
        f2211g = new C1762a((DefaultConstructorMarker) null);
    }

    private C1761L(String str) {
        this.f2212a = str;
    }

    @JvmName(name = "javaName")
    /* renamed from: a */
    public final String mo27595a() {
        return this.f2212a;
    }
}
