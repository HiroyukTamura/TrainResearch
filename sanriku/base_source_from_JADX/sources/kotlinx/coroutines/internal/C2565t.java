package kotlinx.coroutines.internal;

/* renamed from: kotlinx.coroutines.internal.t */
final /* synthetic */ class C2565t {

    /* renamed from: a */
    private static final int f4206a = Runtime.getRuntime().availableProcessors();

    /* renamed from: a */
    public static final int m4470a() {
        return f4206a;
    }

    /* renamed from: a */
    public static final String m4471a(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
