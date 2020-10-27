package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import kotlin.jvm.internal.LongCompanionObject;

final class zzmm implements zzmh, zzmi {
    private zzna zzaei;
    private zzmh zzbbh;
    public final zzmi[] zzbco;
    private final IdentityHashMap<zzmt, Integer> zzbcp = new IdentityHashMap<>();
    private int zzbcq;
    private zzmi[] zzbcr;
    private zzmw zzbcs;

    public zzmm(zzmi... zzmiArr) {
        this.zzbco = zzmiArr;
    }

    public final long zza(zznj[] zznjArr, boolean[] zArr, zzmt[] zzmtArr, boolean[] zArr2, long j) {
        zznj[] zznjArr2 = zznjArr;
        zzmt[] zzmtArr2 = zzmtArr;
        int[] iArr = new int[zznjArr2.length];
        int[] iArr2 = new int[zznjArr2.length];
        for (int i = 0; i < zznjArr2.length; i++) {
            iArr[i] = zzmtArr2[i] == null ? -1 : this.zzbcp.get(zzmtArr2[i]).intValue();
            iArr2[i] = -1;
            if (zznjArr2[i] != null) {
                zzmx zzik = zznjArr2[i].zzik();
                int i2 = 0;
                while (true) {
                    zzmi[] zzmiArr = this.zzbco;
                    if (i2 >= zzmiArr.length) {
                        break;
                    } else if (zzmiArr[i2].zzho().zza(zzik) != -1) {
                        iArr2[i] = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        this.zzbcp.clear();
        int length = zznjArr2.length;
        zzmt[] zzmtArr3 = new zzmt[length];
        zzmt[] zzmtArr4 = new zzmt[zznjArr2.length];
        zznj[] zznjArr3 = new zznj[zznjArr2.length];
        ArrayList arrayList = new ArrayList(this.zzbco.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.zzbco.length) {
            for (int i4 = 0; i4 < zznjArr2.length; i4++) {
                zznj zznj = null;
                zzmtArr4[i4] = iArr[i4] == i3 ? zzmtArr2[i4] : null;
                if (iArr2[i4] == i3) {
                    zznj = zznjArr2[i4];
                }
                zznjArr3[i4] = zznj;
            }
            int i5 = i3;
            zznj[] zznjArr4 = zznjArr3;
            ArrayList arrayList2 = arrayList;
            long zza = this.zzbco[i3].zza(zznjArr3, zArr, zzmtArr4, zArr2, j2);
            if (i5 == 0) {
                j2 = zza;
            } else if (zza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zznjArr2.length; i6++) {
                boolean z2 = true;
                if (iArr2[i6] == i5) {
                    zzoh.checkState(zzmtArr4[i6] != null);
                    zzmtArr3[i6] = zzmtArr4[i6];
                    this.zzbcp.put(zzmtArr4[i6], Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    if (zzmtArr4[i6] != null) {
                        z2 = false;
                    }
                    zzoh.checkState(z2);
                }
            }
            if (z) {
                arrayList2.add(this.zzbco[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            zznjArr3 = zznjArr4;
            zzmtArr2 = zzmtArr;
        }
        zzmt[] zzmtArr5 = zzmtArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzmtArr3, 0, zzmtArr5, 0, length);
        zzmi[] zzmiArr2 = new zzmi[arrayList3.size()];
        this.zzbcr = zzmiArr2;
        arrayList3.toArray(zzmiArr2);
        this.zzbcs = new zzlv(this.zzbcr);
        return j2;
    }

    public final void zza(zzmh zzmh, long j) {
        this.zzbbh = zzmh;
        zzmi[] zzmiArr = this.zzbco;
        this.zzbcq = zzmiArr.length;
        for (zzmi zza : zzmiArr) {
            zza.zza(this, j);
        }
    }

    public final void zza(zzmi zzmi) {
        int i = this.zzbcq - 1;
        this.zzbcq = i;
        if (i <= 0) {
            int i2 = 0;
            for (zzmi zzho : this.zzbco) {
                i2 += zzho.zzho().length;
            }
            zzmx[] zzmxArr = new zzmx[i2];
            int i3 = 0;
            for (zzmi zzho2 : this.zzbco) {
                zzna zzho3 = zzho2.zzho();
                int i4 = zzho3.length;
                int i5 = 0;
                while (i5 < i4) {
                    zzmxArr[i3] = zzho3.zzay(i5);
                    i5++;
                    i3++;
                }
            }
            this.zzaei = new zzna(zzmxArr);
            this.zzbbh.zza(this);
        }
    }

    public final /* synthetic */ void zza(zzmw zzmw) {
        if (this.zzaei != null) {
            this.zzbbh.zza(this);
        }
    }

    public final boolean zzee(long j) {
        return this.zzbcs.zzee(j);
    }

    public final void zzef(long j) {
        for (zzmi zzef : this.zzbcr) {
            zzef.zzef(j);
        }
    }

    public final long zzeg(long j) {
        long zzeg = this.zzbcr[0].zzeg(j);
        int i = 1;
        while (true) {
            zzmi[] zzmiArr = this.zzbcr;
            if (i >= zzmiArr.length) {
                return zzeg;
            }
            if (zzmiArr[i].zzeg(zzeg) == zzeg) {
                i++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    public final long zzhm() {
        return this.zzbcs.zzhm();
    }

    public final void zzhn() throws IOException {
        for (zzmi zzhn : this.zzbco) {
            zzhn.zzhn();
        }
    }

    public final zzna zzho() {
        return this.zzaei;
    }

    public final long zzhp() {
        long zzhp = this.zzbco[0].zzhp();
        int i = 1;
        while (true) {
            zzmi[] zzmiArr = this.zzbco;
            if (i >= zzmiArr.length) {
                if (zzhp != -9223372036854775807L) {
                    zzmi[] zzmiArr2 = this.zzbcr;
                    int length = zzmiArr2.length;
                    int i2 = 0;
                    while (i2 < length) {
                        zzmi zzmi = zzmiArr2[i2];
                        if (zzmi == this.zzbco[0] || zzmi.zzeg(zzhp) == zzhp) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzhp;
            } else if (zzmiArr[i].zzhp() == -9223372036854775807L) {
                i++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    public final long zzhq() {
        long j = Long.MAX_VALUE;
        for (zzmi zzhq : this.zzbcr) {
            long zzhq2 = zzhq.zzhq();
            if (zzhq2 != Long.MIN_VALUE) {
                j = Math.min(j, zzhq2);
            }
        }
        if (j == LongCompanionObject.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }
}
