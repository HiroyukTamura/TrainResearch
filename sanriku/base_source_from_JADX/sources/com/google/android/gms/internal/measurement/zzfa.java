package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public final class zzfa<K, V> extends zzez<K, V> {
    public final zzfb<K, V> zza() {
        Set<Map.Entry<K, Collection<V>>> entrySet = this.zza.entrySet();
        if (entrySet.isEmpty()) {
            return zzep.zza;
        }
        zzex zzex = new zzex(entrySet.size());
        int i = 0;
        for (Map.Entry next : entrySet) {
            Object key = next.getKey();
            zzey zza = zzey.zza((Collection) next.getValue());
            if (!zza.isEmpty()) {
                int i2 = (zzex.zzb + 1) << 1;
                Object[] objArr = zzex.zza;
                if (i2 > objArr.length) {
                    int length = objArr.length;
                    if (i2 >= 0) {
                        int i3 = length + (length >> 1) + 1;
                        if (i3 < i2) {
                            i3 = Integer.highestOneBit(i2 - 1) << 1;
                        }
                        if (i3 < 0) {
                            i3 = Integer.MAX_VALUE;
                        }
                        zzex.zza = Arrays.copyOf(objArr, i3);
                        zzex.zzc = false;
                    } else {
                        throw new AssertionError("cannot store more than MAX_VALUE elements");
                    }
                }
                zzec.zza(key, zza);
                Object[] objArr2 = zzex.zza;
                int i4 = zzex.zzb;
                objArr2[i4 * 2] = key;
                objArr2[(i4 * 2) + 1] = zza;
                zzex.zzb = i4 + 1;
                i += zza.size();
            }
        }
        zzex.zzc = true;
        return new zzfb<>(zzfm.zza(zzex.zzb, zzex.zza), i, (Comparator) null);
    }
}
