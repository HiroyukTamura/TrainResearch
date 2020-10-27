package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBarometerManager;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLBarometerManager$silentlogsdkandroid_releaseFactory */
public final class C2261xbc91a1a1 implements C1585b<RFLBarometerManager> {

    /* renamed from: a */
    private final RFLAppModule f3389a;

    public C2261xbc91a1a1(RFLAppModule rFLAppModule) {
        this.f3389a = rFLAppModule;
    }

    public static C2261xbc91a1a1 create(RFLAppModule rFLAppModule) {
        return new C2261xbc91a1a1(rFLAppModule);
    }

    public static RFLBarometerManager provideRFLBarometerManager$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLBarometerManager provideRFLBarometerManager$silentlogsdkandroid_release = rFLAppModule.provideRFLBarometerManager$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLBarometerManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLBarometerManager$silentlogsdkandroid_release;
    }

    public RFLBarometerManager get() {
        return provideRFLBarometerManager$silentlogsdkandroid_release(this.f3389a);
    }
}
