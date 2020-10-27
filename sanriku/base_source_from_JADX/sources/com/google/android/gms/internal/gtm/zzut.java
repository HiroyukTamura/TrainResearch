package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class zzut implements Cloneable {
    private Object value;
    private zzur<?, ?> zzbhi;
    private List<zzuy> zzbhj = new ArrayList();

    zzut() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzy()];
        zza(zzuo.zzl(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzrz */
    public final zzut clone() {
        Object clone;
        zzut zzut = new zzut();
        try {
            zzut.zzbhi = this.zzbhi;
            if (this.zzbhj == null) {
                zzut.zzbhj = null;
            } else {
                zzut.zzbhj.addAll(this.zzbhj);
            }
            if (this.value != null) {
                if (this.value instanceof zzuw) {
                    clone = (zzuw) ((zzuw) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    clone = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzut.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        clone = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        clone = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        clone = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        clone = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        clone = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzuw[]) {
                        zzuw[] zzuwArr = (zzuw[]) this.value;
                        zzuw[] zzuwArr2 = new zzuw[zzuwArr.length];
                        zzut.value = zzuwArr2;
                        while (i < zzuwArr.length) {
                            zzuwArr2[i] = (zzuw) zzuwArr[i].clone();
                            i++;
                        }
                    }
                }
                zzut.value = clone;
            }
            return zzut;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        List<zzuy> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzut)) {
            return false;
        }
        zzut zzut = (zzut) obj;
        if (this.value == null || zzut.value == null) {
            List<zzuy> list2 = this.zzbhj;
            if (list2 != null && (list = zzut.zzbhj) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(toByteArray(), zzut.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else {
            zzur<?, ?> zzur = this.zzbhi;
            if (zzur != zzut.zzbhi) {
                return false;
            }
            if (!zzur.zzbhc.isArray()) {
                return this.value.equals(zzut.value);
            }
            Object obj2 = this.value;
            return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) zzut.value) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) zzut.value) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) zzut.value) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) zzut.value) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) zzut.value) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) zzut.value) : Arrays.deepEquals((Object[]) obj2, (Object[]) zzut.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzuo zzuo) throws IOException {
        Object obj = this.value;
        if (obj != null) {
            zzur<?, ?> zzur = this.zzbhi;
            if (zzur.zzbhd) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzur.zza(obj2, zzuo);
                    }
                }
                return;
            }
            zzur.zza(obj, zzuo);
            return;
        }
        for (zzuy next : this.zzbhj) {
            zzuo.zzcb(next.tag);
            zzuo.zzm(next.zzawe);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzuy zzuy) throws IOException {
        Object obj;
        Object obj2;
        List<zzuy> list = this.zzbhj;
        if (list != null) {
            list.add(zzuy);
            return;
        }
        Object obj3 = this.value;
        if (obj3 instanceof zzuw) {
            byte[] bArr = zzuy.zzawe;
            zzun zzj = zzun.zzj(bArr, 0, bArr.length);
            int zzoa = zzj.zzoa();
            if (zzoa == bArr.length - zzuo.zzbc(zzoa)) {
                obj = ((zzuw) this.value).zza(zzj);
            } else {
                throw zzuv.zzsa();
            }
        } else {
            if (obj3 instanceof zzuw[]) {
                zzuw[] zzuwArr = (zzuw[]) this.zzbhi.zzag(Collections.singletonList(zzuy));
                zzuw[] zzuwArr2 = (zzuw[]) this.value;
                obj2 = (zzuw[]) Arrays.copyOf(zzuwArr2, zzuwArr2.length + zzuwArr.length);
                System.arraycopy(zzuwArr, 0, obj2, zzuwArr2.length, zzuwArr.length);
            } else if (obj3 instanceof zzsk) {
                obj = ((zzsk) this.value).zzpg().zza((zzsk) this.zzbhi.zzag(Collections.singletonList(zzuy))).zzpm();
            } else if (obj3 instanceof zzsk[]) {
                zzsk[] zzskArr = (zzsk[]) this.zzbhi.zzag(Collections.singletonList(zzuy));
                zzsk[] zzskArr2 = (zzsk[]) this.value;
                obj2 = (zzsk[]) Arrays.copyOf(zzskArr2, zzskArr2.length + zzskArr.length);
                System.arraycopy(zzskArr, 0, obj2, zzskArr2.length, zzskArr.length);
            } else {
                obj = this.zzbhi.zzag(Collections.singletonList(zzuy));
            }
            obj = obj2;
        }
        this.zzbhi = this.zzbhi;
        this.value = obj;
        this.zzbhj = null;
    }

    /* access modifiers changed from: package-private */
    public final <T> T zzb(zzur<?, T> zzur) {
        if (this.value == null) {
            this.zzbhi = zzur;
            this.value = zzur.zzag(this.zzbhj);
            this.zzbhj = null;
        } else if (!this.zzbhi.equals(zzur)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }

    /* access modifiers changed from: package-private */
    public final int zzy() {
        Object obj = this.value;
        if (obj != null) {
            zzur<?, ?> zzur = this.zzbhi;
            if (!zzur.zzbhd) {
                return zzur.zzaj(obj);
            }
            int length = Array.getLength(obj);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                Object obj2 = Array.get(obj, i2);
                if (obj2 != null) {
                    i += zzur.zzaj(obj2);
                }
            }
            return i;
        }
        int i3 = 0;
        for (zzuy next : this.zzbhj) {
            i3 += zzuo.zzbj(next.tag) + 0 + next.zzawe.length;
        }
        return i3;
    }
}
