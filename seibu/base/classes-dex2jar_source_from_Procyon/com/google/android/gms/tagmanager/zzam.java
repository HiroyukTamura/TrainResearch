// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzam extends zzbr
{
    private static final String ID;
    private static final String zzbDq;
    private static final String zzbEb;
    private final zzan zzbEc;
    
    static {
        ID = zzbf.zzdE.toString();
        zzbEb = zzbg.zzhH.toString();
        zzbDq = zzbg.zzfE.toString();
    }
    
    public zzam(final zzan zzbEc) {
        super(zzam.ID, new String[] { zzam.zzbEb });
        this.zzbEc = zzbEc;
    }
    
    @Override
    public final boolean zzAE() {
        return false;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final String zzb = zzgk.zzb(map.get(zzam.zzbEb));
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        final com.google.android.gms.internal.zzbr zzbr = map.get(zzam.zzbDq);
        if (zzbr != null) {
            final Object zzg = zzgk.zzg(zzbr);
            if (!(zzg instanceof Map)) {
                zzdj.zzaT("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzgk.zzCh();
            }
            for (final Map.Entry<Object, V> entry : ((Map<Object, V>)zzg).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzgk.zzI(this.zzbEc.zzd(zzb, hashMap));
        }
        catch (Exception ex) {
            final String value = String.valueOf(ex.getMessage());
            zzdj.zzaT(new StringBuilder(String.valueOf(zzb).length() + 34 + String.valueOf(value).length()).append("Custom macro/tag ").append(zzb).append(" threw exception ").append(value).toString());
            return zzgk.zzCh();
        }
    }
}
