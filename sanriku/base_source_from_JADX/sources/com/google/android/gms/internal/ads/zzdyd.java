package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecd;
import java.util.List;

@Deprecated
public final class zzdyd extends zzecd<zzdyd, zza> implements zzedq {
    private static volatile zzedx<zzdyd> zzea;
    /* access modifiers changed from: private */
    public static final zzdyd zzhpz;
    private String zzhpx = "";
    private zzecl<zzdxm> zzhpy = zzecd.zzbfa();

    public static final class zza extends zzecd.zza<zzdyd, zza> implements zzedq {
        private zza() {
            super(zzdyd.zzhpz);
        }

        /* synthetic */ zza(zzdyc zzdyc) {
            this();
        }
    }

    static {
        zzdyd zzdyd = new zzdyd();
        zzhpz = zzdyd;
        zzecd.zza(zzdyd.class, zzdyd);
    }

    private zzdyd() {
    }

    public static zzdyd zzbbq() {
        return zzhpz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdyc.zzdk[i - 1]) {
            case 1:
                return new zzdyd();
            case 2:
                return new zza((zzdyc) null);
            case 3:
                return zzecd.zza((zzedo) zzhpz, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzhpx", "zzhpy", zzdxm.class});
            case 4:
                return zzhpz;
            case 5:
                zzedx<zzdyd> zzedx = zzea;
                if (zzedx == null) {
                    synchronized (zzdyd.class) {
                        zzedx = zzea;
                        if (zzedx == null) {
                            zzedx = new zzecd.zzc<>(zzhpz);
                            zzea = zzedx;
                        }
                    }
                }
                return zzedx;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final List<zzdxm> zzbbp() {
        return this.zzhpy;
    }
}
