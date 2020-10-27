package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLPointClient;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLPointClient$silentlogsdkandroid_releaseFactory */
public final class C2272x56505488 implements C1585b<RFLPointClient> {

    /* renamed from: a */
    private final RFLAppModule f3402a;

    public C2272x56505488(RFLAppModule rFLAppModule) {
        this.f3402a = rFLAppModule;
    }

    public static C2272x56505488 create(RFLAppModule rFLAppModule) {
        return new C2272x56505488(rFLAppModule);
    }

    public static RFLPointClient provideRFLPointClient$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLPointClient provideRFLPointClient$silentlogsdkandroid_release = rFLAppModule.provideRFLPointClient$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLPointClient$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLPointClient$silentlogsdkandroid_release;
    }

    public RFLPointClient get() {
        return provideRFLPointClient$silentlogsdkandroid_release(this.f3402a);
    }
}
