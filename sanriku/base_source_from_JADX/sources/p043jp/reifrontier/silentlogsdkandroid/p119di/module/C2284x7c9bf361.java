package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLOrmaHolder;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLClientContextModule_ProvideRFLOrmaHolder$silentlogsdkandroid_releaseFactory */
public final class C2284x7c9bf361 implements C1585b<RFLOrmaHolder> {

    /* renamed from: a */
    private final RFLClientContextModule f3419a;

    public C2284x7c9bf361(RFLClientContextModule rFLClientContextModule) {
        this.f3419a = rFLClientContextModule;
    }

    public static C2284x7c9bf361 create(RFLClientContextModule rFLClientContextModule) {
        return new C2284x7c9bf361(rFLClientContextModule);
    }

    public static RFLOrmaHolder provideRFLOrmaHolder$silentlogsdkandroid_release(RFLClientContextModule rFLClientContextModule) {
        RFLOrmaHolder provideRFLOrmaHolder$silentlogsdkandroid_release = rFLClientContextModule.provideRFLOrmaHolder$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLOrmaHolder$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLOrmaHolder$silentlogsdkandroid_release;
    }

    public RFLOrmaHolder get() {
        return provideRFLOrmaHolder$silentlogsdkandroid_release(this.f3419a);
    }
}
