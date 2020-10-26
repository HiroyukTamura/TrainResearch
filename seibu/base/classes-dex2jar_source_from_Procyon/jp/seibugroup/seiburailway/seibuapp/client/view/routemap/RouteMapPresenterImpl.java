// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.routemap;

import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingCallback;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultStationLine;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationDetailInfo;
import java.util.Iterator;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.LineStationInfoWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.util.LogUtils;
import jp.seibugroup.seiburailway.seibuapp.client.view.addstation.AddStationFragment$FragmentType;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.MasterDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import com.feilang.mvpproject.base.BasePresenterClass;

class RouteMapPresenterImpl extends BasePresenterClass implements RouteMapContract$Presenter
{
    private DeviceDataRepository mDeviceDataRepository;
    private MasterDataRepository mMasterDataRepository;
    private String mRomajiName;
    private String mStationId;
    private String mStationName;
    private StationsRepository mStationsRepository;
    private RouteMapContract$View mView;
    
    RouteMapPresenterImpl(@NonNull final RouteMapContract$View routeMapContract$View) {
        (this.mView = Preconditions.checkNotNull(routeMapContract$View)).setPresenter((Object)this);
        this.mDeviceDataRepository = DeviceDataRepository_.getInstance_(this.mView.getContext());
        this.mStationsRepository = StationsRepository_.getInstance_(this.mView.getContext());
        this.mMasterDataRepository = MasterDataRepository_.getInstance_(this.mView.getContext());
    }
    
    private void nextPage(final AddStationFragment$FragmentType addStationFragment$FragmentType) {
        switch (RouteMapPresenterImpl$2.$SwitchMap$jp$seibugroup$seiburailway$seibuapp$client$view$addstation$AddStationFragment$FragmentType[addStationFragment$FragmentType.ordinal()]) {
            case 1: {
                this.mView.goTutorial();
                break;
            }
            case 2: {
                this.mView.goHome();
                break;
            }
            case 3: {
                this.mView.goMyStation();
                break;
            }
        }
        this.mStationName = null;
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO)
    public void failedStationInfo() {
        LogUtils.w("API Failed : API_STATION_INFO ");
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION)
    public void failedStationLineInfo() {
        LogUtils.w("API Failed : API_STATION_LINE_DIRECTION ");
    }
    
    public BaseStation getStationByName(final String s) {
        return this.mMasterDataRepository.getStation(s);
    }
    
    public void getStationInfo(final String s) {
        final BaseStation station = this.mMasterDataRepository.getStation(s);
        if (station != null) {
            this.mStationsRepository.getStationDetailInfo(this, station.getId());
        }
    }
    
    public void getStationLines(final String anObject) {
        final List<BaseStation> queryAllStations = this.mMasterDataRepository.queryAllStations();
        if (queryAllStations != null) {
            for (final BaseStation baseStation : queryAllStations) {
                if (baseStation.getKanjiName().equals(anObject)) {
                    this.mRomajiName = baseStation.getRomajiNameAfterChange();
                    this.mStationId = baseStation.getId();
                    final List<LineStationInfoWrapper> stationLines = this.mStationsRepository.getStationLines(this, this.mStationId);
                    if (stationLines != null) {
                        this.mView.goTimeTablePage(this.mRomajiName, stationLines.get(0).getLineStationInfo().getStation().getStationName(), this.mStationId);
                        return;
                    }
                    break;
                }
            }
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO)
    public void receiveStationInfo(final Object[] array, final StationDetailInfo stationDetailInfo) {
        if (stationDetailInfo != null) {
            this.mView.goStationInfoPage(stationDetailInfo);
            return;
        }
        LogUtils.w("API Return Null : API_STATION_INFO ");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION)
    public void receiveStationLineInfo(final Object[] array, final ResultStationLine resultStationLine) {
        if (resultStationLine != null && resultStationLine.getLines().size() != 0) {
            this.mView.goTimeTablePage(this.mRomajiName, resultStationLine.getLines().get(0).getLineStationInfo().getStation().getStationName(), this.mStationId);
            return;
        }
        LogUtils.w("API Return Null : API_STATION_LINE_DIRECTION ");
    }
    
    public void saveMyStation(final String mStationName, final AddStationFragment$FragmentType addStationFragment$FragmentType) {
        if (TextUtils.isEmpty((CharSequence)this.mStationName)) {
            final BaseStation station = this.mMasterDataRepository.getStation(mStationName);
            if (station != null) {
                this.mStationName = mStationName;
                final List<String> myStationList = this.mDeviceDataRepository.getMyStationList();
                final int n = 0;
                final Iterator<String> iterator = myStationList.iterator();
                while (true) {
                    do {
                        final int n2 = n;
                        if (iterator.hasNext()) {
                            continue;
                        }
                        if (n2 != 0) {
                            this.nextPage(addStationFragment$FragmentType);
                            return;
                        }
                        this.mDeviceDataRepository.saveMyStation(station.getId(), (APSettingCallback.Common)new RouteMapPresenterImpl$1(this, station, addStationFragment$FragmentType));
                        return;
                    } while (!iterator.next().equals(station.getId()));
                    final int n2 = 1;
                    continue;
                }
            }
        }
    }
    
    public void saveStationHistory(final String s) {
        final BaseStation station = this.mMasterDataRepository.getStation(s);
        if (station != null) {
            this.mDeviceDataRepository.saveStationHistory(station.getId(), null);
        }
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
