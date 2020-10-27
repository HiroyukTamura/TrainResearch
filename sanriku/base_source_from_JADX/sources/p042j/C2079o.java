package p042j;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: j.o */
final class C2079o implements C1016z {

    /* renamed from: a */
    private final InputStream f2910a;

    /* renamed from: b */
    private final C2057A f2911b;

    public C2079o(InputStream inputStream, C2057A a) {
        Intrinsics.checkParameterIsNotNull(inputStream, "input");
        Intrinsics.checkParameterIsNotNull(a, "timeout");
        this.f2910a = inputStream;
        this.f2911b = a;
    }

    public void close() {
        this.f2910a.close();
    }

    public long read(C2068f fVar, long j) {
        Intrinsics.checkParameterIsNotNull(fVar, "sink");
        if (j == 0) {
            return 0;
        }
        if (j >= 0) {
            try {
                this.f2911b.mo29124e();
                C2087u b = fVar.mo29147b(1);
                int read = this.f2910a.read(b.f2924a, b.f2926c, (int) Math.min(j, (long) (8192 - b.f2926c)));
                if (read != -1) {
                    b.f2926c += read;
                    long j2 = (long) read;
                    fVar.mo29170j(fVar.size() + j2);
                    return j2;
                } else if (b.f2925b != b.f2926c) {
                    return -1;
                } else {
                    fVar.f2890a = b.mo29248a();
                    C2088v.f2933c.mo29253a(b);
                    return -1;
                }
            } catch (AssertionError e) {
                if (C2080p.m3584a(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        } else {
            throw new IllegalArgumentException(C0681a.m318a("byteCount < 0: ", j).toString());
        }
    }

    public C2057A timeout() {
        return this.f2911b;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("source(");
        a.append(this.f2910a);
        a.append(')');
        return a.toString();
    }
}
