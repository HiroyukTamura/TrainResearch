// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import android.content.Context;
import android.view.WindowManager;
import android.view.OrientationEventListener;

public class RotationListener
{
    private RotationCallback callback;
    private int lastRotation;
    private OrientationEventListener orientationEventListener;
    private WindowManager windowManager;
    
    public void listen(Context applicationContext, final RotationCallback callback) {
        this.stop();
        applicationContext = applicationContext.getApplicationContext();
        this.callback = callback;
        this.windowManager = (WindowManager)applicationContext.getSystemService("window");
        (this.orientationEventListener = new OrientationEventListener(applicationContext, 3) {
            public void onOrientationChanged(int rotation) {
                final WindowManager access$000 = RotationListener.this.windowManager;
                final RotationCallback access$2 = RotationListener.this.callback;
                if (RotationListener.this.windowManager != null && access$2 != null) {
                    rotation = access$000.getDefaultDisplay().getRotation();
                    if (rotation != RotationListener.this.lastRotation) {
                        RotationListener.this.lastRotation = rotation;
                        access$2.onRotationChanged(rotation);
                    }
                }
            }
        }).enable();
        this.lastRotation = this.windowManager.getDefaultDisplay().getRotation();
    }
    
    public void stop() {
        if (this.orientationEventListener != null) {
            this.orientationEventListener.disable();
        }
        this.orientationEventListener = null;
        this.windowManager = null;
        this.callback = null;
    }
}
