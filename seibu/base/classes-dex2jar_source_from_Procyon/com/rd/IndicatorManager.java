// 
// Decompiled by Procyon v0.5.36
// 

package com.rd;

import com.rd.animation.data.Value;
import com.rd.draw.data.Indicator;
import android.support.annotation.Nullable;
import com.rd.draw.DrawManager;
import com.rd.animation.AnimationManager;
import com.rd.animation.controller.ValueController;

public class IndicatorManager implements UpdateListener
{
    private AnimationManager animationManager;
    private DrawManager drawManager;
    private Listener listener;
    
    IndicatorManager(@Nullable final Listener listener) {
        this.listener = listener;
        this.drawManager = new DrawManager();
        this.animationManager = new AnimationManager(this.drawManager.indicator(), this);
    }
    
    public AnimationManager animate() {
        return this.animationManager;
    }
    
    public DrawManager drawer() {
        return this.drawManager;
    }
    
    public Indicator indicator() {
        return this.drawManager.indicator();
    }
    
    @Override
    public void onValueUpdated(@Nullable final Value value) {
        this.drawManager.updateValue(value);
        if (this.listener != null) {
            this.listener.onIndicatorUpdated();
        }
    }
    
    interface Listener
    {
        void onIndicatorUpdated();
    }
}
