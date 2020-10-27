package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.internal.ads.zzbv;
import java.util.HashMap;
import java.util.Map;

final class zzdna implements zzdlq {
    private final Object zzhcv;
    private final zzdmz zzhcw;
    private final zzdnm zzhcx;
    private final zzdlk zzvj;

    zzdna(@NonNull Object obj, @NonNull zzdmz zzdmz, @NonNull zzdnm zzdnm, @NonNull zzdlk zzdlk) {
        this.zzhcv = obj;
        this.zzhcw = zzdmz;
        this.zzhcx = zzdnm;
        this.zzvj = zzdlk;
    }

    @Nullable
    private final synchronized byte[] zzb(Map<String, String> map, Map<String, Object> map2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.zzvj.zza(2007, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.zzhcv.getClass().getDeclaredMethod("xss", new Class[]{Map.class, Map.class}).invoke(this.zzhcv, new Object[]{null, map2});
    }

    @Nullable
    private static String zzk(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(((zzbv.zzf) ((zzecd) zzbv.zzf.zzbm().zzb(zzcc.DG).zzj(zzeaq.zzu(bArr)).zzbet())).toByteArray(), 11);
    }

    public final synchronized void close() throws zzdnk {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.zzhcv.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zzhcv, new Object[0]);
            this.zzvj.zzg(AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzdnk(2003, (Throwable) e);
        }
    }

    @Nullable
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map<String, Object> zzcf;
        zzcf = this.zzhcx.zzcf();
        zzcf.put("f", "c");
        zzcf.put("ctx", context);
        zzcf.put("cs", str2);
        zzcf.put("aid", (Object) null);
        zzcf.put(Promotion.ACTION_VIEW, view);
        zzcf.put("act", activity);
        return zzk(zzb((Map<String, String>) null, zzcf));
    }

    public final synchronized void zza(String str, MotionEvent motionEvent) throws zzdnk {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HashMap hashMap = new HashMap();
            hashMap.put("aid", (Object) null);
            hashMap.put("evt", motionEvent);
            this.zzhcv.getClass().getDeclaredMethod("he", new Class[]{Map.class}).invoke(this.zzhcv, new Object[]{hashMap});
            this.zzvj.zzg(AuthApiStatusCodes.AUTH_API_SERVER_ERROR, System.currentTimeMillis() - currentTimeMillis);
        } catch (Exception e) {
            throw new zzdnk(2005, (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    public final zzdmz zzave() {
        return this.zzhcw;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzavf() throws zzdnk {
        try {
        } catch (Exception e) {
            throw new zzdnk(2001, (Throwable) e);
        }
        return ((Boolean) this.zzhcv.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.zzhcv, new Object[0])).booleanValue();
    }

    public final synchronized int zzavg() throws zzdnk {
        try {
        } catch (Exception e) {
            throw new zzdnk(2006, (Throwable) e);
        }
        return ((Integer) this.zzhcv.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zzhcv, new Object[0])).intValue();
    }

    @Nullable
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map<String, Object> zzce;
        zzce = this.zzhcx.zzce();
        zzce.put("f", "v");
        zzce.put("ctx", context);
        zzce.put("aid", (Object) null);
        zzce.put(Promotion.ACTION_VIEW, view);
        zzce.put("act", activity);
        return zzk(zzb((Map<String, String>) null, zzce));
    }

    @Nullable
    public final synchronized String zzu(Context context, String str) {
        Map<String, Object> zzcd;
        zzcd = this.zzhcx.zzcd();
        zzcd.put("f", "q");
        zzcd.put("ctx", context);
        zzcd.put("aid", (Object) null);
        return zzk(zzb((Map<String, String>) null, zzcd));
    }
}
