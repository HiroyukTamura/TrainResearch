// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.pref;

import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref(SharedPref.Scope.UNIQUE)
public interface PrefAppData
{
    String appVersion();
    
    String dayStartTime();
    
    String deviceToken();
    
    @DefaultString("[]")
    String directionNameJson();
    
    @DefaultString("[]")
    String emergIdJson();
    
    String nightStartTime();
    
    @DefaultString("[]")
    String noticeIdJson();
}
