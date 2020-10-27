package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyDao;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLDailyDao$silentlogsdkandroid_releaseFactory */
public final class C2262xa7d9f3e8 implements C1585b<RFLDailyDao> {

    /* renamed from: a */
    private final RFLAppModule f3390a;

    public C2262xa7d9f3e8(RFLAppModule rFLAppModule) {
        this.f3390a = rFLAppModule;
    }

    public static C2262xa7d9f3e8 create(RFLAppModule rFLAppModule) {
        return new C2262xa7d9f3e8(rFLAppModule);
    }

    public static RFLDailyDao provideRFLDailyDao$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLDailyDao provideRFLDailyDao$silentlogsdkandroid_release = rFLAppModule.provideRFLDailyDao$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLDailyDao$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLDailyDao$silentlogsdkandroid_release;
    }

    public RFLDailyDao get() {
        return provideRFLDailyDao$silentlogsdkandroid_release(this.f3390a);
    }
}
