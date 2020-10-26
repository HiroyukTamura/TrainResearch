// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

abstract class TransitionManagerImpl
{
    public abstract void setTransition(final SceneImpl p0, final SceneImpl p1, final TransitionImpl p2);
    
    public abstract void setTransition(final SceneImpl p0, final TransitionImpl p1);
    
    public abstract void transitionTo(final SceneImpl p0);
}
