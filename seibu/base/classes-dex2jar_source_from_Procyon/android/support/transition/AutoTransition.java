// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

public class AutoTransition extends TransitionSet
{
    public AutoTransition() {
        this.setOrdering(1);
        this.addTransition(new Fade(2)).addTransition(new ChangeBounds()).addTransition(new Fade(1));
    }
}
