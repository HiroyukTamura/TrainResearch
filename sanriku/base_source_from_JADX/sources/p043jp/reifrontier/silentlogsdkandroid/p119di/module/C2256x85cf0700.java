package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLActivityDao;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLActivityDao$silentlogsdkandroid_releaseFactory */
public final class C2256x85cf0700 implements C1585b<RFLActivityDao> {

    /* renamed from: a */
    private final RFLAppModule f3382a;

    public C2256x85cf0700(RFLAppModule rFLAppModule) {
        this.f3382a = rFLAppModule;
    }

    public static C2256x85cf0700 create(RFLAppModule rFLAppModule) {
        return new C2256x85cf0700(rFLAppModule);
    }

    public static RFLActivityDao provideRFLActivityDao$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLActivityDao provideRFLActivityDao$silentlogsdkandroid_release = rFLAppModule.provideRFLActivityDao$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLActivityDao$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLActivityDao$silentlogsdkandroid_release;
    }

    public RFLActivityDao get() {
        return provideRFLActivityDao$silentlogsdkandroid_release(this.f3382a);
    }
}
