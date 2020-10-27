package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

public final class zzdtd {
    public static final String zzhjx = new zzdth().getKeyType();
    public static final String zzhjy = new zzdtr().getKeyType();
    private static final String zzhjz = new zzdtm().getKeyType();
    private static final String zzhka = new zzdtx().getKeyType();
    private static final String zzhkb = new zzdub().getKeyType();
    private static final String zzhkc = new zzdts().getKeyType();
    private static final String zzhkd = new zzduc().getKeyType();
    @Deprecated
    private static final zzdyd zzhke;
    @Deprecated
    private static final zzdyd zzhkf;
    @Deprecated
    private static final zzdyd zzhkg;

    static {
        zzdyd zzbbq = zzdyd.zzbbq();
        zzhke = zzbbq;
        zzhkf = zzbbq;
        zzhkg = zzbbq;
        try {
            zzaxl();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zzaxl() throws GeneralSecurityException {
        zzduz.zzaxl();
        zzdsx.zza(new zzdth(), true);
        zzdsx.zza(new zzdtm(), true);
        zzdsx.zza(new zzdtr(), true);
        zzdsx.zza(new zzdts(), true);
        zzdsx.zza(new zzdtx(), true);
        zzdsx.zza(new zzdub(), true);
        zzdsx.zza(new zzduc(), true);
        zzdsx.zza(new zzdtg());
    }
}
