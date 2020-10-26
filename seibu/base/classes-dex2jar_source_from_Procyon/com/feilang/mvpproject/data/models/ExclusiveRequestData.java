// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.data.models;

import com.google.gson.annotations.SerializedName;

public class ExclusiveRequestData
{
    @SerializedName("key1")
    private String mKey1;
    @SerializedName("key2")
    private String mKey2;
    @SerializedName("key3")
    private String mKey3;
    
    public ExclusiveRequestData(final String mKey1, final String mKey2, final String mKey3) {
        this.mKey1 = mKey1;
        this.mKey2 = mKey2;
        this.mKey3 = mKey3;
    }
    
    public String getKey1() {
        return this.mKey1;
    }
    
    public String getKey2() {
        return this.mKey2;
    }
    
    public String getKey3() {
        return this.mKey3;
    }
    
    public void setKey1(final String mKey1) {
        this.mKey1 = mKey1;
    }
    
    public void setKey2(final String mKey2) {
        this.mKey2 = mKey2;
    }
    
    public void setKey3(final String mKey3) {
        this.mKey3 = mKey3;
    }
}
