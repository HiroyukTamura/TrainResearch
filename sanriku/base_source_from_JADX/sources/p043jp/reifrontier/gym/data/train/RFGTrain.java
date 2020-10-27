package p043jp.reifrontier.gym.data.train;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\u0002\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0003J[\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bHÆ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0006HÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001b¨\u0006."}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/RFGTrain;", "", "trainNo", "", "type", "fromStationId", "", "toStationId", "stopHoliday", "", "schedules", "", "Ljp/reifrontier/gym/data/train/RFGTrainSchedule;", "transferStationIds", "(Ljava/lang/String;Ljava/lang/String;IIZLjava/util/List;Ljava/util/List;)V", "getFromStationId", "()I", "getSchedules", "()Ljava/util/List;", "getStopHoliday", "()Z", "getToStationId", "trainIndex", "getTrainIndex", "setTrainIndex", "(I)V", "getTrainNo", "()Ljava/lang/String;", "trainType", "Ljp/reifrontier/gym/RFGDef$TrainType;", "getTrainType", "()Ljp/reifrontier/gym/RFGDef$TrainType;", "getTransferStationIds", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGTrain */
public final class RFGTrain {
    @SerializedName("from")
    private final int fromStationId;
    @SerializedName("schedules")
    private final List<RFGTrainSchedule> schedules;
    @SerializedName("stop_holiday")
    private final boolean stopHoliday;
    @SerializedName("to")
    private final int toStationId;
    private int trainIndex;
    @SerializedName("train_id")
    private final String trainNo;
    @SerializedName("transfer")
    private final List<Integer> transferStationIds;
    @SerializedName("type")
    private final String type;

    public RFGTrain(String str, String str2, int i, int i2, boolean z, List<RFGTrainSchedule> list, List<Integer> list2) {
        Intrinsics.checkParameterIsNotNull(str, "trainNo");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Intrinsics.checkParameterIsNotNull(list, "schedules");
        Intrinsics.checkParameterIsNotNull(list2, "transferStationIds");
        this.trainNo = str;
        this.type = str2;
        this.fromStationId = i;
        this.toStationId = i2;
        this.stopHoliday = z;
        this.schedules = list;
        this.transferStationIds = list2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGTrain(java.lang.String r11, java.lang.String r12, int r13, int r14, boolean r15, java.util.List r16, java.util.List r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r10 = this;
            r0 = r18 & 2
            if (r0 == 0) goto L_0x0024
            jp.reifrontier.gym.RFGDef$TrainType r0 = p043jp.reifrontier.gym.RFGDef.TrainType.UP
            java.lang.String r0 = "UP"
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r2 = "Locale.ENGLISH"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            if (r0 == 0) goto L_0x001c
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r4 = r0
            goto L_0x0025
        L_0x001c:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        L_0x0024:
            r4 = r12
        L_0x0025:
            r2 = r10
            r3 = r11
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r17
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.data.train.RFGTrain.<init>(java.lang.String, java.lang.String, int, int, boolean, java.util.List, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFGTrain copy$default(RFGTrain rFGTrain, String str, String str2, int i, int i2, boolean z, List<RFGTrainSchedule> list, List<Integer> list2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = rFGTrain.trainNo;
        }
        if ((i3 & 2) != 0) {
            str2 = rFGTrain.type;
        }
        String str3 = str2;
        if ((i3 & 4) != 0) {
            i = rFGTrain.fromStationId;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = rFGTrain.toStationId;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            z = rFGTrain.stopHoliday;
        }
        boolean z2 = z;
        if ((i3 & 32) != 0) {
            list = rFGTrain.schedules;
        }
        List<RFGTrainSchedule> list3 = list;
        if ((i3 & 64) != 0) {
            list2 = rFGTrain.transferStationIds;
        }
        return rFGTrain.copy(str, str3, i4, i5, z2, list3, list2);
    }

    public final String component1() {
        return this.trainNo;
    }

    public final String component2() {
        return this.type;
    }

    public final int component3() {
        return this.fromStationId;
    }

    public final int component4() {
        return this.toStationId;
    }

    public final boolean component5() {
        return this.stopHoliday;
    }

    public final List<RFGTrainSchedule> component6() {
        return this.schedules;
    }

    public final List<Integer> component7() {
        return this.transferStationIds;
    }

    public final RFGTrain copy(String str, String str2, int i, int i2, boolean z, List<RFGTrainSchedule> list, List<Integer> list2) {
        Intrinsics.checkParameterIsNotNull(str, "trainNo");
        Intrinsics.checkParameterIsNotNull(str2, "type");
        Intrinsics.checkParameterIsNotNull(list, "schedules");
        List<Integer> list3 = list2;
        Intrinsics.checkParameterIsNotNull(list3, "transferStationIds");
        return new RFGTrain(str, str2, i, i2, z, list, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGTrain)) {
            return false;
        }
        RFGTrain rFGTrain = (RFGTrain) obj;
        return Intrinsics.areEqual((Object) this.trainNo, (Object) rFGTrain.trainNo) && Intrinsics.areEqual((Object) this.type, (Object) rFGTrain.type) && this.fromStationId == rFGTrain.fromStationId && this.toStationId == rFGTrain.toStationId && this.stopHoliday == rFGTrain.stopHoliday && Intrinsics.areEqual((Object) this.schedules, (Object) rFGTrain.schedules) && Intrinsics.areEqual((Object) this.transferStationIds, (Object) rFGTrain.transferStationIds);
    }

    public final int getFromStationId() {
        return this.fromStationId;
    }

    public final List<RFGTrainSchedule> getSchedules() {
        return this.schedules;
    }

    public final boolean getStopHoliday() {
        return this.stopHoliday;
    }

    public final int getToStationId() {
        return this.toStationId;
    }

    public final int getTrainIndex() {
        return this.trainIndex;
    }

    public final String getTrainNo() {
        return this.trainNo;
    }

    public final RFGDef.TrainType getTrainType() {
        String str = this.type;
        RFGDef.TrainType trainType = RFGDef.TrainType.UP;
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
        if ("UP" != 0) {
            String lowerCase = "UP".toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return Intrinsics.areEqual((Object) str, (Object) lowerCase) ? RFGDef.TrainType.UP : RFGDef.TrainType.DOWN;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public final List<Integer> getTransferStationIds() {
        return this.transferStationIds;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.trainNo;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.fromStationId) * 31) + this.toStationId) * 31;
        boolean z = this.stopHoliday;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        List<RFGTrainSchedule> list = this.schedules;
        int hashCode3 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        List<Integer> list2 = this.transferStationIds;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode3 + i;
    }

    public final void setTrainIndex(int i) {
        this.trainIndex = i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGTrain(trainNo=");
        a.append(this.trainNo);
        a.append(", type=");
        a.append(this.type);
        a.append(", fromStationId=");
        a.append(this.fromStationId);
        a.append(", toStationId=");
        a.append(this.toStationId);
        a.append(", stopHoliday=");
        a.append(this.stopHoliday);
        a.append(", schedules=");
        a.append(this.schedules);
        a.append(", transferStationIds=");
        return C0681a.m325a(a, (List) this.transferStationIds, ")");
    }
}
