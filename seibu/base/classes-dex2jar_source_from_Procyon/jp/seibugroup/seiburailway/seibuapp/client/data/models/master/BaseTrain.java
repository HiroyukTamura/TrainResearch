// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import com.google.gson.annotations.SerializedName;

public class BaseTrain
{
    @SerializedName("trainTypeCode")
    private String code;
    @SerializedName("trainTypeName")
    private String name;
    @SerializedName("trainTypeNameShort")
    private String shortName;
    
    public BaseTrain() {
    }
    
    public BaseTrain(final String code, final String name, final String shortName) {
        this.code = code;
        this.name = name;
        this.shortName = shortName;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getShortName() {
        return this.shortName;
    }
    
    public void setCode(final String code) {
        this.code = code;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }
}
