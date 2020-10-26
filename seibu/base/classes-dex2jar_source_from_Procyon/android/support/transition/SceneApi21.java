// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.view.View;
import android.transition.Scene;
import android.view.ViewGroup;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(21)
@RequiresApi(21)
class SceneApi21 extends SceneWrapper
{
    @Override
    public void enter() {
        this.mScene.enter();
    }
    
    @Override
    public void init(final ViewGroup viewGroup) {
        this.mScene = new Scene(viewGroup);
    }
    
    @Override
    public void init(final ViewGroup viewGroup, final View view) {
        this.mScene = new Scene(viewGroup, view);
    }
}
