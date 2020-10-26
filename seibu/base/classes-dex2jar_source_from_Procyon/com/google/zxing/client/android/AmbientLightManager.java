// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.android;

import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.Sensor;
import android.os.Handler;
import android.content.Context;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import com.journeyapps.barcodescanner.camera.CameraManager;
import android.hardware.SensorEventListener;

public final class AmbientLightManager implements SensorEventListener
{
    private static final float BRIGHT_ENOUGH_LUX = 450.0f;
    private static final float TOO_DARK_LUX = 45.0f;
    private CameraManager cameraManager;
    private CameraSettings cameraSettings;
    private Context context;
    private Handler handler;
    private Sensor lightSensor;
    
    public AmbientLightManager(final Context context, final CameraManager cameraManager, final CameraSettings cameraSettings) {
        this.context = context;
        this.cameraManager = cameraManager;
        this.cameraSettings = cameraSettings;
        this.handler = new Handler();
    }
    
    private void setTorch(final boolean b) {
        this.handler.post((Runnable)new Runnable() {
            @Override
            public void run() {
                AmbientLightManager.this.cameraManager.setTorch(b);
            }
        });
    }
    
    public void onAccuracyChanged(final Sensor sensor, final int n) {
    }
    
    public void onSensorChanged(final SensorEvent sensorEvent) {
        final float n = sensorEvent.values[0];
        if (this.cameraManager != null) {
            if (n <= 45.0f) {
                this.setTorch(true);
            }
            else if (n >= 450.0f) {
                this.setTorch(false);
            }
        }
    }
    
    public void start() {
        if (this.cameraSettings.isAutoTorchEnabled()) {
            final SensorManager sensorManager = (SensorManager)this.context.getSystemService("sensor");
            this.lightSensor = sensorManager.getDefaultSensor(5);
            if (this.lightSensor != null) {
                sensorManager.registerListener((SensorEventListener)this, this.lightSensor, 3);
            }
        }
    }
    
    public void stop() {
        if (this.lightSensor != null) {
            ((SensorManager)this.context.getSystemService("sensor")).unregisterListener((SensorEventListener)this);
            this.lightSensor = null;
        }
    }
}
