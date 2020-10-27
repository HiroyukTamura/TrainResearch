package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLUserProfile;", "", "gender", "", "birthday", "firstDate", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBirthday", "()Ljava/lang/String;", "getFirstDate", "getGender", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLUserProfile */
public final class RFLUserProfile {
    @SerializedName("gender")

    /* renamed from: a */
    private final String f3510a;
    @SerializedName("birthday")

    /* renamed from: b */
    private final String f3511b;
    @SerializedName("firstDate")

    /* renamed from: c */
    private final String f3512c;

    public RFLUserProfile(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "gender");
        Intrinsics.checkParameterIsNotNull(str2, "birthday");
        Intrinsics.checkParameterIsNotNull(str3, "firstDate");
        this.f3510a = str;
        this.f3511b = str2;
        this.f3512c = str3;
    }

    public static /* synthetic */ RFLUserProfile copy$default(RFLUserProfile rFLUserProfile, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLUserProfile.f3510a;
        }
        if ((i & 2) != 0) {
            str2 = rFLUserProfile.f3511b;
        }
        if ((i & 4) != 0) {
            str3 = rFLUserProfile.f3512c;
        }
        return rFLUserProfile.copy(str, str2, str3);
    }

    public final String component1() {
        return this.f3510a;
    }

    public final String component2() {
        return this.f3511b;
    }

    public final String component3() {
        return this.f3512c;
    }

    public final RFLUserProfile copy(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "gender");
        Intrinsics.checkParameterIsNotNull(str2, "birthday");
        Intrinsics.checkParameterIsNotNull(str3, "firstDate");
        return new RFLUserProfile(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLUserProfile)) {
            return false;
        }
        RFLUserProfile rFLUserProfile = (RFLUserProfile) obj;
        return Intrinsics.areEqual((Object) this.f3510a, (Object) rFLUserProfile.f3510a) && Intrinsics.areEqual((Object) this.f3511b, (Object) rFLUserProfile.f3511b) && Intrinsics.areEqual((Object) this.f3512c, (Object) rFLUserProfile.f3512c);
    }

    public final String getBirthday() {
        return this.f3511b;
    }

    public final String getFirstDate() {
        return this.f3512c;
    }

    public final String getGender() {
        return this.f3510a;
    }

    public int hashCode() {
        String str = this.f3510a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3511b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3512c;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLUserProfile(gender=");
        a.append(this.f3510a);
        a.append(", birthday=");
        a.append(this.f3511b);
        a.append(", firstDate=");
        return C0681a.m324a(a, this.f3512c, ")");
    }
}
