// 
// Decompiled by Procyon v0.5.36
// 

package com.journeyapps.barcodescanner.camera;

import com.journeyapps.barcodescanner.SourceData;

public interface PreviewCallback
{
    void onPreview(final SourceData p0);
    
    void onPreviewError(final Exception p0);
}
