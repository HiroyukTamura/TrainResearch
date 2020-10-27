package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLLogger;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLClientContextModule_ProvideRFLLogger$silentlogsdkandroid_releaseFactory */
public final class C2283x9f7626f4 implements C1585b<RFLLogger> {

    /* renamed from: a */
    private final RFLClientContextModule f3418a;

    public C2283x9f7626f4(RFLClientContextModule rFLClientContextModule) {
        this.f3418a = rFLClientContextModule;
    }

    public static C2283x9f7626f4 create(RFLClientContextModule rFLClientContextModule) {
        return new C2283x9f7626f4(rFLClientContextModule);
    }

    public static RFLLogger provideRFLLogger$silentlogsdkandroid_release(RFLClientContextModule rFLClientContextModule) {
        RFLLogger provideRFLLogger$silentlogsdkandroid_release = rFLClientContextModule.provideRFLLogger$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLLogger$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLLogger$silentlogsdkandroid_release;
    }

    public RFLLogger get() {
        return provideRFLLogger$silentlogsdkandroid_release(this.f3418a);
    }
}
