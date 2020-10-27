package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.C1126c;
import org.greenrobot.eventbus.C1129m;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.bus.ActiveMode;
import p043jp.reifrontier.silentlogsdkandroid.data.api.RFLH1Client;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdCampaign;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResType;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResult;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrackingType;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrigger;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTriggerType;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.CalendarExKt;
import p048l.p049a.C1122a;
import p078g.p079a.C1714r;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;
import p078g.p079a.p100z.C1741d;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010%2\f\u00103\u001a\b\u0012\u0004\u0012\u00020%0-J\u0016\u00104\u001a\u00020\u00122\f\u00103\u001a\b\u0012\u0004\u0012\u00020%0-H\u0002J\u001e\u00105\u001a\u0002012\u0006\u00102\u001a\u00020%2\f\u00103\u001a\b\u0012\u0004\u0012\u00020%0-H\u0002J\u0012\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080-07J\u001e\u00109\u001a\u0002012\u0006\u00102\u001a\u00020%2\f\u00103\u001a\b\u0012\u0004\u0012\u00020%0-H\u0003J\u0006\u0010:\u001a\u000201J \u0010;\u001a\u00020\"2\u0006\u00102\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020)H\u0002J\u0010\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\u0012H\u0002J\u0010\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020BH\u0007J\u001a\u0010C\u001a\u0002012\u0006\u0010D\u001a\u00020E2\b\u00102\u001a\u0004\u0018\u00010%H\u0003J\u0018\u0010F\u001a\u0002012\u0006\u0010?\u001a\u00020\u00122\u0006\u00102\u001a\u00020%H\u0003J\u001a\u0010G\u001a\u0002012\u0006\u0010D\u001a\u00020E2\b\u0010<\u001a\u0004\u0018\u00010%H\u0007J\u0016\u0010H\u001a\u00020)2\f\u00103\u001a\b\u0012\u0004\u0012\u00020%0-H\u0002J\b\u0010I\u001a\u000201H\u0002J\b\u0010J\u001a\u000201H\u0002J&\u0010K\u001a\b\u0012\u0004\u0012\u00020\u0012072\u0006\u0010L\u001a\u00020\u00122\u0006\u0010M\u001a\u00020N2\b\u00102\u001a\u0004\u0018\u00010%J\u0006\u0010O\u001a\u000201J\u0006\u0010P\u001a\u000201J\b\u0010Q\u001a\u000201H\u0002J\u001e\u0010R\u001a\u0002012\u0006\u00102\u001a\u00020%2\f\u00103\u001a\b\u0012\u0004\u0012\u00020%0-H\u0002J\u0010\u0010S\u001a\u0002012\u0006\u00102\u001a\u00020%H\u0002J\f\u0010T\u001a\u00020\u0012*\u00020UH\u0002R\u001e\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-X\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdManager;", "", "clientContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "accountManager", "Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "getAccountManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "setAccountManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;)V", "beaconManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManager;", "getBeaconManager$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManager;", "setBeaconManager$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLBeaconManager;)V", "countForSkipLocation", "", "eventBus", "Lorg/greenrobot/eventbus/EventBus;", "getEventBus$silentlogsdkandroid_release", "()Lorg/greenrobot/eventbus/EventBus;", "setEventBus$silentlogsdkandroid_release", "(Lorg/greenrobot/eventbus/EventBus;)V", "getTriggersTime", "Ljava/util/Calendar;", "h1Client", "Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "getH1Client$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;", "setH1Client$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/data/api/RFLH1Client;)V", "isActiveMode", "", "isSendingPostCover", "locationHitEstimateMove", "Landroid/location/Location;", "locationHitTarget", "postCoverFailTime", "radiusForEstimateMove", "", "shouldCancelCheckTrigger", "totalCountForSkipLocation", "triggers", "", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrigger;", "triggersInEstimateMove", "checkTriggerIfNeeded", "", "location", "locationUpdatesArray", "countBetweenLatestWithPreviousLocation", "estimateMoveRangeHighSpeed", "getCampaign", "Lio/reactivex/Single;", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdCampaign;", "getTriggers", "initLocationUpdates", "isInsideLocation", "currentLocation", "radius", "onEnterAdTrigger", "triggerId", "onReceiveActiveMode", "activeMode", "Ljp/reifrontier/silentlogsdkandroid/bus/ActiveMode;", "postAdTracking", "trackingType", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrackingType;", "postCover", "postTracking", "radiusForEstimateMoveRange", "registerEventBus", "resetAdSettings", "responseAd", "campId", "responseType", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResType;", "start", "stop", "unregisterEventBus", "updateEstimateMoveRangeIfNeed", "updateTargetRangeIfNeed", "toSeconds", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager */
public final class RFLAdManager {

    /* renamed from: a */
    private boolean f827a;
    public RFLAccountManager accountManager;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Calendar f828b;
    public RFLBeaconManager beaconManager;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Calendar f829c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f830d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f831e;
    public C1126c eventBus;

    /* renamed from: f */
    private int f832f;

    /* renamed from: g */
    private int f833g;

    /* renamed from: h */
    private Location f834h;
    public RFLH1Client h1Client;

    /* renamed from: i */
    private Location f835i;

    /* renamed from: j */
    private float f836j;

    /* renamed from: k */
    private List<RFLAdTrigger> f837k = CollectionsKt__CollectionsKt.emptyList();
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<RFLAdTrigger> f838l = CollectionsKt__CollectionsKt.emptyList();

    /* renamed from: m */
    private final Context f839m;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$a */
    static final class C1069a extends Lambda implements Function1<Integer, Unit> {

        /* renamed from: a */
        final /* synthetic */ RFLAdManager f840a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1069a(RFLAdManager rFLAdManager) {
            super(1);
            this.f840a = rFLAdManager;
        }

        /* renamed from: a */
        public final void mo21618a(int i) {
            this.f840a.m1451a(i);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo21618a(((Number) obj).intValue());
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$b */
    static final class C1070b<T, R> implements C1742e<T, R> {

        /* renamed from: a */
        public static final C1070b f841a = new C1070b();

        C1070b() {
        }

        /* renamed from: a */
        public final List<RFLAdCampaign> apply(RFLH1Client.APIResponse aPIResponse) {
            Intrinsics.checkParameterIsNotNull(aPIResponse, "apiResponse");
            if (aPIResponse.getCode() != 200) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            Object data = aPIResponse.getData();
            if (data != null) {
                return (List) data;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdCampaign>");
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$c */
    static final class C1071c<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLAdManager f842a;

        /* renamed from: b */
        final /* synthetic */ Location f843b;

        /* renamed from: c */
        final /* synthetic */ List f844c;

        C1071c(RFLAdManager rFLAdManager, Location location, List list) {
            this.f842a = rFLAdManager;
            this.f843b = location;
            this.f844c = list;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            if (aPIResponse.getCode() == 200) {
                RFLAdManager rFLAdManager = this.f842a;
                Object data = aPIResponse.getData();
                if (data != null) {
                    rFLAdManager.f838l = (List) data;
                    this.f842a.m1461c(this.f843b, this.f844c);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger>");
            }
            this.f842a.f828b = null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$d */
    static final class C1072d<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ RFLAdManager f845a;

        C1072d(RFLAdManager rFLAdManager) {
            this.f845a = rFLAdManager;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("GET ad/trigger error=, message=", th, "error")), new Object[0]);
            this.f845a.f828b = null;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$e */
    static final class C1073e<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        public static final C1073e f846a = new C1073e();

        C1073e() {
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            if (aPIResponse.getCode() == 200) {
                Object data = aPIResponse.getData();
                if (data != null) {
                    RFLAdResult rFLAdResult = (RFLAdResult) data;
                    if (rFLAdResult.getResult() == 800) {
                        StringBuilder a = C0681a.m330a("POST ad/tracking success=");
                        a.append(rFLAdResult.getResult());
                        C1122a.m1596a(a.toString(), new Object[0]);
                        return;
                    }
                    StringBuilder a2 = C0681a.m330a("[SilentLog]::Error API POST ad/tracking error=");
                    a2.append(rFLAdResult.getResult());
                    a2.append(", message=");
                    a2.append(rFLAdResult.getMessage());
                    C1122a.m1599b(a2.toString(), new Object[0]);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdResult");
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$f */
    static final class C1074f<T> implements C1741d<Throwable> {

        /* renamed from: a */
        public static final C1074f f847a = new C1074f();

        C1074f() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLog]::Error POST ad/tracking error=, message=", th, "error")), new Object[0]);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$g */
    static final class C1075g<T> implements C1741d<RFLH1Client.APIResponse> {

        /* renamed from: a */
        final /* synthetic */ RFLAdManager f848a;

        C1075g(RFLAdManager rFLAdManager) {
            this.f848a = rFLAdManager;
        }

        /* renamed from: a */
        public final void accept(RFLH1Client.APIResponse aPIResponse) {
            this.f848a.f830d = false;
            if (aPIResponse.getCode() != 200) {
                this.f848a.f831e = true;
                return;
            }
            Object data = aPIResponse.getData();
            if (data != null) {
                RFLAdResult rFLAdResult = (RFLAdResult) data;
                if (rFLAdResult.getResult() >= 900) {
                    StringBuilder a = C0681a.m330a("[SilentLog]::Error(");
                    a.append(rFLAdResult.getResult());
                    a.append(") ");
                    a.append(rFLAdResult.getMessage());
                    C1122a.m1599b(a.toString(), new Object[0]);
                    if (rFLAdResult.getResult() == 900) {
                        this.f848a.f829c = Calendar.getInstance();
                        return;
                    }
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdResult");
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$h */
    static final class C1076h<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ RFLAdManager f849a;

        C1076h(RFLAdManager rFLAdManager) {
            this.f849a = rFLAdManager;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f849a.f830d = false;
            this.f849a.f831e = true;
            StringBuilder sb = new StringBuilder();
            sb.append("[SilentLog]::Error API POST ad/cover ");
            Intrinsics.checkExpressionValueIsNotNull(th, "error");
            C1122a.m1599b(C0681a.m326a(th, sb), new Object[0]);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$i */
    static final class C1077i<TResult> implements OnCompleteListener<Location> {

        /* renamed from: a */
        final /* synthetic */ RFLAdManager f850a;

        /* renamed from: b */
        final /* synthetic */ RFLAdTrackingType f851b;

        /* renamed from: c */
        final /* synthetic */ Location f852c;

        C1077i(RFLAdManager rFLAdManager, RFLAdTrackingType rFLAdTrackingType, Location location) {
            this.f850a = rFLAdManager;
            this.f851b = rFLAdTrackingType;
            this.f852c = location;
        }

        public final void onComplete(Task<Location> task) {
            Intrinsics.checkParameterIsNotNull(task, "task");
            if (task.isSuccessful()) {
                this.f850a.m1455a(this.f851b, task.getResult());
            } else {
                this.f850a.m1455a(this.f851b, this.f852c);
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$j */
    static final class C1078j implements OnFailureListener {

        /* renamed from: a */
        final /* synthetic */ RFLAdManager f853a;

        /* renamed from: b */
        final /* synthetic */ RFLAdTrackingType f854b;

        /* renamed from: c */
        final /* synthetic */ Location f855c;

        C1078j(RFLAdManager rFLAdManager, RFLAdTrackingType rFLAdTrackingType, Location location) {
            this.f853a = rFLAdManager;
            this.f854b = rFLAdTrackingType;
            this.f855c = location;
        }

        public final void onFailure(Exception exc) {
            Intrinsics.checkParameterIsNotNull(exc, "it");
            this.f853a.m1455a(this.f854b, this.f855c);
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$k */
    static final class C1079k<T, R> implements C1742e<T, R> {

        /* renamed from: a */
        public static final C1079k f856a = new C1079k();

        C1079k() {
        }

        /* renamed from: a */
        public final int mo21626a(RFLH1Client.APIResponse aPIResponse) {
            Intrinsics.checkParameterIsNotNull(aPIResponse, "apiResponse");
            if (aPIResponse.getCode() != 200) {
                return -1;
            }
            Object data = aPIResponse.getData();
            if (data != null) {
                RFLAdResult rFLAdResult = (RFLAdResult) data;
                if (rFLAdResult.getResult() > 800) {
                    StringBuilder a = C0681a.m330a("[SilentLogSDK] Error:: ad/response API result=");
                    a.append(rFLAdResult.getResult());
                    a.append(" message=");
                    a.append(rFLAdResult.getMessage());
                    C1122a.m1599b(a.toString(), new Object[0]);
                }
                return rFLAdResult.getResult();
            }
            throw new TypeCastException("null cannot be cast to non-null type jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdResult");
        }

        public /* bridge */ /* synthetic */ Object apply(Object obj) {
            return Integer.valueOf(mo21626a((RFLH1Client.APIResponse) obj));
        }
    }

    public RFLAdManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "clientContext");
        this.f839m = context;
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
        RFLBeaconManager rFLBeaconManager = this.beaconManager;
        if (rFLBeaconManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beaconManager");
        }
        rFLBeaconManager.setOnEnterAdTrigger(new C1069a(this));
    }

    /* renamed from: a */
    private final int m1448a(long j) {
        return (int) (j / ((long) 1000));
    }

    /* renamed from: a */
    private final int m1449a(List<? extends Location> list) {
        if (list.size() < 2) {
            return 0;
        }
        double distanceTo = (double) ((Location) list.get(list.size() - 2)).distanceTo((Location) CollectionsKt___CollectionsKt.last(list));
        Double.isNaN(distanceTo);
        double d = (double) 2;
        Double.isNaN(d);
        int i = (int) ((3000.0d / distanceTo) / d);
        if (i < 0) {
            return 0;
        }
        if (i > 15) {
            return 15;
        }
        return i;
    }

    /* renamed from: a */
    private final void m1450a() {
        m1460c();
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        cVar.mo21907b(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m1451a(int i) {
        T t;
        boolean z;
        Location location = this.f834h;
        if (location != null) {
            Iterator<T> it = this.f837k.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                t = it.next();
                if (((RFLAdTrigger) t).getTriggerId() == i) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            RFLAdTrigger rFLAdTrigger = (RFLAdTrigger) t;
            if (rFLAdTrigger != null) {
                m1452a(rFLAdTrigger.getTriggerId(), location);
            }
        }
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    private final void m1452a(int i, Location location) {
        if (!this.f830d) {
            this.f830d = true;
            this.f828b = null;
            m1458b();
            RFLH1Client rFLH1Client = this.h1Client;
            if (rFLH1Client == null) {
                Intrinsics.throwUninitializedPropertyAccessException("h1Client");
            }
            rFLH1Client.postAdCover(i, location.getLatitude(), location.getLongitude()).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C1075g(this), new C1076h(this));
        }
    }

    /* renamed from: a */
    private final void m1453a(Location location) {
        if (!this.f837k.isEmpty()) {
            Location location2 = this.f834h;
            if (location2 != null ? !m1456a(location2, location, 100.0f) : true) {
                this.f834h = location;
                C1122a.m1596a("Update Target Range ---------------------------------------", new Object[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("current::");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLatitude())}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                sb.append(format);
                sb.append(", ");
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLongitude())}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
                sb.append(format2);
                C1122a.m1596a(sb.toString(), new Object[0]);
                RFLBeaconManager rFLBeaconManager = this.beaconManager;
                if (rFLBeaconManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("beaconManager");
                }
                rFLBeaconManager.stopAllMonitoring();
                if (!this.f837k.isEmpty()) {
                    for (RFLAdTrigger next : this.f837k) {
                        Location location3 = new Location("silentlog-ad-trigger");
                        location3.setLatitude(next.getLat());
                        location3.setLongitude(next.getLon());
                        if (m1456a(location3, location, 100.0f)) {
                            if (RFLAdTriggerType.Companion.getType(next.getTriggerType()) == RFLAdTriggerType.BEACON) {
                                RFLBeaconManager rFLBeaconManager2 = this.beaconManager;
                                if (rFLBeaconManager2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("beaconManager");
                                }
                                rFLBeaconManager2.startMonitoring(next);
                            } else {
                                m1452a(next.getTriggerId(), location);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private final void m1454a(Location location, List<? extends Location> list) {
        int a = m1449a(list);
        this.f832f = a;
        this.f835i = null;
        this.f836j = 0.0f;
        this.f833g += a;
        C1122a.m1596a("Update Estimate Move Range  ====  High Speed!! ----------------------------", new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("current::");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLatitude())}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        sb.append(format);
        sb.append(", ");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%.4f", Arrays.copyOf(new Object[]{Double.valueOf(location.getLongitude())}, 1));
        Intrinsics.checkExpressionValueIsNotNull(format2, "java.lang.String.format(format, *args)");
        sb.append(format2);
        C1122a.m1596a(sb.toString(), new Object[0]);
        C1122a.m1596a("countCalcIgnore == " + this.f832f, new Object[0]);
        if (this.f833g > 30) {
            StringBuilder a2 = C0681a.m330a("Reset get-trigger time, totalCountCalcIgnore == ");
            a2.append(this.f833g);
            C1122a.m1596a(a2.toString(), new Object[0]);
            this.f828b = null;
            this.f833g = 0;
        }
        C1122a.m1596a("------------------------------------------------------", new Object[0]);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    /* renamed from: a */
    public final void m1455a(RFLAdTrackingType rFLAdTrackingType, Location location) {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        if (rFLAccountManager.isAdEntry$silentlogsdkandroid_release()) {
            double d = 0.0d;
            double latitude = location != null ? location.getLatitude() : 0.0d;
            if (location != null) {
                d = location.getLongitude();
            }
            double d2 = d;
            RFLH1Client rFLH1Client = this.h1Client;
            if (rFLH1Client == null) {
                Intrinsics.throwUninitializedPropertyAccessException("h1Client");
            }
            rFLH1Client.postAdTracking(rFLAdTrackingType, latitude, d2).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(C1073e.f846a, C1074f.f847a);
        }
    }

    /* renamed from: a */
    private final boolean m1456a(Location location, Location location2, float f) {
        return location2.distanceTo(location) <= f;
    }

    /* renamed from: b */
    private final float m1457b(List<? extends Location> list) {
        if (list.size() < 2) {
            return 0.0f;
        }
        Location location = (Location) CollectionsKt___CollectionsKt.first(list);
        Location location2 = (Location) CollectionsKt___CollectionsKt.last(list);
        float distanceTo = location.distanceTo(location2) / ((float) (m1448a(location2.getTime()) - m1448a(location.getTime())));
        float f = ((float) 600) * distanceTo;
        if (((double) distanceTo) > 1.0d) {
            return f;
        }
        return 300.0f;
    }

    /* renamed from: b */
    private final void m1458b() {
        this.f832f = 0;
        this.f833g = 0;
        this.f837k = CollectionsKt__CollectionsKt.emptyList();
        this.f835i = null;
        this.f834h = null;
        this.f836j = 0.0f;
        this.f838l = CollectionsKt__CollectionsKt.emptyList();
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: b */
    private final void m1459b(Location location, List<? extends Location> list) {
        this.f828b = Calendar.getInstance();
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        rFLH1Client.getAdTrigger(location.getLatitude(), location.getLongitude()).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new C1071c(this, location, list), new C1072d(this));
    }

    /* renamed from: c */
    private final void m1460c() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        cVar.mo21908c(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1461c(android.location.Location r20, java.util.List<? extends android.location.Location> r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            android.location.Location r2 = r0.f835i
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x001c
            float r5 = r0.f836j
            r6 = 1133871104(0x43958000, float:299.0)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x001c
            boolean r2 = r0.m1456a(r2, r1, r5)
            if (r2 != 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r2 = 0
            goto L_0x001d
        L_0x001c:
            r2 = 1
        L_0x001d:
            if (r2 != 0) goto L_0x0023
            r19.m1453a((android.location.Location) r20)
            return
        L_0x0023:
            int r2 = r21.size()
            if (r2 > r3) goto L_0x002a
            return
        L_0x002a:
            r2 = r21
            float r5 = r0.m1457b(r2)
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r0.f837k = r6
            r0.f835i = r1
            r0.f836j = r5
            r6 = 0
            r0.f834h = r6
            r6 = 1161527296(0x453b8000, float:3000.0)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0048
            r19.m1454a((android.location.Location) r20, (java.util.List<? extends android.location.Location>) r21)
            return
        L_0x0048:
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r6 = "Update Estimate Move Range ----------------------------"
            p048l.p049a.C1122a.m1596a(r6, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "current::"
            r2.append(r6)
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r6 = new java.lang.Object[r3]
            double r7 = r20.getLatitude()
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r6[r4] = r7
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r3)
            java.lang.String r7 = "%.4f"
            java.lang.String r6 = java.lang.String.format(r7, r6)
            java.lang.String r8 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r8)
            r2.append(r6)
            java.lang.String r6 = ", "
            r2.append(r6)
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.Object[] r6 = new java.lang.Object[r3]
            double r9 = r20.getLongitude()
            java.lang.Double r9 = java.lang.Double.valueOf(r9)
            r6[r4] = r9
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r3)
            java.lang.String r6 = java.lang.String.format(r7, r6)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r8)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            p048l.p049a.C1122a.m1596a(r2, r6)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "radius::"
            r2.append(r6)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            p048l.p049a.C1122a.m1596a(r2, r6)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List<jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger> r6 = r0.f838l
            java.util.Iterator r6 = r6.iterator()
        L_0x00c4:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0112
            java.lang.Object r7 = r6.next()
            r8 = r7
            jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger r8 = (p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrigger) r8
            android.location.Location r7 = r8.getLocation()
            float r16 = r7.distanceTo(r1)
            int r7 = (r16 > r5 ? 1 : (r16 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x00df
            r7 = 1
            goto L_0x00e0
        L_0x00df:
            r7 = 0
        L_0x00e0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = r8.getDumpMessage()
            r9.append(r10)
            java.lang.String r10 = " estimateInside:"
            r9.append(r10)
            r9.append(r7)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r10 = new java.lang.Object[r4]
            p048l.p049a.C1122a.m1596a(r9, r10)
            if (r7 == 0) goto L_0x00c4
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r17 = 31
            r18 = 0
            jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger r7 = p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrigger.copy$default(r8, r9, r10, r11, r12, r14, r16, r17, r18)
            r2.add(r7)
            goto L_0x00c4
        L_0x0112:
            boolean r5 = r2.isEmpty()
            r3 = r3 ^ r5
            if (r3 == 0) goto L_0x0128
            jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$updateEstimateMoveRangeIfNeed$$inlined$sortedByDescending$1 r3 = new jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager$updateEstimateMoveRangeIfNeed$$inlined$sortedByDescending$1
            r3.<init>()
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r2, r3)
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r2)
            r0.f837k = r2
        L_0x0128:
            boolean r2 = r0.f831e
            if (r2 == 0) goto L_0x013b
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r3 = "[SilentLogSDK]::Error cancel check trigger for this range"
            p048l.p049a.C1122a.m1599b(r3, r2)
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
            r0.f837k = r2
            r0.f831e = r4
        L_0x013b:
            java.lang.String r2 = "Triggers in Estimate Move Range count::"
            java.lang.StringBuilder r2 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r2)
            java.util.List<jp.reifrontier.silentlogsdkandroid.domain.ad.RFLAdTrigger> r3 = r0.f837k
            int r3 = r3.size()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r4]
            p048l.p049a.C1122a.m1596a(r2, r3)
            java.lang.Object[] r2 = new java.lang.Object[r4]
            java.lang.String r3 = "------------------------------------------------------"
            p048l.p049a.C1122a.m1596a(r3, r2)
            r19.m1453a((android.location.Location) r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p043jp.reifrontier.silentlogsdkandroid.daily.RFLAdManager.m1461c(android.location.Location, java.util.List):void");
    }

    public final void checkTriggerIfNeeded(Location location, List<? extends Location> list) {
        Intrinsics.checkParameterIsNotNull(list, "locationUpdatesArray");
        if (location != null) {
            RFLBeaconManager rFLBeaconManager = this.beaconManager;
            if (rFLBeaconManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("beaconManager");
            }
            rFLBeaconManager.stopAllMonitoring();
            if (this.f827a) {
                RFLAccountManager rFLAccountManager = this.accountManager;
                if (rFLAccountManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("accountManager");
                }
                if (rFLAccountManager.isLogin() && RFLSharedHolder.INSTANCE.adEntryType() > 0) {
                    Calendar calendar = this.f829c;
                    if (calendar != null) {
                        Calendar instance = Calendar.getInstance();
                        Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
                        if (CalendarExKt.isSameDay(calendar, instance)) {
                            C1122a.m1599b("[SilentLogSDK]::Error detect limit", new Object[0]);
                            return;
                        }
                    }
                    this.f829c = null;
                    if (!this.f830d) {
                        int i = this.f832f;
                        if (i > 0) {
                            this.f832f = i - 1;
                            return;
                        }
                        Calendar instance2 = Calendar.getInstance();
                        if (this.f828b != null) {
                            Intrinsics.checkExpressionValueIsNotNull(instance2, "now");
                            Calendar calendar2 = this.f828b;
                            if (calendar2 == null) {
                                Intrinsics.throwNpe();
                            }
                            if (CalendarExKt.diffSeconds(instance2, calendar2) <= 3600) {
                                m1461c(location, list);
                                return;
                            }
                        }
                        m1459b(location, list);
                    }
                }
            }
        }
    }

    public final RFLAccountManager getAccountManager$silentlogsdkandroid_release() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager;
    }

    public final RFLBeaconManager getBeaconManager$silentlogsdkandroid_release() {
        RFLBeaconManager rFLBeaconManager = this.beaconManager;
        if (rFLBeaconManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beaconManager");
        }
        return rFLBeaconManager;
    }

    public final C1714r<List<RFLAdCampaign>> getCampaign() {
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        C1714r<R> b = rFLH1Client.getAdCampaign().mo27434b(C1683a.m2378b()).mo27435b(C1070b.f841a);
        Intrinsics.checkExpressionValueIsNotNull(b, "h1Client.getAdCampaign()…      }\n                }");
        return b;
    }

    public final C1126c getEventBus$silentlogsdkandroid_release() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        return cVar;
    }

    public final RFLH1Client getH1Client$silentlogsdkandroid_release() {
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        return rFLH1Client;
    }

    public final void initLocationUpdates() {
        RFLBeaconManager rFLBeaconManager = this.beaconManager;
        if (rFLBeaconManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beaconManager");
        }
        rFLBeaconManager.stopAllMonitoring();
        this.f837k = CollectionsKt__CollectionsKt.emptyList();
        this.f832f = 0;
        this.f833g = 0;
        this.f831e = false;
    }

    @C1129m
    public final void onReceiveActiveMode(ActiveMode activeMode) {
        Intrinsics.checkParameterIsNotNull(activeMode, "activeMode");
        boolean active = activeMode.getActive();
        this.f827a = active;
        if (active && this.f838l.isEmpty()) {
            this.f828b = null;
            this.f832f = 0;
            this.f833g = 0;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void postTracking(RFLAdTrackingType rFLAdTrackingType, Location location) {
        Intrinsics.checkParameterIsNotNull(rFLAdTrackingType, "trackingType");
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.f839m);
        Intrinsics.checkExpressionValueIsNotNull(fusedLocationProviderClient, "LocationServices.getFuse…iderClient(clientContext)");
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new C1077i(this, rFLAdTrackingType, location)).addOnFailureListener(new C1078j(this, rFLAdTrackingType, location));
        m1458b();
        if (rFLAdTrackingType == RFLAdTrackingType.START) {
            this.f828b = null;
        }
    }

    public final C1714r<Integer> responseAd(int i, RFLAdResType rFLAdResType, Location location) {
        Intrinsics.checkParameterIsNotNull(rFLAdResType, "responseType");
        double d = 0.0d;
        double latitude = location != null ? location.getLatitude() : 0.0d;
        if (location != null) {
            d = location.getLongitude();
        }
        double d2 = d;
        RFLH1Client rFLH1Client = this.h1Client;
        if (rFLH1Client == null) {
            Intrinsics.throwUninitializedPropertyAccessException("h1Client");
        }
        C1714r<R> b = rFLH1Client.postAdResponse(i, rFLAdResType, latitude, d2).mo27434b(C1683a.m2378b()).mo27435b(C1079k.f856a);
        Intrinsics.checkExpressionValueIsNotNull(b, "h1Client.postAdResponse(…      }\n                }");
        return b;
    }

    public final void setAccountManager$silentlogsdkandroid_release(RFLAccountManager rFLAccountManager) {
        Intrinsics.checkParameterIsNotNull(rFLAccountManager, "<set-?>");
        this.accountManager = rFLAccountManager;
    }

    public final void setBeaconManager$silentlogsdkandroid_release(RFLBeaconManager rFLBeaconManager) {
        Intrinsics.checkParameterIsNotNull(rFLBeaconManager, "<set-?>");
        this.beaconManager = rFLBeaconManager;
    }

    public final void setEventBus$silentlogsdkandroid_release(C1126c cVar) {
        Intrinsics.checkParameterIsNotNull(cVar, "<set-?>");
        this.eventBus = cVar;
    }

    public final void setH1Client$silentlogsdkandroid_release(RFLH1Client rFLH1Client) {
        Intrinsics.checkParameterIsNotNull(rFLH1Client, "<set-?>");
        this.h1Client = rFLH1Client;
    }

    public final void start() {
        m1450a();
    }

    public final void stop() {
        this.f827a = false;
        RFLBeaconManager rFLBeaconManager = this.beaconManager;
        if (rFLBeaconManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("beaconManager");
        }
        rFLBeaconManager.stopAllMonitoring();
        m1460c();
    }
}
