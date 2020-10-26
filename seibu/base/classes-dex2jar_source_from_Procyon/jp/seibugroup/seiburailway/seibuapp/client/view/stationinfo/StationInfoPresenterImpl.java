// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.stationinfo;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.LineStationInfoWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultStationLine;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationDetailInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import com.google.common.collect.Lists;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.Weather;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseConfig;
import android.util.Pair;
import android.widget.BaseAdapter;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import com.feilang.mvpproject.util.AppEventBus;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import java.util.Iterator;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.LineInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.Departure;
import java.util.List;
import com.feilang.mvpproject.base.BasePresenterClass;

public class StationInfoPresenterImpl extends BasePresenterClass implements StationInfoContract$Presenter
{
    private List<Departure> mDepartures;
    private DeviceDataRepository mDeviceDataRepository;
    private MasterDataRepository mMasterDataRepository;
    private NearbyStationAdapter mNearbyStationAdapter;
    private StationsRepository mRepository;
    private String mStationId;
    private StationInfo mStationInfo;
    private ArrayList<TrainInfo> mTrainInfo;
    private CardPagerAdapter mTrainInfoAdapter;
    private StationInfoContract$View mView;
    
    StationInfoPresenterImpl(@NonNull final StationInfoContract$View stationInfoContract$View, final String s, final List<Departure> mDepartures) {
        (this.mView = Preconditions.checkNotNull(stationInfoContract$View)).setPresenter((Object)this);
        this.mDepartures = mDepartures;
        this.mRepository = StationsRepository_.getInstance_(this.mView.getContext());
        this.mMasterDataRepository = MasterDataRepository_.getInstance_(this.mView.getContext());
        this.mDeviceDataRepository = DeviceDataRepository_.getInstance_(this.mView.getContext());
        Preconditions.checkNotNull(this.mStationInfo = this.mRepository.getStationInfo(this, s));
    }
    
    private List<LineInfo> getNearbyStations() {
        final List<LineInfo> line = this.mStationInfo.getLine();
        for (final LineInfo lineInfo : line) {
            lineInfo.setNextStationLRomaji(this.getStationRomajiName(lineInfo.getNextStationL()));
            lineInfo.setNextStationRRomaji(this.getStationRomajiName(lineInfo.getNextStationR()));
        }
        return line;
    }
    
    private String getStationRomajiName(final String s) {
        final BaseStation stationById = this.mMasterDataRepository.getStationById(s);
        if (stationById != null) {
            return stationById.getRomajiName();
        }
        return "";
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_GET_CHECK_IN)
    void failedCheckInData() {
        AppEventBus.hideProgress();
        this.mView.showTrainInfo((ArrayList)this.mTrainInfo);
        LogUtils.w("API Failed : API_GET_CHECK_IN ");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO)
    void failedStationInfo() {
        this.mView.showErrorMessage();
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION)
    void failedStationLines() {
        LogUtils.w("API Failed : API_STATION_LINE_DIRECTION ");
    }
    
    public String getAreaInfoUrl() {
        return this.mStationInfo.getAreaInfoUrl();
    }
    
    public String getBusSiteUrl() {
        return this.mStationInfo.getBusSiteUrl();
    }
    
    public BaseAdapter getChangeLineAdapter() {
        return (BaseAdapter)new StationInfoPresenterImpl$1(this);
    }
    
    public String getCheckerMessage() {
        return this.mStationInfo.getPointCheckerDescription().getMessage();
    }
    
    public String getCheckerSpot() {
        return this.mStationInfo.getPointCheckerDescription().getPlace();
    }
    
    public String getCheckerUseTime() {
        return this.mStationInfo.getPointCheckerDescription().getHours();
    }
    
    public String getGurumeUrl() {
        return this.mStationInfo.getRestaurantInfoUrl();
    }
    
    public Pair<String, Integer> getLineIdAndSectionNo(final int n) {
        if (this.mDepartures != null && this.mDepartures.size() > n) {
            return (Pair<String, Integer>)new Pair((Object)this.mDepartures.get(n).getLineId(), (Object)this.mDepartures.get(n).getSectionNo());
        }
        return null;
    }
    
    public String getNakaUrl() {
        return this.mStationInfo.getShopInfoUrl();
    }
    
    public NearbyStationAdapter getNearByStationAdapter() {
        if (this.mNearbyStationAdapter == null) {
            this.mNearbyStationAdapter = new NearbyStationAdapter(this.mView.getContext());
        }
        this.mNearbyStationAdapter.setDataSource((List)this.getNearbyStations());
        this.mNearbyStationAdapter.notifyDataSetChanged();
        return this.mNearbyStationAdapter;
    }
    
    public void getNearByStationInfo(final String mStationId) {
        this.mStationId = mStationId;
        this.mRepository.getStationDetailInfo(this, mStationId);
    }
    
    public String getNearbyUrl() {
        return this.mStationInfo.getAreaInfoUrl();
    }
    
    public ShadowTransformer getShadowTransformer() {
        return new ShadowTransformer(this.mView.getViewPager(), (CardAdapter)this.mTrainInfoAdapter);
    }
    
    public void getStationDepartures(final String s) {
        this.mRepository.getStationDepartures(this, s);
    }
    
    public String getStationImageUrl() {
        return this.mStationInfo.getStationSignImageUrl();
    }
    
    public void getStationInfo() {
        this.mView.showGraph(this.mStationInfo);
    }
    
    public String getStationKanjiName(final String s) {
        final BaseStation stationById = this.mMasterDataRepository.getStationById(s);
        if (stationById != null) {
            return stationById.getKanjiName();
        }
        return "";
    }
    
    public String getStationName() {
        return this.mStationInfo.getStationName();
    }
    
    public String getStationRomajiName() {
        return this.mStationInfo.getStationNameRomaji();
    }
    
    public String getTargetRouteId() {
        if (this.mStationInfo.getLine() != null && this.mStationInfo.getLine().size() > 0) {
            LogUtils.w("Lines is not existed in Station: " + this.mStationInfo.toString());
            return this.mStationInfo.getLine().get(0).getLineId();
        }
        return this.mRepository.getRouteId(BaseConfig.LINE_DEFAULT);
    }
    
    public CardPagerAdapter getTrainInfoAdapter() {
        if (this.mTrainInfoAdapter == null) {
            (this.mTrainInfoAdapter = new CardPagerAdapter(this.mView.getContext())).setPresenter((StationInfoContract$Presenter)this);
            final Iterator<Departure> iterator = this.mDepartures.iterator();
            while (iterator.hasNext()) {
                this.mTrainInfoAdapter.addCardItem((Departure)iterator.next());
            }
        }
        return this.mTrainInfoAdapter;
    }
    
    public List<String> getTrainType() {
        if (this.mStationInfo.getTrainType() == null) {
            return new ArrayList<String>();
        }
        return this.mStationInfo.getTrainType();
    }
    
    public String getTrainTypeComment() {
        return this.mStationInfo.getTrainTypeDescription();
    }
    
    public int getTransferCount() {
        return this.mStationInfo.getTransfer().size();
    }
    
    public String getTransferUrl() {
        return this.mStationInfo.getTransitUrl();
    }
    
    public Weather getWeatherInfo() {
        return this.mStationInfo.getWeather();
    }
    
    public boolean isBeaconExists() {
        return this.mStationInfo.getHasBeacons();
    }
    
    public boolean isCheckerExists() {
        return this.mStationInfo.getHasPointChecker();
    }
    
    public boolean isFloorMapEmpty() {
        return this.mStationInfo.getFloorMap().isEmpty();
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES)
    public void onGetStationDeparturesFailed() {
        LogUtils.v("\u30de\u30a4\u99c5\u66f4\u65b0\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES)
    public void onGetStationDeparturesSuccess(final List<Departure> list) {
        if (list.size() > 0) {
            this.mTrainInfoAdapter.updateBoardData((List)list);
            this.mTrainInfoAdapter.startTrainNameAnimation(this.mView.getDepartureCurrentPosition());
        }
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_TRAIN_INFO)
    void onTrainsFailed() {
        LogUtils.w("API Failed : API_TRAIN_LIST ");
        AppEventBus.hideProgress();
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_INFO)
    void onTrainsSucceed(final Object[] array, final List<TrainInfo> list) {
        if (array.length >= 3 && (int)array[2] == this.hashCode() && list != null) {
            this.mDeviceDataRepository.getCheckIn(this, false, true);
            this.mTrainInfo = Lists.newArrayList((Iterable<? extends TrainInfo>)list);
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_GET_CHECK_IN)
    void receiveCheckInData(final Object[] array, final List<CheckInData> list) {
        AppEventBus.hideProgress();
        if (array.length > 0 && (int)array[0] == this.hashCode()) {
            this.mView.showTrainInfo((ArrayList)this.mTrainInfo);
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO)
    void receiveStationInfo(final Object[] array, final StationDetailInfo stationDetailInfo) {
        if (stationDetailInfo != null && array.length > 0 && TextUtils.equals((CharSequence)array[0], (CharSequence)this.mStationId)) {
            this.mStationId = "";
            this.mView.toNearbyStation(stationDetailInfo.getStation().getStationId(), (List)stationDetailInfo.getDepartures());
            return;
        }
        LogUtils.w("API Return Null : API_STATION_INFO ");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION)
    void receiveStationLines(final Object[] array, final ResultStationLine resultStationLine) {
        if (resultStationLine.getLines() != null) {
            this.mView.migrateToTimeTable((List)resultStationLine.getLines());
            return;
        }
        LogUtils.w("\u4f55\u3082\u7dda\u8def\u3092\u53d6\u5f97\u3055\u308c\u306a\u3044");
    }
    
    public void requestStationLines(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            this.mView.showErrorMessage();
        }
        final List<LineStationInfoWrapper> stationLines = this.mRepository.getStationLines(this, s);
        if (stationLines != null) {
            this.mView.migrateToTimeTable((List)stationLines);
        }
    }
    
    public void requestTrains(final String s, final List<String> list) {
        if (this.mView.isViewSupportVisible()) {
            AppEventBus.showProgress();
            this.mRepository.requestTrainsById(this, s, list, false, false, false);
        }
    }
    
    @Override
    public void start() {
        super.start();
    }
}
