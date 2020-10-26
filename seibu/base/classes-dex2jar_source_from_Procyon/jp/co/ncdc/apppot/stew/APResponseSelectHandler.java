// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Iterator;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import jp.co.ncdc.apppot.stew.utils.JsonUtils;
import jp.co.ncdc.apppot.stew.log.Logger;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.Map;

public abstract class APResponseSelectHandler extends APSuperResponseHandler
{
    private static final String TAG = "APResponseSelectHandler";
    private Map<String, Class<APObject>> mAliasEntities;
    protected String mResultCount;
    public String url;
    
    public APResponseSelectHandler() {
        this.mResultCount = null;
    }
    
    public abstract void onFailure(final APError p0);
    
    public void onSuccess(final int i, String string) {
        while (true) {
            Logger.v("APResponseSelectHandler", "[onSuccess]URL=" + this.url + " \nStatusCode=" + i + "\nBody=" + (String)string);
            while (true) {
                Label_0434: {
                    try {
                        final AJSONObject convertToJSONObject = JsonUtils.convertToJSONObject((String)string);
                        final int int1 = convertToJSONObject.getInt("errCode");
                        final String string2 = convertToJSONObject.getString("description");
                        if (int1 > 0 && int1 != 200) {
                            this.checkTokenValid(string2);
                            this.onFailure(new APError(string2, int1));
                            return;
                        }
                        this.checkOutOfService(APService.getInstance().getServerInfo().checkCharacter, (String)string, int1);
                        Logger.d("APResponseSelectHandler", "[onSuccess]responseBody=" + convertToJSONObject.toString());
                        string = convertToJSONObject.getString("count");
                        if (string != null) {
                            this.mResultCount = (String)string;
                            return;
                        }
                        final HashMap<Object, List> hashMap = new HashMap<Object, List>();
                        final Iterator keys = convertToJSONObject.keys();
                        String s = null;
                        Block_8: {
                            while (keys.hasNext()) {
                                s = keys.next();
                                final JSONArray jsonArray = convertToJSONObject.getJSONArray(s);
                                if (jsonArray.length() != 0) {
                                    break Block_8;
                                }
                            }
                            goto Label_0390;
                        }
                        if (hashMap.get(s) == null) {
                            final ArrayList list = new ArrayList();
                        }
                        break Label_0434;
                        // iftrue(Label_0343:, n >= jsonArray.length())
                        JSONArray jsonArray = null;
                        int n = 0;
                        final JSONObject jsonObject = JsonUtils.getJsonObject(jsonArray, n);
                        final Class<APObject> clazz = this.mAliasEntities.get(s);
                        try {
                            ((List<APObject>)string).add(JsonUtils.convertJsonToAPObject(clazz, jsonObject));
                            ++n;
                        }
                        catch (JSONException ex) {
                            ex.printStackTrace();
                        }
                    }
                    catch (APOutOfServiceException ex2) {
                        this.onFailure(new APError(ex2.getMessage(), i));
                        return;
                    }
                    catch (NullPointerException ex3) {
                        ex3.printStackTrace();
                        Logger.v("APResponseSelectHandler", "[onSuccess]NPE");
                        this.onFailure(new APError(ex3.getLocalizedMessage(), -1));
                        return;
                    }
                    catch (UnsupportedEncodingException ex4) {
                        ex4.printStackTrace();
                        this.onFailure(new APError(ex4.getLocalizedMessage(), -1));
                        return;
                    }
                    finally {
                        this.countDown();
                    }
                }
                int n = 0;
                continue;
            }
        }
    }
    
    public abstract void onSuccess(final Map<String, List<APObject>> p0);
    
    void setAliasEntities(final Map<String, Class<APObject>> mAliasEntities) {
        this.mAliasEntities = mAliasEntities;
    }
}
