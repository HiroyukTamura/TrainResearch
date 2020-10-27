package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyTagDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLOrmaHolder;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLEntityDailyTagDao$silentlogsdkandroid_releaseFactory */
public final class C2268x970d8335 implements C1585b<RFLDailyTagDao> {

    /* renamed from: a */
    private final RFLAppModule f3397a;

    /* renamed from: b */
    private final C1743a<RFLOrmaHolder> f3398b;

    public C2268x970d8335(RFLAppModule rFLAppModule, C1743a<RFLOrmaHolder> aVar) {
        this.f3397a = rFLAppModule;
        this.f3398b = aVar;
    }

    public static C2268x970d8335 create(RFLAppModule rFLAppModule, C1743a<RFLOrmaHolder> aVar) {
        return new C2268x970d8335(rFLAppModule, aVar);
    }

    public static RFLDailyTagDao provideRFLEntityDailyTagDao$silentlogsdkandroid_release(RFLAppModule rFLAppModule, RFLOrmaHolder rFLOrmaHolder) {
        RFLDailyTagDao provideRFLEntityDailyTagDao$silentlogsdkandroid_release = rFLAppModule.provideRFLEntityDailyTagDao$silentlogsdkandroid_release(rFLOrmaHolder);
        C1532a.m2125a(provideRFLEntityDailyTagDao$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLEntityDailyTagDao$silentlogsdkandroid_release;
    }

    public RFLDailyTagDao get() {
        return provideRFLEntityDailyTagDao$silentlogsdkandroid_release(this.f3397a, this.f3398b.get());
    }
}
