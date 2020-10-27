package p043jp.reifrontier.silentlogsdkandroid.domain.daily;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFL_SEGMENT_TYPE;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\u0006\u0010'\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020\u0007J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J_\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0007HÖ\u0001J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\fJ\t\u00109\u001a\u00020\u0005HÖ\u0001R$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0019\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001cR\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017¨\u0006:"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLSegment;", "", "segmentType", "Ljp/reifrontier/silentlogsdkandroid/utils/RFL_SEGMENT_TYPE;", "timezone", "", "fromDate", "", "toDate", "steps", "activities", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivity;", "segment", "place", "(Ljp/reifrontier/silentlogsdkandroid/utils/RFL_SEGMENT_TYPE;Ljava/lang/String;IIILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getActivities", "()Ljava/util/List;", "setActivities", "(Ljava/util/List;)V", "getFromDate", "()I", "setFromDate", "(I)V", "getPlace", "()Ljava/lang/String;", "getSegment", "setSegment", "(Ljava/lang/String;)V", "getSegmentType", "()Ljp/reifrontier/silentlogsdkandroid/utils/RFL_SEGMENT_TYPE;", "setSegmentType", "(Ljp/reifrontier/silentlogsdkandroid/utils/RFL_SEGMENT_TYPE;)V", "getSteps", "setSteps", "getTimezone", "setTimezone", "getToDate", "setToDate", "actualEndTime", "actualStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "setActivity", "", "activity", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLSegment */
public final class RFLSegment {
    @Expose

    /* renamed from: a */
    private RFL_SEGMENT_TYPE f3563a;
    @SerializedName("timezone")
    @Expose

    /* renamed from: b */
    private String f3564b;
    @SerializedName("startTime")
    @Expose

    /* renamed from: c */
    private int f3565c;
    @SerializedName("endTime")
    @Expose

    /* renamed from: d */
    private int f3566d;
    @SerializedName("steps")
    @Expose

    /* renamed from: e */
    private int f3567e;
    @SerializedName("activities")
    @Expose

    /* renamed from: f */
    private List<RFLActivity> f3568f;
    @SerializedName("type")
    @Expose

    /* renamed from: g */
    private String f3569g;
    @SerializedName("place")
    @Expose

    /* renamed from: h */
    private final String f3570h;

    public RFLSegment(RFL_SEGMENT_TYPE rfl_segment_type, String str, int i, int i2, int i3, List<RFLActivity> list, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(rfl_segment_type, "segmentType");
        Intrinsics.checkParameterIsNotNull(str, "timezone");
        Intrinsics.checkParameterIsNotNull(list, "activities");
        Intrinsics.checkParameterIsNotNull(str2, "segment");
        Intrinsics.checkParameterIsNotNull(str3, "place");
        this.f3563a = rfl_segment_type;
        this.f3564b = str;
        this.f3565c = i;
        this.f3566d = i2;
        this.f3567e = i3;
        this.f3568f = list;
        this.f3569g = str2;
        this.f3570h = str3;
    }

    public static /* synthetic */ RFLSegment copy$default(RFLSegment rFLSegment, RFL_SEGMENT_TYPE rfl_segment_type, String str, int i, int i2, int i3, List list, String str2, String str3, int i4, Object obj) {
        RFLSegment rFLSegment2 = rFLSegment;
        int i5 = i4;
        return rFLSegment.copy((i5 & 1) != 0 ? rFLSegment2.f3563a : rfl_segment_type, (i5 & 2) != 0 ? rFLSegment2.f3564b : str, (i5 & 4) != 0 ? rFLSegment2.f3565c : i, (i5 & 8) != 0 ? rFLSegment2.f3566d : i2, (i5 & 16) != 0 ? rFLSegment2.f3567e : i3, (i5 & 32) != 0 ? rFLSegment2.f3568f : list, (i5 & 64) != 0 ? rFLSegment2.f3569g : str2, (i5 & 128) != 0 ? rFLSegment2.f3570h : str3);
    }

    public final int actualEndTime() {
        return ((RFLActivity) CollectionsKt___CollectionsKt.last(this.f3568f)).actualEndTime();
    }

    public final int actualStartTime() {
        return ((RFLActivity) CollectionsKt___CollectionsKt.first(this.f3568f)).actualStartTime();
    }

    public final RFL_SEGMENT_TYPE component1() {
        return this.f3563a;
    }

    public final String component2() {
        return this.f3564b;
    }

    public final int component3() {
        return this.f3565c;
    }

    public final int component4() {
        return this.f3566d;
    }

    public final int component5() {
        return this.f3567e;
    }

    public final List<RFLActivity> component6() {
        return this.f3568f;
    }

    public final String component7() {
        return this.f3569g;
    }

    public final String component8() {
        return this.f3570h;
    }

    public final RFLSegment copy(RFL_SEGMENT_TYPE rfl_segment_type, String str, int i, int i2, int i3, List<RFLActivity> list, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(rfl_segment_type, "segmentType");
        Intrinsics.checkParameterIsNotNull(str, "timezone");
        List<RFLActivity> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "activities");
        String str4 = str2;
        Intrinsics.checkParameterIsNotNull(str4, "segment");
        String str5 = str3;
        Intrinsics.checkParameterIsNotNull(str5, "place");
        return new RFLSegment(rfl_segment_type, str, i, i2, i3, list2, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLSegment)) {
            return false;
        }
        RFLSegment rFLSegment = (RFLSegment) obj;
        return Intrinsics.areEqual((Object) this.f3563a, (Object) rFLSegment.f3563a) && Intrinsics.areEqual((Object) this.f3564b, (Object) rFLSegment.f3564b) && this.f3565c == rFLSegment.f3565c && this.f3566d == rFLSegment.f3566d && this.f3567e == rFLSegment.f3567e && Intrinsics.areEqual((Object) this.f3568f, (Object) rFLSegment.f3568f) && Intrinsics.areEqual((Object) this.f3569g, (Object) rFLSegment.f3569g) && Intrinsics.areEqual((Object) this.f3570h, (Object) rFLSegment.f3570h);
    }

    public final List<RFLActivity> getActivities() {
        return this.f3568f;
    }

    public final int getFromDate() {
        return this.f3565c;
    }

    public final String getPlace() {
        return this.f3570h;
    }

    public final String getSegment() {
        return this.f3569g;
    }

    public final RFL_SEGMENT_TYPE getSegmentType() {
        return this.f3563a;
    }

    public final int getSteps() {
        return this.f3567e;
    }

    public final String getTimezone() {
        return this.f3564b;
    }

    public final int getToDate() {
        return this.f3566d;
    }

    public int hashCode() {
        RFL_SEGMENT_TYPE rfl_segment_type = this.f3563a;
        int i = 0;
        int hashCode = (rfl_segment_type != null ? rfl_segment_type.hashCode() : 0) * 31;
        String str = this.f3564b;
        int hashCode2 = (((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f3565c) * 31) + this.f3566d) * 31) + this.f3567e) * 31;
        List<RFLActivity> list = this.f3568f;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str2 = this.f3569g;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3570h;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public final void setActivities(List<RFLActivity> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.f3568f = list;
    }

    public final void setActivity(RFLActivity rFLActivity) {
        Intrinsics.checkParameterIsNotNull(rFLActivity, "activity");
        this.f3568f = CollectionsKt__CollectionsJVMKt.listOf(rFLActivity);
        this.f3564b = rFLActivity.getTimezone();
        this.f3565c = rFLActivity.getFromDate();
        this.f3566d = rFLActivity.getToDate();
        this.f3567e = rFLActivity.getSteps();
        RFL_SEGMENT_TYPE segment = RFLDailyUtilsKt.segment(rFLActivity.type());
        this.f3563a = segment;
        this.f3569g = RFLDailyUtilsKt.string(segment);
    }

    public final void setFromDate(int i) {
        this.f3565c = i;
    }

    public final void setSegment(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f3569g = str;
    }

    public final void setSegmentType(RFL_SEGMENT_TYPE rfl_segment_type) {
        Intrinsics.checkParameterIsNotNull(rfl_segment_type, "<set-?>");
        this.f3563a = rfl_segment_type;
    }

    public final void setSteps(int i) {
        this.f3567e = i;
    }

    public final void setTimezone(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f3564b = str;
    }

    public final void setToDate(int i) {
        this.f3566d = i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLSegment(segmentType=");
        a.append(this.f3563a);
        a.append(", timezone=");
        a.append(this.f3564b);
        a.append(", fromDate=");
        a.append(this.f3565c);
        a.append(", toDate=");
        a.append(this.f3566d);
        a.append(", steps=");
        a.append(this.f3567e);
        a.append(", activities=");
        a.append(this.f3568f);
        a.append(", segment=");
        a.append(this.f3569g);
        a.append(", place=");
        return C0681a.m324a(a, this.f3570h, ")");
    }
}
