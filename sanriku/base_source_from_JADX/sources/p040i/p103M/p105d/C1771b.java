package p040i.p103M.p105d;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import p040i.p103M.C1764b;
import p042j.C1016z;
import p042j.C2057A;
import p042j.C2068f;
import p042j.C2071g;
import p042j.C2072h;

/* renamed from: i.M.d.b */
public final class C1771b implements C1016z {

    /* renamed from: a */
    private boolean f2228a;

    /* renamed from: b */
    final /* synthetic */ C2072h f2229b;

    /* renamed from: c */
    final /* synthetic */ C1772c f2230c;

    /* renamed from: d */
    final /* synthetic */ C2071g f2231d;

    C1771b(C2072h hVar, C1772c cVar, C2071g gVar) {
        this.f2229b = hVar;
        this.f2230c = cVar;
        this.f2231d = gVar;
    }

    public void close() throws IOException {
        if (!this.f2228a && !C1764b.m2632a((C1016z) this, 100, TimeUnit.MILLISECONDS)) {
            this.f2228a = true;
            this.f2230c.mo27600a();
        }
        this.f2229b.close();
    }

    public long read(C2068f fVar, long j) throws IOException {
        Intrinsics.checkParameterIsNotNull(fVar, "sink");
        try {
            long read = this.f2229b.read(fVar, j);
            if (read == -1) {
                if (!this.f2228a) {
                    this.f2228a = true;
                    this.f2231d.close();
                }
                return -1;
            }
            fVar.mo29136a(this.f2231d.getBuffer(), fVar.size() - read, read);
            this.f2231d.mo29158f();
            return read;
        } catch (IOException e) {
            if (!this.f2228a) {
                this.f2228a = true;
                this.f2230c.mo27600a();
            }
            throw e;
        }
    }

    public C2057A timeout() {
        return this.f2229b.timeout();
    }
}
