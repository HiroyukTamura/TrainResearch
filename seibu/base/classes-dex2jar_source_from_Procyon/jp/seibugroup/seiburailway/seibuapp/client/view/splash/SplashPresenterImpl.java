// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.splash;

import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.DayNightTime;
import jp.seibugroup.seiburailway.seibuapp.client.util.PopWindow;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import com.feilang.mvpproject.base.annotations.Succeed;
import com.feilang.mvpproject.base.annotations.Failed;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.AppPotGetUserParam;
import jp.seibugroup.seiburailway.seibuapp.client.CTCApplication_;
import jp.seibugroup.seiburailway.seibuapp.client.util.LinkUrlUtils;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.Stage;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import org.androidannotations.api.UiThreadExecutor;
import jp.seibugroup.seiburailway.seibuapp.client.util.AppUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.Maintenance;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefWallPaperData_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppTestData_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppData_;
import com.feilang.mvpproject.util.Pipeline;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.AppPotManager_;
import com.feilang.mvpproject.base.BasePresenterClass;

public class SplashPresenterImpl extends BasePresenterClass implements SplashContract$Presenter
{
    private AppPotManager_ mAppPotManager;
    private DeviceDataRepository_ mDeviceRepository;
    private boolean mIgnoreMaintenanceError;
    private Pipeline mPipeline;
    private PrefAppData_ mPrefAppData;
    private PrefAppTestData_ mPrefAppTestData;
    private PrefWallPaperData_ mPrefWallPaperData;
    private MasterDataRepository_ mRepository;
    private SplashContract$View mView;
    
    SplashPresenterImpl(@NonNull final SplashContract$View splashContract$View) {
        (this.mView = Preconditions.checkNotNull(splashContract$View)).setPresenter((Object)this);
    }
    
    private boolean checkMaintenance(final Maintenance maintenance) {
        return maintenance != null && maintenance.getMaintenance() != null && maintenance.getMaintenance().isMaintenancing();
    }
    
    private boolean checkVersionup(final Maintenance maintenance) {
        return maintenance != null && maintenance.getAppVersion() != null && maintenance.getAppVersion().isNewerThanCurrent(AppUtils.getApplicationVersion(this.mView.getContext()));
    }
    
    private void closeApp() {
        UiThreadExecutor.runTask("Close", SplashPresenterImpl$$Lambda$2.lambdaFactory$(this), 0L);
    }
    
    private void goNext(final long n) {
        UiThreadExecutor.runTask("Splash", SplashPresenterImpl$$Lambda$1.lambdaFactory$(this), n);
    }
    
    private void init() {
        (this.mPipeline = new Pipeline(null, true) {
            @Stage(RestEvent = DataNotifyEvent.ApiEventType.API_APP_POT_DONE, order = 2)
            AsyncResult configAppPot(final Constants.Result result) {
                if (this.isPreviousStageFailed()) {
                    this.abort("stop");
                }
                SplashPresenterImpl.this.mAppPotManager.init();
                return AsyncResult.make();
            }
            
            @Stage(RestEvent = DataNotifyEvent.ApiEventType.API_MASTER_DATA, value = Stage.Type.AC)
            AsyncResult downloadMaster(final Void void1) {
                if (!SplashPresenterImpl.this.mRepository.updateDataIfNeed(this)) {
                    if (SplashPresenterImpl.this.mRepository.readDataFromDB()) {
                        this.nextStage(Constants.Result.SUCCESS);
                    }
                    else {
                        this.abort("stop");
                    }
                }
                return AsyncResult.make();
            }
            
            @Stage(RestEvent = DataNotifyEvent.ApiEventType.API_APP_POT_ACCOUNT, order = 1)
            AsyncResult getAccount(final Constants.Result result) {
                if (this.isPreviousStageFailed() && !SplashPresenterImpl.this.mRepository.readDataFromDB()) {
                    this.abort("stop");
                }
                if (SplashPresenterImpl.this.mDeviceRepository.isSaveUser()) {
                    this.nextStage(Constants.Result.SUCCESS);
                }
                else {
                    ((PrefWallPaperData_.PrefWallPaperDataEditor_)SplashPresenterImpl.this.mPrefWallPaperData.edit().wallPaperUrl().put(LinkUrlUtils.getLinkUrlByNo(SplashPresenterImpl.this.mView.getContext(), "13"))).apply();
                    SplashPresenterImpl.this.mDeviceRepository.getUserFromAppPot(this, new AppPotGetUserParam(CTCApplication_.getInstance().getPackageName(), "1.0", "960f4622a1ad40069c7ea589f489c131"));
                }
                return AsyncResult.make();
            }
            
            @Failed
            void onFailed(final int n, final Exception ex) {
                SplashPresenterImpl.this.closeApp();
            }
            
            @Succeed
            void onSucceed(final Constants.Result result) {
                if (Constants.Result.SUCCESS == result) {
                    SplashPresenterImpl.this.goNext(Math.max(3000L - this.resumedTime(), 0L));
                    return;
                }
                SplashPresenterImpl.this.closeApp();
            }
        }).open();
    }
    
    public void destroyPipeline() {
        if (this.mPipeline != null) {
            this.mPipeline.close();
            this.mPipeline = null;
        }
    }
    
    public void getMaintenance(final boolean b, final boolean mIgnoreMaintenanceError) {
        this.mIgnoreMaintenanceError = mIgnoreMaintenanceError;
        this.mRepository.getMaintenance(this, b, mIgnoreMaintenanceError);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_CHECK_MAINTENANCE)
    public void onFailedMaintenance() {
        LogUtils.w("get Maintenance:onFailure");
        if (this.mIgnoreMaintenanceError) {
            this.mView.closeApp();
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_CHECK_MAINTENANCE)
    public void onSuccessMaintenance(final Maintenance maintenance) {
        PopWindow.close(false);
        if (this.mPrefAppTestData.isValidMaintenance().get()) {
            if (this.checkMaintenance(maintenance)) {
                this.mView.showMaintenanceView(maintenance.getMaintenance());
                return;
            }
            if (this.checkVersionup(maintenance)) {
                this.mView.showUpdateDialog(maintenance.getStoreUrl().getAndroidStoreUrl());
                return;
            }
        }
        final DayNightTime dayNightTime = maintenance.getDayNightTime();
        if (dayNightTime != null) {
            ((PrefAppData_.PrefAppDataEditor_)this.mPrefAppData.edit().dayStartTime().put(dayNightTime.getDayStartTime())).apply();
            ((PrefAppData_.PrefAppDataEditor_)this.mPrefAppData.edit().nightStartTime().put(dayNightTime.getNightStartTime())).apply();
        }
        this.init();
    }
    
    @Override
    public void start() {
        super.start();
        this.mRepository = MasterDataRepository_.getInstance_(this.mView.getContext());
        this.mDeviceRepository = DeviceDataRepository_.getInstance_(this.mView.getContext());
        this.mPrefAppData = new PrefAppData_(this.mView.getContext());
        this.mPrefAppTestData = new PrefAppTestData_(this.mView.getContext());
        this.mPrefWallPaperData = new PrefWallPaperData_(this.mView.getContext());
        this.mAppPotManager = AppPotManager_.getInstance_(this.mView.getContext());
        this.getMaintenance(false, true);
    }
    
    @Override
    public void stop() {
        super.stop();
        UiThreadExecutor.cancelAll("Splash");
    }
}
