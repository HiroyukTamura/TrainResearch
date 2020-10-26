// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class SceneIcs extends SceneImpl
{
    ScenePort mScene;
    
    @Override
    public void enter() {
        this.mScene.enter();
    }
    
    @Override
    public void exit() {
        this.mScene.exit();
    }
    
    @Override
    public ViewGroup getSceneRoot() {
        return this.mScene.getSceneRoot();
    }
    
    @Override
    public void init(final ViewGroup viewGroup) {
        this.mScene = new ScenePort(viewGroup);
    }
    
    @Override
    public void init(final ViewGroup viewGroup, final View view) {
        this.mScene = new ScenePort(viewGroup, view);
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
