// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Locale;
import java.util.Map;
import java.util.Set;
import com.google.android.gms.internal.zzbf;

public final class zzde extends zzbr
{
    private static final String ID;
    
    static {
        ID = zzbf.zzdH.toString();
    }
    
    public zzde() {
        super(zzde.ID, new String[0]);
    }
    
    @Override
    public final boolean zzAE() {
        return false;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final Locale default1 = Locale.getDefault();
        if (default1 == null) {
            return zzgk.zzCh();
        }
        final String language = default1.getLanguage();
        if (language == null) {
            return zzgk.zzCh();
        }
        return zzgk.zzI(language.toLowerCase());
    }
}
