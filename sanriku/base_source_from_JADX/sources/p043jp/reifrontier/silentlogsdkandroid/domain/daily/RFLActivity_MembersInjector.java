package p043jp.reifrontier.silentlogsdkandroid.domain.daily;

import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity_MembersInjector */
public final class RFLActivity_MembersInjector implements C1583a<RFLActivity> {

    /* renamed from: a */
    private final C1743a<RFLDailyUtils> f3535a;

    public RFLActivity_MembersInjector(C1743a<RFLDailyUtils> aVar) {
        this.f3535a = aVar;
    }

    public static C1583a<RFLActivity> create(C1743a<RFLDailyUtils> aVar) {
        return new RFLActivity_MembersInjector(aVar);
    }

    public static void injectDailyUtils(RFLActivity rFLActivity, RFLDailyUtils rFLDailyUtils) {
        rFLActivity.dailyUtils = rFLDailyUtils;
    }

    public void injectMembers(RFLActivity rFLActivity) {
        injectDailyUtils(rFLActivity, this.f3535a.get());
    }
}
