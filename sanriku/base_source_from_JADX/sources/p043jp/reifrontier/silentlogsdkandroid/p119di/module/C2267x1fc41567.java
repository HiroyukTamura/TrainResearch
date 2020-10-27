package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLDataLogger$silentlogsdkandroid_releaseFactory */
public final class C2267x1fc41567 implements C1585b<RFLDataLogger> {

    /* renamed from: a */
    private final RFLAppModule f3396a;

    public C2267x1fc41567(RFLAppModule rFLAppModule) {
        this.f3396a = rFLAppModule;
    }

    public static C2267x1fc41567 create(RFLAppModule rFLAppModule) {
        return new C2267x1fc41567(rFLAppModule);
    }

    public static RFLDataLogger provideRFLDataLogger$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLDataLogger provideRFLDataLogger$silentlogsdkandroid_release = rFLAppModule.provideRFLDataLogger$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLDataLogger$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLDataLogger$silentlogsdkandroid_release;
    }

    public RFLDataLogger get() {
        return provideRFLDataLogger$silentlogsdkandroid_release(this.f3396a);
    }
}
