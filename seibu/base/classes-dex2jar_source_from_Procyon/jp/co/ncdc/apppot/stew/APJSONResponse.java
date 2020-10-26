// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import android.util.Log;
import org.json.JSONObject;
import java.util.Iterator;
import org.json.JSONException;
import jp.co.ncdc.apppot.stew.utils.JsonUtils;
import org.json.JSONArray;
import java.util.HashMap;
import java.util.ArrayList;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import java.util.List;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.Map;

public class APJSONResponse implements APResponse
{
    private static final String TAG = "APJSONResponse";
    Map<String, APObject> mDtoListMap;
    private List<APObject> mLocalResultData;
    private AJSONObject mResponseData;
    
    public APJSONResponse(final AJSONObject mResponseData) {
        this.mLocalResultData = new ArrayList<APObject>();
        this.mDtoListMap = new HashMap<String, APObject>();
        this.mResponseData = mResponseData;
    }
    
    public APJSONResponse(final AJSONObject mResponseData, final List<APObject> mLocalResultData) {
        this.mLocalResultData = new ArrayList<APObject>();
        this.mDtoListMap = new HashMap<String, APObject>();
        this.mResponseData = mResponseData;
        if (mLocalResultData != null) {
            this.mLocalResultData = mLocalResultData;
        }
    }
    
    private APSearchResult getSearchResultOfValueObject(final APSearchResult apSearchResult, final Class<?> clazz, final JSONArray jsonArray) throws JSONException {
        for (int i = 0; i < jsonArray.length(); ++i) {
            final APObject convertJsonToAPObject = JsonUtils.convertJsonToAPObject(clazz, jsonArray.getJSONObject(i));
            if (convertJsonToAPObject != null) {
                apSearchResult.add(convertJsonToAPObject);
                this.mDtoListMap.put(convertJsonToAPObject.objectId, convertJsonToAPObject);
            }
        }
        return apSearchResult;
    }
    
    private boolean isContainsFromLocalResultData(final APObject apObject) {
        for (final APObject apObject2 : this.mLocalResultData) {
            if (apObject2.objectId.equals(apObject.objectId)) {
                this.mLocalResultData.remove(apObject2);
                return true;
            }
        }
        return false;
    }
    
    private void mergeResult(final APSearchResult apSearchResult) {
        for (final APObject apObject : this.mLocalResultData) {
            if (this.mDtoListMap.get(apObject.objectId) == null) {
                apSearchResult.add(apObject);
            }
        }
    }
    
    @Override
    public String getDescription() {
        return this.getResponseData().getString("description");
    }
    
    @Override
    public AJSONObject getResponseData() {
        return this.mResponseData;
    }
    
    public JSONArray getResultArray() throws JSONException {
        return this.mResponseData.getJSONArray("results");
    }
    
    @Override
    public List<APObject> getResultForSavedObject(final Class<?> clazz) {
        final ArrayList<APObject> list = new ArrayList<APObject>();
        try {
            final JSONArray resultArray = this.getResultArray();
            for (int length = resultArray.length(), i = 0; i < length; ++i) {
                final JSONObject jsonObject = (JSONObject)resultArray.get(i);
                final APObject instance = APObject.newInstance(clazz);
                instance.serverCreateTime = jsonObject.getString("serverCreateTime");
                instance.serverUpdateTime = jsonObject.getString("serverUpdateTime");
                instance.objectId = jsonObject.getString("objectId");
                Log.d("APJSONResponse", "dto=" + instance.toString());
                list.add(instance);
            }
        }
        catch (JSONException ex) {
            Log.e("APJSONResponse", "JSONException." + ex.getMessage(), (Throwable)ex);
        }
        return list;
    }
    
    @Override
    public APSearchResult getResultForSearchObject(final Class<?> clazz) {
        APSearchResult apSearchResult;
        APSearchResult searchResultOfValueObject = apSearchResult = new APSearchResult();
        APSearchResult apSearchResult2;
        try {
            final JSONObject results = this.getResults();
            apSearchResult = searchResultOfValueObject;
            final Iterator keys = results.keys();
            while (true) {
                apSearchResult = searchResultOfValueObject;
                apSearchResult2 = searchResultOfValueObject;
                if (!keys.hasNext()) {
                    break;
                }
                apSearchResult = searchResultOfValueObject;
                searchResultOfValueObject = this.getSearchResultOfValueObject(searchResultOfValueObject, clazz, results.getJSONArray((String)keys.next()));
            }
        }
        catch (JSONException ex) {
            Log.w("APJSONResponse", ex.getLocalizedMessage());
            apSearchResult2 = apSearchResult;
        }
        final ArrayList<APObject> list = new ArrayList<APObject>();
        for (final APObject apObject : apSearchResult2.getSearchResuls()) {
            boolean b = false;
            if (this.isContainsFromLocalResultData(apObject)) {
                b = true;
                this.mLocalResultData.remove(apObject);
            }
            if (!b) {
                list.add(apObject);
            }
        }
        APEntityManager.getInstance().saveNotExitLocal(list);
        if (this.mLocalResultData.size() > 0) {
            this.mergeResult(apSearchResult2);
            apSearchResult2.counter = apSearchResult2.getSearchResuls().size();
            return apSearchResult2;
        }
        apSearchResult2.counter = this.mResponseData.getInt("counter");
        return apSearchResult2;
    }
    
    public JSONObject getResults() throws JSONException {
        return this.mResponseData.getJSONObject("results");
    }
    
    public String getStatus() {
        return this.mResponseData.getString("status");
    }
    
    public String getString(final String s) {
        return this.mResponseData.getString(s);
    }
    
    @Override
    public boolean isOK() {
        return "OK".equals(this.getStatus());
    }
}
