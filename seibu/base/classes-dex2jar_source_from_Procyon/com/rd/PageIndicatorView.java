// 
// Decompiled by Procyon v0.5.36
// 

package com.rd;

import com.rd.draw.data.RtlMode;
import com.rd.utils.DensityUtils;
import com.rd.draw.data.Orientation;
import com.rd.animation.data.Value;
import com.rd.draw.data.PositionSavedState;
import android.os.Parcelable;
import android.graphics.Canvas;
import com.rd.utils.IdUtils;
import android.util.Pair;
import com.rd.utils.CoordinatesUtils;
import com.rd.animation.type.AnimationType;
import android.support.v4.text.TextUtilsCompat;
import com.rd.draw.data.Indicator;
import android.support.annotation.Nullable;
import android.app.Activity;
import android.annotation.TargetApi;
import android.util.AttributeSet;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import android.view.View;

public class PageIndicatorView extends View implements OnPageChangeListener, Listener
{
    private IndicatorManager manager;
    private DataSetObserver setObserver;
    private ViewPager viewPager;
    
    public PageIndicatorView(final Context context) {
        super(context);
        this.init(null);
    }
    
    public PageIndicatorView(final Context context, final AttributeSet set) {
        super(context, set);
        this.init(set);
    }
    
    public PageIndicatorView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.init(set);
    }
    
    @TargetApi(21)
    public PageIndicatorView(final Context context, final AttributeSet set, final int n, final int n2) {
        super(context, set, n, n2);
        this.init(set);
    }
    
    private void findViewPager() {
        if (this.getContext() instanceof Activity) {
            final View viewById = ((Activity)this.getContext()).findViewById(this.manager.indicator().getViewPagerId());
            if (viewById != null && viewById instanceof ViewPager) {
                this.setViewPager((ViewPager)viewById);
            }
        }
    }
    
    private int getViewPagerCount() {
        if (this.viewPager != null && this.viewPager.getAdapter() != null) {
            return this.viewPager.getAdapter().getCount();
        }
        return this.manager.indicator().getCount();
    }
    
    private void init(@Nullable final AttributeSet set) {
        this.setupId();
        this.initIndicatorManager(set);
    }
    
    private void initIndicatorManager(@Nullable final AttributeSet set) {
        this.manager = new IndicatorManager((IndicatorManager.Listener)this);
        this.manager.drawer().initAttributes(this.getContext(), set);
        final Indicator indicator = this.manager.indicator();
        indicator.setPaddingLeft(this.getPaddingLeft());
        indicator.setPaddingTop(this.getPaddingTop());
        indicator.setPaddingRight(this.getPaddingRight());
        indicator.setPaddingBottom(this.getPaddingBottom());
    }
    
    private boolean isRtl() {
        boolean b = true;
        switch (this.manager.indicator().getRtlMode()) {
            default: {
                b = false;
                return b;
            }
            case On: {
                return b;
            }
            case Off: {
                return false;
            }
            case Auto: {
                b = b;
                if (TextUtilsCompat.getLayoutDirectionFromLocale(this.getContext().getResources().getConfiguration().locale) != 1) {
                    return false;
                }
                return b;
            }
        }
    }
    
    private boolean isViewMeasured() {
        return this.getMeasuredHeight() != 0 || this.getMeasuredWidth() != 0;
    }
    
    private void registerSetObserver() {
        if (this.setObserver != null || this.viewPager == null || this.viewPager.getAdapter() == null) {
            return;
        }
        this.setObserver = new DataSetObserver() {
            public void onChanged() {
                PageIndicatorView.this.updateCount();
            }
        };
        try {
            this.viewPager.getAdapter().registerDataSetObserver(this.setObserver);
        }
        catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
    }
    
    private void selectIndicator(final int n) {
        final Indicator indicator = this.manager.indicator();
        final int count = indicator.getCount();
        final AnimationType animationType = indicator.getAnimationType();
        final boolean interactiveAnimation = indicator.isInteractiveAnimation();
        int n2;
        if (this.isViewMeasured() && (!interactiveAnimation || animationType == AnimationType.NONE)) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        if (n2 != 0) {
            int selection = n;
            if (this.isRtl()) {
                selection = count - 1 - n;
            }
            this.setSelection(selection);
        }
    }
    
    private void selectInteractiveIndicator(final int n, final float n2) {
        final Indicator indicator = this.manager.indicator();
        final AnimationType animationType = indicator.getAnimationType();
        final boolean interactiveAnimation = indicator.isInteractiveAnimation();
        int n3;
        if (this.isViewMeasured() && interactiveAnimation && animationType != AnimationType.NONE) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        if (n3 == 0) {
            return;
        }
        final Pair<Integer, Float> progress = CoordinatesUtils.getProgress(indicator, n, n2, this.isRtl());
        this.setProgress((int)progress.first, (float)progress.second);
    }
    
    private void setupId() {
        if (this.getId() == -1) {
            this.setId(IdUtils.generateViewId());
        }
    }
    
    private void unRegisterSetObserver() {
        if (this.setObserver == null || this.viewPager == null || this.viewPager.getAdapter() == null) {
            return;
        }
        try {
            this.viewPager.getAdapter().unregisterDataSetObserver(this.setObserver);
            this.setObserver = null;
        }
        catch (IllegalStateException ex) {
            ex.printStackTrace();
        }
    }
    
    private void updateCount() {
        if (this.viewPager == null || this.viewPager.getAdapter() == null) {
            return;
        }
        final int count = this.viewPager.getAdapter().getCount();
        final int currentItem = this.viewPager.getCurrentItem();
        this.manager.indicator().setSelectedPosition(currentItem);
        this.manager.indicator().setSelectingPosition(currentItem);
        this.manager.indicator().setLastSelectedPosition(currentItem);
        this.manager.animate().end();
        this.setCount(count);
    }
    
    private void updateVisibility() {
        if (this.manager.indicator().isAutoVisibility()) {
            final int count = this.manager.indicator().getCount();
            final int visibility = this.getVisibility();
            if (visibility != 0 && count > 1) {
                this.setVisibility(0);
                return;
            }
            if (visibility != 4 && count <= 1) {
                this.setVisibility(4);
            }
        }
    }
    
    public long getAnimationDuration() {
        return this.manager.indicator().getAnimationDuration();
    }
    
    public int getCount() {
        return this.manager.indicator().getCount();
    }
    
    public int getPadding() {
        return this.manager.indicator().getPadding();
    }
    
    public int getRadius() {
        return this.manager.indicator().getRadius();
    }
    
    public float getScaleFactor() {
        return this.manager.indicator().getScaleFactor();
    }
    
    public int getSelectedColor() {
        return this.manager.indicator().getSelectedColor();
    }
    
    public int getSelection() {
        return this.manager.indicator().getSelectedPosition();
    }
    
    public int getStrokeWidth() {
        return this.manager.indicator().getStroke();
    }
    
    public int getUnselectedColor() {
        return this.manager.indicator().getUnselectedColor();
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.findViewPager();
    }
    
    protected void onDetachedFromWindow() {
        this.unRegisterSetObserver();
        super.onDetachedFromWindow();
    }
    
    protected void onDraw(final Canvas canvas) {
        this.manager.drawer().draw(canvas);
    }
    
    public void onIndicatorUpdated() {
        this.invalidate();
    }
    
    protected void onMeasure(final int n, final int n2) {
        final Pair<Integer, Integer> measureViewSize = this.manager.drawer().measureViewSize(n, n2);
        this.setMeasuredDimension((int)measureViewSize.first, (int)measureViewSize.second);
    }
    
    public void onPageScrollStateChanged(final int n) {
    }
    
    public void onPageScrolled(final int n, final float n2, final int n3) {
        this.selectInteractiveIndicator(n, n2);
    }
    
    public void onPageSelected(final int n) {
        this.selectIndicator(n);
    }
    
    public void onRestoreInstanceState(final Parcelable parcelable) {
        if (parcelable instanceof PositionSavedState) {
            final Indicator indicator = this.manager.indicator();
            final PositionSavedState positionSavedState = (PositionSavedState)parcelable;
            indicator.setSelectedPosition(positionSavedState.getSelectedPosition());
            indicator.setSelectingPosition(positionSavedState.getSelectingPosition());
            indicator.setLastSelectedPosition(positionSavedState.getLastSelectedPosition());
            super.onRestoreInstanceState(positionSavedState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }
    
    public Parcelable onSaveInstanceState() {
        final Indicator indicator = this.manager.indicator();
        final PositionSavedState positionSavedState = new PositionSavedState(super.onSaveInstanceState());
        positionSavedState.setSelectedPosition(indicator.getSelectedPosition());
        positionSavedState.setSelectingPosition(indicator.getSelectingPosition());
        positionSavedState.setLastSelectedPosition(indicator.getLastSelectedPosition());
        return (Parcelable)positionSavedState;
    }
    
    public void releaseViewPager() {
        if (this.viewPager != null) {
            this.viewPager.removeOnPageChangeListener((ViewPager.OnPageChangeListener)this);
            this.viewPager = null;
        }
    }
    
    public void setAnimationDuration(final long animationDuration) {
        this.manager.indicator().setAnimationDuration(animationDuration);
    }
    
    public void setAnimationType(@Nullable final AnimationType animationType) {
        this.manager.onValueUpdated(null);
        if (animationType != null) {
            this.manager.indicator().setAnimationType(animationType);
        }
        else {
            this.manager.indicator().setAnimationType(AnimationType.NONE);
        }
        this.invalidate();
    }
    
    public void setAutoVisibility(final boolean autoVisibility) {
        if (!autoVisibility) {
            this.setVisibility(0);
        }
        this.manager.indicator().setAutoVisibility(autoVisibility);
        this.updateVisibility();
    }
    
    public void setCount(final int count) {
        if (count >= 0 && this.manager.indicator().getCount() != count) {
            this.manager.indicator().setCount(count);
            this.updateVisibility();
            this.requestLayout();
        }
    }
    
    public void setDynamicCount(final boolean dynamicCount) {
        this.manager.indicator().setDynamicCount(dynamicCount);
        if (dynamicCount) {
            this.registerSetObserver();
            return;
        }
        this.unRegisterSetObserver();
    }
    
    public void setInteractiveAnimation(final boolean interactiveAnimation) {
        this.manager.indicator().setInteractiveAnimation(interactiveAnimation);
    }
    
    public void setOrientation(@Nullable final Orientation orientation) {
        if (orientation != null) {
            this.manager.indicator().setOrientation(orientation);
            this.requestLayout();
        }
    }
    
    public void setPadding(final float n) {
        float n2 = n;
        if (n < 0.0f) {
            n2 = 0.0f;
        }
        this.manager.indicator().setPadding((int)n2);
        this.invalidate();
    }
    
    public void setPadding(int dpToPx) {
        int n = dpToPx;
        if (dpToPx < 0) {
            n = 0;
        }
        dpToPx = DensityUtils.dpToPx(n);
        this.manager.indicator().setPadding(dpToPx);
        this.invalidate();
    }
    
    public void setProgress(final int n, final float n2) {
        final Indicator indicator = this.manager.indicator();
        if (!indicator.isInteractiveAnimation()) {
            return;
        }
        final int count = indicator.getCount();
        int n3;
        if (count <= 0 || n < 0) {
            n3 = 0;
        }
        else if ((n3 = n) > count - 1) {
            n3 = count - 1;
        }
        float n4;
        if (n2 < 0.0f) {
            n4 = 0.0f;
        }
        else {
            n4 = n2;
            if (n2 > 1.0f) {
                n4 = 1.0f;
            }
        }
        if (n4 == 1.0f) {
            indicator.setLastSelectedPosition(indicator.getSelectedPosition());
            indicator.setSelectedPosition(n3);
        }
        indicator.setSelectingPosition(n3);
        this.manager.animate().interactive(n4);
    }
    
    public void setRadius(final float n) {
        float n2 = n;
        if (n < 0.0f) {
            n2 = 0.0f;
        }
        this.manager.indicator().setRadius((int)n2);
        this.invalidate();
    }
    
    public void setRadius(int dpToPx) {
        int n = dpToPx;
        if (dpToPx < 0) {
            n = 0;
        }
        dpToPx = DensityUtils.dpToPx(n);
        this.manager.indicator().setRadius(dpToPx);
        this.invalidate();
    }
    
    public void setRtlMode(@Nullable final RtlMode rtlMode) {
        final Indicator indicator = this.manager.indicator();
        if (rtlMode == null) {
            indicator.setRtlMode(RtlMode.Off);
        }
        else {
            indicator.setRtlMode(rtlMode);
        }
        if (this.viewPager == null) {
            return;
        }
        int lastSelectedPosition;
        final int n = lastSelectedPosition = indicator.getSelectedPosition();
        if (this.isRtl()) {
            lastSelectedPosition = indicator.getCount() - 1 - n;
        }
        else if (this.viewPager != null) {
            lastSelectedPosition = this.viewPager.getCurrentItem();
        }
        indicator.setSelectedPosition(lastSelectedPosition);
        indicator.setSelectingPosition(lastSelectedPosition);
        indicator.setLastSelectedPosition(lastSelectedPosition);
        this.invalidate();
    }
    
    public void setScaleFactor(final float n) {
        float scaleFactor;
        if (n > 1.0f) {
            scaleFactor = 1.0f;
        }
        else {
            scaleFactor = n;
            if (n < 0.3f) {
                scaleFactor = 0.3f;
            }
        }
        this.manager.indicator().setScaleFactor(scaleFactor);
    }
    
    public void setSelectedColor(final int selectedColor) {
        this.manager.indicator().setSelectedColor(selectedColor);
        this.invalidate();
    }
    
    public void setSelection(final int n) {
        final Indicator indicator = this.manager.indicator();
        if (!indicator.isInteractiveAnimation() || indicator.getAnimationType() == AnimationType.NONE) {
            final int selectedPosition = indicator.getSelectedPosition();
            final int n2 = indicator.getCount() - 1;
            int selectedPosition2;
            if (n < 0) {
                selectedPosition2 = 0;
            }
            else if ((selectedPosition2 = n) > n2) {
                selectedPosition2 = n2;
            }
            if (selectedPosition != selectedPosition2) {
                indicator.setLastSelectedPosition(indicator.getSelectedPosition());
                indicator.setSelectedPosition(selectedPosition2);
                this.manager.animate().basic();
            }
        }
    }
    
    public void setStrokeWidth(final float n) {
        final int radius = this.manager.indicator().getRadius();
        float n2;
        if (n < 0.0f) {
            n2 = 0.0f;
        }
        else {
            n2 = n;
            if (n > radius) {
                n2 = (float)radius;
            }
        }
        this.manager.indicator().setStroke((int)n2);
        this.invalidate();
    }
    
    public void setStrokeWidth(int stroke) {
        final int dpToPx = DensityUtils.dpToPx(stroke);
        final int radius = this.manager.indicator().getRadius();
        if (dpToPx < 0) {
            stroke = 0;
        }
        else if ((stroke = dpToPx) > radius) {
            stroke = radius;
        }
        this.manager.indicator().setStroke(stroke);
        this.invalidate();
    }
    
    public void setUnselectedColor(final int unselectedColor) {
        this.manager.indicator().setUnselectedColor(unselectedColor);
        this.invalidate();
    }
    
    public void setViewPager(@Nullable final ViewPager viewPager) {
        this.releaseViewPager();
        if (viewPager == null) {
            return;
        }
        (this.viewPager = viewPager).addOnPageChangeListener((ViewPager.OnPageChangeListener)this);
        this.manager.indicator().setViewPagerId(this.viewPager.getId());
        this.setDynamicCount(this.manager.indicator().isDynamicCount());
        final int viewPagerCount = this.getViewPagerCount();
        if (this.isRtl()) {
            this.manager.indicator().setSelectedPosition(viewPagerCount - 1 - this.viewPager.getCurrentItem());
        }
        this.setCount(viewPagerCount);
    }
}
