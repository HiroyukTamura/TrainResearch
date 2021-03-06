// 
// Decompiled by Procyon v0.5.36
// 

package okio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.nio.charset.Charset;
import java.io.OutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Mac;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import javax.annotation.Nullable;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable
{
    private static final byte[] DIGITS;
    static final int REPLACEMENT_CHARACTER = 65533;
    @Nullable
    Segment head;
    long size;
    
    static {
        DIGITS = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    }
    
    private ByteString digest(final String algorithm) {
        try {
            final MessageDigest instance = MessageDigest.getInstance(algorithm);
            if (this.head != null) {
                instance.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                for (Segment segment = this.head.next; segment != this.head; segment = segment.next) {
                    instance.update(segment.data, segment.pos, segment.limit - segment.pos);
                }
            }
            return ByteString.of(instance.digest());
        }
        catch (NoSuchAlgorithmException ex) {
            throw new AssertionError();
        }
    }
    
    private ByteString hmac(final String s, final ByteString byteString) {
        try {
            final Mac instance = Mac.getInstance(s);
            instance.init(new SecretKeySpec(byteString.toByteArray(), s));
            if (this.head != null) {
                instance.update(this.head.data, this.head.pos, this.head.limit - this.head.pos);
                for (Segment segment = this.head.next; segment != this.head; segment = segment.next) {
                    instance.update(segment.data, segment.pos, segment.limit - segment.pos);
                }
            }
            return ByteString.of(instance.doFinal());
        }
        catch (NoSuchAlgorithmException ex) {
            throw new AssertionError();
        }
        catch (InvalidKeyException cause) {
            throw new IllegalArgumentException(cause);
        }
    }
    
    private boolean rangeEquals(Segment segment, int n, final ByteString byteString, int i, final int n2) {
        int limit = segment.limit;
        byte[] array = segment.data;
        while (i < n2) {
            int limit2 = limit;
            Segment next = segment;
            int pos;
            if ((pos = n) == limit) {
                next = segment.next;
                array = next.data;
                pos = next.pos;
                limit2 = next.limit;
            }
            if (array[pos] != byteString.getByte(i)) {
                return false;
            }
            n = pos + 1;
            ++i;
            limit = limit2;
            segment = next;
        }
        return true;
    }
    
    private void readFrom(final InputStream inputStream, long a, final boolean b) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        while (a > 0L || b) {
            final Segment writableSegment = this.writableSegment(1);
            final int read = inputStream.read(writableSegment.data, writableSegment.limit, (int)Math.min(a, 8192 - writableSegment.limit));
            if (read == -1) {
                if (b) {
                    break;
                }
                throw new EOFException();
            }
            else {
                writableSegment.limit += read;
                this.size += read;
                a -= read;
            }
        }
    }
    
    @Override
    public Buffer buffer() {
        return this;
    }
    
    public void clear() {
        try {
            this.skip(this.size);
        }
        catch (EOFException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    public Buffer clone() {
        final Buffer buffer = new Buffer();
        if (this.size == 0L) {
            return buffer;
        }
        buffer.head = new Segment(this.head);
        final Segment head = buffer.head;
        final Segment head2 = buffer.head;
        final Segment head3 = buffer.head;
        head2.prev = head3;
        head.next = head3;
        for (Segment segment = this.head.next; segment != this.head; segment = segment.next) {
            buffer.head.prev.push(new Segment(segment));
        }
        buffer.size = this.size;
        return buffer;
    }
    
    public void close() {
    }
    
    public long completeSegmentByteCount() {
        final long size = this.size;
        if (size == 0L) {
            return 0L;
        }
        final Segment prev = this.head.prev;
        long n = size;
        if (prev.limit < 8192) {
            n = size;
            if (prev.owner) {
                n = size - (prev.limit - prev.pos);
            }
        }
        return n;
    }
    
    public Buffer copyTo(final OutputStream outputStream) throws IOException {
        return this.copyTo(outputStream, 0L, this.size);
    }
    
    public Buffer copyTo(final OutputStream outputStream, long n, final long n2) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, n, n2);
        if (n2 != 0L) {
            Segment segment = this.head;
            Segment next;
            long n3;
            long b;
            while (true) {
                next = segment;
                n3 = n;
                b = n2;
                if (n < segment.limit - segment.pos) {
                    break;
                }
                n -= segment.limit - segment.pos;
                segment = segment.next;
            }
            while (b > 0L) {
                final int off = (int)(next.pos + n3);
                final int len = (int)Math.min(next.limit - off, b);
                outputStream.write(next.data, off, len);
                b -= len;
                n3 = 0L;
                next = next.next;
            }
        }
        return this;
    }
    
    public Buffer copyTo(final Buffer buffer, long n, final long n2) {
        if (buffer == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, n, n2);
        if (n2 != 0L) {
            buffer.size += n2;
            Segment segment = this.head;
            Segment next;
            long n3;
            long n4;
            while (true) {
                next = segment;
                n3 = n;
                n4 = n2;
                if (n < segment.limit - segment.pos) {
                    break;
                }
                n -= segment.limit - segment.pos;
                segment = segment.next;
            }
            while (n4 > 0L) {
                final Segment head = new Segment(next);
                head.pos += (int)n3;
                head.limit = Math.min(head.pos + (int)n4, head.limit);
                if (buffer.head == null) {
                    head.prev = head;
                    head.next = head;
                    buffer.head = head;
                }
                else {
                    buffer.head.prev.push(head);
                }
                n4 -= head.limit - head.pos;
                n3 = 0L;
                next = next.next;
            }
        }
        return this;
    }
    
    public BufferedSink emit() {
        return (BufferedSink)this;
    }
    
    public Buffer emitCompleteSegments() {
        return this;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Buffer)) {
            return false;
        }
        final Buffer buffer = (Buffer)o;
        if (this.size != buffer.size) {
            return false;
        }
        if (this.size == 0L) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int pos = segment.pos;
        int pos2 = segment2.pos;
        long n2;
        int pos3;
        int pos4;
        for (long n = 0L; n < this.size; n += n2, pos = pos3, pos2 = pos4) {
            n2 = Math.min(segment.limit - pos, segment2.limit - pos2);
            final int n3 = 0;
            final int n4 = pos;
            int n5 = pos2;
            pos3 = n4;
            for (int n6 = n3; n6 < n2; ++n6, ++n5, ++pos3) {
                if (segment.data[pos3] != segment2.data[n5]) {
                    return false;
                }
            }
            if (pos3 == segment.limit) {
                segment = segment.next;
                pos3 = segment.pos;
            }
            if (n5 == segment2.limit) {
                segment2 = segment2.next;
                pos4 = segment2.pos;
            }
            else {
                pos4 = n5;
            }
        }
        return true;
    }
    
    @Override
    public boolean exhausted() {
        return this.size == 0L;
    }
    
    public void flush() {
    }
    
    public byte getByte(long n) {
        Util.checkOffsetAndCount(this.size, n, 1L);
        Segment segment = this.head;
        while (true) {
            final int n2 = segment.limit - segment.pos;
            if (n < n2) {
                break;
            }
            n -= n2;
            segment = segment.next;
        }
        return segment.data[segment.pos + (int)n];
    }
    
    @Override
    public int hashCode() {
        Segment head = this.head;
        if (head == null) {
            return 0;
        }
        int n = 1;
        Segment next;
        int n2;
        do {
            final int pos = head.pos;
            final int limit = head.limit;
            n2 = n;
            for (int i = pos; i < limit; ++i) {
                n2 = n2 * 31 + head.data[i];
            }
            next = head.next;
            n = n2;
        } while ((head = next) != this.head);
        return n2;
    }
    
    public ByteString hmacSha1(final ByteString byteString) {
        return this.hmac("HmacSHA1", byteString);
    }
    
    public ByteString hmacSha256(final ByteString byteString) {
        return this.hmac("HmacSHA256", byteString);
    }
    
    public ByteString hmacSha512(final ByteString byteString) {
        return this.hmac("HmacSHA512", byteString);
    }
    
    @Override
    public long indexOf(final byte b) {
        return this.indexOf(b, 0L, Long.MAX_VALUE);
    }
    
    @Override
    public long indexOf(final byte b, final long n) {
        return this.indexOf(b, n, Long.MAX_VALUE);
    }
    
    @Override
    public long indexOf(final byte b, final long l, long i) {
        if (l < 0L || i < l) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", this.size, l, i));
        }
        long size = i;
        if (i > this.size) {
            size = this.size;
        }
        if (l == size) {
            return -1L;
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        Segment next;
        long n;
        if (this.size - l < l) {
            long size2 = this.size;
            while (true) {
                i = size2;
                next = segment;
                n = l;
                if (size2 <= l) {
                    break;
                }
                segment = segment.prev;
                size2 -= segment.limit - segment.pos;
            }
        }
        else {
            i = 0L;
            while (true) {
                final long n2 = i + (segment.limit - segment.pos);
                next = segment;
                n = l;
                if (n2 >= l) {
                    break;
                }
                segment = segment.next;
                i = n2;
            }
        }
        while (i < size) {
            final byte[] data = next.data;
            for (int n3 = (int)Math.min(next.limit, next.pos + size - i), j = (int)(next.pos + n - i); j < n3; ++j) {
                if (data[j] == b) {
                    return j - next.pos + i;
                }
            }
            i = (n = i + (next.limit - next.pos));
            next = next.next;
        }
        return -1L;
    }
    
    @Override
    public long indexOf(final ByteString byteString) throws IOException {
        return this.indexOf(byteString, 0L);
    }
    
    @Override
    public long indexOf(final ByteString byteString, long n) throws IOException {
        if (byteString.size() == 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        if (n < 0L) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        Segment next;
        long n2;
        if (this.size - n < n) {
            long size = this.size;
            while (true) {
                next = segment;
                n2 = size;
                if (size <= n) {
                    break;
                }
                segment = segment.prev;
                size -= segment.limit - segment.pos;
            }
        }
        else {
            n2 = 0L;
            while (true) {
                final long n3 = n2 + (segment.limit - segment.pos);
                next = segment;
                if (n3 >= n) {
                    break;
                }
                segment = segment.next;
                n2 = n3;
            }
        }
        final byte byte1 = byteString.getByte(0);
        final int size2 = byteString.size();
        for (long n4 = this.size - size2 + 1L; n2 < n4; n2 = (n = n2 + (next.limit - next.pos)), next = next.next) {
            final byte[] data = next.data;
            for (int n5 = (int)Math.min(next.limit, next.pos + n4 - n2), i = (int)(next.pos + n - n2); i < n5; ++i) {
                if (data[i] == byte1 && this.rangeEquals(next, i + 1, byteString, 1, size2)) {
                    return i - next.pos + n2;
                }
            }
        }
        return -1L;
    }
    
    @Override
    public long indexOfElement(final ByteString byteString) {
        return this.indexOfElement(byteString, 0L);
    }
    
    @Override
    public long indexOfElement(final ByteString byteString, long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("fromIndex < 0");
        }
        Segment segment = this.head;
        if (segment == null) {
            return -1L;
        }
        long n2;
        Segment segment2;
        if (this.size - n < n) {
            long size = this.size;
            while (true) {
                n2 = size;
                segment2 = segment;
                if (size <= n) {
                    break;
                }
                segment = segment.prev;
                size -= segment.limit - segment.pos;
            }
        }
        else {
            n2 = 0L;
            while (true) {
                final long n3 = n2 + (segment.limit - segment.pos);
                segment2 = segment;
                if (n3 >= n) {
                    break;
                }
                segment = segment.next;
                n2 = n3;
            }
        }
        if (byteString.size() == 2) {
            final byte byte1 = byteString.getByte(0);
            final byte byte2 = byteString.getByte(1);
            while (n2 < this.size) {
                final byte[] data = segment2.data;
                for (int i = (int)(segment2.pos + n - n2); i < segment2.limit; ++i) {
                    final byte b = data[i];
                    if (b == byte1 || b == byte2) {
                        return i - segment2.pos + n2;
                    }
                }
                n2 = (n = n2 + (segment2.limit - segment2.pos));
                segment2 = segment2.next;
            }
        }
        else {
            final byte[] internalArray = byteString.internalArray();
            while (n2 < this.size) {
                final byte[] data2 = segment2.data;
                for (int j = (int)(segment2.pos + n - n2); j < segment2.limit; ++j) {
                    final byte b2 = data2[j];
                    for (int length = internalArray.length, k = 0; k < length; ++k) {
                        if (b2 == internalArray[k]) {
                            return j - segment2.pos + n2;
                        }
                    }
                }
                n2 = (n = n2 + (segment2.limit - segment2.pos));
                segment2 = segment2.next;
            }
        }
        return -1L;
    }
    
    @Override
    public InputStream inputStream() {
        return (InputStream)new Buffer$2(this);
    }
    
    public ByteString md5() {
        return this.digest("MD5");
    }
    
    public OutputStream outputStream() {
        return (OutputStream)new Buffer$1(this);
    }
    
    @Override
    public boolean rangeEquals(final long n, final ByteString byteString) {
        return this.rangeEquals(n, byteString, 0, byteString.size());
    }
    
    @Override
    public boolean rangeEquals(final long n, final ByteString byteString, final int n2, final int n3) {
        if (n >= 0L && n2 >= 0 && n3 >= 0 && this.size - n >= n3 && byteString.size() - n2 >= n3) {
            for (int i = 0; i < n3; ++i) {
                if (this.getByte(i + n) != byteString.getByte(n2 + i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public int read(final byte[] array) {
        return this.read(array, 0, array.length);
    }
    
    @Override
    public int read(final byte[] array, int n, int min) {
        Util.checkOffsetAndCount((long)array.length, (long)n, (long)min);
        final Segment head = this.head;
        if (head == null) {
            n = -1;
        }
        else {
            min = Math.min(min, head.limit - head.pos);
            System.arraycopy(head.data, head.pos, array, n, min);
            head.pos += min;
            this.size -= min;
            n = min;
            if (head.pos == head.limit) {
                this.head = head.pop();
                SegmentPool.recycle(head);
                return min;
            }
        }
        return n;
    }
    
    public long read(final Buffer buffer, final long lng) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (lng < 0L) {
            throw new IllegalArgumentException("byteCount < 0: " + lng);
        }
        if (this.size == 0L) {
            return -1L;
        }
        long size = lng;
        if (lng > this.size) {
            size = this.size;
        }
        buffer.write(this, size);
        return size;
    }
    
    @Override
    public long readAll(final Sink sink) throws IOException {
        final long size = this.size;
        if (size > 0L) {
            sink.write(this, size);
        }
        return size;
    }
    
    @Override
    public byte readByte() {
        if (this.size == 0L) {
            throw new IllegalStateException("size == 0");
        }
        final Segment head = this.head;
        final int pos = head.pos;
        final int limit = head.limit;
        final byte[] data = head.data;
        final int pos2 = pos + 1;
        final byte b = data[pos];
        --this.size;
        if (pos2 == limit) {
            this.head = head.pop();
            SegmentPool.recycle(head);
            return b;
        }
        head.pos = pos2;
        return b;
    }
    
    @Override
    public byte[] readByteArray() {
        try {
            return this.readByteArray(this.size);
        }
        catch (EOFException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    @Override
    public byte[] readByteArray(final long lng) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, lng);
        if (lng > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + lng);
        }
        final byte[] array = new byte[(int)lng];
        this.readFully(array);
        return array;
    }
    
    @Override
    public ByteString readByteString() {
        return new ByteString(this.readByteArray());
    }
    
    @Override
    public ByteString readByteString(final long n) throws EOFException {
        return new ByteString(this.readByteArray(n));
    }
    
    @Override
    public long readDecimalLong() {
        if (this.size == 0L) {
            throw new IllegalStateException("size == 0");
        }
        long n = 0L;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        long n5 = -7L;
        long n6;
        int n7;
        int n9;
        do {
            final Segment head = this.head;
            final byte[] data = head.data;
            final int pos = head.pos;
            final int limit = head.limit;
            n6 = n;
            n7 = n2;
            long n8 = n5;
            int pos2 = pos;
            n9 = n3;
            int n10;
            while (true) {
                n10 = n4;
                if (pos2 >= limit) {
                    break;
                }
                final byte i = data[pos2];
                if (i >= 48 && i <= 57) {
                    final int n11 = 48 - i;
                    if (n6 < -922337203685477580L || (n6 == -922337203685477580L && n11 < n8)) {
                        final Buffer writeByte = new Buffer().writeDecimalLong(n6).writeByte(i);
                        if (n9 == 0) {
                            writeByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                    }
                    n6 = n6 * 10L + n11;
                }
                else if (i == 45 && n7 == 0) {
                    n9 = 1;
                    --n8;
                }
                else {
                    if (n7 == 0) {
                        throw new NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + Integer.toHexString(i));
                    }
                    n10 = 1;
                    break;
                }
                ++pos2;
                ++n7;
            }
            if (pos2 == limit) {
                this.head = head.pop();
                SegmentPool.recycle(head);
            }
            else {
                head.pos = pos2;
            }
            if (n10 != 0) {
                break;
            }
            n4 = n10;
            n3 = n9;
            n5 = n8;
            n2 = n7;
            n = n6;
        } while (this.head != null);
        this.size -= n7;
        if (n9 != 0) {
            return n6;
        }
        return -n6;
    }
    
    public Buffer readFrom(final InputStream inputStream) throws IOException {
        this.readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }
    
    public Buffer readFrom(final InputStream inputStream, final long lng) throws IOException {
        if (lng < 0L) {
            throw new IllegalArgumentException("byteCount < 0: " + lng);
        }
        this.readFrom(inputStream, lng, false);
        return this;
    }
    
    @Override
    public void readFully(final Buffer buffer, final long n) throws EOFException {
        if (this.size < n) {
            buffer.write(this, this.size);
            throw new EOFException();
        }
        buffer.write(this, n);
    }
    
    @Override
    public void readFully(final byte[] array) throws EOFException {
        int read;
        for (int i = 0; i < array.length; i += read) {
            read = this.read(array, i, array.length - i);
            if (read == -1) {
                throw new EOFException();
            }
        }
    }
    
    @Override
    public long readHexadecimalUnsignedLong() {
        if (this.size == 0L) {
            throw new IllegalStateException("size == 0");
        }
        long n = 0L;
        int n2 = 0;
        int n3 = 0;
        long n4;
        int n5;
        do {
            final Segment head = this.head;
            final byte[] data = head.data;
            int pos = head.pos;
            final int limit = head.limit;
            n4 = n;
            n5 = n2;
            int n6;
            while (true) {
                n6 = n3;
                if (pos >= limit) {
                    break;
                }
                final byte i = data[pos];
                int n7;
                if (i >= 48 && i <= 57) {
                    n7 = i - 48;
                }
                else if (i >= 97 && i <= 102) {
                    n7 = i - 97 + 10;
                }
                else if (i >= 65 && i <= 70) {
                    n7 = i - 65 + 10;
                }
                else {
                    if (n5 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toHexString(i));
                    }
                    n6 = 1;
                    break;
                }
                if ((0xF000000000000000L & n4) != 0x0L) {
                    throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(n4).writeByte(i).readUtf8());
                }
                n4 = (n4 << 4 | (long)n7);
                ++pos;
                ++n5;
            }
            if (pos == limit) {
                this.head = head.pop();
                SegmentPool.recycle(head);
            }
            else {
                head.pos = pos;
            }
            if (n6 != 0) {
                break;
            }
            n3 = n6;
            n2 = n5;
            n = n4;
        } while (this.head != null);
        this.size -= n5;
        return n4;
    }
    
    @Override
    public int readInt() {
        if (this.size < 4L) {
            throw new IllegalStateException("size < 4: " + this.size);
        }
        final Segment head = this.head;
        final int pos = head.pos;
        final int limit = head.limit;
        if (limit - pos < 4) {
            return (this.readByte() & 0xFF) << 24 | (this.readByte() & 0xFF) << 16 | (this.readByte() & 0xFF) << 8 | (this.readByte() & 0xFF);
        }
        final byte[] data = head.data;
        final int n = pos + 1;
        final byte b = data[pos];
        final int n2 = n + 1;
        final byte b2 = data[n];
        final int n3 = n2 + 1;
        final byte b3 = data[n2];
        final int pos2 = n3 + 1;
        final int n4 = (b & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8 | (data[n3] & 0xFF);
        this.size -= 4L;
        if (pos2 == limit) {
            this.head = head.pop();
            SegmentPool.recycle(head);
            return n4;
        }
        head.pos = pos2;
        return n4;
    }
    
    @Override
    public int readIntLe() {
        return Util.reverseBytesInt(this.readInt());
    }
    
    @Override
    public long readLong() {
        if (this.size < 8L) {
            throw new IllegalStateException("size < 8: " + this.size);
        }
        final Segment head = this.head;
        final int pos = head.pos;
        final int limit = head.limit;
        if (limit - pos < 8) {
            return ((long)this.readInt() & 0xFFFFFFFFL) << 32 | ((long)this.readInt() & 0xFFFFFFFFL);
        }
        final byte[] data = head.data;
        final int n = pos + 1;
        final long n2 = data[pos];
        final int n3 = n + 1;
        final long n4 = data[n];
        final int n5 = n3 + 1;
        final long n6 = data[n3];
        final int n7 = n5 + 1;
        final long n8 = data[n5];
        final int n9 = n7 + 1;
        final long n10 = data[n7];
        final int n11 = n9 + 1;
        final long n12 = data[n9];
        final int n13 = n11 + 1;
        final long n14 = data[n11];
        final int pos2 = n13 + 1;
        final long n15 = (n2 & 0xFFL) << 56 | (n4 & 0xFFL) << 48 | (n6 & 0xFFL) << 40 | (n8 & 0xFFL) << 32 | (n10 & 0xFFL) << 24 | (n12 & 0xFFL) << 16 | (n14 & 0xFFL) << 8 | ((long)data[n13] & 0xFFL);
        this.size -= 8L;
        if (pos2 == limit) {
            this.head = head.pop();
            SegmentPool.recycle(head);
            return n15;
        }
        head.pos = pos2;
        return n15;
    }
    
    @Override
    public long readLongLe() {
        return Util.reverseBytesLong(this.readLong());
    }
    
    @Override
    public short readShort() {
        if (this.size < 2L) {
            throw new IllegalStateException("size < 2: " + this.size);
        }
        final Segment head = this.head;
        final int pos = head.pos;
        final int limit = head.limit;
        if (limit - pos < 2) {
            return (short)((this.readByte() & 0xFF) << 8 | (this.readByte() & 0xFF));
        }
        final byte[] data = head.data;
        final int n = pos + 1;
        final byte b = data[pos];
        final int pos2 = n + 1;
        final byte b2 = data[n];
        this.size -= 2L;
        if (pos2 == limit) {
            this.head = head.pop();
            SegmentPool.recycle(head);
        }
        else {
            head.pos = pos2;
        }
        return (short)((b & 0xFF) << 8 | (b2 & 0xFF));
    }
    
    @Override
    public short readShortLe() {
        return Util.reverseBytesShort(this.readShort());
    }
    
    @Override
    public String readString(final long lng, final Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0L, lng);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (lng > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + lng);
        }
        String s;
        if (lng == 0L) {
            s = "";
        }
        else {
            final Segment head = this.head;
            if (head.pos + lng > head.limit) {
                return new String(this.readByteArray(lng), charset);
            }
            final String s2 = new String(head.data, head.pos, (int)lng, charset);
            head.pos += (int)lng;
            this.size -= lng;
            s = s2;
            if (head.pos == head.limit) {
                this.head = head.pop();
                SegmentPool.recycle(head);
                return s2;
            }
        }
        return s;
    }
    
    @Override
    public String readString(final Charset charset) {
        try {
            return this.readString(this.size, charset);
        }
        catch (EOFException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    @Override
    public String readUtf8() {
        try {
            return this.readString(this.size, Util.UTF_8);
        }
        catch (EOFException detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    @Override
    public String readUtf8(final long n) throws EOFException {
        return this.readString(n, Util.UTF_8);
    }
    
    @Override
    public int readUtf8CodePoint() throws EOFException {
        if (this.size == 0L) {
            throw new EOFException();
        }
        final byte byte1 = this.getByte(0L);
        int n;
        int i;
        int n2;
        if ((byte1 & 0x80) == 0x0) {
            n = (byte1 & 0x7F);
            i = 1;
            n2 = 0;
        }
        else if ((byte1 & 0xE0) == 0xC0) {
            n = (byte1 & 0x1F);
            i = 2;
            n2 = 128;
        }
        else if ((byte1 & 0xF0) == 0xE0) {
            n = (byte1 & 0xF);
            i = 3;
            n2 = 2048;
        }
        else {
            if ((byte1 & 0xF8) != 0xF0) {
                this.skip(1L);
                return 65533;
            }
            n = (byte1 & 0x7);
            i = 4;
            n2 = 65536;
        }
        if (this.size < i) {
            throw new EOFException("size < " + i + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(byte1) + ")");
        }
        for (int j = 1; j < i; ++j) {
            final byte byte2 = this.getByte(j);
            if ((byte2 & 0xC0) != 0x80) {
                this.skip(j);
                return 65533;
            }
            n = (n << 6 | (byte2 & 0x3F));
        }
        this.skip(i);
        if (n > 1114111) {
            return 65533;
        }
        if (n >= 55296 && n <= 57343) {
            return 65533;
        }
        int n3;
        if ((n3 = n) < n2) {
            return 65533;
        }
        return n3;
    }
    
    @Nullable
    @Override
    public String readUtf8Line() throws EOFException {
        final long index = this.indexOf((byte)10);
        if (index != -1L) {
            return this.readUtf8Line(index);
        }
        if (this.size != 0L) {
            return this.readUtf8(this.size);
        }
        return null;
    }
    
    String readUtf8Line(final long n) throws EOFException {
        if (n > 0L && this.getByte(n - 1L) == 13) {
            final String utf8 = this.readUtf8(n - 1L);
            this.skip(2L);
            return utf8;
        }
        final String utf9 = this.readUtf8(n);
        this.skip(1L);
        return utf9;
    }
    
    @Override
    public String readUtf8LineStrict() throws EOFException {
        return this.readUtf8LineStrict(Long.MAX_VALUE);
    }
    
    @Override
    public String readUtf8LineStrict(final long n) throws EOFException {
        if (n < 0L) {
            throw new IllegalArgumentException("limit < 0: " + n);
        }
        long n2;
        if (n == Long.MAX_VALUE) {
            n2 = Long.MAX_VALUE;
        }
        else {
            n2 = n + 1L;
        }
        final long index = this.indexOf((byte)10, 0L, n2);
        if (index != -1L) {
            return this.readUtf8Line(index);
        }
        if (n2 < this.size() && this.getByte(n2 - 1L) == 13 && this.getByte(n2) == 10) {
            return this.readUtf8Line(n2);
        }
        final Buffer buffer = new Buffer();
        this.copyTo(buffer, 0L, Math.min(32L, this.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.size(), n) + " content=" + buffer.readByteString().hex() + '\u2026');
    }
    
    @Override
    public boolean request(final long n) {
        return this.size >= n;
    }
    
    @Override
    public void require(final long n) throws EOFException {
        if (this.size < n) {
            throw new EOFException();
        }
    }
    
    List<Integer> segmentSizes() {
        List<Integer> emptyList;
        if (this.head == null) {
            emptyList = Collections.emptyList();
        }
        else {
            final ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(this.head.limit - this.head.pos);
            Segment segment = this.head.next;
            while (true) {
                emptyList = list;
                if (segment == this.head) {
                    break;
                }
                list.add(segment.limit - segment.pos);
                segment = segment.next;
            }
        }
        return emptyList;
    }
    
    @Override
    public int select(final Options options) {
        final Segment head = this.head;
        if (head == null) {
            return options.indexOf((Object)ByteString.EMPTY);
        }
        final ByteString[] byteStrings = options.byteStrings;
        for (int i = 0; i < byteStrings.length; ++i) {
            final ByteString byteString = byteStrings[i];
            if (this.size >= byteString.size() && this.rangeEquals(head, head.pos, byteString, 0, byteString.size())) {
                try {
                    this.skip(byteString.size());
                    return i;
                }
                catch (EOFException detailMessage) {
                    throw new AssertionError((Object)detailMessage);
                }
            }
        }
        return -1;
    }
    
    int selectPrefix(final Options options) {
        final Segment head = this.head;
        final ByteString[] byteStrings = options.byteStrings;
        for (int i = 0; i < byteStrings.length; ++i) {
            final ByteString byteString = byteStrings[i];
            final int n = (int)Math.min(this.size, byteString.size());
            if (n == 0 || this.rangeEquals(head, head.pos, byteString, 0, n)) {
                return i;
            }
        }
        return -1;
    }
    
    public ByteString sha1() {
        return this.digest("SHA-1");
    }
    
    public ByteString sha256() {
        return this.digest("SHA-256");
    }
    
    public ByteString sha512() {
        return this.digest("SHA-512");
    }
    
    public long size() {
        return this.size;
    }
    
    @Override
    public void skip(long a) throws EOFException {
        while (a > 0L) {
            if (this.head == null) {
                throw new EOFException();
            }
            final int n = (int)Math.min(a, this.head.limit - this.head.pos);
            this.size -= n;
            final long n2 = a - n;
            final Segment head = this.head;
            head.pos += n;
            a = n2;
            if (this.head.pos != this.head.limit) {
                continue;
            }
            final Segment head2 = this.head;
            this.head = head2.pop();
            SegmentPool.recycle(head2);
            a = n2;
        }
    }
    
    public ByteString snapshot() {
        if (this.size > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
        }
        return this.snapshot((int)this.size);
    }
    
    public ByteString snapshot(final int n) {
        if (n == 0) {
            return ByteString.EMPTY;
        }
        return (ByteString)new SegmentedByteString(this, n);
    }
    
    public Timeout timeout() {
        return Timeout.NONE;
    }
    
    @Override
    public String toString() {
        return this.snapshot().toString();
    }
    
    Segment writableSegment(final int n) {
        if (n < 1 || n > 8192) {
            throw new IllegalArgumentException();
        }
        if (this.head != null) {
            final Segment prev = this.head.prev;
            if (prev.limit + n <= 8192) {
                final Segment head = prev;
                if (prev.owner) {
                    return head;
                }
            }
            return prev.push(SegmentPool.take());
        }
        this.head = SegmentPool.take();
        final Segment head2 = this.head;
        final Segment head3 = this.head;
        final Segment head = this.head;
        head3.prev = head;
        head2.next = head;
        return head;
    }
    
    public Buffer write(final ByteString byteString) {
        if (byteString == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        byteString.write(this);
        return this;
    }
    
    public Buffer write(final byte[] array) {
        if (array == null) {
            throw new IllegalArgumentException("source == null");
        }
        return this.write(array, 0, array.length);
    }
    
    public Buffer write(final byte[] array, int i, final int n) {
        if (array == null) {
            throw new IllegalArgumentException("source == null");
        }
        Util.checkOffsetAndCount((long)array.length, (long)i, (long)n);
        Segment writableSegment;
        int min;
        for (int n2 = i + n; i < n2; i += min, writableSegment.limit += min) {
            writableSegment = this.writableSegment(1);
            min = Math.min(n2 - i, 8192 - writableSegment.limit);
            System.arraycopy(array, i, writableSegment.data, writableSegment.limit, min);
        }
        this.size += n;
        return this;
    }
    
    public BufferedSink write(final Source source, long n) throws IOException {
        while (n > 0L) {
            final long read = source.read(this, n);
            if (read == -1L) {
                throw new EOFException();
            }
            n -= read;
        }
        return (BufferedSink)this;
    }
    
    public void write(final Buffer buffer, long n) {
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (buffer == this) {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(buffer.size, 0L, n);
        while (n > 0L) {
            if (n < buffer.head.limit - buffer.head.pos) {
                Segment prev;
                if (this.head != null) {
                    prev = this.head.prev;
                }
                else {
                    prev = null;
                }
                if (prev != null && prev.owner) {
                    final long n2 = prev.limit;
                    int pos;
                    if (prev.shared) {
                        pos = 0;
                    }
                    else {
                        pos = prev.pos;
                    }
                    if (n + n2 - pos <= 8192L) {
                        buffer.head.writeTo(prev, (int)n);
                        buffer.size -= n;
                        this.size += n;
                        break;
                    }
                }
                buffer.head = buffer.head.split((int)n);
            }
            final Segment head = buffer.head;
            final long n3 = head.limit - head.pos;
            buffer.head = head.pop();
            if (this.head == null) {
                this.head = head;
                final Segment head2 = this.head;
                final Segment head3 = this.head;
                final Segment head4 = this.head;
                head3.prev = head4;
                head2.next = head4;
            }
            else {
                this.head.prev.push(head).compact();
            }
            buffer.size -= n3;
            this.size += n3;
            n -= n3;
        }
    }
    
    public long writeAll(final Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long n = 0L;
        while (true) {
            final long read = source.read(this, 8192L);
            if (read == -1L) {
                break;
            }
            n += read;
        }
        return n;
    }
    
    public Buffer writeByte(final int n) {
        final Segment writableSegment = this.writableSegment(1);
        writableSegment.data[writableSegment.limit++] = (byte)n;
        ++this.size;
        return this;
    }
    
    public Buffer writeDecimalLong(final long n) {
        if (n == 0L) {
            return this.writeByte(48);
        }
        boolean b = false;
        long n2 = n;
        if (n < 0L) {
            n2 = -n;
            if (n2 < 0L) {
                return this.writeUtf8("-9223372036854775808");
            }
            b = true;
        }
        int n3;
        if (n2 < 100000000L) {
            if (n2 < 10000L) {
                if (n2 < 100L) {
                    if (n2 < 10L) {
                        n3 = 1;
                    }
                    else {
                        n3 = 2;
                    }
                }
                else if (n2 < 1000L) {
                    n3 = 3;
                }
                else {
                    n3 = 4;
                }
            }
            else if (n2 < 1000000L) {
                if (n2 < 100000L) {
                    n3 = 5;
                }
                else {
                    n3 = 6;
                }
            }
            else if (n2 < 10000000L) {
                n3 = 7;
            }
            else {
                n3 = 8;
            }
        }
        else if (n2 < 1000000000000L) {
            if (n2 < 10000000000L) {
                if (n2 < 1000000000L) {
                    n3 = 9;
                }
                else {
                    n3 = 10;
                }
            }
            else if (n2 < 100000000000L) {
                n3 = 11;
            }
            else {
                n3 = 12;
            }
        }
        else if (n2 < 1000000000000000L) {
            if (n2 < 10000000000000L) {
                n3 = 13;
            }
            else if (n2 < 100000000000000L) {
                n3 = 14;
            }
            else {
                n3 = 15;
            }
        }
        else if (n2 < 100000000000000000L) {
            if (n2 < 10000000000000000L) {
                n3 = 16;
            }
            else {
                n3 = 17;
            }
        }
        else if (n2 < 1000000000000000000L) {
            n3 = 18;
        }
        else {
            n3 = 19;
        }
        int n4 = n3;
        if (b) {
            n4 = n3 + 1;
        }
        final Segment writableSegment = this.writableSegment(n4);
        final byte[] data = writableSegment.data;
        int n5 = writableSegment.limit + n4;
        while (n2 != 0L) {
            final int n6 = (int)(n2 % 10L);
            --n5;
            data[n5] = Buffer.DIGITS[n6];
            n2 /= 10L;
        }
        if (b) {
            data[n5 - 1] = 45;
        }
        writableSegment.limit += n4;
        this.size += n4;
        return this;
    }
    
    public Buffer writeHexadecimalUnsignedLong(long i) {
        if (i == 0L) {
            return this.writeByte(48);
        }
        final int n = Long.numberOfTrailingZeros(Long.highestOneBit(i)) / 4 + 1;
        final Segment writableSegment = this.writableSegment(n);
        final byte[] data = writableSegment.data;
        for (int j = writableSegment.limit + n - 1; j >= writableSegment.limit; --j) {
            data[j] = Buffer.DIGITS[(int)(0xFL & i)];
            i >>>= 4;
        }
        writableSegment.limit += n;
        this.size += n;
        return this;
    }
    
    public Buffer writeInt(final int n) {
        final Segment writableSegment = this.writableSegment(4);
        final byte[] data = writableSegment.data;
        final int limit = writableSegment.limit;
        final int n2 = limit + 1;
        data[limit] = (byte)(n >>> 24 & 0xFF);
        final int n3 = n2 + 1;
        data[n2] = (byte)(n >>> 16 & 0xFF);
        final int n4 = n3 + 1;
        data[n3] = (byte)(n >>> 8 & 0xFF);
        data[n4] = (byte)(n & 0xFF);
        writableSegment.limit = n4 + 1;
        this.size += 4L;
        return this;
    }
    
    public Buffer writeIntLe(final int n) {
        return this.writeInt(Util.reverseBytesInt(n));
    }
    
    public Buffer writeLong(final long n) {
        final Segment writableSegment = this.writableSegment(8);
        final byte[] data = writableSegment.data;
        final int limit = writableSegment.limit;
        final int n2 = limit + 1;
        data[limit] = (byte)(n >>> 56 & 0xFFL);
        final int n3 = n2 + 1;
        data[n2] = (byte)(n >>> 48 & 0xFFL);
        final int n4 = n3 + 1;
        data[n3] = (byte)(n >>> 40 & 0xFFL);
        final int n5 = n4 + 1;
        data[n4] = (byte)(n >>> 32 & 0xFFL);
        final int n6 = n5 + 1;
        data[n5] = (byte)(n >>> 24 & 0xFFL);
        final int n7 = n6 + 1;
        data[n6] = (byte)(n >>> 16 & 0xFFL);
        final int n8 = n7 + 1;
        data[n7] = (byte)(n >>> 8 & 0xFFL);
        data[n8] = (byte)(n & 0xFFL);
        writableSegment.limit = n8 + 1;
        this.size += 8L;
        return this;
    }
    
    public Buffer writeLongLe(final long n) {
        return this.writeLong(Util.reverseBytesLong(n));
    }
    
    public Buffer writeShort(final int n) {
        final Segment writableSegment = this.writableSegment(2);
        final byte[] data = writableSegment.data;
        final int limit = writableSegment.limit;
        final int n2 = limit + 1;
        data[limit] = (byte)(n >>> 8 & 0xFF);
        data[n2] = (byte)(n & 0xFF);
        writableSegment.limit = n2 + 1;
        this.size += 2L;
        return this;
    }
    
    public Buffer writeShortLe(final int n) {
        return this.writeShort(Util.reverseBytesShort((short)n));
    }
    
    public Buffer writeString(final String s, final int beginIndex, final int endIndex, final Charset charset) {
        if (s == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (beginIndex < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + beginIndex);
        }
        if (endIndex < beginIndex) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + endIndex + " < " + beginIndex);
        }
        if (endIndex > s.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + endIndex + " > " + s.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(Util.UTF_8)) {
            return this.writeUtf8(s, beginIndex, endIndex);
        }
        final byte[] bytes = s.substring(beginIndex, endIndex).getBytes(charset);
        return this.write(bytes, 0, bytes.length);
    }
    
    public Buffer writeString(final String s, final Charset charset) {
        return this.writeString(s, 0, s.length(), charset);
    }
    
    public Buffer writeTo(final OutputStream outputStream) throws IOException {
        return this.writeTo(outputStream, this.size);
    }
    
    public Buffer writeTo(final OutputStream outputStream, long a) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        Util.checkOffsetAndCount(this.size, 0L, a);
        Segment head = this.head;
        while (true) {
            final Segment segment = head;
            if (a <= 0L) {
                break;
            }
            final int len = (int)Math.min(a, segment.limit - segment.pos);
            outputStream.write(segment.data, segment.pos, len);
            segment.pos += len;
            this.size -= len;
            final long n = a - len;
            head = segment;
            a = n;
            if (segment.pos != segment.limit) {
                continue;
            }
            head = segment.pop();
            this.head = head;
            SegmentPool.recycle(segment);
            a = n;
        }
        return this;
    }
    
    public Buffer writeUtf8(final String s) {
        return this.writeUtf8(s, 0, s.length());
    }
    
    public Buffer writeUtf8(final String s, int i, final int a) {
        if (s == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (a < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + a + " < " + i);
        }
        if (a > s.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + a + " > " + s.length());
        }
        while (i < a) {
            final char char1 = s.charAt(i);
            if (char1 < '\u0080') {
                final Segment writableSegment = this.writableSegment(1);
                final byte[] data = writableSegment.data;
                final int n = writableSegment.limit - i;
                final int min = Math.min(a, 8192 - n);
                data[n + i] = (byte)char1;
                char char2;
                for (++i; i < min; ++i) {
                    char2 = s.charAt(i);
                    if (char2 >= '\u0080') {
                        break;
                    }
                    data[n + i] = (byte)char2;
                }
                final int n2 = i + n - writableSegment.limit;
                writableSegment.limit += n2;
                this.size += n2;
            }
            else if (char1 < '\u0800') {
                this.writeByte(char1 >> 6 | 0xC0);
                this.writeByte((char1 & '?') | 0x80);
                ++i;
            }
            else if (char1 < '\ud800' || char1 > '\udfff') {
                this.writeByte(char1 >> 12 | 0xE0);
                this.writeByte((char1 >> 6 & 0x3F) | 0x80);
                this.writeByte((char1 & '?') | 0x80);
                ++i;
            }
            else {
                char char3;
                if (i + 1 < a) {
                    char3 = s.charAt(i + 1);
                }
                else {
                    char3 = '\0';
                }
                if (char1 > '\udbff' || char3 < '\udc00' || char3 > '\udfff') {
                    this.writeByte(63);
                    ++i;
                }
                else {
                    final int n3 = 65536 + ((0xFFFF27FF & char1) << 10 | (0xFFFF23FF & char3));
                    this.writeByte(n3 >> 18 | 0xF0);
                    this.writeByte((n3 >> 12 & 0x3F) | 0x80);
                    this.writeByte((n3 >> 6 & 0x3F) | 0x80);
                    this.writeByte((n3 & 0x3F) | 0x80);
                    i += 2;
                }
            }
        }
        return this;
    }
    
    public Buffer writeUtf8CodePoint(final int i) {
        if (i < 128) {
            this.writeByte(i);
            return this;
        }
        if (i < 2048) {
            this.writeByte(i >> 6 | 0xC0);
            this.writeByte((i & 0x3F) | 0x80);
            return this;
        }
        if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                this.writeByte(63);
                return this;
            }
            this.writeByte(i >> 12 | 0xE0);
            this.writeByte((i >> 6 & 0x3F) | 0x80);
            this.writeByte((i & 0x3F) | 0x80);
            return this;
        }
        else {
            if (i <= 1114111) {
                this.writeByte(i >> 18 | 0xF0);
                this.writeByte((i >> 12 & 0x3F) | 0x80);
                this.writeByte((i >> 6 & 0x3F) | 0x80);
                this.writeByte((i & 0x3F) | 0x80);
                return this;
            }
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
    }
}
