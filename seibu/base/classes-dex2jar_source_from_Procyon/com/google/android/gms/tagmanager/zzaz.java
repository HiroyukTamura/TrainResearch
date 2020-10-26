// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.List;
import com.google.android.gms.internal.zzbr;
import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzaz extends zzgi
{
    private static final String ID;
    private static final String VALUE;
    private static final String zzbEx;
    private final DataLayer zzbDx;
    
    static {
        ID = zzbf.zzec.toString();
        VALUE = zzbg.zzko.toString();
        zzbEx = zzbg.zzgp.toString();
    }
    
    public zzaz(final DataLayer zzbDx) {
        super(zzaz.ID, new String[] { zzaz.VALUE });
        this.zzbDx = zzbDx;
    }
    
    @Override
    public final void zzq(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final com.google.android.gms.internal.zzbr zzbr = map.get(zzaz.VALUE);
        if (zzbr != null && zzbr != zzgk.zzCb()) {
            final Object zzg = zzgk.zzg(zzbr);
            if (zzg instanceof List) {
                for (final Map<String, Object> next : (List<Object>)zzg) {
                    if (next instanceof Map) {
                        this.zzbDx.push(next);
                    }
                }
            }
        }
        final com.google.android.gms.internal.zzbr zzbr2 = map.get(zzaz.zzbEx);
        if (zzbr2 != null && zzbr2 != zzgk.zzCb()) {
            final String zzb = zzgk.zzb(zzbr2);
            if (zzb != zzgk.zzCg()) {
                this.zzbDx.zzfc(zzb);
            }
        }
    }
}
