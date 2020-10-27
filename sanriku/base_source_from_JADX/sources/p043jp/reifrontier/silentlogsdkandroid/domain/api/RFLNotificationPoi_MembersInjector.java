package p043jp.reifrontier.silentlogsdkandroid.domain.api;

import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.api.RFLNotificationPoi_MembersInjector */
public final class RFLNotificationPoi_MembersInjector implements C1583a<RFLNotificationPoi> {

    /* renamed from: a */
    private final C1743a<RFLDailyUtils> f3486a;

    public RFLNotificationPoi_MembersInjector(C1743a<RFLDailyUtils> aVar) {
        this.f3486a = aVar;
    }

    public static C1583a<RFLNotificationPoi> create(C1743a<RFLDailyUtils> aVar) {
        return new RFLNotificationPoi_MembersInjector(aVar);
    }

    public static void injectDailyUtils(RFLNotificationPoi rFLNotificationPoi, RFLDailyUtils rFLDailyUtils) {
        rFLNotificationPoi.dailyUtils = rFLDailyUtils;
    }

    public void injectMembers(RFLNotificationPoi rFLNotificationPoi) {
        injectDailyUtils(rFLNotificationPoi, this.f3486a.get());
    }
}
