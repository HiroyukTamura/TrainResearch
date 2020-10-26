// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import java.io.IOException;
import android.hardware.Camera;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

public class CameraSurface
{
    private SurfaceHolder surfaceHolder;
    private SurfaceTexture surfaceTexture;
    
    public CameraSurface(final SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            throw new IllegalArgumentException("surfaceTexture may not be null");
        }
        this.surfaceTexture = surfaceTexture;
    }
    
    public CameraSurface(final SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalArgumentException("surfaceHolder may not be null");
        }
        this.surfaceHolder = surfaceHolder;
    }
    
    public SurfaceHolder getSurfaceHolder() {
        return this.surfaceHolder;
    }
    
    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }
    
    public void setPreview(final Camera camera) throws IOException {
        if (this.surfaceHolder != null) {
            camera.setPreviewDisplay(this.surfaceHolder);
            return;
        }
        camera.setPreviewTexture(this.surfaceTexture);
    }
}
