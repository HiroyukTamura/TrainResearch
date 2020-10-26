// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.text.TextUtils;
import java.util.HashMap;
import com.google.android.gms.analytics.zzj;

public final class zzalt extends zzj<zzalt>
{
    private String zzafc;
    private String zzafd;
    private String zzafe;
    private String zzaff;
    private boolean zzafg;
    private String zzafh;
    private boolean zzafi;
    private double zzafj;
    
    public final String getUserId() {
        return this.zzafe;
    }
    
    public final void setClientId(final String zzafd) {
        this.zzafd = zzafd;
    }
    
    public final void setUserId(final String zzafe) {
        this.zzafe = zzafe;
    }
    
    @Override
    public final String toString() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("hitType", this.zzafc);
        hashMap.put("clientId", this.zzafd);
        hashMap.put("userId", this.zzafe);
        hashMap.put("androidAdId", this.zzaff);
        hashMap.put("AdTargetingEnabled", (String)this.zzafg);
        hashMap.put("sessionControl", this.zzafh);
        hashMap.put("nonInteraction", (String)this.zzafi);
        hashMap.put("sampleRate", (String)this.zzafj);
        return zzj.zzh(hashMap);
    }
    
    public final void zzG(final boolean zzafg) {
        this.zzafg = zzafg;
    }
    
    public final void zzH(final boolean b) {
        this.zzafi = true;
    }
    
    public final void zzbj(final String zzafc) {
        this.zzafc = zzafc;
    }
    
    public final void zzbk(final String zzaff) {
        this.zzaff = zzaff;
    }
    
    public final String zzjW() {
        return this.zzafc;
    }
    
    public final String zzjX() {
        return this.zzafd;
    }
    
    public final String zzjY() {
        return this.zzaff;
    }
    
    public final boolean zzjZ() {
        return this.zzafg;
    }
    
    public final String zzka() {
        return this.zzafh;
    }
    
    public final boolean zzkb() {
        return this.zzafi;
    }
    
    public final double zzkc() {
        return this.zzafj;
    }
}
