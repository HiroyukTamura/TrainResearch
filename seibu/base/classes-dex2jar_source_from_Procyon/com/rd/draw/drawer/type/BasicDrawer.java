// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.drawer.type;

import com.rd.animation.type.AnimationType;
import android.graphics.Canvas;
import android.graphics.Paint$Style;
import com.rd.draw.data.Indicator;
import android.support.annotation.NonNull;
import android.graphics.Paint;

public class BasicDrawer extends BaseDrawer
{
    private Paint strokePaint;
    
    public BasicDrawer(@NonNull final Paint paint, @NonNull final Indicator indicator) {
        super(paint, indicator);
        (this.strokePaint = new Paint()).setStyle(Paint$Style.STROKE);
        this.strokePaint.setAntiAlias(true);
        this.strokePaint.setStrokeWidth((float)indicator.getStroke());
    }
    
    public void draw(@NonNull final Canvas canvas, final int n, final boolean b, final int n2, final int n3) {
        final float n4 = (float)this.indicator.getRadius();
        final int stroke = this.indicator.getStroke();
        final float scaleFactor = this.indicator.getScaleFactor();
        final int selectedColor = this.indicator.getSelectedColor();
        int unselectedColor = this.indicator.getUnselectedColor();
        final int selectedPosition = this.indicator.getSelectedPosition();
        final AnimationType animationType = this.indicator.getAnimationType();
        float n5 = n4;
        if (animationType == AnimationType.SCALE) {
            n5 = n4;
            if (!b) {
                n5 = n4 * scaleFactor;
            }
        }
        if (n == selectedPosition) {
            unselectedColor = selectedColor;
        }
        Paint paint;
        if (animationType == AnimationType.FILL && n != selectedPosition) {
            paint = this.strokePaint;
            paint.setStrokeWidth((float)stroke);
        }
        else {
            paint = this.paint;
        }
        paint.setColor(unselectedColor);
        canvas.drawCircle((float)n2, (float)n3, n5, paint);
    }
}
