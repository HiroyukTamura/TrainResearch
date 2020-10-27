package p043jp.reifrontier.gym.domain.silentlog;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/silentlog/RFGDaily;", "", "date", "", "segments", "", "Ljp/reifrontier/gym/domain/silentlog/RFGSegment;", "(Ljava/lang/String;Ljava/util/List;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getSegments", "()Ljava/util/List;", "setSegments", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.silentlog.RFGDaily */
public final class RFGDaily {
    @SerializedName("date")
    private String date;
    @SerializedName("segments")
    private List<RFGSegment> segments;

    public RFGDaily(String str, List<RFGSegment> list) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        Intrinsics.checkParameterIsNotNull(list, "segments");
        this.date = str;
        this.segments = list;
    }

    public static /* synthetic */ RFGDaily copy$default(RFGDaily rFGDaily, String str, List<RFGSegment> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGDaily.date;
        }
        if ((i & 2) != 0) {
            list = rFGDaily.segments;
        }
        return rFGDaily.copy(str, list);
    }

    public final String component1() {
        return this.date;
    }

    public final List<RFGSegment> component2() {
        return this.segments;
    }

    public final RFGDaily copy(String str, List<RFGSegment> list) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        Intrinsics.checkParameterIsNotNull(list, "segments");
        return new RFGDaily(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGDaily)) {
            return false;
        }
        RFGDaily rFGDaily = (RFGDaily) obj;
        return Intrinsics.areEqual((Object) this.date, (Object) rFGDaily.date) && Intrinsics.areEqual((Object) this.segments, (Object) rFGDaily.segments);
    }

    public final String getDate() {
        return this.date;
    }

    public final List<RFGSegment> getSegments() {
        return this.segments;
    }

    public int hashCode() {
        String str = this.date;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<RFGSegment> list = this.segments;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public final void setDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.date = str;
    }

    public final void setSegments(List<RFGSegment> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.segments = list;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGDaily(date=");
        a.append(this.date);
        a.append(", segments=");
        return C0681a.m325a(a, (List) this.segments, ")");
    }
}
