package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLTagDao_MembersInjector */
public final class RFLTagDao_MembersInjector implements C1583a<RFLTagDao> {

    /* renamed from: a */
    private final C1743a<RFLOrmaHolder> f3339a;

    public RFLTagDao_MembersInjector(C1743a<RFLOrmaHolder> aVar) {
        this.f3339a = aVar;
    }

    public static C1583a<RFLTagDao> create(C1743a<RFLOrmaHolder> aVar) {
        return new RFLTagDao_MembersInjector(aVar);
    }

    public static void injectRflOrmaHolder(RFLTagDao rFLTagDao, RFLOrmaHolder rFLOrmaHolder) {
        rFLTagDao.rflOrmaHolder = rFLOrmaHolder;
    }

    public void injectMembers(RFLTagDao rFLTagDao) {
        injectRflOrmaHolder(rFLTagDao, this.f3339a.get());
    }
}
