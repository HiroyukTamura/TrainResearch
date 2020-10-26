// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.transition.Transition;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class TransitionManagerKitKat extends TransitionManagerImpl
{
    private final TransitionManager mTransitionManager;
    
    TransitionManagerKitKat() {
        this.mTransitionManager = new TransitionManager();
    }
    
    @Override
    public void setTransition(final SceneImpl sceneImpl, final SceneImpl sceneImpl2, final TransitionImpl transitionImpl) {
        final TransitionManager mTransitionManager = this.mTransitionManager;
        final Scene mScene = ((SceneWrapper)sceneImpl).mScene;
        final Scene mScene2 = ((SceneWrapper)sceneImpl2).mScene;
        Transition mTransition;
        if (transitionImpl == null) {
            mTransition = null;
        }
        else {
            mTransition = ((TransitionKitKat)transitionImpl).mTransition;
        }
        mTransitionManager.setTransition(mScene, mScene2, mTransition);
    }
    
    @Override
    public void setTransition(final SceneImpl sceneImpl, final TransitionImpl transitionImpl) {
        final TransitionManager mTransitionManager = this.mTransitionManager;
        final Scene mScene = ((SceneWrapper)sceneImpl).mScene;
        Transition mTransition;
        if (transitionImpl == null) {
            mTransition = null;
        }
        else {
            mTransition = ((TransitionKitKat)transitionImpl).mTransition;
        }
        mTransitionManager.setTransition(mScene, mTransition);
    }
    
    @Override
    public void transitionTo(final SceneImpl sceneImpl) {
        this.mTransitionManager.transitionTo(((SceneWrapper)sceneImpl).mScene);
    }
}
