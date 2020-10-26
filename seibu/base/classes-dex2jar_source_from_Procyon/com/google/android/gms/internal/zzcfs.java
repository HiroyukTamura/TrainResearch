// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import java.util.List;
import java.util.Map;
import android.support.annotation.WorkerThread;

@WorkerThread
final class zzcfs implements Runnable
{
    private final String mPackageName;
    private final int zzLe;
    private final Throwable zzaaS;
    private final zzcfr zzbra;
    private final byte[] zzbrb;
    private final Map<String, List<String>> zzbrc;
    
    private zzcfs(final String mPackageName, final zzcfr zzbra, final int zzLe, final Throwable zzaaS, final byte[] zzbrb, final Map<String, List<String>> zzbrc) {
        zzbo.zzu(zzbra);
        this.zzbra = zzbra;
        this.zzLe = zzLe;
        this.zzaaS = zzaaS;
        this.zzbrb = zzbrb;
        this.mPackageName = mPackageName;
        this.zzbrc = zzbrc;
    }
    
    @Override
    public final void run() {
        this.zzbra.zza(this.mPackageName, this.zzLe, this.zzaaS, this.zzbrb, this.zzbrc);
    }
}
