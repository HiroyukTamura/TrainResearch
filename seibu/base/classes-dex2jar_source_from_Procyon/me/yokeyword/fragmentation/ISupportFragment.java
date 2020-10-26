// 
// Decompiled by Procyon v0.5.36
// 

package me.yokeyword.fragmentation;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;
import android.support.annotation.Nullable;
import android.os.Bundle;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public interface ISupportFragment
{
    public static final int RESULT_CANCELED = 0;
    public static final int RESULT_OK = -1;
    public static final int SINGLETASK = 2;
    public static final int SINGLETOP = 1;
    public static final int STANDARD = 0;
    
    void enqueueAction(final Runnable p0);
    
    ExtraTransaction extraTransaction();
    
    FragmentAnimator getFragmentAnimator();
    
    SupportFragmentDelegate getSupportDelegate();
    
    boolean isSupportVisible();
    
    boolean onBackPressedSupport();
    
    FragmentAnimator onCreateFragmentAnimator();
    
    void onEnterAnimationEnd(@Nullable final Bundle p0);
    
    void onFragmentResult(final int p0, final int p1, final Bundle p2);
    
    void onLazyInitView(@Nullable final Bundle p0);
    
    void onNewBundle(final Bundle p0);
    
    void onSupportInvisible();
    
    void onSupportVisible();
    
    void putNewBundle(final Bundle p0);
    
    void setFragmentAnimator(final FragmentAnimator p0);
    
    void setFragmentResult(final int p0, final Bundle p1);
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface LaunchMode {
    }
}
