package p043jp.reifrontier.gym.domain.silentlog;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/silentlog/RFGSegment;", "", "activities", "", "Ljp/reifrontier/gym/domain/silentlog/RFGActivity;", "(Ljava/util/List;)V", "getActivities", "()Ljava/util/List;", "setActivities", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.silentlog.RFGSegment */
public final class RFGSegment {
    @SerializedName("activities")
    private List<? extends RFGActivity> activities;

    public RFGSegment(List<? extends RFGActivity> list) {
        Intrinsics.checkParameterIsNotNull(list, "activities");
        this.activities = list;
    }

    public static /* synthetic */ RFGSegment copy$default(RFGSegment rFGSegment, List<? extends RFGActivity> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = rFGSegment.activities;
        }
        return rFGSegment.copy(list);
    }

    public final List<RFGActivity> component1() {
        return this.activities;
    }

    public final RFGSegment copy(List<? extends RFGActivity> list) {
        Intrinsics.checkParameterIsNotNull(list, "activities");
        return new RFGSegment(list);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof RFGSegment) && Intrinsics.areEqual((Object) this.activities, (Object) ((RFGSegment) obj).activities);
        }
        return true;
    }

    public final List<RFGActivity> getActivities() {
        return this.activities;
    }

    public int hashCode() {
        List<? extends RFGActivity> list = this.activities;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public final void setActivities(List<? extends RFGActivity> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.activities = list;
    }

    public String toString() {
        return C0681a.m325a(C0681a.m330a("RFGSegment(activities="), (List) this.activities, ")");
    }
}
