// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class zzbcj extends zzbcn
{
    private /* synthetic */ zzbcd zzaDp;
    private final ArrayList<Api.zze> zzaDv;
    
    public zzbcj(final zzbcd zzaDp, final ArrayList<Api.zze> zzaDv) {
        this.zzaDp = zzaDp;
        super(zzaDp, null);
        this.zzaDv = zzaDv;
    }
    
    @WorkerThread
    public final void zzpV() {
        this.zzaDp.zzaCZ.zzaCl.zzaDG = this.zzaDp.zzqb();
        final ArrayList<Api.zze> list = this.zzaDv;
        final int size = list.size();
        int i = 0;
        while (i < size) {
            final Api.zze value = list.get(i);
            ++i;
            value.zza(this.zzaDp.zzaDl, this.zzaDp.zzaCZ.zzaCl.zzaDG);
        }
    }
}
