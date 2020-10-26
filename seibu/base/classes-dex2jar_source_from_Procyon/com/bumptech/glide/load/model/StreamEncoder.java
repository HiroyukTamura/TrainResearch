// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.model;

import java.io.IOException;
import android.util.Log;
import com.bumptech.glide.util.ByteArrayPool;
import java.io.OutputStream;
import java.io.InputStream;
import com.bumptech.glide.load.Encoder;

public class StreamEncoder implements Encoder<InputStream>
{
    private static final String TAG = "StreamEncoder";
    
    @Override
    public boolean encode(final InputStream inputStream, final OutputStream outputStream) {
        final byte[] bytes = ByteArrayPool.get().getBytes();
        try {
            try {
                while (true) {
                    final int read = inputStream.read(bytes);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bytes, 0, read);
                }
            }
            catch (IOException ex) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", (Throwable)ex);
                }
                return false;
            }
            return true;
        }
        finally {
            ByteArrayPool.get().releaseBytes(bytes);
        }
    }
    
    @Override
    public String getId() {
        return "";
    }
}
