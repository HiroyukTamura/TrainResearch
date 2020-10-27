package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLClientContextModule_ProvideRFLAccountManager$silentlogsdkandroid_releaseFactory */
public final class C2277x36462bc4 implements C1585b<RFLAccountManager> {

    /* renamed from: a */
    private final RFLClientContextModule f3412a;

    public C2277x36462bc4(RFLClientContextModule rFLClientContextModule) {
        this.f3412a = rFLClientContextModule;
    }

    public static C2277x36462bc4 create(RFLClientContextModule rFLClientContextModule) {
        return new C2277x36462bc4(rFLClientContextModule);
    }

    public static RFLAccountManager provideRFLAccountManager$silentlogsdkandroid_release(RFLClientContextModule rFLClientContextModule) {
        RFLAccountManager provideRFLAccountManager$silentlogsdkandroid_release = rFLClientContextModule.provideRFLAccountManager$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLAccountManager$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLAccountManager$silentlogsdkandroid_release;
    }

    public RFLAccountManager get() {
        return provideRFLAccountManager$silentlogsdkandroid_release(this.f3412a);
    }
}
