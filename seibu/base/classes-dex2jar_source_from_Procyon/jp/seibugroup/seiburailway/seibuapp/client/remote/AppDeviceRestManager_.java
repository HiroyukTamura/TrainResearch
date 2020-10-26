// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote;

import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.BackgroundExecutor$Task;
import com.feilang.mvpproject.remote.errorhandler.AppRestErrorHandler_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppPotAccount_;
import org.androidannotations.api.view.OnViewChangedNotifier;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.BeaconLocationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.BeaconInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeThreeMessageWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.AppPotUser;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.AppPotGetUserParam;
import android.content.Context;

public final class AppDeviceRestManager_ extends AppDeviceRestManager
{
    private static AppDeviceRestManager_ instance_;
    private Context context_;
    
    private AppDeviceRestManager_(final Context context_) {
        this.context_ = context_;
    }
    
    public static AppDeviceRestManager_ getInstance_(final Context context) {
        if (AppDeviceRestManager_.instance_ == null) {
            final OnViewChangedNotifier replaceNotifier = OnViewChangedNotifier.replaceNotifier((OnViewChangedNotifier)null);
            (AppDeviceRestManager_.instance_ = new AppDeviceRestManager_(context.getApplicationContext())).init_();
            OnViewChangedNotifier.replaceNotifier(replaceNotifier);
        }
        return AppDeviceRestManager_.instance_;
    }
    
    private void init_() {
        this.mAppPotUser = new PrefAppPotAccount_(this.context_);
        this.errorHandlerForUserService = AppRestErrorHandler_.getInstance_(this.context_);
        this.context = this.context_;
        this.restAAService = new AppDeviceRestAAService_(this.context_);
        this.init();
    }
    
    @Override
    public void changeCheckIn(final DataCallWrapper<CheckInData> dataCallWrapper, final String s, final CheckInInfo checkInInfo) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.changeCheckIn(dataCallWrapper, s, checkInInfo);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void deleteBeacon(final DataCallWrapper<Object> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.deleteBeacon(dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void deleteCheckIn(final DataCallWrapper<Object> dataCallWrapper, final String s) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.deleteCheckIn(dataCallWrapper, s);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getCheckIn(final DataCallWrapper<List<CheckInData>> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.getCheckIn(dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getEmerg(final DataCallWrapper<NoticeMessageWrapper> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.getEmerg(dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getEventMessage(final DataCallWrapper<NoticeMessageWrapper> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.getEventMessage(dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getHeadlines(final DataCallWrapper<NoticeMessageWrapper> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.getHeadlines(dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getNoticeMessage(final DataCallWrapper<NoticeMessageWrapper> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.getNoticeMessage(dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getSharedCheckIn(final DataCallWrapper<List<CheckInData>> dataCallWrapper, final String s) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.getSharedCheckIn(dataCallWrapper, s);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getThreeNoticeMessage(final DataCallWrapper<NoticeThreeMessageWrapper> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.getThreeNoticeMessage(dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getUserFromAppPot(final AppPotGetUserParam appPotGetUserParam, final DataCallWrapper<AppPotUser> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.getUserFromAppPot(appPotGetUserParam, dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void getWallpapers(final DataCallWrapper<NoticeMessageWrapper> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.getWallpapers(dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void postBeacon(final BeaconInfo beaconInfo, final DataCallWrapper<BeaconLocationInfo> dataCallWrapper) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.postBeacon(beaconInfo, dataCallWrapper);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
    
    @Override
    public void requestCheckIn(final DataCallWrapper<List<CheckInData>> dataCallWrapper, final CheckInInfo checkInInfo) {
        BackgroundExecutor.execute((BackgroundExecutor$Task)new BackgroundExecutor$Task("", 0L, "") {
            public void execute() {
                try {
                    AppDeviceRestManager.this.requestCheckIn(dataCallWrapper, checkInInfo);
                }
                catch (Throwable t) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), t);
                }
            }
        });
    }
}
