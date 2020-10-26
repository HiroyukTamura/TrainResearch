// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.addstation.locationfragment;

import jp.seibugroup.seiburailway.seibuapp.client.util.LocationUtils;
import android.content.Context;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import java.util.Iterator;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStationLine;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfoList;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import jp.seibugroup.seiburailway.seibuapp.client.view.mystation.helper.OnStartDragListener;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingCallback;
import com.feilang.mvpproject.util.Exclusive;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import android.view.View;
import com.feilang.mvpproject.util.AppEventBus;
import java.util.List;
import java.util.ArrayList;
import android.location.Location;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.view.common.adapter.StationListAdapter;
import jp.seibugroup.seiburailway.seibuapp.client.util.CTCLocationListener$CTCLocationHandler;
import com.feilang.mvpproject.base.BasePresenterClass;

public class LocationListPresenterImpl extends BasePresenterClass implements LocationListContract$Presenter, CTCLocationListener$CTCLocationHandler
{
    private StationListAdapter mAdapter;
    private DeviceDataRepository mDeviceDataRepository;
    private StationsRepository mStationsRepository;
    private LocationListContract$View mView;
    
    public LocationListPresenterImpl(@NonNull final DeviceDataRepository deviceDataRepository, @NonNull final StationsRepository stationsRepository, @NonNull final LocationListContract$View locationListContract$View) {
        this.mDeviceDataRepository = Preconditions.checkNotNull(deviceDataRepository);
        this.mStationsRepository = Preconditions.checkNotNull(stationsRepository);
        (this.mView = Preconditions.checkNotNull(locationListContract$View)).setPresenter((Object)this);
    }
    
    private void getStationByLocation(final Location location) {
        if (location == null) {
            this.mView.setLocationStation((List)new ArrayList());
            AppEventBus.hideProgress();
            return;
        }
        this.mStationsRepository.getNearbyStations(this, location);
    }
    
    private void saveHistoryData(final String s) {
        this.mDeviceDataRepository.saveStationHistory(s, (APSettingCallback.Common)new LocationListPresenterImpl$1(this));
    }
    
    public StationListAdapter getAdapter() {
        if (this.mAdapter == null) {
            (this.mAdapter = new StationListAdapter(this.mView.getContext(), (OnStartDragListener)null, true)).setOnItemClickListener(LocationListPresenterImpl$$Lambda$1.lambdaFactory$(this));
        }
        return this.mAdapter;
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_NEARBY)
    public void onGetNearbyStationsFailed() {
        AppEventBus.hideProgress();
        this.mView.setLocationStation((List)new ArrayList());
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_NEARBY)
    public void onGetNearbyStationsSuccess(final String s, final StationInfoList list) {
        AppEventBus.hideProgress();
        if (this.mView.isDestroyed()) {
            return;
        }
        if (list.getStation() == null) {
            this.mView.setLocationStation((List)new ArrayList());
            return;
        }
        final ArrayList<BaseStation> locationStation = new ArrayList<BaseStation>(list.getStation().size());
        for (final StationInfo stationInfo : list.getStation()) {
            final BaseStation baseStation = new BaseStation();
            baseStation.setId(stationInfo.getStationId());
            baseStation.setRomajiName(stationInfo.getStationNameRomaji());
            baseStation.setKanjiName(stationInfo.getStationName());
            final ArrayList baseStationLine = new ArrayList<BaseStationLine>(stationInfo.getLine().size());
            for (final String stationNumber : stationInfo.getStationNo()) {
                final BaseStationLine baseStationLine2 = new BaseStationLine();
                baseStationLine2.setStationNumber(stationNumber);
                baseStationLine2.setStationId(stationInfo.getStationId());
                baseStationLine.add(baseStationLine2);
            }
            baseStation.setBaseStationLine((List<BaseStationLine>)baseStationLine);
            locationStation.add(baseStation);
        }
        this.mView.setLocationStation((List)locationStation);
    }
    
    public void onLocationChanged(final Location location) {
        this.getStationByLocation(location);
    }
    
    public void startGPS(final Context context) {
        AppEventBus.showProgress();
        LocationUtils.startGPS(context, (CTCLocationListener$CTCLocationHandler)this);
    }
}
