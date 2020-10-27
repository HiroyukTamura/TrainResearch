package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleLocationService;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLClientContextModule_ProvideRFLGoogleLocationService$silentlogsdkandroid_releaseFactory */
public final class C2281xaa5dc399 implements C1585b<RFLGoogleLocationService> {

    /* renamed from: a */
    private final RFLClientContextModule f3416a;

    public C2281xaa5dc399(RFLClientContextModule rFLClientContextModule) {
        this.f3416a = rFLClientContextModule;
    }

    public static C2281xaa5dc399 create(RFLClientContextModule rFLClientContextModule) {
        return new C2281xaa5dc399(rFLClientContextModule);
    }

    public static RFLGoogleLocationService provideRFLGoogleLocationService$silentlogsdkandroid_release(RFLClientContextModule rFLClientContextModule) {
        RFLGoogleLocationService provideRFLGoogleLocationService$silentlogsdkandroid_release = rFLClientContextModule.provideRFLGoogleLocationService$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLGoogleLocationService$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLGoogleLocationService$silentlogsdkandroid_release;
    }

    public RFLGoogleLocationService get() {
        return provideRFLGoogleLocationService$silentlogsdkandroid_release(this.f3416a);
    }
}
