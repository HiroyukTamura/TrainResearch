// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;

public class RotateUpTransformer extends ABaseTransformer
{
    private static final float ROT_MOD = -15.0f;
    
    @Override
    protected boolean isPagingEnabled() {
        return true;
    }
    
    @Override
    protected void onTransform(final View view, final float n) {
        view.setPivotX(0.5f * view.getWidth());
        view.setPivotY(0.0f);
        view.setTranslationX(0.0f);
        view.setRotation(-15.0f * n);
    }
}
