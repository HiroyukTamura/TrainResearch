package p043jp.reifrontier.silentlogsdkandroid.domain.daily;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001e\u001a\u00020\nH\u0016J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "", "timezone", "", "latitude", "", "longitude", "accuracy", "", "timestamp", "", "(Ljava/lang/String;DDFI)V", "getAccuracy", "()F", "getLatitude", "()D", "getLongitude", "getTimestamp", "()I", "getTimezone", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint */
public final class RFLTrackPoint {
    @SerializedName("timezone")
    @Expose

    /* renamed from: a */
    private final String f3577a;
    @SerializedName("lat")
    @Expose

    /* renamed from: b */
    private final double f3578b;
    @SerializedName("lon")
    @Expose

    /* renamed from: c */
    private final double f3579c;
    @SerializedName("hacc")
    @Expose

    /* renamed from: d */
    private final float f3580d;
    @SerializedName("time")
    @Expose

    /* renamed from: e */
    private final int f3581e;

    public RFLTrackPoint(String str, double d, double d2, float f, int i) {
        Intrinsics.checkParameterIsNotNull(str, "timezone");
        this.f3577a = str;
        this.f3578b = d;
        this.f3579c = d2;
        this.f3580d = f;
        this.f3581e = i;
    }

    public static /* synthetic */ RFLTrackPoint copy$default(RFLTrackPoint rFLTrackPoint, String str, double d, double d2, float f, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rFLTrackPoint.f3577a;
        }
        if ((i2 & 2) != 0) {
            d = rFLTrackPoint.f3578b;
        }
        double d3 = d;
        if ((i2 & 4) != 0) {
            d2 = rFLTrackPoint.f3579c;
        }
        double d4 = d2;
        if ((i2 & 8) != 0) {
            f = rFLTrackPoint.f3580d;
        }
        float f2 = f;
        if ((i2 & 16) != 0) {
            i = rFLTrackPoint.f3581e;
        }
        return rFLTrackPoint.copy(str, d3, d4, f2, i);
    }

    public final String component1() {
        return this.f3577a;
    }

    public final double component2() {
        return this.f3578b;
    }

    public final double component3() {
        return this.f3579c;
    }

    public final float component4() {
        return this.f3580d;
    }

    public final int component5() {
        return this.f3581e;
    }

    public final RFLTrackPoint copy(String str, double d, double d2, float f, int i) {
        Intrinsics.checkParameterIsNotNull(str, "timezone");
        return new RFLTrackPoint(str, d, d2, f, i);
    }

    public boolean equals(Object obj) {
        if (obj != null) {
            return this.f3581e == ((RFLTrackPoint) obj).f3581e;
        }
        throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint");
    }

    public final float getAccuracy() {
        return this.f3580d;
    }

    public final double getLatitude() {
        return this.f3578b;
    }

    public final double getLongitude() {
        return this.f3579c;
    }

    public final int getTimestamp() {
        return this.f3581e;
    }

    public final String getTimezone() {
        return this.f3577a;
    }

    public int hashCode() {
        return this.f3581e;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLTrackPoint(timezone=");
        a.append(this.f3577a);
        a.append(", latitude=");
        a.append(this.f3578b);
        a.append(", longitude=");
        a.append(this.f3579c);
        a.append(", accuracy=");
        a.append(this.f3580d);
        a.append(", timestamp=");
        return C0681a.m322a(a, this.f3581e, ")");
    }
}
