// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

final class zzj implements Runnable
{
    private final zzp zzt;
    private final zzt zzu;
    private final Runnable zzv;
    
    public zzj(final zzh zzh, final zzp zzt, final zzt zzu, final Runnable zzv) {
        this.zzt = zzt;
        this.zzu = zzu;
        this.zzv = zzv;
    }
    
    @Override
    public final void run() {
        int n;
        if (this.zzu.zzaf == null) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n != 0) {
            this.zzt.zza(this.zzu.result);
        }
        else {
            this.zzt.zzb(this.zzu.zzaf);
        }
        if (this.zzu.zzag) {
            this.zzt.zzb("intermediate-response");
        }
        else {
            this.zzt.zzc("done");
        }
        if (this.zzv != null) {
            this.zzv.run();
        }
    }
}
