package com.google.android.gms.internal.fitness;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzgw extends zzfa<String> implements zzgv, RandomAccess {
    private static final zzgw zzww;
    private static final zzgv zzwx = zzww;
    private final List<Object> zzwy;

    static {
        zzgw zzgw = new zzgw();
        zzww = zzgw;
        zzgw.zzal();
    }

    public zzgw() {
        this(10);
    }

    public zzgw(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzgw(ArrayList<Object> arrayList) {
        this.zzwy = arrayList;
    }

    private static String zze(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzff ? ((zzff) obj).zzap() : zzgk.zzd((byte[]) obj);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzam();
        this.zzwy.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzam();
        if (collection instanceof zzgv) {
            collection = ((zzgv) collection).zzbx();
        }
        boolean addAll = this.zzwy.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzam();
        this.zzwy.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzwy.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzff) {
            zzff zzff = (zzff) obj;
            String zzap = zzff.zzap();
            if (zzff.zzaq()) {
                this.zzwy.set(i, zzap);
            }
            return zzap;
        }
        byte[] bArr = (byte[]) obj;
        String zzd = zzgk.zzd(bArr);
        if (zzgk.zzc(bArr)) {
            this.zzwy.set(i, zzd);
        }
        return zzd;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ Object remove(int i) {
        zzam();
        Object remove = this.zzwy.remove(i);
        this.modCount++;
        return zze(remove);
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
        zzam();
        return zze(this.zzwy.set(i, (String) obj));
    }

    public final int size() {
        return this.zzwy.size();
    }

    public final /* synthetic */ zzgl zzac(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzwy);
            return new zzgw((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final Object zzad(int i) {
        return this.zzwy.get(i);
    }

    public final /* bridge */ /* synthetic */ boolean zzak() {
        return super.zzak();
    }

    public final List<?> zzbx() {
        return Collections.unmodifiableList(this.zzwy);
    }

    public final zzgv zzby() {
        return zzak() ? new zziv(this) : this;
    }
}
