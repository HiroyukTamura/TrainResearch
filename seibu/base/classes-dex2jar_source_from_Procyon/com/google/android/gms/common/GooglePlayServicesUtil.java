// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import com.google.android.gms.common.internal.zzt;
import android.support.v4.app.Fragment;
import android.content.res.Resources;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.app.Dialog;
import android.app.Activity;

public final class GooglePlayServicesUtil extends zzo
{
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    
    static {
        GOOGLE_PLAY_SERVICES_VERSION_CODE = zzo.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
    
    private GooglePlayServicesUtil() {
    }
    
    @Deprecated
    public static Dialog getErrorDialog(final int n, final Activity activity, final int n2) {
        return getErrorDialog(n, activity, n2, null);
    }
    
    @Deprecated
    public static Dialog getErrorDialog(final int n, final Activity activity, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        int n3 = n;
        if (zzo.zze((Context)activity, n)) {
            n3 = 18;
        }
        return GoogleApiAvailability.getInstance().getErrorDialog(activity, n3, n2, dialogInterface$OnCancelListener);
    }
    
    @Deprecated
    public static PendingIntent getErrorPendingIntent(final int n, final Context context, final int n2) {
        return zzo.getErrorPendingIntent(n, context, n2);
    }
    
    @Deprecated
    public static String getErrorString(final int n) {
        return zzo.getErrorString(n);
    }
    
    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(final Context context) {
        return zzo.getOpenSourceSoftwareLicenseInfo(context);
    }
    
    public static Context getRemoteContext(final Context context) {
        return zzo.getRemoteContext(context);
    }
    
    public static Resources getRemoteResource(final Context context) {
        return zzo.getRemoteResource(context);
    }
    
    @Deprecated
    public static int isGooglePlayServicesAvailable(final Context context) {
        return zzo.isGooglePlayServicesAvailable(context);
    }
    
    @Deprecated
    public static boolean isUserRecoverableError(final int n) {
        return zzo.isUserRecoverableError(n);
    }
    
    @Deprecated
    public static boolean showErrorDialogFragment(final int n, final Activity activity, final int n2) {
        return showErrorDialogFragment(n, activity, n2, null);
    }
    
    @Deprecated
    public static boolean showErrorDialogFragment(final int n, final Activity activity, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        return showErrorDialogFragment(n, activity, null, n2, dialogInterface$OnCancelListener);
    }
    
    public static boolean showErrorDialogFragment(final int n, final Activity activity, final Fragment fragment, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        int n3 = n;
        if (zzo.zze((Context)activity, n)) {
            n3 = 18;
        }
        final GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (fragment == null) {
            return instance.showErrorDialogFragment(activity, n3, n2, dialogInterface$OnCancelListener);
        }
        GoogleApiAvailability.getInstance();
        final Dialog zza = GoogleApiAvailability.zza((Context)activity, n3, zzt.zza(fragment, zze.zza((Context)activity, n3, "d"), n2), dialogInterface$OnCancelListener);
        if (zza == null) {
            return false;
        }
        GoogleApiAvailability.zza(activity, zza, "GooglePlayServicesErrorDialog", dialogInterface$OnCancelListener);
        return true;
    }
    
    @Deprecated
    public static void showErrorNotification(final int n, final Context context) {
        final GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
        if (zzo.zze(context, n) || (n == 9 && zzo.zzy(context, "com.android.vending"))) {
            instance.zzar(context);
            return;
        }
        instance.showErrorNotification(context, n);
    }
}
