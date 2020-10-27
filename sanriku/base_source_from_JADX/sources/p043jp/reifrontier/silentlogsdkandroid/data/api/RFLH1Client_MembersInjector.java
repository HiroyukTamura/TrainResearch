package p043jp.reifrontier.silentlogsdkandroid.data.api;

import org.greenrobot.eventbus.C1126c;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client_MembersInjector */
public final class RFLH1Client_MembersInjector implements C1583a<RFLH1Client> {

    /* renamed from: a */
    private final C1743a<C1126c> f3322a;

    public RFLH1Client_MembersInjector(C1743a<C1126c> aVar) {
        this.f3322a = aVar;
    }

    public static C1583a<RFLH1Client> create(C1743a<C1126c> aVar) {
        return new RFLH1Client_MembersInjector(aVar);
    }

    public static void injectEventBus(RFLH1Client rFLH1Client, C1126c cVar) {
        rFLH1Client.eventBus = cVar;
    }

    public void injectMembers(RFLH1Client rFLH1Client) {
        injectEventBus(rFLH1Client, this.f3322a.get());
    }
}
