package p043jp.reifrontier.silentlogsdkandroid.utils;

import p076f.C1583a;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLLogTree_MembersInjector */
public final class RFLLogTree_MembersInjector implements C1583a<RFLLogTree> {

    /* renamed from: a */
    private final C1743a<RFLLogger> f3811a;

    public RFLLogTree_MembersInjector(C1743a<RFLLogger> aVar) {
        this.f3811a = aVar;
    }

    public static C1583a<RFLLogTree> create(C1743a<RFLLogger> aVar) {
        return new RFLLogTree_MembersInjector(aVar);
    }

    public static void injectRflLogger(RFLLogTree rFLLogTree, RFLLogger rFLLogger) {
        rFLLogTree.rflLogger = rFLLogger;
    }

    public void injectMembers(RFLLogTree rFLLogTree) {
        injectRflLogger(rFLLogTree, this.f3811a.get());
    }
}
