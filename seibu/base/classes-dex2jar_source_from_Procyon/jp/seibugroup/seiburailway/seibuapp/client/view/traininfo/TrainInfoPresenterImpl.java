// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.traininfo;

import com.annimon.stream.function.Consumer;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.DestinationsInfo;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository_;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import java.util.ArrayList;
import java.util.HashMap;
import com.feilang.mvpproject.base.BasePresenterClass;

public class TrainInfoPresenterImpl extends BasePresenterClass implements TrainInfoContract$Presenter
{
    private HashMap<String, ArrayList<TrainInfo>> mAllTrainData;
    private DeviceDataRepository mDeviceRepository;
    private MasterDataRepository mMasterDataRepository;
    private StationsRepository mRepository;
    private String mSelectedRouteId;
    private String mSelectedTrainId;
    private ArrayList<TrainInfo> mTrainInfoList;
    private TrainInfoContract$View mView;
    
    TrainInfoPresenterImpl(@NonNull final TrainInfoContract$View trainInfoContract$View) {
        (this.mView = Preconditions.checkNotNull(trainInfoContract$View)).setPresenter((Object)this);
        this.mMasterDataRepository = MasterDataRepository_.getInstance_(this.mView.getContext());
        this.mRepository = StationsRepository_.getInstance_(this.mView.getContext());
        this.mDeviceRepository = DeviceDataRepository_.getInstance_(this.mView.getContext());
    }
    
    private void findSelectedTrain() {
        final ArrayList<TrainInfo> list = this.mAllTrainData.get(this.mSelectedRouteId);
        if (list == null) {
            this.mView.onApiFailed();
            return;
        }
        final Optional<TrainInfo> first = Stream.of((Iterable<? extends TrainInfo>)list).filter(TrainInfoPresenterImpl$$Lambda$3.lambdaFactory$(this)).findFirst();
        if (first.isPresent()) {
            this.mView.findTrainSuccess(first.get().getLineId(), first.get().getTrainId(), first.get().getSectionNo());
            return;
        }
        this.mView.findTrainSuccess(this.mSelectedRouteId, (String)null, 0);
    }
    
    public void checkout(final String s) {
        final Optional<CheckInData> first = Stream.of((Iterable<? extends CheckInData>)this.mDeviceRepository.getCheckInTrains()).filter(TrainInfoPresenterImpl$$Lambda$1.lambdaFactory$(s)).findFirst();
        if (first.isPresent()) {
            this.mDeviceRepository.deleteCheckIn(this, first.get().getCheckinId(), false);
            this.mView.showProgress();
        }
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_GET_CHECK_IN)
    void failedCheckInData() {
        LogUtils.w("API Failed : API_GET_CHECK_IN ");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_DESTINATIONSINfO)
    void failedDestinationData() {
        this.mView.hideProgress();
        this.mView.onApiFailed();
        LogUtils.w("API Failed : API_DESTINATIONSINfO ");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_TRAIN_LIST)
    void failedStationLines() {
        this.mView.hideProgress();
        this.mView.onApiFailed();
    }
    
    public void findSelectedTrainInAllTrainData(final String mSelectedRouteId, String s) {
        this.mSelectedRouteId = mSelectedRouteId;
        this.mSelectedTrainId = s;
        this.mAllTrainData = new HashMap<String, ArrayList<TrainInfo>>();
        final Iterator<String> iterator = Arrays.asList("L001+L002+L003+L005+L008+L009+L011+L012+L021+L022+L013+L010".split("\\+")).iterator();
        while (iterator.hasNext()) {
            s = iterator.next();
            this.mAllTrainData.put(s, new ArrayList<TrainInfo>());
        }
        this.mRepository.requestAllTrains(this, "L001+L002+L003+L005+L008+L009+L011+L012+L021+L022+L013+L010", false);
        this.mView.showProgress();
    }
    
    public void getCheckinByApi() {
        this.mDeviceRepository.getCheckIn(this, true, true);
    }
    
    public void getCheckinData(final ArrayList<TrainInfo> mTrainInfoList) {
        this.mTrainInfoList = mTrainInfoList;
        this.mView.setupTrainRecyclerView((ArrayList)this.mTrainInfoList, (List)this.mDeviceRepository.getCheckInTrains());
    }
    
    public void getDestinationsInfo(final String s, final String s2, final String s3) {
        this.mRepository.getDestinationsInfo(this, s3, s, s2, false);
    }
    
    public String getStationNameById(final String s) {
        final BaseStation stationById = this.mMasterDataRepository.getStationById(s);
        if (stationById != null) {
            return stationById.getKanjiName();
        }
        return "";
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_DELETE_CHECK_IN)
    void onCheckOutFailed() {
        this.mView.hideProgress();
        this.mView.checkOutDone(false);
        LogUtils.w("API Failed : API_DELETE_CHECK_IN ");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_DELETE_CHECK_IN)
    void onCheckOutSuccess(final Object o) {
        this.mView.hideProgress();
        this.mView.checkOutDone(true);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_GET_CHECK_IN)
    void receiveCheckInData(final Object[] array, final List<CheckInData> list) {
        if (array.length > 0 && (int)array[0] == this.hashCode()) {
            CTCEventBus.post(list);
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_DESTINATIONSINfO)
    void receiveDestinationData(final DestinationsInfo destinationsInfo) {
        this.mView.hideProgress();
        this.mView.showDestinations(destinationsInfo);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_LIST)
    void receiveStationLines(final Object[] array, final List<TrainInfo> list) {
        this.mView.hideProgress();
        Stream.of((Iterable<?>)list).forEach(TrainInfoPresenterImpl$$Lambda$2.lambdaFactory$(this));
        CTCEventBus.post(this.mAllTrainData);
        this.findSelectedTrain();
    }
    
    @Override
    public void start() {
        super.start();
        CTCEventBus.register(this);
    }
    
    @Override
    public void stop() {
        super.stop();
        CTCEventBus.unregister(this);
    }
}
