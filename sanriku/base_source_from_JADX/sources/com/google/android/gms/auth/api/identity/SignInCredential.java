package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInCredentialCreator")
public final class SignInCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInCredential> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getId", mo11969id = 1)
    private final String zzba;
    @SafeParcelable.Field(getter = "getDisplayName", mo11969id = 2)
    @Nullable
    private final String zzbb;
    @SafeParcelable.Field(getter = "getGivenName", mo11969id = 3)
    @Nullable
    private final String zzbc;
    @SafeParcelable.Field(getter = "getFamilyName", mo11969id = 4)
    @Nullable
    private final String zzbd;
    @SafeParcelable.Field(getter = "getProfilePictureUri", mo11969id = 5)
    @Nullable
    private final Uri zzbe;
    @SafeParcelable.Field(getter = "getPassword", mo11969id = 6)
    @Nullable
    private final String zzbf;
    @SafeParcelable.Field(getter = "getGoogleIdToken", mo11969id = 7)
    @Nullable
    private final String zzbg;

    @SafeParcelable.Constructor
    public SignInCredential(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) @Nullable String str2, @SafeParcelable.Param(mo11972id = 3) @Nullable String str3, @SafeParcelable.Param(mo11972id = 4) @Nullable String str4, @SafeParcelable.Param(mo11972id = 5) @Nullable Uri uri, @SafeParcelable.Param(mo11972id = 6) @Nullable String str5, @SafeParcelable.Param(mo11972id = 7) @Nullable String str6) {
        this.zzba = Preconditions.checkNotEmpty(str);
        this.zzbb = str2;
        this.zzbc = str3;
        this.zzbd = str4;
        this.zzbe = uri;
        this.zzbf = str5;
        this.zzbg = str6;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        return Objects.equal(this.zzba, signInCredential.zzba) && Objects.equal(this.zzbb, signInCredential.zzbb) && Objects.equal(this.zzbc, signInCredential.zzbc) && Objects.equal(this.zzbd, signInCredential.zzbd) && Objects.equal(this.zzbe, signInCredential.zzbe) && Objects.equal(this.zzbf, signInCredential.zzbf) && Objects.equal(this.zzbg, signInCredential.zzbg);
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzbb;
    }

    @Nullable
    public final String getFamilyName() {
        return this.zzbd;
    }

    @Nullable
    public final String getGivenName() {
        return this.zzbc;
    }

    @Nullable
    public final String getGoogleIdToken() {
        return this.zzbg;
    }

    public final String getId() {
        return this.zzba;
    }

    @Nullable
    public final String getPassword() {
        return this.zzbf;
    }

    @Nullable
    public final Uri getProfilePictureUri() {
        return this.zzbe;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzba, this.zzbb, this.zzbc, this.zzbd, this.zzbe, this.zzbf, this.zzbg);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 4, getFamilyName(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getProfilePictureUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getPassword(), false);
        SafeParcelWriter.writeString(parcel, 7, getGoogleIdToken(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
