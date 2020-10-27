package com.google.android.gms.internal.ads;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzeel<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzhuu;
    private final int zzibr;
    /* access modifiers changed from: private */
    public List<zzeeu> zzibs;
    /* access modifiers changed from: private */
    public Map<K, V> zzibt;
    private volatile zzeew zzibu;
    /* access modifiers changed from: private */
    public Map<K, V> zzibv;
    private volatile zzeeq zzibw;

    private zzeel(int i) {
        this.zzibr = i;
        this.zzibs = Collections.emptyList();
        this.zzibt = Collections.emptyMap();
        this.zzibv = Collections.emptyMap();
    }

    /* synthetic */ zzeel(int i, zzeeo zzeeo) {
        this(i);
    }

    private final int zza(K k) {
        int size = this.zzibs.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzibs.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzibs.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* access modifiers changed from: private */
    public final void zzbgt() {
        if (this.zzhuu) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzbgu() {
        zzbgt();
        if (this.zzibt.isEmpty() && !(this.zzibt instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzibt = treeMap;
            this.zzibv = treeMap.descendingMap();
        }
        return (SortedMap) this.zzibt;
    }

    static <FieldDescriptorType extends zzebv<FieldDescriptorType>> zzeel<FieldDescriptorType, Object> zzhi(int i) {
        return new zzeeo(i);
    }

    /* access modifiers changed from: private */
    public final V zzhk(int i) {
        zzbgt();
        V value = this.zzibs.remove(i).getValue();
        if (!this.zzibt.isEmpty()) {
            Iterator it = zzbgu().entrySet().iterator();
            this.zzibs.add(new zzeeu(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void clear() {
        zzbgt();
        if (!this.zzibs.isEmpty()) {
            this.zzibs.clear();
        }
        if (!this.zzibt.isEmpty()) {
            this.zzibt.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzibt.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzibu == null) {
            this.zzibu = new zzeew(this, (zzeeo) null);
        }
        return this.zzibu;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeel)) {
            return super.equals(obj);
        }
        zzeel zzeel = (zzeel) obj;
        int size = size();
        if (size != zzeel.size()) {
            return false;
        }
        int zzbgq = zzbgq();
        if (zzbgq != zzeel.zzbgq()) {
            return entrySet().equals(zzeel.entrySet());
        }
        for (int i = 0; i < zzbgq; i++) {
            if (!zzhj(i).equals(zzeel.zzhj(i))) {
                return false;
            }
        }
        if (zzbgq != size) {
            return this.zzibt.equals(zzeel.zzibt);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? this.zzibs.get(zza).getValue() : this.zzibt.get(comparable);
    }

    public int hashCode() {
        int zzbgq = zzbgq();
        int i = 0;
        for (int i2 = 0; i2 < zzbgq; i2++) {
            i += this.zzibs.get(i2).hashCode();
        }
        return this.zzibt.size() > 0 ? i + this.zzibt.hashCode() : i;
    }

    public final boolean isImmutable() {
        return this.zzhuu;
    }

    public V remove(Object obj) {
        zzbgt();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzhk(zza);
        }
        if (this.zzibt.isEmpty()) {
            return null;
        }
        return this.zzibt.remove(comparable);
    }

    public int size() {
        return this.zzibt.size() + this.zzibs.size();
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzbgt();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzibs.get(zza).setValue(v);
        }
        zzbgt();
        if (this.zzibs.isEmpty() && !(this.zzibs instanceof ArrayList)) {
            this.zzibs = new ArrayList(this.zzibr);
        }
        int i = -(zza + 1);
        if (i >= this.zzibr) {
            return zzbgu().put(k, v);
        }
        int size = this.zzibs.size();
        int i2 = this.zzibr;
        if (size == i2) {
            zzeeu remove = this.zzibs.remove(i2 - 1);
            zzbgu().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzibs.add(i, new zzeeu(this, k, v));
        return null;
    }

    public void zzbcj() {
        if (!this.zzhuu) {
            this.zzibt = this.zzibt.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzibt);
            this.zzibv = this.zzibv.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzibv);
            this.zzhuu = true;
        }
    }

    public final int zzbgq() {
        return this.zzibs.size();
    }

    public final Iterable<Map.Entry<K, V>> zzbgr() {
        return this.zzibt.isEmpty() ? zzeep.zzbhb() : this.zzibt.entrySet();
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzbgs() {
        if (this.zzibw == null) {
            this.zzibw = new zzeeq(this, (zzeeo) null);
        }
        return this.zzibw;
    }

    public final Map.Entry<K, V> zzhj(int i) {
        return this.zzibs.get(i);
    }
}
