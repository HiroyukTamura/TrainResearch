package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLLocationManager;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u001e\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLGoogleLocationService;", "", "clientContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "locationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getLocationClient", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "isGeofenceExists", "", "code", "", "pendingIntent", "Landroid/app/PendingIntent;", "removeLocationUpdates", "", "locationCallback", "Lcom/google/android/gms/location/LocationCallback;", "requestLocationUpdates", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "setupGeofence", "latlngs", "", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLLocationManager$GeofenceLatLng;", "stopGeoFence", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleLocationService */
public final class RFLGoogleLocationService {

    /* renamed from: a */
    private final FusedLocationProviderClient f3204a;

    /* renamed from: b */
    private final Context f3205b;

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLGoogleLocationService$a */
    static final class C2193a<TResult> implements OnCompleteListener<Void> {

        /* renamed from: a */
        final /* synthetic */ int f3206a;

        C2193a(int i) {
            this.f3206a = i;
        }

        public final void onComplete(Task<Void> task) {
            Intrinsics.checkParameterIsNotNull(task, "task");
            if (task.isSuccessful()) {
                C1122a.m1596a("Geofence Success ::code:%s", Integer.valueOf(this.f3206a));
                return;
            }
            Object[] objArr = new Object[1];
            Exception exception = task.getException();
            if (exception == null) {
                Intrinsics.throwNpe();
            }
            objArr[0] = exception.getMessage();
            C1122a.m1599b("Geofence Error ::%s", objArr);
        }
    }

    public RFLGoogleLocationService(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "clientContext");
        this.f3205b = context;
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
        Intrinsics.checkExpressionValueIsNotNull(fusedLocationProviderClient, "LocationServices.getFuse…iderClient(clientContext)");
        this.f3204a = fusedLocationProviderClient;
        C1122a.m1596a("init call", new Object[0]);
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    /* renamed from: a */
    private final boolean m3748a(int i) {
        return PendingIntent.getBroadcast(this.f3205b, i, new Intent(this.f3205b, Class.forName(RFLSharedHolder.INSTANCE.geofenceName())), 536870912) != null;
    }

    /* renamed from: b */
    private final PendingIntent m3749b(int i) {
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f3205b, i, new Intent(this.f3205b, Class.forName(RFLSharedHolder.INSTANCE.geofenceName())), 134217728);
        Intrinsics.checkExpressionValueIsNotNull(broadcast, "PendingIntent.getBroadca…tent.FLAG_UPDATE_CURRENT)");
        return broadcast;
    }

    public final FusedLocationProviderClient getLocationClient() {
        return this.f3204a;
    }

    public final void removeLocationUpdates(LocationCallback locationCallback) {
        Intrinsics.checkParameterIsNotNull(locationCallback, "locationCallback");
        this.f3204a.removeLocationUpdates(locationCallback);
    }

    @SuppressLint({"MissingPermission"})
    public final void requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback) {
        Intrinsics.checkParameterIsNotNull(locationRequest, "locationRequest");
        Intrinsics.checkParameterIsNotNull(locationCallback, "locationCallback");
        if (!RFLSharedHolder.INSTANCE.grant()) {
            C1122a.m1599b("Unable Start Location Updates", new Object[0]);
        } else {
            this.f3204a.requestLocationUpdates(locationRequest, locationCallback, (Looper) null);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void setupGeofence(List<RFLLocationManager.GeofenceLatLng> list, int i) {
        Intrinsics.checkParameterIsNotNull(list, "latlngs");
        if (!RFLSharedHolder.INSTANCE.grant()) {
            C1122a.m1599b("Geofence: permission is not granted", new Object[0]);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (RFLLocationManager.GeofenceLatLng next : list) {
            Geofence build = new Geofence.Builder().setRequestId(next.getGeoId()).setCircularRegion(next.getLatitude(), next.getLongitude(), next.getRad()).setExpirationDuration(-1).setTransitionTypes(next.getTransitionTypes()).setLoiteringDelay(0).build();
            Intrinsics.checkExpressionValueIsNotNull(build, "gf");
            arrayList.add(build);
        }
        GeofencingRequest build2 = new GeofencingRequest.Builder().setInitialTrigger(3).addGeofences(arrayList).build();
        PendingIntent b = m3749b(i);
        GeofencingClient geofencingClient = LocationServices.getGeofencingClient(this.f3205b);
        geofencingClient.removeGeofences(b);
        geofencingClient.addGeofences(build2, b).addOnCompleteListener(new C2193a(i));
    }

    public final void stopGeoFence(int i) {
        if (m3748a(i)) {
            PendingIntent b = m3749b(i);
            LocationServices.getGeofencingClient(this.f3205b).removeGeofences(b);
            b.cancel();
        }
    }
}
