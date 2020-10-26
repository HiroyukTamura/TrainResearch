// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.utils;

import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import jp.co.ncdc.apppot.stew.json.AJSONArray;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import org.json.JSONException;
import java.util.Iterator;
import android.util.Log;
import jp.co.ncdc.apppot.stew.dto.APObject;
import org.json.JSONObject;

public class JsonUtils
{
    public static APObject convertJsonToAPObject(final Class<?> clazz, final JSONObject jsonObject) throws JSONException {
        final APObject instance = APObject.newInstance(clazz);
        Log.d("JsonUtils", "[convertJsonToAPObject]:record=" + jsonObject.toString());
        final Iterator keys = jsonObject.keys();
        while (keys.hasNext()) {
            final String s = keys.next();
            final String string = jsonObject.getString(s);
            if (!APObjectUtils.isExceptColumn(s) && !APObjectUtils.isServerColumn(s)) {
                if (s.equals("serverCreateTime")) {
                    instance.serverCreateTime = string;
                }
                else if (s.equals("serverUpdateTime")) {
                    instance.serverUpdateTime = string;
                }
                else if (s.equals("objectId")) {
                    instance.objectId = string;
                }
                else if (s.equals("createUserId")) {
                    if (string == null || string.equals("null")) {
                        continue;
                    }
                    instance.createUserId = Double.parseDouble(string);
                }
                else {
                    try {
                        APObject.setValueFromServer(instance, clazz.getField(s), string);
                    }
                    catch (Exception ex) {
                        Log.v("JsonUtils", "[convertJsonToAPObject]:no field=" + s + ", " + string);
                    }
                }
            }
        }
        Log.v("JsonUtils", "[convertJsonToAPObject]:dto=" + instance.toString());
        APObject apObject = instance;
        if (instance.objectId == null) {
            apObject = null;
        }
        return apObject;
    }
    
    public static AJSONObject convertToJSONObject(final String s) {
        if (s == null) {
            final AJSONObject ajsonObject = new AJSONObject();
            ajsonObject.put("status", "error");
            ajsonObject.put("results", new AJSONArray());
            return ajsonObject;
        }
        try {
            return new AJSONObject(s);
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static final boolean getBoolean(final JSONObject jsonObject, final String s) {
        try {
            return jsonObject.getBoolean(s);
        }
        catch (JSONException ex) {
            return false;
        }
    }
    
    public static final int getInt(final JSONObject jsonObject, final String s) {
        try {
            return jsonObject.getInt(s);
        }
        catch (JSONException ex) {
            return -1;
        }
    }
    
    public static JSONObject getJsonObject(final JSONArray jsonArray, final int n) {
        try {
            return jsonArray.getJSONObject(n);
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public static JSONObject getJsonObject(JSONObject jsonObject, final String s) {
        try {
            jsonObject = jsonObject.getJSONObject(s);
            return jsonObject;
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public static final long getLong(final JSONObject jsonObject, final String s) {
        try {
            return jsonObject.getLong(s);
        }
        catch (JSONException ex) {
            return -1L;
        }
    }
    
    public static final String getString(final JSONObject jsonObject, final String s) {
        try {
            return jsonObject.getString(s);
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public static final AJSONObject toJson(final Map<String, Object> map) {
        final AJSONObject ajsonObject = new AJSONObject();
        for (final String s : map.keySet()) {
            final List<Object> value = map.get(s);
            if (value instanceof List) {
                ajsonObject.put(s, toJsonArray(value));
            }
            else if (value instanceof Map) {
                ajsonObject.put(s, toJson((Map<String, Object>)value));
            }
            else if (value instanceof String) {
                ajsonObject.put(s, String.valueOf(value));
            }
            else {
                ajsonObject.put(s, value);
            }
        }
        return ajsonObject;
    }
    
    public static final JSONArray toJsonArray(final List<Object> list) {
        final JSONArray jsonArray = new JSONArray();
        for (final Map<String, Object> next : list) {
            if (next instanceof Map) {
                jsonArray.put((Object)toJson(next));
            }
            else {
                jsonArray.put((Object)next);
            }
        }
        return jsonArray;
    }
}
