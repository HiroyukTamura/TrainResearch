// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view.home.locationcard;

import android.location.Location;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.StationDeparture;
import com.feilang.mvpproject.util.LogUtils;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfoList;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import java.util.List;
import java.util.ArrayList;
import com.feilang.mvpproject.util.AppEventBus;
import jp.seibugroup.seiburailway.seibuapp.client.util.LocationUtils;
import android.content.Context;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.AppPotDao_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import com.google.common.base.Preconditions;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import android.location.LocationManager;
import jp.seibugroup.seiburailway.seibuapp.client.util.CTCLocationListener;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.AppPotDao;
import jp.seibugroup.seiburailway.seibuapp.client.util.CTCLocationListener$CTCLocationHandler;
import com.feilang.mvpproject.base.BasePresenterClass;

public class MyStationCardLocationPresenterImpl extends BasePresenterClass implements MyStationCardLocationContract$Presenter, CTCLocationListener$CTCLocationHandler
{
    private AppPotDao mAppPotDao;
    private CTCLocationListener mLocationListener;
    private LocationManager mLocationManager;
    private StationsRepository mStationsRepository;
    private MyStationCardLocationContract$View mView;
    
    public MyStationCardLocationPresenterImpl(@NonNull final MyStationCardLocationContract$View myStationCardLocationContract$View) {
        this.mLocationManager = null;
        this.mLocationListener = null;
        (this.mView = Preconditions.checkNotNull(myStationCardLocationContract$View)).setPresenter((Object)this);
        this.mStationsRepository = StationsRepository_.getInstance_(this.mView.getContext());
        this.mAppPotDao = AppPotDao_.getInstance_(this.mView.getContext());
    }
    
    public void getNearbyStation(final Context context) {
        if (LocationUtils.startGPS(context, (CTCLocationListener$CTCLocationHandler)this)) {
            AppEventBus.showProgress();
            return;
        }
        this.mView.showNearbyStations((List)new ArrayList());
    }
    
    public void getStationDepartures(final String s) {
        this.mStationsRepository.getStationDeparturesForHome(this, s, true);
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_NEARBY)
    public void onGetNearbyStationsFailed() {
        if (this.mView.isDestroyed()) {
            return;
        }
        this.mView.showNearbyStations((List)new ArrayList());
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_NEARBY)
    public void onGetNearbyStationsSuccess(final String s, final StationInfoList list) {
        if (this.mView.isDestroyed()) {
            return;
        }
        if (list != null) {
            this.mView.showNearbyStations((List)list.getStation());
            return;
        }
        this.mView.showNearbyStations((List)new ArrayList());
    }
    
    @OnApiFailed(DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES_MY)
    public void onGetStationDeparturesFailed() {
        if (this.mView.isDestroyed()) {
            return;
        }
        LogUtils.v("\u30de\u30a4\u99c5\u66f4\u65b0\u306e\u5931\u6557\u51e6\u7406");
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES_MY)
    public void onGetStationDeparturesSuccess(final Object[] array, final List<StationDeparture> list) {
        if (array.length < 1 || (int)array[0] != this.hashCode() || this.mView.isDestroyed()) {
            return;
        }
        if (list.size() > 0) {
            this.mView.updateMyStaiton((StationDeparture)list.get(0));
            return;
        }
        this.mView.updateMyStaiton((StationDeparture)null);
    }
    
    public void onLocationChanged(final Location obj) {
        LogUtils.v("location: " + obj);
        if (obj == null) {
            this.mView.showNearbyStations((List)new ArrayList());
            AppEventBus.hideProgress();
            return;
        }
        this.mStationsRepository.getNearbyStations(this, obj);
    }
}
