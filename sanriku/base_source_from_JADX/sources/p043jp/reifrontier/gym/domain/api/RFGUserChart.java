package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUserChart;", "", "type", "", "data", "", "Ljp/reifrontier/gym/domain/api/RFGUserChartData;", "(Ljava/lang/String;Ljava/util/List;)V", "getData", "()Ljava/util/List;", "getType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGUserChart */
public final class RFGUserChart {
    @SerializedName("data")
    private final List<RFGUserChartData> data;
    @SerializedName("type")
    private final String type;

    public RFGUserChart(String str, List<RFGUserChartData> list) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(list, "data");
        this.type = str;
        this.data = list;
    }

    public static /* synthetic */ RFGUserChart copy$default(RFGUserChart rFGUserChart, String str, List<RFGUserChartData> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGUserChart.type;
        }
        if ((i & 2) != 0) {
            list = rFGUserChart.data;
        }
        return rFGUserChart.copy(str, list);
    }

    public final String component1() {
        return this.type;
    }

    public final List<RFGUserChartData> component2() {
        return this.data;
    }

    public final RFGUserChart copy(String str, List<RFGUserChartData> list) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        Intrinsics.checkParameterIsNotNull(list, "data");
        return new RFGUserChart(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGUserChart)) {
            return false;
        }
        RFGUserChart rFGUserChart = (RFGUserChart) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) rFGUserChart.type) && Intrinsics.areEqual((Object) this.data, (Object) rFGUserChart.data);
    }

    public final List<RFGUserChartData> getData() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.type;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<RFGUserChartData> list = this.data;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGUserChart(type=");
        a.append(this.type);
        a.append(", data=");
        return C0681a.m325a(a, (List) this.data, ")");
    }
}
