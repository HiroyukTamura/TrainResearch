package p009e.p028d.p030b.p031a.p032i;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import p009e.p028d.p030b.p054b.C1532a;
import p076f.p077b.C1585b;

/* renamed from: e.d.b.a.i.h */
public final class C0898h implements C1585b<Executor> {

    /* renamed from: a */
    private static final C0898h f576a = new C0898h();

    /* renamed from: a */
    public static C0898h m1219a() {
        return f576a;
    }

    public Object get() {
        C0899i iVar = new C0899i(Executors.newSingleThreadExecutor());
        C1532a.m2125a(iVar, "Cannot return null from a non-@Nullable @Provides method");
        return iVar;
    }
}
