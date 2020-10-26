// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.json.AJSONObject;
import jp.co.ncdc.apppot.stew.log.Logger;

public class APCommonResponseHandler extends APResponseHandler
{
    private static final String TAG = "APCommonResponseHandler";
    public int status;
    
    public APCommonResponseHandler(final boolean useSynchronousMode) {
        this.status = 0;
        this.setUseSynchronousMode(useSynchronousMode);
    }
    
    @Override
    public void onFailure(final APResponse apResponse) {
        Logger.v("APCommonResponseHandler", "[onFailure]" + apResponse.getDescription());
    }
    
    @Override
    public void onSuccess(final APResponse apResponse) {
        Logger.v("APCommonResponseHandler", "[onSuccess]" + apResponse.getDescription());
        if ("OK".equals(((AJSONObject)apResponse.getResponseData()).getString("status"))) {
            this.status = 1;
        }
    }
}
