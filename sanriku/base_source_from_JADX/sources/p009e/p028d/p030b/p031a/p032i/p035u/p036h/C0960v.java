package p009e.p028d.p030b.p031a.p032i.p035u.p036h;

import android.database.sqlite.SQLiteDatabase;
import p009e.p028d.p030b.p031a.p032i.C0896g;
import p009e.p028d.p030b.p031a.p032i.C0903k;
import p009e.p028d.p030b.p031a.p032i.p035u.p036h.C0923A;

/* renamed from: e.d.b.a.i.u.h.v */
final /* synthetic */ class C0960v implements C0923A.C0925b {

    /* renamed from: a */
    private final C0923A f681a;

    /* renamed from: b */
    private final C0903k f682b;

    /* renamed from: c */
    private final C0896g f683c;

    private C0960v(C0923A a, C0903k kVar, C0896g gVar) {
        this.f681a = a;
        this.f682b = kVar;
        this.f683c = gVar;
    }

    /* renamed from: a */
    public static C0923A.C0925b m1361a(C0923A a, C0903k kVar, C0896g gVar) {
        return new C0960v(a, kVar, gVar);
    }

    public Object apply(Object obj) {
        return C0923A.m1263a(this.f681a, this.f682b, this.f683c, (SQLiteDatabase) obj);
    }
}
