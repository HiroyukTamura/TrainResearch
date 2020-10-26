// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.json;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.IntStringAdapter;
import com.google.gson.annotations.JsonAdapter;

public class Maintenance
{
    private AppVersion appVersion;
    private String created;
    private DayNightTime dayNightTime;
    private MaintenanceInfo maintenance;
    private StoreUrl storeUrl;
    private int ttl;
    @JsonAdapter(IntStringAdapter.class)
    private int version;
    
    public AppVersion getAppVersion() {
        return this.appVersion;
    }
    
    public String getCreated() {
        return this.created;
    }
    
    public DayNightTime getDayNightTime() {
        return this.dayNightTime;
    }
    
    public MaintenanceInfo getMaintenance() {
        return this.maintenance;
    }
    
    public StoreUrl getStoreUrl() {
        return this.storeUrl;
    }
    
    public int getTtl() {
        return this.ttl;
    }
    
    public int getVersion() {
        return this.version;
    }
    
    public void setAppVersion(final AppVersion appVersion) {
        this.appVersion = appVersion;
    }
    
    public void setCreated(final String created) {
        this.created = created;
    }
    
    public void setDayNightTime(final DayNightTime dayNightTime) {
        this.dayNightTime = dayNightTime;
    }
    
    public void setMaintenance(final MaintenanceInfo maintenance) {
        this.maintenance = maintenance;
    }
    
    public void setStoreUrl(final StoreUrl storeUrl) {
        this.storeUrl = storeUrl;
    }
    
    public void setTtl(final int ttl) {
        this.ttl = ttl;
    }
    
    public void setVersion(final int version) {
        this.version = version;
    }
}
