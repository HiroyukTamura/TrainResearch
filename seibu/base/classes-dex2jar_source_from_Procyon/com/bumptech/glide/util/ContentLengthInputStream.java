// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.util;

import android.util.Log;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

public final class ContentLengthInputStream extends FilterInputStream
{
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;
    
    ContentLengthInputStream(final InputStream in, final long contentLength) {
        super(in);
        this.contentLength = contentLength;
    }
    
    private int checkReadSoFarOrThrow(final int n) throws IOException {
        if (n >= 0) {
            this.readSoFar += n;
        }
        else if (this.contentLength - this.readSoFar > 0L) {
            throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
        }
        return n;
    }
    
    public static InputStream obtain(final InputStream inputStream, final long n) {
        return new ContentLengthInputStream(inputStream, n);
    }
    
    public static InputStream obtain(final InputStream inputStream, final String s) {
        return obtain(inputStream, parseContentLength(s));
    }
    
    private static int parseContentLength(final String s) {
        int int1 = -1;
        if (TextUtils.isEmpty((CharSequence)s)) {
            return int1;
        }
        try {
            int1 = Integer.parseInt(s);
            return int1;
        }
        catch (NumberFormatException ex) {
            int1 = int1;
            if (Log.isLoggable("ContentLengthStream", 3)) {
                Log.d("ContentLengthStream", "failed to parse content length header: " + s, (Throwable)ex);
                return -1;
            }
            return int1;
        }
    }
    
    @Override
    public int available() throws IOException {
        synchronized (this) {
            return (int)Math.max(this.contentLength - this.readSoFar, this.in.available());
        }
    }
    
    @Override
    public int read() throws IOException {
        synchronized (this) {
            return this.checkReadSoFarOrThrow(super.read());
        }
    }
    
    @Override
    public int read(final byte[] array) throws IOException {
        return this.read(array, 0, array.length);
    }
    
    @Override
    public int read(final byte[] b, int checkReadSoFarOrThrow, final int len) throws IOException {
        synchronized (this) {
            checkReadSoFarOrThrow = this.checkReadSoFarOrThrow(super.read(b, checkReadSoFarOrThrow, len));
            return checkReadSoFarOrThrow;
        }
    }
}
