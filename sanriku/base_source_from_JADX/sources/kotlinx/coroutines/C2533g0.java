package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.C2563r;

/* renamed from: kotlinx.coroutines.g0 */
public final class C2533g0 {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C2563r f4149a = new C2563r("COMPLETING_ALREADY");
    @JvmField

    /* renamed from: b */
    public static final C2563r f4150b = new C2563r("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final C2563r f4151c = new C2563r("COMPLETING_RETRY");
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final C2563r f4152d = new C2563r("TOO_LATE_TO_CANCEL");
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final C2563r f4153e = new C2563r("SEALED");
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final C2503M f4154f = new C2503M(false);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final C2503M f4155g = new C2503M(true);

    /* renamed from: a */
    public static final Object m4404a(Object obj) {
        return obj instanceof C2514V ? new C2515W((C2514V) obj) : obj;
    }

    /* renamed from: b */
    public static final Object m4406b(Object obj) {
        C2514V v;
        C2515W w = (C2515W) (!(obj instanceof C2515W) ? null : obj);
        return (w == null || (v = w.f4129a) == null) ? obj : v;
    }
}
