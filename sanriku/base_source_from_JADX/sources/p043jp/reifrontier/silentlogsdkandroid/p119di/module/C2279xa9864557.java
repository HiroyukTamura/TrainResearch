package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManager;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLClientContextModule_ProvideRFLBeaconManager$silentlogsdkandroid_releaseFactory */
public final class C2279xa9864557 implements C1585b<RFLBeaconManager> {

    /* renamed from: a */
    private final RFLClientContextModule f3414a;

    public C2279xa9864557(RFLClientContextModule rFLClientContextModule) {
        this.f3414a = rFLClientContextModule;
    }

    public static C2279xa9864557 create(RFLClientContextModule rFLClientContextModule) {
        return new C2279xa9864557(rFLClientContextModule);
    }

    public static RFLBeaconManager provideRFLBeaconManager$silentlogsdkandroid_release(RFLClientContextModule rFLClientContextModule) {
        RFLBeaconManager provideRFLBeaconManager$silentlogsdkandroid_release = rFLClientContextModule.provideRFLBeaconManager$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLBeaconManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLBeaconManager$silentlogsdkandroid_release;
    }

    public RFLBeaconManager get() {
        return provideRFLBeaconManager$silentlogsdkandroid_release(this.f3414a);
    }
}
