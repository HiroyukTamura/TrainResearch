// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class CubeOutTransformer extends ABaseTransformer
{
    public boolean isPagingEnabled() {
        return true;
    }
    
    @Override
    protected void onTransform(final View view, final float n) {
        float pivotX = 0.0f;
        if (n < 0.0f) {
            pivotX = (float)view.getWidth();
        }
        view.setPivotX(pivotX);
        view.setPivotY(view.getHeight() * 0.5f);
        view.setRotationY(90.0f * n);
    }
}
