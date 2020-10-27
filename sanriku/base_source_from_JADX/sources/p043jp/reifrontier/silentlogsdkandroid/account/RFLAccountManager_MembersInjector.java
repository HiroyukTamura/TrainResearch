package p043jp.reifrontier.silentlogsdkandroid.account;

import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager_MembersInjector */
public final class RFLAccountManager_MembersInjector implements C1583a<RFLAccountManager> {

    /* renamed from: a */
    private final C1743a<RFLH1Client> f3040a;

    /* renamed from: b */
    private final C1743a<RFLDailyUtils> f3041b;

    public RFLAccountManager_MembersInjector(C1743a<RFLH1Client> aVar, C1743a<RFLDailyUtils> aVar2) {
        this.f3040a = aVar;
        this.f3041b = aVar2;
    }

    public static C1583a<RFLAccountManager> create(C1743a<RFLH1Client> aVar, C1743a<RFLDailyUtils> aVar2) {
        return new RFLAccountManager_MembersInjector(aVar, aVar2);
    }

    public static void injectDailyUtils(RFLAccountManager rFLAccountManager, RFLDailyUtils rFLDailyUtils) {
        rFLAccountManager.dailyUtils = rFLDailyUtils;
    }

    public static void injectH1Client(RFLAccountManager rFLAccountManager, RFLH1Client rFLH1Client) {
        rFLAccountManager.h1Client = rFLH1Client;
    }

    public void injectMembers(RFLAccountManager rFLAccountManager) {
        injectH1Client(rFLAccountManager, this.f3040a.get());
        injectDailyUtils(rFLAccountManager, this.f3041b.get());
    }
}
