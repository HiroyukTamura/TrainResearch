// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import android.util.Log;
import android.os.Message;
import java.util.ArrayList;
import android.os.Handler;
import android.os.Handler$Callback;
import android.hardware.Camera;
import android.hardware.Camera$AutoFocusCallback;
import java.util.Collection;

public final class AutoFocusManager
{
    private static final long AUTO_FOCUS_INTERVAL_MS = 2000L;
    private static final Collection<String> FOCUS_MODES_CALLING_AF;
    private static final String TAG;
    private int MESSAGE_FOCUS;
    private final Camera$AutoFocusCallback autoFocusCallback;
    private final Camera camera;
    private final Handler$Callback focusHandlerCallback;
    private boolean focusing;
    private Handler handler;
    private boolean stopped;
    private final boolean useAutoFocus;
    
    static {
        TAG = AutoFocusManager.class.getSimpleName();
        (FOCUS_MODES_CALLING_AF = new ArrayList<String>(2)).add("auto");
        AutoFocusManager.FOCUS_MODES_CALLING_AF.add("macro");
    }
    
    public AutoFocusManager(final Camera camera, final CameraSettings cameraSettings) {
        boolean useAutoFocus = true;
        this.MESSAGE_FOCUS = 1;
        this.focusHandlerCallback = (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (message.what == AutoFocusManager.this.MESSAGE_FOCUS) {
                    AutoFocusManager.this.focus();
                    return true;
                }
                return false;
            }
        };
        this.autoFocusCallback = (Camera$AutoFocusCallback)new Camera$AutoFocusCallback() {
            public void onAutoFocus(final boolean b, final Camera camera) {
                AutoFocusManager.this.handler.post((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        AutoFocusManager.this.focusing = false;
                        AutoFocusManager.this.autoFocusAgainLater();
                    }
                });
            }
        };
        this.handler = new Handler(this.focusHandlerCallback);
        this.camera = camera;
        final String focusMode = camera.getParameters().getFocusMode();
        if (!cameraSettings.isAutoFocusEnabled() || !AutoFocusManager.FOCUS_MODES_CALLING_AF.contains(focusMode)) {
            useAutoFocus = false;
        }
        this.useAutoFocus = useAutoFocus;
        Log.i(AutoFocusManager.TAG, "Current focus mode '" + focusMode + "'; use auto focus? " + this.useAutoFocus);
        this.start();
    }
    
    private void autoFocusAgainLater() {
        synchronized (this) {
            if (!this.stopped && !this.handler.hasMessages(this.MESSAGE_FOCUS)) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(this.MESSAGE_FOCUS), 2000L);
            }
        }
    }
    
    private void cancelOutstandingTask() {
        this.handler.removeMessages(this.MESSAGE_FOCUS);
    }
    
    private void focus() {
        if (!this.useAutoFocus || this.stopped || this.focusing) {
            return;
        }
        try {
            this.camera.autoFocus(this.autoFocusCallback);
            this.focusing = true;
        }
        catch (RuntimeException ex) {
            Log.w(AutoFocusManager.TAG, "Unexpected exception while focusing", (Throwable)ex);
            this.autoFocusAgainLater();
        }
    }
    
    public void start() {
        this.stopped = false;
        this.focus();
    }
    
    public void stop() {
        this.stopped = true;
        this.focusing = false;
        this.cancelOutstandingTask();
        if (!this.useAutoFocus) {
            return;
        }
        try {
            this.camera.cancelAutoFocus();
        }
        catch (RuntimeException ex) {
            Log.w(AutoFocusManager.TAG, "Unexpected exception while cancelling focusing", (Throwable)ex);
        }
    }
}
