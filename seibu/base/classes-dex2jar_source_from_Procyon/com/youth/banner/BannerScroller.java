// 
// Decompiled by Procyon v0.5.36
// 

package com.youth.banner;

import android.view.animation.Interpolator;
import android.content.Context;
import android.widget.Scroller;

public class BannerScroller extends Scroller
{
    private int mDuration;
    
    public BannerScroller(final Context context) {
        super(context);
        this.mDuration = 800;
    }
    
    public BannerScroller(final Context context, final Interpolator interpolator) {
        super(context, interpolator);
        this.mDuration = 800;
    }
    
    public BannerScroller(final Context context, final Interpolator interpolator, final boolean b) {
        super(context, interpolator, b);
        this.mDuration = 800;
    }
    
    public void setDuration(final int mDuration) {
        this.mDuration = mDuration;
    }
    
    public void startScroll(final int n, final int n2, final int n3, final int n4) {
        super.startScroll(n, n2, n3, n4, this.mDuration);
    }
    
    public void startScroll(final int n, final int n2, final int n3, final int n4, final int n5) {
        super.startScroll(n, n2, n3, n4, this.mDuration);
    }
}
