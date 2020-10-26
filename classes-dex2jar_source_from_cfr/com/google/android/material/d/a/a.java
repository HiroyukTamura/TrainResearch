/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 */
package com.google.android.material.d.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.material.d.c;
import com.google.android.material.d.d;

public class a
extends androidx.b.a.a
implements d {
    private final c d;

    @Override
    public void a() {
        this.d.a();
    }

    @Override
    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    public void b() {
        this.d.b();
    }

    @Override
    public boolean c() {
        return super.isOpaque();
    }

    public void draw(Canvas canvas) {
        if (this.d != null) {
            this.d.a(canvas);
            return;
        }
        super.draw(canvas);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.d.e();
    }

    @Override
    public int getCircularRevealScrimColor() {
        return this.d.d();
    }

    @Override
    public d.d getRevealInfo() {
        return this.d.c();
    }

    public boolean isOpaque() {
        if (this.d != null) {
            return this.d.f();
        }
        return super.isOpaque();
    }

    @Override
    public void setCircularRevealOverlayDrawable(Drawable drawable2) {
        this.d.a(drawable2);
    }

    @Override
    public void setCircularRevealScrimColor(int n2) {
        this.d.a(n2);
    }

    @Override
    public void setRevealInfo(d.d d2) {
        this.d.a(d2);
    }
}

