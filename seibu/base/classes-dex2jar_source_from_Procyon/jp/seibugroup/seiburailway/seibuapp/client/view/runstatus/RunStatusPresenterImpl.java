// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.runstatus;

import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import java.util.Collection;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusHistoryWrapper;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import jp.seibugroup.seiburailway.seibuapp.client.util.DateUtils;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import com.feilang.mvpproject.base.BasePresenterClass;

public class RunStatusPresenterImpl extends BasePresenterClass implements RunStatusContract$Presenter
{
    private StationsRepository mRepository;
    private RunStatusContract$View mView;
    
    RunStatusPresenterImpl(@NonNull final RunStatusContract$View runStatusContract$View, @NonNull final StationsRepository stationsRepository) {
        this.mView = Preconditions.checkNotNull(runStatusContract$View);
        this.mRepository = Preconditions.checkNotNull(stationsRepository);
        this.mView.setPresenter((Object)this);
    }
    
    public void getRunStatusHistoryData() {
        this.mRepository.getRunStatusHistory(this, DateUtils.getDateStringYYYYMMDDHHMMSS());
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_RUN_STATUS_HISTORY)
    public void onRunStatusApiFailed() {
        LogUtils.w("API Failed : API_RUN_STATUS_HISTORY ");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_RUN_STATUS_HISTORY)
    public void onRunStatusApiSuccess(final RunStatusHistoryWrapper runStatusHistoryWrapper) {
        this.mView.toHistoryPage(new ArrayList((Collection<? extends E>)runStatusHistoryWrapper.getLineStatus()));
    }
}
