// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw.controller;

import android.support.annotation.Nullable;
import com.rd.utils.CoordinatesUtils;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.draw.data.Indicator;
import com.rd.draw.drawer.Drawer;

public class DrawController
{
    private Drawer drawer;
    private Indicator indicator;
    private Value value;
    
    public DrawController(@NonNull final Indicator indicator) {
        this.indicator = indicator;
        this.drawer = new Drawer(indicator);
    }
    
    private void drawIndicator(@NonNull final Canvas canvas, final int n, final int n2, final int n3) {
        final boolean b = true;
        final boolean interactiveAnimation = this.indicator.isInteractiveAnimation();
        final int selectedPosition = this.indicator.getSelectedPosition();
        final int selectingPosition = this.indicator.getSelectingPosition();
        final int lastSelectedPosition = this.indicator.getLastSelectedPosition();
        boolean b2;
        if (!interactiveAnimation && (n == selectedPosition || n == lastSelectedPosition)) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        while (true) {
            Label_0126: {
                if (!interactiveAnimation) {
                    break Label_0126;
                }
                boolean b3 = b;
                if (n != selectedPosition) {
                    if (n != selectingPosition) {
                        break Label_0126;
                    }
                    b3 = b;
                }
                final boolean b4 = b2 | b3;
                this.drawer.setup(n, n2, n3);
                if (this.value != null && b4) {
                    this.drawWithAnimation(canvas);
                    return;
                }
                this.drawer.drawBasic(canvas, b4);
                return;
            }
            boolean b3 = false;
            continue;
        }
    }
    
    private void drawWithAnimation(@NonNull final Canvas canvas) {
        switch (this.indicator.getAnimationType()) {
            default: {}
            case NONE: {
                this.drawer.drawBasic(canvas, true);
            }
            case COLOR: {
                this.drawer.drawColor(canvas, this.value);
            }
            case SCALE: {
                this.drawer.drawScale(canvas, this.value);
            }
            case WORM: {
                this.drawer.drawWorm(canvas, this.value);
            }
            case SLIDE: {
                this.drawer.drawSlide(canvas, this.value);
            }
            case FILL: {
                this.drawer.drawFill(canvas, this.value);
            }
            case THIN_WORM: {
                this.drawer.drawThinWorm(canvas, this.value);
            }
            case DROP: {
                this.drawer.drawDrop(canvas, this.value);
            }
            case SWAP: {
                this.drawer.drawSwap(canvas, this.value);
            }
        }
    }
    
    public void draw(@NonNull final Canvas canvas) {
        for (int count = this.indicator.getCount(), i = 0; i < count; ++i) {
            this.drawIndicator(canvas, i, CoordinatesUtils.getXCoordinate(this.indicator, i), CoordinatesUtils.getYCoordinate(this.indicator, i));
        }
    }
    
    public void updateValue(@Nullable final Value value) {
        this.value = value;
    }
}
