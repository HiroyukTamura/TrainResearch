// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class RotateDownTransformer extends ABaseTransformer
{
    private static final float ROT_MOD = -15.0f;
    
    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
    
    @Override
    protected void onTransform(final View view, final float n) {
        final float n2 = (float)view.getWidth();
        final float pivotY = (float)view.getHeight();
        view.setPivotX(0.5f * n2);
        view.setPivotY(pivotY);
        view.setRotation(-15.0f * n * -1.25f);
    }
}
