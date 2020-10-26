// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.db;

import jp.co.ncdc.apppot.stew.APResponseHandler;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingStationHistoryModel;
import com.feilang.mvpproject.util.LogUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.ApSettingServiceInfoPushDetailModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingPushModel;
import java.util.Iterator;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot.APSettingMyStationModel;
import jp.co.ncdc.apppot.stew.APService;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;
import jp.co.ncdc.apppot.stew.APEntityManager;
import jp.co.ncdc.apppot.stew.APQuery;
import org.androidannotations.annotations.EBean;

@EBean(scope = EBean.Scope.Singleton)
public class AppPotDao
{
    public boolean clearLocalTable(final Class<?> clazz) {
        boolean b = true;
        final APQuery apQuery = new APQuery(clazz);
        apQuery.scopeType("3");
        final List<APObject> object = APEntityManager.getInstance().getObject(apQuery);
        if (object == null || object.size() == 0) {
            b = false;
        }
        else if (1 != APEntityManager.getInstance().deleteObject(object)) {
            return false;
        }
        return b;
    }
    
    public boolean clearServerTable(final Class<?> clazz) {
        boolean b = true;
        final APQuery apQuery = new APQuery(clazz);
        apQuery.whereEqual("createUserId", APService.getInstance().getUserInfo().userId);
        apQuery.scopeType("3");
        final List<APObject> object = APEntityManager.getInstance().getObject(apQuery);
        if (object == null || object.size() == 0) {
            b = false;
        }
        else if (1 != APEntityManager.getInstance().deleteObject(object)) {
            return false;
        }
        return b;
    }
    
    public void deleteOverflowStationHistory(final List<APObject> list, final int n) {
        for (int i = list.size(); i > n; --i) {
            APEntityManager.getInstance().deleteObject(list.get(i - 1));
        }
    }
    
    public List<APSettingMyStationModel> getAllMyStation() {
        final ArrayList<APSettingMyStationModel> list = new ArrayList<APSettingMyStationModel>();
        final APQuery apQuery = new APQuery(APSettingMyStationModel.class);
        apQuery.sortAsc("orderNumber");
        apQuery.whereEqual("createUserId", APService.getInstance().getUserInfo().userId);
        apQuery.scopeType("3");
        final Iterator<APObject> iterator = APEntityManager.getInstance().getObject(apQuery).iterator();
        while (iterator.hasNext()) {
            list.add((APSettingMyStationModel)iterator.next());
        }
        return list;
    }
    
    public List<APSettingPushModel> getAllPush() {
        final ArrayList<APSettingPushModel> list = new ArrayList<APSettingPushModel>();
        final APQuery apQuery = new APQuery(APSettingPushModel.class);
        apQuery.sortDesc("updateTime");
        apQuery.whereEqual("createUserId", APService.getInstance().getUserInfo().userId);
        apQuery.scopeType("3");
        final Iterator<APObject> iterator = APEntityManager.getInstance().getObject(apQuery).iterator();
        while (iterator.hasNext()) {
            list.add((APSettingPushModel)iterator.next());
        }
        return list;
    }
    
    public List<ApSettingServiceInfoPushDetailModel> getAllService() {
        final ArrayList<ApSettingServiceInfoPushDetailModel> list = new ArrayList<ApSettingServiceInfoPushDetailModel>();
        final APQuery apQuery = new APQuery(ApSettingServiceInfoPushDetailModel.class);
        apQuery.sortAsc("dayOfWeek");
        apQuery.whereEqual("createUserId", APService.getInstance().getUserInfo().userId);
        apQuery.scopeType("3");
        LogUtils.outputLog("getAllService createUserId: " + APService.getInstance().getUserInfo().userId);
        for (final APObject apObject : APEntityManager.getInstance().getObject(apQuery)) {
            if (apObject != null) {
                LogUtils.outputLog("getAllService createUserId: " + apObject.createUserId);
                LogUtils.outputLog("getAllService appPotUserId: " + ((ApSettingServiceInfoPushDetailModel)apObject).appPotUserId);
            }
            list.add((ApSettingServiceInfoPushDetailModel)apObject);
        }
        return list;
    }
    
    public List<APSettingStationHistoryModel> getAllStationHistory() {
        final ArrayList<APSettingStationHistoryModel> list = new ArrayList<APSettingStationHistoryModel>();
        final APQuery apQuery = new APQuery(APSettingStationHistoryModel.class);
        apQuery.sortDesc("updateTime");
        apQuery.scopeType("3");
        final Iterator<APObject> iterator = APEntityManager.getInstance().getObject(apQuery).iterator();
        while (iterator.hasNext()) {
            list.add((APSettingStationHistoryModel)iterator.next());
        }
        return list;
    }
    
    public boolean save(final APObject apObject) {
        return 1 == APEntityManager.getInstance().saveObject(apObject);
    }
    
    public void saveList(final List<APObject> list, final APResponseHandler apResponseHandler) {
        APEntityManager.getInstance().saveObjectList(list, apResponseHandler);
    }
}
