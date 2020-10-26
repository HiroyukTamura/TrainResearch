/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.a;

import com.mixpanel.android.a.b.a;
import com.mixpanel.android.a.d;
import com.mixpanel.android.a.d.d;
import com.mixpanel.android.a.e.e;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.a.e.i;
import java.net.InetSocketAddress;

public abstract class b
implements d {
    @Override
    public i a(com.mixpanel.android.a.a a2, a a3, com.mixpanel.android.a.e.a a4) {
        return new e();
    }

    @Override
    public String a(com.mixpanel.android.a.a object) {
        if ((object = object.a()) != null) {
            StringBuffer stringBuffer = new StringBuffer(90);
            stringBuffer.append("<cross-domain-policy><allow-access-from domain=\"*\" to-ports=\"");
            stringBuffer.append(((InetSocketAddress)object).getPort());
            stringBuffer.append("\" /></cross-domain-policy>\u0000");
            return stringBuffer.toString();
        }
        throw new com.mixpanel.android.a.c.d("socket not bound");
    }

    @Override
    public void a(com.mixpanel.android.a.a a2, com.mixpanel.android.a.d.d d2) {
    }

    @Override
    public void a(com.mixpanel.android.a.a a2, com.mixpanel.android.a.e.a a3) {
    }

    @Override
    public void a(com.mixpanel.android.a.a a2, com.mixpanel.android.a.e.a a3, h h2) {
    }

    @Override
    public void b(com.mixpanel.android.a.a a2, com.mixpanel.android.a.d.d d2) {
        d2 = new com.mixpanel.android.a.d.e(d2);
        ((com.mixpanel.android.a.d.e)d2).a(d.a.e);
        a2.a(d2);
    }

    @Override
    public void c(com.mixpanel.android.a.a a2, com.mixpanel.android.a.d.d d2) {
    }
}

