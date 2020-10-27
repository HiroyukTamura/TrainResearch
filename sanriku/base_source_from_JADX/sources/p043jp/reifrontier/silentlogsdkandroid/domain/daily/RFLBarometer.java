package p043jp.reifrontier.silentlogsdkandroid.domain.daily;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLBarometer;", "", "barometer", "", "timestamp", "", "(DI)V", "getBarometer", "()D", "getTimestamp", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLBarometer */
public final class RFLBarometer {
    @SerializedName("barometer")
    @Expose

    /* renamed from: a */
    private final double f3536a;
    @SerializedName("time")
    @Expose

    /* renamed from: b */
    private final int f3537b;

    public RFLBarometer(double d, int i) {
        this.f3536a = d;
        this.f3537b = i;
    }

    public static /* synthetic */ RFLBarometer copy$default(RFLBarometer rFLBarometer, double d, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = rFLBarometer.f3536a;
        }
        if ((i2 & 2) != 0) {
            i = rFLBarometer.f3537b;
        }
        return rFLBarometer.copy(d, i);
    }

    public final double component1() {
        return this.f3536a;
    }

    public final int component2() {
        return this.f3537b;
    }

    public final RFLBarometer copy(double d, int i) {
        return new RFLBarometer(d, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLBarometer)) {
            return false;
        }
        RFLBarometer rFLBarometer = (RFLBarometer) obj;
        return Double.compare(this.f3536a, rFLBarometer.f3536a) == 0 && this.f3537b == rFLBarometer.f3537b;
    }

    public final double getBarometer() {
        return this.f3536a;
    }

    public final int getTimestamp() {
        return this.f3537b;
    }

    public int hashCode() {
        return (Double.doubleToLongBits(this.f3536a) * 31) + this.f3537b;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLBarometer(barometer=");
        a.append(this.f3536a);
        a.append(", timestamp=");
        return C0681a.m322a(a, this.f3537b, ")");
    }
}
