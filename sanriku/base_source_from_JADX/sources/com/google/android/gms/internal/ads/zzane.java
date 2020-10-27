package com.google.android.gms.internal.ads;

import com.google.ads.mediation.C0553a;
import java.util.Date;
import java.util.HashSet;
import p009e.p028d.p029a.C0871a;
import p009e.p028d.p029a.C0872b;

public final class zzane {
    public static int zza(C0871a aVar) {
        int i = zzanh.zzdhm[aVar.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }

    public static C0553a zza(zzuj zzuj, boolean z) {
        HashSet hashSet = zzuj.zzcei != null ? new HashSet(zzuj.zzcei) : null;
        Date date = new Date(zzuj.zzceg);
        int i = zzuj.zzceh;
        return new C0553a(date, i != 1 ? i != 2 ? C0872b.UNKNOWN : C0872b.FEMALE : C0872b.MALE, hashSet, z, zzuj.zzmp);
    }
}
