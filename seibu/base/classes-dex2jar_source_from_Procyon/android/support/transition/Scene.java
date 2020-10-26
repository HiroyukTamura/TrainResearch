// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.os.Build$VERSION;

public class Scene
{
    private static SceneStaticsImpl sImpl;
    SceneImpl mImpl;
    
    static {
        if (Build$VERSION.SDK_INT >= 21) {
            Scene.sImpl = new SceneStaticsApi21();
            return;
        }
        if (Build$VERSION.SDK_INT >= 19) {
            Scene.sImpl = new SceneStaticsKitKat();
            return;
        }
        Scene.sImpl = new SceneStaticsIcs();
    }
    
    private Scene(final SceneImpl mImpl) {
        this.mImpl = mImpl;
    }
    
    public Scene(@NonNull final ViewGroup viewGroup) {
        (this.mImpl = this.createSceneImpl()).init(viewGroup);
    }
    
    public Scene(@NonNull final ViewGroup viewGroup, @NonNull final View view) {
        (this.mImpl = this.createSceneImpl()).init(viewGroup, view);
    }
    
    private SceneImpl createSceneImpl() {
        if (Build$VERSION.SDK_INT >= 21) {
            return new SceneApi21();
        }
        if (Build$VERSION.SDK_INT >= 19) {
            return new SceneKitKat();
        }
        return new SceneIcs();
    }
    
    @NonNull
    public static Scene getSceneForLayout(@NonNull final ViewGroup viewGroup, @LayoutRes final int n, @NonNull final Context context) {
        SparseArray sparseArray;
        if ((sparseArray = (SparseArray)viewGroup.getTag(R.id.transition_scene_layoutid_cache)) == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(R.id.transition_scene_layoutid_cache, (Object)sparseArray);
        }
        final Scene scene = (Scene)sparseArray.get(n);
        if (scene != null) {
            return scene;
        }
        final Scene scene2 = new Scene(Scene.sImpl.getSceneForLayout(viewGroup, n, context));
        sparseArray.put(n, (Object)scene2);
        return scene2;
    }
    
    public void enter() {
        this.mImpl.enter();
    }
    
    public void exit() {
        this.mImpl.exit();
    }
    
    @NonNull
    public ViewGroup getSceneRoot() {
        return this.mImpl.getSceneRoot();
    }
    
    public void setEnterAction(@Nullable final Runnable enterAction) {
        this.mImpl.setEnterAction(enterAction);
    }
    
    public void setExitAction(@Nullable final Runnable exitAction) {
        this.mImpl.setExitAction(exitAction);
    }
}
