// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import org.json.JSONObject;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;
import jp.co.ncdc.apppot.stew.json.AJSONObject;

public class APFileResponse extends APJSONResponse
{
    private static final String TAG = "APGroupResponse";
    private static final String WARN_MESSAGE = "This method is not valid.";
    
    APFileResponse(final AJSONObject ajsonObject, final List<APObject> list) {
        super(ajsonObject, list);
    }
    
    public void getResult(final APFile apFile) {
        apFile.setData(this.getResponseData().getAJSONObject("results"));
    }
    
    @Override
    public List<APObject> getResultForSavedObject(final Class<?> clazz) {
        throw new IllegalArgumentException("This method is not valid.");
    }
    
    @Override
    public APSearchResult getResultForSearchObject(final Class<?> clazz) {
        throw new IllegalArgumentException("This method is not valid.");
    }
    
    @Override
    public JSONObject getResults() {
        throw new IllegalArgumentException("This method is not valid.");
    }
}
