package kotlinx.coroutines.p130u0;

import kotlinx.coroutines.C1120x;
import kotlinx.coroutines.internal.C2564s;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: kotlinx.coroutines.u0.b */
public final class C2594b extends C2595c {

    /* renamed from: f */
    private static final C1120x f4251f;

    /* renamed from: g */
    public static final C2594b f4252g;

    static {
        C2594b bVar = new C2594b();
        f4252g = bVar;
        int a = C2564s.m4465a("kotlinx.coroutines.io.parallelism", RangesKt___RangesKt.coerceAtLeast(64, C2564s.m4464a()), 0, 0, 12, (Object) null);
        if (a > 0) {
            f4251f = new C2597e(bVar, a, 1);
            return;
        }
        throw new IllegalArgumentException(C0681a.m316a("Expected positive parallelism level, but have ", a).toString());
    }

    private C2594b() {
        super(0, 0, (String) null, 7);
    }

    public void close() {
        throw new UnsupportedOperationException("DefaultDispatcher cannot be closed");
    }

    /* renamed from: o */
    public final C1120x mo35619o() {
        return f4251f;
    }

    public String toString() {
        return "DefaultDispatcher";
    }
}
