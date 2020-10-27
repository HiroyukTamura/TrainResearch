package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdjustTrackPointManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p076f.p077b.C1585b;
import p101h.p102a.C1743a;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLAdjustTrackPointManager$silentlogsdkandroid_releaseFactory */
public final class C2259x8c528aaa implements C1585b<RFLAdjustTrackPointManager> {

    /* renamed from: a */
    private final RFLAppModule f3386a;

    /* renamed from: b */
    private final C1743a<RFLDataLogger> f3387b;

    public C2259x8c528aaa(RFLAppModule rFLAppModule, C1743a<RFLDataLogger> aVar) {
        this.f3386a = rFLAppModule;
        this.f3387b = aVar;
    }

    public static C2259x8c528aaa create(RFLAppModule rFLAppModule, C1743a<RFLDataLogger> aVar) {
        return new C2259x8c528aaa(rFLAppModule, aVar);
    }

    public static RFLAdjustTrackPointManager provideRFLAdjustTrackPointManager$silentlogsdkandroid_release(RFLAppModule rFLAppModule, RFLDataLogger rFLDataLogger) {
        RFLAdjustTrackPointManager provideRFLAdjustTrackPointManager$silentlogsdkandroid_release = rFLAppModule.provideRFLAdjustTrackPointManager$silentlogsdkandroid_release(rFLDataLogger);
        C1532a.m2125a(provideRFLAdjustTrackPointManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLAdjustTrackPointManager$silentlogsdkandroid_release;
    }

    public RFLAdjustTrackPointManager get() {
        return provideRFLAdjustTrackPointManager$silentlogsdkandroid_release(this.f3386a, this.f3387b.get());
    }
}
