// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzt extends zzbr
{
    private static final String ID;
    private static final String VALUE;
    
    static {
        ID = zzbf.zzds.toString();
        VALUE = zzbg.zzko.toString();
    }
    
    public zzt() {
        super(zzt.ID, new String[] { zzt.VALUE });
    }
    
    public static String zzAG() {
        return zzt.ID;
    }
    
    public static String zzAH() {
        return zzt.VALUE;
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        return map.get(zzt.VALUE);
    }
}
