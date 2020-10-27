package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzdf;
import com.google.android.gms.internal.gtm.zzdi;
import com.google.android.gms.internal.gtm.zzi;
import com.google.android.gms.internal.gtm.zzop;
import com.google.android.gms.internal.gtm.zzor;
import com.google.android.gms.internal.gtm.zzov;
import com.google.android.gms.internal.gtm.zzoz;
import com.google.android.gms.internal.gtm.zzuv;
import com.google.android.gms.internal.gtm.zzuw;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import p009e.p010a.p011a.p012a.C0681a;

final class zzex implements zzah {
    private final String zzaec;
    private zzdh<zzop> zzajf;
    private final ExecutorService zzajm = zzdf.zzgp().zzr(zzdi.zzadg);
    private final Context zzrm;

    zzex(Context context, String str) {
        this.zzrm = context;
        this.zzaec = str;
    }

    private static zzov zza(ByteArrayOutputStream byteArrayOutputStream) {
        try {
            return zzda.zzbf(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            zzdi.zzax("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return null;
        } catch (JSONException unused2) {
            zzdi.zzac("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return null;
        }
    }

    private static zzov zzb(byte[] bArr) {
        try {
            zzov zza = zzor.zza((zzi) zzuw.zza(new zzi(), bArr));
            if (zza != null) {
                zzdi.zzab("The container was successfully loaded from the resource (using binary file)");
            }
            return zza;
        } catch (zzuv unused) {
            zzdi.zzav("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (zzoz unused2) {
            zzdi.zzac("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    @VisibleForTesting
    private final File zzje() {
        String valueOf = String.valueOf(this.zzaec);
        return new File(this.zzrm.getDir("google_tagmanager", 0), valueOf.length() != 0 ? "resource_".concat(valueOf) : new String("resource_"));
    }

    public final synchronized void release() {
        this.zzajm.shutdown();
    }

    public final void zza(zzop zzop) {
        this.zzajm.execute(new zzez(this, zzop));
    }

    public final void zza(zzdh<zzop> zzdh) {
        this.zzajf = zzdh;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean zzb(zzop zzop) {
        File zzje = zzje();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzje);
            try {
                int zzpe = zzop.zzpe();
                byte[] bArr = new byte[zzpe];
                zzuw.zza(zzop, bArr, 0, zzpe);
                fileOutputStream.write(bArr);
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException unused) {
                    zzdi.zzac("error closing stream for writing resource to disk");
                    return true;
                }
            } catch (IOException unused2) {
                zzdi.zzac("Error writing resource to disk. Removing resource from disk.");
                zzje.delete();
                try {
                    fileOutputStream.close();
                } catch (IOException unused3) {
                    zzdi.zzac("error closing stream for writing resource to disk");
                }
                return false;
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                    zzdi.zzac("error closing stream for writing resource to disk");
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            zzdi.zzav("Error opening resource file for writing");
            return false;
        }
    }

    public final void zzhk() {
        this.zzajm.execute(new zzey(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r4.zzajf.zzs(com.google.android.gms.tagmanager.zzcz.zzahu);
        com.google.android.gms.tagmanager.zzdi.zzac("Failed to read the resource from disk. The resource is inconsistent");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r4.zzajf.zzs(com.google.android.gms.tagmanager.zzcz.zzahu);
        com.google.android.gms.tagmanager.zzdi.zzac("Failed to read the resource from disk");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a1, code lost:
        com.google.android.gms.tagmanager.zzdi.zzac("Error closing stream for reading resource from disk");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        throw r2;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:22:0x0077, B:26:0x0087] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0077 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0087 */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzjd() {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing stream for reading resource from disk"
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.gtm.zzop> r1 = r4.zzajf
            if (r1 == 0) goto L_0x00b2
            r1.zzhj()
            java.lang.String r1 = "Attempting to load resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzab(r1)
            com.google.android.gms.tagmanager.zzeh r1 = com.google.android.gms.tagmanager.zzeh.zziy()
            com.google.android.gms.tagmanager.zzeh$zza r1 = r1.zziz()
            com.google.android.gms.tagmanager.zzeh$zza r2 = com.google.android.gms.tagmanager.zzeh.zza.CONTAINER
            if (r1 == r2) goto L_0x0026
            com.google.android.gms.tagmanager.zzeh r1 = com.google.android.gms.tagmanager.zzeh.zziy()
            com.google.android.gms.tagmanager.zzeh$zza r1 = r1.zziz()
            com.google.android.gms.tagmanager.zzeh$zza r2 = com.google.android.gms.tagmanager.zzeh.zza.CONTAINER_DEBUG
            if (r1 != r2) goto L_0x003e
        L_0x0026:
            java.lang.String r1 = r4.zzaec
            com.google.android.gms.tagmanager.zzeh r2 = com.google.android.gms.tagmanager.zzeh.zziy()
            java.lang.String r2 = r2.getContainerId()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x003e
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.gtm.zzop> r0 = r4.zzajf
            int r1 = com.google.android.gms.tagmanager.zzcz.zzaht
            r0.zzs(r1)
            return
        L_0x003e:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00a5 }
            java.io.File r2 = r4.zzje()     // Catch:{ FileNotFoundException -> 0x00a5 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00a5 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            r2.<init>()     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            com.google.android.gms.internal.gtm.zzor.zza(r1, r2)     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            byte[] r2 = r2.toByteArray()     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            com.google.android.gms.internal.gtm.zzop r3 = new com.google.android.gms.internal.gtm.zzop     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            r3.<init>()     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            com.google.android.gms.internal.gtm.zzuw r2 = com.google.android.gms.internal.gtm.zzuw.zza(r3, r2)     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            com.google.android.gms.internal.gtm.zzop r2 = (com.google.android.gms.internal.gtm.zzop) r2     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            com.google.android.gms.internal.gtm.zzi r3 = r2.zzqk     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            if (r3 != 0) goto L_0x006f
            com.google.android.gms.internal.gtm.zzk r3 = r2.zzauy     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            if (r3 == 0) goto L_0x0067
            goto L_0x006f
        L_0x0067:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            java.lang.String r3 = "Resource and SupplementedResource are NULL."
            r2.<init>(r3)     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            throw r2     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
        L_0x006f:
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.gtm.zzop> r3 = r4.zzajf     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            r3.zze(r2)     // Catch:{ IOException -> 0x0087, IllegalArgumentException -> 0x0077 }
            goto L_0x0083
        L_0x0075:
            r2 = move-exception
            goto L_0x009d
        L_0x0077:
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.gtm.zzop> r2 = r4.zzajf     // Catch:{ all -> 0x0075 }
            int r3 = com.google.android.gms.tagmanager.zzcz.zzahu     // Catch:{ all -> 0x0075 }
            r2.zzs(r3)     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = "Failed to read the resource from disk. The resource is inconsistent"
            com.google.android.gms.tagmanager.zzdi.zzac(r2)     // Catch:{ all -> 0x0075 }
        L_0x0083:
            r1.close()     // Catch:{ IOException -> 0x0094 }
            goto L_0x0097
        L_0x0087:
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.gtm.zzop> r2 = r4.zzajf     // Catch:{ all -> 0x0075 }
            int r3 = com.google.android.gms.tagmanager.zzcz.zzahu     // Catch:{ all -> 0x0075 }
            r2.zzs(r3)     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = "Failed to read the resource from disk"
            com.google.android.gms.tagmanager.zzdi.zzac(r2)     // Catch:{ all -> 0x0075 }
            goto L_0x0083
        L_0x0094:
            com.google.android.gms.tagmanager.zzdi.zzac(r0)
        L_0x0097:
            java.lang.String r0 = "The Disk resource was successfully read."
            com.google.android.gms.tagmanager.zzdi.zzab(r0)
            return
        L_0x009d:
            r1.close()     // Catch:{ IOException -> 0x00a1 }
            goto L_0x00a4
        L_0x00a1:
            com.google.android.gms.tagmanager.zzdi.zzac(r0)
        L_0x00a4:
            throw r2
        L_0x00a5:
            java.lang.String r0 = "Failed to find the resource in the disk"
            com.google.android.gms.tagmanager.zzdi.zzax(r0)
            com.google.android.gms.tagmanager.zzdh<com.google.android.gms.internal.gtm.zzop> r0 = r4.zzajf
            int r1 = com.google.android.gms.tagmanager.zzcz.zzaht
            r0.zzs(r1)
            return
        L_0x00b2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Callback must be set before execute"
            r0.<init>(r1)
            goto L_0x00bb
        L_0x00ba:
            throw r0
        L_0x00bb:
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzex.zzjd():void");
    }

    public final zzov zzt(int i) {
        String str;
        try {
            InputStream openRawResource = this.zzrm.getResources().openRawResource(i);
            String resourceName = this.zzrm.getResources().getResourceName(i);
            StringBuilder sb = new StringBuilder(C0681a.m336b(resourceName, 66));
            sb.append("Attempting to load a container from the resource ID ");
            sb.append(i);
            sb.append(" (");
            sb.append(resourceName);
            sb.append(")");
            zzdi.zzab(sb.toString());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzor.zza(openRawResource, byteArrayOutputStream);
                zzov zza = zza(byteArrayOutputStream);
                if (zza == null) {
                    return zzb(byteArrayOutputStream.toByteArray());
                }
                zzdi.zzab("The container was successfully loaded from the resource (using JSON file format)");
                return zza;
            } catch (IOException unused) {
                String resourceName2 = this.zzrm.getResources().getResourceName(i);
                StringBuilder sb2 = new StringBuilder(C0681a.m336b(resourceName2, 67));
                sb2.append("Error reading the default container with resource ID ");
                sb2.append(i);
                sb2.append(" (");
                sb2.append(resourceName2);
                sb2.append(")");
                str = sb2.toString();
                zzdi.zzac(str);
                return null;
            }
        } catch (Resources.NotFoundException unused2) {
            str = C0681a.m309a(98, "Failed to load the container. No default container resource found with the resource ID ", i);
            zzdi.zzac(str);
            return null;
        }
    }
}
