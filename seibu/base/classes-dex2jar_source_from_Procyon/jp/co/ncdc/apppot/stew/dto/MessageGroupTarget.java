// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.dto;

public class MessageGroupTarget implements MessageTarget
{
    private long groupId;
    private String roleName;
    
    public long getGroupId() {
        return this.groupId;
    }
    
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setGroupId(final long groupId) {
        this.groupId = groupId;
    }
    
    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }
}
