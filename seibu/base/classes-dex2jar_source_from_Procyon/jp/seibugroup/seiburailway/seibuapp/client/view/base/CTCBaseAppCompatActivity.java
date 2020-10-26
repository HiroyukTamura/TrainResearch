// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.base;

import android.widget.TextView;
import android.support.v4.content.ContextCompat;
import android.widget.ImageButton;
import android.view.View$OnClickListener;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.view.MainActivity_;
import org.androidannotations.api.builder.ActivityIntentBuilder;
import com.google.common.eventbus.Subscribe;
import com.feilang.mvpproject.util.LogUtils;
import android.view.KeyEvent;
import jp.seibugroup.seiburailway.seibuapp.client.view.splash.SplashActivity_;
import jp.seibugroup.seiburailway.seibuapp.client.util.AppStatusManager_;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.app.Activity;
import jp.seibugroup.seiburailway.seibuapp.client.util.PopWindow;
import android.view.MotionEvent;
import android.content.Intent;
import android.content.Context;
import jp.seibugroup.seiburailway.seibuapp.client.util.AppUtils;
import android.net.Uri;
import com.feilang.mvpproject.remote.errorhandler.AppRestErrorEvent;
import com.feilang.mvpproject.remote.errorhandler.AppNoResultErrorEvent;
import com.feilang.mvpproject.util.ApiEventDispatchUtils;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.data.models.ErrorData;
import android.content.DialogInterface;
import com.feilang.mvpproject.remote.errorhandler.AppNetWorkErrorEvent;
import com.feilang.mvpproject.base.BaseAppCompatActivity;

public class CTCBaseAppCompatActivity extends BaseAppCompatActivity
{
    private Uri setupAppSource() {
        final Intent intent = this.getIntent();
        if (intent != null && !AppUtils.isFirstOpenApp((Context)this)) {
            return intent.getData();
        }
        return null;
    }
    
    @Override
    public boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        return !PopWindow.isShowing((Activity)this) && super.dispatchTouchEvent(motionEvent);
    }
    
    @Override
    protected Toolbar getToolbar() {
        return (Toolbar)this.findViewById(2131689658);
    }
    
    @Override
    public void onBackPressedSupport() {
        if (this.getSupportFragmentManager().getBackStackEntryCount() > 1) {
            this.pop();
            return;
        }
        ActivityCompat.finishAfterTransition(this);
    }
    
    @Override
    protected void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        if (AppStatusManager_.getInstance_((Context)this).getAppStatus() == -1) {
            this.startActivity(new Intent((Context)this, (Class)SplashActivity_.class).setFlags(268468224));
            this.finish();
        }
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n != 4) {
            return super.onKeyDown(n, keyEvent);
        }
        if (PopWindow.isShowing((Activity)this)) {
            PopWindow.close();
            return false;
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    @Subscribe
    @Override
    public void onNetWorkError(final AppNetWorkErrorEvent appNetWorkErrorEvent) {
        LogUtils.outputLog("AppNetWorkErrorEvent, errorMessage = " + appNetWorkErrorEvent.errorMessage);
        if (this.isNeedIgnoreError(appNetWorkErrorEvent.callback)) {
            final ErrorData errorData = new ErrorData("", appNetWorkErrorEvent.errorMessage);
            errorData.setTag(appNetWorkErrorEvent.callback.tag);
            ApiEventDispatchUtils.dispatchFailedEvent(appNetWorkErrorEvent.callback.getCaller(), new DataNotifyEvent(appNetWorkErrorEvent.callback.getCaller(), appNetWorkErrorEvent.callback.identifier, errorData));
            return;
        }
        this.showErrorMessage(this.getString(2131230853), CTCBaseAppCompatActivity$$Lambda$3.lambdaFactory$(appNetWorkErrorEvent));
    }
    
    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        if (!this.getLocalClassName().contains("splash")) {
            final Uri setupAppSource = this.setupAppSource();
            AppStatusManager_.getInstance_((Context)this).setAppSource(setupAppSource);
            if (setupAppSource != null) {
                this.entryActivity((ActivityIntentBuilder)MainActivity_.intent((Context)this).flags(67108864));
            }
        }
    }
    
    @Subscribe
    public void onNoResultError(final AppNoResultErrorEvent appNoResultErrorEvent) {
        LogUtils.outputLog("AppNoResultErrorEvent");
        this.runOnUiThread(CTCBaseAppCompatActivity$$Lambda$1.lambdaFactory$(this, appNoResultErrorEvent));
    }
    
    @Subscribe
    @Override
    public void onRestError(final AppRestErrorEvent appRestErrorEvent) {
        LogUtils.outputLog("AppRestErrorEvent, errorCode = " + appRestErrorEvent.errorCode + ", errorMessage = " + appRestErrorEvent.errorMessage);
        String s = this.getString(2131230853);
        if (TextUtils.equals((CharSequence)appRestErrorEvent.errorMessage.getCode(), (CharSequence)"E0234")) {
            s = this.getString(2131230841);
        }
        this.runOnUiThread(CTCBaseAppCompatActivity$$Lambda$2.lambdaFactory$(this, s, appRestErrorEvent));
    }
    
    protected void setToolBarRightButton(final int imageResource, final View$OnClickListener onClickListener) {
        final ImageButton imageButton = (ImageButton)this.toolbar.findViewById(2131689978);
        imageButton.setImageResource(imageResource);
        imageButton.setVisibility(0);
        imageButton.setOnClickListener(onClickListener);
    }
    
    protected void setToolbarColor(final int n) {
        this.toolbar.setBackgroundColor(ContextCompat.getColor(this.getBaseContext(), n));
    }
    
    protected void setToolbarRightText(final int text, final View$OnClickListener onClickListener) {
        final TextView textView = (TextView)this.toolbar.findViewById(2131689979);
        textView.setText(text);
        textView.setVisibility(0);
        textView.setOnClickListener(onClickListener);
    }
    
    protected void showBackButton(final View$OnClickListener navigationOnClickListener) {
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.toolbar.setNavigationOnClickListener(navigationOnClickListener);
    }
    
    protected void showCloseButton(final View$OnClickListener navigationOnClickListener) {
        this.toolbar.setNavigationIcon(2130837770);
        this.toolbar.setNavigationOnClickListener(navigationOnClickListener);
    }
}
