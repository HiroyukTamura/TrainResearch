package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

class zzdos<E> extends zzdov<E> {
    int size = 0;
    Object[] zzhfc;
    boolean zzhfd;

    zzdos(int i) {
        zzdoo.zzj(i, "initialCapacity");
        this.zzhfc = new Object[i];
    }

    private final void zzeg(int i) {
        Object[] objArr = this.zzhfc;
        if (objArr.length < i) {
            int length = objArr.length;
            if (i >= 0) {
                int i2 = length + (length >> 1) + 1;
                if (i2 < i) {
                    i2 = Integer.highestOneBit(i - 1) << 1;
                }
                if (i2 < 0) {
                    i2 = Integer.MAX_VALUE;
                }
                this.zzhfc = Arrays.copyOf(objArr, i2);
                this.zzhfd = false;
                return;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        } else if (this.zzhfd) {
            this.zzhfc = (Object[]) objArr.clone();
            this.zzhfd = false;
        }
    }

    /* renamed from: zzab */
    public zzdos<E> zzac(E e) {
        zzdoj.checkNotNull(e);
        zzeg(this.size + 1);
        Object[] objArr = this.zzhfc;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = e;
        return this;
    }

    public zzdov<E> zzg(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzeg(collection.size() + this.size);
            if (collection instanceof zzdot) {
                this.size = ((zzdot) collection).zza(this.zzhfc, this.size);
                return this;
            }
        }
        super.zzg(iterable);
        return this;
    }
}
