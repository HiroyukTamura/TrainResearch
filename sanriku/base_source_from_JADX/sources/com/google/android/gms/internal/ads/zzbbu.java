package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;

final class zzbbu implements SensorEventListener {
    private final SensorManager zzeck;
    private final Object zzecl = new Object();
    private final Display zzecm;
    private final float[] zzecn = new float[9];
    private final float[] zzeco = new float[9];
    private float[] zzecp;
    private Handler zzecq;
    private zzbbw zzecr;

    zzbbu(Context context) {
        this.zzeck = (SensorManager) context.getSystemService("sensor");
        this.zzecm = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private final void zzl(int i, int i2) {
        float[] fArr = this.zzeco;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.zzecl) {
                if (this.zzecp == null) {
                    this.zzecp = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.zzecn, fArr);
            int rotation = this.zzecm.getRotation();
            if (rotation == 1) {
                SensorManager.remapCoordinateSystem(this.zzecn, 2, 129, this.zzeco);
            } else if (rotation == 2) {
                SensorManager.remapCoordinateSystem(this.zzecn, 129, 130, this.zzeco);
            } else if (rotation != 3) {
                System.arraycopy(this.zzecn, 0, this.zzeco, 0, 9);
            } else {
                SensorManager.remapCoordinateSystem(this.zzecn, 130, 1, this.zzeco);
            }
            zzl(1, 3);
            zzl(2, 6);
            zzl(5, 7);
            synchronized (this.zzecl) {
                System.arraycopy(this.zzeco, 0, this.zzecp, 0, 9);
            }
            zzbbw zzbbw = this.zzecr;
            if (zzbbw != null) {
                zzbbw.zzul();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void start() {
        if (this.zzecq == null) {
            Sensor defaultSensor = this.zzeck.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzazw.zzfa("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            zzdns zzdns = new zzdns(handlerThread.getLooper());
            this.zzecq = zzdns;
            if (!this.zzeck.registerListener(this, defaultSensor, 0, zzdns)) {
                zzazw.zzfa("SensorManager.registerListener failed.");
                stop();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void stop() {
        if (this.zzecq != null) {
            this.zzeck.unregisterListener(this);
            this.zzecq.post(new zzbbt(this));
            this.zzecq = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbbw zzbbw) {
        this.zzecr = zzbbw;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(float[] fArr) {
        synchronized (this.zzecl) {
            if (this.zzecp == null) {
                return false;
            }
            System.arraycopy(this.zzecp, 0, fArr, 0, this.zzecp.length);
            return true;
        }
    }
}
