// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import com.google.gson.annotations.SerializedName;

public class BaseRouteGroup
{
    @SerializedName("lineGroupId")
    private String groupId;
    @SerializedName("lineGroupName")
    private String groupName;
    
    public BaseRouteGroup() {
    }
    
    public BaseRouteGroup(final String groupId, final String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }
    
    public String getGroupId() {
        return this.groupId;
    }
    
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupId(final String groupId) {
        this.groupId = groupId;
    }
    
    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }
}
