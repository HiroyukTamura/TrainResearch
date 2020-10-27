package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGRewardUserList;", "", "requestIds", "", "(Ljava/lang/String;)V", "requestIdList", "", "getRequestIdList", "()Ljava/util/List;", "getRequestIds", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGRewardUserList */
public final class RFGRewardUserList {
    @SerializedName("request_ids")
    private final String requestIds;

    public RFGRewardUserList(String str) {
        Intrinsics.checkParameterIsNotNull(str, "requestIds");
        this.requestIds = str;
    }

    public static /* synthetic */ RFGRewardUserList copy$default(RFGRewardUserList rFGRewardUserList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGRewardUserList.requestIds;
        }
        return rFGRewardUserList.copy(str);
    }

    public final String component1() {
        return this.requestIds;
    }

    public final RFGRewardUserList copy(String str) {
        Intrinsics.checkParameterIsNotNull(str, "requestIds");
        return new RFGRewardUserList(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RFGRewardUserList) && Intrinsics.areEqual((Object) this.requestIds, (Object) ((RFGRewardUserList) obj).requestIds);
        }
        return true;
    }

    public final List<String> getRequestIdList() {
        return StringsKt__StringsKt.split$default((CharSequence) this.requestIds, new String[]{","}, false, 0, 6, (Object) null);
    }

    public final String getRequestIds() {
        return this.requestIds;
    }

    public int hashCode() {
        String str = this.requestIds;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C0681a.m324a(C0681a.m330a("RFGRewardUserList(requestIds="), this.requestIds, ")");
    }
}
