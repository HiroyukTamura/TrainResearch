package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: org.greenrobot.eventbus.f */
public class C2616f extends Handler implements C2624l {

    /* renamed from: a */
    private final C2623k f4307a = new C2623k();

    /* renamed from: b */
    private final int f4308b;

    /* renamed from: c */
    private final C1126c f4309c;

    /* renamed from: d */
    private boolean f4310d;

    protected C2616f(C1126c cVar, Looper looper, int i) {
        super(looper);
        this.f4309c = cVar;
        this.f4308b = i;
    }

    /* renamed from: a */
    public void mo35639a(C2629q qVar, Object obj) {
        C2622j a = C2622j.m4571a(qVar, obj);
        synchronized (this) {
            this.f4307a.mo35649a(a);
            if (!this.f4310d) {
                this.f4310d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new C2615e("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                C2622j a = this.f4307a.mo35647a();
                if (a == null) {
                    synchronized (this) {
                        a = this.f4307a.mo35647a();
                        if (a == null) {
                            this.f4310d = false;
                            this.f4310d = false;
                            return;
                        }
                    }
                }
                this.f4309c.mo21904a(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f4308b));
            if (sendMessage(obtainMessage())) {
                this.f4310d = true;
                return;
            }
            throw new C2615e("Could not send handler message");
        } catch (Throwable th) {
            this.f4310d = false;
            throw th;
        }
    }
}
