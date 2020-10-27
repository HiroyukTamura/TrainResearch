package org.greenrobot.eventbus.p132s;

import org.greenrobot.eventbus.C2615e;
import org.greenrobot.eventbus.C2626o;
import org.greenrobot.eventbus.ThreadMode;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: org.greenrobot.eventbus.s.a */
public class C2631a implements C2632b {

    /* renamed from: a */
    private final Class f4345a;

    /* renamed from: b */
    private final Class<? extends C2632b> f4346b = null;

    /* renamed from: c */
    private final C2634d[] f4347c;

    public C2631a(Class cls, boolean z, C2634d[] dVarArr) {
        this.f4345a = cls;
        this.f4347c = dVarArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C2626o mo35657a(String str, Class cls, ThreadMode threadMode, int i, boolean z) {
        try {
            return new C2626o(this.f4345a.getDeclaredMethod(str, new Class[]{cls}), cls, threadMode, i, z);
        } catch (NoSuchMethodException e) {
            StringBuilder a = C0681a.m330a("Could not find subscriber method in ");
            a.append(this.f4345a);
            a.append(". Maybe a missing ProGuard rule?");
            throw new C2615e(a.toString(), e);
        }
    }

    /* renamed from: a */
    public synchronized C2626o[] mo35658a() {
        C2626o[] oVarArr;
        int length = this.f4347c.length;
        oVarArr = new C2626o[length];
        for (int i = 0; i < length; i++) {
            C2634d dVar = this.f4347c[i];
            oVarArr[i] = mo35657a(dVar.f4348a, dVar.f4350c, dVar.f4349b, dVar.f4351d, dVar.f4352e);
        }
        return oVarArr;
    }

    /* renamed from: b */
    public C2632b mo35659b() {
        Class<? extends C2632b> cls = this.f4346b;
        if (cls == null) {
            return null;
        }
        try {
            return (C2632b) cls.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: c */
    public Class mo35660c() {
        return this.f4345a;
    }
}
