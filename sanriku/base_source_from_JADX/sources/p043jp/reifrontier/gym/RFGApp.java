package p043jp.reifrontier.gym;

import android.content.Context;
import android.os.Build;
import androidx.multidex.MultiDexApplication;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.gson.Gson;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import p041io.realm.ImportFlag;
import p041io.realm.Realm;
import p041io.realm.RealmList;
import p043jp.reifrontier.gym.data.RFGAppSetUp;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p043jp.reifrontier.gym.data.api.RFGPointClient;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.bus.RFGConnectSilentLog;
import p043jp.reifrontier.gym.data.bus.RFGUpdatePassword;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p043jp.reifrontier.gym.domain.silentlog.RFGActivity;
import p043jp.reifrontier.gym.domain.silentlog.RFGDaily;
import p043jp.reifrontier.gym.domain.silentlog.RFGDay;
import p043jp.reifrontier.gym.domain.silentlog.RFGSegment;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u001f"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGApp;", "Landroidx/multidex/MultiDexApplication;", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$SilentLogOperationListener;", "Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation$SilentLogInternalOperationListener;", "()V", "onCreate", "", "resultForConnectApi", "result", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$ConnectResult;", "userId", "", "resultForForgetPassword", "success", "", "message", "resultForLoadDailyBackground", "daily", "date", "Ljava/util/Date;", "resultForLoadUserProfile", "resultForLogoutApi", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$LogoutResult;", "resultForTransportPrediction", "resultForUpdateBirthday", "birthday", "resultForUpdateGender", "gender", "", "resultForUpdatePassword", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.RFGApp */
public final class RFGApp extends MultiDexApplication implements SilentLogOperation.SilentLogOperationListener, SilentLogInternalOperation.SilentLogInternalOperationListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static RFGApp instance;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/RFGApp$Companion;", "", "()V", "instance", "Ljp/reifrontier/gym/RFGApp;", "applicationContext", "Landroid/content/Context;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.RFGApp$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Context applicationContext() {
            RFGApp access$getInstance$cp = RFGApp.instance;
            if (access$getInstance$cp == null) {
                Intrinsics.throwNpe();
            }
            Context applicationContext = access$getInstance$cp.getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "instance!!.applicationContext");
            return applicationContext;
        }
    }

    public RFGApp() {
        instance = this;
    }

    public void onCreate() {
        super.onCreate();
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
        RFGAnalyticsManager.INSTANCE.initialize(this);
        Realm.init(this);
        RFGH2Client.Companion.getINSTANCE().build(this);
        RFGRailroadClient.Companion.getINSTANCE().build(this);
        RFGPointClient.Companion.getINSTANCE().build(this);
        RFGAppSetUp rFGAppSetUp = new RFGAppSetUp(this);
        rFGAppSetUp.setUpRealm();
        rFGAppSetUp.setUpSilentLog();
        rFGAppSetUp.setUpPreference();
        boolean isUseGoogleFit = RFGShared.INSTANCE.isUseGoogleFit();
        String string = getResources().getString(R.string.user_agent, new Object[]{BuildConfig.FLAVOR, BuildConfig.VERSION_NAME, BuildConfig.APPLICATION_ID, 24, Integer.valueOf(Build.VERSION.SDK_INT)});
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(\n   …VERSION.SDK_INT\n        )");
        C1122a.m1600c("App OnCreate::%s", string);
        C1122a.m1600c("App OnCreate:: use GoogleFit %s", Boolean.valueOf(isUseGoogleFit));
    }

    public void resultForConnectApi(SilentLogOperation.ConnectResult connectResult, String str) {
        Intrinsics.checkParameterIsNotNull(connectResult, "result");
        boolean z = false;
        C1122a.m1600c("[Gym]::Info App connectApi : result:" + connectResult + " userId:" + str, new Object[0]);
        C1126c c = C1126c.m1638c();
        if (connectResult == SilentLogOperation.ConnectResult.Success) {
            z = true;
        }
        c.mo21903a((Object) new RFGConnectSilentLog(z, str));
    }

    public void resultForForgetPassword(boolean z, String str) {
    }

    public void resultForLoadDailyBackground(String str, Date date) {
        Intrinsics.checkParameterIsNotNull(str, "daily");
        Intrinsics.checkParameterIsNotNull(date, "date");
        C1122a.m1600c("[Gym]::Info App endBackgroundLoadDaily", new Object[0]);
        RFGShared.INSTANCE.setRequestFeed(0);
        Realm defaultInstance = Realm.getDefaultInstance();
        RFGDaily rFGDaily = (RFGDaily) new Gson().fromJson(str, new RFGApp$resultForLoadDailyBackground$turnsType$1().getType());
        if (rFGDaily != null) {
            RealmList realmList = new RealmList();
            for (RFGSegment activities : rFGDaily.getSegments()) {
                for (RFGActivity add : activities.getActivities()) {
                    realmList.add(add);
                }
            }
            if (realmList.size() > 0) {
                RFGDay rFGDay = new RFGDay();
                rFGDay.setDate(rFGDaily.getDate());
                rFGDay.setActivites(realmList);
                defaultInstance.beginTransaction();
                defaultInstance.copyToRealmOrUpdate(rFGDay, new ImportFlag[0]);
                defaultInstance.commitTransaction();
            }
        }
        defaultInstance.close();
    }

    public void resultForLoadUserProfile(boolean z) {
    }

    public void resultForLogoutApi(SilentLogOperation.LogoutResult logoutResult) {
        Intrinsics.checkParameterIsNotNull(logoutResult, "result");
        if (logoutResult == SilentLogOperation.LogoutResult.Success) {
            Realm defaultInstance = Realm.getDefaultInstance();
            if (defaultInstance == null) {
                Intrinsics.throwNpe();
            }
            defaultInstance.executeTransaction(new RFGApp$resultForLogoutApi$1(defaultInstance));
            SilentLogOperation.Companion.getInstance().logoutApi();
        }
    }

    public void resultForTransportPrediction(String str) {
        Intrinsics.checkParameterIsNotNull(str, "daily");
    }

    public void resultForUpdateBirthday(boolean z, Date date) {
    }

    public void resultForUpdateGender(boolean z, int i) {
    }

    public void resultForUpdatePassword(boolean z) {
        C1126c.m1638c().mo21903a((Object) new RFGUpdatePassword(z));
    }
}
