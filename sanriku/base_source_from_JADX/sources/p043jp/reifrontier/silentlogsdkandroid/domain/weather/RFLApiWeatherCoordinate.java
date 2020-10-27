package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiWeatherCoordinate;", "", "lat", "", "lon", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getLat", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLon", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiWeatherCoordinate;", "equals", "", "other", "hashCode", "", "toString", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiWeatherCoordinate */
public final class RFLApiWeatherCoordinate {
    @SerializedName("lat")

    /* renamed from: a */
    private final Double f3782a;
    @SerializedName("lon")

    /* renamed from: b */
    private final Double f3783b;

    public RFLApiWeatherCoordinate(Double d, Double d2) {
        this.f3782a = d;
        this.f3783b = d2;
    }

    public static /* synthetic */ RFLApiWeatherCoordinate copy$default(RFLApiWeatherCoordinate rFLApiWeatherCoordinate, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = rFLApiWeatherCoordinate.f3782a;
        }
        if ((i & 2) != 0) {
            d2 = rFLApiWeatherCoordinate.f3783b;
        }
        return rFLApiWeatherCoordinate.copy(d, d2);
    }

    public final Double component1() {
        return this.f3782a;
    }

    public final Double component2() {
        return this.f3783b;
    }

    public final RFLApiWeatherCoordinate copy(Double d, Double d2) {
        return new RFLApiWeatherCoordinate(d, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLApiWeatherCoordinate)) {
            return false;
        }
        RFLApiWeatherCoordinate rFLApiWeatherCoordinate = (RFLApiWeatherCoordinate) obj;
        return Intrinsics.areEqual((Object) this.f3782a, (Object) rFLApiWeatherCoordinate.f3782a) && Intrinsics.areEqual((Object) this.f3783b, (Object) rFLApiWeatherCoordinate.f3783b);
    }

    public final Double getLat() {
        return this.f3782a;
    }

    public final Double getLon() {
        return this.f3783b;
    }

    public int hashCode() {
        Double d = this.f3782a;
        int i = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 31;
        Double d2 = this.f3783b;
        if (d2 != null) {
            i = d2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLApiWeatherCoordinate(lat=");
        a.append(this.f3782a);
        a.append(", lon=");
        a.append(this.f3783b);
        a.append(")");
        return a.toString();
    }
}
