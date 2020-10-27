package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class zzbcp implements zznu {
    private boolean isOpen;
    private Uri uri;
    private InputStream zzeff;
    private final zznu zzefg;
    @Nullable
    private final zzoi<zznu> zzefh;
    private final zzbcs zzefi;
    private final Context zzvf;

    public zzbcp(Context context, zznu zznu, zzoi<zznu> zzoi, zzbcs zzbcs) {
        this.zzvf = context;
        this.zzefg = zznu;
        this.zzefh = zzoi;
        this.zzefi = zzbcs;
    }

    public final void close() throws IOException {
        if (this.isOpen) {
            this.isOpen = false;
            this.uri = null;
            InputStream inputStream = this.zzeff;
            if (inputStream != null) {
                IOUtils.closeQuietly((Closeable) inputStream);
                this.zzeff = null;
            } else {
                this.zzefg.close();
            }
            zzoi<zznu> zzoi = this.zzefh;
            if (zzoi != null) {
                zzoi.zze(this);
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.isOpen) {
            InputStream inputStream = this.zzeff;
            int read = inputStream != null ? inputStream.read(bArr, i, i2) : this.zzefg.read(bArr, i, i2);
            zzoi<zznu> zzoi = this.zzefh;
            if (zzoi != null) {
                zzoi.zzc(this, read);
            }
            return read;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0093, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r6.cancel(true);
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009f, code lost:
        r6 = com.google.android.gms.ads.internal.zzq.zzld().elapsedRealtime() - r11;
        r1.zzefi.zzb(false, r6);
        r4 = new java.lang.StringBuilder(44);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r6.cancel(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b6, code lost:
        r6 = com.google.android.gms.ads.internal.zzq.zzld().elapsedRealtime() - r11;
        r1.zzefi.zzb(false, r6);
        r4 = new java.lang.StringBuilder(44);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c9, code lost:
        r4.append("Cache connection took ");
        r4.append(r6);
        r4.append("ms");
        com.google.android.gms.internal.ads.zzawr.zzeg(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00da, code lost:
        r4 = com.google.android.gms.ads.internal.zzq.zzld().elapsedRealtime() - r11;
        r1.zzefi.zzb(false, r4);
        r6 = new java.lang.StringBuilder(44);
        r6.append("Cache connection took ");
        r6.append(r4);
        r6.append("ms");
        com.google.android.gms.internal.ads.zzawr.zzeg(r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00fd, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:18:0x0095, B:21:0x00b3] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0095 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00b3 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x011e  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x00b3=Splitter:B:21:0x00b3, B:18:0x0095=Splitter:B:18:0x0095} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zznv r21) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "ms"
            java.lang.String r3 = "Cache connection took "
            boolean r4 = r1.isOpen
            if (r4 != 0) goto L_0x0144
            r4 = 1
            r1.isOpen = r4
            android.net.Uri r5 = r0.uri
            r1.uri = r5
            com.google.android.gms.internal.ads.zzoi<com.google.android.gms.internal.ads.zznu> r5 = r1.zzefh
            if (r5 == 0) goto L_0x001a
            r5.zza(r1, r0)
        L_0x001a:
            android.net.Uri r5 = r0.uri
            com.google.android.gms.internal.ads.zzsf r5 = com.google.android.gms.internal.ads.zzsf.zzd(r5)
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzzz.zzcpx
            com.google.android.gms.internal.ads.zzzv r7 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r6 = r7.zzd(r6)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            r7 = -1
            if (r6 == 0) goto L_0x00fe
            if (r5 == 0) goto L_0x011c
            long r9 = r0.position
            r5.zzbss = r9
            boolean r6 = r5.zzbsr
            if (r6 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzzz.zzcpz
            goto L_0x0043
        L_0x0041:
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzzz.zzcpy
        L_0x0043:
            com.google.android.gms.internal.ads.zzzv r9 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r6 = r9.zzd(r6)
            java.lang.Long r6 = (java.lang.Long) r6
            long r9 = r6.longValue()
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzq.zzld()
            long r11 = r6.elapsedRealtime()
            com.google.android.gms.ads.internal.zzq.zzlq()
            android.content.Context r6 = r1.zzvf
            java.util.concurrent.Future r6 = com.google.android.gms.internal.ads.zzsu.zza(r6, r5)
            r13 = 0
            r14 = 44
            java.util.concurrent.TimeUnit r15 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x00b3, InterruptedException -> 0x0095 }
            java.lang.Object r9 = r6.get(r9, r15)     // Catch:{ ExecutionException | TimeoutException -> 0x00b3, InterruptedException -> 0x0095 }
            java.io.InputStream r9 = (java.io.InputStream) r9     // Catch:{ ExecutionException | TimeoutException -> 0x00b3, InterruptedException -> 0x0095 }
            r1.zzeff = r9     // Catch:{ ExecutionException | TimeoutException -> 0x00b3, InterruptedException -> 0x0095 }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzq.zzld()
            long r5 = r0.elapsedRealtime()
            long r5 = r5 - r11
            com.google.android.gms.internal.ads.zzbcs r0 = r1.zzefi
            r0.zzb(r4, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            r0.append(r3)
            r0.append(r5)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.internal.ads.zzawr.zzeg(r0)
            return r7
        L_0x0093:
            r0 = move-exception
            goto L_0x00da
        L_0x0095:
            r6.cancel(r4)     // Catch:{ all -> 0x0093 }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0093 }
            r4.interrupt()     // Catch:{ all -> 0x0093 }
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzq.zzld()
            long r6 = r4.elapsedRealtime()
            long r6 = r6 - r11
            com.google.android.gms.internal.ads.zzbcs r4 = r1.zzefi
            r4.zzb(r13, r6)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
            goto L_0x00c9
        L_0x00b3:
            r6.cancel(r4)     // Catch:{ all -> 0x0093 }
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzq.zzld()
            long r6 = r4.elapsedRealtime()
            long r6 = r6 - r11
            com.google.android.gms.internal.ads.zzbcs r4 = r1.zzefi
            r4.zzb(r13, r6)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r14)
        L_0x00c9:
            r4.append(r3)
            r4.append(r6)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.google.android.gms.internal.ads.zzawr.zzeg(r2)
            goto L_0x011c
        L_0x00da:
            com.google.android.gms.common.util.Clock r4 = com.google.android.gms.ads.internal.zzq.zzld()
            long r4 = r4.elapsedRealtime()
            long r4 = r4 - r11
            com.google.android.gms.internal.ads.zzbcs r6 = r1.zzefi
            r6.zzb(r13, r4)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r14)
            r6.append(r3)
            r6.append(r4)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            com.google.android.gms.internal.ads.zzawr.zzeg(r2)
            throw r0
        L_0x00fe:
            r2 = 0
            if (r5 == 0) goto L_0x010d
            long r2 = r0.position
            r5.zzbss = r2
            com.google.android.gms.internal.ads.zzrx r2 = com.google.android.gms.ads.internal.zzq.zzlc()
            com.google.android.gms.internal.ads.zzse r2 = r2.zza((com.google.android.gms.internal.ads.zzsf) r5)
        L_0x010d:
            if (r2 == 0) goto L_0x011c
            boolean r3 = r2.zzmv()
            if (r3 == 0) goto L_0x011c
            java.io.InputStream r0 = r2.zzmw()
            r1.zzeff = r0
            return r7
        L_0x011c:
            if (r5 == 0) goto L_0x013d
            com.google.android.gms.internal.ads.zznv r2 = new com.google.android.gms.internal.ads.zznv
            java.lang.String r3 = r5.url
            android.net.Uri r10 = android.net.Uri.parse(r3)
            byte[] r11 = r0.zzbfm
            long r12 = r0.zzbfn
            long r14 = r0.position
            long r3 = r0.zzce
            java.lang.String r5 = r0.zzcc
            int r0 = r0.flags
            r9 = r2
            r16 = r3
            r18 = r5
            r19 = r0
            r9.<init>(r10, r11, r12, r14, r16, r18, r19)
            r0 = r2
        L_0x013d:
            com.google.android.gms.internal.ads.zznu r2 = r1.zzefg
            long r2 = r2.zza(r0)
            return r2
        L_0x0144:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "Attempt to open an already open CacheDataSource."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcp.zza(com.google.android.gms.internal.ads.zznv):long");
    }
}
