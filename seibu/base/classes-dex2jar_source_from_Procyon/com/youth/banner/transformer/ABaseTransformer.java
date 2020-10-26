// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.transformer;

import android.view.View;
import android.support.v4.view.ViewPager;

public abstract class ABaseTransformer implements PageTransformer
{
    protected static final float min(final float n, final float n2) {
        if (n < n2) {
            return n2;
        }
        return n;
    }
    
    protected boolean hideOffscreenPages() {
        return true;
    }
    
    protected boolean isPagingEnabled() {
        return false;
    }
    
    protected void onPostTransform(final View view, final float n) {
    }
    
    protected void onPreTransform(final View view, final float n) {
        final float n2 = 0.0f;
        final float n3 = (float)view.getWidth();
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationY(0.0f);
        float translationX;
        if (this.isPagingEnabled()) {
            translationX = 0.0f;
        }
        else {
            translationX = -n3 * n;
        }
        view.setTranslationX(translationX);
        if (this.hideOffscreenPages()) {
            float alpha = n2;
            if (n > -1.0f) {
                if (n >= 1.0f) {
                    alpha = n2;
                }
                else {
                    alpha = 1.0f;
                }
            }
            view.setAlpha(alpha);
            return;
        }
        view.setAlpha(1.0f);
    }
    
    protected abstract void onTransform(final View p0, final float p1);
    
    @Override
    public void transformPage(final View view, final float n) {
        this.onPreTransform(view, n);
        this.onTransform(view, n);
        this.onPostTransform(view, n);
    }
}
