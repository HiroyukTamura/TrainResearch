// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.app.job.JobParameters;

final class zzcix implements Runnable
{
    private /* synthetic */ zzcgl zzbrM;
    final /* synthetic */ zzcfl zzbrP;
    final /* synthetic */ Integer zzbun;
    final /* synthetic */ JobParameters zzbuo;
    final /* synthetic */ zzciw zzbup;
    
    zzcix(final zzciw zzbup, final zzcgl zzbrM, final Integer zzbun, final zzcfl zzbrP, final JobParameters zzbuo) {
        this.zzbup = zzbup;
        this.zzbrM = zzbrM;
        this.zzbun = zzbun;
        this.zzbrP = zzbrP;
        this.zzbuo = zzbuo;
    }
    
    @Override
    public final void run() {
        this.zzbrM.zzze();
        this.zzbrM.zzl(new zzciy(this));
        this.zzbrM.zzza();
    }
}
