// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbo;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzby;
import com.google.android.gms.common.internal.zzbd;
import com.google.android.gms.R;
import android.content.Context;
import com.google.android.gms.common.api.Status;

@Deprecated
public final class zzbdm
{
    private static zzbdm zzaEB;
    private static final Object zzuF;
    private final String mAppId;
    private final Status zzaEC;
    private final boolean zzaED;
    private final boolean zzaEE;
    
    static {
        zzuF = new Object();
    }
    
    private zzbdm(final Context context) {
        boolean zzaED = true;
        boolean zzaEE = true;
        final Resources resources = context.getResources();
        final int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            zzaED = (resources.getInteger(identifier) != 0);
            if (zzaED) {
                zzaEE = false;
            }
            this.zzaEE = zzaEE;
        }
        else {
            this.zzaEE = false;
        }
        this.zzaED = zzaED;
        String mAppId;
        if ((mAppId = zzbd.zzaD(context)) == null) {
            mAppId = new zzby(context).getString("google_app_id");
        }
        if (TextUtils.isEmpty((CharSequence)mAppId)) {
            this.zzaEC = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.mAppId = null;
            return;
        }
        this.mAppId = mAppId;
        this.zzaEC = Status.zzaBm;
    }
    
    public static Status zzaz(final Context context) {
        zzbo.zzb(context, "Context must not be null.");
        synchronized (zzbdm.zzuF) {
            if (zzbdm.zzaEB == null) {
                zzbdm.zzaEB = new zzbdm(context);
            }
            return zzbdm.zzaEB.zzaEC;
        }
    }
    
    private static zzbdm zzcu(final String s) {
        synchronized (zzbdm.zzuF) {
            if (zzbdm.zzaEB == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(s).length() + 34).append("Initialize must be called before ").append(s).append(".").toString());
            }
        }
        // monitorexit(o)
        return zzbdm.zzaEB;
    }
    
    public static String zzqA() {
        return zzcu("getGoogleAppId").mAppId;
    }
    
    public static boolean zzqB() {
        return zzcu("isMeasurementExplicitlyDisabled").zzaEE;
    }
}
