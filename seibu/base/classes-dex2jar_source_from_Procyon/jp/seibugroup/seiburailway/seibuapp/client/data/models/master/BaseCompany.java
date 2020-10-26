// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import com.google.gson.annotations.SerializedName;

public class BaseCompany
{
    @SerializedName("companyName")
    private String name;
    @SerializedName("companyNameShort")
    private String shortName;
    
    public BaseCompany() {
    }
    
    public BaseCompany(final String name, final String shortName) {
        this.name = name;
        this.shortName = shortName;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getShortName() {
        return this.shortName;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }
}
