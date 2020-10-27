package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLActivityDao_MembersInjector */
public final class RFLActivityDao_MembersInjector implements C1583a<RFLActivityDao> {

    /* renamed from: a */
    private final C1743a<RFLOrmaHolder> f3331a;

    public RFLActivityDao_MembersInjector(C1743a<RFLOrmaHolder> aVar) {
        this.f3331a = aVar;
    }

    public static C1583a<RFLActivityDao> create(C1743a<RFLOrmaHolder> aVar) {
        return new RFLActivityDao_MembersInjector(aVar);
    }

    public static void injectRflOrmaHolder(RFLActivityDao rFLActivityDao, RFLOrmaHolder rFLOrmaHolder) {
        rFLActivityDao.rflOrmaHolder = rFLOrmaHolder;
    }

    public void injectMembers(RFLActivityDao rFLActivityDao) {
        injectRflOrmaHolder(rFLActivityDao, this.f3331a.get());
    }
}
