// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class zzd extends Thread
{
    private static final boolean DEBUG;
    private final BlockingQueue<zzp<?>> zzg;
    private final BlockingQueue<zzp<?>> zzh;
    private final zzb zzi;
    private final zzw zzj;
    private volatile boolean zzk;
    
    static {
        DEBUG = zzab.DEBUG;
    }
    
    public zzd(final BlockingQueue<zzp<?>> zzg, final BlockingQueue<zzp<?>> zzh, final zzb zzi, final zzw zzj) {
        this.zzk = false;
        this.zzg = zzg;
        this.zzh = zzh;
        this.zzi = zzi;
        this.zzj = zzj;
    }
    
    public final void quit() {
        this.zzk = true;
        this.interrupt();
    }
    
    @Override
    public final void run() {
        if (zzd.DEBUG) {
            zzab.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzi.initialize();
    Label_0029_Outer:
        while (true) {
            while (true) {
                zzp<?> zzp;
                zzc zza;
                try {
                    while (true) {
                        zzp = this.zzg.take();
                        zzp.zzb("cache-queue-take");
                        zza = this.zzi.zza(zzp.getUrl());
                        if (zza != null) {
                            break;
                        }
                        zzp.zzb("cache-miss");
                        this.zzh.put(zzp);
                    }
                }
                catch (InterruptedException ex) {
                    if (this.zzk) {
                        return;
                    }
                    continue Label_0029_Outer;
                }
                int n;
                if (zza.zzd < System.currentTimeMillis()) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                if (n != 0) {
                    zzp.zzb("cache-hit-expired");
                    zzp.zza(zza);
                    this.zzh.put(zzp);
                    continue;
                }
                zzp.zzb("cache-hit");
                final zzt<?> zza2 = zzp.zza(new zzn(zza.data, zza.zzf));
                zzp.zzb("cache-hit-parsed");
                int n2;
                if (zza.zze < System.currentTimeMillis()) {
                    n2 = 1;
                }
                else {
                    n2 = 0;
                }
                if (n2 == 0) {
                    this.zzj.zza(zzp, zza2);
                    continue;
                }
                zzp.zzb("cache-hit-refresh-needed");
                zzp.zza(zza);
                zza2.zzag = true;
                this.zzj.zza(zzp, zza2, new zze(this, zzp));
                continue;
            }
        }
    }
}
