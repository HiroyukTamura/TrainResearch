// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import java.io.InputStream;
import android.os.ParcelFileDescriptor;
import android.graphics.Bitmap;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.ResourceDecoder;

public class ImageVideoBitmapDecoder implements ResourceDecoder<ImageVideoWrapper, Bitmap>
{
    private static final String TAG = "ImageVideoDecoder";
    private final ResourceDecoder<ParcelFileDescriptor, Bitmap> fileDescriptorDecoder;
    private final ResourceDecoder<InputStream, Bitmap> streamDecoder;
    
    public ImageVideoBitmapDecoder(final ResourceDecoder<InputStream, Bitmap> streamDecoder, final ResourceDecoder<ParcelFileDescriptor, Bitmap> fileDescriptorDecoder) {
        this.streamDecoder = streamDecoder;
        this.fileDescriptorDecoder = fileDescriptorDecoder;
    }
    
    @Override
    public Resource<Bitmap> decode(ImageVideoWrapper fileDescriptor, final int n, final int n2) throws IOException {
        Resource<Bitmap> decode = null;
        final InputStream stream = fileDescriptor.getStream();
        Resource<Bitmap> decode2 = decode;
        while (true) {
            if (stream == null) {
                break Label_0033;
            }
            try {
                decode2 = this.streamDecoder.decode(stream, n, n2);
                if ((decode = decode2) == null) {
                    fileDescriptor = (ImageVideoWrapper)fileDescriptor.getFileDescriptor();
                    decode = decode2;
                    if (fileDescriptor != null) {
                        decode = this.fileDescriptorDecoder.decode((ParcelFileDescriptor)fileDescriptor, n, n2);
                    }
                }
                return decode;
            }
            catch (IOException ex) {
                decode2 = decode;
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", (Throwable)ex);
                    decode2 = decode;
                }
                continue;
            }
            break;
        }
    }
    
    @Override
    public String getId() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
