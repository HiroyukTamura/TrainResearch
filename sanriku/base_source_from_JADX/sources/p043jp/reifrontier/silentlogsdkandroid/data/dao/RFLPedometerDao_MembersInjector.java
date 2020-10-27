package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLPedometerDao_MembersInjector */
public final class RFLPedometerDao_MembersInjector implements C1583a<RFLPedometerDao> {

    /* renamed from: a */
    private final C1743a<RFLOrmaHolder> f3337a;

    public RFLPedometerDao_MembersInjector(C1743a<RFLOrmaHolder> aVar) {
        this.f3337a = aVar;
    }

    public static C1583a<RFLPedometerDao> create(C1743a<RFLOrmaHolder> aVar) {
        return new RFLPedometerDao_MembersInjector(aVar);
    }

    public static void injectRflOrmaHolder(RFLPedometerDao rFLPedometerDao, RFLOrmaHolder rFLOrmaHolder) {
        rFLPedometerDao.rflOrmaHolder = rFLOrmaHolder;
    }

    public void injectMembers(RFLPedometerDao rFLPedometerDao) {
        injectRflOrmaHolder(rFLPedometerDao, this.f3337a.get());
    }
}
