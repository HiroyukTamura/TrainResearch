package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTPDao;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLTPDao$silentlogsdkandroid_releaseFactory */
public final class RFLAppModule_ProvideRFLTPDao$silentlogsdkandroid_releaseFactory implements C1585b<RFLTPDao> {

    /* renamed from: a */
    private final RFLAppModule f3405a;

    public RFLAppModule_ProvideRFLTPDao$silentlogsdkandroid_releaseFactory(RFLAppModule rFLAppModule) {
        this.f3405a = rFLAppModule;
    }

    public static RFLAppModule_ProvideRFLTPDao$silentlogsdkandroid_releaseFactory create(RFLAppModule rFLAppModule) {
        return new RFLAppModule_ProvideRFLTPDao$silentlogsdkandroid_releaseFactory(rFLAppModule);
    }

    public static RFLTPDao provideRFLTPDao$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLTPDao provideRFLTPDao$silentlogsdkandroid_release = rFLAppModule.provideRFLTPDao$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLTPDao$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLTPDao$silentlogsdkandroid_release;
    }

    public RFLTPDao get() {
        return provideRFLTPDao$silentlogsdkandroid_release(this.f3405a);
    }
}
