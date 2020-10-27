package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.location.Location;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLAdjustTrackPointDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLBarometerDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyTagDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLOrmaHolder;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLPedometerDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTPDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTagDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTrackPointDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLWeatherDao;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLBarometer;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTag;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityBarometer;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDaily;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDailyTag;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityForecast;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTP;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTag;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTrackPoint;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeather;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLWeatherListData;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p078g.p079a.C1696b;
import p078g.p079a.C1697c;
import p078g.p079a.C1699e;
import p078g.p079a.C1714r;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001~B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@J\u000e\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EJ\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020@J\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020L0G2\u0006\u0010A\u001a\u00020MJ\u0014\u0010N\u001a\b\u0012\u0004\u0012\u00020O0G2\u0006\u0010A\u001a\u00020@J\u0010\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010A\u001a\u00020RJ\u0010\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010A\u001a\u00020MJ\u0010\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010A\u001a\u00020@J\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010A\u001a\u00020R2\u0006\u0010X\u001a\u00020RJ\u001a\u0010Y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0G0G2\u0006\u0010A\u001a\u00020RJ\u0016\u0010Z\u001a\u00020@2\u0006\u0010I\u001a\u00020[2\u0006\u0010J\u001a\u00020[J\u0010\u0010\\\u001a\u0004\u0018\u00010H2\u0006\u0010A\u001a\u00020RJ&\u0010]\u001a\n\u0012\u0004\u0012\u00020^\u0018\u00010G2\u0006\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020@2\u0006\u0010_\u001a\u00020`J\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010d\u001a\u00020LJ\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010f\u001a\u00020Q2\u0006\u0010g\u001a\u00020RJ\u0014\u0010h\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010i\u001a\u00020jJ\u0014\u0010k\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010A\u001a\u00020MJ\u0014\u0010l\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010i\u001a\u00020jJ$\u0010m\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010n\u001a\u00020^2\u0006\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020@J$\u0010o\u001a\u00020p2\f\u0010q\u001a\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020@J$\u0010r\u001a\u00020p2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020^0G2\u0006\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020@J\u0016\u0010t\u001a\u00020[2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020C0vH\u0002J\u0014\u0010w\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010x\u001a\u00020OJ$\u0010y\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010A\u001a\u00020M2\u0006\u0010z\u001a\u00020R2\u0006\u0010{\u001a\u00020@J\u0014\u0010|\u001a\b\u0012\u0004\u0012\u00020c0b2\u0006\u0010}\u001a\u00020VR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u00109\u001a\u00020:8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "", "()V", "adjustTrackPointDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLAdjustTrackPointDao;", "getAdjustTrackPointDao", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLAdjustTrackPointDao;", "setAdjustTrackPointDao", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLAdjustTrackPointDao;)V", "barometerDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLBarometerDao;", "getBarometerDao", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLBarometerDao;", "setBarometerDao", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLBarometerDao;)V", "dailyDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyDao;", "getDailyDao", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyDao;", "setDailyDao", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyDao;)V", "dailyTagDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyTagDao;", "getDailyTagDao", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyTagDao;", "setDailyTagDao", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyTagDao;)V", "pedometerDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLPedometerDao;", "getPedometerDao", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLPedometerDao;", "setPedometerDao", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLPedometerDao;)V", "rflOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "getRflOrmaHolder", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "setRflOrmaHolder", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;)V", "tagDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTagDao;", "getTagDao", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTagDao;", "setTagDao", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTagDao;)V", "tpDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTPDao;", "getTpDao", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTPDao;", "setTpDao", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTPDao;)V", "trackPointDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTrackPointDao;", "getTrackPointDao", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTrackPointDao;", "setTrackPointDao", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTrackPointDao;)V", "weatherDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLWeatherDao;", "getWeatherDao", "()Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLWeatherDao;", "setWeatherDao", "(Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLWeatherDao;)V", "countForecastByDate", "", "date", "deleteTwoWeekData", "", "targetDay", "Ljava/util/Calendar;", "findAdjustTrackPoints", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "from", "to", "findBarometer", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLBarometer;", "Ljava/util/Date;", "findCurrentWeather", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeatherListData;", "findDaily", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;", "", "findDailyTag", "Ljp/reifrontier/silentlogsdkandroid/domain/db/RFLEntityDailyTag;", "findForecastByDate", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLWeather;", "findLocation", "timezone", "findLocations", "findStep", "", "findTP", "findTag", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTag;", "useTo", "", "insertBarometer", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "barometer", "insertDaily", "daily", "dateString", "insertLocation", "location", "Landroid/location/Location;", "insertPedometer", "insertTP", "insertTag", "tag", "replaceAdjustTrackPoints", "Lio/reactivex/Completable;", "adjustTrackPoints", "replaceUserTag", "tags", "runWithBenchmark", "task", "Lkotlin/Function0;", "saveCurrentWeather", "weatherListData", "saveDailyTag", "dailyTag", "updateTime", "saveForecast", "weather", "Result", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger */
public final class RFLDataLogger {
    public RFLAdjustTrackPointDao adjustTrackPointDao;
    public RFLBarometerDao barometerDao;
    public RFLDailyDao dailyDao;
    public RFLDailyTagDao dailyTagDao;
    public RFLPedometerDao pedometerDao;
    public RFLOrmaHolder rflOrmaHolder;
    public RFLTagDao tagDao;
    public RFLTPDao tpDao;
    public RFLTrackPointDao trackPointDao;
    public RFLWeatherDao weatherDao;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "", "title", "", "elapsedMillis", "", "(Ljava/lang/String;J)V", "getElapsedMillis", "()J", "getTitle", "()Ljava/lang/String;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$Result */
    public static final class Result {

        /* renamed from: a */
        private final String f3128a;

        /* renamed from: b */
        private final long f3129b;

        public Result(String str, long j) {
            Intrinsics.checkParameterIsNotNull(str, "title");
            this.f3128a = str;
            this.f3129b = j;
        }

        public final long getElapsedMillis() {
            return this.f3129b;
        }

        public final String getTitle() {
            return this.f3128a;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$a */
    static final class C2160a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3130a;

        /* renamed from: b */
        final /* synthetic */ Calendar f3131b;

        C2160a(RFLDataLogger rFLDataLogger, Calendar calendar) {
            this.f3130a = rFLDataLogger;
            this.f3131b = calendar;
        }

        public final void run() {
            this.f3130a.getTpDao().deleteBefore(this.f3131b);
            this.f3130a.getTrackPointDao().deleteBefore(this.f3131b);
            this.f3130a.getAdjustTrackPointDao().deleteBefore(this.f3131b);
            this.f3130a.getPedometerDao().deleteBefore(this.f3131b);
            this.f3130a.getDailyTagDao().deleteBefore(this.f3131b);
            this.f3130a.getDailyDao().deleteBefore(this.f3131b);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "call"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$b */
    static final class C2161b<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3132a;

        /* renamed from: b */
        final /* synthetic */ RFLBarometer f3133b;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$b$a */
        static final class C2162a extends Lambda implements Function0<Unit> {

            /* renamed from: a */
            final /* synthetic */ C2161b f3134a;

            /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$b$a$a */
            static final class C2163a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ C2162a f3135a;

                C2163a(C2162a aVar) {
                    this.f3135a = aVar;
                }

                public final void run() {
                    String format$default = RFLDailyUtilsKt.format$default(new Date(((long) this.f3135a.f3134a.f3133b.getTimestamp()) * 1000), "yyyy-MM-dd", (String) null, 2, (Object) null);
                    List<RFLEntityBarometer> find = this.f3135a.f3134a.f3132a.getBarometerDao().find(format$default);
                    if (find.isEmpty()) {
                        this.f3135a.f3134a.f3132a.getBarometerDao().insert(format$default, CollectionsKt__CollectionsJVMKt.listOf(this.f3135a.f3134a.f3133b));
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(((RFLEntityBarometer) CollectionsKt___CollectionsKt.first(find)).getBarometers());
                    arrayList.add(this.f3135a.f3134a.f3133b);
                    this.f3135a.f3134a.f3132a.getBarometerDao().updateByDate(arrayList, format$default);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2162a(C2161b bVar) {
                super(0);
                this.f3134a = bVar;
            }

            public final void invoke() {
                this.f3134a.f3132a.getRflOrmaHolder().getORMA().transactionSync(new C2163a(this));
            }
        }

        C2161b(RFLDataLogger rFLDataLogger, RFLBarometer rFLBarometer) {
            this.f3132a = rFLDataLogger;
            this.f3133b = rFLBarometer;
        }

        public final Result call() {
            return new Result("Orma/insert", this.f3132a.m3738a(new C2162a(this)));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "call"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$c */
    static final class C2164c<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3136a;

        /* renamed from: b */
        final /* synthetic */ String f3137b;

        /* renamed from: c */
        final /* synthetic */ RFLDaily f3138c;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$c$a */
        static final class C2165a extends Lambda implements Function0<Unit> {

            /* renamed from: a */
            final /* synthetic */ C2164c f3139a;

            /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$c$a$a */
            static final class C2166a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ C2165a f3140a;

                C2166a(C2165a aVar) {
                    this.f3140a = aVar;
                }

                public final void run() {
                    if (this.f3140a.f3139a.f3136a.getDailyDao().find(this.f3140a.f3139a.f3137b, "timezone").isEmpty()) {
                        RFLDailyDao dailyDao = this.f3140a.f3139a.f3136a.getDailyDao();
                        C2164c cVar = this.f3140a.f3139a;
                        dailyDao.insert(cVar.f3137b, "timezone", cVar.f3138c);
                        return;
                    }
                    RFLDailyDao dailyDao2 = this.f3140a.f3139a.f3136a.getDailyDao();
                    C2164c cVar2 = this.f3140a.f3139a;
                    dailyDao2.updateByDateTimezone(cVar2.f3138c, cVar2.f3137b, "timezone");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2165a(C2164c cVar) {
                super(0);
                this.f3139a = cVar;
            }

            public final void invoke() {
                this.f3139a.f3136a.getRflOrmaHolder().getORMA().transactionSync(new C2166a(this));
            }
        }

        C2164c(RFLDataLogger rFLDataLogger, String str, RFLDaily rFLDaily) {
            this.f3136a = rFLDataLogger;
            this.f3137b = str;
            this.f3138c = rFLDaily;
        }

        public final Result call() {
            return new Result("Orma/insert", this.f3136a.m3738a(new C2165a(this)));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "call"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$d */
    static final class C2167d<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3141a;

        /* renamed from: b */
        final /* synthetic */ Location f3142b;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$d$a */
        static final class C2168a extends Lambda implements Function0<Unit> {

            /* renamed from: a */
            final /* synthetic */ C2167d f3143a;

            /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$d$a$a */
            static final class C2169a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ C2168a f3144a;

                C2169a(C2168a aVar) {
                    this.f3144a = aVar;
                }

                public final void run() {
                    String format$default = RFLDailyUtilsKt.format$default(new Date(this.f3144a.f3143a.f3142b.getTime()), "yyyy-MM-dd", (String) null, 2, (Object) null);
                    TimeZone timeZone = TimeZone.getDefault();
                    Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getDefault()");
                    String id = timeZone.getID();
                    Intrinsics.checkExpressionValueIsNotNull(id, "timezone");
                    String str = id;
                    RFLTrackPoint rFLTrackPoint = new RFLTrackPoint(str, this.f3144a.f3143a.f3142b.getLatitude(), this.f3144a.f3143a.f3142b.getLongitude(), this.f3144a.f3143a.f3142b.getAccuracy(), (int) Math.floor((double) (this.f3144a.f3143a.f3142b.getTime() / ((long) 1000))));
                    List<RFLEntityTrackPoint> find = this.f3144a.f3143a.f3141a.getTrackPointDao().find(format$default, id);
                    if (find.isEmpty()) {
                        this.f3144a.f3143a.f3141a.getTrackPointDao().insert(format$default, id, CollectionsKt__CollectionsJVMKt.listOf(rFLTrackPoint));
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(((RFLEntityTrackPoint) CollectionsKt___CollectionsKt.first(find)).getTrackPoints());
                    arrayList.add(rFLTrackPoint);
                    this.f3144a.f3143a.f3141a.getTrackPointDao().updateByDateTimezone(arrayList, format$default, id);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2168a(C2167d dVar) {
                super(0);
                this.f3143a = dVar;
            }

            public final void invoke() {
                this.f3143a.f3141a.getRflOrmaHolder().getORMA().transactionSync(new C2169a(this));
            }
        }

        C2167d(RFLDataLogger rFLDataLogger, Location location) {
            this.f3141a = rFLDataLogger;
            this.f3142b = location;
        }

        public final Result call() {
            return new Result("Orma/insert", this.f3141a.m3738a(new C2168a(this)));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "call"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$e */
    static final class C2170e<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3145a;

        /* renamed from: b */
        final /* synthetic */ Date f3146b;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$e$a */
        static final class C2171a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C2170e f3147a;

            C2171a(C2170e eVar) {
                this.f3147a = eVar;
            }

            public final void run() {
                this.f3147a.f3145a.getPedometerDao().insert(this.f3147a.f3146b.getTime());
            }
        }

        C2170e(RFLDataLogger rFLDataLogger, Date date) {
            this.f3145a = rFLDataLogger;
            this.f3146b = date;
        }

        public final Result call() {
            this.f3145a.getRflOrmaHolder().getORMA().transactionSync(new C2171a(this));
            return new Result("Orma/insert", -1);
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "call"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$f */
    static final class C2172f<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3148a;

        /* renamed from: b */
        final /* synthetic */ Location f3149b;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$f$a */
        static final class C2173a extends Lambda implements Function0<Unit> {

            /* renamed from: a */
            final /* synthetic */ C2172f f3150a;

            /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$f$a$a */
            static final class C2174a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ C2173a f3151a;

                C2174a(C2173a aVar) {
                    this.f3151a = aVar;
                }

                public final void run() {
                    String format$default = RFLDailyUtilsKt.format$default(RFLDailyUtilsKt.tomorrow(new Date(this.f3151a.f3150a.f3149b.getTime())), "yyyy-MM-dd", (String) null, 2, (Object) null);
                    TimeZone timeZone = TimeZone.getDefault();
                    Intrinsics.checkExpressionValueIsNotNull(timeZone, "TimeZone.getDefault()");
                    String id = timeZone.getID();
                    Intrinsics.checkExpressionValueIsNotNull(id, "timezone");
                    RFLTrackPoint rFLTrackPoint = new RFLTrackPoint(id, this.f3151a.f3150a.f3149b.getLatitude(), this.f3151a.f3150a.f3149b.getLongitude(), this.f3151a.f3150a.f3149b.getAccuracy(), (int) Math.floor((double) (new Date().getTime() / ((long) 1000))));
                    if (this.f3151a.f3150a.f3148a.getTpDao().find(format$default).isEmpty()) {
                        this.f3151a.f3150a.f3148a.getTpDao().insert(format$default, rFLTrackPoint);
                    } else {
                        this.f3151a.f3150a.f3148a.getTpDao().updateByDateTimezone(rFLTrackPoint, format$default);
                    }
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2173a(C2172f fVar) {
                super(0);
                this.f3150a = fVar;
            }

            public final void invoke() {
                this.f3150a.f3148a.getRflOrmaHolder().getORMA().transactionSync(new C2174a(this));
            }
        }

        C2172f(RFLDataLogger rFLDataLogger, Location location) {
            this.f3148a = rFLDataLogger;
            this.f3149b = location;
        }

        public final Result call() {
            return new Result("Orma/insert", this.f3148a.m3738a(new C2173a(this)));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "call"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$g */
    static final class C2175g<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3152a;

        /* renamed from: b */
        final /* synthetic */ int f3153b;

        /* renamed from: c */
        final /* synthetic */ int f3154c;

        /* renamed from: d */
        final /* synthetic */ RFLTag f3155d;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$g$a */
        static final class C2176a extends Lambda implements Function0<Unit> {

            /* renamed from: a */
            final /* synthetic */ C2175g f3156a;

            /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$g$a$a */
            static final class C2177a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ C2176a f3157a;

                C2177a(C2176a aVar) {
                    this.f3157a = aVar;
                }

                public final void run() {
                    RFLTagDao tagDao = this.f3157a.f3156a.f3152a.getTagDao();
                    C2175g gVar = this.f3157a.f3156a;
                    tagDao.insert(gVar.f3153b, gVar.f3154c, gVar.f3155d);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2176a(C2175g gVar) {
                super(0);
                this.f3156a = gVar;
            }

            public final void invoke() {
                this.f3156a.f3152a.getRflOrmaHolder().getORMA().transactionSync(new C2177a(this));
            }
        }

        C2175g(RFLDataLogger rFLDataLogger, int i, int i2, RFLTag rFLTag) {
            this.f3152a = rFLDataLogger;
            this.f3153b = i;
            this.f3154c = i2;
            this.f3155d = rFLTag;
        }

        public final Result call() {
            return new Result("Orma/insert", this.f3152a.m3738a(new C2176a(this)));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "it", "Lio/reactivex/CompletableEmitter;", "subscribe"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$h */
    static final class C2178h implements C1699e {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3158a;

        /* renamed from: b */
        final /* synthetic */ int f3159b;

        /* renamed from: c */
        final /* synthetic */ int f3160c;

        /* renamed from: d */
        final /* synthetic */ List f3161d;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$h$a */
        static final class C2179a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C2178h f3162a;

            C2179a(C2178h hVar) {
                this.f3162a = hVar;
            }

            public final void run() {
                RFLAdjustTrackPointDao adjustTrackPointDao = this.f3162a.f3158a.getAdjustTrackPointDao();
                C2178h hVar = this.f3162a;
                adjustTrackPointDao.delete(hVar.f3159b, hVar.f3160c);
                RFLAdjustTrackPointDao adjustTrackPointDao2 = this.f3162a.f3158a.getAdjustTrackPointDao();
                C2178h hVar2 = this.f3162a;
                adjustTrackPointDao2.insert(hVar2.f3159b, hVar2.f3160c, hVar2.f3161d);
            }
        }

        C2178h(RFLDataLogger rFLDataLogger, int i, int i2, List list) {
            this.f3158a = rFLDataLogger;
            this.f3159b = i;
            this.f3160c = i2;
            this.f3161d = list;
        }

        public final void subscribe(C1697c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "it");
            this.f3158a.getRflOrmaHolder().getORMA().transactionSync(new C2179a(this));
            cVar.onComplete();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "it", "Lio/reactivex/CompletableEmitter;", "subscribe"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$i */
    static final class C2180i implements C1699e {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3163a;

        /* renamed from: b */
        final /* synthetic */ int f3164b;

        /* renamed from: c */
        final /* synthetic */ int f3165c;

        /* renamed from: d */
        final /* synthetic */ List f3166d;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$i$a */
        static final class C2181a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C2180i f3167a;

            C2181a(C2180i iVar) {
                this.f3167a = iVar;
            }

            public final void run() {
                RFLTagDao tagDao = this.f3167a.f3163a.getTagDao();
                C2180i iVar = this.f3167a;
                tagDao.deleteUserTag(iVar.f3164b, iVar.f3165c);
                for (RFLTag insert : this.f3167a.f3166d) {
                    RFLTagDao tagDao2 = this.f3167a.f3163a.getTagDao();
                    C2180i iVar2 = this.f3167a;
                    tagDao2.insert(iVar2.f3164b, iVar2.f3165c, insert);
                }
            }
        }

        C2180i(RFLDataLogger rFLDataLogger, int i, int i2, List list) {
            this.f3163a = rFLDataLogger;
            this.f3164b = i;
            this.f3165c = i2;
            this.f3166d = list;
        }

        public final void subscribe(C1697c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "it");
            this.f3163a.getRflOrmaHolder().getORMA().transactionSync(new C2181a(this));
            cVar.onComplete();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "call"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$j */
    static final class C2182j<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3168a;

        /* renamed from: b */
        final /* synthetic */ RFLWeatherListData f3169b;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$j$a */
        static final class C2183a extends Lambda implements Function0<Unit> {

            /* renamed from: a */
            final /* synthetic */ C2182j f3170a;

            /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$j$a$a */
            static final class C2184a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ C2183a f3171a;

                C2184a(C2183a aVar) {
                    this.f3171a = aVar;
                }

                public final void run() {
                    this.f3171a.f3170a.f3168a.getWeatherDao().saveCurrentWeather(this.f3171a.f3170a.f3169b.getDate(), this.f3171a.f3170a.f3169b.getTemperature(), this.f3171a.f3170a.f3169b.getTimestamp(), this.f3171a.f3170a.f3169b.getPressure(), this.f3171a.f3170a.f3169b.getPressureIn(), this.f3171a.f3170a.f3169b.getTrend(), this.f3171a.f3170a.f3169b.getType());
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2183a(C2182j jVar) {
                super(0);
                this.f3170a = jVar;
            }

            public final void invoke() {
                this.f3170a.f3168a.getRflOrmaHolder().getORMA().transactionSync(new C2184a(this));
            }
        }

        C2182j(RFLDataLogger rFLDataLogger, RFLWeatherListData rFLWeatherListData) {
            this.f3168a = rFLDataLogger;
            this.f3169b = rFLWeatherListData;
        }

        public final Result call() {
            return new Result("Orma/insert", this.f3168a.m3738a(new C2183a(this)));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "call"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$k */
    static final class C2185k<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3172a;

        /* renamed from: b */
        final /* synthetic */ Date f3173b;

        /* renamed from: c */
        final /* synthetic */ String f3174c;

        /* renamed from: d */
        final /* synthetic */ int f3175d;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$k$a */
        static final class C2186a extends Lambda implements Function0<Unit> {

            /* renamed from: a */
            final /* synthetic */ C2185k f3176a;

            /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$k$a$a */
            static final class C2187a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ C2186a f3177a;

                C2187a(C2186a aVar) {
                    this.f3177a = aVar;
                }

                public final void run() {
                    RFLDailyTagDao dailyTagDao = this.f3177a.f3176a.f3172a.getDailyTagDao();
                    C2185k kVar = this.f3177a.f3176a;
                    dailyTagDao.save(kVar.f3173b, kVar.f3174c, kVar.f3175d);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2186a(C2185k kVar) {
                super(0);
                this.f3176a = kVar;
            }

            public final void invoke() {
                this.f3176a.f3172a.getRflOrmaHolder().getORMA().transactionSync(new C2187a(this));
            }
        }

        C2185k(RFLDataLogger rFLDataLogger, Date date, String str, int i) {
            this.f3172a = rFLDataLogger;
            this.f3173b = date;
            this.f3174c = str;
            this.f3175d = i;
        }

        public final Result call() {
            return new Result("Orma/insert", this.f3172a.m3738a(new C2186a(this)));
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger$Result;", "call"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$l */
    static final class C2188l<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDataLogger f3178a;

        /* renamed from: b */
        final /* synthetic */ RFLWeather f3179b;

        @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$l$a */
        static final class C2189a extends Lambda implements Function0<Unit> {

            /* renamed from: a */
            final /* synthetic */ C2188l f3180a;

            /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger$l$a$a */
            static final class C2190a implements Runnable {

                /* renamed from: a */
                final /* synthetic */ C2189a f3181a;

                C2190a(C2189a aVar) {
                    this.f3181a = aVar;
                }

                public final void run() {
                    Date date;
                    try {
                        date = new SimpleDateFormat("yyyyMMdd'T'HHmmssZ", Locale.US).parse(this.f3181a.f3180a.f3179b.getTimestamp());
                    } catch (Exception unused) {
                        date = null;
                    }
                    RFLWeatherDao weatherDao = this.f3181a.f3180a.f3178a.getWeatherDao();
                    int date2 = this.f3181a.f3180a.f3179b.getDate();
                    int highTemperature = this.f3181a.f3180a.f3179b.getHighTemperature();
                    int lowTemperature = this.f3181a.f3180a.f3179b.getLowTemperature();
                    String icon = this.f3181a.f3180a.f3179b.getIcon();
                    if (icon == null) {
                        icon = "";
                    }
                    weatherDao.saveForecast(date2, highTemperature, lowTemperature, icon, this.f3181a.f3180a.f3179b.getWeatherCode(), this.f3181a.f3180a.f3179b.getWeatherType().ordinal(), date != null ? RFLDailyUtilsKt.second(date) : 0);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2189a(C2188l lVar) {
                super(0);
                this.f3180a = lVar;
            }

            public final void invoke() {
                this.f3180a.f3178a.getRflOrmaHolder().getORMA().transactionSync(new C2190a(this));
            }
        }

        C2188l(RFLDataLogger rFLDataLogger, RFLWeather rFLWeather) {
            this.f3178a = rFLDataLogger;
            this.f3179b = rFLWeather;
        }

        public final Result call() {
            return new Result("Orma/insert", this.f3178a.m3738a(new C2189a(this)));
        }
    }

    public RFLDataLogger() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final long m3738a(Function0<Unit> function0) {
        long nanoTime = System.nanoTime();
        function0.invoke();
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
    }

    public final int countForecastByDate(int i) {
        RFLWeatherDao rFLWeatherDao = this.weatherDao;
        if (rFLWeatherDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherDao");
        }
        return rFLWeatherDao.countForecastByDate(i);
    }

    public final void deleteTwoWeekData(Calendar calendar) {
        Intrinsics.checkParameterIsNotNull(calendar, "targetDay");
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        rFLOrmaHolder.getORMA().transactionSync(new C2160a(this, calendar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        r3 = r3.getAdjustTrackPoints();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint> findAdjustTrackPoints(int r3, int r4) {
        /*
            r2 = this;
            jp.reifrontier.silentlogsdkandroid.data.dao.RFLAdjustTrackPointDao r0 = r2.adjustTrackPointDao
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "adjustTrackPointDao"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0009:
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityAdjustTrackPoint r3 = r0.find(r3, r4)
            if (r3 == 0) goto L_0x0016
            java.util.List r3 = r3.getAdjustTrackPoints()
            if (r3 == 0) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x001a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger.findAdjustTrackPoints(int, int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        r4 = r4.getBarometers();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLBarometer> findBarometer(java.util.Date r4) {
        /*
            r3 = this;
            java.lang.String r0 = "date"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            r0 = 0
            java.lang.String r1 = "yyyy-MM-dd"
            r2 = 2
            java.lang.String r4 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.format$default(r4, r1, r0, r2, r0)
            jp.reifrontier.silentlogsdkandroid.data.dao.RFLBarometerDao r0 = r3.barometerDao
            if (r0 != 0) goto L_0x0016
            java.lang.String r1 = "barometerDao"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0016:
            java.util.List r4 = r0.find(r4)
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r4)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityBarometer r4 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityBarometer) r4
            if (r4 == 0) goto L_0x0029
            java.util.List r4 = r4.getBarometers()
            if (r4 == 0) goto L_0x0029
            goto L_0x002e
        L_0x0029:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x002e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger.findBarometer(java.util.Date):java.util.List");
    }

    public final List<RFLWeatherListData> findCurrentWeather(int i) {
        RFLWeatherDao rFLWeatherDao = this.weatherDao;
        if (rFLWeatherDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherDao");
        }
        return rFLWeatherDao.findCurrentWeather(i);
    }

    public final RFLDaily findDaily(String str) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        RFLDailyDao rFLDailyDao = this.dailyDao;
        if (rFLDailyDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyDao");
        }
        RFLEntityDaily rFLEntityDaily = (RFLEntityDaily) CollectionsKt___CollectionsKt.firstOrNull(rFLDailyDao.find(str, "timezone"));
        if (rFLEntityDaily != null) {
            return rFLEntityDaily.getDaily();
        }
        return null;
    }

    public final RFLEntityDailyTag findDailyTag(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        RFLDailyTagDao rFLDailyTagDao = this.dailyTagDao;
        if (rFLDailyTagDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyTagDao");
        }
        return rFLDailyTagDao.find(date);
    }

    public final RFLWeather findForecastByDate(int i) {
        RFLWeatherDao rFLWeatherDao = this.weatherDao;
        if (rFLWeatherDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherDao");
        }
        RFLEntityForecast findForecastByDate = rFLWeatherDao.findForecastByDate(i);
        if (findForecastByDate == null) {
            return null;
        }
        int date = findForecastByDate.getDate();
        int highTemperature = findForecastByDate.getHighTemperature();
        int lowTemperature = findForecastByDate.getLowTemperature();
        String icon = findForecastByDate.getIcon();
        if (icon == null) {
            icon = "";
        }
        return new RFLWeather(date, highTemperature, lowTemperature, icon, findForecastByDate.getWeatherCode(), RFLDailyUtilsKt.format$default(RFLDailyUtilsKt.date(findForecastByDate.getTimestamp()), "yyyyMMdd'T'HHmmssZ", (String) null, 2, (Object) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        r3 = r3.getTrackPoints();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint> findLocation(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "date"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "timezone"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            jp.reifrontier.silentlogsdkandroid.data.dao.RFLTrackPointDao r0 = r2.trackPointDao
            if (r0 != 0) goto L_0x0013
            java.lang.String r1 = "trackPointDao"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0013:
            java.util.List r3 = r0.find(r3, r4)
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r3)
            jp.reifrontier.silentlogsdkandroid.domain.db.RFLEntityTrackPoint r3 = (p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityTrackPoint) r3
            if (r3 == 0) goto L_0x0026
            java.util.List r3 = r3.getTrackPoints()
            if (r3 == 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x002a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger.findLocation(java.lang.String, java.lang.String):java.util.List");
    }

    public final List<List<RFLTrackPoint>> findLocations(String str) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        RFLTrackPointDao rFLTrackPointDao = this.trackPointDao;
        if (rFLTrackPointDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackPointDao");
        }
        List<RFLEntityTrackPoint> find = rFLTrackPointDao.find(str);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(find, 10));
        for (RFLEntityTrackPoint trackPoints : find) {
            arrayList.add(trackPoints.getTrackPoints());
        }
        return arrayList;
    }

    public final int findStep(long j, long j2) {
        RFLPedometerDao rFLPedometerDao = this.pedometerDao;
        if (rFLPedometerDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pedometerDao");
        }
        return rFLPedometerDao.findStep(j, j2);
    }

    public final RFLTrackPoint findTP(String str) {
        Intrinsics.checkParameterIsNotNull(str, "date");
        RFLTPDao rFLTPDao = this.tpDao;
        if (rFLTPDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tpDao");
        }
        RFLEntityTP rFLEntityTP = (RFLEntityTP) CollectionsKt___CollectionsKt.firstOrNull(rFLTPDao.find(str));
        if (rFLEntityTP != null) {
            return rFLEntityTP.getTrackPoint();
        }
        return null;
    }

    public final List<RFLTag> findTag(int i, int i2, boolean z) {
        List<RFLEntityTag> list;
        if (z) {
            RFLTagDao rFLTagDao = this.tagDao;
            if (rFLTagDao == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagDao");
            }
            list = rFLTagDao.find(i, i2);
        } else {
            RFLTagDao rFLTagDao2 = this.tagDao;
            if (rFLTagDao2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagDao");
            }
            list = rFLTagDao2.find(i);
        }
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (RFLEntityTag tag : list) {
            arrayList.add(tag.getTag());
        }
        return arrayList;
    }

    public final RFLAdjustTrackPointDao getAdjustTrackPointDao() {
        RFLAdjustTrackPointDao rFLAdjustTrackPointDao = this.adjustTrackPointDao;
        if (rFLAdjustTrackPointDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adjustTrackPointDao");
        }
        return rFLAdjustTrackPointDao;
    }

    public final RFLBarometerDao getBarometerDao() {
        RFLBarometerDao rFLBarometerDao = this.barometerDao;
        if (rFLBarometerDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barometerDao");
        }
        return rFLBarometerDao;
    }

    public final RFLDailyDao getDailyDao() {
        RFLDailyDao rFLDailyDao = this.dailyDao;
        if (rFLDailyDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyDao");
        }
        return rFLDailyDao;
    }

    public final RFLDailyTagDao getDailyTagDao() {
        RFLDailyTagDao rFLDailyTagDao = this.dailyTagDao;
        if (rFLDailyTagDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyTagDao");
        }
        return rFLDailyTagDao;
    }

    public final RFLPedometerDao getPedometerDao() {
        RFLPedometerDao rFLPedometerDao = this.pedometerDao;
        if (rFLPedometerDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pedometerDao");
        }
        return rFLPedometerDao;
    }

    public final RFLOrmaHolder getRflOrmaHolder() {
        RFLOrmaHolder rFLOrmaHolder = this.rflOrmaHolder;
        if (rFLOrmaHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflOrmaHolder");
        }
        return rFLOrmaHolder;
    }

    public final RFLTagDao getTagDao() {
        RFLTagDao rFLTagDao = this.tagDao;
        if (rFLTagDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagDao");
        }
        return rFLTagDao;
    }

    public final RFLTPDao getTpDao() {
        RFLTPDao rFLTPDao = this.tpDao;
        if (rFLTPDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tpDao");
        }
        return rFLTPDao;
    }

    public final RFLTrackPointDao getTrackPointDao() {
        RFLTrackPointDao rFLTrackPointDao = this.trackPointDao;
        if (rFLTrackPointDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("trackPointDao");
        }
        return rFLTrackPointDao;
    }

    public final RFLWeatherDao getWeatherDao() {
        RFLWeatherDao rFLWeatherDao = this.weatherDao;
        if (rFLWeatherDao == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherDao");
        }
        return rFLWeatherDao;
    }

    public final C1714r<Result> insertBarometer(RFLBarometer rFLBarometer) {
        Intrinsics.checkParameterIsNotNull(rFLBarometer, "barometer");
        C1714r<Result> a = C1714r.m2413a(new C2161b(this, rFLBarometer)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a());
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …dSchedulers.mainThread())");
        return a;
    }

    public final C1714r<Result> insertDaily(RFLDaily rFLDaily, String str) {
        Intrinsics.checkParameterIsNotNull(rFLDaily, "daily");
        Intrinsics.checkParameterIsNotNull(str, "dateString");
        C1714r<Result> a = C1714r.m2413a(new C2164c(this, str, rFLDaily)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a());
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …dSchedulers.mainThread())");
        return a;
    }

    public final C1714r<Result> insertLocation(Location location) {
        Intrinsics.checkParameterIsNotNull(location, FirebaseAnalytics.Param.LOCATION);
        C1714r<Result> a = C1714r.m2413a(new C2167d(this, location)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a());
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …dSchedulers.mainThread())");
        return a;
    }

    public final C1714r<Result> insertPedometer(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        C1714r<Result> b = C1714r.m2413a(new C2170e(this, date)).mo27434b(C1683a.m2377a());
        Intrinsics.checkExpressionValueIsNotNull(b, "Single.fromCallable {\n  …Schedulers.computation())");
        return b;
    }

    public final C1714r<Result> insertTP(Location location) {
        Intrinsics.checkParameterIsNotNull(location, FirebaseAnalytics.Param.LOCATION);
        C1714r<Result> a = C1714r.m2413a(new C2172f(this, location)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a());
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …dSchedulers.mainThread())");
        return a;
    }

    public final C1714r<Result> insertTag(RFLTag rFLTag, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(rFLTag, "tag");
        C1714r<Result> a = C1714r.m2413a(new C2175g(this, i, i2, rFLTag)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a());
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …dSchedulers.mainThread())");
        return a;
    }

    public final C1696b replaceAdjustTrackPoints(List<RFLTrackPoint> list, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(list, "adjustTrackPoints");
        C1696b a = C1696b.m2386a((C1699e) new C2178h(this, i, i2, list));
        Intrinsics.checkExpressionValueIsNotNull(a, "Completable.create {\n   …it.onComplete()\n        }");
        return a;
    }

    public final C1696b replaceUserTag(List<RFLTag> list, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(list, "tags");
        C1696b a = C1696b.m2386a((C1699e) new C2180i(this, i, i2, list));
        Intrinsics.checkExpressionValueIsNotNull(a, "Completable.create {\n   …it.onComplete()\n        }");
        return a;
    }

    public final C1714r<Result> saveCurrentWeather(RFLWeatherListData rFLWeatherListData) {
        Intrinsics.checkParameterIsNotNull(rFLWeatherListData, "weatherListData");
        C1714r<Result> a = C1714r.m2413a(new C2182j(this, rFLWeatherListData)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a());
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …dSchedulers.mainThread())");
        return a;
    }

    public final C1714r<Result> saveDailyTag(Date date, String str, int i) {
        Intrinsics.checkParameterIsNotNull(date, "date");
        Intrinsics.checkParameterIsNotNull(str, "dailyTag");
        C1714r<Result> a = C1714r.m2413a(new C2185k(this, date, str, i)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a());
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …dSchedulers.mainThread())");
        return a;
    }

    public final C1714r<Result> saveForecast(RFLWeather rFLWeather) {
        Intrinsics.checkParameterIsNotNull(rFLWeather, "weather");
        C1714r<Result> a = C1714r.m2413a(new C2188l(this, rFLWeather)).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a());
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …dSchedulers.mainThread())");
        return a;
    }

    public final void setAdjustTrackPointDao(RFLAdjustTrackPointDao rFLAdjustTrackPointDao) {
        Intrinsics.checkParameterIsNotNull(rFLAdjustTrackPointDao, "<set-?>");
        this.adjustTrackPointDao = rFLAdjustTrackPointDao;
    }

    public final void setBarometerDao(RFLBarometerDao rFLBarometerDao) {
        Intrinsics.checkParameterIsNotNull(rFLBarometerDao, "<set-?>");
        this.barometerDao = rFLBarometerDao;
    }

    public final void setDailyDao(RFLDailyDao rFLDailyDao) {
        Intrinsics.checkParameterIsNotNull(rFLDailyDao, "<set-?>");
        this.dailyDao = rFLDailyDao;
    }

    public final void setDailyTagDao(RFLDailyTagDao rFLDailyTagDao) {
        Intrinsics.checkParameterIsNotNull(rFLDailyTagDao, "<set-?>");
        this.dailyTagDao = rFLDailyTagDao;
    }

    public final void setPedometerDao(RFLPedometerDao rFLPedometerDao) {
        Intrinsics.checkParameterIsNotNull(rFLPedometerDao, "<set-?>");
        this.pedometerDao = rFLPedometerDao;
    }

    public final void setRflOrmaHolder(RFLOrmaHolder rFLOrmaHolder) {
        Intrinsics.checkParameterIsNotNull(rFLOrmaHolder, "<set-?>");
        this.rflOrmaHolder = rFLOrmaHolder;
    }

    public final void setTagDao(RFLTagDao rFLTagDao) {
        Intrinsics.checkParameterIsNotNull(rFLTagDao, "<set-?>");
        this.tagDao = rFLTagDao;
    }

    public final void setTpDao(RFLTPDao rFLTPDao) {
        Intrinsics.checkParameterIsNotNull(rFLTPDao, "<set-?>");
        this.tpDao = rFLTPDao;
    }

    public final void setTrackPointDao(RFLTrackPointDao rFLTrackPointDao) {
        Intrinsics.checkParameterIsNotNull(rFLTrackPointDao, "<set-?>");
        this.trackPointDao = rFLTrackPointDao;
    }

    public final void setWeatherDao(RFLWeatherDao rFLWeatherDao) {
        Intrinsics.checkParameterIsNotNull(rFLWeatherDao, "<set-?>");
        this.weatherDao = rFLWeatherDao;
    }
}
