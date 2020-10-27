package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLDailyManager$silentlogsdkandroid_releaseFactory */
public final class C2264xf7b41ded implements C1585b<RFLDailyManager> {

    /* renamed from: a */
    private final RFLAppModule f3392a;

    public C2264xf7b41ded(RFLAppModule rFLAppModule) {
        this.f3392a = rFLAppModule;
    }

    public static C2264xf7b41ded create(RFLAppModule rFLAppModule) {
        return new C2264xf7b41ded(rFLAppModule);
    }

    public static RFLDailyManager provideRFLDailyManager$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLDailyManager provideRFLDailyManager$silentlogsdkandroid_release = rFLAppModule.provideRFLDailyManager$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLDailyManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLDailyManager$silentlogsdkandroid_release;
    }

    public RFLDailyManager get() {
        return provideRFLDailyManager$silentlogsdkandroid_release(this.f3392a);
    }
}
