package p043jp.reifrontier.silentlogsdkandroid.daily;

import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLBarometerManager_MembersInjector */
public final class RFLBarometerManager_MembersInjector implements C1583a<RFLBarometerManager> {

    /* renamed from: a */
    private final C1743a<RFLDataLogger> f3054a;

    public RFLBarometerManager_MembersInjector(C1743a<RFLDataLogger> aVar) {
        this.f3054a = aVar;
    }

    public static C1583a<RFLBarometerManager> create(C1743a<RFLDataLogger> aVar) {
        return new RFLBarometerManager_MembersInjector(aVar);
    }

    public static void injectDataLogger(RFLBarometerManager rFLBarometerManager, RFLDataLogger rFLDataLogger) {
        rFLBarometerManager.dataLogger = rFLDataLogger;
    }

    public void injectMembers(RFLBarometerManager rFLBarometerManager) {
        injectDataLogger(rFLBarometerManager, this.f3054a.get());
    }
}
