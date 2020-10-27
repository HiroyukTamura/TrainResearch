package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLOrmaHolder;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLWeatherDao;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLWeatherDao$silentlogsdkandroid_releaseFactory */
public final class C2276xd1c76dc3 implements C1585b<RFLWeatherDao> {

    /* renamed from: a */
    private final RFLAppModule f3409a;

    /* renamed from: b */
    private final C1743a<RFLOrmaHolder> f3410b;

    public C2276xd1c76dc3(RFLAppModule rFLAppModule, C1743a<RFLOrmaHolder> aVar) {
        this.f3409a = rFLAppModule;
        this.f3410b = aVar;
    }

    public static C2276xd1c76dc3 create(RFLAppModule rFLAppModule, C1743a<RFLOrmaHolder> aVar) {
        return new C2276xd1c76dc3(rFLAppModule, aVar);
    }

    public static RFLWeatherDao provideRFLWeatherDao$silentlogsdkandroid_release(RFLAppModule rFLAppModule, RFLOrmaHolder rFLOrmaHolder) {
        RFLWeatherDao provideRFLWeatherDao$silentlogsdkandroid_release = rFLAppModule.provideRFLWeatherDao$silentlogsdkandroid_release(rFLOrmaHolder);
        C1532a.m2125a(provideRFLWeatherDao$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLWeatherDao$silentlogsdkandroid_release;
    }

    public RFLWeatherDao get() {
        return provideRFLWeatherDao$silentlogsdkandroid_release(this.f3409a, this.f3410b.get());
    }
}
