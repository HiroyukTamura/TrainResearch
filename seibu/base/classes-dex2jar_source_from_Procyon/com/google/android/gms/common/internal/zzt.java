// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.content.ActivityNotFoundException;
import android.util.Log;
import android.content.DialogInterface;
import com.google.android.gms.internal.zzbdt;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.app.Activity;
import android.content.DialogInterface$OnClickListener;

public abstract class zzt implements DialogInterface$OnClickListener
{
    public static zzt zza(final Activity activity, final Intent intent, final int n) {
        return new zzu(intent, activity, n);
    }
    
    public static zzt zza(@NonNull final Fragment fragment, final Intent intent, final int n) {
        return new zzv(intent, fragment, n);
    }
    
    public static zzt zza(@NonNull final zzbdt zzbdt, final Intent intent, final int n) {
        return new zzw(intent, zzbdt, 2);
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        try {
            this.zzrv();
        }
        catch (ActivityNotFoundException ex) {
            Log.e("DialogRedirect", "Failed to start resolution intent", (Throwable)ex);
        }
        finally {
            dialogInterface.dismiss();
        }
    }
    
    protected abstract void zzrv();
}
