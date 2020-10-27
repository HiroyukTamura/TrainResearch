package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLPedometerManager;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLPedometerManager$silentlogsdkandroid_releaseFactory */
public final class C2271x3b4d6e9d implements C1585b<RFLPedometerManager> {

    /* renamed from: a */
    private final RFLAppModule f3401a;

    public C2271x3b4d6e9d(RFLAppModule rFLAppModule) {
        this.f3401a = rFLAppModule;
    }

    public static C2271x3b4d6e9d create(RFLAppModule rFLAppModule) {
        return new C2271x3b4d6e9d(rFLAppModule);
    }

    public static RFLPedometerManager provideRFLPedometerManager$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLPedometerManager provideRFLPedometerManager$silentlogsdkandroid_release = rFLAppModule.provideRFLPedometerManager$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLPedometerManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLPedometerManager$silentlogsdkandroid_release;
    }

    public RFLPedometerManager get() {
        return provideRFLPedometerManager$silentlogsdkandroid_release(this.f3401a);
    }
}
