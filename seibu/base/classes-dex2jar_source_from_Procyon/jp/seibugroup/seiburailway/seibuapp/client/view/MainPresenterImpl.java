// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.view;

import com.feilang.mvpproject.base.BaseContract;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository_;
import jp.seibugroup.seiburailway.seibuapp.client.util.DateUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.BeaconInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainInfo;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.BeaconLocationInfo;
import java.util.Arrays;
import jp.seibugroup.seiburailway.seibuapp.client.event.CTCEventBus;
import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import java.util.Iterator;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.StationsRepository;
import jp.seibugroup.seiburailway.seibuapp.client.data.repository.DeviceDataRepository;
import jp.seibugroup.seiburailway.seibuapp.client.remote.beacon.BeaconServiceManager;
import org.altbeacon.beacon.Beacon;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefBeaconData_;
import com.feilang.mvpproject.base.BasePresenterClass;

public class MainPresenterImpl extends BasePresenterClass implements MainContract$Presenter
{
    private PrefBeaconData_ mBeaconData;
    private List<Beacon> mBeaconList;
    private BeaconServiceManager mBeaconServiceManager;
    private DeviceDataRepository mDeviceRepository;
    private StationsRepository mStationsRepository;
    MainContract.View mView;
    
    MainPresenterImpl(@NonNull final MainContract.View view) {
        this.mBeaconList = new ArrayList<Beacon>();
        (this.mView = Preconditions.checkNotNull(view)).setPresenter((MainContract$Presenter)this);
    }
    
    private boolean isBeaconExist(final Beacon beacon) {
        final boolean b = false;
        final Iterator<Beacon> iterator = this.mBeaconList.iterator();
        do {
            final boolean b2 = b;
            if (iterator.hasNext()) {
                continue;
            }
            return b2;
        } while (!iterator.next().equals(beacon));
        return true;
    }
    
    private void stopBeaconService() {
        if (this.mBeaconServiceManager != null) {
            this.mBeaconServiceManager.stopBeaconRangingService();
            this.mBeaconServiceManager = null;
        }
    }
    
    public void deleteBeacon() {
        this.mBeaconList.clear();
        this.mDeviceRepository.deleteBeacon(this);
        Constants.LINE_ID = "";
        Constants.TRAIN_ID = "";
        CTCEventBus.post("beacon_delete");
    }
    
    public void getTrainInfo(final String s, final String s2) {
        this.mStationsRepository.requestTrainsById(this, s, Arrays.asList(s2));
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_REGISTER_BEACON)
    public void onRegisterBeaconApiSuccess(final Object[] array, final String s, final BeaconLocationInfo beaconLocationInfo) {
        if (1 <= array.length && !this.isBeaconExist((Beacon)array[0])) {
            this.mBeaconList.add((Beacon)array[0]);
            if (beaconLocationInfo != null) {
                if (Constants.DETECTED_ID == null) {
                    Constants.DETECTED_ID = new ArrayList<String>();
                }
                if (!Constants.DETECTED_ID.contains(beaconLocationInfo.getDetectedId())) {
                    Constants.DETECTED_ID.add(beaconLocationInfo.getDetectedId());
                }
                final BeaconLocationInfo.Location location = beaconLocationInfo.getLocation();
                if (location != null && !TextUtils.isEmpty((CharSequence)location.getLineId()) && !TextUtils.isEmpty((CharSequence)location.getTrainNo()) && "1".equals(location.getLocationType())) {
                    Constants.LINE_ID = location.getLineId();
                    Constants.TRAIN_ID = location.getTrainNo();
                    CTCEventBus.post("beacon_register");
                }
            }
        }
    }
    
    @OnApiSuccess(DataNotifyEvent.ApiEventType.API_TRAIN_INFO)
    void onTrainsSucceed(final Object[] array, final List<TrainInfo> list) {
        if (array.length < 3 || (int)array[2] != this.hashCode() || ((BaseContract.View)this.mView).isDestroyed() || list == null || list.size() == 0) {
            return;
        }
        final TrainInfo trainInfo = list.get(0);
        if (trainInfo.isHasBeacons() && trainInfo.isOnRail()) {
            this.mView.toArrivalPush(trainInfo);
            return;
        }
        this.mView.showErrorMessage();
    }
    
    public void registerBeacon(final Beacon beacon) {
        final BeaconInfo beaconInfo = new BeaconInfo();
        if (beacon.getId1() != null) {
            beaconInfo.setUuid(beacon.getId1().toString());
        }
        if (beacon.getId2() != null) {
            beaconInfo.setMajor(beacon.getId2().toString());
        }
        if (beacon.getId3() != null) {
            beaconInfo.setMinor(beacon.getId3().toString());
        }
        beaconInfo.setDateTime(DateUtils.getDateStringISO8601());
        this.mDeviceRepository.registerBeacon(this, beaconInfo, beacon);
    }
    
    public void setRegionEnterFlg(final boolean b) {
        ((PrefBeaconData_.PrefBeaconDataEditor_)this.mBeaconData.edit().isEntered().put(b)).apply();
    }
    
    @Override
    public void start() {
        super.start();
        this.mDeviceRepository = DeviceDataRepository_.getInstance_(this.mView.getContext());
        this.mStationsRepository = StationsRepository_.getInstance_(this.mView.getContext());
    }
    
    public void startBeaconService() {
        this.mBeaconData = new PrefBeaconData_(this.mView.getContext());
        (this.mBeaconServiceManager = new BeaconServiceManager(this.mView.getContext(), (MainContract$Presenter)this)).startListen();
    }
    
    @Override
    public void stop() {
        super.stop();
        this.stopBeaconService();
    }
}
