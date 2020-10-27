package kotlinx.coroutines;

/* renamed from: kotlinx.coroutines.d0 */
public class C2528d0 extends C1113f0 implements C2577o {

    /* renamed from: b */
    private final boolean f4143b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2528d0(C1111a0 a0Var) {
        super(true);
        C1113f0 f0Var;
        boolean z = true;
        mo21839a(a0Var);
        C1117j d = mo21849d();
        C2570k kVar = (C2570k) (!(d instanceof C2570k) ? null : d);
        if (kVar != null && (f0Var = (C1113f0) kVar.f4144d) != null) {
            while (true) {
                if (!f0Var.mo21843b()) {
                    C1117j d2 = f0Var.mo21849d();
                    C2570k kVar2 = (C2570k) (!(d2 instanceof C2570k) ? null : d2);
                    if (kVar2 != null) {
                        f0Var = (C1113f0) kVar2.f4144d;
                        if (f0Var == null) {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = false;
        this.f4143b = z;
    }

    /* renamed from: b */
    public boolean mo21843b() {
        return this.f4143b;
    }

    /* renamed from: c */
    public boolean mo21848c() {
        return true;
    }
}
