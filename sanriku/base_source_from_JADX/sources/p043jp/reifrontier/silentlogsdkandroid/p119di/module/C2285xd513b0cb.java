package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLWeatherClient;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLClientContextModule_ProvideRFLWeatherManager$silentlogsdkandroid_releaseFactory */
public final class C2285xd513b0cb implements C1585b<RFLWeatherManager> {

    /* renamed from: a */
    private final RFLClientContextModule f3420a;

    /* renamed from: b */
    private final C1743a<RFLDataLogger> f3421b;

    /* renamed from: c */
    private final C1743a<RFLWeatherClient> f3422c;

    public C2285xd513b0cb(RFLClientContextModule rFLClientContextModule, C1743a<RFLDataLogger> aVar, C1743a<RFLWeatherClient> aVar2) {
        this.f3420a = rFLClientContextModule;
        this.f3421b = aVar;
        this.f3422c = aVar2;
    }

    public static C2285xd513b0cb create(RFLClientContextModule rFLClientContextModule, C1743a<RFLDataLogger> aVar, C1743a<RFLWeatherClient> aVar2) {
        return new C2285xd513b0cb(rFLClientContextModule, aVar, aVar2);
    }

    public static RFLWeatherManager provideRFLWeatherManager$silentlogsdkandroid_release(RFLClientContextModule rFLClientContextModule, RFLDataLogger rFLDataLogger, RFLWeatherClient rFLWeatherClient) {
        RFLWeatherManager provideRFLWeatherManager$silentlogsdkandroid_release = rFLClientContextModule.provideRFLWeatherManager$silentlogsdkandroid_release(rFLDataLogger, rFLWeatherClient);
        C1532a.m2125a(provideRFLWeatherManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLWeatherManager$silentlogsdkandroid_release;
    }

    public RFLWeatherManager get() {
        return provideRFLWeatherManager$silentlogsdkandroid_release(this.f3420a, this.f3421b.get(), this.f3422c.get());
    }
}
