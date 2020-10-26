// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.content.Context;
import android.view.ViewGroup;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
class SceneStaticsIcs extends SceneStaticsImpl
{
    @Override
    public SceneImpl getSceneForLayout(final ViewGroup viewGroup, final int n, final Context context) {
        final SceneIcs sceneIcs = new SceneIcs();
        sceneIcs.mScene = ScenePort.getSceneForLayout(viewGroup, n, context);
        return sceneIcs;
    }
}
