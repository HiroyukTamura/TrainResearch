package p043jp.reifrontier.silentlogsdkandroid;

import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLActivityPoiManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdjustTrackPointManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleFitManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLPointClient;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLWeatherClient;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLOrmaHolder;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation_MembersInjector */
public final class RFLSilentLogOperation_MembersInjector implements C1583a<RFLSilentLogOperation> {

    /* renamed from: a */
    private final C1743a<RFLDailyManager> f2980a;

    /* renamed from: b */
    private final C1743a<RFLDailyLoader> f2981b;

    /* renamed from: c */
    private final C1743a<RFLDataLogger> f2982c;

    /* renamed from: d */
    private final C1743a<RFLDailyUtils> f2983d;

    /* renamed from: e */
    private final C1743a<RFLH1Client> f2984e;

    /* renamed from: f */
    private final C1743a<RFLPointClient> f2985f;

    /* renamed from: g */
    private final C1743a<RFLWeatherClient> f2986g;

    /* renamed from: h */
    private final C1743a<RFLLocationManager> f2987h;

    /* renamed from: i */
    private final C1743a<RFLGoogleFitManager> f2988i;

    /* renamed from: j */
    private final C1743a<RFLAccountManager> f2989j;

    /* renamed from: k */
    private final C1743a<RFLAdManager> f2990k;

    /* renamed from: l */
    private final C1743a<C1126c> f2991l;

    /* renamed from: m */
    private final C1743a<RFLOrmaHolder> f2992m;

    /* renamed from: n */
    private final C1743a<RFLActivityPoiManager> f2993n;

    /* renamed from: o */
    private final C1743a<RFLAdjustTrackPointManager> f2994o;

    /* renamed from: p */
    private final C1743a<RFLDailyTagManager> f2995p;

    /* renamed from: q */
    private final C1743a<RFLWeatherManager> f2996q;

    public RFLSilentLogOperation_MembersInjector(C1743a<RFLDailyManager> aVar, C1743a<RFLDailyLoader> aVar2, C1743a<RFLDataLogger> aVar3, C1743a<RFLDailyUtils> aVar4, C1743a<RFLH1Client> aVar5, C1743a<RFLPointClient> aVar6, C1743a<RFLWeatherClient> aVar7, C1743a<RFLLocationManager> aVar8, C1743a<RFLGoogleFitManager> aVar9, C1743a<RFLAccountManager> aVar10, C1743a<RFLAdManager> aVar11, C1743a<C1126c> aVar12, C1743a<RFLOrmaHolder> aVar13, C1743a<RFLActivityPoiManager> aVar14, C1743a<RFLAdjustTrackPointManager> aVar15, C1743a<RFLDailyTagManager> aVar16, C1743a<RFLWeatherManager> aVar17) {
        this.f2980a = aVar;
        this.f2981b = aVar2;
        this.f2982c = aVar3;
        this.f2983d = aVar4;
        this.f2984e = aVar5;
        this.f2985f = aVar6;
        this.f2986g = aVar7;
        this.f2987h = aVar8;
        this.f2988i = aVar9;
        this.f2989j = aVar10;
        this.f2990k = aVar11;
        this.f2991l = aVar12;
        this.f2992m = aVar13;
        this.f2993n = aVar14;
        this.f2994o = aVar15;
        this.f2995p = aVar16;
        this.f2996q = aVar17;
    }

    public static C1583a<RFLSilentLogOperation> create(C1743a<RFLDailyManager> aVar, C1743a<RFLDailyLoader> aVar2, C1743a<RFLDataLogger> aVar3, C1743a<RFLDailyUtils> aVar4, C1743a<RFLH1Client> aVar5, C1743a<RFLPointClient> aVar6, C1743a<RFLWeatherClient> aVar7, C1743a<RFLLocationManager> aVar8, C1743a<RFLGoogleFitManager> aVar9, C1743a<RFLAccountManager> aVar10, C1743a<RFLAdManager> aVar11, C1743a<C1126c> aVar12, C1743a<RFLOrmaHolder> aVar13, C1743a<RFLActivityPoiManager> aVar14, C1743a<RFLAdjustTrackPointManager> aVar15, C1743a<RFLDailyTagManager> aVar16, C1743a<RFLWeatherManager> aVar17) {
        return new RFLSilentLogOperation_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13, aVar14, aVar15, aVar16, aVar17);
    }

    public static void injectAccountManager(RFLSilentLogOperation rFLSilentLogOperation, RFLAccountManager rFLAccountManager) {
        rFLSilentLogOperation.accountManager = rFLAccountManager;
    }

    public static void injectActivityPoiManager(RFLSilentLogOperation rFLSilentLogOperation, RFLActivityPoiManager rFLActivityPoiManager) {
        rFLSilentLogOperation.activityPoiManager = rFLActivityPoiManager;
    }

    public static void injectAdManager(RFLSilentLogOperation rFLSilentLogOperation, RFLAdManager rFLAdManager) {
        rFLSilentLogOperation.adManager = rFLAdManager;
    }

    public static void injectAdjustTrackPointManager(RFLSilentLogOperation rFLSilentLogOperation, RFLAdjustTrackPointManager rFLAdjustTrackPointManager) {
        rFLSilentLogOperation.adjustTrackPointManager = rFLAdjustTrackPointManager;
    }

    public static void injectDailyLoader(RFLSilentLogOperation rFLSilentLogOperation, RFLDailyLoader rFLDailyLoader) {
        rFLSilentLogOperation.dailyLoader = rFLDailyLoader;
    }

    public static void injectDailyManager(RFLSilentLogOperation rFLSilentLogOperation, RFLDailyManager rFLDailyManager) {
        rFLSilentLogOperation.dailyManager = rFLDailyManager;
    }

    public static void injectDailyTagManager(RFLSilentLogOperation rFLSilentLogOperation, RFLDailyTagManager rFLDailyTagManager) {
        rFLSilentLogOperation.dailyTagManager = rFLDailyTagManager;
    }

    public static void injectDailyUtils(RFLSilentLogOperation rFLSilentLogOperation, RFLDailyUtils rFLDailyUtils) {
        rFLSilentLogOperation.dailyUtils = rFLDailyUtils;
    }

    public static void injectDataLogger(RFLSilentLogOperation rFLSilentLogOperation, RFLDataLogger rFLDataLogger) {
        rFLSilentLogOperation.dataLogger = rFLDataLogger;
    }

    public static void injectEventBus(RFLSilentLogOperation rFLSilentLogOperation, C1126c cVar) {
        rFLSilentLogOperation.eventBus = cVar;
    }

    public static void injectGoogleFitManager(RFLSilentLogOperation rFLSilentLogOperation, RFLGoogleFitManager rFLGoogleFitManager) {
        rFLSilentLogOperation.googleFitManager = rFLGoogleFitManager;
    }

    public static void injectH1Client(RFLSilentLogOperation rFLSilentLogOperation, RFLH1Client rFLH1Client) {
        rFLSilentLogOperation.h1Client = rFLH1Client;
    }

    public static void injectLocationManager(RFLSilentLogOperation rFLSilentLogOperation, RFLLocationManager rFLLocationManager) {
        rFLSilentLogOperation.locationManager = rFLLocationManager;
    }

    public static void injectOrmaHolder(RFLSilentLogOperation rFLSilentLogOperation, RFLOrmaHolder rFLOrmaHolder) {
        rFLSilentLogOperation.ormaHolder = rFLOrmaHolder;
    }

    public static void injectPointClient(RFLSilentLogOperation rFLSilentLogOperation, RFLPointClient rFLPointClient) {
        rFLSilentLogOperation.pointClient = rFLPointClient;
    }

    public static void injectWeatherClient(RFLSilentLogOperation rFLSilentLogOperation, RFLWeatherClient rFLWeatherClient) {
        rFLSilentLogOperation.weatherClient = rFLWeatherClient;
    }

    public static void injectWeatherManager(RFLSilentLogOperation rFLSilentLogOperation, RFLWeatherManager rFLWeatherManager) {
        rFLSilentLogOperation.weatherManager = rFLWeatherManager;
    }

    public void injectMembers(RFLSilentLogOperation rFLSilentLogOperation) {
        injectDailyManager(rFLSilentLogOperation, this.f2980a.get());
        injectDailyLoader(rFLSilentLogOperation, this.f2981b.get());
        injectDataLogger(rFLSilentLogOperation, this.f2982c.get());
        injectDailyUtils(rFLSilentLogOperation, this.f2983d.get());
        injectH1Client(rFLSilentLogOperation, this.f2984e.get());
        injectPointClient(rFLSilentLogOperation, this.f2985f.get());
        injectWeatherClient(rFLSilentLogOperation, this.f2986g.get());
        injectLocationManager(rFLSilentLogOperation, this.f2987h.get());
        injectGoogleFitManager(rFLSilentLogOperation, this.f2988i.get());
        injectAccountManager(rFLSilentLogOperation, this.f2989j.get());
        injectAdManager(rFLSilentLogOperation, this.f2990k.get());
        injectEventBus(rFLSilentLogOperation, this.f2991l.get());
        injectOrmaHolder(rFLSilentLogOperation, this.f2992m.get());
        injectActivityPoiManager(rFLSilentLogOperation, this.f2993n.get());
        injectAdjustTrackPointManager(rFLSilentLogOperation, this.f2994o.get());
        injectDailyTagManager(rFLSilentLogOperation, this.f2995p.get());
        injectWeatherManager(rFLSilentLogOperation, this.f2996q.get());
    }
}
