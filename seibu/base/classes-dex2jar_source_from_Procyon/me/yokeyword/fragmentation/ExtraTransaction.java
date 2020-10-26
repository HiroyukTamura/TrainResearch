// 
// Decompiled by Procyon v0.5.36
// 

package me.yokeyword.fragmentation;

import android.support.annotation.AnimatorRes;
import android.support.annotation.AnimRes;
import android.support.annotation.RequiresApi;
import android.view.View;

public abstract class ExtraTransaction
{
    @RequiresApi(22)
    public abstract ExtraTransaction addSharedElement(final View p0, final String p1);
    
    public abstract ExtraTransaction.ExtraTransaction$DontAddToBackStackTransaction dontAddToBackStack();
    
    public abstract void popTo(final String p0, final boolean p1);
    
    public abstract void popTo(final String p0, final boolean p1, final Runnable p2, final int p3);
    
    public abstract void popToChild(final String p0, final boolean p1);
    
    public abstract void popToChild(final String p0, final boolean p1, final Runnable p2, final int p3);
    
    public abstract void remove(final ISupportFragment p0, final boolean p1);
    
    public abstract void replace(final ISupportFragment p0);
    
    public abstract ExtraTransaction setCustomAnimations(@AnimRes @AnimatorRes final int p0, @AnimRes @AnimatorRes final int p1);
    
    public abstract ExtraTransaction setCustomAnimations(@AnimRes @AnimatorRes final int p0, @AnimRes @AnimatorRes final int p1, @AnimRes @AnimatorRes final int p2, @AnimRes @AnimatorRes final int p3);
    
    public abstract ExtraTransaction setTag(final String p0);
    
    public abstract void start(final ISupportFragment p0);
    
    public abstract void start(final ISupportFragment p0, final int p1);
    
    public abstract void startDontHideSelf(final ISupportFragment p0);
    
    public abstract void startForResult(final ISupportFragment p0, final int p1);
    
    public abstract void startForResultDontHideSelf(final ISupportFragment p0, final int p1);
    
    public abstract void startWithPop(final ISupportFragment p0);
}
