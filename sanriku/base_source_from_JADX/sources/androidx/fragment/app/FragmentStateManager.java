package androidx.fragment.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.C0264R;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStoreOwner;
import p009e.p010a.p011a.p012a.C0681a;

class FragmentStateManager {
    private static final String TAG = "FragmentManager";
    private static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    private static final String TARGET_STATE_TAG = "android:target_state";
    private static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    private static final String VIEW_STATE_TAG = "android:view_state";
    private final FragmentLifecycleCallbacksDispatcher mDispatcher;
    @NonNull
    private final Fragment mFragment;
    private int mFragmentManagerState = -1;

    /* renamed from: androidx.fragment.app.FragmentStateManager$1 */
    static /* synthetic */ class C02881 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0017 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$lifecycle$Lifecycle$State = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x000f }
                r1 = 4
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                r1 = 3
                int[] r2 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x0017 }
                androidx.lifecycle.Lifecycle$State r3 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x0017 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0017 }
            L_0x0017:
                int[] r2 = $SwitchMap$androidx$lifecycle$Lifecycle$State     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r3 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r0] = r1     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.C02881.<clinit>():void");
        }
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull Fragment fragment) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragment;
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull Fragment fragment, @NonNull FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        Fragment fragment3 = this.mFragment;
        fragment3.mTarget = null;
        Bundle bundle = fragmentState.mSavedFragmentState;
        fragment3.mSavedFragmentState = bundle == null ? new Bundle() : bundle;
    }

    FragmentStateManager(@NonNull FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, @NonNull ClassLoader classLoader, @NonNull FragmentFactory fragmentFactory, @NonNull FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragment = fragmentFactory.instantiate(classLoader, fragmentState.mClassName);
        Bundle bundle = fragmentState.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        this.mFragment.setArguments(fragmentState.mArguments);
        Fragment fragment = this.mFragment;
        fragment.mWho = fragmentState.mWho;
        fragment.mFromLayout = fragmentState.mFromLayout;
        fragment.mRestored = true;
        fragment.mFragmentId = fragmentState.mFragmentId;
        fragment.mContainerId = fragmentState.mContainerId;
        fragment.mTag = fragmentState.mTag;
        fragment.mRetainInstance = fragmentState.mRetainInstance;
        fragment.mRemoving = fragmentState.mRemoving;
        fragment.mDetached = fragmentState.mDetached;
        fragment.mHidden = fragmentState.mHidden;
        fragment.mMaxState = Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        Bundle bundle2 = fragmentState.mSavedFragmentState;
        if (bundle2 != null) {
            this.mFragment.mSavedFragmentState = bundle2;
        } else {
            this.mFragment.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder a = C0681a.m330a("Instantiated fragment ");
            a.append(this.mFragment);
            Log.v(TAG, a.toString());
        }
    }

    private Bundle saveBasicState() {
        Bundle bundle = new Bundle();
        this.mFragment.performSaveInstanceState(bundle);
        this.mDispatcher.dispatchOnFragmentSaveInstanceState(this.mFragment, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.mFragment.mView != null) {
            saveViewState();
        }
        if (this.mFragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(VIEW_STATE_TAG, this.mFragment.mSavedViewState);
        }
        if (!this.mFragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(USER_VISIBLE_HINT_TAG, this.mFragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public void activityCreated() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder a = C0681a.m330a("moveto ACTIVITY_CREATED: ");
            a.append(this.mFragment);
            Log.d(TAG, a.toString());
        }
        Fragment fragment = this.mFragment;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        Fragment fragment2 = this.mFragment;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentActivityCreated(fragment2, fragment2.mSavedFragmentState, false);
    }

    /* access modifiers changed from: package-private */
    public void attach(@NonNull FragmentHostCallback<?> fragmentHostCallback, @NonNull FragmentManager fragmentManager, @Nullable Fragment fragment) {
        Fragment fragment2 = this.mFragment;
        fragment2.mHost = fragmentHostCallback;
        fragment2.mParentFragment = fragment;
        fragment2.mFragmentManager = fragmentManager;
        this.mDispatcher.dispatchOnFragmentPreAttached(fragment2, fragmentHostCallback.getContext(), false);
        this.mFragment.performAttach();
        Fragment fragment3 = this.mFragment;
        Fragment fragment4 = fragment3.mParentFragment;
        if (fragment4 == null) {
            fragmentHostCallback.onAttachFragment(fragment3);
        } else {
            fragment4.onAttachFragment(fragment3);
        }
        this.mDispatcher.dispatchOnFragmentAttached(this.mFragment, fragmentHostCallback.getContext(), false);
    }

    /* access modifiers changed from: package-private */
    public int computeMaxState() {
        int i = this.mFragmentManagerState;
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout) {
            i = fragment.mInLayout ? Math.max(i, 1) : i < 2 ? Math.min(i, fragment.mState) : Math.min(i, 1);
        }
        if (!this.mFragment.mAdded) {
            i = Math.min(i, 1);
        }
        Fragment fragment2 = this.mFragment;
        if (fragment2.mRemoving) {
            i = fragment2.isInBackStack() ? Math.min(i, 1) : Math.min(i, -1);
        }
        Fragment fragment3 = this.mFragment;
        if (fragment3.mDeferStart && fragment3.mState < 3) {
            i = Math.min(i, 2);
        }
        int ordinal = this.mFragment.mMaxState.ordinal();
        return ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? Math.min(i, -1) : i : Math.min(i, 3) : Math.min(i, 1);
    }

    /* access modifiers changed from: package-private */
    public void create() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder a = C0681a.m330a("moveto CREATED: ");
            a.append(this.mFragment);
            Log.d(TAG, a.toString());
        }
        Fragment fragment = this.mFragment;
        if (!fragment.mIsCreated) {
            this.mDispatcher.dispatchOnFragmentPreCreated(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.mFragment;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
            Fragment fragment3 = this.mFragment;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.mFragment.mState = 1;
    }

    /* JADX WARNING: type inference failed for: r5v15, types: [android.view.View] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createView(@androidx.annotation.NonNull androidx.fragment.app.FragmentContainer r5) {
        /*
            r4 = this;
            androidx.fragment.app.Fragment r0 = r4.mFragment
            boolean r0 = r0.mFromLayout
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 3
            boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r0)
            if (r0 == 0) goto L_0x0022
            java.lang.String r0 = "moveto CREATE_VIEW: "
            java.lang.StringBuilder r0 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r0)
            androidx.fragment.app.Fragment r1 = r4.mFragment
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FragmentManager"
            android.util.Log.d(r1, r0)
        L_0x0022:
            r0 = 0
            androidx.fragment.app.Fragment r1 = r4.mFragment
            android.view.ViewGroup r2 = r1.mContainer
            if (r2 == 0) goto L_0x002b
            r0 = r2
            goto L_0x0098
        L_0x002b:
            int r1 = r1.mContainerId
            if (r1 == 0) goto L_0x0098
            r0 = -1
            if (r1 == r0) goto L_0x007e
            android.view.View r5 = r5.onFindViewById(r1)
            r0 = r5
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0098
            androidx.fragment.app.Fragment r5 = r4.mFragment
            boolean r1 = r5.mRestored
            if (r1 == 0) goto L_0x0042
            goto L_0x0098
        L_0x0042:
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ NotFoundException -> 0x004f }
            androidx.fragment.app.Fragment r0 = r4.mFragment     // Catch:{ NotFoundException -> 0x004f }
            int r0 = r0.mContainerId     // Catch:{ NotFoundException -> 0x004f }
            java.lang.String r5 = r5.getResourceName(r0)     // Catch:{ NotFoundException -> 0x004f }
            goto L_0x0051
        L_0x004f:
            java.lang.String r5 = "unknown"
        L_0x0051:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No view found for id 0x"
            java.lang.StringBuilder r1 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r1)
            androidx.fragment.app.Fragment r2 = r4.mFragment
            int r2 = r2.mContainerId
            java.lang.String r2 = java.lang.Integer.toHexString(r2)
            r1.append(r2)
            java.lang.String r2 = " ("
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = ") for fragment "
            r1.append(r5)
            androidx.fragment.app.Fragment r5 = r4.mFragment
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x007e:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Cannot create fragment "
            java.lang.StringBuilder r0 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r0)
            androidx.fragment.app.Fragment r1 = r4.mFragment
            r0.append(r1)
            java.lang.String r1 = " for a container view with no id"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L_0x0098:
            androidx.fragment.app.Fragment r5 = r4.mFragment
            r5.mContainer = r0
            android.os.Bundle r1 = r5.mSavedFragmentState
            android.view.LayoutInflater r1 = r5.performGetLayoutInflater(r1)
            androidx.fragment.app.Fragment r2 = r4.mFragment
            android.os.Bundle r2 = r2.mSavedFragmentState
            r5.performCreateView(r1, r0, r2)
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r5 = r5.mView
            if (r5 == 0) goto L_0x0100
            r1 = 0
            r5.setSaveFromParentEnabled(r1)
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r2 = r5.mView
            int r3 = androidx.fragment.C0264R.C0266id.fragment_container_view_tag
            r2.setTag(r3, r5)
            if (r0 == 0) goto L_0x00c5
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r5 = r5.mView
            r0.addView(r5)
        L_0x00c5:
            androidx.fragment.app.Fragment r5 = r4.mFragment
            boolean r0 = r5.mHidden
            if (r0 == 0) goto L_0x00d2
            android.view.View r5 = r5.mView
            r0 = 8
            r5.setVisibility(r0)
        L_0x00d2:
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r5 = r5.mView
            androidx.core.view.ViewCompat.requestApplyInsets(r5)
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r0 = r5.mView
            android.os.Bundle r2 = r5.mSavedFragmentState
            r5.onViewCreated(r0, r2)
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher r5 = r4.mDispatcher
            androidx.fragment.app.Fragment r0 = r4.mFragment
            android.view.View r2 = r0.mView
            android.os.Bundle r3 = r0.mSavedFragmentState
            r5.dispatchOnFragmentViewCreated(r0, r2, r3, r1)
            androidx.fragment.app.Fragment r5 = r4.mFragment
            android.view.View r0 = r5.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x00fe
            androidx.fragment.app.Fragment r0 = r4.mFragment
            android.view.ViewGroup r0 = r0.mContainer
            if (r0 == 0) goto L_0x00fe
            r1 = 1
        L_0x00fe:
            r5.mIsNewlyAdded = r1
        L_0x0100:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.createView(androidx.fragment.app.FragmentContainer):void");
    }

    /* access modifiers changed from: package-private */
    public void destroy(@NonNull FragmentHostCallback<?> fragmentHostCallback, @NonNull FragmentManagerViewModel fragmentManagerViewModel) {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder a = C0681a.m330a("movefrom CREATED: ");
            a.append(this.mFragment);
            Log.d(TAG, a.toString());
        }
        Fragment fragment = this.mFragment;
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (z2 || fragmentManagerViewModel.shouldDestroy(this.mFragment)) {
            if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                z = fragmentManagerViewModel.isCleared();
            } else if (fragmentHostCallback.getContext() instanceof Activity) {
                z = true ^ ((Activity) fragmentHostCallback.getContext()).isChangingConfigurations();
            }
            if (z2 || z) {
                fragmentManagerViewModel.clearNonConfigState(this.mFragment);
            }
            this.mFragment.performDestroy();
            this.mDispatcher.dispatchOnFragmentDestroyed(this.mFragment, false);
            return;
        }
        this.mFragment.mState = 0;
    }

    /* access modifiers changed from: package-private */
    public void detach(@NonNull FragmentManagerViewModel fragmentManagerViewModel) {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder a = C0681a.m330a("movefrom ATTACHED: ");
            a.append(this.mFragment);
            Log.d(TAG, a.toString());
        }
        this.mFragment.performDetach();
        boolean z = false;
        this.mDispatcher.dispatchOnFragmentDetached(this.mFragment, false);
        Fragment fragment = this.mFragment;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (z || fragmentManagerViewModel.shouldDestroy(this.mFragment)) {
            if (FragmentManager.isLoggingEnabled(3)) {
                StringBuilder a2 = C0681a.m330a("initState called for fragment: ");
                a2.append(this.mFragment);
                Log.d(TAG, a2.toString());
            }
            this.mFragment.initState();
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureInflatedView() {
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                StringBuilder a = C0681a.m330a("moveto CREATE_VIEW: ");
                a.append(this.mFragment);
                Log.d(TAG, a.toString());
            }
            Fragment fragment2 = this.mFragment;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), (ViewGroup) null, this.mFragment.mSavedFragmentState);
            View view = this.mFragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.mFragment;
                fragment3.mView.setTag(C0264R.C0266id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.mFragment;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                Fragment fragment5 = this.mFragment;
                fragment5.onViewCreated(fragment5.mView, fragment5.mSavedFragmentState);
                FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
                Fragment fragment6 = this.mFragment;
                fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentViewCreated(fragment6, fragment6.mView, fragment6.mSavedFragmentState, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Fragment getFragment() {
        return this.mFragment;
    }

    /* access modifiers changed from: package-private */
    public void pause() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder a = C0681a.m330a("movefrom RESUMED: ");
            a.append(this.mFragment);
            Log.d(TAG, a.toString());
        }
        this.mFragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(this.mFragment, false);
    }

    /* access modifiers changed from: package-private */
    public void restoreState(@NonNull ClassLoader classLoader) {
        Bundle bundle = this.mFragment.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.mFragment;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(VIEW_STATE_TAG);
            Fragment fragment2 = this.mFragment;
            fragment2.mTargetWho = fragment2.mSavedFragmentState.getString(TARGET_STATE_TAG);
            Fragment fragment3 = this.mFragment;
            if (fragment3.mTargetWho != null) {
                fragment3.mTargetRequestCode = fragment3.mSavedFragmentState.getInt(TARGET_REQUEST_CODE_STATE_TAG, 0);
            }
            Fragment fragment4 = this.mFragment;
            Boolean bool = fragment4.mSavedUserVisibleHint;
            if (bool != null) {
                fragment4.mUserVisibleHint = bool.booleanValue();
                this.mFragment.mSavedUserVisibleHint = null;
            } else {
                fragment4.mUserVisibleHint = fragment4.mSavedFragmentState.getBoolean(USER_VISIBLE_HINT_TAG, true);
            }
            Fragment fragment5 = this.mFragment;
            if (!fragment5.mUserVisibleHint) {
                fragment5.mDeferStart = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder a = C0681a.m330a("moveto RESTORE_VIEW_STATE: ");
            a.append(this.mFragment);
            Log.d(TAG, a.toString());
        }
        Fragment fragment = this.mFragment;
        if (fragment.mView != null) {
            fragment.restoreViewState(fragment.mSavedFragmentState);
        }
        this.mFragment.mSavedFragmentState = null;
    }

    /* access modifiers changed from: package-private */
    public void resume() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder a = C0681a.m330a("moveto RESUMED: ");
            a.append(this.mFragment);
            Log.d(TAG, a.toString());
        }
        this.mFragment.performResume();
        this.mDispatcher.dispatchOnFragmentResumed(this.mFragment, false);
        Fragment fragment = this.mFragment;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Fragment.SavedState saveInstanceState() {
        Bundle saveBasicState;
        if (this.mFragment.mState <= -1 || (saveBasicState = saveBasicState()) == null) {
            return null;
        }
        return new Fragment.SavedState(saveBasicState);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentState saveState() {
        FragmentState fragmentState = new FragmentState(this.mFragment);
        if (this.mFragment.mState <= -1 || fragmentState.mSavedFragmentState != null) {
            fragmentState.mSavedFragmentState = this.mFragment.mSavedFragmentState;
        } else {
            Bundle saveBasicState = saveBasicState();
            fragmentState.mSavedFragmentState = saveBasicState;
            if (this.mFragment.mTargetWho != null) {
                if (saveBasicState == null) {
                    fragmentState.mSavedFragmentState = new Bundle();
                }
                fragmentState.mSavedFragmentState.putString(TARGET_STATE_TAG, this.mFragment.mTargetWho);
                int i = this.mFragment.mTargetRequestCode;
                if (i != 0) {
                    fragmentState.mSavedFragmentState.putInt(TARGET_REQUEST_CODE_STATE_TAG, i);
                }
            }
        }
        return fragmentState;
    }

    /* access modifiers changed from: package-private */
    public void saveViewState() {
        if (this.mFragment.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.mFragment.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.mFragment.mSavedViewState = sparseArray;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setFragmentManagerState(int i) {
        this.mFragmentManagerState = i;
    }

    /* access modifiers changed from: package-private */
    public void start() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder a = C0681a.m330a("moveto STARTED: ");
            a.append(this.mFragment);
            Log.d(TAG, a.toString());
        }
        this.mFragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(this.mFragment, false);
    }

    /* access modifiers changed from: package-private */
    public void stop() {
        if (FragmentManager.isLoggingEnabled(3)) {
            StringBuilder a = C0681a.m330a("movefrom STARTED: ");
            a.append(this.mFragment);
            Log.d(TAG, a.toString());
        }
        this.mFragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(this.mFragment, false);
    }
}
