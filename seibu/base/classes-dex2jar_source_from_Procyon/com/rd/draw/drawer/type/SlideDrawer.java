// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.drawer.type;

import com.rd.draw.data.Orientation;
import com.rd.animation.data.type.SlideAnimationValue;
import com.rd.animation.data.Value;
import android.graphics.Canvas;
import com.rd.draw.data.Indicator;
import android.support.annotation.NonNull;
import android.graphics.Paint;

public class SlideDrawer extends BaseDrawer
{
    public SlideDrawer(@NonNull final Paint paint, @NonNull final Indicator indicator) {
        super(paint, indicator);
    }
    
    public void draw(@NonNull final Canvas canvas, @NonNull final Value value, final int n, final int n2) {
        if (!(value instanceof SlideAnimationValue)) {
            return;
        }
        final int coordinate = ((SlideAnimationValue)value).getCoordinate();
        final int unselectedColor = this.indicator.getUnselectedColor();
        final int selectedColor = this.indicator.getSelectedColor();
        final int radius = this.indicator.getRadius();
        this.paint.setColor(unselectedColor);
        canvas.drawCircle((float)n, (float)n2, (float)radius, this.paint);
        this.paint.setColor(selectedColor);
        if (this.indicator.getOrientation() == Orientation.HORIZONTAL) {
            canvas.drawCircle((float)coordinate, (float)n2, (float)radius, this.paint);
            return;
        }
        canvas.drawCircle((float)n, (float)coordinate, (float)radius, this.paint);
    }
}
