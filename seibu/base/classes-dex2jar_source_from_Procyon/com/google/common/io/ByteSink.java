// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.InputStream;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public abstract class ByteSink
{
    protected ByteSink() {
    }
    
    public CharSink asCharSink(final Charset charset) {
        return new AsCharSink(charset);
    }
    
    public OutputStream openBufferedStream() throws IOException {
        final OutputStream openStream = this.openStream();
        if (openStream instanceof BufferedOutputStream) {
            return openStream;
        }
        return new BufferedOutputStream(openStream);
    }
    
    public abstract OutputStream openStream() throws IOException;
    
    public void write(final byte[] b) throws IOException {
        Preconditions.checkNotNull(b);
        final Closer create = Closer.create();
        try {
            final OutputStream outputStream = create.register(this.openStream());
            outputStream.write(b);
            outputStream.flush();
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    public long writeFrom(final InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        final Closer create = Closer.create();
        try {
            final OutputStream outputStream = create.register(this.openStream());
            final long copy = ByteStreams.copy(inputStream, outputStream);
            outputStream.flush();
            return copy;
        }
        catch (Throwable t) {
            throw create.rethrow(t);
        }
        finally {
            create.close();
        }
    }
    
    private final class AsCharSink extends CharSink
    {
        private final Charset charset;
        
        private AsCharSink(final Charset charset) {
            this.charset = Preconditions.checkNotNull(charset);
        }
        
        @Override
        public Writer openStream() throws IOException {
            return new OutputStreamWriter(ByteSink.this.openStream(), this.charset);
        }
        
        @Override
        public String toString() {
            final String value = String.valueOf(String.valueOf(ByteSink.this.toString()));
            final String value2 = String.valueOf(String.valueOf(this.charset));
            return new StringBuilder(value.length() + 13 + value2.length()).append(value).append(".asCharSink(").append(value2).append(")").toString();
        }
    }
}
