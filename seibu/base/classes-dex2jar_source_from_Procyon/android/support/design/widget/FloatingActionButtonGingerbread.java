// 
// Decompiled by Procyon v0.5.36
// 

package android.support.design.widget;

import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.graphics.PorterDuff$Mode;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.support.design.R;
import android.support.annotation.Nullable;
import android.graphics.Rect;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;

class FloatingActionButtonGingerbread extends FloatingActionButtonImpl
{
    ShadowDrawableWrapper mShadowDrawable;
    private final StateListAnimator mStateListAnimator;
    
    FloatingActionButtonGingerbread(final VisibilityAwareImageButton visibilityAwareImageButton, final ShadowViewDelegate shadowViewDelegate, final ValueAnimatorCompat.Creator creator) {
        super(visibilityAwareImageButton, shadowViewDelegate, creator);
        (this.mStateListAnimator = new StateListAnimator()).addState(FloatingActionButtonGingerbread.PRESSED_ENABLED_STATE_SET, this.createAnimator((ShadowAnimatorImpl)new ElevateToTranslationZAnimation()));
        this.mStateListAnimator.addState(FloatingActionButtonGingerbread.FOCUSED_ENABLED_STATE_SET, this.createAnimator((ShadowAnimatorImpl)new ElevateToTranslationZAnimation()));
        this.mStateListAnimator.addState(FloatingActionButtonGingerbread.ENABLED_STATE_SET, this.createAnimator((ShadowAnimatorImpl)new ResetElevationAnimation()));
        this.mStateListAnimator.addState(FloatingActionButtonGingerbread.EMPTY_STATE_SET, this.createAnimator((ShadowAnimatorImpl)new DisabledElevationAnimation()));
    }
    
    private ValueAnimatorCompat createAnimator(@NonNull final ShadowAnimatorImpl shadowAnimatorImpl) {
        final ValueAnimatorCompat animator = this.mAnimatorCreator.createAnimator();
        animator.setInterpolator(FloatingActionButtonGingerbread.ANIM_INTERPOLATOR);
        animator.setDuration(100L);
        animator.addListener((ValueAnimatorCompat.AnimatorListener)shadowAnimatorImpl);
        animator.addUpdateListener((ValueAnimatorCompat.AnimatorUpdateListener)shadowAnimatorImpl);
        animator.setFloatValues(0.0f, 1.0f);
        return animator;
    }
    
    private static ColorStateList createColorStateList(int n) {
        final int[][] array = new int[3][];
        final int[] array2 = new int[3];
        array[0] = FloatingActionButtonGingerbread.FOCUSED_ENABLED_STATE_SET;
        array2[0] = n;
        final int n2 = 0 + 1;
        array[n2] = FloatingActionButtonGingerbread.PRESSED_ENABLED_STATE_SET;
        array2[n2] = n;
        n = n2 + 1;
        array[n] = new int[0];
        array2[n] = 0;
        return new ColorStateList(array, array2);
    }
    
    @Override
    float getElevation() {
        return this.mElevation;
    }
    
    @Override
    void getPadding(final Rect rect) {
        this.mShadowDrawable.getPadding(rect);
    }
    
    @Override
    void hide(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean b) {
        if (this.isOrWillBeHidden()) {
            return;
        }
        this.mAnimState = 1;
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mView.getContext(), R.anim.design_fab_out);
        loadAnimation.setInterpolator(android.support.design.widget.AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        loadAnimation.setDuration(200L);
        loadAnimation.setAnimationListener((Animation$AnimationListener)new android.support.design.widget.AnimationUtils.AnimationListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animation animation) {
                FloatingActionButtonGingerbread.this.mAnimState = 0;
                final VisibilityAwareImageButton mView = FloatingActionButtonGingerbread.this.mView;
                int n;
                if (b) {
                    n = 8;
                }
                else {
                    n = 4;
                }
                mView.internalSetVisibility(n, b);
                if (internalVisibilityChangedListener != null) {
                    internalVisibilityChangedListener.onHidden();
                }
            }
        });
        this.mView.startAnimation(loadAnimation);
    }
    
    @Override
    void jumpDrawableToCurrentState() {
        this.mStateListAnimator.jumpToCurrentState();
    }
    
    @Override
    void onCompatShadowChanged() {
    }
    
    @Override
    void onDrawableStateChanged(final int[] state) {
        this.mStateListAnimator.setState(state);
    }
    
    @Override
    void onElevationsChanged(final float n, final float n2) {
        if (this.mShadowDrawable != null) {
            this.mShadowDrawable.setShadowSize(n, this.mPressedTranslationZ + n);
            this.updatePadding();
        }
    }
    
    @Override
    void setBackgroundDrawable(final ColorStateList list, final PorterDuff$Mode porterDuff$Mode, final int n, final int n2) {
        DrawableCompat.setTintList(this.mShapeDrawable = DrawableCompat.wrap((Drawable)this.createShapeDrawable()), list);
        if (porterDuff$Mode != null) {
            DrawableCompat.setTintMode(this.mShapeDrawable, porterDuff$Mode);
        }
        DrawableCompat.setTintList(this.mRippleDrawable = DrawableCompat.wrap((Drawable)this.createShapeDrawable()), createColorStateList(n));
        Drawable[] array;
        if (n2 > 0) {
            this.mBorderDrawable = this.createBorderDrawable(n2, list);
            array = new Drawable[] { this.mBorderDrawable, this.mShapeDrawable, this.mRippleDrawable };
        }
        else {
            this.mBorderDrawable = null;
            array = new Drawable[] { this.mShapeDrawable, this.mRippleDrawable };
        }
        this.mContentBackground = (Drawable)new LayerDrawable(array);
        (this.mShadowDrawable = new ShadowDrawableWrapper(this.mView.getContext(), this.mContentBackground, this.mShadowViewDelegate.getRadius(), this.mElevation, this.mElevation + this.mPressedTranslationZ)).setAddPaddingForCorners(false);
        this.mShadowViewDelegate.setBackgroundDrawable(this.mShadowDrawable);
    }
    
    @Override
    void setBackgroundTintList(final ColorStateList borderTint) {
        if (this.mShapeDrawable != null) {
            DrawableCompat.setTintList(this.mShapeDrawable, borderTint);
        }
        if (this.mBorderDrawable != null) {
            this.mBorderDrawable.setBorderTint(borderTint);
        }
    }
    
    @Override
    void setBackgroundTintMode(final PorterDuff$Mode porterDuff$Mode) {
        if (this.mShapeDrawable != null) {
            DrawableCompat.setTintMode(this.mShapeDrawable, porterDuff$Mode);
        }
    }
    
    @Override
    void setRippleColor(final int n) {
        if (this.mRippleDrawable != null) {
            DrawableCompat.setTintList(this.mRippleDrawable, createColorStateList(n));
        }
    }
    
    @Override
    void show(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean b) {
        if (this.isOrWillBeShown()) {
            return;
        }
        this.mAnimState = 2;
        this.mView.internalSetVisibility(0, b);
        final Animation loadAnimation = AnimationUtils.loadAnimation(this.mView.getContext(), R.anim.design_fab_in);
        loadAnimation.setDuration(200L);
        loadAnimation.setInterpolator(android.support.design.widget.AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        loadAnimation.setAnimationListener((Animation$AnimationListener)new android.support.design.widget.AnimationUtils.AnimationListenerAdapter() {
            @Override
            public void onAnimationEnd(final Animation animation) {
                FloatingActionButtonGingerbread.this.mAnimState = 0;
                if (internalVisibilityChangedListener != null) {
                    internalVisibilityChangedListener.onShown();
                }
            }
        });
        this.mView.startAnimation(loadAnimation);
    }
    
    private class DisabledElevationAnimation extends ShadowAnimatorImpl
    {
        DisabledElevationAnimation() {
        }
        
        @Override
        protected float getTargetShadowSize() {
            return 0.0f;
        }
    }
    
    private class ElevateToTranslationZAnimation extends ShadowAnimatorImpl
    {
        ElevateToTranslationZAnimation() {
        }
        
        @Override
        protected float getTargetShadowSize() {
            return FloatingActionButtonGingerbread.this.mElevation + FloatingActionButtonGingerbread.this.mPressedTranslationZ;
        }
    }
    
    private class ResetElevationAnimation extends ShadowAnimatorImpl
    {
        ResetElevationAnimation() {
        }
        
        @Override
        protected float getTargetShadowSize() {
            return FloatingActionButtonGingerbread.this.mElevation;
        }
    }
    
    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements AnimatorUpdateListener
    {
        private float mShadowSizeEnd;
        private float mShadowSizeStart;
        private boolean mValidValues;
        
        protected abstract float getTargetShadowSize();
        
        @Override
        public void onAnimationEnd(final ValueAnimatorCompat valueAnimatorCompat) {
            FloatingActionButtonGingerbread.this.mShadowDrawable.setShadowSize(this.mShadowSizeEnd);
            this.mValidValues = false;
        }
        
        @Override
        public void onAnimationUpdate(final ValueAnimatorCompat valueAnimatorCompat) {
            if (!this.mValidValues) {
                this.mShadowSizeStart = FloatingActionButtonGingerbread.this.mShadowDrawable.getShadowSize();
                this.mShadowSizeEnd = this.getTargetShadowSize();
                this.mValidValues = true;
            }
            FloatingActionButtonGingerbread.this.mShadowDrawable.setShadowSize(this.mShadowSizeStart + (this.mShadowSizeEnd - this.mShadowSizeStart) * valueAnimatorCompat.getAnimatedFraction());
        }
    }
}
