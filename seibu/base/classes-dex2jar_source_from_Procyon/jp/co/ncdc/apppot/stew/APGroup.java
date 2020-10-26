// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.utils.JsonUtils;
import jp.co.ncdc.apppot.stew.log.Logger;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import org.json.JSONObject;

public class APGroup
{
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_GROUP = "group";
    static final String KEY_GROUPS = "groups";
    static final String KEY_GROUP_ID = "groupId";
    static final String KEY_GROUP_NAME = "groupName";
    static final String KEY_IS_ADD_CURRENT_APP = "isAddCurrentApp";
    private static final APService SERVICE;
    private static final String TAG;
    public String description;
    public long groupId;
    public String groupName;
    public boolean isAddCurrentApp;
    
    static {
        TAG = APGroup.class.getSimpleName();
        SERVICE = APService.getInstance();
    }
    
    public APGroup() {
    }
    
    APGroup(final JSONObject data) {
        this.setData(data);
    }
    
    private static AJSONObject createParam(final String s, final String s2) {
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("token", APGroup.SERVICE.getAuthToken());
        ajsonObject.put("groupName", s);
        ajsonObject.put("description", s2);
        return ajsonObject;
    }
    
    private static AJSONObject createParam(final String s, final String s2, final boolean b) {
        final AJSONObject param = createParam(s, s2);
        param.put("isAddCurrentApp", b);
        return param;
    }
    
    public static final void getList(final APResponseHandler apResponseHandler) {
        Logger.v(APGroup.TAG, "[getList]:start");
        if (!APGroup.SERVICE.hasUserToken()) {
            Logger.w(APGroup.TAG, "[getList]:You need User Token.");
            throw new IllegalArgumentException("You need User Token.");
        }
        APGroup.SERVICE.getHttpClient().get(APGroup.SERVICE.getContext(), APGroup.SERVICE.getServerInfo().getUrl("/groups?token=" + APGroup.SERVICE.getAuthToken()), apResponseHandler);
        Logger.v(APGroup.TAG, "[getList]:end");
    }
    
    public void create(final boolean b, final APResponseHandler apResponseHandler) {
        Logger.v(APGroup.TAG, "[create]:start");
        if (!APGroup.SERVICE.hasUserToken()) {
            Logger.w(APGroup.TAG, "[create]:You need User Token.");
            throw new IllegalArgumentException("You need User Token.");
        }
        APGroup.SERVICE.getHttpClient().postWithToken(APGroup.SERVICE.getContext(), APGroup.SERVICE.getAuthToken(), APGroup.SERVICE.getServerInfo().getUrl("/groups"), createParam(this.groupName, this.description, b), apResponseHandler);
        Logger.v(APGroup.TAG, "[create]:end");
    }
    
    public void delete(final APResponseHandler apResponseHandler) {
        Logger.v(APGroup.TAG, "[delete]:start");
        if (!APGroup.SERVICE.hasUserToken()) {
            Logger.w(APGroup.TAG, "[delete]:You need User Token.");
            throw new IllegalArgumentException("You need User Token.");
        }
        APGroup.SERVICE.getHttpClient().delete(APGroup.SERVICE.getContext(), APGroup.SERVICE.getServerInfo().getUrl("/groups/" + this.groupId + "?token=" + APGroup.SERVICE.getAuthToken()), apResponseHandler);
        Logger.v(APGroup.TAG, "[delete]:end");
    }
    
    void setData(final JSONObject jsonObject) {
        this.groupId = JsonUtils.getLong(jsonObject, "groupId");
        this.groupName = JsonUtils.getString(jsonObject, "groupName");
        this.description = JsonUtils.getString(jsonObject, "description");
        this.isAddCurrentApp = JsonUtils.getBoolean(jsonObject, "isAddCurrentApp");
    }
    
    AJSONObject toJsonGroupId() {
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("groupId", this.groupId);
        return ajsonObject;
    }
    
    @Override
    public String toString() {
        return "groupId:" + this.groupId + ", groupName:" + this.groupName + ", description:" + this.description;
    }
    
    public void update(final APResponseHandler apResponseHandler) {
        Logger.v(APGroup.TAG, "[update]:start");
        if (!APGroup.SERVICE.hasUserToken()) {
            Logger.w(APGroup.TAG, "[update]:You need User Token.");
            throw new IllegalArgumentException("You need User Token.");
        }
        APGroup.SERVICE.getHttpClient().putWithToken(APGroup.SERVICE.getContext(), APGroup.SERVICE.getAuthToken(), APGroup.SERVICE.getServerInfo().getUrl("/groups/" + this.groupId), createParam(this.groupName, this.description), apResponseHandler);
        Logger.v(APGroup.TAG, "[update]:end");
    }
}
