package p043jp.reifrontier.silentlogsdkandroid.daily;

import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager_MembersInjector */
public final class RFLDailyManager_MembersInjector implements C1583a<RFLDailyManager> {

    /* renamed from: a */
    private final C1743a<RFLH1Client> f3100a;

    /* renamed from: b */
    private final C1743a<RFLDataLogger> f3101b;

    /* renamed from: c */
    private final C1743a<RFLDailyUtils> f3102c;

    /* renamed from: d */
    private final C1743a<RFLBarometerManager> f3103d;

    /* renamed from: e */
    private final C1743a<RFLDailyLoader> f3104e;

    /* renamed from: f */
    private final C1743a<RFLPedometerManager> f3105f;

    /* renamed from: g */
    private final C1743a<RFLLocationManager> f3106g;

    /* renamed from: h */
    private final C1743a<RFLAccountManager> f3107h;

    /* renamed from: i */
    private final C1743a<RFLWeatherManager> f3108i;

    /* renamed from: j */
    private final C1743a<C1126c> f3109j;

    public RFLDailyManager_MembersInjector(C1743a<RFLH1Client> aVar, C1743a<RFLDataLogger> aVar2, C1743a<RFLDailyUtils> aVar3, C1743a<RFLBarometerManager> aVar4, C1743a<RFLDailyLoader> aVar5, C1743a<RFLPedometerManager> aVar6, C1743a<RFLLocationManager> aVar7, C1743a<RFLAccountManager> aVar8, C1743a<RFLWeatherManager> aVar9, C1743a<C1126c> aVar10) {
        this.f3100a = aVar;
        this.f3101b = aVar2;
        this.f3102c = aVar3;
        this.f3103d = aVar4;
        this.f3104e = aVar5;
        this.f3105f = aVar6;
        this.f3106g = aVar7;
        this.f3107h = aVar8;
        this.f3108i = aVar9;
        this.f3109j = aVar10;
    }

    public static C1583a<RFLDailyManager> create(C1743a<RFLH1Client> aVar, C1743a<RFLDataLogger> aVar2, C1743a<RFLDailyUtils> aVar3, C1743a<RFLBarometerManager> aVar4, C1743a<RFLDailyLoader> aVar5, C1743a<RFLPedometerManager> aVar6, C1743a<RFLLocationManager> aVar7, C1743a<RFLAccountManager> aVar8, C1743a<RFLWeatherManager> aVar9, C1743a<C1126c> aVar10) {
        return new RFLDailyManager_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10);
    }

    public static void injectAccountManager(RFLDailyManager rFLDailyManager, RFLAccountManager rFLAccountManager) {
        rFLDailyManager.accountManager = rFLAccountManager;
    }

    public static void injectBarometerManager(RFLDailyManager rFLDailyManager, RFLBarometerManager rFLBarometerManager) {
        rFLDailyManager.barometerManager = rFLBarometerManager;
    }

    public static void injectDailyLoader(RFLDailyManager rFLDailyManager, RFLDailyLoader rFLDailyLoader) {
        rFLDailyManager.dailyLoader = rFLDailyLoader;
    }

    public static void injectDailyUtils(RFLDailyManager rFLDailyManager, RFLDailyUtils rFLDailyUtils) {
        rFLDailyManager.dailyUtils = rFLDailyUtils;
    }

    public static void injectDataLogger(RFLDailyManager rFLDailyManager, RFLDataLogger rFLDataLogger) {
        rFLDailyManager.dataLogger = rFLDataLogger;
    }

    public static void injectEventBus(RFLDailyManager rFLDailyManager, C1126c cVar) {
        rFLDailyManager.eventBus = cVar;
    }

    public static void injectH1Client(RFLDailyManager rFLDailyManager, RFLH1Client rFLH1Client) {
        rFLDailyManager.h1Client = rFLH1Client;
    }

    public static void injectLocationManager(RFLDailyManager rFLDailyManager, RFLLocationManager rFLLocationManager) {
        rFLDailyManager.locationManager = rFLLocationManager;
    }

    public static void injectPedometerManager(RFLDailyManager rFLDailyManager, RFLPedometerManager rFLPedometerManager) {
        rFLDailyManager.pedometerManager = rFLPedometerManager;
    }

    public static void injectWeatherManager(RFLDailyManager rFLDailyManager, RFLWeatherManager rFLWeatherManager) {
        rFLDailyManager.weatherManager = rFLWeatherManager;
    }

    public void injectMembers(RFLDailyManager rFLDailyManager) {
        injectH1Client(rFLDailyManager, this.f3100a.get());
        injectDataLogger(rFLDailyManager, this.f3101b.get());
        injectDailyUtils(rFLDailyManager, this.f3102c.get());
        injectBarometerManager(rFLDailyManager, this.f3103d.get());
        injectDailyLoader(rFLDailyManager, this.f3104e.get());
        injectPedometerManager(rFLDailyManager, this.f3105f.get());
        injectLocationManager(rFLDailyManager, this.f3106g.get());
        injectAccountManager(rFLDailyManager, this.f3107h.get());
        injectWeatherManager(rFLDailyManager, this.f3108i.get());
        injectEventBus(rFLDailyManager, this.f3109j.get());
    }
}
