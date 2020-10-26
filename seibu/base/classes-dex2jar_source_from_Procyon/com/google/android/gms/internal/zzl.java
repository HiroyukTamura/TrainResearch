// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.net.TrafficStats;
import android.os.SystemClock;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class zzl extends Thread
{
    private final zzb zzi;
    private final zzw zzj;
    private volatile boolean zzk;
    private final BlockingQueue<zzp<?>> zzw;
    private final zzk zzx;
    
    public zzl(final BlockingQueue<zzp<?>> zzw, final zzk zzx, final zzb zzi, final zzw zzj) {
        this.zzk = false;
        this.zzw = zzw;
        this.zzx = zzx;
        this.zzi = zzi;
        this.zzj = zzj;
    }
    
    public final void quit() {
        this.zzk = true;
        this.interrupt();
    }
    
    @Override
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                final zzp<?> zzp = this.zzw.take();
                try {
                    zzp.zzb("network-queue-take");
                    TrafficStats.setThreadStatsTag(zzp.zzc());
                    final zzn zza = this.zzx.zza(zzp);
                    zzp.zzb("network-http-complete");
                    if (!zza.zzz || !zzp.zzl()) {
                        goto Label_0113;
                    }
                    zzp.zzc("not-modified");
                }
                catch (zzaa zzaa) {
                    zzaa.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.zzj.zza(zzp, zzaa);
                }
                catch (Exception ex) {
                    zzab.zza(ex, "Unhandled exception %s", ex.toString());
                    final zzaa zzaa2 = new zzaa(ex);
                    zzaa2.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.zzj.zza(zzp, zzaa2);
                }
            }
            catch (InterruptedException ex2) {}
        }
    }
}
