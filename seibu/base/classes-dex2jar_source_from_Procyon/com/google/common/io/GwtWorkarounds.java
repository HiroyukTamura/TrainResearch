// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.io;

import java.io.OutputStream;
import java.io.InputStream;
import java.io.Writer;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import com.google.common.base.Preconditions;
import java.io.Reader;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class GwtWorkarounds
{
    private GwtWorkarounds() {
    }
    
    @GwtIncompatible("Reader")
    static CharInput asCharInput(final Reader reader) {
        Preconditions.checkNotNull(reader);
        return (CharInput)new CharInput() {
            @Override
            public void close() throws IOException {
                reader.close();
            }
            
            @Override
            public int read() throws IOException {
                return reader.read();
            }
        };
    }
    
    static CharInput asCharInput(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return (CharInput)new CharInput() {
            int index = 0;
            
            @Override
            public void close() {
                this.index = charSequence.length();
            }
            
            @Override
            public int read() {
                if (this.index < charSequence.length()) {
                    return charSequence.charAt(this.index++);
                }
                return -1;
            }
        };
    }
    
    @GwtIncompatible("Writer")
    static CharOutput asCharOutput(final Writer writer) {
        Preconditions.checkNotNull(writer);
        return (CharOutput)new CharOutput() {
            @Override
            public void close() throws IOException {
                writer.close();
            }
            
            @Override
            public void flush() throws IOException {
                writer.flush();
            }
            
            @Override
            public void write(final char c) throws IOException {
                writer.append(c);
            }
        };
    }
    
    @GwtIncompatible("InputStream")
    static InputStream asInputStream(final ByteInput byteInput) {
        Preconditions.checkNotNull(byteInput);
        return new InputStream() {
            @Override
            public void close() throws IOException {
                byteInput.close();
            }
            
            @Override
            public int read() throws IOException {
                return byteInput.read();
            }
            
            @Override
            public int read(final byte[] array, final int n, final int n2) throws IOException {
                Preconditions.checkNotNull(array);
                Preconditions.checkPositionIndexes(n, n + n2, array.length);
                int n3;
                if (n2 == 0) {
                    n3 = 0;
                }
                else {
                    final int read = this.read();
                    if (read == -1) {
                        return -1;
                    }
                    array[n] = (byte)read;
                    for (int i = 1; i < n2; ++i) {
                        final int read2 = this.read();
                        n3 = i;
                        if (read2 == -1) {
                            return n3;
                        }
                        array[n + i] = (byte)read2;
                    }
                    return n2;
                }
                return n3;
            }
        };
    }
    
    @GwtIncompatible("OutputStream")
    static OutputStream asOutputStream(final ByteOutput byteOutput) {
        Preconditions.checkNotNull(byteOutput);
        return new OutputStream() {
            @Override
            public void close() throws IOException {
                byteOutput.close();
            }
            
            @Override
            public void flush() throws IOException {
                byteOutput.flush();
            }
            
            @Override
            public void write(final int n) throws IOException {
                byteOutput.write((byte)n);
            }
        };
    }
    
    static CharOutput stringBuilderOutput(final int capacity) {
        return (CharOutput)new CharOutput() {
            final /* synthetic */ StringBuilder val$builder = new StringBuilder(capacity);
            
            @Override
            public void close() {
            }
            
            @Override
            public void flush() {
            }
            
            @Override
            public String toString() {
                return this.val$builder.toString();
            }
            
            @Override
            public void write(final char c) {
                this.val$builder.append(c);
            }
        };
    }
    
    interface ByteInput
    {
        void close() throws IOException;
        
        int read() throws IOException;
    }
    
    interface ByteOutput
    {
        void close() throws IOException;
        
        void flush() throws IOException;
        
        void write(final byte p0) throws IOException;
    }
    
    interface CharInput
    {
        void close() throws IOException;
        
        int read() throws IOException;
    }
    
    interface CharOutput
    {
        void close() throws IOException;
        
        void flush() throws IOException;
        
        void write(final char p0) throws IOException;
    }
}
