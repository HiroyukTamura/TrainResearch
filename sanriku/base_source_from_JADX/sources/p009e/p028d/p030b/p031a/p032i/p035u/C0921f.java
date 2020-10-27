package p009e.p028d.p030b.p031a.p032i.p035u;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0637g;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p009e.p028d.p030b.p031a.C0877d;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;
import p009e.p028d.p030b.p054b.C1532a;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: e.d.b.a.i.u.f */
public final class C0921f implements C1585b<C0637g> {

    /* renamed from: a */
    private final C1743a<C0968a> f616a;

    public C0921f(C1743a<C0968a> aVar) {
        this.f616a = aVar;
    }

    public Object get() {
        C0637g.C0638a aVar = new C0637g.C0638a();
        C0877d dVar = C0877d.DEFAULT;
        C0637g.C0639b.C0640a d = C0637g.C0639b.m247d();
        d.mo9565a(30000);
        d.mo9568b(86400000);
        aVar.mo9571a(dVar, d.mo9567a());
        C0877d dVar2 = C0877d.HIGHEST;
        C0637g.C0639b.C0640a d2 = C0637g.C0639b.m247d();
        d2.mo9565a(1000);
        d2.mo9568b(86400000);
        aVar.mo9571a(dVar2, d2.mo9567a());
        C0877d dVar3 = C0877d.VERY_LOW;
        C0637g.C0639b.C0640a d3 = C0637g.C0639b.m247d();
        d3.mo9565a(86400000);
        d3.mo9568b(86400000);
        d3.mo9566a((Set<C0637g.C0641c>) Collections.unmodifiableSet(new HashSet(Arrays.asList(new C0637g.C0641c[]{C0637g.C0641c.NETWORK_UNMETERED, C0637g.C0641c.DEVICE_IDLE}))));
        aVar.mo9571a(dVar3, d3.mo9567a());
        aVar.mo9572a(this.f616a.get());
        C0637g a = aVar.mo9573a();
        C1532a.m2125a(a, "Cannot return null from a non-@Nullable @Provides method");
        return a;
    }
}
