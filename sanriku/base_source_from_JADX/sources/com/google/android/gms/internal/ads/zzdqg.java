package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpw;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzdqg<OutputT> extends zzdpw.zzj<OutputT> {
    private static final Logger zzhgm = Logger.getLogger(zzdqg.class.getName());
    private static final zzb zzhhl;
    private volatile int remaining;
    /* access modifiers changed from: private */
    public volatile Set<Throwable> seenExceptions = null;

    static final class zza extends zzb {
        private final AtomicReferenceFieldUpdater<zzdqg, Set<Throwable>> zzhhm;
        private final AtomicIntegerFieldUpdater<zzdqg> zzhhn;

        zza(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.zzhhm = atomicReferenceFieldUpdater;
            this.zzhhn = atomicIntegerFieldUpdater;
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzdqg zzdqg, Set<Throwable> set, Set<Throwable> set2) {
            this.zzhhm.compareAndSet(zzdqg, (Object) null, set2);
        }

        /* access modifiers changed from: package-private */
        public final int zzc(zzdqg zzdqg) {
            return this.zzhhn.decrementAndGet(zzdqg);
        }
    }

    static abstract class zzb {
        private zzb() {
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzdqg zzdqg, Set<Throwable> set, Set<Throwable> set2);

        /* access modifiers changed from: package-private */
        public abstract int zzc(zzdqg zzdqg);
    }

    static final class zzc extends zzb {
        private zzc() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzdqg zzdqg, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (zzdqg) {
                if (zzdqg.seenExceptions == null) {
                    Set unused = zzdqg.seenExceptions = set2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int zzc(zzdqg zzdqg) {
            int zzb;
            synchronized (zzdqg) {
                zzb = zzdqg.zzb(zzdqg);
            }
            return zzb;
        }
    }

    static {
        Throwable th;
        zzb zzb2;
        try {
            zzb2 = new zza(AtomicReferenceFieldUpdater.newUpdater(zzdqg.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzdqg.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzb2 = new zzc();
        }
        zzhhl = zzb2;
        if (th != null) {
            zzhgm.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzdqg(int i) {
        this.remaining = i;
    }

    static /* synthetic */ int zzb(zzdqg zzdqg) {
        int i = zzdqg.remaining - 1;
        zzdqg.remaining = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    public final Set<Throwable> zzawk() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzh(newSetFromMap);
        zzhhl.zza(this, (Set<Throwable>) null, newSetFromMap);
        return this.seenExceptions;
    }

    /* access modifiers changed from: package-private */
    public final int zzawl() {
        return zzhhl.zzc(this);
    }

    /* access modifiers changed from: package-private */
    public final void zzawm() {
        this.seenExceptions = null;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzh(Set<Throwable> set);
}
