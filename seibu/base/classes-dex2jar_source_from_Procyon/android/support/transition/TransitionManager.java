// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.os.Build$VERSION;

public class TransitionManager
{
    private static TransitionManagerStaticsImpl sImpl;
    private TransitionManagerImpl mImpl;
    
    static {
        if (Build$VERSION.SDK_INT < 19) {
            TransitionManager.sImpl = new TransitionManagerStaticsIcs();
            return;
        }
        TransitionManager.sImpl = new TransitionManagerStaticsKitKat();
    }
    
    public TransitionManager() {
        if (Build$VERSION.SDK_INT < 19) {
            this.mImpl = new TransitionManagerIcs();
            return;
        }
        this.mImpl = new TransitionManagerKitKat();
    }
    
    public static void beginDelayedTransition(@NonNull final ViewGroup viewGroup) {
        TransitionManager.sImpl.beginDelayedTransition(viewGroup);
    }
    
    public static void beginDelayedTransition(@NonNull final ViewGroup viewGroup, @Nullable final Transition transition) {
        final TransitionManagerStaticsImpl sImpl = TransitionManager.sImpl;
        TransitionImpl mImpl;
        if (transition == null) {
            mImpl = null;
        }
        else {
            mImpl = transition.mImpl;
        }
        sImpl.beginDelayedTransition(viewGroup, mImpl);
    }
    
    public static void go(@NonNull final Scene scene) {
        TransitionManager.sImpl.go(scene.mImpl);
    }
    
    public static void go(@NonNull final Scene scene, @Nullable final Transition transition) {
        final TransitionManagerStaticsImpl sImpl = TransitionManager.sImpl;
        final SceneImpl mImpl = scene.mImpl;
        TransitionImpl mImpl2;
        if (transition == null) {
            mImpl2 = null;
        }
        else {
            mImpl2 = transition.mImpl;
        }
        sImpl.go(mImpl, mImpl2);
    }
    
    public void setTransition(@NonNull final Scene scene, @NonNull final Scene scene2, @Nullable final Transition transition) {
        final TransitionManagerImpl mImpl = this.mImpl;
        final SceneImpl mImpl2 = scene.mImpl;
        final SceneImpl mImpl3 = scene2.mImpl;
        TransitionImpl mImpl4;
        if (transition == null) {
            mImpl4 = null;
        }
        else {
            mImpl4 = transition.mImpl;
        }
        mImpl.setTransition(mImpl2, mImpl3, mImpl4);
    }
    
    public void setTransition(@NonNull final Scene scene, @Nullable final Transition transition) {
        final TransitionManagerImpl mImpl = this.mImpl;
        final SceneImpl mImpl2 = scene.mImpl;
        TransitionImpl mImpl3;
        if (transition == null) {
            mImpl3 = null;
        }
        else {
            mImpl3 = transition.mImpl;
        }
        mImpl.setTransition(mImpl2, mImpl3);
    }
    
    public void transitionTo(@NonNull final Scene scene) {
        this.mImpl.transitionTo(scene.mImpl);
    }
}
