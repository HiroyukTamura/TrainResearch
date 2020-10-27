package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012&\u0010\r\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f\u0012&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012&\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010.\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010/\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ)\u00105\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000fHÆ\u0003J)\u00106\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000fHÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ)\u00108\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000fHÆ\u0003J\u0002\u00109\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2(\b\u0002\u0010\r\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f2(\b\u0002\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2(\b\u0002\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010:J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020\fHÖ\u0001J\t\u0010?\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R6\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R6\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b&\u0010\u001bR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b'\u0010\u001bR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b(\u0010\u001bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R6\u0010\r\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u000f8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001f¨\u0006@"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentWeather;", "", "coordinate", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiWeatherCoordinate;", "weatherList", "", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiWeather;", "base", "", "main", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentMain;", "visibility", "", "wind", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "clouds", "unixTime", "systemInfo", "timezone", "cityId", "cityName", "cod", "(Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiWeatherCoordinate;Ljava/util/List;Ljava/lang/String;Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentMain;Ljava/lang/Integer;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/lang/Integer;Ljava/util/HashMap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getBase", "()Ljava/lang/String;", "getCityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCityName", "getClouds", "()Ljava/util/HashMap;", "getCod", "getCoordinate", "()Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiWeatherCoordinate;", "getMain", "()Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentMain;", "getSystemInfo", "getTimezone", "getUnixTime", "getVisibility", "getWeatherList", "()Ljava/util/List;", "getWind", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiWeatherCoordinate;Ljava/util/List;Ljava/lang/String;Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentMain;Ljava/lang/Integer;Ljava/util/HashMap;Ljava/util/HashMap;Ljava/lang/Integer;Ljava/util/HashMap;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentWeather;", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiCurrentWeather */
public final class RFLApiCurrentWeather {
    @SerializedName("coord")

    /* renamed from: a */
    private final RFLApiWeatherCoordinate f3746a;
    @SerializedName("weather")

    /* renamed from: b */
    private final List<RFLApiWeather> f3747b;
    @SerializedName("base")

    /* renamed from: c */
    private final String f3748c;
    @SerializedName("main")

    /* renamed from: d */
    private final RFLApiCurrentMain f3749d;
    @SerializedName("visibility")

    /* renamed from: e */
    private final Integer f3750e;
    @SerializedName("wind")

    /* renamed from: f */
    private final HashMap<String, Object> f3751f;
    @SerializedName("clouds")

    /* renamed from: g */
    private final HashMap<String, Object> f3752g;
    @SerializedName("dt")

    /* renamed from: h */
    private final Integer f3753h;
    @SerializedName("sys")

    /* renamed from: i */
    private final HashMap<String, Object> f3754i;
    @SerializedName("timezone")

    /* renamed from: j */
    private final Integer f3755j;
    @SerializedName("id")

    /* renamed from: k */
    private final Integer f3756k;
    @SerializedName("name")

    /* renamed from: l */
    private final String f3757l;
    @SerializedName("cod")

    /* renamed from: m */
    private final Integer f3758m;

    public RFLApiCurrentWeather(RFLApiWeatherCoordinate rFLApiWeatherCoordinate, List<RFLApiWeather> list, String str, RFLApiCurrentMain rFLApiCurrentMain, Integer num, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, Integer num2, HashMap<String, Object> hashMap3, Integer num3, Integer num4, String str2, Integer num5) {
        this.f3746a = rFLApiWeatherCoordinate;
        this.f3747b = list;
        this.f3748c = str;
        this.f3749d = rFLApiCurrentMain;
        this.f3750e = num;
        this.f3751f = hashMap;
        this.f3752g = hashMap2;
        this.f3753h = num2;
        this.f3754i = hashMap3;
        this.f3755j = num3;
        this.f3756k = num4;
        this.f3757l = str2;
        this.f3758m = num5;
    }

    public static /* synthetic */ RFLApiCurrentWeather copy$default(RFLApiCurrentWeather rFLApiCurrentWeather, RFLApiWeatherCoordinate rFLApiWeatherCoordinate, List list, String str, RFLApiCurrentMain rFLApiCurrentMain, Integer num, HashMap hashMap, HashMap hashMap2, Integer num2, HashMap hashMap3, Integer num3, Integer num4, String str2, Integer num5, int i, Object obj) {
        RFLApiCurrentWeather rFLApiCurrentWeather2 = rFLApiCurrentWeather;
        int i2 = i;
        return rFLApiCurrentWeather.copy((i2 & 1) != 0 ? rFLApiCurrentWeather2.f3746a : rFLApiWeatherCoordinate, (i2 & 2) != 0 ? rFLApiCurrentWeather2.f3747b : list, (i2 & 4) != 0 ? rFLApiCurrentWeather2.f3748c : str, (i2 & 8) != 0 ? rFLApiCurrentWeather2.f3749d : rFLApiCurrentMain, (i2 & 16) != 0 ? rFLApiCurrentWeather2.f3750e : num, (i2 & 32) != 0 ? rFLApiCurrentWeather2.f3751f : hashMap, (i2 & 64) != 0 ? rFLApiCurrentWeather2.f3752g : hashMap2, (i2 & 128) != 0 ? rFLApiCurrentWeather2.f3753h : num2, (i2 & 256) != 0 ? rFLApiCurrentWeather2.f3754i : hashMap3, (i2 & 512) != 0 ? rFLApiCurrentWeather2.f3755j : num3, (i2 & 1024) != 0 ? rFLApiCurrentWeather2.f3756k : num4, (i2 & 2048) != 0 ? rFLApiCurrentWeather2.f3757l : str2, (i2 & 4096) != 0 ? rFLApiCurrentWeather2.f3758m : num5);
    }

    public final RFLApiWeatherCoordinate component1() {
        return this.f3746a;
    }

    public final Integer component10() {
        return this.f3755j;
    }

    public final Integer component11() {
        return this.f3756k;
    }

    public final String component12() {
        return this.f3757l;
    }

    public final Integer component13() {
        return this.f3758m;
    }

    public final List<RFLApiWeather> component2() {
        return this.f3747b;
    }

    public final String component3() {
        return this.f3748c;
    }

    public final RFLApiCurrentMain component4() {
        return this.f3749d;
    }

    public final Integer component5() {
        return this.f3750e;
    }

    public final HashMap<String, Object> component6() {
        return this.f3751f;
    }

    public final HashMap<String, Object> component7() {
        return this.f3752g;
    }

    public final Integer component8() {
        return this.f3753h;
    }

    public final HashMap<String, Object> component9() {
        return this.f3754i;
    }

    public final RFLApiCurrentWeather copy(RFLApiWeatherCoordinate rFLApiWeatherCoordinate, List<RFLApiWeather> list, String str, RFLApiCurrentMain rFLApiCurrentMain, Integer num, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, Integer num2, HashMap<String, Object> hashMap3, Integer num3, Integer num4, String str2, Integer num5) {
        return new RFLApiCurrentWeather(rFLApiWeatherCoordinate, list, str, rFLApiCurrentMain, num, hashMap, hashMap2, num2, hashMap3, num3, num4, str2, num5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLApiCurrentWeather)) {
            return false;
        }
        RFLApiCurrentWeather rFLApiCurrentWeather = (RFLApiCurrentWeather) obj;
        return Intrinsics.areEqual((Object) this.f3746a, (Object) rFLApiCurrentWeather.f3746a) && Intrinsics.areEqual((Object) this.f3747b, (Object) rFLApiCurrentWeather.f3747b) && Intrinsics.areEqual((Object) this.f3748c, (Object) rFLApiCurrentWeather.f3748c) && Intrinsics.areEqual((Object) this.f3749d, (Object) rFLApiCurrentWeather.f3749d) && Intrinsics.areEqual((Object) this.f3750e, (Object) rFLApiCurrentWeather.f3750e) && Intrinsics.areEqual((Object) this.f3751f, (Object) rFLApiCurrentWeather.f3751f) && Intrinsics.areEqual((Object) this.f3752g, (Object) rFLApiCurrentWeather.f3752g) && Intrinsics.areEqual((Object) this.f3753h, (Object) rFLApiCurrentWeather.f3753h) && Intrinsics.areEqual((Object) this.f3754i, (Object) rFLApiCurrentWeather.f3754i) && Intrinsics.areEqual((Object) this.f3755j, (Object) rFLApiCurrentWeather.f3755j) && Intrinsics.areEqual((Object) this.f3756k, (Object) rFLApiCurrentWeather.f3756k) && Intrinsics.areEqual((Object) this.f3757l, (Object) rFLApiCurrentWeather.f3757l) && Intrinsics.areEqual((Object) this.f3758m, (Object) rFLApiCurrentWeather.f3758m);
    }

    public final String getBase() {
        return this.f3748c;
    }

    public final Integer getCityId() {
        return this.f3756k;
    }

    public final String getCityName() {
        return this.f3757l;
    }

    public final HashMap<String, Object> getClouds() {
        return this.f3752g;
    }

    public final Integer getCod() {
        return this.f3758m;
    }

    public final RFLApiWeatherCoordinate getCoordinate() {
        return this.f3746a;
    }

    public final RFLApiCurrentMain getMain() {
        return this.f3749d;
    }

    public final HashMap<String, Object> getSystemInfo() {
        return this.f3754i;
    }

    public final Integer getTimezone() {
        return this.f3755j;
    }

    public final Integer getUnixTime() {
        return this.f3753h;
    }

    public final Integer getVisibility() {
        return this.f3750e;
    }

    public final List<RFLApiWeather> getWeatherList() {
        return this.f3747b;
    }

    public final HashMap<String, Object> getWind() {
        return this.f3751f;
    }

    public int hashCode() {
        RFLApiWeatherCoordinate rFLApiWeatherCoordinate = this.f3746a;
        int i = 0;
        int hashCode = (rFLApiWeatherCoordinate != null ? rFLApiWeatherCoordinate.hashCode() : 0) * 31;
        List<RFLApiWeather> list = this.f3747b;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.f3748c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        RFLApiCurrentMain rFLApiCurrentMain = this.f3749d;
        int hashCode4 = (hashCode3 + (rFLApiCurrentMain != null ? rFLApiCurrentMain.hashCode() : 0)) * 31;
        Integer num = this.f3750e;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 31;
        HashMap<String, Object> hashMap = this.f3751f;
        int hashCode6 = (hashCode5 + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        HashMap<String, Object> hashMap2 = this.f3752g;
        int hashCode7 = (hashCode6 + (hashMap2 != null ? hashMap2.hashCode() : 0)) * 31;
        Integer num2 = this.f3753h;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 31;
        HashMap<String, Object> hashMap3 = this.f3754i;
        int hashCode9 = (hashCode8 + (hashMap3 != null ? hashMap3.hashCode() : 0)) * 31;
        Integer num3 = this.f3755j;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.f3756k;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 31;
        String str2 = this.f3757l;
        int hashCode12 = (hashCode11 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num5 = this.f3758m;
        if (num5 != null) {
            i = num5.hashCode();
        }
        return hashCode12 + i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLApiCurrentWeather(coordinate=");
        a.append(this.f3746a);
        a.append(", weatherList=");
        a.append(this.f3747b);
        a.append(", base=");
        a.append(this.f3748c);
        a.append(", main=");
        a.append(this.f3749d);
        a.append(", visibility=");
        a.append(this.f3750e);
        a.append(", wind=");
        a.append(this.f3751f);
        a.append(", clouds=");
        a.append(this.f3752g);
        a.append(", unixTime=");
        a.append(this.f3753h);
        a.append(", systemInfo=");
        a.append(this.f3754i);
        a.append(", timezone=");
        a.append(this.f3755j);
        a.append(", cityId=");
        a.append(this.f3756k);
        a.append(", cityName=");
        a.append(this.f3757l);
        a.append(", cod=");
        a.append(this.f3758m);
        a.append(")");
        return a.toString();
    }
}
