// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.drawer.type;

import com.rd.draw.data.Orientation;
import com.rd.animation.data.type.SwapAnimationValue;
import com.rd.animation.data.Value;
import android.graphics.Canvas;
import com.rd.draw.data.Indicator;
import android.support.annotation.NonNull;
import android.graphics.Paint;

public class SwapDrawer extends BaseDrawer
{
    public SwapDrawer(@NonNull final Paint paint, @NonNull final Indicator indicator) {
        super(paint, indicator);
    }
    
    public void draw(@NonNull final Canvas canvas, @NonNull final Value value, final int n, final int n2, final int n3) {
        if (!(value instanceof SwapAnimationValue)) {
            return;
        }
        final SwapAnimationValue swapAnimationValue = (SwapAnimationValue)value;
        int selectedColor = this.indicator.getSelectedColor();
        final int unselectedColor = this.indicator.getUnselectedColor();
        final int radius = this.indicator.getRadius();
        final int selectedPosition = this.indicator.getSelectedPosition();
        final int selectingPosition = this.indicator.getSelectingPosition();
        final int lastSelectedPosition = this.indicator.getLastSelectedPosition();
        final int coordinate = swapAnimationValue.getCoordinate();
        final int n4 = unselectedColor;
        int n5;
        if (this.indicator.isInteractiveAnimation()) {
            if (n == selectingPosition) {
                n5 = swapAnimationValue.getCoordinate();
            }
            else {
                selectedColor = n4;
                n5 = coordinate;
                if (n == selectedPosition) {
                    n5 = swapAnimationValue.getCoordinateReverse();
                    selectedColor = unselectedColor;
                }
            }
        }
        else if (n == lastSelectedPosition) {
            n5 = swapAnimationValue.getCoordinate();
        }
        else {
            selectedColor = n4;
            n5 = coordinate;
            if (n == selectedPosition) {
                n5 = swapAnimationValue.getCoordinateReverse();
                selectedColor = unselectedColor;
            }
        }
        this.paint.setColor(selectedColor);
        if (this.indicator.getOrientation() == Orientation.HORIZONTAL) {
            canvas.drawCircle((float)n5, (float)n3, (float)radius, this.paint);
            return;
        }
        canvas.drawCircle((float)n2, (float)n5, (float)radius, this.paint);
    }
}
