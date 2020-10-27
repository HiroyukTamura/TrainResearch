package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLClientContextModule_ProvideRFLAdManager$silentlogsdkandroid_releaseFactory */
public final class C2278x5313ed76 implements C1585b<RFLAdManager> {

    /* renamed from: a */
    private final RFLClientContextModule f3413a;

    public C2278x5313ed76(RFLClientContextModule rFLClientContextModule) {
        this.f3413a = rFLClientContextModule;
    }

    public static C2278x5313ed76 create(RFLClientContextModule rFLClientContextModule) {
        return new C2278x5313ed76(rFLClientContextModule);
    }

    public static RFLAdManager provideRFLAdManager$silentlogsdkandroid_release(RFLClientContextModule rFLClientContextModule) {
        RFLAdManager provideRFLAdManager$silentlogsdkandroid_release = rFLClientContextModule.provideRFLAdManager$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLAdManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLAdManager$silentlogsdkandroid_release;
    }

    public RFLAdManager get() {
        return provideRFLAdManager$silentlogsdkandroid_release(this.f3413a);
    }
}
