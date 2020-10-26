// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

public class CameraSettings
{
    private boolean autoFocusEnabled;
    private boolean autoTorchEnabled;
    private boolean barcodeSceneModeEnabled;
    private boolean continuousFocusEnabled;
    private boolean exposureEnabled;
    private FocusMode focusMode;
    private boolean meteringEnabled;
    private int requestedCameraId;
    private boolean scanInverted;
    
    public CameraSettings() {
        this.requestedCameraId = -1;
        this.scanInverted = false;
        this.barcodeSceneModeEnabled = false;
        this.meteringEnabled = false;
        this.autoFocusEnabled = true;
        this.continuousFocusEnabled = false;
        this.exposureEnabled = false;
        this.autoTorchEnabled = false;
        this.focusMode = FocusMode.AUTO;
    }
    
    public FocusMode getFocusMode() {
        return this.focusMode;
    }
    
    public int getRequestedCameraId() {
        return this.requestedCameraId;
    }
    
    public boolean isAutoFocusEnabled() {
        return this.autoFocusEnabled;
    }
    
    public boolean isAutoTorchEnabled() {
        return this.autoTorchEnabled;
    }
    
    public boolean isBarcodeSceneModeEnabled() {
        return this.barcodeSceneModeEnabled;
    }
    
    public boolean isContinuousFocusEnabled() {
        return this.continuousFocusEnabled;
    }
    
    public boolean isExposureEnabled() {
        return this.exposureEnabled;
    }
    
    public boolean isMeteringEnabled() {
        return this.meteringEnabled;
    }
    
    public boolean isScanInverted() {
        return this.scanInverted;
    }
    
    public void setAutoFocusEnabled(final boolean autoFocusEnabled) {
        this.autoFocusEnabled = autoFocusEnabled;
        if (autoFocusEnabled && this.continuousFocusEnabled) {
            this.focusMode = FocusMode.CONTINUOUS;
            return;
        }
        if (autoFocusEnabled) {
            this.focusMode = FocusMode.AUTO;
            return;
        }
        this.focusMode = null;
    }
    
    public void setAutoTorchEnabled(final boolean autoTorchEnabled) {
        this.autoTorchEnabled = autoTorchEnabled;
    }
    
    public void setBarcodeSceneModeEnabled(final boolean barcodeSceneModeEnabled) {
        this.barcodeSceneModeEnabled = barcodeSceneModeEnabled;
    }
    
    public void setContinuousFocusEnabled(final boolean continuousFocusEnabled) {
        this.continuousFocusEnabled = continuousFocusEnabled;
        if (continuousFocusEnabled) {
            this.focusMode = FocusMode.CONTINUOUS;
            return;
        }
        if (this.autoFocusEnabled) {
            this.focusMode = FocusMode.AUTO;
            return;
        }
        this.focusMode = null;
    }
    
    public void setExposureEnabled(final boolean exposureEnabled) {
        this.exposureEnabled = exposureEnabled;
    }
    
    public void setFocusMode(final FocusMode focusMode) {
        this.focusMode = focusMode;
    }
    
    public void setMeteringEnabled(final boolean meteringEnabled) {
        this.meteringEnabled = meteringEnabled;
    }
    
    public void setRequestedCameraId(final int requestedCameraId) {
        this.requestedCameraId = requestedCameraId;
    }
    
    public void setScanInverted(final boolean scanInverted) {
        this.scanInverted = scanInverted;
    }
    
    public enum FocusMode
    {
        AUTO, 
        CONTINUOUS, 
        INFINITY, 
        MACRO;
    }
}
