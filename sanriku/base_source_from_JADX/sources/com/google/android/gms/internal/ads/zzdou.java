package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdou<E> extends zzdot<E> implements List<E>, RandomAccess {
    private static final zzdpo<Object> zzhff = new zzdow(zzdpe.zzhfq, 0);

    zzdou() {
    }

    public static <E> zzdou<E> zzad(E e) {
        Object[] objArr = {e};
        for (int i = 0; i <= 0; i++) {
            zzdpf.zzd(objArr[0], 0);
        }
        return zzb(objArr, 1);
    }

    public static <E> zzdou<E> zzavy() {
        return zzdpe.zzhfq;
    }

    public static <E> zzdou<E> zzb(E[] eArr) {
        if (eArr.length == 0) {
            return zzdpe.zzhfq;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            zzdpf.zzd(objArr[i], i);
        }
        return zzb(objArr, objArr.length);
    }

    static <E> zzdou<E> zzb(Object[] objArr, int i) {
        return i == 0 ? zzdpe.zzhfq : new zzdpe(objArr, i);
    }

    static <E> zzdou<E> zzc(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    public static <E> zzdou<E> zzh(Iterable<? extends E> iterable) {
        zzdoj.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection instanceof zzdot) {
                zzdou<E> zzavw = ((zzdot) collection).zzavw();
                if (!zzavw.zzavx()) {
                    return zzavw;
                }
                Object[] array = zzavw.toArray();
                return zzb(array, array.length);
            }
            Object[] array2 = collection.toArray();
            int length = array2.length;
            for (int i = 0; i < length; i++) {
                zzdpf.zzd(array2[i], i);
            }
            return zzb(array2, array2.length);
        }
        Iterator<? extends E> it = iterable.iterator();
        if (!it.hasNext()) {
            return zzdpe.zzhfq;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return zzad(next);
        }
        zzdox zzdox = (zzdox) ((zzdox) new zzdox().zzac(next)).zza(it);
        zzdox.zzhfd = true;
        return zzb(zzdox.zzhfc, zzdox.size);
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdoj.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i = 0;
                    while (i < size) {
                        if (zzdoe.equal(get(i), list.get(i))) {
                            i++;
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object obj2 = get(i2);
                        i2++;
                        if (!zzdoe.equal(obj2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ((get(i2).hashCode() + (i * 31)) ^ -1) ^ -1;
        }
        return i;
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzdpo) listIterator(0);
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzdoj.zzt(i, size());
        return isEmpty() ? zzhff : new zzdow(this, i);
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    /* renamed from: zzavs */
    public final zzdpp<E> iterator() {
        return (zzdpo) listIterator();
    }

    public final zzdou<E> zzavw() {
        return this;
    }

    /* renamed from: zzu */
    public zzdou<E> subList(int i, int i2) {
        zzdoj.zzf(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? zzdpe.zzhfq : new zzdoz(this, i, i3);
    }
}
