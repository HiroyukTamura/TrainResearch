package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTrackPointDao;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLTrackPointDao$silentlogsdkandroid_releaseFactory */
public final class C2274x7ebd3236 implements C1585b<RFLTrackPointDao> {

    /* renamed from: a */
    private final RFLAppModule f3407a;

    public C2274x7ebd3236(RFLAppModule rFLAppModule) {
        this.f3407a = rFLAppModule;
    }

    public static C2274x7ebd3236 create(RFLAppModule rFLAppModule) {
        return new C2274x7ebd3236(rFLAppModule);
    }

    public static RFLTrackPointDao provideRFLTrackPointDao$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLTrackPointDao provideRFLTrackPointDao$silentlogsdkandroid_release = rFLAppModule.provideRFLTrackPointDao$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLTrackPointDao$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLTrackPointDao$silentlogsdkandroid_release;
    }

    public RFLTrackPointDao get() {
        return provideRFLTrackPointDao$silentlogsdkandroid_release(this.f3407a);
    }
}
