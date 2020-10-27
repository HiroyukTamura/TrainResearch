package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLClientContextModule_ProvideRFLLocationManager$silentlogsdkandroid_releaseFactory */
public final class C2282x7b9bb408 implements C1585b<RFLLocationManager> {

    /* renamed from: a */
    private final RFLClientContextModule f3417a;

    public C2282x7b9bb408(RFLClientContextModule rFLClientContextModule) {
        this.f3417a = rFLClientContextModule;
    }

    public static C2282x7b9bb408 create(RFLClientContextModule rFLClientContextModule) {
        return new C2282x7b9bb408(rFLClientContextModule);
    }

    public static RFLLocationManager provideRFLLocationManager$silentlogsdkandroid_release(RFLClientContextModule rFLClientContextModule) {
        RFLLocationManager provideRFLLocationManager$silentlogsdkandroid_release = rFLClientContextModule.provideRFLLocationManager$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLLocationManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLLocationManager$silentlogsdkandroid_release;
    }

    public RFLLocationManager get() {
        return provideRFLLocationManager$silentlogsdkandroid_release(this.f3417a);
    }
}
