// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.gifdecoder;

import java.nio.ByteOrder;
import java.util.Arrays;
import java.nio.BufferUnderflowException;
import android.util.Log;
import java.nio.ByteBuffer;

public class GifHeaderParser
{
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 3;
    public static final String TAG = "GifHeaderParser";
    private final byte[] block;
    private int blockSize;
    private GifHeader header;
    private ByteBuffer rawData;
    
    public GifHeaderParser() {
        this.block = new byte[256];
        this.blockSize = 0;
    }
    
    private boolean err() {
        return this.header.status != 0;
    }
    
    private int read() {
        try {
            return this.rawData.get() & 0xFF;
        }
        catch (Exception ex) {
            this.header.status = 1;
            return 0;
        }
    }
    
    private void readBitmap() {
        boolean interlace = true;
        this.header.currentFrame.ix = this.readShort();
        this.header.currentFrame.iy = this.readShort();
        this.header.currentFrame.iw = this.readShort();
        this.header.currentFrame.ih = this.readShort();
        final int read = this.read();
        int n;
        if ((read & 0x80) != 0x0) {
            n = 1;
        }
        else {
            n = 0;
        }
        final int n2 = (int)Math.pow(2.0, (read & 0x7) + 1);
        final GifFrame currentFrame = this.header.currentFrame;
        if ((read & 0x40) == 0x0) {
            interlace = false;
        }
        currentFrame.interlace = interlace;
        if (n != 0) {
            this.header.currentFrame.lct = this.readColorTable(n2);
        }
        else {
            this.header.currentFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        this.skipImageData();
        if (this.err()) {
            return;
        }
        final GifHeader header = this.header;
        ++header.frameCount;
        this.header.frames.add(this.header.currentFrame);
    }
    
    private int readBlock() {
        this.blockSize = this.read();
        int n = 0;
        int n2 = 0;
        if (this.blockSize > 0) {
            int length = 0;
            while (true) {
                int i = length;
                n = n2;
                try {
                    if (n2 < this.blockSize) {
                        i = length;
                        length = (i = this.blockSize - n2);
                        this.rawData.get(this.block, n2, length);
                        n2 += length;
                        continue;
                    }
                }
                catch (Exception ex) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + n2 + " count: " + i + " blockSize: " + this.blockSize, (Throwable)ex);
                    }
                    this.header.status = 1;
                    n = n2;
                }
                break;
            }
        }
        return n;
    }
    
    private int[] readColorTable(final int n) {
        int[] array = null;
        final byte[] dst = new byte[n * 3];
        try {
            this.rawData.get(dst);
            final int[] array2 = new int[256];
            int n2 = 0;
            int n3 = 0;
            while (true) {
                array = array2;
                if (n3 >= n) {
                    break;
                }
                final int n4 = n2 + 1;
                final byte b = dst[n2];
                final int n5 = n4 + 1;
                array2[n3] = (0xFF000000 | (b & 0xFF) << 16 | (dst[n4] & 0xFF) << 8 | (dst[n5] & 0xFF));
                n2 = n5 + 1;
                ++n3;
            }
        }
        catch (BufferUnderflowException ex) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", (Throwable)ex);
            }
            this.header.status = 1;
        }
        return array;
    }
    
    private void readContents() {
        int n = 0;
        while (n == 0 && !this.err()) {
            switch (this.read()) {
                default: {
                    this.header.status = 1;
                    continue;
                }
                case 44: {
                    if (this.header.currentFrame == null) {
                        this.header.currentFrame = new GifFrame();
                    }
                    this.readBitmap();
                    continue;
                }
                case 33: {
                    switch (this.read()) {
                        default: {
                            this.skip();
                            continue;
                        }
                        case 249: {
                            this.header.currentFrame = new GifFrame();
                            this.readGraphicControlExt();
                            continue;
                        }
                        case 255: {
                            this.readBlock();
                            String string = "";
                            for (int i = 0; i < 11; ++i) {
                                string += (char)this.block[i];
                            }
                            if (string.equals("NETSCAPE2.0")) {
                                this.readNetscapeExt();
                                continue;
                            }
                            this.skip();
                            continue;
                        }
                        case 254: {
                            this.skip();
                            continue;
                        }
                        case 1: {
                            this.skip();
                            continue;
                        }
                    }
                    break;
                }
                case 59: {
                    n = 1;
                    continue;
                }
            }
        }
    }
    
    private void readGraphicControlExt() {
        boolean transparency = true;
        this.read();
        final int read = this.read();
        this.header.currentFrame.dispose = (read & 0x1C) >> 2;
        if (this.header.currentFrame.dispose == 0) {
            this.header.currentFrame.dispose = 1;
        }
        final GifFrame currentFrame = this.header.currentFrame;
        if ((read & 0x1) == 0x0) {
            transparency = false;
        }
        currentFrame.transparency = transparency;
        int short1;
        if ((short1 = this.readShort()) < 3) {
            short1 = 10;
        }
        this.header.currentFrame.delay = short1 * 10;
        this.header.currentFrame.transIndex = this.read();
        this.read();
    }
    
    private void readHeader() {
        String string = "";
        for (int i = 0; i < 6; ++i) {
            string += (char)this.read();
        }
        if (!string.startsWith("GIF")) {
            this.header.status = 1;
        }
        else {
            this.readLSD();
            if (this.header.gctFlag && !this.err()) {
                this.header.gct = this.readColorTable(this.header.gctSize);
                this.header.bgColor = this.header.gct[this.header.bgIndex];
            }
        }
    }
    
    private void readLSD() {
        this.header.width = this.readShort();
        this.header.height = this.readShort();
        final int read = this.read();
        this.header.gctFlag = ((read & 0x80) != 0x0);
        this.header.gctSize = 2 << (read & 0x7);
        this.header.bgIndex = this.read();
        this.header.pixelAspect = this.read();
    }
    
    private void readNetscapeExt() {
        do {
            this.readBlock();
            if (this.block[0] == 1) {
                this.header.loopCount = ((this.block[2] & 0xFF) << 8 | (this.block[1] & 0xFF));
            }
        } while (this.blockSize > 0 && !this.err());
    }
    
    private int readShort() {
        return this.rawData.getShort();
    }
    
    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte)0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }
    
    private void skip() {
        int i;
        do {
            i = this.read();
            this.rawData.position(this.rawData.position() + i);
        } while (i > 0);
    }
    
    private void skipImageData() {
        this.read();
        this.skip();
    }
    
    public void clear() {
        this.rawData = null;
        this.header = null;
    }
    
    public GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (this.err()) {
            return this.header;
        }
        this.readHeader();
        if (!this.err()) {
            this.readContents();
            if (this.header.frameCount < 0) {
                this.header.status = 1;
            }
        }
        return this.header;
    }
    
    public GifHeaderParser setData(final byte[] array) {
        this.reset();
        if (array != null) {
            (this.rawData = ByteBuffer.wrap(array)).rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            return this;
        }
        this.rawData = null;
        this.header.status = 2;
        return this;
    }
}
