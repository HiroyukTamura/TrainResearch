package p043jp.reifrontier.gym.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.Realm;
import p041io.realm.RealmConfiguration;
import p043jp.reifrontier.gym.BuildConfig;
import p043jp.reifrontier.gym.RFGApp;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.service.RFGForegroundService;
import p043jp.reifrontier.gym.service.RFGGeoReceiver;
import p043jp.reifrontier.gym.service.RFGService;
import p043jp.reifrontier.gym.util.RFGMigration;
import p043jp.reifrontier.gym.util.RFGUtilsKt;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/data/RFGAppSetUp;", "", "application", "Ljp/reifrontier/gym/RFGApp;", "(Ljp/reifrontier/gym/RFGApp;)V", "setUpPreference", "", "setUpRealm", "setUpSilentLog", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.RFGAppSetUp */
public final class RFGAppSetUp {
    private final RFGApp application;

    public RFGAppSetUp(RFGApp rFGApp) {
        Intrinsics.checkParameterIsNotNull(rFGApp, "application");
        this.application = rFGApp;
    }

    public final void setUpPreference() {
        RFGShared.INSTANCE.initialize(this.application);
        RFGShared.INSTANCE.setRequestFeed(0);
        RFGShared.INSTANCE.setRequestPoint(0);
        RFGShared.INSTANCE.setRequestActs(0);
        boolean isUseGoogleFit = RFGShared.INSTANCE.isUseGoogleFit();
        boolean hasInstalledGoogleFit = RFGUtilsKt.hasInstalledGoogleFit(this.application);
        if (!isUseGoogleFit || !hasInstalledGoogleFit) {
            SilentLogOperation.Companion.getInstance().setStepPerMinutesPriority(true);
        } else {
            SilentLogOperation.Companion.getInstance().connectGoogleFitClient();
            SilentLogOperation.Companion.getInstance().setStepPerMinutesPriority(false);
        }
        if (!Intrinsics.areEqual((Object) RFGShared.INSTANCE.firstDate(), (Object) "21000207T000000Z")) {
            RFGShared.INSTANCE.setIsEnterPersonal(true);
        }
    }

    public final void setUpRealm() {
        Realm.init(this.application);
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder().schemaVersion(4).migration(new RFGMigration()).build());
    }

    public final void setUpSilentLog() {
        String name = RFGService.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name, "RFGService::class.java.name");
        String name2 = RFGGeoReceiver.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "RFGGeoReceiver::class.java.name");
        String name3 = RFGForegroundService.class.getName();
        Intrinsics.checkExpressionValueIsNotNull(name3, "RFGForegroundService::class.java.name");
        SilentLogOperation instance = SilentLogOperation.Companion.getInstance();
        RFGApp rFGApp = this.application;
        instance.createInternalOperation(rFGApp, rFGApp);
        SilentLogInternalOperation internalOperation = SilentLogOperation.Companion.getInstance().getInternalOperation();
        RFGApp rFGApp2 = this.application;
        internalOperation.build(rFGApp2, rFGApp2, BuildConfig.CLIENT_ID, BuildConfig.CLIENT_SECRET, false);
        SilentLogOperation.Companion.getInstance().setServiceName(name, name2, name3);
        SilentLogOperation.Companion.getInstance().enableTransportPrediction(false);
        SilentLogOperation.Companion.getInstance().savePointSystemKey("point-201911-SAN");
        SilentLogOperation.Companion.getInstance().loadUserProfile(true);
    }
}
