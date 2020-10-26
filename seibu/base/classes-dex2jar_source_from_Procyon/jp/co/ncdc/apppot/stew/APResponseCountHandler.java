// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;
import java.util.Map;
import jp.co.ncdc.apppot.stew.log.Logger;

public class APResponseCountHandler extends APResponseSelectHandler
{
    private static final String TAG = "APResponseCountHandler";
    
    public APResponseCountHandler() {
        this.setUseSynchronousMode(true);
    }
    
    protected int getCount() {
        if (this.mResultCount != null) {
            return Integer.parseInt(this.mResultCount);
        }
        return 0;
    }
    
    @Override
    public void onFailure(final APError apError) {
        Logger.w("APResponseCountHandler", "[onFailure]:no use this method.");
    }
    
    @Override
    public void onSuccess(final Map<String, List<APObject>> map) {
        Logger.w("APResponseCountHandler", "[onSuccess]:no use this method.");
    }
}
