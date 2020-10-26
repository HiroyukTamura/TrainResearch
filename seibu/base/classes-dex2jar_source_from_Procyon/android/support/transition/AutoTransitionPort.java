// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class AutoTransitionPort extends TransitionSetPort
{
    public AutoTransitionPort() {
        this.setOrdering(1);
        this.addTransition(new FadePort(2)).addTransition(new ChangeBoundsPort()).addTransition(new FadePort(1));
    }
}
