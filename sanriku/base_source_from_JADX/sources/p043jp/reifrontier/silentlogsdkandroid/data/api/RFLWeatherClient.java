package p043jp.reifrontier.silentlogsdkandroid.data.api;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p069e.p070a.p071a.p072a.C1578g;
import p040i.C1744A;
import p040i.C1752D;
import p040i.p116N.C1909a;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiCurrentWeather;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiForecastWeather;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0002J\"\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLWeatherClient;", "", "()V", "apiWeather", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLApiWeather;", "retrofit", "Lretrofit2/Retrofit;", "build", "", "staging", "", "getBaseUrl", "", "requestCurrent", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentWeather;", "lat", "", "lon", "requestForecast", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecastWeather;", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLWeatherClient */
public final class RFLWeatherClient {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private Retrofit f3329a;

    /* renamed from: b */
    private RFLApiWeather f3330b;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLWeatherClient$Companion;", "", "()V", "APP_ID", "", "PRODUCTION_URL", "STAGING_URL", "UNITS", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLWeatherClient$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private final String m3804a(boolean z) {
        return "https://api.openweathermap.org/data/2.5/";
    }

    public final void build(boolean z) {
        C1909a aVar = new C1909a(new RFLWeatherClient$build$logger$1());
        aVar.mo28005a(z ? C1909a.C1910a.BODY : C1909a.C1910a.NONE);
        C1752D.C1753a aVar2 = new C1752D.C1753a();
        aVar2.mo27508c(240, TimeUnit.SECONDS);
        aVar2.mo27505b(240, TimeUnit.SECONDS);
        aVar2.mo27509d(240, TimeUnit.SECONDS);
        aVar2.mo27503a(true);
        aVar2.mo27501a((C1744A) aVar);
        Retrofit build = new Retrofit.Builder().client(new C1752D(aVar2)).baseUrl(m3804a(z)).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(C1578g.m2208a()).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "Retrofit.Builder()\n     …\n                .build()");
        this.f3329a = build;
        Object create = build.create(RFLApiWeather.class);
        Intrinsics.checkExpressionValueIsNotNull(create, "retrofit.create(RFLApiWeather::class.java)");
        this.f3330b = (RFLApiWeather) create;
    }

    public final C1714r<Response<RFLApiCurrentWeather>> requestCurrent(double d, double d2) {
        RFLApiWeather rFLApiWeather = this.f3330b;
        if (rFLApiWeather == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiWeather");
        }
        return rFLApiWeather.getCurrent(d, d2, "5606acbaaebfcaed67a65dc39b76f8f4", "metric", 1);
    }

    public final C1714r<Response<RFLApiForecastWeather>> requestForecast(double d, double d2) {
        RFLApiWeather rFLApiWeather = this.f3330b;
        if (rFLApiWeather == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apiWeather");
        }
        return rFLApiWeather.getForecast(d, d2, "5606acbaaebfcaed67a65dc39b76f8f4", "metric", 2);
    }
}
