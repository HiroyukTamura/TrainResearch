package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzir extends zzgn<String> implements zziu, RandomAccess {
    private static final zzir zza;
    private static final zziu zzb = zza;
    private final List<Object> zzc;

    static {
        zzir zzir = new zzir();
        zza = zzir;
        zzir.zzb();
    }

    public zzir() {
        this(10);
    }

    public zzir(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzir(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    private static String zza(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzgt ? ((zzgt) obj).zzb() : zzie.zzb((byte[]) obj);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzc();
        if (collection instanceof zziu) {
            collection = ((zziu) collection).zzd();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzc();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgt) {
            zzgt zzgt = (zzgt) obj;
            String zzb2 = zzgt.zzb();
            if (zzgt.zzc()) {
                this.zzc.set(i, zzb2);
            }
            return zzb2;
        }
        byte[] bArr = (byte[]) obj;
        String zzb3 = zzie.zzb(bArr);
        if (zzie.zza(bArr)) {
            this.zzc.set(i, zzb3);
        }
        return zzb3;
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ Object remove(int i) {
        zzc();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zza(remove);
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
        zzc();
        return zza(this.zzc.set(i, (String) obj));
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* synthetic */ zzik zza(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzir((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final void zza(zzgt zzgt) {
        zzc();
        this.zzc.add(zzgt);
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean zza() {
        return super.zza();
    }

    public final Object zzb(int i) {
        return this.zzc.get(i);
    }

    public final List<?> zzd() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final zziu zze() {
        return zza() ? new zzkv(this) : this;
    }
}
