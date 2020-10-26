// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import java.util.Iterator;
import com.google.zxing.ResultPoint;
import java.util.List;
import android.view.KeyEvent;
import java.util.Set;
import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import com.google.zxing.DecodeHintType;
import java.util.Map;
import com.google.zxing.MultiFormatReader;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import com.google.zxing.client.android.DecodeHintManager;
import com.google.zxing.client.android.DecodeFormatManager;
import android.content.Intent;
import com.journeyapps.barcodescanner.camera.CameraParametersCallback;
import android.content.res.TypedArray;
import android.view.ViewGroup;
import com.google.zxing.client.android.R;
import android.util.AttributeSet;
import android.content.Context;
import android.widget.TextView;
import android.widget.FrameLayout;

public class DecoratedBarcodeView extends FrameLayout
{
    private BarcodeView barcodeView;
    private TextView statusView;
    private TorchListener torchListener;
    private ViewfinderView viewFinder;
    
    public DecoratedBarcodeView(final Context context) {
        super(context);
        this.initialize();
    }
    
    public DecoratedBarcodeView(final Context context, final AttributeSet set) {
        super(context, set);
        this.initialize(set);
    }
    
    public DecoratedBarcodeView(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.initialize(set);
    }
    
    private void initialize() {
        this.initialize(null);
    }
    
    private void initialize(final AttributeSet set) {
        final TypedArray obtainStyledAttributes = this.getContext().obtainStyledAttributes(set, R.styleable.zxing_view);
        final int resourceId = obtainStyledAttributes.getResourceId(R.styleable.zxing_view_zxing_scanner_layout, R.layout.zxing_barcode_scanner);
        obtainStyledAttributes.recycle();
        inflate(this.getContext(), resourceId, (ViewGroup)this);
        this.barcodeView = (BarcodeView)this.findViewById(R.id.zxing_barcode_surface);
        if (this.barcodeView == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.BarcodeView on provided layout with the id \"zxing_barcode_surface\".");
        }
        this.barcodeView.initializeAttributes(set);
        this.viewFinder = (ViewfinderView)this.findViewById(R.id.zxing_viewfinder_view);
        if (this.viewFinder == null) {
            throw new IllegalArgumentException("There is no a com.journeyapps.barcodescanner.ViewfinderView on provided layout with the id \"zxing_viewfinder_view\".");
        }
        this.viewFinder.setCameraPreview(this.barcodeView);
        this.statusView = (TextView)this.findViewById(R.id.zxing_status_view);
    }
    
    public void changeCameraParameters(final CameraParametersCallback cameraParametersCallback) {
        this.barcodeView.changeCameraParameters(cameraParametersCallback);
    }
    
    public void decodeContinuous(final BarcodeCallback barcodeCallback) {
        this.barcodeView.decodeContinuous(new WrappedCallback(barcodeCallback));
    }
    
    public void decodeSingle(final BarcodeCallback barcodeCallback) {
        this.barcodeView.decodeSingle(new WrappedCallback(barcodeCallback));
    }
    
    public BarcodeView getBarcodeView() {
        return (BarcodeView)this.findViewById(R.id.zxing_barcode_surface);
    }
    
    public TextView getStatusView() {
        return this.statusView;
    }
    
    public ViewfinderView getViewFinder() {
        return this.viewFinder;
    }
    
    public void initializeFromIntent(final Intent intent) {
        final Set<BarcodeFormat> decodeFormats = DecodeFormatManager.parseDecodeFormats(intent);
        final Map<DecodeHintType, Object> decodeHints = DecodeHintManager.parseDecodeHints(intent);
        final CameraSettings cameraSettings = new CameraSettings();
        if (intent.hasExtra("SCAN_CAMERA_ID")) {
            final int intExtra = intent.getIntExtra("SCAN_CAMERA_ID", -1);
            if (intExtra >= 0) {
                cameraSettings.setRequestedCameraId(intExtra);
            }
        }
        final String stringExtra = intent.getStringExtra("PROMPT_MESSAGE");
        if (stringExtra != null) {
            this.setStatusText(stringExtra);
        }
        final int intExtra2 = intent.getIntExtra("SCAN_TYPE", 0);
        final String stringExtra2 = intent.getStringExtra("CHARACTER_SET");
        new MultiFormatReader().setHints(decodeHints);
        this.barcodeView.setCameraSettings(cameraSettings);
        this.barcodeView.setDecoderFactory(new DefaultDecoderFactory(decodeFormats, decodeHints, stringExtra2, intExtra2));
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        boolean onKeyDown = true;
        switch (n) {
            default: {
                onKeyDown = super.onKeyDown(n, keyEvent);
                return onKeyDown;
            }
            case 27:
            case 80: {
                return onKeyDown;
            }
            case 25: {
                this.setTorchOff();
                return true;
            }
            case 24: {
                this.setTorchOn();
                return true;
            }
        }
    }
    
    public void pause() {
        this.barcodeView.pause();
    }
    
    public void pauseAndWait() {
        this.barcodeView.pauseAndWait();
    }
    
    public void resume() {
        this.barcodeView.resume();
    }
    
    public void setStatusText(final String text) {
        if (this.statusView != null) {
            this.statusView.setText((CharSequence)text);
        }
    }
    
    public void setTorchListener(final TorchListener torchListener) {
        this.torchListener = torchListener;
    }
    
    public void setTorchOff() {
        this.barcodeView.setTorch(false);
        if (this.torchListener != null) {
            this.torchListener.onTorchOff();
        }
    }
    
    public void setTorchOn() {
        this.barcodeView.setTorch(true);
        if (this.torchListener != null) {
            this.torchListener.onTorchOn();
        }
    }
    
    public interface TorchListener
    {
        void onTorchOff();
        
        void onTorchOn();
    }
    
    private class WrappedCallback implements BarcodeCallback
    {
        private BarcodeCallback delegate;
        
        public WrappedCallback(final BarcodeCallback delegate) {
            this.delegate = delegate;
        }
        
        @Override
        public void barcodeResult(final BarcodeResult barcodeResult) {
            this.delegate.barcodeResult(barcodeResult);
        }
        
        @Override
        public void possibleResultPoints(final List<ResultPoint> list) {
            final Iterator<ResultPoint> iterator = list.iterator();
            while (iterator.hasNext()) {
                DecoratedBarcodeView.this.viewFinder.addPossibleResultPoint(iterator.next());
            }
            this.delegate.possibleResultPoints(list);
        }
    }
}
