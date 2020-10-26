// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner;

import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.os.Bundle;
import com.google.zxing.client.android.R;
import android.app.Activity;

public class CaptureActivity extends Activity
{
    private DecoratedBarcodeView barcodeScannerView;
    private CaptureManager capture;
    
    protected DecoratedBarcodeView initializeContent() {
        this.setContentView(R.layout.zxing_capture);
        return (DecoratedBarcodeView)this.findViewById(R.id.zxing_barcode_scanner);
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.barcodeScannerView = this.initializeContent();
        (this.capture = new CaptureManager(this, this.barcodeScannerView)).initializeFromIntent(this.getIntent(), bundle);
        this.capture.decode();
    }
    
    protected void onDestroy() {
        super.onDestroy();
        this.capture.onDestroy();
    }
    
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        return this.barcodeScannerView.onKeyDown(n, keyEvent) || super.onKeyDown(n, keyEvent);
    }
    
    protected void onPause() {
        super.onPause();
        this.capture.onPause();
    }
    
    public void onRequestPermissionsResult(final int n, @NonNull final String[] array, @NonNull final int[] array2) {
        this.capture.onRequestPermissionsResult(n, array, array2);
    }
    
    protected void onResume() {
        super.onResume();
        this.capture.onResume();
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.capture.onSaveInstanceState(bundle);
    }
}
