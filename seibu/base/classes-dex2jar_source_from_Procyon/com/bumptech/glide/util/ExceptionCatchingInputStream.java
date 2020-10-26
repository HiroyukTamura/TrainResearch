// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.util;

import java.io.IOException;
import java.util.Queue;
import java.io.InputStream;

public class ExceptionCatchingInputStream extends InputStream
{
    private static final Queue<ExceptionCatchingInputStream> QUEUE;
    private IOException exception;
    private InputStream wrapped;
    
    static {
        QUEUE = Util.createQueue(0);
    }
    
    ExceptionCatchingInputStream() {
    }
    
    static void clearQueue() {
        while (!ExceptionCatchingInputStream.QUEUE.isEmpty()) {
            ExceptionCatchingInputStream.QUEUE.remove();
        }
    }
    
    public static ExceptionCatchingInputStream obtain(final InputStream inputStream) {
        Object queue = ExceptionCatchingInputStream.QUEUE;
        synchronized (queue) {
            final ExceptionCatchingInputStream exceptionCatchingInputStream = ExceptionCatchingInputStream.QUEUE.poll();
            // monitorexit(queue)
            queue = exceptionCatchingInputStream;
            if (exceptionCatchingInputStream == null) {
                queue = new ExceptionCatchingInputStream();
            }
            ((ExceptionCatchingInputStream)queue).setInputStream(inputStream);
            return (ExceptionCatchingInputStream)queue;
        }
    }
    
    @Override
    public int available() throws IOException {
        return this.wrapped.available();
    }
    
    @Override
    public void close() throws IOException {
        this.wrapped.close();
    }
    
    public IOException getException() {
        return this.exception;
    }
    
    @Override
    public void mark(final int readlimit) {
        this.wrapped.mark(readlimit);
    }
    
    @Override
    public boolean markSupported() {
        return this.wrapped.markSupported();
    }
    
    @Override
    public int read() throws IOException {
        try {
            return this.wrapped.read();
        }
        catch (IOException exception) {
            this.exception = exception;
            return -1;
        }
    }
    
    @Override
    public int read(final byte[] b) throws IOException {
        try {
            return this.wrapped.read(b);
        }
        catch (IOException exception) {
            this.exception = exception;
            return -1;
        }
    }
    
    @Override
    public int read(final byte[] b, int read, final int len) throws IOException {
        try {
            read = this.wrapped.read(b, read, len);
            return read;
        }
        catch (IOException exception) {
            this.exception = exception;
            return -1;
        }
    }
    
    public void release() {
        this.exception = null;
        this.wrapped = null;
        synchronized (ExceptionCatchingInputStream.QUEUE) {
            ExceptionCatchingInputStream.QUEUE.offer(this);
        }
    }
    
    @Override
    public void reset() throws IOException {
        synchronized (this) {
            this.wrapped.reset();
        }
    }
    
    void setInputStream(final InputStream wrapped) {
        this.wrapped = wrapped;
    }
    
    @Override
    public long skip(long skip) throws IOException {
        try {
            skip = this.wrapped.skip(skip);
            return skip;
        }
        catch (IOException exception) {
            this.exception = exception;
            return 0L;
        }
    }
}
