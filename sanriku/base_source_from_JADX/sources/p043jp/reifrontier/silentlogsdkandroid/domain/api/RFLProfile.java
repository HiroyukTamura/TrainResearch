package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import com.google.android.gms.common.Scopes;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLProfile;", "", "username", "", "userId", "profile", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLUserProfile;", "private", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLPrivate;", "extra", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLExtra;", "(Ljava/lang/String;Ljava/lang/String;Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLUserProfile;Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLPrivate;Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLExtra;)V", "getExtra", "()Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLExtra;", "getPrivate", "()Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLPrivate;", "getProfile", "()Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLUserProfile;", "getUserId", "()Ljava/lang/String;", "getUsername", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLProfile */
public final class RFLProfile {
    @SerializedName("username")

    /* renamed from: a */
    private final String f3503a;
    @SerializedName("userId")

    /* renamed from: b */
    private final String f3504b;
    @SerializedName("profile")

    /* renamed from: c */
    private final RFLUserProfile f3505c;
    @SerializedName("private")

    /* renamed from: d */
    private final RFLPrivate f3506d;
    @SerializedName("extra")

    /* renamed from: e */
    private final RFLExtra f3507e;

    public RFLProfile(String str, String str2, RFLUserProfile rFLUserProfile, RFLPrivate rFLPrivate, RFLExtra rFLExtra) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(rFLUserProfile, Scopes.PROFILE);
        Intrinsics.checkParameterIsNotNull(rFLPrivate, "private");
        this.f3503a = str;
        this.f3504b = str2;
        this.f3505c = rFLUserProfile;
        this.f3506d = rFLPrivate;
        this.f3507e = rFLExtra;
    }

    public static /* synthetic */ RFLProfile copy$default(RFLProfile rFLProfile, String str, String str2, RFLUserProfile rFLUserProfile, RFLPrivate rFLPrivate, RFLExtra rFLExtra, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLProfile.f3503a;
        }
        if ((i & 2) != 0) {
            str2 = rFLProfile.f3504b;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            rFLUserProfile = rFLProfile.f3505c;
        }
        RFLUserProfile rFLUserProfile2 = rFLUserProfile;
        if ((i & 8) != 0) {
            rFLPrivate = rFLProfile.f3506d;
        }
        RFLPrivate rFLPrivate2 = rFLPrivate;
        if ((i & 16) != 0) {
            rFLExtra = rFLProfile.f3507e;
        }
        return rFLProfile.copy(str, str3, rFLUserProfile2, rFLPrivate2, rFLExtra);
    }

    public final String component1() {
        return this.f3503a;
    }

    public final String component2() {
        return this.f3504b;
    }

    public final RFLUserProfile component3() {
        return this.f3505c;
    }

    public final RFLPrivate component4() {
        return this.f3506d;
    }

    public final RFLExtra component5() {
        return this.f3507e;
    }

    public final RFLProfile copy(String str, String str2, RFLUserProfile rFLUserProfile, RFLPrivate rFLPrivate, RFLExtra rFLExtra) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(rFLUserProfile, Scopes.PROFILE);
        Intrinsics.checkParameterIsNotNull(rFLPrivate, "private");
        return new RFLProfile(str, str2, rFLUserProfile, rFLPrivate, rFLExtra);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLProfile)) {
            return false;
        }
        RFLProfile rFLProfile = (RFLProfile) obj;
        return Intrinsics.areEqual((Object) this.f3503a, (Object) rFLProfile.f3503a) && Intrinsics.areEqual((Object) this.f3504b, (Object) rFLProfile.f3504b) && Intrinsics.areEqual((Object) this.f3505c, (Object) rFLProfile.f3505c) && Intrinsics.areEqual((Object) this.f3506d, (Object) rFLProfile.f3506d) && Intrinsics.areEqual((Object) this.f3507e, (Object) rFLProfile.f3507e);
    }

    public final RFLExtra getExtra() {
        return this.f3507e;
    }

    public final RFLPrivate getPrivate() {
        return this.f3506d;
    }

    public final RFLUserProfile getProfile() {
        return this.f3505c;
    }

    public final String getUserId() {
        return this.f3504b;
    }

    public final String getUsername() {
        return this.f3503a;
    }

    public int hashCode() {
        String str = this.f3503a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3504b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        RFLUserProfile rFLUserProfile = this.f3505c;
        int hashCode3 = (hashCode2 + (rFLUserProfile != null ? rFLUserProfile.hashCode() : 0)) * 31;
        RFLPrivate rFLPrivate = this.f3506d;
        int hashCode4 = (hashCode3 + (rFLPrivate != null ? rFLPrivate.hashCode() : 0)) * 31;
        RFLExtra rFLExtra = this.f3507e;
        if (rFLExtra != null) {
            i = rFLExtra.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLProfile(username=");
        a.append(this.f3503a);
        a.append(", userId=");
        a.append(this.f3504b);
        a.append(", profile=");
        a.append(this.f3505c);
        a.append(", private=");
        a.append(this.f3506d);
        a.append(", extra=");
        a.append(this.f3507e);
        a.append(")");
        return a.toString();
    }
}
