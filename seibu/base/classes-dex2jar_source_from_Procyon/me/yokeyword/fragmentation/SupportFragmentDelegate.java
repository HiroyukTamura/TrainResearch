// 
// Decompiled by Procyon v0.5.36
// 

package me.yokeyword.fragmentation;

import me.yokeyword.fragmentation.helper.internal.ResultRecord;
import android.os.Parcelable;
import android.app.Activity;
import android.view.View;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.content.res.TypedArray;
import android.os.Looper;
import android.support.v4.app.FragmentManager;
import android.view.animation.Animation;
import me.yokeyword.fragmentation.helper.internal.VisibleDelegate;
import me.yokeyword.fragmentation.helper.internal.TransactionRecord;
import android.os.Bundle;
import android.os.Handler;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import android.support.v4.app.Fragment;
import me.yokeyword.fragmentation.helper.internal.AnimatorHelper;
import android.support.v4.app.FragmentActivity;

public class SupportFragmentDelegate
{
    static final int STATUS_ROOT_ANIM_DISABLE = 1;
    static final int STATUS_ROOT_ANIM_ENABLE = 2;
    static final int STATUS_UN_ROOT = 0;
    protected FragmentActivity _mActivity;
    boolean mAnimByActivity;
    AnimatorHelper mAnimHelper;
    int mContainerId;
    private int mCustomEnterAnim;
    SupportFragmentDelegate.SupportFragmentDelegate$EnterAnimListener mEnterAnimListener;
    private boolean mFirstCreateView;
    private Fragment mFragment;
    FragmentAnimator mFragmentAnimator;
    private Handler mHandler;
    private boolean mIsHidden;
    boolean mIsSharedElement;
    boolean mLockAnim;
    Bundle mNewBundle;
    private boolean mReplaceMode;
    private int mRootStatus;
    private Bundle mSaveInstanceState;
    private ISupportActivity mSupport;
    private ISupportFragment mSupportF;
    private TransactionDelegate mTransactionDelegate;
    TransactionRecord mTransactionRecord;
    private VisibleDelegate mVisibleDelegate;
    
    public SupportFragmentDelegate(final ISupportFragment mSupportF) {
        this.mRootStatus = 0;
        this.mCustomEnterAnim = Integer.MIN_VALUE;
        this.mFirstCreateView = true;
        this.mIsHidden = true;
        this.mAnimByActivity = true;
        if (!(mSupportF instanceof Fragment)) {
            throw new RuntimeException("Must extends Fragment");
        }
        this.mSupportF = mSupportF;
        this.mFragment = (Fragment)mSupportF;
    }
    
    private void compatSharedElements() {
        this.notifyEnterAnimEnd();
    }
    
    private void fixAnimationListener(final Animation animation) {
        this.mSupport.getSupportDelegate().mFragmentClickable = false;
        this.getHandler().postDelayed((Runnable)new SupportFragmentDelegate$1(this), animation.getDuration());
        if (this.mEnterAnimListener != null) {
            this.getHandler().post((Runnable)new SupportFragmentDelegate$2(this));
        }
    }
    
    private FragmentManager getChildFragmentManager() {
        return this.mFragment.getChildFragmentManager();
    }
    
    private Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
        return this.mHandler;
    }
    
    private ISupportFragment getTopFragment() {
        return SupportHelper.getTopFragment(this.getChildFragmentManager());
    }
    
    private int getWindowBackground() {
        final TypedArray obtainStyledAttributes = this._mActivity.getTheme().obtainStyledAttributes(new int[] { 16842836 });
        final int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }
    
    private void notifyEnterAnimEnd() {
        this.getHandler().post((Runnable)new SupportFragmentDelegate$3(this));
        this.mSupport.getSupportDelegate().mFragmentClickable = true;
    }
    
    private void processRestoreInstanceState(final Bundle bundle) {
        if (bundle != null) {
            final FragmentTransaction beginTransaction = this.mFragment.getFragmentManager().beginTransaction();
            if (this.mIsHidden) {
                beginTransaction.hide(this.mFragment);
            }
            else {
                beginTransaction.show(this.mFragment);
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }
    
    public void enqueueAction(final Runnable runnable) {
        final Handler handler = this.getHandler();
        long duration;
        if (this.mAnimHelper == null) {
            duration = 0L;
        }
        else {
            duration = this.mAnimHelper.enterAnim.getDuration();
        }
        handler.postDelayed(runnable, duration);
    }
    
    public ExtraTransaction extraTransaction() {
        if (this.mTransactionDelegate == null) {
            throw new RuntimeException(this.mFragment.getClass().getSimpleName() + " not attach!");
        }
        return (ExtraTransaction)new ExtraTransaction$ExtraTransactionImpl(this.mSupportF, this.mTransactionDelegate, false);
    }
    
    public FragmentActivity getActivity() {
        return this._mActivity;
    }
    
    public FragmentAnimator getFragmentAnimator() {
        if (this.mSupport == null) {
            throw new RuntimeException("Fragment has not been attached to Activity!");
        }
        if (this.mFragmentAnimator == null) {
            this.mFragmentAnimator = this.mSupportF.onCreateFragmentAnimator();
            if (this.mFragmentAnimator == null) {
                this.mFragmentAnimator = this.mSupport.getFragmentAnimator();
            }
        }
        return this.mFragmentAnimator;
    }
    
    public VisibleDelegate getVisibleDelegate() {
        if (this.mVisibleDelegate == null) {
            this.mVisibleDelegate = new VisibleDelegate(this.mSupportF);
        }
        return this.mVisibleDelegate;
    }
    
    public void hideSoftInput() {
        SupportHelper.hideSoftInput(this.mFragment.getView());
    }
    
    public final boolean isSupportVisible() {
        return this.getVisibleDelegate().isSupportVisible();
    }
    
    public void loadMultipleRootFragment(final int n, final int n2, final ISupportFragment... array) {
        this.mTransactionDelegate.loadMultipleRootTransaction(this.getChildFragmentManager(), n, n2, array);
    }
    
    public void loadRootFragment(final int n, final ISupportFragment supportFragment) {
        this.loadRootFragment(n, supportFragment, true, false);
    }
    
    public void loadRootFragment(final int n, final ISupportFragment supportFragment, final boolean b, final boolean b2) {
        this.mTransactionDelegate.loadRootTransaction(this.getChildFragmentManager(), n, supportFragment, b, b2);
    }
    
    public void onActivityCreated(@Nullable final Bundle bundle) {
        this.getVisibleDelegate().onActivityCreated(bundle);
        final View view = this.mFragment.getView();
        if (view != null) {
            view.setClickable(true);
            this.setBackground(view);
        }
        if (bundle != null || this.mRootStatus == 1 || (this.mFragment.getTag() != null && this.mFragment.getTag().startsWith("android:switcher:")) || (this.mReplaceMode && !this.mFirstCreateView)) {
            this.notifyEnterAnimEnd();
        }
        else if (this.mCustomEnterAnim != Integer.MIN_VALUE) {
            Animation animation;
            if (this.mCustomEnterAnim == 0) {
                animation = this.mAnimHelper.getNoneAnim();
            }
            else {
                animation = AnimationUtils.loadAnimation((Context)this._mActivity, this.mCustomEnterAnim);
            }
            this.fixAnimationListener(animation);
        }
        if (this.mFirstCreateView) {
            this.mFirstCreateView = false;
        }
    }
    
    public void onAttach(final Activity activity) {
        if (activity instanceof ISupportActivity) {
            this.mSupport = (ISupportActivity)activity;
            this._mActivity = (FragmentActivity)activity;
            this.mTransactionDelegate = this.mSupport.getSupportDelegate().getTransactionDelegate();
            return;
        }
        throw new RuntimeException(activity.getClass().getSimpleName() + " must impl ISupportActivity!");
    }
    
    public boolean onBackPressedSupport() {
        return false;
    }
    
    public void onCreate(@Nullable final Bundle mSaveInstanceState) {
        this.getVisibleDelegate().onCreate(mSaveInstanceState);
        final Bundle arguments = this.mFragment.getArguments();
        if (arguments != null) {
            this.mRootStatus = arguments.getInt("fragmentation_arg_root_status", 0);
            this.mIsSharedElement = arguments.getBoolean("fragmentation_arg_is_shared_element", false);
            this.mContainerId = arguments.getInt("fragmentation_arg_container");
            this.mReplaceMode = arguments.getBoolean("fragmentation_arg_replace", false);
            this.mCustomEnterAnim = arguments.getInt("fragmentation_arg_custom_end_anim", Integer.MIN_VALUE);
        }
        if (mSaveInstanceState == null) {
            this.getFragmentAnimator();
        }
        else {
            this.mSaveInstanceState = mSaveInstanceState;
            this.mFragmentAnimator = (FragmentAnimator)mSaveInstanceState.getParcelable("fragmentation_state_save_animator");
            this.mIsHidden = mSaveInstanceState.getBoolean("fragmentation_state_save_status");
            this.mContainerId = mSaveInstanceState.getInt("fragmentation_arg_container");
        }
        this.processRestoreInstanceState(mSaveInstanceState);
        this.mAnimHelper = new AnimatorHelper(this._mActivity.getApplicationContext(), this.mFragmentAnimator);
    }
    
    public Animation onCreateAnimation(final int n, final boolean b, final int n2) {
        if (this.mSupport.getSupportDelegate().mPopMultipleNoAnim || this.mLockAnim) {
            if (n == 8194 && b) {
                return this.mAnimHelper.getNoneAnimFixed();
            }
            return this.mAnimHelper.getNoneAnim();
        }
        else if (n == 4097) {
            if (!b) {
                return this.mAnimHelper.popExitAnim;
            }
            if (this.mRootStatus == 1) {
                return this.mAnimHelper.getNoneAnim();
            }
            final Animation enterAnim = this.mAnimHelper.enterAnim;
            this.fixAnimationListener(enterAnim);
            return enterAnim;
        }
        else {
            if (n == 8194) {
                Animation animation;
                if (b) {
                    animation = this.mAnimHelper.popEnterAnim;
                }
                else {
                    animation = this.mAnimHelper.exitAnim;
                }
                return animation;
            }
            if (this.mIsSharedElement && b) {
                this.compatSharedElements();
            }
            if (!b) {
                return this.mAnimHelper.compatChildFragmentExitAnim(this.mFragment);
            }
            return null;
        }
    }
    
    public FragmentAnimator onCreateFragmentAnimator() {
        return this.mSupport.getFragmentAnimator();
    }
    
    public void onDestroy() {
        this.mTransactionDelegate.handleResultRecord(this.mFragment);
    }
    
    public void onDestroyView() {
        this.mSupport.getSupportDelegate().mFragmentClickable = true;
        this.getVisibleDelegate().onDestroyView();
    }
    
    public void onEnterAnimationEnd(final Bundle bundle) {
    }
    
    public void onFragmentResult(final int n, final int n2, final Bundle bundle) {
    }
    
    public void onHiddenChanged(final boolean b) {
        this.getVisibleDelegate().onHiddenChanged(b);
    }
    
    public void onLazyInitView(@Nullable final Bundle bundle) {
    }
    
    public void onNewBundle(final Bundle bundle) {
    }
    
    public void onPause() {
        this.getVisibleDelegate().onPause();
    }
    
    public void onResume() {
        this.getVisibleDelegate().onResume();
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        this.getVisibleDelegate().onSaveInstanceState(bundle);
        bundle.putParcelable("fragmentation_state_save_animator", (Parcelable)this.mFragmentAnimator);
        bundle.putBoolean("fragmentation_state_save_status", this.mFragment.isHidden());
        bundle.putInt("fragmentation_arg_container", this.mContainerId);
    }
    
    public void onSupportInvisible() {
    }
    
    public void onSupportVisible() {
    }
    
    public void pop() {
        this.mTransactionDelegate.back(this.mFragment.getFragmentManager());
    }
    
    public void popChild() {
        this.mTransactionDelegate.back(this.getChildFragmentManager());
    }
    
    public void popTo(final Class<?> clazz, final boolean b) {
        this.getChildFragmentManager().popBackStack();
        this.popTo(clazz, b, null);
    }
    
    public void popTo(final Class<?> clazz, final boolean b, final Runnable runnable) {
        this.popTo(clazz, b, runnable, Integer.MAX_VALUE);
    }
    
    public void popTo(final Class<?> clazz, final boolean b, final Runnable runnable, final int n) {
        this.mTransactionDelegate.popTo(clazz.getName(), b, runnable, this.mFragment.getFragmentManager(), n);
    }
    
    public void popToChild(final Class<?> clazz, final boolean b) {
        this.popToChild(clazz, b, null);
    }
    
    public void popToChild(final Class<?> clazz, final boolean b, final Runnable runnable) {
        this.popToChild(clazz, b, runnable, Integer.MAX_VALUE);
    }
    
    public void popToChild(final Class<?> clazz, final boolean b, final Runnable runnable, final int n) {
        this.mTransactionDelegate.popTo(clazz.getName(), b, runnable, this.getChildFragmentManager(), n);
    }
    
    public void putNewBundle(final Bundle mNewBundle) {
        this.mNewBundle = mNewBundle;
    }
    
    public void replaceChildFragment(final ISupportFragment supportFragment, final boolean b) {
        final TransactionDelegate mTransactionDelegate = this.mTransactionDelegate;
        final FragmentManager childFragmentManager = this.getChildFragmentManager();
        final ISupportFragment topFragment = this.getTopFragment();
        int n;
        if (b) {
            n = 10;
        }
        else {
            n = 14;
        }
        mTransactionDelegate.dispatchStartTransaction(childFragmentManager, topFragment, supportFragment, 0, 0, n);
    }
    
    public void replaceFragment(final ISupportFragment supportFragment, final boolean b) {
        final TransactionDelegate mTransactionDelegate = this.mTransactionDelegate;
        final FragmentManager fragmentManager = this.mFragment.getFragmentManager();
        final ISupportFragment mSupportF = this.mSupportF;
        int n;
        if (b) {
            n = 10;
        }
        else {
            n = 14;
        }
        mTransactionDelegate.dispatchStartTransaction(fragmentManager, mSupportF, supportFragment, 0, 0, n);
    }
    
    public void setBackground(final View view) {
        if ((this.mFragment.getTag() != null && this.mFragment.getTag().startsWith("android:switcher:")) || this.mRootStatus != 0 || view.getBackground() != null) {
            return;
        }
        final int defaultFragmentBackground = this.mSupport.getSupportDelegate().getDefaultFragmentBackground();
        if (defaultFragmentBackground == 0) {
            view.setBackgroundResource(this.getWindowBackground());
            return;
        }
        view.setBackgroundResource(defaultFragmentBackground);
    }
    
    public void setFragmentAnimator(final FragmentAnimator mFragmentAnimator) {
        this.mFragmentAnimator = mFragmentAnimator;
        if (this.mAnimHelper != null) {
            this.mAnimHelper.notifyChanged(mFragmentAnimator);
        }
        this.mAnimByActivity = false;
    }
    
    public void setFragmentResult(final int resultCode, final Bundle resultBundle) {
        final Bundle arguments = this.mFragment.getArguments();
        if (arguments != null && arguments.containsKey("fragment_arg_result_record")) {
            final ResultRecord resultRecord = (ResultRecord)arguments.getParcelable("fragment_arg_result_record");
            if (resultRecord != null) {
                resultRecord.resultCode = resultCode;
                resultRecord.resultBundle = resultBundle;
            }
        }
    }
    
    public void setUserVisibleHint(final boolean userVisibleHint) {
        this.getVisibleDelegate().setUserVisibleHint(userVisibleHint);
    }
    
    public void showHideFragment(final ISupportFragment supportFragment) {
        this.showHideFragment(supportFragment, null);
    }
    
    public void showHideFragment(final ISupportFragment supportFragment, final ISupportFragment supportFragment2) {
        this.mTransactionDelegate.showHideFragment(this.getChildFragmentManager(), supportFragment, supportFragment2);
    }
    
    public void showSoftInput(final View view) {
        SupportHelper.showSoftInput(view);
    }
    
    public void start(final ISupportFragment supportFragment) {
        this.start(supportFragment, 0);
    }
    
    public void start(final ISupportFragment supportFragment, final int n) {
        this.mTransactionDelegate.dispatchStartTransaction(this.mFragment.getFragmentManager(), this.mSupportF, supportFragment, 0, n, 0);
    }
    
    public void startChild(final ISupportFragment supportFragment) {
        this.startChild(supportFragment, 0);
    }
    
    public void startChild(final ISupportFragment supportFragment, final int n) {
        this.mTransactionDelegate.dispatchStartTransaction(this.getChildFragmentManager(), this.getTopFragment(), supportFragment, 0, n, 0);
    }
    
    public void startChildForResult(final ISupportFragment supportFragment, final int n) {
        this.mTransactionDelegate.dispatchStartTransaction(this.getChildFragmentManager(), this.getTopFragment(), supportFragment, n, 0, 2);
    }
    
    public void startChildWithPop(final ISupportFragment supportFragment) {
        this.mTransactionDelegate.dispatchStartTransaction(this.getChildFragmentManager(), this.getTopFragment(), supportFragment, 0, 0, 1);
    }
    
    public void startForResult(final ISupportFragment supportFragment, final int n) {
        this.mTransactionDelegate.dispatchStartTransaction(this.mFragment.getFragmentManager(), this.mSupportF, supportFragment, n, 0, 2);
    }
    
    public void startWithPop(final ISupportFragment supportFragment) {
        this.mTransactionDelegate.dispatchStartTransaction(this.mFragment.getFragmentManager(), this.mSupportF, supportFragment, 0, 0, 1);
    }
}
