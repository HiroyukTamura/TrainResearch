// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import com.google.zxing.LuminanceSource;
import com.google.zxing.Result;
import android.os.Bundle;
import android.util.Log;
import com.google.zxing.client.android.R;
import android.os.Message;
import android.os.HandlerThread;
import com.journeyapps.barcodescanner.camera.PreviewCallback;
import android.os.Handler;
import android.graphics.Rect;
import com.journeyapps.barcodescanner.camera.CameraInstance;
import android.os.Handler$Callback;

public class DecoderThread
{
    private static final String TAG;
    private final Object LOCK;
    private final Handler$Callback callback;
    private CameraInstance cameraInstance;
    private Rect cropRect;
    private Decoder decoder;
    private Handler handler;
    private final PreviewCallback previewCallback;
    private Handler resultHandler;
    private boolean running;
    private HandlerThread thread;
    
    static {
        TAG = DecoderThread.class.getSimpleName();
    }
    
    public DecoderThread(final CameraInstance cameraInstance, final Decoder decoder, final Handler resultHandler) {
        this.running = false;
        this.LOCK = new Object();
        this.callback = (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (message.what == R.id.zxing_decode) {
                    DecoderThread.this.decode((SourceData)message.obj);
                }
                else if (message.what == R.id.zxing_preview_failed) {
                    DecoderThread.this.requestNextPreview();
                }
                return true;
            }
        };
        this.previewCallback = new PreviewCallback() {
            @Override
            public void onPreview(final SourceData sourceData) {
                synchronized (DecoderThread.this.LOCK) {
                    if (DecoderThread.this.running) {
                        DecoderThread.this.handler.obtainMessage(R.id.zxing_decode, (Object)sourceData).sendToTarget();
                    }
                }
            }
            
            @Override
            public void onPreviewError(final Exception ex) {
                synchronized (DecoderThread.this.LOCK) {
                    if (DecoderThread.this.running) {
                        DecoderThread.this.handler.obtainMessage(R.id.zxing_preview_failed).sendToTarget();
                    }
                }
            }
        };
        Util.validateMainThread();
        this.cameraInstance = cameraInstance;
        this.decoder = decoder;
        this.resultHandler = resultHandler;
    }
    
    private void decode(final SourceData sourceData) {
        final long currentTimeMillis = System.currentTimeMillis();
        Result decode = null;
        sourceData.setCropRect(this.cropRect);
        final LuminanceSource source = this.createSource(sourceData);
        if (source != null) {
            decode = this.decoder.decode(source);
        }
        if (decode != null) {
            Log.d(DecoderThread.TAG, "Found barcode in " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            if (this.resultHandler != null) {
                final Message obtain = Message.obtain(this.resultHandler, R.id.zxing_decode_succeeded, (Object)new BarcodeResult(decode, sourceData));
                obtain.setData(new Bundle());
                obtain.sendToTarget();
            }
        }
        else if (this.resultHandler != null) {
            Message.obtain(this.resultHandler, R.id.zxing_decode_failed).sendToTarget();
        }
        if (this.resultHandler != null) {
            Message.obtain(this.resultHandler, R.id.zxing_possible_result_points, (Object)this.decoder.getPossibleResultPoints()).sendToTarget();
        }
        this.requestNextPreview();
    }
    
    private void requestNextPreview() {
        this.cameraInstance.requestPreview(this.previewCallback);
    }
    
    protected LuminanceSource createSource(final SourceData sourceData) {
        if (this.cropRect == null) {
            return null;
        }
        return sourceData.createSource();
    }
    
    public Rect getCropRect() {
        return this.cropRect;
    }
    
    public Decoder getDecoder() {
        return this.decoder;
    }
    
    public void setCropRect(final Rect cropRect) {
        this.cropRect = cropRect;
    }
    
    public void setDecoder(final Decoder decoder) {
        this.decoder = decoder;
    }
    
    public void start() {
        Util.validateMainThread();
        (this.thread = new HandlerThread(DecoderThread.TAG)).start();
        this.handler = new Handler(this.thread.getLooper(), this.callback);
        this.running = true;
        this.requestNextPreview();
    }
    
    public void stop() {
        Util.validateMainThread();
        synchronized (this.LOCK) {
            this.running = false;
            this.handler.removeCallbacksAndMessages((Object)null);
            this.thread.quit();
        }
    }
}
