// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.drawer.type;

import com.rd.draw.data.Orientation;
import com.rd.animation.data.type.ThinWormAnimationValue;
import com.rd.animation.data.Value;
import android.graphics.Canvas;
import com.rd.draw.data.Indicator;
import android.support.annotation.NonNull;
import android.graphics.Paint;

public class ThinWormDrawer extends WormDrawer
{
    public ThinWormDrawer(@NonNull final Paint paint, @NonNull final Indicator indicator) {
        super(paint, indicator);
    }
    
    @Override
    public void draw(@NonNull final Canvas canvas, @NonNull final Value value, final int n, final int n2) {
        if (!(value instanceof ThinWormAnimationValue)) {
            return;
        }
        final ThinWormAnimationValue thinWormAnimationValue = (ThinWormAnimationValue)value;
        final int rectStart = thinWormAnimationValue.getRectStart();
        final int rectEnd = thinWormAnimationValue.getRectEnd();
        final int n3 = thinWormAnimationValue.getHeight() / 2;
        final int radius = this.indicator.getRadius();
        final int unselectedColor = this.indicator.getUnselectedColor();
        final int selectedColor = this.indicator.getSelectedColor();
        if (this.indicator.getOrientation() == Orientation.HORIZONTAL) {
            this.rect.left = (float)rectStart;
            this.rect.right = (float)rectEnd;
            this.rect.top = (float)(n2 - n3);
            this.rect.bottom = (float)(n2 + n3);
        }
        else {
            this.rect.left = (float)(n - n3);
            this.rect.right = (float)(n + n3);
            this.rect.top = (float)rectStart;
            this.rect.bottom = (float)rectEnd;
        }
        this.paint.setColor(unselectedColor);
        canvas.drawCircle((float)n, (float)n2, (float)radius, this.paint);
        this.paint.setColor(selectedColor);
        canvas.drawRoundRect(this.rect, (float)radius, (float)radius, this.paint);
    }
}
