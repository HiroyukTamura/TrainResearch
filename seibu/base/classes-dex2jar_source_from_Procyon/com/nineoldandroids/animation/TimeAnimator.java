// 
// Decompiled by Procyon v0.5.36
// 

package com.nineoldandroids.animation;

public class TimeAnimator extends ValueAnimator
{
    private TimeListener mListener;
    private long mPreviousTime;
    
    public TimeAnimator() {
        this.mPreviousTime = -1L;
    }
    
    @Override
    void animateValue(final float n) {
    }
    
    @Override
    boolean animationFrame(final long n) {
        long n2 = 0L;
        if (this.mPlayingState == 0) {
            this.mPlayingState = 1;
            if (this.mSeekTime < 0L) {
                this.mStartTime = n;
            }
            else {
                this.mStartTime = n - this.mSeekTime;
                this.mSeekTime = -1L;
            }
        }
        if (this.mListener != null) {
            final long mStartTime = this.mStartTime;
            if (this.mPreviousTime >= 0L) {
                n2 = n - this.mPreviousTime;
            }
            this.mPreviousTime = n;
            this.mListener.onTimeUpdate(this, n - mStartTime, n2);
        }
        return false;
    }
    
    @Override
    void initAnimation() {
    }
    
    public void setTimeListener(final TimeListener mListener) {
        this.mListener = mListener;
    }
    
    public interface TimeListener
    {
        void onTimeUpdate(final TimeAnimator p0, final long p1, final long p2);
    }
}
