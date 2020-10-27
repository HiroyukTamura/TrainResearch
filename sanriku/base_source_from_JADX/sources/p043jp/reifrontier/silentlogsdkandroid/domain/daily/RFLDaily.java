package p043jp.reifrontier.silentlogsdkandroid.domain.daily;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherListData;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bQ\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\u0002\u0010 J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J\u000f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00110\bHÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00106J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00106J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0011\u0010e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\bHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\t\u0010g\u001a\u00020\u0006HÆ\u0003J\u000f\u0010h\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010m\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u00106J\u0002\u0010n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÆ\u0001¢\u0006\u0002\u0010oJ\u0013\u0010p\u001a\u00020q2\b\u0010r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010s\u001a\u00020\u0006HÖ\u0001J\u0014\u0010t\u001a\u00020u2\f\u0010v\u001a\b\u0012\u0004\u0012\u00020\u00110\bJ\u0014\u0010w\u001a\u00020u2\f\u0010x\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010y\u001a\u00020u2\f\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u0014\u0010{\u001a\u00020u2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u001d0\bJ\t\u0010}\u001a\u00020\u0003HÖ\u0001R$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R \u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010&\"\u0004\b(\u0010)R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010)R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010&\"\u0004\b-\u0010)R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010&\"\u0004\b/\u0010)R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u001e\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010&\"\u0004\b2\u0010)R \u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010&\"\u0004\b4\u0010)R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\"\"\u0004\b;\u0010$R$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\"\"\u0004\b=\u0010$R \u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010&\"\u0004\b?\u0010)R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR \u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010&\"\u0004\bI\u0010)R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010&\"\u0004\bK\u0010)R\"\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\bL\u00106\"\u0004\bM\u00108R\"\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\bN\u00106\"\u0004\bO\u00108R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\bP\u00106\"\u0004\bQ\u00108R \u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR&\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\"\"\u0004\bW\u0010$¨\u0006~"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;", "", "timezone", "", "date", "steps", "", "segments", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLSegment;", "deviceOS", "deviceName", "clientId", "updateTimeApp", "updateTimeServer", "stepPerMin", "barometerList", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLBarometer;", "extSteps", "extSrc", "stepProvider", "timezoneKeys", "dataId", "dataCounts", "dailyTag", "updateTimeTag", "summary", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLSummary;", "weatherList", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherListData;", "weather", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather;", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLSummary;Ljava/util/List;Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather;)V", "getBarometerList", "()Ljava/util/List;", "setBarometerList", "(Ljava/util/List;)V", "getClientId", "()Ljava/lang/String;", "getDailyTag", "setDailyTag", "(Ljava/lang/String;)V", "getDataCounts", "setDataCounts", "getDataId", "setDataId", "getDate", "setDate", "getDeviceName", "getDeviceOS", "setDeviceOS", "getExtSrc", "setExtSrc", "getExtSteps", "()Ljava/lang/Integer;", "setExtSteps", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSegments", "setSegments", "getStepPerMin", "setStepPerMin", "getStepProvider", "setStepProvider", "getSteps", "()I", "setSteps", "(I)V", "getSummary", "()Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLSummary;", "setSummary", "(Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLSummary;)V", "getTimezone", "setTimezone", "getTimezoneKeys", "setTimezoneKeys", "getUpdateTimeApp", "setUpdateTimeApp", "getUpdateTimeServer", "setUpdateTimeServer", "getUpdateTimeTag", "setUpdateTimeTag", "getWeather", "()Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather;", "setWeather", "(Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather;)V", "getWeatherList", "setWeatherList", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLSummary;Ljava/util/List;Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather;)Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;", "equals", "", "other", "hashCode", "setBarometer", "", "newBarometerList", "setSegment", "newSegments", "setStepList", "newStepList", "setWeatherListData", "newWeatherList", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily */
public final class RFLDaily {
    @SerializedName("timezone")
    @Expose

    /* renamed from: a */
    private String f3538a;
    @SerializedName("date")
    @Expose

    /* renamed from: b */
    private String f3539b;
    @SerializedName("steps")
    @Expose

    /* renamed from: c */
    private int f3540c;
    @SerializedName("segments")
    @Expose

    /* renamed from: d */
    private List<RFLSegment> f3541d;
    @SerializedName("device_os")
    @Expose

    /* renamed from: e */
    private String f3542e;
    @SerializedName("device_name")
    @Expose

    /* renamed from: f */
    private final String f3543f;
    @SerializedName("client_id")
    @Expose

    /* renamed from: g */
    private final String f3544g;
    @SerializedName("update_time_app")
    @Expose

    /* renamed from: h */
    private Integer f3545h;
    @SerializedName("update_time_server")
    @Expose

    /* renamed from: i */
    private Integer f3546i;
    @SerializedName("step_per_minutes")

    /* renamed from: j */
    private List<Integer> f3547j;
    @SerializedName("barometer_list")

    /* renamed from: k */
    private List<RFLBarometer> f3548k;
    @SerializedName("ext_steps")

    /* renamed from: l */
    private Integer f3549l;
    @SerializedName("ext_src")

    /* renamed from: m */
    private String f3550m;
    @SerializedName("step_provider")

    /* renamed from: n */
    private String f3551n;
    @SerializedName("timezone_s")

    /* renamed from: o */
    private String f3552o;
    @SerializedName("data_ids")

    /* renamed from: p */
    private String f3553p;
    @SerializedName("data_counts")

    /* renamed from: q */
    private String f3554q;
    @SerializedName("daily_tag")

    /* renamed from: r */
    private String f3555r;
    @SerializedName("update_time_tag")

    /* renamed from: s */
    private Integer f3556s;
    @SerializedName("summary")

    /* renamed from: t */
    private RFLSummary f3557t;
    @SerializedName("weather_list")

    /* renamed from: u */
    private List<RFLWeatherListData> f3558u;
    @SerializedName("weather")

    /* renamed from: v */
    private RFLWeather f3559v;

    public RFLDaily(String str, String str2, int i, List<RFLSegment> list, String str3, String str4, String str5, Integer num, Integer num2, List<Integer> list2, List<RFLBarometer> list3, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, Integer num4, RFLSummary rFLSummary, List<RFLWeatherListData> list4, RFLWeather rFLWeather) {
        String str12 = str4;
        String str13 = str5;
        List<Integer> list5 = list2;
        List<RFLBarometer> list6 = list3;
        Intrinsics.checkParameterIsNotNull(str, "timezone");
        Intrinsics.checkParameterIsNotNull(str2, "date");
        Intrinsics.checkParameterIsNotNull(list, "segments");
        Intrinsics.checkParameterIsNotNull(str3, "deviceOS");
        Intrinsics.checkParameterIsNotNull(str12, "deviceName");
        Intrinsics.checkParameterIsNotNull(str13, "clientId");
        Intrinsics.checkParameterIsNotNull(list5, "stepPerMin");
        Intrinsics.checkParameterIsNotNull(list6, "barometerList");
        this.f3538a = str;
        this.f3539b = str2;
        this.f3540c = i;
        this.f3541d = list;
        this.f3542e = str3;
        this.f3543f = str12;
        this.f3544g = str13;
        this.f3545h = num;
        this.f3546i = num2;
        this.f3547j = list5;
        this.f3548k = list6;
        this.f3549l = num3;
        this.f3550m = str6;
        this.f3551n = str7;
        this.f3552o = str8;
        this.f3553p = str9;
        this.f3554q = str10;
        this.f3555r = str11;
        this.f3556s = num4;
        this.f3557t = rFLSummary;
        this.f3558u = list4;
        this.f3559v = rFLWeather;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RFLDaily(java.lang.String r26, java.lang.String r27, int r28, java.util.List r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.Integer r33, java.lang.Integer r34, java.util.List r35, java.util.List r36, java.lang.Integer r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.Integer r44, p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLSummary r45, java.util.List r46, p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather r47, int r48, kotlin.jvm.internal.DefaultConstructorMarker r49) {
        /*
            r25 = this;
            r0 = r48
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x000c
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r12 = r1
            goto L_0x000e
        L_0x000c:
            r12 = r35
        L_0x000e:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0018
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r13 = r1
            goto L_0x001a
        L_0x0018:
            r13 = r36
        L_0x001a:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            r2 = 0
            if (r1 == 0) goto L_0x0021
            r14 = r2
            goto L_0x0023
        L_0x0021:
            r14 = r37
        L_0x0023:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0029
            r15 = r2
            goto L_0x002b
        L_0x0029:
            r15 = r38
        L_0x002b:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0032
            r16 = r2
            goto L_0x0034
        L_0x0032:
            r16 = r39
        L_0x0034:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x003b
            r17 = r2
            goto L_0x003d
        L_0x003b:
            r17 = r40
        L_0x003d:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0046
            r18 = r2
            goto L_0x0048
        L_0x0046:
            r18 = r41
        L_0x0048:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0050
            r19 = r2
            goto L_0x0052
        L_0x0050:
            r19 = r42
        L_0x0052:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x005a
            r20 = r2
            goto L_0x005c
        L_0x005a:
            r20 = r43
        L_0x005c:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0069
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r21 = r1
            goto L_0x006b
        L_0x0069:
            r21 = r44
        L_0x006b:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0073
            r22 = r2
            goto L_0x0075
        L_0x0073:
            r22 = r45
        L_0x0075:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0081
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r23 = r1
            goto L_0x0083
        L_0x0081:
            r23 = r46
        L_0x0083:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x008b
            r24 = r2
            goto L_0x008d
        L_0x008b:
            r24 = r47
        L_0x008d:
            r2 = r25
            r3 = r26
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily.<init>(java.lang.String, java.lang.String, int, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.List, java.util.List, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, jp.reifrontier.silentlogsdkandroid.domain.daily.RFLSummary, java.util.List, jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ RFLDaily copy$default(RFLDaily rFLDaily, String str, String str2, int i, List list, String str3, String str4, String str5, Integer num, Integer num2, List list2, List list3, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, Integer num4, RFLSummary rFLSummary, List list4, RFLWeather rFLWeather, int i2, Object obj) {
        RFLDaily rFLDaily2 = rFLDaily;
        int i3 = i2;
        return rFLDaily.copy((i3 & 1) != 0 ? rFLDaily2.f3538a : str, (i3 & 2) != 0 ? rFLDaily2.f3539b : str2, (i3 & 4) != 0 ? rFLDaily2.f3540c : i, (i3 & 8) != 0 ? rFLDaily2.f3541d : list, (i3 & 16) != 0 ? rFLDaily2.f3542e : str3, (i3 & 32) != 0 ? rFLDaily2.f3543f : str4, (i3 & 64) != 0 ? rFLDaily2.f3544g : str5, (i3 & 128) != 0 ? rFLDaily2.f3545h : num, (i3 & 256) != 0 ? rFLDaily2.f3546i : num2, (i3 & 512) != 0 ? rFLDaily2.f3547j : list2, (i3 & 1024) != 0 ? rFLDaily2.f3548k : list3, (i3 & 2048) != 0 ? rFLDaily2.f3549l : num3, (i3 & 4096) != 0 ? rFLDaily2.f3550m : str6, (i3 & 8192) != 0 ? rFLDaily2.f3551n : str7, (i3 & 16384) != 0 ? rFLDaily2.f3552o : str8, (i3 & 32768) != 0 ? rFLDaily2.f3553p : str9, (i3 & 65536) != 0 ? rFLDaily2.f3554q : str10, (i3 & 131072) != 0 ? rFLDaily2.f3555r : str11, (i3 & 262144) != 0 ? rFLDaily2.f3556s : num4, (i3 & 524288) != 0 ? rFLDaily2.f3557t : rFLSummary, (i3 & 1048576) != 0 ? rFLDaily2.f3558u : list4, (i3 & 2097152) != 0 ? rFLDaily2.f3559v : rFLWeather);
    }

    public final String component1() {
        return this.f3538a;
    }

    public final List<Integer> component10() {
        return this.f3547j;
    }

    public final List<RFLBarometer> component11() {
        return this.f3548k;
    }

    public final Integer component12() {
        return this.f3549l;
    }

    public final String component13() {
        return this.f3550m;
    }

    public final String component14() {
        return this.f3551n;
    }

    public final String component15() {
        return this.f3552o;
    }

    public final String component16() {
        return this.f3553p;
    }

    public final String component17() {
        return this.f3554q;
    }

    public final String component18() {
        return this.f3555r;
    }

    public final Integer component19() {
        return this.f3556s;
    }

    public final String component2() {
        return this.f3539b;
    }

    public final RFLSummary component20() {
        return this.f3557t;
    }

    public final List<RFLWeatherListData> component21() {
        return this.f3558u;
    }

    public final RFLWeather component22() {
        return this.f3559v;
    }

    public final int component3() {
        return this.f3540c;
    }

    public final List<RFLSegment> component4() {
        return this.f3541d;
    }

    public final String component5() {
        return this.f3542e;
    }

    public final String component6() {
        return this.f3543f;
    }

    public final String component7() {
        return this.f3544g;
    }

    public final Integer component8() {
        return this.f3545h;
    }

    public final Integer component9() {
        return this.f3546i;
    }

    public final RFLDaily copy(String str, String str2, int i, List<RFLSegment> list, String str3, String str4, String str5, Integer num, Integer num2, List<Integer> list2, List<RFLBarometer> list3, Integer num3, String str6, String str7, String str8, String str9, String str10, String str11, Integer num4, RFLSummary rFLSummary, List<RFLWeatherListData> list4, RFLWeather rFLWeather) {
        String str12 = str;
        Intrinsics.checkParameterIsNotNull(str12, "timezone");
        Intrinsics.checkParameterIsNotNull(str2, "date");
        Intrinsics.checkParameterIsNotNull(list, "segments");
        Intrinsics.checkParameterIsNotNull(str3, "deviceOS");
        Intrinsics.checkParameterIsNotNull(str4, "deviceName");
        Intrinsics.checkParameterIsNotNull(str5, "clientId");
        Intrinsics.checkParameterIsNotNull(list2, "stepPerMin");
        Intrinsics.checkParameterIsNotNull(list3, "barometerList");
        return new RFLDaily(str12, str2, i, list, str3, str4, str5, num, num2, list2, list3, num3, str6, str7, str8, str9, str10, str11, num4, rFLSummary, list4, rFLWeather);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RFLDaily)) {
            return false;
        }
        RFLDaily rFLDaily = (RFLDaily) obj;
        return Intrinsics.areEqual((Object) this.f3538a, (Object) rFLDaily.f3538a) && Intrinsics.areEqual((Object) this.f3539b, (Object) rFLDaily.f3539b) && this.f3540c == rFLDaily.f3540c && Intrinsics.areEqual((Object) this.f3541d, (Object) rFLDaily.f3541d) && Intrinsics.areEqual((Object) this.f3542e, (Object) rFLDaily.f3542e) && Intrinsics.areEqual((Object) this.f3543f, (Object) rFLDaily.f3543f) && Intrinsics.areEqual((Object) this.f3544g, (Object) rFLDaily.f3544g) && Intrinsics.areEqual((Object) this.f3545h, (Object) rFLDaily.f3545h) && Intrinsics.areEqual((Object) this.f3546i, (Object) rFLDaily.f3546i) && Intrinsics.areEqual((Object) this.f3547j, (Object) rFLDaily.f3547j) && Intrinsics.areEqual((Object) this.f3548k, (Object) rFLDaily.f3548k) && Intrinsics.areEqual((Object) this.f3549l, (Object) rFLDaily.f3549l) && Intrinsics.areEqual((Object) this.f3550m, (Object) rFLDaily.f3550m) && Intrinsics.areEqual((Object) this.f3551n, (Object) rFLDaily.f3551n) && Intrinsics.areEqual((Object) this.f3552o, (Object) rFLDaily.f3552o) && Intrinsics.areEqual((Object) this.f3553p, (Object) rFLDaily.f3553p) && Intrinsics.areEqual((Object) this.f3554q, (Object) rFLDaily.f3554q) && Intrinsics.areEqual((Object) this.f3555r, (Object) rFLDaily.f3555r) && Intrinsics.areEqual((Object) this.f3556s, (Object) rFLDaily.f3556s) && Intrinsics.areEqual((Object) this.f3557t, (Object) rFLDaily.f3557t) && Intrinsics.areEqual((Object) this.f3558u, (Object) rFLDaily.f3558u) && Intrinsics.areEqual((Object) this.f3559v, (Object) rFLDaily.f3559v);
    }

    public final List<RFLBarometer> getBarometerList() {
        return this.f3548k;
    }

    public final String getClientId() {
        return this.f3544g;
    }

    public final String getDailyTag() {
        return this.f3555r;
    }

    public final String getDataCounts() {
        return this.f3554q;
    }

    public final String getDataId() {
        return this.f3553p;
    }

    public final String getDate() {
        return this.f3539b;
    }

    public final String getDeviceName() {
        return this.f3543f;
    }

    public final String getDeviceOS() {
        return this.f3542e;
    }

    public final String getExtSrc() {
        return this.f3550m;
    }

    public final Integer getExtSteps() {
        return this.f3549l;
    }

    public final List<RFLSegment> getSegments() {
        return this.f3541d;
    }

    public final List<Integer> getStepPerMin() {
        return this.f3547j;
    }

    public final String getStepProvider() {
        return this.f3551n;
    }

    public final int getSteps() {
        return this.f3540c;
    }

    public final RFLSummary getSummary() {
        return this.f3557t;
    }

    public final String getTimezone() {
        return this.f3538a;
    }

    public final String getTimezoneKeys() {
        return this.f3552o;
    }

    public final Integer getUpdateTimeApp() {
        return this.f3545h;
    }

    public final Integer getUpdateTimeServer() {
        return this.f3546i;
    }

    public final Integer getUpdateTimeTag() {
        return this.f3556s;
    }

    public final RFLWeather getWeather() {
        return this.f3559v;
    }

    public final List<RFLWeatherListData> getWeatherList() {
        return this.f3558u;
    }

    public int hashCode() {
        String str = this.f3538a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f3539b;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f3540c) * 31;
        List<RFLSegment> list = this.f3541d;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.f3542e;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f3543f;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f3544g;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.f3545h;
        int hashCode7 = (hashCode6 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.f3546i;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 31;
        List<Integer> list2 = this.f3547j;
        int hashCode9 = (hashCode8 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<RFLBarometer> list3 = this.f3548k;
        int hashCode10 = (hashCode9 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Integer num3 = this.f3549l;
        int hashCode11 = (hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 31;
        String str6 = this.f3550m;
        int hashCode12 = (hashCode11 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f3551n;
        int hashCode13 = (hashCode12 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f3552o;
        int hashCode14 = (hashCode13 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.f3553p;
        int hashCode15 = (hashCode14 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.f3554q;
        int hashCode16 = (hashCode15 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.f3555r;
        int hashCode17 = (hashCode16 + (str11 != null ? str11.hashCode() : 0)) * 31;
        Integer num4 = this.f3556s;
        int hashCode18 = (hashCode17 + (num4 != null ? num4.hashCode() : 0)) * 31;
        RFLSummary rFLSummary = this.f3557t;
        int hashCode19 = (hashCode18 + (rFLSummary != null ? rFLSummary.hashCode() : 0)) * 31;
        List<RFLWeatherListData> list4 = this.f3558u;
        int hashCode20 = (hashCode19 + (list4 != null ? list4.hashCode() : 0)) * 31;
        RFLWeather rFLWeather = this.f3559v;
        if (rFLWeather != null) {
            i = rFLWeather.hashCode();
        }
        return hashCode20 + i;
    }

    public final void setBarometer(List<RFLBarometer> list) {
        Intrinsics.checkParameterIsNotNull(list, "newBarometerList");
        this.f3548k = list;
    }

    public final void setBarometerList(List<RFLBarometer> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.f3548k = list;
    }

    public final void setDailyTag(String str) {
        this.f3555r = str;
    }

    public final void setDataCounts(String str) {
        this.f3554q = str;
    }

    public final void setDataId(String str) {
        this.f3553p = str;
    }

    public final void setDate(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f3539b = str;
    }

    public final void setDeviceOS(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f3542e = str;
    }

    public final void setExtSrc(String str) {
        this.f3550m = str;
    }

    public final void setExtSteps(Integer num) {
        this.f3549l = num;
    }

    public final void setSegment(List<RFLSegment> list) {
        Intrinsics.checkParameterIsNotNull(list, "newSegments");
        int i = 0;
        for (RFLSegment steps : list) {
            i += steps.getSteps();
        }
        this.f3540c = i;
        this.f3541d = list;
    }

    public final void setSegments(List<RFLSegment> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.f3541d = list;
    }

    public final void setStepList(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "newStepList");
        this.f3547j = list;
    }

    public final void setStepPerMin(List<Integer> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.f3547j = list;
    }

    public final void setStepProvider(String str) {
        this.f3551n = str;
    }

    public final void setSteps(int i) {
        this.f3540c = i;
    }

    public final void setSummary(RFLSummary rFLSummary) {
        this.f3557t = rFLSummary;
    }

    public final void setTimezone(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f3538a = str;
    }

    public final void setTimezoneKeys(String str) {
        this.f3552o = str;
    }

    public final void setUpdateTimeApp(Integer num) {
        this.f3545h = num;
    }

    public final void setUpdateTimeServer(Integer num) {
        this.f3546i = num;
    }

    public final void setUpdateTimeTag(Integer num) {
        this.f3556s = num;
    }

    public final void setWeather(RFLWeather rFLWeather) {
        this.f3559v = rFLWeather;
    }

    public final void setWeatherList(List<RFLWeatherListData> list) {
        this.f3558u = list;
    }

    public final void setWeatherListData(List<RFLWeatherListData> list) {
        Intrinsics.checkParameterIsNotNull(list, "newWeatherList");
        this.f3558u = list;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("RFLDaily(timezone=");
        a.append(this.f3538a);
        a.append(", date=");
        a.append(this.f3539b);
        a.append(", steps=");
        a.append(this.f3540c);
        a.append(", segments=");
        a.append(this.f3541d);
        a.append(", deviceOS=");
        a.append(this.f3542e);
        a.append(", deviceName=");
        a.append(this.f3543f);
        a.append(", clientId=");
        a.append(this.f3544g);
        a.append(", updateTimeApp=");
        a.append(this.f3545h);
        a.append(", updateTimeServer=");
        a.append(this.f3546i);
        a.append(", stepPerMin=");
        a.append(this.f3547j);
        a.append(", barometerList=");
        a.append(this.f3548k);
        a.append(", extSteps=");
        a.append(this.f3549l);
        a.append(", extSrc=");
        a.append(this.f3550m);
        a.append(", stepProvider=");
        a.append(this.f3551n);
        a.append(", timezoneKeys=");
        a.append(this.f3552o);
        a.append(", dataId=");
        a.append(this.f3553p);
        a.append(", dataCounts=");
        a.append(this.f3554q);
        a.append(", dailyTag=");
        a.append(this.f3555r);
        a.append(", updateTimeTag=");
        a.append(this.f3556s);
        a.append(", summary=");
        a.append(this.f3557t);
        a.append(", weatherList=");
        a.append(this.f3558u);
        a.append(", weather=");
        a.append(this.f3559v);
        a.append(")");
        return a.toString();
    }
}
