package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.util.RFGUtilsKt;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0012J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\tHÆ\u0003J\t\u0010;\u001a\u00020\tHÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\u0006\u0010>\u001a\u00020\u0003J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020\tHÖ\u0001J\u0006\u0010C\u001a\u00020\tJ\u0006\u0010D\u001a\u00020\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001R$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010$\"\u0004\b(\u0010&R\u001e\u0010\f\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001e\u0010\n\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&¨\u0006F"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGClub;", "", "clubId", "", "clubCode", "clubName", "clubIcon", "clubDesc", "clubReset", "", "updateTime", "createTime", "endTime", "pointRankingList", "", "Ljp/reifrontier/gym/domain/api/RFGUserData;", "stepRankingList", "bikeRankingList", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBikeRankingList", "()Ljava/util/List;", "setBikeRankingList", "(Ljava/util/List;)V", "getClubCode", "()Ljava/lang/String;", "setClubCode", "(Ljava/lang/String;)V", "getClubDesc", "setClubDesc", "getClubIcon", "setClubIcon", "getClubId", "setClubId", "getClubName", "setClubName", "getClubReset", "()I", "setClubReset", "(I)V", "getCreateTime", "setCreateTime", "getEndTime", "setEndTime", "getPointRankingList", "setPointRankingList", "getStepRankingList", "setStepRankingList", "getUpdateTime", "setUpdateTime", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "endDateString", "equals", "", "other", "hashCode", "resetResId", "startDateString", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGClub */
public final class RFGClub {
    @SerializedName("club_users_bicycle")
    private List<RFGUserData> bikeRankingList;
    @SerializedName("club_code")
    private String clubCode;
    @SerializedName("club_desc")
    private String clubDesc;
    @SerializedName("club_icon")
    private String clubIcon;
    @SerializedName("club_id")
    private String clubId;
    @SerializedName("club_name")
    private String clubName;
    @SerializedName("club_reset")
    private int clubReset;
    @SerializedName("create_time")
    private int createTime;
    @SerializedName("end_time")
    private int endTime;
    @SerializedName("club_users")
    private List<RFGUserData> pointRankingList;
    @SerializedName("club_users_step")
    private List<RFGUserData> stepRankingList;
    @SerializedName("update_time")
    private int updateTime;

    public RFGClub(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, List<RFGUserData> list, List<RFGUserData> list2, List<RFGUserData> list3) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        Intrinsics.checkParameterIsNotNull(str2, "clubCode");
        Intrinsics.checkParameterIsNotNull(str3, "clubName");
        Intrinsics.checkParameterIsNotNull(str4, "clubIcon");
        Intrinsics.checkParameterIsNotNull(str5, "clubDesc");
        Intrinsics.checkParameterIsNotNull(list, "pointRankingList");
        Intrinsics.checkParameterIsNotNull(list2, "stepRankingList");
        Intrinsics.checkParameterIsNotNull(list3, "bikeRankingList");
        this.clubId = str;
        this.clubCode = str2;
        this.clubName = str3;
        this.clubIcon = str4;
        this.clubDesc = str5;
        this.clubReset = i;
        this.updateTime = i2;
        this.createTime = i3;
        this.endTime = i4;
        this.pointRankingList = list;
        this.stepRankingList = list2;
        this.bikeRankingList = list3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGClub(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21, int r22, int r23, int r24, java.util.List r25, java.util.List r26, java.util.List r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "0"
            r3 = r1
            goto L_0x000c
        L_0x000a:
            r3 = r16
        L_0x000c:
            r1 = r0 & 2
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0014
            r4 = r2
            goto L_0x0016
        L_0x0014:
            r4 = r17
        L_0x0016:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x001c
            r5 = r2
            goto L_0x001e
        L_0x001c:
            r5 = r18
        L_0x001e:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0024
            r6 = r2
            goto L_0x0026
        L_0x0024:
            r6 = r19
        L_0x0026:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r20
        L_0x002e:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0035
            r1 = 2
            r8 = 2
            goto L_0x0037
        L_0x0035:
            r8 = r21
        L_0x0037:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0041
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r12 = r1
            goto L_0x0043
        L_0x0041:
            r12 = r25
        L_0x0043:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x004d
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r13 = r1
            goto L_0x004f
        L_0x004d:
            r13 = r26
        L_0x004f:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0059
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r14 = r0
            goto L_0x005b
        L_0x0059:
            r14 = r27
        L_0x005b:
            r2 = r15
            r9 = r22
            r10 = r23
            r11 = r24
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.api.RFGClub.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, java.util.List, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFGClub copy$default(RFGClub rFGClub, String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, List list, List list2, List list3, int i5, Object obj) {
        RFGClub rFGClub2 = rFGClub;
        int i6 = i5;
        return rFGClub.copy((i6 & 1) != 0 ? rFGClub2.clubId : str, (i6 & 2) != 0 ? rFGClub2.clubCode : str2, (i6 & 4) != 0 ? rFGClub2.clubName : str3, (i6 & 8) != 0 ? rFGClub2.clubIcon : str4, (i6 & 16) != 0 ? rFGClub2.clubDesc : str5, (i6 & 32) != 0 ? rFGClub2.clubReset : i, (i6 & 64) != 0 ? rFGClub2.updateTime : i2, (i6 & 128) != 0 ? rFGClub2.createTime : i3, (i6 & 256) != 0 ? rFGClub2.endTime : i4, (i6 & 512) != 0 ? rFGClub2.pointRankingList : list, (i6 & 1024) != 0 ? rFGClub2.stepRankingList : list2, (i6 & 2048) != 0 ? rFGClub2.bikeRankingList : list3);
    }

    public final String component1() {
        return this.clubId;
    }

    public final List<RFGUserData> component10() {
        return this.pointRankingList;
    }

    public final List<RFGUserData> component11() {
        return this.stepRankingList;
    }

    public final List<RFGUserData> component12() {
        return this.bikeRankingList;
    }

    public final String component2() {
        return this.clubCode;
    }

    public final String component3() {
        return this.clubName;
    }

    public final String component4() {
        return this.clubIcon;
    }

    public final String component5() {
        return this.clubDesc;
    }

    public final int component6() {
        return this.clubReset;
    }

    public final int component7() {
        return this.updateTime;
    }

    public final int component8() {
        return this.createTime;
    }

    public final int component9() {
        return this.endTime;
    }

    public final RFGClub copy(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, List<RFGUserData> list, List<RFGUserData> list2, List<RFGUserData> list3) {
        Intrinsics.checkParameterIsNotNull(str, "clubId");
        String str6 = str2;
        Intrinsics.checkParameterIsNotNull(str6, "clubCode");
        String str7 = str3;
        Intrinsics.checkParameterIsNotNull(str7, "clubName");
        String str8 = str4;
        Intrinsics.checkParameterIsNotNull(str8, "clubIcon");
        String str9 = str5;
        Intrinsics.checkParameterIsNotNull(str9, "clubDesc");
        List<RFGUserData> list4 = list;
        Intrinsics.checkParameterIsNotNull(list4, "pointRankingList");
        List<RFGUserData> list5 = list2;
        Intrinsics.checkParameterIsNotNull(list5, "stepRankingList");
        List<RFGUserData> list6 = list3;
        Intrinsics.checkParameterIsNotNull(list6, "bikeRankingList");
        return new RFGClub(str, str6, str7, str8, str9, i, i2, i3, i4, list4, list5, list6);
    }

    public final String endDateString() {
        return RFGUtilsKt.formaaat11(new Date(((long) this.endTime) * 1000), "yyyy年M月d日", "Asia/Tokyo");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGClub)) {
            return false;
        }
        RFGClub rFGClub = (RFGClub) obj;
        return Intrinsics.areEqual((Object) this.clubId, (Object) rFGClub.clubId) && Intrinsics.areEqual((Object) this.clubCode, (Object) rFGClub.clubCode) && Intrinsics.areEqual((Object) this.clubName, (Object) rFGClub.clubName) && Intrinsics.areEqual((Object) this.clubIcon, (Object) rFGClub.clubIcon) && Intrinsics.areEqual((Object) this.clubDesc, (Object) rFGClub.clubDesc) && this.clubReset == rFGClub.clubReset && this.updateTime == rFGClub.updateTime && this.createTime == rFGClub.createTime && this.endTime == rFGClub.endTime && Intrinsics.areEqual((Object) this.pointRankingList, (Object) rFGClub.pointRankingList) && Intrinsics.areEqual((Object) this.stepRankingList, (Object) rFGClub.stepRankingList) && Intrinsics.areEqual((Object) this.bikeRankingList, (Object) rFGClub.bikeRankingList);
    }

    public final List<RFGUserData> getBikeRankingList() {
        return this.bikeRankingList;
    }

    public final String getClubCode() {
        return this.clubCode;
    }

    public final String getClubDesc() {
        return this.clubDesc;
    }

    public final String getClubIcon() {
        return this.clubIcon;
    }

    public final String getClubId() {
        return this.clubId;
    }

    public final String getClubName() {
        return this.clubName;
    }

    public final int getClubReset() {
        return this.clubReset;
    }

    public final int getCreateTime() {
        return this.createTime;
    }

    public final int getEndTime() {
        return this.endTime;
    }

    public final List<RFGUserData> getPointRankingList() {
        return this.pointRankingList;
    }

    public final List<RFGUserData> getStepRankingList() {
        return this.stepRankingList;
    }

    public final int getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        String str = this.clubId;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.clubCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.clubName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.clubIcon;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.clubDesc;
        int hashCode5 = (((((((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.clubReset) * 31) + this.updateTime) * 31) + this.createTime) * 31) + this.endTime) * 31;
        List<RFGUserData> list = this.pointRankingList;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        List<RFGUserData> list2 = this.stepRankingList;
        int hashCode7 = (hashCode6 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<RFGUserData> list3 = this.bikeRankingList;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode7 + i;
    }

    public final int resetResId() {
        int i = this.clubReset;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? R.string.club_reset_no : R.string.club_reset_year : R.string.club_reset_season : R.string.club_reset_month : R.string.club_reset_week;
    }

    public final void setBikeRankingList(List<RFGUserData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.bikeRankingList = list;
    }

    public final void setClubCode(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.clubCode = str;
    }

    public final void setClubDesc(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.clubDesc = str;
    }

    public final void setClubIcon(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.clubIcon = str;
    }

    public final void setClubId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.clubId = str;
    }

    public final void setClubName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.clubName = str;
    }

    public final void setClubReset(int i) {
        this.clubReset = i;
    }

    public final void setCreateTime(int i) {
        this.createTime = i;
    }

    public final void setEndTime(int i) {
        this.endTime = i;
    }

    public final void setPointRankingList(List<RFGUserData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.pointRankingList = list;
    }

    public final void setStepRankingList(List<RFGUserData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.stepRankingList = list;
    }

    public final void setUpdateTime(int i) {
        this.updateTime = i;
    }

    public final String startDateString() {
        return RFGUtilsKt.formaaat11(new Date(((long) this.createTime) * 1000), "yyyy年M月d日", "Asia/Tokyo");
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGClub(clubId=");
        a.append(this.clubId);
        a.append(", clubCode=");
        a.append(this.clubCode);
        a.append(", clubName=");
        a.append(this.clubName);
        a.append(", clubIcon=");
        a.append(this.clubIcon);
        a.append(", clubDesc=");
        a.append(this.clubDesc);
        a.append(", clubReset=");
        a.append(this.clubReset);
        a.append(", updateTime=");
        a.append(this.updateTime);
        a.append(", createTime=");
        a.append(this.createTime);
        a.append(", endTime=");
        a.append(this.endTime);
        a.append(", pointRankingList=");
        a.append(this.pointRankingList);
        a.append(", stepRankingList=");
        a.append(this.stepRankingList);
        a.append(", bikeRankingList=");
        return C0681a.m325a(a, (List) this.bikeRankingList, ")");
    }
}
