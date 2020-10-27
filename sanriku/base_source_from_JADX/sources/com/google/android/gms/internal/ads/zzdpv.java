package com.google.android.gms.internal.ads;

import java.lang.Throwable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import p009e.p010a.p011a.p012a.C0681a;

abstract class zzdpv<V, X extends Throwable, F, T> extends zzdqq<V> implements Runnable {
    @NullableDecl
    private zzdri<? extends V> zzhgj;
    @NullableDecl
    private Class<X> zzhgk;
    @NullableDecl
    private F zzhgl;

    zzdpv(zzdri<? extends V> zzdri, Class<X> cls, F f) {
        this.zzhgj = (zzdri) zzdoj.checkNotNull(zzdri);
        this.zzhgk = (Class) zzdoj.checkNotNull(cls);
        this.zzhgl = zzdoj.checkNotNull(f);
    }

    static <X extends Throwable, V> zzdri<V> zza(zzdri<? extends V> zzdri, Class<X> cls, zzdqj<? super X, ? extends V> zzdqj, Executor executor) {
        zzdpu zzdpu = new zzdpu(zzdri, cls, zzdqj);
        zzdri.addListener(zzdpu, zzdrk.zza(executor, zzdpu));
        return zzdpu;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhgj);
        this.zzhgj = null;
        this.zzhgk = null;
        this.zzhgl = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        String str;
        zzdri<? extends V> zzdri = this.zzhgj;
        Class<X> cls = this.zzhgk;
        F f = this.zzhgl;
        String pendingToString = super.pendingToString();
        if (zzdri != null) {
            String valueOf = String.valueOf(zzdri);
            str = C0681a.m313a(valueOf.length() + 16, "inputFuture=[", valueOf, "], ");
        } else {
            str = "";
        }
        if (cls != null && f != null) {
            String valueOf2 = String.valueOf(cls);
            String valueOf3 = String.valueOf(f);
            return C0681a.m324a(C0681a.m337b(valueOf3.length() + valueOf2.length() + C0681a.m336b(str, 29), str, "exceptionType=[", valueOf2, "], fallback=["), valueOf3, "]");
        } else if (pendingToString == null) {
            return null;
        } else {
            String valueOf4 = String.valueOf(str);
            return pendingToString.length() != 0 ? valueOf4.concat(pendingToString) : new String(valueOf4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzdri<? extends V> r0 = r10.zzhgj
            java.lang.Class<X> r1 = r10.zzhgk
            F r2 = r10.zzhgl
            r3 = 1
            if (r0 != 0) goto L_0x000b
            r4 = 1
            goto L_0x000c
        L_0x000b:
            r4 = 0
        L_0x000c:
            if (r1 != 0) goto L_0x0010
            r5 = 1
            goto L_0x0011
        L_0x0010:
            r5 = 0
        L_0x0011:
            r4 = r4 | r5
            if (r2 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            r3 = r3 | r4
            if (r3 != 0) goto L_0x009f
            boolean r3 = r10.isCancelled()
            if (r3 == 0) goto L_0x0021
            goto L_0x009f
        L_0x0021:
            r3 = 0
            r10.zzhgj = r3
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzdrz     // Catch:{ ExecutionException -> 0x003a, all -> 0x0038 }
            if (r4 == 0) goto L_0x0030
            r4 = r0
            com.google.android.gms.internal.ads.zzdrz r4 = (com.google.android.gms.internal.ads.zzdrz) r4     // Catch:{ ExecutionException -> 0x003a, all -> 0x0038 }
            java.lang.Throwable r4 = com.google.android.gms.internal.ads.zzdsc.zza(r4)     // Catch:{ ExecutionException -> 0x003a, all -> 0x0038 }
            goto L_0x0031
        L_0x0030:
            r4 = r3
        L_0x0031:
            if (r4 != 0) goto L_0x0073
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzdqw.zza(r0)     // Catch:{ ExecutionException -> 0x003a, all -> 0x0038 }
            goto L_0x0074
        L_0x0038:
            r4 = move-exception
            goto L_0x0073
        L_0x003a:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x0072
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r7 = r6.length()
            int r7 = r7 + 35
            int r8 = r4.length()
            int r8 = r8 + r7
            java.lang.String r7 = "Future type "
            java.lang.String r9 = " threw "
            java.lang.StringBuilder r4 = p009e.p010a.p011a.p012a.C0681a.m337b(r8, r7, r6, r9, r4)
            java.lang.String r6 = " without a cause"
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
        L_0x0072:
            r4 = r5
        L_0x0073:
            r5 = r3
        L_0x0074:
            if (r4 != 0) goto L_0x007a
            r10.set(r5)
            return
        L_0x007a:
            boolean r1 = r1.isInstance(r4)
            if (r1 != 0) goto L_0x0084
            r10.setFuture(r0)
            return
        L_0x0084:
            java.lang.Object r0 = r10.zza(r2, r4)     // Catch:{ all -> 0x0090 }
            r10.zzhgk = r3
            r10.zzhgl = r3
            r10.setResult(r0)
            return
        L_0x0090:
            r0 = move-exception
            r10.setException(r0)     // Catch:{ all -> 0x0099 }
            r10.zzhgk = r3
            r10.zzhgl = r3
            return
        L_0x0099:
            r0 = move-exception
            r10.zzhgk = r3
            r10.zzhgl = r3
            throw r0
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpv.run():void");
    }

    /* access modifiers changed from: package-private */
    public abstract void setResult(@NullableDecl T t);

    /* access modifiers changed from: package-private */
    @NullableDecl
    public abstract T zza(F f, X x) throws Exception;
}
