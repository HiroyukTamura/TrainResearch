package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012&\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010.\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\fHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J¶\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072(\b\u0002\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R6\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001b\u0010\u0017R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001c\u0010\u0017R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001e\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0017R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b$\u0010\u0017R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&¨\u0006:"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecast;", "", "unixTime", "", "sunrise", "sunset", "temperature", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecastTemperature;", "feelsLike", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "pressure", "humidity", "weatherList", "", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiWeather;", "windSpeed", "windDegrees", "clouds", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecastTemperature;Ljava/util/HashMap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getClouds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFeelsLike", "()Ljava/util/HashMap;", "getHumidity", "getPressure", "getSunrise", "getSunset", "getTemperature", "()Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecastTemperature;", "getUnixTime", "getWeatherList", "()Ljava/util/List;", "getWindDegrees", "getWindSpeed", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecastTemperature;Ljava/util/HashMap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecast;", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiForecast */
public final class RFLApiForecast {
    @SerializedName("dt")

    /* renamed from: a */
    private final Integer f3759a;
    @SerializedName("sunrise")

    /* renamed from: b */
    private final Integer f3760b;
    @SerializedName("sunset")

    /* renamed from: c */
    private final Integer f3761c;
    @SerializedName("temp")

    /* renamed from: d */
    private final RFLApiForecastTemperature f3762d;
    @SerializedName("feels_like")

    /* renamed from: e */
    private final HashMap<String, Float> f3763e;
    @SerializedName("pressure")

    /* renamed from: f */
    private final Integer f3764f;
    @SerializedName("humidity")

    /* renamed from: g */
    private final Integer f3765g;
    @SerializedName("weather")

    /* renamed from: h */
    private final List<RFLApiWeather> f3766h;
    @SerializedName("speed")

    /* renamed from: i */
    private final Float f3767i;
    @SerializedName("deg")

    /* renamed from: j */
    private final Integer f3768j;
    @SerializedName("clouds")

    /* renamed from: k */
    private final Integer f3769k;

    public RFLApiForecast(Integer num, Integer num2, Integer num3, RFLApiForecastTemperature rFLApiForecastTemperature, HashMap<String, Float> hashMap, Integer num4, Integer num5, List<RFLApiWeather> list, Float f, Integer num6, Integer num7) {
        this.f3759a = num;
        this.f3760b = num2;
        this.f3761c = num3;
        this.f3762d = rFLApiForecastTemperature;
        this.f3763e = hashMap;
        this.f3764f = num4;
        this.f3765g = num5;
        this.f3766h = list;
        this.f3767i = f;
        this.f3768j = num6;
        this.f3769k = num7;
    }

    public static /* synthetic */ RFLApiForecast copy$default(RFLApiForecast rFLApiForecast, Integer num, Integer num2, Integer num3, RFLApiForecastTemperature rFLApiForecastTemperature, HashMap hashMap, Integer num4, Integer num5, List list, Float f, Integer num6, Integer num7, int i, Object obj) {
        RFLApiForecast rFLApiForecast2 = rFLApiForecast;
        int i2 = i;
        return rFLApiForecast.copy((i2 & 1) != 0 ? rFLApiForecast2.f3759a : num, (i2 & 2) != 0 ? rFLApiForecast2.f3760b : num2, (i2 & 4) != 0 ? rFLApiForecast2.f3761c : num3, (i2 & 8) != 0 ? rFLApiForecast2.f3762d : rFLApiForecastTemperature, (i2 & 16) != 0 ? rFLApiForecast2.f3763e : hashMap, (i2 & 32) != 0 ? rFLApiForecast2.f3764f : num4, (i2 & 64) != 0 ? rFLApiForecast2.f3765g : num5, (i2 & 128) != 0 ? rFLApiForecast2.f3766h : list, (i2 & 256) != 0 ? rFLApiForecast2.f3767i : f, (i2 & 512) != 0 ? rFLApiForecast2.f3768j : num6, (i2 & 1024) != 0 ? rFLApiForecast2.f3769k : num7);
    }

    public final Integer component1() {
        return this.f3759a;
    }

    public final Integer component10() {
        return this.f3768j;
    }

    public final Integer component11() {
        return this.f3769k;
    }

    public final Integer component2() {
        return this.f3760b;
    }

    public final Integer component3() {
        return this.f3761c;
    }

    public final RFLApiForecastTemperature component4() {
        return this.f3762d;
    }

    public final HashMap<String, Float> component5() {
        return this.f3763e;
    }

    public final Integer component6() {
        return this.f3764f;
    }

    public final Integer component7() {
        return this.f3765g;
    }

    public final List<RFLApiWeather> component8() {
        return this.f3766h;
    }

    public final Float component9() {
        return this.f3767i;
    }

    public final RFLApiForecast copy(Integer num, Integer num2, Integer num3, RFLApiForecastTemperature rFLApiForecastTemperature, HashMap<String, Float> hashMap, Integer num4, Integer num5, List<RFLApiWeather> list, Float f, Integer num6, Integer num7) {
        return new RFLApiForecast(num, num2, num3, rFLApiForecastTemperature, hashMap, num4, num5, list, f, num6, num7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLApiForecast)) {
            return false;
        }
        RFLApiForecast rFLApiForecast = (RFLApiForecast) obj;
        return Intrinsics.areEqual((Object) this.f3759a, (Object) rFLApiForecast.f3759a) && Intrinsics.areEqual((Object) this.f3760b, (Object) rFLApiForecast.f3760b) && Intrinsics.areEqual((Object) this.f3761c, (Object) rFLApiForecast.f3761c) && Intrinsics.areEqual((Object) this.f3762d, (Object) rFLApiForecast.f3762d) && Intrinsics.areEqual((Object) this.f3763e, (Object) rFLApiForecast.f3763e) && Intrinsics.areEqual((Object) this.f3764f, (Object) rFLApiForecast.f3764f) && Intrinsics.areEqual((Object) this.f3765g, (Object) rFLApiForecast.f3765g) && Intrinsics.areEqual((Object) this.f3766h, (Object) rFLApiForecast.f3766h) && Intrinsics.areEqual((Object) this.f3767i, (Object) rFLApiForecast.f3767i) && Intrinsics.areEqual((Object) this.f3768j, (Object) rFLApiForecast.f3768j) && Intrinsics.areEqual((Object) this.f3769k, (Object) rFLApiForecast.f3769k);
    }

    public final Integer getClouds() {
        return this.f3769k;
    }

    public final HashMap<String, Float> getFeelsLike() {
        return this.f3763e;
    }

    public final Integer getHumidity() {
        return this.f3765g;
    }

    public final Integer getPressure() {
        return this.f3764f;
    }

    public final Integer getSunrise() {
        return this.f3760b;
    }

    public final Integer getSunset() {
        return this.f3761c;
    }

    public final RFLApiForecastTemperature getTemperature() {
        return this.f3762d;
    }

    public final Integer getUnixTime() {
        return this.f3759a;
    }

    public final List<RFLApiWeather> getWeatherList() {
        return this.f3766h;
    }

    public final Integer getWindDegrees() {
        return this.f3768j;
    }

    public final Float getWindSpeed() {
        return this.f3767i;
    }

    public int hashCode() {
        Integer num = this.f3759a;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.f3760b;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.f3761c;
        int hashCode3 = (hashCode2 + (num3 != null ? num3.hashCode() : 0)) * 31;
        RFLApiForecastTemperature rFLApiForecastTemperature = this.f3762d;
        int hashCode4 = (hashCode3 + (rFLApiForecastTemperature != null ? rFLApiForecastTemperature.hashCode() : 0)) * 31;
        HashMap<String, Float> hashMap = this.f3763e;
        int hashCode5 = (hashCode4 + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        Integer num4 = this.f3764f;
        int hashCode6 = (hashCode5 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.f3765g;
        int hashCode7 = (hashCode6 + (num5 != null ? num5.hashCode() : 0)) * 31;
        List<RFLApiWeather> list = this.f3766h;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        Float f = this.f3767i;
        int hashCode9 = (hashCode8 + (f != null ? f.hashCode() : 0)) * 31;
        Integer num6 = this.f3768j;
        int hashCode10 = (hashCode9 + (num6 != null ? num6.hashCode() : 0)) * 31;
        Integer num7 = this.f3769k;
        if (num7 != null) {
            i = num7.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLApiForecast(unixTime=");
        a.append(this.f3759a);
        a.append(", sunrise=");
        a.append(this.f3760b);
        a.append(", sunset=");
        a.append(this.f3761c);
        a.append(", temperature=");
        a.append(this.f3762d);
        a.append(", feelsLike=");
        a.append(this.f3763e);
        a.append(", pressure=");
        a.append(this.f3764f);
        a.append(", humidity=");
        a.append(this.f3765g);
        a.append(", weatherList=");
        a.append(this.f3766h);
        a.append(", windSpeed=");
        a.append(this.f3767i);
        a.append(", windDegrees=");
        a.append(this.f3768j);
        a.append(", clouds=");
        a.append(this.f3769k);
        a.append(")");
        return a.toString();
    }
}
