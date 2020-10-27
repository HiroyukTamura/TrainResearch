package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;
import sun.misc.Unsafe;

public class zzdpw<V> extends zzdrz implements zzdri<V> {
    /* access modifiers changed from: private */
    public static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL = new Object();
    private static final Logger zzhgm = Logger.getLogger(zzdpw.class.getName());
    /* access modifiers changed from: private */
    public static final zza zzhgn;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile zzd listeners;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile Object value;
    /* access modifiers changed from: private */
    @NullableDecl
    public volatile zzk waiters;

    static abstract class zza {
        private zza() {
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzk zzk, zzk zzk2);

        /* access modifiers changed from: package-private */
        public abstract void zza(zzk zzk, Thread thread);

        /* access modifiers changed from: package-private */
        public abstract boolean zza(zzdpw<?> zzdpw, zzd zzd, zzd zzd2);

        /* access modifiers changed from: package-private */
        public abstract boolean zza(zzdpw<?> zzdpw, zzk zzk, zzk zzk2);

        /* access modifiers changed from: package-private */
        public abstract boolean zza(zzdpw<?> zzdpw, Object obj, Object obj2);
    }

    static final class zzb {
        static final zzb zzhgo = new zzb(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable exception;

        zzb(Throwable th) {
            this.exception = (Throwable) zzdoj.checkNotNull(th);
        }
    }

    static final class zzc {
        static final zzc zzhgp;
        static final zzc zzhgq;
        @NullableDecl
        final Throwable cause;
        final boolean wasInterrupted;

        static {
            if (zzdpw.GENERATE_CANCELLATION_CAUSES) {
                zzhgq = null;
                zzhgp = null;
                return;
            }
            zzhgq = new zzc(false, (Throwable) null);
            zzhgp = new zzc(true, (Throwable) null);
        }

        zzc(boolean z, @NullableDecl Throwable th) {
            this.wasInterrupted = z;
            this.cause = th;
        }
    }

    static final class zzd {
        static final zzd zzhgr = new zzd((Runnable) null, (Executor) null);
        final Executor executor;
        @NullableDecl
        zzd next;
        final Runnable task;

        zzd(Runnable runnable, Executor executor2) {
            this.task = runnable;
            this.executor = executor2;
        }
    }

    static final class zze<V> implements Runnable {
        final zzdri<? extends V> future;
        final zzdpw<V> zzhgs;

        zze(zzdpw<V> zzdpw, zzdri<? extends V> zzdri) {
            this.zzhgs = zzdpw;
            this.future = zzdri;
        }

        public final void run() {
            if (this.zzhgs.value == this) {
                if (zzdpw.zzhgn.zza((zzdpw<?>) this.zzhgs, (Object) this, zzdpw.getFutureValue(this.future))) {
                    zzdpw.zza((zzdpw<?>) this.zzhgs);
                }
            }
        }
    }

    static final class zzf extends zza {
        final AtomicReferenceFieldUpdater<zzdpw, zzd> listenersUpdater;
        final AtomicReferenceFieldUpdater<zzdpw, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<zzk, zzk> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<zzk, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<zzdpw, zzk> waitersUpdater;

        zzf(AtomicReferenceFieldUpdater<zzk, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<zzk, zzk> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<zzdpw, zzk> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<zzdpw, zzd> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<zzdpw, Object> atomicReferenceFieldUpdater5) {
            super();
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, zzk zzk2) {
            this.waiterNextUpdater.lazySet(zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, Thread thread) {
            this.waiterThreadUpdater.lazySet(zzk, thread);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdpw<?> zzdpw, zzd zzd, zzd zzd2) {
            return this.listenersUpdater.compareAndSet(zzdpw, zzd, zzd2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdpw<?> zzdpw, zzk zzk, zzk zzk2) {
            return this.waitersUpdater.compareAndSet(zzdpw, zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdpw<?> zzdpw, Object obj, Object obj2) {
            return this.valueUpdater.compareAndSet(zzdpw, obj, obj2);
        }
    }

    interface zzg<V> extends zzdri<V> {
    }

    static final class zzh extends zza {
        private zzh() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, zzk zzk2) {
            zzk.next = zzk2;
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdpw<?> zzdpw, zzd zzd, zzd zzd2) {
            synchronized (zzdpw) {
                if (zzdpw.listeners != zzd) {
                    return false;
                }
                zzd unused = zzdpw.listeners = zzd2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdpw<?> zzdpw, zzk zzk, zzk zzk2) {
            synchronized (zzdpw) {
                if (zzdpw.waiters != zzk) {
                    return false;
                }
                zzk unused = zzdpw.waiters = zzk2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdpw<?> zzdpw, Object obj, Object obj2) {
            synchronized (zzdpw) {
                if (zzdpw.value != obj) {
                    return false;
                }
                Object unused = zzdpw.value = obj2;
                return true;
            }
        }
    }

    static final class zzi extends zza {
        static final Unsafe zzhgt;
        static final long zzhgu;
        static final long zzhgv;
        static final long zzhgw;
        static final long zzhgx;
        static final long zzhgy;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005d, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.ads.zzdpw.zzi.C06731());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.android.gms.internal.ads.zzdpw$zzk> r0 = com.google.android.gms.internal.ads.zzdpw.zzk.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.android.gms.internal.ads.zzdpw$zzi$1 r1 = new com.google.android.gms.internal.ads.zzdpw$zzi$1     // Catch:{ PrivilegedActionException -> 0x005d }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005d }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005d }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005d }
            L_0x0012:
                java.lang.Class<com.google.android.gms.internal.ads.zzdpw> r2 = com.google.android.gms.internal.ads.zzdpw.class
                java.lang.String r3 = "waiters"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                zzhgv = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "listeners"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ Exception -> 0x0053 }
                zzhgu = r3     // Catch:{ Exception -> 0x0053 }
                java.lang.String r3 = "value"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                zzhgw = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ Exception -> 0x0053 }
                zzhgx = r2     // Catch:{ Exception -> 0x0053 }
                java.lang.String r2 = "next"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ Exception -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ Exception -> 0x0053 }
                zzhgy = r2     // Catch:{ Exception -> 0x0053 }
                zzhgt = r1     // Catch:{ Exception -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                com.google.android.gms.internal.ads.zzdom.zzg(r0)
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005d:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.Throwable r0 = r0.getCause()
                java.lang.String r2 = "Could not initialize intrinsics"
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpw.zzi.<clinit>():void");
        }

        private zzi() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, zzk zzk2) {
            zzhgt.putObject(zzk, zzhgy, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzk zzk, Thread thread) {
            zzhgt.putObject(zzk, zzhgx, thread);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdpw<?> zzdpw, zzd zzd, zzd zzd2) {
            return zzhgt.compareAndSwapObject(zzdpw, zzhgu, zzd, zzd2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdpw<?> zzdpw, zzk zzk, zzk zzk2) {
            return zzhgt.compareAndSwapObject(zzdpw, zzhgv, zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zza(zzdpw<?> zzdpw, Object obj, Object obj2) {
            return zzhgt.compareAndSwapObject(zzdpw, zzhgw, obj, obj2);
        }
    }

    static abstract class zzj<V> extends zzdpw<V> implements zzg<V> {
        zzj() {
        }

        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return zzdpw.super.get(j, timeUnit);
        }
    }

    static final class zzk {
        static final zzk zzhgz = new zzk(false);
        @NullableDecl
        volatile zzk next;
        @NullableDecl
        volatile Thread thread;

        zzk() {
            zzdpw.zzhgn.zza(this, Thread.currentThread());
        }

        private zzk(boolean z) {
        }

        /* access modifiers changed from: package-private */
        public final void zzb(zzk zzk) {
            zzdpw.zzhgn.zza(this, zzk);
        }
    }

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        zza zza2;
        Class<zzk> cls = zzk.class;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        GENERATE_CANCELLATION_CAUSES = z;
        try {
            zza2 = new zzi();
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            zza2 = new zzh();
        }
        zzhgn = zza2;
        if (th != null) {
            zzhgm.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzhgm.logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    protected zzdpw() {
    }

    /* access modifiers changed from: private */
    public static Object getFutureValue(zzdri<?> zzdri) {
        Throwable zza2;
        if (zzdri instanceof zzg) {
            Object obj = ((zzdpw) zzdri).value;
            if (!(obj instanceof zzc)) {
                return obj;
            }
            zzc zzc2 = (zzc) obj;
            return zzc2.wasInterrupted ? zzc2.cause != null ? new zzc(false, zzc2.cause) : zzc.zzhgq : obj;
        } else if ((zzdri instanceof zzdrz) && (zza2 = zzdsc.zza((zzdrz) zzdri)) != null) {
            return new zzb(zza2);
        } else {
            boolean isCancelled = zzdri.isCancelled();
            if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
                return zzc.zzhgq;
            }
            try {
                Object uninterruptibly = getUninterruptibly(zzdri);
                if (!isCancelled) {
                    return uninterruptibly == null ? NULL : uninterruptibly;
                }
                String valueOf = String.valueOf(zzdri);
                StringBuilder sb = new StringBuilder(valueOf.length() + 84);
                sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                sb.append(valueOf);
                return new zzc(false, new IllegalArgumentException(sb.toString()));
            } catch (ExecutionException e) {
                if (!isCancelled) {
                    return new zzb(e.getCause());
                }
                String valueOf2 = String.valueOf(zzdri);
                return new zzc(false, new IllegalArgumentException(C0681a.m312a(valueOf2.length() + 84, "get() did not throw CancellationException, despite reporting isCancelled() == true: ", valueOf2), e));
            } catch (CancellationException e2) {
                if (isCancelled) {
                    return new zzc(false, e2);
                }
                String valueOf3 = String.valueOf(zzdri);
                return new zzb(new IllegalArgumentException(C0681a.m312a(valueOf3.length() + 77, "get() threw CancellationException, despite reporting isCancelled() == false: ", valueOf3), e2));
            } catch (Throwable th) {
                return new zzb(th);
            }
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    private final void zza(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zzhgz) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (zzhgn.zza((zzdpw<?>) this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: private */
    public static void zza(zzdpw<?> zzdpw) {
        zzdpw<V> zzdpw2;
        zzd zzd2;
        zzd zzd3;
        zzd zzd4 = null;
        zzdpw<?> zzdpw3 = zzdpw;
        while (true) {
            zzk zzk2 = zzdpw3.waiters;
            if (zzhgn.zza(zzdpw3, zzk2, zzk.zzhgz)) {
                while (zzk2 != null) {
                    Thread thread = zzk2.thread;
                    if (thread != null) {
                        zzk2.thread = null;
                        LockSupport.unpark(thread);
                    }
                    zzk2 = zzk2.next;
                }
                zzdpw3.afterDone();
                do {
                    zzd2 = zzdpw3.listeners;
                } while (!zzhgn.zza(zzdpw3, zzd2, zzd.zzhgr));
                while (true) {
                    zzd3 = zzd4;
                    zzd4 = zzd2;
                    if (zzd4 == null) {
                        break;
                    }
                    zzd2 = zzd4.next;
                    zzd4.next = zzd3;
                }
                while (zzd3 != null) {
                    zzd4 = zzd3.next;
                    Runnable runnable = zzd3.task;
                    if (runnable instanceof zze) {
                        zze zze2 = (zze) runnable;
                        zzdpw<V> zzdpw4 = zze2.zzhgs;
                        if (zzdpw4.value == zze2) {
                            if (zzhgn.zza((zzdpw<?>) zzdpw4, (Object) zze2, getFutureValue(zze2.future))) {
                                zzdpw2 = zzdpw4;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        zza(runnable, zzd3.executor);
                    }
                    zzd3 = zzd4;
                }
                return;
            }
            zzdpw2 = zzdpw3;
            zzdpw3 = zzdpw2;
        }
    }

    private static void zza(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzhgm;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", C0681a.m314a(valueOf2.length() + valueOf.length() + 57, "RuntimeException while executing runnable ", valueOf, " with executor ", valueOf2), e);
        }
    }

    private final void zza(StringBuilder sb) {
        String str = "]";
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            zza(sb, uninterruptibly);
            sb.append(str);
        } catch (ExecutionException e) {
            sb.append("FAILURE, cause=[");
            sb.append(e.getCause());
            sb.append(str);
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            str = " thrown from get()]";
            sb.append(str);
        }
    }

    private final void zza(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    private static V zzaf(Object obj) throws ExecutionException {
        if (obj instanceof zzc) {
            Throwable th = ((zzc) obj).cause;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzb) {
            throw new ExecutionException(((zzb) obj).exception);
        } else if (obj == NULL) {
            return null;
        } else {
            return obj;
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzdoj.checkNotNull(runnable, "Runnable was null.");
        zzdoj.checkNotNull(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zzhgr) {
            zza(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzhgn.zza((zzdpw<?>) this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zzhgr);
        zza(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void afterDone() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.android.gms.internal.ads.zzdri<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdpw.zze
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = GENERATE_CANCELLATION_CAUSES
            if (r3 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzdpw$zzc r3 = new com.google.android.gms.internal.ads.zzdpw$zzc
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzdpw$zzc r3 = com.google.android.gms.internal.ads.zzdpw.zzc.zzhgp
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzdpw$zzc r3 = com.google.android.gms.internal.ads.zzdpw.zzc.zzhgq
        L_0x0026:
            r5 = 0
            r4 = r7
        L_0x0028:
            com.google.android.gms.internal.ads.zzdpw$zza r6 = zzhgn
            boolean r6 = r6.zza((com.google.android.gms.internal.ads.zzdpw<?>) r4, (java.lang.Object) r0, (java.lang.Object) r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.interruptTask()
        L_0x0035:
            zza((com.google.android.gms.internal.ads.zzdpw<?>) r4)
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdpw.zze
            if (r4 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzdpw$zze r0 = (com.google.android.gms.internal.ads.zzdpw.zze) r0
            com.google.android.gms.internal.ads.zzdri<? extends V> r0 = r0.future
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdpw.zzg
            if (r4 == 0) goto L_0x0055
            r4 = r0
            com.google.android.gms.internal.ads.zzdpw r4 = (com.google.android.gms.internal.ads.zzdpw) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzdpw.zze
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = 1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzdpw.zze
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpw.cancel(boolean):boolean");
    }

    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zze))) {
                return zzaf(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zzhgz) {
                zzk zzk3 = new zzk();
                do {
                    zzk3.zzb(zzk2);
                    if (zzhgn.zza((zzdpw<?>) this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zza(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zze))));
                        return zzaf(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zzhgz);
            }
            return zzaf(this.value);
        }
        throw new InterruptedException();
    }

    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            if ((obj != null) && (!(obj instanceof zze))) {
                return zzaf(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                zzk zzk2 = this.waiters;
                if (zzk2 != zzk.zzhgz) {
                    zzk zzk3 = new zzk();
                    do {
                        zzk3.zzb(zzk2);
                        if (zzhgn.zza((zzdpw<?>) this, zzk2, zzk3)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof zze))) {
                                        return zzaf(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zza(zzk3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zza(zzk3);
                        } else {
                            zzk2 = this.waiters;
                        }
                    } while (zzk2 != zzk.zzhgz);
                }
                return zzaf(this.value);
            }
            while (nanos > 0) {
                Object obj3 = this.value;
                if ((obj3 != null) && (!(obj3 instanceof zze))) {
                    return zzaf(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzdpw = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String lowerCase2 = timeUnit.toString().toLowerCase(Locale.ROOT);
            StringBuilder sb = new StringBuilder(C0681a.m336b(lowerCase2, 28));
            sb.append("Waited ");
            sb.append(j);
            sb.append(" ");
            sb.append(lowerCase2);
            String sb2 = sb.toString();
            if (nanos + 1000 < 0) {
                String concat = String.valueOf(sb2).concat(" (plus ");
                long j2 = -nanos;
                long convert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(convert);
                boolean z = convert == 0 || nanos2 > 1000;
                if (convert > 0) {
                    String valueOf = String.valueOf(concat);
                    StringBuilder sb3 = new StringBuilder(C0681a.m336b(lowerCase, valueOf.length() + 21));
                    sb3.append(valueOf);
                    sb3.append(convert);
                    sb3.append(" ");
                    sb3.append(lowerCase);
                    String sb4 = sb3.toString();
                    if (z) {
                        sb4 = String.valueOf(sb4).concat(",");
                    }
                    concat = String.valueOf(sb4).concat(" ");
                }
                if (z) {
                    String valueOf2 = String.valueOf(concat);
                    StringBuilder sb5 = new StringBuilder(valueOf2.length() + 33);
                    sb5.append(valueOf2);
                    sb5.append(nanos2);
                    sb5.append(" nanoseconds ");
                    concat = sb5.toString();
                }
                sb2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(String.valueOf(sb2).concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(C0681a.m313a(C0681a.m336b(zzdpw, C0681a.m336b(sb2, 5)), sb2, " for ", zzdpw));
        }
        throw new InterruptedException();
    }

    /* access modifiers changed from: protected */
    public void interruptTask() {
    }

    public boolean isCancelled() {
        return this.value instanceof zzc;
    }

    public boolean isDone() {
        Object obj = this.value;
        return (!(obj instanceof zze)) & (obj != null);
    }

    /* access modifiers changed from: package-private */
    public final void maybePropagateCancellationTo(@NullableDecl Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public String pendingToString() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean set(@NullableDecl V v) {
        if (v == null) {
            v = NULL;
        }
        if (!zzhgn.zza((zzdpw<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        zza((zzdpw<?>) this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean setException(Throwable th) {
        if (!zzhgn.zza((zzdpw<?>) this, (Object) null, (Object) new zzb((Throwable) zzdoj.checkNotNull(th)))) {
            return false;
        }
        zza((zzdpw<?>) this);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean setFuture(zzdri<? extends V> zzdri) {
        zze zze2;
        zzb zzb2;
        zzdoj.checkNotNull(zzdri);
        Object obj = this.value;
        if (obj == null) {
            if (zzdri.isDone()) {
                if (!zzhgn.zza((zzdpw<?>) this, (Object) null, getFutureValue(zzdri))) {
                    return false;
                }
                zza((zzdpw<?>) this);
                return true;
            }
            zze2 = new zze(this, zzdri);
            if (zzhgn.zza((zzdpw<?>) this, (Object) null, (Object) zze2)) {
                try {
                    zzdri.addListener(zze2, zzdqp.INSTANCE);
                } catch (Throwable unused) {
                    zzb2 = zzb.zzhgo;
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzc) {
            zzdri.cancel(((zzc) obj).wasInterrupted);
        }
        return false;
        zzhgn.zza((zzdpw<?>) this, (Object) zze2, (Object) zzb2);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = super.toString()
            r0.append(r1)
            java.lang.String r1 = "[status="
            r0.append(r1)
            boolean r1 = r6.isCancelled()
            java.lang.String r2 = "]"
            if (r1 == 0) goto L_0x001f
            java.lang.String r1 = "CANCELLED"
            r0.append(r1)
            goto L_0x007f
        L_0x001f:
            boolean r1 = r6.isDone()
            if (r1 == 0) goto L_0x0026
            goto L_0x007c
        L_0x0026:
            int r1 = r0.length()
            java.lang.String r3 = "PENDING"
            r0.append(r3)
            java.lang.Object r3 = r6.value
            boolean r4 = r3 instanceof com.google.android.gms.internal.ads.zzdpw.zze
            if (r4 == 0) goto L_0x0042
            java.lang.String r4 = ", setFuture=["
            r0.append(r4)
            com.google.android.gms.internal.ads.zzdpw$zze r3 = (com.google.android.gms.internal.ads.zzdpw.zze) r3
            com.google.android.gms.internal.ads.zzdri<? extends V> r3 = r3.future
            r6.zza((java.lang.StringBuilder) r0, (java.lang.Object) r3)
            goto L_0x006c
        L_0x0042:
            java.lang.String r3 = r6.pendingToString()     // Catch:{ RuntimeException -> 0x004d, StackOverflowError -> 0x004b }
            java.lang.String r3 = com.google.android.gms.internal.ads.zzdok.emptyToNull(r3)     // Catch:{ RuntimeException -> 0x004d, StackOverflowError -> 0x004b }
            goto L_0x0062
        L_0x004b:
            r3 = move-exception
            goto L_0x004e
        L_0x004d:
            r3 = move-exception
        L_0x004e:
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r4 = r3.length()
            int r4 = r4 + 38
            java.lang.String r5 = "Exception thrown from implementation: "
            java.lang.String r3 = p009e.p010a.p011a.p012a.C0681a.m312a((int) r4, (java.lang.String) r5, (java.lang.String) r3)
        L_0x0062:
            if (r3 == 0) goto L_0x006f
            java.lang.String r4 = ", info=["
            r0.append(r4)
            r0.append(r3)
        L_0x006c:
            r0.append(r2)
        L_0x006f:
            boolean r3 = r6.isDone()
            if (r3 == 0) goto L_0x007f
            int r3 = r0.length()
            r0.delete(r1, r3)
        L_0x007c:
            r6.zza((java.lang.StringBuilder) r0)
        L_0x007f:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpw.toString():java.lang.String");
    }

    /* access modifiers changed from: protected */
    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof zzc) && ((zzc) obj).wasInterrupted;
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public final Throwable zzawf() {
        if (!(this instanceof zzg)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzb) {
            return ((zzb) obj).exception;
        }
        return null;
    }
}
