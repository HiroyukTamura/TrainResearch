// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.drawer.type;

import com.rd.animation.data.type.FillAnimationValue;
import com.rd.animation.data.Value;
import android.graphics.Canvas;
import android.graphics.Paint$Style;
import com.rd.draw.data.Indicator;
import android.support.annotation.NonNull;
import android.graphics.Paint;

public class FillDrawer extends BaseDrawer
{
    private Paint strokePaint;
    
    public FillDrawer(@NonNull final Paint paint, @NonNull final Indicator indicator) {
        super(paint, indicator);
        (this.strokePaint = new Paint()).setStyle(Paint$Style.STROKE);
        this.strokePaint.setAntiAlias(true);
    }
    
    public void draw(@NonNull final Canvas canvas, @NonNull final Value value, final int n, final int n2, final int n3) {
        if (!(value instanceof FillAnimationValue)) {
            return;
        }
        final FillAnimationValue fillAnimationValue = (FillAnimationValue)value;
        int color = this.indicator.getUnselectedColor();
        float n4 = (float)this.indicator.getRadius();
        int n5 = this.indicator.getStroke();
        final int selectedPosition = this.indicator.getSelectedPosition();
        final int selectingPosition = this.indicator.getSelectingPosition();
        final int lastSelectedPosition = this.indicator.getLastSelectedPosition();
        if (this.indicator.isInteractiveAnimation()) {
            if (n == selectingPosition) {
                color = fillAnimationValue.getColor();
                n4 = (float)fillAnimationValue.getRadius();
                n5 = fillAnimationValue.getStroke();
            }
            else if (n == selectedPosition) {
                color = fillAnimationValue.getColorReverse();
                n4 = (float)fillAnimationValue.getRadiusReverse();
                n5 = fillAnimationValue.getStrokeReverse();
            }
        }
        else if (n == selectedPosition) {
            color = fillAnimationValue.getColor();
            n4 = (float)fillAnimationValue.getRadius();
            n5 = fillAnimationValue.getStroke();
        }
        else if (n == lastSelectedPosition) {
            color = fillAnimationValue.getColorReverse();
            n4 = (float)fillAnimationValue.getRadiusReverse();
            n5 = fillAnimationValue.getStrokeReverse();
        }
        this.strokePaint.setColor(color);
        this.strokePaint.setStrokeWidth((float)this.indicator.getStroke());
        canvas.drawCircle((float)n2, (float)n3, (float)this.indicator.getRadius(), this.strokePaint);
        this.strokePaint.setStrokeWidth((float)n5);
        canvas.drawCircle((float)n2, (float)n3, n4, this.strokePaint);
    }
}
