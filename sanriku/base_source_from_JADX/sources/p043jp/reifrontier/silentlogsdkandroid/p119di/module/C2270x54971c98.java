package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLPedometerDao;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLPedometerDao$silentlogsdkandroid_releaseFactory */
public final class C2270x54971c98 implements C1585b<RFLPedometerDao> {

    /* renamed from: a */
    private final RFLAppModule f3400a;

    public C2270x54971c98(RFLAppModule rFLAppModule) {
        this.f3400a = rFLAppModule;
    }

    public static C2270x54971c98 create(RFLAppModule rFLAppModule) {
        return new C2270x54971c98(rFLAppModule);
    }

    public static RFLPedometerDao provideRFLPedometerDao$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLPedometerDao provideRFLPedometerDao$silentlogsdkandroid_release = rFLAppModule.provideRFLPedometerDao$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLPedometerDao$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLPedometerDao$silentlogsdkandroid_release;
    }

    public RFLPedometerDao get() {
        return provideRFLPedometerDao$silentlogsdkandroid_release(this.f3400a);
    }
}
