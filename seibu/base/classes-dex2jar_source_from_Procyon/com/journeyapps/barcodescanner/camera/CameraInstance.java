// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import android.view.SurfaceHolder;
import com.journeyapps.barcodescanner.Size;
import com.journeyapps.barcodescanner.Util;
import com.google.zxing.client.android.R;
import android.util.Log;
import android.content.Context;
import android.os.Handler;

public class CameraInstance
{
    private static final String TAG;
    private boolean cameraClosed;
    private CameraManager cameraManager;
    private CameraSettings cameraSettings;
    private CameraThread cameraThread;
    private Runnable closer;
    private Runnable configure;
    private DisplayConfiguration displayConfiguration;
    private Handler mainHandler;
    private boolean open;
    private Runnable opener;
    private Runnable previewStarter;
    private Handler readyHandler;
    private CameraSurface surface;
    
    static {
        TAG = CameraInstance.class.getSimpleName();
    }
    
    public CameraInstance(final Context context) {
        this.open = false;
        this.cameraClosed = true;
        this.cameraSettings = new CameraSettings();
        this.opener = new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(CameraInstance.TAG, "Opening camera");
                    CameraInstance.this.cameraManager.open();
                }
                catch (Exception ex) {
                    CameraInstance.this.notifyError(ex);
                    Log.e(CameraInstance.TAG, "Failed to open camera", (Throwable)ex);
                }
            }
        };
        this.configure = new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(CameraInstance.TAG, "Configuring camera");
                    CameraInstance.this.cameraManager.configure();
                    if (CameraInstance.this.readyHandler != null) {
                        CameraInstance.this.readyHandler.obtainMessage(R.id.zxing_prewiew_size_ready, (Object)CameraInstance.this.getPreviewSize()).sendToTarget();
                    }
                }
                catch (Exception ex) {
                    CameraInstance.this.notifyError(ex);
                    Log.e(CameraInstance.TAG, "Failed to configure camera", (Throwable)ex);
                }
            }
        };
        this.previewStarter = new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(CameraInstance.TAG, "Starting preview");
                    CameraInstance.this.cameraManager.setPreviewDisplay(CameraInstance.this.surface);
                    CameraInstance.this.cameraManager.startPreview();
                }
                catch (Exception ex) {
                    CameraInstance.this.notifyError(ex);
                    Log.e(CameraInstance.TAG, "Failed to start preview", (Throwable)ex);
                }
            }
        };
        this.closer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Log.d(CameraInstance.TAG, "Closing camera");
                        CameraInstance.this.cameraManager.stopPreview();
                        CameraInstance.this.cameraManager.close();
                        CameraInstance.this.cameraClosed = true;
                        CameraInstance.this.readyHandler.sendEmptyMessage(R.id.zxing_camera_closed);
                        CameraInstance.this.cameraThread.decrementInstances();
                    }
                    catch (Exception ex) {
                        Log.e(CameraInstance.TAG, "Failed to close camera", (Throwable)ex);
                        continue;
                    }
                    break;
                }
            }
        };
        Util.validateMainThread();
        this.cameraThread = CameraThread.getInstance();
        (this.cameraManager = new CameraManager(context)).setCameraSettings(this.cameraSettings);
        this.mainHandler = new Handler();
    }
    
    public CameraInstance(final CameraManager cameraManager) {
        this.open = false;
        this.cameraClosed = true;
        this.cameraSettings = new CameraSettings();
        this.opener = new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(CameraInstance.TAG, "Opening camera");
                    CameraInstance.this.cameraManager.open();
                }
                catch (Exception ex) {
                    CameraInstance.this.notifyError(ex);
                    Log.e(CameraInstance.TAG, "Failed to open camera", (Throwable)ex);
                }
            }
        };
        this.configure = new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(CameraInstance.TAG, "Configuring camera");
                    CameraInstance.this.cameraManager.configure();
                    if (CameraInstance.this.readyHandler != null) {
                        CameraInstance.this.readyHandler.obtainMessage(R.id.zxing_prewiew_size_ready, (Object)CameraInstance.this.getPreviewSize()).sendToTarget();
                    }
                }
                catch (Exception ex) {
                    CameraInstance.this.notifyError(ex);
                    Log.e(CameraInstance.TAG, "Failed to configure camera", (Throwable)ex);
                }
            }
        };
        this.previewStarter = new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d(CameraInstance.TAG, "Starting preview");
                    CameraInstance.this.cameraManager.setPreviewDisplay(CameraInstance.this.surface);
                    CameraInstance.this.cameraManager.startPreview();
                }
                catch (Exception ex) {
                    CameraInstance.this.notifyError(ex);
                    Log.e(CameraInstance.TAG, "Failed to start preview", (Throwable)ex);
                }
            }
        };
        this.closer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Log.d(CameraInstance.TAG, "Closing camera");
                        CameraInstance.this.cameraManager.stopPreview();
                        CameraInstance.this.cameraManager.close();
                        CameraInstance.this.cameraClosed = true;
                        CameraInstance.this.readyHandler.sendEmptyMessage(R.id.zxing_camera_closed);
                        CameraInstance.this.cameraThread.decrementInstances();
                    }
                    catch (Exception ex) {
                        Log.e(CameraInstance.TAG, "Failed to close camera", (Throwable)ex);
                        continue;
                    }
                    break;
                }
            }
        };
        Util.validateMainThread();
        this.cameraManager = cameraManager;
    }
    
    private Size getPreviewSize() {
        return this.cameraManager.getPreviewSize();
    }
    
    private void notifyError(final Exception ex) {
        if (this.readyHandler != null) {
            this.readyHandler.obtainMessage(R.id.zxing_camera_error, (Object)ex).sendToTarget();
        }
    }
    
    private void validateOpen() {
        if (!this.open) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }
    
    public void changeCameraParameters(final CameraParametersCallback cameraParametersCallback) {
        Util.validateMainThread();
        if (this.open) {
            this.cameraThread.enqueue(new Runnable() {
                @Override
                public void run() {
                    CameraInstance.this.cameraManager.changeCameraParameters(cameraParametersCallback);
                }
            });
        }
    }
    
    public void close() {
        Util.validateMainThread();
        if (this.open) {
            this.cameraThread.enqueue(this.closer);
        }
        else {
            this.cameraClosed = true;
        }
        this.open = false;
    }
    
    public void configureCamera() {
        Util.validateMainThread();
        this.validateOpen();
        this.cameraThread.enqueue(this.configure);
    }
    
    protected CameraManager getCameraManager() {
        return this.cameraManager;
    }
    
    public int getCameraRotation() {
        return this.cameraManager.getCameraRotation();
    }
    
    public CameraSettings getCameraSettings() {
        return this.cameraSettings;
    }
    
    protected CameraThread getCameraThread() {
        return this.cameraThread;
    }
    
    public DisplayConfiguration getDisplayConfiguration() {
        return this.displayConfiguration;
    }
    
    protected CameraSurface getSurface() {
        return this.surface;
    }
    
    public boolean isCameraClosed() {
        return this.cameraClosed;
    }
    
    public boolean isOpen() {
        return this.open;
    }
    
    public void open() {
        Util.validateMainThread();
        this.open = true;
        this.cameraClosed = false;
        this.cameraThread.incrementAndEnqueue(this.opener);
    }
    
    public void requestPreview(final PreviewCallback previewCallback) {
        this.mainHandler.post((Runnable)new Runnable() {
            @Override
            public void run() {
                if (!CameraInstance.this.open) {
                    Log.d(CameraInstance.TAG, "Camera is closed, not requesting preview");
                    return;
                }
                CameraInstance.this.cameraThread.enqueue(new Runnable() {
                    @Override
                    public void run() {
                        CameraInstance.this.cameraManager.requestPreviewFrame(previewCallback);
                    }
                });
            }
        });
    }
    
    public void setCameraSettings(final CameraSettings cameraSettings) {
        if (!this.open) {
            this.cameraSettings = cameraSettings;
            this.cameraManager.setCameraSettings(cameraSettings);
        }
    }
    
    public void setDisplayConfiguration(final DisplayConfiguration displayConfiguration) {
        this.displayConfiguration = displayConfiguration;
        this.cameraManager.setDisplayConfiguration(displayConfiguration);
    }
    
    public void setReadyHandler(final Handler readyHandler) {
        this.readyHandler = readyHandler;
    }
    
    public void setSurface(final CameraSurface surface) {
        this.surface = surface;
    }
    
    public void setSurfaceHolder(final SurfaceHolder surfaceHolder) {
        this.setSurface(new CameraSurface(surfaceHolder));
    }
    
    public void setTorch(final boolean b) {
        Util.validateMainThread();
        if (this.open) {
            this.cameraThread.enqueue(new Runnable() {
                @Override
                public void run() {
                    CameraInstance.this.cameraManager.setTorch(b);
                }
            });
        }
    }
    
    public void startPreview() {
        Util.validateMainThread();
        this.validateOpen();
        this.cameraThread.enqueue(this.previewStarter);
    }
}
