package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLDailyLoader$silentlogsdkandroid_releaseFactory */
public final class C2263x3e9e58d7 implements C1585b<RFLDailyLoader> {

    /* renamed from: a */
    private final RFLAppModule f3391a;

    public C2263x3e9e58d7(RFLAppModule rFLAppModule) {
        this.f3391a = rFLAppModule;
    }

    public static C2263x3e9e58d7 create(RFLAppModule rFLAppModule) {
        return new C2263x3e9e58d7(rFLAppModule);
    }

    public static RFLDailyLoader provideRFLDailyLoader$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLDailyLoader provideRFLDailyLoader$silentlogsdkandroid_release = rFLAppModule.provideRFLDailyLoader$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLDailyLoader$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLDailyLoader$silentlogsdkandroid_release;
    }

    public RFLDailyLoader get() {
        return provideRFLDailyLoader$silentlogsdkandroid_release(this.f3391a);
    }
}
