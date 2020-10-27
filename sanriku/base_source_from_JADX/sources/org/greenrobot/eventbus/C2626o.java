package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* renamed from: org.greenrobot.eventbus.o */
public class C2626o {

    /* renamed from: a */
    final Method f4322a;

    /* renamed from: b */
    final ThreadMode f4323b;

    /* renamed from: c */
    final Class<?> f4324c;

    /* renamed from: d */
    final int f4325d;

    /* renamed from: e */
    final boolean f4326e;

    /* renamed from: f */
    String f4327f;

    public C2626o(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f4322a = method;
        this.f4323b = threadMode;
        this.f4324c = cls;
        this.f4325d = i;
        this.f4326e = z;
    }

    /* renamed from: a */
    private synchronized void m4577a() {
        if (this.f4327f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f4322a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f4322a.getName());
            sb.append('(');
            sb.append(this.f4324c.getName());
            this.f4327f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2626o)) {
            return false;
        }
        m4577a();
        C2626o oVar = (C2626o) obj;
        oVar.m4577a();
        return this.f4327f.equals(oVar.f4327f);
    }

    public int hashCode() {
        return this.f4322a.hashCode();
    }
}
