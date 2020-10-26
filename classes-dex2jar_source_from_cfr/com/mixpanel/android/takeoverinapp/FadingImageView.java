/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.Xfermode
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.ImageView
 */
package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class FadingImageView
extends ImageView {
    private Matrix a;
    private Paint b;
    private Shader c;
    private Paint d;
    private Shader e;
    private int f;
    private int g;
    private boolean h;

    public FadingImageView(Context context) {
        super(context);
        this.a();
    }

    public FadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a();
    }

    public FadingImageView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a();
    }

    private void a() {
        this.a = new Matrix();
        this.b = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.c = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{-16777216, -16777216, -452984832, 0}, new float[]{0.0f, 0.2f, 0.4f, 1.0f}, tileMode);
        this.b.setShader(this.c);
        this.b.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.d = new Paint();
        tileMode = Shader.TileMode.CLAMP;
        this.e = new LinearGradient(0.0f, 0.0f, 0.0f, 1.0f, new int[]{0, 0, -16777216, -16777216}, new float[]{0.0f, 0.85f, 0.98f, 1.0f}, tileMode);
        this.d.setShader(this.e);
        this.b.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public void a(boolean bl2) {
        this.h = bl2;
    }

    public void draw(Canvas canvas) {
        if (this.h) {
            Rect rect = canvas.getClipBounds();
            int n2 = canvas.saveLayer(0.0f, 0.0f, (float)rect.width(), (float)rect.height(), null, 31);
            super.draw(canvas);
            canvas.drawRect(0.0f, 0.0f, (float)this.g, (float)this.f, this.b);
            canvas.restoreToCount(n2);
            return;
        }
        super.draw(canvas);
    }

    protected void onMeasure(int n2, int n3) {
        super.onMeasure(n2, n3);
        if (this.h) {
            this.f = this.getHeight();
            this.g = this.getWidth();
            n2 = View.MeasureSpec.getSize((int)n3);
            this.a.setScale(1.0f, (float)n2);
            this.c.setLocalMatrix(this.a);
            this.e.setLocalMatrix(this.a);
        }
    }
}

