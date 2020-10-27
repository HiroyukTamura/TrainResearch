package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGResponse;", "", "success", "Ljp/reifrontier/gym/domain/api/RFGResponseDetail;", "faild", "error", "result", "", "(Ljp/reifrontier/gym/domain/api/RFGResponseDetail;Ljp/reifrontier/gym/domain/api/RFGResponseDetail;Ljp/reifrontier/gym/domain/api/RFGResponseDetail;Ljava/lang/String;)V", "getError", "()Ljp/reifrontier/gym/domain/api/RFGResponseDetail;", "getFaild", "getResult", "()Ljava/lang/String;", "getSuccess", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGResponse */
public final class RFGResponse {
    @SerializedName("error")
    private final RFGResponseDetail error;
    @SerializedName("faild")
    private final RFGResponseDetail faild;
    @SerializedName("result")
    private final String result;
    @SerializedName("success")
    private final RFGResponseDetail success;

    public RFGResponse(RFGResponseDetail rFGResponseDetail, RFGResponseDetail rFGResponseDetail2, RFGResponseDetail rFGResponseDetail3, String str) {
        this.success = rFGResponseDetail;
        this.faild = rFGResponseDetail2;
        this.error = rFGResponseDetail3;
        this.result = str;
    }

    public static /* synthetic */ RFGResponse copy$default(RFGResponse rFGResponse, RFGResponseDetail rFGResponseDetail, RFGResponseDetail rFGResponseDetail2, RFGResponseDetail rFGResponseDetail3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            rFGResponseDetail = rFGResponse.success;
        }
        if ((i & 2) != 0) {
            rFGResponseDetail2 = rFGResponse.faild;
        }
        if ((i & 4) != 0) {
            rFGResponseDetail3 = rFGResponse.error;
        }
        if ((i & 8) != 0) {
            str = rFGResponse.result;
        }
        return rFGResponse.copy(rFGResponseDetail, rFGResponseDetail2, rFGResponseDetail3, str);
    }

    public final RFGResponseDetail component1() {
        return this.success;
    }

    public final RFGResponseDetail component2() {
        return this.faild;
    }

    public final RFGResponseDetail component3() {
        return this.error;
    }

    public final String component4() {
        return this.result;
    }

    public final RFGResponse copy(RFGResponseDetail rFGResponseDetail, RFGResponseDetail rFGResponseDetail2, RFGResponseDetail rFGResponseDetail3, String str) {
        return new RFGResponse(rFGResponseDetail, rFGResponseDetail2, rFGResponseDetail3, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGResponse)) {
            return false;
        }
        RFGResponse rFGResponse = (RFGResponse) obj;
        return Intrinsics.areEqual((Object) this.success, (Object) rFGResponse.success) && Intrinsics.areEqual((Object) this.faild, (Object) rFGResponse.faild) && Intrinsics.areEqual((Object) this.error, (Object) rFGResponse.error) && Intrinsics.areEqual((Object) this.result, (Object) rFGResponse.result);
    }

    public final RFGResponseDetail getError() {
        return this.error;
    }

    public final RFGResponseDetail getFaild() {
        return this.faild;
    }

    public final String getResult() {
        return this.result;
    }

    public final RFGResponseDetail getSuccess() {
        return this.success;
    }

    public int hashCode() {
        RFGResponseDetail rFGResponseDetail = this.success;
        int i = 0;
        int hashCode = (rFGResponseDetail != null ? rFGResponseDetail.hashCode() : 0) * 31;
        RFGResponseDetail rFGResponseDetail2 = this.faild;
        int hashCode2 = (hashCode + (rFGResponseDetail2 != null ? rFGResponseDetail2.hashCode() : 0)) * 31;
        RFGResponseDetail rFGResponseDetail3 = this.error;
        int hashCode3 = (hashCode2 + (rFGResponseDetail3 != null ? rFGResponseDetail3.hashCode() : 0)) * 31;
        String str = this.result;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGResponse(success=");
        a.append(this.success);
        a.append(", faild=");
        a.append(this.faild);
        a.append(", error=");
        a.append(this.error);
        a.append(", result=");
        return C0681a.m324a(a, this.result, ")");
    }
}
