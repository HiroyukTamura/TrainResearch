package p043jp.reifrontier.gym.service;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.JobIntentService;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\fH\u0014¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/gym/service/RFGGeoFenceJob;", "Landroidx/core/app/JobIntentService;", "()V", "didEnterRegion", "", "triggerGeofenceId", "", "didExitRegion", "enqueueWork", "context", "Landroid/content/Context;", "work", "Landroid/content/Intent;", "onHandleWork", "intent", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.service.RFGGeoFenceJob */
public final class RFGGeoFenceJob extends JobIntentService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int JOB_ID = 20120216;
    private static final String TAG;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/service/RFGGeoFenceJob$Companion;", "", "()V", "JOB_ID", "", "TAG", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.service.RFGGeoFenceJob$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String simpleName = RFGGeoFenceJob.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "RFGGeoFenceJob::class.java.simpleName");
        TAG = simpleName;
    }

    private final void didEnterRegion(String str) {
        Context applicationContext = getApplicationContext();
        if (Intrinsics.areEqual((Object) (String) CollectionsKt___CollectionsKt.last(StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null)), (Object) "silentlogsdkandroid")) {
            Intent intent = new Intent(applicationContext, RFGService.class);
            intent.putExtra("kRFL_TRIGGER", str);
            if (Build.VERSION.SDK_INT >= 26) {
                applicationContext.startForegroundService(intent);
            } else {
                applicationContext.startService(intent);
            }
        } else {
            new RFGLocalPush(this).showNotification(str);
        }
    }

    private final void didExitRegion(String str) {
        Context applicationContext = getApplicationContext();
        Intent intent = new Intent(applicationContext, RFGService.class);
        intent.putExtra("kRFL_TRIGGER", str);
        if (Build.VERSION.SDK_INT >= 26) {
            applicationContext.startForegroundService(intent);
        } else {
            applicationContext.startService(intent);
        }
    }

    public final void enqueueWork(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "work");
        JobIntentService.enqueueWork(context, (Class<?>) RFGGeoFenceJob.class, (int) JOB_ID, intent);
    }

    /* access modifiers changed from: protected */
    public void onHandleWork(Intent intent) {
        String str;
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        GeofencingEvent fromIntent = GeofencingEvent.fromIntent(intent);
        if (fromIntent != null) {
            List<Geofence> triggeringGeofences = fromIntent.getTriggeringGeofences();
            if (fromIntent.hasError()) {
                C1122a.m1599b("[Gym]::Error GeoFence Event Error :%s", Integer.valueOf(fromIntent.getErrorCode()));
                return;
            }
            if (triggeringGeofences == null || triggeringGeofences.size() <= 0) {
                str = "triggeringGeofence";
            } else {
                Object first = CollectionsKt___CollectionsKt.first(triggeringGeofences);
                Intrinsics.checkExpressionValueIsNotNull(first, "geFence.first()");
                str = ((Geofence) first).getRequestId();
                Intrinsics.checkExpressionValueIsNotNull(str, "geFence.first().requestId");
            }
            int geofenceTransition = fromIntent.getGeofenceTransition();
            if (geofenceTransition != 1 && geofenceTransition != 2 && geofenceTransition != 4) {
                C1122a.m1599b("[Gym]::Error Geofence error: %s", Integer.valueOf(geofenceTransition));
            } else if (geofenceTransition == 1) {
                didEnterRegion(str);
            } else if (geofenceTransition == 2) {
                didExitRegion(str);
            }
        }
    }
}
