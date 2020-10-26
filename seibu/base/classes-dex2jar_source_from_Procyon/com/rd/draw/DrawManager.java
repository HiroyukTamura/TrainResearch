// 
// Decompiled by Procyon v0.5.36
// 

package com.rd.draw;

import com.rd.animation.data.Value;
import android.util.Pair;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.content.Context;
import android.support.annotation.NonNull;
import android.graphics.Canvas;
import com.rd.draw.controller.MeasureController;
import com.rd.draw.data.Indicator;
import com.rd.draw.controller.DrawController;
import com.rd.draw.controller.AttributeController;

public class DrawManager
{
    private AttributeController attributeController;
    private DrawController drawController;
    private Indicator indicator;
    private MeasureController measureController;
    
    public DrawManager() {
        this.indicator = new Indicator();
        this.drawController = new DrawController(this.indicator);
        this.measureController = new MeasureController();
        this.attributeController = new AttributeController(this.indicator);
    }
    
    public void draw(@NonNull final Canvas canvas) {
        this.drawController.draw(canvas);
    }
    
    @NonNull
    public Indicator indicator() {
        if (this.indicator == null) {
            this.indicator = new Indicator();
        }
        return this.indicator;
    }
    
    public void initAttributes(@NonNull final Context context, @Nullable final AttributeSet set) {
        this.attributeController.init(context, set);
    }
    
    public Pair<Integer, Integer> measureViewSize(final int n, final int n2) {
        return this.measureController.measureViewSize(this.indicator, n, n2);
    }
    
    public void updateValue(@Nullable final Value value) {
        this.drawController.updateValue(value);
    }
}
