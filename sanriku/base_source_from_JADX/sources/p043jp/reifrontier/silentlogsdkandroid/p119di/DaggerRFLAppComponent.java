package p043jp.reifrontier.silentlogsdkandroid.p119di;

import org.greenrobot.eventbus.C1126c;
import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation;
import p043jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLActivityPoiManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdjustTrackPointManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBarometerManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBarometerManager_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleFitManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleLocationService;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLPedometerManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLPedometerManager_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLPointManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLPointClient;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLWeatherClient;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLActivityDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLActivityDao_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLAdjustTrackPointDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLAdjustTrackPointDao_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLBarometerDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLBarometerDao_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyDao_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyTagDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLOrmaHolder;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLPedometerDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLPedometerDao_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTPDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTPDao_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTagDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTagDao_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTrackPointDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTrackPointDao_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLWeatherDao;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLNotificationPoi;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLNotificationPoi_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2257x72b792cf;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2258x197e4725;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2259x8c528aaa;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2260x76d5719c;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2261xbc91a1a1;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2262xa7d9f3e8;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2263x3e9e58d7;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2264xf7b41ded;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2265x81ee3a37;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2266x6bf27c69;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2267x1fc41567;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2268x970d8335;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2269x3a77eacd;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2270x54971c98;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2271x3b4d6e9d;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2272x56505488;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2273xa98950a4;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2274x7ebd3236;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2275xb4b9ae64;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2276xd1c76dc3;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2277x36462bc4;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2278x5313ed76;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2279xa9864557;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2280xbd18c26f;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2281xaa5dc399;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2282x7b9bb408;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2283x9f7626f4;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2284x7c9bf361;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.C2285xd513b0cb;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.RFLAppModule;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.RFLAppModule_ProvideEventBus$silentlogsdkandroid_releaseFactory;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.RFLAppModule_ProvideRFLTPDao$silentlogsdkandroid_releaseFactory;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.RFLAppModule_ProvideRFLTagDao$silentlogsdkandroid_releaseFactory;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.RFLClientContextModule;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLLogTree;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLLogTree_MembersInjector;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLLogger;
import p076f.p077b.C1584a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.DaggerRFLAppComponent */
public final class DaggerRFLAppComponent implements RFLAppComponent {

    /* renamed from: A */
    private C1743a<RFLBarometerDao> f3346A;

    /* renamed from: B */
    private C1743a<RFLDailyTagDao> f3347B;

    /* renamed from: C */
    private C1743a<RFLWeatherDao> f3348C;

    /* renamed from: D */
    private C1743a<RFLPointManager> f3349D;

    /* renamed from: E */
    private C1743a<RFLBeaconManager> f3350E;

    /* renamed from: F */
    private C1743a<RFLGoogleLocationService> f3351F;

    /* renamed from: a */
    private C1743a<RFLDailyManager> f3352a;

    /* renamed from: b */
    private C1743a<RFLDailyLoader> f3353b;

    /* renamed from: c */
    private C1743a<RFLDataLogger> f3354c;

    /* renamed from: d */
    private C1743a<RFLDailyUtils> f3355d;

    /* renamed from: e */
    private C1743a<RFLH1Client> f3356e;

    /* renamed from: f */
    private C1743a<RFLPointClient> f3357f;

    /* renamed from: g */
    private C1743a<RFLWeatherClient> f3358g;

    /* renamed from: h */
    private C1743a<RFLLocationManager> f3359h;

    /* renamed from: i */
    private C1743a<RFLGoogleFitManager> f3360i;

    /* renamed from: j */
    private C1743a<RFLAccountManager> f3361j;

    /* renamed from: k */
    private C1743a<RFLAdManager> f3362k;

    /* renamed from: l */
    private C1743a<C1126c> f3363l;

    /* renamed from: m */
    private C1743a<RFLOrmaHolder> f3364m;

    /* renamed from: n */
    private C1743a<RFLActivityPoiManager> f3365n;

    /* renamed from: o */
    private C1743a<RFLAdjustTrackPointManager> f3366o;

    /* renamed from: p */
    private C1743a<RFLDailyTagManager> f3367p;

    /* renamed from: q */
    private C1743a<RFLWeatherManager> f3368q;

    /* renamed from: r */
    private C1743a<RFLBarometerManager> f3369r;

    /* renamed from: s */
    private C1743a<RFLPedometerManager> f3370s;

    /* renamed from: t */
    private C1743a<RFLLogger> f3371t;

    /* renamed from: u */
    private C1743a<RFLTrackPointDao> f3372u;

    /* renamed from: v */
    private C1743a<RFLPedometerDao> f3373v;

    /* renamed from: w */
    private C1743a<RFLDailyDao> f3374w;

    /* renamed from: x */
    private C1743a<RFLTPDao> f3375x;

    /* renamed from: y */
    private C1743a<RFLTagDao> f3376y;

    /* renamed from: z */
    private C1743a<RFLAdjustTrackPointDao> f3377z;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.di.DaggerRFLAppComponent$Builder */
    public static final class Builder {

        /* renamed from: a */
        private RFLAppModule f3378a;

        /* renamed from: b */
        private RFLClientContextModule f3379b;

        private Builder() {
        }

        public RFLAppComponent build() {
            if (this.f3378a == null) {
                this.f3378a = new RFLAppModule();
            }
            C1532a.m2137a(this.f3379b, RFLClientContextModule.class);
            return new DaggerRFLAppComponent(this.f3378a, this.f3379b);
        }

        public Builder rFLAppModule(RFLAppModule rFLAppModule) {
            if (rFLAppModule != null) {
                this.f3378a = rFLAppModule;
                return this;
            }
            throw null;
        }

        public Builder rFLClientContextModule(RFLClientContextModule rFLClientContextModule) {
            if (rFLClientContextModule != null) {
                this.f3379b = rFLClientContextModule;
                return this;
            }
            throw null;
        }
    }

    private DaggerRFLAppComponent(RFLAppModule rFLAppModule, RFLClientContextModule rFLClientContextModule) {
        m3840a(rFLAppModule, rFLClientContextModule);
    }

    /* renamed from: a */
    private RFLSilentLogOperation m3818a(RFLSilentLogOperation rFLSilentLogOperation) {
        RFLSilentLogOperation_MembersInjector.injectDailyManager(rFLSilentLogOperation, this.f3352a.get());
        RFLSilentLogOperation_MembersInjector.injectDailyLoader(rFLSilentLogOperation, this.f3353b.get());
        RFLSilentLogOperation_MembersInjector.injectDataLogger(rFLSilentLogOperation, this.f3354c.get());
        RFLSilentLogOperation_MembersInjector.injectDailyUtils(rFLSilentLogOperation, this.f3355d.get());
        RFLSilentLogOperation_MembersInjector.injectH1Client(rFLSilentLogOperation, this.f3356e.get());
        RFLSilentLogOperation_MembersInjector.injectPointClient(rFLSilentLogOperation, this.f3357f.get());
        RFLSilentLogOperation_MembersInjector.injectWeatherClient(rFLSilentLogOperation, this.f3358g.get());
        RFLSilentLogOperation_MembersInjector.injectLocationManager(rFLSilentLogOperation, this.f3359h.get());
        RFLSilentLogOperation_MembersInjector.injectGoogleFitManager(rFLSilentLogOperation, this.f3360i.get());
        RFLSilentLogOperation_MembersInjector.injectAccountManager(rFLSilentLogOperation, this.f3361j.get());
        RFLSilentLogOperation_MembersInjector.injectAdManager(rFLSilentLogOperation, this.f3362k.get());
        RFLSilentLogOperation_MembersInjector.injectEventBus(rFLSilentLogOperation, this.f3363l.get());
        RFLSilentLogOperation_MembersInjector.injectOrmaHolder(rFLSilentLogOperation, this.f3364m.get());
        RFLSilentLogOperation_MembersInjector.injectActivityPoiManager(rFLSilentLogOperation, this.f3365n.get());
        RFLSilentLogOperation_MembersInjector.injectAdjustTrackPointManager(rFLSilentLogOperation, this.f3366o.get());
        RFLSilentLogOperation_MembersInjector.injectDailyTagManager(rFLSilentLogOperation, this.f3367p.get());
        RFLSilentLogOperation_MembersInjector.injectWeatherManager(rFLSilentLogOperation, this.f3368q.get());
        return rFLSilentLogOperation;
    }

    /* renamed from: a */
    private RFLAccountManager m3819a(RFLAccountManager rFLAccountManager) {
        RFLAccountManager_MembersInjector.injectH1Client(rFLAccountManager, this.f3356e.get());
        RFLAccountManager_MembersInjector.injectDailyUtils(rFLAccountManager, this.f3355d.get());
        return rFLAccountManager;
    }

    /* renamed from: a */
    private RFLAdManager m3820a(RFLAdManager rFLAdManager) {
        RFLAdManager_MembersInjector.injectH1Client(rFLAdManager, this.f3356e.get());
        RFLAdManager_MembersInjector.injectEventBus(rFLAdManager, this.f3363l.get());
        RFLAdManager_MembersInjector.injectAccountManager(rFLAdManager, this.f3361j.get());
        RFLAdManager_MembersInjector.injectBeaconManager(rFLAdManager, this.f3350E.get());
        return rFLAdManager;
    }

    /* renamed from: a */
    private RFLBarometerManager m3821a(RFLBarometerManager rFLBarometerManager) {
        RFLBarometerManager_MembersInjector.injectDataLogger(rFLBarometerManager, this.f3354c.get());
        return rFLBarometerManager;
    }

    /* renamed from: a */
    private RFLDailyLoader m3822a(RFLDailyLoader rFLDailyLoader) {
        RFLDailyLoader_MembersInjector.injectDataLogger(rFLDailyLoader, this.f3354c.get());
        RFLDailyLoader_MembersInjector.injectDailyUtils(rFLDailyLoader, this.f3355d.get());
        RFLDailyLoader_MembersInjector.injectH1Client(rFLDailyLoader, this.f3356e.get());
        RFLDailyLoader_MembersInjector.injectGoogleFitManager(rFLDailyLoader, this.f3360i.get());
        RFLDailyLoader_MembersInjector.injectPointManager(rFLDailyLoader, this.f3349D.get());
        RFLDailyLoader_MembersInjector.injectEventBus(rFLDailyLoader, this.f3363l.get());
        return rFLDailyLoader;
    }

    /* renamed from: a */
    private RFLDailyManager m3823a(RFLDailyManager rFLDailyManager) {
        RFLDailyManager_MembersInjector.injectH1Client(rFLDailyManager, this.f3356e.get());
        RFLDailyManager_MembersInjector.injectDataLogger(rFLDailyManager, this.f3354c.get());
        RFLDailyManager_MembersInjector.injectDailyUtils(rFLDailyManager, this.f3355d.get());
        RFLDailyManager_MembersInjector.injectBarometerManager(rFLDailyManager, this.f3369r.get());
        RFLDailyManager_MembersInjector.injectDailyLoader(rFLDailyManager, this.f3353b.get());
        RFLDailyManager_MembersInjector.injectPedometerManager(rFLDailyManager, this.f3370s.get());
        RFLDailyManager_MembersInjector.injectLocationManager(rFLDailyManager, this.f3359h.get());
        RFLDailyManager_MembersInjector.injectAccountManager(rFLDailyManager, this.f3361j.get());
        RFLDailyManager_MembersInjector.injectWeatherManager(rFLDailyManager, this.f3368q.get());
        RFLDailyManager_MembersInjector.injectEventBus(rFLDailyManager, this.f3363l.get());
        return rFLDailyManager;
    }

    /* renamed from: a */
    private RFLDataLogger m3824a(RFLDataLogger rFLDataLogger) {
        RFLDataLogger_MembersInjector.injectRflOrmaHolder(rFLDataLogger, this.f3364m.get());
        RFLDataLogger_MembersInjector.injectTrackPointDao(rFLDataLogger, this.f3372u.get());
        RFLDataLogger_MembersInjector.injectPedometerDao(rFLDataLogger, this.f3373v.get());
        RFLDataLogger_MembersInjector.injectDailyDao(rFLDataLogger, this.f3374w.get());
        RFLDataLogger_MembersInjector.injectTpDao(rFLDataLogger, this.f3375x.get());
        RFLDataLogger_MembersInjector.injectTagDao(rFLDataLogger, this.f3376y.get());
        RFLDataLogger_MembersInjector.injectAdjustTrackPointDao(rFLDataLogger, this.f3377z.get());
        RFLDataLogger_MembersInjector.injectBarometerDao(rFLDataLogger, this.f3346A.get());
        RFLDataLogger_MembersInjector.injectDailyTagDao(rFLDataLogger, this.f3347B.get());
        RFLDataLogger_MembersInjector.injectWeatherDao(rFLDataLogger, this.f3348C.get());
        return rFLDataLogger;
    }

    /* renamed from: a */
    private RFLLocationManager m3825a(RFLLocationManager rFLLocationManager) {
        RFLLocationManager_MembersInjector.injectGoogleLocationService(rFLLocationManager, this.f3351F.get());
        RFLLocationManager_MembersInjector.injectDailyUtils(rFLLocationManager, this.f3355d.get());
        RFLLocationManager_MembersInjector.injectEventBus(rFLLocationManager, this.f3363l.get());
        RFLLocationManager_MembersInjector.injectAccountManager(rFLLocationManager, this.f3361j.get());
        RFLLocationManager_MembersInjector.injectAdManager(rFLLocationManager, this.f3362k.get());
        return rFLLocationManager;
    }

    /* renamed from: a */
    private RFLPedometerManager m3826a(RFLPedometerManager rFLPedometerManager) {
        RFLPedometerManager_MembersInjector.injectEventBus(rFLPedometerManager, this.f3363l.get());
        RFLPedometerManager_MembersInjector.injectDataLogger(rFLPedometerManager, this.f3354c.get());
        return rFLPedometerManager;
    }

    /* renamed from: a */
    private RFLH1Client m3827a(RFLH1Client rFLH1Client) {
        RFLH1Client_MembersInjector.injectEventBus(rFLH1Client, this.f3363l.get());
        return rFLH1Client;
    }

    /* renamed from: a */
    private RFLActivityDao m3828a(RFLActivityDao rFLActivityDao) {
        RFLActivityDao_MembersInjector.injectRflOrmaHolder(rFLActivityDao, this.f3364m.get());
        return rFLActivityDao;
    }

    /* renamed from: a */
    private RFLAdjustTrackPointDao m3829a(RFLAdjustTrackPointDao rFLAdjustTrackPointDao) {
        RFLAdjustTrackPointDao_MembersInjector.injectRflOrmaHolder(rFLAdjustTrackPointDao, this.f3364m.get());
        return rFLAdjustTrackPointDao;
    }

    /* renamed from: a */
    private RFLBarometerDao m3830a(RFLBarometerDao rFLBarometerDao) {
        RFLBarometerDao_MembersInjector.injectRflOrmaHolder(rFLBarometerDao, this.f3364m.get());
        return rFLBarometerDao;
    }

    /* renamed from: a */
    private RFLDailyDao m3831a(RFLDailyDao rFLDailyDao) {
        RFLDailyDao_MembersInjector.injectRflOrmaHolder(rFLDailyDao, this.f3364m.get());
        return rFLDailyDao;
    }

    /* renamed from: a */
    private RFLPedometerDao m3832a(RFLPedometerDao rFLPedometerDao) {
        RFLPedometerDao_MembersInjector.injectRflOrmaHolder(rFLPedometerDao, this.f3364m.get());
        return rFLPedometerDao;
    }

    /* renamed from: a */
    private RFLTPDao m3833a(RFLTPDao rFLTPDao) {
        RFLTPDao_MembersInjector.injectRflOrmaHolder(rFLTPDao, this.f3364m.get());
        return rFLTPDao;
    }

    /* renamed from: a */
    private RFLTagDao m3834a(RFLTagDao rFLTagDao) {
        RFLTagDao_MembersInjector.injectRflOrmaHolder(rFLTagDao, this.f3364m.get());
        return rFLTagDao;
    }

    /* renamed from: a */
    private RFLTrackPointDao m3835a(RFLTrackPointDao rFLTrackPointDao) {
        RFLTrackPointDao_MembersInjector.injectRflOrmaHolder(rFLTrackPointDao, this.f3364m.get());
        return rFLTrackPointDao;
    }

    /* renamed from: a */
    private RFLNotificationPoi m3836a(RFLNotificationPoi rFLNotificationPoi) {
        RFLNotificationPoi_MembersInjector.injectDailyUtils(rFLNotificationPoi, this.f3355d.get());
        return rFLNotificationPoi;
    }

    /* renamed from: a */
    private RFLActivity m3837a(RFLActivity rFLActivity) {
        RFLActivity_MembersInjector.injectDailyUtils(rFLActivity, this.f3355d.get());
        return rFLActivity;
    }

    /* renamed from: a */
    private RFLDailyUtils m3838a(RFLDailyUtils rFLDailyUtils) {
        RFLDailyUtils_MembersInjector.injectDataLogger(rFLDailyUtils, this.f3354c.get());
        return rFLDailyUtils;
    }

    /* renamed from: a */
    private RFLLogTree m3839a(RFLLogTree rFLLogTree) {
        RFLLogTree_MembersInjector.injectRflLogger(rFLLogTree, this.f3371t.get());
        return rFLLogTree;
    }

    /* renamed from: a */
    private void m3840a(RFLAppModule rFLAppModule, RFLClientContextModule rFLClientContextModule) {
        this.f3352a = C1584a.m2212a(C2264xf7b41ded.create(rFLAppModule));
        this.f3353b = C1584a.m2212a(C2263x3e9e58d7.create(rFLAppModule));
        this.f3354c = C1584a.m2212a(C2267x1fc41567.create(rFLAppModule));
        this.f3355d = C1584a.m2212a(C2266x6bf27c69.create(rFLAppModule));
        this.f3356e = C1584a.m2212a(C2269x3a77eacd.create(rFLAppModule));
        this.f3357f = C1584a.m2212a(C2272x56505488.create(rFLAppModule));
        this.f3358g = C1584a.m2212a(C2275xb4b9ae64.create(rFLAppModule));
        this.f3359h = C1584a.m2212a(C2282x7b9bb408.create(rFLClientContextModule));
        this.f3360i = C1584a.m2212a(C2280xbd18c26f.create(rFLClientContextModule));
        this.f3361j = C1584a.m2212a(C2277x36462bc4.create(rFLClientContextModule));
        this.f3362k = C1584a.m2212a(C2278x5313ed76.create(rFLClientContextModule));
        this.f3363l = C1584a.m2212a(RFLAppModule_ProvideEventBus$silentlogsdkandroid_releaseFactory.create(rFLAppModule));
        this.f3364m = C1584a.m2212a(C2284x7c9bf361.create(rFLClientContextModule));
        this.f3365n = C1584a.m2212a(C2257x72b792cf.create(rFLAppModule, this.f3354c));
        this.f3366o = C1584a.m2212a(C2259x8c528aaa.create(rFLAppModule, this.f3354c));
        this.f3367p = C1584a.m2212a(C2265x81ee3a37.create(rFLAppModule, this.f3354c));
        this.f3368q = C1584a.m2212a(C2285xd513b0cb.create(rFLClientContextModule, this.f3354c, this.f3358g));
        this.f3369r = C1584a.m2212a(C2261xbc91a1a1.create(rFLAppModule));
        this.f3370s = C1584a.m2212a(C2271x3b4d6e9d.create(rFLAppModule));
        this.f3371t = C1584a.m2212a(C2283x9f7626f4.create(rFLClientContextModule));
        this.f3372u = C1584a.m2212a(C2274x7ebd3236.create(rFLAppModule));
        this.f3373v = C1584a.m2212a(C2270x54971c98.create(rFLAppModule));
        this.f3374w = C1584a.m2212a(C2262xa7d9f3e8.create(rFLAppModule));
        this.f3375x = C1584a.m2212a(RFLAppModule_ProvideRFLTPDao$silentlogsdkandroid_releaseFactory.create(rFLAppModule));
        this.f3376y = C1584a.m2212a(RFLAppModule_ProvideRFLTagDao$silentlogsdkandroid_releaseFactory.create(rFLAppModule));
        this.f3377z = C1584a.m2212a(C2258x197e4725.create(rFLAppModule));
        this.f3346A = C1584a.m2212a(C2260x76d5719c.create(rFLAppModule));
        this.f3347B = C1584a.m2212a(C2268x970d8335.create(rFLAppModule, this.f3364m));
        this.f3348C = C1584a.m2212a(C2276xd1c76dc3.create(rFLAppModule, this.f3364m));
        this.f3349D = C1584a.m2212a(C2273xa98950a4.create(rFLAppModule, this.f3357f));
        this.f3350E = C1584a.m2212a(C2279xa9864557.create(rFLClientContextModule));
        this.f3351F = C1584a.m2212a(C2281xaa5dc399.create(rFLClientContextModule));
    }

    public static Builder builder() {
        return new Builder();
    }

    public void inject(RFLSilentLogOperation rFLSilentLogOperation) {
        m3818a(rFLSilentLogOperation);
    }

    public void inject(RFLAccountManager rFLAccountManager) {
        m3819a(rFLAccountManager);
    }

    public void inject(RFLAdManager rFLAdManager) {
        m3820a(rFLAdManager);
    }

    public void inject(RFLBarometerManager rFLBarometerManager) {
        m3821a(rFLBarometerManager);
    }

    public void inject(RFLDailyLoader rFLDailyLoader) {
        m3822a(rFLDailyLoader);
    }

    public void inject(RFLDailyManager rFLDailyManager) {
        m3823a(rFLDailyManager);
    }

    public void inject(RFLDataLogger rFLDataLogger) {
        m3824a(rFLDataLogger);
    }

    public void inject(RFLGoogleFitManager rFLGoogleFitManager) {
    }

    public void inject(RFLGoogleLocationService rFLGoogleLocationService) {
    }

    public void inject(RFLLocationManager rFLLocationManager) {
        m3825a(rFLLocationManager);
    }

    public void inject(RFLPedometerManager rFLPedometerManager) {
        m3826a(rFLPedometerManager);
    }

    public void inject(RFLH1Client rFLH1Client) {
        m3827a(rFLH1Client);
    }

    public void inject(RFLActivityDao rFLActivityDao) {
        m3828a(rFLActivityDao);
    }

    public void inject(RFLAdjustTrackPointDao rFLAdjustTrackPointDao) {
        m3829a(rFLAdjustTrackPointDao);
    }

    public void inject(RFLBarometerDao rFLBarometerDao) {
        m3830a(rFLBarometerDao);
    }

    public void inject(RFLDailyDao rFLDailyDao) {
        m3831a(rFLDailyDao);
    }

    public void inject(RFLPedometerDao rFLPedometerDao) {
        m3832a(rFLPedometerDao);
    }

    public void inject(RFLTPDao rFLTPDao) {
        m3833a(rFLTPDao);
    }

    public void inject(RFLTagDao rFLTagDao) {
        m3834a(rFLTagDao);
    }

    public void inject(RFLTrackPointDao rFLTrackPointDao) {
        m3835a(rFLTrackPointDao);
    }

    public void inject(RFLNotificationPoi rFLNotificationPoi) {
        m3836a(rFLNotificationPoi);
    }

    public void inject(RFLActivity rFLActivity) {
        m3837a(rFLActivity);
    }

    public void inject(RFLDailyUtils rFLDailyUtils) {
        m3838a(rFLDailyUtils);
    }

    public void inject(RFLLogTree rFLLogTree) {
        m3839a(rFLLogTree);
    }
}
