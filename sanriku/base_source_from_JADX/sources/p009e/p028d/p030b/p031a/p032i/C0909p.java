package p009e.p028d.p030b.p031a.p032i;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0647m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0651q;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p009e.p028d.p030b.p031a.C0875b;
import p009e.p028d.p030b.p031a.C0877d;
import p009e.p028d.p030b.p031a.C0880g;
import p009e.p028d.p030b.p031a.C0881h;
import p009e.p028d.p030b.p031a.p032i.C0882a;
import p009e.p028d.p030b.p031a.p032i.C0891d;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p035u.C0920e;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;

/* renamed from: e.d.b.a.i.p */
public class C0909p implements C0908o {

    /* renamed from: e */
    private static volatile C0910q f588e;

    /* renamed from: a */
    private final C0968a f589a;

    /* renamed from: b */
    private final C0968a f590b;

    /* renamed from: c */
    private final C0920e f591c;

    /* renamed from: d */
    private final C0647m f592d;

    C0909p(C0968a aVar, C0968a aVar2, C0920e eVar, C0647m mVar, C0651q qVar) {
        this.f589a = aVar;
        this.f590b = aVar2;
        this.f591c = eVar;
        this.f592d = mVar;
        qVar.mo9579a();
    }

    /* renamed from: a */
    public static void m1240a(Context context) {
        if (f588e == null) {
            synchronized (C0909p.class) {
                if (f588e == null) {
                    C0891d.C0893b bVar = new C0891d.C0893b((C0891d.C0892a) null);
                    bVar.mo20332a(context);
                    f588e = bVar.mo20333a();
                }
            }
        }
    }

    /* renamed from: b */
    public static C0909p m1241b() {
        C0910q qVar = f588e;
        if (qVar != null) {
            return qVar.mo20331h();
        }
        throw new IllegalStateException("Not initialized!");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public C0647m mo20350a() {
        return this.f592d;
    }

    /* renamed from: a */
    public C0880g mo20351a(C0894e eVar) {
        Set<T> unmodifiableSet = eVar instanceof C0894e ? Collections.unmodifiableSet(eVar.mo9430a()) : Collections.singleton(C0875b.m1149a("proto"));
        C0903k.C0904a d = C0903k.m1231d();
        d.mo20327a(eVar.getName());
        d.mo20328a(eVar.getExtras());
        return new C0905l(unmodifiableSet, d.mo20329a(), this);
    }

    /* renamed from: a */
    public void mo20352a(C0901j jVar, C0881h hVar) {
        C0920e eVar = this.f591c;
        C0903k d = jVar.mo20310d();
        C0877d c = jVar.mo20308b().mo20277c();
        if (d != null) {
            C0903k.C0904a d2 = C0903k.m1231d();
            d2.mo20327a(d.mo20321a());
            d2.mo20326a(c);
            d2.mo20328a(d.mo20322b());
            C0903k a = d2.mo20329a();
            C0882a.C0884b bVar = new C0882a.C0884b();
            bVar.mo20303a((Map<String, String>) new HashMap());
            bVar.mo20299a(this.f589a.mo20396a());
            bVar.mo20305b(this.f590b.mo20396a());
            bVar.mo20302a(jVar.mo20311e());
            bVar.mo20300a(new C0895f(jVar.mo20307a(), jVar.mo20309c().apply(jVar.mo20308b().mo20276b())));
            bVar.mo20301a(jVar.mo20308b().mo20275a());
            eVar.mo20355a(a, bVar.mo20304a(), hVar);
            return;
        }
        throw null;
    }
}
