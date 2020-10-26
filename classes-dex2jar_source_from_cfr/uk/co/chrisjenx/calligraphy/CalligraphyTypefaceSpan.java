/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Paint
 *  android.graphics.Typeface
 *  android.text.TextPaint
 *  android.text.style.MetricAffectingSpan
 */
package uk.co.chrisjenx.calligraphy;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class CalligraphyTypefaceSpan
extends MetricAffectingSpan {
    private final Typeface typeface;

    public CalligraphyTypefaceSpan(Typeface typeface) {
        if (typeface != null) {
            this.typeface = typeface;
            return;
        }
        throw new IllegalArgumentException("typeface is null");
    }

    private void apply(Paint paint) {
        Typeface typeface = paint.getTypeface();
        int n2 = typeface != null ? typeface.getStyle() : 0;
        if (((n2 &= this.typeface.getStyle()) & 1) != 0) {
            paint.setFakeBoldText(true);
        }
        if ((n2 & 2) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        paint.setTypeface(this.typeface);
    }

    public void updateDrawState(TextPaint textPaint) {
        this.apply((Paint)textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        this.apply((Paint)textPaint);
    }
}

