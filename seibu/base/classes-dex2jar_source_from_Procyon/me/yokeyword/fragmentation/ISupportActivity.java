// 
// Decompiled by Procyon v0.5.36
// 

package me.yokeyword.fragmentation;

import me.yokeyword.fragmentation.anim.FragmentAnimator;
import android.view.MotionEvent;

public interface ISupportActivity
{
    boolean dispatchTouchEvent(final MotionEvent p0);
    
    ExtraTransaction extraTransaction();
    
    FragmentAnimator getFragmentAnimator();
    
    SupportActivityDelegate getSupportDelegate();
    
    void onBackPressed();
    
    void onBackPressedSupport();
    
    FragmentAnimator onCreateFragmentAnimator();
    
    void setFragmentAnimator(final FragmentAnimator p0);
}
