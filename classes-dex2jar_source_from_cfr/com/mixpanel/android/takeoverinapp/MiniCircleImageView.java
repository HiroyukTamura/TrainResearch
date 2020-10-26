/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.widget.ImageView
 */
package com.mixpanel.android.takeoverinapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.ImageView;

public class MiniCircleImageView
extends ImageView {
    private Paint a;
    private int b;
    private int c;

    public MiniCircleImageView(Context context) {
        super(context);
        this.a();
    }

    public MiniCircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a();
    }

    public MiniCircleImageView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a() {
        Paint paint;
        int n2;
        this.a = new Paint(1);
        if (Build.VERSION.SDK_INT >= 23) {
            paint = this.a;
            n2 = this.getResources().getColor(17170443, null);
        } else {
            paint = this.a;
            n2 = this.getResources().getColor(17170443);
        }
        paint.setColor(n2);
        this.a.setStyle(Paint.Style.STROKE);
        float f2 = TypedValue.applyDimension((int)1, (float)2.0f, (DisplayMetrics)this.getResources().getDisplayMetrics());
        this.a.setStrokeWidth(f2);
    }

    protected void onSizeChanged(int n2, int n3, int n4, int n5) {
        super.onSizeChanged(n2, n3, n4, n5);
        this.b = n2;
        this.c = n3;
    }
}

