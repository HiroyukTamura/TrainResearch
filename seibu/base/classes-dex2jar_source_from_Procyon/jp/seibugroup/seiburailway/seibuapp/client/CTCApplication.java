// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client;

import android.os.Process;
import android.content.Context;
import android.content.Intent;
import jp.seibugroup.seiburailway.seibuapp.client.view.splash.SplashActivity_;
import android.text.TextUtils;
import android.os.Bundle;
import android.app.Activity;
import android.app.Application$ActivityLifecycleCallbacks;
import me.yokeyword.fragmentation.Fragmentation;
import java.util.Locale;
import com.feilang.mvpproject.util.LogUtils;
import org.androidannotations.annotations.sharedpreferences.Pref;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppData_;
import com.feilang.mvpproject.base.BaseAppCompatActivity;
import jp.seibugroup.seiburailway.seibuapp.client.view.MainActivity;
import org.androidannotations.annotations.EApplication;
import android.support.multidex.MultiDexApplication;

@EApplication
public class CTCApplication extends MultiDexApplication
{
    private static MainActivity mMainActivity;
    private static int mPaused;
    private static String mPhoneLanguage;
    private static int mResumed;
    private static BaseAppCompatActivity mTopActivity;
    @Pref
    PrefAppData_ mPrefAppData;
    
    public static MainActivity getMainActivity() {
        return CTCApplication.mMainActivity;
    }
    
    public static BaseAppCompatActivity getTopActivity() {
        return CTCApplication.mTopActivity;
    }
    
    public static boolean isApplicationInForeground() {
        return CTCApplication.mResumed > CTCApplication.mPaused;
    }
    
    public void onCreate() {
        super.onCreate();
        CTCApplication.mPhoneLanguage = Locale.getDefault().toString();
        Fragmentation.builder().stackViewMode(0).debug(false).handleException(CTCApplication$$Lambda$1.lambdaFactory$()).install();
        this.registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)new Application$ActivityLifecycleCallbacks() {
            public void onActivityCreated(final Activity activity, final Bundle bundle) {
                if (!TextUtils.equals((CharSequence)Locale.getDefault().toString(), (CharSequence)CTCApplication.mPhoneLanguage)) {
                    ((PrefAppData_.PrefAppDataEditor_)CTCApplication.this.mPrefAppData.edit().directionNameJson().put("[]")).apply();
                    final Intent intent = new Intent((Context)activity, (Class)SplashActivity_.class);
                    intent.setFlags(268468224);
                    activity.startActivity(intent);
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                }
                if (MainActivity.class.isInstance(activity)) {
                    CTCApplication.mMainActivity = (MainActivity)activity;
                }
            }
            
            public void onActivityDestroyed(final Activity activity) {
                if (MainActivity.class.isInstance(activity)) {
                    CTCApplication.mMainActivity = null;
                }
            }
            
            public void onActivityPaused(final Activity activity) {
                ++CTCApplication.mPaused;
            }
            
            public void onActivityResumed(final Activity activity) {
                ++CTCApplication.mResumed;
                CTCApplication.mTopActivity = (BaseAppCompatActivity)activity;
            }
            
            public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
            }
            
            public void onActivityStarted(final Activity activity) {
            }
            
            public void onActivityStopped(final Activity activity) {
            }
        });
    }
}
