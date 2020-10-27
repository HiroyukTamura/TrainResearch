package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzbv;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzeo {
    private static final String TAG = "zzeo";
    protected Context zzvf;
    private volatile boolean zzwb;
    private zzem zzya;
    private ExecutorService zzyj;
    private DexClassLoader zzyk;
    private zzdv zzyl;
    private byte[] zzym;
    private volatile AdvertisingIdClient zzyn = null;
    private Future zzyo;
    private boolean zzyp;
    /* access modifiers changed from: private */
    public volatile zzbv.zza zzyq;
    private Future zzyr;
    private zzdh zzys;
    private boolean zzyt;
    private boolean zzyu;
    private Map<Pair<String, String>, zzfx> zzyv;
    private boolean zzyw;

    private zzeo(Context context) {
        boolean z = false;
        this.zzwb = false;
        this.zzyo = null;
        this.zzyq = null;
        this.zzyr = null;
        this.zzyt = false;
        this.zzyu = false;
        this.zzyw = false;
        Context applicationContext = context.getApplicationContext();
        z = applicationContext != null ? true : z;
        this.zzyp = z;
        this.zzvf = z ? applicationContext : context;
        this.zzyv = new HashMap();
        if (this.zzya == null) {
            this.zzya = new zzem(this.zzvf);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(1:22)(2:23|24))|25|26|27|28|29|(2:31|(1:33)(2:34|35))|36|(1:38)|39|40|41|42|43|44|45|66) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004d */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[Catch:{ zzdy -> 0x012f, zzeh -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087 A[Catch:{ all -> 0x00fe, FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b2 A[Catch:{ all -> 0x00fe, FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzeo zza(android.content.Context r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.String r0 = "%s/%s.dex"
            com.google.android.gms.internal.ads.zzeo r1 = new com.google.android.gms.internal.ads.zzeo
            r1.<init>(r9)
            com.google.android.gms.internal.ads.zzen r9 = new com.google.android.gms.internal.ads.zzen     // Catch:{ zzeh -> 0x0136 }
            r9.<init>()     // Catch:{ zzeh -> 0x0136 }
            java.util.concurrent.ExecutorService r9 = java.util.concurrent.Executors.newCachedThreadPool(r9)     // Catch:{ zzeh -> 0x0136 }
            r1.zzyj = r9     // Catch:{ zzeh -> 0x0136 }
            r1.zzwb = r12     // Catch:{ zzeh -> 0x0136 }
            if (r12 == 0) goto L_0x0023
            java.util.concurrent.ExecutorService r9 = r1.zzyj     // Catch:{ zzeh -> 0x0136 }
            com.google.android.gms.internal.ads.zzeq r12 = new com.google.android.gms.internal.ads.zzeq     // Catch:{ zzeh -> 0x0136 }
            r12.<init>(r1)     // Catch:{ zzeh -> 0x0136 }
            java.util.concurrent.Future r9 = r9.submit(r12)     // Catch:{ zzeh -> 0x0136 }
            r1.zzyo = r9     // Catch:{ zzeh -> 0x0136 }
        L_0x0023:
            java.util.concurrent.ExecutorService r9 = r1.zzyj     // Catch:{ zzeh -> 0x0136 }
            com.google.android.gms.internal.ads.zzes r12 = new com.google.android.gms.internal.ads.zzes     // Catch:{ zzeh -> 0x0136 }
            r12.<init>(r1)     // Catch:{ zzeh -> 0x0136 }
            r9.execute(r12)     // Catch:{ zzeh -> 0x0136 }
            r9 = 1
            r12 = 0
            com.google.android.gms.common.GoogleApiAvailabilityLight r2 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ all -> 0x004d }
            android.content.Context r3 = r1.zzvf     // Catch:{ all -> 0x004d }
            int r3 = r2.getApkVersion(r3)     // Catch:{ all -> 0x004d }
            if (r3 <= 0) goto L_0x003d
            r3 = 1
            goto L_0x003e
        L_0x003d:
            r3 = 0
        L_0x003e:
            r1.zzyt = r3     // Catch:{ all -> 0x004d }
            android.content.Context r3 = r1.zzvf     // Catch:{ all -> 0x004d }
            int r2 = r2.isGooglePlayServicesAvailable(r3)     // Catch:{ all -> 0x004d }
            if (r2 != 0) goto L_0x004a
            r2 = 1
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            r1.zzyu = r2     // Catch:{ all -> 0x004d }
        L_0x004d:
            r1.zza((int) r12, (boolean) r9)     // Catch:{ zzeh -> 0x0136 }
            boolean r2 = com.google.android.gms.internal.ads.zzet.isMainThread()     // Catch:{ zzeh -> 0x0136 }
            if (r2 == 0) goto L_0x0071
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzzz.zzcob     // Catch:{ zzeh -> 0x0136 }
            com.google.android.gms.internal.ads.zzzv r3 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ zzeh -> 0x0136 }
            java.lang.Object r2 = r3.zzd(r2)     // Catch:{ zzeh -> 0x0136 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ zzeh -> 0x0136 }
            boolean r2 = r2.booleanValue()     // Catch:{ zzeh -> 0x0136 }
            if (r2 != 0) goto L_0x0069
            goto L_0x0071
        L_0x0069:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ zzeh -> 0x0136 }
            java.lang.String r10 = "Task Context initialization must not be called from the UI thread."
            r9.<init>(r10)     // Catch:{ zzeh -> 0x0136 }
            throw r9     // Catch:{ zzeh -> 0x0136 }
        L_0x0071:
            com.google.android.gms.internal.ads.zzdv r2 = new com.google.android.gms.internal.ads.zzdv     // Catch:{ zzeh -> 0x0136 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ zzeh -> 0x0136 }
            r1.zzyl = r2     // Catch:{ zzeh -> 0x0136 }
            byte[] r10 = r2.zzan(r10)     // Catch:{ zzdy -> 0x012f }
            r1.zzym = r10     // Catch:{ zzdy -> 0x012f }
            android.content.Context r10 = r1.zzvf     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            java.io.File r10 = r10.getCacheDir()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            if (r10 != 0) goto L_0x0098
            android.content.Context r10 = r1.zzvf     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r2 = "dex"
            java.io.File r10 = r10.getDir(r2, r12)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            if (r10 == 0) goto L_0x0092
            goto L_0x0098
        L_0x0092:
            com.google.android.gms.internal.ads.zzeh r9 = new com.google.android.gms.internal.ads.zzeh     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            throw r9     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
        L_0x0098:
            java.lang.String r2 = "1582435991586"
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r5 = "%s/%s.jar"
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r7[r12] = r10     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r7[r9] = r2     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r5 = java.lang.String.format(r5, r7)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            boolean r5 = r4.exists()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            if (r5 != 0) goto L_0x00c9
            com.google.android.gms.internal.ads.zzdv r5 = r1.zzyl     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            byte[] r7 = r1.zzym     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            byte[] r11 = r5.zza(r7, r11)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r4.createNewFile()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            int r7 = r11.length     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r5.write(r11, r12, r7)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r5.close()     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
        L_0x00c9:
            r1.zzb((java.io.File) r10, (java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            dalvik.system.DexClassLoader r11 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x00fe }
            java.lang.String r5 = r4.getAbsolutePath()     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = r10.getAbsolutePath()     // Catch:{ all -> 0x00fe }
            android.content.Context r8 = r1.zzvf     // Catch:{ all -> 0x00fe }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x00fe }
            r11.<init>(r5, r7, r3, r8)     // Catch:{ all -> 0x00fe }
            r1.zzyk = r11     // Catch:{ all -> 0x00fe }
            zzb(r4)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r1.zza((java.io.File) r10, (java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.Object[] r11 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r11[r12] = r10     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r11[r9] = r2     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r10 = java.lang.String.format(r0, r11)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            zzao(r10)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            com.google.android.gms.internal.ads.zzdh r10 = new com.google.android.gms.internal.ads.zzdh     // Catch:{ zzeh -> 0x0136 }
            r10.<init>(r1)     // Catch:{ zzeh -> 0x0136 }
            r1.zzys = r10     // Catch:{ zzeh -> 0x0136 }
            r1.zzyw = r9     // Catch:{ zzeh -> 0x0136 }
            goto L_0x0136
        L_0x00fe:
            r11 = move-exception
            zzb(r4)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r1.zza((java.io.File) r10, (java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r3[r12] = r10     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            r3[r9] = r2     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            java.lang.String r9 = java.lang.String.format(r0, r3)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            zzao(r9)     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
            throw r11     // Catch:{ FileNotFoundException -> 0x0128, IOException -> 0x0121, zzdy -> 0x011a, NullPointerException -> 0x0113 }
        L_0x0113:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzeh r10 = new com.google.android.gms.internal.ads.zzeh     // Catch:{ zzeh -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzeh -> 0x0136 }
            throw r10     // Catch:{ zzeh -> 0x0136 }
        L_0x011a:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzeh r10 = new com.google.android.gms.internal.ads.zzeh     // Catch:{ zzeh -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzeh -> 0x0136 }
            throw r10     // Catch:{ zzeh -> 0x0136 }
        L_0x0121:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzeh r10 = new com.google.android.gms.internal.ads.zzeh     // Catch:{ zzeh -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzeh -> 0x0136 }
            throw r10     // Catch:{ zzeh -> 0x0136 }
        L_0x0128:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzeh r10 = new com.google.android.gms.internal.ads.zzeh     // Catch:{ zzeh -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzeh -> 0x0136 }
            throw r10     // Catch:{ zzeh -> 0x0136 }
        L_0x012f:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzeh r10 = new com.google.android.gms.internal.ads.zzeh     // Catch:{ zzeh -> 0x0136 }
            r10.<init>(r9)     // Catch:{ zzeh -> 0x0136 }
            throw r10     // Catch:{ zzeh -> 0x0136 }
        L_0x0136:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeo.zza(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.ads.zzeo");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c0 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d4 A[SYNTHETIC, Splitter:B:42:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00db A[SYNTHETIC, Splitter:B:46:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e5 A[SYNTHETIC, Splitter:B:54:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ec A[SYNTHETIC, Splitter:B:58:0x00ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "test"
            java.io.File r1 = new java.io.File
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r10
            r5 = 1
            r3[r5] = r11
            java.lang.String r6 = "%s/%s.tmp"
            java.lang.String r3 = java.lang.String.format(r6, r3)
            r1.<init>(r3)
            boolean r3 = r1.exists()
            if (r3 == 0) goto L_0x001d
            return
        L_0x001d:
            java.io.File r3 = new java.io.File
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r10
            r2[r5] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r2)
            r3.<init>(r10)
            boolean r10 = r3.exists()
            if (r10 != 0) goto L_0x0035
            return
        L_0x0035:
            long r5 = r3.length()
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 > 0) goto L_0x0040
            return
        L_0x0040:
            int r10 = (int) r5
            byte[] r10 = new byte[r10]
            r2 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d0 }
            r5.<init>(r3)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00e2, all -> 0x00d0 }
            int r6 = r5.read(r10)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            if (r6 > 0) goto L_0x0056
            r5.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            zzb(r3)
            return
        L_0x0056:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r6.print(r0)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r6.print(r0)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r6.print(r0)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzbv$zzc$zza r0 = com.google.android.gms.internal.ads.zzbv.zzc.zzbf()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzeaq r6 = com.google.android.gms.internal.ads.zzeaq.zzu(r6)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzbv$zzc$zza r0 = r0.zzd(r6)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r11 = r11.getBytes()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzeaq r11 = com.google.android.gms.internal.ads.zzeaq.zzu(r11)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzbv$zzc$zza r11 = r0.zzc(r11)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzdv r0 = r9.zzyl     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r6 = r9.zzym     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.lang.String r10 = r0.zzb(r6, r10)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r10 = r10.getBytes()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzeaq r0 = com.google.android.gms.internal.ads.zzeaq.zzu(r10)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzbv$zzc$zza r0 = r11.zza(r0)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            byte[] r10 = com.google.android.gms.internal.ads.zzcn.zzb(r10)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzeaq r10 = com.google.android.gms.internal.ads.zzeaq.zzu(r10)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r0.zzb(r10)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r1.createNewFile()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            r10.<init>(r1)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00cd, all -> 0x00c9 }
            com.google.android.gms.internal.ads.zzedo r11 = r11.zzbet()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzecd r11 = (com.google.android.gms.internal.ads.zzecd) r11     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            com.google.android.gms.internal.ads.zzbv$zzc r11 = (com.google.android.gms.internal.ads.zzbv.zzc) r11     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            int r0 = r11.length     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r10.write(r11, r4, r0)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r10.close()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ce, all -> 0x00c7 }
            r5.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00c0:
            r10.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            zzb(r3)
            return
        L_0x00c7:
            r11 = move-exception
            goto L_0x00cb
        L_0x00c9:
            r11 = move-exception
            r10 = r2
        L_0x00cb:
            r2 = r5
            goto L_0x00d2
        L_0x00cd:
            r10 = r2
        L_0x00ce:
            r2 = r5
            goto L_0x00e3
        L_0x00d0:
            r11 = move-exception
            r10 = r2
        L_0x00d2:
            if (r2 == 0) goto L_0x00d9
            r2.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00d9
        L_0x00d8:
        L_0x00d9:
            if (r10 == 0) goto L_0x00de
            r10.close()     // Catch:{ IOException -> 0x00de }
        L_0x00de:
            zzb(r3)
            throw r11
        L_0x00e2:
            r10 = r2
        L_0x00e3:
            if (r2 == 0) goto L_0x00ea
            r2.close()     // Catch:{ IOException -> 0x00e9 }
            goto L_0x00ea
        L_0x00e9:
        L_0x00ea:
            if (r10 == 0) goto L_0x00ef
            r10.close()     // Catch:{ IOException -> 0x00ef }
        L_0x00ef:
            zzb(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeo.zza(java.io.File, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public static boolean zza(int i, zzbv.zza zza) {
        if (i < 4) {
            return zza == null || !zza.zzak() || zza.zzag().equals("0000000000000000000000000000000000000000000000000000000000000000") || !zza.zzap() || !zza.zzaq().zzbh() || zza.zzaq().zzbi() == -2;
        }
        return false;
    }

    private static void zzao(String str) {
        zzb(new File(str));
    }

    private static void zzb(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00cc */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e4 A[SYNTHETIC, Splitter:B:55:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00eb A[SYNTHETIC, Splitter:B:59:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f2 A[SYNTHETIC, Splitter:B:66:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f9 A[SYNTHETIC, Splitter:B:70:0x00f9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzb(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r10
            r4 = 1
            r2[r4] = r11
            java.lang.String r5 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r5, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 != 0) goto L_0x001b
            return r3
        L_0x001b:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r10
            r1[r4] = r11
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r1)
            r2.<init>(r10)
            boolean r10 = r2.exists()
            if (r10 == 0) goto L_0x0033
            return r3
        L_0x0033:
            r10 = 0
            long r5 = r0.length()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 > 0) goto L_0x0042
            zzb(r0)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            return r3
        L_0x0042:
            int r1 = (int) r5     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            byte[] r1 = new byte[r1]     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            r5.<init>(r0)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00ef, all -> 0x00e0 }
            int r6 = r5.read(r1)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            if (r6 > 0) goto L_0x005e
            java.lang.String r11 = TAG     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r11, r1)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            zzb(r0)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r5.close()     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            return r3
        L_0x005e:
            com.google.android.gms.internal.ads.zzebq r6 = com.google.android.gms.internal.ads.zzebq.zzbed()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzbv$zzc r1 = com.google.android.gms.internal.ads.zzbv.zzc.zzb((byte[]) r1, (com.google.android.gms.internal.ads.zzebq) r6)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzeaq r7 = r1.zzbd()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r7 = r7.toByteArray()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r6.<init>(r7)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            boolean r11 = r11.equals(r6)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            if (r11 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzeaq r11 = r1.zzbc()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzeaq r6 = r1.zzbb()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r6 = r6.toByteArray()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r6 = com.google.android.gms.internal.ads.zzcn.zzb(r6)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            if (r11 == 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzeaq r11 = r1.zzbe()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r11 = r11.toByteArray()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            boolean r11 = java.util.Arrays.equals(r11, r6)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            if (r11 != 0) goto L_0x00a8
            goto L_0x00d2
        L_0x00a8:
            com.google.android.gms.internal.ads.zzdv r11 = r9.zzyl     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r0 = r9.zzym     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            com.google.android.gms.internal.ads.zzeaq r1 = r1.zzbb()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r1 = r1.toByteArray()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r6.<init>(r1)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            byte[] r11 = r11.zza(r0, r6)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r2.createNewFile()     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r0.<init>(r2)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            int r10 = r11.length     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00d0 }
            r0.write(r11, r3, r10)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00de, all -> 0x00d0 }
            r5.close()     // Catch:{ IOException -> 0x00cc }
        L_0x00cc:
            r0.close()     // Catch:{ IOException -> 0x00cf }
        L_0x00cf:
            return r4
        L_0x00d0:
            r11 = move-exception
            goto L_0x00db
        L_0x00d2:
            zzb(r0)     // Catch:{ zzdy | IOException | NoSuchAlgorithmException -> 0x00dd, all -> 0x00d9 }
            r5.close()     // Catch:{ IOException -> 0x00d8 }
        L_0x00d8:
            return r3
        L_0x00d9:
            r11 = move-exception
            r0 = r10
        L_0x00db:
            r10 = r5
            goto L_0x00e2
        L_0x00dd:
            r0 = r10
        L_0x00de:
            r10 = r5
            goto L_0x00f0
        L_0x00e0:
            r11 = move-exception
            r0 = r10
        L_0x00e2:
            if (r10 == 0) goto L_0x00e9
            r10.close()     // Catch:{ IOException -> 0x00e8 }
            goto L_0x00e9
        L_0x00e8:
        L_0x00e9:
            if (r0 == 0) goto L_0x00ee
            r0.close()     // Catch:{ IOException -> 0x00ee }
        L_0x00ee:
            throw r11
        L_0x00ef:
            r0 = r10
        L_0x00f0:
            if (r10 == 0) goto L_0x00f7
            r10.close()     // Catch:{ IOException -> 0x00f6 }
            goto L_0x00f7
        L_0x00f6:
        L_0x00f7:
            if (r0 == 0) goto L_0x00fc
            r0.close()     // Catch:{ IOException -> 0x00fc }
        L_0x00fc:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeo.zzb(java.io.File, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public final void zzcr() {
        try {
            if (this.zzyn == null && this.zzyp) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzvf);
                advertisingIdClient.start();
                this.zzyn = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzyn = null;
        }
    }

    @VisibleForTesting
    private final zzbv.zza zzcs() {
        try {
            return zzdlu.zzj(this.zzvf, this.zzvf.getPackageName(), Integer.toString(this.zzvf.getPackageManager().getPackageInfo(this.zzvf.getPackageName(), 0).versionCode));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Context getContext() {
        return this.zzvf;
    }

    public final boolean isInitialized() {
        return this.zzyw;
    }

    public final Method zza(String str, String str2) {
        zzfx zzfx = this.zzyv.get(new Pair(str, str2));
        if (zzfx == null) {
            return null;
        }
        return zzfx.zzdc();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(int i, boolean z) {
        if (this.zzyu) {
            Future<?> submit = this.zzyj.submit(new zzep(this, i, z));
            if (i == 0) {
                this.zzyr = submit;
            }
        }
    }

    public final boolean zza(String str, String str2, Class<?>... clsArr) {
        if (this.zzyv.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzyv.put(new Pair(str, str2), new zzfx(this, str, str2, clsArr));
        return true;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzbv.zza zzb(int i, boolean z) {
        if (i > 0 && z) {
            try {
                Thread.sleep((long) (i * 1000));
            } catch (InterruptedException unused) {
            }
        }
        return zzcs();
    }

    public final int zzbv() {
        if (this.zzys != null) {
            return zzdh.zzbv();
        }
        return Integer.MIN_VALUE;
    }

    public final boolean zzcg() {
        return this.zzya.zzcg();
    }

    public final ExecutorService zzch() {
        return this.zzyj;
    }

    public final DexClassLoader zzci() {
        return this.zzyk;
    }

    public final zzdv zzcj() {
        return this.zzyl;
    }

    public final byte[] zzck() {
        return this.zzym;
    }

    public final boolean zzcl() {
        return this.zzyt;
    }

    public final zzdh zzcm() {
        return this.zzys;
    }

    public final boolean zzcn() {
        return this.zzyu;
    }

    /* access modifiers changed from: package-private */
    public final zzem zzco() {
        return this.zzya;
    }

    public final zzbv.zza zzcp() {
        return this.zzyq;
    }

    public final Future zzcq() {
        return this.zzyr;
    }

    public final AdvertisingIdClient zzct() {
        if (!this.zzwb) {
            return null;
        }
        if (this.zzyn != null) {
            return this.zzyn;
        }
        Future future = this.zzyo;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzyo = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzyo.cancel(true);
            }
        }
        return this.zzyn;
    }
}
