// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.trainposition;

import org.androidannotations.api.UiThreadExecutor;
import java.util.Arrays;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.util.CheckinUtils;
import com.google.gson.Gson;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationDetailInfo;
import com.google.common.eventbus.Subscribe;
import java.util.Date;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.Collector;
import com.annimon.stream.Collectors;
import com.annimon.stream.function.Function;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseRoute;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import com.feilang.mvpproject.util.AppEventBus;
import com.feilang.mvpproject.data.datasource.DataNotifyEventBus;
import java.util.Collection;
import java.util.Iterator;
import java.util.HashMap;
import android.text.TextUtils;
import com.google.common.collect.Lists;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TransferData;
import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import android.support.v4.util.Pair;
import com.annimon.stream.Stream;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseConfig;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefSharedData_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import java.util.Map;
import java.util.List;
import com.feilang.mvpproject.base.BasePresenterClass;

public class StationPositionPresenterImpl extends BasePresenterClass implements StationPositionContract$Presenter
{
    private List<String> mAllSharedIds;
    private Map<String, List<TrainInfo>> mAllTrainData;
    private int mCallBackSize;
    private DeviceDataRepository mDeviceRepository;
    private boolean mIsDataChanged;
    private boolean mIsPopup;
    private boolean mIsToTrainInfo;
    private boolean mLoadingMap;
    private boolean mNeedApiProgress;
    private StationsRepository mRepository;
    private String mSaveLineId;
    private List<TrainInfo> mSaveTrains;
    private List<CheckInData> mSharedDatas;
    private PrefSharedData_ mSharedPref;
    private int mTrainIdSize;
    private List<TrainInfo> mTrainInfoList;
    private StationPositionContract$View mView;
    
    StationPositionPresenterImpl(@NonNull final StationPositionContract$View stationPositionContract$View) {
        this.mNeedApiProgress = false;
        this.mIsDataChanged = false;
        this.mIsPopup = false;
        this.mIsToTrainInfo = false;
        this.mTrainIdSize = 0;
        this.mCallBackSize = 0;
        this.mTrainInfoList = new ArrayList<TrainInfo>();
        this.mSharedDatas = new ArrayList<CheckInData>();
        this.mAllSharedIds = new ArrayList<String>();
        (this.mView = Preconditions.checkNotNull(stationPositionContract$View)).setPresenter((Object)this);
        this.mRepository = StationsRepository_.getInstance_(this.mView.getContext());
        this.mDeviceRepository = DeviceDataRepository_.getInstance_(this.mView.getContext());
    }
    
    private String getRealRoute(final String s) {
        final Optional<Pair> first = Stream.of((Pair[])BaseConfig.BRANCH_ROUTE).filter(StationPositionPresenterImpl$$Lambda$10.lambdaFactory$(s)).findFirst();
        if (first.isPresent()) {
            return (String)first.get().second;
        }
        return s;
    }
    
    private List<TransferData> insertSection(final List<TransferData> list) {
        List<TransferData> arrayList2;
        if (list != null && list.size() > 0) {
            final ArrayList<Object> arrayList = Lists.newArrayList((Iterable<?>)list);
            String s = "";
            int n = 0;
            while (true) {
                arrayList2 = (List<TransferData>)arrayList;
                if (n >= arrayList.size()) {
                    break;
                }
                final TransferData transferData = arrayList.get(n);
                String companyId = s;
                if (!TextUtils.equals((CharSequence)transferData.getCompanyId(), (CharSequence)s)) {
                    companyId = transferData.getCompanyId();
                    arrayList.add(n, new TransferData("section_type", transferData.getCompany()));
                }
                ++n;
                s = companyId;
            }
        }
        else {
            arrayList2 = (List<TransferData>)Lists.newArrayList();
        }
        return arrayList2;
    }
    
    private List<TrainInfo> removeRepeatTrain(final List<TrainInfo> list) {
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        for (final TrainInfo trainInfo : list) {
            hashMap.put(trainInfo.getTrainId(), trainInfo);
        }
        return (List<TrainInfo>)Lists.newArrayList((Iterable<?>)hashMap.values());
    }
    
    private void requestTrainsByRouteId(final String s) {
        if (TextUtils.equals((CharSequence)s, (CharSequence)"L009")) {
            this.mSaveTrains.addAll(this.mAllTrainData.get(s));
            this.requestTrainsByRouteId("L010");
            return;
        }
        if (TextUtils.equals((CharSequence)s, (CharSequence)"L001")) {
            this.mSaveTrains.addAll((Collection<? extends TrainInfo>)Stream.of((Iterable<?>)this.mAllTrainData.get(s)).filter(StationPositionPresenterImpl$$Lambda$8.lambdaFactory$()).toList());
            this.requestTrainsByRouteId("L003");
            return;
        }
        if (TextUtils.equals((CharSequence)s, (CharSequence)"L003")) {
            this.mSaveTrains.addAll(this.mAllTrainData.get(s));
        }
        else if (TextUtils.equals((CharSequence)s, (CharSequence)"L010")) {
            this.mSaveTrains.addAll(this.mAllTrainData.get(s));
        }
        else if (TextUtils.equals((CharSequence)s, (CharSequence)"L008")) {
            this.mSaveTrains.addAll((Collection<? extends TrainInfo>)Stream.of((Iterable<?>)this.mAllTrainData.get("L001")).filter(StationPositionPresenterImpl$$Lambda$9.lambdaFactory$()).toList());
            this.mSaveTrains.addAll(this.mAllTrainData.get("L008"));
        }
        else {
            this.mSaveTrains.addAll(this.mAllTrainData.get(s));
        }
        this.mNeedApiProgress = false;
        DataNotifyEventBus.getInstance().post(StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.make((Object)"api"));
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_GET_CHECK_IN)
    void failedCheckInData() {
        if (this.mIsToTrainInfo) {
            AppEventBus.hideProgress();
            this.mView.toTrainInfo((List)Lists.newArrayList((Iterable<?>)this.mTrainInfoList));
            this.mTrainInfoList.clear();
        }
        else {
            DataNotifyEventBus.getInstance().post(StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.make((Object)"checkin"));
        }
        this.mIsToTrainInfo = false;
        LogUtils.w("API Failed : API_GET_CHECK_IN ");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_GET_SHARED_CHECK_IN)
    void failedShareCheckInData() {
        LogUtils.w("API Failed : API_GET_SHARED_CHECK_IN ");
        DataNotifyEventBus.getInstance().post(StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.make((Object)"shared"));
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_INFO)
    void failedStationInfo() {
        LogUtils.w("API Failed : API_STATION_INFO ");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_TRAIN_LIST)
    void failedStationLines() {
        LogUtils.w("API Failed : API_TRAIN_LIST ");
        this.mNeedApiProgress = false;
        DataNotifyEventBus.getInstance().post(StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.make((Object)"api"));
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_TRAIN_INFO)
    void failedTrainsById() {
        AppEventBus.hideProgress();
        this.mTrainInfoList.clear();
        this.mCallBackSize = 0;
        this.mTrainIdSize = 0;
        LogUtils.w("API Failed : API_TRAIN_LIST ");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_TRAIN_WRAPPING_MESSAGE)
    public void failedTrainsWrappingData() {
        LogUtils.w("API Failed : API_TRAIN_WRAPPING ");
    }
    
    public void freshCurrentRouteData() {
        if (this.mIsDataChanged) {
            this.mIsDataChanged = false;
            this.mSaveTrains.clear();
            StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.reset(1);
            this.requestTrainsByRouteId(this.mSaveLineId);
        }
    }
    
    public String getRouteIdByName(final String s) {
        final BaseRoute baseRoute = this.mRepository.getBaseRoute(s);
        if (baseRoute != null) {
            return baseRoute.getId();
        }
        return null;
    }
    
    public String getRouteNameById(String realRoute) {
        realRoute = this.getRealRoute(realRoute);
        final BaseRoute baseRouteById = this.mRepository.getBaseRouteById(realRoute);
        if (baseRouteById != null) {
            return baseRouteById.getName();
        }
        return null;
    }
    
    public List<String> getRouteNames() {
        return Stream.of((Pair[])BaseConfig.ROUTE_MAP).map((Function<? super Pair, ?>)StationPositionPresenterImpl$$Lambda$1.lambdaFactory$()).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
    }
    
    public void getTrainInfoData(final List<String> list) {
        final HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Stream.of((Iterable<?>)list).forEach(StationPositionPresenterImpl$$Lambda$4.lambdaFactory$(this, (Map)hashMap));
        this.mTrainIdSize = hashMap.size();
        this.mCallBackSize = 0;
        this.mTrainInfoList.clear();
        AppEventBus.showProgress();
        Stream.of(hashMap).forEach(StationPositionPresenterImpl$$Lambda$5.lambdaFactory$(this));
    }
    
    public void getTrainWrappingData() {
        this.mRepository.getTrainWrappingMessage(this);
    }
    
    public Date getUpdateDate() {
        return this.mRepository.getTrainPositionUpdateDate();
    }
    
    public void loadOtherLineInfo(final String s, final boolean mIsPopup) {
        this.mIsPopup = mIsPopup;
        this.mRepository.getOtherCompanyLineInfo(this, s);
    }
    
    public void loadStationInfo(final String s) {
        this.mRepository.getStationDetailInfo(this, s);
    }
    
    public void notifyLoadMapDone() {
        this.mLoadingMap = false;
        DataNotifyEventBus.getInstance().post(StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.make((Object)"map"));
    }
    
    @Subscribe
    public void onDataChanged(final Map<String, List<TrainInfo>> map) {
        if (map != null) {
            this.mIsDataChanged = true;
            this.mAllTrainData.clear();
            this.mAllTrainData.putAll(map);
        }
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO)
    void onFailedStationInfo() {
        LogUtils.w("API Failed : API_STATION_INFO ");
    }
    
    @Subscribe
    public void onRefChanged(final StationPositionPresenterImpl.StationPositionPresenterImpl$Ref stationPositionPresenterImpl$Ref) {
        if (StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.isZero()) {
            if (!this.mNeedApiProgress) {
                AppEventBus.hideProgress();
            }
            this.mSaveTrains = this.removeRepeatTrain(this.mSaveTrains);
            this.mView.showTrainPosition(this.mSaveLineId, (List)this.mSaveTrains);
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO)
    void onSucceedStationInfo(final Object[] array, final StationDetailInfo stationDetailInfo) {
        this.mView.migrateToStationInfo(stationDetailInfo);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_GET_CHECK_IN)
    void receiveCheckInData(final Object[] array, final List<CheckInData> checkInTrainInfos) {
        if (this.mIsToTrainInfo) {
            AppEventBus.hideProgress();
            this.mView.toTrainInfo((List)Lists.newArrayList((Iterable<?>)this.mTrainInfoList));
            this.mTrainInfoList.clear();
        }
        else {
            if (checkInTrainInfos != null) {
                this.mView.setCheckInTrainInfos((List)checkInTrainInfos);
            }
            DataNotifyEventBus.getInstance().post(StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.make((Object)"checkin"));
        }
        this.mIsToTrainInfo = false;
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_GET_SHARED_CHECK_IN)
    void receiveShareCheckInData(final List<CheckInData> mSharedDatas) {
        Lists.newArrayList();
        if (mSharedDatas != null) {
            this.mView.setSharedTrainInfos((List)Stream.of((Iterable<?>)mSharedDatas).filter(StationPositionPresenterImpl$$Lambda$6.lambdaFactory$()).toList());
        }
        this.mSharedDatas = mSharedDatas;
        ((PrefSharedData_.PrefSharedDataEditor_)this.mSharedPref.edit().sharedCheckInData().put(new Gson().toJson(CheckinUtils.insertShareUrlIdToResponse((List)this.mSharedDatas, (List)this.mAllSharedIds)))).apply();
        DataNotifyEventBus.getInstance().post(StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.make((Object)"shared"));
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_INFO)
    void receiveStationInfo(final Object[] array, final StationInfo stationInfo) {
        if (array[1].equals("2")) {
            if (!this.mIsPopup) {
                this.mView.toOtherApp((List)stationInfo.getTransfer());
                return;
            }
            this.mView.showOtherLineDialog((List)this.insertSection(stationInfo.getTransfer()));
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_LIST)
    void receiveStationLines(final Object[] array, final List<TrainInfo> list) {
        if (list != null && array != null && array.length > 1 && (int)array[1] == this.hashCode()) {
            Stream.of((Iterable<?>)list).forEach(StationPositionPresenterImpl$$Lambda$7.lambdaFactory$(this));
        }
        this.requestTrainsByRouteId(this.mSaveLineId);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_INFO)
    void receiveTrainsById(final Object[] array, final List<TrainInfo> list) {
        ++this.mCallBackSize;
        this.mTrainInfoList.addAll(list);
        if (this.mCallBackSize == this.mTrainIdSize) {
            this.mIsToTrainInfo = true;
            this.mDeviceRepository.getCheckIn(this, false, true);
            this.mCallBackSize = 0;
            this.mTrainIdSize = 0;
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_WRAPPING_MESSAGE)
    public void receiveTrainsWrappingData(final String s, final TrainList list) {
        if (!this.mView.isDestroyed() && list != null) {
            this.mView.toTrainWrapping((List)list.getCar());
        }
    }
    
    @Override
    public void start() {
        super.start();
        this.mSharedPref = new PrefSharedData_(this.mView.getContext());
        CTCEventBus.register(this);
    }
    
    public void startLoadData(String join, final boolean b) {
        this.mSaveLineId = join;
        int n;
        if (b) {
            n = 3;
        }
        else {
            n = 4;
        }
        StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.reset(n);
        AppEventBus.showProgress();
        this.mDeviceRepository.getCheckIn(this, false, true);
        if (this.mAllTrainData == null || b) {
            this.mAllTrainData = new HashMap<String, List<TrainInfo>>();
            final Iterator<String> iterator = Arrays.asList("L001+L002+L003+L005+L008+L009+L011+L012+L021+L022+L013+L010".split("\\+")).iterator();
            while (iterator.hasNext()) {
                this.mAllTrainData.put(iterator.next(), new ArrayList<TrainInfo>());
            }
            this.mSaveTrains = new ArrayList<TrainInfo>();
            this.mNeedApiProgress = true;
            this.mRepository.requestAllTrains(this, "L001+L002+L003+L005+L008+L009+L011+L012+L021+L022+L013+L010", false);
        }
        else {
            if (this.mSaveTrains != null) {
                this.mSaveTrains.clear();
            }
            else {
                this.mSaveTrains = new ArrayList<TrainInfo>();
            }
            this.requestTrainsByRouteId(join);
        }
        if (!b && !this.mLoadingMap) {
            UiThreadExecutor.runTask("", StationPositionPresenterImpl$$Lambda$2.lambdaFactory$(this, join), 200L);
        }
        join = (String)this.mSharedPref.sharedCheckInData().get();
        if (!TextUtils.isEmpty((CharSequence)join)) {
            this.mSharedDatas = new Gson().fromJson(join, new StationPositionPresenterImpl$1(this).getType());
            if (this.mSharedDatas != null) {
                this.mAllSharedIds = Stream.of((Iterable<?>)this.mSharedDatas).map((Function<? super Object, ? extends String>)StationPositionPresenterImpl$$Lambda$3.lambdaFactory$()).toList();
                join = TextUtils.join((CharSequence)"+", (Iterable)this.mAllSharedIds);
                if (!TextUtils.isEmpty((CharSequence)join)) {
                    this.mDeviceRepository.getSharedCheckIn(this, join, false);
                    return;
                }
            }
        }
        DataNotifyEventBus.getInstance().post(StationPositionPresenterImpl.StationPositionPresenterImpl$Ref.make((Object)"shared"));
    }
    
    @Override
    public void stop() {
        super.stop();
        CTCEventBus.unregister(this);
    }
}
