package p009e.p028d.p030b.p031a.p032i.p035u;

import com.google.android.datatransport.runtime.backends.C0617e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0653s;
import java.util.concurrent.Executor;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;
import p009e.p028d.p030b.p031a.p032i.p037v.C0966b;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: e.d.b.a.i.u.d */
public final class C0919d implements C1585b<C0918c> {

    /* renamed from: a */
    private final C1743a<Executor> f611a;

    /* renamed from: b */
    private final C1743a<C0617e> f612b;

    /* renamed from: c */
    private final C1743a<C0653s> f613c;

    /* renamed from: d */
    private final C1743a<C0940c> f614d;

    /* renamed from: e */
    private final C1743a<C0966b> f615e;

    public C0919d(C1743a<Executor> aVar, C1743a<C0617e> aVar2, C1743a<C0653s> aVar3, C1743a<C0940c> aVar4, C1743a<C0966b> aVar5) {
        this.f611a = aVar;
        this.f612b = aVar2;
        this.f613c = aVar3;
        this.f614d = aVar4;
        this.f615e = aVar5;
    }

    public Object get() {
        return new C0918c(this.f611a.get(), this.f612b.get(), this.f613c.get(), this.f614d.get(), this.f615e.get());
    }
}
