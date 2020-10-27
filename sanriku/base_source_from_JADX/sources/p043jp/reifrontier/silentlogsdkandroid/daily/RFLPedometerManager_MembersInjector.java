package p043jp.reifrontier.silentlogsdkandroid.daily;

import org.greenrobot.eventbus.C1126c;
import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLPedometerManager_MembersInjector */
public final class RFLPedometerManager_MembersInjector implements C1583a<RFLPedometerManager> {

    /* renamed from: a */
    private final C1743a<C1126c> f3224a;

    /* renamed from: b */
    private final C1743a<RFLDataLogger> f3225b;

    public RFLPedometerManager_MembersInjector(C1743a<C1126c> aVar, C1743a<RFLDataLogger> aVar2) {
        this.f3224a = aVar;
        this.f3225b = aVar2;
    }

    public static C1583a<RFLPedometerManager> create(C1743a<C1126c> aVar, C1743a<RFLDataLogger> aVar2) {
        return new RFLPedometerManager_MembersInjector(aVar, aVar2);
    }

    public static void injectDataLogger(RFLPedometerManager rFLPedometerManager, RFLDataLogger rFLDataLogger) {
        rFLPedometerManager.dataLogger = rFLDataLogger;
    }

    public static void injectEventBus(RFLPedometerManager rFLPedometerManager, C1126c cVar) {
        rFLPedometerManager.eventBus = cVar;
    }

    public void injectMembers(RFLPedometerManager rFLPedometerManager) {
        injectEventBus(rFLPedometerManager, this.f3224a.get());
        injectDataLogger(rFLPedometerManager, this.f3225b.get());
    }
}
