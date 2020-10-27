package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.C0668R;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import p009e.p010a.p011a.p012a.C0681a;

@KeepForSdk
@Deprecated
public final class GoogleServices {
    private static final Object sLock = new Object();
    private static GoogleServices zzbk;
    private final String zzbl;
    private final Status zzbm;
    private final boolean zzbn;
    private final boolean zzbo;

    @KeepForSdk
    @VisibleForTesting
    GoogleServices(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C0668R.string.common_google_play_services_unknown_issue));
        boolean z = false;
        boolean z2 = true;
        if (identifier != 0) {
            z = resources.getInteger(identifier) != 0 ? true : z;
            this.zzbo = !z;
            z2 = z;
        } else {
            this.zzbo = false;
        }
        this.zzbn = z2;
        String zzc = zzp.zzc(context);
        zzc = zzc == null ? new StringResourceValueReader(context).getString("google_app_id") : zzc;
        if (TextUtils.isEmpty(zzc)) {
            this.zzbm = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzbl = null;
            return;
        }
        this.zzbl = zzc;
        this.zzbm = Status.RESULT_SUCCESS;
    }

    @KeepForSdk
    @VisibleForTesting
    GoogleServices(String str, boolean z) {
        this.zzbl = str;
        this.zzbm = Status.RESULT_SUCCESS;
        this.zzbn = z;
        this.zzbo = !z;
    }

    @KeepForSdk
    private static GoogleServices checkInitialized(String str) {
        GoogleServices googleServices;
        synchronized (sLock) {
            if (zzbk != null) {
                googleServices = zzbk;
            } else {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return googleServices;
    }

    @KeepForSdk
    @VisibleForTesting
    static void clearInstanceForTest() {
        synchronized (sLock) {
            zzbk = null;
        }
    }

    @KeepForSdk
    public static String getGoogleAppId() {
        return checkInitialized("getGoogleAppId").zzbl;
    }

    @KeepForSdk
    public static Status initialize(Context context) {
        Status status;
        Preconditions.checkNotNull(context, "Context must not be null.");
        synchronized (sLock) {
            if (zzbk == null) {
                zzbk = new GoogleServices(context);
            }
            status = zzbk.zzbm;
        }
        return status;
    }

    @KeepForSdk
    public static Status initialize(Context context, String str, boolean z) {
        Preconditions.checkNotNull(context, "Context must not be null.");
        Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
        synchronized (sLock) {
            if (zzbk != null) {
                Status checkGoogleAppId = zzbk.checkGoogleAppId(str);
                return checkGoogleAppId;
            }
            GoogleServices googleServices = new GoogleServices(str, z);
            zzbk = googleServices;
            Status status = googleServices.zzbm;
            return status;
        }
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        GoogleServices checkInitialized = checkInitialized("isMeasurementEnabled");
        return checkInitialized.zzbm.isSuccess() && checkInitialized.zzbn;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        return checkInitialized("isMeasurementExplicitlyDisabled").zzbo;
    }

    /* access modifiers changed from: package-private */
    @KeepForSdk
    @VisibleForTesting
    public final Status checkGoogleAppId(String str) {
        String str2 = this.zzbl;
        if (str2 == null || str2.equals(str)) {
            return Status.RESULT_SUCCESS;
        }
        String str3 = this.zzbl;
        return new Status(10, C0681a.m313a(C0681a.m336b(str3, 97), "Initialize was called with two different Google App IDs.  Only the first app ID will be used: '", str3, "'."));
    }
}
