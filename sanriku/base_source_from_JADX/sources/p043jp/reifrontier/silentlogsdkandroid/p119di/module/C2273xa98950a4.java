package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLPointManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLPointClient;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLPointManager$silentlogsdkandroid_releaseFactory */
public final class C2273xa98950a4 implements C1585b<RFLPointManager> {

    /* renamed from: a */
    private final RFLAppModule f3403a;

    /* renamed from: b */
    private final C1743a<RFLPointClient> f3404b;

    public C2273xa98950a4(RFLAppModule rFLAppModule, C1743a<RFLPointClient> aVar) {
        this.f3403a = rFLAppModule;
        this.f3404b = aVar;
    }

    public static C2273xa98950a4 create(RFLAppModule rFLAppModule, C1743a<RFLPointClient> aVar) {
        return new C2273xa98950a4(rFLAppModule, aVar);
    }

    public static RFLPointManager provideRFLPointManager$silentlogsdkandroid_release(RFLAppModule rFLAppModule, RFLPointClient rFLPointClient) {
        RFLPointManager provideRFLPointManager$silentlogsdkandroid_release = rFLAppModule.provideRFLPointManager$silentlogsdkandroid_release(rFLPointClient);
        C1532a.m2125a(provideRFLPointManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLPointManager$silentlogsdkandroid_release;
    }

    public RFLPointManager get() {
        return provideRFLPointManager$silentlogsdkandroid_release(this.f3403a, this.f3404b.get());
    }
}
