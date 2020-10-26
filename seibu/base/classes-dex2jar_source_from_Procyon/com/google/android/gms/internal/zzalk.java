// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import com.google.android.gms.analytics.zzj;

public final class zzalk extends zzj<zzalk>
{
    private String mAppId;
    private String zzaeH;
    private String zzaeI;
    private String zzaeJ;
    
    public final void setAppId(final String mAppId) {
        this.mAppId = mAppId;
    }
    
    public final void setAppInstallerId(final String zzaeJ) {
        this.zzaeJ = zzaeJ;
    }
    
    public final void setAppName(final String zzaeH) {
        this.zzaeH = zzaeH;
    }
    
    public final void setAppVersion(final String zzaeI) {
        this.zzaeI = zzaeI;
    }
    
    @Override
    public final String toString() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("appName", this.zzaeH);
        hashMap.put("appVersion", this.zzaeI);
        hashMap.put("appId", this.mAppId);
        hashMap.put("appInstallerId", this.zzaeJ);
        return zzj.zzh(hashMap);
    }
    
    public final void zza(final zzalk zzalk) {
        if (!TextUtils.isEmpty((CharSequence)this.zzaeH)) {
            zzalk.zzaeH = this.zzaeH;
        }
        if (!TextUtils.isEmpty((CharSequence)this.zzaeI)) {
            zzalk.zzaeI = this.zzaeI;
        }
        if (!TextUtils.isEmpty((CharSequence)this.mAppId)) {
            zzalk.mAppId = this.mAppId;
        }
        if (!TextUtils.isEmpty((CharSequence)this.zzaeJ)) {
            zzalk.zzaeJ = this.zzaeJ;
        }
    }
    
    public final String zzhl() {
        return this.mAppId;
    }
    
    public final String zzjG() {
        return this.zzaeH;
    }
    
    public final String zzjH() {
        return this.zzaeI;
    }
    
    public final String zzjI() {
        return this.zzaeJ;
    }
}
