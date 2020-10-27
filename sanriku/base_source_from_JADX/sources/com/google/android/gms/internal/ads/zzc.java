package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class zzc extends Thread {
    private static final boolean DEBUG = zzag.DEBUG;
    private final BlockingQueue<zzq<?>> zza;
    /* access modifiers changed from: private */
    public final BlockingQueue<zzq<?>> zzb;
    private final zza zzc;
    /* access modifiers changed from: private */
    public final zzaa zzd;
    private volatile boolean zze = false;
    private final zze zzf;

    public zzc(BlockingQueue<zzq<?>> blockingQueue, BlockingQueue<zzq<?>> blockingQueue2, zza zza2, zzaa zzaa) {
        this.zza = blockingQueue;
        this.zzb = blockingQueue2;
        this.zzc = zza2;
        this.zzd = zzaa;
        this.zzf = new zze(this);
    }

    private final void processRequest() throws InterruptedException {
        zzaa zzaa;
        zzq take = this.zza.take();
        take.zzb("cache-queue-take");
        take.zza(1);
        try {
            take.isCanceled();
            zzd zza2 = this.zzc.zza(take.zze());
            if (zza2 == null) {
                take.zzb("cache-miss");
                if (!this.zzf.zzb(take)) {
                    this.zzb.put(take);
                }
            } else if (zza2.zza()) {
                take.zzb("cache-hit-expired");
                take.zza(zza2);
                if (!this.zzf.zzb(take)) {
                    this.zzb.put(take);
                }
                take.zza(2);
            } else {
                take.zzb("cache-hit");
                zzz zza3 = take.zza(new zzo(zza2.data, zza2.zzl));
                take.zzb("cache-hit-parsed");
                if (!(zza2.zzk < System.currentTimeMillis())) {
                    zzaa = this.zzd;
                } else {
                    take.zzb("cache-hit-refresh-needed");
                    take.zza(zza2);
                    zza3.zzbj = true;
                    if (!this.zzf.zzb(take)) {
                        this.zzd.zza(take, zza3, new zzf(this, take));
                        take.zza(2);
                    }
                    zzaa = this.zzd;
                }
                zzaa.zzb(take, zza3);
                take.zza(2);
            }
        } finally {
            take.zza(2);
        }
    }

    public final void quit() {
        this.zze = true;
        interrupt();
    }

    public final void run() {
        if (DEBUG) {
            zzag.m296v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzc.initialize();
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzag.m295e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
