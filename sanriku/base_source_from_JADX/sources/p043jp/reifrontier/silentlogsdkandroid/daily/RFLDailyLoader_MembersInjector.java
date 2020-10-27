package p043jp.reifrontier.silentlogsdkandroid.daily;

import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader_MembersInjector */
public final class RFLDailyLoader_MembersInjector implements C1583a<RFLDailyLoader> {

    /* renamed from: a */
    private final C1743a<RFLDataLogger> f3094a;

    /* renamed from: b */
    private final C1743a<RFLDailyUtils> f3095b;

    /* renamed from: c */
    private final C1743a<RFLH1Client> f3096c;

    /* renamed from: d */
    private final C1743a<RFLGoogleFitManager> f3097d;

    /* renamed from: e */
    private final C1743a<RFLPointManager> f3098e;

    /* renamed from: f */
    private final C1743a<C1126c> f3099f;

    public RFLDailyLoader_MembersInjector(C1743a<RFLDataLogger> aVar, C1743a<RFLDailyUtils> aVar2, C1743a<RFLH1Client> aVar3, C1743a<RFLGoogleFitManager> aVar4, C1743a<RFLPointManager> aVar5, C1743a<C1126c> aVar6) {
        this.f3094a = aVar;
        this.f3095b = aVar2;
        this.f3096c = aVar3;
        this.f3097d = aVar4;
        this.f3098e = aVar5;
        this.f3099f = aVar6;
    }

    public static C1583a<RFLDailyLoader> create(C1743a<RFLDataLogger> aVar, C1743a<RFLDailyUtils> aVar2, C1743a<RFLH1Client> aVar3, C1743a<RFLGoogleFitManager> aVar4, C1743a<RFLPointManager> aVar5, C1743a<C1126c> aVar6) {
        return new RFLDailyLoader_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static void injectDailyUtils(RFLDailyLoader rFLDailyLoader, RFLDailyUtils rFLDailyUtils) {
        rFLDailyLoader.dailyUtils = rFLDailyUtils;
    }

    public static void injectDataLogger(RFLDailyLoader rFLDailyLoader, RFLDataLogger rFLDataLogger) {
        rFLDailyLoader.dataLogger = rFLDataLogger;
    }

    public static void injectEventBus(RFLDailyLoader rFLDailyLoader, C1126c cVar) {
        rFLDailyLoader.eventBus = cVar;
    }

    public static void injectGoogleFitManager(RFLDailyLoader rFLDailyLoader, RFLGoogleFitManager rFLGoogleFitManager) {
        rFLDailyLoader.googleFitManager = rFLGoogleFitManager;
    }

    public static void injectH1Client(RFLDailyLoader rFLDailyLoader, RFLH1Client rFLH1Client) {
        rFLDailyLoader.h1Client = rFLH1Client;
    }

    public static void injectPointManager(RFLDailyLoader rFLDailyLoader, RFLPointManager rFLPointManager) {
        rFLDailyLoader.pointManager = rFLPointManager;
    }

    public void injectMembers(RFLDailyLoader rFLDailyLoader) {
        injectDataLogger(rFLDailyLoader, this.f3094a.get());
        injectDailyUtils(rFLDailyLoader, this.f3095b.get());
        injectH1Client(rFLDailyLoader, this.f3096c.get());
        injectGoogleFitManager(rFLDailyLoader, this.f3097d.get());
        injectPointManager(rFLDailyLoader, this.f3098e.get());
        injectEventBus(rFLDailyLoader, this.f3099f.get());
    }
}
