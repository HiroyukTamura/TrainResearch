package p043jp.reifrontier.silentlogsdkandroid.p119di;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.RFLSilentLogOperation;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLBarometerManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyLoader;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDailyManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleFitManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleLocationService;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLPedometerManager;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLActivityDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLAdjustTrackPointDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLBarometerDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLDailyDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLPedometerDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTPDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTagDao;
import p043jp.reifrontier.silentlogsdkandroid.data.dao.RFLTrackPointDao;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLNotificationPoi;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivity;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.RFLAppModule;
import p043jp.reifrontier.silentlogsdkandroid.p119di.module.RFLClientContextModule;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLLogTree;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u00014J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00100\u001a\u000201H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u00102\u001a\u000203H&¨\u00065"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/di/RFLAppComponent;", "", "inject", "", "rflSilentLogOperation", "Ljp/reifrontier/silentlogsdkandroid/RFLSilentLogOperation;", "rflAccountManager", "Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "rflAdManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdManager;", "rflBarometerManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLBarometerManager;", "rflDailyLoader", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyLoader;", "rflDailyManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyManager;", "rflDataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "rflGoogleFitManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleFitManager;", "rflGoogleLocationService", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleLocationService;", "rflLocationManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager;", "rflPedometerManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLPedometerManager;", "rflH1Client", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "rflActivityDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLActivityDao;", "rflAdjustTrackPointDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLAdjustTrackPointDao;", "rflBarometerDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLBarometerDao;", "rflDailyDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLDailyDao;", "rflPedometerDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLPedometerDao;", "rflTPDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTPDao;", "rflTagDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTagDao;", "rflTrackPointDao", "Ljp/reifrontier/silentlogsdkandroid/data/dao/RFLTrackPointDao;", "rflNotificationPoi", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLNotificationPoi;", "rflActivity", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivity;", "rflDailyUtils", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "rflLogTree", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLLogTree;", "SdkComponent", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.di.RFLAppComponent */
public interface RFLAppComponent {

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/di/RFLAppComponent$SdkComponent;", "", "()V", "component", "Ljp/reifrontier/silentlogsdkandroid/di/RFLAppComponent;", "getComponent$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/di/RFLAppComponent;", "setComponent$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/di/RFLAppComponent;)V", "initComponent", "", "clientContext", "Landroid/content/Context;", "initComponent$silentlogsdkandroid_release", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.di.RFLAppComponent$SdkComponent */
    public static final class SdkComponent {
        public static final SdkComponent INSTANCE = new SdkComponent();

        /* renamed from: a */
        private static RFLAppComponent f3380a;

        private SdkComponent() {
        }

        public final RFLAppComponent getComponent$silentlogsdkandroid_release() {
            return f3380a;
        }

        public final void initComponent$silentlogsdkandroid_release(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "clientContext");
            if (f3380a == null) {
                f3380a = DaggerRFLAppComponent.builder().rFLAppModule(new RFLAppModule()).rFLClientContextModule(new RFLClientContextModule(context)).build();
            }
        }

        public final void setComponent$silentlogsdkandroid_release(RFLAppComponent rFLAppComponent) {
            f3380a = rFLAppComponent;
        }
    }

    void inject(RFLSilentLogOperation rFLSilentLogOperation);

    void inject(RFLAccountManager rFLAccountManager);

    void inject(RFLAdManager rFLAdManager);

    void inject(RFLBarometerManager rFLBarometerManager);

    void inject(RFLDailyLoader rFLDailyLoader);

    void inject(RFLDailyManager rFLDailyManager);

    void inject(RFLDataLogger rFLDataLogger);

    void inject(RFLGoogleFitManager rFLGoogleFitManager);

    void inject(RFLGoogleLocationService rFLGoogleLocationService);

    void inject(RFLLocationManager rFLLocationManager);

    void inject(RFLPedometerManager rFLPedometerManager);

    void inject(RFLH1Client rFLH1Client);

    void inject(RFLActivityDao rFLActivityDao);

    void inject(RFLAdjustTrackPointDao rFLAdjustTrackPointDao);

    void inject(RFLBarometerDao rFLBarometerDao);

    void inject(RFLDailyDao rFLDailyDao);

    void inject(RFLPedometerDao rFLPedometerDao);

    void inject(RFLTPDao rFLTPDao);

    void inject(RFLTagDao rFLTagDao);

    void inject(RFLTrackPointDao rFLTrackPointDao);

    void inject(RFLNotificationPoi rFLNotificationPoi);

    void inject(RFLActivity rFLActivity);

    void inject(RFLDailyUtils rFLDailyUtils);

    void inject(RFLLogTree rFLLogTree);
}
