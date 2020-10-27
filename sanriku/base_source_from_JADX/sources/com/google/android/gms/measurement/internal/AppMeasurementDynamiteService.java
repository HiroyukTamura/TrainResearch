package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.measurement.zzab;
import com.google.android.gms.internal.measurement.zzac;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzu;
import com.google.android.gms.internal.measurement.zzw;
import java.util.Map;

@DynamiteApi
public class AppMeasurementDynamiteService extends zzu {
    @VisibleForTesting
    zzgd zza = null;
    private Map<Integer, zzhf> zzb = new ArrayMap();

    class zza implements zzhf {
        private zzab zza;

        zza(zzab zzab) {
            this.zza = zzab;
        }

        public final void onEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event listener threw exception", e);
            }
        }
    }

    class zzb implements zzhc {
        private zzab zza;

        zzb(zzab zzab) {
            this.zza = zzab;
        }

        public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
            try {
                this.zza.zza(str, str2, bundle, j);
            } catch (RemoteException e) {
                AppMeasurementDynamiteService.this.zza.zzr().zzi().zza("Event interceptor threw exception", e);
            }
        }
    }

    private final void zza() {
        if (this.zza == null) {
            throw new IllegalStateException("Attempting to perform action before initialize.");
        }
    }

    private final void zza(zzw zzw, String str) {
        this.zza.zzi().zza(zzw, str);
    }

    public void beginAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zza(str, j);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        zza();
        this.zza.zzh().zzc(str, str2, bundle);
    }

    public void endAdUnitExposure(String str, long j) throws RemoteException {
        zza();
        this.zza.zzz().zzb(str, j);
    }

    public void generateEventId(zzw zzw) throws RemoteException {
        zza();
        this.zza.zzi().zza(zzw, this.zza.zzi().zzg());
    }

    public void getAppInstanceId(zzw zzw) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzh(this, zzw));
    }

    public void getCachedAppInstanceId(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzh().zzah());
    }

    public void getConditionalUserProperties(String str, String str2, zzw zzw) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzl(this, zzw, str, str2));
    }

    public void getCurrentScreenClass(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzh().zzak());
    }

    public void getCurrentScreenName(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzh().zzaj());
    }

    public void getGmpAppId(zzw zzw) throws RemoteException {
        zza();
        zza(zzw, this.zza.zzh().zzal());
    }

    public void getMaxUserProperties(String str, zzw zzw) throws RemoteException {
        zza();
        this.zza.zzh();
        Preconditions.checkNotEmpty(str);
        this.zza.zzi().zza(zzw, 25);
    }

    public void getTestFlag(zzw zzw, int i) throws RemoteException {
        zza();
        if (i == 0) {
            this.zza.zzi().zza(zzw, this.zza.zzh().zzad());
        } else if (i == 1) {
            this.zza.zzi().zza(zzw, this.zza.zzh().zzae().longValue());
        } else if (i == 2) {
            zzkw zzi = this.zza.zzi();
            double doubleValue = this.zza.zzh().zzag().doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                zzw.zza(bundle);
            } catch (RemoteException e) {
                zzi.zzy.zzr().zzi().zza("Error returning double value to wrapper", e);
            }
        } else if (i == 3) {
            this.zza.zzi().zza(zzw, this.zza.zzh().zzaf().intValue());
        } else if (i == 4) {
            this.zza.zzi().zza(zzw, this.zza.zzh().zzac().booleanValue());
        }
    }

    public void getUserProperties(String str, String str2, boolean z, zzw zzw) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzi(this, zzw, str, str2, z));
    }

    public void initForTests(Map map) throws RemoteException {
        zza();
    }

    public void initialize(IObjectWrapper iObjectWrapper, zzae zzae, long j) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzgd zzgd = this.zza;
        if (zzgd == null) {
            this.zza = zzgd.zza(context, zzae, Long.valueOf(j));
        } else {
            zzgd.zzr().zzi().zza("Attempting to initialize multiple times");
        }
    }

    public void isDataCollectionEnabled(zzw zzw) throws RemoteException {
        zza();
        this.zza.zzq().zza((Runnable) new zzk(this, zzw));
    }

    public void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, bundle, z, z2, j);
    }

    public void logEventAndBundle(String str, String str2, Bundle bundle, zzw zzw, long j) throws RemoteException {
        Bundle bundle2;
        zza();
        Preconditions.checkNotEmpty(str2);
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putString("_o", "app");
        this.zza.zzq().zza((Runnable) new zzj(this, zzw, new zzao(str2, new zzan(bundle), "app", j), str));
    }

    public void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        zza();
        Object obj = null;
        Object unwrap = iObjectWrapper == null ? null : ObjectWrapper.unwrap(iObjectWrapper);
        Object unwrap2 = iObjectWrapper2 == null ? null : ObjectWrapper.unwrap(iObjectWrapper2);
        if (iObjectWrapper3 != null) {
            obj = ObjectWrapper.unwrap(iObjectWrapper3);
        }
        this.zza.zzr().zza(i, true, false, str, unwrap, unwrap2, obj);
    }

    public void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityCreated((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
    }

    public void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityDestroyed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityPaused(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityPaused((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityResumed(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityResumed((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzw zzw, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        Bundle bundle = new Bundle();
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivitySaveInstanceState((Activity) ObjectWrapper.unwrap(iObjectWrapper), bundle);
        }
        try {
            zzw.zza(bundle);
        } catch (RemoteException e) {
            this.zza.zzr().zzi().zza("Error returning bundle value to wrapper", e);
        }
    }

    public void onActivityStarted(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityStarted((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void onActivityStopped(IObjectWrapper iObjectWrapper, long j) throws RemoteException {
        zza();
        zzid zzid = this.zza.zzh().zza;
        if (zzid != null) {
            this.zza.zzh().zzab();
            zzid.onActivityStopped((Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public void performAction(Bundle bundle, zzw zzw, long j) throws RemoteException {
        zza();
        zzw.zza((Bundle) null);
    }

    public void registerOnMeasurementEventListener(zzab zzab) throws RemoteException {
        zza();
        zzhf zzhf = this.zzb.get(Integer.valueOf(zzab.zza()));
        if (zzhf == null) {
            zzhf = new zza(zzab);
            this.zzb.put(Integer.valueOf(zzab.zza()), zzhf);
        }
        this.zza.zzh().zza(zzhf);
    }

    public void resetAnalyticsData(long j) throws RemoteException {
        zza();
        zzhh zzh = this.zza.zzh();
        zzh.zza((String) null);
        zzh.zzq().zza((Runnable) new zzhp(zzh, j));
    }

    public void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        zza();
        if (bundle == null) {
            this.zza.zzr().zzf().zza("Conditional user property must not be null");
        } else {
            this.zza.zzh().zza(bundle, j);
        }
    }

    public void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) throws RemoteException {
        zza();
        this.zza.zzv().zza((Activity) ObjectWrapper.unwrap(iObjectWrapper), str, str2);
    }

    public void setDataCollectionEnabled(boolean z) throws RemoteException {
        zza();
        zzhh zzh = this.zza.zzh();
        zzh.zzw();
        zzh.zzb();
        zzh.zzq().zza((Runnable) new zzhy(zzh, z));
    }

    public void setDefaultEventParameters(Bundle bundle) {
        zza();
        zzhh zzh = this.zza.zzh();
        zzh.zzq().zza((Runnable) new zzhg(zzh, bundle == null ? null : new Bundle(bundle)));
    }

    public void setEventInterceptor(zzab zzab) throws RemoteException {
        zza();
        zzhh zzh = this.zza.zzh();
        zzb zzb2 = new zzb(zzab);
        zzh.zzb();
        zzh.zzw();
        zzh.zzq().zza((Runnable) new zzho(zzh, zzb2));
    }

    public void setInstanceIdProvider(zzac zzac) throws RemoteException {
        zza();
    }

    public void setMeasurementEnabled(boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(z);
    }

    public void setMinimumSessionDuration(long j) throws RemoteException {
        zza();
        zzhh zzh = this.zza.zzh();
        zzh.zzb();
        zzh.zzq().zza((Runnable) new zzia(zzh, j));
    }

    public void setSessionTimeoutDuration(long j) throws RemoteException {
        zza();
        zzhh zzh = this.zza.zzh();
        zzh.zzb();
        zzh.zzq().zza((Runnable) new zzhl(zzh, j));
    }

    public void setUserId(String str, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza((String) null, "_id", str, true, j);
    }

    public void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) throws RemoteException {
        zza();
        this.zza.zzh().zza(str, str2, ObjectWrapper.unwrap(iObjectWrapper), z, j);
    }

    public void unregisterOnMeasurementEventListener(zzab zzab) throws RemoteException {
        zza();
        zzhf remove = this.zzb.remove(Integer.valueOf(zzab.zza()));
        if (remove == null) {
            remove = new zza(zzab);
        }
        this.zza.zzh().zzb(remove);
    }
}
