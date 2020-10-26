// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import android.util.Log;
import java.util.UUID;
import com.google.android.gms.analytics.zzj;

public final class zzalu extends zzj<zzalu>
{
    private int zzafk;
    private int zzafl;
    private String zzafm;
    private String zzafn;
    private boolean zzafo;
    private boolean zzafp;
    private String zzul;
    
    public zzalu() {
        this(false);
    }
    
    private zzalu(final boolean b) {
        final UUID randomUUID = UUID.randomUUID();
        int n = (int)(randomUUID.getLeastSignificantBits() & 0x7FFFFFFFL);
        if (n == 0 && (n = (int)(randomUUID.getMostSignificantBits() & 0x7FFFFFFFL)) == 0) {
            Log.e("GAv4", "UUID.randomUUID() returned 0.");
            n = Integer.MAX_VALUE;
        }
        this(false, n);
    }
    
    private zzalu(final boolean b, final int zzafk) {
        if (zzafk == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        this.zzafk = zzafk;
        this.zzafp = false;
    }
    
    @Override
    public final String toString() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("screenName", this.zzul);
        hashMap.put("interstitial", (String)this.zzafo);
        hashMap.put("automatic", (String)this.zzafp);
        hashMap.put("screenId", (String)this.zzafk);
        hashMap.put("referrerScreenId", (String)this.zzafl);
        hashMap.put("referrerScreenName", this.zzafm);
        hashMap.put("referrerUri", this.zzafn);
        return zzj.zzh(hashMap);
    }
    
    public final String zzkd() {
        return this.zzul;
    }
    
    public final int zzke() {
        return this.zzafk;
    }
    
    public final String zzkf() {
        return this.zzafn;
    }
}
