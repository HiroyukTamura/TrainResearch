package p042j;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: j.d */
public final class C2066d implements C1016z {

    /* renamed from: a */
    final /* synthetic */ C2062b f2888a;

    /* renamed from: b */
    final /* synthetic */ C1016z f2889b;

    C2066d(C2062b bVar, C1016z zVar) {
        this.f2888a = bVar;
        this.f2889b = zVar;
    }

    public void close() {
        C2062b bVar = this.f2888a;
        bVar.mo29126g();
        try {
            this.f2889b.close();
            Unit unit = Unit.INSTANCE;
            if (bVar.mo29127h()) {
                throw bVar.mo27919a((IOException) null);
            }
        } catch (IOException e) {
            e = e;
            if (bVar.mo29127h()) {
                e = bVar.mo27919a(e);
            }
            throw e;
        } finally {
            boolean h = bVar.mo29127h();
        }
    }

    public long read(C2068f fVar, long j) {
        Intrinsics.checkParameterIsNotNull(fVar, "sink");
        C2062b bVar = this.f2888a;
        bVar.mo29126g();
        try {
            long read = this.f2889b.read(fVar, j);
            if (!bVar.mo29127h()) {
                return read;
            }
            throw bVar.mo27919a((IOException) null);
        } catch (IOException e) {
            e = e;
            if (bVar.mo29127h()) {
                e = bVar.mo27919a(e);
            }
            throw e;
        } finally {
            boolean h = bVar.mo29127h();
        }
    }

    public C2057A timeout() {
        return this.f2888a;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("AsyncTimeout.source(");
        a.append(this.f2889b);
        a.append(')');
        return a.toString();
    }
}
