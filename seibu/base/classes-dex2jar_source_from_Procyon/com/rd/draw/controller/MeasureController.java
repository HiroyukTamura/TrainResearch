// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.controller;

import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Orientation;
import android.view.View$MeasureSpec;
import android.util.Pair;
import android.support.annotation.NonNull;
import com.rd.draw.data.Indicator;

public class MeasureController
{
    public Pair<Integer, Integer> measureViewSize(@NonNull final Indicator indicator, int i, int min) {
        final int mode = View$MeasureSpec.getMode(i);
        final int size = View$MeasureSpec.getSize(i);
        final int mode2 = View$MeasureSpec.getMode(min);
        final int size2 = View$MeasureSpec.getSize(min);
        final int count = indicator.getCount();
        i = indicator.getRadius();
        final int stroke = indicator.getStroke();
        final int padding = indicator.getPadding();
        final int paddingLeft = indicator.getPaddingLeft();
        final int paddingTop = indicator.getPaddingTop();
        final int paddingRight = indicator.getPaddingRight();
        final int paddingBottom = indicator.getPaddingBottom();
        final int n = i * 2;
        min = 0;
        i = 0;
        final Orientation orientation = indicator.getOrientation();
        if (count != 0) {
            i = n * count + stroke * 2 * count + padding * (count - 1);
            min = n + stroke;
            if (orientation == Orientation.HORIZONTAL) {
                final int n2 = min;
                min = i;
                i = n2;
            }
        }
        int n3 = i;
        int n4 = min;
        if (indicator.getAnimationType() == AnimationType.DROP) {
            if (orientation == Orientation.HORIZONTAL) {
                n3 = i * 2;
                n4 = min;
            }
            else {
                n4 = min * 2;
                n3 = i;
            }
        }
        i = paddingLeft + paddingRight;
        min = paddingTop + paddingBottom;
        if (orientation == Orientation.HORIZONTAL) {
            i += n4;
            min += n3;
        }
        else {
            i += n4;
            min += n3;
        }
        if (mode == 1073741824) {
            i = size;
        }
        else if (mode == Integer.MIN_VALUE) {
            i = Math.min(i, size);
        }
        if (mode2 == 1073741824) {
            min = size2;
        }
        else if (mode2 == Integer.MIN_VALUE) {
            min = Math.min(min, size2);
        }
        int n5 = i;
        if (i < 0) {
            n5 = 0;
        }
        if ((i = min) < 0) {
            i = 0;
        }
        indicator.setWidth(n5);
        indicator.setHeight(i);
        return (Pair<Integer, Integer>)new Pair((Object)n5, (Object)i);
    }
}
