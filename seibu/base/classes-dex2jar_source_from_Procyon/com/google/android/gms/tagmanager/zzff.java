// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Collection;
import java.util.List;
import com.google.android.gms.internal.ei;
import java.util.Set;
import com.google.android.gms.internal.em;
import java.util.Map;

final class zzff implements zzfh
{
    private /* synthetic */ Map zzbGq;
    private /* synthetic */ Map zzbGr;
    private /* synthetic */ Map zzbGs;
    private /* synthetic */ Map zzbGt;
    
    zzff(final zzfc zzfc, final Map zzbGq, final Map zzbGr, final Map zzbGs, final Map zzbGt) {
        this.zzbGq = zzbGq;
        this.zzbGr = zzbGr;
        this.zzbGs = zzbGs;
        this.zzbGt = zzbGt;
    }
    
    @Override
    public final void zza(final em em, final Set<ei> set, final Set<ei> set2, final zzer zzer) {
        final List<? extends ei> list = this.zzbGq.get(em);
        this.zzbGr.get(em);
        if (list != null) {
            set.addAll(list);
            zzer.zzBt();
        }
        final List<? extends ei> list2 = this.zzbGs.get(em);
        this.zzbGt.get(em);
        if (list2 != null) {
            set2.addAll(list2);
            zzer.zzBu();
        }
    }
}
