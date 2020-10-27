package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyDao_MembersInjector */
public final class RFLDailyDao_MembersInjector implements C1583a<RFLDailyDao> {

    /* renamed from: a */
    private final C1743a<RFLOrmaHolder> f3334a;

    public RFLDailyDao_MembersInjector(C1743a<RFLOrmaHolder> aVar) {
        this.f3334a = aVar;
    }

    public static C1583a<RFLDailyDao> create(C1743a<RFLOrmaHolder> aVar) {
        return new RFLDailyDao_MembersInjector(aVar);
    }

    public static void injectRflOrmaHolder(RFLDailyDao rFLDailyDao, RFLOrmaHolder rFLOrmaHolder) {
        rFLDailyDao.rflOrmaHolder = rFLOrmaHolder;
    }

    public void injectMembers(RFLDailyDao rFLDailyDao) {
        injectRflOrmaHolder(rFLDailyDao, this.f3334a.get());
    }
}
