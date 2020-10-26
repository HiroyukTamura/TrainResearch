// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.transition.Scene;
import android.content.Context;
import android.view.ViewGroup;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class SceneStaticsKitKat extends SceneStaticsImpl
{
    @Override
    public SceneImpl getSceneForLayout(final ViewGroup viewGroup, final int n, final Context context) {
        final SceneKitKat sceneKitKat = new SceneKitKat();
        sceneKitKat.mScene = Scene.getSceneForLayout(viewGroup, n, context);
        return sceneKitKat;
    }
}
