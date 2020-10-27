package org.greenrobot.eventbus;

import android.os.Looper;

/* renamed from: org.greenrobot.eventbus.h */
public interface C2619h {

    /* renamed from: org.greenrobot.eventbus.h$a */
    public static class C2620a implements C2619h {

        /* renamed from: a */
        private final Looper f4311a;

        public C2620a(Looper looper) {
            this.f4311a = looper;
        }

        /* renamed from: a */
        public C2624l mo35645a(C1126c cVar) {
            return new C2616f(cVar, this.f4311a, 10);
        }

        /* renamed from: a */
        public boolean mo35646a() {
            return this.f4311a == Looper.myLooper();
        }
    }
}
