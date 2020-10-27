package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class zzm extends Thread {
    private final zzn zzaa;
    private final zza zzc;
    private final zzaa zzd;
    private volatile boolean zze = false;
    private final BlockingQueue<zzq<?>> zzz;

    public zzm(BlockingQueue<zzq<?>> blockingQueue, zzn zzn, zza zza, zzaa zzaa2) {
        this.zzz = blockingQueue;
        this.zzaa = zzn;
        this.zzc = zza;
        this.zzd = zzaa2;
    }

    private final void processRequest() throws InterruptedException {
        zzq take = this.zzz.take();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        take.zza(3);
        try {
            take.zzb("network-queue-take");
            take.isCanceled();
            TrafficStats.setThreadStatsTag(take.zzd());
            zzo zzc2 = this.zzaa.zzc(take);
            take.zzb("network-http-complete");
            if (!zzc2.zzac || !take.zzl()) {
                zzz zza = take.zza(zzc2);
                take.zzb("network-parse-complete");
                if (take.zzh() && zza.zzbh != null) {
                    this.zzc.zza(take.zze(), zza.zzbh);
                    take.zzb("network-cache-written");
                }
                take.zzk();
                this.zzd.zzb(take, zza);
                take.zza((zzz<?>) zza);
                take.zza(4);
                return;
            }
            take.zzc("not-modified");
            take.zzm();
        } catch (zzae e) {
            e.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzd.zza(take, e);
            take.zzm();
        } catch (Exception e2) {
            zzag.zza(e2, "Unhandled exception %s", e2.toString());
            zzae zzae = new zzae((Throwable) e2);
            zzae.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.zzd.zza(take, zzae);
            take.zzm();
        } finally {
            take.zza(4);
        }
    }

    public final void quit() {
        this.zze = true;
        interrupt();
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.m295e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
