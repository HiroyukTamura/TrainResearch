// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import java.util.Map;
import com.google.zxing.DecodeHintType;
import java.util.HashMap;
import android.util.AttributeSet;
import com.google.zxing.ResultPoint;
import java.util.List;
import com.google.zxing.client.android.R;
import android.os.Message;
import android.content.Context;
import android.os.Handler;
import android.os.Handler$Callback;

public class BarcodeView extends CameraPreview
{
    private BarcodeCallback callback;
    private DecodeMode decodeMode;
    private DecoderFactory decoderFactory;
    private DecoderThread decoderThread;
    private final Handler$Callback resultCallback;
    private Handler resultHandler;
    
    public BarcodeView(final Context context) {
        super(context);
        this.decodeMode = DecodeMode.NONE;
        this.callback = null;
        this.resultCallback = (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (message.what == R.id.zxing_decode_succeeded) {
                    final BarcodeResult barcodeResult = (BarcodeResult)message.obj;
                    if (barcodeResult != null && BarcodeView.this.callback != null && BarcodeView.this.decodeMode != DecodeMode.NONE) {
                        BarcodeView.this.callback.barcodeResult(barcodeResult);
                        if (BarcodeView.this.decodeMode == DecodeMode.SINGLE) {
                            BarcodeView.this.stopDecoding();
                        }
                    }
                }
                else if (message.what != R.id.zxing_decode_failed) {
                    if (message.what != R.id.zxing_possible_result_points) {
                        return false;
                    }
                    final List list = (List)message.obj;
                    if (BarcodeView.this.callback != null && BarcodeView.this.decodeMode != DecodeMode.NONE) {
                        BarcodeView.this.callback.possibleResultPoints(list);
                        return true;
                    }
                }
                return true;
            }
        };
        this.initialize();
    }
    
    public BarcodeView(final Context context, final AttributeSet set) {
        super(context, set);
        this.decodeMode = DecodeMode.NONE;
        this.callback = null;
        this.resultCallback = (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (message.what == R.id.zxing_decode_succeeded) {
                    final BarcodeResult barcodeResult = (BarcodeResult)message.obj;
                    if (barcodeResult != null && BarcodeView.this.callback != null && BarcodeView.this.decodeMode != DecodeMode.NONE) {
                        BarcodeView.this.callback.barcodeResult(barcodeResult);
                        if (BarcodeView.this.decodeMode == DecodeMode.SINGLE) {
                            BarcodeView.this.stopDecoding();
                        }
                    }
                }
                else if (message.what != R.id.zxing_decode_failed) {
                    if (message.what != R.id.zxing_possible_result_points) {
                        return false;
                    }
                    final List list = (List)message.obj;
                    if (BarcodeView.this.callback != null && BarcodeView.this.decodeMode != DecodeMode.NONE) {
                        BarcodeView.this.callback.possibleResultPoints(list);
                        return true;
                    }
                }
                return true;
            }
        };
        this.initialize();
    }
    
    public BarcodeView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.decodeMode = DecodeMode.NONE;
        this.callback = null;
        this.resultCallback = (Handler$Callback)new Handler$Callback() {
            public boolean handleMessage(final Message message) {
                if (message.what == R.id.zxing_decode_succeeded) {
                    final BarcodeResult barcodeResult = (BarcodeResult)message.obj;
                    if (barcodeResult != null && BarcodeView.this.callback != null && BarcodeView.this.decodeMode != DecodeMode.NONE) {
                        BarcodeView.this.callback.barcodeResult(barcodeResult);
                        if (BarcodeView.this.decodeMode == DecodeMode.SINGLE) {
                            BarcodeView.this.stopDecoding();
                        }
                    }
                }
                else if (message.what != R.id.zxing_decode_failed) {
                    if (message.what != R.id.zxing_possible_result_points) {
                        return false;
                    }
                    final List list = (List)message.obj;
                    if (BarcodeView.this.callback != null && BarcodeView.this.decodeMode != DecodeMode.NONE) {
                        BarcodeView.this.callback.possibleResultPoints(list);
                        return true;
                    }
                }
                return true;
            }
        };
        this.initialize();
    }
    
    private Decoder createDecoder() {
        if (this.decoderFactory == null) {
            this.decoderFactory = this.createDefaultDecoderFactory();
        }
        final DecoderResultPointCallback decoderResultPointCallback = new DecoderResultPointCallback();
        final HashMap<DecodeHintType, DecoderResultPointCallback> hashMap = new HashMap<DecodeHintType, DecoderResultPointCallback>();
        hashMap.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, decoderResultPointCallback);
        final Decoder decoder = this.decoderFactory.createDecoder(hashMap);
        decoderResultPointCallback.setDecoder(decoder);
        return decoder;
    }
    
    private void initialize() {
        this.decoderFactory = new DefaultDecoderFactory();
        this.resultHandler = new Handler(this.resultCallback);
    }
    
    private void startDecoderThread() {
        this.stopDecoderThread();
        if (this.decodeMode != DecodeMode.NONE && this.isPreviewActive()) {
            (this.decoderThread = new DecoderThread(this.getCameraInstance(), this.createDecoder(), this.resultHandler)).setCropRect(this.getPreviewFramingRect());
            this.decoderThread.start();
        }
    }
    
    private void stopDecoderThread() {
        if (this.decoderThread != null) {
            this.decoderThread.stop();
            this.decoderThread = null;
        }
    }
    
    protected DecoderFactory createDefaultDecoderFactory() {
        return new DefaultDecoderFactory();
    }
    
    public void decodeContinuous(final BarcodeCallback callback) {
        this.decodeMode = DecodeMode.CONTINUOUS;
        this.callback = callback;
        this.startDecoderThread();
    }
    
    public void decodeSingle(final BarcodeCallback callback) {
        this.decodeMode = DecodeMode.SINGLE;
        this.callback = callback;
        this.startDecoderThread();
    }
    
    public DecoderFactory getDecoderFactory() {
        return this.decoderFactory;
    }
    
    @Override
    public void pause() {
        this.stopDecoderThread();
        super.pause();
    }
    
    @Override
    protected void previewStarted() {
        super.previewStarted();
        this.startDecoderThread();
    }
    
    public void setDecoderFactory(final DecoderFactory decoderFactory) {
        Util.validateMainThread();
        this.decoderFactory = decoderFactory;
        if (this.decoderThread != null) {
            this.decoderThread.setDecoder(this.createDecoder());
        }
    }
    
    public void stopDecoding() {
        this.decodeMode = DecodeMode.NONE;
        this.callback = null;
        this.stopDecoderThread();
    }
    
    private enum DecodeMode
    {
        CONTINUOUS, 
        NONE, 
        SINGLE;
    }
}
