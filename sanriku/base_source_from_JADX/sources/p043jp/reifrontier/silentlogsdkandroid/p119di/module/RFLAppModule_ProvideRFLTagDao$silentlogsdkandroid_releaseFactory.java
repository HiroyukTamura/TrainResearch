package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTagDao;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLTagDao$silentlogsdkandroid_releaseFactory */
public final class RFLAppModule_ProvideRFLTagDao$silentlogsdkandroid_releaseFactory implements C1585b<RFLTagDao> {

    /* renamed from: a */
    private final RFLAppModule f3406a;

    public RFLAppModule_ProvideRFLTagDao$silentlogsdkandroid_releaseFactory(RFLAppModule rFLAppModule) {
        this.f3406a = rFLAppModule;
    }

    public static RFLAppModule_ProvideRFLTagDao$silentlogsdkandroid_releaseFactory create(RFLAppModule rFLAppModule) {
        return new RFLAppModule_ProvideRFLTagDao$silentlogsdkandroid_releaseFactory(rFLAppModule);
    }

    public static RFLTagDao provideRFLTagDao$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLTagDao provideRFLTagDao$silentlogsdkandroid_release = rFLAppModule.provideRFLTagDao$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLTagDao$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLTagDao$silentlogsdkandroid_release;
    }

    public RFLTagDao get() {
        return provideRFLTagDao$silentlogsdkandroid_release(this.f3406a);
    }
}
