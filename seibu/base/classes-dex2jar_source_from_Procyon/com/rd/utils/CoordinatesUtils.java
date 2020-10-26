// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.utils;

import android.util.Pair;
import com.rd.animation.type.AnimationType;
import android.support.annotation.NonNull;
import com.rd.draw.data.Orientation;
import android.support.annotation.Nullable;
import com.rd.draw.data.Indicator;

public class CoordinatesUtils
{
    public static int getCoordinate(@Nullable final Indicator indicator, final int n) {
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            return getXCoordinate(indicator, n);
        }
        return getYCoordinate(indicator, n);
    }
    
    private static int getHorizontalCoordinate(@NonNull final Indicator indicator, int n) {
        final int count = indicator.getCount();
        final int radius = indicator.getRadius();
        final int stroke = indicator.getStroke();
        final int padding = indicator.getPadding();
        int n2 = 0;
        for (int i = 0; i < count; ++i) {
            final int n3 = n2 + (stroke / 2 + radius);
            if (n == i) {
                return n3;
            }
            n2 = n3 + (radius + padding + stroke / 2);
        }
        n = n2;
        if (indicator.getAnimationType() == AnimationType.DROP) {
            n = n2 + radius * 2;
        }
        return n;
    }
    
    public static Pair<Integer, Float> getProgress(@NonNull final Indicator indicator, int i, float n, final boolean b) {
        final int count = indicator.getCount();
        final int selectedPosition = indicator.getSelectedPosition();
        int n2 = i;
        if (b) {
            n2 = count - 1 - i;
        }
        if (n2 < 0) {
            i = 0;
        }
        else if ((i = n2) > count - 1) {
            i = count - 1;
        }
        int n3;
        if (i > selectedPosition) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        int n4;
        if (b) {
            if (i - 1 < selectedPosition) {
                n4 = 1;
            }
            else {
                n4 = 0;
            }
        }
        else if (i + 1 < selectedPosition) {
            n4 = 1;
        }
        else {
            n4 = 0;
        }
        int selectedPosition2 = 0;
        Label_0081: {
            if (n3 == 0) {
                selectedPosition2 = selectedPosition;
                if (n4 == 0) {
                    break Label_0081;
                }
            }
            selectedPosition2 = i;
            indicator.setSelectedPosition(selectedPosition2);
        }
        int n5;
        if (selectedPosition2 == i && n != 0.0f) {
            n5 = 1;
        }
        else {
            n5 = 0;
        }
        if (n5 != 0) {
            if (b) {
                --i;
            }
            else {
                ++i;
            }
        }
        else {
            n = 1.0f - n;
        }
        float f;
        if (n > 1.0f) {
            f = 1.0f;
        }
        else {
            f = n;
            if (n < 0.0f) {
                f = 0.0f;
            }
        }
        return (Pair<Integer, Float>)new Pair((Object)i, (Object)f);
    }
    
    private static int getVerticalCoordinate(@NonNull final Indicator indicator) {
        final int radius = indicator.getRadius();
        if (indicator.getAnimationType() == AnimationType.DROP) {
            return radius * 3;
        }
        return radius;
    }
    
    public static int getXCoordinate(@Nullable final Indicator indicator, int n) {
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            n = getHorizontalCoordinate(indicator, n);
        }
        else {
            n = getVerticalCoordinate(indicator);
        }
        return n + indicator.getPaddingLeft();
    }
    
    public static int getYCoordinate(@Nullable final Indicator indicator, int n) {
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            n = getVerticalCoordinate(indicator);
        }
        else {
            n = getHorizontalCoordinate(indicator, n);
        }
        return n + indicator.getPaddingTop();
    }
}
