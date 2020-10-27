package p043jp.reifrontier.silentlogsdkandroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogAdListener;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogInternalOperation;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResType;
import p078g.p079a.C1696b;
import p078g.p079a.C1714r;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000e\u0018\u0000 s2\u00020\u0001:\u0006stuvwxB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014JC\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0018\b\u0002\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u000eJ\u0016\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020 J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0004J\b\u0010&\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010'\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020(J\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140*2\u0006\u0010+\u001a\u00020\u001aJ\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020#0*2\u0006\u0010+\u001a\u00020\u001aJ\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0014J\u0006\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020\u001aJ\u0006\u00101\u001a\u00020\u0014J\u000e\u00102\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u000203J\u0006\u00104\u001a\u00020#J\u0006\u00105\u001a\u00020#J\u0006\u00106\u001a\u00020#J\u0006\u00107\u001a\u00020#J\u0006\u00108\u001a\u00020#J\b\u00109\u001a\u0004\u0018\u00010:J\u0010\u0010;\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020#J\u0006\u0010=\u001a\u00020\u000eJ\u0006\u0010>\u001a\u00020\u000eJ\u0016\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0004J\u000e\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u0014J\f\u0010D\u001a\b\u0012\u0004\u0012\u00020E0*J\u0006\u0010F\u001a\u00020GJ\u001e\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020K2\u0006\u0010\u0011\u001a\u00020LJ\u001e\u0010M\u001a\u00020\u000e2\u0006\u0010N\u001a\u00020\u00142\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u0004J\u000e\u0010Q\u001a\u00020\u000e2\u0006\u0010R\u001a\u00020\u0014J\u000e\u0010S\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020\u0014J\u000e\u0010U\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020#J\u000e\u0010W\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020\u0014J\u000e\u0010Y\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020#J\u001e\u0010[\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u00142\u0006\u0010]\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\u0014J\u000e\u0010_\u001a\u00020\u000e2\u0006\u0010`\u001a\u00020#J\u000e\u0010a\u001a\u00020\u000e2\u0006\u0010b\u001a\u00020\u0004J\u000e\u0010c\u001a\u00020\u000e2\u0006\u0010d\u001a\u00020#J\u0006\u0010e\u001a\u00020#J\u000e\u0010f\u001a\u00020\u000e2\u0006\u0010g\u001a\u00020hJ \u0010i\u001a\u00020\u000e2\u0018\u0010j\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u001c0kJ\u0006\u0010l\u001a\u00020\u000eJ\u0006\u0010m\u001a\u00020\u000eJ\u0006\u0010n\u001a\u00020\u000eJ\u000e\u0010o\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010p\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010q\u001a\u00020\u000e2\u0006\u0010r\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006y"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation;", "", "()V", "SILENT_LOG_SDK_GPS_PERMISSION", "", "getSILENT_LOG_SDK_GPS_PERMISSION", "()I", "internalOperation", "Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation;", "getInternalOperation", "()Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation;", "internalSilentLogOperation", "Ljp/reifrontier/silentlogsdkandroid/RFLSilentLogOperation;", "build", "", "context", "Landroid/content/Context;", "listener", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$SilentLogOperationListener;", "clientId", "", "clientSecret", "connectApi", "username", "gender", "birthday", "Ljava/util/Date;", "privateKeyMap", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Date;Ljava/util/Map;)V", "connectGoogleFitClient", "createInternalOperation", "Ljp/reifrontier/silentlogsdkandroid/SilentLogInternalOperation$SilentLogInternalOperationListener;", "enableTransportPrediction", "enable", "", "entryCampaignAsync", "adEntryType", "getBirthDay", "getCampaign", "Ljp/reifrontier/silentlogsdkandroid/SilentLogAdListener$OnCompletedGetCampaign;", "getDataFor", "Lio/reactivex/Single;", "targetDate", "getDataWithTagFor", "getEntryType", "getExtraUserId", "getGender", "getInstallDate", "getSilentLogUserId", "getTodayStepCountByGoogleFit", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$SilentLogStepsListener;", "hasAuth", "isEntryCampaign", "isLogin", "isMilePointAuth", "isRegistLogin", "loadLocation", "Landroid/location/Location;", "loadUserProfile", "force", "logoutApi", "onStart", "permissionResult", "requestCode", "grantResults", "registerRemoteToken", "tokenString", "release", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$LogoutResult;", "releaseWithoutLogout", "Lio/reactivex/Completable;", "responseAd", "campId", "responseType", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResType;", "Ljp/reifrontier/silentlogsdkandroid/SilentLogAdListener$OnCompletedResponseAd;", "saveActivityTag", "activityTag", "fromDate", "toDate", "savePointSystemKey", "pointSystemKey", "setBaseUrl", "baseUrl", "setJapanOnly", "japanOnly", "setPointUrl", "pointUrl", "setSendPushToken", "sendPushToken", "setServiceName", "service", "geofence", "foreground", "setStepPerMinutesPriority", "useSdkSteps", "setTrackingPriorityType", "type", "setUseAdvertisingId", "useAdvertisingId", "shouldLoadUserProfile", "startFromService", "intent", "Landroid/content/Intent;", "startGeofence", "list", "", "startTracking", "stopGeofence", "stopTracking", "updateBirthday", "updateGender", "writeLog", "message", "Companion", "ConnectResult", "Holder", "LogoutResult", "SilentLogOperationListener", "SilentLogStepsListener", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogOperation */
public final class SilentLogOperation {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Lazy f819c = LazyKt__LazyJVMKt.lazy(C1067a.f824a);

    /* renamed from: a */
    private final int f820a;

    /* renamed from: b */
    private final RFLSilentLogOperation f821b;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$Companion;", "", "()V", "instance", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation;", "getInstance", "()Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation;", "instance$delegate", "Lkotlin/Lazy;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogOperation$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SilentLogOperation getInstance() {
            Lazy access$getInstance$cp = SilentLogOperation.f819c;
            Companion companion = SilentLogOperation.Companion;
            return (SilentLogOperation) access$getInstance$cp.getValue();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$ConnectResult;", "", "(Ljava/lang/String;I)V", "Success", "FailCreate", "FailLogin", "FailRestricted", "FailUnknown", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogOperation$ConnectResult */
    public enum ConnectResult {
        Success,
        FailCreate,
        FailLogin,
        FailRestricted,
        FailUnknown
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$LogoutResult;", "", "(Ljava/lang/String;I)V", "Success", "Fail", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogOperation$LogoutResult */
    public enum LogoutResult {
        Success,
        Fail
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0017"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$SilentLogOperationListener;", "", "resultForConnectApi", "", "result", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$ConnectResult;", "userId", "", "resultForLoadDailyBackground", "daily", "date", "Ljava/util/Date;", "resultForLoadUserProfile", "success", "", "resultForLogoutApi", "Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$LogoutResult;", "resultForTransportPrediction", "resultForUpdateBirthday", "birthday", "resultForUpdateGender", "gender", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogOperation$SilentLogOperationListener */
    public interface SilentLogOperationListener {
        void resultForConnectApi(ConnectResult connectResult, String str);

        void resultForLoadDailyBackground(String str, Date date);

        void resultForLoadUserProfile(boolean z);

        void resultForLogoutApi(LogoutResult logoutResult);

        void resultForTransportPrediction(String str);

        void resultForUpdateBirthday(boolean z, Date date);

        void resultForUpdateGender(boolean z, int i);
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/SilentLogOperation$SilentLogStepsListener;", "", "resultTodaySteps", "", "isSuccess", "", "steps", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogOperation$SilentLogStepsListener */
    public interface SilentLogStepsListener {
        void resultTodaySteps(boolean z, int i);
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogOperation$a */
    static final class C1067a extends Lambda implements Function0<SilentLogOperation> {

        /* renamed from: a */
        public static final C1067a f824a = new C1067a();

        C1067a() {
            super(0);
        }

        public final SilentLogOperation invoke() {
            return C1068b.f826b.mo21601a();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.SilentLogOperation$b */
    private static final class C1068b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a */
        private static final SilentLogOperation f825a = new SilentLogOperation((DefaultConstructorMarker) null);

        /* renamed from: b */
        public static final C1068b f826b = new C1068b();

        private C1068b() {
        }

        /* renamed from: a */
        public final SilentLogOperation mo21601a() {
            return f825a;
        }
    }

    private SilentLogOperation() {
        this.f820a = 15540;
        this.f821b = new RFLSilentLogOperation();
    }

    public /* synthetic */ SilentLogOperation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ void connectApi$default(SilentLogOperation silentLogOperation, String str, Integer num, Date date, Map map, int i, Object obj) {
        if ((i & 8) != 0) {
            map = null;
        }
        silentLogOperation.connectApi(str, num, date, map);
    }

    public static /* synthetic */ void loadUserProfile$default(SilentLogOperation silentLogOperation, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        silentLogOperation.loadUserProfile(z);
    }

    public final void build(Context context, SilentLogOperationListener silentLogOperationListener, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(silentLogOperationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkParameterIsNotNull(str, "clientId");
        Intrinsics.checkParameterIsNotNull(str2, "clientSecret");
        this.f821b.build$silentlogsdkandroid_release(context, silentLogOperationListener, str, str2, false);
    }

    public final void connectApi(String str, Integer num, Date date, Map<String, ? extends Object> map) {
        this.f821b.connectApi$silentlogsdkandroid_release(str, num, date, map);
    }

    public final void connectGoogleFitClient() {
        this.f821b.connectGoogleFitClient$silentlogsdkandroid_release();
    }

    public final void createInternalOperation(Context context, SilentLogInternalOperation.SilentLogInternalOperationListener silentLogInternalOperationListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(silentLogInternalOperationListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f821b.createInternalOperation$silentlogsdkandroid_release(context, silentLogInternalOperationListener);
    }

    public final void enableTransportPrediction(boolean z) {
        this.f821b.enableTransportPrediction$silentlogsdkandroid_release(z);
    }

    public final void entryCampaignAsync(int i) {
        this.f821b.entryCampaignAsync$silentlogsdkandroid_release(i);
    }

    public final Date getBirthDay() {
        return this.f821b.getBirthDay$silentlogsdkandroid_release();
    }

    public final void getCampaign(SilentLogAdListener.OnCompletedGetCampaign onCompletedGetCampaign) {
        Intrinsics.checkParameterIsNotNull(onCompletedGetCampaign, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f821b.getCampaign$silentlogsdkandroid_release(onCompletedGetCampaign);
    }

    public final C1714r<String> getDataFor(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        return this.f821b.loadDailyFromDate$silentlogsdkandroid_release(date);
    }

    public final C1714r<Boolean> getDataWithTagFor(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        return this.f821b.loadDailyWithTag$silentlogsdkandroid_release(date);
    }

    public final int getEntryType() {
        return this.f821b.getEntryType$silentlogsdkandroid_release();
    }

    public final String getExtraUserId() {
        return this.f821b.getExtraUserId$silentlogsdkandroid_release();
    }

    public final int getGender() {
        return this.f821b.getGender$silentlogsdkandroid_release();
    }

    public final Date getInstallDate() {
        return this.f821b.getInstallDate();
    }

    public final SilentLogInternalOperation getInternalOperation() {
        SilentLogInternalOperation internalOperation = this.f821b.getInternalOperation();
        if (internalOperation != null) {
            return internalOperation;
        }
        throw new UnsupportedOperationException("permission denied");
    }

    public final int getSILENT_LOG_SDK_GPS_PERMISSION() {
        return this.f820a;
    }

    public final String getSilentLogUserId() {
        return this.f821b.getSilentLogUserId$silentlogsdkandroid_release();
    }

    public final void getTodayStepCountByGoogleFit(SilentLogStepsListener silentLogStepsListener) {
        Intrinsics.checkParameterIsNotNull(silentLogStepsListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f821b.getTodayStepCountByGoogleFit$silentlogsdkandroid_release(silentLogStepsListener);
    }

    public final boolean hasAuth() {
        return this.f821b.hasAuth$silentlogsdkandroid_release();
    }

    public final boolean isEntryCampaign() {
        return this.f821b.isEntryCampaign$silentlogsdkandroid_release();
    }

    public final boolean isLogin() {
        return this.f821b.isLogin$silentlogsdkandroid_release();
    }

    public final boolean isMilePointAuth() {
        return this.f821b.isMilePointAuth$silentlogsdkandroid_release();
    }

    public final boolean isRegistLogin() {
        return this.f821b.isRegistLogin$silentlogsdkandroid_release();
    }

    public final Location loadLocation() {
        return this.f821b.loadLocation$silentlogsdkandroid_release();
    }

    public final void loadUserProfile(boolean z) {
        this.f821b.loadUserProfileIfNeed$silentlogsdkandroid_release(z);
    }

    public final void logoutApi() {
        this.f821b.logoutApi$silentlogsdkandroid_release();
    }

    public final void onStart() {
        this.f821b.onStart$silentlogsdkandroid_release();
    }

    public final void permissionResult(int i, int i2) {
        this.f821b.permissionResult$silentlogsdkandroid_release(i, i2);
    }

    public final void registerRemoteToken(String str) {
        Intrinsics.checkParameterIsNotNull(str, "tokenString");
        this.f821b.registerRemoteToken$silentlogsdkandroid_release(str);
    }

    public final C1714r<LogoutResult> release() {
        return this.f821b.release$silentlogsdkandroid_release();
    }

    public final C1696b releaseWithoutLogout() {
        return this.f821b.releaseWithoutLogout$silentlogsdkandroid_release();
    }

    public final void responseAd(int i, RFLAdResType rFLAdResType, SilentLogAdListener.OnCompletedResponseAd onCompletedResponseAd) {
        Intrinsics.checkParameterIsNotNull(rFLAdResType, "responseType");
        Intrinsics.checkParameterIsNotNull(onCompletedResponseAd, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f821b.responseAd$silentlogsdkandroid_release(i, rFLAdResType, onCompletedResponseAd);
    }

    public final void saveActivityTag(String str, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "activityTag");
        this.f821b.saveActivityTag$silentlogsdkandroid_release(str, i, i2);
    }

    public final void savePointSystemKey(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pointSystemKey");
        this.f821b.savePointSystemKey$silentlogsdkandroid_release(str);
    }

    public final void setBaseUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "baseUrl");
        this.f821b.setBaseUrl$silentlogsdkandroid_release(str);
    }

    public final void setJapanOnly(boolean z) {
        this.f821b.setJapanOnly(z);
    }

    public final void setPointUrl(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pointUrl");
        this.f821b.setPointUrl$silentlogsdkandroid_release(str);
    }

    public final void setSendPushToken(boolean z) {
        this.f821b.setSendPushToken$silentlogsdkandroid_release(z);
    }

    public final void setServiceName(String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(str, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkParameterIsNotNull(str2, "geofence");
        Intrinsics.checkParameterIsNotNull(str3, "foreground");
        this.f821b.setServiceName$silentlogsdkandroid_release(str, str2, str3);
    }

    public final void setStepPerMinutesPriority(boolean z) {
        this.f821b.setStepPerMinutesPriority$silentlogsdkandroid_release(z);
    }

    public final void setTrackingPriorityType(int i) {
        this.f821b.setTrackingPriorityType$silentlogsdkandroid_release(i);
    }

    public final void setUseAdvertisingId(boolean z) {
        this.f821b.setUseAdvertisingId$silentlogsdkandroid_release(z);
    }

    public final boolean shouldLoadUserProfile() {
        return this.f821b.shouldLoadUserProfile$silentlogsdkandroid_release();
    }

    public final void startFromService(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        this.f821b.startFromService$silentlogsdkandroid_release(intent);
    }

    public final void startGeofence(List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        this.f821b.startGeofence$silentlogsdkandroid_release(list);
    }

    public final void startTracking() {
        this.f821b.startTracking$silentlogsdkandroid_release();
    }

    public final void stopGeofence() {
        this.f821b.stopGeofence$silentlogsdkandroid_release();
    }

    public final void stopTracking() {
        this.f821b.stopTracking$silentlogsdkandroid_release();
    }

    public final void updateBirthday(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "birthday");
        this.f821b.updateBirthday$silentlogsdkandroid_release(date);
    }

    public final void updateGender(int i) {
        this.f821b.updateGender$silentlogsdkandroid_release(i);
    }

    public final void writeLog(String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        this.f821b.writeLog$silentlogsdkandroid_release(str);
    }
}
