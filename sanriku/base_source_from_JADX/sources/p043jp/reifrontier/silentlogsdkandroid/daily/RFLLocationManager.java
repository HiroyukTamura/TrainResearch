package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.C1126c;
import org.greenrobot.eventbus.C1129m;
import org.greenrobot.eventbus.ThreadMode;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.account.RFLAccountManager;
import p043jp.reifrontier.silentlogsdkandroid.bus.ActiveMode;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.api.RFLNotificationPoi;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResType;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrackingType;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p043jp.reifrontier.silentlogsdkandroid.utils.LocationExKt;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtils;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p048l.p049a.C1122a;
import p078g.p079a.C1714r;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\r\b\u0000\u0018\u0000 \u00012\u00020\u0001:\u0006\u0001\u0001\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010N\u001a\u0002012\u0006\u0010A\u001a\u00020\u0014H\u0002J\b\u0010O\u001a\u000201H\u0002J\u0010\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH\u0002J\b\u0010T\u001a\u000201H\u0002J\u000e\u0010U\u001a\u0002012\u0006\u0010A\u001a\u00020\u0014J\u0006\u0010V\u001a\u000201J\u000e\u0010W\u001a\u0002012\u0006\u0010A\u001a\u00020\u0014J\u0006\u0010X\u001a\u000201J\u0010\u0010Y\u001a\u00020+2\u0006\u0010Z\u001a\u00020[H\u0002J\b\u0010\\\u001a\u00020QH\u0002J\b\u0010]\u001a\u000201H\u0003J\b\u0010^\u001a\u00020QH\u0002J\b\u0010_\u001a\u00020QH\u0002J\u0012\u0010`\u001a\u0002012\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0010\u0010c\u001a\u0002012\u0006\u0010d\u001a\u00020eH\u0007J\u0014\u0010f\u001a\u0002012\f\u0010g\u001a\b\u0012\u0004\u0012\u00020h0HJ\u0006\u0010i\u001a\u000201J\b\u0010j\u001a\u000201H\u0002J\u001c\u0010k\u001a\b\u0012\u0004\u0012\u00020m0l2\u0006\u0010n\u001a\u00020m2\u0006\u0010o\u001a\u00020pJ\u0016\u0010q\u001a\u0002012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020s0HH\u0002J\u0016\u0010t\u001a\u0002012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020s0HH\u0002J\u0016\u0010u\u001a\u0002012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020s0HH\u0002J\u0016\u0010v\u001a\u0002012\f\u0010r\u001a\b\u0012\u0004\u0012\u00020s0HH\u0002J\b\u0010w\u001a\u00020+H\u0002J\b\u0010x\u001a\u00020+H\u0002J\u0006\u0010y\u001a\u000201J\b\u0010z\u001a\u000201H\u0002J\u0006\u0010{\u001a\u000201J\u0010\u0010|\u001a\u0002012\u0006\u0010A\u001a\u00020\u0014H\u0002J\"\u0010}\u001a\u0002012\u001a\u0010~\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020[\u0012\u0005\u0012\u00030\u00010\u00010J\u0012\u0010\u0001\u001a\u0002012\u0007\u0010\u0001\u001a\u00020MH\u0002J\u0007\u0010\u0001\u001a\u000201J\t\u0010\u0001\u001a\u000201H\u0002J\t\u0010\u0001\u001a\u000201H\u0002J\t\u0010\u0001\u001a\u000201H\u0002J\u0007\u0010\u0001\u001a\u000201J\u0007\u0010\u0001\u001a\u000201J\u0007\u0010\u0001\u001a\u000201R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0000@\u0000X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u00020+8BX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\"\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u00020+2\u0006\u0010\u0013\u001a\u00020+@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u000e\u00108\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u0016\u00109\u001a\u0004\u0018\u00010\u00148@X\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0017R\u0010\u0010;\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000RN\u0010=\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110+¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(B\u0012\u0004\u0012\u000201\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0014\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00140HX\u000e¢\u0006\u0002\n\u0000R\"\u0010I\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00103\"\u0004\bK\u00105R\u000e\u0010L\u001a\u00020MX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager;", "Lcom/google/android/gms/location/LocationCallback;", "clientContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "accountManager", "Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "getAccountManager", "()Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;", "setAccountManager", "(Ljp/reifrontier/silentlogsdkandroid/account/RFLAccountManager;)V", "adManager", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdManager;", "getAdManager", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdManager;", "setAdManager", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdManager;)V", "autoStartHandler", "Landroid/os/Handler;", "<set-?>", "Landroid/location/Location;", "currentLocation", "getCurrentLocation$silentlogsdkandroid_release", "()Landroid/location/Location;", "dailyUtils", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "getDailyUtils$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;", "setDailyUtils$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/utils/RFLDailyUtils;)V", "eventBus", "Lorg/greenrobot/eventbus/EventBus;", "getEventBus", "()Lorg/greenrobot/eventbus/EventBus;", "setEventBus", "(Lorg/greenrobot/eventbus/EventBus;)V", "googleLocationService", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleLocationService;", "getGoogleLocationService$silentlogsdkandroid_release", "()Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleLocationService;", "setGoogleLocationService$silentlogsdkandroid_release", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleLocationService;)V", "hasGrantedLocation", "", "hasServiceClass", "getHasServiceClass", "()Z", "initLocationUpdate", "Lkotlin/Function0;", "", "getInitLocationUpdate$silentlogsdkandroid_release", "()Lkotlin/jvm/functions/Function0;", "setInitLocationUpdate$silentlogsdkandroid_release", "(Lkotlin/jvm/functions/Function0;)V", "isActiveMode", "isActiveMode$silentlogsdkandroid_release", "isClientGeofence", "lastLocation", "getLastLocation$silentlogsdkandroid_release", "locationHandler", "locationStartHandler", "onLocationChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "location", "same", "getOnLocationChange$silentlogsdkandroid_release", "()Lkotlin/jvm/functions/Function2;", "setOnLocationChange$silentlogsdkandroid_release", "(Lkotlin/jvm/functions/Function2;)V", "resentLocationHolder", "", "stopLocation", "getStopLocation$silentlogsdkandroid_release", "setStopLocation$silentlogsdkandroid_release", "trackingAccuracy", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager$RFLTrackingAccuracy;", "addLocationToHolder", "autoStartLocationUpdates", "buildLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "interval", "", "cancelAutoStartLocationUpdateTimer", "checkLocation", "checkPermission", "discriminateActivity", "grantLocation", "grantedPermission", "permission", "", "highUpdates", "initLocationUpdates", "lowUpdates", "middleUpdates", "onLocationResult", "locationResult", "Lcom/google/android/gms/location/LocationResult;", "onReceiveActiveMode", "activeMode", "Ljp/reifrontier/silentlogsdkandroid/bus/ActiveMode;", "registerPOItoFence", "regionNotificationPoi", "Ljp/reifrontier/silentlogsdkandroid/domain/api/RFLNotificationPoi;", "reregisterEventBus", "resetLocationUpdates", "responseAd", "Lio/reactivex/Single;", "", "campId", "responseType", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResType;", "setupGeoFenceCenter", "latlngs", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager$GeofenceLatLng;", "setupGeoFenceClient", "setupGeoFenceCode", "setupGeoFenceEvent", "shouldRestartLocationUpdates", "shouldStopFromLocationHolder", "start", "startAutoStartLocationUpdateTimer", "startGeoFence", "startGeoFenceCenter", "startGeofenceFromClient", "list", "", "", "", "startLocationUpdates", "state", "stop", "stopGeoFenceCenter", "stopGeoFenceClient", "stopGeoFenceCode", "stopGeoFenceEvent", "stopGeofenceFromClient", "stopLocationUpdates", "Companion", "GeofenceLatLng", "RFLTrackingAccuracy", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager */
public final class RFLLocationManager extends LocationCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String GEOFENCE_ID_CENTER_1 = "center1.reifrontier.silentlogsdkandroid";
    public static final String GEOFENCE_ID_CENTER_2 = "center2.reifrontier.silentlogsdkandroid";
    public static final String GEOFENCE_ID_CENTER_3 = "center3.reifrontier.silentlogsdkandroid";
    public static final String GEOFENCE_ID_EAST = "east.reifrontier.silentlogsdkandroid";
    public static final String GEOFENCE_ID_NORTH = "north.reifrontier.silentlogsdkandroid";
    public static final String GEOFENCE_ID_SOUTH = "south.reifrontier.silentlogsdkandroid";
    public static final String GEOFENCE_ID_WEST = "west.reifrontier.silentlogsdkandroid";

    /* renamed from: a */
    private Function2<? super Location, ? super Boolean, Unit> f893a;
    public RFLAccountManager accountManager;
    public RFLAdManager adManager;

    /* renamed from: b */
    private Function0<Unit> f894b;

    /* renamed from: c */
    private Function0<Unit> f895c;

    /* renamed from: d */
    private boolean f896d;
    public RFLDailyUtils dailyUtils;

    /* renamed from: e */
    private List<Location> f897e = new ArrayList();
    public C1126c eventBus;

    /* renamed from: f */
    private Handler f898f;

    /* renamed from: g */
    private Handler f899g;
    public RFLGoogleLocationService googleLocationService;

    /* renamed from: h */
    private Handler f900h;

    /* renamed from: i */
    private boolean f901i;

    /* renamed from: j */
    private boolean f902j;

    /* renamed from: k */
    private Location f903k;

    /* renamed from: l */
    private final Context f904l;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager$Companion;", "", "()V", "AUTO_LOCATION_UPDATE_INTERVAL", "", "EQUATOR_RADIUS", "", "GEOFENCE_ID_CENTER_1", "", "GEOFENCE_ID_CENTER_2", "GEOFENCE_ID_CENTER_3", "GEOFENCE_ID_EAST", "GEOFENCE_ID_NORTH", "GEOFENCE_ID_SOUTH", "GEOFENCE_ID_WEST", "INTERVAL_HIGH", "INTERVAL_LOW", "INTERVAL_MIDDLE", "PENDING_INTENT_GEOFENCE_CODE", "PENDING_INTENT_GEOFENCE_CODE_CENTER", "PENDING_INTENT_GEOFENCE_CODE_CLIENT", "PENDING_INTENT_GEOFENCE_CODE_EVENT", "POLE_RADIUS", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager$GeofenceLatLng;", "", "latitude", "", "longitude", "geoId", "", "rad", "", "transitionTypes", "", "(DDLjava/lang/String;FI)V", "getGeoId", "()Ljava/lang/String;", "getLatitude", "()D", "getLongitude", "getRad", "()F", "getTransitionTypes", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager$GeofenceLatLng */
    public static final class GeofenceLatLng {

        /* renamed from: a */
        private final double f905a;

        /* renamed from: b */
        private final double f906b;

        /* renamed from: c */
        private final String f907c;

        /* renamed from: d */
        private final float f908d;

        /* renamed from: e */
        private final int f909e;

        public GeofenceLatLng(double d, double d2, String str, float f, int i) {
            Intrinsics.checkParameterIsNotNull(str, "geoId");
            this.f905a = d;
            this.f906b = d2;
            this.f907c = str;
            this.f908d = f;
            this.f909e = i;
        }

        public static /* synthetic */ GeofenceLatLng copy$default(GeofenceLatLng geofenceLatLng, double d, double d2, String str, float f, int i, int i2, Object obj) {
            GeofenceLatLng geofenceLatLng2 = geofenceLatLng;
            return geofenceLatLng.copy((i2 & 1) != 0 ? geofenceLatLng2.f905a : d, (i2 & 2) != 0 ? geofenceLatLng2.f906b : d2, (i2 & 4) != 0 ? geofenceLatLng2.f907c : str, (i2 & 8) != 0 ? geofenceLatLng2.f908d : f, (i2 & 16) != 0 ? geofenceLatLng2.f909e : i);
        }

        public final double component1() {
            return this.f905a;
        }

        public final double component2() {
            return this.f906b;
        }

        public final String component3() {
            return this.f907c;
        }

        public final float component4() {
            return this.f908d;
        }

        public final int component5() {
            return this.f909e;
        }

        public final GeofenceLatLng copy(double d, double d2, String str, float f, int i) {
            Intrinsics.checkParameterIsNotNull(str, "geoId");
            return new GeofenceLatLng(d, d2, str, f, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GeofenceLatLng)) {
                return false;
            }
            GeofenceLatLng geofenceLatLng = (GeofenceLatLng) obj;
            return Double.compare(this.f905a, geofenceLatLng.f905a) == 0 && Double.compare(this.f906b, geofenceLatLng.f906b) == 0 && Intrinsics.areEqual((Object) this.f907c, (Object) geofenceLatLng.f907c) && Float.compare(this.f908d, geofenceLatLng.f908d) == 0 && this.f909e == geofenceLatLng.f909e;
        }

        public final String getGeoId() {
            return this.f907c;
        }

        public final double getLatitude() {
            return this.f905a;
        }

        public final double getLongitude() {
            return this.f906b;
        }

        public final float getRad() {
            return this.f908d;
        }

        public final int getTransitionTypes() {
            return this.f909e;
        }

        public int hashCode() {
            int a = ((Double.doubleToLongBits(this.f905a) * 31) + Double.doubleToLongBits(this.f906b)) * 31;
            String str = this.f907c;
            return ((Float.floatToIntBits(this.f908d) + ((a + (str != null ? str.hashCode() : 0)) * 31)) * 31) + this.f909e;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("GeofenceLatLng(latitude=");
            a.append(this.f905a);
            a.append(", longitude=");
            a.append(this.f906b);
            a.append(", geoId=");
            a.append(this.f907c);
            a.append(", rad=");
            a.append(this.f908d);
            a.append(", transitionTypes=");
            return C0681a.m322a(a, this.f909e, ")");
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager$RFLTrackingAccuracy;", "", "(Ljava/lang/String;I)V", "HIGH", "MIDDLE", "LOW", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager$RFLTrackingAccuracy */
    public enum RFLTrackingAccuracy {
        HIGH,
        MIDDLE,
        LOW
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RFLTrackingAccuracy.values().length];
            $EnumSwitchMapping$0 = iArr;
            RFLTrackingAccuracy rFLTrackingAccuracy = RFLTrackingAccuracy.HIGH;
            iArr[0] = 1;
            int[] iArr2 = $EnumSwitchMapping$0;
            RFLTrackingAccuracy rFLTrackingAccuracy2 = RFLTrackingAccuracy.MIDDLE;
            iArr2[1] = 2;
            int[] iArr3 = $EnumSwitchMapping$0;
            RFLTrackingAccuracy rFLTrackingAccuracy3 = RFLTrackingAccuracy.LOW;
            iArr3[2] = 3;
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager$a */
    static final class C1105a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RFLLocationManager f911a;

        C1105a(RFLLocationManager rFLLocationManager) {
            this.f911a = rFLLocationManager;
        }

        public final void run() {
            Function0<Unit> stopLocation$silentlogsdkandroid_release = this.f911a.getStopLocation$silentlogsdkandroid_release();
            if (stopLocation$silentlogsdkandroid_release != null) {
                Unit invoke = stopLocation$silentlogsdkandroid_release.invoke();
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager$b */
    static final class C1106b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RFLLocationManager f912a;

        C1106b(RFLLocationManager rFLLocationManager) {
            this.f912a = rFLLocationManager;
        }

        public final void run() {
            Function0<Unit> stopLocation$silentlogsdkandroid_release = this.f912a.getStopLocation$silentlogsdkandroid_release();
            if (stopLocation$silentlogsdkandroid_release != null) {
                Unit invoke = stopLocation$silentlogsdkandroid_release.invoke();
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager$c */
    static final class C1107c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RFLLocationManager f913a;

        C1107c(RFLLocationManager rFLLocationManager) {
            this.f913a = rFLLocationManager;
        }

        public final void run() {
            Function0<Unit> stopLocation$silentlogsdkandroid_release = this.f913a.getStopLocation$silentlogsdkandroid_release();
            if (stopLocation$silentlogsdkandroid_release != null) {
                Unit invoke = stopLocation$silentlogsdkandroid_release.invoke();
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager$d */
    static final class C1108d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RFLLocationManager f914a;

        C1108d(RFLLocationManager rFLLocationManager) {
            this.f914a = rFLLocationManager;
        }

        public final void run() {
            this.f914a.m1510e();
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager$e */
    static final class C1109e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ RFLLocationManager f915a;

        C1109e(RFLLocationManager rFLLocationManager) {
            this.f915a = rFLLocationManager;
        }

        public final void run() {
            this.f915a.m1498a();
        }
    }

    public RFLLocationManager(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "clientContext");
        this.f904l = context;
        RFLTrackingAccuracy rFLTrackingAccuracy = RFLTrackingAccuracy.MIDDLE;
        C1122a.m1596a("init call", new Object[0]);
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final LocationRequest m1497a(long j) {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(j);
        locationRequest.setFastestInterval(j / ((long) 2));
        locationRequest.setPriority(102);
        return locationRequest;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m1498a() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        if (!rFLAccountManager.isLogin() || !this.f896d || this.f902j) {
            m1516k();
            return;
        }
        C1122a.m1600c("[SilentLogSDK] Info::Start AutoLocationUpdate", new Object[0]);
        m1513h();
        m1501a(RFLTrackingAccuracy.HIGH);
    }

    /* renamed from: a */
    private final void m1499a(Location location) {
        if (this.f897e.size() > 9) {
            this.f897e.remove(0);
        }
        this.f897e.add(location);
    }

    /* renamed from: a */
    private final void m1500a(List<GeofenceLatLng> list) {
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.setupGeofence(list, 1490);
    }

    /* renamed from: a */
    private final void m1501a(RFLTrackingAccuracy rFLTrackingAccuracy) {
        LocationRequest locationRequest;
        C1122a.m1600c("[SilentLogSDK] Info::Start Location Updates", new Object[0]);
        RFLAdManager rFLAdManager = this.adManager;
        if (rFLAdManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adManager");
        }
        rFLAdManager.postTracking(RFLAdTrackingType.START, this.f903k);
        int i = WhenMappings.$EnumSwitchMapping$0[rFLTrackingAccuracy.ordinal()];
        if (i == 1) {
            C1122a.m1596a("startLocationUpdates HIGH", new Object[0]);
            locationRequest = m1508d();
        } else if (i == 2) {
            C1122a.m1596a("startLocationUpdates MIDDLE", new Object[0]);
            locationRequest = m1512g();
        } else if (i == 3) {
            C1122a.m1596a("startLocationUpdates LOW", new Object[0]);
            locationRequest = m1511f();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.requestLocationUpdates(locationRequest, this);
    }

    /* renamed from: a */
    private final boolean m1502a(String str) {
        return ContextCompat.checkSelfPermission(this.f904l, str) == 0;
    }

    /* renamed from: b */
    private final void m1503b() {
        if (this.f900h != null) {
            C1122a.m1600c("[SilentLogSDK] Info::Cancel AutoLocationUpdateTimer", new Object[0]);
            Handler handler = this.f900h;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.f900h = null;
        }
    }

    /* renamed from: b */
    private final void m1504b(Location location) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GeofenceLatLng(location.getLatitude(), location.getLongitude(), GEOFENCE_ID_CENTER_1, 1000.0f, 2));
        arrayList.add(new GeofenceLatLng(location.getLatitude(), location.getLongitude(), GEOFENCE_ID_CENTER_2, 2000.0f, 2));
        arrayList.add(new GeofenceLatLng(location.getLatitude(), location.getLongitude(), GEOFENCE_ID_CENTER_3, 3000.0f, 2));
        m1500a((List<GeofenceLatLng>) arrayList);
    }

    /* renamed from: b */
    private final void m1505b(List<GeofenceLatLng> list) {
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.setupGeofence(list, 2980);
    }

    /* renamed from: c */
    private final void m1506c(List<GeofenceLatLng> list) {
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.setupGeofence(list, 1390);
    }

    /* renamed from: c */
    private final boolean m1507c() {
        try {
            Class<?> cls = Class.forName(RFLSharedHolder.INSTANCE.geofenceName());
            Intrinsics.checkExpressionValueIsNotNull(cls, "Class.forName(RFLSharedHolder.geofenceName())");
            C1122a.m1596a(cls.getSimpleName(), new Object[0]);
            Class<?> cls2 = Class.forName(RFLSharedHolder.INSTANCE.serviceName());
            Intrinsics.checkExpressionValueIsNotNull(cls2, "Class.forName(RFLSharedHolder.serviceName())");
            C1122a.m1596a(cls2.getSimpleName(), new Object[0]);
            Class<?> cls3 = Class.forName(RFLSharedHolder.INSTANCE.foregroundName());
            Intrinsics.checkExpressionValueIsNotNull(cls3, "Class.forName(RFLSharedHolder.foregroundName())");
            C1122a.m1596a(cls3.getSimpleName(), new Object[0]);
            return true;
        } catch (ClassNotFoundException unused) {
            C1122a.m1599b("[SilentLogSDK] Error::Valid Service OR GeoFence Name Required!!", new Object[0]);
            return false;
        }
    }

    /* renamed from: d */
    private final LocationRequest m1508d() {
        return m1497a(2000);
    }

    /* renamed from: d */
    private final void m1509d(List<GeofenceLatLng> list) {
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.setupGeofence(list, 1590);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    /* renamed from: e */
    public final void m1510e() {
        if (m1507c()) {
            if (!this.f896d) {
                C1122a.m1599b("[SilentLogSDK] Error::Unable Start Location Updates", new Object[0]);
            } else if (!this.f902j && m1514i()) {
                this.f903k = null;
                m1519n();
                stopGeoFenceEvent();
                m1517l();
                Function0<Unit> function0 = this.f894b;
                if (function0 != null) {
                    Unit invoke = function0.invoke();
                }
                m1503b();
                this.f897e = new ArrayList();
                int priorityType = RFLSharedHolder.INSTANCE.priorityType();
                RFLTrackingAccuracy rFLTrackingAccuracy = priorityType != 0 ? priorityType != 2 ? RFLTrackingAccuracy.MIDDLE : RFLTrackingAccuracy.LOW : RFLTrackingAccuracy.HIGH;
                RFLAdManager rFLAdManager = this.adManager;
                if (rFLAdManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adManager");
                }
                rFLAdManager.initLocationUpdates();
                m1501a(rFLTrackingAccuracy);
            }
        }
    }

    /* renamed from: f */
    private final LocationRequest m1511f() {
        return m1497a(15000);
    }

    /* renamed from: g */
    private final LocationRequest m1512g() {
        return m1497a(10000);
    }

    /* renamed from: h */
    private final void m1513h() {
        this.f897e = new ArrayList();
        Handler handler = this.f899g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f899g = null;
        m1519n();
        m1517l();
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.removeLocationUpdates(this);
    }

    /* renamed from: i */
    private final boolean m1514i() {
        return this.f897e.size() <= 1 || System.currentTimeMillis() - ((Location) CollectionsKt___CollectionsKt.last(this.f897e)).getTime() > ((long) 120000);
    }

    /* renamed from: j */
    private final boolean m1515j() {
        if (this.f897e.size() <= 1) {
            return false;
        }
        Location location = (Location) CollectionsKt___CollectionsKt.first(this.f897e);
        Location location2 = (Location) CollectionsKt___CollectionsKt.last(this.f897e);
        return ((double) (location.distanceTo(location2) / ((float) ((location2.getTime() - location.getTime()) / ((long) 1000))))) < 0.3d;
    }

    /* renamed from: k */
    private final void m1516k() {
        m1503b();
        C1122a.m1600c("[SilentLogSDK] Info::Set AutoLocationUpdateTimer after 120 minutes.", new Object[0]);
        Handler handler = new Handler();
        handler.postDelayed(new C1109e(this), 7200000);
        this.f900h = handler;
    }

    /* renamed from: l */
    private final void m1517l() {
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.stopGeoFence(1490);
    }

    /* renamed from: m */
    private final void m1518m() {
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.stopGeoFence(2980);
    }

    /* renamed from: n */
    private final void m1519n() {
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.stopGeoFence(1390);
    }

    public final void checkLocation(Location location) {
        Intrinsics.checkParameterIsNotNull(location, FirebaseAnalytics.Param.LOCATION);
        if (this.f901i) {
            Location location2 = this.f903k;
            if (location2 == null) {
                Intrinsics.throwNpe();
            }
            if (!RFLDailyUtilsKt.isSameDay(new Date(location2.getTime()), new Date(location.getTime()))) {
                stopGeofenceFromClient();
            }
        }
    }

    public final void checkPermission() {
        boolean z = m1502a("android.permission.ACCESS_FINE_LOCATION") && m1502a("android.permission.ACCESS_COARSE_LOCATION");
        this.f896d = z;
        RFLSharedHolder.INSTANCE.setGrant(z);
    }

    public final void discriminateActivity(Location location) {
        Intrinsics.checkParameterIsNotNull(location, FirebaseAnalytics.Param.LOCATION);
        Location location2 = this.f903k;
        if (location2 != null) {
            if (this.f902j) {
                Handler handler = this.f899g;
                if (handler != null) {
                    handler.removeCallbacksAndMessages((Object) null);
                }
                this.f899g = null;
            } else if (location.distanceTo(location2) >= ((float) 15) || this.f900h != null) {
                RFLDailyUtils rFLDailyUtils = this.dailyUtils;
                if (rFLDailyUtils == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
                }
                int distanceBetweenAAndB = rFLDailyUtils.getDistanceBetweenAAndB(location, this.f903k);
                long j = 120000;
                if (!(distanceBetweenAAndB == 0 || distanceBetweenAAndB == 1) || !m1515j()) {
                    j = 180000;
                }
                Handler handler2 = this.f899g;
                if (handler2 != null) {
                    handler2.removeCallbacksAndMessages((Object) null);
                }
                this.f899g = null;
                C1122a.m1596a("[DEBUG] Info::Stop Location After %s min", Long.valueOf((j / ((long) 1000)) / ((long) 60)));
                Handler handler3 = new Handler();
                this.f899g = handler3;
                handler3.postDelayed(new C1105a(this), j);
                m1503b();
            } else {
                return;
            }
            this.f903k = location;
            m1499a(location);
            return;
        }
        Handler handler4 = this.f899g;
        if (handler4 != null) {
            handler4.removeCallbacksAndMessages((Object) null);
        }
        this.f899g = null;
        if (!this.f902j) {
            Handler handler5 = new Handler();
            this.f899g = handler5;
            handler5.postDelayed(new C1106b(this), 60000);
            C1122a.m1596a("[DEBUG] Info::Stop Location After 1 min", new Object[0]);
        }
        this.f903k = location;
        m1499a(location);
        m1504b(location);
    }

    public final RFLAccountManager getAccountManager() {
        RFLAccountManager rFLAccountManager = this.accountManager;
        if (rFLAccountManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountManager");
        }
        return rFLAccountManager;
    }

    public final RFLAdManager getAdManager() {
        RFLAdManager rFLAdManager = this.adManager;
        if (rFLAdManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adManager");
        }
        return rFLAdManager;
    }

    public final Location getCurrentLocation$silentlogsdkandroid_release() {
        return this.f903k;
    }

    public final RFLDailyUtils getDailyUtils$silentlogsdkandroid_release() {
        RFLDailyUtils rFLDailyUtils = this.dailyUtils;
        if (rFLDailyUtils == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dailyUtils");
        }
        return rFLDailyUtils;
    }

    public final C1126c getEventBus() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        return cVar;
    }

    public final RFLGoogleLocationService getGoogleLocationService$silentlogsdkandroid_release() {
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        return rFLGoogleLocationService;
    }

    public final Function0<Unit> getInitLocationUpdate$silentlogsdkandroid_release() {
        return this.f894b;
    }

    public final Location getLastLocation$silentlogsdkandroid_release() {
        if (this.f897e.isEmpty()) {
            return null;
        }
        return (Location) CollectionsKt___CollectionsKt.last(this.f897e);
    }

    public final Function2<Location, Boolean, Unit> getOnLocationChange$silentlogsdkandroid_release() {
        return this.f893a;
    }

    public final Function0<Unit> getStopLocation$silentlogsdkandroid_release() {
        return this.f895c;
    }

    public final void grantLocation() {
        if (!this.f896d) {
            this.f896d = true;
            RFLSharedHolder.INSTANCE.setGrant(true);
            if (RFLSharedHolder.INSTANCE.tracking()) {
                start();
            }
        }
    }

    public final boolean isActiveMode$silentlogsdkandroid_release() {
        return this.f902j;
    }

    public void onLocationResult(LocationResult locationResult) {
        Location lastLocation = locationResult != null ? locationResult.getLastLocation() : null;
        boolean z = false;
        if (lastLocation == null) {
            Function2<? super Location, ? super Boolean, Unit> function2 = this.f893a;
            if (function2 != null) {
                Unit invoke = function2.invoke(lastLocation, false);
            }
        } else if (!RFLSharedHolder.INSTANCE.isLocationJapanOnly() || LocationExKt.isJapan(lastLocation)) {
            if (this.f903k != null) {
                long time = lastLocation.getTime();
                Location location = this.f903k;
                if (location == null) {
                    Intrinsics.throwNpe();
                }
                if ((time - location.getTime()) / ((long) 1000) <= 1) {
                    z = true;
                }
            }
            Function2<? super Location, ? super Boolean, Unit> function22 = this.f893a;
            if (function22 != null) {
                Unit invoke2 = function22.invoke(lastLocation, Boolean.valueOf(z));
            }
            if (!z) {
                RFLAdManager rFLAdManager = this.adManager;
                if (rFLAdManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adManager");
                }
                rFLAdManager.checkTriggerIfNeeded(lastLocation, this.f897e);
            }
        }
    }

    @C1129m(threadMode = ThreadMode.MAIN)
    public final void onReceiveActiveMode(ActiveMode activeMode) {
        Intrinsics.checkParameterIsNotNull(activeMode, "activeMode");
        boolean active = activeMode.getActive();
        if (active != this.f902j) {
            C1122a.m1596a("onReceiveActiveMode:%s isActive:%s", Boolean.valueOf(activeMode.getActive()), Boolean.valueOf(this.f902j));
            this.f902j = active;
            if (active) {
                m1503b();
                m1513h();
                m1501a(RFLTrackingAccuracy.HIGH);
                return;
            }
            Handler handler = this.f899g;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            this.f899g = null;
            C1122a.m1596a("[DEBUG] Info::Stop Location After 1 min", new Object[0]);
            Handler handler2 = new Handler();
            this.f899g = handler2;
            handler2.postDelayed(new C1107c(this), 60000);
            Location location = this.f903k;
            if (location != null) {
                m1504b(location);
            }
        }
    }

    public final void registerPOItoFence(List<RFLNotificationPoi> list) {
        Intrinsics.checkParameterIsNotNull(list, "regionNotificationPoi");
        if (!list.isEmpty()) {
            C1122a.m1596a("registerPOItoFence %s ", list);
            ArrayList arrayList = new ArrayList();
            for (RFLNotificationPoi next : list) {
                StringBuilder a = C0681a.m330a("eve.reifrontier.");
                a.append(next.getPlaceId());
                a.append("-e!!e-");
                a.append(String.valueOf(next.getPoiId()));
                arrayList.add(new GeofenceLatLng(next.getLat(), next.getLon(), a.toString(), next.getRangeRadius(), 1));
            }
            m1509d(arrayList);
        }
    }

    public final void reregisterEventBus() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        cVar.mo21908c(this);
        C1126c cVar2 = this.eventBus;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        cVar2.mo21907b(this);
    }

    public final C1714r<Integer> responseAd(int i, RFLAdResType rFLAdResType) {
        Intrinsics.checkParameterIsNotNull(rFLAdResType, "responseType");
        RFLAdManager rFLAdManager = this.adManager;
        if (rFLAdManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adManager");
        }
        return rFLAdManager.responseAd(i, rFLAdResType, this.f903k);
    }

    public final void setAccountManager(RFLAccountManager rFLAccountManager) {
        Intrinsics.checkParameterIsNotNull(rFLAccountManager, "<set-?>");
        this.accountManager = rFLAccountManager;
    }

    public final void setAdManager(RFLAdManager rFLAdManager) {
        Intrinsics.checkParameterIsNotNull(rFLAdManager, "<set-?>");
        this.adManager = rFLAdManager;
    }

    public final void setDailyUtils$silentlogsdkandroid_release(RFLDailyUtils rFLDailyUtils) {
        Intrinsics.checkParameterIsNotNull(rFLDailyUtils, "<set-?>");
        this.dailyUtils = rFLDailyUtils;
    }

    public final void setEventBus(C1126c cVar) {
        Intrinsics.checkParameterIsNotNull(cVar, "<set-?>");
        this.eventBus = cVar;
    }

    public final void setGoogleLocationService$silentlogsdkandroid_release(RFLGoogleLocationService rFLGoogleLocationService) {
        Intrinsics.checkParameterIsNotNull(rFLGoogleLocationService, "<set-?>");
        this.googleLocationService = rFLGoogleLocationService;
    }

    public final void setInitLocationUpdate$silentlogsdkandroid_release(Function0<Unit> function0) {
        this.f894b = function0;
    }

    public final void setOnLocationChange$silentlogsdkandroid_release(Function2<? super Location, ? super Boolean, Unit> function2) {
        this.f893a = function2;
    }

    public final void setStopLocation$silentlogsdkandroid_release(Function0<Unit> function0) {
        this.f895c = function0;
    }

    public final void start() {
        Handler handler = this.f898f;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f898f = null;
        }
        Handler handler2 = new Handler();
        this.f898f = handler2;
        handler2.postDelayed(new C1108d(this), 500);
        reregisterEventBus();
        RFLAdManager rFLAdManager = this.adManager;
        if (rFLAdManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adManager");
        }
        rFLAdManager.start();
    }

    public final void startGeoFence() {
        if (this.f903k != null) {
            C1122a.m1600c("[SilentLogSDK] Info::startGeoFence", new Object[0]);
            Location location = this.f903k;
            if (location == null) {
                Intrinsics.throwNpe();
            }
            double latitude = location.getLatitude();
            Location location2 = this.f903k;
            if (location2 == null) {
                Intrinsics.throwNpe();
            }
            double longitude = location2.getLongitude();
            double d = (double) 360000;
            double d2 = (double) 6378137;
            double cos = Math.cos((3.141592653589793d * latitude) / 180.0d);
            Double.isNaN(d2);
            Double.isNaN(d);
            double d3 = d / ((cos * d2) * 6.283185307179586d);
            double d4 = longitude + d3;
            double d5 = longitude - d3;
            double d6 = latitude + 0.0090133729745762d;
            double d7 = latitude - 0.0090133729745762d;
            C1122a.m1596a("C: %s,%s", Double.valueOf(latitude), Double.valueOf(longitude));
            C1122a.m1596a("N: %s,%s  S: %s,%s", Double.valueOf(d6), Double.valueOf(longitude), Double.valueOf(d7), Double.valueOf(longitude));
            C1122a.m1596a("E: %s,%s  W: %s,%s", Double.valueOf(latitude), Double.valueOf(d4), Double.valueOf(latitude), Double.valueOf(d5));
            ArrayList arrayList = new ArrayList();
            float f = 970.0f;
            if (Build.VERSION.SDK_INT >= 26) {
                f = 990.0f;
            }
            double d8 = longitude;
            float f2 = f;
            GeofenceLatLng geofenceLatLng = r3;
            GeofenceLatLng geofenceLatLng2 = new GeofenceLatLng(d6, d8, GEOFENCE_ID_NORTH, f2, 1);
            arrayList.add(geofenceLatLng);
            arrayList.add(new GeofenceLatLng(d7, d8, GEOFENCE_ID_SOUTH, f2, 1));
            double d9 = latitude;
            arrayList.add(new GeofenceLatLng(d9, d4, GEOFENCE_ID_EAST, f2, 1));
            arrayList.add(new GeofenceLatLng(d9, d5, GEOFENCE_ID_WEST, f2, 1));
            m1506c(arrayList);
        }
    }

    public final void startGeofenceFromClient(List<? extends Map<String, ? extends Object>> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        C1122a.m1596a("startGeofenceFromClient", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (Map map : list) {
            Object obj = map.get("lat");
            if (obj != null) {
                double doubleValue = ((Double) obj).doubleValue();
                Object obj2 = map.get("lon");
                if (obj2 != null) {
                    double doubleValue2 = ((Double) obj2).doubleValue();
                    Object obj3 = map.get("id");
                    if (obj3 != null) {
                        arrayList.add(new GeofenceLatLng(doubleValue, doubleValue2, (String) obj3, 90.0f, 1));
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Double");
            }
        }
        m1505b((List<GeofenceLatLng>) arrayList);
        this.f901i = true;
    }

    public final void stop() {
        C1126c cVar = this.eventBus;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventBus");
        }
        cVar.mo21908c(this);
        Handler handler = this.f898f;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f898f = null;
        m1513h();
        stopGeofenceFromClient();
        stopGeoFenceEvent();
        m1503b();
        this.f903k = null;
        this.f897e.clear();
        this.f902j = false;
        this.f901i = false;
        RFLAdManager rFLAdManager = this.adManager;
        if (rFLAdManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adManager");
        }
        rFLAdManager.stop();
    }

    public final void stopGeoFenceEvent() {
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.stopGeoFence(1590);
    }

    public final void stopGeofenceFromClient() {
        m1518m();
        this.f901i = false;
    }

    public final void stopLocationUpdates() {
        C1122a.m1600c("[SilentLogSDK] Info::stopLocationUpdates", new Object[0]);
        RFLAdManager rFLAdManager = this.adManager;
        if (rFLAdManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adManager");
        }
        rFLAdManager.postTracking(RFLAdTrackingType.STOP, this.f903k);
        this.f897e = new ArrayList();
        Handler handler = this.f899g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.f899g = null;
        RFLGoogleLocationService rFLGoogleLocationService = this.googleLocationService;
        if (rFLGoogleLocationService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("googleLocationService");
        }
        rFLGoogleLocationService.removeLocationUpdates(this);
        m1516k();
    }
}
