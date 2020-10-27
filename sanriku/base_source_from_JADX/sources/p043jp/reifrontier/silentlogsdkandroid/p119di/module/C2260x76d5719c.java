package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLBarometerDao;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLBarometerDao$silentlogsdkandroid_releaseFactory */
public final class C2260x76d5719c implements C1585b<RFLBarometerDao> {

    /* renamed from: a */
    private final RFLAppModule f3388a;

    public C2260x76d5719c(RFLAppModule rFLAppModule) {
        this.f3388a = rFLAppModule;
    }

    public static C2260x76d5719c create(RFLAppModule rFLAppModule) {
        return new C2260x76d5719c(rFLAppModule);
    }

    public static RFLBarometerDao provideRFLBarometerDao$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLBarometerDao provideRFLBarometerDao$silentlogsdkandroid_release = rFLAppModule.provideRFLBarometerDao$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLBarometerDao$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLBarometerDao$silentlogsdkandroid_release;
    }

    public RFLBarometerDao get() {
        return provideRFLBarometerDao$silentlogsdkandroid_release(this.f3388a);
    }
}
