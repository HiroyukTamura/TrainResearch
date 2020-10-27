package p043jp.reifrontier.silentlogsdkandroid.domain.p121db;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityAdjustTrackPoint;", "", "fromDate", "", "toDate", "data", "", "(II[B)V", "adjustTrackPoints", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "getAdjustTrackPoints", "()Ljava/util/List;", "getData", "()[B", "getFromDate", "()I", "getToDate", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint */
public final class RFLEntityAdjustTrackPoint {

    /* renamed from: a */
    private final int f3631a;

    /* renamed from: b */
    private final int f3632b;

    /* renamed from: c */
    private final byte[] f3633c;

    public RFLEntityAdjustTrackPoint(int i, int i2, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        this.f3631a = i;
        this.f3632b = i2;
        this.f3633c = bArr;
    }

    public static /* synthetic */ RFLEntityAdjustTrackPoint copy$default(RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint, int i, int i2, byte[] bArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = rFLEntityAdjustTrackPoint.f3631a;
        }
        if ((i3 & 2) != 0) {
            i2 = rFLEntityAdjustTrackPoint.f3632b;
        }
        if ((i3 & 4) != 0) {
            bArr = rFLEntityAdjustTrackPoint.f3633c;
        }
        return rFLEntityAdjustTrackPoint.copy(i, i2, bArr);
    }

    public final int component1() {
        return this.f3631a;
    }

    public final int component2() {
        return this.f3632b;
    }

    public final byte[] component3() {
        return this.f3633c;
    }

    public final RFLEntityAdjustTrackPoint copy(int i, int i2, byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        return new RFLEntityAdjustTrackPoint(i, i2, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) RFLEntityAdjustTrackPoint.class, (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            RFLEntityAdjustTrackPoint rFLEntityAdjustTrackPoint = (RFLEntityAdjustTrackPoint) obj;
            return this.f3631a == rFLEntityAdjustTrackPoint.f3631a && this.f3632b == rFLEntityAdjustTrackPoint.f3632b && Arrays.equals(this.f3633c, rFLEntityAdjustTrackPoint.f3633c);
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint");
    }

    public final List<RFLTrackPoint> getAdjustTrackPoints() {
        Type type = new RFLEntityAdjustTrackPoint$adjustTrackPoints$type$1().getType();
        Object fromJson = new Gson().fromJson(new String(this.f3633c, Charsets.UTF_8), type);
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson<List<RFL…ckPoint>>(jsonData, type)");
        return (List) fromJson;
    }

    public final byte[] getData() {
        return this.f3633c;
    }

    public final int getFromDate() {
        return this.f3631a;
    }

    public final int getToDate() {
        return this.f3632b;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3633c) + (((this.f3631a * 31) + this.f3632b) * 31);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLEntityAdjustTrackPoint(fromDate=");
        a.append(this.f3631a);
        a.append(", toDate=");
        a.append(this.f3632b);
        a.append(", data=");
        a.append(Arrays.toString(this.f3633c));
        a.append(")");
        return a.toString();
    }
}
