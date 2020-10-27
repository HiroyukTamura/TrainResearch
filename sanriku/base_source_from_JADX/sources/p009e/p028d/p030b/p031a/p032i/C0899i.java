package p009e.p028d.p030b.p031a.p032i;

import java.util.concurrent.Executor;
import p009e.p028d.p030b.p031a.p032i.p033s.C0913a;

/* renamed from: e.d.b.a.i.i */
class C0899i implements Executor {

    /* renamed from: a */
    private final Executor f577a;

    /* renamed from: e.d.b.a.i.i$a */
    static class C0900a implements Runnable {

        /* renamed from: a */
        private final Runnable f578a;

        C0900a(Runnable runnable) {
            this.f578a = runnable;
        }

        public void run() {
            try {
                this.f578a.run();
            } catch (Exception e) {
                C0913a.m1250a("Executor", "Background execution failure.", (Throwable) e);
            }
        }
    }

    C0899i(Executor executor) {
        this.f577a = executor;
    }

    public void execute(Runnable runnable) {
        this.f577a.execute(new C0900a(runnable));
    }
}
