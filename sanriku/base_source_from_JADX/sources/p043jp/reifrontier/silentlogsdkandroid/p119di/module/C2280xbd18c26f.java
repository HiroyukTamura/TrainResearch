package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleFitManager;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLClientContextModule_ProvideRFLGoogleFitManager$silentlogsdkandroid_releaseFactory */
public final class C2280xbd18c26f implements C1585b<RFLGoogleFitManager> {

    /* renamed from: a */
    private final RFLClientContextModule f3415a;

    public C2280xbd18c26f(RFLClientContextModule rFLClientContextModule) {
        this.f3415a = rFLClientContextModule;
    }

    public static C2280xbd18c26f create(RFLClientContextModule rFLClientContextModule) {
        return new C2280xbd18c26f(rFLClientContextModule);
    }

    public static RFLGoogleFitManager provideRFLGoogleFitManager$silentlogsdkandroid_release(RFLClientContextModule rFLClientContextModule) {
        RFLGoogleFitManager provideRFLGoogleFitManager$silentlogsdkandroid_release = rFLClientContextModule.provideRFLGoogleFitManager$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLGoogleFitManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLGoogleFitManager$silentlogsdkandroid_release;
    }

    public RFLGoogleFitManager get() {
        return provideRFLGoogleFitManager$silentlogsdkandroid_release(this.f3415a);
    }
}
