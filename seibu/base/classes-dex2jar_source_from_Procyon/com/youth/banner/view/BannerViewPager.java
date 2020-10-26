// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner.view;

import android.view.MotionEvent;
import android.util.AttributeSet;
import android.content.Context;
import android.support.v4.view.ViewPager;

public class BannerViewPager extends ViewPager
{
    private boolean scrollable;
    
    public BannerViewPager(final Context context) {
        super(context);
        this.scrollable = true;
    }
    
    public BannerViewPager(final Context context, final AttributeSet set) {
        super(context, set);
        this.scrollable = true;
    }
    
    @Override
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        return this.scrollable && (this.getCurrentItem() != 0 || this.getChildCount() != 0) && super.onInterceptTouchEvent(motionEvent);
    }
    
    @Override
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        return this.scrollable && (this.getCurrentItem() != 0 || this.getChildCount() != 0) && super.onTouchEvent(motionEvent);
    }
    
    public void setScrollable(final boolean scrollable) {
        this.scrollable = scrollable;
    }
}
