package p009e.p028d.p030b.p031a.p032i;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.C0624j;
import com.google.android.datatransport.runtime.backends.C0627l;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0637g;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0647m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0648n;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0651q;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0652r;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0653s;
import java.util.concurrent.Executor;
import p009e.p028d.p030b.p031a.p032i.C0910q;
import p009e.p028d.p030b.p031a.p032i.p035u.C0918c;
import p009e.p028d.p030b.p031a.p032i.p035u.C0919d;
import p009e.p028d.p030b.p031a.p032i.p035u.C0921f;
import p009e.p028d.p030b.p031a.p032i.p035u.C0922g;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0923A;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0928B;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0935H;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0943e;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0944f;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0945g;
import p009e.p028d.p030b.p031a.p032i.p038w.C0969b;
import p009e.p028d.p030b.p031a.p032i.p038w.C0970c;
import p009e.p028d.p030b.p054b.C1532a;
import p076f.p077b.C1584a;
import p076f.p077b.C1585b;
import p076f.p077b.C1586c;
import p101h.p102a.C1743a;

/* renamed from: e.d.b.a.i.d */
final class C0891d extends C0910q {

    /* renamed from: a */
    private C1743a<Executor> f561a = C1584a.m2212a(C0898h.m1219a());

    /* renamed from: b */
    private C1743a<Context> f562b;

    /* renamed from: c */
    private C1743a f563c;

    /* renamed from: d */
    private C1743a f564d;

    /* renamed from: e */
    private C1743a f565e;

    /* renamed from: f */
    private C1743a<C0923A> f566f;

    /* renamed from: g */
    private C1743a<C0637g> f567g;

    /* renamed from: h */
    private C1743a<C0653s> f568h;

    /* renamed from: i */
    private C1743a<C0918c> f569i;

    /* renamed from: l */
    private C1743a<C0647m> f570l;

    /* renamed from: m */
    private C1743a<C0651q> f571m;

    /* renamed from: n */
    private C1743a<C0909p> f572n;

    /* renamed from: e.d.b.a.i.d$b */
    private static final class C0893b implements C0910q.C0911a {

        /* renamed from: a */
        private Context f573a;

        private C0893b() {
        }

        /* synthetic */ C0893b(C0892a aVar) {
        }

        /* renamed from: a */
        public C0910q.C0911a mo20332a(Context context) {
            if (context != null) {
                this.f573a = context;
                return this;
            }
            throw null;
        }

        /* renamed from: a */
        public C0910q mo20333a() {
            C1532a.m2137a(this.f573a, Context.class);
            return new C0891d(this.f573a, (C0892a) null);
        }
    }

    /* synthetic */ C0891d(Context context, C0892a aVar) {
        C1585b a = C1586c.m2214a(context);
        this.f562b = a;
        C0624j jVar = new C0624j(a, C0969b.m1368a(), C0970c.m1369a());
        this.f563c = jVar;
        this.f564d = C1584a.m2212a(new C0627l(this.f562b, jVar));
        this.f565e = new C0935H(this.f562b, C0943e.m1340a(), C0944f.m1341a());
        this.f566f = C1584a.m2212a(new C0928B(C0969b.m1368a(), C0970c.m1369a(), C0945g.m1342a(), this.f565e));
        C0921f fVar = new C0921f(C0969b.m1368a());
        this.f567g = fVar;
        C0922g gVar = new C0922g(this.f562b, this.f566f, fVar, C0970c.m1369a());
        this.f568h = gVar;
        C1743a<Executor> aVar2 = this.f561a;
        C1743a aVar3 = this.f564d;
        C1743a<C0923A> aVar4 = this.f566f;
        this.f569i = new C0919d(aVar2, aVar3, gVar, aVar4, aVar4);
        C1743a<Context> aVar5 = this.f562b;
        C1743a aVar6 = this.f564d;
        C1743a<C0923A> aVar7 = this.f566f;
        C1743a<C0923A> aVar8 = aVar7;
        this.f570l = new C0648n(aVar5, aVar6, aVar8, this.f568h, this.f561a, aVar7, C0969b.m1368a());
        C1743a<Executor> aVar9 = this.f561a;
        C1743a<C0923A> aVar10 = this.f566f;
        this.f571m = new C0652r(aVar9, aVar10, this.f568h, aVar10);
        this.f572n = C1584a.m2212a(new C0912r(C0969b.m1368a(), C0970c.m1369a(), this.f569i, this.f570l, this.f571m));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0940c mo20330d() {
        return this.f566f.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public C0909p mo20331h() {
        return this.f572n.get();
    }
}
