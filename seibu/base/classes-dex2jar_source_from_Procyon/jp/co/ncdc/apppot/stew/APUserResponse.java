// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import org.json.JSONArray;
import org.json.JSONException;
import jp.co.ncdc.apppot.stew.log.Logger;
import java.util.ArrayList;
import org.json.JSONObject;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;
import jp.co.ncdc.apppot.stew.json.AJSONObject;

public class APUserResponse extends APJSONResponse
{
    private static final String TAG = "APUserResponse";
    private static final String WARN_MESSAGE = "This method is not valid.";
    
    APUserResponse(final AJSONObject ajsonObject, final List<APObject> list) {
        super(ajsonObject, list);
    }
    
    public APUser getResultData() {
        final AJSONObject ajsonObject = this.getResponseData().getAJSONObject("user");
        if (ajsonObject != null) {
            return new APUser(ajsonObject);
        }
        return null;
    }
    
    @Override
    public List<APObject> getResultForSavedObject(final Class<?> clazz) {
        throw new IllegalArgumentException("This method is not valid.");
    }
    
    @Override
    public APSearchResult getResultForSearchObject(final Class<?> clazz) {
        throw new IllegalArgumentException("This method is not valid.");
    }
    
    public List<APUser> getResultList() {
        final ArrayList<APUser> list = new ArrayList<APUser>();
        final JSONArray jsonArray = this.getResponseData().getJSONArray("users");
        int i = 0;
    Label_0047_Outer:
        while (i < jsonArray.length()) {
            while (true) {
                try {
                    list.add(new APUser(jsonArray.getJSONObject(i)));
                    ++i;
                    continue Label_0047_Outer;
                }
                catch (JSONException ex) {
                    Logger.w("APUserResponse", ex.getLocalizedMessage());
                    continue;
                }
                break;
            }
            break;
        }
        return list;
    }
    
    @Override
    public JSONObject getResults() {
        throw new IllegalArgumentException("This method is not valid.");
    }
}
