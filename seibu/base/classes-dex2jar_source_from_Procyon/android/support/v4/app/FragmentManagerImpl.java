// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.app;

import android.support.annotation.CallSuper;
import android.support.v4.os.BuildCompat;
import android.support.v4.util.DebugUtils;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.content.res.Resources$NotFoundException;
import android.view.animation.AnimationUtils;
import java.util.Arrays;
import java.util.Iterator;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.content.res.Configuration;
import java.io.FileDescriptor;
import java.io.Writer;
import java.io.PrintWriter;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.view.animation.Animation$AnimationListener;
import java.util.List;
import android.view.animation.ScaleAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AlphaAnimation;
import android.content.Context;
import android.view.ViewGroup;
import java.util.Collection;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.View;
import android.support.v4.util.ArraySet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.support.v4.util.Pair;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.lang.reflect.Field;
import android.view.animation.Interpolator;
import android.support.v4.view.LayoutInflaterFactory;

final class FragmentManagerImpl extends FragmentManager implements LayoutInflaterFactory
{
    static final Interpolator ACCELERATE_CUBIC;
    static final Interpolator ACCELERATE_QUINT;
    static final int ANIM_DUR = 220;
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    static boolean DEBUG = false;
    static final Interpolator DECELERATE_CUBIC;
    static final Interpolator DECELERATE_QUINT;
    static final boolean HONEYCOMB;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    static final String VIEW_STATE_TAG = "android:view_state";
    static Field sAnimationListenerField;
    ArrayList<Fragment> mActive;
    ArrayList<Fragment> mAdded;
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<Integer> mAvailIndices;
    ArrayList<BackStackRecord> mBackStack;
    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    ArrayList<BackStackRecord> mBackStackIndices;
    FragmentContainer mContainer;
    ArrayList<Fragment> mCreatedMenus;
    int mCurState;
    boolean mDestroyed;
    Runnable mExecCommit;
    boolean mExecutingActions;
    boolean mHavePendingDeferredStart;
    FragmentHostCallback mHost;
    private CopyOnWriteArrayList<Pair<FragmentLifecycleCallbacks, Boolean>> mLifecycleCallbacks;
    boolean mNeedMenuInvalidate;
    String mNoTransactionsBecause;
    Fragment mParent;
    ArrayList<OpGenerator> mPendingActions;
    ArrayList<StartEnterTransitionListener> mPostponedTransactions;
    SparseArray<Parcelable> mStateArray;
    Bundle mStateBundle;
    boolean mStateSaved;
    Runnable[] mTmpActions;
    ArrayList<Fragment> mTmpAddedFragments;
    ArrayList<Boolean> mTmpIsPop;
    ArrayList<BackStackRecord> mTmpRecords;
    
    static {
        boolean honeycomb = false;
        FragmentManagerImpl.DEBUG = false;
        if (Build$VERSION.SDK_INT >= 11) {
            honeycomb = true;
        }
        HONEYCOMB = honeycomb;
        FragmentManagerImpl.sAnimationListenerField = null;
        DECELERATE_QUINT = (Interpolator)new DecelerateInterpolator(2.5f);
        DECELERATE_CUBIC = (Interpolator)new DecelerateInterpolator(1.5f);
        ACCELERATE_QUINT = (Interpolator)new AccelerateInterpolator(2.5f);
        ACCELERATE_CUBIC = (Interpolator)new AccelerateInterpolator(1.5f);
    }
    
    FragmentManagerImpl() {
        this.mCurState = 0;
        this.mStateBundle = null;
        this.mStateArray = null;
        this.mExecCommit = new Runnable() {
            @Override
            public void run() {
                FragmentManagerImpl.this.execPendingActions();
            }
        };
    }
    
    private void addAddedFragments(final ArraySet<Fragment> set) {
        if (this.mCurState >= 1) {
            final int min = Math.min(this.mCurState, 4);
            int size;
            if (this.mAdded == null) {
                size = 0;
            }
            else {
                size = this.mAdded.size();
            }
            for (int i = 0; i < size; ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment.mState < min) {
                    this.moveToState(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                    if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                        set.add(fragment);
                    }
                }
            }
        }
    }
    
    private void checkStateLoss() {
        if (this.mStateSaved) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.mNoTransactionsBecause != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.mNoTransactionsBecause);
        }
    }
    
    private void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }
    
    private void completeExecute(final BackStackRecord e, final boolean b, final boolean b2, final boolean b3) {
        final ArrayList<BackStackRecord> list = new ArrayList<BackStackRecord>(1);
        final ArrayList<Boolean> list2 = new ArrayList<Boolean>(1);
        list.add(e);
        list2.add(b);
        executeOps(list, list2, 0, 1);
        if (b2) {
            FragmentTransition.startTransitions(this, list, list2, 0, 1, true);
        }
        if (b3) {
            this.moveToState(this.mCurState, true);
        }
        if (this.mActive != null) {
            for (int size = this.mActive.size(), i = 0; i < size; ++i) {
                final Fragment fragment = this.mActive.get(i);
                if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && e.interactsWith(fragment.mContainerId)) {
                    if (Build$VERSION.SDK_INT >= 11 && fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    if (b3) {
                        fragment.mPostponedAlpha = 0.0f;
                    }
                    else {
                        fragment.mPostponedAlpha = -1.0f;
                        fragment.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }
    
    private void endAnimatingAwayFragments() {
        int size;
        if (this.mActive == null) {
            size = 0;
        }
        else {
            size = this.mActive.size();
        }
        for (int i = 0; i < size; ++i) {
            final Fragment fragment = this.mActive.get(i);
            if (fragment != null && fragment.getAnimatingAway() != null) {
                final int stateAfterAnimating = fragment.getStateAfterAnimating();
                final View animatingAway = fragment.getAnimatingAway();
                fragment.setAnimatingAway(null);
                final Animation animation = animatingAway.getAnimation();
                if (animation != null) {
                    animation.cancel();
                }
                this.moveToState(fragment, stateAfterAnimating, 0, 0, false);
            }
        }
    }
    
    private void ensureExecReady(final boolean b) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!b) {
            this.checkStateLoss();
        }
        if (this.mTmpRecords == null) {
            this.mTmpRecords = new ArrayList<BackStackRecord>();
            this.mTmpIsPop = new ArrayList<Boolean>();
        }
        this.mExecutingActions = true;
        try {
            this.executePostponedTransaction(null, null);
        }
        finally {
            this.mExecutingActions = false;
        }
    }
    
    private static void executeOps(final ArrayList<BackStackRecord> list, final ArrayList<Boolean> list2, int i, final int n) {
        while (i < n) {
            final BackStackRecord backStackRecord = list.get(i);
            if (list2.get(i)) {
                backStackRecord.bumpBackStackNesting(-1);
                backStackRecord.executePopOps(i == n - 1);
            }
            else {
                backStackRecord.bumpBackStackNesting(1);
                backStackRecord.executeOps();
            }
            ++i;
        }
    }
    
    private void executeOpsTogether(final ArrayList<BackStackRecord> list, final ArrayList<Boolean> list2, int i, final int n) {
        final boolean mAllowOptimization = list.get(i).mAllowOptimization;
        int n2 = 0;
        if (this.mTmpAddedFragments == null) {
            this.mTmpAddedFragments = new ArrayList<Fragment>();
        }
        else {
            this.mTmpAddedFragments.clear();
        }
        if (this.mAdded != null) {
            this.mTmpAddedFragments.addAll(this.mAdded);
        }
        for (int j = i; j < n; ++j) {
            final BackStackRecord backStackRecord = list.get(j);
            if (!list2.get(j)) {
                backStackRecord.expandReplaceOps(this.mTmpAddedFragments);
            }
            else {
                backStackRecord.trackAddedFragmentsInPop(this.mTmpAddedFragments);
            }
            if (n2 != 0 || backStackRecord.mAddToBackStack) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
        }
        this.mTmpAddedFragments.clear();
        if (!mAllowOptimization) {
            FragmentTransition.startTransitions(this, list, list2, i, n, false);
        }
        executeOps(list, list2, i, n);
        int postponePostponableTransactions = n;
        if (mAllowOptimization) {
            final ArraySet<Fragment> set = new ArraySet<Fragment>();
            this.addAddedFragments(set);
            postponePostponableTransactions = this.postponePostponableTransactions(list, list2, i, n, set);
            this.makeRemovedFragmentsInvisible(set);
        }
        if (postponePostponableTransactions != i && mAllowOptimization) {
            FragmentTransition.startTransitions(this, list, list2, i, postponePostponableTransactions, true);
            this.moveToState(this.mCurState, true);
        }
        while (i < n) {
            final BackStackRecord backStackRecord2 = list.get(i);
            if (list2.get(i) && backStackRecord2.mIndex >= 0) {
                this.freeBackStackIndex(backStackRecord2.mIndex);
                backStackRecord2.mIndex = -1;
            }
            ++i;
        }
        if (n2 != 0) {
            this.reportBackStackChanged();
        }
    }
    
    private void executePostponedTransaction(final ArrayList<BackStackRecord> list, final ArrayList<Boolean> list2) {
        int size;
        if (this.mPostponedTransactions == null) {
            size = 0;
        }
        else {
            size = this.mPostponedTransactions.size();
        }
        final int n = 0;
        int n2 = size;
        int i = n;
    Label_0093_Outer:
        while (i < n2) {
            final StartEnterTransitionListener startEnterTransitionListener = this.mPostponedTransactions.get(i);
            while (true) {
                Label_0116: {
                    if (list == null || startEnterTransitionListener.mIsBack) {
                        break Label_0116;
                    }
                    final int index = list.indexOf(startEnterTransitionListener.mRecord);
                    if (index == -1 || !list2.get(index)) {
                        break Label_0116;
                    }
                    startEnterTransitionListener.cancelTransaction();
                    final int n3 = n2;
                    final int n4 = i;
                    i = n4 + 1;
                    n2 = n3;
                    continue Label_0093_Outer;
                }
                if (!startEnterTransitionListener.isReady()) {
                    int n4 = i;
                    int n3 = n2;
                    if (list == null) {
                        continue;
                    }
                    n4 = i;
                    n3 = n2;
                    if (!startEnterTransitionListener.mRecord.interactsWith(list, 0, list.size())) {
                        continue;
                    }
                }
                this.mPostponedTransactions.remove(i);
                int n4 = i - 1;
                int n3 = n2 - 1;
                if (list != null && !startEnterTransitionListener.mIsBack) {
                    final int index2 = list.indexOf(startEnterTransitionListener.mRecord);
                    if (index2 != -1 && list2.get(index2)) {
                        startEnterTransitionListener.cancelTransaction();
                        continue;
                    }
                }
                startEnterTransitionListener.completeTransaction();
                continue;
            }
        }
    }
    
    private Fragment findFragmentUnder(Fragment o) {
        final ViewGroup mContainer = o.mContainer;
        final View mView = o.mView;
        if (mContainer != null && mView != null) {
            for (int i = this.mAdded.indexOf(o) - 1; i >= 0; --i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment.mContainer == mContainer) {
                    o = fragment;
                    if (fragment.mView != null) {
                        return o;
                    }
                }
            }
            return null;
        }
        o = null;
        return o;
    }
    
    private void forcePostponedTransactions() {
        if (this.mPostponedTransactions != null) {
            while (!this.mPostponedTransactions.isEmpty()) {
                this.mPostponedTransactions.remove(0).completeTransaction();
            }
        }
    }
    
    private boolean generateOpsForPendingActions(final ArrayList<BackStackRecord> list, final ArrayList<Boolean> list2) {
        synchronized (this) {
            if (this.mPendingActions == null || this.mPendingActions.size() == 0) {
                return false;
            }
            final int size = this.mPendingActions.size();
            for (int i = 0; i < size; ++i) {
                this.mPendingActions.get(i).generateOps(list, list2);
            }
            this.mPendingActions.clear();
            this.mHost.getHandler().removeCallbacks(this.mExecCommit);
            // monitorexit(this)
            if (size > 0) {
                return true;
            }
        }
        return false;
    }
    
    static Animation makeFadeAnimation(final Context context, final float n, final float n2) {
        final AlphaAnimation alphaAnimation = new AlphaAnimation(n, n2);
        alphaAnimation.setInterpolator(FragmentManagerImpl.DECELERATE_CUBIC);
        alphaAnimation.setDuration(220L);
        return (Animation)alphaAnimation;
    }
    
    static Animation makeOpenCloseAnimation(final Context context, final float n, final float n2, final float n3, final float n4) {
        final AnimationSet set = new AnimationSet(false);
        final ScaleAnimation scaleAnimation = new ScaleAnimation(n, n2, n, n2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(FragmentManagerImpl.DECELERATE_QUINT);
        scaleAnimation.setDuration(220L);
        set.addAnimation((Animation)scaleAnimation);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(n3, n4);
        alphaAnimation.setInterpolator(FragmentManagerImpl.DECELERATE_CUBIC);
        alphaAnimation.setDuration(220L);
        set.addAnimation((Animation)alphaAnimation);
        return (Animation)set;
    }
    
    private void makeRemovedFragmentsInvisible(final ArraySet<Fragment> set) {
        for (int size = set.size(), i = 0; i < size; ++i) {
            final Fragment fragment = set.valueAt(i);
            if (!fragment.mAdded) {
                final View view = fragment.getView();
                if (Build$VERSION.SDK_INT < 11) {
                    fragment.getView().setVisibility(4);
                }
                else {
                    fragment.mPostponedAlpha = view.getAlpha();
                    view.setAlpha(0.0f);
                }
            }
        }
    }
    
    static boolean modifiesAlpha(final Animation animation) {
        if (!(animation instanceof AlphaAnimation)) {
            if (animation instanceof AnimationSet) {
                final List animations = ((AnimationSet)animation).getAnimations();
                for (int i = 0; i < animations.size(); ++i) {
                    if (animations.get(i) instanceof AlphaAnimation) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
    
    private void optimizeAndExecuteOps(final ArrayList<BackStackRecord> list, final ArrayList<Boolean> list2) {
        if (list != null && !list.isEmpty()) {
            if (list2 == null || list.size() != list2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            this.executePostponedTransaction(list, list2);
            final int size = list.size();
            int n = 0;
            int n2;
            int n3;
            for (int i = 0; i < size; i = n2 + 1, n = n3) {
                n2 = i;
                n3 = n;
                if (!list.get(i).mAllowOptimization) {
                    if (n != i) {
                        this.executeOpsTogether(list, list2, n, i);
                    }
                    int n5;
                    int n4 = n5 = i + 1;
                    if (list2.get(i)) {
                        while ((n5 = n4) < size) {
                            n5 = n4;
                            if (!list2.get(n4)) {
                                break;
                            }
                            n5 = n4;
                            if (list.get(n4).mAllowOptimization) {
                                break;
                            }
                            ++n4;
                        }
                    }
                    this.executeOpsTogether(list, list2, i, n5);
                    final int n6 = n5;
                    n2 = n5 - 1;
                    n3 = n6;
                }
            }
            if (n != size) {
                this.executeOpsTogether(list, list2, n, size);
            }
        }
    }
    
    private boolean popBackStackImmediate(final String s, final int n, final int n2) {
        this.execPendingActions();
        this.ensureExecReady(true);
        final boolean popBackStackState = this.popBackStackState(this.mTmpRecords, this.mTmpIsPop, s, n, n2);
        Label_0053: {
            if (!popBackStackState) {
                break Label_0053;
            }
            this.mExecutingActions = true;
            try {
                this.optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
                this.cleanupExec();
                this.doPendingDeferredStart();
                return popBackStackState;
            }
            finally {
                this.cleanupExec();
            }
        }
    }
    
    private int postponePostponableTransactions(final ArrayList<BackStackRecord> list, final ArrayList<Boolean> list2, final int n, final int n2, final ArraySet<Fragment> set) {
        int n3 = n2;
        int index;
        for (int i = n2 - 1; i >= n; --i, n3 = index) {
            final BackStackRecord element = list.get(i);
            final boolean booleanValue = list2.get(i);
            int n4;
            if (element.isPostponed() && !element.interactsWith(list, i + 1, n2)) {
                n4 = 1;
            }
            else {
                n4 = 0;
            }
            index = n3;
            if (n4 != 0) {
                if (this.mPostponedTransactions == null) {
                    this.mPostponedTransactions = new ArrayList<StartEnterTransitionListener>();
                }
                final StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(element, booleanValue);
                this.mPostponedTransactions.add(startEnterTransitionListener);
                element.setOnStartPostponedListener(startEnterTransitionListener);
                if (booleanValue) {
                    element.executeOps();
                }
                else {
                    element.executePopOps(false);
                }
                index = n3 - 1;
                if (i != index) {
                    list.remove(i);
                    list.add(index, element);
                }
                this.addAddedFragments(set);
            }
        }
        return n3;
    }
    
    public static int reverseTransit(final int n) {
        switch (n) {
            default: {
                return 0;
            }
            case 4097: {
                return 8194;
            }
            case 8194: {
                return 4097;
            }
            case 4099: {
                return 4099;
            }
        }
    }
    
    private void scheduleCommit() {
    Label_0081_Outer:
        while (true) {
            int n = 1;
        Label_0081:
            while (true) {
            Label_0097:
                while (true) {
                    Label_0092: {
                        while (true) {
                            final int n2;
                            synchronized (this) {
                                if (this.mPostponedTransactions == null || this.mPostponedTransactions.isEmpty()) {
                                    break Label_0092;
                                }
                                n2 = 1;
                                if (this.mPendingActions != null && this.mPendingActions.size() == 1) {
                                    break Label_0081;
                                }
                                break Label_0097;
                                this.mHost.getHandler().removeCallbacks(this.mExecCommit);
                                this.mHost.getHandler().post(this.mExecCommit);
                                return;
                            }
                            if (n2 == 0 && n == 0) {
                                return;
                            }
                            continue;
                        }
                    }
                    int n2 = 0;
                    continue Label_0081_Outer;
                }
                n = 0;
                continue Label_0081;
            }
        }
    }
    
    private void setHWLayerAnimListenerIfAlpha(final View view, final Animation obj) {
        if (view == null || obj == null || !shouldRunOnHWLayer(view, obj)) {
            return;
        }
        Animation$AnimationListener animation$AnimationListener = null;
        while (true) {
            try {
                if (FragmentManagerImpl.sAnimationListenerField == null) {
                    (FragmentManagerImpl.sAnimationListenerField = Animation.class.getDeclaredField("mListener")).setAccessible(true);
                }
                animation$AnimationListener = (Animation$AnimationListener)FragmentManagerImpl.sAnimationListenerField.get(obj);
                ViewCompat.setLayerType(view, 2, null);
                obj.setAnimationListener((Animation$AnimationListener)new AnimateOnHWLayerIfNeededListener(view, obj, animation$AnimationListener));
            }
            catch (NoSuchFieldException ex) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", (Throwable)ex);
                continue;
            }
            catch (IllegalAccessException ex2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", (Throwable)ex2);
                continue;
            }
            break;
        }
    }
    
    static boolean shouldRunOnHWLayer(final View view, final Animation animation) {
        return Build$VERSION.SDK_INT >= 19 && ViewCompat.getLayerType(view) == 0 && ViewCompat.hasOverlappingRendering(view) && modifiesAlpha(animation);
    }
    
    private void throwException(final RuntimeException ex) {
        Log.e("FragmentManager", ex.getMessage());
        Log.e("FragmentManager", "Activity state:");
        final PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        while (true) {
            Label_0075: {
                if (this.mHost == null) {
                    break Label_0075;
                }
                try {
                    this.mHost.onDump("  ", null, printWriter, new String[0]);
                    throw ex;
                }
                catch (Exception ex2) {
                    Log.e("FragmentManager", "Failed dumping state", (Throwable)ex2);
                    throw ex;
                }
                try {
                    this.dump("  ", null, printWriter, new String[0]);
                    continue;
                }
                catch (Exception ex3) {
                    Log.e("FragmentManager", "Failed dumping state", (Throwable)ex3);
                    continue;
                }
            }
            continue;
        }
    }
    
    public static int transitToStyleIndex(final int n, final boolean b) {
        switch (n) {
            default: {
                return -1;
            }
            case 4097: {
                if (b) {
                    return 1;
                }
                return 2;
            }
            case 8194: {
                if (b) {
                    return 3;
                }
                return 4;
            }
            case 4099: {
                if (b) {
                    return 5;
                }
                return 6;
            }
        }
    }
    
    void addBackStackState(final BackStackRecord e) {
        if (this.mBackStack == null) {
            this.mBackStack = new ArrayList<BackStackRecord>();
        }
        this.mBackStack.add(e);
        this.reportBackStackChanged();
    }
    
    public void addFragment(final Fragment fragment, final boolean b) {
        if (this.mAdded == null) {
            this.mAdded = new ArrayList<Fragment>();
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        this.makeActive(fragment);
        if (!fragment.mDetached) {
            if (this.mAdded.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.mAdded.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            if (b) {
                this.moveToState(fragment);
            }
        }
    }
    
    @Override
    public void addOnBackStackChangedListener(final OnBackStackChangedListener e) {
        if (this.mBackStackChangeListeners == null) {
            this.mBackStackChangeListeners = new ArrayList<OnBackStackChangedListener>();
        }
        this.mBackStackChangeListeners.add(e);
    }
    
    public int allocBackStackIndex(final BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mAvailBackStackIndices == null || this.mAvailBackStackIndices.size() <= 0) {
                if (this.mBackStackIndices == null) {
                    this.mBackStackIndices = new ArrayList<BackStackRecord>();
                }
                final int size = this.mBackStackIndices.size();
                if (FragmentManagerImpl.DEBUG) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + backStackRecord);
                }
                this.mBackStackIndices.add(backStackRecord);
                return size;
            }
            final int intValue = this.mAvailBackStackIndices.remove(this.mAvailBackStackIndices.size() - 1);
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + backStackRecord);
            }
            this.mBackStackIndices.set(intValue, backStackRecord);
            return intValue;
        }
    }
    
    public void attachController(final FragmentHostCallback mHost, final FragmentContainer mContainer, final Fragment mParent) {
        if (this.mHost != null) {
            throw new IllegalStateException("Already attached");
        }
        this.mHost = mHost;
        this.mContainer = mContainer;
        this.mParent = mParent;
    }
    
    public void attachFragment(final Fragment e) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "attach: " + e);
        }
        if (e.mDetached) {
            e.mDetached = false;
            if (!e.mAdded) {
                if (this.mAdded == null) {
                    this.mAdded = new ArrayList<Fragment>();
                }
                if (this.mAdded.contains(e)) {
                    throw new IllegalStateException("Fragment already added: " + e);
                }
                if (FragmentManagerImpl.DEBUG) {
                    Log.v("FragmentManager", "add from attach: " + e);
                }
                this.mAdded.add(e);
                e.mAdded = true;
                if (e.mHasMenu && e.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }
    
    @Override
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }
    
    void completeShowHideFragment(final Fragment fragment) {
        if (fragment.mView != null) {
            final Animation loadAnimation = this.loadAnimation(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (loadAnimation != null) {
                this.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                fragment.mView.startAnimation(loadAnimation);
                this.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                loadAnimation.start();
            }
            int visibility;
            if (fragment.mHidden && !fragment.isHideReplaced()) {
                visibility = 8;
            }
            else {
                visibility = 0;
            }
            fragment.mView.setVisibility(visibility);
            if (fragment.isHideReplaced()) {
                fragment.setHideReplaced(false);
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.mNeedMenuInvalidate = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }
    
    public void detachFragment(final Fragment o) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "detach: " + o);
        }
        if (!o.mDetached) {
            o.mDetached = true;
            if (o.mAdded) {
                if (this.mAdded != null) {
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "remove from detach: " + o);
                    }
                    this.mAdded.remove(o);
                }
                if (o.mHasMenu && o.mMenuVisible) {
                    this.mNeedMenuInvalidate = true;
                }
                o.mAdded = false;
            }
        }
    }
    
    public void dispatchActivityCreated() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(2, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchConfigurationChanged(final Configuration configuration) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                }
            }
        }
    }
    
    public boolean dispatchContextItemSelected(final MenuItem menuItem) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void dispatchCreate() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(1, false);
        this.mExecutingActions = false;
    }
    
    public boolean dispatchCreateOptionsMenu(final Menu menu, final MenuInflater menuInflater) {
        boolean b = false;
        boolean b2 = false;
        ArrayList<Fragment> mCreatedMenus = null;
        ArrayList<Fragment> list = null;
        if (this.mAdded != null) {
            int index = 0;
            while (true) {
                mCreatedMenus = list;
                b = b2;
                if (index >= this.mAdded.size()) {
                    break;
                }
                final Fragment e = this.mAdded.get(index);
                ArrayList<Fragment> list2 = list;
                boolean b3 = b2;
                if (e != null) {
                    list2 = list;
                    b3 = b2;
                    if (e.performCreateOptionsMenu(menu, menuInflater)) {
                        b3 = true;
                        if ((list2 = list) == null) {
                            list2 = new ArrayList<Fragment>();
                        }
                        list2.add(e);
                    }
                }
                ++index;
                list = list2;
                b2 = b3;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i = 0; i < this.mCreatedMenus.size(); ++i) {
                final Fragment o = this.mCreatedMenus.get(i);
                if (mCreatedMenus == null || !mCreatedMenus.contains(o)) {
                    o.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = mCreatedMenus;
        return b;
    }
    
    public void dispatchDestroy() {
        this.mDestroyed = true;
        this.execPendingActions();
        this.mExecutingActions = true;
        this.moveToState(0, false);
        this.mExecutingActions = false;
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
    }
    
    public void dispatchDestroyView() {
        this.mExecutingActions = true;
        this.moveToState(1, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchLowMemory() {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performLowMemory();
                }
            }
        }
    }
    
    public void dispatchMultiWindowModeChanged(final boolean b) {
        if (this.mAdded != null) {
            for (int i = this.mAdded.size() - 1; i >= 0; --i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performMultiWindowModeChanged(b);
                }
            }
        }
    }
    
    void dispatchOnFragmentActivityCreated(final Fragment fragment, final Bundle bundle, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentActivityCreated(fragment, bundle, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentActivityCreated(this, fragment, bundle);
                }
            }
        }
    }
    
    void dispatchOnFragmentAttached(final Fragment fragment, final Context context, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentAttached(fragment, context, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentAttached(this, fragment, context);
                }
            }
        }
    }
    
    void dispatchOnFragmentCreated(final Fragment fragment, final Bundle bundle, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentCreated(fragment, bundle, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentCreated(this, fragment, bundle);
                }
            }
        }
    }
    
    void dispatchOnFragmentDestroyed(final Fragment fragment, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentDestroyed(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentDestroyed(this, fragment);
                }
            }
        }
    }
    
    void dispatchOnFragmentDetached(final Fragment fragment, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentDetached(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentDetached(this, fragment);
                }
            }
        }
    }
    
    void dispatchOnFragmentPaused(final Fragment fragment, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPaused(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentPaused(this, fragment);
                }
            }
        }
    }
    
    void dispatchOnFragmentPreAttached(final Fragment fragment, final Context context, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentPreAttached(fragment, context, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentPreAttached(this, fragment, context);
                }
            }
        }
    }
    
    void dispatchOnFragmentResumed(final Fragment fragment, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentResumed(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentResumed(this, fragment);
                }
            }
        }
    }
    
    void dispatchOnFragmentSaveInstanceState(final Fragment fragment, final Bundle bundle, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentSaveInstanceState(fragment, bundle, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentSaveInstanceState(this, fragment, bundle);
                }
            }
        }
    }
    
    void dispatchOnFragmentStarted(final Fragment fragment, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentStarted(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentStarted(this, fragment);
                }
            }
        }
    }
    
    void dispatchOnFragmentStopped(final Fragment fragment, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentStopped(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentStopped(this, fragment);
                }
            }
        }
    }
    
    void dispatchOnFragmentViewCreated(final Fragment fragment, final View view, final Bundle bundle, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentViewCreated(fragment, view, bundle, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentViewCreated(this, fragment, view, bundle);
                }
            }
        }
    }
    
    void dispatchOnFragmentViewDestroyed(final Fragment fragment, final boolean b) {
        if (this.mParent != null) {
            final FragmentManager fragmentManager = this.mParent.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl)fragmentManager).dispatchOnFragmentViewDestroyed(fragment, true);
            }
        }
        if (this.mLifecycleCallbacks != null) {
            for (final Pair<FragmentLifecycleCallbacks, Boolean> pair : this.mLifecycleCallbacks) {
                if (!b || pair.second) {
                    pair.first.onFragmentViewDestroyed(this, fragment);
                }
            }
        }
    }
    
    public boolean dispatchOptionsItemSelected(final MenuItem menuItem) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void dispatchOptionsMenuClosed(final Menu menu) {
        if (this.mAdded != null) {
            for (int i = 0; i < this.mAdded.size(); ++i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }
    
    public void dispatchPause() {
        this.mExecutingActions = true;
        this.moveToState(4, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchPictureInPictureModeChanged(final boolean b) {
        if (this.mAdded != null) {
            for (int i = this.mAdded.size() - 1; i >= 0; --i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null) {
                    fragment.performPictureInPictureModeChanged(b);
                }
            }
        }
    }
    
    public boolean dispatchPrepareOptionsMenu(final Menu menu) {
        boolean b = false;
        boolean b2 = false;
        if (this.mAdded != null) {
            int index = 0;
            while (true) {
                b = b2;
                if (index >= this.mAdded.size()) {
                    break;
                }
                final Fragment fragment = this.mAdded.get(index);
                boolean b3 = b2;
                if (fragment != null) {
                    b3 = b2;
                    if (fragment.performPrepareOptionsMenu(menu)) {
                        b3 = true;
                    }
                }
                ++index;
                b2 = b3;
            }
        }
        return b;
    }
    
    public void dispatchReallyStop() {
        this.mExecutingActions = true;
        this.moveToState(2, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchResume() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(5, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchStart() {
        this.mStateSaved = false;
        this.mExecutingActions = true;
        this.moveToState(4, false);
        this.mExecutingActions = false;
    }
    
    public void dispatchStop() {
        this.mStateSaved = true;
        this.mExecutingActions = true;
        this.moveToState(3, false);
        this.mExecutingActions = false;
    }
    
    void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            int n = 0;
            boolean b;
            for (int i = 0; i < this.mActive.size(); ++i, n = (b ? 1 : 0)) {
                final Fragment fragment = this.mActive.get(i);
                b = (n != 0);
                if (fragment != null) {
                    b = (n != 0);
                    if (fragment.mLoaderManager != null) {
                        b = ((n | (fragment.mLoaderManager.hasRunningLoaders() ? 1 : 0)) != 0x0);
                    }
                }
            }
            if (n == 0) {
                this.mHavePendingDeferredStart = false;
                this.startPendingDeferredFragments();
            }
        }
    }
    
    @Override
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        final String string = s + "    ";
        if (this.mActive != null) {
            final int size = this.mActive.size();
            if (size > 0) {
                printWriter.print(s);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (int i = 0; i < size; ++i) {
                    final Fragment x = this.mActive.get(i);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(x);
                    if (x != null) {
                        x.dump(string, fileDescriptor, printWriter, array);
                    }
                }
            }
        }
        if (this.mAdded != null) {
            final int size2 = this.mAdded.size();
            if (size2 > 0) {
                printWriter.print(s);
                printWriter.println("Added Fragments:");
                for (int j = 0; j < size2; ++j) {
                    final Fragment fragment = this.mAdded.get(j);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(j);
                    printWriter.print(": ");
                    printWriter.println(fragment.toString());
                }
            }
        }
        if (this.mCreatedMenus != null) {
            final int size3 = this.mCreatedMenus.size();
            if (size3 > 0) {
                printWriter.print(s);
                printWriter.println("Fragments Created Menus:");
                for (int k = 0; k < size3; ++k) {
                    final Fragment fragment2 = this.mCreatedMenus.get(k);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(k);
                    printWriter.print(": ");
                    printWriter.println(fragment2.toString());
                }
            }
        }
        if (this.mBackStack != null) {
            final int size4 = this.mBackStack.size();
            if (size4 > 0) {
                printWriter.print(s);
                printWriter.println("Back Stack:");
                for (int l = 0; l < size4; ++l) {
                    final BackStackRecord backStackRecord = this.mBackStack.get(l);
                    printWriter.print(s);
                    printWriter.print("  #");
                    printWriter.print(l);
                    printWriter.print(": ");
                    printWriter.println(backStackRecord.toString());
                    backStackRecord.dump(string, fileDescriptor, printWriter, array);
                }
            }
        }
        synchronized (this) {
            if (this.mBackStackIndices != null) {
                final int size5 = this.mBackStackIndices.size();
                if (size5 > 0) {
                    printWriter.print(s);
                    printWriter.println("Back Stack Indices:");
                    for (int n = 0; n < size5; ++n) {
                        final BackStackRecord x2 = this.mBackStackIndices.get(n);
                        printWriter.print(s);
                        printWriter.print("  #");
                        printWriter.print(n);
                        printWriter.print(": ");
                        printWriter.println(x2);
                    }
                }
            }
            if (this.mAvailBackStackIndices != null && this.mAvailBackStackIndices.size() > 0) {
                printWriter.print(s);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.mAvailBackStackIndices.toArray()));
            }
            // monitorexit(this)
            if (this.mPendingActions != null) {
                final int size6 = this.mPendingActions.size();
                if (size6 > 0) {
                    printWriter.print(s);
                    printWriter.println("Pending Actions:");
                    for (int n2 = 0; n2 < size6; ++n2) {
                        final OpGenerator x3 = this.mPendingActions.get(n2);
                        printWriter.print(s);
                        printWriter.print("  #");
                        printWriter.print(n2);
                        printWriter.print(": ");
                        printWriter.println(x3);
                    }
                }
            }
        }
        final String s2;
        printWriter.print(s2);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(s2);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(s2);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(s2);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(s2);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(s2);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
        if (this.mNoTransactionsBecause != null) {
            printWriter.print(s2);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.mNoTransactionsBecause);
        }
        if (this.mAvailIndices != null && this.mAvailIndices.size() > 0) {
            printWriter.print(s2);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.mAvailIndices.toArray()));
        }
    }
    
    public void enqueueAction(final OpGenerator opGenerator, final boolean b) {
        if (!b) {
            this.checkStateLoss();
        }
        synchronized (this) {
            if (this.mDestroyed || this.mHost == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
        if (this.mPendingActions == null) {
            this.mPendingActions = new ArrayList<OpGenerator>();
        }
        final OpGenerator e;
        this.mPendingActions.add(e);
        this.scheduleCommit();
    }
    // monitorexit(this)
    
    public boolean execPendingActions() {
        this.ensureExecReady(true);
        boolean b = false;
        while (this.generateOpsForPendingActions(this.mTmpRecords, this.mTmpIsPop)) {
            this.mExecutingActions = true;
            try {
                this.optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
                this.cleanupExec();
                b = true;
                continue;
            }
            finally {
                this.cleanupExec();
            }
            break;
        }
        this.doPendingDeferredStart();
        return b;
    }
    
    public void execSingleAction(final OpGenerator opGenerator, final boolean b) {
        this.ensureExecReady(b);
        Label_0043: {
            if (!opGenerator.generateOps(this.mTmpRecords, this.mTmpIsPop)) {
                break Label_0043;
            }
            this.mExecutingActions = true;
            try {
                this.optimizeAndExecuteOps(this.mTmpRecords, this.mTmpIsPop);
                this.cleanupExec();
                this.doPendingDeferredStart();
            }
            finally {
                this.cleanupExec();
            }
        }
    }
    
    @Override
    public boolean executePendingTransactions() {
        final boolean execPendingActions = this.execPendingActions();
        this.forcePostponedTransactions();
        return execPendingActions;
    }
    
    @Override
    public Fragment findFragmentById(final int n) {
        if (this.mAdded != null) {
            for (int i = this.mAdded.size() - 1; i >= 0; --i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null && fragment.mFragmentId == n) {
                    return fragment;
                }
            }
        }
        Label_0054: {
            break Label_0054;
        }
        if (this.mActive != null) {
            for (int j = this.mActive.size() - 1; j >= 0; --j) {
                final Fragment fragment2 = this.mActive.get(j);
                if (fragment2 != null) {
                    final Fragment fragment = fragment2;
                    if (fragment2.mFragmentId == n) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    public Fragment findFragmentByTag(final String s) {
        if (this.mAdded != null && s != null) {
            for (int i = this.mAdded.size() - 1; i >= 0; --i) {
                final Fragment fragment = this.mAdded.get(i);
                if (fragment != null && s.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        Label_0061: {
            break Label_0061;
        }
        if (this.mActive != null && s != null) {
            for (int j = this.mActive.size() - 1; j >= 0; --j) {
                final Fragment fragment2 = this.mActive.get(j);
                if (fragment2 != null) {
                    final Fragment fragment = fragment2;
                    if (s.equals(fragment2.mTag)) {
                        return fragment;
                    }
                }
            }
        }
        return null;
    }
    
    public Fragment findFragmentByWho(final String s) {
        if (this.mActive != null && s != null) {
            for (int i = this.mActive.size() - 1; i >= 0; --i) {
                final Fragment fragment = this.mActive.get(i);
                if (fragment != null) {
                    final Fragment fragmentByWho = fragment.findFragmentByWho(s);
                    if (fragmentByWho != null) {
                        return fragmentByWho;
                    }
                }
            }
        }
        return null;
    }
    
    public void freeBackStackIndex(final int i) {
        synchronized (this) {
            this.mBackStackIndices.set(i, null);
            if (this.mAvailBackStackIndices == null) {
                this.mAvailBackStackIndices = new ArrayList<Integer>();
            }
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.mAvailBackStackIndices.add(i);
        }
    }
    
    @Override
    public BackStackEntry getBackStackEntryAt(final int index) {
        return this.mBackStack.get(index);
    }
    
    @Override
    public int getBackStackEntryCount() {
        if (this.mBackStack != null) {
            return this.mBackStack.size();
        }
        return 0;
    }
    
    @Override
    public Fragment getFragment(final Bundle bundle, final String s) {
        final int int1 = bundle.getInt(s, -1);
        Fragment fragment;
        if (int1 == -1) {
            fragment = null;
        }
        else {
            if (int1 >= this.mActive.size()) {
                this.throwException(new IllegalStateException("Fragment no longer exists for key " + s + ": index " + int1));
            }
            final Fragment fragment2 = this.mActive.get(int1);
            if ((fragment = fragment2) == null) {
                this.throwException(new IllegalStateException("Fragment no longer exists for key " + s + ": index " + int1));
                return fragment2;
            }
        }
        return fragment;
    }
    
    @Override
    public List<Fragment> getFragments() {
        return this.mActive;
    }
    
    LayoutInflaterFactory getLayoutInflaterFactory() {
        return this;
    }
    
    public void hideFragment(final Fragment obj) {
        boolean mHiddenChanged = true;
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "hide: " + obj);
        }
        if (!obj.mHidden) {
            obj.mHidden = true;
            if (obj.mHiddenChanged) {
                mHiddenChanged = false;
            }
            obj.mHiddenChanged = mHiddenChanged;
        }
    }
    
    @Override
    public boolean isDestroyed() {
        return this.mDestroyed;
    }
    
    boolean isStateAtLeast(final int n) {
        return this.mCurState >= n;
    }
    
    Animation loadAnimation(final Fragment fragment, int n, final boolean b, final int n2) {
        final Animation onCreateAnimation = fragment.onCreateAnimation(n, b, fragment.getNextAnim());
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (fragment.getNextAnim() != 0) {
            final Animation loadAnimation = AnimationUtils.loadAnimation(this.mHost.getContext(), fragment.getNextAnim());
            if (loadAnimation != null) {
                return loadAnimation;
            }
        }
        if (n == 0) {
            return null;
        }
        n = transitToStyleIndex(n, b);
        if (n < 0) {
            return null;
        }
        switch (n) {
            default: {
                n = n2;
                if (n2 == 0) {
                    n = n2;
                    if (this.mHost.onHasWindowAnimations()) {
                        n = this.mHost.onGetWindowAnimations();
                    }
                }
                if (n == 0) {
                    return null;
                }
                return null;
            }
            case 1: {
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.125f, 1.0f, 0.0f, 1.0f);
            }
            case 2: {
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.0f, 0.975f, 1.0f, 0.0f);
            }
            case 3: {
                return makeOpenCloseAnimation(this.mHost.getContext(), 0.975f, 1.0f, 0.0f, 1.0f);
            }
            case 4: {
                return makeOpenCloseAnimation(this.mHost.getContext(), 1.0f, 1.075f, 1.0f, 0.0f);
            }
            case 5: {
                return makeFadeAnimation(this.mHost.getContext(), 0.0f, 1.0f);
            }
            case 6: {
                return makeFadeAnimation(this.mHost.getContext(), 1.0f, 0.0f);
            }
        }
    }
    
    void makeActive(final Fragment obj) {
        if (obj.mIndex < 0) {
            if (this.mAvailIndices == null || this.mAvailIndices.size() <= 0) {
                if (this.mActive == null) {
                    this.mActive = new ArrayList<Fragment>();
                }
                obj.setIndex(this.mActive.size(), this.mParent);
                this.mActive.add(obj);
            }
            else {
                obj.setIndex(this.mAvailIndices.remove(this.mAvailIndices.size() - 1), this.mParent);
                this.mActive.set(obj.mIndex, obj);
            }
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Allocated fragment index " + obj);
            }
        }
    }
    
    void makeInactive(final Fragment obj) {
        if (obj.mIndex < 0) {
            return;
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Freeing fragment index " + obj);
        }
        this.mActive.set(obj.mIndex, null);
        if (this.mAvailIndices == null) {
            this.mAvailIndices = new ArrayList<Integer>();
        }
        this.mAvailIndices.add(obj.mIndex);
        this.mHost.inactivateFragment(obj.mWho);
        obj.initState();
    }
    
    void moveFragmentToExpectedState(final Fragment fragment) {
        if (fragment != null) {
            int n2;
            final int n = n2 = this.mCurState;
            if (fragment.mRemoving) {
                if (fragment.isInBackStack()) {
                    n2 = Math.min(n, 1);
                }
                else {
                    n2 = Math.min(n, 0);
                }
            }
            this.moveToState(fragment, n2, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            if (fragment.mView != null) {
                final Fragment fragmentUnder = this.findFragmentUnder(fragment);
                if (fragmentUnder != null) {
                    final View mView = fragmentUnder.mView;
                    final ViewGroup mContainer = fragment.mContainer;
                    final int indexOfChild = mContainer.indexOfChild(mView);
                    final int indexOfChild2 = mContainer.indexOfChild(fragment.mView);
                    if (indexOfChild2 < indexOfChild) {
                        mContainer.removeViewAt(indexOfChild2);
                        mContainer.addView(fragment.mView, indexOfChild);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    if (Build$VERSION.SDK_INT < 11) {
                        fragment.mView.setVisibility(0);
                    }
                    else if (fragment.mPostponedAlpha > 0.0f) {
                        fragment.mView.setAlpha(fragment.mPostponedAlpha);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    final Animation loadAnimation = this.loadAnimation(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (loadAnimation != null) {
                        this.setHWLayerAnimListenerIfAlpha(fragment.mView, loadAnimation);
                        fragment.mView.startAnimation(loadAnimation);
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                this.completeShowHideFragment(fragment);
            }
        }
    }
    
    void moveToState(int i, final boolean b) {
        if (this.mHost == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (b || i != this.mCurState) {
            this.mCurState = i;
            if (this.mActive != null) {
                i = 0;
                int n = 0;
                if (this.mAdded != null) {
                    final int size = this.mAdded.size();
                    int index = 0;
                    while (true) {
                        i = n;
                        if (index >= size) {
                            break;
                        }
                        final Fragment fragment = this.mAdded.get(index);
                        this.moveFragmentToExpectedState(fragment);
                        i = n;
                        if (fragment.mLoaderManager != null) {
                            i = (n | (fragment.mLoaderManager.hasRunningLoaders() ? 1 : 0));
                        }
                        ++index;
                        n = i;
                    }
                }
                final int size2 = this.mActive.size();
                final int n2 = 0;
                int n3 = i;
                Fragment fragment2;
                boolean b2;
                for (i = n2; i < size2; ++i, n3 = (b2 ? 1 : 0)) {
                    fragment2 = this.mActive.get(i);
                    b2 = (n3 != 0);
                    if (fragment2 != null) {
                        if (!fragment2.mRemoving) {
                            b2 = (n3 != 0);
                            if (!fragment2.mDetached) {
                                continue;
                            }
                        }
                        b2 = (n3 != 0);
                        if (!fragment2.mIsNewlyAdded) {
                            this.moveFragmentToExpectedState(fragment2);
                            b2 = (n3 != 0);
                            if (fragment2.mLoaderManager != null) {
                                b2 = ((n3 | (fragment2.mLoaderManager.hasRunningLoaders() ? 1 : 0)) != 0x0);
                            }
                        }
                    }
                }
                if (n3 == 0) {
                    this.startPendingDeferredFragments();
                }
                if (this.mNeedMenuInvalidate && this.mHost != null && this.mCurState == 5) {
                    this.mHost.onSupportInvalidateOptionsMenu();
                    this.mNeedMenuInvalidate = false;
                }
            }
        }
    }
    
    void moveToState(final Fragment fragment) {
        this.moveToState(fragment, this.mCurState, 0, 0, false);
    }
    
    void moveToState(final Fragment obj, int n, int n2, int n3, final boolean b) {
        int n4 = 0;
        Label_0028: {
            if (obj.mAdded) {
                n4 = n;
                if (!obj.mDetached) {
                    break Label_0028;
                }
            }
            if ((n4 = n) > 1) {
                n4 = 1;
            }
        }
        int mState = n4;
        if (obj.mRemoving && (mState = n4) > obj.mState) {
            mState = obj.mState;
        }
        n = mState;
        if (obj.mDeferStart) {
            n = mState;
            if (obj.mState < 4 && (n = mState) > 3) {
                n = 3;
            }
        }
        int n7 = 0;
        Label_0191: {
            if (obj.mState < n) {
                if (!obj.mFromLayout || obj.mInLayout) {
                    if (obj.getAnimatingAway() != null) {
                        obj.setAnimatingAway(null);
                        this.moveToState(obj, obj.getStateAfterAnimating(), 0, 0, true);
                    }
                    n2 = n;
                    int n5 = n;
                    int n6 = n;
                    n3 = n;
                    FragmentManagerImpl mFragmentManager;
                    ViewGroup mContainer;
                    ViewGroup viewGroup;
                    String resourceName;
                    boolean mIsNewlyAdded;
                    Label_0695:Label_1245_Outer:Label_1261_Outer:
                    while (true) {
                        Label_0650: {
                        Label_1275_Outer:
                            while (true) {
                                while (true) {
                                    Label_0583: {
                                        while (true) {
                                            Label_1049:Label_1109_Outer:
                                            while (true) {
                                            Label_1165_Outer:
                                                while (true) {
                                                    while (true) {
                                                        switch (obj.mState) {
                                                            default: {
                                                                n7 = n;
                                                                break Label_0191;
                                                            }
                                                            case 0: {
                                                                if (FragmentManagerImpl.DEBUG) {
                                                                    Log.v("FragmentManager", "moveto CREATED: " + obj);
                                                                }
                                                                n3 = n;
                                                                if (obj.mSavedFragmentState != null) {
                                                                    obj.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                                                                    obj.mSavedViewState = (SparseArray<Parcelable>)obj.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                                                                    obj.mTarget = this.getFragment(obj.mSavedFragmentState, "android:target_state");
                                                                    if (obj.mTarget != null) {
                                                                        obj.mTargetRequestCode = obj.mSavedFragmentState.getInt("android:target_req_state", 0);
                                                                    }
                                                                    obj.mUserVisibleHint = obj.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
                                                                    n3 = n;
                                                                    if (!obj.mUserVisibleHint) {
                                                                        obj.mDeferStart = true;
                                                                        if ((n3 = n) > 3) {
                                                                            n3 = 3;
                                                                        }
                                                                    }
                                                                }
                                                                obj.mHost = this.mHost;
                                                                obj.mParentFragment = this.mParent;
                                                                if (this.mParent != null) {
                                                                    mFragmentManager = this.mParent.mChildFragmentManager;
                                                                }
                                                                else {
                                                                    mFragmentManager = this.mHost.getFragmentManagerImpl();
                                                                }
                                                                obj.mFragmentManager = mFragmentManager;
                                                                this.dispatchOnFragmentPreAttached(obj, this.mHost.getContext(), false);
                                                                obj.mCalled = false;
                                                                obj.onAttach(this.mHost.getContext());
                                                                if (!obj.mCalled) {
                                                                    throw new SuperNotCalledException("Fragment " + obj + " did not call through to super.onAttach()");
                                                                }
                                                                if (obj.mParentFragment == null) {
                                                                    this.mHost.onAttachFragment(obj);
                                                                    break;
                                                                }
                                                                break Label_1049;
                                                            }
                                                            case 1: {
                                                                if ((n5 = n2) <= 1) {
                                                                    break Label_1049;
                                                                }
                                                                if (FragmentManagerImpl.DEBUG) {
                                                                    Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + obj);
                                                                }
                                                                if (obj.mFromLayout) {
                                                                    break Label_1049;
                                                                }
                                                                mContainer = null;
                                                                if (obj.mContainerId == 0) {
                                                                    break Label_1165_Outer;
                                                                }
                                                                if (obj.mContainerId == -1) {
                                                                    this.throwException(new IllegalArgumentException("Cannot create fragment " + obj + " for a container view with no id"));
                                                                }
                                                                viewGroup = (ViewGroup)this.mContainer.onFindViewById(obj.mContainerId);
                                                                if ((mContainer = viewGroup) != null) {
                                                                    break Label_1165_Outer;
                                                                }
                                                                mContainer = viewGroup;
                                                                if (!obj.mRestored) {
                                                                    break Label_1165_Outer;
                                                                }
                                                                break Label_1165_Outer;
                                                            }
                                                            case 2: {
                                                                break Label_1049;
                                                                Label_0967_Outer:Label_1043_Outer:
                                                                while (true) {
                                                                    Label_1316: {
                                                                        while (true) {
                                                                        Label_1310:
                                                                            while (true) {
                                                                            Label_1296:
                                                                                while (true) {
                                                                                    try {
                                                                                        resourceName = obj.getResources().getResourceName(obj.mContainerId);
                                                                                        this.throwException(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(obj.mContainerId) + " (" + resourceName + ") for fragment " + obj));
                                                                                        mContainer = viewGroup;
                                                                                        obj.mContainer = mContainer;
                                                                                        obj.mView = obj.performCreateView(obj.getLayoutInflater(obj.mSavedFragmentState), mContainer, obj.mSavedFragmentState);
                                                                                        if (obj.mView == null) {
                                                                                            break Label_1316;
                                                                                        }
                                                                                        obj.mInnerView = obj.mView;
                                                                                        if (Build$VERSION.SDK_INT < 11) {
                                                                                            break Label_1296;
                                                                                        }
                                                                                        ViewCompat.setSaveFromParentEnabled(obj.mView, false);
                                                                                        if (mContainer != null) {
                                                                                            mContainer.addView(obj.mView);
                                                                                        }
                                                                                        if (obj.mHidden) {
                                                                                            obj.mView.setVisibility(8);
                                                                                        }
                                                                                        obj.onViewCreated(obj.mView, obj.mSavedFragmentState);
                                                                                        this.dispatchOnFragmentViewCreated(obj, obj.mView, obj.mSavedFragmentState, false);
                                                                                        if (obj.mView.getVisibility() != 0 || obj.mContainer == null) {
                                                                                            break Label_1310;
                                                                                        }
                                                                                        mIsNewlyAdded = true;
                                                                                        obj.mIsNewlyAdded = mIsNewlyAdded;
                                                                                        obj.performActivityCreated(obj.mSavedFragmentState);
                                                                                        this.dispatchOnFragmentActivityCreated(obj, obj.mSavedFragmentState, false);
                                                                                        if (obj.mView != null) {
                                                                                            obj.restoreViewState(obj.mSavedFragmentState);
                                                                                        }
                                                                                        obj.mSavedFragmentState = null;
                                                                                        n5 = n2;
                                                                                        if ((n6 = n5) > 2) {
                                                                                            obj.mState = 3;
                                                                                            n6 = n5;
                                                                                        }
                                                                                        if ((n3 = n6) > 3) {
                                                                                            if (FragmentManagerImpl.DEBUG) {
                                                                                                Log.v("FragmentManager", "moveto STARTED: " + obj);
                                                                                            }
                                                                                            obj.performStart();
                                                                                            this.dispatchOnFragmentStarted(obj, false);
                                                                                            n3 = n6;
                                                                                        }
                                                                                        if ((n7 = n3) > 4) {
                                                                                            if (FragmentManagerImpl.DEBUG) {
                                                                                                Log.v("FragmentManager", "moveto RESUMED: " + obj);
                                                                                            }
                                                                                            obj.performResume();
                                                                                            this.dispatchOnFragmentResumed(obj, false);
                                                                                            obj.mSavedFragmentState = null;
                                                                                            obj.mSavedViewState = null;
                                                                                            n7 = n3;
                                                                                        }
                                                                                        break Label_0191;
                                                                                        obj.restoreChildFragmentState(obj.mSavedFragmentState);
                                                                                        obj.mState = 1;
                                                                                        break Label_0583;
                                                                                        obj.mParentFragment.onAttachFragment(obj);
                                                                                        break Label_1049;
                                                                                        obj.mView = (View)NoSaveStateFrameLayout.wrap(obj.mView);
                                                                                        break Label_0650;
                                                                                        obj.mInnerView = null;
                                                                                        n2 = n3;
                                                                                        continue Label_0695;
                                                                                    }
                                                                                    catch (Resources$NotFoundException ex) {
                                                                                        resourceName = "unknown";
                                                                                        continue Label_0967_Outer;
                                                                                    }
                                                                                    break;
                                                                                }
                                                                                obj.mView = (View)NoSaveStateFrameLayout.wrap(obj.mView);
                                                                                continue Label_1043_Outer;
                                                                            }
                                                                            mIsNewlyAdded = false;
                                                                            continue Label_1109_Outer;
                                                                        }
                                                                    }
                                                                    obj.mInnerView = null;
                                                                    continue Label_1049;
                                                                }
                                                                break;
                                                            }
                                                            case 3: {
                                                                continue Label_1165_Outer;
                                                            }
                                                            case 4: {
                                                                continue Label_1245_Outer;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    break;
                                                }
                                                break;
                                            }
                                            this.dispatchOnFragmentAttached(obj, this.mHost.getContext(), false);
                                            if (obj.mRetaining) {
                                                continue Label_1261_Outer;
                                            }
                                            break;
                                        }
                                        obj.performCreate(obj.mSavedFragmentState);
                                        this.dispatchOnFragmentCreated(obj, obj.mSavedFragmentState, false);
                                    }
                                    obj.mRetaining = false;
                                    n2 = n3;
                                    if (!obj.mFromLayout) {
                                        continue Label_0695;
                                    }
                                    obj.mView = obj.performCreateView(obj.getLayoutInflater(obj.mSavedFragmentState), null, obj.mSavedFragmentState);
                                    if (obj.mView == null) {
                                        continue;
                                    }
                                    break;
                                }
                                obj.mInnerView = obj.mView;
                                if (Build$VERSION.SDK_INT < 11) {
                                    continue Label_1275_Outer;
                                }
                                break;
                            }
                            ViewCompat.setSaveFromParentEnabled(obj.mView, false);
                        }
                        if (obj.mHidden) {
                            obj.mView.setVisibility(8);
                        }
                        obj.onViewCreated(obj.mView, obj.mSavedFragmentState);
                        this.dispatchOnFragmentViewCreated(obj, obj.mView, obj.mSavedFragmentState, false);
                        n2 = n3;
                        continue Label_0695;
                    }
                }
            }
            else {
                if (obj.mState <= (n7 = n)) {
                    break Label_0191;
                }
                switch (obj.mState) {
                    default: {
                        n7 = n;
                        break Label_0191;
                    }
                    case 3: {
                        if (n < 3) {
                            if (FragmentManagerImpl.DEBUG) {
                                Log.v("FragmentManager", "movefrom STOPPED: " + obj);
                            }
                            obj.performReallyStop();
                        }
                    }
                    case 2: {
                        if (n < 2) {
                            if (FragmentManagerImpl.DEBUG) {
                                Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + obj);
                            }
                            if (obj.mView != null && this.mHost.onShouldSaveFragmentState(obj) && obj.mSavedViewState == null) {
                                this.saveFragmentViewState(obj);
                            }
                            obj.performDestroyView();
                            this.dispatchOnFragmentViewDestroyed(obj, false);
                            if (obj.mView != null && obj.mContainer != null) {
                                Animation loadAnimation;
                                final Animation animation = loadAnimation = null;
                                if (this.mCurState > 0) {
                                    loadAnimation = animation;
                                    if (!this.mDestroyed) {
                                        loadAnimation = animation;
                                        if (obj.mView.getVisibility() == 0) {
                                            loadAnimation = animation;
                                            if (obj.mPostponedAlpha >= 0.0f) {
                                                loadAnimation = this.loadAnimation(obj, n2, false, n3);
                                            }
                                        }
                                    }
                                }
                                obj.mPostponedAlpha = 0.0f;
                                if (loadAnimation != null) {
                                    obj.setAnimatingAway(obj.mView);
                                    obj.setStateAfterAnimating(n);
                                    loadAnimation.setAnimationListener((Animation$AnimationListener)new AnimateOnHWLayerIfNeededListener(obj.mView, loadAnimation) {
                                        @Override
                                        public void onAnimationEnd(final Animation animation) {
                                            super.onAnimationEnd(animation);
                                            if (obj.getAnimatingAway() != null) {
                                                obj.setAnimatingAway(null);
                                                FragmentManagerImpl.this.moveToState(obj, obj.getStateAfterAnimating(), 0, 0, false);
                                            }
                                        }
                                    });
                                    obj.mView.startAnimation(loadAnimation);
                                }
                                obj.mContainer.removeView(obj.mView);
                            }
                            obj.mContainer = null;
                            obj.mView = null;
                            obj.mInnerView = null;
                        }
                    }
                    case 1: {
                        if ((n7 = n) >= 1) {
                            break Label_0191;
                        }
                        if (this.mDestroyed && obj.getAnimatingAway() != null) {
                            final View animatingAway = obj.getAnimatingAway();
                            obj.setAnimatingAway(null);
                            animatingAway.clearAnimation();
                        }
                        if (obj.getAnimatingAway() != null) {
                            obj.setStateAfterAnimating(n);
                            n7 = 1;
                            break Label_0191;
                        }
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v("FragmentManager", "movefrom CREATED: " + obj);
                        }
                        if (!obj.mRetaining) {
                            obj.performDestroy();
                            this.dispatchOnFragmentDestroyed(obj, false);
                        }
                        else {
                            obj.mState = 0;
                        }
                        obj.performDetach();
                        this.dispatchOnFragmentDetached(obj, false);
                        n7 = n;
                        if (b) {
                            break Label_0191;
                        }
                        if (!obj.mRetaining) {
                            this.makeInactive(obj);
                            n7 = n;
                            break Label_0191;
                        }
                        obj.mHost = null;
                        obj.mParentFragment = null;
                        obj.mFragmentManager = null;
                        n7 = n;
                        break Label_0191;
                    }
                    case 5: {
                        if (n < 5) {
                            if (FragmentManagerImpl.DEBUG) {
                                Log.v("FragmentManager", "movefrom RESUMED: " + obj);
                            }
                            obj.performPause();
                            this.dispatchOnFragmentPaused(obj, false);
                        }
                    }
                    case 4: {
                        if (n < 4) {
                            if (FragmentManagerImpl.DEBUG) {
                                Log.v("FragmentManager", "movefrom STARTED: " + obj);
                            }
                            obj.performStop();
                            this.dispatchOnFragmentStopped(obj, false);
                        }
                    }
                }
            }
            return;
        }
        if (obj.mState != n7) {
            Log.w("FragmentManager", "moveToState: Fragment state for " + obj + " not updated inline; " + "expected state " + n7 + " found " + obj.mState);
            obj.mState = n7;
        }
    }
    
    public void noteStateNotSaved() {
        this.mStateSaved = false;
    }
    
    @Override
    public View onCreateView(final View view, String attributeValue, final Context context, final AttributeSet set) {
        if ("fragment".equals(attributeValue)) {
            attributeValue = set.getAttributeValue((String)null, "class");
            final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, FragmentTag.Fragment);
            String string;
            if ((string = attributeValue) == null) {
                string = obtainStyledAttributes.getString(0);
            }
            final int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            final String string2 = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (Fragment.isSupportFragmentClass(this.mHost.getContext(), string)) {
                int id;
                if (view != null) {
                    id = view.getId();
                }
                else {
                    id = 0;
                }
                if (id == -1 && resourceId == -1 && string2 == null) {
                    throw new IllegalArgumentException(set.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
                }
                Fragment fragmentById;
                if (resourceId != -1) {
                    fragmentById = this.findFragmentById(resourceId);
                }
                else {
                    fragmentById = null;
                }
                Fragment fragmentByTag = fragmentById;
                if (fragmentById == null) {
                    fragmentByTag = fragmentById;
                    if (string2 != null) {
                        fragmentByTag = this.findFragmentByTag(string2);
                    }
                }
                Fragment fragmentById2;
                if ((fragmentById2 = fragmentByTag) == null) {
                    fragmentById2 = fragmentByTag;
                    if (id != -1) {
                        fragmentById2 = this.findFragmentById(id);
                    }
                }
                if (FragmentManagerImpl.DEBUG) {
                    Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + fragmentById2);
                }
                Fragment instantiate;
                if (fragmentById2 == null) {
                    instantiate = Fragment.instantiate(context, string);
                    instantiate.mFromLayout = true;
                    int mFragmentId;
                    if (resourceId != 0) {
                        mFragmentId = resourceId;
                    }
                    else {
                        mFragmentId = id;
                    }
                    instantiate.mFragmentId = mFragmentId;
                    instantiate.mContainerId = id;
                    instantiate.mTag = string2;
                    instantiate.mInLayout = true;
                    instantiate.mFragmentManager = this;
                    instantiate.mHost = this.mHost;
                    instantiate.onInflate(this.mHost.getContext(), set, instantiate.mSavedFragmentState);
                    this.addFragment(instantiate, true);
                }
                else {
                    if (fragmentById2.mInLayout) {
                        throw new IllegalArgumentException(set.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
                    }
                    fragmentById2.mInLayout = true;
                    fragmentById2.mHost = this.mHost;
                    instantiate = fragmentById2;
                    if (!fragmentById2.mRetaining) {
                        fragmentById2.onInflate(this.mHost.getContext(), set, fragmentById2.mSavedFragmentState);
                        instantiate = fragmentById2;
                    }
                }
                if (this.mCurState < 1 && instantiate.mFromLayout) {
                    this.moveToState(instantiate, 1, 0, 0, false);
                }
                else {
                    this.moveToState(instantiate);
                }
                if (instantiate.mView == null) {
                    throw new IllegalStateException("Fragment " + string + " did not create a view.");
                }
                if (resourceId != 0) {
                    instantiate.mView.setId(resourceId);
                }
                if (instantiate.mView.getTag() == null) {
                    instantiate.mView.setTag((Object)string2);
                }
                return instantiate.mView;
            }
        }
        return null;
    }
    
    public void performPendingDeferredStart(final Fragment fragment) {
        if (fragment.mDeferStart) {
            if (!this.mExecutingActions) {
                fragment.mDeferStart = false;
                this.moveToState(fragment, this.mCurState, 0, 0, false);
                return;
            }
            this.mHavePendingDeferredStart = true;
        }
    }
    
    @Override
    public void popBackStack() {
        this.enqueueAction((OpGenerator)new PopBackStackState(null, -1, 0), false);
    }
    
    @Override
    public void popBackStack(final int i, final int n) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        this.enqueueAction((OpGenerator)new PopBackStackState(null, i, n), false);
    }
    
    @Override
    public void popBackStack(final String s, final int n) {
        this.enqueueAction((OpGenerator)new PopBackStackState(s, -1, n), false);
    }
    
    @Override
    public boolean popBackStackImmediate() {
        this.checkStateLoss();
        return this.popBackStackImmediate(null, -1, 0);
    }
    
    @Override
    public boolean popBackStackImmediate(final int i, final int n) {
        this.checkStateLoss();
        this.execPendingActions();
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        return this.popBackStackImmediate(null, i, n);
    }
    
    @Override
    public boolean popBackStackImmediate(final String s, final int n) {
        this.checkStateLoss();
        return this.popBackStackImmediate(s, -1, n);
    }
    
    boolean popBackStackState(final ArrayList<BackStackRecord> list, final ArrayList<Boolean> list2, final String s, int i, int index) {
        if (this.mBackStack != null) {
            if (s == null && i < 0 && (index & 0x1) == 0x0) {
                i = this.mBackStack.size() - 1;
                if (i < 0) {
                    return false;
                }
                list.add(this.mBackStack.remove(i));
                list2.add(true);
            }
            else {
                int n = -1;
                if (s != null || i >= 0) {
                    int j;
                    for (j = this.mBackStack.size() - 1; j >= 0; --j) {
                        final BackStackRecord backStackRecord = this.mBackStack.get(j);
                        if ((s != null && s.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.mIndex)) {
                            break;
                        }
                    }
                    if (j < 0) {
                        return false;
                    }
                    n = j;
                    if ((index & 0x1) != 0x0) {
                        index = j - 1;
                        while (true) {
                            n = index;
                            if (index < 0) {
                                break;
                            }
                            final BackStackRecord backStackRecord2 = this.mBackStack.get(index);
                            if (s == null || !s.equals(backStackRecord2.getName())) {
                                n = index;
                                if (i < 0) {
                                    break;
                                }
                                n = index;
                                if (i != backStackRecord2.mIndex) {
                                    break;
                                }
                            }
                            --index;
                        }
                    }
                }
                if (n == this.mBackStack.size() - 1) {
                    return false;
                }
                for (i = this.mBackStack.size() - 1; i > n; --i) {
                    list.add(this.mBackStack.remove(i));
                    list2.add(true);
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void putFragment(final Bundle bundle, final String s, final Fragment obj) {
        if (obj.mIndex < 0) {
            this.throwException(new IllegalStateException("Fragment " + obj + " is not currently in the FragmentManager"));
        }
        bundle.putInt(s, obj.mIndex);
    }
    
    @Override
    public void registerFragmentLifecycleCallbacks(final FragmentLifecycleCallbacks fragmentLifecycleCallbacks, final boolean b) {
        if (this.mLifecycleCallbacks == null) {
            this.mLifecycleCallbacks = new CopyOnWriteArrayList<Pair<FragmentLifecycleCallbacks, Boolean>>();
        }
        this.mLifecycleCallbacks.add(new Pair<FragmentLifecycleCallbacks, Boolean>(fragmentLifecycleCallbacks, b));
    }
    
    public void removeFragment(final Fragment fragment) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean b;
        if (!fragment.isInBackStack()) {
            b = true;
        }
        else {
            b = false;
        }
        if (!fragment.mDetached || b) {
            if (this.mAdded != null) {
                this.mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }
    
    @Override
    public void removeOnBackStackChangedListener(final OnBackStackChangedListener o) {
        if (this.mBackStackChangeListeners != null) {
            this.mBackStackChangeListeners.remove(o);
        }
    }
    
    void reportBackStackChanged() {
        if (this.mBackStackChangeListeners != null) {
            for (int i = 0; i < this.mBackStackChangeListeners.size(); ++i) {
                this.mBackStackChangeListeners.get(i).onBackStackChanged();
            }
        }
    }
    
    void restoreAllState(final Parcelable parcelable, final FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (parcelable != null) {
            final FragmentManagerState fragmentManagerState = (FragmentManagerState)parcelable;
            if (fragmentManagerState.mActive != null) {
                List<FragmentManagerNonConfig> list = null;
                if (fragmentManagerNonConfig != null) {
                    final List<Fragment> fragments = fragmentManagerNonConfig.getFragments();
                    final List<FragmentManagerNonConfig> childNonConfigs = fragmentManagerNonConfig.getChildNonConfigs();
                    int size;
                    if (fragments != null) {
                        size = fragments.size();
                    }
                    else {
                        size = 0;
                    }
                    int n = 0;
                    while (true) {
                        list = childNonConfigs;
                        if (n >= size) {
                            break;
                        }
                        final Fragment fragment = fragments.get(n);
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        final FragmentState fragmentState = fragmentManagerState.mActive[fragment.mIndex];
                        fragmentState.mInstance = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.mSavedFragmentState != null) {
                            fragmentState.mSavedFragmentState.setClassLoader(this.mHost.getContext().getClassLoader());
                            fragment.mSavedViewState = (SparseArray<Parcelable>)fragmentState.mSavedFragmentState.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = fragmentState.mSavedFragmentState;
                        }
                        ++n;
                    }
                }
                this.mActive = new ArrayList<Fragment>(fragmentManagerState.mActive.length);
                if (this.mAvailIndices != null) {
                    this.mAvailIndices.clear();
                }
                for (int i = 0; i < fragmentManagerState.mActive.length; ++i) {
                    final FragmentState fragmentState2 = fragmentManagerState.mActive[i];
                    if (fragmentState2 != null) {
                        FragmentManagerNonConfig fragmentManagerNonConfig2 = null;
                        if (list != null) {
                            fragmentManagerNonConfig2 = fragmentManagerNonConfig2;
                            if (i < list.size()) {
                                fragmentManagerNonConfig2 = list.get(i);
                            }
                        }
                        final Fragment instantiate = fragmentState2.instantiate(this.mHost, this.mParent, fragmentManagerNonConfig2);
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i + ": " + instantiate);
                        }
                        this.mActive.add(instantiate);
                        fragmentState2.mInstance = null;
                    }
                    else {
                        this.mActive.add(null);
                        if (this.mAvailIndices == null) {
                            this.mAvailIndices = new ArrayList<Integer>();
                        }
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i);
                        }
                        this.mAvailIndices.add(i);
                    }
                }
                if (fragmentManagerNonConfig != null) {
                    final List<Fragment> fragments2 = fragmentManagerNonConfig.getFragments();
                    int size2;
                    if (fragments2 != null) {
                        size2 = fragments2.size();
                    }
                    else {
                        size2 = 0;
                    }
                    for (int j = 0; j < size2; ++j) {
                        final Fragment obj = fragments2.get(j);
                        if (obj.mTargetIndex >= 0) {
                            if (obj.mTargetIndex < this.mActive.size()) {
                                obj.mTarget = this.mActive.get(obj.mTargetIndex);
                            }
                            else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + obj + " target no longer exists: " + obj.mTargetIndex);
                                obj.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.mAdded != null) {
                    this.mAdded = new ArrayList<Fragment>(fragmentManagerState.mAdded.length);
                    for (int k = 0; k < fragmentManagerState.mAdded.length; ++k) {
                        final Fragment e = this.mActive.get(fragmentManagerState.mAdded[k]);
                        if (e == null) {
                            this.throwException(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.mAdded[k]));
                        }
                        e.mAdded = true;
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v("FragmentManager", "restoreAllState: added #" + k + ": " + e);
                        }
                        if (this.mAdded.contains(e)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.mAdded.add(e);
                    }
                }
                else {
                    this.mAdded = null;
                }
                if (fragmentManagerState.mBackStack == null) {
                    this.mBackStack = null;
                    return;
                }
                this.mBackStack = new ArrayList<BackStackRecord>(fragmentManagerState.mBackStack.length);
                for (int l = 0; l < fragmentManagerState.mBackStack.length; ++l) {
                    final BackStackRecord instantiate2 = fragmentManagerState.mBackStack[l].instantiate(this);
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "restoreAllState: back stack #" + l + " (index " + instantiate2.mIndex + "): " + instantiate2);
                        final PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                        instantiate2.dump("  ", printWriter, false);
                        printWriter.close();
                    }
                    this.mBackStack.add(instantiate2);
                    if (instantiate2.mIndex >= 0) {
                        this.setBackStackIndex(instantiate2.mIndex, instantiate2);
                    }
                }
            }
        }
    }
    
    FragmentManagerNonConfig retainNonConfig() {
        List<Fragment> list = null;
        ArrayList<Fragment> list2 = null;
        List<FragmentManagerNonConfig> list3 = null;
        ArrayList<FragmentManagerNonConfig> list4 = null;
        if (this.mActive != null) {
            int index = 0;
            while (true) {
                list3 = list4;
                list = list2;
                if (index >= this.mActive.size()) {
                    break;
                }
                final Fragment fragment = this.mActive.get(index);
                ArrayList<FragmentManagerNonConfig> list5 = list4;
                ArrayList<Fragment> list6 = list2;
                if (fragment != null) {
                    ArrayList<Fragment> list7 = list2;
                    if (fragment.mRetainInstance) {
                        ArrayList<Fragment> list8;
                        if ((list8 = list2) == null) {
                            list8 = new ArrayList<Fragment>();
                        }
                        list8.add(fragment);
                        fragment.mRetaining = true;
                        int mIndex;
                        if (fragment.mTarget != null) {
                            mIndex = fragment.mTarget.mIndex;
                        }
                        else {
                            mIndex = -1;
                        }
                        fragment.mTargetIndex = mIndex;
                        list7 = list8;
                        if (FragmentManagerImpl.DEBUG) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                            list7 = list8;
                        }
                    }
                    int n = 0;
                    ArrayList<FragmentManagerNonConfig> list9 = list4;
                    if (fragment.mChildFragmentManager != null) {
                        final FragmentManagerNonConfig retainNonConfig = fragment.mChildFragmentManager.retainNonConfig();
                        n = n;
                        list9 = list4;
                        if (retainNonConfig != null) {
                            if ((list9 = list4) == null) {
                                final ArrayList<FragmentManagerNonConfig> list10 = new ArrayList<FragmentManagerNonConfig>();
                                int n2 = 0;
                                while (true) {
                                    list9 = list10;
                                    if (n2 >= index) {
                                        break;
                                    }
                                    list10.add(null);
                                    ++n2;
                                }
                            }
                            list9.add(retainNonConfig);
                            n = 1;
                        }
                    }
                    list5 = list9;
                    list6 = list7;
                    if (list9 != null) {
                        list5 = list9;
                        list6 = list7;
                        if (n == 0) {
                            list9.add(null);
                            list6 = list7;
                            list5 = list9;
                        }
                    }
                }
                ++index;
                list4 = list5;
                list2 = list6;
            }
        }
        if (list == null && list3 == null) {
            return null;
        }
        return new FragmentManagerNonConfig(list, list3);
    }
    
    Parcelable saveAllState() {
        this.forcePostponedTransactions();
        this.endAnimatingAwayFragments();
        this.execPendingActions();
        if (FragmentManagerImpl.HONEYCOMB) {
            this.mStateSaved = true;
        }
        if (this.mActive != null && this.mActive.size() > 0) {
            final int size = this.mActive.size();
            final FragmentState[] mActive = new FragmentState[size];
            int n = 0;
            for (int i = 0; i < size; ++i) {
                final Fragment obj = this.mActive.get(i);
                if (obj != null) {
                    if (obj.mIndex < 0) {
                        this.throwException(new IllegalStateException("Failure saving state: active " + obj + " has cleared index: " + obj.mIndex));
                    }
                    final boolean b = true;
                    final FragmentState fragmentState = new FragmentState(obj);
                    mActive[i] = fragmentState;
                    if (obj.mState > 0 && fragmentState.mSavedFragmentState == null) {
                        fragmentState.mSavedFragmentState = this.saveFragmentBasicState(obj);
                        if (obj.mTarget != null) {
                            if (obj.mTarget.mIndex < 0) {
                                this.throwException(new IllegalStateException("Failure saving state: " + obj + " has target not in fragment manager: " + obj.mTarget));
                            }
                            if (fragmentState.mSavedFragmentState == null) {
                                fragmentState.mSavedFragmentState = new Bundle();
                            }
                            this.putFragment(fragmentState.mSavedFragmentState, "android:target_state", obj.mTarget);
                            if (obj.mTargetRequestCode != 0) {
                                fragmentState.mSavedFragmentState.putInt("android:target_req_state", obj.mTargetRequestCode);
                            }
                        }
                    }
                    else {
                        fragmentState.mSavedFragmentState = obj.mSavedFragmentState;
                    }
                    n = (b ? 1 : 0);
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Saved state of " + obj + ": " + fragmentState.mSavedFragmentState);
                        n = (b ? 1 : 0);
                    }
                }
            }
            if (n != 0) {
                final int[] array = null;
                final BackStackState[] array2 = null;
                int[] mAdded = array;
                if (this.mAdded != null) {
                    final int size2 = this.mAdded.size();
                    mAdded = array;
                    if (size2 > 0) {
                        final int[] array3 = new int[size2];
                        int n2 = 0;
                        while (true) {
                            mAdded = array3;
                            if (n2 >= size2) {
                                break;
                            }
                            array3[n2] = this.mAdded.get(n2).mIndex;
                            if (array3[n2] < 0) {
                                this.throwException(new IllegalStateException("Failure saving state: active " + this.mAdded.get(n2) + " has cleared index: " + array3[n2]));
                            }
                            if (FragmentManagerImpl.DEBUG) {
                                Log.v("FragmentManager", "saveAllState: adding fragment #" + n2 + ": " + this.mAdded.get(n2));
                            }
                            ++n2;
                        }
                    }
                }
                BackStackState[] mBackStack = array2;
                if (this.mBackStack != null) {
                    final int size3 = this.mBackStack.size();
                    mBackStack = array2;
                    if (size3 > 0) {
                        final BackStackState[] array4 = new BackStackState[size3];
                        int index = 0;
                        while (true) {
                            mBackStack = array4;
                            if (index >= size3) {
                                break;
                            }
                            array4[index] = new BackStackState(this.mBackStack.get(index));
                            if (FragmentManagerImpl.DEBUG) {
                                Log.v("FragmentManager", "saveAllState: adding back stack #" + index + ": " + this.mBackStack.get(index));
                            }
                            ++index;
                        }
                    }
                }
                final FragmentManagerState fragmentManagerState = new FragmentManagerState();
                fragmentManagerState.mActive = mActive;
                fragmentManagerState.mAdded = mAdded;
                fragmentManagerState.mBackStack = mBackStack;
                return (Parcelable)fragmentManagerState;
            }
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
                return null;
            }
        }
        return null;
    }
    
    Bundle saveFragmentBasicState(final Fragment fragment) {
        Bundle mStateBundle = null;
        if (this.mStateBundle == null) {
            this.mStateBundle = new Bundle();
        }
        fragment.performSaveInstanceState(this.mStateBundle);
        this.dispatchOnFragmentSaveInstanceState(fragment, this.mStateBundle, false);
        if (!this.mStateBundle.isEmpty()) {
            mStateBundle = this.mStateBundle;
            this.mStateBundle = null;
        }
        if (fragment.mView != null) {
            this.saveFragmentViewState(fragment);
        }
        Bundle bundle = mStateBundle;
        if (fragment.mSavedViewState != null) {
            if ((bundle = mStateBundle) == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", (SparseArray)fragment.mSavedViewState);
        }
        Bundle bundle2 = bundle;
        if (!fragment.mUserVisibleHint) {
            if ((bundle2 = bundle) == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle2;
    }
    
    @Override
    public Fragment.SavedState saveFragmentInstanceState(final Fragment obj) {
        final Fragment.SavedState savedState = null;
        if (obj.mIndex < 0) {
            this.throwException(new IllegalStateException("Fragment " + obj + " is not currently in the FragmentManager"));
        }
        Fragment.SavedState savedState2 = savedState;
        if (obj.mState > 0) {
            final Bundle saveFragmentBasicState = this.saveFragmentBasicState(obj);
            savedState2 = savedState;
            if (saveFragmentBasicState != null) {
                savedState2 = new Fragment.SavedState(saveFragmentBasicState);
            }
        }
        return savedState2;
    }
    
    void saveFragmentViewState(final Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.mStateArray == null) {
                this.mStateArray = (SparseArray<Parcelable>)new SparseArray();
            }
            else {
                this.mStateArray.clear();
            }
            fragment.mInnerView.saveHierarchyState((SparseArray)this.mStateArray);
            if (this.mStateArray.size() > 0) {
                fragment.mSavedViewState = this.mStateArray;
                this.mStateArray = null;
            }
        }
    }
    
    public void setBackStackIndex(final int i, final BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.mBackStackIndices == null) {
                this.mBackStackIndices = new ArrayList<BackStackRecord>();
            }
            int j;
            if (i < (j = this.mBackStackIndices.size())) {
                if (FragmentManagerImpl.DEBUG) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.mBackStackIndices.set(i, backStackRecord);
            }
            else {
                while (j < i) {
                    this.mBackStackIndices.add(null);
                    if (this.mAvailBackStackIndices == null) {
                        this.mAvailBackStackIndices = new ArrayList<Integer>();
                    }
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Adding available back stack index " + j);
                    }
                    this.mAvailBackStackIndices.add(j);
                    ++j;
                }
                if (FragmentManagerImpl.DEBUG) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.mBackStackIndices.add(backStackRecord);
            }
        }
    }
    
    public void showFragment(final Fragment obj) {
        boolean mHiddenChanged = false;
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "show: " + obj);
        }
        if (obj.mHidden) {
            obj.mHidden = false;
            if (!obj.mHiddenChanged) {
                mHiddenChanged = true;
            }
            obj.mHiddenChanged = mHiddenChanged;
        }
    }
    
    void startPendingDeferredFragments() {
        if (this.mActive != null) {
            for (int i = 0; i < this.mActive.size(); ++i) {
                final Fragment fragment = this.mActive.get(i);
                if (fragment != null) {
                    this.performPendingDeferredStart(fragment);
                }
            }
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.mParent != null) {
            DebugUtils.buildShortClassTag(this.mParent, sb);
        }
        else {
            DebugUtils.buildShortClassTag(this.mHost, sb);
        }
        sb.append("}}");
        return sb.toString();
    }
    
    @Override
    public void unregisterFragmentLifecycleCallbacks(final FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        if (this.mLifecycleCallbacks == null) {
            return;
        }
        while (true) {
            final CopyOnWriteArrayList<Pair<FragmentLifecycleCallbacks, Boolean>> mLifecycleCallbacks = this.mLifecycleCallbacks;
            // monitorenter(mLifecycleCallbacks)
            int n = 0;
            while (true) {
                Label_0069: {
                    try {
                        final int size = this.mLifecycleCallbacks.size();
                        if (n < size) {
                            if (this.mLifecycleCallbacks.get(n).first != fragmentLifecycleCallbacks) {
                                break Label_0069;
                            }
                            this.mLifecycleCallbacks.remove(n);
                        }
                        return;
                    }
                    finally {
                    }
                    // monitorexit(mLifecycleCallbacks)
                }
                ++n;
                continue;
            }
        }
    }
    
    static class AnimateOnHWLayerIfNeededListener implements Animation$AnimationListener
    {
        private Animation$AnimationListener mOriginalListener;
        private boolean mShouldRunOnHWLayer;
        View mView;
        
        public AnimateOnHWLayerIfNeededListener(final View mView, final Animation animation) {
            if (mView == null || animation == null) {
                return;
            }
            this.mView = mView;
        }
        
        public AnimateOnHWLayerIfNeededListener(final View mView, final Animation animation, final Animation$AnimationListener mOriginalListener) {
            if (mView == null || animation == null) {
                return;
            }
            this.mOriginalListener = mOriginalListener;
            this.mView = mView;
            this.mShouldRunOnHWLayer = true;
        }
        
        @CallSuper
        public void onAnimationEnd(final Animation animation) {
            if (this.mView != null && this.mShouldRunOnHWLayer) {
                if (ViewCompat.isAttachedToWindow(this.mView) || BuildCompat.isAtLeastN()) {
                    this.mView.post((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            ViewCompat.setLayerType(AnimateOnHWLayerIfNeededListener.this.mView, 0, null);
                        }
                    });
                }
                else {
                    ViewCompat.setLayerType(this.mView, 0, null);
                }
            }
            if (this.mOriginalListener != null) {
                this.mOriginalListener.onAnimationEnd(animation);
            }
        }
        
        public void onAnimationRepeat(final Animation animation) {
            if (this.mOriginalListener != null) {
                this.mOriginalListener.onAnimationRepeat(animation);
            }
        }
        
        @CallSuper
        public void onAnimationStart(final Animation animation) {
            if (this.mOriginalListener != null) {
                this.mOriginalListener.onAnimationStart(animation);
            }
        }
    }
    
    static class FragmentTag
    {
        public static final int[] Fragment;
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;
        
        static {
            Fragment = new int[] { 16842755, 16842960, 16842961 };
        }
    }
    
    interface OpGenerator
    {
        boolean generateOps(final ArrayList<BackStackRecord> p0, final ArrayList<Boolean> p1);
    }
    
    private class PopBackStackState implements OpGenerator
    {
        final int mFlags;
        final int mId;
        final String mName;
        
        PopBackStackState(final String mName, final int mId, final int mFlags) {
            this.mName = mName;
            this.mId = mId;
            this.mFlags = mFlags;
        }
        
        @Override
        public boolean generateOps(final ArrayList<BackStackRecord> list, final ArrayList<Boolean> list2) {
            return FragmentManagerImpl.this.popBackStackState(list, list2, this.mName, this.mId, this.mFlags);
        }
    }
    
    static class StartEnterTransitionListener implements OnStartEnterTransitionListener
    {
        private final boolean mIsBack;
        private int mNumPostponed;
        private final BackStackRecord mRecord;
        
        StartEnterTransitionListener(final BackStackRecord mRecord, final boolean mIsBack) {
            this.mIsBack = mIsBack;
            this.mRecord = mRecord;
        }
        
        public void cancelTransaction() {
            this.mRecord.mManager.completeExecute(this.mRecord, this.mIsBack, false, false);
        }
        
        public void completeTransaction() {
            boolean b = false;
            boolean b2;
            if (this.mNumPostponed > 0) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            final FragmentManagerImpl mManager = this.mRecord.mManager;
            for (int size = mManager.mAdded.size(), i = 0; i < size; ++i) {
                final Fragment fragment = mManager.mAdded.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (b2 && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            final FragmentManagerImpl mManager2 = this.mRecord.mManager;
            final BackStackRecord mRecord = this.mRecord;
            final boolean mIsBack = this.mIsBack;
            if (!b2) {
                b = true;
            }
            mManager2.completeExecute(mRecord, mIsBack, b, true);
        }
        
        public boolean isReady() {
            return this.mNumPostponed == 0;
        }
        
        @Override
        public void onStartEnterTransition() {
            --this.mNumPostponed;
            if (this.mNumPostponed != 0) {
                return;
            }
            this.mRecord.mManager.scheduleCommit();
        }
        
        @Override
        public void startListening() {
            ++this.mNumPostponed;
        }
    }
}
