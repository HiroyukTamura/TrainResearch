package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzml implements zzmk {
    private final zzhq zzady = new zzhq();
    private final zzmk[] zzbch;
    private final ArrayList<zzmk> zzbci;
    private zzmj zzbcj;
    private zzhp zzbck;
    private Object zzbcl;
    private int zzbcm = -1;
    private zzmn zzbcn;

    public zzml(zzmk... zzmkArr) {
        this.zzbch = zzmkArr;
        this.zzbci = new ArrayList<>(Arrays.asList(zzmkArr));
    }

    /* access modifiers changed from: private */
    public final void zza(int i, zzhp zzhp, Object obj) {
        zzmn zzmn;
        if (this.zzbcn == null) {
            int zzfe = zzhp.zzfe();
            int i2 = 0;
            while (true) {
                if (i2 >= zzfe) {
                    if (this.zzbcm == -1) {
                        this.zzbcm = zzhp.zzff();
                    } else if (zzhp.zzff() != this.zzbcm) {
                        zzmn = new zzmn(1);
                    }
                    zzmn = null;
                } else if (zzhp.zza(i2, this.zzady, false).zzahp) {
                    zzmn = new zzmn(0);
                    break;
                } else {
                    i2++;
                }
            }
            this.zzbcn = zzmn;
        }
        if (this.zzbcn == null) {
            this.zzbci.remove(this.zzbch[i]);
            if (i == 0) {
                this.zzbck = zzhp;
                this.zzbcl = obj;
            }
            if (this.zzbci.isEmpty()) {
                this.zzbcj.zzb(this.zzbck, this.zzbcl);
            }
        }
    }

    public final zzmi zza(int i, zzns zzns) {
        int length = this.zzbch.length;
        zzmi[] zzmiArr = new zzmi[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzmiArr[i2] = this.zzbch[i2].zza(i, zzns);
        }
        return new zzmm(zzmiArr);
    }

    public final void zza(zzgt zzgt, boolean z, zzmj zzmj) {
        this.zzbcj = zzmj;
        int i = 0;
        while (true) {
            zzmk[] zzmkArr = this.zzbch;
            if (i < zzmkArr.length) {
                zzmkArr[i].zza(zzgt, false, new zzmo(this, i));
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzb(zzmi zzmi) {
        zzmm zzmm = (zzmm) zzmi;
        int i = 0;
        while (true) {
            zzmk[] zzmkArr = this.zzbch;
            if (i < zzmkArr.length) {
                zzmkArr[i].zzb(zzmm.zzbco[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzhy() throws IOException {
        zzmn zzmn = this.zzbcn;
        if (zzmn == null) {
            for (zzmk zzhy : this.zzbch) {
                zzhy.zzhy();
            }
            return;
        }
        throw zzmn;
    }

    public final void zzhz() {
        for (zzmk zzhz : this.zzbch) {
            zzhz.zzhz();
        }
    }
}
