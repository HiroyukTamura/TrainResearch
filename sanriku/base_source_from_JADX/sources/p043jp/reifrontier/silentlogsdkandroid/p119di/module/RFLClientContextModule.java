package p043jp.reifrontier.silentlogsdkandroid.p119di.module;

import android.content.Context;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerJellyBeans;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerLollipop;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBeaconManagerUnsupported;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleFitManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleLocationService;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLWeatherManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLWeatherClient;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLOrmaHolder;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLLogger;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0007J\r\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\nJ\r\u0010\u000b\u001a\u00020\fH\u0001¢\u0006\u0002\b\rJ\r\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\b\u0010J\r\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u0018H\u0001¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/di/module/RFLClientContextModule;", "", "clientContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "provideRFLAccountManager", "Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "provideRFLAccountManager$silentlogsdkandroid_release", "provideRFLAdManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdManager;", "provideRFLAdManager$silentlogsdkandroid_release", "provideRFLBeaconManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManager;", "provideRFLBeaconManager$silentlogsdkandroid_release", "provideRFLGoogleFitManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager;", "provideRFLGoogleFitManager$silentlogsdkandroid_release", "provideRFLGoogleLocationService", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleLocationService;", "provideRFLGoogleLocationService$silentlogsdkandroid_release", "provideRFLLocationManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager;", "provideRFLLocationManager$silentlogsdkandroid_release", "provideRFLLogger", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLLogger;", "provideRFLLogger$silentlogsdkandroid_release", "provideRFLOrmaHolder", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLOrmaHolder;", "provideRFLOrmaHolder$silentlogsdkandroid_release", "provideRFLWeatherManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLWeatherManager;", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "weatherApiClient", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLWeatherClient;", "provideRFLWeatherManager$silentlogsdkandroid_release", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.di.module.RFLClientContextModule */
public final class RFLClientContextModule {

    /* renamed from: a */
    private final Context f3411a;

    public RFLClientContextModule(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "clientContext");
        this.f3411a = context;
    }

    public final RFLAccountManager provideRFLAccountManager$silentlogsdkandroid_release() {
        return new RFLAccountManager(this.f3411a);
    }

    public final RFLAdManager provideRFLAdManager$silentlogsdkandroid_release() {
        return new RFLAdManager(this.f3411a);
    }

    public final RFLBeaconManager provideRFLBeaconManager$silentlogsdkandroid_release() {
        return !this.f3411a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") ? new RFLBeaconManagerUnsupported() : Build.VERSION.SDK_INT >= 21 ? new RFLBeaconManagerLollipop(this.f3411a) : new RFLBeaconManagerJellyBeans(this.f3411a);
    }

    public final RFLGoogleFitManager provideRFLGoogleFitManager$silentlogsdkandroid_release() {
        return new RFLGoogleFitManager(this.f3411a);
    }

    public final RFLGoogleLocationService provideRFLGoogleLocationService$silentlogsdkandroid_release() {
        return new RFLGoogleLocationService(this.f3411a);
    }

    public final RFLLocationManager provideRFLLocationManager$silentlogsdkandroid_release() {
        return new RFLLocationManager(this.f3411a);
    }

    public final RFLLogger provideRFLLogger$silentlogsdkandroid_release() {
        return new RFLLogger(this.f3411a);
    }

    public final RFLOrmaHolder provideRFLOrmaHolder$silentlogsdkandroid_release() {
        return new RFLOrmaHolder(this.f3411a);
    }

    public final RFLWeatherManager provideRFLWeatherManager$silentlogsdkandroid_release(RFLDataLogger rFLDataLogger, RFLWeatherClient rFLWeatherClient) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "dataLogger");
        Intrinsics.checkParameterIsNotNull(rFLWeatherClient, "weatherApiClient");
        return new RFLWeatherManager(rFLDataLogger, rFLWeatherClient);
    }
}
