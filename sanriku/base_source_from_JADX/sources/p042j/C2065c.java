package p042j;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: j.c */
public final class C2065c implements C2090x {

    /* renamed from: a */
    final /* synthetic */ C2062b f2886a;

    /* renamed from: b */
    final /* synthetic */ C2090x f2887b;

    C2065c(C2062b bVar, C2090x xVar) {
        this.f2886a = bVar;
        this.f2887b = xVar;
    }

    /* renamed from: a */
    public void mo27647a(C2068f fVar, long j) {
        Intrinsics.checkParameterIsNotNull(fVar, FirebaseAnalytics.Param.SOURCE);
        C1532a.m2135a(fVar.size(), 0, j);
        while (true) {
            long j2 = 0;
            if (j > 0) {
                C2087u uVar = fVar.f2890a;
                if (uVar == null) {
                    Intrinsics.throwNpe();
                }
                while (true) {
                    if (j2 >= ((long) 65536)) {
                        break;
                    }
                    j2 += (long) (uVar.f2926c - uVar.f2925b);
                    if (j2 < j) {
                        uVar = uVar.f2929f;
                        if (uVar == null) {
                            break;
                        }
                    }
                    j2 = j;
                    break;
                }
                C2062b bVar = this.f2886a;
                bVar.mo29126g();
                try {
                    this.f2887b.mo27647a(fVar, j2);
                    Unit unit = Unit.INSTANCE;
                    if (!bVar.mo29127h()) {
                        j -= j2;
                    } else {
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
            } else {
                return;
            }
        }
    }

    public void close() {
        C2062b bVar = this.f2886a;
        bVar.mo29126g();
        try {
            this.f2887b.close();
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

    public void flush() {
        C2062b bVar = this.f2886a;
        bVar.mo29126g();
        try {
            this.f2887b.flush();
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

    public C2057A timeout() {
        return this.f2886a;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("AsyncTimeout.sink(");
        a.append(this.f2887b);
        a.append(')');
        return a.toString();
    }
}
