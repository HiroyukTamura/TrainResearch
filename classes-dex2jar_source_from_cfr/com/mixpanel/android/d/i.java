/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.d;

import com.mixpanel.android.d.a;

class i {
    public final String a;
    public final Class<?> b;
    public final a c;
    private final String d;

    public i(String string2, Class<?> class_, a a2, String string3) {
        this.a = string2;
        this.b = class_;
        this.c = a2;
        this.d = string3;
    }

    public a a(Object[] arrobject) {
        if (this.d == null) {
            return null;
        }
        return new a(this.b, this.d, arrobject, Void.TYPE);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[PropertyDescription ");
        stringBuilder.append(this.a);
        stringBuilder.append(",");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append(this.c);
        stringBuilder.append("/");
        stringBuilder.append(this.d);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

