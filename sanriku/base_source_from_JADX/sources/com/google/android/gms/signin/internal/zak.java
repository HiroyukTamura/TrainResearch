package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInResponseCreator")
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zaj();
    @SafeParcelable.VersionField(mo11975id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getConnectionResult", mo11969id = 2)
    private final ConnectionResult zapo;
    @SafeParcelable.Field(getter = "getResolveAccountResponse", mo11969id = 3)
    @Nullable
    private final ResolveAccountResponse zata;

    public zak(int i) {
        this(new ConnectionResult(8, (PendingIntent) null), (ResolveAccountResponse) null);
    }

    @SafeParcelable.Constructor
    zak(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) ConnectionResult connectionResult, @SafeParcelable.Param(mo11972id = 3) @Nullable ResolveAccountResponse resolveAccountResponse) {
        this.versionCode = i;
        this.zapo = connectionResult;
        this.zata = resolveAccountResponse;
    }

    private zak(ConnectionResult connectionResult, @Nullable ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, (ResolveAccountResponse) null);
    }

    public final ConnectionResult getConnectionResult() {
        return this.zapo;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zapo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zata, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    public final ResolveAccountResponse zacv() {
        return this.zata;
    }
}
