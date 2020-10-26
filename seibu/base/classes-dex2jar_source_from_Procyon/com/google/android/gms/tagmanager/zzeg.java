// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import com.google.android.gms.internal.zzbg;

public abstract class zzeg extends zzbr
{
    private static final String zzbEH;
    private static final String zzbFE;
    
    static {
        zzbEH = zzbg.zzfR.toString();
        zzbFE = zzbg.zzfS.toString();
    }
    
    public zzeg(final String s) {
        super(s, new String[] { zzeg.zzbEH, zzeg.zzbFE });
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    protected abstract boolean zza(final com.google.android.gms.internal.zzbr p0, final com.google.android.gms.internal.zzbr p1, final Map<String, com.google.android.gms.internal.zzbr> p2);
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final Iterator<com.google.android.gms.internal.zzbr> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == zzgk.zzCh()) {
                return zzgk.zzI(false);
            }
        }
        final com.google.android.gms.internal.zzbr zzbr = map.get(zzeg.zzbEH);
        final com.google.android.gms.internal.zzbr zzbr2 = map.get(zzeg.zzbFE);
        return zzgk.zzI(zzbr != null && zzbr2 != null && this.zza(zzbr, zzbr2, map));
    }
}
