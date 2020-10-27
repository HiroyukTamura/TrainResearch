package p043jp.reifrontier.silentlogsdkandroid.daily;

import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager_MembersInjector */
public final class RFLAdManager_MembersInjector implements C1583a<RFLAdManager> {

    /* renamed from: a */
    private final C1743a<RFLH1Client> f3046a;

    /* renamed from: b */
    private final C1743a<C1126c> f3047b;

    /* renamed from: c */
    private final C1743a<RFLAccountManager> f3048c;

    /* renamed from: d */
    private final C1743a<RFLBeaconManager> f3049d;

    public RFLAdManager_MembersInjector(C1743a<RFLH1Client> aVar, C1743a<C1126c> aVar2, C1743a<RFLAccountManager> aVar3, C1743a<RFLBeaconManager> aVar4) {
        this.f3046a = aVar;
        this.f3047b = aVar2;
        this.f3048c = aVar3;
        this.f3049d = aVar4;
    }

    public static C1583a<RFLAdManager> create(C1743a<RFLH1Client> aVar, C1743a<C1126c> aVar2, C1743a<RFLAccountManager> aVar3, C1743a<RFLBeaconManager> aVar4) {
        return new RFLAdManager_MembersInjector(aVar, aVar2, aVar3, aVar4);
    }

    public static void injectAccountManager(RFLAdManager rFLAdManager, RFLAccountManager rFLAccountManager) {
        rFLAdManager.accountManager = rFLAccountManager;
    }

    public static void injectBeaconManager(RFLAdManager rFLAdManager, RFLBeaconManager rFLBeaconManager) {
        rFLAdManager.beaconManager = rFLBeaconManager;
    }

    public static void injectEventBus(RFLAdManager rFLAdManager, C1126c cVar) {
        rFLAdManager.eventBus = cVar;
    }

    public static void injectH1Client(RFLAdManager rFLAdManager, RFLH1Client rFLH1Client) {
        rFLAdManager.h1Client = rFLH1Client;
    }

    public void injectMembers(RFLAdManager rFLAdManager) {
        injectH1Client(rFLAdManager, this.f3046a.get());
        injectEventBus(rFLAdManager, this.f3047b.get());
        injectAccountManager(rFLAdManager, this.f3048c.get());
        injectBeaconManager(rFLAdManager, this.f3049d.get());
    }
}
