// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.util.zze;
import java.util.concurrent.atomic.AtomicReference;
import com.google.android.gms.measurement.AppMeasurement;
import android.os.RemoteException;
import java.util.Collection;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;
import android.content.ServiceConnection;
import com.google.android.gms.common.stats.zza;
import java.util.Iterator;
import android.support.annotation.WorkerThread;
import android.content.ComponentName;
import java.util.ArrayList;
import java.util.List;

public final class zzcid extends zzchj
{
    private final zzciq zzbtT;
    private zzcfd zzbtU;
    private Boolean zzbtV;
    private final zzcer zzbtW;
    private final zzcjf zzbtX;
    private final List<Runnable> zzbtY;
    private final zzcer zzbtZ;
    
    protected zzcid(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbtY = new ArrayList<Runnable>();
        this.zzbtX = new zzcjf(zzcgl.zzkq());
        this.zzbtT = new zzciq(this);
        this.zzbtW = new zzcie(this, zzcgl);
        this.zzbtZ = new zzcii(this, zzcgl);
    }
    
    @WorkerThread
    private final void onServiceDisconnected(final ComponentName componentName) {
        super.zzjC();
        if (this.zzbtU != null) {
            this.zzbtU = null;
            super.zzwF().zzyD().zzj("Disconnected from device MeasurementService", componentName);
            super.zzjC();
            this.zzla();
        }
    }
    
    @WorkerThread
    private final void zzkP() {
        super.zzjC();
        this.zzbtX.start();
        this.zzbtW.zzs(zzcem.zzxB());
    }
    
    @WorkerThread
    private final void zzkQ() {
        super.zzjC();
        if (!this.isConnected()) {
            return;
        }
        super.zzwF().zzyD().log("Inactivity, disconnecting from the service");
        this.disconnect();
    }
    
    @WorkerThread
    private final void zzm(final Runnable runnable) throws IllegalStateException {
        super.zzjC();
        if (this.isConnected()) {
            runnable.run();
            return;
        }
        if (this.zzbtY.size() >= zzcem.zzxJ()) {
            super.zzwF().zzyx().log("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzbtY.add(runnable);
        this.zzbtZ.zzs(60000L);
        this.zzla();
    }
    
    @WorkerThread
    private final void zzzl() {
        super.zzjC();
        super.zzwF().zzyD().zzj("Processing queued up service tasks", this.zzbtY.size());
        for (final Runnable runnable : this.zzbtY) {
            try {
                runnable.run();
            }
            catch (Throwable t) {
                super.zzwF().zzyx().zzj("Task exception while flushing queue", t);
            }
        }
        this.zzbtY.clear();
        this.zzbtZ.cancel();
    }
    
    @WorkerThread
    public final void disconnect() {
        super.zzjC();
        this.zzkD();
        while (true) {
            try {
                zza.zzrU();
                super.getContext().unbindService((ServiceConnection)this.zzbtT);
                this.zzbtU = null;
            }
            catch (IllegalStateException ex) {
                continue;
            }
            catch (IllegalArgumentException ex2) {
                continue;
            }
            break;
        }
    }
    
    @WorkerThread
    public final boolean isConnected() {
        super.zzjC();
        this.zzkD();
        return this.zzbtU != null;
    }
    
    @WorkerThread
    protected final void zza(final zzcfd zzbtU) {
        super.zzjC();
        zzbo.zzu(zzbtU);
        this.zzbtU = zzbtU;
        this.zzkP();
        this.zzzl();
    }
    
    @WorkerThread
    final void zza(final zzcfd zzcfd, final com.google.android.gms.common.internal.safeparcel.zza zza) {
        super.zzjC();
        super.zzwp();
        this.zzkD();
        zzcem.zzxE();
        final ArrayList<com.google.android.gms.common.internal.safeparcel.zza> list = new ArrayList<com.google.android.gms.common.internal.safeparcel.zza>();
        zzcem.zzxN();
        for (int n = 0, size = 100; n < 1001 && size == 100; ++n) {
            final List<com.google.android.gms.common.internal.safeparcel.zza> zzbp = super.zzwy().zzbp(100);
            if (zzbp != null) {
                list.addAll((Collection<?>)zzbp);
                size = zzbp.size();
            }
            else {
                size = 0;
            }
            if (zza != null && size < 100) {
                list.add(zza);
            }
            final ArrayList<Object> list2 = (ArrayList<Object>)list;
            final int size2 = list2.size();
            int i = 0;
            while (i < size2) {
                final com.google.android.gms.common.internal.safeparcel.zza value = list2.get(i);
                ++i;
                final com.google.android.gms.common.internal.safeparcel.zza zza2 = value;
                if (zza2 instanceof zzcez) {
                    try {
                        zzcfd.zza((zzcez)zza2, super.zzwu().zzdV(super.zzwF().zzyE()));
                    }
                    catch (RemoteException ex) {
                        super.zzwF().zzyx().zzj("Failed to send event to the service", ex);
                    }
                }
                else if (zza2 instanceof zzcji) {
                    try {
                        zzcfd.zza((zzcji)zza2, super.zzwu().zzdV(super.zzwF().zzyE()));
                    }
                    catch (RemoteException ex2) {
                        super.zzwF().zzyx().zzj("Failed to send attribute to the service", ex2);
                    }
                }
                else if (zza2 instanceof zzcek) {
                    try {
                        zzcfd.zza((zzcek)zza2, super.zzwu().zzdV(super.zzwF().zzyE()));
                    }
                    catch (RemoteException ex3) {
                        super.zzwF().zzyx().zzj("Failed to send conditional property to the service", ex3);
                    }
                }
                else {
                    super.zzwF().zzyx().log("Discarding data. Unrecognized parcel type.");
                }
            }
        }
    }
    
    @WorkerThread
    protected final void zza(final AppMeasurement.zzb zzb) {
        super.zzjC();
        this.zzkD();
        this.zzm(new zzcih(this, zzb));
    }
    
    @WorkerThread
    public final void zza(final AtomicReference<String> atomicReference) {
        super.zzjC();
        this.zzkD();
        this.zzm(new zzcif(this, atomicReference));
    }
    
    @WorkerThread
    protected final void zza(final AtomicReference<List<zzcek>> atomicReference, final String s, final String s2, final String s3) {
        super.zzjC();
        this.zzkD();
        this.zzm(new zzcim(this, atomicReference, s, s2, s3));
    }
    
    @WorkerThread
    protected final void zza(final AtomicReference<List<zzcji>> atomicReference, final String s, final String s2, final String s3, final boolean b) {
        super.zzjC();
        this.zzkD();
        this.zzm(new zzcin(this, atomicReference, s, s2, s3, b));
    }
    
    @WorkerThread
    protected final void zza(final AtomicReference<List<zzcji>> atomicReference, final boolean b) {
        super.zzjC();
        this.zzkD();
        this.zzm(new zzcip(this, atomicReference, b));
    }
    
    @WorkerThread
    protected final void zzb(final zzcji zzcji) {
        super.zzjC();
        this.zzkD();
        zzcem.zzxE();
        this.zzm(new zzcio(this, super.zzwy().zza(zzcji), zzcji));
    }
    
    @WorkerThread
    protected final void zzc(final zzcez zzcez, final String s) {
        zzbo.zzu(zzcez);
        super.zzjC();
        this.zzkD();
        zzcem.zzxE();
        this.zzm(new zzcik(this, true, super.zzwy().zza(zzcez), zzcez, s));
    }
    
    @WorkerThread
    protected final void zzf(final zzcek zzcek) {
        zzbo.zzu(zzcek);
        super.zzjC();
        this.zzkD();
        zzcem.zzxE();
        this.zzm(new zzcil(this, true, super.zzwy().zzc(zzcek), new zzcek(zzcek), zzcek));
    }
    
    @Override
    protected final void zzjD() {
    }
    
    @WorkerThread
    final void zzla() {
        int n = 1;
        super.zzjC();
        this.zzkD();
        if (this.isConnected()) {
            return;
        }
        if (this.zzbtV == null) {
            this.zzbtV = super.zzwG().zzyI();
            if (this.zzbtV == null) {
                super.zzwF().zzyD().log("State of service unknown");
                super.zzjC();
                this.zzkD();
                zzcem.zzxE();
                super.zzwF().zzyD().log("Checking service availability");
                boolean b = false;
                Label_0150: {
                    switch (com.google.android.gms.common.zze.zzoW().isGooglePlayServicesAvailable(super.getContext())) {
                        case 0: {
                            super.zzwF().zzyD().log("Service available");
                            b = true;
                            break Label_0150;
                        }
                        case 1: {
                            super.zzwF().zzyD().log("Service missing");
                            break;
                        }
                        case 18: {
                            super.zzwF().zzyz().log("Service updating");
                            b = true;
                            break Label_0150;
                        }
                        case 2: {
                            super.zzwF().zzyC().log("Service container out of date");
                            b = true;
                            break Label_0150;
                        }
                        case 3: {
                            super.zzwF().zzyz().log("Service disabled");
                            break;
                        }
                        case 9: {
                            super.zzwF().zzyz().log("Service invalid");
                            break;
                        }
                    }
                    b = false;
                }
                this.zzbtV = b;
                super.zzwG().zzak(this.zzbtV);
            }
        }
        if (this.zzbtV) {
            super.zzwF().zzyD().log("Using measurement service");
            this.zzbtT.zzzm();
            return;
        }
        zzcem.zzxE();
        final List queryIntentServices = super.getContext().getPackageManager().queryIntentServices(new Intent().setClassName(super.getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (queryIntentServices == null || queryIntentServices.size() <= 0) {
            n = 0;
        }
        if (n != 0) {
            super.zzwF().zzyD().log("Using local app measurement service");
            final Intent intent = new Intent("com.google.android.gms.measurement.START");
            final Context context = super.getContext();
            zzcem.zzxE();
            intent.setComponent(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
            this.zzbtT.zzk(intent);
            return;
        }
        super.zzwF().zzyx().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
    }
    
    @WorkerThread
    protected final void zzzj() {
        super.zzjC();
        this.zzkD();
        this.zzm(new zzcij(this));
    }
    
    @WorkerThread
    protected final void zzzk() {
        super.zzjC();
        this.zzkD();
        this.zzm(new zzcig(this));
    }
}
