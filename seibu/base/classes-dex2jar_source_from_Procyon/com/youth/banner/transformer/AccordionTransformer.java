// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class AccordionTransformer extends ABaseTransformer
{
    @Override
    protected void onTransform(final View view, float scaleX) {
        float pivotX;
        if (scaleX < 0.0f) {
            pivotX = 0.0f;
        }
        else {
            pivotX = (float)view.getWidth();
        }
        view.setPivotX(pivotX);
        if (scaleX < 0.0f) {
            ++scaleX;
        }
        else {
            scaleX = 1.0f - scaleX;
        }
        view.setScaleX(scaleX);
    }
}
