package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecastWeather;", "", "cod", "", "forecastList", "", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecast;", "(Ljava/lang/String;Ljava/util/List;)V", "getCod", "()Ljava/lang/String;", "getForecastList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiForecastWeather */
public final class RFLApiForecastWeather {
    @SerializedName("cod")

    /* renamed from: a */
    private final String f3776a;
    @SerializedName("list")

    /* renamed from: b */
    private final List<RFLApiForecast> f3777b;

    public RFLApiForecastWeather(String str, List<RFLApiForecast> list) {
        this.f3776a = str;
        this.f3777b = list;
    }

    public static /* synthetic */ RFLApiForecastWeather copy$default(RFLApiForecastWeather rFLApiForecastWeather, String str, List<RFLApiForecast> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rFLApiForecastWeather.f3776a;
        }
        if ((i & 2) != 0) {
            list = rFLApiForecastWeather.f3777b;
        }
        return rFLApiForecastWeather.copy(str, list);
    }

    public final String component1() {
        return this.f3776a;
    }

    public final List<RFLApiForecast> component2() {
        return this.f3777b;
    }

    public final RFLApiForecastWeather copy(String str, List<RFLApiForecast> list) {
        return new RFLApiForecastWeather(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLApiForecastWeather)) {
            return false;
        }
        RFLApiForecastWeather rFLApiForecastWeather = (RFLApiForecastWeather) obj;
        return Intrinsics.areEqual((Object) this.f3776a, (Object) rFLApiForecastWeather.f3776a) && Intrinsics.areEqual((Object) this.f3777b, (Object) rFLApiForecastWeather.f3777b);
    }

    public final String getCod() {
        return this.f3776a;
    }

    public final List<RFLApiForecast> getForecastList() {
        return this.f3777b;
    }

    public int hashCode() {
        String str = this.f3776a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        List<RFLApiForecast> list = this.f3777b;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLApiForecastWeather(cod=");
        a.append(this.f3776a);
        a.append(", forecastList=");
        return C0681a.m325a(a, (List) this.f3777b, ")");
    }
}
