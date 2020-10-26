// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

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
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class Status extends zza implements Result, ReflectedParcelable
{
    public static final Parcelable$Creator<Status> CREATOR;
    public static final Status zzaBm;
    public static final Status zzaBn;
    public static final Status zzaBo;
    public static final Status zzaBp;
    public static final Status zzaBq;
    private static Status zzaBr;
    private static Status zzaBs;
    private final PendingIntent mPendingIntent;
    private int zzaku;
    private final int zzaxu;
    private final String zzazY;
    
    static {
        zzaBm = new Status(0);
        zzaBn = new Status(14);
        zzaBo = new Status(8);
        zzaBp = new Status(15);
        zzaBq = new Status(16);
        Status.zzaBr = new Status(17);
        Status.zzaBs = new Status(18);
        CREATOR = (Parcelable$Creator)new zzf();
    }
    
    public Status(final int n) {
        this(n, null);
    }
    
    Status(final int zzaku, final int zzaxu, final String zzazY, final PendingIntent mPendingIntent) {
        this.zzaku = zzaku;
        this.zzaxu = zzaxu;
        this.zzazY = zzazY;
        this.mPendingIntent = mPendingIntent;
    }
    
    public Status(final int n, final String s) {
        this(1, n, s, null);
    }
    
    public Status(final int n, final String s, final PendingIntent pendingIntent) {
        this(1, n, s, pendingIntent);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o instanceof Status) {
            final Status status = (Status)o;
            if (this.zzaku == status.zzaku && this.zzaxu == status.zzaxu && zzbe.equal(this.zzazY, status.zzazY) && zzbe.equal(this.mPendingIntent, status.mPendingIntent)) {
                return true;
            }
        }
        return false;
    }
    
    public final PendingIntent getResolution() {
        return this.mPendingIntent;
    }
    
    @Override
    public final Status getStatus() {
        return this;
    }
    
    public final int getStatusCode() {
        return this.zzaxu;
    }
    
    @Nullable
    public final String getStatusMessage() {
        return this.zzazY;
    }
    
    public final boolean hasResolution() {
        return this.mPendingIntent != null;
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.zzaku, this.zzaxu, this.zzazY, this.mPendingIntent });
    }
    
    public final boolean isCanceled() {
        return this.zzaxu == 16;
    }
    
    public final boolean isInterrupted() {
        return this.zzaxu == 14;
    }
    
    public final boolean isSuccess() {
        return this.zzaxu <= 0;
    }
    
    public final void startResolutionForResult(final Activity activity, final int n) throws IntentSender$SendIntentException {
        if (!this.hasResolution()) {
            return;
        }
        activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), n, (Intent)null, 0, 0, 0);
    }
    
    @Override
    public final String toString() {
        return zzbe.zzt(this).zzg("statusCode", this.zzpq()).zzg("resolution", this.mPendingIntent).toString();
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.getStatusCode());
        zzd.zza(parcel, 2, this.getStatusMessage(), false);
        zzd.zza(parcel, 3, (Parcelable)this.mPendingIntent, n, false);
        zzd.zzc(parcel, 1000, this.zzaku);
        zzd.zzI(parcel, zze);
    }
    
    public final String zzpq() {
        if (this.zzazY != null) {
            return this.zzazY;
        }
        return CommonStatusCodes.getStatusCodeString(this.zzaxu);
    }
}
