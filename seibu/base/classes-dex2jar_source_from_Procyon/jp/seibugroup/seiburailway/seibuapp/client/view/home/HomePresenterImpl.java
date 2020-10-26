// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.home;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.LineStationInfoWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultStationLine;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeThreeMessageWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.StationDeparture;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusDataWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusData;
import jp.seibugroup.seiburailway.seibuapp.client.util.HomeCheckinDataUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.BaseballModel;
import java.util.Collection;
import com.feilang.mvpproject.data.models.ErrorData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.PushInfo;
import com.google.gson.Gson;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageData;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import java.util.Collections;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import com.annimon.stream.Optional;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import org.androidannotations.api.UiThreadExecutor;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import com.feilang.mvpproject.util.AppEventBus;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInOptions;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInInfo;
import android.text.TextUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefAppData_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.HomeData;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainTimeTable;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import com.feilang.mvpproject.base.BasePresenterClass;

public class HomePresenterImpl extends BasePresenterClass implements HomeContract$Presenter
{
    private static final int GET_CHECKIN_TIMER = 10000;
    private TrainStationListAdapter mAdapter;
    private CheckInData mCheckInData;
    private List<TrainTimeTable> mCheckinTimeTableDatas;
    private DeviceDataRepository mDeviceDataRepository;
    private HomeData mHomeData;
    private boolean mIsFromNotification;
    private boolean mIsImplStartFirst;
    private MasterDataRepository mMasterDataRepository;
    private PrefAppData_ mPrefAppData;
    private String mSelectedRouteId;
    private String mSelectedTrainId;
    private List<String> mShownPushInfo;
    private StationsRepository mStationsRepository;
    private ArrayList<TrainInfo> mTrainInfoList;
    private HomeContract$View mView;
    
    public HomePresenterImpl(@NonNull final StationsRepository stationsRepository, @NonNull final DeviceDataRepository deviceDataRepository, @NonNull final MasterDataRepository masterDataRepository, @NonNull final HomeContract$View homeContract$View, final boolean mIsFromNotification) {
        this.mHomeData = new HomeData();
        this.mShownPushInfo = (List<String>)Lists.newArrayList();
        this.mIsFromNotification = false;
        this.mIsImplStartFirst = true;
        this.mView = Preconditions.checkNotNull(homeContract$View);
        this.mStationsRepository = Preconditions.checkNotNull(stationsRepository);
        this.mDeviceDataRepository = Preconditions.checkNotNull(deviceDataRepository);
        this.mMasterDataRepository = Preconditions.checkNotNull(masterDataRepository);
        this.mIsFromNotification = mIsFromNotification;
        this.mView.setPresenter((Object)this);
    }
    
    public void changeCheckIn(final TrainTimeTable trainTimeTable) {
        final String stationId = trainTimeTable.getStationId();
        final CheckInInfo checkInInfo = new CheckInInfo();
        String carNo;
        if (TextUtils.isEmpty((CharSequence)this.mCheckInData.getCarNo())) {
            carNo = null;
        }
        else {
            carNo = this.mCheckInData.getCarNo();
        }
        checkInInfo.setCarNo(carNo);
        checkInInfo.setLineId(this.mCheckInData.getLineId());
        checkInInfo.setTrainNo(this.mCheckInData.getTrainNo());
        checkInInfo.setOptions(new CheckInOptions());
        checkInInfo.setGetOnStation(this.mCheckInData.getGetOnStation());
        checkInInfo.setGetOffStation(stationId);
        AppEventBus.showProgress();
        this.mDeviceDataRepository.changeCheckIn(this, this.mCheckInData.getCheckinId(), checkInInfo, false);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_CHANGE_CHECK_IN)
    void changeCheckInFailed() {
        LogUtils.w("API Failed : API_CHANGE_CHECK_IN ");
        AppEventBus.hideProgress();
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_CHANGE_CHECK_IN)
    void changeCheckInSuccess(final CheckInData mCheckInData) {
        this.mCheckInData = mCheckInData;
        this.mView.updateStopStationView(this.mCheckInData);
        if (this.mCheckInData != null) {
            this.mStationsRepository.requestTrainsById(this, this.mCheckInData.getLineId(), Lists.newArrayList(this.mCheckInData.getTrainNo()), true, false, false);
        }
    }
    
    public void deleteCheckIn() {
        if (this.mCheckInData != null) {
            final String checkinId = this.mCheckInData.getCheckinId();
            AppEventBus.showProgress();
            this.mDeviceDataRepository.deleteCheckIn(this, checkinId, false);
        }
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_DELETE_CHECK_IN)
    void deleteCheckInFailed() {
        LogUtils.w("API Failed : API_DELETE_CHECK_IN ");
        AppEventBus.hideProgress();
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_DELETE_CHECK_IN)
    void deleteCheckInSuccess(final Object o) {
        this.mDeviceDataRepository.getCheckIn(this, false, false);
        this.mView.deleteCheckInView();
        this.mCheckInData = null;
        UiThreadExecutor.cancelAll("get_check_in");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_GET_SHARED_CHECK_IN)
    void failedShareCheckInData() {
        this.getHeadlines();
        LogUtils.w("API Failed : API_GET_SHARED_CHECK_IN ");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION)
    void failedStationLines() {
        if (this.mView.isDestroyed()) {
            return;
        }
        this.getHeadlines();
        LogUtils.w("API Failed : API_STATION_LINE_DIRECTION ");
    }
    
    public void findSelectedTrain(final String mSelectedRouteId, final String mSelectedTrainId) {
        this.mSelectedRouteId = mSelectedRouteId;
        this.mSelectedTrainId = mSelectedTrainId;
        this.mStationsRepository.requestAllTrains(this, mSelectedRouteId, true);
    }
    
    public void getBaseBallStatus() {
        this.mStationsRepository.getBaseballGames(this);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_GET_CHECK_IN)
    void getCheckInFailed() {
        AppEventBus.hideProgress();
        UiThreadExecutor.runTask("get_check_in", HomePresenterImpl$$Lambda$8.lambdaFactory$(this), 10000L);
        LogUtils.w("API Failed : API_GET_CHECK_IN ");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_GET_CHECK_IN)
    void getCheckInSuccess(final Object[] array, final List<CheckInData> list) {
        AppEventBus.hideProgress();
        if (array.length > 1 && (int)array[0] == this.hashCode()) {
            if (list != null) {
                final Optional<CheckInData> first = Stream.of((Iterable<? extends CheckInData>)list).filter(HomePresenterImpl$$Lambda$5.lambdaFactory$()).findFirst();
                if (first.isPresent()) {
                    this.mCheckInData = first.get();
                    UiThreadExecutor.runTask("get_check_in", HomePresenterImpl$$Lambda$6.lambdaFactory$(this), 10000L);
                    this.mView.updateStopStationView(this.mCheckInData);
                    if (this.mCheckInData != null) {
                        this.mStationsRepository.requestTrainsById(this, this.mCheckInData.getLineId(), Lists.newArrayList(this.mCheckInData.getTrainNo()), true, false, (boolean)array[1]);
                        return;
                    }
                }
                else {
                    final Optional<CheckInData> first2 = Stream.of((Iterable<? extends CheckInData>)list).filter(HomePresenterImpl$$Lambda$7.lambdaFactory$()).findFirst();
                    if (first2.isPresent()) {
                        this.mView.updateStopStationView((CheckInData)first2.get());
                        return;
                    }
                }
            }
            this.mView.deleteCheckInView();
        }
    }
    
    public void getCheckin() {
        UiThreadExecutor.cancelAll("get_check_in");
        this.mDeviceDataRepository.getCheckIn(this, false, false);
    }
    
    public void getCurrentTrainInfo() {
        this.mStationsRepository.requestTrainsById(this, Constants.LINE_ID, Collections.singletonList(Constants.TRAIN_ID));
    }
    
    public void getEmerg() {
        this.mDeviceDataRepository.getEmerg(this);
    }
    
    public void getHeadlines() {
        this.mDeviceDataRepository.getHeadlines(this);
    }
    
    public void getMyStationDepartures(final boolean b) {
        final List<String> myStationList = this.mDeviceDataRepository.getMyStationList();
        if (myStationList == null || myStationList.size() == 0) {
            AppEventBus.hideProgress();
            return;
        }
        final ArrayList<BaseStation> savedMyStationData = new ArrayList<BaseStation>();
        final Iterator<String> iterator = myStationList.iterator();
        while (iterator.hasNext()) {
            savedMyStationData.add(this.mMasterDataRepository.getStationById(iterator.next()));
        }
        Constants.setSavedMyStationData(savedMyStationData);
        this.mStationsRepository.getStationDeparturesForHome(this, myStationList, b);
    }
    
    public List<TrainTimeTable> getNextStationList() {
        final ArrayList<Object> arrayList = Lists.newArrayList((Iterable<?>)this.mCheckinTimeTableDatas);
        final Optional<Object> first = Stream.of((Iterable<?>)arrayList).filter(HomePresenterImpl$$Lambda$1.lambdaFactory$(this)).findFirst();
        if (first.isPresent()) {
            if (first.get().isPast()) {
                return Stream.of((Iterable<? extends TrainTimeTable>)arrayList).filter(HomePresenterImpl$$Lambda$2.lambdaFactory$(this)).toList();
            }
            final int index = arrayList.indexOf(first.get());
            if (index + 1 < arrayList.size()) {
                arrayList.subList(0, index + 1).clear();
                return (List<TrainTimeTable>)arrayList;
            }
        }
        return (List<TrainTimeTable>)Lists.newArrayList();
    }
    
    public TrainStationListAdapter getNextStationListAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = new TrainStationListAdapter(this.mView.getContext());
        }
        return this.mAdapter;
    }
    
    public void getNoticeMessages() {
        this.mDeviceDataRepository.getNoticeMessages(this);
    }
    
    public void getRunStatusData() {
        this.mStationsRepository.getRunStatusData(this);
    }
    
    public String getShareUrl() {
        final String string = "seibuapp://share?c=" + this.mCheckInData.getCheckinId();
        try {
            return "https://events.seibuapp.jp/share/start.html?url=" + URLEncoder.encode(new String(string.getBytes(), "UTF-8"), "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            return "https://events.seibuapp.jp/share/start.html?url=";
        }
    }
    
    public void getSharedDatas(final List<String> list) {
        this.mDeviceDataRepository.getSharedCheckIn(this, TextUtils.join((CharSequence)"+", (Iterable)list), true);
    }
    
    public String getStationName(final String s) {
        final BaseStation stationById = this.mMasterDataRepository.getStationById(s);
        if (stationById != null) {
            return stationById.getKanjiName();
        }
        return "";
    }
    
    public String getStationRomajiName(final String s) {
        final BaseStation stationById = this.mMasterDataRepository.getStationById(s);
        if (stationById != null) {
            return stationById.getRomajiNameAfterChange();
        }
        return "";
    }
    
    public void getThreeNoticeMessages() {
        this.mDeviceDataRepository.getThreeNoticeMessages(this);
    }
    
    public ArrayList<TrainInfo> getTrainInfoList() {
        return this.mTrainInfoList;
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_TRAIN_LIST)
    void getTrainsByLineIdFailed() {
        this.getHeadlines();
        LogUtils.w("API Failed : API_TRAIN_LIST ");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_LIST)
    void getTrainsByLineIdSuccess(final Object[] array, final List<TrainInfo> list) {
        if (list != null && array != null && array.length > 1 && (int)array[1] == this.hashCode()) {
            final Optional<TrainInfo> first = Stream.of((Iterable<? extends TrainInfo>)list).filter(HomePresenterImpl$$Lambda$4.lambdaFactory$(this)).findFirst();
            if (!first.isPresent()) {
                this.mView.findTrainSuccess(this.mSelectedRouteId, (String)null, 0);
                return;
            }
            this.mView.findTrainSuccess(first.get().getLineId(), first.get().getTrainId(), first.get().getSectionNo());
        }
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_EMERG)
    public void onEmergApiFailed() {
        LogUtils.v("\u7dca\u6025\u901f\u5831\u53d6\u5f97\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_EMERG)
    public void onEmergApiSuccess(String s, final ArrayList<NoticeMessageData> list) {
        s = (String)this.mPrefAppData.emergIdJson().get();
        final List list2 = new Gson().fromJson(s, new HomePresenterImpl$1(this).getType());
        final ArrayList<NoticeMessageData> list3 = new ArrayList<NoticeMessageData>(list.size());
        for (final NoticeMessageData noticeMessageData : list) {
            if (list2 != null && !list2.contains(noticeMessageData.getNoticeId())) {
                list3.add(noticeMessageData);
            }
        }
        this.mView.showEmergInfo((List)list3);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_HEADLINES)
    public void onHeadlinesApiFailed() {
        LogUtils.v("\u7dca\u6025\u304a\u77e5\u3089\u305b\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_HEADLINES)
    public void onHeadlinesApiSuccess(String s, final List<NoticeMessageData> list) {
        this.mHomeData.setHeadlines(list);
        Collections.sort((List<Comparable>)list);
        s = (String)this.mPrefAppData.noticeIdJson().get();
        final List list2 = new Gson().fromJson(s, new HomePresenterImpl$2(this).getType());
        final ArrayList<PushInfo> list3 = new ArrayList<PushInfo>();
        for (final NoticeMessageData noticeMessageData : list) {
            if ((list2 == null || !list2.contains(noticeMessageData.getNoticeId())) && !this.mShownPushInfo.contains(noticeMessageData.getNoticeId())) {
                this.mShownPushInfo.add(noticeMessageData.getNoticeId());
                final PushInfo pushInfo = new PushInfo();
                pushInfo.setNoticeID(noticeMessageData.getNoticeId());
                pushInfo.setContentTitle(noticeMessageData.getTitle());
                final List<String> contentList = noticeMessageData.getContentList();
                if (contentList != null && contentList.size() > 0) {
                    pushInfo.setContent(contentList.get(0));
                }
                final List<String> imageUrlList = noticeMessageData.getImageUrlList();
                if (imageUrlList != null && imageUrlList.size() > 0) {
                    pushInfo.setImageUrl(imageUrlList.get(0));
                }
                final List<String> toUrlList = noticeMessageData.getToUrlList();
                if (toUrlList != null && toUrlList.size() > 0) {
                    pushInfo.setToUrl(toUrlList.get(0));
                }
                final List<Boolean> viaBrowserList = noticeMessageData.getViaBrowserList();
                if (viaBrowserList != null && viaBrowserList.size() > 0) {
                    if (viaBrowserList.get(0)) {
                        pushInfo.setViaBrowser("1");
                    }
                    else {
                        pushInfo.setViaBrowser("0");
                    }
                }
                pushInfo.setType("0");
                pushInfo.setEventType(noticeMessageData.getNoticeType());
                list3.add(pushInfo);
            }
        }
        this.mView.showPushNotification((List)list3);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_NOTICE_MESSAGE)
    public void onNoticeMessageApiFailed(final ErrorData errorData) {
        LogUtils.v("\u304a\u77e5\u3089\u305b\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_NOTICE_MESSAGE)
    public void onNoticeMessageApiSuccess(final String s, final List<NoticeMessageData> c) {
        if (c == null) {
            this.mView.showNoticeMessagePage(new ArrayList());
            return;
        }
        this.mView.showNoticeMessagePage(new ArrayList((Collection<? extends E>)c));
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_NOTICE_MESSAGE_UNREAD)
    public void onNoticeMessageUnreadCountApiFailed() {
        LogUtils.v("\u672a\u8aad\u304a\u77e5\u3089\u305b\u6570\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_NOTICE_MESSAGE_UNREAD)
    public void onNoticeMessageUnreadCountApiSuccess(final String s, final long n) {
        this.mView.setupNoticeCount(n);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_BASEBALL_GAMES)
    public void onRequestBaseballApiFailed() {
        LogUtils.v("\u30e9\u30a4\u30aa\u30f3\u30ba\u8a66\u5408\u72b6\u6cc1\u53d6\u5f97\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_BASEBALL_GAMES)
    public void onRequestBaseballApiSuccess(final String s, final List<BaseballModel> list) {
        if (this.mView.isDestroyed()) {
            return;
        }
        if (list != null && list.size() > 0) {
            final BaseballModel baseballModel = list.get(0);
            final String url = baseballModel.getUrl();
            if (baseballModel.isPlaying() && !TextUtils.isEmpty((CharSequence)url)) {
                this.mView.setupBaseballIcon(url);
                return;
            }
        }
        this.mView.setupBaseballIcon((String)null);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_TRAIN_INFO)
    public void onRequestTrainsByIdApiFailed() {
        LogUtils.v("\u5217\u8eca\u60c5\u5831\u53d6\u5f97\u306e\u5931\u6557\u51e6\u7406");
        AppEventBus.hideProgress();
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_INFO)
    public void onRequestTrainsByIdApiSuccess(final Object[] array, final List<TrainInfo> list) {
        boolean b = false;
        AppEventBus.hideProgress();
        if (array.length < 3 || (int)array[2] != this.hashCode() || this.mView.isDestroyed() || list == null || list.size() == 0) {
            return;
        }
        final TrainInfo trainInfo = list.get(0);
        if (array.length == 5 && (boolean)array[3]) {
            this.mTrainInfoList = Lists.newArrayList((Iterable<? extends TrainInfo>)list);
            final HomeCheckinDataUtils homeCheckinDataUtils = new HomeCheckinDataUtils();
            homeCheckinDataUtils.setTrainInfo(this.mView.getContext(), trainInfo);
            final List allStopStationsList = homeCheckinDataUtils.getAllStopStationsList();
            final TrainTimeTable trainTimeTable = null;
            final Optional<TrainTimeTable> first = Stream.of((Iterable<? extends TrainTimeTable>)allStopStationsList).filter(HomePresenterImpl$$Lambda$3.lambdaFactory$(this)).findFirst();
            TrainTimeTable trainTimeTable2;
            if (first.isPresent()) {
                trainTimeTable2 = first.get();
            }
            else {
                trainTimeTable2 = trainTimeTable;
                if (this.mCheckInData.getGetOffStation() != null) {
                    trainTimeTable2 = trainTimeTable;
                    if (!this.mCheckInData.getGetOffStation().isEmpty()) {
                        trainTimeTable2 = new TrainTimeTable();
                        trainTimeTable2.setStationName(this.getStationName(this.mCheckInData.getGetOffStation()));
                    }
                }
            }
            final TrainStationListAdapter mAdapter = this.mAdapter;
            final String markStationId = homeCheckinDataUtils.getMarkStationId();
            final String getOffStation = this.mCheckInData.getGetOffStation();
            if ((!TextUtils.isEmpty((CharSequence)trainInfo.getToStationId()) && !TextUtils.isEmpty((CharSequence)trainInfo.getFromStationId())) || !homeCheckinDataUtils.isFromStationIsStopStation()) {
                b = true;
            }
            mAdapter.setDataSource(allStopStationsList, markStationId, getOffStation, b, homeCheckinDataUtils.getLonggestStationName());
            this.mCheckinTimeTableDatas = (List<TrainTimeTable>)allStopStationsList;
            this.mAdapter.notifyDataSetChanged();
            this.mView.updateStopStationDetailView(trainInfo, trainTimeTable2, homeCheckinDataUtils, (boolean)array[4]);
            return;
        }
        if (trainInfo.isHasBeacons() && trainInfo.isOnRail()) {
            this.mView.toArrivalPush(trainInfo);
            return;
        }
        this.mView.showErrorMessage();
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_RUN_STATUS_MESSAGE)
    public void onRunStatusApiFailed() {
        this.mView.setupRunStatus((RunStatusData)null);
        LogUtils.v("\u904b\u884c\u60c5\u5831\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_RUN_STATUS_MESSAGE)
    public void onRunStatusApiSuccess(final Object[] array, final RunStatusDataWrapper runStatusDataWrapper) {
        if (!(boolean)array[1]) {
            if (this.mHomeData != null) {
                this.mHomeData.setRunStatusInfo(runStatusDataWrapper.getLineStatus());
                this.mView.setupRunStatus(runStatusDataWrapper.getLineStatus());
                this.mView.setupMyLine((List)runStatusDataWrapper.getLineStatusSpecific());
            }
            if (array.length > 0 && !(boolean)array[0]) {
                this.mView.toRunningInfo(runStatusDataWrapper);
            }
        }
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES_HOME)
    public void onStationDeparturesApiFailed() {
        LogUtils.v("\u767a\u8eca\u6848\u5185\u306e\u5931\u6557\u51e6\u7406");
        this.mView.updateViews(this.mHomeData, false);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES_HOME)
    public void onStationDeparturesApiSuccess(final Object[] array, final List<StationDeparture> myStationInfoList) {
        if ((int)array[0] == this.hashCode() && !this.mView.isDestroyed()) {
            this.mHomeData.setMyStationInfoList(myStationInfoList);
            this.mView.updateViews(this.mHomeData, true);
        }
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_THREE_NOTICE)
    public void onThreeApiFailed() {
        LogUtils.v("\u30a2\u30d7\u30ea\u8d77\u52d5\u6642\u306b\u5fc5\u8981\u306a\u304a\u77e5\u3089\u305b\u7b49\u306e\u60c5\u5831\u3092\u5168\u3066\u53d6\u5f97\u3059\u308b\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_THREE_NOTICE)
    public void onThreeApiSuccess(String s, final NoticeThreeMessageWrapper noticeThreeMessageWrapper) {
        this.mHomeData.setHeadlines(noticeThreeMessageWrapper.getHeadlines().getNotice());
        Collections.sort(noticeThreeMessageWrapper.getHeadlines().getNotice());
        s = (String)this.mPrefAppData.noticeIdJson().get();
        final List list = new Gson().fromJson(s, new HomePresenterImpl$3(this).getType());
        final ArrayList<PushInfo> list2 = new ArrayList<PushInfo>();
        for (final NoticeMessageData noticeMessageData : noticeThreeMessageWrapper.getHeadlines().getNotice()) {
            if ((list == null || !list.contains(noticeMessageData.getNoticeId())) && !this.mShownPushInfo.contains(noticeMessageData.getNoticeId())) {
                this.mShownPushInfo.add(noticeMessageData.getNoticeId());
                final PushInfo pushInfo = new PushInfo();
                pushInfo.setNoticeID(noticeMessageData.getNoticeId());
                pushInfo.setContentTitle(noticeMessageData.getTitle());
                final List<String> contentList = noticeMessageData.getContentList();
                if (contentList != null && contentList.size() > 0) {
                    pushInfo.setContent(contentList.get(0));
                }
                final List<String> imageUrlList = noticeMessageData.getImageUrlList();
                if (imageUrlList != null && imageUrlList.size() > 0) {
                    pushInfo.setImageUrl(imageUrlList.get(0));
                }
                final List<String> toUrlList = noticeMessageData.getToUrlList();
                if (toUrlList != null && toUrlList.size() > 0) {
                    pushInfo.setToUrl(toUrlList.get(0));
                }
                final List<Boolean> viaBrowserList = noticeMessageData.getViaBrowserList();
                if (viaBrowserList != null && viaBrowserList.size() > 0) {
                    if (viaBrowserList.get(0)) {
                        pushInfo.setViaBrowser("1");
                    }
                    else {
                        pushInfo.setViaBrowser("0");
                    }
                }
                pushInfo.setType("0");
                pushInfo.setEventType(noticeMessageData.getNoticeType());
                list2.add(pushInfo);
            }
        }
        this.mView.showPushNotification((List)list2);
        this.mView.setupNoticeCount(noticeThreeMessageWrapper.getHomeUnreadCount());
        LogUtils.v("\u30a2\u30d7\u30ea\u8d77\u52d5\u6642\u306b\u5fc5\u8981\u306a\u304a\u77e5\u3089\u305b\u7b49\u306e\u60c5\u5831\u3092\u5168\u3066\u53d6\u5f97\u3059\u308b\u306esuccess\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_GET_SHARED_CHECK_IN)
    void receiveShareCheckInData(final List<CheckInData> list) {
        this.mView.getSharedCheckinDatas((List)list);
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION)
    void receiveStationLines(final Object[] array, final ResultStationLine resultStationLine) {
        if (this.mView.isDestroyed()) {
            return;
        }
        if (resultStationLine.getLines() != null && resultStationLine.getLines().size() != 0) {
            this.mView.showStationTimeTableTop();
            return;
        }
        this.getHeadlines();
        LogUtils.w("\u4f55\u3082\u53d6\u5f97\u3055\u308c\u306a\u3044");
    }
    
    public void refreshData() {
        UiThreadExecutor.cancelAll("get_check_in");
        this.mHomeData.setRunStatusInfo(null);
        this.getMyStationDepartures(false);
        this.mDeviceDataRepository.getNoticeMessagesUnreadCount(this);
        this.mDeviceDataRepository.getEmerg(this);
        this.mStationsRepository.getRunStatusData(this, false, true, false);
        this.mStationsRepository.getBaseballGames(this);
        this.mDeviceDataRepository.getCheckIn(this, false, true);
    }
    
    public void requestStationLines(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            this.mView.showErrorMessage();
        }
        else {
            final List<LineStationInfoWrapper> stationLines = this.mStationsRepository.getStationLines(this, s);
            if (stationLines != null && stationLines.size()) {
                this.mView.showStationTimeTableTop();
            }
        }
    }
    
    public void setIsFromNotification(final boolean mIsFromNotification) {
        this.mIsFromNotification = mIsFromNotification;
    }
    
    @Override
    public void start() {
        super.start();
        this.mPrefAppData = new PrefAppData_(this.mView.getContext());
        this.mHomeData.setRunStatusInfo(null);
        if (this.mHomeData.getMyStationInfoList() == null) {
            this.getMyStationDepartures(true);
        }
        if (!this.mIsFromNotification) {
            if (!this.mIsImplStartFirst && !Constants.IS_FROM_RUNSTATUS) {
                this.mDeviceDataRepository.getNoticeMessagesUnreadCount(this);
            }
            this.mStationsRepository.getBaseballGames(this);
        }
        this.mDeviceDataRepository.getEmerg(this);
        this.mStationsRepository.getRunStatusData(this, false, true, false);
        this.mDeviceDataRepository.getCheckIn(this, false, true);
        this.mIsFromNotification = false;
        this.mIsImplStartFirst = false;
    }
}
