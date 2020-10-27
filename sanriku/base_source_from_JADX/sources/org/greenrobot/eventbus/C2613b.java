package org.greenrobot.eventbus;

import java.util.logging.Level;

/* renamed from: org.greenrobot.eventbus.b */
final class C2613b implements Runnable, C2624l {

    /* renamed from: a */
    private final C2623k f4293a = new C2623k();

    /* renamed from: b */
    private final C1126c f4294b;

    /* renamed from: c */
    private volatile boolean f4295c;

    C2613b(C1126c cVar) {
        this.f4294b = cVar;
    }

    /* renamed from: a */
    public void mo35639a(C2629q qVar, Object obj) {
        C2622j a = C2622j.m4571a(qVar, obj);
        synchronized (this) {
            this.f4293a.mo35649a(a);
            if (!this.f4295c) {
                this.f4295c = true;
                this.f4294b.mo21902a().execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                C2622j a = this.f4293a.mo35648a(1000);
                if (a == null) {
                    synchronized (this) {
                        a = this.f4293a.mo35647a();
                        if (a == null) {
                            this.f4295c = false;
                            this.f4295c = false;
                            return;
                        }
                    }
                }
                this.f4294b.mo21904a(a);
            } catch (InterruptedException e) {
                try {
                    C2617g b = this.f4294b.mo21906b();
                    Level level = Level.WARNING;
                    b.mo35644a(level, Thread.currentThread().getName() + " was interruppted", e);
                    return;
                } finally {
                    this.f4295c = false;
                }
            }
        }
    }
}
