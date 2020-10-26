// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.os.Build;
import java.util.Map;
import com.google.android.gms.internal.zzbf;

final class zzbd extends zzbr
{
    private static final String ID;
    
    static {
        ID = zzbf.zzdx.toString();
    }
    
    public zzbd() {
        super(zzbd.ID, new String[0]);
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final String manufacturer = Build.MANUFACTURER;
        String s2;
        final String s = s2 = Build.MODEL;
        if (!s.startsWith(manufacturer)) {
            s2 = s;
            if (!manufacturer.equals("unknown")) {
                s2 = new StringBuilder(String.valueOf(manufacturer).length() + 1 + String.valueOf(s).length()).append(manufacturer).append(" ").append(s).toString();
            }
        }
        return zzgk.zzI(s2);
    }
}
