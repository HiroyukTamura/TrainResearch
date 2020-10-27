package p043jp.reifrontier.silentlogsdkandroid.domain.weather;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather;", "", "date", "", "highTemperature", "lowTemperature", "icon", "", "weatherCode", "timestamp", "(IIILjava/lang/String;ILjava/lang/String;)V", "getDate", "()I", "getHighTemperature", "getIcon", "()Ljava/lang/String;", "getLowTemperature", "getTimestamp", "getWeatherCode", "weatherType", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherType;", "getWeatherType", "()Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather */
public final class RFLWeather {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final transient int f3784a;
    @SerializedName("highTemp")

    /* renamed from: b */
    private final int f3785b;
    @SerializedName("lowTemp")

    /* renamed from: c */
    private final int f3786c;
    @SerializedName("weatherType")

    /* renamed from: d */
    private final String f3787d;
    @SerializedName("weatherCode")

    /* renamed from: e */
    private final int f3788e;
    @SerializedName("timestamp")

    /* renamed from: f */
    private final String f3789f;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather$Companion;", "", "()V", "newInstance", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather;", "apiData", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentWeather;", "now", "", "weatherBase", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecastWeather;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
            r12 = (p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiWeather) kotlin.collections.CollectionsKt___CollectionsKt.first(r12);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather newInstance(p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiCurrentWeather r12, int r13, p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather r14) {
            /*
                r11 = this;
                r0 = 0
                if (r12 == 0) goto L_0x0086
                if (r14 == 0) goto L_0x0086
                java.lang.Integer r1 = r12.getCod()
                if (r1 != 0) goto L_0x000c
                goto L_0x0014
            L_0x000c:
                int r1 = r1.intValue()
                r2 = 200(0xc8, float:2.8E-43)
                if (r1 == r2) goto L_0x0015
            L_0x0014:
                return r0
            L_0x0015:
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiCurrentMain r1 = r12.getMain()
                if (r1 == 0) goto L_0x0086
                java.lang.Integer r1 = r12.getUnixTime()
                if (r1 == 0) goto L_0x0086
                r1.intValue()
                java.util.Calendar r1 = java.util.Calendar.getInstance()
                java.lang.String r2 = "this"
                kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
                long r2 = (long) r13
                r4 = 1000(0x3e8, double:4.94E-321)
                long r2 = r2 * r4
                r1.setTimeInMillis(r2)
                r2 = 11
                int r1 = r1.get(r2)
                r2 = 17
                if (r1 <= r2) goto L_0x0040
                return r0
            L_0x0040:
                java.util.List r12 = r12.getWeatherList()
                if (r12 == 0) goto L_0x0086
                boolean r1 = r12.isEmpty()
                if (r1 == 0) goto L_0x004d
                return r0
            L_0x004d:
                java.lang.Object r12 = kotlin.collections.CollectionsKt___CollectionsKt.first(r12)
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiWeather r12 = (p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiWeather) r12
                java.lang.Integer r1 = r12.getId()
                if (r1 == 0) goto L_0x0086
                int r7 = r1.intValue()
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType$Companion r1 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType.Companion
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType r1 = r1.getFromApi(r7)
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherType r2 = r14.getWeatherType()
                if (r1 != r2) goto L_0x006a
                return r0
            L_0x006a:
                java.lang.String r6 = r12.getMain()
                if (r6 == 0) goto L_0x0086
                java.util.Date r12 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.date(r13)
                r13 = 2
                java.lang.String r1 = "yyyyMMdd'T'HHmmssZ"
                java.lang.String r8 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.format$default(r12, r1, r0, r13, r0)
                r3 = 0
                r4 = 0
                r5 = 0
                r9 = 7
                r10 = 0
                r2 = r14
                jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather r12 = p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                return r12
            L_0x0086:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather.Companion.newInstance(jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiCurrentWeather, int, jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather):jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather");
        }

        public final RFLWeather newInstance(RFLApiForecastWeather rFLApiForecastWeather, int i) {
            RFLApiForecast rFLApiForecast;
            Integer unixTime;
            List<RFLApiWeather> weatherList;
            Float max;
            if (rFLApiForecastWeather == null || (!Intrinsics.areEqual((Object) rFLApiForecastWeather.getCod(), (Object) "200"))) {
                return null;
            }
            Date start = RFLDailyUtilsKt.start(RFLDailyUtilsKt.date(i));
            List<RFLApiForecast> forecastList = rFLApiForecastWeather.getForecastList();
            if (!(forecastList == null || forecastList.isEmpty() || (unixTime = rFLApiForecast.getUnixTime()) == null)) {
                int intValue = unixTime.intValue();
                if (!RFLDailyUtilsKt.isSameDay(RFLDailyUtilsKt.date(intValue), start) || (weatherList = rFLApiForecast.getWeatherList()) == null || weatherList.isEmpty()) {
                    return null;
                }
                RFLApiWeather rFLApiWeather = (RFLApiWeather) CollectionsKt___CollectionsKt.first(weatherList);
                Integer id = rFLApiWeather.getId();
                int intValue2 = id != null ? id.intValue() : 0;
                String main = rFLApiWeather.getMain();
                if (main == null) {
                    main = "";
                }
                String str = main;
                RFLApiForecastTemperature temperature = (rFLApiForecast = (RFLApiForecast) CollectionsKt___CollectionsKt.first(forecastList)).getTemperature();
                if (!(temperature == null || (max = temperature.getMax()) == null)) {
                    float floatValue = max.floatValue();
                    Float min = rFLApiForecast.getTemperature().getMin();
                    if (min != null) {
                        return new RFLWeather(RFLDailyUtilsKt.second(start), MathKt__MathJVMKt.roundToInt(floatValue), MathKt__MathJVMKt.roundToInt(min.floatValue()), str, intValue2, RFLDailyUtilsKt.format$default(RFLDailyUtilsKt.date(intValue), "yyyyMMdd'T'HHmmssZ", (String) null, 2, (Object) null));
                    }
                }
            }
            return null;
        }
    }

    public RFLWeather(int i, int i2, int i3, String str, int i4, String str2) {
        Intrinsics.checkParameterIsNotNull(str2, "timestamp");
        this.f3784a = i;
        this.f3785b = i2;
        this.f3786c = i3;
        this.f3787d = str;
        this.f3788e = i4;
        this.f3789f = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFLWeather(int i, int i2, int i3, String str, int i4, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, i2, i3, (i5 & 8) != 0 ? "" : str, i4, str2);
    }

    public static /* synthetic */ RFLWeather copy$default(RFLWeather rFLWeather, int i, int i2, int i3, String str, int i4, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = rFLWeather.f3784a;
        }
        if ((i5 & 2) != 0) {
            i2 = rFLWeather.f3785b;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = rFLWeather.f3786c;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            str = rFLWeather.f3787d;
        }
        String str3 = str;
        if ((i5 & 16) != 0) {
            i4 = rFLWeather.f3788e;
        }
        int i8 = i4;
        if ((i5 & 32) != 0) {
            str2 = rFLWeather.f3789f;
        }
        return rFLWeather.copy(i, i6, i7, str3, i8, str2);
    }

    public final int component1() {
        return this.f3784a;
    }

    public final int component2() {
        return this.f3785b;
    }

    public final int component3() {
        return this.f3786c;
    }

    public final String component4() {
        return this.f3787d;
    }

    public final int component5() {
        return this.f3788e;
    }

    public final String component6() {
        return this.f3789f;
    }

    public final RFLWeather copy(int i, int i2, int i3, String str, int i4, String str2) {
        Intrinsics.checkParameterIsNotNull(str2, "timestamp");
        return new RFLWeather(i, i2, i3, str, i4, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLWeather)) {
            return false;
        }
        RFLWeather rFLWeather = (RFLWeather) obj;
        return this.f3784a == rFLWeather.f3784a && this.f3785b == rFLWeather.f3785b && this.f3786c == rFLWeather.f3786c && Intrinsics.areEqual((Object) this.f3787d, (Object) rFLWeather.f3787d) && this.f3788e == rFLWeather.f3788e && Intrinsics.areEqual((Object) this.f3789f, (Object) rFLWeather.f3789f);
    }

    public final int getDate() {
        return this.f3784a;
    }

    public final int getHighTemperature() {
        return this.f3785b;
    }

    public final String getIcon() {
        return this.f3787d;
    }

    public final int getLowTemperature() {
        return this.f3786c;
    }

    public final String getTimestamp() {
        return this.f3789f;
    }

    public final int getWeatherCode() {
        return this.f3788e;
    }

    public final RFLWeatherType getWeatherType() {
        return RFLWeatherType.Companion.getFromApi(this.f3788e);
    }

    public int hashCode() {
        int i = ((((this.f3784a * 31) + this.f3785b) * 31) + this.f3786c) * 31;
        String str = this.f3787d;
        int i2 = 0;
        int hashCode = (((i + (str != null ? str.hashCode() : 0)) * 31) + this.f3788e) * 31;
        String str2 = this.f3789f;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLWeather(date=");
        a.append(this.f3784a);
        a.append(", highTemperature=");
        a.append(this.f3785b);
        a.append(", lowTemperature=");
        a.append(this.f3786c);
        a.append(", icon=");
        a.append(this.f3787d);
        a.append(", weatherCode=");
        a.append(this.f3788e);
        a.append(", timestamp=");
        return C0681a.m324a(a, this.f3789f, ")");
    }
}
