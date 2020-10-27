package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLTrackPointDao_MembersInjector */
public final class RFLTrackPointDao_MembersInjector implements C1583a<RFLTrackPointDao> {

    /* renamed from: a */
    private final C1743a<RFLOrmaHolder> f3340a;

    public RFLTrackPointDao_MembersInjector(C1743a<RFLOrmaHolder> aVar) {
        this.f3340a = aVar;
    }

    public static C1583a<RFLTrackPointDao> create(C1743a<RFLOrmaHolder> aVar) {
        return new RFLTrackPointDao_MembersInjector(aVar);
    }

    public static void injectRflOrmaHolder(RFLTrackPointDao rFLTrackPointDao, RFLOrmaHolder rFLOrmaHolder) {
        rFLTrackPointDao.rflOrmaHolder = rFLOrmaHolder;
    }

    public void injectMembers(RFLTrackPointDao rFLTrackPointDao) {
        injectRflOrmaHolder(rFLTrackPointDao, this.f3340a.get());
    }
}
