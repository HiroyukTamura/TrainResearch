/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.a.c;

public class b
extends Exception {
    private int a;

    public b(int n2) {
        this.a = n2;
    }

    public b(int n2, String string2) {
        super(string2);
        this.a = n2;
    }

    public b(int n2, Throwable throwable) {
        super(throwable);
        this.a = n2;
    }

    public int a() {
        return this.a;
    }
}

