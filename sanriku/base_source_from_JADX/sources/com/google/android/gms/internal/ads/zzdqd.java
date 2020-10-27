package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;

abstract class zzdqd<InputT, OutputT> extends zzdqg<OutputT> {
    private static final Logger logger = Logger.getLogger(zzdqd.class.getName());
    /* access modifiers changed from: private */
    @NullableDecl
    public zzdot<? extends zzdri<? extends InputT>> zzhhe;
    private final boolean zzhhf;
    private final boolean zzhhg;

    enum zza {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    zzdqd(zzdot<? extends zzdri<? extends InputT>> zzdot, boolean z, boolean z2) {
        super(zzdot.size());
        this.zzhhe = (zzdot) zzdoj.checkNotNull(zzdot);
        this.zzhhf = z;
        this.zzhhg = z2;
    }

    /* access modifiers changed from: private */
    public final void zza(int i, Future<? extends InputT> future) {
        try {
            zzb(i, zzdqw.zza(future));
        } catch (ExecutionException e) {
            zzi(e.getCause());
        } catch (Throwable th) {
            zzi(th);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(@NullableDecl zzdot<? extends Future<? extends InputT>> zzdot) {
        int zzawl = zzawl();
        int i = 0;
        if (!(zzawl >= 0)) {
            throw new IllegalStateException("Less than 0 remaining futures");
        } else if (zzawl == 0) {
            if (zzdot != null) {
                zzdpp zzdpp = (zzdpp) zzdot.iterator();
                while (zzdpp.hasNext()) {
                    Future future = (Future) zzdpp.next();
                    if (!future.isCancelled()) {
                        zza(i, future);
                    }
                    i++;
                }
            }
            zzawm();
            zzawj();
            zza(zza.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    private static boolean zza(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    private final void zzi(Throwable th) {
        zzdoj.checkNotNull(th);
        if (this.zzhhf && !setException(th) && zza(zzawk(), th)) {
            zzj(th);
        } else if (th instanceof Error) {
            zzj(th);
        }
    }

    private static void zzj(Throwable th) {
        logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        super.afterDone();
        zzdot<? extends zzdri<? extends InputT>> zzdot = this.zzhhe;
        zza(zza.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (zzdot != null)) {
            boolean wasInterrupted = wasInterrupted();
            zzdpp zzdpp = (zzdpp) zzdot.iterator();
            while (zzdpp.hasNext()) {
                ((Future) zzdpp.next()).cancel(wasInterrupted);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzdot<? extends zzdri<? extends InputT>> zzdot = this.zzhhe;
        if (zzdot == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzdot);
        return C0681a.m312a(valueOf.length() + 8, "futures=", valueOf);
    }

    /* access modifiers changed from: package-private */
    public void zza(zza zza2) {
        zzdoj.checkNotNull(zza2);
        this.zzhhe = null;
    }

    /* access modifiers changed from: package-private */
    public final void zzawi() {
        if (this.zzhhe.isEmpty()) {
            zzawj();
        } else if (this.zzhhf) {
            int i = 0;
            zzdpp zzdpp = (zzdpp) this.zzhhe.iterator();
            while (zzdpp.hasNext()) {
                zzdri zzdri = (zzdri) zzdpp.next();
                zzdri.addListener(new zzdqc(this, zzdri, i), zzdqp.INSTANCE);
                i++;
            }
        } else {
            zzdqe zzdqe = new zzdqe(this, this.zzhhg ? this.zzhhe : null);
            zzdpp zzdpp2 = (zzdpp) this.zzhhe.iterator();
            while (zzdpp2.hasNext()) {
                ((zzdri) zzdpp2.next()).addListener(zzdqe, zzdqp.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zzawj();

    /* access modifiers changed from: package-private */
    public abstract void zzb(int i, @NullableDecl InputT inputt);

    /* access modifiers changed from: package-private */
    public final void zzh(Set<Throwable> set) {
        zzdoj.checkNotNull(set);
        if (!isCancelled()) {
            zza(set, zzawf());
        }
    }
}
