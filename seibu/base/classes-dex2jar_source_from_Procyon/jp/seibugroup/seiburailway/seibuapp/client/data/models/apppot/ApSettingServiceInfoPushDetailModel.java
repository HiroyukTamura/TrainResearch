// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.apppot;

import jp.co.ncdc.apppot.stew.dto.APObject;

public class ApSettingServiceInfoPushDetailModel extends APObject
{
    public String appPotUserId;
    public boolean at10;
    public boolean at12;
    public boolean at14;
    public boolean at16;
    public boolean at18;
    public boolean at20;
    public boolean at22;
    public boolean at24;
    public boolean at4;
    public boolean at6;
    public boolean at8;
    public int dayOfWeek;
    
    public ApSettingServiceInfoPushDetailModel() {
        this.at4 = true;
        this.at6 = true;
        this.at8 = true;
        this.at10 = true;
        this.at12 = true;
        this.at14 = true;
        this.at16 = true;
        this.at18 = true;
        this.at20 = true;
        this.at22 = true;
        this.at24 = true;
        this.setPersistentType(PersistentType.APServerOnly);
        this.setScopeTypeForAutoRefresh(ScopeType.APScopeAll);
    }
}
