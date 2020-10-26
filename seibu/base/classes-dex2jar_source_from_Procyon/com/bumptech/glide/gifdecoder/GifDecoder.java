// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.gifdecoder;

import java.util.Iterator;
import java.nio.ByteOrder;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import android.annotation.TargetApi;
import android.os.Build$VERSION;
import android.util.Log;
import java.nio.ByteBuffer;
import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;

public class GifDecoder
{
    private static final Bitmap$Config BITMAP_CONFIG;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG;
    private int[] act;
    private BitmapProvider bitmapProvider;
    private final byte[] block;
    private byte[] data;
    private int framePointer;
    private GifHeader header;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    
    static {
        TAG = GifDecoder.class.getSimpleName();
        BITMAP_CONFIG = Bitmap$Config.ARGB_8888;
    }
    
    public GifDecoder(final BitmapProvider bitmapProvider) {
        this.block = new byte[256];
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }
    
    private void decodeBitmapData(final GifFrame gifFrame) {
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        int n;
        if (gifFrame == null) {
            n = this.header.width * this.header.height;
        }
        else {
            n = gifFrame.iw * gifFrame.ih;
        }
        if (this.mainPixels == null || this.mainPixels.length < n) {
            this.mainPixels = new byte[n];
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        final int read = this.read();
        final int n2 = 1 << read;
        int n3 = n2 + 2;
        int n4 = -1;
        int n5 = read + 1;
        int n6 = (1 << n5) - 1;
        for (int i = 0; i < n2; ++i) {
            this.prefix[i] = 0;
            this.suffix[i] = (byte)i;
        }
        int n7 = 0;
        int j = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int k = 0;
    Label_0211:
        while (k < n) {
            int n13 = n7;
            int block;
            if ((block = n10) == 0) {
                block = this.readBlock();
                if (block <= 0) {
                    this.status = 3;
                    break;
                }
                n13 = 0;
            }
            n12 += (this.block[n13] & 0xFF) << n11;
            int l = n11 + 8;
            final int n14 = n13 + 1;
            final int n15 = block - 1;
            int n16 = n3;
            while (l >= n5) {
                final int n17 = n12 & n6;
                final int n18 = n12 >> n5;
                final int n19 = l - n5;
                if (n17 == n2) {
                    n5 = read + 1;
                    n6 = (1 << n5) - 1;
                    n16 = n2 + 2;
                    n4 = -1;
                    l = n19;
                    n12 = n18;
                }
                else {
                    if (n17 > n16) {
                        this.status = 3;
                        n3 = n16;
                        n7 = n14;
                        n11 = n19;
                        n10 = n15;
                        n12 = n18;
                        continue Label_0211;
                    }
                    if (n17 == n2 + 1) {
                        n3 = n16;
                        n7 = n14;
                        n11 = n19;
                        n10 = n15;
                        n12 = n18;
                        continue Label_0211;
                    }
                    if (n4 == -1) {
                        this.pixelStack[n8] = this.suffix[n17];
                        n4 = n17;
                        ++n8;
                        l = n19;
                        n12 = n18;
                        n9 = n17;
                    }
                    else {
                        int n20 = n17;
                        int n21 = n8;
                        if (n17 >= n16) {
                            this.pixelStack[n8] = (byte)n9;
                            n20 = n4;
                            n21 = n8 + 1;
                        }
                        while (n20 >= n2) {
                            this.pixelStack[n21] = this.suffix[n20];
                            n20 = this.prefix[n20];
                            ++n21;
                        }
                        final int n22 = this.suffix[n20] & 0xFF;
                        final byte[] pixelStack = this.pixelStack;
                        final int n23 = n21 + 1;
                        pixelStack[n21] = (byte)n22;
                        int n24 = n16;
                        int n25 = n6;
                        int n26 = n5;
                        if (n16 < 4096) {
                            this.prefix[n16] = (short)n4;
                            this.suffix[n16] = (byte)n22;
                            final int n27 = n24 = n16 + 1;
                            n25 = n6;
                            n26 = n5;
                            if ((n27 & n6) == 0x0) {
                                n24 = n27;
                                n25 = n6;
                                n26 = n5;
                                if (n27 < 4096) {
                                    n26 = n5 + 1;
                                    n25 = n6 + n27;
                                    n24 = n27;
                                }
                            }
                        }
                        int n28;
                        int n29;
                        for (n28 = j, n29 = n23; n29 > 0; --n29, this.mainPixels[n28] = this.pixelStack[n29], ++k, ++n28) {}
                        final int n30 = n29;
                        n16 = n24;
                        l = n19;
                        n6 = n25;
                        n5 = n26;
                        n12 = n18;
                        n9 = n22;
                        n4 = n17;
                        j = n28;
                        n8 = n30;
                    }
                }
            }
            n3 = n16;
            n7 = n14;
            n11 = l;
            n10 = n15;
        }
        while (j < n) {
            this.mainPixels[j] = 0;
            ++j;
        }
    }
    
    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }
    
    private Bitmap getNextBitmap() {
        Bitmap alpha;
        if ((alpha = this.bitmapProvider.obtain(this.header.width, this.header.height, GifDecoder.BITMAP_CONFIG)) == null) {
            alpha = Bitmap.createBitmap(this.header.width, this.header.height, GifDecoder.BITMAP_CONFIG);
        }
        setAlpha(alpha);
        return alpha;
    }
    
    private int read() {
        try {
            return this.rawData.get() & 0xFF;
        }
        catch (Exception ex) {
            this.status = 1;
            return 0;
        }
    }
    
    private int readBlock() {
        final int read = this.read();
        int n = 0;
        int offset = 0;
        if (read > 0) {
            while ((n = offset) < read) {
                final int length = read - offset;
                try {
                    this.rawData.get(this.block, offset, length);
                    offset += length;
                    continue;
                }
                catch (Exception ex) {
                    Log.w(GifDecoder.TAG, "Error Reading Block", (Throwable)ex);
                    this.status = 1;
                    n = offset;
                }
                break;
            }
        }
        return n;
    }
    
    @TargetApi(12)
    private static void setAlpha(final Bitmap bitmap) {
        if (Build$VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
    
    private Bitmap setPixels(final GifFrame gifFrame, final GifFrame gifFrame2) {
        final int width = this.header.width;
        final int height = this.header.height;
        final int[] mainScratch = this.mainScratch;
        if (gifFrame2 != null && gifFrame2.dispose > 0) {
            if (gifFrame2.dispose == 2) {
                int bgColor = 0;
                if (!gifFrame.transparency) {
                    bgColor = this.header.bgColor;
                }
                Arrays.fill(mainScratch, bgColor);
            }
            else if (gifFrame2.dispose == 3 && this.previousImage != null) {
                this.previousImage.getPixels(mainScratch, 0, width, 0, 0, width, height);
            }
        }
        this.decodeBitmapData(gifFrame);
        int n = 1;
        int n2 = 8;
        int n3 = 0;
        int n5;
        int n6;
        int n7;
        for (int i = 0; i < gifFrame.ih; ++i, n3 = n5, n2 = n6, n = n7) {
            int n4 = i;
            n5 = n3;
            n6 = n2;
            n7 = n;
            if (gifFrame.interlace) {
                int n8 = n3;
                n6 = n2;
                n7 = n;
                if (n3 >= gifFrame.ih) {
                    n7 = n + 1;
                    switch (n7) {
                        default: {
                            n6 = n2;
                            n8 = n3;
                            break;
                        }
                        case 2: {
                            n8 = 4;
                            n6 = n2;
                            break;
                        }
                        case 3: {
                            n8 = 2;
                            n6 = 4;
                            break;
                        }
                        case 4: {
                            n8 = 1;
                            n6 = 2;
                            break;
                        }
                    }
                }
                n4 = n8;
                n5 = n8 + n6;
            }
            final int n9 = n4 + gifFrame.iy;
            if (n9 < this.header.height) {
                final int n10 = n9 * this.header.width;
                int j = n10 + gifFrame.ix;
                int n11;
                if (this.header.width + n10 < (n11 = j + gifFrame.iw)) {
                    n11 = n10 + this.header.width;
                }
                for (int n12 = i * gifFrame.iw; j < n11; ++j, ++n12) {
                    final int n13 = this.act[this.mainPixels[n12] & 0xFF];
                    if (n13 != 0) {
                        mainScratch[j] = n13;
                    }
                }
            }
        }
        if (this.savePrevious && (gifFrame.dispose == 0 || gifFrame.dispose == 1)) {
            if (this.previousImage == null) {
                this.previousImage = this.getNextBitmap();
            }
            this.previousImage.setPixels(mainScratch, 0, width, 0, 0, width, height);
        }
        final Bitmap nextBitmap = this.getNextBitmap();
        nextBitmap.setPixels(mainScratch, 0, width, 0, 0, width, height);
        return nextBitmap;
    }
    
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }
    
    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        if (this.previousImage != null) {
            this.bitmapProvider.release(this.previousImage);
        }
        this.previousImage = null;
        this.rawData = null;
    }
    
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }
    
    public byte[] getData() {
        return this.data;
    }
    
    public int getDelay(final int n) {
        int delay = -1;
        if (n >= 0) {
            delay = delay;
            if (n < this.header.frameCount) {
                delay = this.header.frames.get(n).delay;
            }
        }
        return delay;
    }
    
    public int getFrameCount() {
        return this.header.frameCount;
    }
    
    public int getHeight() {
        return this.header.height;
    }
    
    public int getLoopCount() {
        return this.header.loopCount;
    }
    
    public int getNextDelay() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            return -1;
        }
        return this.getDelay(this.framePointer);
    }
    
    public Bitmap getNextFrame() {
        while (true) {
            Bitmap bitmap = null;
            GifFrame gifFrame = null;
            int n = 0;
        Label_0330:
            while (true) {
                Label_0295: {
                    synchronized (this) {
                        if (this.header.frameCount <= 0 || this.framePointer < 0) {
                            if (Log.isLoggable(GifDecoder.TAG, 3)) {
                                Log.d(GifDecoder.TAG, "unable to decode frame, frameCount=" + this.header.frameCount + " framePointer=" + this.framePointer);
                            }
                            this.status = 1;
                        }
                        Bitmap setPixels;
                        if (this.status == 1 || this.status == 2) {
                            setPixels = bitmap;
                            if (Log.isLoggable(GifDecoder.TAG, 3)) {
                                Log.d(GifDecoder.TAG, "Unable to decode frame, status=" + this.status);
                                setPixels = bitmap;
                            }
                        }
                        else {
                            this.status = 0;
                            gifFrame = this.header.frames.get(this.framePointer);
                            n = this.framePointer - 1;
                            if (n >= 0) {
                                final GifFrame gifFrame2 = this.header.frames.get(n);
                            }
                            if (gifFrame.lct != null) {
                                break Label_0295;
                            }
                            this.act = this.header.gct;
                            n = 0;
                            if (gifFrame.transparency) {
                                n = this.act[gifFrame.transIndex];
                                this.act[gifFrame.transIndex] = 0;
                            }
                            if (this.act != null) {
                                break Label_0330;
                            }
                            if (Log.isLoggable(GifDecoder.TAG, 3)) {
                                Log.d(GifDecoder.TAG, "No Valid Color Table");
                            }
                            this.status = 1;
                            setPixels = bitmap;
                        }
                        return setPixels;
                    }
                }
                this.act = gifFrame.lct;
                if (this.header.bgIndex == gifFrame.transIndex) {
                    this.header.bgColor = 0;
                    continue;
                }
                continue;
            }
            Bitmap setPixels;
            final GifFrame gifFrame3;
            bitmap = (setPixels = this.setPixels(gifFrame, gifFrame3));
            if (gifFrame.transparency) {
                this.act[gifFrame.transIndex] = n;
                setPixels = bitmap;
                return setPixels;
            }
            return setPixels;
        }
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public int getWidth() {
        return this.header.width;
    }
    
    public int read(final InputStream inputStream, int read) {
        int size = 16384;
        Label_0108: {
            if (inputStream == null) {
                break Label_0108;
            }
            if (read > 0) {
                size = read + 4096;
            }
            Label_0090: {
                try {
                    final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(size);
                    final byte[] array = new byte[16384];
                    while (true) {
                        read = inputStream.read(array, 0, array.length);
                        if (read == -1) {
                            break Label_0090;
                        }
                        byteArrayOutputStream.write(array, 0, read);
                    }
                }
                catch (IOException ex) {
                    Log.w(GifDecoder.TAG, "Error reading data from stream", (Throwable)ex);
                }
                while (true) {
                    Label_0085: {
                        if (inputStream == null) {
                            break Label_0085;
                        }
                        try {
                            inputStream.close();
                            return this.status;
                            this.status = 2;
                            continue;
                            final ByteArrayOutputStream byteArrayOutputStream;
                            byteArrayOutputStream.flush();
                            this.read(byteArrayOutputStream.toByteArray());
                            continue;
                        }
                        catch (IOException ex2) {
                            Log.w(GifDecoder.TAG, "Error closing stream", (Throwable)ex2);
                            return this.status;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public int read(final byte[] array) {
        this.data = array;
        this.header = this.getHeaderParser().setData(array).parseHeader();
        if (array != null) {
            (this.rawData = ByteBuffer.wrap(array)).rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.mainPixels = new byte[this.header.width * this.header.height];
            this.mainScratch = new int[this.header.width * this.header.height];
            this.savePrevious = false;
            final Iterator<GifFrame> iterator = this.header.frames.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
        }
        return this.status;
    }
    
    public void resetFrameIndex() {
        this.framePointer = -1;
    }
    
    public void setData(final GifHeader header, final byte[] array) {
        this.header = header;
        this.data = array;
        this.status = 0;
        this.framePointer = -1;
        (this.rawData = ByteBuffer.wrap(array)).rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        final Iterator<GifFrame> iterator = header.frames.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        this.mainPixels = new byte[header.width * header.height];
        this.mainScratch = new int[header.width * header.height];
    }
    
    public interface BitmapProvider
    {
        Bitmap obtain(final int p0, final int p1, final Bitmap$Config p2);
        
        void release(final Bitmap p0);
    }
}
