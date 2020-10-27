package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzey<E> extends zzer<E> implements Set<E> {
    @NullableDecl
    private transient zzeq<E> zza;

    zzey() {
    }

    static int zza(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (true) {
                double d = (double) highestOneBit;
                Double.isNaN(d);
                if (d * 0.7d >= ((double) max)) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            if (max >= 1073741824) {
                z = false;
            }
            zzdq.zza(z, (Object) "collection too large");
            return 1073741824;
        }
    }

    public static <E> zzey<E> zza(Collection<? extends E> collection) {
        if ((collection instanceof zzey) && !(collection instanceof SortedSet)) {
            zzey<E> zzey = (zzey) collection;
            if (!zzey.zzh()) {
                return zzey;
            }
        }
        Object[] array = collection.toArray();
        int length = array.length;
        while (length != 0) {
            if (length == 1) {
                return new zzfu(array[0]);
            }
            int zza2 = zza(length);
            Object[] objArr = new Object[zza2];
            int i = zza2 - 1;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                Object zza3 = zzfl.zza(array[i4], i4);
                int hashCode = zza3.hashCode();
                int zza4 = zzeo.zza(hashCode);
                while (true) {
                    int i5 = zza4 & i;
                    Object obj = objArr[i5];
                    if (obj != null) {
                        if (obj.equals(zza3)) {
                            break;
                        }
                        zza4++;
                    } else {
                        array[i3] = zza3;
                        objArr[i5] = zza3;
                        i2 += hashCode;
                        i3++;
                        break;
                    }
                }
            }
            Arrays.fill(array, i3, length, (Object) null);
            if (i3 == 1) {
                return new zzfu(array[0], i2);
            }
            if (zza(i3) < zza2 / 2) {
                length = i3;
            } else {
                int length2 = array.length;
                if (i3 < (length2 >> 1) + (length2 >> 2)) {
                    array = Arrays.copyOf(array, i3);
                }
                return new zzft(array, i2, objArr, i, i3);
            }
        }
        return zzft.zza;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzey) || !zza() || !((zzey) obj).zza() || hashCode() == obj.hashCode()) {
            return zzfv.zza(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return zzfv.zza(this);
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* access modifiers changed from: package-private */
    public boolean zza() {
        return false;
    }

    public zzeq<E> zzc() {
        zzeq<E> zzeq = this.zza;
        if (zzeq != null) {
            return zzeq;
        }
        zzeq<E> zzd = zzd();
        this.zza = zzd;
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public zzeq<E> zzd() {
        return zzeq.zza(toArray());
    }
}
