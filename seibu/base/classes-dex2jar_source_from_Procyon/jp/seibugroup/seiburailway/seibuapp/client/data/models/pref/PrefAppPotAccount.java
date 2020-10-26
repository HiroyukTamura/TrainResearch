// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.pref;

import org.androidannotations.annotations.sharedpreferences.DefaultBoolean;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref(SharedPref.Scope.UNIQUE)
public interface PrefAppPotAccount
{
    String apppotPassword();
    
    String apppotUserId();
    
    @DefaultBoolean(false)
    boolean isSaved();
    
    String loginToken();
}
