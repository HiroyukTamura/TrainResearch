package p009e.p028d.p030b.p031a.p032i.p035u;

import com.google.android.datatransport.runtime.backends.C0617e;
import com.google.android.datatransport.runtime.backends.C0628m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0653s;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.C0881h;
import p009e.p028d.p030b.p031a.p032i.C0896g;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.C0909p;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;

/* renamed from: e.d.b.a.i.u.c */
public class C0918c implements C0920e {

    /* renamed from: f */
    private static final Logger f605f = Logger.getLogger(C0909p.class.getName());

    /* renamed from: a */
    private final C0653s f606a;

    /* renamed from: b */
    private final Executor f607b;

    /* renamed from: c */
    private final C0617e f608c;

    /* renamed from: d */
    private final C0940c f609d;

    /* renamed from: e */
    private final C0966b f610e;

    public C0918c(Executor executor, C0617e eVar, C0653s sVar, C0940c cVar, C0966b bVar) {
        this.f607b = executor;
        this.f608c = eVar;
        this.f606a = sVar;
        this.f609d = cVar;
        this.f610e = bVar;
    }

    /* renamed from: a */
    static /* synthetic */ Object m1255a(C0918c cVar, C0903k kVar, C0896g gVar) {
        cVar.f609d.mo20357a(kVar, gVar);
        cVar.f606a.mo9552a(kVar, 1);
        return null;
    }

    /* renamed from: a */
    static /* synthetic */ void m1256a(C0918c cVar, C0903k kVar, C0881h hVar, C0896g gVar) {
        try {
            C0628m mVar = cVar.f608c.get(kVar.mo20321a());
            if (mVar == null) {
                String format = String.format("Transport backend '%s' is not registered", new Object[]{kVar.mo20321a()});
                f605f.warning(format);
                hVar.onSchedule(new IllegalArgumentException(format));
                return;
            }
            cVar.f610e.mo20359a(C0917b.m1254a(cVar, kVar, mVar.mo9524a(gVar)));
            hVar.onSchedule((Exception) null);
        } catch (Exception e) {
            Logger logger = f605f;
            StringBuilder a = C0681a.m330a("Error scheduling event ");
            a.append(e.getMessage());
            logger.warning(a.toString());
            hVar.onSchedule(e);
        }
    }

    /* renamed from: a */
    public void mo20355a(C0903k kVar, C0896g gVar, C0881h hVar) {
        this.f607b.execute(C0916a.m1253a(this, kVar, hVar, gVar));
    }
}
