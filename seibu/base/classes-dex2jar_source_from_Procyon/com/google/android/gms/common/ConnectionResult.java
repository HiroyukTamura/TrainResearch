// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import android.content.IntentSender$SendIntentException;
import android.content.Intent;
import android.app.Activity;
import java.util.Arrays;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbe;
import android.app.PendingIntent;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class ConnectionResult extends zza
{
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final Parcelable$Creator<ConnectionResult> CREATOR;
    public static final int DEVELOPER_ERROR = 10;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final ConnectionResult zzazX;
    private final PendingIntent mPendingIntent;
    private int zzaku;
    private final int zzaxu;
    private final String zzazY;
    
    static {
        zzazX = new ConnectionResult(0);
        CREATOR = (Parcelable$Creator)new zzb();
    }
    
    public ConnectionResult(final int n) {
        this(n, null, null);
    }
    
    ConnectionResult(final int zzaku, final int zzaxu, final PendingIntent mPendingIntent, final String zzazY) {
        this.zzaku = zzaku;
        this.zzaxu = zzaxu;
        this.mPendingIntent = mPendingIntent;
        this.zzazY = zzazY;
    }
    
    public ConnectionResult(final int n, final PendingIntent pendingIntent) {
        this(n, pendingIntent, null);
    }
    
    public ConnectionResult(final int n, final PendingIntent pendingIntent, final String s) {
        this(1, n, pendingIntent, s);
    }
    
    static String getStatusString(final int i) {
        switch (i) {
            default: {
                return new StringBuilder(31).append("UNKNOWN_ERROR_CODE(").append(i).append(")").toString();
            }
            case 0: {
                return "SUCCESS";
            }
            case 1: {
                return "SERVICE_MISSING";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 9: {
                return "SERVICE_INVALID";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 11: {
                return "LICENSE_CHECK_FAILED";
            }
            case 13: {
                return "CANCELED";
            }
            case 14: {
                return "TIMEOUT";
            }
            case 15: {
                return "INTERRUPTED";
            }
            case 16: {
                return "API_UNAVAILABLE";
            }
            case 17: {
                return "SIGN_IN_FAILED";
            }
            case 18: {
                return "SERVICE_UPDATING";
            }
            case 19: {
                return "SERVICE_MISSING_PERMISSION";
            }
            case 20: {
                return "RESTRICTED_PROFILE";
            }
            case 21: {
                return "API_VERSION_UPDATE_REQUIRED";
            }
            case 1500: {
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            }
            case 99: {
                return "UNFINISHED";
            }
            case -1: {
                return "UNKNOWN";
            }
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof ConnectionResult)) {
                return false;
            }
            final ConnectionResult connectionResult = (ConnectionResult)o;
            if (this.zzaxu != connectionResult.zzaxu || !zzbe.equal(this.mPendingIntent, connectionResult.mPendingIntent) || !zzbe.equal(this.zzazY, connectionResult.zzazY)) {
                return false;
            }
        }
        return true;
    }
    
    public final int getErrorCode() {
        return this.zzaxu;
    }
    
    @Nullable
    public final String getErrorMessage() {
        return this.zzazY;
    }
    
    @Nullable
    public final PendingIntent getResolution() {
        return this.mPendingIntent;
    }
    
    public final boolean hasResolution() {
        return this.zzaxu != 0 && this.mPendingIntent != null;
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.zzaxu, this.mPendingIntent, this.zzazY });
    }
    
    public final boolean isSuccess() {
        return this.zzaxu == 0;
    }
    
    public final void startResolutionForResult(final Activity activity, final int n) throws IntentSender$SendIntentException {
        if (!this.hasResolution()) {
            return;
        }
        activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), n, (Intent)null, 0, 0, 0);
    }
    
    @Override
    public final String toString() {
        return zzbe.zzt(this).zzg("statusCode", getStatusString(this.zzaxu)).zzg("resolution", this.mPendingIntent).zzg("message", this.zzazY).toString();
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zzc(parcel, 2, this.getErrorCode());
        zzd.zza(parcel, 3, (Parcelable)this.getResolution(), n, false);
        zzd.zza(parcel, 4, this.getErrorMessage(), false);
        zzd.zzI(parcel, zze);
    }
}
