package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLWeatherClient;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLWeatherClient$silentlogsdkandroid_releaseFactory */
public final class C2275xb4b9ae64 implements C1585b<RFLWeatherClient> {

    /* renamed from: a */
    private final RFLAppModule f3408a;

    public C2275xb4b9ae64(RFLAppModule rFLAppModule) {
        this.f3408a = rFLAppModule;
    }

    public static C2275xb4b9ae64 create(RFLAppModule rFLAppModule) {
        return new C2275xb4b9ae64(rFLAppModule);
    }

    public static RFLWeatherClient provideRFLWeatherClient$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLWeatherClient provideRFLWeatherClient$silentlogsdkandroid_release = rFLAppModule.provideRFLWeatherClient$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLWeatherClient$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLWeatherClient$silentlogsdkandroid_release;
    }

    public RFLWeatherClient get() {
        return provideRFLWeatherClient$silentlogsdkandroid_release(this.f3408a);
    }
}
