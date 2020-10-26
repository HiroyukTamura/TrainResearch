/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.a.e;

import com.mixpanel.android.a.e.b;
import com.mixpanel.android.a.e.g;

public class d
extends g
implements b {
    private String a = "*";

    @Override
    public String a() {
        return this.a;
    }

    @Override
    public void a(String string2) {
        if (string2 != null) {
            this.a = string2;
            return;
        }
        throw new IllegalArgumentException("http resource descriptor must not be null");
    }
}

