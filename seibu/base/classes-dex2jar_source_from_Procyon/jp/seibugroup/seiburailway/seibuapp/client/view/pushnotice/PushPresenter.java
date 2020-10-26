// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.pushnotice;

import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.remote.fcm.NotificationBroadcastReceiver;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusDataWrapper;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import com.feilang.mvpproject.base.BasePresenterClass;

public class PushPresenter extends BasePresenterClass
{
    private StationsRepository mStationsRepository;
    
    public PushPresenter(@NonNull final StationsRepository stationsRepository) {
        this.mStationsRepository = Preconditions.checkNotNull(stationsRepository);
    }
    
    public void getRunStatus() {
        this.mStationsRepository.getRunStatusData(this, true, false, true);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_RUN_STATUS_MESSAGE)
    public void onRunStatusApiFailed() {
        CTCEventBus.post("background_open_push");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_RUN_STATUS_MESSAGE)
    public void onRunStatusApiSuccess(final Object[] array, final RunStatusDataWrapper runStatusDataWrapper) {
        this.stopReceiveDataEvent();
        NotificationBroadcastReceiver.getRunStatusSuccess(runStatusDataWrapper);
    }
}
