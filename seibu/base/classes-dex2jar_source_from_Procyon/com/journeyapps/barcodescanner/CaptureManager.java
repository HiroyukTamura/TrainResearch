// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import android.os.Build$VERSION;
import android.os.Bundle;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import com.google.zxing.client.android.R;
import android.app.AlertDialog$Builder;
import java.util.Iterator;
import java.util.Map;
import com.google.zxing.ResultMetadataType;
import android.content.Intent;
import android.annotation.TargetApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.graphics.Bitmap;
import java.io.IOException;
import java.io.OutputStream;
import android.graphics.Bitmap$CompressFormat;
import java.io.FileOutputStream;
import java.io.File;
import android.content.Context;
import android.util.Log;
import com.google.zxing.ResultPoint;
import java.util.List;
import com.google.zxing.client.android.InactivityTimer;
import android.os.Handler;
import com.google.zxing.client.android.BeepManager;
import android.app.Activity;

public class CaptureManager
{
    private static final String SAVED_ORIENTATION_LOCK = "SAVED_ORIENTATION_LOCK";
    private static final String TAG;
    private static int cameraPermissionReqCode;
    private Activity activity;
    private boolean askedPermission;
    private DecoratedBarcodeView barcodeView;
    private BeepManager beepManager;
    private BarcodeCallback callback;
    private boolean destroyed;
    private boolean finishWhenClosed;
    private Handler handler;
    private InactivityTimer inactivityTimer;
    private int orientationLock;
    private boolean returnBarcodeImagePath;
    private final CameraPreview.StateListener stateListener;
    
    static {
        TAG = CaptureManager.class.getSimpleName();
        CaptureManager.cameraPermissionReqCode = 250;
    }
    
    public CaptureManager(final Activity activity, final DecoratedBarcodeView barcodeView) {
        this.orientationLock = -1;
        this.returnBarcodeImagePath = false;
        this.destroyed = false;
        this.finishWhenClosed = false;
        this.callback = new BarcodeCallback() {
            @Override
            public void barcodeResult(final BarcodeResult barcodeResult) {
                CaptureManager.this.barcodeView.pause();
                CaptureManager.this.beepManager.playBeepSoundAndVibrate();
                CaptureManager.this.handler.post((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        CaptureManager.this.returnResult(barcodeResult);
                    }
                });
            }
            
            @Override
            public void possibleResultPoints(final List<ResultPoint> list) {
            }
        };
        this.stateListener = new CameraPreview.StateListener() {
            @Override
            public void cameraClosed() {
                if (CaptureManager.this.finishWhenClosed) {
                    Log.d(CaptureManager.TAG, "Camera closed; finishing activity");
                    CaptureManager.this.finish();
                }
            }
            
            @Override
            public void cameraError(final Exception ex) {
                CaptureManager.this.displayFrameworkBugMessageAndExit();
            }
            
            @Override
            public void previewSized() {
            }
            
            @Override
            public void previewStarted() {
            }
            
            @Override
            public void previewStopped() {
            }
        };
        this.askedPermission = false;
        this.activity = activity;
        this.barcodeView = barcodeView;
        barcodeView.getBarcodeView().addStateListener(this.stateListener);
        this.handler = new Handler();
        this.inactivityTimer = new InactivityTimer((Context)activity, new Runnable() {
            @Override
            public void run() {
                Log.d(CaptureManager.TAG, "Finishing due to inactivity");
                CaptureManager.this.finish();
            }
        });
        this.beepManager = new BeepManager(activity);
    }
    
    private void finish() {
        this.activity.finish();
    }
    
    private String getBarcodeImagePath(final BarcodeResult barcodeResult) {
        String absolutePath = null;
        if (!this.returnBarcodeImagePath) {
            return absolutePath;
        }
        final Bitmap bitmap = barcodeResult.getBitmap();
        try {
            final File tempFile = File.createTempFile("barcodeimage", ".jpg", this.activity.getCacheDir());
            final FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
            bitmap.compress(Bitmap$CompressFormat.JPEG, 100, (OutputStream)fileOutputStream);
            fileOutputStream.close();
            absolutePath = tempFile.getAbsolutePath();
            return absolutePath;
        }
        catch (IOException obj) {
            Log.w(CaptureManager.TAG, "Unable to create temporary file and store bitmap! " + obj);
            return null;
        }
    }
    
    public static int getCameraPermissionReqCode() {
        return CaptureManager.cameraPermissionReqCode;
    }
    
    @TargetApi(23)
    private void openCameraWithPermission() {
        if (ContextCompat.checkSelfPermission((Context)this.activity, "android.permission.CAMERA") == 0) {
            this.barcodeView.resume();
        }
        else if (!this.askedPermission) {
            ActivityCompat.requestPermissions(this.activity, new String[] { "android.permission.CAMERA" }, CaptureManager.cameraPermissionReqCode);
            this.askedPermission = true;
        }
    }
    
    public static Intent resultIntent(final BarcodeResult barcodeResult, final String s) {
        final Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.addFlags(524288);
        intent.putExtra("SCAN_RESULT", barcodeResult.toString());
        intent.putExtra("SCAN_RESULT_FORMAT", barcodeResult.getBarcodeFormat().toString());
        final byte[] rawBytes = barcodeResult.getRawBytes();
        if (rawBytes != null && rawBytes.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", rawBytes);
        }
        final Map<ResultMetadataType, Object> resultMetadata = barcodeResult.getResultMetadata();
        if (resultMetadata != null) {
            if (resultMetadata.containsKey(ResultMetadataType.UPC_EAN_EXTENSION)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", resultMetadata.get(ResultMetadataType.UPC_EAN_EXTENSION).toString());
            }
            final Number n = resultMetadata.get(ResultMetadataType.ORIENTATION);
            if (n != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", n.intValue());
            }
            final String s2 = resultMetadata.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
            if (s2 != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", s2);
            }
            final Iterable<byte[]> iterable = resultMetadata.get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                int i = 0;
                final Iterator<byte[]> iterator = iterable.iterator();
                while (iterator.hasNext()) {
                    intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i, (byte[])iterator.next());
                    ++i;
                }
            }
        }
        if (s != null) {
            intent.putExtra("SCAN_RESULT_IMAGE_PATH", s);
        }
        return intent;
    }
    
    public static void setCameraPermissionReqCode(final int cameraPermissionReqCode) {
        CaptureManager.cameraPermissionReqCode = cameraPermissionReqCode;
    }
    
    protected void closeAndFinish() {
        if (this.barcodeView.getBarcodeView().isCameraClosed()) {
            this.finish();
        }
        else {
            this.finishWhenClosed = true;
        }
        this.barcodeView.pause();
        this.inactivityTimer.cancel();
    }
    
    public void decode() {
        this.barcodeView.decodeSingle(this.callback);
    }
    
    protected void displayFrameworkBugMessageAndExit() {
        if (this.activity.isFinishing() || this.destroyed || this.finishWhenClosed) {
            return;
        }
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.activity);
        alertDialog$Builder.setTitle((CharSequence)this.activity.getString(R.string.zxing_app_name));
        alertDialog$Builder.setMessage((CharSequence)this.activity.getString(R.string.zxing_msg_camera_framework_bug));
        alertDialog$Builder.setPositiveButton(R.string.zxing_button_ok, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                CaptureManager.this.finish();
            }
        });
        alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
            public void onCancel(final DialogInterface dialogInterface) {
                CaptureManager.this.finish();
            }
        });
        alertDialog$Builder.show();
    }
    
    public void initializeFromIntent(final Intent intent, final Bundle bundle) {
        this.activity.getWindow().addFlags(128);
        if (bundle != null) {
            this.orientationLock = bundle.getInt("SAVED_ORIENTATION_LOCK", -1);
        }
        if (intent != null) {
            if (intent.getBooleanExtra("SCAN_ORIENTATION_LOCKED", true)) {
                this.lockOrientation();
            }
            if ("com.google.zxing.client.android.SCAN".equals(intent.getAction())) {
                this.barcodeView.initializeFromIntent(intent);
            }
            if (!intent.getBooleanExtra("BEEP_ENABLED", true)) {
                this.beepManager.setBeepEnabled(false);
            }
            if (intent.hasExtra("TIMEOUT")) {
                this.handler.postDelayed((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        CaptureManager.this.returnResultTimeout();
                    }
                }, intent.getLongExtra("TIMEOUT", 0L));
            }
            if (intent.getBooleanExtra("BARCODE_IMAGE_ENABLED", false)) {
                this.returnBarcodeImagePath = true;
            }
        }
    }
    
    protected void lockOrientation() {
        if (this.orientationLock == -1) {
            final int rotation = this.activity.getWindowManager().getDefaultDisplay().getRotation();
            final int orientation = this.activity.getResources().getConfiguration().orientation;
            int orientationLock = 0;
            if (orientation == 2) {
                if (rotation == 0 || rotation == 1) {
                    orientationLock = 0;
                }
                else {
                    orientationLock = 8;
                }
            }
            else if (orientation == 1) {
                if (rotation == 0 || rotation == 3) {
                    orientationLock = 1;
                }
                else {
                    orientationLock = 9;
                }
            }
            this.orientationLock = orientationLock;
        }
        this.activity.setRequestedOrientation(this.orientationLock);
    }
    
    public void onDestroy() {
        this.destroyed = true;
        this.inactivityTimer.cancel();
        this.handler.removeCallbacksAndMessages((Object)null);
    }
    
    public void onPause() {
        this.inactivityTimer.cancel();
        this.barcodeView.pauseAndWait();
    }
    
    public void onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
        if (n == CaptureManager.cameraPermissionReqCode) {
            if (array2.length <= 0 || array2[0] != 0) {
                this.displayFrameworkBugMessageAndExit();
                return;
            }
            this.barcodeView.resume();
        }
    }
    
    public void onResume() {
        if (Build$VERSION.SDK_INT >= 23) {
            this.openCameraWithPermission();
        }
        else {
            this.barcodeView.resume();
        }
        this.inactivityTimer.start();
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        bundle.putInt("SAVED_ORIENTATION_LOCK", this.orientationLock);
    }
    
    protected void returnResult(final BarcodeResult barcodeResult) {
        this.activity.setResult(-1, resultIntent(barcodeResult, this.getBarcodeImagePath(barcodeResult)));
        this.closeAndFinish();
    }
    
    protected void returnResultTimeout() {
        final Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("TIMEOUT", true);
        this.activity.setResult(0, intent);
        this.closeAndFinish();
    }
}
