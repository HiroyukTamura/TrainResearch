// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.drawer.type;

import com.rd.animation.data.type.ColorAnimationValue;
import com.rd.animation.data.Value;
import android.graphics.Canvas;
import com.rd.draw.data.Indicator;
import android.support.annotation.NonNull;
import android.graphics.Paint;

public class ColorDrawer extends BaseDrawer
{
    public ColorDrawer(@NonNull final Paint paint, @NonNull final Indicator indicator) {
        super(paint, indicator);
    }
    
    public void draw(@NonNull final Canvas canvas, @NonNull final Value value, final int n, final int n2, final int n3) {
        if (!(value instanceof ColorAnimationValue)) {
            return;
        }
        final ColorAnimationValue colorAnimationValue = (ColorAnimationValue)value;
        final float n4 = (float)this.indicator.getRadius();
        int color = this.indicator.getSelectedColor();
        final int selectedPosition = this.indicator.getSelectedPosition();
        final int selectingPosition = this.indicator.getSelectingPosition();
        final int lastSelectedPosition = this.indicator.getLastSelectedPosition();
        if (this.indicator.isInteractiveAnimation()) {
            if (n == selectingPosition) {
                color = colorAnimationValue.getColor();
            }
            else if (n == selectedPosition) {
                color = colorAnimationValue.getColorReverse();
            }
        }
        else if (n == selectedPosition) {
            color = colorAnimationValue.getColor();
        }
        else if (n == lastSelectedPosition) {
            color = colorAnimationValue.getColorReverse();
        }
        this.paint.setColor(color);
        canvas.drawCircle((float)n2, (float)n3, n4, this.paint);
    }
}
