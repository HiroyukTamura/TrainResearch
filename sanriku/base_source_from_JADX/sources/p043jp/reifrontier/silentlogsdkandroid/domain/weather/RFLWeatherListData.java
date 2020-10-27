package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006#"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherListData;", "", "date", "", "temperature", "timestamp", "pressure", "", "pressureIn", "trend", "type", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()I", "getPressure", "()Ljava/lang/String;", "getPressureIn", "getTemperature", "getTimestamp", "getTrend", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherListData */
public final class RFLWeatherListData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final transient int f3798a;
    @SerializedName("temperature")

    /* renamed from: b */
    private final int f3799b;
    @SerializedName("timestamp")

    /* renamed from: c */
    private final int f3800c;
    @SerializedName("pressure_mb")

    /* renamed from: d */
    private final String f3801d;
    @SerializedName("pressure_in")

    /* renamed from: e */
    private final String f3802e;
    @SerializedName("pressure_trend")

    /* renamed from: f */
    private final String f3803f;
    @SerializedName("weather_type")

    /* renamed from: g */
    private final String f3804g;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherListData$Companion;", "", "()V", "newInstance", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherListData;", "apiCurrentWeather", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentWeather;", "now", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherListData$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RFLWeatherListData newInstance(RFLApiCurrentWeather rFLApiCurrentWeather, int i) {
            Integer cod;
            List<RFLApiWeather> weatherList;
            String main;
            RFLApiCurrentMain main2;
            Float temperature;
            if (!(rFLApiCurrentWeather == null || (cod = rFLApiCurrentWeather.getCod()) == null || cod.intValue() != 200 || (weatherList = rFLApiCurrentWeather.getWeatherList()) == null || weatherList.isEmpty() || (main = ((RFLApiWeather) CollectionsKt___CollectionsKt.first(weatherList)).getMain()) == null || (main2 = rFLApiCurrentWeather.getMain()) == null || (temperature = main2.getTemperature()) == null)) {
                float floatValue = temperature.floatValue();
                Integer pressure = main2.getPressure();
                if (pressure != null) {
                    int intValue = pressure.intValue();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String a = C0681a.m328a(new Object[]{Float.valueOf((float) intValue)}, 1, "%.2f", "java.lang.String.format(format, *args)");
                    Integer unixTime = rFLApiCurrentWeather.getUnixTime();
                    if (unixTime != null) {
                        return new RFLWeatherListData(i, MathKt__MathJVMKt.roundToInt(floatValue), unixTime.intValue(), a, a, "-", main);
                    }
                }
            }
            return null;
        }
    }

    public RFLWeatherListData(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "pressure");
        Intrinsics.checkParameterIsNotNull(str2, "pressureIn");
        Intrinsics.checkParameterIsNotNull(str3, "trend");
        Intrinsics.checkParameterIsNotNull(str4, "type");
        this.f3798a = i;
        this.f3799b = i2;
        this.f3800c = i3;
        this.f3801d = str;
        this.f3802e = str2;
        this.f3803f = str3;
        this.f3804g = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFLWeatherListData(int i, int i2, int i3, String str, String str2, String str3, String str4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, i2, i3, str, str2, str3, str4);
    }

    public static /* synthetic */ RFLWeatherListData copy$default(RFLWeatherListData rFLWeatherListData, int i, int i2, int i3, String str, String str2, String str3, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = rFLWeatherListData.f3798a;
        }
        if ((i4 & 2) != 0) {
            i2 = rFLWeatherListData.f3799b;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = rFLWeatherListData.f3800c;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            str = rFLWeatherListData.f3801d;
        }
        String str5 = str;
        if ((i4 & 16) != 0) {
            str2 = rFLWeatherListData.f3802e;
        }
        String str6 = str2;
        if ((i4 & 32) != 0) {
            str3 = rFLWeatherListData.f3803f;
        }
        String str7 = str3;
        if ((i4 & 64) != 0) {
            str4 = rFLWeatherListData.f3804g;
        }
        return rFLWeatherListData.copy(i, i5, i6, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.f3798a;
    }

    public final int component2() {
        return this.f3799b;
    }

    public final int component3() {
        return this.f3800c;
    }

    public final String component4() {
        return this.f3801d;
    }

    public final String component5() {
        return this.f3802e;
    }

    public final String component6() {
        return this.f3803f;
    }

    public final String component7() {
        return this.f3804g;
    }

    public final RFLWeatherListData copy(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        Intrinsics.checkParameterIsNotNull(str, "pressure");
        Intrinsics.checkParameterIsNotNull(str2, "pressureIn");
        Intrinsics.checkParameterIsNotNull(str3, "trend");
        String str5 = str4;
        Intrinsics.checkParameterIsNotNull(str5, "type");
        return new RFLWeatherListData(i, i2, i3, str, str2, str3, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLWeatherListData)) {
            return false;
        }
        RFLWeatherListData rFLWeatherListData = (RFLWeatherListData) obj;
        return this.f3798a == rFLWeatherListData.f3798a && this.f3799b == rFLWeatherListData.f3799b && this.f3800c == rFLWeatherListData.f3800c && Intrinsics.areEqual((Object) this.f3801d, (Object) rFLWeatherListData.f3801d) && Intrinsics.areEqual((Object) this.f3802e, (Object) rFLWeatherListData.f3802e) && Intrinsics.areEqual((Object) this.f3803f, (Object) rFLWeatherListData.f3803f) && Intrinsics.areEqual((Object) this.f3804g, (Object) rFLWeatherListData.f3804g);
    }

    public final int getDate() {
        return this.f3798a;
    }

    public final String getPressure() {
        return this.f3801d;
    }

    public final String getPressureIn() {
        return this.f3802e;
    }

    public final int getTemperature() {
        return this.f3799b;
    }

    public final int getTimestamp() {
        return this.f3800c;
    }

    public final String getTrend() {
        return this.f3803f;
    }

    public final String getType() {
        return this.f3804g;
    }

    public int hashCode() {
        int i = ((((this.f3798a * 31) + this.f3799b) * 31) + this.f3800c) * 31;
        String str = this.f3801d;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f3802e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f3803f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f3804g;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLWeatherListData(date=");
        a.append(this.f3798a);
        a.append(", temperature=");
        a.append(this.f3799b);
        a.append(", timestamp=");
        a.append(this.f3800c);
        a.append(", pressure=");
        a.append(this.f3801d);
        a.append(", pressureIn=");
        a.append(this.f3802e);
        a.append(", trend=");
        a.append(this.f3803f);
        a.append(", type=");
        return C0681a.m324a(a, this.f3804g, ")");
    }
}
