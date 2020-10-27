package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0002\u0010\u0012J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u0003H\u0016J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0001J\b\u0010M\u001a\u00020\u0003H\u0016J\b\u0010N\u001a\u00020\u0003H\u0016J\u0013\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010RHÖ\u0003J\t\u0010S\u001a\u00020 HÖ\u0001J\b\u0010T\u001a\u00020\u0003H\u0016J\b\u0010U\u001a\u00020\u0003H\u0016J\b\u0010V\u001a\u00020\u0003H\u0016J\b\u0010W\u001a\u00020=H\u0016J\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\b\u0010Y\u001a\u00020\u0003H\u0016J\t\u0010Z\u001a\u00020\u0003HÖ\u0001J\b\u0010[\u001a\u00020\u0003H\u0016J\b\u0010\\\u001a\u00020=H\u0016J\b\u0010]\u001a\u00020\u0003H\u0016J\b\u0010^\u001a\u00020\u0003H\u0016J\b\u0010_\u001a\u00020=H\u0016J\b\u0010`\u001a\u00020\u0003H\u0016R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0014R\u0014\u0010'\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001e\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0014R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R\u0014\u00108\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0014R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0014\"\u0004\b;\u0010\u0016¨\u0006a"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGSummaryHistory;", "Ljp/reifrontier/gym/domain/api/RFGPanelData;", "aType", "", "aDate", "walkPoint", "runPoint", "bicyclePoint", "trainPoint", "otherPoint", "step", "distanceRun", "distanceBicycle", "distanceTrain", "mets", "activities", "", "Ljp/reifrontier/gym/domain/api/RFGServerActivity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getADate", "()Ljava/lang/String;", "setADate", "(Ljava/lang/String;)V", "getAType", "setAType", "getActivities", "()Ljava/util/List;", "setActivities", "(Ljava/util/List;)V", "getBicyclePoint", "setBicyclePoint", "currentYearPointDayNumber", "", "getCurrentYearPointDayNumber", "()I", "setCurrentYearPointDayNumber", "(I)V", "date", "getDate", "dayNumber", "getDayNumber", "getDistanceBicycle", "setDistanceBicycle", "getDistanceRun", "setDistanceRun", "getDistanceTrain", "setDistanceTrain", "getMets", "setMets", "getOtherPoint", "setOtherPoint", "getRunPoint", "setRunPoint", "getStep", "getTrainPoint", "setTrainPoint", "type", "getType", "getWalkPoint", "setWalkPoint", "bicyclePointF", "", "bikePointText", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "distanceBikeText", "distanceRunText", "equals", "", "other", "", "hashCode", "metsText", "otherPointText", "point", "pointF", "serverActivities", "stepText", "toString", "train", "trainPointF", "trainPointText", "walk", "walkPointF", "walkPointText", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGSummaryHistory */
public final class RFGSummaryHistory implements RFGPanelData {
    @SerializedName("date")
    private String aDate;
    @SerializedName("type")
    private String aType;
    @SerializedName("activity")
    private List<RFGServerActivity> activities;
    @SerializedName("bicycle_point")
    private String bicyclePoint;
    private int currentYearPointDayNumber;
    @SerializedName("distance_bicycle")
    private String distanceBicycle;
    @SerializedName("distance_run")
    private String distanceRun;
    @SerializedName("distance_train")
    private String distanceTrain;
    @SerializedName("mets")
    private String mets;
    @SerializedName("other_point")
    private String otherPoint;
    @SerializedName("run_point")
    private String runPoint;
    @SerializedName("steps")
    private final String step;
    @SerializedName("train_point")
    private String trainPoint;
    @SerializedName("walk_point")
    private String walkPoint;

    public RFGSummaryHistory() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 8191, (DefaultConstructorMarker) null);
    }

    public RFGSummaryHistory(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List<RFGServerActivity> list) {
        Intrinsics.checkParameterIsNotNull(str, "aType");
        Intrinsics.checkParameterIsNotNull(str2, "aDate");
        Intrinsics.checkParameterIsNotNull(str3, "walkPoint");
        Intrinsics.checkParameterIsNotNull(str4, "runPoint");
        Intrinsics.checkParameterIsNotNull(str5, "bicyclePoint");
        Intrinsics.checkParameterIsNotNull(str6, "trainPoint");
        Intrinsics.checkParameterIsNotNull(str7, "otherPoint");
        Intrinsics.checkParameterIsNotNull(str8, "step");
        Intrinsics.checkParameterIsNotNull(str9, "distanceRun");
        Intrinsics.checkParameterIsNotNull(str10, "distanceBicycle");
        Intrinsics.checkParameterIsNotNull(str11, "distanceTrain");
        Intrinsics.checkParameterIsNotNull(str12, "mets");
        Intrinsics.checkParameterIsNotNull(list, "activities");
        this.aType = str;
        this.aDate = str2;
        this.walkPoint = str3;
        this.runPoint = str4;
        this.bicyclePoint = str5;
        this.trainPoint = str6;
        this.otherPoint = str7;
        this.step = str8;
        this.distanceRun = str9;
        this.distanceBicycle = str10;
        this.distanceTrain = str11;
        this.mets = str12;
        this.activities = list;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGSummaryHistory(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.util.List r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r14 = this;
            r0 = r28
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r15
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r2 = r16
        L_0x0012:
            r3 = r0 & 4
            java.lang.String r4 = "0"
            if (r3 == 0) goto L_0x001a
            r3 = r4
            goto L_0x001c
        L_0x001a:
            r3 = r17
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r4
            goto L_0x0024
        L_0x0022:
            r5 = r18
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r4
            goto L_0x002c
        L_0x002a:
            r6 = r19
        L_0x002c:
            r7 = r0 & 32
            java.lang.String r8 = "0.0"
            if (r7 == 0) goto L_0x0034
            r7 = r8
            goto L_0x0036
        L_0x0034:
            r7 = r20
        L_0x0036:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003c
            r9 = r4
            goto L_0x003e
        L_0x003c:
            r9 = r21
        L_0x003e:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r4 = r22
        L_0x0045:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004b
            r10 = r8
            goto L_0x004d
        L_0x004b:
            r10 = r23
        L_0x004d:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0053
            r11 = r8
            goto L_0x0055
        L_0x0053:
            r11 = r24
        L_0x0055:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005b
            r12 = r8
            goto L_0x005d
        L_0x005b:
            r12 = r25
        L_0x005d:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r8 = r26
        L_0x0064:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x006d
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            goto L_0x006f
        L_0x006d:
            r0 = r27
        L_0x006f:
            r15 = r14
            r16 = r1
            r17 = r2
            r18 = r3
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r9
            r23 = r4
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r8
            r28 = r0
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.api.RFGSummaryHistory.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFGSummaryHistory copy$default(RFGSummaryHistory rFGSummaryHistory, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List list, int i, Object obj) {
        RFGSummaryHistory rFGSummaryHistory2 = rFGSummaryHistory;
        int i2 = i;
        return rFGSummaryHistory.copy((i2 & 1) != 0 ? rFGSummaryHistory2.aType : str, (i2 & 2) != 0 ? rFGSummaryHistory2.aDate : str2, (i2 & 4) != 0 ? rFGSummaryHistory2.walkPoint : str3, (i2 & 8) != 0 ? rFGSummaryHistory2.runPoint : str4, (i2 & 16) != 0 ? rFGSummaryHistory2.bicyclePoint : str5, (i2 & 32) != 0 ? rFGSummaryHistory2.trainPoint : str6, (i2 & 64) != 0 ? rFGSummaryHistory2.otherPoint : str7, (i2 & 128) != 0 ? rFGSummaryHistory2.step : str8, (i2 & 256) != 0 ? rFGSummaryHistory2.distanceRun : str9, (i2 & 512) != 0 ? rFGSummaryHistory2.distanceBicycle : str10, (i2 & 1024) != 0 ? rFGSummaryHistory2.distanceTrain : str11, (i2 & 2048) != 0 ? rFGSummaryHistory2.mets : str12, (i2 & 4096) != 0 ? rFGSummaryHistory2.activities : list);
    }

    public float bicyclePointF() {
        return Float.parseFloat(this.bicyclePoint) + Float.parseFloat(this.runPoint) + Float.parseFloat(this.walkPoint);
    }

    public String bikePointText() {
        return this.bicyclePoint;
    }

    public final String component1() {
        return this.aType;
    }

    public final String component10() {
        return this.distanceBicycle;
    }

    public final String component11() {
        return this.distanceTrain;
    }

    public final String component12() {
        return this.mets;
    }

    public final List<RFGServerActivity> component13() {
        return this.activities;
    }

    public final String component2() {
        return this.aDate;
    }

    public final String component3() {
        return this.walkPoint;
    }

    public final String component4() {
        return this.runPoint;
    }

    public final String component5() {
        return this.bicyclePoint;
    }

    public final String component6() {
        return this.trainPoint;
    }

    public final String component7() {
        return this.otherPoint;
    }

    public final String component8() {
        return this.step;
    }

    public final String component9() {
        return this.distanceRun;
    }

    public final RFGSummaryHistory copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, List<RFGServerActivity> list) {
        String str13 = str;
        Intrinsics.checkParameterIsNotNull(str13, "aType");
        String str14 = str2;
        Intrinsics.checkParameterIsNotNull(str14, "aDate");
        String str15 = str3;
        Intrinsics.checkParameterIsNotNull(str15, "walkPoint");
        String str16 = str4;
        Intrinsics.checkParameterIsNotNull(str16, "runPoint");
        String str17 = str5;
        Intrinsics.checkParameterIsNotNull(str17, "bicyclePoint");
        String str18 = str6;
        Intrinsics.checkParameterIsNotNull(str18, "trainPoint");
        String str19 = str7;
        Intrinsics.checkParameterIsNotNull(str19, "otherPoint");
        String str20 = str8;
        Intrinsics.checkParameterIsNotNull(str20, "step");
        String str21 = str9;
        Intrinsics.checkParameterIsNotNull(str21, "distanceRun");
        String str22 = str10;
        Intrinsics.checkParameterIsNotNull(str22, "distanceBicycle");
        String str23 = str11;
        Intrinsics.checkParameterIsNotNull(str23, "distanceTrain");
        String str24 = str12;
        Intrinsics.checkParameterIsNotNull(str24, "mets");
        List<RFGServerActivity> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "activities");
        return new RFGSummaryHistory(str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, list2);
    }

    public String distanceBikeText() {
        return this.distanceBicycle;
    }

    public String distanceRunText() {
        return this.distanceRun;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGSummaryHistory)) {
            return false;
        }
        RFGSummaryHistory rFGSummaryHistory = (RFGSummaryHistory) obj;
        return Intrinsics.areEqual((Object) this.aType, (Object) rFGSummaryHistory.aType) && Intrinsics.areEqual((Object) this.aDate, (Object) rFGSummaryHistory.aDate) && Intrinsics.areEqual((Object) this.walkPoint, (Object) rFGSummaryHistory.walkPoint) && Intrinsics.areEqual((Object) this.runPoint, (Object) rFGSummaryHistory.runPoint) && Intrinsics.areEqual((Object) this.bicyclePoint, (Object) rFGSummaryHistory.bicyclePoint) && Intrinsics.areEqual((Object) this.trainPoint, (Object) rFGSummaryHistory.trainPoint) && Intrinsics.areEqual((Object) this.otherPoint, (Object) rFGSummaryHistory.otherPoint) && Intrinsics.areEqual((Object) this.step, (Object) rFGSummaryHistory.step) && Intrinsics.areEqual((Object) this.distanceRun, (Object) rFGSummaryHistory.distanceRun) && Intrinsics.areEqual((Object) this.distanceBicycle, (Object) rFGSummaryHistory.distanceBicycle) && Intrinsics.areEqual((Object) this.distanceTrain, (Object) rFGSummaryHistory.distanceTrain) && Intrinsics.areEqual((Object) this.mets, (Object) rFGSummaryHistory.mets) && Intrinsics.areEqual((Object) this.activities, (Object) rFGSummaryHistory.activities);
    }

    public final String getADate() {
        return this.aDate;
    }

    public final String getAType() {
        return this.aType;
    }

    public final List<RFGServerActivity> getActivities() {
        return this.activities;
    }

    public final String getBicyclePoint() {
        return this.bicyclePoint;
    }

    public final int getCurrentYearPointDayNumber() {
        return this.currentYearPointDayNumber;
    }

    public String getDate() {
        return this.aDate;
    }

    public int getDayNumber() {
        return this.currentYearPointDayNumber;
    }

    public final String getDistanceBicycle() {
        return this.distanceBicycle;
    }

    public final String getDistanceRun() {
        return this.distanceRun;
    }

    public final String getDistanceTrain() {
        return this.distanceTrain;
    }

    public final String getMets() {
        return this.mets;
    }

    public final String getOtherPoint() {
        return this.otherPoint;
    }

    public final String getRunPoint() {
        return this.runPoint;
    }

    public final String getStep() {
        return this.step;
    }

    public final String getTrainPoint() {
        return this.trainPoint;
    }

    public String getType() {
        return this.aType;
    }

    public final String getWalkPoint() {
        return this.walkPoint;
    }

    public int hashCode() {
        String str = this.aType;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.aDate;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.walkPoint;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.runPoint;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bicyclePoint;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.trainPoint;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.otherPoint;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.step;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.distanceRun;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.distanceBicycle;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.distanceTrain;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.mets;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        List<RFGServerActivity> list = this.activities;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode12 + i;
    }

    public String metsText() {
        return this.mets;
    }

    public String otherPointText() {
        return this.otherPoint;
    }

    public String point() {
        return C0681a.m328a(new Object[]{Float.valueOf(pointF())}, 1, "%.0f", "java.lang.String.format(this, *args)");
    }

    public float pointF() {
        return Float.parseFloat(this.otherPoint) + Float.parseFloat(this.runPoint) + Float.parseFloat(this.bicyclePoint) + Float.parseFloat(this.walkPoint);
    }

    public final List<RFGServerActivity> serverActivities() {
        return this.activities.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : CollectionsKt___CollectionsKt.sortedWith(this.activities, RFGSummaryHistory$serverActivities$1.INSTANCE);
    }

    public final void setADate(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.aDate = str;
    }

    public final void setAType(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.aType = str;
    }

    public final void setActivities(List<RFGServerActivity> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.activities = list;
    }

    public final void setBicyclePoint(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.bicyclePoint = str;
    }

    public final void setCurrentYearPointDayNumber(int i) {
        this.currentYearPointDayNumber = i;
    }

    public final void setDistanceBicycle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.distanceBicycle = str;
    }

    public final void setDistanceRun(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.distanceRun = str;
    }

    public final void setDistanceTrain(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.distanceTrain = str;
    }

    public final void setMets(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.mets = str;
    }

    public final void setOtherPoint(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.otherPoint = str;
    }

    public final void setRunPoint(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.runPoint = str;
    }

    public final void setTrainPoint(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.trainPoint = str;
    }

    public final void setWalkPoint(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.walkPoint = str;
    }

    public String stepText() {
        return this.step;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGSummaryHistory(aType=");
        a.append(this.aType);
        a.append(", aDate=");
        a.append(this.aDate);
        a.append(", walkPoint=");
        a.append(this.walkPoint);
        a.append(", runPoint=");
        a.append(this.runPoint);
        a.append(", bicyclePoint=");
        a.append(this.bicyclePoint);
        a.append(", trainPoint=");
        a.append(this.trainPoint);
        a.append(", otherPoint=");
        a.append(this.otherPoint);
        a.append(", step=");
        a.append(this.step);
        a.append(", distanceRun=");
        a.append(this.distanceRun);
        a.append(", distanceBicycle=");
        a.append(this.distanceBicycle);
        a.append(", distanceTrain=");
        a.append(this.distanceTrain);
        a.append(", mets=");
        a.append(this.mets);
        a.append(", activities=");
        return C0681a.m325a(a, (List) this.activities, ")");
    }

    public String train() {
        return C0681a.m328a(new Object[]{Float.valueOf(Float.parseFloat(this.distanceTrain))}, 1, "%.0f", "java.lang.String.format(this, *args)");
    }

    public float trainPointF() {
        return Float.parseFloat(this.trainPoint);
    }

    public String trainPointText() {
        return this.trainPoint;
    }

    public String walk() {
        return C0681a.m328a(new Object[]{Float.valueOf(Float.parseFloat(this.runPoint) + Float.parseFloat(this.walkPoint))}, 1, "%.0f", "java.lang.String.format(this, *args)");
    }

    public float walkPointF() {
        return Float.parseFloat(this.runPoint) + Float.parseFloat(this.walkPoint);
    }

    public String walkPointText() {
        return C0681a.m328a(new Object[]{Float.valueOf(Float.parseFloat(this.runPoint) + Float.parseFloat(this.walkPoint))}, 1, "%.0f", "java.lang.String.format(this, *args)");
    }
}
