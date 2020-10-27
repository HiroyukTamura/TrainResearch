package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLDailyTagManager$silentlogsdkandroid_releaseFactory */
public final class C2265x81ee3a37 implements C1585b<RFLDailyTagManager> {

    /* renamed from: a */
    private final RFLAppModule f3393a;

    /* renamed from: b */
    private final C1743a<RFLDataLogger> f3394b;

    public C2265x81ee3a37(RFLAppModule rFLAppModule, C1743a<RFLDataLogger> aVar) {
        this.f3393a = rFLAppModule;
        this.f3394b = aVar;
    }

    public static C2265x81ee3a37 create(RFLAppModule rFLAppModule, C1743a<RFLDataLogger> aVar) {
        return new C2265x81ee3a37(rFLAppModule, aVar);
    }

    public static RFLDailyTagManager provideRFLDailyTagManager$silentlogsdkandroid_release(RFLAppModule rFLAppModule, RFLDataLogger rFLDataLogger) {
        RFLDailyTagManager provideRFLDailyTagManager$silentlogsdkandroid_release = rFLAppModule.provideRFLDailyTagManager$silentlogsdkandroid_release(rFLDataLogger);
        C1532a.m2125a(provideRFLDailyTagManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLDailyTagManager$silentlogsdkandroid_release;
    }

    public RFLDailyTagManager get() {
        return provideRFLDailyTagManager$silentlogsdkandroid_release(this.f3393a, this.f3394b.get());
    }
}
