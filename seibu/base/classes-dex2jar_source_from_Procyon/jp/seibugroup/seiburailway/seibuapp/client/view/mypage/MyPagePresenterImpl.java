// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.mypage;

import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingPushModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingCallback;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageData;
import java.util.ArrayList;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import com.feilang.mvpproject.base.BasePresenterClass;

public class MyPagePresenterImpl extends BasePresenterClass implements MyPageContract$Presenter
{
    private DeviceDataRepository mDeviceDataRepository;
    private MyPageContract$View mView;
    
    public MyPagePresenterImpl(@NonNull final DeviceDataRepository deviceDataRepository, @NonNull final MyPageContract$View myPageContract$View) {
        this.mDeviceDataRepository = Preconditions.checkNotNull(deviceDataRepository);
        (this.mView = Preconditions.checkNotNull(myPageContract$View)).setPresenter((Object)this);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_WALLPAPERS)
    public void failedWallPaperData() {
        if (this.mView.isDestroyed()) {
            return;
        }
        LogUtils.w("API Failed : API_WALLPAPERS");
    }
    
    public ArrayList<NoticeMessageData> getPictureWallPaperData() {
        return this.mDeviceDataRepository.wallpaper;
    }
    
    public void getPictureWallPaperDataApi() {
        this.mDeviceDataRepository.getWallpapers(this);
    }
    
    public void getSettingsData() {
        this.mDeviceDataRepository.getPushSetting((APSettingCallback.Select<APSettingPushModel>)new MyPagePresenterImpl$1(this));
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_WALLPAPERS)
    public void receiveWallPaperData(final String s, final ArrayList<NoticeMessageData> list) {
        if (this.mView.isDestroyed()) {
            return;
        }
        this.mView.toPictureWallPaperPage((ArrayList)list);
    }
}
