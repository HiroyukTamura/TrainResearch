// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.bitmap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.io.IOException;
import android.util.Log;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class ImageHeaderParser
{
    private static final int[] BYTES_PER_FORMAT;
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final String TAG = "ImageHeaderParser";
    private final StreamReader streamReader;
    
    static {
        BYTES_PER_FORMAT = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
        byte[] bytes = new byte[0];
        while (true) {
            try {
                bytes = "Exif\u0000\u0000".getBytes("UTF-8");
                JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = bytes;
            }
            catch (UnsupportedEncodingException ex) {
                continue;
            }
            break;
        }
    }
    
    public ImageHeaderParser(final InputStream inputStream) {
        this.streamReader = new StreamReader(inputStream);
    }
    
    private static int calcTagOffset(final int n, final int n2) {
        return n + 2 + n2 * 12;
    }
    
    private byte[] getExifSegment() throws IOException {
        long skip;
        int n;
        short uInt9;
        do {
            final short uInt8 = this.streamReader.getUInt8();
            byte[] array;
            if (uInt8 != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + uInt8);
                }
                array = null;
            }
            else {
                uInt9 = this.streamReader.getUInt8();
                if (uInt9 == 218) {
                    return null;
                }
                if (uInt9 == 217) {
                    if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                    }
                    return null;
                }
                n = this.streamReader.getUInt16() - 2;
                if (uInt9 != 225) {
                    skip = this.streamReader.skip(n);
                    continue;
                }
                array = new byte[n];
                final int read = this.streamReader.read(array);
                if (read != n) {
                    if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Unable to read segment data, type: " + uInt9 + ", length: " + n + ", actually read: " + read);
                    }
                    return null;
                }
            }
            return array;
        } while (skip == n);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + uInt9 + ", wanted to skip: " + n + ", but actually skipped: " + skip);
        }
        return null;
    }
    
    private static boolean handles(final int n) {
        return (n & 0xFFD8) == 0xFFD8 || n == 19789 || n == 18761;
    }
    
    private static int parseExifSegment(final RandomAccessReader randomAccessReader) {
        final int length = "Exif\u0000\u0000".length();
        final short int16 = randomAccessReader.getInt16(length);
        ByteOrder byteOrder;
        if (int16 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        else if (int16 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + int16);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        final int n = randomAccessReader.getInt32(length + 4) + length;
        final short int17 = randomAccessReader.getInt16(n);
        for (int i = 0; i < int17; ++i) {
            final int calcTagOffset = calcTagOffset(n, i);
            final short int18 = randomAccessReader.getInt16(calcTagOffset);
            if (int18 == 274) {
                final short int19 = randomAccessReader.getInt16(calcTagOffset + 2);
                if (int19 < 1 || int19 > 12) {
                    if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Got invalid format code=" + int19);
                    }
                }
                else {
                    final int int20 = randomAccessReader.getInt32(calcTagOffset + 4);
                    if (int20 < 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Negative tiff component count");
                        }
                    }
                    else {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i + " tagType=" + int18 + " formatCode=" + int19 + " componentCount=" + int20);
                        }
                        final int n2 = int20 + ImageHeaderParser.BYTES_PER_FORMAT[int19];
                        if (n2 > 4) {
                            if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + int19);
                            }
                        }
                        else {
                            final int j = calcTagOffset + 8;
                            if (j < 0 || j > randomAccessReader.length()) {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + j + " tagType=" + int18);
                                }
                            }
                            else {
                                if (n2 >= 0 && j + n2 <= randomAccessReader.length()) {
                                    return randomAccessReader.getInt16(j);
                                }
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + int18);
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    public int getOrientation() throws IOException {
        if (handles(this.streamReader.getUInt16())) {
            final byte[] exifSegment = this.getExifSegment();
            boolean b;
            if (exifSegment != null && exifSegment.length > ImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) {
                b = true;
            }
            else {
                b = false;
            }
            int n = b ? 1 : 0;
            if (b) {
                int n2 = 0;
                while (true) {
                    n = (b ? 1 : 0);
                    if (n2 >= ImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length) {
                        break;
                    }
                    if (exifSegment[n2] != ImageHeaderParser.JPEG_EXIF_SEGMENT_PREAMBLE_BYTES[n2]) {
                        n = 0;
                        break;
                    }
                    ++n2;
                }
            }
            if (n != 0) {
                return parseExifSegment(new RandomAccessReader(exifSegment));
            }
        }
        return -1;
    }
    
    public ImageType getType() throws IOException {
        final int uInt16 = this.streamReader.getUInt16();
        if (uInt16 == 65496) {
            return ImageType.JPEG;
        }
        final int n = (uInt16 << 16 & 0xFFFF0000) | (this.streamReader.getUInt16() & 0xFFFF);
        if (n == -1991225785) {
            this.streamReader.skip(21L);
            if (this.streamReader.getByte() >= 3) {
                return ImageType.PNG_A;
            }
            return ImageType.PNG;
        }
        else {
            if (n >> 8 == 4671814) {
                return ImageType.GIF;
            }
            return ImageType.UNKNOWN;
        }
    }
    
    public boolean hasAlpha() throws IOException {
        return this.getType().hasAlpha();
    }
    
    public enum ImageType
    {
        GIF(true), 
        JPEG(false), 
        PNG(false), 
        PNG_A(true), 
        UNKNOWN(false);
        
        private final boolean hasAlpha;
        
        private ImageType(final boolean hasAlpha) {
            this.hasAlpha = hasAlpha;
        }
        
        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }
    
    private static class RandomAccessReader
    {
        private final ByteBuffer data;
        
        public RandomAccessReader(final byte[] array) {
            (this.data = ByteBuffer.wrap(array)).order(ByteOrder.BIG_ENDIAN);
        }
        
        public short getInt16(final int n) {
            return this.data.getShort(n);
        }
        
        public int getInt32(final int n) {
            return this.data.getInt(n);
        }
        
        public int length() {
            return this.data.array().length;
        }
        
        public void order(final ByteOrder bo) {
            this.data.order(bo);
        }
    }
    
    private static class StreamReader
    {
        private final InputStream is;
        
        public StreamReader(final InputStream is) {
            this.is = is;
        }
        
        public int getByte() throws IOException {
            return this.is.read();
        }
        
        public int getUInt16() throws IOException {
            return (this.is.read() << 8 & 0xFF00) | (this.is.read() & 0xFF);
        }
        
        public short getUInt8() throws IOException {
            return (short)(this.is.read() & 0xFF);
        }
        
        public int read(final byte[] b) throws IOException {
            int i;
            int read;
            for (i = b.length; i > 0; i -= read) {
                read = this.is.read(b, b.length - i, i);
                if (read == -1) {
                    break;
                }
            }
            return b.length - i;
        }
        
        public long skip(final long n) throws IOException {
            if (n < 0L) {
                return 0L;
            }
            long n2 = n;
            while (n2 > 0L) {
                final long skip = this.is.skip(n2);
                if (skip > 0L) {
                    n2 -= skip;
                }
                else {
                    if (this.is.read() == -1) {
                        break;
                    }
                    --n2;
                }
            }
            return n - n2;
        }
    }
}
