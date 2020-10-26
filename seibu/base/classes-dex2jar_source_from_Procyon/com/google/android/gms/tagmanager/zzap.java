// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.Map;
import java.util.List;

final class zzap implements zzaq
{
    private /* synthetic */ DataLayer zzbEl;
    
    zzap(final DataLayer zzbEl) {
        this.zzbEl = zzbEl;
    }
    
    @Override
    public final void zzJ(final List<DataLayer.zza> list) {
        for (final DataLayer.zza zza : list) {
            this.zzbEl.zzr(DataLayer.zzn(zza.zzBN, zza.mValue));
        }
        this.zzbEl.zzbEk.countDown();
    }
}
