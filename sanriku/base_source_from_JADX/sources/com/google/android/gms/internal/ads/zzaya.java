package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import p043jp.reifrontier.gym.RFGDef;

public final class zzaya {
    private final Object lock = new Object();
    private String zzdxa = "";
    private String zzdxb = "";
    private boolean zzdxc = false;
    @VisibleForTesting
    private String zzdxd = "";

    @VisibleForTesting
    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzazw.zzfb("Can not create dialog without Activity Context");
        } else {
            zzaxa.zzdwf.post(new zzaxz(this, context, str, z, z2));
        }
    }

    private final String zzbh(Context context) {
        String str;
        synchronized (this.lock) {
            if (TextUtils.isEmpty(this.zzdxa)) {
                zzq.zzkw();
                String zzs = zzaxa.zzs(context, "debug_signals_id.txt");
                this.zzdxa = zzs;
                if (TextUtils.isEmpty(zzs)) {
                    zzq.zzkw();
                    this.zzdxa = zzaxa.zzxg();
                    zzq.zzkw();
                    zzaxa.zzc(context, "debug_signals_id.txt", this.zzdxa);
                }
            }
            str = this.zzdxa;
        }
        return str;
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzd(context, (String) zzvj.zzpv().zzd(zzzz.zzcqj), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzq.zzkw();
        zzaxa.zzb(context, str, buildUpon.build().toString());
    }

    private final Uri zzd(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzbh(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    @VisibleForTesting
    private final boolean zzf(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzvj.zzpv().zzd(zzzz.zzcqh), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzazw.zzed("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzh.trim());
            String optString = jSONObject.optString("gct");
            this.zzdxd = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
            synchronized (this.lock) {
                this.zzdxb = optString;
            }
            return true;
        } catch (JSONException e) {
            zzazw.zzd("Fail to get in app preview response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private final boolean zzg(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzvj.zzpv().zzd(zzzz.zzcqi), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzazw.zzed("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzh.trim()).optString("debug_mode"));
            synchronized (this.lock) {
                this.zzdxc = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzazw.zzd("Fail to get debug mode response json.", e);
            return false;
        }
    }

    @VisibleForTesting
    private static String zzh(Context context, String str, String str2) {
        String str3;
        Throwable e;
        String str4;
        String str5;
        HashMap hashMap = new HashMap();
        hashMap.put(AbstractSpiCall.HEADER_USER_AGENT, zzq.zzkw().zzr(context, str2));
        zzdri<String> zzc = new zzaym(context).zzc(str, hashMap);
        try {
            return zzc.get((long) ((Integer) zzvj.zzpv().zzd(zzzz.zzcqk)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e2) {
            e = e2;
            str5 = "Timeout while retriving a response from: ";
            str4 = String.valueOf(str);
            if (str4.length() == 0) {
                str3 = new String(str5);
                zzazw.zzc(str3, e);
                zzc.cancel(true);
                return null;
            }
            str3 = str5.concat(str4);
            zzazw.zzc(str3, e);
            zzc.cancel(true);
            return null;
        } catch (InterruptedException e3) {
            e = e3;
            str5 = "Interrupted while retriving a response from: ";
            str4 = String.valueOf(str);
            if (str4.length() == 0) {
                str3 = new String(str5);
                zzazw.zzc(str3, e);
                zzc.cancel(true);
                return null;
            }
            str3 = str5.concat(str4);
            zzazw.zzc(str3, e);
            zzc.cancel(true);
            return null;
        } catch (Exception e4) {
            String valueOf = String.valueOf(str);
            zzazw.zzc(valueOf.length() != 0 ? "Error retriving a response from: ".concat(valueOf) : new String("Error retriving a response from: "), e4);
            return null;
        }
    }

    private final void zzi(Context context, String str, String str2) {
        zzq.zzkw();
        zzaxa.zza(context, zzd(context, (String) zzvj.zzpv().zzd(zzzz.zzcqg), str, str2));
    }

    public final void zza(Context context, String str, String str2, @Nullable String str3) {
        boolean zzxu = zzxu();
        if (zzg(context, str, str2)) {
            if (!zzxu && !TextUtils.isEmpty(str3)) {
                zzc(context, str2, str3, str);
            }
            zzazw.zzed("Device is linked for debug signals.");
            zza(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzi(context, str, str2);
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzq.zzlg().zzxu()) {
            return false;
        }
        zzazw.zzed("Sending troubleshooting signals to the server.");
        zzc(context, str, str2, str3);
        return true;
    }

    public final void zze(Context context, String str, String str2) {
        if (!zzf(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (ExifInterface.GPS_MEASUREMENT_2D.equals(this.zzdxd)) {
            zzazw.zzed("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzdxd)) {
            zzazw.zzed("The app is not linked for creative preview.");
            zzi(context, str, str2);
        } else if (RFGDef.DEFAULT_GYM_ID.equals(this.zzdxd)) {
            zzazw.zzed("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final String zzxt() {
        String str;
        synchronized (this.lock) {
            str = this.zzdxb;
        }
        return str;
    }

    public final boolean zzxu() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdxc;
        }
        return z;
    }
}
