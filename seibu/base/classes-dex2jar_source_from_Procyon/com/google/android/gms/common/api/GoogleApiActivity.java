// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.GoogleApiAvailability;
import android.content.IntentSender$SendIntentException;
import android.util.Log;
import android.os.Bundle;
import android.content.DialogInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzbdb;
import android.os.Parcelable;
import android.content.Intent;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.app.Activity;

public class GoogleApiActivity extends Activity implements DialogInterface$OnCancelListener
{
    private int zzaAR;
    
    public GoogleApiActivity() {
        this.zzaAR = 0;
    }
    
    public static PendingIntent zza(final Context context, final PendingIntent pendingIntent, final int n) {
        return PendingIntent.getActivity(context, 0, zza(context, pendingIntent, n, true), 134217728);
    }
    
    public static Intent zza(final Context context, final PendingIntent pendingIntent, final int n, final boolean b) {
        final Intent intent = new Intent(context, (Class)GoogleApiActivity.class);
        intent.putExtra("pending_intent", (Parcelable)pendingIntent);
        intent.putExtra("failing_client_id", n);
        intent.putExtra("notify_manager", b);
        return intent;
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n == 1) {
            final boolean booleanExtra = this.getIntent().getBooleanExtra("notify_manager", true);
            this.zzaAR = 0;
            this.setResult(n2, intent);
            if (booleanExtra) {
                final zzbdb zzay = zzbdb.zzay((Context)this);
                switch (n2) {
                    case 0: {
                        zzay.zza(new ConnectionResult(13, null), this.getIntent().getIntExtra("failing_client_id", -1));
                        break;
                    }
                    case -1: {
                        zzay.zzps();
                        break;
                    }
                }
            }
        }
        else if (n == 2) {
            this.zzaAR = 0;
            this.setResult(n2, intent);
        }
        this.finish();
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
        this.setResult(this.zzaAR = 0);
        this.finish();
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzaAR = bundle.getInt("resolution");
        }
        if (this.zzaAR != 1) {
            final Bundle extras = this.getIntent().getExtras();
            if (extras == null) {
                Log.e("GoogleApiActivity", "Activity started without extras");
                this.finish();
            }
            else {
                final PendingIntent pendingIntent = (PendingIntent)extras.get("pending_intent");
                final Integer n = (Integer)extras.get("error_code");
                if (pendingIntent == null && n == null) {
                    Log.e("GoogleApiActivity", "Activity started without resolution");
                    this.finish();
                    return;
                }
                if (pendingIntent != null) {
                    try {
                        this.startIntentSenderForResult(pendingIntent.getIntentSender(), 1, (Intent)null, 0, 0, 0);
                        this.zzaAR = 1;
                        return;
                    }
                    catch (IntentSender$SendIntentException ex) {
                        Log.e("GoogleApiActivity", "Failed to launch pendingIntent", (Throwable)ex);
                        this.finish();
                        return;
                    }
                }
                GoogleApiAvailability.getInstance().showErrorDialogFragment(this, n, 2, (DialogInterface$OnCancelListener)this);
                this.zzaAR = 1;
            }
        }
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        bundle.putInt("resolution", this.zzaAR);
        super.onSaveInstanceState(bundle);
    }
}
