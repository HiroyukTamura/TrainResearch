/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 *  android.widget.FrameLayout
 */
package com.google.android.material.d;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.google.android.material.d.c;
import com.google.android.material.d.d;

public class b
extends FrameLayout
implements d {
    private final c a;

    @Override
    public void a() {
        this.a.a();
    }

    @Override
    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override
    public void b() {
        this.a.b();
    }

    @Override
    public boolean c() {
        return super.isOpaque();
    }

    @SuppressLint(value={"MissingSuperCall"})
    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.a(canvas);
            return;
        }
        super.draw(canvas);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.a.e();
    }

    @Override
    public int getCircularRevealScrimColor() {
        return this.a.d();
    }

    @Override
    public d.d getRevealInfo() {
        return this.a.c();
    }

    public boolean isOpaque() {
        if (this.a != null) {
            return this.a.f();
        }
        return super.isOpaque();
    }

    @Override
    public void setCircularRevealOverlayDrawable(Drawable drawable2) {
        this.a.a(drawable2);
    }

    @Override
    public void setCircularRevealScrimColor(int n2) {
        this.a.a(n2);
    }

    @Override
    public void setRevealInfo(d.d d2) {
        this.a.a(d2);
    }
}

