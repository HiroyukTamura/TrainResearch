// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.db;

import java.util.Collection;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.gen.NoticeMessageReadHistoryDao;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseData;
import com.annimon.stream.Collector;
import com.annimon.stream.Collectors;
import android.support.annotation.Nullable;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.gen.BaseTrainDao;
import org.greenrobot.greendao.Property;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.gen.BaseStationDao;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.gen.BaseStationLineDao;
import com.annimon.stream.function.Predicate;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseConfig;
import com.annimon.stream.function.Function;
import org.androidannotations.annotations.AfterInject;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.ExternalLinkUrl;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseCompany;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseRouteGroup;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStationLine;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseTrain;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseRoute;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import com.annimon.stream.function.Consumer;
import com.annimon.stream.Stream;
import java.util.List;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.greendao.NoticeMessageReadHistory;
import org.androidannotations.annotations.sharedpreferences.Pref;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.pref.PrefMasterData_;
import org.androidannotations.annotations.RootContext;
import android.content.Context;
import org.androidannotations.annotations.EBean;

@EBean
public class MasterDaoUtils
{
    private static final String TAG;
    @RootContext
    Context context;
    private DaoManager mManager;
    @Pref
    PrefMasterData_ pref;
    
    static {
        TAG = MasterDaoUtils.class.getSimpleName();
    }
    
    public boolean deleteAll() {
        try {
            this.mManager.getDaoSession().deleteAll((Class)BaseStation.class);
            this.mManager.getDaoSession().deleteAll((Class)BaseRoute.class);
            this.mManager.getDaoSession().deleteAll((Class)BaseTrain.class);
            this.mManager.getDaoSession().deleteAll((Class)BaseStationLine.class);
            this.mManager.getDaoSession().deleteAll((Class)BaseRouteGroup.class);
            this.mManager.getDaoSession().deleteAll((Class)BaseCompany.class);
            this.mManager.getDaoSession().deleteAll((Class)ExternalLinkUrl.class);
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public void destroy() {
        this.mManager.closeConnection();
    }
    
    @AfterInject
    void init() {
        (this.mManager = DaoManager.getInstance()).init(this.context);
    }
    
    public boolean insertNoticeHistory(final List<String> list) {
        return this.insertRecords((List<Object>)Stream.of((Iterable<?>)list).map((Function<? super Object, ? extends T>)MasterDaoUtils$$Lambda$4.lambdaFactory$()).toList());
    }
    
    public <T> boolean insertRecords(final List<T> list) {
        try {
            this.mManager.getDaoSession().runInTx(MasterDaoUtils$$Lambda$1.lambdaFactory$(this, list));
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean insertRoute(final BaseRoute baseRoute) {
        return this.mManager.getDaoSession().getBaseRouteDao().insert((Object)baseRoute) > 0L;
    }
    
    public boolean insertStation(final BaseStation baseStation) {
        return this.mManager.getDaoSession().getBaseStationDao().insert((Object)baseStation) > 0L;
    }
    
    public boolean isAllStopType(final String s) {
        return Stream.of((Iterable<?>)this.queryTrainsTypeCode(BaseConfig.ALL_STOP_TYPE)).filter(MasterDaoUtils$$Lambda$3.lambdaFactory$(s)).findFirst().isPresent();
    }
    
    public <T> List<T> queryAllRecords(final Class<T> clazz) {
        return (List<T>)this.mManager.getDaoSession().loadAll((Class)clazz);
    }
    
    public List<BaseRoute> queryAllRoutes() {
        return (List<BaseRoute>)this.mManager.getDaoSession().loadAll((Class)BaseRoute.class);
    }
    
    public List<BaseRoute> queryAllRoutes(final String s) {
        final QueryBuilder queryBuilder = this.mManager.getDaoSession().getBaseRouteDao().queryBuilder();
        queryBuilder.join((Class)BaseStationLine.class, BaseStationLineDao.Properties.LineId).where(BaseStationLineDao.Properties.StationId.eq((Object)s), new WhereCondition[0]);
        return (List<BaseRoute>)queryBuilder.list();
    }
    
    public List<BaseStation> queryAllStations() {
        final BaseStationDao baseStationDao = this.mManager.getDaoSession().getBaseStationDao();
        return (List<BaseStation>)baseStationDao.queryBuilder().where(BaseStationDao.Properties.InService.eq((Object)1), new WhereCondition[] { baseStationDao.queryBuilder().or(BaseStationDao.Properties.OnSeibuLine.eq((Object)1), BaseStationDao.Properties.Id.eq((Object)"S0315KT"), new WhereCondition[0]) }).list();
    }
    
    public List<BaseTrain> queryAllTrains() {
        return (List<BaseTrain>)this.mManager.getDaoSession().loadAll((Class)BaseTrain.class);
    }
    
    public List<BaseStation> queryStationsByKeyword(final String s) {
        final BaseStationDao baseStationDao = this.mManager.getDaoSession().getBaseStationDao();
        return (List<BaseStation>)baseStationDao.queryBuilder().where(BaseStationDao.Properties.InService.eq((Object)1), new WhereCondition[] { baseStationDao.queryBuilder().or(BaseStationDao.Properties.OnSeibuLine.eq((Object)1), BaseStationDao.Properties.Id.eq((Object)"S0315KT"), new WhereCondition[0]), baseStationDao.queryBuilder().or(BaseStationDao.Properties.HiraganaName.like(s + "%"), BaseStationDao.Properties.KanjiName.like(s + "%"), new WhereCondition[0]) }).orderAsc(new Property[] { BaseStationDao.Properties.RomajiName }).list();
    }
    
    @Nullable
    public BaseTrain queryTrainType(final String s) {
        final List list = this.mManager.getDaoSession().getBaseTrainDao().queryBuilder().where(BaseTrainDao.Properties.Code.eq((Object)s), new WhereCondition[0]).list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
    
    public List<BaseTrain> queryTrains(final String s) {
        return (List<BaseTrain>)this.mManager.getDaoSession().getBaseTrainDao().queryBuilder().where(BaseTrainDao.Properties.Name.eq((Object)s), new WhereCondition[0]).list();
    }
    
    public List<String> queryTrainsTypeCode(final String s) {
        return Stream.of((Iterable<?>)this.queryTrains(s)).map((Function<? super Object, ?>)MasterDaoUtils$$Lambda$2.lambdaFactory$()).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
    }
    
    public BaseData readBaseData() {
        final BaseData baseData = new BaseData();
        baseData.setStations(this.queryAllRecords(BaseStation.class));
        baseData.setRoutes(this.queryAllRecords(BaseRoute.class));
        baseData.setTrains(this.queryAllRecords(BaseTrain.class));
        baseData.setStationLines(this.queryAllRecords(BaseStationLine.class));
        baseData.setLineGroup(this.queryAllRecords(BaseRouteGroup.class));
        baseData.setCompanys(this.queryAllRecords(BaseCompany.class));
        baseData.setExternalLinkUrl(this.queryAllRecords(ExternalLinkUrl.class));
        baseData.setVersion((int)this.pref.version().get());
        baseData.setReleaseDate((String)this.pref.releaseDate().get());
        baseData.setValidPeriod((long)this.pref.validPeriod().get());
        return baseData;
    }
    
    public long unreadNoticeCount(final List<String> list) {
        return list.size() - this.mManager.getDaoSession().getNoticeMessageReadHistoryDao().queryBuilder().where(NoticeMessageReadHistoryDao.Properties.NoticeId.in((Collection)list), new WhereCondition[0]).count();
    }
    
    public boolean writeBaseData(final BaseData baseData) {
        if (this.deleteAll() && this.insertRecords(baseData.getStations()) && this.insertRecords(baseData.getRoutes()) && this.insertRecords(baseData.getTrains()) && this.insertRecords(baseData.getStationLines()) && this.insertRecords(baseData.getLineGroup()) && this.insertRecords(baseData.getCompanys()) && this.insertRecords(baseData.getExternalLinkUrl())) {
            this.pref.releaseDate().put((Object)baseData.getReleaseDate());
            this.pref.validPeriod().put((Object)baseData.getValidPeriod());
            this.pref.version().put((Object)baseData.getVersion());
            return true;
        }
        return false;
    }
}
