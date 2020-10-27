package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbu;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzmo;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzfx extends zzkl implements zzaa {
    @VisibleForTesting
    private static int zzb = 65535;
    @VisibleForTesting
    private static int zzc = 2;
    private final Map<String, Map<String, String>> zzd = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zze = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzf = new ArrayMap();
    private final Map<String, zzca.zzb> zzg = new ArrayMap();
    private final Map<String, Map<String, Integer>> zzh = new ArrayMap();
    private final Map<String, String> zzi = new ArrayMap();

    zzfx(zzkk zzkk) {
        super(zzkk);
    }

    @WorkerThread
    private final zzca.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzca.zzb.zzj();
        }
        try {
            zzca.zzb zzb2 = (zzca.zzb) ((zzib) ((zzca.zzb.zza) zzks.zza(zzca.zzb.zzi(), bArr)).zzv());
            zzfb zzx = zzr().zzx();
            String str2 = null;
            Long valueOf = zzb2.zza() ? Long.valueOf(zzb2.zzb()) : null;
            if (zzb2.zzc()) {
                str2 = zzb2.zzd();
            }
            zzx.zza("Parsed config. version, gmp_app_id", valueOf, str2);
            return zzb2;
        } catch (zzij | RuntimeException e) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzez.zza(str), e);
            return zzca.zzb.zzj();
        }
    }

    private static Map<String, String> zza(zzca.zzb zzb2) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzb2 != null) {
            for (zzca.zzc next : zzb2.zze()) {
                arrayMap.put(next.zza(), next.zzb());
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzca.zzb.zza zza) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zza != null) {
            for (int i = 0; i < zza.zza(); i++) {
                zzca.zza.C2676zza zza2 = (zzca.zza.C2676zza) zza.zza(i).zzbl();
                if (TextUtils.isEmpty(zza2.zza())) {
                    zzr().zzi().zza("EventConfig contained null event name");
                } else {
                    String zzb2 = zzhb.zzb(zza2.zza());
                    if (!TextUtils.isEmpty(zzb2)) {
                        zza2 = zza2.zza(zzb2);
                        zza.zza(i, zza2);
                    }
                    arrayMap.put(zza2.zza(), Boolean.valueOf(zza2.zzb()));
                    arrayMap2.put(zza2.zza(), Boolean.valueOf(zza2.zzc()));
                    if (zza2.zzd()) {
                        if (zza2.zze() < zzc || zza2.zze() > zzb) {
                            zzr().zzi().zza("Invalid sampling rate. Event name, sample rate", zza2.zza(), Integer.valueOf(zza2.zze()));
                        } else {
                            arrayMap3.put(zza2.zza(), Integer.valueOf(zza2.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, arrayMap);
        this.zzf.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    @WorkerThread
    private final void zzi(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] zzd2 = zzi().zzd(str);
            if (zzd2 == null) {
                this.zzd.put(str, (Object) null);
                this.zze.put(str, (Object) null);
                this.zzf.put(str, (Object) null);
                this.zzg.put(str, (Object) null);
                this.zzi.put(str, (Object) null);
                this.zzh.put(str, (Object) null);
                return;
            }
            zzca.zzb.zza zza = (zzca.zzb.zza) zza(str, zzd2).zzbl();
            zza(str, zza);
            this.zzd.put(str, zza((zzca.zzb) ((zzib) zza.zzv())));
            this.zzg.put(str, (zzca.zzb) ((zzib) zza.zzv()));
            this.zzi.put(str, (Object) null);
        }
    }

    /* renamed from: e_ */
    public final /* bridge */ /* synthetic */ zzo mo24432e_() {
        return super.mo24432e_();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final zzca.zzb zza(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return this.zzg.get(str);
    }

    @WorkerThread
    public final String zza(String str, String str2) {
        zzd();
        zzi(str);
        Map map = this.zzd.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zza(String str, byte[] bArr, String str2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzca.zzb.zza zza = (zzca.zzb.zza) zza(str, bArr).zzbl();
        if (zza == null) {
            return false;
        }
        zza(str, zza);
        this.zzg.put(str, (zzca.zzb) ((zzib) zza.zzv()));
        this.zzi.put(str, str2);
        this.zzd.put(str, zza((zzca.zzb) ((zzib) zza.zzv())));
        zzi().zza(str, (List<zzbu.zza>) new ArrayList(zza.zzb()));
        try {
            zza.zzc();
            bArr = ((zzca.zzb) ((zzib) zza.zzv())).zzbi();
        } catch (RuntimeException e) {
            zzr().zzi().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzez.zza(str), e);
        }
        zzad zzi2 = zzi();
        Preconditions.checkNotEmpty(str);
        zzi2.zzd();
        zzi2.zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzi2.mo24209c_().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzi2.zzr().zzf().zza("Failed to update remote config (got 0). appId", zzez.zza(str));
            }
        } catch (SQLiteException e2) {
            zzi2.zzr().zzf().zza("Error storing remote config. appId", zzez.zza(str), e2);
        }
        this.zzg.put(str, (zzca.zzb) ((zzib) zza.zzv()));
        return true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzb(String str) {
        zzd();
        return this.zzi.get(str);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzb(String str, String str2) {
        Boolean bool;
        zzd();
        zzi(str);
        if (zzg(str) && zzkw.zze(str2)) {
            return true;
        }
        if (zzh(str) && zzkw.zza(str2)) {
            return true;
        }
        Map map = this.zze.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzc(String str) {
        zzd();
        this.zzi.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzc(String str, String str2) {
        Boolean bool;
        zzd();
        zzi(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        if (zzmo.zzb() && zzt().zza(zzaq.zzci) && ("purchase".equals(str2) || "refund".equals(str2))) {
            return true;
        }
        Map map = this.zzf.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final int zzd(String str, String str2) {
        Integer num;
        zzd();
        zzi(str);
        Map map = this.zzh.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzd(String str) {
        zzd();
        this.zzg.remove(str);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zze(String str) {
        zzd();
        zzca.zzb zza = zza(str);
        if (zza == null) {
            return false;
        }
        return zza.zzh();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final long zzf(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e) {
            zzr().zzi().zza("Unable to parse timezone offset. appId", zzez.zza(str), e);
            return 0;
        }
    }

    public final /* bridge */ /* synthetic */ zzks zzg() {
        return super.zzg();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    public final /* bridge */ /* synthetic */ zzad zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfx zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }
}
