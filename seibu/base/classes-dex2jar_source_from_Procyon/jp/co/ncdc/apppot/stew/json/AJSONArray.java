// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.json;

import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONArray;

public class AJSONArray extends JSONArray
{
    public AJSONArray getJSONArray(final int n) {
        try {
            return (AJSONArray)super.getJSONArray(n);
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public AJSONObject getJSONObject(final int n) {
        try {
            return (AJSONObject)super.getJSONObject(n);
        }
        catch (JSONException ex) {
            return null;
        }
    }
}
