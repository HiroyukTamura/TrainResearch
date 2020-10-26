// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import com.journeyapps.barcodescanner.SourceData;
import java.io.IOException;
import android.view.SurfaceHolder;
import android.hardware.Camera$PreviewCallback;
import com.google.zxing.client.android.camera.open.OpenCameraInterface;
import android.os.Build;
import android.os.Build$VERSION;
import com.google.zxing.client.android.camera.CameraConfigurationUtils;
import java.util.Iterator;
import android.hardware.Camera$Size;
import java.util.ArrayList;
import java.util.List;
import android.hardware.Camera$Parameters;
import android.util.Log;
import com.journeyapps.barcodescanner.Size;
import android.content.Context;
import android.hardware.Camera$CameraInfo;
import android.hardware.Camera;
import com.google.zxing.client.android.AmbientLightManager;

public final class CameraManager
{
    private static final String TAG;
    private AmbientLightManager ambientLightManager;
    private AutoFocusManager autoFocusManager;
    private Camera camera;
    private Camera$CameraInfo cameraInfo;
    private final CameraPreviewCallback cameraPreviewCallback;
    private Context context;
    private String defaultParameters;
    private DisplayConfiguration displayConfiguration;
    private Size previewSize;
    private boolean previewing;
    private Size requestedPreviewSize;
    private int rotationDegrees;
    private CameraSettings settings;
    
    static {
        TAG = CameraManager.class.getSimpleName();
    }
    
    public CameraManager(final Context context) {
        this.settings = new CameraSettings();
        this.rotationDegrees = -1;
        this.context = context;
        this.cameraPreviewCallback = new CameraPreviewCallback();
    }
    
    private int calculateDisplayRotation() {
        final int rotation = this.displayConfiguration.getRotation();
        int n = 0;
        switch (rotation) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 90;
                break;
            }
            case 2: {
                n = 180;
                break;
            }
            case 3: {
                n = 270;
                break;
            }
        }
        int i;
        if (this.cameraInfo.facing == 1) {
            i = (360 - (this.cameraInfo.orientation + n) % 360) % 360;
        }
        else {
            i = (this.cameraInfo.orientation - n + 360) % 360;
        }
        Log.i(CameraManager.TAG, "Camera Display Orientation: " + i);
        return i;
    }
    
    private Camera$Parameters getDefaultCameraParameters() {
        final Camera$Parameters parameters = this.camera.getParameters();
        if (this.defaultParameters == null) {
            this.defaultParameters = parameters.flatten();
            return parameters;
        }
        parameters.unflatten(this.defaultParameters);
        return parameters;
    }
    
    private static List<Size> getPreviewSizes(final Camera$Parameters camera$Parameters) {
        final List supportedPreviewSizes = camera$Parameters.getSupportedPreviewSizes();
        final ArrayList<Size> list = new ArrayList<Size>();
        if (supportedPreviewSizes == null) {
            final Camera$Size previewSize = camera$Parameters.getPreviewSize();
            if (previewSize != null) {
                list.add(new Size(previewSize.width, previewSize.height));
            }
        }
        else {
            for (final Camera$Size camera$Size : supportedPreviewSizes) {
                list.add(new Size(camera$Size.width, camera$Size.height));
            }
        }
        return list;
    }
    
    private void setCameraDisplayOrientation(final int displayOrientation) {
        this.camera.setDisplayOrientation(displayOrientation);
    }
    
    private void setDesiredParameters(final boolean b) {
        final Camera$Parameters defaultCameraParameters = this.getDefaultCameraParameters();
        if (defaultCameraParameters == null) {
            Log.w(CameraManager.TAG, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i(CameraManager.TAG, "Initial camera parameters: " + defaultCameraParameters.flatten());
        if (b) {
            Log.w(CameraManager.TAG, "In camera config safe mode -- most settings will not be honored");
        }
        CameraConfigurationUtils.setFocus(defaultCameraParameters, this.settings.getFocusMode(), b);
        if (!b) {
            CameraConfigurationUtils.setTorch(defaultCameraParameters, false);
            if (this.settings.isScanInverted()) {
                CameraConfigurationUtils.setInvertColor(defaultCameraParameters);
            }
            if (this.settings.isBarcodeSceneModeEnabled()) {
                CameraConfigurationUtils.setBarcodeSceneMode(defaultCameraParameters);
            }
            if (this.settings.isMeteringEnabled() && Build$VERSION.SDK_INT >= 15) {
                CameraConfigurationUtils.setVideoStabilization(defaultCameraParameters);
                CameraConfigurationUtils.setFocusArea(defaultCameraParameters);
                CameraConfigurationUtils.setMetering(defaultCameraParameters);
            }
        }
        final List<Size> previewSizes = getPreviewSizes(defaultCameraParameters);
        if (previewSizes.size() == 0) {
            this.requestedPreviewSize = null;
        }
        else {
            this.requestedPreviewSize = this.displayConfiguration.getBestPreviewSize(previewSizes, this.isCameraRotated());
            defaultCameraParameters.setPreviewSize(this.requestedPreviewSize.width, this.requestedPreviewSize.height);
        }
        if (Build.DEVICE.equals("glass-1")) {
            CameraConfigurationUtils.setBestPreviewFPS(defaultCameraParameters);
        }
        Log.i(CameraManager.TAG, "Final camera parameters: " + defaultCameraParameters.flatten());
        this.camera.setParameters(defaultCameraParameters);
    }
    
    private void setParameters() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0        
        //     2: invokespecial   com/journeyapps/barcodescanner/camera/CameraManager.calculateDisplayRotation:()I
        //     5: putfield        com/journeyapps/barcodescanner/camera/CameraManager.rotationDegrees:I
        //     8: aload_0        
        //     9: aload_0        
        //    10: getfield        com/journeyapps/barcodescanner/camera/CameraManager.rotationDegrees:I
        //    13: invokespecial   com/journeyapps/barcodescanner/camera/CameraManager.setCameraDisplayOrientation:(I)V
        //    16: aload_0        
        //    17: iconst_0       
        //    18: invokespecial   com/journeyapps/barcodescanner/camera/CameraManager.setDesiredParameters:(Z)V
        //    21: aload_0        
        //    22: getfield        com/journeyapps/barcodescanner/camera/CameraManager.camera:Landroid/hardware/Camera;
        //    25: invokevirtual   android/hardware/Camera.getParameters:()Landroid/hardware/Camera$Parameters;
        //    28: invokevirtual   android/hardware/Camera$Parameters.getPreviewSize:()Landroid/hardware/Camera$Size;
        //    31: astore_1       
        //    32: aload_1        
        //    33: ifnonnull       93
        //    36: aload_0        
        //    37: aload_0        
        //    38: getfield        com/journeyapps/barcodescanner/camera/CameraManager.requestedPreviewSize:Lcom/journeyapps/barcodescanner/Size;
        //    41: putfield        com/journeyapps/barcodescanner/camera/CameraManager.previewSize:Lcom/journeyapps/barcodescanner/Size;
        //    44: aload_0        
        //    45: getfield        com/journeyapps/barcodescanner/camera/CameraManager.cameraPreviewCallback:Lcom/journeyapps/barcodescanner/camera/CameraManager$CameraPreviewCallback;
        //    48: aload_0        
        //    49: getfield        com/journeyapps/barcodescanner/camera/CameraManager.previewSize:Lcom/journeyapps/barcodescanner/Size;
        //    52: invokevirtual   com/journeyapps/barcodescanner/camera/CameraManager$CameraPreviewCallback.setResolution:(Lcom/journeyapps/barcodescanner/Size;)V
        //    55: return         
        //    56: astore_1       
        //    57: getstatic       com/journeyapps/barcodescanner/camera/CameraManager.TAG:Ljava/lang/String;
        //    60: ldc_w           "Failed to set rotation."
        //    63: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //    66: pop            
        //    67: goto            16
        //    70: astore_1       
        //    71: aload_0        
        //    72: iconst_1       
        //    73: invokespecial   com/journeyapps/barcodescanner/camera/CameraManager.setDesiredParameters:(Z)V
        //    76: goto            21
        //    79: astore_1       
        //    80: getstatic       com/journeyapps/barcodescanner/camera/CameraManager.TAG:Ljava/lang/String;
        //    83: ldc_w           "Camera rejected even safe-mode parameters! No configuration"
        //    86: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //    89: pop            
        //    90: goto            21
        //    93: aload_0        
        //    94: new             Lcom/journeyapps/barcodescanner/Size;
        //    97: dup            
        //    98: aload_1        
        //    99: getfield        android/hardware/Camera$Size.width:I
        //   102: aload_1        
        //   103: getfield        android/hardware/Camera$Size.height:I
        //   106: invokespecial   com/journeyapps/barcodescanner/Size.<init>:(II)V
        //   109: putfield        com/journeyapps/barcodescanner/camera/CameraManager.previewSize:Lcom/journeyapps/barcodescanner/Size;
        //   112: goto            44
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      16     56     70     Ljava/lang/Exception;
        //  16     21     70     93     Ljava/lang/Exception;
        //  71     76     79     93     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0016:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void changeCameraParameters(final CameraParametersCallback cameraParametersCallback) {
        if (this.camera == null) {
            return;
        }
        try {
            this.camera.setParameters(cameraParametersCallback.changeCameraParameters(this.camera.getParameters()));
        }
        catch (RuntimeException ex) {
            Log.e(CameraManager.TAG, "Failed to change camera parameters", (Throwable)ex);
        }
    }
    
    public void close() {
        if (this.camera != null) {
            this.camera.release();
            this.camera = null;
        }
    }
    
    public void configure() {
        if (this.camera == null) {
            throw new RuntimeException("Camera not open");
        }
        this.setParameters();
    }
    
    public Camera getCamera() {
        return this.camera;
    }
    
    public int getCameraRotation() {
        return this.rotationDegrees;
    }
    
    public CameraSettings getCameraSettings() {
        return this.settings;
    }
    
    public DisplayConfiguration getDisplayConfiguration() {
        return this.displayConfiguration;
    }
    
    public Size getNaturalPreviewSize() {
        return this.previewSize;
    }
    
    public Size getPreviewSize() {
        if (this.previewSize == null) {
            return null;
        }
        if (this.isCameraRotated()) {
            return this.previewSize.rotate();
        }
        return this.previewSize;
    }
    
    public boolean isCameraRotated() {
        if (this.rotationDegrees == -1) {
            throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
        }
        return this.rotationDegrees % 180 != 0;
    }
    
    public boolean isOpen() {
        return this.camera != null;
    }
    
    public boolean isTorchOn() {
        final boolean b = false;
        final Camera$Parameters parameters = this.camera.getParameters();
        boolean b2 = b;
        if (parameters != null) {
            final String flashMode = parameters.getFlashMode();
            b2 = b;
            if (flashMode != null) {
                if (!"on".equals(flashMode)) {
                    b2 = b;
                    if (!"torch".equals(flashMode)) {
                        return b2;
                    }
                }
                b2 = true;
            }
        }
        return b2;
    }
    
    public void open() {
        this.camera = OpenCameraInterface.open(this.settings.getRequestedCameraId());
        if (this.camera == null) {
            throw new RuntimeException("Failed to open camera");
        }
        Camera.getCameraInfo(OpenCameraInterface.getCameraId(this.settings.getRequestedCameraId()), this.cameraInfo = new Camera$CameraInfo());
    }
    
    public void requestPreviewFrame(final PreviewCallback callback) {
        final Camera camera = this.camera;
        if (camera != null && this.previewing) {
            this.cameraPreviewCallback.setCallback(callback);
            camera.setOneShotPreviewCallback((Camera$PreviewCallback)this.cameraPreviewCallback);
        }
    }
    
    public void setCameraSettings(final CameraSettings settings) {
        this.settings = settings;
    }
    
    public void setDisplayConfiguration(final DisplayConfiguration displayConfiguration) {
        this.displayConfiguration = displayConfiguration;
    }
    
    public void setPreviewDisplay(final SurfaceHolder surfaceHolder) throws IOException {
        this.setPreviewDisplay(new CameraSurface(surfaceHolder));
    }
    
    public void setPreviewDisplay(final CameraSurface cameraSurface) throws IOException {
        cameraSurface.setPreview(this.camera);
    }
    
    public void setTorch(final boolean b) {
        if (this.camera == null) {
            return;
        }
        try {
            if (b != this.isTorchOn()) {
                if (this.autoFocusManager != null) {
                    this.autoFocusManager.stop();
                }
                final Camera$Parameters parameters = this.camera.getParameters();
                CameraConfigurationUtils.setTorch(parameters, b);
                if (this.settings.isExposureEnabled()) {
                    CameraConfigurationUtils.setBestExposure(parameters, b);
                }
                this.camera.setParameters(parameters);
                if (this.autoFocusManager != null) {
                    this.autoFocusManager.start();
                }
            }
        }
        catch (RuntimeException ex) {
            Log.e(CameraManager.TAG, "Failed to set torch", (Throwable)ex);
        }
    }
    
    public void startPreview() {
        final Camera camera = this.camera;
        if (camera != null && !this.previewing) {
            camera.startPreview();
            this.previewing = true;
            this.autoFocusManager = new AutoFocusManager(this.camera, this.settings);
            (this.ambientLightManager = new AmbientLightManager(this.context, this, this.settings)).start();
        }
    }
    
    public void stopPreview() {
        if (this.autoFocusManager != null) {
            this.autoFocusManager.stop();
            this.autoFocusManager = null;
        }
        if (this.ambientLightManager != null) {
            this.ambientLightManager.stop();
            this.ambientLightManager = null;
        }
        if (this.camera != null && this.previewing) {
            this.camera.stopPreview();
            this.cameraPreviewCallback.setCallback(null);
            this.previewing = false;
        }
    }
    
    private final class CameraPreviewCallback implements Camera$PreviewCallback
    {
        private PreviewCallback callback;
        private Size resolution;
        
        public CameraPreviewCallback() {
        }
        
        public void onPreviewFrame(final byte[] array, final Camera camera) {
            final Size resolution = this.resolution;
            final PreviewCallback callback = this.callback;
            if (resolution != null && callback != null) {
                if (array != null) {
                    callback.onPreview(new SourceData(array, resolution.width, resolution.height, camera.getParameters().getPreviewFormat(), CameraManager.this.getCameraRotation()));
                    return;
                }
                try {
                    throw new NullPointerException("No preview data received");
                }
                catch (RuntimeException ex) {
                    Log.e(CameraManager.TAG, "Camera preview failed", (Throwable)ex);
                    callback.onPreviewError(ex);
                }
            }
            else {
                Log.d(CameraManager.TAG, "Got preview callback, but no handler or resolution available");
                if (callback != null) {
                    callback.onPreviewError(new Exception("No resolution available"));
                }
            }
        }
        
        public void setCallback(final PreviewCallback callback) {
            this.callback = callback;
        }
        
        public void setResolution(final Size resolution) {
            this.resolution = resolution;
        }
    }
}
