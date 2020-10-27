package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import org.greenrobot.eventbus.C1126c;
import p009e.p028d.p030b.p054b.C1532a;
import p076f.p077b.C1585b;

/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLAppModule_ProvideEventBus$silentlogsdkandroid_releaseFactory */
public final class RFLAppModule_ProvideEventBus$silentlogsdkandroid_releaseFactory implements C1585b<C1126c> {

    /* renamed from: a */
    private final RFLAppModule f3381a;

    public RFLAppModule_ProvideEventBus$silentlogsdkandroid_releaseFactory(RFLAppModule rFLAppModule) {
        this.f3381a = rFLAppModule;
    }

    public static RFLAppModule_ProvideEventBus$silentlogsdkandroid_releaseFactory create(RFLAppModule rFLAppModule) {
        return new RFLAppModule_ProvideEventBus$silentlogsdkandroid_releaseFactory(rFLAppModule);
    }

    public static C1126c provideEventBus$silentlogsdkandroid_release(RFLAppModule rFLAppModule) {
        C1126c provideEventBus$silentlogsdkandroid_release = rFLAppModule.provideEventBus$silentlogsdkandroid_release();
        C1532a.m2125a(provideEventBus$silentlogsdkandroid_release, "Cannot return null from a non-@Nullable @Provides method");
        return provideEventBus$silentlogsdkandroid_release;
    }

    public C1126c get() {
        return provideEventBus$silentlogsdkandroid_release(this.f3381a);
    }
}
