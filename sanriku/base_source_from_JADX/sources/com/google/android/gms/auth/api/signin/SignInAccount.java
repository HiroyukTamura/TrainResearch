package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInAccountCreator")
@SafeParcelable.Reserved({1})
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zzd();
    @SafeParcelable.Field(defaultValue = "", mo11969id = 4)
    @Deprecated
    private String zzbv;
    @SafeParcelable.Field(getter = "getGoogleSignInAccount", mo11969id = 7)
    private GoogleSignInAccount zzbw;
    @SafeParcelable.Field(defaultValue = "", mo11969id = 8)
    @Deprecated
    private String zzbx;

    @SafeParcelable.Constructor
    SignInAccount(@SafeParcelable.Param(mo11972id = 4) String str, @SafeParcelable.Param(mo11972id = 7) GoogleSignInAccount googleSignInAccount, @SafeParcelable.Param(mo11972id = 8) String str2) {
        this.zzbw = googleSignInAccount;
        this.zzbv = Preconditions.checkNotEmpty(str, "8.3 and 8.4 SDKs require non-null email");
        this.zzbx = Preconditions.checkNotEmpty(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzbw;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 4, this.zzbv, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzbw, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzbx, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
