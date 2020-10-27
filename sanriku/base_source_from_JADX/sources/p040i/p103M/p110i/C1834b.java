package p040i.p103M.p110i;

import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, mo21739d2 = {"Lokhttp3/internal/http2/ErrorCode;", "", "httpCode", "", "(Ljava/lang/String;II)V", "getHttpCode", "()I", "NO_ERROR", "PROTOCOL_ERROR", "INTERNAL_ERROR", "FLOW_CONTROL_ERROR", "SETTINGS_TIMEOUT", "STREAM_CLOSED", "FRAME_SIZE_ERROR", "REFUSED_STREAM", "CANCEL", "COMPRESSION_ERROR", "CONNECT_ERROR", "ENHANCE_YOUR_CALM", "INADEQUATE_SECURITY", "HTTP_1_1_REQUIRED", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.i.b */
public enum C1834b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: i */
    public static final C1835a f2474i = null;

    /* renamed from: a */
    private final int f2475a;

    /* renamed from: i.M.i.b$a */
    public static final class C1835a {
        public /* synthetic */ C1835a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public final C1834b mo27807a(int i) {
            for (C1834b bVar : C1834b.m2917b()) {
                if (bVar.mo27806a() == i) {
                    return bVar;
                }
            }
            return null;
        }
    }

    static {
        f2474i = new C1835a((DefaultConstructorMarker) null);
    }

    private C1834b(int i) {
        this.f2475a = i;
    }

    /* renamed from: b */
    public static C1834b[] m2917b() {
        return (C1834b[]) f2473h.clone();
    }

    /* renamed from: a */
    public final int mo27806a() {
        return this.f2475a;
    }
}
