package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLDailyUtils$silentlogsdkandroid_releaseFactory */
public final class C2266x6bf27c69 implements C1585b<RFLDailyUtils> {

    /* renamed from: a */
    private final RFLAppModule f3395a;

    public C2266x6bf27c69(RFLAppModule rFLAppModule) {
        this.f3395a = rFLAppModule;
    }

    public static C2266x6bf27c69 create(RFLAppModule rFLAppModule) {
        return new C2266x6bf27c69(rFLAppModule);
    }

    public static RFLDailyUtils provideRFLDailyUtils$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLDailyUtils provideRFLDailyUtils$silentlogsdkandroid_release = rFLAppModule.provideRFLDailyUtils$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLDailyUtils$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLDailyUtils$silentlogsdkandroid_release;
    }

    public RFLDailyUtils get() {
        return provideRFLDailyUtils$silentlogsdkandroid_release(this.f3395a);
    }
}
