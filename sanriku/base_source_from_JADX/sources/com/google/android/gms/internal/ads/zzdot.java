package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdot<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzhfe = new Object[0];

    zzdot() {
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
        return toArray(zzhfe);
    }

    public final <T> T[] toArray(T[] tArr) {
        zzdoj.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzavt = zzavt();
            if (zzavt != null) {
                return Arrays.copyOfRange(zzavt, zzavu(), zzavv(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzdpp zzdpp = (zzdpp) iterator();
        while (zzdpp.hasNext()) {
            objArr[i] = zzdpp.next();
            i++;
        }
        return i;
    }

    /* renamed from: zzavs */
    public abstract zzdpp<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzavt() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int zzavu() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzavv() {
        throw new UnsupportedOperationException();
    }

    public zzdou<E> zzavw() {
        return isEmpty() ? zzdou.zzavy() : zzdou.zzc(toArray());
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzavx();
}
