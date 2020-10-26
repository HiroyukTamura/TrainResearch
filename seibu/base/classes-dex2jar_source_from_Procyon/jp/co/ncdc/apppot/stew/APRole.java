// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import org.json.JSONArray;
import org.json.JSONException;
import com.google.gson.Gson;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import java.util.ArrayList;
import jp.co.ncdc.apppot.stew.log.Logger;
import java.util.List;
import jp.co.ncdc.apppot.stew.utils.JsonUtils;
import org.json.JSONObject;

public class APRole
{
    static final String KEY_COMPANY_ID = "companyId";
    static final String KEY_DESCRIPTION = "description";
    static final String KEY_ROLE = "role";
    static final String KEY_ROLE_ID = "roleId";
    static final String KEY_ROLE_NAME = "roleName";
    private static final APService SERVICE;
    private static final String TAG;
    public long companyId;
    public String description;
    public long roleId;
    public String roleName;
    
    static {
        TAG = APRole.class.getSimpleName();
        SERVICE = APService.getInstance();
    }
    
    public APRole() {
    }
    
    APRole(final JSONObject jsonObject) {
        this.roleId = JsonUtils.getLong(jsonObject, "roleId");
        this.roleName = JsonUtils.getString(jsonObject, "roleName");
    }
    
    public static final List<APRole> getRoles() {
        Logger.v(APRole.TAG, "[getList]sync:start");
        final ArrayList<APRole> list = new ArrayList<APRole>();
        final APResponseHandler apResponseHandler = new APResponseHandler() {
            @Override
            public void onFailure(final APResponse apResponse) {
                Logger.w(APRole.TAG, "[onFailure]:" + apResponse.getResponseData());
            }
            
            @Override
            public void onSuccess(APResponse jsonArray) {
                Logger.v(APRole.TAG, "[onSuccess]" + jsonArray.getResponseData());
                jsonArray = (APResponse)((AJSONObject)jsonArray.getResponseData()).getJSONArray("results");
                int n = 0;
            Label_0092_Outer:
                while (true) {
                    if (n >= ((JSONArray)jsonArray).length()) {
                        return;
                    }
                    while (true) {
                        try {
                            list.add(new Gson().fromJson(((JSONArray)jsonArray).getJSONObject(n).toString(), APRole.class));
                            ++n;
                            continue Label_0092_Outer;
                        }
                        catch (JSONException ex) {
                            continue;
                        }
                        break;
                    }
                }
            }
        };
        apResponseHandler.setUseSynchronousMode(true);
        getRoles(apResponseHandler);
        Logger.v(APRole.TAG, "[getList]sync:end");
        return list;
    }
    
    public static final void getRoles(final APResponseHandler apResponseHandler) {
        if (!APRole.SERVICE.hasUserToken()) {
            throw new IllegalArgumentException("You need User Token.");
        }
        APRole.SERVICE.getHttpClient().get(APRole.SERVICE.getContext(), APRole.SERVICE.getServerInfo().getUrl("/roles?token=" + APRole.SERVICE.getAuthToken()), apResponseHandler);
    }
    
    AJSONObject toJsonRoleName() {
        final AJSONObject ajsonObject = new AJSONObject();
        ajsonObject.put("roleName", this.roleName);
        return ajsonObject;
    }
    
    @Override
    public String toString() {
        return "roleId:" + this.roleId + ", roleName:" + this.roleName;
    }
}
