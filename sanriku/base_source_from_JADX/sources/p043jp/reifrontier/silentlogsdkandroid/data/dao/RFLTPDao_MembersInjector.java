package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLTPDao_MembersInjector */
public final class RFLTPDao_MembersInjector implements C1583a<RFLTPDao> {

    /* renamed from: a */
    private final C1743a<RFLOrmaHolder> f3338a;

    public RFLTPDao_MembersInjector(C1743a<RFLOrmaHolder> aVar) {
        this.f3338a = aVar;
    }

    public static C1583a<RFLTPDao> create(C1743a<RFLOrmaHolder> aVar) {
        return new RFLTPDao_MembersInjector(aVar);
    }

    public static void injectRflOrmaHolder(RFLTPDao rFLTPDao, RFLOrmaHolder rFLOrmaHolder) {
        rFLTPDao.rflOrmaHolder = rFLOrmaHolder;
    }

    public void injectMembers(RFLTPDao rFLTPDao) {
        injectRflOrmaHolder(rFLTPDao, this.f3338a.get());
    }
}
