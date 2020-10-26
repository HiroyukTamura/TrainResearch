// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.view.ViewGroup;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class TransitionManagerStaticsIcs extends TransitionManagerStaticsImpl
{
    @Override
    public void beginDelayedTransition(final ViewGroup viewGroup) {
        TransitionManagerPort.beginDelayedTransition(viewGroup);
    }
    
    @Override
    public void beginDelayedTransition(final ViewGroup viewGroup, final TransitionImpl transitionImpl) {
        TransitionPort mTransition;
        if (transitionImpl == null) {
            mTransition = null;
        }
        else {
            mTransition = ((TransitionIcs)transitionImpl).mTransition;
        }
        TransitionManagerPort.beginDelayedTransition(viewGroup, mTransition);
    }
    
    @Override
    public void go(final SceneImpl sceneImpl) {
        TransitionManagerPort.go(((SceneIcs)sceneImpl).mScene);
    }
    
    @Override
    public void go(final SceneImpl sceneImpl, final TransitionImpl transitionImpl) {
        final ScenePort mScene = ((SceneIcs)sceneImpl).mScene;
        TransitionPort mTransition;
        if (transitionImpl == null) {
            mTransition = null;
        }
        else {
            mTransition = ((TransitionIcs)transitionImpl).mTransition;
        }
        TransitionManagerPort.go(mScene, mTransition);
    }
}
