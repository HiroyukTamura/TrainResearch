package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.material.snackbar.c */
class C1201c {

    /* renamed from: c */
    private static C1201c f1239c;

    /* renamed from: a */
    private final Object f1240a = new Object();

    /* renamed from: b */
    private final Handler f1241b = new Handler(Looper.getMainLooper(), new C1202a());

    /* renamed from: com.google.android.material.snackbar.c$a */
    class C1202a implements Handler.Callback {
        C1202a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            C1201c.this.mo25490a((C1204c) message.obj);
            return true;
        }
    }

    /* renamed from: com.google.android.material.snackbar.c$b */
    interface C1203b {
        /* renamed from: a */
        void mo25493a(int i);
    }

    /* renamed from: com.google.android.material.snackbar.c$c */
    private static class C1204c {

        /* renamed from: a */
        final WeakReference<C1203b> f1243a;
    }

    private C1201c() {
    }

    /* renamed from: a */
    static C1201c m1826a() {
        if (f1239c == null) {
            f1239c = new C1201c();
        }
        return f1239c;
    }

    /* renamed from: a */
    public void mo25489a(C1203b bVar) {
        synchronized (this.f1240a) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo25490a(C1204c cVar) {
        synchronized (this.f1240a) {
            if (cVar == null || cVar == null) {
                C1203b bVar = (C1203b) cVar.f1243a.get();
                if (bVar != null) {
                    this.f1241b.removeCallbacksAndMessages(cVar);
                    bVar.mo25493a(2);
                }
            }
        }
    }

    /* renamed from: b */
    public void mo25491b(C1203b bVar) {
        synchronized (this.f1240a) {
        }
    }
}
