// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot;

import jp.co.ncdc.apppot.stew.dto.APObject;

public class APSettingStationHistoryModel extends APObject
{
    public String appPotUserId;
    public int orderNumber;
    public String stationId;
    
    public APSettingStationHistoryModel() {
        this.setPersistentType(PersistentType.APLocalOnly);
        this.setAutoRefresh(true);
        this.setRefreshInterval(300);
        this.setScopeTypeForAutoRefresh(ScopeType.APScopeAll);
    }
}
