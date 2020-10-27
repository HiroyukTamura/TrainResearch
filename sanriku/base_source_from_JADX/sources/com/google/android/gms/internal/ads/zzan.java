package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

@VisibleForTesting
final class zzan {
    long zzcb;
    final String zzcc;
    final String zzg;
    final long zzh;
    final long zzi;
    final long zzj;
    final long zzk;
    final List<zzk> zzm;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzan(java.lang.String r14, com.google.android.gms.internal.ads.zzd r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.zzg
            long r3 = r15.zzh
            long r5 = r15.zzi
            long r7 = r15.zzj
            long r9 = r15.zzk
            java.util.List<com.google.android.gms.internal.ads.zzk> r0 = r15.zzm
            if (r0 == 0) goto L_0x0010
        L_0x000e:
            r11 = r0
            goto L_0x0044
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.String> r15 = r15.zzl
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x0023:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L_0x000e
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.google.android.gms.internal.ads.zzk r11 = new com.google.android.gms.internal.ads.zzk
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L_0x0023
        L_0x0044:
            r0 = r13
            r1 = r14
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzan.<init>(java.lang.String, com.google.android.gms.internal.ads.zzd):void");
    }

    private zzan(String str, String str2, long j, long j2, long j3, long j4, List<zzk> list) {
        this.zzcc = str;
        this.zzg = "".equals(str2) ? null : str2;
        this.zzh = j;
        this.zzi = j2;
        this.zzj = j3;
        this.zzk = j4;
        this.zzm = list;
    }

    static zzan zzc(zzaq zzaq) throws IOException {
        if (zzal.zzb((InputStream) zzaq) == 538247942) {
            return new zzan(zzal.zza(zzaq), zzal.zza(zzaq), zzal.zzc(zzaq), zzal.zzc(zzaq), zzal.zzc(zzaq), zzal.zzc(zzaq), zzal.zzb(zzaq));
        }
        throw new IOException();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(OutputStream outputStream) {
        try {
            zzal.zza(outputStream, 538247942);
            zzal.zza(outputStream, this.zzcc);
            zzal.zza(outputStream, this.zzg == null ? "" : this.zzg);
            zzal.zza(outputStream, this.zzh);
            zzal.zza(outputStream, this.zzi);
            zzal.zza(outputStream, this.zzj);
            zzal.zza(outputStream, this.zzk);
            List<zzk> list = this.zzm;
            if (list != null) {
                zzal.zza(outputStream, list.size());
                for (zzk next : list) {
                    zzal.zza(outputStream, next.getName());
                    zzal.zza(outputStream, next.getValue());
                }
            } else {
                zzal.zza(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzag.m294d("%s", e.toString());
            return false;
        }
    }
}
