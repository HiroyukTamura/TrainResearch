// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;

public interface APResponse
{
    String getDescription();
    
    Object getResponseData();
    
    List<APObject> getResultForSavedObject(final Class<?> p0);
    
    APSearchResult getResultForSearchObject(final Class<?> p0);
    
    boolean isOK();
}
