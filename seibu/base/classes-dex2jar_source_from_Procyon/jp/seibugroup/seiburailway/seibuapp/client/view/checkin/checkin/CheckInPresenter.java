// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.checkin.checkin;

import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingPushModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingCallback;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInInfo;
import com.feilang.mvpproject.base.BasePresenterClass;

public class CheckInPresenter extends BasePresenterClass implements CheckInContract$Presenter
{
    private CheckInInfo mCheckInInfo;
    private DeviceDataRepository mDeviceDataRepository;
    private MasterDataRepository mMasterDataRepository;
    CheckInContract$View mView;
    
    public CheckInPresenter(@NonNull final MasterDataRepository masterDataRepository, @NonNull final DeviceDataRepository deviceDataRepository, @NonNull final CheckInContract$View checkInContract$View) {
        this.mDeviceDataRepository = Preconditions.checkNotNull(deviceDataRepository);
        this.mMasterDataRepository = Preconditions.checkNotNull(masterDataRepository);
        (this.mView = Preconditions.checkNotNull(checkInContract$View)).setPresenter((Object)this);
    }
    
    public void checkIn() {
        this.mView.showProgress();
        this.mDeviceDataRepository.requestCheckIn(this, this.mCheckInInfo, false);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_REQUEST_CHECK_IN)
    void failedCheckInData() {
        this.mView.hideProgress();
        this.mView.showErrorMessage();
        LogUtils.w("API Failed : API_REQUEST_CHECK_IN ");
    }
    
    public void getPushSetting() {
        this.mView.showProgress();
        this.mDeviceDataRepository.getPushSetting((APSettingCallback.Select<APSettingPushModel>)new CheckInPresenter$1(this));
    }
    
    public String getStationIdByName(final String s) {
        final BaseStation station = this.mMasterDataRepository.getStation(s);
        if (station != null) {
            return station.getId();
        }
        return "";
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_REQUEST_CHECK_IN)
    void receiveCheckInData(final List<CheckInData> list) {
        this.mView.hideProgress();
        this.mView.checkInDone((List)list);
    }
    
    public void saveNotifySettings(final APSettingPushModel apSettingPushModel) {
        this.mView.showProgress();
        this.mDeviceDataRepository.savePushSetting(apSettingPushModel, (APSettingCallback.Common)new CheckInPresenter$2(this));
    }
    
    public void setCheckInInfo(final CheckInInfo mCheckInInfo) {
        this.mCheckInInfo = mCheckInInfo;
    }
}
