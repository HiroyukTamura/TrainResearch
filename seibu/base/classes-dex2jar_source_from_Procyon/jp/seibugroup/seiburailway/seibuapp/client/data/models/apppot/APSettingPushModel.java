// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot;

import jp.co.ncdc.apppot.stew.dto.APObject;

public class APSettingPushModel extends APObject
{
    public String appPotUserId;
    public String getOffStationId;
    public boolean isEnabledCoupon;
    public boolean isEnabledGetOff;
    public boolean isEnabledInformation;
    public boolean isEnabledServiceInfo;
    public boolean isEnabledStampRally;
    public String lineId;
    public String scheduledDate;
    public String trainNo;
    
    public APSettingPushModel() {
        this.isEnabledInformation = true;
        this.isEnabledServiceInfo = true;
        this.isEnabledGetOff = true;
        this.isEnabledStampRally = true;
        this.isEnabledCoupon = true;
        this.setPersistentType(PersistentType.APServerOnly);
        this.setScopeTypeForAutoRefresh(ScopeType.APScopeAll);
    }
}
