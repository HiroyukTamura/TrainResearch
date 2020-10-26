// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public class zzbez<T>
{
    private static String READ_PERMISSION;
    private static zzbff zzaFo;
    private static int zzaFp;
    private static final Object zzuF;
    private String zzBN;
    private T zzBO;
    private T zzaFq;
    
    static {
        zzuF = new Object();
        zzbez.zzaFo = null;
        zzbez.zzaFp = 0;
        zzbez.READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    }
    
    protected zzbez(final String zzBN, final T zzBO) {
        this.zzaFq = null;
        this.zzBN = zzBN;
        this.zzBO = zzBO;
    }
    
    public static zzbez<Float> zza(final String s, final Float n) {
        return new zzbfd(s, n);
    }
    
    public static zzbez<Integer> zza(final String s, final Integer n) {
        return new zzbfc(s, n);
    }
    
    public static zzbez<Long> zza(final String s, final Long n) {
        return new zzbfb(s, n);
    }
    
    public static zzbez<Boolean> zzg(final String s, final boolean b) {
        return new zzbfa(s, b);
    }
    
    public static zzbez<String> zzv(final String s, final String s2) {
        return new zzbfe(s, s2);
    }
}
