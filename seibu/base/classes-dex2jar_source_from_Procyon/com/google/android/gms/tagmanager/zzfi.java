// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbr;

final class zzfi
{
    private zzea<zzbr> zzbGu;
    private zzbr zzbGv;
    
    public zzfi(final zzea<zzbr> zzbGu, final zzbr zzbGv) {
        this.zzbGu = zzbGu;
        this.zzbGv = zzbGv;
    }
    
    public final int getSize() {
        final int zzLU = this.zzbGu.getObject().zzLU();
        int zzLU2;
        if (this.zzbGv == null) {
            zzLU2 = 0;
        }
        else {
            zzLU2 = this.zzbGv.zzLU();
        }
        return zzLU2 + zzLU;
    }
    
    public final zzea<zzbr> zzBM() {
        return this.zzbGu;
    }
    
    public final zzbr zzBN() {
        return this.zzbGv;
    }
}
