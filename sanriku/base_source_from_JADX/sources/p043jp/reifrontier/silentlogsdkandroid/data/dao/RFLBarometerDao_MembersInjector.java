package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLBarometerDao_MembersInjector */
public final class RFLBarometerDao_MembersInjector implements C1583a<RFLBarometerDao> {

    /* renamed from: a */
    private final C1743a<RFLOrmaHolder> f3333a;

    public RFLBarometerDao_MembersInjector(C1743a<RFLOrmaHolder> aVar) {
        this.f3333a = aVar;
    }

    public static C1583a<RFLBarometerDao> create(C1743a<RFLOrmaHolder> aVar) {
        return new RFLBarometerDao_MembersInjector(aVar);
    }

    public static void injectRflOrmaHolder(RFLBarometerDao rFLBarometerDao, RFLOrmaHolder rFLOrmaHolder) {
        rFLBarometerDao.rflOrmaHolder = rFLOrmaHolder;
    }

    public void injectMembers(RFLBarometerDao rFLBarometerDao) {
        injectRflOrmaHolder(rFLBarometerDao, this.f3333a.get());
    }
}
