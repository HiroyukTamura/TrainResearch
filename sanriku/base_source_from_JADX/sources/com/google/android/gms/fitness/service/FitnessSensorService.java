package com.google.android.gms.fitness.service;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.fitness.zzbg;
import com.google.android.gms.internal.fitness.zzcm;
import com.google.android.gms.internal.fitness.zzeq;
import com.google.android.gms.internal.fitness.zzes;
import com.google.android.gms.internal.fitness.zzew;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

public abstract class FitnessSensorService extends Service {
    public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
    private zza zzqx;

    static class zza extends zzew {
        private final FitnessSensorService zzra;

        private zza(FitnessSensorService fitnessSensorService) {
            this.zzra = fitnessSensorService;
        }

        public final void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zzcm zzcm) throws RemoteException {
            this.zzra.zzaf();
            zzcm.onResult(this.zzra.onRegister(fitnessSensorServiceRequest) ? Status.RESULT_SUCCESS : new Status(13));
        }

        public final void zza(zzeq zzeq, zzbg zzbg) throws RemoteException {
            this.zzra.zzaf();
            zzbg.zza(new DataSourcesResult(this.zzra.onFindDataSources(zzeq.getDataTypes()), Status.RESULT_SUCCESS));
        }

        public final void zza(zzes zzes, zzcm zzcm) throws RemoteException {
            this.zzra.zzaf();
            zzcm.onResult(this.zzra.onUnregister(zzes.getDataSource()) ? Status.RESULT_SUCCESS : new Status(13));
        }
    }

    @CallSuper
    @Nullable
    public IBinder onBind(Intent intent) {
        if (!SERVICE_INTERFACE.equals(intent.getAction())) {
            return null;
        }
        if (Log.isLoggable("FitnessSensorService", 3)) {
            String valueOf = String.valueOf(intent);
            String name = FitnessSensorService.class.getName();
            Log.d("FitnessSensorService", C0681a.m314a(name.length() + valueOf.length() + 20, "Intent ", valueOf, " received by ", name));
        }
        return this.zzqx.asBinder();
    }

    @CallSuper
    public void onCreate() {
        super.onCreate();
        this.zzqx = new zza();
    }

    public abstract List<DataSource> onFindDataSources(List<DataType> list);

    public abstract boolean onRegister(FitnessSensorServiceRequest fitnessSensorServiceRequest);

    public abstract boolean onUnregister(DataSource dataSource);

    /* access modifiers changed from: protected */
    @TargetApi(19)
    @VisibleForTesting
    public final void zzaf() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (PlatformVersion.isAtLeastKitKat()) {
            ((AppOpsManager) getSystemService("appops")).checkPackage(callingUid, "com.google.android.gms");
            return;
        }
        String[] packagesForUid = getPackageManager().getPackagesForUid(callingUid);
        if (packagesForUid != null) {
            int length = packagesForUid.length;
            int i = 0;
            while (i < length) {
                if (!packagesForUid[i].equals("com.google.android.gms")) {
                    i++;
                } else {
                    return;
                }
            }
        }
        throw new SecurityException("Unauthorized caller");
    }
}
