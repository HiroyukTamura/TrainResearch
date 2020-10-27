package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInConfigurationCreator")
@SafeParcelable.Reserved({1})
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzx();
    @SafeParcelable.Field(getter = "getConsumerPkgName", mo11969id = 2)
    private final String zzcm;
    @SafeParcelable.Field(getter = "getGoogleConfig", mo11969id = 5)
    private GoogleSignInOptions zzcn;

    @SafeParcelable.Constructor
    public SignInConfiguration(@SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 5) GoogleSignInOptions googleSignInOptions) {
        this.zzcm = Preconditions.checkNotEmpty(str);
        this.zzcn = googleSignInOptions;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.zzcm.equals(signInConfiguration.zzcm)) {
            GoogleSignInOptions googleSignInOptions = this.zzcn;
            GoogleSignInOptions googleSignInOptions2 = signInConfiguration.zzcn;
            if (googleSignInOptions == null) {
                if (googleSignInOptions2 == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(googleSignInOptions2)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new HashAccumulator().addObject(this.zzcm).addObject(this.zzcn).hash();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzcm, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzcn, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final GoogleSignInOptions zzo() {
        return this.zzcn;
    }
}
