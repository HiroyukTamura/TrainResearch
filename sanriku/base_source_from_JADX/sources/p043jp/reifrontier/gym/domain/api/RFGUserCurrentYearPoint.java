package p043jp.reifrontier.gym.domain.api;

import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0015H\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003JO\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\b\u00100\u001a\u00020\u0015H\u0016J\b\u00101\u001a\u00020\u0015H\u0016J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\b\u00107\u001a\u00020\u0015H\u0016J\b\u00108\u001a\u00020\u0015H\u0016J\b\u00109\u001a\u00020\u0015H\u0016J\b\u0010:\u001a\u00020\u0006H\u0016J\b\u0010;\u001a\u00020\u0015H\u0016J\t\u0010<\u001a\u00020\u0015HÖ\u0001J\b\u0010=\u001a\u00020\u0015H\u0016J\b\u0010>\u001a\u00020\u0006H\u0016J\b\u0010?\u001a\u00020\u0015H\u0016J\b\u0010@\u001a\u00020\u0015H\u0016J\b\u0010A\u001a\u00020\u0006H\u0016J\b\u0010B\u001a\u00020\u0015H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u001e\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0017R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000f¨\u0006C"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/api/RFGUserCurrentYearPoint;", "Ljp/reifrontier/gym/domain/api/RFGPanelData;", "aDayNumber", "", "allPoint", "step", "", "walkPoint", "distanceBicycle", "bicyclePoint", "otherPoint", "(IIFIFII)V", "getADayNumber", "()I", "setADayNumber", "(I)V", "getAllPoint", "setAllPoint", "getBicyclePoint", "setBicyclePoint", "date", "", "getDate", "()Ljava/lang/String;", "dayNumber", "getDayNumber", "getDistanceBicycle", "()F", "setDistanceBicycle", "(F)V", "getOtherPoint", "setOtherPoint", "getStep", "setStep", "type", "getType", "getWalkPoint", "setWalkPoint", "bicyclePointF", "bikePointText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "distanceBikeText", "distanceRunText", "equals", "", "other", "", "hashCode", "metsText", "otherPointText", "point", "pointF", "stepText", "toString", "train", "trainPointF", "trainPointText", "walk", "walkPointF", "walkPointText", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.api.RFGUserCurrentYearPoint */
public final class RFGUserCurrentYearPoint implements RFGPanelData {
    @SerializedName("day_num")
    private int aDayNumber;
    @SerializedName("point")
    private int allPoint;
    @SerializedName("bike_point")
    private int bicyclePoint;
    @SerializedName("bike_avg")
    private float distanceBicycle;
    @SerializedName("other_point")
    private int otherPoint;
    @SerializedName("step_avg")
    private float step;
    @SerializedName("step_point")
    private int walkPoint;

    public RFGUserCurrentYearPoint() {
        this(0, 0, 0.0f, 0, 0.0f, 0, 0, 127, (DefaultConstructorMarker) null);
    }

    public RFGUserCurrentYearPoint(int i, int i2, float f, int i3, float f2, int i4, int i5) {
        this.aDayNumber = i;
        this.allPoint = i2;
        this.step = f;
        this.walkPoint = i3;
        this.distanceBicycle = f2;
        this.bicyclePoint = i4;
        this.otherPoint = i5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFGUserCurrentYearPoint(int r7, int r8, float r9, int r10, float r11, int r12, int r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = 0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = 0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            r8 = 0
            if (r7 == 0) goto L_0x0016
            r2 = 0
            goto L_0x0017
        L_0x0016:
            r2 = r9
        L_0x0017:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001d
            r3 = 0
            goto L_0x001e
        L_0x001d:
            r3 = r10
        L_0x001e:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0024
            r4 = 0
            goto L_0x0025
        L_0x0024:
            r4 = r11
        L_0x0025:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002b
            r5 = 0
            goto L_0x002c
        L_0x002b:
            r5 = r12
        L_0x002c:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0032
            r14 = 0
            goto L_0x0033
        L_0x0032:
            r14 = r13
        L_0x0033:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.gym.domain.api.RFGUserCurrentYearPoint.<init>(int, int, float, int, float, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFGUserCurrentYearPoint copy$default(RFGUserCurrentYearPoint rFGUserCurrentYearPoint, int i, int i2, float f, int i3, float f2, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = rFGUserCurrentYearPoint.aDayNumber;
        }
        if ((i6 & 2) != 0) {
            i2 = rFGUserCurrentYearPoint.allPoint;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            f = rFGUserCurrentYearPoint.step;
        }
        float f3 = f;
        if ((i6 & 8) != 0) {
            i3 = rFGUserCurrentYearPoint.walkPoint;
        }
        int i8 = i3;
        if ((i6 & 16) != 0) {
            f2 = rFGUserCurrentYearPoint.distanceBicycle;
        }
        float f4 = f2;
        if ((i6 & 32) != 0) {
            i4 = rFGUserCurrentYearPoint.bicyclePoint;
        }
        int i9 = i4;
        if ((i6 & 64) != 0) {
            i5 = rFGUserCurrentYearPoint.otherPoint;
        }
        return rFGUserCurrentYearPoint.copy(i, i7, f3, i8, f4, i9, i5);
    }

    public float bicyclePointF() {
        return (float) this.bicyclePoint;
    }

    public String bikePointText() {
        return C0681a.m328a(new Object[]{Integer.valueOf(this.bicyclePoint)}, 1, "%d", "java.lang.String.format(this, *args)");
    }

    public final int component1() {
        return this.aDayNumber;
    }

    public final int component2() {
        return this.allPoint;
    }

    public final float component3() {
        return this.step;
    }

    public final int component4() {
        return this.walkPoint;
    }

    public final float component5() {
        return this.distanceBicycle;
    }

    public final int component6() {
        return this.bicyclePoint;
    }

    public final int component7() {
        return this.otherPoint;
    }

    public final RFGUserCurrentYearPoint copy(int i, int i2, float f, int i3, float f2, int i4, int i5) {
        return new RFGUserCurrentYearPoint(i, i2, f, i3, f2, i4, i5);
    }

    public String distanceBikeText() {
        return C0681a.m328a(new Object[]{Float.valueOf(this.distanceBicycle)}, 1, "%.1f", "java.lang.String.format(this, *args)");
    }

    public String distanceRunText() {
        return IdManager.DEFAULT_VERSION_NAME;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFGUserCurrentYearPoint)) {
            return false;
        }
        RFGUserCurrentYearPoint rFGUserCurrentYearPoint = (RFGUserCurrentYearPoint) obj;
        return this.aDayNumber == rFGUserCurrentYearPoint.aDayNumber && this.allPoint == rFGUserCurrentYearPoint.allPoint && Float.compare(this.step, rFGUserCurrentYearPoint.step) == 0 && this.walkPoint == rFGUserCurrentYearPoint.walkPoint && Float.compare(this.distanceBicycle, rFGUserCurrentYearPoint.distanceBicycle) == 0 && this.bicyclePoint == rFGUserCurrentYearPoint.bicyclePoint && this.otherPoint == rFGUserCurrentYearPoint.otherPoint;
    }

    public final int getADayNumber() {
        return this.aDayNumber;
    }

    public final int getAllPoint() {
        return this.allPoint;
    }

    public final int getBicyclePoint() {
        return this.bicyclePoint;
    }

    public String getDate() {
        return "";
    }

    public int getDayNumber() {
        return this.aDayNumber;
    }

    public final float getDistanceBicycle() {
        return this.distanceBicycle;
    }

    public final int getOtherPoint() {
        return this.otherPoint;
    }

    public final float getStep() {
        return this.step;
    }

    public String getType() {
        return "total";
    }

    public final int getWalkPoint() {
        return this.walkPoint;
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.step);
        return ((((Float.floatToIntBits(this.distanceBicycle) + ((((floatToIntBits + (((this.aDayNumber * 31) + this.allPoint) * 31)) * 31) + this.walkPoint) * 31)) * 31) + this.bicyclePoint) * 31) + this.otherPoint;
    }

    public String metsText() {
        return C0681a.m328a(new Object[]{Float.valueOf(0.0f)}, 1, "%.2f", "java.lang.String.format(this, *args)");
    }

    public String otherPointText() {
        return C0681a.m328a(new Object[]{Integer.valueOf(this.otherPoint)}, 1, "%d", "java.lang.String.format(this, *args)");
    }

    public String point() {
        return C0681a.m328a(new Object[]{Integer.valueOf(this.allPoint)}, 1, "%d", "java.lang.String.format(this, *args)");
    }

    public float pointF() {
        return ((float) this.walkPoint) + ((float) this.bicyclePoint) + ((float) this.otherPoint);
    }

    public final void setADayNumber(int i) {
        this.aDayNumber = i;
    }

    public final void setAllPoint(int i) {
        this.allPoint = i;
    }

    public final void setBicyclePoint(int i) {
        this.bicyclePoint = i;
    }

    public final void setDistanceBicycle(float f) {
        this.distanceBicycle = f;
    }

    public final void setOtherPoint(int i) {
        this.otherPoint = i;
    }

    public final void setStep(float f) {
        this.step = f;
    }

    public final void setWalkPoint(int i) {
        this.walkPoint = i;
    }

    public String stepText() {
        return C0681a.m328a(new Object[]{Float.valueOf(this.step)}, 1, "%.1f", "java.lang.String.format(this, *args)");
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFGUserCurrentYearPoint(aDayNumber=");
        a.append(this.aDayNumber);
        a.append(", allPoint=");
        a.append(this.allPoint);
        a.append(", step=");
        a.append(this.step);
        a.append(", walkPoint=");
        a.append(this.walkPoint);
        a.append(", distanceBicycle=");
        a.append(this.distanceBicycle);
        a.append(", bicyclePoint=");
        a.append(this.bicyclePoint);
        a.append(", otherPoint=");
        return C0681a.m322a(a, this.otherPoint, ")");
    }

    public String train() {
        return RFGDef.DEFAULT_GYM_ID;
    }

    public float trainPointF() {
        return 0.0f;
    }

    public String trainPointText() {
        return C0681a.m328a(new Object[]{Float.valueOf(0.0f)}, 1, "%.1f", "java.lang.String.format(this, *args)");
    }

    public String walk() {
        return C0681a.m328a(new Object[]{Float.valueOf(walkPointF())}, 1, "%.0f", "java.lang.String.format(this, *args)");
    }

    public float walkPointF() {
        return (float) this.walkPoint;
    }

    public String walkPointText() {
        return C0681a.m328a(new Object[]{Float.valueOf(walkPointF())}, 1, "%.0f", "java.lang.String.format(this, *args)");
    }
}
