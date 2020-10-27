package p043jp.reifrontier.silentlogsdkandroid.daily;

import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager_MembersInjector */
public final class RFLLocationManager_MembersInjector implements C1583a<RFLLocationManager> {

    /* renamed from: a */
    private final C1743a<RFLGoogleLocationService> f3207a;

    /* renamed from: b */
    private final C1743a<RFLDailyUtils> f3208b;

    /* renamed from: c */
    private final C1743a<C1126c> f3209c;

    /* renamed from: d */
    private final C1743a<RFLAccountManager> f3210d;

    /* renamed from: e */
    private final C1743a<RFLAdManager> f3211e;

    public RFLLocationManager_MembersInjector(C1743a<RFLGoogleLocationService> aVar, C1743a<RFLDailyUtils> aVar2, C1743a<C1126c> aVar3, C1743a<RFLAccountManager> aVar4, C1743a<RFLAdManager> aVar5) {
        this.f3207a = aVar;
        this.f3208b = aVar2;
        this.f3209c = aVar3;
        this.f3210d = aVar4;
        this.f3211e = aVar5;
    }

    public static C1583a<RFLLocationManager> create(C1743a<RFLGoogleLocationService> aVar, C1743a<RFLDailyUtils> aVar2, C1743a<C1126c> aVar3, C1743a<RFLAccountManager> aVar4, C1743a<RFLAdManager> aVar5) {
        return new RFLLocationManager_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static void injectAccountManager(RFLLocationManager rFLLocationManager, RFLAccountManager rFLAccountManager) {
        rFLLocationManager.accountManager = rFLAccountManager;
    }

    public static void injectAdManager(RFLLocationManager rFLLocationManager, RFLAdManager rFLAdManager) {
        rFLLocationManager.adManager = rFLAdManager;
    }

    public static void injectDailyUtils(RFLLocationManager rFLLocationManager, RFLDailyUtils rFLDailyUtils) {
        rFLLocationManager.dailyUtils = rFLDailyUtils;
    }

    public static void injectEventBus(RFLLocationManager rFLLocationManager, C1126c cVar) {
        rFLLocationManager.eventBus = cVar;
    }

    public static void injectGoogleLocationService(RFLLocationManager rFLLocationManager, RFLGoogleLocationService rFLGoogleLocationService) {
        rFLLocationManager.googleLocationService = rFLGoogleLocationService;
    }

    public void injectMembers(RFLLocationManager rFLLocationManager) {
        injectGoogleLocationService(rFLLocationManager, this.f3207a.get());
        injectDailyUtils(rFLLocationManager, this.f3208b.get());
        injectEventBus(rFLLocationManager, this.f3209c.get());
        injectAccountManager(rFLLocationManager, this.f3210d.get());
        injectAdManager(rFLLocationManager, this.f3211e.get());
    }
}
