// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AJSONObject extends JSONObject
{
    public AJSONObject() {
    }
    
    public AJSONObject(final String s) throws JSONException {
        super(s);
    }
    
    public AJSONObject getAJSONObject(final String s) {
        try {
            return new AJSONObject(super.getJSONObject(s).toString());
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public int getInt(final String s) {
        try {
            return super.getInt(s);
        }
        catch (JSONException ex) {
            return -99999;
        }
    }
    
    public JSONArray getJSONArray(final String s) {
        try {
            return super.getJSONArray(s);
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public long getLong(final String s) {
        try {
            return super.getLong(s);
        }
        catch (JSONException ex) {
            return -999999L;
        }
    }
    
    public String getString(String string) {
        try {
            string = super.getString(string);
            return string;
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public JSONObject put(final String s, final double n) {
        try {
            return super.put(s, n);
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public JSONObject put(final String s, final int n) {
        try {
            return super.put(s, n);
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public JSONObject put(final String s, final long n) {
        try {
            return super.put(s, n);
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public JSONObject put(final String s, final Object o) {
        try {
            return super.put(s, o);
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    public JSONObject put(final String s, final boolean b) {
        try {
            return super.put(s, b);
        }
        catch (JSONException ex) {
            return null;
        }
    }
}
