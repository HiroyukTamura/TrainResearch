package p043jp.reifrontier.gym.domain.app;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.domain.api.RFGSummaryHistory;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\nHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/app/RFGAdapterSummary;", "", "dateTitle", "", "date", "Ljava/util/Date;", "list", "", "Ljp/reifrontier/gym/domain/app/RFGAdapterActivity;", "summary", "Ljp/reifrontier/gym/domain/api/RFGSummaryHistory;", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/List;Ljp/reifrontier/gym/domain/api/RFGSummaryHistory;)V", "getDate", "()Ljava/util/Date;", "getDateTitle", "()Ljava/lang/String;", "getList", "()Ljava/util/List;", "getSummary", "()Ljp/reifrontier/gym/domain/api/RFGSummaryHistory;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.app.RFGAdapterSummary */
public final class RFGAdapterSummary {
    private final Date date;
    private final String dateTitle;
    private final List<RFGAdapterActivity> list;
    private final RFGSummaryHistory summary;

    public RFGAdapterSummary(String str, Date date2, List<RFGAdapterActivity> list2, RFGSummaryHistory rFGSummaryHistory) {
        Intrinsics.checkParameterIsNotNull(str, "dateTitle");
        Intrinsics.checkParameterIsNotNull(date2, "date");
        Intrinsics.checkParameterIsNotNull(list2, "list");
        Intrinsics.checkParameterIsNotNull(rFGSummaryHistory, "summary");
        this.dateTitle = str;
        this.date = date2;
        this.list = list2;
        this.summary = rFGSummaryHistory;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFGAdapterSummary(String str, Date date2, List list2, RFGSummaryHistory rFGSummaryHistory, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, date2, (i & 4) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list2, rFGSummaryHistory);
    }

    public static /* synthetic */ RFGAdapterSummary copy$default(RFGAdapterSummary rFGAdapterSummary, String str, Date date2, List<RFGAdapterActivity> list2, RFGSummaryHistory rFGSummaryHistory, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFGAdapterSummary.dateTitle;
        }
        if ((i & 2) != 0) {
            date2 = rFGAdapterSummary.date;
        }
        if ((i & 4) != 0) {
            list2 = rFGAdapterSummary.list;
        }
        if ((i & 8) != 0) {
            rFGSummaryHistory = rFGAdapterSummary.summary;
        }
        return rFGAdapterSummary.copy(str, date2, list2, rFGSummaryHistory);
    }

    public final String component1() {
        return this.dateTitle;
    }

    public final Date component2() {
        return this.date;
    }

    public final List<RFGAdapterActivity> component3() {
        return this.list;
    }

    public final RFGSummaryHistory component4() {
        return this.summary;
    }

    public final RFGAdapterSummary copy(String str, Date date2, List<RFGAdapterActivity> list2, RFGSummaryHistory rFGSummaryHistory) {
        Intrinsics.checkParameterIsNotNull(str, "dateTitle");
        Intrinsics.checkParameterIsNotNull(date2, "date");
        Intrinsics.checkParameterIsNotNull(list2, "list");
        Intrinsics.checkParameterIsNotNull(rFGSummaryHistory, "summary");
        return new RFGAdapterSummary(str, date2, list2, rFGSummaryHistory);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGAdapterSummary)) {
            return false;
        }
        RFGAdapterSummary rFGAdapterSummary = (RFGAdapterSummary) obj;
        return Intrinsics.areEqual((Object) this.dateTitle, (Object) rFGAdapterSummary.dateTitle) && Intrinsics.areEqual((Object) this.date, (Object) rFGAdapterSummary.date) && Intrinsics.areEqual((Object) this.list, (Object) rFGAdapterSummary.list) && Intrinsics.areEqual((Object) this.summary, (Object) rFGAdapterSummary.summary);
    }

    public final Date getDate() {
        return this.date;
    }

    public final String getDateTitle() {
        return this.dateTitle;
    }

    public final List<RFGAdapterActivity> getList() {
        return this.list;
    }

    public final RFGSummaryHistory getSummary() {
        return this.summary;
    }

    public int hashCode() {
        String str = this.dateTitle;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Date date2 = this.date;
        int hashCode2 = (hashCode + (date2 != null ? date2.hashCode() : 0)) * 31;
        List<RFGAdapterActivity> list2 = this.list;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        RFGSummaryHistory rFGSummaryHistory = this.summary;
        if (rFGSummaryHistory != null) {
            i = rFGSummaryHistory.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGAdapterSummary(dateTitle=");
        a.append(this.dateTitle);
        a.append(", date=");
        a.append(this.date);
        a.append(", list=");
        a.append(this.list);
        a.append(", summary=");
        a.append(this.summary);
        a.append(")");
        return a.toString();
    }
}
