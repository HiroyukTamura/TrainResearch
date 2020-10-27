package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLActivityPoiManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLActivityPoiManager$silentlogsdkandroid_releaseFactory */
public final class C2257x72b792cf implements C1585b<RFLActivityPoiManager> {

    /* renamed from: a */
    private final RFLAppModule f3383a;

    /* renamed from: b */
    private final C1743a<RFLDataLogger> f3384b;

    public C2257x72b792cf(RFLAppModule rFLAppModule, C1743a<RFLDataLogger> aVar) {
        this.f3383a = rFLAppModule;
        this.f3384b = aVar;
    }

    public static C2257x72b792cf create(RFLAppModule rFLAppModule, C1743a<RFLDataLogger> aVar) {
        return new C2257x72b792cf(rFLAppModule, aVar);
    }

    public static RFLActivityPoiManager provideRFLActivityPoiManager$silentlogsdkandroid_release(RFLAppModule rFLAppModule, RFLDataLogger rFLDataLogger) {
        RFLActivityPoiManager provideRFLActivityPoiManager$silentlogsdkandroid_release = rFLAppModule.provideRFLActivityPoiManager$silentlogsdkandroid_release(rFLDataLogger);
        C1532a.m2125a(provideRFLActivityPoiManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLActivityPoiManager$silentlogsdkandroid_release;
    }

    public RFLActivityPoiManager get() {
        return provideRFLActivityPoiManager$silentlogsdkandroid_release(this.f3383a, this.f3384b.get());
    }
}
