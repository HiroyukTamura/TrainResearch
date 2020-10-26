// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.utils.JsonUtils;
import java.util.Iterator;
import jp.co.ncdc.apppot.stew.json.AJSONArray;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import jp.co.ncdc.apppot.stew.log.Logger;
import java.util.ArrayList;
import org.json.JSONObject;
import java.util.List;

public class APUser
{
    static final String KEY_ACCOUNT = "account";
    static final String KEY_FIRST_NAME = "firstName";
    static final String KEY_GROUP_ROLES = "groupRoleMap";
    static final String KEY_LAST_NAME = "lastName";
    static final String KEY_PASSWORD = "password";
    static final String KEY_USER = "user";
    static final String KEY_USERS = "users";
    static final String KEY_USER_ID = "userId";
    private static final APService SERVICE;
    private static final String TAG;
    public String account;
    public String firstName;
    public List<APGroupRole> groupRoleList;
    public String lastName;
    public String password;
    public long userId;
    
    static {
        TAG = APUser.class.getSimpleName();
        SERVICE = APService.getInstance();
    }
    
    public APUser() {
    }
    
    APUser(final JSONObject data) {
        this.setData(data);
    }
    
    private List<APGroupRole> convertToList(final JSONObject jsonObject, final String s) {
        final ArrayList<APGroupRole> list = new ArrayList<APGroupRole>();
        try {
            final JSONArray jsonArray = jsonObject.getJSONArray(s);
            for (int i = 0; i < jsonArray.length(); ++i) {
                list.add(new APGroupRole(jsonArray.getJSONObject(i)));
            }
        }
        catch (JSONException ex) {
            Logger.w(APUser.TAG, ex.getLocalizedMessage());
        }
        return list;
    }
    
    private static AJSONObject createParam(final String s, final String s2, final String s3, final String s4, final List<APGroupRole> list) {
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("token", APUser.SERVICE.getAuthToken());
        ajsonObject.put("account", s);
        ajsonObject.put("firstName", s2);
        ajsonObject.put("lastName", s3);
        ajsonObject.put("password", s4);
        final AJSONArray ajsonArray = new AJSONArray();
        for (final APGroupRole apGroupRole : list) {
            final AJSONObject ajsonObject2 = new AJSONObject();
            ajsonObject2.put("group", apGroupRole.group.toJsonGroupId());
            ajsonObject2.put("role", apGroupRole.role.toJsonRoleName());
            ajsonArray.put((Object)ajsonObject2);
        }
        ajsonObject.put("groupRoleMap", ajsonArray);
        return ajsonObject;
    }
    
    public static final void getList(final long lng, final APResponseHandler apResponseHandler) {
        Logger.v(APUser.TAG, "[getList]:start");
        if (!APUser.SERVICE.hasUserToken()) {
            Logger.w(APUser.TAG, "[getList]:You need User Token.");
            throw new IllegalArgumentException("You need User Token.");
        }
        APUser.SERVICE.getHttpClient().get(APUser.SERVICE.getContext(), APUser.SERVICE.getServerInfo().getUrl("/users?token=" + APUser.SERVICE.getAuthToken() + "&groupId=" + lng), apResponseHandler);
        Logger.v(APUser.TAG, "[getList]:end");
    }
    
    public void create(final APResponseHandler apResponseHandler) {
        Logger.v(APUser.TAG, "[create]:start");
        if (!APUser.SERVICE.hasUserToken()) {
            Logger.w(APUser.TAG, "[create]:You need User Token.");
            throw new IllegalArgumentException("You need User Token.");
        }
        final APHttpClient httpClient = APUser.SERVICE.getHttpClient();
        final AJSONObject param = createParam(this.account, this.firstName, this.lastName, this.password, this.groupRoleList);
        Logger.i(APUser.TAG, "param=" + param.toString());
        httpClient.postWithToken(APUser.SERVICE.getContext(), APUser.SERVICE.getAuthToken(), APUser.SERVICE.getServerInfo().getUrl("/users"), param, apResponseHandler);
        Logger.v(APUser.TAG, "[create]:end");
    }
    
    public void delete(final APResponseHandler apResponseHandler) {
        Logger.v(APUser.TAG, "[delete]:start");
        if (!APUser.SERVICE.hasUserToken()) {
            Logger.w(APUser.TAG, "[delete]:You need User Token.");
            throw new IllegalArgumentException("You need User Token.");
        }
        APUser.SERVICE.getHttpClient().delete(APUser.SERVICE.getContext(), APUser.SERVICE.getServerInfo().getUrl("/users/" + this.userId + "?token=" + APUser.SERVICE.getAuthToken()), apResponseHandler);
        Logger.v(APUser.TAG, "[delete]:end");
    }
    
    void setData(final JSONObject jsonObject) {
        this.userId = JsonUtils.getLong(jsonObject, "userId");
        this.account = JsonUtils.getString(jsonObject, "account");
        this.firstName = JsonUtils.getString(jsonObject, "firstName");
        this.lastName = JsonUtils.getString(jsonObject, "lastName");
        this.password = JsonUtils.getString(jsonObject, "password");
        this.groupRoleList = this.convertToList(jsonObject, "groupRoleMap");
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.groupRoleList != null && this.groupRoleList.size() > 0) {
            final Iterator<APGroupRole> iterator = this.groupRoleList.iterator();
            while (iterator.hasNext()) {
                sb.append(iterator.next().toString());
            }
        }
        sb.append("]");
        return "userId:" + this.userId + ", account:" + this.account + ", firstName:" + this.firstName + ", lastName:" + this.lastName + ", password:" + this.password + ", groupRoleMap:" + sb.toString();
    }
    
    public void update(final APResponseHandler apResponseHandler) {
        Logger.v(APUser.TAG, "[update]:start");
        if (!APUser.SERVICE.hasUserToken()) {
            Logger.w(APUser.TAG, "[update]:You need User Token.");
            throw new IllegalArgumentException("You need User Token.");
        }
        APUser.SERVICE.getHttpClient().putWithToken(APUser.SERVICE.getContext(), APUser.SERVICE.getAuthToken(), APUser.SERVICE.getServerInfo().getUrl("/users/" + this.userId), createParam(this.account, this.firstName, this.lastName, this.password, this.groupRoleList), apResponseHandler);
        Logger.v(APUser.TAG, "[update]:end");
    }
}
