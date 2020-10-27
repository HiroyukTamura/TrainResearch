package kotlinx.coroutines.p130u0;

import kotlin.jvm.JvmField;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

/* renamed from: kotlinx.coroutines.u0.j */
public final class C2602j extends C2600h {
    @JvmField

    /* renamed from: c */
    public final Runnable f4267c;

    public C2602j(Runnable runnable, long j, C2601i iVar) {
        super(j, iVar);
        this.f4267c = runnable;
    }

    public void run() {
        try {
            this.f4267c.run();
        } finally {
            this.f4266b.mo35622d();
        }
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("Task[");
        a.append(C1532a.m2129a((Object) this.f4267c));
        a.append('@');
        a.append(C1532a.m2147b(this.f4267c));
        a.append(", ");
        a.append(this.f4265a);
        a.append(", ");
        a.append(this.f4266b);
        a.append(']');
        return a.toString();
    }
}
