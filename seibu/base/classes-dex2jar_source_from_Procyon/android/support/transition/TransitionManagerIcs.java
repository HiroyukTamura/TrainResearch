// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class TransitionManagerIcs extends TransitionManagerImpl
{
    private final TransitionManagerPort mTransitionManager;
    
    TransitionManagerIcs() {
        this.mTransitionManager = new TransitionManagerPort();
    }
    
    @Override
    public void setTransition(final SceneImpl sceneImpl, final SceneImpl sceneImpl2, final TransitionImpl transitionImpl) {
        final TransitionManagerPort mTransitionManager = this.mTransitionManager;
        final ScenePort mScene = ((SceneIcs)sceneImpl).mScene;
        final ScenePort mScene2 = ((SceneIcs)sceneImpl2).mScene;
        TransitionPort mTransition;
        if (transitionImpl == null) {
            mTransition = null;
        }
        else {
            mTransition = ((TransitionIcs)transitionImpl).mTransition;
        }
        mTransitionManager.setTransition(mScene, mScene2, mTransition);
    }
    
    @Override
    public void setTransition(final SceneImpl sceneImpl, final TransitionImpl transitionImpl) {
        final TransitionManagerPort mTransitionManager = this.mTransitionManager;
        final ScenePort mScene = ((SceneIcs)sceneImpl).mScene;
        TransitionPort mTransition;
        if (transitionImpl == null) {
            mTransition = null;
        }
        else {
            mTransition = ((TransitionIcs)transitionImpl).mTransition;
        }
        mTransitionManager.setTransition(mScene, mTransition);
    }
    
    @Override
    public void transitionTo(final SceneImpl sceneImpl) {
        this.mTransitionManager.transitionTo(((SceneIcs)sceneImpl).mScene);
    }
}
