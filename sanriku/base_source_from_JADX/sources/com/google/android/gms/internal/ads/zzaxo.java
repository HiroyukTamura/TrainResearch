package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.zzq;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;

@TargetApi(24)
public class zzaxo extends zzaxl {
    @VisibleForTesting
    private static boolean zze(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }

    public final boolean zza(Activity activity, Configuration configuration) {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzcqm)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqo)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzvj.zzpr();
        int zzc = zzazm.zzc(activity, configuration.screenHeightDp);
        int zzc2 = zzazm.zzc(activity, configuration.screenWidthDp);
        zzq.zzkw();
        DisplayMetrics zza = zzaxa.zza((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i = zza.heightPixels;
        int i2 = zza.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d = (double) activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        int intValue = ((Integer) zzvj.zzpv().zzd(zzzz.zzcql)).intValue() * ((int) Math.round(d + 0.5d));
        return !(zze(i, zzc + dimensionPixelSize, intValue) && zze(i2, zzc2, intValue));
    }
}
