package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzna;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzq {
    private String zza;
    private boolean zzb;
    private zzcc.zzi zzc;
    /* access modifiers changed from: private */
    public BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzo zzh;

    private zzq(zzo zzo, String str) {
        this.zzh = zzo;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzq(zzo zzo, String str, zzcc.zzi zzi, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzo;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer next : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(next));
                this.zzg.put(next, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zzi;
    }

    /* synthetic */ zzq(zzo zzo, String str, zzcc.zzi zzi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzr zzr) {
        this(zzo, str, zzi, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzq(zzo zzo, String str, zzr zzr) {
        this(zzo, str);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final zzcc.zza zza(int i) {
        ArrayList arrayList;
        List list;
        zzcc.zza.C2677zza zzh2 = zzcc.zza.zzh();
        zzh2.zza(i);
        zzh2.zza(this.zzb);
        zzcc.zzi zzi = this.zzc;
        if (zzi != null) {
            zzh2.zza(zzi);
        }
        zzcc.zzi.zza zza2 = zzcc.zzi.zzi().zzb((Iterable<? extends Long>) zzks.zza(this.zzd)).zza((Iterable<? extends Long>) zzks.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            for (Integer intValue : this.zzf.keySet()) {
                int intValue2 = intValue.intValue();
                arrayList.add((zzcc.zzb) ((zzib) zzcc.zzb.zze().zza(intValue2).zza(this.zzf.get(Integer.valueOf(intValue2)).longValue()).zzv()));
            }
        }
        zza2.zzc(arrayList);
        if (this.zzg == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(this.zzg.size());
            for (Integer next : this.zzg.keySet()) {
                zzcc.zzj.zza zza3 = zzcc.zzj.zze().zza(next.intValue());
                List list2 = this.zzg.get(next);
                if (list2 != null) {
                    Collections.sort(list2);
                    zza3.zza((Iterable<? extends Long>) list2);
                }
                arrayList2.add((zzcc.zzj) ((zzib) zza3.zzv()));
            }
            list = arrayList2;
        }
        zza2.zzd(list);
        zzh2.zza(zza2);
        return (zzcc.zza) ((zzib) zzh2.zzv());
    }

    /* access modifiers changed from: package-private */
    public final void zza(@NonNull zzv zzv) {
        int zza2 = zzv.zza();
        Boolean bool = zzv.zzc;
        if (bool != null) {
            this.zze.set(zza2, bool.booleanValue());
        }
        Boolean bool2 = zzv.zzd;
        if (bool2 != null) {
            this.zzd.set(zza2, bool2.booleanValue());
        }
        if (zzv.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(zza2));
            long longValue = zzv.zze.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(zza2), Long.valueOf(longValue));
            }
        }
        if (zzv.zzf != null) {
            List list = this.zzg.get(Integer.valueOf(zza2));
            if (list == null) {
                list = new ArrayList();
                this.zzg.put(Integer.valueOf(zza2), list);
            }
            if (zzv.zzb()) {
                list.clear();
            }
            if (zzna.zzb() && this.zzh.zzt().zzd(this.zza, zzaq.zzbf) && zzv.zzc()) {
                list.clear();
            }
            if (!zzna.zzb() || !this.zzh.zzt().zzd(this.zza, zzaq.zzbf)) {
                list.add(Long.valueOf(zzv.zzf.longValue() / 1000));
                return;
            }
            long longValue2 = zzv.zzf.longValue() / 1000;
            if (!list.contains(Long.valueOf(longValue2))) {
                list.add(Long.valueOf(longValue2));
            }
        }
    }
}
