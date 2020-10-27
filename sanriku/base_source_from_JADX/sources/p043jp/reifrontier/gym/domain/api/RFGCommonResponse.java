package p043jp.reifrontier.gym.domain.api;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGCommonResponse;", "", "success", "", "error", "(Ljava/lang/String;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "getSuccess", "setSuccess", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGCommonResponse */
public final class RFGCommonResponse {
    @SerializedName("error")
    private String error;
    @SerializedName("success")
    private String success;

    public RFGCommonResponse() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public RFGCommonResponse(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, FirebaseAnalytics.Param.SUCCESS);
        Intrinsics.checkParameterIsNotNull(str2, "error");
        this.success = str;
        this.error = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGCommonResponse(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public static /* synthetic */ RFGCommonResponse copy$default(RFGCommonResponse rFGCommonResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGCommonResponse.success;
        }
        if ((i & 2) != 0) {
            str2 = rFGCommonResponse.error;
        }
        return rFGCommonResponse.copy(str, str2);
    }

    public final String component1() {
        return this.success;
    }

    public final String component2() {
        return this.error;
    }

    public final RFGCommonResponse copy(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, FirebaseAnalytics.Param.SUCCESS);
        Intrinsics.checkParameterIsNotNull(str2, "error");
        return new RFGCommonResponse(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGCommonResponse)) {
            return false;
        }
        RFGCommonResponse rFGCommonResponse = (RFGCommonResponse) obj;
        return Intrinsics.areEqual((Object) this.success, (Object) rFGCommonResponse.success) && Intrinsics.areEqual((Object) this.error, (Object) rFGCommonResponse.error);
    }

    public final String getError() {
        return this.error;
    }

    public final String getSuccess() {
        return this.success;
    }

    public int hashCode() {
        String str = this.success;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.error;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public final void setError(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.error = str;
    }

    public final void setSuccess(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.success = str;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGCommonResponse(success=");
        a.append(this.success);
        a.append(", error=");
        return C0681a.m324a(a, this.error, ")");
    }
}
