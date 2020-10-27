package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzuq;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzur<M extends zzuq<M>, T> {
    public final int tag;
    private final int type;
    private final zzrc<?, ?> zzban;
    protected final Class<T> zzbhc;
    protected final boolean zzbhd;

    private zzur(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, (zzrc<?, ?>) null, 810, false);
    }

    private zzur(int i, Class<T> cls, zzrc<?, ?> zzrc, int i2, boolean z) {
        this.type = i;
        this.zzbhc = cls;
        this.tag = i2;
        this.zzbhd = false;
        this.zzban = null;
    }

    public static <M extends zzuq<M>, T extends zzuw> zzur<M, T> zza(int i, Class<T> cls, long j) {
        return new zzur<>(11, cls, 810, false);
    }

    private final Object zzc(zzun zzun) {
        Class componentType = this.zzbhd ? this.zzbhc.getComponentType() : this.zzbhc;
        try {
            int i = this.type;
            if (i == 10) {
                zzuw zzuw = (zzuw) componentType.newInstance();
                zzun.zza(zzuw, this.tag >>> 3);
                return zzuw;
            } else if (i == 11) {
                zzuw zzuw2 = (zzuw) componentType.newInstance();
                zzun.zza(zzuw2);
                return zzuw2;
            } else {
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(C0681a.m312a(valueOf.length() + 33, "Error creating instance of class ", valueOf), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(componentType);
            throw new IllegalArgumentException(C0681a.m312a(valueOf2.length() + 33, "Error creating instance of class ", valueOf2), e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzur)) {
            return false;
        }
        zzur zzur = (zzur) obj;
        return this.type == zzur.type && this.zzbhc == zzur.zzbhc && this.tag == zzur.tag && this.zzbhd == zzur.zzbhd;
    }

    public final int hashCode() {
        return ((((this.zzbhc.hashCode() + ((this.type + 1147) * 31)) * 31) + this.tag) * 31) + (this.zzbhd ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public final void zza(Object obj, zzuo zzuo) {
        try {
            zzuo.zzcb(this.tag);
            int i = this.type;
            if (i == 10) {
                ((zzuw) obj).zza(zzuo);
                zzuo.zzd(this.tag >>> 3, 4);
            } else if (i == 11) {
                zzuo.zzb((zzuw) obj);
            } else {
                int i2 = this.type;
                StringBuilder sb = new StringBuilder(24);
                sb.append("Unknown type ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final T zzag(List<zzuy> list) {
        if (list == null) {
            return null;
        }
        if (this.zzbhd) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                byte[] bArr = list.get(i).zzawe;
                if (bArr.length != 0) {
                    arrayList.add(zzc(zzun.zzk(bArr)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            Class<T> cls = this.zzbhc;
            T cast = cls.cast(Array.newInstance(cls.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.zzbhc.cast(zzc(zzun.zzk(list.get(list.size() - 1).zzawe)));
        }
    }

    /* access modifiers changed from: protected */
    public final int zzaj(Object obj) {
        int i = this.tag >>> 3;
        int i2 = this.type;
        if (i2 == 10) {
            return ((zzuw) obj).zzpe() + (zzuo.zzbb(i) << 1);
        } else if (i2 == 11) {
            return zzuo.zzb(i, (zzuw) obj);
        } else {
            throw new IllegalArgumentException(C0681a.m309a(24, "Unknown type ", this.type));
        }
    }
}
