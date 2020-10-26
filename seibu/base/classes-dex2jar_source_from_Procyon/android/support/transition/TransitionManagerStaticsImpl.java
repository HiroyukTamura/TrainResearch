// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.view.ViewGroup;

abstract class TransitionManagerStaticsImpl
{
    public abstract void beginDelayedTransition(final ViewGroup p0);
    
    public abstract void beginDelayedTransition(final ViewGroup p0, final TransitionImpl p1);
    
    public abstract void go(final SceneImpl p0);
    
    public abstract void go(final SceneImpl p0, final TransitionImpl p1);
}
