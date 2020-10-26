// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.data.models;

import com.google.gson.annotations.SerializedName;

public class ExclusiveResponseData
{
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    
    public ExclusiveResponseData(final String mId, final String mName) {
        this.mId = mId;
        this.mName = mName;
    }
    
    public String getId() {
        return this.mId;
    }
    
    public String getName() {
        return this.mName;
    }
    
    public void setId(final String mId) {
        this.mId = mId;
    }
    
    public void setName(final String mName) {
        this.mName = mName;
    }
}
