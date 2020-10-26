// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import com.google.android.gms.common.internal.zzbo;
import java.util.Map;

public final class zzamm
{
    private final Map<String, String> zzHa;
    private final String zzafd;
    private final long zzagc;
    private final String zzagd;
    private final boolean zzage;
    private long zzagf;
    
    public zzamm(final long n, final String zzafd, final String zzagd, final boolean zzage, final long zzagf, final Map<String, String> m) {
        zzbo.zzcF(zzafd);
        zzbo.zzcF(zzagd);
        this.zzagc = 0L;
        this.zzafd = zzafd;
        this.zzagd = zzagd;
        this.zzage = zzage;
        this.zzagf = zzagf;
        if (m != null) {
            this.zzHa = new HashMap<String, String>(m);
            return;
        }
        this.zzHa = Collections.emptyMap();
    }
    
    public final Map<String, String> zzdV() {
        return this.zzHa;
    }
    
    public final String zzjX() {
        return this.zzafd;
    }
    
    public final long zzkK() {
        return this.zzagc;
    }
    
    public final String zzkL() {
        return this.zzagd;
    }
    
    public final boolean zzkM() {
        return this.zzage;
    }
    
    public final long zzkN() {
        return this.zzagf;
    }
    
    public final void zzm(final long zzagf) {
        this.zzagf = zzagf;
    }
}
