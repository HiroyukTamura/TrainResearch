// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.drawer.type;

import com.rd.draw.data.Orientation;
import com.rd.animation.data.type.DropAnimationValue;
import com.rd.animation.data.Value;
import android.graphics.Canvas;
import com.rd.draw.data.Indicator;
import android.support.annotation.NonNull;
import android.graphics.Paint;

public class DropDrawer extends BaseDrawer
{
    public DropDrawer(@NonNull final Paint paint, @NonNull final Indicator indicator) {
        super(paint, indicator);
    }
    
    public void draw(@NonNull final Canvas canvas, @NonNull final Value value, final int n, final int n2) {
        if (!(value instanceof DropAnimationValue)) {
            return;
        }
        final DropAnimationValue dropAnimationValue = (DropAnimationValue)value;
        final int unselectedColor = this.indicator.getUnselectedColor();
        final int selectedColor = this.indicator.getSelectedColor();
        final float n3 = (float)this.indicator.getRadius();
        this.paint.setColor(unselectedColor);
        canvas.drawCircle((float)n, (float)n2, n3, this.paint);
        this.paint.setColor(selectedColor);
        if (this.indicator.getOrientation() == Orientation.HORIZONTAL) {
            canvas.drawCircle((float)dropAnimationValue.getWidth(), (float)dropAnimationValue.getHeight(), (float)dropAnimationValue.getRadius(), this.paint);
            return;
        }
        canvas.drawCircle((float)dropAnimationValue.getHeight(), (float)dropAnimationValue.getWidth(), (float)dropAnimationValue.getRadius(), this.paint);
    }
}
