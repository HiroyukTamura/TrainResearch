package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.text.format.DateUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.greenrobot.eventbus.C1126c;
import org.greenrobot.eventbus.C1129m;
import org.greenrobot.eventbus.ThreadMode;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.bus.PostDaily;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLSegment;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLSummary;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTag;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFL_ACTIVITY_TYPE;
import p048l.p049a.C1122a;
import p078g.p079a.C1696b;
import p078g.p079a.C1697c;
import p078g.p079a.C1698d;
import p078g.p079a.C1699e;
import p078g.p079a.C1714r;
import p078g.p079a.C1718v;
import p078g.p079a.p080A.p082b.C1599b;
import p078g.p079a.p080A.p084d.C1603b;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;
import p078g.p079a.p100z.C1738a;
import p078g.p079a.p100z.C1741d;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 v2\u00020\u0001:\u0002vwB\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010>H\u0003¢\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020H2\u0006\u0010N\u001a\u00020\u00102\u0006\u0010O\u001a\u00020@J\u0010\u0010P\u001a\u00020H2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020HH\u0007J\u0018\u0010T\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010V0U2\u0006\u0010I\u001a\u00020JH\u0002J\u0014\u0010W\u001a\b\u0012\u0004\u0012\u00020X0U2\u0006\u0010I\u001a\u00020JJ\u0018\u0010W\u001a\u00020H2\u0006\u0010Y\u001a\u00020J2\u0006\u0010Z\u001a\u00020XH\u0003J\b\u0010[\u001a\u00020HH\u0002J\b\u0010\\\u001a\u00020HH\u0002J\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020^0U2\u0006\u0010I\u001a\u00020JJ\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020^0U2\u0006\u0010I\u001a\u00020JJ\u0010\u0010`\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0003J\u001a\u0010a\u001a\u00020H2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010b\u001a\u00020^H\u0002J\u0010\u0010c\u001a\u00020H2\u0006\u0010d\u001a\u00020eH\u0007J\u0006\u0010f\u001a\u00020HJ+\u0010g\u001a\u00020H2!\u0010h\u001a\u001d\u0012\u0013\u0012\u00110^¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(l\u0012\u0004\u0012\u00020H0iH\u0007J\b\u0010m\u001a\u00020HH\u0002J\b\u0010n\u001a\u00020HH\u0002J\u000e\u0010o\u001a\u00020H2\u0006\u0010p\u001a\u00020>J\u0016\u0010q\u001a\u00020H2\u0006\u0010Y\u001a\u00020J2\u0006\u0010r\u001a\u00020XJ\u0016\u0010s\u001a\b\u0012\u0004\u0012\u00020t0U2\u0006\u0010I\u001a\u00020JH\u0002J\u0016\u0010u\u001a\b\u0012\u0004\u0012\u00020t0U2\u0006\u0010I\u001a\u00020JH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020*8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u0002008\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u001e\u00107\u001a\u0002088\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010=\u001a\u00020>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X.¢\u0006\u0002\n\u0000R\u001e\u0010A\u001a\u00020B8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006x"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyManager;", "", "()V", "accountManager", "Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "getAccountManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "setAccountManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;)V", "barometerManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLBarometerManager;", "getBarometerManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLBarometerManager;", "setBarometerManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLBarometerManager;)V", "clientContext", "Landroid/content/Context;", "dailyLoader", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader;", "getDailyLoader$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader;", "setDailyLoader$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader;)V", "dailyUtils", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "getDailyUtils$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "setDailyUtils$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;)V", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "getDataLogger$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "setDataLogger$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;)V", "eventBus", "Lorg/greenrobot/eventbus/EventBus;", "getEventBus", "()Lorg/greenrobot/eventbus/EventBus;", "setEventBus", "(Lorg/greenrobot/eventbus/EventBus;)V", "h1Client", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "getH1Client$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "setH1Client$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;)V", "locationManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager;", "getLocationManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager;", "setLocationManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager;)V", "locationModeHandler", "Landroid/os/Handler;", "pedometerManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLPedometerManager;", "getPedometerManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLPedometerManager;", "setPedometerManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLPedometerManager;)V", "retryCount", "", "silentLogOperationListener", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$SilentLogOperationListener;", "weatherManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLWeatherManager;", "getWeatherManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLWeatherManager;", "setWeatherManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLWeatherManager;)V", "attemptPostDaily", "", "date", "Ljava/util/Date;", "previousUpdate", "(Ljava/util/Date;Ljava/lang/Integer;)V", "build", "aContext", "aSilentLogOperationListener", "checkLocation", "location", "Landroid/location/Location;", "forceCreateDaily", "getDailyOnBackground", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;", "loadDaily", "", "targetDate", "message", "loadDailyAfterTrackingStarted", "loadDailyBeforeTrackingStop", "loadDailyWithAdjustTrackPoint", "", "loadDailyWithTag", "loadPrediction", "onLocationChanged", "same", "onReceivePostDaily", "postDaily", "Ljp/reifrontier/silentlogsdkandroid/bus/PostDaily;", "release", "removeTwoWeekData", "onCompleted", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "reregisterEventBus", "resetSteps", "startFromGeoFence", "triggerPoiId", "updateDailyNote", "dailyNote", "withAdjustTrackPoint", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyManager$TagResult;", "withTag", "Companion", "TagResult", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager */
public final class RFLDailyManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public SilentLogOperation.SilentLogOperationListener f857a;
    public RFLAccountManager accountManager;
    public RFLBarometerManager barometerManager;
    public RFLDailyLoader dailyLoader;
    public RFLDailyUtils dailyUtils;
    public RFLDataLogger dataLogger;
    public C1126c eventBus;
    public RFLH1Client h1Client;
    public RFLLocationManager locationManager;
    public RFLPedometerManager pedometerManager;
    public RFLWeatherManager weatherManager;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyManager$Companion;", "", "()V", "LOCATION_MODE_DELAY", "", "RETRY_INTERVAL", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyManager$TagResult;", "", "update", "", "(Z)V", "getUpdate", "()Z", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$TagResult */
    public static final class TagResult {

        /* renamed from: a */
        private final boolean f858a;

        public TagResult(boolean z) {
            this.f858a = z;
        }

        public final boolean getUpdate() {
            return this.f858a;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$a */
    static final class C1080a extends Lambda implements Function2<Location, Boolean, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f859a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1080a(RFLDailyManager rFLDailyManager) {
            super(2);
            this.f859a = rFLDailyManager;
        }

        /* renamed from: a */
        public final void mo21658a(Location location, boolean z) {
            this.f859a.m1474a(location, z);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            mo21658a((Location) obj, ((Boolean) obj2).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$b */
    static final class C1081b extends Lambda implements Function0<Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f860a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1081b(RFLDailyManager rFLDailyManager) {
            super(0);
            this.f860a = rFLDailyManager;
        }

        public final void invoke() {
            this.f860a.m1477b();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$c */
    static final class C1082c extends Lambda implements Function0<Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f861a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1082c(RFLDailyManager rFLDailyManager) {
            super(0);
            this.f861a = rFLDailyManager;
        }

        public final void invoke() {
            this.f861a.m1472a();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$d */
    static final class C1083d<T> implements C1741d<RFLDaily> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f862a;

        /* renamed from: b */
        final /* synthetic */ Date f863b;

        /* renamed from: c */
        final /* synthetic */ Integer f864c;

        C1083d(RFLDailyManager rFLDailyManager, Date date, Integer num) {
            this.f862a = rFLDailyManager;
            this.f863b = date;
            this.f864c = num;
        }

        /* renamed from: a */
        public final void accept(RFLDaily rFLDaily) {
            if (rFLDaily == null) {
                C1122a.m1599b("[SilentLogSDK] Error::Upload Daily end... No Valid Daily With Date::daily is null.", new Object[0]);
            } else {
                this.f862a.getDailyLoader$silentlogsdkandroid_release().postDaily(this.f863b, rFLDaily, this.f864c);
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$e */
    static final class C1084e<T> implements C1741d<Throwable> {

        /* renamed from: a */
        public static final C1084e f865a = new C1084e();

        C1084e() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            Intrinsics.checkExpressionValueIsNotNull(th, "error");
            C1122a.m1599b("[SilentLogSDK] Error::Upload Daily end... No Valid Daily With Date::%s", th.getLocalizedMessage());
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$f */
    static final class C1085f<T> implements C1741d<RFLDailyLoader.UpdateDaily> {

        /* renamed from: a */
        public static final C1085f f866a = new C1085f();

        C1085f() {
        }

        /* renamed from: a */
        public final void accept(RFLDailyLoader.UpdateDaily updateDaily) {
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$g */
    static final class C1086g<T> implements C1741d<Throwable> {

        /* renamed from: a */
        public static final C1086g f867a = new C1086g();

        C1086g() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK] Error::Load Daily Error:", th, "error")), new Object[0]);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$h */
    static final class C1087h<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f868a;

        /* renamed from: b */
        final /* synthetic */ Date f869b;

        C1087h(RFLDailyManager rFLDailyManager, Date date) {
            this.f868a = rFLDailyManager;
            this.f869b = date;
        }

        public final RFLDaily call() {
            return this.f868a.getDataLogger$silentlogsdkandroid_release().findDaily(RFLDailyUtilsKt.format$default(this.f869b, "yyyy-MM-dd", (String) null, 2, (Object) null));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$i */
    static final class C1088i<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        public static final C1088i f870a = new C1088i();

        C1088i() {
        }

        /* renamed from: a */
        public final C1714r<String> apply(RFLDailyLoader.UpdateDaily updateDaily) {
            Intrinsics.checkParameterIsNotNull(updateDaily, "t");
            return C1714r.m2412a(updateDaily.getHasData() ? updateDaily.getDaily() : "");
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$j */
    static final class C1089j<V> implements Callable<T> {

        /* renamed from: a */
        public static final C1089j f871a = new C1089j();

        C1089j() {
        }

        public final String call() {
            return "";
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$k */
    static final class C1090k<T> implements C1741d<RFLDailyLoader.UpdateDaily> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f872a;

        /* renamed from: b */
        final /* synthetic */ String f873b;

        /* renamed from: c */
        final /* synthetic */ Date f874c;

        C1090k(RFLDailyManager rFLDailyManager, String str, Date date) {
            this.f872a = rFLDailyManager;
            this.f873b = str;
            this.f874c = date;
        }

        /* renamed from: a */
        public final void accept(RFLDailyLoader.UpdateDaily updateDaily) {
            C1122a.m1600c("[SilentLogSDK] Info::End Daily Factory :::%s", this.f873b);
            if (updateDaily.getHasData()) {
                RFLDailyManager.access$getSilentLogOperationListener$p(this.f872a).resultForLoadDailyBackground(updateDaily.getDaily(), this.f874c);
            }
            this.f872a.m1478b(this.f874c);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$l */
    static final class C1091l<T> implements C1741d<Throwable> {

        /* renamed from: a */
        public static final C1091l f875a = new C1091l();

        C1091l() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK] Error::Load Daily Error:", th, "error")), new Object[0]);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$m */
    static final class C1092m extends Lambda implements Function1<Boolean, Unit> {

        /* renamed from: a */
        public static final C1092m f876a = new C1092m();

        C1092m() {
            super(1);
        }

        /* renamed from: a */
        public final void mo21668a(boolean z) {
            if (z) {
                C1122a.m1596a("[SilentLogSDK]::Debug removeTwoWeekData success", new Object[0]);
            } else {
                C1122a.m1599b("[SilentLogSDK] Error::removeTwoWeekData failed", new Object[0]);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo21668a(((Boolean) obj).booleanValue());
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$n */
    static final class C1093n<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        public static final C1093n f877a = new C1093n();

        C1093n() {
        }

        /* renamed from: a */
        public final C1714r<Boolean> apply(TagResult tagResult) {
            Intrinsics.checkParameterIsNotNull(tagResult, "t");
            return C1714r.m2412a(Boolean.valueOf(tagResult.getUpdate()));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$o */
    static final class C1094o<V> implements Callable<T> {

        /* renamed from: a */
        public static final C1094o f878a = new C1094o();

        C1094o() {
        }

        public final Void call() {
            return null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$p */
    static final class C1095p<T, R> implements C1742e<T, C1718v<? extends R>> {

        /* renamed from: a */
        public static final C1095p f879a = new C1095p();

        C1095p() {
        }

        /* renamed from: a */
        public final C1714r<Boolean> apply(TagResult tagResult) {
            Intrinsics.checkParameterIsNotNull(tagResult, "t");
            return C1714r.m2412a(Boolean.valueOf(tagResult.getUpdate()));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$q */
    static final class C1096q<V> implements Callable<T> {

        /* renamed from: a */
        public static final C1096q f880a = new C1096q();

        C1096q() {
        }

        public final Void call() {
            return null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$r */
    static final class C1097r<T> implements C1741d<RFLDailyLoader.UpdateDaily> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f881a;

        C1097r(RFLDailyManager rFLDailyManager) {
            this.f881a = rFLDailyManager;
        }

        /* renamed from: a */
        public final void accept(RFLDailyLoader.UpdateDaily updateDaily) {
            C1122a.m1600c("[SilentLogSDK] Info::End LoadPrediction Factory :::%s", Boolean.valueOf(updateDaily.getHasData()));
            if (updateDaily.getHasData()) {
                RFLDailyManager.access$getSilentLogOperationListener$p(this.f881a).resultForTransportPrediction(updateDaily.getDaily());
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$s */
    static final class C1098s<T> implements C1741d<Throwable> {

        /* renamed from: a */
        public static final C1098s f882a = new C1098s();

        C1098s() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("loadPrediction Daily Error:", th, "error")), new Object[0]);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$t */
    static final class C1099t implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f883a;

        /* renamed from: b */
        final /* synthetic */ Date f884b;

        /* renamed from: c */
        final /* synthetic */ PostDaily f885c;

        C1099t(RFLDailyManager rFLDailyManager, Date date, PostDaily postDaily) {
            this.f883a = rFLDailyManager;
            this.f884b = date;
            this.f885c = postDaily;
        }

        public final void run() {
            this.f883a.m1475a(this.f884b, this.f885c.getPreviousUpdate());
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$u */
    static final class C1100u implements C1699e {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f886a;

        C1100u(RFLDailyManager rFLDailyManager) {
            this.f886a = rFLDailyManager;
        }

        public final void subscribe(C1697c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "emitter");
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            Object clone = instance.clone();
            if (clone != null) {
                Calendar calendar = (Calendar) clone;
                calendar.set(5, calendar.get(5) - 14);
                this.f886a.getDataLogger$silentlogsdkandroid_release().deleteTwoWeekData(calendar);
                cVar.onComplete();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.util.Calendar");
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$v */
    static final class C1101v implements C1738a {

        /* renamed from: a */
        final /* synthetic */ Function1 f887a;

        C1101v(Function1 function1) {
            this.f887a = function1;
        }

        public final void run() {
            C1122a.m1596a("[SilentLogSDK] Debug::removeTwoWeekData success", new Object[0]);
            this.f887a.invoke(true);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$w */
    static final class C1102w<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Function1 f888a;

        C1102w(Function1 function1) {
            this.f888a = function1;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK] Error::removeTwoWeekData error=", th, "it")), new Object[0]);
            this.f888a.invoke(false);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$x */
    static final class C1103x<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f889a;

        /* renamed from: b */
        final /* synthetic */ Date f890b;

        C1103x(RFLDailyManager rFLDailyManager, Date date) {
            this.f889a = rFLDailyManager;
            this.f890b = date;
        }

        public final TagResult call() {
            boolean z;
            boolean z2;
            String format$default = RFLDailyUtilsKt.format$default(this.f890b, "yyyy-MM-dd", (String) null, 2, (Object) null);
            RFLDaily findDaily = this.f889a.getDataLogger$silentlogsdkandroid_release().findDaily(format$default);
            if (findDaily != null) {
                boolean z3 = false;
                for (RFLSegment activities : findDaily.getSegments()) {
                    for (RFLActivity next : activities.getActivities()) {
                        List<RFLTrackPoint> findAdjustTrackPoints = this.f889a.getDataLogger$silentlogsdkandroid_release().findAdjustTrackPoints(next.getFromDate(), next.getToDate());
                        if (next.getAdjustTrackPoints() == null || next.getAdjustTrackPoints().size() != findAdjustTrackPoints.size()) {
                            z2 = true;
                        } else {
                            z2 = false;
                            int i = 0;
                            for (T next2 : next.getAdjustTrackPoints()) {
                                int i2 = i + 1;
                                if (i < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                RFLTrackPoint rFLTrackPoint = (RFLTrackPoint) next2;
                                if (findAdjustTrackPoints.get(i).getTimestamp() != rFLTrackPoint.getTimestamp() || findAdjustTrackPoints.get(i).getLatitude() != rFLTrackPoint.getLatitude() || findAdjustTrackPoints.get(i).getLongitude() != rFLTrackPoint.getLongitude() || findAdjustTrackPoints.get(i).getAccuracy() != rFLTrackPoint.getAccuracy() || (!Intrinsics.areEqual((Object) findAdjustTrackPoints.get(i).getTimezone(), (Object) rFLTrackPoint.getTimezone()))) {
                                    z2 = true;
                                }
                                i = i2;
                            }
                        }
                        if (z2) {
                            next.setAdjustTrackPoints(findAdjustTrackPoints);
                            z3 = true;
                        }
                    }
                }
                if (z3) {
                    this.f889a.getDataLogger$silentlogsdkandroid_release().insertDaily(findDaily, format$default).mo27431a();
                    this.f889a.getEventBus().mo21903a((Object) new PostDaily(this.f890b, (Integer) null));
                }
                z = z3;
            } else {
                z = false;
            }
            return new TagResult(z);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$y */
    static final class C1104y<V> implements Callable<T> {

        /* renamed from: a */
        final /* synthetic */ RFLDailyManager f891a;

        /* renamed from: b */
        final /* synthetic */ Date f892b;

        C1104y(RFLDailyManager rFLDailyManager, Date date) {
            this.f891a = rFLDailyManager;
            this.f892b = date;
        }

        public final TagResult call() {
            ArrayList arrayList;
            ArrayList arrayList2;
            String format$default = RFLDailyUtilsKt.format$default(this.f892b, "yyyy-MM-dd", (String) null, 2, (Object) null);
            RFLDaily findDaily = this.f891a.getDataLogger$silentlogsdkandroid_release().findDaily(format$default);
            boolean z = false;
            if (findDaily != null) {
                boolean z2 = false;
                for (RFLSegment activities : findDaily.getSegments()) {
                    for (RFLActivity next : activities.getActivities()) {
                        List<RFLTag> findTag = this.f891a.getDataLogger$silentlogsdkandroid_release().findTag(next.getFromDate(), next.getToDate(), next.type() != RFL_ACTIVITY_TYPE.STAY);
                        if (findTag == null) {
                            findTag = CollectionsKt__CollectionsKt.emptyList();
                        }
                        List<RFLTag> tagList = next.getTagList();
                        if (tagList != null) {
                            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(tagList, 10));
                            for (RFLTag add : tagList) {
                                arrayList3.add(add);
                            }
                            arrayList = arrayList3;
                        } else {
                            arrayList = CollectionsKt__CollectionsKt.emptyList();
                        }
                        next.replaceUserTagList(findTag);
                        List<RFLTag> tagList2 = next.getTagList();
                        if (tagList2 != null) {
                            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(tagList2, 10));
                            for (RFLTag add2 : tagList2) {
                                arrayList4.add(add2);
                            }
                            arrayList2 = arrayList4;
                        } else {
                            arrayList2 = CollectionsKt__CollectionsKt.emptyList();
                        }
                        if (!Intrinsics.areEqual((Object) arrayList, (Object) arrayList2)) {
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    this.f891a.getDataLogger$silentlogsdkandroid_release().insertDaily(findDaily, format$default).mo27431a();
                    this.f891a.getEventBus().mo21903a((Object) new PostDaily(this.f892b, (Integer) null));
                }
                z = z2;
            }
            return new TagResult(z);
        }
    }

    public RFLDailyManager() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
        RFLLocationManager rFLLocationManager = this.locationManager;
        if (rFLLocationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        rFLLocationManager.setOnLocationChange$silentlogsdkandroid_release(new C1080a(this));
        RFLLocationManager rFLLocationManager2 = this.locationManager;
        if (rFLLocationManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        rFLLocationManager2.setStopLocation$silentlogsdkandroid_release(new C1081b(this));
        RFLLocationManager rFLLocationManager3 = this.locationManager;
        if (rFLLocationManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        rFLLocationManager3.setInitLocationUpdate$silentlogsdkandroid_release(new C1082c(this));
    }

    /* renamed from: a */
    private final C1714r<RFLDaily> m1471a(Date date) {
        C1714r<RFLDaily> a = C1714r.m2413a(new C1087h(this, date));
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …ily(dateString)\n        }");
        return a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m1472a() {
        long loadTime = RFLSharedHolder.INSTANCE.loadTime();
        Date date = new Date();
        if (System.currentTimeMillis() - loadTime > 7200000) {
            if (!DateUtils.isToday(loadTime)) {
                date = RFLDailyUtilsKt.yesterday(date);
            }
            m1476a(date, "After Start Tracking");
        }
    }

    /* renamed from: a */
    private final void m1473a(Location location) {
        RFLLocationManager rFLLocationManager = this.locationManager;
        if (rFLLocationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        rFLLocationManager.checkLocation(location);
        RFLBarometerManager rFLBarometerManager = this.barometerManager;
        if (rFLBarometerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barometerManager");
        }
        rFLBarometerManager.startUpdate$silentlogsdkandroid_release();
        RFLWeatherManager rFLWeatherManager = this.weatherManager;
        if (rFLWeatherManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherManager");
        }
        rFLWeatherManager.startUpdate(location);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m1474a(Location location, boolean z) {
        if (location == null) {
            C1122a.m1599b("[SilentLogSDK] Error::onLocationChanged:: Location is Null", new Object[0]);
            m1477b();
        } else {
            if (!z) {
                RFLDataLogger rFLDataLogger = this.dataLogger;
                if (rFLDataLogger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
                }
                rFLDataLogger.insertLocation(location).mo27431a();
                RFLLocationManager rFLLocationManager = this.locationManager;
                if (rFLLocationManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationManager");
                }
                rFLLocationManager.discriminateActivity(location);
                m1473a(location);
            }
            C1122a.m1596a("onLocationChanged : %s,%s time:%s", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude()), Long.valueOf(location.getTime() / ((long) 1000)));
        }
        RFLPedometerManager rFLPedometerManager = this.pedometerManager;
        if (rFLPedometerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pedometerManager");
        }
        rFLPedometerManager.forceStopActiveModeIfNeed();
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    public final void m1475a(Date date, Integer num) {
        m1471a(date).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C1083d(this, date, num), C1084e.f865a);
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    private final void m1476a(Date date, String str) {
        C1122a.m1600c("[SilentLogSDK] Info::Start DailyFactory %s:::targetDate:%s", str, RFLDailyUtilsKt.format$default(date, "yyyyMMdd", (String) null, 2, (Object) null));
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        if (!rFLAccountManager.isLogin()) {
            C1122a.m1599b("[SilentLogSDK] Error::Load Daily Error: have not logged in", new Object[0]);
            return;
        }
        RFLDailyLoader rFLDailyLoader = this.dailyLoader;
        if (rFLDailyLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyLoader");
        }
        rFLDailyLoader.loadDaily(date).mo27432a(new C1090k(this, str, date), C1091l.f875a);
    }

    public static final /* synthetic */ SilentLogOperation.SilentLogOperationListener access$getSilentLogOperationListener$p(RFLDailyManager rFLDailyManager) {
        SilentLogOperation.SilentLogOperationListener silentLogOperationListener = rFLDailyManager.f857a;
        if (silentLogOperationListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("silentLogOperationListener");
        }
        return silentLogOperationListener;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x004b, code lost:
        if (r4.currentSteps() > 50) goto L_0x004d;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1477b() {
        /*
            r10 = this;
            jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder r0 = p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder.INSTANCE
            long r0 = r0.loadTime()
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r2 - r0
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r3 = 0
            r6[r3] = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            r7 = 1
            r6[r7] = r2
            java.lang.String r2 = "loadDailyBeforeTrackingStop now :%s date:%s"
            p048l.p049a.C1122a.m1596a(r2, r6)
            java.lang.Object[] r2 = new java.lang.Object[r7]
            java.lang.Long r6 = java.lang.Long.valueOf(r4)
            r2[r3] = r6
            java.lang.String r6 = "loadDailyBeforeTrackingStop interval :%s"
            p048l.p049a.C1122a.m1596a(r6, r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            r8 = 7200000(0x6ddd00, double:3.5572727E-317)
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x003c
            goto L_0x004d
        L_0x003c:
            jp.reifrontier.silentlogsdkandroid.daily.RFLPedometerManager r4 = r10.pedometerManager
            if (r4 != 0) goto L_0x0045
            java.lang.String r5 = "pedometerManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x0045:
            int r4 = r4.currentSteps()
            r5 = 50
            if (r4 <= r5) goto L_0x004e
        L_0x004d:
            r3 = 1
        L_0x004e:
            jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager r4 = r10.locationManager
            java.lang.String r5 = "locationManager"
            if (r4 != 0) goto L_0x0057
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x0057:
            android.location.Location r4 = r4.getCurrentLocation$silentlogsdkandroid_release()
            if (r4 == 0) goto L_0x007d
            jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger r4 = r10.dataLogger
            if (r4 != 0) goto L_0x0066
            java.lang.String r6 = "dataLogger"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x0066:
            jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager r6 = r10.locationManager
            if (r6 != 0) goto L_0x006d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x006d:
            android.location.Location r6 = r6.getCurrentLocation$silentlogsdkandroid_release()
            if (r6 != 0) goto L_0x0076
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0076:
            g.a.r r4 = r4.insertTP(r6)
            r4.mo27431a()
        L_0x007d:
            if (r3 == 0) goto L_0x008e
            boolean r0 = android.text.format.DateUtils.isToday(r0)
            if (r0 != 0) goto L_0x0089
            java.util.Date r2 = p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt.yesterday(r2)
        L_0x0089:
            java.lang.String r0 = "Before Stop Location"
            r10.m1476a((java.util.Date) r2, (java.lang.String) r0)
        L_0x008e:
            jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager r0 = r10.locationManager
            if (r0 != 0) goto L_0x0095
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x0095:
            r0.stopLocationUpdates()
            r10.m1482d()
            jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager r0 = r10.locationManager
            if (r0 != 0) goto L_0x00a2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x00a2:
            r0.startGeoFence()
            jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder r0 = p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder.INSTANCE
            boolean r0 = r0.isEnableTwoWeekSetting()
            if (r0 == 0) goto L_0x00b2
            jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager$m r0 = p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager.C1092m.f876a
            r10.removeTwoWeekData(r0)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager.m1477b():void");
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    /* renamed from: b */
    public final void m1478b(Date date) {
        if (RFLSharedHolder.INSTANCE.predict()) {
            C1122a.m1600c("[SilentLogSDK] Info::Start LoadPrediction Factory :::", new Object[0]);
            Date yesterday = RFLDailyUtilsKt.yesterday(date);
            RFLDailyLoader rFLDailyLoader = this.dailyLoader;
            if (rFLDailyLoader == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dailyLoader");
            }
            rFLDailyLoader.loadPredictionDaily(yesterday).mo27432a(new C1097r(this), C1098s.f882a);
        }
    }

    /* renamed from: c */
    private final C1714r<TagResult> m1479c(Date date) {
        C1714r<TagResult> a = C1714r.m2413a(new C1103x(this, date));
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …gResult(update)\n        }");
        return a;
    }

    /* renamed from: c */
    private final void m1480c() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        cVar.mo21908c(this);
        C1126c cVar2 = this.eventBus;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        cVar2.mo21907b(this);
    }

    /* renamed from: d */
    private final C1714r<TagResult> m1481d(Date date) {
        C1714r<TagResult> a = C1714r.m2413a(new C1104y(this, date));
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable {\n  …gResult(update)\n        }");
        return a;
    }

    /* renamed from: d */
    private final void m1482d() {
        RFLPedometerManager rFLPedometerManager = this.pedometerManager;
        if (rFLPedometerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pedometerManager");
        }
        rFLPedometerManager.resetCurrentSteps();
    }

    public final void build(Context context, SilentLogOperation.SilentLogOperationListener silentLogOperationListener) {
        Intrinsics.checkParameterIsNotNull(context, "aContext");
        Intrinsics.checkParameterIsNotNull(silentLogOperationListener, "aSilentLogOperationListener");
        this.f857a = silentLogOperationListener;
        RFLLocationManager rFLLocationManager = this.locationManager;
        if (rFLLocationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        rFLLocationManager.checkPermission();
        RFLPedometerManager rFLPedometerManager = this.pedometerManager;
        if (rFLPedometerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pedometerManager");
        }
        rFLPedometerManager.build(context);
        RFLBarometerManager rFLBarometerManager = this.barometerManager;
        if (rFLBarometerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barometerManager");
        }
        rFLBarometerManager.initialize$silentlogsdkandroid_release(context);
        m1480c();
    }

    @SuppressLint({"CheckResult"})
    public final void forceCreateDaily() {
        RFLDailyLoader rFLDailyLoader = this.dailyLoader;
        if (rFLDailyLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyLoader");
        }
        rFLDailyLoader.loadDaily(new Date()).mo27432a(C1085f.f866a, C1086g.f867a);
    }

    public final RFLAccountManager getAccountManager$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager;
    }

    public final RFLBarometerManager getBarometerManager$silentlogsdkandroid_release() {
        RFLBarometerManager rFLBarometerManager = this.barometerManager;
        if (rFLBarometerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barometerManager");
        }
        return rFLBarometerManager;
    }

    public final RFLDailyLoader getDailyLoader$silentlogsdkandroid_release() {
        RFLDailyLoader rFLDailyLoader = this.dailyLoader;
        if (rFLDailyLoader == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyLoader");
        }
        return rFLDailyLoader;
    }

    public final RFLDailyUtils getDailyUtils$silentlogsdkandroid_release() {
        RFLDailyUtils rFLDailyUtils = this.dailyUtils;
        if (rFLDailyUtils == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
        }
        return rFLDailyUtils;
    }

    public final RFLDataLogger getDataLogger$silentlogsdkandroid_release() {
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        return rFLDataLogger;
    }

    public final C1126c getEventBus() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        return cVar;
    }

    public final RFLH1Client getH1Client$silentlogsdkandroid_release() {
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        return rFLH1Client;
    }

    public final RFLLocationManager getLocationManager$silentlogsdkandroid_release() {
        RFLLocationManager rFLLocationManager = this.locationManager;
        if (rFLLocationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        return rFLLocationManager;
    }

    public final RFLPedometerManager getPedometerManager$silentlogsdkandroid_release() {
        RFLPedometerManager rFLPedometerManager = this.pedometerManager;
        if (rFLPedometerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pedometerManager");
        }
        return rFLPedometerManager;
    }

    public final RFLWeatherManager getWeatherManager$silentlogsdkandroid_release() {
        RFLWeatherManager rFLWeatherManager = this.weatherManager;
        if (rFLWeatherManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weatherManager");
        }
        return rFLWeatherManager;
    }

    public final C1714r<String> loadDaily(Date date) {
        C1714r<R> rVar;
        String str;
        Intrinsics.checkParameterIsNotNull(date, "date");
        if (RFLSharedHolder.INSTANCE.grant()) {
            RFLDailyLoader rFLDailyLoader = this.dailyLoader;
            if (rFLDailyLoader == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dailyLoader");
            }
            rVar = rFLDailyLoader.loadDaily(date).mo27430a(C1088i.f870a);
            str = "dailyLoader.loadDaily(da…  }\n                    }";
        } else {
            C1122a.m1599b("[SilentLogSDK]::Error No location permission", new Object[0]);
            rVar = C1714r.m2413a(C1089j.f871a);
            str = "Single.fromCallable {\n  …         \"\"\n            }";
        }
        Intrinsics.checkExpressionValueIsNotNull(rVar, str);
        return rVar;
    }

    public final C1714r<Boolean> loadDailyWithAdjustTrackPoint(Date date) {
        C1714r<R> rVar;
        String str;
        Intrinsics.checkParameterIsNotNull(date, "date");
        if (RFLSharedHolder.INSTANCE.grant()) {
            rVar = m1479c(date).mo27430a(C1093n.f877a);
            str = "withAdjustTrackPoint(dat…> Single.just(t.update) }";
        } else {
            C1122a.m1599b("[SilentLogSDK]::Error No location permission", new Object[0]);
            rVar = C1714r.m2413a(C1094o.f878a);
            str = "Single.fromCallable {\n  …       null\n            }";
        }
        Intrinsics.checkExpressionValueIsNotNull(rVar, str);
        return rVar;
    }

    public final C1714r<Boolean> loadDailyWithTag(Date date) {
        C1714r<R> rVar;
        String str;
        Intrinsics.checkParameterIsNotNull(date, "date");
        if (RFLSharedHolder.INSTANCE.grant()) {
            rVar = m1481d(date).mo27430a(C1095p.f879a);
            str = "withTag(date).flatMap { …> Single.just(t.update) }";
        } else {
            C1122a.m1599b("[SilentLogSDK]::Error No location permission", new Object[0]);
            rVar = C1714r.m2413a(C1096q.f880a);
            str = "Single.fromCallable {\n  …       null\n            }";
        }
        Intrinsics.checkExpressionValueIsNotNull(rVar, str);
        return rVar;
    }

    @C1129m(threadMode = ThreadMode.MAIN)
    public final void onReceivePostDaily(PostDaily postDaily) {
        Intrinsics.checkParameterIsNotNull(postDaily, "postDaily");
        new Handler().postDelayed(new C1099t(this, postDaily.getDate(), postDaily), 500);
    }

    public final void release() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        cVar.mo21908c(this);
        RFLBarometerManager rFLBarometerManager = this.barometerManager;
        if (rFLBarometerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("barometerManager");
        }
        rFLBarometerManager.release$silentlogsdkandroid_release();
        RFLPedometerManager rFLPedometerManager = this.pedometerManager;
        if (rFLPedometerManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pedometerManager");
        }
        rFLPedometerManager.release();
    }

    @SuppressLint({"CheckResult"})
    public final void removeTwoWeekData(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "onCompleted");
        if (!RFLSharedHolder.INSTANCE.isEnableTwoWeekSetting()) {
            function1.invoke(true);
            return;
        }
        C1696b a = C1696b.m2386a((C1699e) new C1100u(this)).mo27420a(C1683a.m2378b());
        C1101v vVar = new C1101v(function1);
        C1102w wVar = new C1102w(function1);
        C1599b.m2241a(wVar, "onError is null");
        C1599b.m2241a(vVar, "onComplete is null");
        a.mo27423a((C1698d) new C1603b(wVar, vVar));
    }

    public final void setAccountManager$silentlogsdkandroid_release(RFLAccountManager rFLAccountManager) {
        Intrinsics.checkParameterIsNotNull(rFLAccountManager, "<set-?>");
        this.accountManager = rFLAccountManager;
    }

    public final void setBarometerManager$silentlogsdkandroid_release(RFLBarometerManager rFLBarometerManager) {
        Intrinsics.checkParameterIsNotNull(rFLBarometerManager, "<set-?>");
        this.barometerManager = rFLBarometerManager;
    }

    public final void setDailyLoader$silentlogsdkandroid_release(RFLDailyLoader rFLDailyLoader) {
        Intrinsics.checkParameterIsNotNull(rFLDailyLoader, "<set-?>");
        this.dailyLoader = rFLDailyLoader;
    }

    public final void setDailyUtils$silentlogsdkandroid_release(RFLDailyUtils rFLDailyUtils) {
        Intrinsics.checkParameterIsNotNull(rFLDailyUtils, "<set-?>");
        this.dailyUtils = rFLDailyUtils;
    }

    public final void setDataLogger$silentlogsdkandroid_release(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "<set-?>");
        this.dataLogger = rFLDataLogger;
    }

    public final void setEventBus(C1126c cVar) {
        Intrinsics.checkParameterIsNotNull(cVar, "<set-?>");
        this.eventBus = cVar;
    }

    public final void setH1Client$silentlogsdkandroid_release(RFLH1Client rFLH1Client) {
        Intrinsics.checkParameterIsNotNull(rFLH1Client, "<set-?>");
        this.h1Client = rFLH1Client;
    }

    public final void setLocationManager$silentlogsdkandroid_release(RFLLocationManager rFLLocationManager) {
        Intrinsics.checkParameterIsNotNull(rFLLocationManager, "<set-?>");
        this.locationManager = rFLLocationManager;
    }

    public final void setPedometerManager$silentlogsdkandroid_release(RFLPedometerManager rFLPedometerManager) {
        Intrinsics.checkParameterIsNotNull(rFLPedometerManager, "<set-?>");
        this.pedometerManager = rFLPedometerManager;
    }

    public final void setWeatherManager$silentlogsdkandroid_release(RFLWeatherManager rFLWeatherManager) {
        Intrinsics.checkParameterIsNotNull(rFLWeatherManager, "<set-?>");
        this.weatherManager = rFLWeatherManager;
    }

    public final void startFromGeoFence(int i) {
        RFLLocationManager rFLLocationManager = this.locationManager;
        if (rFLLocationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationManager");
        }
        rFLLocationManager.stopGeoFenceEvent();
    }

    public final void updateDailyNote(Date date, String str) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(str, "dailyNote");
        String format$default = RFLDailyUtilsKt.format$default(date, "yyyy-MM-dd", (String) null, 2, (Object) null);
        RFLDataLogger rFLDataLogger = this.dataLogger;
        if (rFLDataLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
        }
        RFLDaily findDaily = rFLDataLogger.findDaily(format$default);
        if (findDaily != null) {
            RFLSummary summary = findDaily.getSummary();
            if (!Intrinsics.areEqual((Object) summary != null ? summary.getDailyNote() : null, (Object) str)) {
                if (str.length() == 0) {
                    findDaily.setSummary((RFLSummary) null);
                } else {
                    findDaily.setSummary(new RFLSummary(str));
                }
                RFLDataLogger rFLDataLogger2 = this.dataLogger;
                if (rFLDataLogger2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataLogger");
                }
                rFLDataLogger2.insertDaily(findDaily, format$default).mo27431a();
                C1126c cVar = this.eventBus;
                if (cVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventBus");
                }
                cVar.mo21903a((Object) new PostDaily(date, (Integer) null));
            }
        }
    }
}
