// 
// Decompiled by Procyon v0.5.36
// 

package okhttp3;

import java.io.IOException;
import java.io.InputStream;
import okio.Buffer;
import okio.BufferedSource;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import java.nio.charset.Charset;
import java.io.Reader;
import java.io.Closeable;

public abstract class ResponseBody implements Closeable
{
    private Reader reader;
    
    private Charset charset() {
        final MediaType contentType = this.contentType();
        if (contentType != null) {
            return contentType.charset(Util.UTF_8);
        }
        return Util.UTF_8;
    }
    
    public static ResponseBody create(@Nullable final MediaType mediaType, final long n, final BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        return new ResponseBody() {
            @Override
            public long contentLength() {
                return n;
            }
            
            @Nullable
            @Override
            public MediaType contentType() {
                return mediaType;
            }
            
            @Override
            public BufferedSource source() {
                return bufferedSource;
            }
        };
    }
    
    public static ResponseBody create(@Nullable final MediaType obj, final String s) {
        Charset charset = Util.UTF_8;
        MediaType parse = obj;
        if (obj != null) {
            charset = obj.charset();
            parse = obj;
            if (charset == null) {
                charset = Util.UTF_8;
                parse = MediaType.parse(obj + "; charset=utf-8");
            }
        }
        final Buffer writeString = new Buffer().writeString(s, charset);
        return create(parse, writeString.size(), writeString);
    }
    
    public static ResponseBody create(@Nullable final MediaType mediaType, final byte[] array) {
        return create(mediaType, array.length, new Buffer().write(array));
    }
    
    public final InputStream byteStream() {
        return this.source().inputStream();
    }
    
    public final byte[] bytes() throws IOException {
        final long contentLength = this.contentLength();
        if (contentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
        final BufferedSource source = this.source();
        try {
            final byte[] byteArray = source.readByteArray();
            Util.closeQuietly((Closeable)source);
            if (contentLength != -1L && contentLength != byteArray.length) {
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + byteArray.length + ") disagree");
            }
        }
        finally {
            Util.closeQuietly((Closeable)source);
        }
        return;
    }
    
    public final Reader charStream() {
        final Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        return this.reader = (Reader)new ResponseBody.ResponseBody$BomAwareReader(this.source(), this.charset());
    }
    
    @Override
    public void close() {
        Util.closeQuietly((Closeable)this.source());
    }
    
    public abstract long contentLength();
    
    @Nullable
    public abstract MediaType contentType();
    
    public abstract BufferedSource source();
    
    public final String string() throws IOException {
        final BufferedSource source = this.source();
        try {
            return source.readString(Util.bomAwareCharset(source, this.charset()));
        }
        finally {
            Util.closeQuietly((Closeable)source);
        }
    }
}
