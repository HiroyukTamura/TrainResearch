// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.lang.reflect.InvocationTargetException;
import com.google.android.gms.common.util.zzr;
import android.support.annotation.Nullable;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.common.internal.zzbo;
import android.support.annotation.Size;
import android.text.TextUtils;
import android.content.Context;
import com.google.android.gms.common.zze;

public final class zzcem extends zzchi
{
    private static String zzbpm;
    private Boolean zzagU;
    
    static {
        zzcem.zzbpm = String.valueOf(zze.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
    }
    
    zzcem(final zzcgl zzcgl) {
        super(zzcgl);
    }
    
    public static boolean zzqB() {
        return zzbdm.zzqB();
    }
    
    public static long zzwP() {
        return 11020L;
    }
    
    static long zzxA() {
        return 61000L;
    }
    
    static long zzxB() {
        return zzcfb.zzbqB.get();
    }
    
    public static String zzxC() {
        return "google_app_measurement.db";
    }
    
    static String zzxD() {
        return "google_app_measurement_local.db";
    }
    
    public static boolean zzxE() {
        return false;
    }
    
    public static long zzxG() {
        return zzcfb.zzbqy.get();
    }
    
    public static long zzxH() {
        return zzcfb.zzbqt.get();
    }
    
    public static long zzxI() {
        return zzcfb.zzbqu.get();
    }
    
    public static long zzxJ() {
        return 1000L;
    }
    
    public static long zzxK() {
        return Math.max(0L, zzcfb.zzbpX.get());
    }
    
    public static int zzxL() {
        return Math.max(0, zzcfb.zzbqd.get());
    }
    
    public static int zzxM() {
        return Math.max(1, zzcfb.zzbqe.get());
    }
    
    public static int zzxN() {
        return 100000;
    }
    
    public static String zzxO() {
        return zzcfb.zzbql.get();
    }
    
    public static long zzxP() {
        return zzcfb.zzbpY.get();
    }
    
    public static long zzxQ() {
        return Math.max(0L, zzcfb.zzbqm.get());
    }
    
    public static long zzxR() {
        return Math.max(0L, zzcfb.zzbqo.get());
    }
    
    public static long zzxS() {
        return Math.max(0L, zzcfb.zzbqp.get());
    }
    
    public static long zzxT() {
        return Math.max(0L, zzcfb.zzbqq.get());
    }
    
    public static long zzxU() {
        return Math.max(0L, zzcfb.zzbqr.get());
    }
    
    public static long zzxV() {
        return Math.max(0L, zzcfb.zzbqs.get());
    }
    
    public static long zzxW() {
        return zzcfb.zzbqn.get();
    }
    
    public static long zzxX() {
        return Math.max(0L, zzcfb.zzbqv.get());
    }
    
    public static long zzxY() {
        return Math.max(0L, zzcfb.zzbqw.get());
    }
    
    public static int zzxZ() {
        return Math.min(20, Math.max(0, zzcfb.zzbqx.get()));
    }
    
    static String zzxf() {
        return zzcfb.zzbpV.get();
    }
    
    public static int zzxg() {
        return 25;
    }
    
    public static int zzxh() {
        return 40;
    }
    
    public static int zzxi() {
        return 24;
    }
    
    static int zzxj() {
        return 40;
    }
    
    static int zzxk() {
        return 100;
    }
    
    static int zzxl() {
        return 256;
    }
    
    static int zzxm() {
        return 1000;
    }
    
    public static int zzxn() {
        return 36;
    }
    
    public static int zzxo() {
        return 2048;
    }
    
    static int zzxp() {
        return 500;
    }
    
    public static long zzxq() {
        return zzcfb.zzbqf.get();
    }
    
    public static long zzxr() {
        return zzcfb.zzbqh.get();
    }
    
    static int zzxs() {
        return 25;
    }
    
    static int zzxt() {
        return 1000;
    }
    
    static int zzxu() {
        return 25;
    }
    
    static int zzxv() {
        return 1000;
    }
    
    static long zzxw() {
        return 15552000000L;
    }
    
    static long zzxx() {
        return 15552000000L;
    }
    
    static long zzxy() {
        return 3600000L;
    }
    
    static long zzxz() {
        return 60000L;
    }
    
    public static boolean zzyb() {
        return zzcfb.zzbpU.get();
    }
    
    public final long zza(String zzM, final zzcfc<Long> zzcfc) {
        if (zzM == null) {
            return zzcfc.get();
        }
        zzM = super.zzwC().zzM(zzM, zzcfc.getKey());
        if (TextUtils.isEmpty((CharSequence)zzM)) {
            return zzcfc.get();
        }
        try {
            return zzcfc.get((long)Long.valueOf(zzM));
        }
        catch (NumberFormatException ex) {
            return zzcfc.get();
        }
    }
    
    public final int zzb(String zzM, final zzcfc<Integer> zzcfc) {
        if (zzM == null) {
            return zzcfc.get();
        }
        zzM = super.zzwC().zzM(zzM, zzcfc.getKey());
        if (TextUtils.isEmpty((CharSequence)zzM)) {
            return zzcfc.get();
        }
        try {
            return zzcfc.get((int)Integer.valueOf(zzM));
        }
        catch (NumberFormatException ex) {
            return zzcfc.get();
        }
    }
    
    public final int zzdM(@Size(min = 1L) final String s) {
        return this.zzb(s, zzcfb.zzbqj);
    }
    
    @Nullable
    final Boolean zzdN(@Size(min = 1L) final String s) {
        Boolean value = null;
        zzbo.zzcF(s);
        ApplicationInfo applicationInfo;
        try {
            if (super.getContext().getPackageManager() == null) {
                super.zzwF().zzyx().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            applicationInfo = zzbha.zzaP(super.getContext()).getApplicationInfo(super.getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                super.zzwF().zzyx().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            }
        }
        catch (PackageManager$NameNotFoundException ex) {
            super.zzwF().zzyx().zzj("Failed to load metadata: Package name not found", ex);
            return null;
        }
        if (applicationInfo.metaData == null) {
            super.zzwF().zzyx().log("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (applicationInfo.metaData.containsKey(s)) {
            value = applicationInfo.metaData.getBoolean(s);
        }
        return value;
    }
    
    public final boolean zzdO(final String s) {
        return "1".equals(super.zzwC().zzM(s, "gaia_collection_enabled"));
    }
    
    public final boolean zzln() {
        Label_0088: {
            if (this.zzagU != null) {
                break Label_0088;
            }
            synchronized (this) {
                if (this.zzagU == null) {
                    final ApplicationInfo applicationInfo = super.getContext().getApplicationInfo();
                    final String zzsf = zzr.zzsf();
                    if (applicationInfo != null) {
                        final String processName = applicationInfo.processName;
                        this.zzagU = (processName != null && processName.equals(zzsf));
                    }
                    if (this.zzagU == null) {
                        this.zzagU = Boolean.TRUE;
                        super.zzwF().zzyx().log("My process not in the list of running processes");
                    }
                }
                // monitorexit(this)
                return this.zzagU;
            }
        }
    }
    
    public final boolean zzxF() {
        final Boolean zzdN = this.zzdN("firebase_analytics_collection_deactivated");
        return zzdN != null && zzdN;
    }
    
    public final String zzya() {
        try {
            return (String)Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "debug.firebase.analytics.app", "");
        }
        catch (ClassNotFoundException ex) {
            super.zzwF().zzyx().zzj("Could not find SystemProperties class", ex);
        }
        catch (NoSuchMethodException ex2) {
            super.zzwF().zzyx().zzj("Could not find SystemProperties.get() method", ex2);
            goto Label_0067;
        }
        catch (IllegalAccessException ex3) {
            super.zzwF().zzyx().zzj("Could not access SystemProperties.get()", ex3);
            goto Label_0067;
        }
        catch (InvocationTargetException ex4) {
            super.zzwF().zzyx().zzj("SystemProperties.get() threw an exception", ex4);
            goto Label_0067;
        }
    }
}
