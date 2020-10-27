package com.google.android.gms.measurement.internal;

import androidx.exifinterface.media.ExifInterface;
import p009e.p010a.p011a.p012a.C0681a;

final class zzey implements Runnable {
    private final /* synthetic */ int zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ Object zzd;
    private final /* synthetic */ Object zze;
    private final /* synthetic */ zzez zzf;

    zzey(zzez zzez, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzez;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    public final void run() {
        char c;
        zzez zzez;
        zzfl zzc2 = this.zzf.zzy.zzc();
        if (zzc2.zzz()) {
            if (this.zzf.zza == 0) {
                if (this.zzf.zzt().zzg()) {
                    zzez = this.zzf;
                    zzez.zzu();
                    c = 'C';
                } else {
                    zzez = this.zzf;
                    zzez.zzu();
                    c = 'c';
                }
                char unused = zzez.zza = c;
            }
            if (this.zzf.zzb < 0) {
                zzez zzez2 = this.zzf;
                long unused2 = zzez2.zzb = zzez2.zzt().zzf();
            }
            char charAt = "01VDIWEA?".charAt(this.zza);
            char zza2 = this.zzf.zza;
            long zzb2 = this.zzf.zzb;
            String zza3 = zzez.zza(true, this.zzb, this.zzc, this.zzd, this.zze);
            StringBuilder sb = new StringBuilder(C0681a.m336b(zza3, 24));
            sb.append(ExifInterface.GPS_MEASUREMENT_2D);
            sb.append(charAt);
            sb.append(zza2);
            sb.append(zzb2);
            sb.append(":");
            sb.append(zza3);
            String sb2 = sb.toString();
            if (sb2.length() > 1024) {
                sb2 = this.zzb.substring(0, 1024);
            }
            zzc2.zzb.zza(sb2, 1);
            return;
        }
        this.zzf.zza(6, "Persisted config not initialized. Not logging error/warn");
    }
}
