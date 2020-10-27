package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzer<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zza = new Object[0];

    zzer() {
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(@NullableDecl Object obj);

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(zza);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzdq.zza(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zze = zze();
            if (zze != null) {
                return Arrays.copyOfRange(zze, zzf(), zzg(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zzb(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zzb(Object[] objArr, int i) {
        zzfz zzfz = (zzfz) iterator();
        while (zzfz.hasNext()) {
            objArr[i] = zzfz.next();
            i++;
        }
        return i;
    }

    /* renamed from: zzb */
    public abstract zzfz<E> iterator();

    public zzeq<E> zzc() {
        return isEmpty() ? zzeq.zza() : zzeq.zza(toArray());
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zze() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int zzf() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzg() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzh();
}
