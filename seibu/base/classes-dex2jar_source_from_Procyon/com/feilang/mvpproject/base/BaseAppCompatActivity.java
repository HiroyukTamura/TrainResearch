// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.base;

import android.support.annotation.UiThread;
import android.widget.TextView;
import android.content.DialogInterface$OnClickListener;
import android.support.v7.app.ActionBar;
import com.feilang.mvpproject.util.AppEventBus;
import android.content.Intent;
import com.google.common.eventbus.Subscribe;
import android.view.Menu;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import com.feilang.mvpproject.util.LogUtils;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import android.graphics.PorterDuff$Mode;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.content.Context;
import com.feilang.mvpproject.R;
import com.feilang.mvpproject.remote.errorhandler.AppRestErrorEvent;
import com.feilang.mvpproject.util.ApiEventDispatchUtils;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.data.models.ErrorData;
import android.content.DialogInterface;
import com.feilang.mvpproject.remote.errorhandler.AppNetWorkErrorEvent;
import android.support.v7.widget.Toolbar;
import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import me.yokeyword.fragmentation.SupportActivity;

public abstract class BaseAppCompatActivity extends SupportActivity
{
    private static final int ANIM_MODE_DEFAULT = 0;
    private static final int ANIM_MODE_FADE = 3;
    private static final int ANIM_MODE_MODEL = 2;
    private static final int ANIM_MODE_PUSH = 1;
    private static final String INTENT_KEY_ANIM = "INTENT_KEY_ANIM";
    private int animeMode;
    private AlertDialog mErrorDialog;
    private Dialog mProgressDialog;
    protected Toolbar toolbar;
    
    private void showProgress() {
        if (!this.isFinishing() && this.mProgressDialog == null) {
            (this.mProgressDialog = new Dialog((Context)this, R.style.ContentTransparent)).setContentView(R.layout.dialog_progress);
            final ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar)this.mProgressDialog.findViewById(R.id.bar_processing);
            if (contentLoadingProgressBar != null) {
                contentLoadingProgressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor((Context)this, R.color.colorAccent), PorterDuff$Mode.SRC_IN);
            }
            this.mProgressDialog.setCancelable(false);
            this.mProgressDialog.show();
        }
    }
    
    public <T extends ActivityIntentBuilder> void entryActivity(final T t) {
        t.get().putExtra("INTENT_KEY_ANIM", 3);
        t.start().withAnimation(17432576, R.anim.activity_define_black);
    }
    
    public void finish() {
        super.finish();
        LogUtils.trace(this);
        switch (this.animeMode) {
            default: {}
            case 2: {
                this.overridePendingTransition(0, R.anim.activity_close_down);
            }
            case 1: {
                this.overridePendingTransition(0, 17432579);
            }
            case 3: {
                this.overridePendingTransition(0, 17432577);
            }
        }
    }
    
    protected String getProgressLoadingTip() {
        return null;
    }
    
    protected abstract Toolbar getToolbar();
    
    protected void hideProgress() {
        if (this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
    }
    
    protected boolean isNeedIgnoreError(final DataCallWrapper dataCallWrapper) {
        return dataCallWrapper == null || (DataCallWrapper.class.isInstance(dataCallWrapper) && dataCallWrapper.ignoreError);
    }
    
    public <T extends ActivityIntentBuilder> void modelActivity(final T t) {
        t.get().putExtra("INTENT_KEY_ANIM", 2);
        t.start().withAnimation(R.anim.activity_start_up, R.anim.activity_define_black);
    }
    
    public <T extends ActivityIntentBuilder> void modelActivityForResult(final T t, final int n) {
        t.get().putExtra("INTENT_KEY_ANIM", 2);
        t.startForResult(n).withAnimation(R.anim.activity_start_up, R.anim.activity_define_black);
    }
    
    @Override
    public void onAttachFragment(final Fragment fragment) {
        super.onAttachFragment(fragment);
        LogUtils.trace(this);
    }
    
    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }
    
    @Override
    protected void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        LogUtils.trace(this);
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        return true;
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.trace(this);
    }
    
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        LogUtils.trace(this);
    }
    
    @Subscribe
    public void onNetWorkError(final AppNetWorkErrorEvent appNetWorkErrorEvent) {
        LogUtils.outputLog("AppNetWorkErrorEvent, errorMessage = " + appNetWorkErrorEvent.errorMessage);
        if (this.isNeedIgnoreError(appNetWorkErrorEvent.callback)) {
            final ErrorData errorData = new ErrorData("", appNetWorkErrorEvent.errorMessage);
            errorData.setTag(appNetWorkErrorEvent.callback.tag);
            ApiEventDispatchUtils.dispatchFailedEvent(appNetWorkErrorEvent.callback.getCaller(), new DataNotifyEvent(appNetWorkErrorEvent.callback.getCaller(), appNetWorkErrorEvent.callback.identifier, errorData));
            return;
        }
        this.showNetworkErrorMessage("error", appNetWorkErrorEvent.errorMessage, BaseAppCompatActivity$$Lambda$2.lambdaFactory$(appNetWorkErrorEvent));
    }
    
    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.trace(this);
        try {
            AppEventBus.getInstance().unregister(this);
        }
        catch (IllegalArgumentException ex) {
            LogUtils.outputLog("AppEventBus unregister failed, this: " + this.getLocalClassName());
        }
    }
    
    @Subscribe
    public void onProgress(final String s) {
        this.runOnUiThread((Runnable)new Runnable() {
            @Override
            public void run() {
                if (s.equals("KEY_PROGRESS_START")) {
                    BaseAppCompatActivity.this.showProgress();
                }
                else if (s.equals("KEY_PROGRESS_STOP")) {
                    BaseAppCompatActivity.this.hideProgress();
                }
            }
        });
    }
    
    @Subscribe
    public void onRestError(final AppRestErrorEvent appRestErrorEvent) {
        LogUtils.outputLog("AppRestErrorEvent, errorCode = " + appRestErrorEvent.errorCode + ", errorMessage = " + appRestErrorEvent.errorMessage);
        String message = "\u30a8\u30e9\u30fc\u767a\u751f\u3057\u307e\u3057\u305f\u3002";
        if (appRestErrorEvent.errorMessage.getMessage() != null) {
            message = appRestErrorEvent.errorMessage.getMessage();
        }
        this.runOnUiThread(BaseAppCompatActivity$$Lambda$1.lambdaFactory$(this, message, appRestErrorEvent));
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.trace(this);
        this.animeMode = this.getIntent().getIntExtra("INTENT_KEY_ANIM", 0);
        AppEventBus.getInstance().register(this);
    }
    
    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        LogUtils.trace(this);
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.trace(this);
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.trace(this);
    }
    
    public <T extends ActivityIntentBuilder> void pushActivity(final T t) {
        t.get().putExtra("INTENT_KEY_ANIM", 1);
        t.start().withAnimation(R.anim.slide_in_right, R.anim.activity_define_black);
    }
    
    public void setActionBarAppearence(final boolean b) {
        final ActionBar supportActionBar = this.getSupportActionBar();
        if (supportActionBar != null) {
            if (!b) {
                supportActionBar.hide();
                return;
            }
            supportActionBar.show();
        }
    }
    
    protected void setToolbarTitle(final String title) {
        this.setSupportActionBar(this.toolbar = this.getToolbar());
        this.toolbar.setTitle(title);
        final ActionBar supportActionBar = this.getSupportActionBar();
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }
    
    protected void setupToolbar(final int title) {
        (this.toolbar = this.getToolbar()).setTitle(title);
        this.setSupportActionBar(this.toolbar);
        final ActionBar supportActionBar = this.getSupportActionBar();
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }
    
    public void showErrorMessage(final String s, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        this.showErrorMessage("", s, null, dialogInterface$OnClickListener);
    }
    
    @UiThread
    public void showErrorMessage(final String title, final String message, String s, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        if (!this.isFinishing() && this.mErrorDialog == null) {
            if (s == null) {
                s = "OK";
            }
            (this.mErrorDialog = new AlertDialog.Builder((Context)this).setTitle(title).setMessage(message).setPositiveButton(s, dialogInterface$OnClickListener).create()).setOnDismissListener(BaseAppCompatActivity$$Lambda$4.lambdaFactory$(this));
            this.mErrorDialog.setCancelable(false);
            this.mErrorDialog.show();
            if (title == null) {
                final TextView textView = (TextView)this.mErrorDialog.findViewById(16908299);
                if (textView != null) {
                    textView.setGravity(17);
                }
            }
        }
    }
    
    protected void showErrorMessageThenFinish(final String s) {
        this.showErrorMessage(s, BaseAppCompatActivity$$Lambda$3.lambdaFactory$(this));
    }
    
    public void showMessage(final String s, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        this.showErrorMessage(null, s, null, dialogInterface$OnClickListener);
    }
    
    public void showNetworkErrorMessage(final String s, final String s2, final DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        this.showErrorMessage(s, s2, null, dialogInterface$OnClickListener);
    }
}
