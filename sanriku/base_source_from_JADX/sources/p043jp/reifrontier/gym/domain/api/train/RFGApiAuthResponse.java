package p043jp.reifrontier.gym.domain.api.train;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/train/RFGApiAuthResponse;", "", "result", "", "token", "(Ljava/lang/String;Ljava/lang/String;)V", "getResult", "()Ljava/lang/String;", "getToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.train.RFGApiAuthResponse */
public final class RFGApiAuthResponse {
    @SerializedName("result")
    private final String result;
    @SerializedName("token")
    private final String token;

    public RFGApiAuthResponse(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str2, "token");
        this.result = str;
        this.token = str2;
    }

    public static /* synthetic */ RFGApiAuthResponse copy$default(RFGApiAuthResponse rFGApiAuthResponse, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGApiAuthResponse.result;
        }
        if ((i & 2) != 0) {
            str2 = rFGApiAuthResponse.token;
        }
        return rFGApiAuthResponse.copy(str, str2);
    }

    public final String component1() {
        return this.result;
    }

    public final String component2() {
        return this.token;
    }

    public final RFGApiAuthResponse copy(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str2, "token");
        return new RFGApiAuthResponse(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGApiAuthResponse)) {
            return false;
        }
        RFGApiAuthResponse rFGApiAuthResponse = (RFGApiAuthResponse) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) rFGApiAuthResponse.result) && Intrinsics.areEqual((Object) this.token, (Object) rFGApiAuthResponse.token);
    }

    public final String getResult() {
        return this.result;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.result;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.token;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGApiAuthResponse(result=");
        a.append(this.result);
        a.append(", token=");
        return C0681a.m324a(a, this.token, ")");
    }
}
