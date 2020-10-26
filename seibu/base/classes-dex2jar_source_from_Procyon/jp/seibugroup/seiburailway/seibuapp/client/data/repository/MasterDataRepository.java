// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.repository;

import jp.seibugroup.seiburailway.seibuapp.client.util.Constants;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseTrain;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import android.support.annotation.Nullable;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseRoute;
import android.support.annotation.NonNull;
import com.feilang.mvpproject.data.models.ResultData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.Maintenance;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import org.androidannotations.annotations.sharedpreferences.Pref;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMasterData_;
import jp.seibugroup.seiburailway.seibuapp.client.remote.AppMasterManager;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseData;
import org.androidannotations.annotations.Bean;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.MasterDaoUtils;
import org.androidannotations.annotations.RootContext;
import android.content.Context;
import org.androidannotations.annotations.EBean;

@EBean(scope = EBean.Scope.Singleton)
public class MasterDataRepository
{
    @RootContext
    Context mContext;
    @Bean
    MasterDaoUtils mDao;
    private BaseData mData;
    @Bean
    AppMasterManager mMasterManager;
    @Pref
    PrefMasterData_ prefs;
    
    public String getLinkUrlByNo(final String s) {
        return this.mData.getUrl(s);
    }
    
    public void getMaintenance(final Object o, final boolean b, final boolean b2) {
        this.mMasterManager.getMaintenance(new DataCallWrapper<Maintenance>(o, DataNotifyEvent.ApiEventType.API_CHECK_MAINTENANCE, b, b2) {
            @NonNull
            @Override
            public ResultData handleData(final Maintenance maintenance) {
                return ResultData.createNew(maintenance);
            }
        });
    }
    
    @Nullable
    public BaseRoute getRoute(final String s) {
        return this.mData.getRoute(s);
    }
    
    @Nullable
    public BaseRoute getRouteById(final String s) {
        return this.mData.getRouteById(s);
    }
    
    @Nullable
    public BaseStation getStation(final String s) {
        return this.mData.getStation(s);
    }
    
    @Nullable
    public BaseStation getStationById(final String s) {
        return this.mData.getStationById(s);
    }
    
    @Nullable
    public BaseTrain getTrainTypeById(final String s) {
        return this.mData.getTrainTypeById(s);
    }
    
    @Nullable
    public List<String> getTrainTypeCode(final String s) {
        return this.mDao.queryTrainsTypeCode(s);
    }
    
    @Nullable
    public List<BaseStation> queryAllStations() {
        return this.mDao.queryAllStations();
    }
    
    @Nullable
    public List<BaseStation> queryStationsByKeyword(final String s) {
        return this.mDao.queryStationsByKeyword(s);
    }
    
    public boolean readDataFromDB() {
        boolean b = true;
        if (this.mData == null) {
            this.mData = this.mDao.readBaseData();
            b = b;
            if (0L == this.mData.getExpiredTime()) {
                b = false;
            }
        }
        return b;
    }
    
    public void updateData(final Object o) {
        this.mMasterManager.getMasterData(new DataCallWrapper<BaseData>(o, DataNotifyEvent.ApiEventType.API_MASTER_DATA, false, false) {
            @NonNull
            @Override
            public ResultData handleData(final BaseData baseData) {
                if (baseData != null && (MasterDataRepository.this.mData == null || baseData.getVersion() > MasterDataRepository.this.mData.getVersion())) {
                    MasterDataRepository.this.mDao.writeBaseData(baseData);
                    MasterDataRepository.this.mData = baseData;
                    MasterDataRepository.this.prefs.expiredTime().put((Object)MasterDataRepository.this.mData.getExpiredTime());
                }
                return ResultData.createNew(Constants.Result.SUCCESS);
            }
        });
    }
    
    public boolean updateDataIfNeed(final Object o) {
        if ((long)this.prefs.expiredTime().get() < System.currentTimeMillis()) {
            this.updateData(o);
            return true;
        }
        return false;
    }
}
