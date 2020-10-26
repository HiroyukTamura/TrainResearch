/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.widget.ImageButton
 */
package com.google.android.material.internal;

import android.widget.ImageButton;

public class h
extends ImageButton {
    private int a;

    public final void a(int n2, boolean bl2) {
        super.setVisibility(n2);
        if (bl2) {
            this.a = n2;
        }
    }

    public final int getUserSetVisibility() {
        return this.a;
    }

    public void setVisibility(int n2) {
        this.a(n2, true);
    }
}

