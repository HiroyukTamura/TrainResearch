// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import org.json.JSONException;
import org.json.JSONObject;

public class APUserInfo
{
    public static final String TAG = "APUserInfo";
    public String account;
    public String anonymousToken;
    public String firstName;
    public APGroupInfo[] groupInfo;
    public String lastLogginedAccount;
    public long lastLogginedUserId;
    public String lastName;
    public long userId;
    public String userTokens;
    public long validTime;
    
    public void clear() {
        this.userTokens = null;
        this.anonymousToken = null;
        this.userId = 0L;
        this.validTime = 0L;
        this.firstName = null;
        this.lastName = null;
        this.account = null;
        this.groupInfo = null;
    }
    
    void clearToken() {
        this.userTokens = null;
        this.anonymousToken = null;
    }
    
    public boolean isLogin() {
        return this.userTokens != null;
    }
    
    public static class APGroupInfo
    {
        public String description;
        public int groupId;
        public String groupName;
        public int roleId;
        public String roleName;
        
        public APGroupInfo(final JSONObject jsonObject) throws JSONException {
            this.groupId = jsonObject.getInt("groupId");
            this.groupName = jsonObject.getString("groupName");
            this.roleId = jsonObject.getInt("roleId");
            this.roleName = jsonObject.getString("roleName");
            this.description = jsonObject.getString("description");
        }
    }
}
