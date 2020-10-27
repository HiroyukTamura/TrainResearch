package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUpdateResult;", "", "email", "", "userId", "id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getId", "getUserId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGUpdateResult */
public final class RFGUpdateResult {
    @SerializedName("email")
    private final String email;
    @SerializedName("id")

    /* renamed from: id */
    private final String f2963id;
    @SerializedName("userId")
    private final String userId;

    public RFGUpdateResult(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, "id");
        this.email = str;
        this.userId = str2;
        this.f2963id = str3;
    }

    public static /* synthetic */ RFGUpdateResult copy$default(RFGUpdateResult rFGUpdateResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGUpdateResult.email;
        }
        if ((i & 2) != 0) {
            str2 = rFGUpdateResult.userId;
        }
        if ((i & 4) != 0) {
            str3 = rFGUpdateResult.f2963id;
        }
        return rFGUpdateResult.copy(str, str2, str3);
    }

    public final String component1() {
        return this.email;
    }

    public final String component2() {
        return this.userId;
    }

    public final String component3() {
        return this.f2963id;
    }

    public final RFGUpdateResult copy(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        Intrinsics.checkParameterIsNotNull(str2, "userId");
        Intrinsics.checkParameterIsNotNull(str3, "id");
        return new RFGUpdateResult(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGUpdateResult)) {
            return false;
        }
        RFGUpdateResult rFGUpdateResult = (RFGUpdateResult) obj;
        return Intrinsics.areEqual((Object) this.email, (Object) rFGUpdateResult.email) && Intrinsics.areEqual((Object) this.userId, (Object) rFGUpdateResult.userId) && Intrinsics.areEqual((Object) this.f2963id, (Object) rFGUpdateResult.f2963id);
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getId() {
        return this.f2963id;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.email;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2963id;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGUpdateResult(email=");
        a.append(this.email);
        a.append(", userId=");
        a.append(this.userId);
        a.append(", id=");
        return C0681a.m324a(a, this.f2963id, ")");
    }
}
