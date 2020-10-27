package p043jp.reifrontier.gym.domain.app;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.domain.api.RFGPanelData;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/app/RFGAdapterPoint;", "", "list", "", "Ljp/reifrontier/gym/domain/api/RFGPanelData;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.app.RFGAdapterPoint */
public final class RFGAdapterPoint {
    private final List<RFGPanelData> list;

    public RFGAdapterPoint(List<? extends RFGPanelData> list2) {
        Intrinsics.checkParameterIsNotNull(list2, "list");
        this.list = list2;
    }

    public static /* synthetic */ RFGAdapterPoint copy$default(RFGAdapterPoint rFGAdapterPoint, List<RFGPanelData> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list2 = rFGAdapterPoint.list;
        }
        return rFGAdapterPoint.copy(list2);
    }

    public final List<RFGPanelData> component1() {
        return this.list;
    }

    public final RFGAdapterPoint copy(List<? extends RFGPanelData> list2) {
        Intrinsics.checkParameterIsNotNull(list2, "list");
        return new RFGAdapterPoint(list2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RFGAdapterPoint) && Intrinsics.areEqual((Object) this.list, (Object) ((RFGAdapterPoint) obj).list);
        }
        return true;
    }

    public final List<RFGPanelData> getList() {
        return this.list;
    }

    public int hashCode() {
        List<RFGPanelData> list2 = this.list;
        if (list2 != null) {
            return list2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return C0681a.m325a(C0681a.m330a("RFGAdapterPoint(list="), (List) this.list, ")");
    }
}
