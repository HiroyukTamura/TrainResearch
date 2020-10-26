// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.trainwrapping;

import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import com.annimon.stream.function.Consumer;
import java.util.List;
import java.util.Iterator;
import java.util.Arrays;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import android.text.TextUtils;
import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import java.util.ArrayList;
import java.util.HashMap;
import com.feilang.mvpproject.base.BasePresenterClass;

public class TrainWrappingPresenterImpl extends BasePresenterClass implements TrainWrappingContract$Presenter
{
    private TrainWrappingAdapter mAdapter;
    private HashMap<String, ArrayList<TrainInfo>> mAllTrainData;
    private StationsRepository mRepository;
    private String mSelectedRouteId;
    private String mSelectedTrainId;
    private TrainWrappingContract$View mView;
    
    public TrainWrappingPresenterImpl(@NonNull final StationsRepository stationsRepository, @NonNull final TrainWrappingContract$View trainWrappingContract$View) {
        this.mView = Preconditions.checkNotNull(trainWrappingContract$View);
        this.mRepository = Preconditions.checkNotNull(stationsRepository);
        this.mView.setPresenter((Object)this);
    }
    
    private void findSelectedTrain() {
        final ArrayList<TrainInfo> list = this.mAllTrainData.get(this.mSelectedRouteId);
        if (list == null) {
            this.mView.findTrainFailed();
            return;
        }
        final Optional<TrainInfo> first = Stream.of((Iterable<? extends TrainInfo>)list).filter(TrainWrappingPresenterImpl$$Lambda$2.lambdaFactory$(this)).findFirst();
        if (first.isPresent()) {
            this.mView.findTrainSuccess(first.get().getLineId(), first.get().getTrainId(), first.get().getSectionNo());
            return;
        }
        this.mView.findTrainFailed();
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_TRAIN_LIST)
    void failedStationLines() {
        this.mView.findTrainFailed();
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
        this.mRepository.requestAllTrains(this, "L001+L002+L003+L005+L008+L009+L011+L012+L021+L022+L013+L010", true);
    }
    
    public TrainWrappingAdapter getAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = new TrainWrappingAdapter(this.mView.getContext());
        }
        return this.mAdapter;
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_LIST)
    void receiveStationLines(final Object[] array, final List<TrainInfo> list) {
        Stream.of((Iterable<?>)list).forEach(TrainWrappingPresenterImpl$$Lambda$1.lambdaFactory$(this));
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
