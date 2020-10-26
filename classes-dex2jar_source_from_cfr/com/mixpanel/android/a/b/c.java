/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.a.b;

import com.mixpanel.android.a.b.a;
import com.mixpanel.android.a.b.b;

public class c
extends b {
    @Override
    public a.b a(com.mixpanel.android.a.e.a a2) {
        if (c.b(a2) == 13) {
            return a.b.a;
        }
        return a.b.b;
    }

    @Override
    public com.mixpanel.android.a.e.b a(com.mixpanel.android.a.e.b b2) {
        super.a(b2);
        b2.a("Sec-WebSocket-Version", "13");
        return b2;
    }

    @Override
    public a c() {
        return new c();
    }
}

