package p043jp.reifrontier.gym.domain.api;

import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u0006\u0010 \u001a\u00020!J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003Jc\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0006\u0010,\u001a\u00020!J\u0013\u0010-\u001a\u00020.2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\u0006\u00101\u001a\u000200J\u0006\u00102\u001a\u00020!J\u0006\u00103\u001a\u00020!J\t\u00104\u001a\u00020\u0003HÖ\u0001J\u0006\u00105\u001a\u00020!J\u0006\u00106\u001a\u00020!R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000e¨\u00067"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUserChartData;", "", "order", "", "title", "walk", "bicycle", "run", "other", "weight", "step", "distance_bicycle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBicycle", "()Ljava/lang/String;", "setBicycle", "(Ljava/lang/String;)V", "getDistance_bicycle", "setDistance_bicycle", "getOrder", "setOrder", "getOther", "setOther", "getRun", "setRun", "getStep", "setStep", "getTitle", "setTitle", "getWalk", "setWalk", "getWeight", "bicyclePoint", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "distanceF", "equals", "", "hashCode", "", "ord", "point", "stepF", "toString", "walkPoint", "weightF", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGUserChartData */
public final class RFGUserChartData {
    @SerializedName("bicycle")
    private String bicycle;
    @SerializedName("distance_bicycle")
    private String distance_bicycle;
    @SerializedName("ord")
    private String order;
    @SerializedName("other")
    private String other;
    @SerializedName("run")
    private String run;
    @SerializedName("steps")
    private String step;
    @SerializedName("title")
    private String title;
    @SerializedName("walk")
    private String walk;
    @SerializedName("weight")
    private final String weight;

    public RFGUserChartData() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
    }

    public RFGUserChartData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkParameterIsNotNull(str, "order");
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(str3, "walk");
        Intrinsics.checkParameterIsNotNull(str4, "bicycle");
        Intrinsics.checkParameterIsNotNull(str5, "run");
        Intrinsics.checkParameterIsNotNull(str6, FitnessActivities.OTHER);
        Intrinsics.checkParameterIsNotNull(str7, "weight");
        Intrinsics.checkParameterIsNotNull(str8, "step");
        Intrinsics.checkParameterIsNotNull(str9, "distance_bicycle");
        this.order = str;
        this.title = str2;
        this.walk = str3;
        this.bicycle = str4;
        this.run = str5;
        this.other = str6;
        this.weight = str7;
        this.step = str8;
        this.distance_bicycle = str9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGUserChartData(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r11 = this;
            r0 = r21
            r1 = r0 & 1
            java.lang.String r2 = "0"
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r12
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            java.lang.String r3 = ""
            goto L_0x0013
        L_0x0012:
            r3 = r13
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = r2
            goto L_0x001a
        L_0x0019:
            r4 = r14
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0021
        L_0x0020:
            r5 = r15
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r16
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r17
        L_0x0031:
            r8 = r0 & 64
            java.lang.String r9 = "0.0"
            if (r8 == 0) goto L_0x0039
            r8 = r9
            goto L_0x003b
        L_0x0039:
            r8 = r18
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r2 = r19
        L_0x0042:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r9 = r20
        L_0x0049:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r2
            r21 = r9
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.api.RFGUserChartData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFGUserChartData copy$default(RFGUserChartData rFGUserChartData, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        RFGUserChartData rFGUserChartData2 = rFGUserChartData;
        int i2 = i;
        return rFGUserChartData.copy((i2 & 1) != 0 ? rFGUserChartData2.order : str, (i2 & 2) != 0 ? rFGUserChartData2.title : str2, (i2 & 4) != 0 ? rFGUserChartData2.walk : str3, (i2 & 8) != 0 ? rFGUserChartData2.bicycle : str4, (i2 & 16) != 0 ? rFGUserChartData2.run : str5, (i2 & 32) != 0 ? rFGUserChartData2.other : str6, (i2 & 64) != 0 ? rFGUserChartData2.weight : str7, (i2 & 128) != 0 ? rFGUserChartData2.step : str8, (i2 & 256) != 0 ? rFGUserChartData2.distance_bicycle : str9);
    }

    public final float bicyclePoint() {
        return Float.parseFloat(this.run) + Float.parseFloat(this.bicycle) + Float.parseFloat(this.walk);
    }

    public final String component1() {
        return this.order;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.walk;
    }

    public final String component4() {
        return this.bicycle;
    }

    public final String component5() {
        return this.run;
    }

    public final String component6() {
        return this.other;
    }

    public final String component7() {
        return this.weight;
    }

    public final String component8() {
        return this.step;
    }

    public final String component9() {
        return this.distance_bicycle;
    }

    public final RFGUserChartData copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkParameterIsNotNull(str, "order");
        Intrinsics.checkParameterIsNotNull(str2, "title");
        Intrinsics.checkParameterIsNotNull(str3, "walk");
        Intrinsics.checkParameterIsNotNull(str4, "bicycle");
        String str10 = str5;
        Intrinsics.checkParameterIsNotNull(str10, "run");
        String str11 = str6;
        Intrinsics.checkParameterIsNotNull(str11, FitnessActivities.OTHER);
        String str12 = str7;
        Intrinsics.checkParameterIsNotNull(str12, "weight");
        String str13 = str8;
        Intrinsics.checkParameterIsNotNull(str13, "step");
        String str14 = str9;
        Intrinsics.checkParameterIsNotNull(str14, "distance_bicycle");
        return new RFGUserChartData(str, str2, str3, str4, str10, str11, str12, str13, str14);
    }

    public final float distanceF() {
        return Float.parseFloat(this.distance_bicycle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGUserChartData)) {
            return false;
        }
        RFGUserChartData rFGUserChartData = (RFGUserChartData) obj;
        return Intrinsics.areEqual((Object) this.order, (Object) rFGUserChartData.order) && Intrinsics.areEqual((Object) this.title, (Object) rFGUserChartData.title) && Intrinsics.areEqual((Object) this.walk, (Object) rFGUserChartData.walk) && Intrinsics.areEqual((Object) this.bicycle, (Object) rFGUserChartData.bicycle) && Intrinsics.areEqual((Object) this.run, (Object) rFGUserChartData.run) && Intrinsics.areEqual((Object) this.other, (Object) rFGUserChartData.other) && Intrinsics.areEqual((Object) this.weight, (Object) rFGUserChartData.weight) && Intrinsics.areEqual((Object) this.step, (Object) rFGUserChartData.step) && Intrinsics.areEqual((Object) this.distance_bicycle, (Object) rFGUserChartData.distance_bicycle);
    }

    public final String getBicycle() {
        return this.bicycle;
    }

    public final String getDistance_bicycle() {
        return this.distance_bicycle;
    }

    public final String getOrder() {
        return this.order;
    }

    public final String getOther() {
        return this.other;
    }

    public final String getRun() {
        return this.run;
    }

    public final String getStep() {
        return this.step;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getWalk() {
        return this.walk;
    }

    public final String getWeight() {
        return this.weight;
    }

    public int hashCode() {
        String str = this.order;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.walk;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.bicycle;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.run;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.other;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.weight;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.step;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.distance_bicycle;
        if (str9 != null) {
            i = str9.hashCode();
        }
        return hashCode8 + i;
    }

    public final int ord() {
        return Integer.parseInt(this.order);
    }

    public final float point() {
        return Float.parseFloat(this.other) + Float.parseFloat(this.run) + Float.parseFloat(this.bicycle) + Float.parseFloat(this.walk);
    }

    public final void setBicycle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.bicycle = str;
    }

    public final void setDistance_bicycle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.distance_bicycle = str;
    }

    public final void setOrder(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.order = str;
    }

    public final void setOther(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.other = str;
    }

    public final void setRun(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.run = str;
    }

    public final void setStep(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.step = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.title = str;
    }

    public final void setWalk(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.walk = str;
    }

    public final float stepF() {
        return Float.parseFloat(this.step);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGUserChartData(order=");
        a.append(this.order);
        a.append(", title=");
        a.append(this.title);
        a.append(", walk=");
        a.append(this.walk);
        a.append(", bicycle=");
        a.append(this.bicycle);
        a.append(", run=");
        a.append(this.run);
        a.append(", other=");
        a.append(this.other);
        a.append(", weight=");
        a.append(this.weight);
        a.append(", step=");
        a.append(this.step);
        a.append(", distance_bicycle=");
        return C0681a.m324a(a, this.distance_bicycle, ")");
    }

    public final float walkPoint() {
        return Float.parseFloat(this.run) + Float.parseFloat(this.walk);
    }

    public final float weightF() {
        return Float.parseFloat(this.weight);
    }
}
