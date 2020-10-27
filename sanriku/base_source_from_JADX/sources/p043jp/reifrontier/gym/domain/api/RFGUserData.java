package p043jp.reifrontier.gym.domain.api;

import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010$\u001a\u00020%H\u0002J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J[\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u00103\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u00020\u0003HÖ\u0001J\u000e\u00106\u001a\u00020\u00052\u0006\u0010'\u001a\u00020(J\b\u00107\u001a\u00020%H\u0002J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015¨\u00069"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUserData;", "", "order", "", "gymId", "", "handleName", "icon", "point", "bike", "step", "auth", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAuth", "()Z", "setAuth", "(Z)V", "getBike", "()Ljava/lang/String;", "setBike", "(Ljava/lang/String;)V", "getGymId", "setGymId", "getHandleName", "setHandleName", "getIcon", "setIcon", "getOrder", "()I", "setOrder", "(I)V", "getPoint", "setPoint", "getStep", "setStep", "bikeF", "", "clubRankData", "type", "Ljp/reifrontier/gym/RFGDef$RankingType;", "dateCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "listData", "stepF", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGUserData */
public final class RFGUserData {
    @SerializedName("auth_flag")
    private boolean auth;
    @SerializedName("bicycle")
    private String bike;
    @SerializedName("sl2_id")
    private String gymId;
    @SerializedName("handle_name")
    private String handleName;
    @SerializedName("icon")
    private String icon;
    @SerializedName("ord")
    private int order;
    @SerializedName("point")
    private String point;
    @SerializedName("step")
    private String step;

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.domain.api.RFGUserData$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RFGDef.RankingType.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFGDef.RankingType rankingType = RFGDef.RankingType.POINT;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFGDef.RankingType rankingType2 = RFGDef.RankingType.STEPS;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFGDef.RankingType rankingType3 = RFGDef.RankingType.BIKE;
            iArr3[2] = 3;
            int[] iArr4 = new int[RFGDef.RankingType.values().length];
            $EnumSwitchMapping$1 = iArr4;
            RFGDef.RankingType rankingType4 = RFGDef.RankingType.POINT;
            iArr4[0] = 1;
            int[] iArr5 = $EnumSwitchMapping$1;
            RFGDef.RankingType rankingType5 = RFGDef.RankingType.STEPS;
            iArr5[1] = 2;
            int[] iArr6 = $EnumSwitchMapping$1;
            RFGDef.RankingType rankingType6 = RFGDef.RankingType.BIKE;
            iArr6[2] = 3;
        }
    }

    public RFGUserData() {
        this(0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, 255, (DefaultConstructorMarker) null);
    }

    public RFGUserData(int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "gymId");
        Intrinsics.checkParameterIsNotNull(str2, "handleName");
        Intrinsics.checkParameterIsNotNull(str4, "point");
        Intrinsics.checkParameterIsNotNull(str5, "bike");
        Intrinsics.checkParameterIsNotNull(str6, "step");
        this.order = i;
        this.gymId = str;
        this.handleName = str2;
        this.icon = str3;
        this.point = str4;
        this.bike = str5;
        this.step = str6;
        this.auth = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGUserData(int r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, boolean r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0013
        L_0x0012:
            r3 = r12
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r4 = r13
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = 0
            goto L_0x0020
        L_0x001f:
            r5 = r14
        L_0x0020:
            r6 = r0 & 16
            java.lang.String r7 = "0"
            if (r6 == 0) goto L_0x0028
            r6 = r7
            goto L_0x0029
        L_0x0028:
            r6 = r15
        L_0x0029:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            java.lang.String r8 = "0.0"
            goto L_0x0032
        L_0x0030:
            r8 = r16
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r7 = r17
        L_0x0039:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r2 = r18
        L_0x0040:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r4
            r15 = r5
            r16 = r6
            r17 = r8
            r18 = r7
            r19 = r2
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.api.RFGUserData.<init>(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    private final float bikeF() {
        return Float.parseFloat(this.bike);
    }

    public static /* synthetic */ RFGUserData copy$default(RFGUserData rFGUserData, int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i2, Object obj) {
        RFGUserData rFGUserData2 = rFGUserData;
        int i3 = i2;
        return rFGUserData.copy((i3 & 1) != 0 ? rFGUserData2.order : i, (i3 & 2) != 0 ? rFGUserData2.gymId : str, (i3 & 4) != 0 ? rFGUserData2.handleName : str2, (i3 & 8) != 0 ? rFGUserData2.icon : str3, (i3 & 16) != 0 ? rFGUserData2.point : str4, (i3 & 32) != 0 ? rFGUserData2.bike : str5, (i3 & 64) != 0 ? rFGUserData2.step : str6, (i3 & 128) != 0 ? rFGUserData2.auth : z);
    }

    private final float stepF() {
        return Float.parseFloat(this.step) / ((float) 10000);
    }

    public final String clubRankData(RFGDef.RankingType rankingType, int i) {
        String str;
        Intrinsics.checkParameterIsNotNull(rankingType, "type");
        int ordinal = rankingType.ordinal();
        if (ordinal == 0) {
            return this.point;
        }
        if (ordinal == 1) {
            float parseFloat = Float.parseFloat(this.step) / ((float) i);
            Locale locale = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            str = String.format(locale, "%.0f", Arrays.copyOf(new Object[]{Float.valueOf(parseFloat)}, 1));
        } else if (ordinal == 2) {
            float bikeF = bikeF() / ((float) i);
            Locale locale2 = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.US");
            str = String.format(locale2, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(bikeF)}, 1));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(locale, this, *args)");
        return str;
    }

    public final int component1() {
        return this.order;
    }

    public final String component2() {
        return this.gymId;
    }

    public final String component3() {
        return this.handleName;
    }

    public final String component4() {
        return this.icon;
    }

    public final String component5() {
        return this.point;
    }

    public final String component6() {
        return this.bike;
    }

    public final String component7() {
        return this.step;
    }

    public final boolean component8() {
        return this.auth;
    }

    public final RFGUserData copy(int i, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "gymId");
        Intrinsics.checkParameterIsNotNull(str2, "handleName");
        Intrinsics.checkParameterIsNotNull(str4, "point");
        String str7 = str5;
        Intrinsics.checkParameterIsNotNull(str7, "bike");
        String str8 = str6;
        Intrinsics.checkParameterIsNotNull(str8, "step");
        return new RFGUserData(i, str, str2, str3, str4, str7, str8, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGUserData)) {
            return false;
        }
        RFGUserData rFGUserData = (RFGUserData) obj;
        return this.order == rFGUserData.order && Intrinsics.areEqual((Object) this.gymId, (Object) rFGUserData.gymId) && Intrinsics.areEqual((Object) this.handleName, (Object) rFGUserData.handleName) && Intrinsics.areEqual((Object) this.icon, (Object) rFGUserData.icon) && Intrinsics.areEqual((Object) this.point, (Object) rFGUserData.point) && Intrinsics.areEqual((Object) this.bike, (Object) rFGUserData.bike) && Intrinsics.areEqual((Object) this.step, (Object) rFGUserData.step) && this.auth == rFGUserData.auth;
    }

    public final boolean getAuth() {
        return this.auth;
    }

    public final String getBike() {
        return this.bike;
    }

    public final String getGymId() {
        return this.gymId;
    }

    public final String getHandleName() {
        return this.handleName;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final int getOrder() {
        return this.order;
    }

    public final String getPoint() {
        return this.point;
    }

    public final String getStep() {
        return this.step;
    }

    public int hashCode() {
        int i = this.order * 31;
        String str = this.gymId;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.handleName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.icon;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.point;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.bike;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.step;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = (hashCode5 + i2) * 31;
        boolean z = this.auth;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String listData(RFGDef.RankingType rankingType) {
        String str;
        Intrinsics.checkParameterIsNotNull(rankingType, "type");
        int ordinal = rankingType.ordinal();
        if (ordinal == 0) {
            return this.point;
        }
        if (ordinal == 1) {
            Locale locale = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.US");
            str = String.format(locale, "%.2f", Arrays.copyOf(new Object[]{Float.valueOf(stepF())}, 1));
        } else if (ordinal == 2) {
            Locale locale2 = Locale.US;
            Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.US");
            str = String.format(locale2, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(bikeF())}, 1));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(locale, this, *args)");
        return str;
    }

    public final void setAuth(boolean z) {
        this.auth = z;
    }

    public final void setBike(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.bike = str;
    }

    public final void setGymId(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.gymId = str;
    }

    public final void setHandleName(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.handleName = str;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setOrder(int i) {
        this.order = i;
    }

    public final void setPoint(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.point = str;
    }

    public final void setStep(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.step = str;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGUserData(order=");
        a.append(this.order);
        a.append(", gymId=");
        a.append(this.gymId);
        a.append(", handleName=");
        a.append(this.handleName);
        a.append(", icon=");
        a.append(this.icon);
        a.append(", point=");
        a.append(this.point);
        a.append(", bike=");
        a.append(this.bike);
        a.append(", step=");
        a.append(this.step);
        a.append(", auth=");
        a.append(this.auth);
        a.append(")");
        return a.toString();
    }
}
