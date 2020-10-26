// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.Set;
import java.util.Queue;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzs
{
    private AtomicInteger zzW;
    private final Map<String, Queue<zzp<?>>> zzX;
    private final Set<zzp<?>> zzY;
    private final PriorityBlockingQueue<zzp<?>> zzZ;
    private final PriorityBlockingQueue<zzp<?>> zzaa;
    private zzl[] zzab;
    private zzd zzac;
    private List<Object> zzad;
    private final zzb zzi;
    private final zzw zzj;
    private final zzk zzx;
    
    public zzs(final zzb zzb, final zzk zzk) {
        this(zzb, zzk, 4);
    }
    
    private zzs(final zzb zzb, final zzk zzk, final int n) {
        this(zzb, zzk, 4, new zzh(new Handler(Looper.getMainLooper())));
    }
    
    private zzs(final zzb zzi, final zzk zzx, final int n, final zzw zzj) {
        this.zzW = new AtomicInteger();
        this.zzX = new HashMap<String, Queue<zzp<?>>>();
        this.zzY = new HashSet<zzp<?>>();
        this.zzZ = new PriorityBlockingQueue<zzp<?>>();
        this.zzaa = new PriorityBlockingQueue<zzp<?>>();
        this.zzad = new ArrayList<Object>();
        this.zzi = zzi;
        this.zzx = zzx;
        this.zzab = new zzl[4];
        this.zzj = zzj;
    }
    
    public final void start() {
        final int n = 0;
        if (this.zzac != null) {
            this.zzac.quit();
        }
        for (int i = 0; i < this.zzab.length; ++i) {
            if (this.zzab[i] != null) {
                this.zzab[i].quit();
            }
        }
        (this.zzac = new zzd(this.zzZ, this.zzaa, this.zzi, this.zzj)).start();
        for (int j = n; j < this.zzab.length; ++j) {
            (this.zzab[j] = new zzl(this.zzaa, this.zzx, this.zzi, this.zzj)).start();
        }
    }
    
    public final <T> zzp<T> zzc(final zzp<T> e) {
        e.zza(this);
        synchronized (this.zzY) {
            this.zzY.add(e);
            // monitorexit(this.zzY)
            e.zza(this.zzW.incrementAndGet());
            e.zzb("add-to-queue");
            if (!e.zzh()) {
                this.zzaa.add(e);
                return e;
            }
        }
        while (true) {
            final zzp<?> e2;
            final String zzd;
            synchronized (this.zzX) {
                zzd = e2.zzd();
                if (this.zzX.containsKey(zzd)) {
                    Queue<zzp<?>> queue;
                    if ((queue = this.zzX.get(zzd)) == null) {
                        queue = new LinkedList<zzp<?>>();
                    }
                    queue.add(e2);
                    this.zzX.put(zzd, queue);
                    if (com.google.android.gms.internal.zzab.DEBUG) {
                        com.google.android.gms.internal.zzab.zza("Request for cacheKey=%s is in flight, putting on hold.", zzd);
                    }
                    return (zzp<T>)e2;
                }
            }
            this.zzX.put(zzd, null);
            this.zzZ.add(e2);
            return (zzp<T>)e2;
        }
    }
    
    final <T> void zzd(final zzp<T> zzp) {
        synchronized (this.zzY) {
            this.zzY.remove(zzp);
            // monitorexit(this.zzY)
            final List<Object> zzad = this.zzad;
            synchronized (this.zzY) {
                final Iterator<Object> iterator = this.zzad.iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                }
            }
        }
        // monitorexit(zzad)
        final zzp zzp2;
        if (zzp2.zzh()) {
            synchronized (this.zzX) {
                final String zzd = zzp2.zzd();
                final Queue<zzp<?>> c = this.zzX.remove(zzd);
                if (c != null) {
                    if (com.google.android.gms.internal.zzab.DEBUG) {
                        com.google.android.gms.internal.zzab.zza("Releasing %d waiting requests for cacheKey=%s.", c.size(), zzd);
                    }
                    this.zzZ.addAll((Collection<?>)c);
                }
            }
        }
    }
}
