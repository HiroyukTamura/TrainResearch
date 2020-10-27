package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzpo<E> extends AbstractList<E> implements zzrj<E> {
    private boolean zzavs = true;

    zzpo() {
    }

    public void add(int i, E e) {
        zzmz();
        super.add(i, e);
    }

    public boolean add(E e) {
        zzmz();
        return super.add(e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzmz();
        return super.addAll(i, collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzmz();
        return super.addAll(collection);
    }

    public void clear() {
        zzmz();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public E remove(int i) {
        zzmz();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzmz();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzmz();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzmz();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzmz();
        return super.set(i, e);
    }

    public final void zzmi() {
        this.zzavs = false;
    }

    public boolean zzmy() {
        return this.zzavs;
    }

    /* access modifiers changed from: protected */
    public final void zzmz() {
        if (!this.zzavs) {
            throw new UnsupportedOperationException();
        }
    }
}
