// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import android.os.Bundle;
import android.os.Parcelable;
import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import com.journeyapps.barcodescanner.camera.FitXYStrategy;
import com.journeyapps.barcodescanner.camera.FitCenterStrategy;
import com.journeyapps.barcodescanner.camera.CenterCropStrategy;
import com.journeyapps.barcodescanner.camera.CameraParametersCallback;
import android.graphics.Matrix;
import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.view.TextureView$SurfaceTextureListener;
import com.journeyapps.barcodescanner.camera.CameraSurface;
import android.view.View;
import android.util.AttributeSet;
import java.util.Iterator;
import com.google.zxing.client.android.R;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;
import java.util.ArrayList;
import android.content.Context;
import android.view.WindowManager;
import android.view.TextureView;
import android.view.SurfaceView;
import android.view.SurfaceHolder$Callback;
import java.util.List;
import android.os.Handler;
import android.os.Handler$Callback;
import com.journeyapps.barcodescanner.camera.PreviewScalingStrategy;
import android.graphics.Rect;
import com.journeyapps.barcodescanner.camera.DisplayConfiguration;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import com.journeyapps.barcodescanner.camera.CameraInstance;
import android.view.ViewGroup;

public class CameraPreview extends ViewGroup
{
    private static final int ROTATION_LISTENER_DELAY_MS = 250;
    private static final String TAG;
    private CameraInstance cameraInstance;
    private CameraSettings cameraSettings;
    private Size containerSize;
    private Size currentSurfaceSize;
    private DisplayConfiguration displayConfiguration;
    private final StateListener fireState;
    private Rect framingRect;
    private Size framingRectSize;
    private double marginFraction;
    private int openedOrientation;
    private boolean previewActive;
    private Rect previewFramingRect;
    private PreviewScalingStrategy previewScalingStrategy;
    private Size previewSize;
    private RotationCallback rotationCallback;
    private RotationListener rotationListener;
    private final Handler$Callback stateCallback;
    private Handler stateHandler;
    private List<StateListener> stateListeners;
    private final SurfaceHolder$Callback surfaceCallback;
    private Rect surfaceRect;
    private SurfaceView surfaceView;
    private TextureView textureView;
    private boolean torchOn;
    private boolean useTextureView;
    private WindowManager windowManager;
    
    static {
        TAG = CameraPreview.class.getSimpleName();
    }
    
    public CameraPreview(final Context context) {
        super(context);
        this.useTextureView = false;
        this.previewActive = false;
        this.openedOrientation = -1;
        this.stateListeners = new ArrayList<StateListener>();
        this.cameraSettings = new CameraSettings();
        this.framingRect = null;
        this.previewFramingRect = null;
        this.framingRectSize = null;
        this.marginFraction = 0.1;
        this.previewScalingStrategy = null;
        this.torchOn = false;
        this.surfaceCallback = (SurfaceHolder$Callback)new SurfaceHolder$Callback() {
            public void surfaceChanged(final SurfaceHolder surfaceHolder, final int n, final int n2, final int n3) {
                if (surfaceHolder == null) {
                    Log.e(CameraPreview.TAG, "*** WARNING *** surfaceChanged() gave us a null surface!");
                    return;
                }
                CameraPreview.this.currentSurfaceSize = new Size(n2, n3);
                CameraPreview.this.startPreviewIfReady();
            }
            
            public void surfaceCreated(final SurfaceHolder surfaceHolder) {
            }
            
            public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
                CameraPreview.this.currentSurfaceSize = null;
            }
        };
        this.stateCallback = (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (message.what == R.id.zxing_prewiew_size_ready) {
                    CameraPreview.this.previewSized((Size)message.obj);
                    return true;
                }
                if (message.what == R.id.zxing_camera_error) {
                    final Exception ex = (Exception)message.obj;
                    if (CameraPreview.this.isActive()) {
                        CameraPreview.this.pause();
                        CameraPreview.this.fireState.cameraError(ex);
                    }
                }
                else if (message.what == R.id.zxing_camera_closed) {
                    CameraPreview.this.fireState.cameraClosed();
                }
                return false;
            }
        };
        this.rotationCallback = new RotationCallback() {
            @Override
            public void onRotationChanged(final int n) {
                CameraPreview.this.stateHandler.postDelayed((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        CameraPreview.this.rotationChanged();
                    }
                }, 250L);
            }
        };
        this.fireState = (StateListener)new StateListener() {
            @Override
            public void cameraClosed() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().cameraClosed();
                }
            }
            
            @Override
            public void cameraError(final Exception ex) {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().cameraError(ex);
                }
            }
            
            @Override
            public void previewSized() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().previewSized();
                }
            }
            
            @Override
            public void previewStarted() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().previewStarted();
                }
            }
            
            @Override
            public void previewStopped() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().previewStopped();
                }
            }
        };
        this.initialize(context, null, 0, 0);
    }
    
    public CameraPreview(final Context context, final AttributeSet set) {
        super(context, set);
        this.useTextureView = false;
        this.previewActive = false;
        this.openedOrientation = -1;
        this.stateListeners = new ArrayList<StateListener>();
        this.cameraSettings = new CameraSettings();
        this.framingRect = null;
        this.previewFramingRect = null;
        this.framingRectSize = null;
        this.marginFraction = 0.1;
        this.previewScalingStrategy = null;
        this.torchOn = false;
        this.surfaceCallback = (SurfaceHolder$Callback)new SurfaceHolder$Callback() {
            public void surfaceChanged(final SurfaceHolder surfaceHolder, final int n, final int n2, final int n3) {
                if (surfaceHolder == null) {
                    Log.e(CameraPreview.TAG, "*** WARNING *** surfaceChanged() gave us a null surface!");
                    return;
                }
                CameraPreview.this.currentSurfaceSize = new Size(n2, n3);
                CameraPreview.this.startPreviewIfReady();
            }
            
            public void surfaceCreated(final SurfaceHolder surfaceHolder) {
            }
            
            public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
                CameraPreview.this.currentSurfaceSize = null;
            }
        };
        this.stateCallback = (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (message.what == R.id.zxing_prewiew_size_ready) {
                    CameraPreview.this.previewSized((Size)message.obj);
                    return true;
                }
                if (message.what == R.id.zxing_camera_error) {
                    final Exception ex = (Exception)message.obj;
                    if (CameraPreview.this.isActive()) {
                        CameraPreview.this.pause();
                        CameraPreview.this.fireState.cameraError(ex);
                    }
                }
                else if (message.what == R.id.zxing_camera_closed) {
                    CameraPreview.this.fireState.cameraClosed();
                }
                return false;
            }
        };
        this.rotationCallback = new RotationCallback() {
            @Override
            public void onRotationChanged(final int n) {
                CameraPreview.this.stateHandler.postDelayed((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        CameraPreview.this.rotationChanged();
                    }
                }, 250L);
            }
        };
        this.fireState = (StateListener)new StateListener() {
            @Override
            public void cameraClosed() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().cameraClosed();
                }
            }
            
            @Override
            public void cameraError(final Exception ex) {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().cameraError(ex);
                }
            }
            
            @Override
            public void previewSized() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().previewSized();
                }
            }
            
            @Override
            public void previewStarted() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().previewStarted();
                }
            }
            
            @Override
            public void previewStopped() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().previewStopped();
                }
            }
        };
        this.initialize(context, set, 0, 0);
    }
    
    public CameraPreview(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.useTextureView = false;
        this.previewActive = false;
        this.openedOrientation = -1;
        this.stateListeners = new ArrayList<StateListener>();
        this.cameraSettings = new CameraSettings();
        this.framingRect = null;
        this.previewFramingRect = null;
        this.framingRectSize = null;
        this.marginFraction = 0.1;
        this.previewScalingStrategy = null;
        this.torchOn = false;
        this.surfaceCallback = (SurfaceHolder$Callback)new SurfaceHolder$Callback() {
            public void surfaceChanged(final SurfaceHolder surfaceHolder, final int n, final int n2, final int n3) {
                if (surfaceHolder == null) {
                    Log.e(CameraPreview.TAG, "*** WARNING *** surfaceChanged() gave us a null surface!");
                    return;
                }
                CameraPreview.this.currentSurfaceSize = new Size(n2, n3);
                CameraPreview.this.startPreviewIfReady();
            }
            
            public void surfaceCreated(final SurfaceHolder surfaceHolder) {
            }
            
            public void surfaceDestroyed(final SurfaceHolder surfaceHolder) {
                CameraPreview.this.currentSurfaceSize = null;
            }
        };
        this.stateCallback = (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (message.what == R.id.zxing_prewiew_size_ready) {
                    CameraPreview.this.previewSized((Size)message.obj);
                    return true;
                }
                if (message.what == R.id.zxing_camera_error) {
                    final Exception ex = (Exception)message.obj;
                    if (CameraPreview.this.isActive()) {
                        CameraPreview.this.pause();
                        CameraPreview.this.fireState.cameraError(ex);
                    }
                }
                else if (message.what == R.id.zxing_camera_closed) {
                    CameraPreview.this.fireState.cameraClosed();
                }
                return false;
            }
        };
        this.rotationCallback = new RotationCallback() {
            @Override
            public void onRotationChanged(final int n) {
                CameraPreview.this.stateHandler.postDelayed((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        CameraPreview.this.rotationChanged();
                    }
                }, 250L);
            }
        };
        this.fireState = (StateListener)new StateListener() {
            @Override
            public void cameraClosed() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().cameraClosed();
                }
            }
            
            @Override
            public void cameraError(final Exception ex) {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().cameraError(ex);
                }
            }
            
            @Override
            public void previewSized() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().previewSized();
                }
            }
            
            @Override
            public void previewStarted() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().previewStarted();
                }
            }
            
            @Override
            public void previewStopped() {
                final Iterator<StateListener> iterator = CameraPreview.this.stateListeners.iterator();
                while (iterator.hasNext()) {
                    iterator.next().previewStopped();
                }
            }
        };
        this.initialize(context, set, n, 0);
    }
    
    private void calculateFrames() {
        if (this.containerSize == null || this.previewSize == null || this.displayConfiguration == null) {
            this.previewFramingRect = null;
            this.framingRect = null;
            this.surfaceRect = null;
            throw new IllegalStateException("containerSize or previewSize is not set yet");
        }
        final int width = this.previewSize.width;
        final int height = this.previewSize.height;
        final int width2 = this.containerSize.width;
        final int height2 = this.containerSize.height;
        this.surfaceRect = this.displayConfiguration.scalePreview(this.previewSize);
        this.framingRect = this.calculateFramingRect(new Rect(0, 0, width2, height2), this.surfaceRect);
        final Rect rect = new Rect(this.framingRect);
        rect.offset(-this.surfaceRect.left, -this.surfaceRect.top);
        this.previewFramingRect = new Rect(rect.left * width / this.surfaceRect.width(), rect.top * height / this.surfaceRect.height(), rect.right * width / this.surfaceRect.width(), rect.bottom * height / this.surfaceRect.height());
        if (this.previewFramingRect.width() <= 0 || this.previewFramingRect.height() <= 0) {
            this.previewFramingRect = null;
            this.framingRect = null;
            Log.w(CameraPreview.TAG, "Preview frame is too small");
            return;
        }
        this.fireState.previewSized();
    }
    
    private void containerSized(final Size containerSize) {
        this.containerSize = containerSize;
        if (this.cameraInstance != null && this.cameraInstance.getDisplayConfiguration() == null) {
            (this.displayConfiguration = new DisplayConfiguration(this.getDisplayRotation(), containerSize)).setPreviewScalingStrategy(this.getPreviewScalingStrategy());
            this.cameraInstance.setDisplayConfiguration(this.displayConfiguration);
            this.cameraInstance.configureCamera();
            if (this.torchOn) {
                this.cameraInstance.setTorch(this.torchOn);
            }
        }
    }
    
    private int getDisplayRotation() {
        return this.windowManager.getDefaultDisplay().getRotation();
    }
    
    private void initCamera() {
        if (this.cameraInstance != null) {
            Log.w(CameraPreview.TAG, "initCamera called twice");
            return;
        }
        (this.cameraInstance = this.createCameraInstance()).setReadyHandler(this.stateHandler);
        this.cameraInstance.open();
        this.openedOrientation = this.getDisplayRotation();
    }
    
    private void initialize(final Context context, final AttributeSet set, final int n, final int n2) {
        if (this.getBackground() == null) {
            this.setBackgroundColor(-16777216);
        }
        this.initializeAttributes(set);
        this.windowManager = (WindowManager)context.getSystemService("window");
        this.stateHandler = new Handler(this.stateCallback);
        this.rotationListener = new RotationListener();
    }
    
    private void previewSized(final Size previewSize) {
        this.previewSize = previewSize;
        if (this.containerSize != null) {
            this.calculateFrames();
            this.requestLayout();
            this.startPreviewIfReady();
        }
    }
    
    private void rotationChanged() {
        if (this.isActive() && this.getDisplayRotation() != this.openedOrientation) {
            this.pause();
            this.resume();
        }
    }
    
    private void setupSurfaceView() {
        if (this.useTextureView) {
            (this.textureView = new TextureView(this.getContext())).setSurfaceTextureListener(this.surfaceTextureListener());
            this.addView((View)this.textureView);
            return;
        }
        this.surfaceView = new SurfaceView(this.getContext());
        this.surfaceView.getHolder().addCallback(this.surfaceCallback);
        this.addView((View)this.surfaceView);
    }
    
    private void startCameraPreview(final CameraSurface surface) {
        if (!this.previewActive && this.cameraInstance != null) {
            Log.i(CameraPreview.TAG, "Starting preview");
            this.cameraInstance.setSurface(surface);
            this.cameraInstance.startPreview();
            this.previewActive = true;
            this.previewStarted();
            this.fireState.previewStarted();
        }
    }
    
    private void startPreviewIfReady() {
        if (this.currentSurfaceSize != null && this.previewSize != null && this.surfaceRect != null) {
            if (this.surfaceView != null && this.currentSurfaceSize.equals(new Size(this.surfaceRect.width(), this.surfaceRect.height()))) {
                this.startCameraPreview(new CameraSurface(this.surfaceView.getHolder()));
            }
            else if (this.textureView != null && this.textureView.getSurfaceTexture() != null) {
                if (this.previewSize != null) {
                    this.textureView.setTransform(this.calculateTextureTransform(new Size(this.textureView.getWidth(), this.textureView.getHeight()), this.previewSize));
                }
                this.startCameraPreview(new CameraSurface(this.textureView.getSurfaceTexture()));
            }
        }
    }
    
    @TargetApi(14)
    private TextureView$SurfaceTextureListener surfaceTextureListener() {
        return (TextureView$SurfaceTextureListener)new TextureView$SurfaceTextureListener() {
            public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, final int n, final int n2) {
                this.onSurfaceTextureSizeChanged(surfaceTexture, n, n2);
            }
            
            public boolean onSurfaceTextureDestroyed(final SurfaceTexture surfaceTexture) {
                return false;
            }
            
            public void onSurfaceTextureSizeChanged(final SurfaceTexture surfaceTexture, final int n, final int n2) {
                CameraPreview.this.currentSurfaceSize = new Size(n, n2);
                CameraPreview.this.startPreviewIfReady();
            }
            
            public void onSurfaceTextureUpdated(final SurfaceTexture surfaceTexture) {
            }
        };
    }
    
    public void addStateListener(final StateListener stateListener) {
        this.stateListeners.add(stateListener);
    }
    
    protected Rect calculateFramingRect(Rect rect, final Rect rect2) {
        rect = new Rect(rect);
        rect.intersect(rect2);
        if (this.framingRectSize != null) {
            rect.inset(Math.max(0, (rect.width() - this.framingRectSize.width) / 2), Math.max(0, (rect.height() - this.framingRectSize.height) / 2));
        }
        else {
            final int n = (int)Math.min(rect.width() * this.marginFraction, rect.height() * this.marginFraction);
            rect.inset(n, n);
            if (rect.height() > rect.width()) {
                rect.inset(0, (rect.height() - rect.width()) / 2);
                return rect;
            }
        }
        return rect;
    }
    
    protected Matrix calculateTextureTransform(final Size size, final Size size2) {
        final float n = size.width / (float)size.height;
        final float n2 = size2.width / (float)size2.height;
        float n3;
        float n4;
        if (n < n2) {
            n3 = n2 / n;
            n4 = 1.0f;
        }
        else {
            n3 = 1.0f;
            n4 = n / n2;
        }
        final Matrix matrix = new Matrix();
        matrix.setScale(n3, n4);
        matrix.postTranslate((size.width - size.width * n3) / 2.0f, (size.height - size.height * n4) / 2.0f);
        return matrix;
    }
    
    public void changeCameraParameters(final CameraParametersCallback cameraParametersCallback) {
        if (this.cameraInstance != null) {
            this.cameraInstance.changeCameraParameters(cameraParametersCallback);
        }
    }
    
    protected CameraInstance createCameraInstance() {
        final CameraInstance cameraInstance = new CameraInstance(this.getContext());
        cameraInstance.setCameraSettings(this.cameraSettings);
        return cameraInstance;
    }
    
    public CameraInstance getCameraInstance() {
        return this.cameraInstance;
    }
    
    public CameraSettings getCameraSettings() {
        return this.cameraSettings;
    }
    
    public Rect getFramingRect() {
        return this.framingRect;
    }
    
    public Size getFramingRectSize() {
        return this.framingRectSize;
    }
    
    public double getMarginFraction() {
        return this.marginFraction;
    }
    
    public Rect getPreviewFramingRect() {
        return this.previewFramingRect;
    }
    
    public PreviewScalingStrategy getPreviewScalingStrategy() {
        if (this.previewScalingStrategy != null) {
            return this.previewScalingStrategy;
        }
        if (this.textureView != null) {
            return new CenterCropStrategy();
        }
        return new FitCenterStrategy();
    }
    
    protected void initializeAttributes(final AttributeSet set) {
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, R.styleable.zxing_camera_preview);
        final int n = (int)obtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        final int n2 = (int)obtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (n > 0 && n2 > 0) {
            this.framingRectSize = new Size(n, n2);
        }
        this.useTextureView = obtainStyledAttributes.getBoolean(R.styleable.zxing_camera_preview_zxing_use_texture_view, true);
        final int integer = obtainStyledAttributes.getInteger(R.styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (integer == 1) {
            this.previewScalingStrategy = new CenterCropStrategy();
        }
        else if (integer == 2) {
            this.previewScalingStrategy = new FitCenterStrategy();
        }
        else if (integer == 3) {
            this.previewScalingStrategy = new FitXYStrategy();
        }
        obtainStyledAttributes.recycle();
    }
    
    protected boolean isActive() {
        return this.cameraInstance != null;
    }
    
    public boolean isCameraClosed() {
        return this.cameraInstance == null || this.cameraInstance.isCameraClosed();
    }
    
    public boolean isPreviewActive() {
        return this.previewActive;
    }
    
    public boolean isUseTextureView() {
        return this.useTextureView;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.setupSurfaceView();
    }
    
    @SuppressLint({ "DrawAllocation" })
    protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
        this.containerSized(new Size(n3 - n, n4 - n2));
        if (this.surfaceView != null) {
            if (this.surfaceRect != null) {
                this.surfaceView.layout(this.surfaceRect.left, this.surfaceRect.top, this.surfaceRect.right, this.surfaceRect.bottom);
                return;
            }
            this.surfaceView.layout(0, 0, this.getWidth(), this.getHeight());
        }
        else if (this.textureView != null) {
            this.textureView.layout(0, 0, this.getWidth(), this.getHeight());
        }
    }
    
    protected void onRestoreInstanceState(final Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        final Bundle bundle = (Bundle)parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        this.setTorch(bundle.getBoolean("torch"));
    }
    
    protected Parcelable onSaveInstanceState() {
        final Parcelable onSaveInstanceState = super.onSaveInstanceState();
        final Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.torchOn);
        return (Parcelable)bundle;
    }
    
    public void pause() {
        Util.validateMainThread();
        Log.d(CameraPreview.TAG, "pause()");
        this.openedOrientation = -1;
        if (this.cameraInstance != null) {
            this.cameraInstance.close();
            this.cameraInstance = null;
            this.previewActive = false;
        }
        else {
            this.stateHandler.sendEmptyMessage(R.id.zxing_camera_closed);
        }
        if (this.currentSurfaceSize == null && this.surfaceView != null) {
            this.surfaceView.getHolder().removeCallback(this.surfaceCallback);
        }
        if (this.currentSurfaceSize == null && this.textureView != null) {
            this.textureView.setSurfaceTextureListener((TextureView$SurfaceTextureListener)null);
        }
        this.containerSize = null;
        this.previewSize = null;
        this.previewFramingRect = null;
        this.rotationListener.stop();
        this.fireState.previewStopped();
    }
    
    public void pauseAndWait() {
        final CameraInstance cameraInstance = this.getCameraInstance();
        this.pause();
        final long nanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.isCameraClosed() && System.nanoTime() - nanoTime <= 2000000000L) {
            try {
                Thread.sleep(1L);
            }
            catch (InterruptedException ex) {}
        }
    }
    
    protected void previewStarted() {
    }
    
    public void resume() {
        Util.validateMainThread();
        Log.d(CameraPreview.TAG, "resume()");
        this.initCamera();
        if (this.currentSurfaceSize != null) {
            this.startPreviewIfReady();
        }
        else if (this.surfaceView != null) {
            this.surfaceView.getHolder().addCallback(this.surfaceCallback);
        }
        else if (this.textureView != null) {
            if (this.textureView.isAvailable()) {
                this.surfaceTextureListener().onSurfaceTextureAvailable(this.textureView.getSurfaceTexture(), this.textureView.getWidth(), this.textureView.getHeight());
            }
            else {
                this.textureView.setSurfaceTextureListener(this.surfaceTextureListener());
            }
        }
        this.requestLayout();
        this.rotationListener.listen(this.getContext(), this.rotationCallback);
    }
    
    public void setCameraSettings(final CameraSettings cameraSettings) {
        this.cameraSettings = cameraSettings;
    }
    
    public void setFramingRectSize(final Size framingRectSize) {
        this.framingRectSize = framingRectSize;
    }
    
    public void setMarginFraction(final double marginFraction) {
        if (marginFraction >= 0.5) {
            throw new IllegalArgumentException("The margin fraction must be less than 0.5");
        }
        this.marginFraction = marginFraction;
    }
    
    public void setPreviewScalingStrategy(final PreviewScalingStrategy previewScalingStrategy) {
        this.previewScalingStrategy = previewScalingStrategy;
    }
    
    public void setTorch(final boolean b) {
        this.torchOn = b;
        if (this.cameraInstance != null) {
            this.cameraInstance.setTorch(b);
        }
    }
    
    public void setUseTextureView(final boolean useTextureView) {
        this.useTextureView = useTextureView;
    }
    
    public interface StateListener
    {
        void cameraClosed();
        
        void cameraError(final Exception p0);
        
        void previewSized();
        
        void previewStarted();
        
        void previewStopped();
    }
}
