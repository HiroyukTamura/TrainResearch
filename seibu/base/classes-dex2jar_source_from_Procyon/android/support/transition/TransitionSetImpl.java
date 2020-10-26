// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

interface TransitionSetImpl
{
    TransitionSetImpl addTransition(final TransitionImpl p0);
    
    int getOrdering();
    
    TransitionSetImpl removeTransition(final TransitionImpl p0);
    
    TransitionSetImpl setOrdering(final int p0);
}
