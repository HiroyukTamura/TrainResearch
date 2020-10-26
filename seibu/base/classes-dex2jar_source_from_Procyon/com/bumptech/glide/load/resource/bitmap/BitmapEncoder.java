// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.util.Util;
import android.util.Log;
import com.bumptech.glide.util.LogTime;
import java.io.OutputStream;
import com.bumptech.glide.load.engine.Resource;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.Bitmap;
import com.bumptech.glide.load.ResourceEncoder;

public class BitmapEncoder implements ResourceEncoder<Bitmap>
{
    private static final int DEFAULT_COMPRESSION_QUALITY = 90;
    private static final String TAG = "BitmapEncoder";
    private Bitmap$CompressFormat compressFormat;
    private int quality;
    
    public BitmapEncoder() {
        this(null, 90);
    }
    
    public BitmapEncoder(final Bitmap$CompressFormat compressFormat, final int quality) {
        this.compressFormat = compressFormat;
        this.quality = quality;
    }
    
    private Bitmap$CompressFormat getFormat(final Bitmap bitmap) {
        if (this.compressFormat != null) {
            return this.compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap$CompressFormat.PNG;
        }
        return Bitmap$CompressFormat.JPEG;
    }
    
    @Override
    public boolean encode(final Resource<Bitmap> resource, final OutputStream outputStream) {
        final Bitmap bitmap = resource.get();
        final long logTime = LogTime.getLogTime();
        final Bitmap$CompressFormat format = this.getFormat(bitmap);
        bitmap.compress(format, this.quality, outputStream);
        if (Log.isLoggable("BitmapEncoder", 2)) {
            Log.v("BitmapEncoder", "Compressed with type: " + format + " of size " + Util.getBitmapByteSize(bitmap) + " in " + LogTime.getElapsedMillis(logTime));
        }
        return true;
    }
    
    @Override
    public String getId() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }
}
