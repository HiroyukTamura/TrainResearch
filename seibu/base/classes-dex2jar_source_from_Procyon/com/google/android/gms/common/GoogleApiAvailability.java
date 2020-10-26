// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import android.os.Message;
import android.os.Looper;
import android.annotation.SuppressLint;
import android.os.Handler;
import com.google.android.gms.common.api.GoogleApiActivity;
import android.support.annotation.NonNull;
import com.google.android.gms.internal.zzbdt;
import android.support.annotation.MainThread;
import com.google.android.gms.internal.zzbeb;
import com.google.android.gms.tasks.Tasks;
import com.google.android.gms.tasks.Task;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.res.Resources;
import android.util.Log;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import com.google.android.gms.R;
import android.app.Notification$Style;
import android.app.Notification$BigTextStyle;
import android.app.Notification$Builder;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.common.util.zzj;
import android.app.PendingIntent;
import android.support.v4.app.FragmentActivity;
import android.support.annotation.Nullable;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.google.android.gms.internal.zzbdk;
import com.google.android.gms.internal.zzbdl;
import android.util.TypedValue;
import com.google.android.gms.common.internal.zzt;
import android.app.AlertDialog;
import android.content.DialogInterface$OnClickListener;
import com.google.android.gms.common.internal.zzs;
import android.view.View;
import android.app.AlertDialog$Builder;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.ProgressBar;
import android.app.Dialog;
import android.content.DialogInterface$OnCancelListener;
import android.app.Activity;

public class GoogleApiAvailability extends zze
{
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final GoogleApiAvailability zzaAa;
    
    static {
        zzaAa = new GoogleApiAvailability();
        GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
    
    GoogleApiAvailability() {
    }
    
    public static GoogleApiAvailability getInstance() {
        return GoogleApiAvailability.zzaAa;
    }
    
    public static Dialog zza(final Activity activity, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        final ProgressBar view = new ProgressBar((Context)activity, (AttributeSet)null, 16842874);
        view.setIndeterminate(true);
        view.setVisibility(0);
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)activity);
        alertDialog$Builder.setView((View)view);
        alertDialog$Builder.setMessage((CharSequence)zzs.zzi((Context)activity, 18));
        alertDialog$Builder.setPositiveButton((CharSequence)"", (DialogInterface$OnClickListener)null);
        final AlertDialog create = alertDialog$Builder.create();
        zza(activity, (Dialog)create, "GooglePlayServicesUpdatingDialog", dialogInterface$OnCancelListener);
        return (Dialog)create;
    }
    
    static Dialog zza(final Context context, final int n, final zzt zzt, final DialogInterface$OnCancelListener onCancelListener) {
        AlertDialog$Builder alertDialog$Builder = null;
        if (n == 0) {
            return null;
        }
        final TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            alertDialog$Builder = new AlertDialog$Builder(context, 5);
        }
        AlertDialog$Builder alertDialog$Builder2;
        if ((alertDialog$Builder2 = alertDialog$Builder) == null) {
            alertDialog$Builder2 = new AlertDialog$Builder(context);
        }
        alertDialog$Builder2.setMessage((CharSequence)zzs.zzi(context, n));
        if (onCancelListener != null) {
            alertDialog$Builder2.setOnCancelListener(onCancelListener);
        }
        final String zzk = zzs.zzk(context, n);
        if (zzk != null) {
            alertDialog$Builder2.setPositiveButton((CharSequence)zzk, (DialogInterface$OnClickListener)zzt);
        }
        final String zzg = zzs.zzg(context, n);
        if (zzg != null) {
            alertDialog$Builder2.setTitle((CharSequence)zzg);
        }
        return (Dialog)alertDialog$Builder2.create();
    }
    
    @Nullable
    public static zzbdk zza(final Context context, final zzbdl zzbdl) {
        final IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        final zzbdk zzbdk = new zzbdk(zzbdl);
        context.registerReceiver((BroadcastReceiver)zzbdk, intentFilter);
        zzbdk.setContext(context);
        zzbdk zzbdk2 = zzbdk;
        if (!zzo.zzy(context, "com.google.android.gms")) {
            zzbdl.zzpA();
            zzbdk.unregister();
            zzbdk2 = null;
        }
        return zzbdk2;
    }
    
    static void zza(final Activity activity, final Dialog dialog, final String s, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.newInstance(dialog, dialogInterface$OnCancelListener).show(((FragmentActivity)activity).getSupportFragmentManager(), s);
            return;
        }
        ErrorDialogFragment.newInstance(dialog, dialogInterface$OnCancelListener).show(activity.getFragmentManager(), s);
    }
    
    @TargetApi(20)
    private final void zza(final Context context, int n, String zzh, final PendingIntent contentIntent) {
        if (n == 18) {
            this.zzar(context);
        }
        else {
            if (contentIntent != null) {
                zzh = zzs.zzh(context, n);
                final String zzj = zzs.zzj(context, n);
                final Resources resources = context.getResources();
                Notification notification;
                if (com.google.android.gms.common.util.zzj.zzaH(context)) {
                    zzbo.zzae(zzq.zzsd());
                    notification = new Notification$Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle((CharSequence)zzh).setStyle((Notification$Style)new Notification$BigTextStyle().bigText((CharSequence)zzj)).addAction(R.drawable.common_full_open_on_phone, (CharSequence)resources.getString(R.string.common_open_on_phone), contentIntent).build();
                }
                else {
                    notification = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(resources.getString(R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(contentIntent).setContentTitle(zzh).setContentText(zzj).setLocalOnly(true).setStyle(new NotificationCompat.BigTextStyle().bigText(zzj)).build();
                }
                switch (n) {
                    default: {
                        n = 39789;
                        break;
                    }
                    case 1:
                    case 2:
                    case 3: {
                        zzo.zzaAs.set(false);
                        n = 10436;
                        break;
                    }
                }
                ((NotificationManager)context.getSystemService("notification")).notify(n, notification);
                return;
            }
            if (n == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
        }
    }
    
    public Dialog getErrorDialog(final Activity activity, final int n, final int n2) {
        return this.getErrorDialog(activity, n, n2, null);
    }
    
    public Dialog getErrorDialog(final Activity activity, final int n, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        return zza((Context)activity, n, zzt.zza(activity, zze.zza((Context)activity, n, "d"), n2), dialogInterface$OnCancelListener);
    }
    
    @Nullable
    @Override
    public PendingIntent getErrorResolutionPendingIntent(final Context context, final int n, final int n2) {
        return super.getErrorResolutionPendingIntent(context, n, n2);
    }
    
    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(final Context context, final ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            return connectionResult.getResolution();
        }
        return this.getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
    }
    
    @Override
    public final String getErrorString(final int n) {
        return super.getErrorString(n);
    }
    
    @Nullable
    @Override
    public String getOpenSourceSoftwareLicenseInfo(final Context context) {
        return super.getOpenSourceSoftwareLicenseInfo(context);
    }
    
    @Override
    public int isGooglePlayServicesAvailable(final Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }
    
    @Override
    public final boolean isUserResolvableError(final int n) {
        return super.isUserResolvableError(n);
    }
    
    @MainThread
    public Task<Void> makeGooglePlayServicesAvailable(final Activity activity) {
        zzbo.zzcz("makeGooglePlayServicesAvailable must be called from the main thread");
        final int googlePlayServicesAvailable = this.isGooglePlayServicesAvailable((Context)activity);
        if (googlePlayServicesAvailable == 0) {
            return Tasks.forResult((Void)null);
        }
        final zzbeb zzp = zzbeb.zzp(activity);
        zzp.zzb(new ConnectionResult(googlePlayServicesAvailable, null), 0);
        return zzp.getTask();
    }
    
    public boolean showErrorDialogFragment(final Activity activity, final int n, final int n2) {
        return this.showErrorDialogFragment(activity, n, n2, null);
    }
    
    public boolean showErrorDialogFragment(final Activity activity, final int n, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        final Dialog errorDialog = this.getErrorDialog(activity, n, n2, dialogInterface$OnCancelListener);
        if (errorDialog == null) {
            return false;
        }
        zza(activity, errorDialog, "GooglePlayServicesErrorDialog", dialogInterface$OnCancelListener);
        return true;
    }
    
    public void showErrorNotification(final Context context, final int n) {
        this.zza(context, n, null, this.zza(context, n, 0, "n"));
    }
    
    public void showErrorNotification(final Context context, final ConnectionResult connectionResult) {
        this.zza(context, connectionResult.getErrorCode(), null, this.getErrorResolutionPendingIntent(context, connectionResult));
    }
    
    public final boolean zza(final Activity activity, @NonNull final zzbdt zzbdt, final int n, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        final Dialog zza = zza((Context)activity, n, zzt.zza(zzbdt, zze.zza((Context)activity, n, "d"), 2), dialogInterface$OnCancelListener);
        if (zza == null) {
            return false;
        }
        zza(activity, zza, "GooglePlayServicesErrorDialog", dialogInterface$OnCancelListener);
        return true;
    }
    
    public final boolean zza(final Context context, final ConnectionResult connectionResult, final int n) {
        final PendingIntent errorResolutionPendingIntent = this.getErrorResolutionPendingIntent(context, connectionResult);
        if (errorResolutionPendingIntent != null) {
            this.zza(context, connectionResult.getErrorCode(), null, GoogleApiActivity.zza(context, errorResolutionPendingIntent, n));
            return true;
        }
        return false;
    }
    
    final void zzar(final Context context) {
        new zza(context).sendEmptyMessageDelayed(1, 120000L);
    }
    
    @SuppressLint({ "HandlerLeak" })
    final class zza extends Handler
    {
        private final Context mApplicationContext;
        
        public zza(final Context context) {
            Looper looper;
            if (Looper.myLooper() == null) {
                looper = Looper.getMainLooper();
            }
            else {
                looper = Looper.myLooper();
            }
            super(looper);
            this.mApplicationContext = context.getApplicationContext();
        }
        
        public final void handleMessage(final Message message) {
            switch (message.what) {
                default: {
                    Log.w("GoogleApiAvailability", new StringBuilder(50).append("Don't know how to handle this message: ").append(message.what).toString());
                    break;
                }
                case 1: {
                    final int googlePlayServicesAvailable = GoogleApiAvailability.this.isGooglePlayServicesAvailable(this.mApplicationContext);
                    if (GoogleApiAvailability.this.isUserResolvableError(googlePlayServicesAvailable)) {
                        GoogleApiAvailability.this.showErrorNotification(this.mApplicationContext, googlePlayServicesAvailable);
                        return;
                    }
                    break;
                }
            }
        }
    }
}
