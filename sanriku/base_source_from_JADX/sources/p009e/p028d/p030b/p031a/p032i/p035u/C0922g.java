package p009e.p028d.p030b.p031a.p032i.p035u;

import android.content.Context;
import android.os.Build;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0629a;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0635e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0637g;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.C0653s;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0940c;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;
import p009e.p028d.p030b.p054b.C1532a;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: e.d.b.a.i.u.g */
public final class C0922g implements C1585b<C0653s> {

    /* renamed from: a */
    private final C1743a<Context> f617a;

    /* renamed from: b */
    private final C1743a<C0940c> f618b;

    /* renamed from: c */
    private final C1743a<C0637g> f619c;

    /* renamed from: d */
    private final C1743a<C0968a> f620d;

    public C0922g(C1743a<Context> aVar, C1743a<C0940c> aVar2, C1743a<C0637g> aVar3, C1743a<C0968a> aVar4) {
        this.f617a = aVar;
        this.f618b = aVar2;
        this.f619c = aVar3;
        this.f620d = aVar4;
    }

    public Object get() {
        Context context = this.f617a.get();
        C0940c cVar = this.f618b.get();
        C0637g gVar = this.f619c.get();
        Object eVar = Build.VERSION.SDK_INT >= 21 ? new C0635e(context, cVar, gVar) : new C0629a(context, cVar, this.f620d.get(), gVar);
        C1532a.m2125a(eVar, "Cannot return null from a non-@Nullable @Provides method");
        return eVar;
    }
}
