// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.pref;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref
public interface PrefMasterData
{
    String appVersion();
    
    long expiredTime();
    
    String releaseDate();
    
    long validPeriod();
    
    int version();
}
