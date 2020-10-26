// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.transition.Scene;
import android.content.Context;
import android.view.ViewGroup;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(21)
@RequiresApi(21)
class SceneStaticsApi21 extends SceneStaticsImpl
{
    @Override
    public SceneImpl getSceneForLayout(final ViewGroup viewGroup, final int n, final Context context) {
        final SceneApi21 sceneApi21 = new SceneApi21();
        sceneApi21.mScene = Scene.getSceneForLayout(viewGroup, n, context);
        return sceneApi21;
    }
}
