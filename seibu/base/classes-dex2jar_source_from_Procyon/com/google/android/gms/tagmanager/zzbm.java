// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzbr;
import java.util.Map;
import com.google.android.gms.internal.zzbf;

public final class zzbm extends zzga
{
    private static final String ID;
    
    static {
        ID = zzbf.zzez.toString();
    }
    
    public zzbm() {
        super(zzbm.ID);
    }
    
    @Override
    protected final boolean zza(final String s, final String anObject, final Map<String, com.google.android.gms.internal.zzbr> map) {
        return s.equals(anObject);
    }
}
