// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base;

import com.feilang.mvpproject.R;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.net.Uri;
import android.content.Intent;
import android.text.TextUtils;
import com.feilang.mvpproject.util.AppEventBus;
import com.google.common.eventbus.Subscribe;
import com.feilang.mvpproject.util.Constants;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.content.Context;
import com.feilang.mvpproject.util.LogUtils;
import android.support.annotation.Nullable;
import android.os.Bundle;
import org.androidannotations.annotations.EFragment;
import me.yokeyword.fragmentation.SupportFragment;

@EFragment
public class BaseFragment extends SupportFragment implements View
{
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";
    protected BaseAppCompatActivity mActivity;
    
    public boolean isDestroyed() {
        return !this.isResumed();
    }
    
    public void onActivityCreated(@Nullable final Bundle bundle) {
        super.onActivityCreated(bundle);
        LogUtils.trace(this);
    }
    
    public void onAttach(final Context context) {
        super.onAttach(context);
        LogUtils.trace(this);
        this.mActivity = (BaseAppCompatActivity)context;
    }
    
    public void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        LogUtils.trace(this);
        if (bundle != null) {
            final boolean boolean1 = bundle.getBoolean("STATE_SAVE_IS_HIDDEN");
            final FragmentTransaction beginTransaction = this.getFragmentManager().beginTransaction();
            if (boolean1) {
                beginTransaction.hide((Fragment)this);
            }
            else {
                beginTransaction.show((Fragment)this);
            }
            beginTransaction.commitAllowingStateLoss();
        }
    }
    
    @Nullable
    public android.view.View onCreateView(final LayoutInflater layoutInflater, @Nullable final ViewGroup viewGroup, @Nullable final Bundle bundle) {
        LogUtils.trace(this);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
    
    @Subscribe
    public void onDataRefreshed(final Constants.DataRefreshEvent dataRefreshEvent) {
        LogUtils.trace(this);
        this.viewDataRefreshed(dataRefreshEvent);
    }
    
    public void onDestroy() {
        super.onDestroy();
        LogUtils.trace(this);
    }
    
    public void onDestroyView() {
        super.onDestroyView();
        LogUtils.trace(this);
    }
    
    public void onDetach() {
        super.onDetach();
        LogUtils.trace(this);
        this.mActivity = null;
    }
    
    public void onLowMemory() {
        super.onLowMemory();
        LogUtils.trace(this);
    }
    
    public void onPause() {
        super.onPause();
        LogUtils.trace(this);
        try {
            AppEventBus.getInstance().unregister(this);
        }
        catch (IllegalArgumentException ex) {
            LogUtils.outputLog("AppEventBus unregister failed, this: " + this.getClass().getName());
        }
    }
    
    public void onResume() {
        super.onResume();
        LogUtils.trace(this);
        AppEventBus.getInstance().register(this);
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("STATE_SAVE_IS_HIDDEN", this.isHidden());
    }
    
    public void onStart() {
        super.onStart();
        LogUtils.trace(this);
    }
    
    public void onStop() {
        super.onStop();
        LogUtils.trace(this);
    }
    
    protected void openUrl(final String s) {
        if (!TextUtils.isEmpty((CharSequence)s)) {
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(s));
            if (intent.resolveActivity(this.getActivity().getPackageManager()) != null) {
                this.startActivity(intent);
            }
        }
    }
    
    public void replaceFragment(final int n, final BaseFragment baseFragment, final boolean b) {
        final FragmentTransaction beginTransaction = this.getFragmentManager().beginTransaction();
        beginTransaction.replace(n, (Fragment)baseFragment, baseFragment.getClass().getName());
        if (b) {
            beginTransaction.addToBackStack(baseFragment.getClass().getName());
        }
        beginTransaction.commit();
    }
    
    protected void showErrorMessage(final String s) {
        ((BaseAppCompatActivity)this.getContext()).showErrorMessage(s, null);
    }
    
    protected void showErrorMessageThenFinish(final String s) {
        final BaseAppCompatActivity baseAppCompatActivity = (BaseAppCompatActivity)this.getContext();
        baseAppCompatActivity.showErrorMessage(s, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                baseAppCompatActivity.finish();
            }
        });
    }
    
    protected void showMessage(final String s) {
        ((BaseAppCompatActivity)this.getContext()).showMessage(s, null);
    }
    
    protected void startFragmentWithFade(final int n, final BaseFragment baseFragment, final boolean b) {
        final FragmentTransaction beginTransaction = this.getFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(17432576, 17432577);
        beginTransaction.replace(n, (Fragment)baseFragment, baseFragment.getClass().getName());
        if (b) {
            beginTransaction.addToBackStack(baseFragment.getClass().getName());
        }
        beginTransaction.commit();
    }
    
    protected void startFragmentWithModel(final int n, final BaseFragment baseFragment, final boolean b) {
        final FragmentTransaction beginTransaction = this.getFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(R.anim.activity_start_up, R.anim.activity_define_black);
        beginTransaction.replace(n, (Fragment)baseFragment, baseFragment.getClass().getName());
        if (b) {
            beginTransaction.addToBackStack(baseFragment.getClass().getName());
        }
        beginTransaction.commit();
    }
    
    protected void startFragmentWithPush(final int n, final BaseFragment baseFragment) {
        final FragmentTransaction beginTransaction = this.getFragmentManager().beginTransaction();
        beginTransaction.setCustomAnimations(R.anim.activity_push_enter, R.anim.activity_define_black);
        beginTransaction.replace(n, (Fragment)baseFragment, baseFragment.getClass().getName());
        beginTransaction.addToBackStack(baseFragment.getClass().getName());
        beginTransaction.commit();
    }
    
    protected void viewDataRefreshed(final Constants.DataRefreshEvent dataRefreshEvent) {
        LogUtils.trace(this);
    }
}
