package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGRankingData;", "", "kind", "", "type", "data", "", "Ljp/reifrontier/gym/domain/api/RFGUserData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "getKind", "()Ljava/lang/String;", "setKind", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGRankingData */
public final class RFGRankingData {
    @SerializedName("ranking")
    private List<RFGUserData> data;
    @SerializedName("kind")
    private String kind;
    @SerializedName("type")
    private String type;

    public RFGRankingData() {
        this((String) null, (String) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public RFGRankingData(String str, String str2, List<RFGUserData> list) {
        Intrinsics.checkParameterIsNotNull(str, "kind");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Intrinsics.checkParameterIsNotNull(list, "data");
        this.kind = str;
        this.type = str2;
        this.data = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGRankingData(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list);
    }

    public static /* synthetic */ RFGRankingData copy$default(RFGRankingData rFGRankingData, String str, String str2, List<RFGUserData> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGRankingData.kind;
        }
        if ((i & 2) != 0) {
            str2 = rFGRankingData.type;
        }
        if ((i & 4) != 0) {
            list = rFGRankingData.data;
        }
        return rFGRankingData.copy(str, str2, list);
    }

    public final String component1() {
        return this.kind;
    }

    public final String component2() {
        return this.type;
    }

    public final List<RFGUserData> component3() {
        return this.data;
    }

    public final RFGRankingData copy(String str, String str2, List<RFGUserData> list) {
        Intrinsics.checkParameterIsNotNull(str, "kind");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Intrinsics.checkParameterIsNotNull(list, "data");
        return new RFGRankingData(str, str2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGRankingData)) {
            return false;
        }
        RFGRankingData rFGRankingData = (RFGRankingData) obj;
        return Intrinsics.areEqual((Object) this.kind, (Object) rFGRankingData.kind) && Intrinsics.areEqual((Object) this.type, (Object) rFGRankingData.type) && Intrinsics.areEqual((Object) this.data, (Object) rFGRankingData.data);
    }

    public final List<RFGUserData> getData() {
        return this.data;
    }

    public final String getKind() {
        return this.kind;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.kind;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<RFGUserData> list = this.data;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    public final void setData(List<RFGUserData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.data = list;
    }

    public final void setKind(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.kind = str;
    }

    public final void setType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.type = str;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGRankingData(kind=");
        a.append(this.kind);
        a.append(", type=");
        a.append(this.type);
        a.append(", data=");
        return C0681a.m325a(a, (List) this.data, ")");
    }
}
