// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.view.ViewGroup;
import android.transition.Scene;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
abstract class SceneWrapper extends SceneImpl
{
    Scene mScene;
    
    @Override
    public void exit() {
        this.mScene.exit();
    }
    
    @Override
    public ViewGroup getSceneRoot() {
        return this.mScene.getSceneRoot();
    }
    
    @Override
    public void setEnterAction(final Runnable enterAction) {
        this.mScene.setEnterAction(enterAction);
    }
    
    @Override
    public void setExitAction(final Runnable exitAction) {
        this.mScene.setExitAction(exitAction);
    }
}
