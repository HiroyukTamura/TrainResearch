/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 */
package com.mixpanel.android.d;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class f
implements SensorEventListener {
    private int a = -1;
    private int b = 0;
    private long c = -1L;
    private final float[] d = new float[3];
    private final a e;

    public f(a a2) {
        this.e = a2;
    }

    private float[] a(float[] arrf) {
        for (int i2 = 0; i2 < 3; ++i2) {
            float f2 = this.d[i2];
            this.d[i2] = f2 + (arrf[i2] - f2) * 0.7f;
        }
        return this.d;
    }

    public void onAccuracyChanged(Sensor sensor, int n2) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] arrf = this.a(sensorEvent.values);
        int n2 = this.b;
        float f2 = arrf[0] * arrf[0] + arrf[1] * arrf[1] + arrf[2] * arrf[2];
        this.b = 0;
        if (arrf[2] > 7.8f && arrf[2] < 11.8f) {
            this.b = -1;
        }
        if (arrf[2] < -7.8f && arrf[2] > -11.8f) {
            this.b = 1;
        }
        if (f2 < 60.840004f || f2 > 139.24f) {
            this.b = 0;
        }
        if (n2 != this.b) {
            this.c = sensorEvent.timestamp;
        }
        long l2 = sensorEvent.timestamp - this.c;
        switch (this.b) {
            default: {
                return;
            }
            case 1: {
                if (l2 <= 250000000L || this.a != 0) break;
                com.mixpanel.android.c.f.a("MixpanelAPI.FlipGesture", "Flip gesture begun");
                this.a = 1;
                return;
            }
            case 0: {
                if (l2 <= 1000000000L || this.a == 0) break;
                com.mixpanel.android.c.f.a("MixpanelAPI.FlipGesture", "Flip gesture abandoned");
                this.a = 0;
                return;
            }
            case -1: {
                if (l2 <= 250000000L || this.a != 1) break;
                com.mixpanel.android.c.f.a("MixpanelAPI.FlipGesture", "Flip gesture completed");
                this.a = 0;
                this.e.a();
            }
        }
    }

    public static interface a {
        public void a();
    }

}

