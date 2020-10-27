package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Future;
import p043jp.reifrontier.gym.RFGDef;

public final class zzbh extends zzan {
    private volatile String zzut;
    private Future<String> zzyh;

    protected zzbh(zzap zzap) {
        super(zzap);
    }

    private final boolean zzb(Context context, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotMainThread("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            zza("Storing clientId", str);
            fileOutputStream = context.openFileOutput("gaClientId", 0);
            fileOutputStream.write(str.getBytes());
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e) {
                zze("Failed to close clientId writing stream", e);
                return true;
            }
        } catch (FileNotFoundException e2) {
            zze("Error creating clientId file", e2);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    zze("Failed to close clientId writing stream", e3);
                }
            }
            return false;
        } catch (IOException e4) {
            zze("Error writing to clientId file", e4);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    zze("Failed to close clientId writing stream", e5);
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    zze("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0071 A[SYNTHETIC, Splitter:B:39:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007e A[SYNTHETIC, Splitter:B:47:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x008a A[SYNTHETIC, Splitter:B:55:0x008a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzd(android.content.Context r9) {
        /*
            r8 = this;
            java.lang.String r0 = "gaClientId"
            java.lang.String r1 = "Failed to close client id reading stream"
            java.lang.String r2 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r2)
            r2 = 0
            java.io.FileInputStream r3 = r9.openFileInput(r0)     // Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x0065, all -> 0x0063 }
            r4 = 36
            byte[] r5 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r6 = 0
            int r4 = r3.read(r5, r6, r4)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            int r7 = r3.available()     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            if (r7 <= 0) goto L_0x0031
            java.lang.String r4 = "clientId file seems corrupted, deleting it."
            r8.zzt(r4)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r3.close()     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r9.deleteFile(r0)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r3.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0030:
            return r2
        L_0x0031:
            r7 = 14
            if (r4 >= r7) goto L_0x0049
            java.lang.String r4 = "clientId file is empty, deleting it."
            r8.zzt(r4)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r3.close()     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r9.deleteFile(r0)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r3.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0048:
            return r2
        L_0x0049:
            r3.close()     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r7.<init>(r5, r6, r4)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            java.lang.String r4 = "Read client id from disk"
            r8.zza(r4, r7)     // Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005f }
            r3.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x005e:
            return r7
        L_0x005f:
            r4 = move-exception
            goto L_0x0067
        L_0x0061:
            goto L_0x0088
        L_0x0063:
            r9 = move-exception
            goto L_0x007c
        L_0x0065:
            r4 = move-exception
            r3 = r2
        L_0x0067:
            java.lang.String r5 = "Error reading client id file, deleting it"
            r8.zze(r5, r4)     // Catch:{ all -> 0x007a }
            r9.deleteFile(r0)     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x0079
            r3.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0079
        L_0x0075:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0079:
            return r2
        L_0x007a:
            r9 = move-exception
            r2 = r3
        L_0x007c:
            if (r2 == 0) goto L_0x0086
            r2.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x0086
        L_0x0082:
            r0 = move-exception
            r8.zze(r1, r0)
        L_0x0086:
            throw r9
        L_0x0087:
            r3 = r2
        L_0x0088:
            if (r3 == 0) goto L_0x0092
            r3.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r9 = move-exception
            r8.zze(r1, r9)
        L_0x0092:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbh.zzd(android.content.Context):java.lang.String");
    }

    /* access modifiers changed from: private */
    @VisibleForTesting
    public final String zzek() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            return !zzb(zzcq().getContext(), lowerCase) ? RFGDef.DEFAULT_GYM_ID : lowerCase;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return RFGDef.DEFAULT_GYM_ID;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaw() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e A[Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x0026 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzeh() {
        /*
            r2 = this;
            r2.zzdb()
            monitor-enter(r2)
            java.lang.String r0 = r2.zzut     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0017
            com.google.android.gms.analytics.zzk r0 = r2.zzcq()     // Catch:{ all -> 0x0050 }
            com.google.android.gms.internal.gtm.zzbi r1 = new com.google.android.gms.internal.gtm.zzbi     // Catch:{ all -> 0x0050 }
            r1.<init>(r2)     // Catch:{ all -> 0x0050 }
            java.util.concurrent.Future r0 = r0.zza(r1)     // Catch:{ all -> 0x0050 }
            r2.zzyh = r0     // Catch:{ all -> 0x0050 }
        L_0x0017:
            java.util.concurrent.Future<java.lang.String> r0 = r2.zzyh     // Catch:{ all -> 0x0050 }
            if (r0 == 0) goto L_0x004c
            java.util.concurrent.Future<java.lang.String> r0 = r2.zzyh     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x0026 }
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x0026 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x0026 }
            r2.zzut = r0     // Catch:{ InterruptedException -> 0x0031, ExecutionException -> 0x0026 }
            goto L_0x003a
        L_0x0026:
            r0 = move-exception
            java.lang.String r1 = "Failed to load or generate client id"
            r2.zze(r1, r0)     // Catch:{ all -> 0x0050 }
            java.lang.String r0 = "0"
        L_0x002e:
            r2.zzut = r0     // Catch:{ all -> 0x0050 }
            goto L_0x003a
        L_0x0031:
            r0 = move-exception
            java.lang.String r1 = "ClientId loading or generation was interrupted"
            r2.zzd(r1, r0)     // Catch:{ all -> 0x0050 }
            java.lang.String r0 = "0"
            goto L_0x002e
        L_0x003a:
            java.lang.String r0 = r2.zzut     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0042
            java.lang.String r0 = "0"
            r2.zzut = r0     // Catch:{ all -> 0x0050 }
        L_0x0042:
            java.lang.String r0 = "Loaded clientId"
            java.lang.String r1 = r2.zzut     // Catch:{ all -> 0x0050 }
            r2.zza(r0, r1)     // Catch:{ all -> 0x0050 }
            r0 = 0
            r2.zzyh = r0     // Catch:{ all -> 0x0050 }
        L_0x004c:
            java.lang.String r0 = r2.zzut     // Catch:{ all -> 0x0050 }
            monitor-exit(r2)     // Catch:{ all -> 0x0050 }
            return r0
        L_0x0050:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0050 }
            goto L_0x0054
        L_0x0053:
            throw r0
        L_0x0054:
            goto L_0x0053
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzbh.zzeh():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public final String zzei() {
        synchronized (this) {
            this.zzut = null;
            this.zzyh = zzcq().zza(new zzbj(this));
        }
        return zzeh();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final String zzej() {
        String zzd = zzd(zzcq().getContext());
        return zzd == null ? zzek() : zzd;
    }
}
