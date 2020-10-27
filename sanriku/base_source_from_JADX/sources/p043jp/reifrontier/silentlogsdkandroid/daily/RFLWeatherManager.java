package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.annotation.SuppressLint;
import android.location.Location;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLWeatherClient;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiCurrentWeather;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiForecastWeather;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherCategory;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherListData;
import p043jp.reifrontier.silentlogsdkandroid.utils.CalendarExKt;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p048l.p049a.C1122a;
import p078g.p079a.C1696b;
import p078g.p079a.C1697c;
import p078g.p079a.C1699e;
import p078g.p079a.C1714r;
import p078g.p079a.C1715s;
import p078g.p079a.C1717u;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;
import p078g.p079a.p100z.C1741d;
import retrofit2.Response;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0002 !B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J5\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000e0\u0012H\u0007J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\""}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLWeatherManager;", "", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "weatherApiClient", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLWeatherClient;", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;Ljp/reifrontier/silentlogsdkandroid/data/api/RFLWeatherClient;)V", "forecastRequesting", "", "weatherCategory", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherCategory;", "getWeatherCategory", "()Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherCategory;", "findWeather", "", "date", "Ljava/util/Date;", "listener", "Lkotlin/Function1;", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather;", "Lkotlin/ParameterName;", "name", "weather", "getCurrentWeatherIfNeeded", "location", "Landroid/location/Location;", "now", "", "getForecastIfNeeded", "isNeededCurrentWeather", "isNeededForecast", "startUpdate", "LocationInfo", "NoSuchObjectException", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager */
public final class RFLWeatherManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f3229a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final RFLDataLogger f3230b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final RFLWeatherClient f3231c;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B)\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001`\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLWeatherManager$LocationInfo;", "", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "hasData", "", "getHasData", "()Z", "lat", "", "getLat", "()D", "location", "Landroid/location/Location;", "getLocation", "()Landroid/location/Location;", "lon", "getLon", "timestamp", "", "getTimestamp", "()I", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$LocationInfo */
    public static final class LocationInfo {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        /* renamed from: a */
        private final double f3232a;

        /* renamed from: b */
        private final double f3233b;

        /* renamed from: c */
        private final int f3234c;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLWeatherManager$LocationInfo$Companion;", "", "()V", "getHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "location", "Landroid/location/Location;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$LocationInfo$Companion */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final HashMap<String, Object> getHashMap(Location location) {
                Intrinsics.checkParameterIsNotNull(location, FirebaseAnalytics.Param.LOCATION);
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("lat", Double.valueOf(location.getLatitude()));
                hashMap.put("lon", Double.valueOf(location.getLongitude()));
                hashMap.put("timestamp", Double.valueOf((double) (location.getTime() / 1000)));
                return hashMap;
            }
        }

        public LocationInfo(HashMap<String, Object> hashMap) {
            Intrinsics.checkParameterIsNotNull(hashMap, "map");
            Object obj = hashMap.get("lat");
            Double valueOf = Double.valueOf(0.0d);
            obj = obj == null ? valueOf : obj;
            if (obj != null) {
                this.f3232a = ((Double) obj).doubleValue();
                Object obj2 = hashMap.get("lon");
                obj2 = obj2 == null ? valueOf : obj2;
                if (obj2 != null) {
                    this.f3233b = ((Double) obj2).doubleValue();
                    Object obj3 = hashMap.get("timestamp");
                    valueOf = obj3 != null ? obj3 : valueOf;
                    if (valueOf != null) {
                        this.f3234c = (int) valueOf.doubleValue();
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
        }

        public final boolean getHasData() {
            return (this.f3232a == 0.0d || this.f3233b == 0.0d || this.f3234c == 0) ? false : true;
        }

        public final double getLat() {
            return this.f3232a;
        }

        public final Location getLocation() {
            Location location = new Location(RFLAccountManager.DEFAULT_ACCESS_TOKEN);
            location.setLatitude(this.f3232a);
            location.setLongitude(this.f3233b);
            return location;
        }

        public final double getLon() {
            return this.f3233b;
        }

        public final int getTimestamp() {
            return this.f3234c;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$a */
    private static final class C2196a extends Exception {
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$b */
    static final class C2197b<T> implements C1717u<T> {

        /* renamed from: a */
        final /* synthetic */ RFLWeatherManager f3235a;

        /* renamed from: b */
        final /* synthetic */ Date f3236b;

        C2197b(RFLWeatherManager rFLWeatherManager, Date date) {
            this.f3235a = rFLWeatherManager;
            this.f3236b = date;
        }

        public final void subscribe(C1715s<RFLWeather> sVar) {
            Intrinsics.checkParameterIsNotNull(sVar, "emitter");
            RFLWeather findForecastByDate = this.f3235a.f3230b.findForecastByDate(RFLDailyUtilsKt.second(this.f3236b));
            if (findForecastByDate != null) {
                sVar.onSuccess(findForecastByDate);
            } else {
                sVar.onError(new C2196a());
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$c */
    static final class C2198c<T> implements C1741d<RFLWeather> {

        /* renamed from: a */
        final /* synthetic */ Function1 f3237a;

        C2198c(Function1 function1) {
            this.f3237a = function1;
        }

        /* renamed from: a */
        public final void accept(RFLWeather rFLWeather) {
            this.f3237a.invoke(rFLWeather);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$d */
    static final class C2199d<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Function1 f3238a;

        C2199d(Function1 function1) {
            this.f3238a = function1;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            if (!(th instanceof C2196a)) {
                C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK]::Error ", th, "it")), new Object[0]);
            }
            this.f3238a.invoke(null);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "it", "Lio/reactivex/CompletableEmitter;", "subscribe"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$e */
    static final class C2200e implements C1699e {

        /* renamed from: a */
        final /* synthetic */ RFLWeatherManager f3239a;

        /* renamed from: b */
        final /* synthetic */ Location f3240b;

        /* renamed from: c */
        final /* synthetic */ int f3241c;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$e$a */
        static final class C2201a<T> implements C1741d<Response<RFLApiCurrentWeather>> {

            /* renamed from: a */
            final /* synthetic */ C2200e f3242a;

            C2201a(C2200e eVar) {
                this.f3242a = eVar;
            }

            /* renamed from: a */
            public final void accept(Response<RFLApiCurrentWeather> response) {
                if (response.code() == 200) {
                    RFLWeatherListData newInstance = RFLWeatherListData.Companion.newInstance(response.body(), this.f3242a.f3241c);
                    if (newInstance != null) {
                        RFLSharedHolder.INSTANCE.setLocationTemperature(LocationInfo.Companion.getHashMap(this.f3242a.f3240b));
                        this.f3242a.f3239a.f3230b.saveCurrentWeather(newInstance).mo27431a();
                        C2200e eVar = this.f3242a;
                        RFLWeather newInstance2 = RFLWeather.Companion.newInstance(response.body(), eVar.f3241c, eVar.f3239a.f3230b.findForecastByDate(this.f3242a.f3241c));
                        if (newInstance2 != null) {
                            this.f3242a.f3239a.f3230b.saveForecast(newInstance2).mo27431a();
                            return;
                        }
                        return;
                    }
                    return;
                }
                StringBuilder a = C0681a.m330a("[SilentLogSDK]::Error getCurrentWeather ");
                a.append(response.code());
                C1122a.m1599b(a.toString(), new Object[0]);
            }
        }

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$e$b */
        static final class C2202b<T> implements C1741d<Throwable> {

            /* renamed from: a */
            public static final C2202b f3243a = new C2202b();

            C2202b() {
            }

            /* renamed from: a */
            public final void accept(Throwable th) {
                C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK]::Error getCurrentWeather ", th, "it")), new Object[0]);
            }
        }

        C2200e(RFLWeatherManager rFLWeatherManager, Location location, int i) {
            this.f3239a = rFLWeatherManager;
            this.f3240b = location;
            this.f3241c = i;
        }

        public final void subscribe(C1697c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "it");
            if (this.f3239a.m3760a(this.f3240b)) {
                this.f3239a.f3231c.requestCurrent(this.f3240b.getLatitude(), this.f3240b.getLongitude()).mo27434b(C1683a.m2378b()).mo27432a(new C2201a(this), C2202b.f3243a);
            }
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "it", "Lio/reactivex/CompletableEmitter;", "subscribe"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$f */
    static final class C2203f implements C1699e {

        /* renamed from: a */
        final /* synthetic */ RFLWeatherManager f3244a;

        /* renamed from: b */
        final /* synthetic */ int f3245b;

        /* renamed from: c */
        final /* synthetic */ Location f3246c;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$f$a */
        static final class C2204a<T> implements C1741d<Response<RFLApiForecastWeather>> {

            /* renamed from: a */
            final /* synthetic */ C2203f f3247a;

            C2204a(C2203f fVar) {
                this.f3247a = fVar;
            }

            /* renamed from: a */
            public final void accept(Response<RFLApiForecastWeather> response) {
                if (response.code() == 200) {
                    RFLWeather newInstance = RFLWeather.Companion.newInstance(response.body(), this.f3247a.f3245b);
                    if (newInstance != null) {
                        this.f3247a.f3244a.f3230b.saveForecast(newInstance).mo27431a();
                        RFLSharedHolder.INSTANCE.setForecastLastUpdateTime(this.f3247a.f3245b);
                        this.f3247a.f3244a.f3229a = false;
                    }
                } else {
                    StringBuilder a = C0681a.m330a("[SilentLogSDK]::Error getCurrentWeather ");
                    a.append(response.code());
                    C1122a.m1599b(a.toString(), new Object[0]);
                }
                RFLSharedHolder.INSTANCE.setForecastLastUpdateTime(0);
                this.f3247a.f3244a.f3229a = false;
            }
        }

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager$f$b */
        static final class C2205b<T> implements C1741d<Throwable> {

            /* renamed from: a */
            final /* synthetic */ C2203f f3248a;

            C2205b(C2203f fVar) {
                this.f3248a = fVar;
            }

            /* renamed from: a */
            public final void accept(Throwable th) {
                C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK]::Error getForecastWeather ", th, "it")), new Object[0]);
                this.f3248a.f3244a.f3229a = false;
                RFLSharedHolder.INSTANCE.setForecastLastUpdateTime(0);
            }
        }

        C2203f(RFLWeatherManager rFLWeatherManager, int i, Location location) {
            this.f3244a = rFLWeatherManager;
            this.f3245b = i;
            this.f3246c = location;
        }

        public final void subscribe(C1697c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "it");
            if (this.f3244a.m3759a(this.f3245b) && !this.f3244a.f3229a) {
                if (Calendar.getInstance().compareTo(this.f3244a.m3757a().getRandomTime()) >= 0) {
                    this.f3244a.f3229a = true;
                    this.f3244a.f3231c.requestForecast(this.f3246c.getLatitude(), this.f3246c.getLongitude()).mo27434b(C1683a.m2378b()).mo27432a(new C2204a(this), new C2205b(this));
                }
            }
        }
    }

    public RFLWeatherManager(RFLDataLogger rFLDataLogger, RFLWeatherClient rFLWeatherClient) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "dataLogger");
        Intrinsics.checkParameterIsNotNull(rFLWeatherClient, "weatherApiClient");
        this.f3230b = rFLDataLogger;
        this.f3231c = rFLWeatherClient;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final RFLWeatherCategory m3757a() {
        RFLWeatherCategory forecastWeatherCategory = RFLSharedHolder.INSTANCE.getForecastWeatherCategory();
        if (forecastWeatherCategory != RFLWeatherCategory.NONE) {
            return forecastWeatherCategory;
        }
        RFLWeatherCategory rFLWeatherCategory = RFLWeatherCategory.values()[new Random(System.currentTimeMillis()).nextInt(RFLWeatherCategory.values().length - 1) + 1];
        RFLSharedHolder.INSTANCE.setForecastWeatherCategory(rFLWeatherCategory);
        return rFLWeatherCategory;
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    private final void m3758a(Location location, int i) {
        C1696b.m2386a((C1699e) new C2200e(this, location, i)).mo27420a(C1683a.m2378b()).mo27421a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m3759a(int i) {
        int forecastLastUpdateTime = RFLSharedHolder.INSTANCE.getForecastLastUpdateTime();
        if (forecastLastUpdateTime == 0 || this.f3230b.countForecastByDate(i) <= 0) {
            return true;
        }
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "this");
        instance.setTimeInMillis(((long) forecastLastUpdateTime) * 1000);
        Calendar instance2 = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "this");
        instance2.setTimeInMillis(((long) i) * 1000);
        Intrinsics.checkExpressionValueIsNotNull(instance, "forecastLastUpdate");
        Intrinsics.checkExpressionValueIsNotNull(instance2, "today");
        return !CalendarExKt.isSameDay(instance, instance2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m3760a(Location location) {
        int time = (int) (location.getTime() / 1000);
        LocationInfo locationInfo = new LocationInfo(RFLSharedHolder.INSTANCE.getLocationTemperature());
        return !locationInfo.getHasData() || ((double) location.distanceTo(locationInfo.getLocation())) > 20000.0d || time - locationInfo.getTimestamp() > 21600;
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: b */
    private final void m3761b(Location location, int i) {
        C1696b.m2386a((C1699e) new C2203f(this, i, location)).mo27420a(C1683a.m2378b()).mo27421a();
    }

    @SuppressLint({"CheckResult"})
    public final void findWeather(Date date, Function1<? super RFLWeather, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        Intrinsics.checkParameterIsNotNull(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!RFLSharedHolder.INSTANCE.isEnableAltitudePrediction()) {
            function1.invoke(null);
            return;
        }
        StringBuilder a = C0681a.m330a("[SilentLogSDK]::Debug findWeather date=");
        a.append(RFLDailyUtilsKt.second(date));
        C1122a.m1596a(a.toString(), new Object[0]);
        C1714r.m2410a(new C2197b(this, date)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C2198c(function1), new C2199d(function1));
    }

    public final void startUpdate(Location location) {
        Intrinsics.checkParameterIsNotNull(location, FirebaseAnalytics.Param.LOCATION);
        if (RFLSharedHolder.INSTANCE.isEnableAltitudePrediction()) {
            int second = RFLDailyUtilsKt.second(new Date());
            m3761b(location, second);
            m3758a(location, second);
        }
    }
}
