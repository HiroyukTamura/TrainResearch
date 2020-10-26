// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class CubeInTransformer extends ABaseTransformer
{
    public boolean isPagingEnabled() {
        return true;
    }
    
    @Override
    protected void onTransform(final View view, final float n) {
        float pivotX;
        if (n > 0.0f) {
            pivotX = 0.0f;
        }
        else {
            pivotX = (float)view.getWidth();
        }
        view.setPivotX(pivotX);
        view.setPivotY(0.0f);
        view.setRotationY(-90.0f * n);
    }
}
