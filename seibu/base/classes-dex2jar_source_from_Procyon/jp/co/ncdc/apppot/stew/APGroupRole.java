// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.utils.JsonUtils;
import org.json.JSONObject;

public class APGroupRole
{
    static final String KEY_GROUP = "group";
    static final String KEY_ROLE = "role";
    public APGroup group;
    public APRole role;
    
    public APGroupRole(final APGroup group, final APRole role) {
        this.group = group;
        this.role = role;
    }
    
    APGroupRole(final JSONObject jsonObject) {
        this.group = new APGroup(JsonUtils.getJsonObject(jsonObject, "group"));
        this.role = new APRole(JsonUtils.getJsonObject(jsonObject, "role"));
    }
    
    @Override
    public String toString() {
        return "group:{" + this.group.toString() + "}, role:{" + this.role.toString() + "}";
    }
}
