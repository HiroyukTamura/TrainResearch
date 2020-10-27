package p042j;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Typography;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;
import p042j.p118B.C2059a;
import p042j.p118B.C2060b;
import p043jp.reifrontier.gym.RFGDef;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010p\u001a\u00020\u001dJ\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\u0015\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020/H\u0000¢\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020FH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020GH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001dH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020z2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010{\u001a\u00020\f2\u0006\u0010x\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0010\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0010\u0010\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0011\u0010\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001fH\u0016J$\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u001f2\u0007\u0010\u0001\u001a\u00020/2\u0007\u0010\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0001"}, mo21739d2 = {"Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: j.f */
public final class C2068f implements C2072h, C2071g, Cloneable, ByteChannel {
    @JvmField

    /* renamed from: a */
    public C2087u f2890a;

    /* renamed from: b */
    private long f2891b;

    /* renamed from: j.f$a */
    public static final class C2069a extends InputStream {

        /* renamed from: a */
        final /* synthetic */ C2068f f2892a;

        C2069a(C2068f fVar) {
            this.f2892a = fVar;
        }

        public int available() {
            return (int) Math.min(this.f2892a.size(), (long) Integer.MAX_VALUE);
        }

        public void close() {
        }

        public int read() {
            if (this.f2892a.size() > 0) {
                return this.f2892a.readByte() & UByte.MAX_VALUE;
            }
            return -1;
        }

        public int read(byte[] bArr, int i, int i2) {
            Intrinsics.checkParameterIsNotNull(bArr, "sink");
            return this.f2892a.read(bArr, i, i2);
        }

        public String toString() {
            return this.f2892a + ".inputStream()";
        }
    }

    /* renamed from: j.f$b */
    public static final class C2070b extends OutputStream {

        /* renamed from: a */
        final /* synthetic */ C2068f f2893a;

        C2070b(C2068f fVar) {
            this.f2893a = fVar;
        }

        public void close() {
        }

        public void flush() {
        }

        public String toString() {
            return this.f2893a + ".outputStream()";
        }

        public void write(int i) {
            this.f2893a.writeByte(i);
        }

        public void write(byte[] bArr, int i, int i2) {
            Intrinsics.checkParameterIsNotNull(bArr, "data");
            this.f2893a.write(bArr, i, i2);
        }
    }

    /* renamed from: a */
    public long mo29135a(C1016z zVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(zVar, FirebaseAnalytics.Param.SOURCE);
        long j = 0;
        while (true) {
            long read = zVar.read(this, (long) 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    /* renamed from: a */
    public final C2068f mo29136a(C2068f fVar, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(fVar, "out");
        C1532a.m2135a(this.f2891b, j, j2);
        if (j2 != 0) {
            fVar.f2891b += j2;
            C2087u uVar = this.f2890a;
            while (true) {
                if (uVar == null) {
                    Intrinsics.throwNpe();
                }
                int i = uVar.f2926c;
                int i2 = uVar.f2925b;
                if (j < ((long) (i - i2))) {
                    break;
                }
                j -= (long) (i - i2);
                uVar = uVar.f2929f;
            }
            while (j2 > 0) {
                if (uVar == null) {
                    Intrinsics.throwNpe();
                }
                C2087u b = uVar.mo29251b();
                int i3 = b.f2925b + ((int) j);
                b.f2925b = i3;
                b.f2926c = Math.min(i3 + ((int) j2), b.f2926c);
                C2087u uVar2 = fVar.f2890a;
                if (uVar2 == null) {
                    b.f2930g = b;
                    b.f2929f = b;
                    fVar.f2890a = b;
                } else {
                    if (uVar2 == null) {
                        Intrinsics.throwNpe();
                    }
                    C2087u uVar3 = uVar2.f2930g;
                    if (uVar3 == null) {
                        Intrinsics.throwNpe();
                    }
                    uVar3.mo29249a(b);
                }
                j2 -= (long) (b.f2926c - b.f2925b);
                uVar = uVar.f2929f;
                j = 0;
            }
        }
        return this;
    }

    /* renamed from: a */
    public C2068f mo29138a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "string");
        mo29139a(str, 0, str.length());
        return this;
    }

    /* renamed from: a */
    public C2068f mo29140a(String str, int i, int i2, Charset charset) {
        Intrinsics.checkParameterIsNotNull(str, "string");
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 > str.length()) {
                    z = false;
                }
                if (!z) {
                    StringBuilder b = C0681a.m338b("endIndex > string.length: ", i2, " > ");
                    b.append(str.length());
                    throw new IllegalArgumentException(b.toString().toString());
                } else if (Intrinsics.areEqual((Object) charset, (Object) Charsets.UTF_8)) {
                    mo29139a(str, i, i2);
                    return this;
                } else {
                    String substring = str.substring(i, i2);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    byte[] bytes = substring.getBytes(charset);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    write(bytes, 0, bytes.length);
                    return this;
                }
            } else {
                throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
            }
        } else {
            throw new IllegalArgumentException(C0681a.m316a("beginIndex < 0: ", i).toString());
        }
    }

    /* renamed from: a */
    public String mo29143a(long j, Charset charset) throws EOFException {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(C0681a.m318a("byteCount: ", j).toString());
        } else if (this.f2891b < j) {
            throw new EOFException();
        } else if (j == 0) {
            return "";
        } else {
            C2087u uVar = this.f2890a;
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
            int i = uVar.f2925b;
            if (((long) i) + j > ((long) uVar.f2926c)) {
                return new String(mo29156e(j), charset);
            }
            int i2 = (int) j;
            String str = new String(uVar.f2924a, i, i2, charset);
            int i3 = uVar.f2925b + i2;
            uVar.f2925b = i3;
            this.f2891b -= j;
            if (i3 == uVar.f2926c) {
                this.f2890a = uVar.mo29248a();
                C2088v.f2933c.mo29253a(uVar);
            }
            return str;
        }
    }

    /* renamed from: a */
    public String mo29144a(Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        return mo29143a(this.f2891b, charset);
    }

    /* renamed from: b */
    public long mo29146b(C2073i iVar) {
        long j;
        int i;
        Intrinsics.checkParameterIsNotNull(iVar, "targetBytes");
        Intrinsics.checkParameterIsNotNull(iVar, "targetBytes");
        C2087u uVar = this.f2890a;
        if (uVar == null) {
            return -1;
        }
        long j2 = this.f2891b;
        long j3 = 0;
        if (j2 - 0 < 0) {
            while (j2 > 0) {
                uVar = uVar.f2930g;
                if (uVar == null) {
                    Intrinsics.throwNpe();
                }
                j2 -= (long) (uVar.f2926c - uVar.f2925b);
            }
            if (iVar.mo29212d() == 2) {
                byte a = iVar.mo29201a(0);
                byte a2 = iVar.mo29201a(1);
                while (j < this.f2891b) {
                    byte[] bArr = uVar.f2924a;
                    i = (int) ((((long) uVar.f2925b) + j3) - j);
                    int i2 = uVar.f2926c;
                    while (i < i2) {
                        byte b = bArr[i];
                        if (!(b == a || b == a2)) {
                            i++;
                        }
                    }
                    j3 = ((long) (uVar.f2926c - uVar.f2925b)) + j;
                    uVar = uVar.f2929f;
                    if (uVar == null) {
                        Intrinsics.throwNpe();
                    }
                    j2 = j3;
                }
                return -1;
            }
            byte[] f = iVar.mo29215f();
            while (j < this.f2891b) {
                byte[] bArr2 = uVar.f2924a;
                int i3 = (int) ((((long) uVar.f2925b) + j3) - j);
                int i4 = uVar.f2926c;
                while (i < i4) {
                    byte b2 = bArr2[i];
                    int length = f.length;
                    int i5 = 0;
                    while (i5 < length) {
                        if (b2 != f[i5]) {
                            i5++;
                        }
                    }
                    i3 = i + 1;
                }
                j3 = ((long) (uVar.f2926c - uVar.f2925b)) + j;
                uVar = uVar.f2929f;
                if (uVar == null) {
                    Intrinsics.throwNpe();
                }
                j2 = j3;
            }
            return -1;
        }
        j = 0;
        while (true) {
            long j4 = ((long) (uVar.f2926c - uVar.f2925b)) + j;
            if (j4 > 0) {
                break;
            }
            uVar = uVar.f2929f;
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
            j = j4;
        }
        if (iVar.mo29212d() == 2) {
            byte a3 = iVar.mo29201a(0);
            byte a4 = iVar.mo29201a(1);
            while (j < this.f2891b) {
                byte[] bArr3 = uVar.f2924a;
                int i6 = (int) ((((long) uVar.f2925b) + j3) - j);
                int i7 = uVar.f2926c;
                while (i < i7) {
                    byte b3 = bArr3[i];
                    if (!(b3 == a3 || b3 == a4)) {
                        i6 = i + 1;
                    }
                }
                j3 = ((long) (uVar.f2926c - uVar.f2925b)) + j;
                uVar = uVar.f2929f;
                if (uVar == null) {
                    Intrinsics.throwNpe();
                }
                j = j3;
            }
            return -1;
        }
        byte[] f2 = iVar.mo29215f();
        while (j < this.f2891b) {
            byte[] bArr4 = uVar.f2924a;
            int i8 = (int) ((((long) uVar.f2925b) + j3) - j);
            int i9 = uVar.f2926c;
            while (i < i9) {
                byte b4 = bArr4[i];
                int length2 = f2.length;
                int i10 = 0;
                while (i10 < length2) {
                    if (b4 != f2[i10]) {
                        i10++;
                    }
                }
                i8 = i + 1;
            }
            j3 = ((long) (uVar.f2926c - uVar.f2925b)) + j;
            uVar = uVar.f2929f;
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
            j = j3;
        }
        return -1;
        return ((long) (i - uVar.f2925b)) + j;
    }

    /* renamed from: b */
    public final C2087u mo29147b(int i) {
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (z) {
            C2087u uVar = this.f2890a;
            if (uVar == null) {
                C2087u a = C2088v.f2933c.mo29252a();
                this.f2890a = a;
                a.f2930g = a;
                a.f2929f = a;
                return a;
            }
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
            C2087u uVar2 = uVar.f2930g;
            if (uVar2 == null) {
                Intrinsics.throwNpe();
            }
            if (uVar2.f2926c + i <= 8192 && uVar2.f2928e) {
                return uVar2;
            }
            C2087u a2 = C2088v.f2933c.mo29252a();
            uVar2.mo29249a(a2);
            return a2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    /* renamed from: c */
    public C2068f mo29151c(long j) {
        if (j == 0) {
            writeByte(48);
        } else {
            long j2 = (j >>> 1) | j;
            long j3 = j2 | (j2 >>> 2);
            long j4 = j3 | (j3 >>> 4);
            long j5 = j4 | (j4 >>> 8);
            long j6 = j5 | (j5 >>> 16);
            long j7 = j6 | (j6 >>> 32);
            long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
            long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
            long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
            long j11 = j10 + (j10 >>> 8);
            long j12 = j11 + (j11 >>> 16);
            int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
            C2087u b = mo29147b(i);
            byte[] bArr = b.f2924a;
            int i2 = b.f2926c;
            for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
                bArr[i3] = C2059a.m3455a()[(int) (15 & j)];
                j >>>= 4;
            }
            b.f2926c += i;
            this.f2891b += (long) i;
        }
        return this;
    }

    /* renamed from: c */
    public boolean mo29152c() {
        return this.f2891b == 0;
    }

    public C2068f clone() {
        C2068f fVar = new C2068f();
        if (this.f2891b != 0) {
            C2087u uVar = this.f2890a;
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
            C2087u b = uVar.mo29251b();
            fVar.f2890a = b;
            b.f2930g = b;
            b.f2929f = b;
            for (C2087u uVar2 = uVar.f2929f; uVar2 != uVar; uVar2 = uVar2.f2929f) {
                C2087u uVar3 = b.f2930g;
                if (uVar3 == null) {
                    Intrinsics.throwNpe();
                }
                if (uVar2 == null) {
                    Intrinsics.throwNpe();
                }
                uVar3.mo29249a(uVar2.mo29251b());
            }
            fVar.f2891b = this.f2891b;
        }
        return fVar;
    }

    public void close() {
    }

    /* renamed from: d */
    public final void mo29154d() {
        skip(this.f2891b);
    }

    /* renamed from: d */
    public boolean mo29155d(long j) {
        return this.f2891b >= j;
    }

    /* renamed from: e */
    public byte[] mo29156e(long j) throws EOFException {
        int i = 0;
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(C0681a.m318a("byteCount: ", j).toString());
        } else if (this.f2891b >= j) {
            int i2 = (int) j;
            byte[] bArr = new byte[i2];
            Intrinsics.checkParameterIsNotNull(bArr, "sink");
            while (i < i2) {
                int read = read(bArr, i, i2 - i);
                if (read != -1) {
                    i += read;
                } else {
                    throw new EOFException();
                }
            }
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    /* JADX WARNING: type inference failed for: r21v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = 0
            r3 = 1
            if (r0 != r1) goto L_0x000b
        L_0x0008:
            r2 = 1
            goto L_0x0080
        L_0x000b:
            boolean r4 = r1 instanceof p042j.C2068f
            if (r4 != 0) goto L_0x0011
            goto L_0x0080
        L_0x0011:
            long r4 = r0.f2891b
            j.f r1 = (p042j.C2068f) r1
            long r6 = r1.f2891b
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x001c
            goto L_0x0080
        L_0x001c:
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0023
            goto L_0x0008
        L_0x0023:
            j.u r4 = r0.f2890a
            if (r4 != 0) goto L_0x002a
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x002a:
            j.u r1 = r1.f2890a
            if (r1 != 0) goto L_0x0031
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0031:
            int r5 = r4.f2925b
            int r8 = r1.f2925b
            r9 = r6
        L_0x0036:
            long r11 = r0.f2891b
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0008
            int r11 = r4.f2926c
            int r11 = r11 - r5
            int r12 = r1.f2926c
            int r12 = r12 - r8
            int r11 = java.lang.Math.min(r11, r12)
            long r11 = (long) r11
            r13 = r6
        L_0x0048:
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 >= 0) goto L_0x0064
            byte[] r15 = r4.f2924a
            int r16 = r5 + 1
            byte r5 = r15[r5]
            byte[] r15 = r1.f2924a
            int r17 = r8 + 1
            byte r8 = r15[r8]
            if (r5 == r8) goto L_0x005b
            goto L_0x0080
        L_0x005b:
            r18 = 1
            long r13 = r13 + r18
            r5 = r16
            r8 = r17
            goto L_0x0048
        L_0x0064:
            int r13 = r4.f2926c
            if (r5 != r13) goto L_0x0071
            j.u r4 = r4.f2929f
            if (r4 != 0) goto L_0x006f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x006f:
            int r5 = r4.f2925b
        L_0x0071:
            int r13 = r1.f2926c
            if (r8 != r13) goto L_0x007e
            j.u r1 = r1.f2929f
            if (r1 != 0) goto L_0x007c
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x007c:
            int r8 = r1.f2925b
        L_0x007e:
            long r9 = r9 + r11
            goto L_0x0036
        L_0x0080:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p042j.C2068f.equals(java.lang.Object):boolean");
    }

    /* renamed from: f */
    public C2071g mo29158f() {
        return this;
    }

    /* renamed from: f */
    public void mo29159f(long j) throws EOFException {
        if (this.f2891b < j) {
            throw new EOFException();
        }
    }

    public void flush() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        if (r6 != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        r3 = p009e.p010a.p011a.p012a.C0681a.m330a("Number too large: ");
        r3.append(r1.mo29175o());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        throw new java.lang.NumberFormatException(r3.toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0097 A[EDGE_INSN: B:51:0x0097->B:33:0x0097 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0013  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e  */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo29160g() throws java.io.EOFException {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.f2891b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b8
            r1 = -7
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x000f:
            j.u r8 = r0.f2890a
            if (r8 != 0) goto L_0x0016
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0016:
            byte[] r9 = r8.f2924a
            int r10 = r8.f2925b
            int r11 = r8.f2926c
        L_0x001c:
            if (r10 >= r11) goto L_0x0097
            byte r12 = r9[r10]
            r13 = 48
            byte r13 = (byte) r13
            if (r12 < r13) goto L_0x006c
            r14 = 57
            byte r14 = (byte) r14
            if (r12 > r14) goto L_0x006c
            int r13 = r13 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x0045
            int r16 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r16 != 0) goto L_0x003e
            long r14 = (long) r13
            int r16 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r16 >= 0) goto L_0x003e
            goto L_0x0045
        L_0x003e:
            r14 = 10
            long r3 = r3 * r14
            long r12 = (long) r13
            long r3 = r3 + r12
            goto L_0x0077
        L_0x0045:
            j.f r1 = new j.f
            r1.<init>()
            r1.mo29161g((long) r3)
            r1.writeByte((int) r12)
            if (r6 != 0) goto L_0x0055
            r1.readByte()
        L_0x0055:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.String r3 = "Number too large: "
            java.lang.StringBuilder r3 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r3)
            java.lang.String r1 = r1.mo29175o()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006c:
            r13 = 45
            byte r13 = (byte) r13
            if (r12 != r13) goto L_0x007c
            if (r5 != 0) goto L_0x007c
            r12 = 1
            long r1 = r1 - r12
            r6 = 1
        L_0x0077:
            int r10 = r10 + 1
            int r5 = r5 + 1
            goto L_0x001c
        L_0x007c:
            if (r5 == 0) goto L_0x0080
            r7 = 1
            goto L_0x0097
        L_0x0080:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r2 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r2)
            java.lang.String r3 = p009e.p028d.p030b.p054b.C1532a.m2128a((byte) r12)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0097:
            if (r10 != r11) goto L_0x00a5
            j.u r9 = r8.mo29248a()
            r0.f2890a = r9
            j.v r9 = p042j.C2088v.f2933c
            r9.mo29253a(r8)
            goto L_0x00a7
        L_0x00a5:
            r8.f2925b = r10
        L_0x00a7:
            if (r7 != 0) goto L_0x00ad
            j.u r8 = r0.f2890a
            if (r8 != 0) goto L_0x000f
        L_0x00ad:
            long r1 = r0.f2891b
            long r7 = (long) r5
            long r1 = r1 - r7
            r0.f2891b = r1
            if (r6 == 0) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            long r3 = -r3
        L_0x00b7:
            return r3
        L_0x00b8:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            goto L_0x00bf
        L_0x00be:
            throw r1
        L_0x00bf:
            goto L_0x00be
        */
        throw new UnsupportedOperationException("Method not decompiled: p042j.C2068f.mo29160g():long");
    }

    public C2068f getBuffer() {
        return this;
    }

    /* renamed from: h */
    public final long mo29164h() {
        long j = this.f2891b;
        if (j == 0) {
            return 0;
        }
        C2087u uVar = this.f2890a;
        if (uVar == null) {
            Intrinsics.throwNpe();
        }
        C2087u uVar2 = uVar.f2930g;
        if (uVar2 == null) {
            Intrinsics.throwNpe();
        }
        int i = uVar2.f2926c;
        if (i < 8192 && uVar2.f2928e) {
            j -= (long) (i - uVar2.f2925b);
        }
        return j;
    }

    public int hashCode() {
        C2087u uVar = this.f2890a;
        if (uVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = uVar.f2926c;
            for (int i3 = uVar.f2925b; i3 < i2; i3++) {
                i = (i * 31) + uVar.f2924a[i3];
            }
            uVar = uVar.f2929f;
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
        } while (uVar != this.f2890a);
        return i;
    }

    /* renamed from: i */
    public OutputStream mo29166i() {
        return new C2070b(this);
    }

    /* renamed from: i */
    public String mo29167i(long j) throws EOFException {
        return mo29143a(j, Charsets.UTF_8);
    }

    public boolean isOpen() {
        return true;
    }

    /* renamed from: j */
    public C2073i mo29169j() {
        return mo29142a(this.f2891b);
    }

    /* renamed from: j */
    public final void mo29170j(long j) {
        this.f2891b = j;
    }

    /* renamed from: k */
    public String mo29171k() throws EOFException {
        return mo29148b((long) LongCompanionObject.MAX_VALUE);
    }

    /* renamed from: l */
    public short mo29172l() throws EOFException {
        short readShort = readShort() & UShort.MAX_VALUE;
        return (short) (((readShort & 255) << 8) | ((65280 & readShort) >>> 8));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008f, code lost:
        if (r8 != r9) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0091, code lost:
        r15.f2890a = r6.mo29248a();
        p042j.C2088v.f2933c.mo29253a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        r6.f2925b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009f, code lost:
        if (r1 != false) goto L_0x00a5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0078 A[SYNTHETIC] */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo29173m() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.f2891b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00ac
            r0 = 0
            r1 = 0
            r4 = r2
        L_0x000b:
            j.u r6 = r15.f2890a
            if (r6 != 0) goto L_0x0012
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0012:
            byte[] r7 = r6.f2924a
            int r8 = r6.f2925b
            int r9 = r6.f2926c
        L_0x0018:
            if (r8 >= r9) goto L_0x008f
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0029
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0029
            int r11 = r10 - r11
            goto L_0x0042
        L_0x0029:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0034
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0034
            goto L_0x003e
        L_0x0034:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0074
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0074
        L_0x003e:
            int r11 = r10 - r11
            int r11 = r11 + 10
        L_0x0042:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x0052
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x0018
        L_0x0052:
            j.f r0 = new j.f
            r0.<init>()
            r0.mo29151c((long) r4)
            r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.StringBuilder r2 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r2)
            java.lang.String r0 = r0.mo29175o()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0074:
            if (r0 == 0) goto L_0x0078
            r1 = 1
            goto L_0x008f
        L_0x0078:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r1 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r1)
            java.lang.String r2 = p009e.p028d.p030b.p054b.C1532a.m2128a((byte) r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008f:
            if (r8 != r9) goto L_0x009d
            j.u r7 = r6.mo29248a()
            r15.f2890a = r7
            j.v r7 = p042j.C2088v.f2933c
            r7.mo29253a(r6)
            goto L_0x009f
        L_0x009d:
            r6.f2925b = r8
        L_0x009f:
            if (r1 != 0) goto L_0x00a5
            j.u r6 = r15.f2890a
            if (r6 != 0) goto L_0x000b
        L_0x00a5:
            long r1 = r15.f2891b
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.f2891b = r1
            return r4
        L_0x00ac:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            goto L_0x00b3
        L_0x00b2:
            throw r0
        L_0x00b3:
            goto L_0x00b2
        */
        throw new UnsupportedOperationException("Method not decompiled: p042j.C2068f.mo29173m():long");
    }

    /* renamed from: n */
    public InputStream mo29174n() {
        return new C2069a(this);
    }

    /* renamed from: o */
    public String mo29175o() {
        return mo29143a(this.f2891b, Charsets.UTF_8);
    }

    /* renamed from: p */
    public int mo29176p() throws EOFException {
        byte b;
        int i;
        byte b2;
        if (this.f2891b != 0) {
            byte h = mo29163h(0);
            int i2 = 1;
            if ((h & ByteCompanionObject.MIN_VALUE) == 0) {
                b2 = h & ByteCompanionObject.MAX_VALUE;
                i = 1;
                b = 0;
            } else if ((h & 224) == 192) {
                b2 = h & 31;
                i = 2;
                b = ByteCompanionObject.MIN_VALUE;
            } else if ((h & 240) == 224) {
                b2 = h & 15;
                i = 3;
                b = 2048;
            } else if ((h & 248) == 240) {
                b2 = h & 7;
                i = 4;
                b = 65536;
            } else {
                skip(1);
                return 65533;
            }
            long j = (long) i;
            if (this.f2891b >= j) {
                while (i2 < i) {
                    long j2 = (long) i2;
                    byte h2 = mo29163h(j2);
                    if ((h2 & 192) == 128) {
                        b2 = (b2 << 6) | (h2 & 63);
                        i2++;
                    } else {
                        skip(j2);
                        return 65533;
                    }
                }
                skip(j);
                if (b2 > 1114111) {
                    return 65533;
                }
                if ((55296 <= b2 && 57343 >= b2) || b2 < b) {
                    return 65533;
                }
                return b2;
            }
            StringBuilder b3 = C0681a.m338b("size < ", i, ": ");
            b3.append(this.f2891b);
            b3.append(" (to read code point prefixed 0x");
            b3.append(C1532a.m2128a(h));
            b3.append(')');
            throw new EOFException(b3.toString());
        }
        throw new EOFException();
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkParameterIsNotNull(byteBuffer, "sink");
        C2087u uVar = this.f2890a;
        if (uVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), uVar.f2926c - uVar.f2925b);
        byteBuffer.put(uVar.f2924a, uVar.f2925b, min);
        int i = uVar.f2925b + min;
        uVar.f2925b = i;
        this.f2891b -= (long) min;
        if (i == uVar.f2926c) {
            this.f2890a = uVar.mo29248a();
            C2088v.f2933c.mo29253a(uVar);
        }
        return min;
    }

    public int read(byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, "sink");
        C1532a.m2135a((long) bArr.length, (long) i, (long) i2);
        C2087u uVar = this.f2890a;
        if (uVar == null) {
            return -1;
        }
        int min = Math.min(i2, uVar.f2926c - uVar.f2925b);
        byte[] bArr2 = uVar.f2924a;
        int i3 = uVar.f2925b;
        byte[] unused = ArraysKt___ArraysJvmKt.copyInto(bArr2, bArr, i, i3, i3 + min);
        int i4 = uVar.f2925b + min;
        uVar.f2925b = i4;
        this.f2891b -= (long) min;
        if (i4 != uVar.f2926c) {
            return min;
        }
        this.f2890a = uVar.mo29248a();
        C2088v.f2933c.mo29253a(uVar);
        return min;
    }

    public byte readByte() throws EOFException {
        if (this.f2891b != 0) {
            C2087u uVar = this.f2890a;
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
            int i = uVar.f2925b;
            int i2 = uVar.f2926c;
            int i3 = i + 1;
            byte b = uVar.f2924a[i];
            this.f2891b--;
            if (i3 == i2) {
                this.f2890a = uVar.mo29248a();
                C2088v.f2933c.mo29253a(uVar);
            } else {
                uVar.f2925b = i3;
            }
            return b;
        }
        throw new EOFException();
    }

    public int readInt() throws EOFException {
        if (this.f2891b >= 4) {
            C2087u uVar = this.f2890a;
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
            int i = uVar.f2925b;
            int i2 = uVar.f2926c;
            if (((long) (i2 - i)) < 4) {
                return ((readByte() & UByte.MAX_VALUE) << 24) | ((readByte() & UByte.MAX_VALUE) << 16) | ((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE);
            }
            byte[] bArr = uVar.f2924a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i3] & UByte.MAX_VALUE) << 16);
            int i5 = i4 + 1;
            byte b2 = b | ((bArr[i4] & UByte.MAX_VALUE) << 8);
            int i6 = i5 + 1;
            byte b3 = b2 | (bArr[i5] & UByte.MAX_VALUE);
            this.f2891b -= 4;
            if (i6 == i2) {
                this.f2890a = uVar.mo29248a();
                C2088v.f2933c.mo29253a(uVar);
            } else {
                uVar.f2925b = i6;
            }
            return b3;
        }
        throw new EOFException();
    }

    public short readShort() throws EOFException {
        if (this.f2891b >= 2) {
            C2087u uVar = this.f2890a;
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
            int i = uVar.f2925b;
            int i2 = uVar.f2926c;
            if (i2 - i < 2) {
                return (short) (((readByte() & UByte.MAX_VALUE) << 8) | (readByte() & UByte.MAX_VALUE));
            }
            byte[] bArr = uVar.f2924a;
            int i3 = i + 1;
            int i4 = i3 + 1;
            byte b = ((bArr[i] & UByte.MAX_VALUE) << 8) | (bArr[i3] & UByte.MAX_VALUE);
            this.f2891b -= 2;
            if (i4 == i2) {
                this.f2890a = uVar.mo29248a();
                C2088v.f2933c.mo29253a(uVar);
            } else {
                uVar.f2925b = i4;
            }
            return (short) b;
        }
        throw new EOFException();
    }

    @JvmName(name = "size")
    public final long size() {
        return this.f2891b;
    }

    public void skip(long j) throws EOFException {
        while (j > 0) {
            C2087u uVar = this.f2890a;
            if (uVar != null) {
                int min = (int) Math.min(j, (long) (uVar.f2926c - uVar.f2925b));
                long j2 = (long) min;
                this.f2891b -= j2;
                j -= j2;
                int i = uVar.f2925b + min;
                uVar.f2925b = i;
                if (i == uVar.f2926c) {
                    this.f2890a = uVar.mo29248a();
                    C2088v.f2933c.mo29253a(uVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public C2057A timeout() {
        return C2057A.f2872d;
    }

    public String toString() {
        if (this.f2891b <= ((long) Integer.MAX_VALUE)) {
            return mo29141a((int) this.f2891b).toString();
        }
        StringBuilder a = C0681a.m330a("size > Int.MAX_VALUE: ");
        a.append(this.f2891b);
        throw new IllegalStateException(a.toString().toString());
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkParameterIsNotNull(byteBuffer, FirebaseAnalytics.Param.SOURCE);
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            C2087u b = mo29147b(1);
            int min = Math.min(i, 8192 - b.f2926c);
            byteBuffer.get(b.f2924a, b.f2926c, min);
            i -= min;
            b.f2926c += min;
        }
        this.f2891b += (long) remaining;
        return remaining;
    }

    public C2068f write(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, FirebaseAnalytics.Param.SOURCE);
        write(bArr, 0, bArr.length);
        return this;
    }

    public C2068f write(byte[] bArr, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(bArr, FirebaseAnalytics.Param.SOURCE);
        long j = (long) i2;
        C1532a.m2135a((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            C2087u b = mo29147b(1);
            int min = Math.min(i3 - i, 8192 - b.f2926c);
            int i4 = i + min;
            byte[] unused = ArraysKt___ArraysJvmKt.copyInto(bArr, b.f2924a, b.f2926c, i, i4);
            b.f2926c += min;
            i = i4;
        }
        this.f2891b += j;
        return this;
    }

    public C2068f writeByte(int i) {
        C2087u b = mo29147b(1);
        byte[] bArr = b.f2924a;
        int i2 = b.f2926c;
        b.f2926c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f2891b++;
        return this;
    }

    public C2068f writeInt(int i) {
        C2087u b = mo29147b(4);
        byte[] bArr = b.f2924a;
        int i2 = b.f2926c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        b.f2926c = i5 + 1;
        this.f2891b += 4;
        return this;
    }

    public C2068f writeShort(int i) {
        C2087u b = mo29147b(2);
        byte[] bArr = b.f2924a;
        int i2 = b.f2926c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        b.f2926c = i3 + 1;
        this.f2891b += 2;
        return this;
    }

    /* renamed from: c */
    public C2068f mo29150c(int i) {
        long j;
        long j2;
        String str;
        if (i < 128) {
            writeByte(i);
        } else {
            if (i < 2048) {
                C2087u b = mo29147b(2);
                byte[] bArr = b.f2924a;
                int i2 = b.f2926c;
                bArr[i2] = (byte) ((i >> 6) | 192);
                bArr[i2 + 1] = (byte) ((i & 63) | 128);
                b.f2926c = i2 + 2;
                j2 = this.f2891b;
                j = 2;
            } else if (55296 <= i && 57343 >= i) {
                writeByte(63);
            } else if (i < 65536) {
                C2087u b2 = mo29147b(3);
                byte[] bArr2 = b2.f2924a;
                int i3 = b2.f2926c;
                bArr2[i3] = (byte) ((i >> 12) | 224);
                bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
                bArr2[i3 + 2] = (byte) ((i & 63) | 128);
                b2.f2926c = i3 + 3;
                j2 = this.f2891b;
                j = 3;
            } else if (i <= 1114111) {
                C2087u b3 = mo29147b(4);
                byte[] bArr3 = b3.f2924a;
                int i4 = b3.f2926c;
                bArr3[i4] = (byte) ((i >> 18) | 240);
                bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
                bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
                bArr3[i4 + 3] = (byte) ((i & 63) | 128);
                b3.f2926c = i4 + 4;
                j2 = this.f2891b;
                j = 4;
            } else {
                StringBuilder a = C0681a.m330a("Unexpected code point: 0x");
                if (i != 0) {
                    int i5 = 0;
                    char[] cArr = {C2060b.m3457a()[(i >> 28) & 15], C2060b.m3457a()[(i >> 24) & 15], C2060b.m3457a()[(i >> 20) & 15], C2060b.m3457a()[(i >> 16) & 15], C2060b.m3457a()[(i >> 12) & 15], C2060b.m3457a()[(i >> 8) & 15], C2060b.m3457a()[(i >> 4) & 15], C2060b.m3457a()[i & 15]};
                    while (i5 < 8 && cArr[i5] == '0') {
                        i5++;
                    }
                    str = new String(cArr, i5, 8 - i5);
                } else {
                    str = RFGDef.DEFAULT_GYM_ID;
                }
                a.append(str);
                throw new IllegalArgumentException(a.toString());
            }
            this.f2891b = j2 + j;
        }
        return this;
    }

    @JvmName(name = "getByte")
    /* renamed from: h */
    public final byte mo29163h(long j) {
        C1532a.m2135a(this.f2891b, j, 1);
        C2087u uVar = this.f2890a;
        if (uVar != null) {
            long j2 = this.f2891b;
            if (j2 - j < j) {
                while (j2 > j) {
                    uVar = uVar.f2930g;
                    if (uVar == null) {
                        Intrinsics.throwNpe();
                    }
                    j2 -= (long) (uVar.f2926c - uVar.f2925b);
                }
                return uVar.f2924a[(int) ((((long) uVar.f2925b) + j) - j2)];
            }
            long j3 = 0;
            while (true) {
                int i = uVar.f2926c;
                int i2 = uVar.f2925b;
                long j4 = ((long) (i - i2)) + j3;
                if (j4 > j) {
                    return uVar.f2924a[(int) ((((long) i2) + j) - j3)];
                }
                uVar = uVar.f2929f;
                if (uVar == null) {
                    Intrinsics.throwNpe();
                }
                j3 = j4;
            }
        } else {
            Intrinsics.throwNpe();
            throw null;
        }
    }

    public long read(C2068f fVar, long j) {
        Intrinsics.checkParameterIsNotNull(fVar, "sink");
        if (j >= 0) {
            long j2 = this.f2891b;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            fVar.mo27647a(this, j);
            return j;
        }
        throw new IllegalArgumentException(C0681a.m318a("byteCount < 0: ", j).toString());
    }

    /* renamed from: a */
    public long mo29133a(byte b, long j, long j2) {
        C2087u uVar;
        long j3 = 0;
        if (0 <= j && j2 >= j) {
            long j4 = this.f2891b;
            if (j2 > j4) {
                j2 = j4;
            }
            if (!(j == j2 || (uVar = this.f2890a) == null)) {
                long j5 = this.f2891b;
                if (j5 - j < j) {
                    while (j5 > j) {
                        uVar = uVar.f2930g;
                        if (uVar == null) {
                            Intrinsics.throwNpe();
                        }
                        j5 -= (long) (uVar.f2926c - uVar.f2925b);
                    }
                    while (j5 < j2) {
                        byte[] bArr = uVar.f2924a;
                        int min = (int) Math.min((long) uVar.f2926c, (((long) uVar.f2925b) + j2) - j5);
                        for (int i = (int) ((((long) uVar.f2925b) + j) - j5); i < min; i++) {
                            if (bArr[i] == b) {
                                return ((long) (i - uVar.f2925b)) + j5;
                            }
                        }
                        j5 += (long) (uVar.f2926c - uVar.f2925b);
                        uVar = uVar.f2929f;
                        if (uVar == null) {
                            Intrinsics.throwNpe();
                        }
                        j = j5;
                    }
                } else {
                    while (true) {
                        long j6 = ((long) (uVar.f2926c - uVar.f2925b)) + j3;
                        if (j6 > j) {
                            break;
                        }
                        uVar = uVar.f2929f;
                        if (uVar == null) {
                            Intrinsics.throwNpe();
                        }
                        j3 = j6;
                    }
                    while (j3 < j2) {
                        byte[] bArr2 = uVar.f2924a;
                        int min2 = (int) Math.min((long) uVar.f2926c, (((long) uVar.f2925b) + j2) - j3);
                        for (int i2 = (int) ((((long) uVar.f2925b) + j) - j3); i2 < min2; i2++) {
                            if (bArr2[i2] == b) {
                                return ((long) (i2 - uVar.f2925b)) + j3;
                            }
                        }
                        j3 += (long) (uVar.f2926c - uVar.f2925b);
                        uVar = uVar.f2929f;
                        if (uVar == null) {
                            Intrinsics.throwNpe();
                        }
                        j = j3;
                    }
                }
            }
            return -1;
        }
        StringBuilder a = C0681a.m330a("size=");
        a.append(this.f2891b);
        a.append(" fromIndex=");
        a.append(j);
        a.append(" toIndex=");
        a.append(j2);
        throw new IllegalArgumentException(a.toString().toString());
    }

    /* renamed from: g */
    public C2068f mo29161g(long j) {
        if (j == 0) {
            writeByte(48);
        } else {
            boolean z = false;
            int i = 1;
            if (j < 0) {
                j = -j;
                if (j < 0) {
                    mo29138a("-9223372036854775808");
                } else {
                    z = true;
                }
            }
            if (j >= 100000000) {
                i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
            } else if (j >= 10000) {
                i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
            } else if (j >= 100) {
                i = j < 1000 ? 3 : 4;
            } else if (j >= 10) {
                i = 2;
            }
            if (z) {
                i++;
            }
            C2087u b = mo29147b(i);
            byte[] bArr = b.f2924a;
            int i2 = b.f2926c + i;
            while (j != 0) {
                long j2 = (long) 10;
                i2--;
                bArr[i2] = C2059a.m3455a()[(int) (j % j2)];
                j /= j2;
            }
            if (z) {
                bArr[i2 - 1] = (byte) 45;
            }
            b.f2926c += i;
            this.f2891b += (long) i;
        }
        return this;
    }

    /* renamed from: a */
    public boolean mo29145a(long j, C2073i iVar) {
        Intrinsics.checkParameterIsNotNull(iVar, "bytes");
        int d = iVar.mo29212d();
        Intrinsics.checkParameterIsNotNull(iVar, "bytes");
        if (j < 0 || d < 0 || this.f2891b - j < ((long) d) || iVar.mo29212d() - 0 < d) {
            return false;
        }
        for (int i = 0; i < d; i++) {
            if (mo29163h(((long) i) + j) != iVar.mo29201a(0 + i)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public byte[] mo29149b() {
        return mo29156e(this.f2891b);
    }

    /* renamed from: a */
    public long mo29134a(C2090x xVar) throws IOException {
        Intrinsics.checkParameterIsNotNull(xVar, "sink");
        long j = this.f2891b;
        if (j > 0) {
            xVar.mo27647a(this, j);
        }
        return j;
    }

    /* renamed from: b */
    public String mo29148b(long j) throws EOFException {
        if (j >= 0) {
            long j2 = LongCompanionObject.MAX_VALUE;
            if (j != LongCompanionObject.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b = (byte) 10;
            long a = mo29133a(b, 0, j2);
            if (a != -1) {
                return C2059a.m3454a(this, a);
            }
            if (j2 < this.f2891b && mo29163h(j2 - 1) == ((byte) 13) && mo29163h(j2) == b) {
                return C2059a.m3454a(this, j2);
            }
            C2068f fVar = new C2068f();
            mo29136a(fVar, 0, Math.min((long) 32, this.f2891b));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f2891b, j) + " content=" + fVar.mo29169j().mo29213e() + Typography.ellipsis);
        }
        throw new IllegalArgumentException(C0681a.m318a("limit < 0: ", j).toString());
    }

    /* renamed from: a */
    public C2073i mo29142a(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(C0681a.m318a("byteCount: ", j).toString());
        } else if (this.f2891b < j) {
            throw new EOFException();
        } else if (j < ((long) 4096)) {
            return new C2073i(mo29156e(j));
        } else {
            C2073i a = mo29141a((int) j);
            skip(j);
            return a;
        }
    }

    /* renamed from: a */
    public int mo29132a(C2081q qVar) {
        Intrinsics.checkParameterIsNotNull(qVar, "options");
        int a = C2059a.m3453a(this, qVar, false);
        if (a == -1) {
            return -1;
        }
        skip((long) qVar.mo29226a()[a].mo29212d());
        return a;
    }

    /* renamed from: a */
    public final C2073i mo29141a(int i) {
        if (i == 0) {
            return C2073i.f2894d;
        }
        C1532a.m2135a(this.f2891b, 0, (long) i);
        C2087u uVar = this.f2890a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (uVar == null) {
                Intrinsics.throwNpe();
            }
            int i5 = uVar.f2926c;
            int i6 = uVar.f2925b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                uVar = uVar.f2929f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[(i4 * 2)];
        C2087u uVar2 = this.f2890a;
        int i7 = 0;
        while (i2 < i) {
            if (uVar2 == null) {
                Intrinsics.throwNpe();
            }
            bArr[i7] = uVar2.f2924a;
            i2 += uVar2.f2926c - uVar2.f2925b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = uVar2.f2925b;
            uVar2.f2927d = true;
            i7++;
            uVar2 = uVar2.f2929f;
        }
        return new C2089w(bArr, iArr);
    }

    /* renamed from: a */
    public C2068f mo29137a(C2073i iVar) {
        Intrinsics.checkParameterIsNotNull(iVar, "byteString");
        iVar.mo29204a(this, 0, iVar.mo29212d());
        return this;
    }

    /* renamed from: a */
    public void mo27647a(C2068f fVar, long j) {
        int i;
        C2087u uVar;
        C2087u uVar2;
        C2068f fVar2 = fVar;
        Intrinsics.checkParameterIsNotNull(fVar2, FirebaseAnalytics.Param.SOURCE);
        if (fVar2 != this) {
            C1532a.m2135a(fVar2.f2891b, 0, j);
            long j2 = j;
            while (j2 > 0) {
                C2087u uVar3 = fVar2.f2890a;
                if (uVar3 == null) {
                    Intrinsics.throwNpe();
                }
                int i2 = uVar3.f2926c;
                C2087u uVar4 = fVar2.f2890a;
                if (uVar4 == null) {
                    Intrinsics.throwNpe();
                }
                if (j2 < ((long) (i2 - uVar4.f2925b))) {
                    C2087u uVar5 = this.f2890a;
                    if (uVar5 != null) {
                        if (uVar5 == null) {
                            Intrinsics.throwNpe();
                        }
                        uVar = uVar5.f2930g;
                    } else {
                        uVar = null;
                    }
                    if (uVar != null && uVar.f2928e) {
                        if ((((long) uVar.f2926c) + j2) - ((long) (uVar.f2927d ? 0 : uVar.f2925b)) <= ((long) 8192)) {
                            C2087u uVar6 = fVar2.f2890a;
                            if (uVar6 == null) {
                                Intrinsics.throwNpe();
                            }
                            uVar6.mo29250a(uVar, (int) j2);
                            fVar2.f2891b -= j2;
                            this.f2891b += j2;
                            return;
                        }
                    }
                    C2087u uVar7 = fVar2.f2890a;
                    if (uVar7 == null) {
                        Intrinsics.throwNpe();
                    }
                    int i3 = (int) j2;
                    if (uVar7 != null) {
                        if (i3 > 0 && i3 <= uVar7.f2926c - uVar7.f2925b) {
                            if (i3 >= 1024) {
                                uVar2 = uVar7.mo29251b();
                            } else {
                                uVar2 = C2088v.f2933c.mo29252a();
                                byte[] bArr = uVar7.f2924a;
                                byte[] bArr2 = uVar2.f2924a;
                                int i4 = uVar7.f2925b;
                                byte[] unused = ArraysKt___ArraysJvmKt.copyInto$default(bArr, bArr2, 0, i4, i4 + i3, 2, (Object) null);
                            }
                            uVar2.f2926c = uVar2.f2925b + i3;
                            uVar7.f2925b += i3;
                            C2087u uVar8 = uVar7.f2930g;
                            if (uVar8 == null) {
                                Intrinsics.throwNpe();
                            }
                            uVar8.mo29249a(uVar2);
                            fVar2.f2890a = uVar2;
                        } else {
                            throw new IllegalArgumentException("byteCount out of range".toString());
                        }
                    } else {
                        throw null;
                    }
                }
                C2087u uVar9 = fVar2.f2890a;
                if (uVar9 == null) {
                    Intrinsics.throwNpe();
                }
                long j3 = (long) (uVar9.f2926c - uVar9.f2925b);
                fVar2.f2890a = uVar9.mo29248a();
                C2087u uVar10 = this.f2890a;
                if (uVar10 == null) {
                    this.f2890a = uVar9;
                    uVar9.f2930g = uVar9;
                    uVar9.f2929f = uVar9;
                } else {
                    if (uVar10 == null) {
                        Intrinsics.throwNpe();
                    }
                    C2087u uVar11 = uVar10.f2930g;
                    if (uVar11 == null) {
                        Intrinsics.throwNpe();
                    }
                    uVar11.mo29249a(uVar9);
                    if (uVar9.f2930g != uVar9) {
                        C2087u uVar12 = uVar9.f2930g;
                        if (uVar12 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (uVar12.f2928e) {
                            int i5 = uVar9.f2926c - uVar9.f2925b;
                            C2087u uVar13 = uVar9.f2930g;
                            if (uVar13 == null) {
                                Intrinsics.throwNpe();
                            }
                            int i6 = 8192 - uVar13.f2926c;
                            C2087u uVar14 = uVar9.f2930g;
                            if (uVar14 == null) {
                                Intrinsics.throwNpe();
                            }
                            if (uVar14.f2927d) {
                                i = 0;
                            } else {
                                C2087u uVar15 = uVar9.f2930g;
                                if (uVar15 == null) {
                                    Intrinsics.throwNpe();
                                }
                                i = uVar15.f2925b;
                            }
                            if (i5 <= i6 + i) {
                                C2087u uVar16 = uVar9.f2930g;
                                if (uVar16 == null) {
                                    Intrinsics.throwNpe();
                                }
                                uVar9.mo29250a(uVar16, i5);
                                uVar9.mo29248a();
                                C2088v.f2933c.mo29253a(uVar9);
                            }
                        }
                    } else {
                        throw new IllegalStateException("cannot compact".toString());
                    }
                }
                fVar2.f2891b -= j3;
                this.f2891b += j3;
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    /* renamed from: a */
    public C2068f mo29139a(String str, int i, int i2) {
        long j;
        long j2;
        char charAt;
        Intrinsics.checkParameterIsNotNull(str, "string");
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= str.length()) {
                    while (i < i2) {
                        char charAt2 = str.charAt(i);
                        if (charAt2 < 128) {
                            C2087u b = mo29147b(1);
                            byte[] bArr = b.f2924a;
                            int i3 = b.f2926c - i;
                            int min = Math.min(i2, 8192 - i3);
                            int i4 = i + 1;
                            bArr[i + i3] = (byte) charAt2;
                            while (true) {
                                i = i4;
                                if (i >= min || (charAt = str.charAt(i)) >= 128) {
                                    int i5 = b.f2926c;
                                    int i6 = (i3 + i) - i5;
                                    b.f2926c = i5 + i6;
                                    this.f2891b += (long) i6;
                                } else {
                                    i4 = i + 1;
                                    bArr[i + i3] = (byte) charAt;
                                }
                            }
                            int i52 = b.f2926c;
                            int i62 = (i3 + i) - i52;
                            b.f2926c = i52 + i62;
                            this.f2891b += (long) i62;
                        } else {
                            if (charAt2 < 2048) {
                                C2087u b2 = mo29147b(2);
                                byte[] bArr2 = b2.f2924a;
                                int i7 = b2.f2926c;
                                bArr2[i7] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i7 + 1] = (byte) ((charAt2 & '?') | 128);
                                b2.f2926c = i7 + 2;
                                j = this.f2891b;
                                j2 = 2;
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                C2087u b3 = mo29147b(3);
                                byte[] bArr3 = b3.f2924a;
                                int i8 = b3.f2926c;
                                bArr3[i8] = (byte) ((charAt2 >> 12) | 224);
                                bArr3[i8 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i8 + 2] = (byte) ((charAt2 & '?') | 128);
                                b3.f2926c = i8 + 3;
                                j = this.f2891b;
                                j2 = 3;
                            } else {
                                int i9 = i + 1;
                                char charAt3 = i9 < i2 ? str.charAt(i9) : 0;
                                if (charAt2 > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                                    writeByte(63);
                                    i = i9;
                                } else {
                                    int i10 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + CharCompanionObject.MIN_VALUE;
                                    C2087u b4 = mo29147b(4);
                                    byte[] bArr4 = b4.f2924a;
                                    int i11 = b4.f2926c;
                                    bArr4[i11] = (byte) ((i10 >> 18) | 240);
                                    bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                                    bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                                    bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                                    b4.f2926c = i11 + 4;
                                    this.f2891b += 4;
                                    i += 2;
                                }
                            }
                            this.f2891b = j + j2;
                            i++;
                        }
                    }
                    return this;
                }
                StringBuilder b5 = C0681a.m338b("endIndex > string.length: ", i2, " > ");
                b5.append(str.length());
                throw new IllegalArgumentException(b5.toString().toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        throw new IllegalArgumentException(C0681a.m316a("beginIndex < 0: ", i).toString());
    }
}
