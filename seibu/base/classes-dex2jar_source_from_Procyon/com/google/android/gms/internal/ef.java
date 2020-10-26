// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zzi;
import java.util.HashMap;
import com.google.android.gms.common.util.zze;
import java.util.Map;
import android.content.Context;

public final class ef
{
    private final Context mContext;
    private String zzbEa;
    private Map<String, Object> zzbKw;
    private final Map<String, Object> zzbKx;
    private final ep zzbLI;
    private final zze zzvw;
    
    public ef(final Context context) {
        this(context, new HashMap<String, Object>(), new ep(context), zzi.zzrY());
    }
    
    private ef(final Context mContext, final Map<String, Object> zzbKx, final ep zzbLI, final zze zzvw) {
        this.zzbEa = null;
        this.zzbKw = new HashMap<String, Object>();
        this.mContext = mContext;
        this.zzvw = zzvw;
        this.zzbLI = zzbLI;
        this.zzbKx = zzbKx;
    }
    
    public final void zzgc(final String zzbEa) {
        this.zzbEa = zzbEa;
    }
}
