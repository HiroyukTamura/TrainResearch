package p043jp.reifrontier.silentlogsdkandroid.data.dao;

import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.data.dao.RFLAdjustTrackPointDao_MembersInjector */
public final class RFLAdjustTrackPointDao_MembersInjector implements C1583a<RFLAdjustTrackPointDao> {

    /* renamed from: a */
    private final C1743a<RFLOrmaHolder> f3332a;

    public RFLAdjustTrackPointDao_MembersInjector(C1743a<RFLOrmaHolder> aVar) {
        this.f3332a = aVar;
    }

    public static C1583a<RFLAdjustTrackPointDao> create(C1743a<RFLOrmaHolder> aVar) {
        return new RFLAdjustTrackPointDao_MembersInjector(aVar);
    }

    public static void injectRflOrmaHolder(RFLAdjustTrackPointDao rFLAdjustTrackPointDao, RFLOrmaHolder rFLOrmaHolder) {
        rFLAdjustTrackPointDao.rflOrmaHolder = rFLOrmaHolder;
    }

    public void injectMembers(RFLAdjustTrackPointDao rFLAdjustTrackPointDao) {
        injectRflOrmaHolder(rFLAdjustTrackPointDao, this.f3332a.get());
    }
}
