package p043jp.reifrontier.silentlogsdkandroid.utils;

import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils_MembersInjector */
public final class RFLDailyUtils_MembersInjector implements C1583a<RFLDailyUtils> {

    /* renamed from: a */
    private final C1743a<RFLDataLogger> f3810a;

    public RFLDailyUtils_MembersInjector(C1743a<RFLDataLogger> aVar) {
        this.f3810a = aVar;
    }

    public static C1583a<RFLDailyUtils> create(C1743a<RFLDataLogger> aVar) {
        return new RFLDailyUtils_MembersInjector(aVar);
    }

    public static void injectDataLogger(RFLDailyUtils rFLDailyUtils, RFLDataLogger rFLDataLogger) {
        rFLDailyUtils.dataLogger = rFLDataLogger;
    }

    public void injectMembers(RFLDailyUtils rFLDailyUtils) {
        injectDataLogger(rFLDailyUtils, this.f3810a.get());
    }
}
