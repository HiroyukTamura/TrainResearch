// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class ScaleInOutTransformer extends ABaseTransformer
{
    @Override
    protected void onTransform(final View view, float n) {
        float pivotX;
        if (n < 0.0f) {
            pivotX = 0.0f;
        }
        else {
            pivotX = (float)view.getWidth();
        }
        view.setPivotX(pivotX);
        view.setPivotY(view.getHeight() / 2.0f);
        if (n < 0.0f) {
            ++n;
        }
        else {
            n = 1.0f - n;
        }
        view.setScaleX(n);
        view.setScaleY(n);
    }
}
