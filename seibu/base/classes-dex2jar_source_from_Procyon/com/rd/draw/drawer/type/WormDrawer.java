// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.drawer.type;

import com.rd.draw.data.Orientation;
import com.rd.animation.data.type.WormAnimationValue;
import com.rd.animation.data.Value;
import android.graphics.Canvas;
import com.rd.draw.data.Indicator;
import android.support.annotation.NonNull;
import android.graphics.Paint;
import android.graphics.RectF;

public class WormDrawer extends BaseDrawer
{
    public RectF rect;
    
    public WormDrawer(@NonNull final Paint paint, @NonNull final Indicator indicator) {
        super(paint, indicator);
        this.rect = new RectF();
    }
    
    public void draw(@NonNull final Canvas canvas, @NonNull final Value value, final int n, final int n2) {
        if (!(value instanceof WormAnimationValue)) {
            return;
        }
        final WormAnimationValue wormAnimationValue = (WormAnimationValue)value;
        final int rectStart = wormAnimationValue.getRectStart();
        final int rectEnd = wormAnimationValue.getRectEnd();
        final int radius = this.indicator.getRadius();
        final int unselectedColor = this.indicator.getUnselectedColor();
        final int selectedColor = this.indicator.getSelectedColor();
        if (this.indicator.getOrientation() == Orientation.HORIZONTAL) {
            this.rect.left = (float)rectStart;
            this.rect.right = (float)rectEnd;
            this.rect.top = (float)(n2 - radius);
            this.rect.bottom = (float)(n2 + radius);
        }
        else {
            this.rect.left = (float)(n - radius);
            this.rect.right = (float)(n + radius);
            this.rect.top = (float)rectStart;
            this.rect.bottom = (float)rectEnd;
        }
        this.paint.setColor(unselectedColor);
        canvas.drawCircle((float)n, (float)n2, (float)radius, this.paint);
        this.paint.setColor(selectedColor);
        canvas.drawRoundRect(this.rect, (float)radius, (float)radius, this.paint);
    }
}
