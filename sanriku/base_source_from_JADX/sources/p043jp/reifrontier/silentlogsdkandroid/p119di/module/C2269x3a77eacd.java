package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import p009e.p028d.p030b.p054b.C1532a;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideRFLH1Client$silentlogsdkandroid_releaseFactory */
public final class C2269x3a77eacd implements C1585b<RFLH1Client> {

    /* renamed from: a */
    private final RFLAppModule f3399a;

    public C2269x3a77eacd(RFLAppModule rFLAppModule) {
        this.f3399a = rFLAppModule;
    }

    public static C2269x3a77eacd create(RFLAppModule rFLAppModule) {
        return new C2269x3a77eacd(rFLAppModule);
    }

    public static RFLH1Client provideRFLH1Client$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        RFLH1Client provideRFLH1Client$silentlogsdkandroid_release = rFLAppModule.provideRFLH1Client$silentlogsdkandroid_release();
        C1532a.m2125a(provideRFLH1Client$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideRFLH1Client$silentlogsdkandroid_release;
    }

    public RFLH1Client get() {
        return provideRFLH1Client$silentlogsdkandroid_release(this.f3399a);
    }
}
