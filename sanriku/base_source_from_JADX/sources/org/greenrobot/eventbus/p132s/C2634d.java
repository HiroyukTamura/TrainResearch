package org.greenrobot.eventbus.p132s;

import org.greenrobot.eventbus.ThreadMode;

/* renamed from: org.greenrobot.eventbus.s.d */
public class C2634d {

    /* renamed from: a */
    final String f4348a;

    /* renamed from: b */
    final ThreadMode f4349b;

    /* renamed from: c */
    final Class<?> f4350c;

    /* renamed from: d */
    final int f4351d = 0;

    /* renamed from: e */
    final boolean f4352e = false;

    public C2634d(String str, Class<?> cls) {
        ThreadMode threadMode = ThreadMode.POSTING;
        this.f4348a = str;
        this.f4349b = threadMode;
        this.f4350c = cls;
    }

    public C2634d(String str, Class<?> cls, ThreadMode threadMode) {
        this.f4348a = str;
        this.f4349b = threadMode;
        this.f4350c = cls;
    }
}
