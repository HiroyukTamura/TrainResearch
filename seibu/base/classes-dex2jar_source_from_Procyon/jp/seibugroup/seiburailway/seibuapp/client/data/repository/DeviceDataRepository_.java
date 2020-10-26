// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.repository;

import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.BackgroundExecutor$Task;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.AppPotDao_;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.MasterDaoUtils_;
import jp.seibugroup.seiburailway.seibuapp.client.remote.AppDeviceRestManager_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMyStationData_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppPotAccount_;
import org.androidannotations.api.view.OnViewChangedNotifier;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingPushModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.ApSettingServiceInfoPushDetailModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingStationHistoryModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingCallback;
import android.content.Context;

public final class DeviceDataRepository_ extends DeviceDataRepository
{
    private static DeviceDataRepository_ instance_;
    private Context context_;
    
    private DeviceDataRepository_(final Context context_) {
        this.context_ = context_;
    }
    
    public static DeviceDataRepository_ getInstance_(final Context context) {
        if (DeviceDataRepository_.instance_ == null) {
            final OnViewChangedNotifier replaceNotifier = OnViewChangedNotifier.replaceNotifier((OnViewChangedNotifier)null);
            (DeviceDataRepository_.instance_ = new DeviceDataRepository_(context.getApplicationContext())).init_();
            OnViewChangedNotifier.replaceNotifier(replaceNotifier);
        }
        return DeviceDataRepository_.instance_;
    }
    
    private void init_() {
        this.mAppPotUser = new PrefAppPotAccount_(this.context_);
        this.mStationPref = new PrefMyStationData_(this.context_);
        this.mAppRest = AppDeviceRestManager_.getInstance_(this.context_);
        this.mGreenDao = MasterDaoUtils_.getInstance_(this.context_);
        this.mAppPotDao = AppPotDao_.getInstance_(this.context_);
    }
    
    @Override
    public void clearStationHistory(final APSettingCallback.Common common) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    DeviceDataRepository.this.clearStationHistory(common);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getPushSetting(final APSettingCallback.Select<APSettingPushModel> select) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    DeviceDataRepository.this.getPushSetting(select);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getServiceInfo(final APSettingCallback.Select<ApSettingServiceInfoPushDetailModel> select) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    DeviceDataRepository.this.getServiceInfo(select);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getStationHistoryList(final APSettingCallback.Select<APSettingStationHistoryModel> select) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    DeviceDataRepository.this.getStationHistoryList(select);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void saveMyStation(final String s, final APSettingCallback.Common common) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    DeviceDataRepository.this.saveMyStation(s, common);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void saveMyStationList(final List<BaseStation> list, final APSettingCallback.Common common) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    DeviceDataRepository.this.saveMyStationList(list, common);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void savePushSetting(final APSettingPushModel apSettingPushModel, final APSettingCallback.Common common) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    DeviceDataRepository.this.savePushSetting(apSettingPushModel, common);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void saveServiceInfo(final ApSettingServiceInfoPushDetailModel apSettingServiceInfoPushDetailModel, final APSettingCallback.Common common) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "save_notify_time") {
            public void execute() {
                try {
                    DeviceDataRepository.this.saveServiceInfo(apSettingServiceInfoPushDetailModel, common);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void saveStationHistory(final String s, final APSettingCallback.Common common) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    DeviceDataRepository.this.saveStationHistory(s, common);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
}
