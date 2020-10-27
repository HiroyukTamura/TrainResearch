package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzecw extends zzeak<String> implements zzecv, RandomAccess {
    private static final zzecw zzhzl;
    private static final zzecv zzhzm = zzhzl;
    private final List<Object> zzhzn;

    static {
        zzecw zzecw = new zzecw();
        zzhzl = zzecw;
        zzecw.zzbcj();
    }

    public zzecw() {
        this(10);
    }

    public zzecw(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzecw(ArrayList<Object> arrayList) {
        this.zzhzn = arrayList;
    }

    private static String zzam(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzeaq ? ((zzeaq) obj).zzbco() : zzecg.zzz((byte[]) obj);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzbck();
        this.zzhzn.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbck();
        if (collection instanceof zzecv) {
            collection = ((zzecv) collection).zzbfs();
        }
        boolean addAll = this.zzhzn.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzbck();
        this.zzhzn.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzhzn.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeaq) {
            zzeaq zzeaq = (zzeaq) obj;
            String zzbco = zzeaq.zzbco();
            if (zzeaq.zzbcp()) {
                this.zzhzn.set(i, zzbco);
            }
            return zzbco;
        }
        byte[] bArr = (byte[]) obj;
        String zzz = zzecg.zzz(bArr);
        if (zzecg.zzy(bArr)) {
            this.zzhzn.set(i, zzz);
        }
        return zzz;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ Object remove(int i) {
        zzbck();
        Object remove = this.zzhzn.remove(i);
        this.modCount++;
        return zzam(remove);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzbck();
        return zzam(this.zzhzn.set(i, (String) obj));
    }

    public final int size() {
        return this.zzhzn.size();
    }

    public final void zzaj(zzeaq zzeaq) {
        zzbck();
        this.zzhzn.add(zzeaq);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean zzbci() {
        return super.zzbci();
    }

    public final List<?> zzbfs() {
        return Collections.unmodifiableList(this.zzhzn);
    }

    public final zzecv zzbft() {
        return zzbci() ? new zzefd(this) : this;
    }

    public final /* synthetic */ zzecl zzfn(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzhzn);
            return new zzecw((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final Object zzgy(int i) {
        return this.zzhzn.get(i);
    }
}
