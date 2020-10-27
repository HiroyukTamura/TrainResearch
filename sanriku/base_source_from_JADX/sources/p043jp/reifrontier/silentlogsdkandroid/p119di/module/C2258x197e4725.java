package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLAdjustTrackPointDao;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLAdjustTrackPointDao$silentlogsdkandroid_releaseFactory */
public final class C2258x197e4725 implements C1585b<RFLAdjustTrackPointDao> {

    /* renamed from: a */
    private final RFLAppModule f3385a;

    public C2258x197e4725(RFLAppModule rFLAppModule) {
        this.f3385a = rFLAppModule;
    }

    public static C2258x197e4725 create(RFLAppModule rFLAppModule) {
        return new C2258x197e4725(rFLAppModule);
    }

    public static RFLAdjustTrackPointDao provideRFLAdjustTrackPointDao$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLAdjustTrackPointDao provideRFLAdjustTrackPointDao$silentlogsdkandroid_release = rFLAppModule.provideRFLAdjustTrackPointDao$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLAdjustTrackPointDao$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLAdjustTrackPointDao$silentlogsdkandroid_release;
    }

    public RFLAdjustTrackPointDao get() {
        return provideRFLAdjustTrackPointDao$silentlogsdkandroid_release(this.f3385a);
    }
}
