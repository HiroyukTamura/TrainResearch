// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.db;

import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.BackgroundExecutor$Task;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMyStationData_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppPotAccount_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppData_;
import org.androidannotations.api.view.OnViewChangedNotifier;
import android.content.Context;

public final class AppPotManager_ extends AppPotManager
{
    private static AppPotManager_ instance_;
    private Context context_;
    
    private AppPotManager_(final Context context_) {
        this.context_ = context_;
    }
    
    public static AppPotManager_ getInstance_(final Context context) {
        if (AppPotManager_.instance_ == null) {
            final OnViewChangedNotifier replaceNotifier = OnViewChangedNotifier.replaceNotifier((OnViewChangedNotifier)null);
            (AppPotManager_.instance_ = new AppPotManager_(context.getApplicationContext())).init_();
            OnViewChangedNotifier.replaceNotifier(replaceNotifier);
        }
        return AppPotManager_.instance_;
    }
    
    private void init_() {
        this.mPrefAppData = new PrefAppData_(this.context_);
        this.mAppPotUser = new PrefAppPotAccount_(this.context_);
        this.mStationPref = new PrefMyStationData_(this.context_);
        this.mAppPotDao = AppPotDao_.getInstance_(this.context_);
        this.mContext = this.context_;
    }
    
    @Override
    public void insertDefaultPush() {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppPotManager.this.insertDefaultPush();
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void insertDefaultServiceInfoPushDetail() {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppPotManager.this.insertDefaultServiceInfoPushDetail();
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
}
