/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.widget.SeekBar
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.a;
import androidx.appcompat.widget.r;

public class q
extends SeekBar {
    private final r a = new r(this);

    public q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.seekBarStyle);
    }

    public q(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.a.a(attributeSet, n2);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.a.c();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.a.b();
    }

    protected void onDraw(Canvas canvas) {
        synchronized (this) {
            super.onDraw(canvas);
            this.a.a(canvas);
            return;
        }
    }
}

