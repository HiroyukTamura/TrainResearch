// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbo;
import android.app.Activity;
import com.google.android.gms.common.util.zza;

public class zzbbw extends zzbba
{
    private zzbdb zzaAN;
    private final zza<zzbat<?>> zzaCW;
    
    private zzbbw(final zzbdt zzbdt) {
        super(zzbdt);
        this.zzaCW = new zza<zzbat<?>>();
        this.zzaEG.zza("ConnectionlessLifecycleHelper", this);
    }
    
    public static void zza(final Activity activity, final zzbdb zzaAN, final zzbat<?> zzbat) {
        zzbds.zzn(activity);
        final zzbdt zzn = zzbds.zzn(activity);
        zzbbw zzbbw;
        if ((zzbbw = zzn.zza("ConnectionlessLifecycleHelper", zzbbw.class)) == null) {
            zzbbw = new zzbbw(zzn);
        }
        zzbbw.zzaAN = zzaAN;
        zzbo.zzb(zzbat, "ApiKey cannot be null");
        zzbbw.zzaCW.add(zzbat);
        zzaAN.zza(zzbbw);
    }
    
    private final void zzpS() {
        if (!this.zzaCW.isEmpty()) {
            this.zzaAN.zza(this);
        }
    }
    
    @Override
    public final void onResume() {
        super.onResume();
        this.zzpS();
    }
    
    @Override
    public final void onStart() {
        super.onStart();
        this.zzpS();
    }
    
    @Override
    public final void onStop() {
        super.onStop();
        this.zzaAN.zzb(this);
    }
    
    @Override
    protected final void zza(final ConnectionResult connectionResult, final int n) {
        this.zzaAN.zza(connectionResult, n);
    }
    
    final zza<zzbat<?>> zzpR() {
        return this.zzaCW;
    }
    
    @Override
    protected final void zzps() {
        this.zzaAN.zzps();
    }
}
