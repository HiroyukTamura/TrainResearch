// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot;

import jp.co.ncdc.apppot.stew.dto.APObject;

public class APSettingMyStationModel extends APObject
{
    public String appPotUserId;
    public int orderNumber;
    public String stationId;
    
    public APSettingMyStationModel() {
        this.setPersistentType(PersistentType.APServerOnly);
        this.setScopeTypeForAutoRefresh(ScopeType.APScopeAll);
    }
}
