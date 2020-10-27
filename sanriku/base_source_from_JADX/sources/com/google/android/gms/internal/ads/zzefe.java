package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzefe extends zzefc<zzefb, zzefb> {
    zzefe() {
    }

    private static void zza(Object obj, zzefb zzefb) {
        ((zzecd) obj).zzhxv = zzefb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzefb) obj).zzd(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzeaq zzeaq) {
        ((zzefb) obj).zzd((i << 3) | 2, zzeaq);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzefb) obj).zzd((i << 3) | 3, (zzefb) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzefv zzefv) throws IOException {
        ((zzefb) obj).zzb(zzefv);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzeee zzeee) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zzak(Object obj) {
        ((zzecd) obj).zzhxv.zzbcj();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzaq(Object obj) {
        zzefb zzefb = (zzefb) obj;
        zzefb.zzbcj();
        return zzefb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzau(Object obj) {
        return ((zzefb) obj).zzbex();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzay(Object obj) {
        return ((zzecd) obj).zzhxv;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzaz(Object obj) {
        zzefb zzefb = ((zzecd) obj).zzhxv;
        if (zzefb != zzefb.zzbhd()) {
            return zzefb;
        }
        zzefb zzbhe = zzefb.zzbhe();
        zza(obj, zzbhe);
        return zzbhe;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzefb) obj).zzd((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzba(Object obj) {
        return ((zzefb) obj).zzbhf();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzbhg() {
        return zzefb.zzbhe();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzefb) obj).zzd((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, zzefv zzefv) throws IOException {
        ((zzefb) obj).zza(zzefv);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        zza(obj, (zzefb) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Object obj, Object obj2) {
        zza(obj, (zzefb) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzj(Object obj, Object obj2) {
        zzefb zzefb = (zzefb) obj;
        zzefb zzefb2 = (zzefb) obj2;
        return zzefb2.equals(zzefb.zzbhd()) ? zzefb : zzefb.zza(zzefb, zzefb2);
    }
}
