package kotlinx.coroutines;

/* renamed from: kotlinx.coroutines.q0 */
public final class C2582q0 {

    /* renamed from: a */
    private static final ThreadLocal<C2504N> f4220a = new ThreadLocal<>();

    /* renamed from: b */
    public static final C2582q0 f4221b = null;

    /* renamed from: a */
    public static final C2504N m4503a() {
        C2504N n = f4220a.get();
        if (n != null) {
            return n;
        }
        C2525c cVar = new C2525c(Thread.currentThread());
        f4220a.set(cVar);
        return cVar;
    }

    /* renamed from: a */
    public static final void m4504a(C2504N n) {
        f4220a.set(n);
    }

    /* renamed from: b */
    public static final void m4505b() {
        f4220a.set((Object) null);
    }
}
