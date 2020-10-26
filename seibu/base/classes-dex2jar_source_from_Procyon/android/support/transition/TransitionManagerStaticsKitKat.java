// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.ViewGroup;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class TransitionManagerStaticsKitKat extends TransitionManagerStaticsImpl
{
    @Override
    public void beginDelayedTransition(final ViewGroup viewGroup) {
        TransitionManager.beginDelayedTransition(viewGroup);
    }
    
    @Override
    public void beginDelayedTransition(final ViewGroup viewGroup, final TransitionImpl transitionImpl) {
        Transition mTransition;
        if (transitionImpl == null) {
            mTransition = null;
        }
        else {
            mTransition = ((TransitionKitKat)transitionImpl).mTransition;
        }
        TransitionManager.beginDelayedTransition(viewGroup, mTransition);
    }
    
    @Override
    public void go(final SceneImpl sceneImpl) {
        TransitionManager.go(((SceneWrapper)sceneImpl).mScene);
    }
    
    @Override
    public void go(final SceneImpl sceneImpl, final TransitionImpl transitionImpl) {
        final Scene mScene = ((SceneWrapper)sceneImpl).mScene;
        Transition mTransition;
        if (transitionImpl == null) {
            mTransition = null;
        }
        else {
            mTransition = ((TransitionKitKat)transitionImpl).mTransition;
        }
        TransitionManager.go(mScene, mTransition);
    }
}
