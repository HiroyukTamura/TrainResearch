package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.database.Cursor;
import java.util.List;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0923A;

/* renamed from: e.d.b.a.i.u.h.m */
final /* synthetic */ class C0951m implements C0923A.C0925b {

    /* renamed from: a */
    private final C0923A f670a;

    /* renamed from: b */
    private final List f671b;

    /* renamed from: c */
    private final C0903k f672c;

    private C0951m(C0923A a, List list, C0903k kVar) {
        this.f670a = a;
        this.f671b = list;
        this.f672c = kVar;
    }

    /* renamed from: a */
    public static C0923A.C0925b m1350a(C0923A a, List list, C0903k kVar) {
        return new C0951m(a, list, kVar);
    }

    public Object apply(Object obj) {
        C0923A.m1269a(this.f670a, this.f671b, this.f672c, (Cursor) obj);
        return null;
    }
}
