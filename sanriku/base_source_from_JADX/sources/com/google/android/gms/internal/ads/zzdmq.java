package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.regex.Pattern;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzdmq {
    private final Context zzvf;
    private final zzdlk zzvj;

    public zzdmq(@NonNull Context context, zzdlk zzdlk) {
        this.zzvf = context;
        this.zzvj = zzdlk;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        if (r4 == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0045, code lost:
        r4.zza(2024, 0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r4 == null) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzauu() {
        /*
            r5 = this;
            java.util.HashSet r0 = new java.util.HashSet
            java.lang.String r1 = "i686"
            java.lang.String r2 = "armv71"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            com.google.android.gms.internal.ads.zzdol r1 = com.google.android.gms.internal.ads.zzdol.OS_ARCH
            java.lang.String r1 = r1.value()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0024
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0024
            return r1
        L_0x0024:
            r0 = 0
            r2 = 2024(0x7e8, float:2.836E-42)
            java.lang.Class<android.os.Build> r3 = android.os.Build.class
            java.lang.String r4 = "SUPPORTED_ABIS"
            java.lang.reflect.Field r3 = r3.getField(r4)     // Catch:{ NoSuchFieldException -> 0x0049, IllegalAccessException -> 0x0040 }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ NoSuchFieldException -> 0x0049, IllegalAccessException -> 0x0040 }
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ NoSuchFieldException -> 0x0049, IllegalAccessException -> 0x0040 }
            if (r3 == 0) goto L_0x004f
            int r4 = r3.length     // Catch:{ NoSuchFieldException -> 0x0049, IllegalAccessException -> 0x0040 }
            if (r4 <= 0) goto L_0x004f
            r4 = 0
            r0 = r3[r4]     // Catch:{ NoSuchFieldException -> 0x0049, IllegalAccessException -> 0x0040 }
            return r0
        L_0x0040:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzdlk r4 = r5.zzvj
            if (r4 == 0) goto L_0x004f
        L_0x0045:
            r4.zza((int) r2, (long) r0, (java.lang.Exception) r3)
            goto L_0x004f
        L_0x0049:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzdlk r4 = r5.zzvj
            if (r4 == 0) goto L_0x004f
            goto L_0x0045
        L_0x004f:
            java.lang.String r0 = android.os.Build.CPU_ABI
            if (r0 == 0) goto L_0x0054
            return r0
        L_0x0054:
            java.lang.String r0 = android.os.Build.CPU_ABI2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdmq.zzauu():java.lang.String");
    }

    private final zzgb zzauv() {
        FileInputStream fileInputStream;
        File file = new File(new File(this.zzvf.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            return zzgb.UNSUPPORTED;
        }
        File[] listFiles = file.listFiles(new zzdpt(Pattern.compile(".*\\.so$", 2)));
        if (listFiles == null || listFiles.length == 0) {
            return zzgb.UNSUPPORTED;
        }
        try {
            fileInputStream = new FileInputStream(listFiles[0]);
            byte[] bArr = new byte[20];
            if (fileInputStream.read(bArr) == 20) {
                byte[] bArr2 = {0, 0};
                if (bArr[5] == 2) {
                    zzj(bArr);
                    zzgb zzgb = zzgb.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgb;
                }
                bArr2[0] = bArr[19];
                bArr2[1] = bArr[18];
                short s = ByteBuffer.wrap(bArr2).getShort();
                if (s == 3) {
                    zzgb zzgb2 = zzgb.X86;
                    fileInputStream.close();
                    return zzgb2;
                } else if (s == 40) {
                    zzgb zzgb3 = zzgb.ARM7;
                    fileInputStream.close();
                    return zzgb3;
                } else if (s == 62) {
                    zzgb zzgb4 = zzgb.X86_64;
                    fileInputStream.close();
                    return zzgb4;
                } else if (s != 183) {
                    zzgb zzgb5 = zzgb.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgb5;
                } else {
                    zzgb zzgb6 = zzgb.ARM64;
                    fileInputStream.close();
                    return zzgb6;
                }
            } else {
                fileInputStream.close();
                return zzgb.UNSUPPORTED;
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            zzdzz.zza(th, th);
        }
        throw th;
    }

    private final void zzj(byte[] bArr) {
        if (this.zzvj != null) {
            StringBuilder a = C0681a.m330a("os.arch:");
            a.append(zzdol.OS_ARCH.value());
            a.append(";");
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
                if (strArr != null) {
                    a.append("supported_abis:");
                    a.append(Arrays.toString(strArr));
                    a.append(";");
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
            a.append("CPU_ABI:");
            a.append(Build.CPU_ABI);
            a.append(";");
            a.append("CPU_ABI2:");
            a.append(Build.CPU_ABI2);
            a.append(";");
            if (bArr != null) {
                a.append("ELF:");
                a.append(Arrays.toString(bArr));
                a.append(";");
            }
            this.zzvj.zzi(4007, a.toString());
        }
    }

    public final zzgb zzauw() {
        zzgb zzauv = zzauv();
        if (zzauv != zzgb.UNSUPPORTED) {
            return zzauv;
        }
        String zzauu = zzauu();
        if (!TextUtils.isEmpty(zzauu)) {
            if (zzauu.equalsIgnoreCase("i686") || zzauu.equalsIgnoreCase("x86")) {
                return zzgb.X86;
            }
            if (zzauu.equalsIgnoreCase("x86_64")) {
                return zzgb.X86_64;
            }
            if (zzauu.equalsIgnoreCase("arm64-v8a")) {
                return zzgb.ARM64;
            }
            if (zzauu.equalsIgnoreCase("armeabi-v7a") || zzauu.equalsIgnoreCase("armv71")) {
                return zzgb.ARM7;
            }
        }
        zzj((byte[]) null);
        return zzgb.UNSUPPORTED;
    }
}
