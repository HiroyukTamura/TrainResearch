package p042j;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;
import p042j.p118B.C2059a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, mo21739d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "okio"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: j.t */
public final class C2085t implements C2072h {
    @JvmField

    /* renamed from: a */
    public final C2068f f2920a = new C2068f();
    @JvmField

    /* renamed from: b */
    public boolean f2921b;
    @JvmField

    /* renamed from: c */
    public final C1016z f2922c;

    /* renamed from: j.t$a */
    public static final class C2086a extends InputStream {

        /* renamed from: a */
        final /* synthetic */ C2085t f2923a;

        C2086a(C2085t tVar) {
            this.f2923a = tVar;
        }

        public int available() {
            C2085t tVar = this.f2923a;
            if (!tVar.f2921b) {
                return (int) Math.min(tVar.f2920a.size(), (long) Integer.MAX_VALUE);
            }
            throw new IOException("closed");
        }

        public void close() {
            this.f2923a.close();
        }

        public int read() {
            C2085t tVar = this.f2923a;
            if (!tVar.f2921b) {
                if (tVar.f2920a.size() == 0) {
                    C2085t tVar2 = this.f2923a;
                    if (tVar2.f2922c.read(tVar2.f2920a, (long) 8192) == -1) {
                        return -1;
                    }
                }
                return this.f2923a.f2920a.readByte() & UByte.MAX_VALUE;
            }
            throw new IOException("closed");
        }

        public int read(byte[] bArr, int i, int i2) {
            Intrinsics.checkParameterIsNotNull(bArr, "data");
            if (!this.f2923a.f2921b) {
                C1532a.m2135a((long) bArr.length, (long) i, (long) i2);
                if (this.f2923a.f2920a.size() == 0) {
                    C2085t tVar = this.f2923a;
                    if (tVar.f2922c.read(tVar.f2920a, (long) 8192) == -1) {
                        return -1;
                    }
                }
                return this.f2923a.f2920a.read(bArr, i, i2);
            }
            throw new IOException("closed");
        }

        public String toString() {
            return this.f2923a + ".inputStream()";
        }
    }

    public C2085t(C1016z zVar) {
        Intrinsics.checkParameterIsNotNull(zVar, FirebaseAnalytics.Param.SOURCE);
        this.f2922c = zVar;
    }

    /* renamed from: a */
    public long mo29238a(byte b, long j, long j2) {
        boolean z = true;
        if (!this.f2921b) {
            if (0 > j || j2 < j) {
                z = false;
            }
            if (z) {
                while (j < j2) {
                    long a = this.f2920a.mo29133a(b, j, j2);
                    if (a != -1) {
                        return a;
                    }
                    long size = this.f2920a.size();
                    if (size >= j2 || this.f2922c.read(this.f2920a, (long) 8192) == -1) {
                        return -1;
                    }
                    j = Math.max(j, size);
                }
                return -1;
            }
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: a */
    public long mo29134a(C2090x xVar) {
        C2068f fVar;
        Intrinsics.checkParameterIsNotNull(xVar, "sink");
        long j = 0;
        while (true) {
            int i = (this.f2922c.read(this.f2920a, (long) 8192) > -1 ? 1 : (this.f2922c.read(this.f2920a, (long) 8192) == -1 ? 0 : -1));
            fVar = this.f2920a;
            if (i == 0) {
                break;
            }
            long h = fVar.mo29164h();
            if (h > 0) {
                j += h;
                xVar.mo27647a(this.f2920a, h);
            }
        }
        if (fVar.size() <= 0) {
            return j;
        }
        long size = j + this.f2920a.size();
        C2068f fVar2 = this.f2920a;
        xVar.mo27647a(fVar2, fVar2.size());
        return size;
    }

    /* renamed from: a */
    public String mo29144a(Charset charset) {
        Intrinsics.checkParameterIsNotNull(charset, "charset");
        this.f2920a.mo29135a(this.f2922c);
        return this.f2920a.mo29144a(charset);
    }

    /* renamed from: a */
    public boolean mo29145a(long j, C2073i iVar) {
        Intrinsics.checkParameterIsNotNull(iVar, "bytes");
        int d = iVar.mo29212d();
        Intrinsics.checkParameterIsNotNull(iVar, "bytes");
        if (!this.f2921b) {
            if (j >= 0 && d >= 0 && iVar.mo29212d() - 0 >= d) {
                int i = 0;
                while (i < d) {
                    long j2 = ((long) i) + j;
                    if (mo29155d(1 + j2) && this.f2920a.mo29163h(j2) == iVar.mo29201a(0 + i)) {
                        i++;
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* renamed from: b */
    public String mo29148b(long j) {
        if (j >= 0) {
            long j2 = j == LongCompanionObject.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            byte b = (byte) 10;
            long a = mo29238a(b, 0, j2);
            if (a != -1) {
                return C2059a.m3454a(this.f2920a, a);
            }
            if (j2 < LongCompanionObject.MAX_VALUE && mo29155d(j2) && this.f2920a.mo29163h(j2 - 1) == ((byte) 13) && mo29155d(1 + j2) && this.f2920a.mo29163h(j2) == b) {
                return C2059a.m3454a(this.f2920a, j2);
            }
            C2068f fVar = new C2068f();
            C2068f fVar2 = this.f2920a;
            fVar2.mo29136a(fVar, 0, Math.min((long) 32, fVar2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f2920a.size(), j) + " content=" + fVar.mo29169j().mo29213e() + "…");
        }
        throw new IllegalArgumentException(C0681a.m318a("limit < 0: ", j).toString());
    }

    /* renamed from: b */
    public byte[] mo29149b() {
        this.f2920a.mo29135a(this.f2922c);
        return this.f2920a.mo29149b();
    }

    /* renamed from: c */
    public boolean mo29152c() {
        if (!this.f2921b) {
            return this.f2920a.mo29152c() && this.f2922c.read(this.f2920a, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public void close() {
        if (!this.f2921b) {
            this.f2921b = true;
            this.f2922c.close();
            this.f2920a.mo29154d();
        }
    }

    /* renamed from: d */
    public int mo29239d() {
        mo29159f(4);
        int readInt = this.f2920a.readInt();
        return ((readInt & 255) << 24) | ((-16777216 & readInt) >>> 24) | ((16711680 & readInt) >>> 8) | ((65280 & readInt) << 8);
    }

    /* renamed from: d */
    public boolean mo29155d(long j) {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(C0681a.m318a("byteCount < 0: ", j).toString());
        } else if (!this.f2921b) {
            while (this.f2920a.size() < j) {
                if (this.f2922c.read(this.f2920a, (long) 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    /* renamed from: e */
    public byte[] mo29156e(long j) {
        if (mo29155d(j)) {
            return this.f2920a.mo29156e(j);
        }
        throw new EOFException();
    }

    /* renamed from: f */
    public void mo29159f(long j) {
        if (!mo29155d(j)) {
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r4 == 0) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r0 = p009e.p010a.p011a.p012a.C0681a.m330a("Expected leading [0-9] or '-' character but was 0x");
        r1 = java.lang.Integer.toString(r8, kotlin.text.CharsKt.checkRadix(kotlin.text.CharsKt.checkRadix(16)));
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r0.append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        throw new java.lang.NumberFormatException(r0.toString());
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo29160g() {
        /*
            r10 = this;
            r0 = 1
            r10.mo29159f(r0)
            r2 = 0
            r4 = r2
        L_0x0008:
            long r6 = r4 + r0
            boolean r8 = r10.mo29155d(r6)
            if (r8 == 0) goto L_0x0057
            j.f r8 = r10.f2920a
            byte r8 = r8.mo29163h(r4)
            r9 = 48
            byte r9 = (byte) r9
            if (r8 < r9) goto L_0x0020
            r9 = 57
            byte r9 = (byte) r9
            if (r8 <= r9) goto L_0x002a
        L_0x0020:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L_0x002c
            r9 = 45
            byte r9 = (byte) r9
            if (r8 == r9) goto L_0x002a
            goto L_0x002c
        L_0x002a:
            r4 = r6
            goto L_0x0008
        L_0x002c:
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0031
            goto L_0x0057
        L_0x0031:
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r0 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r0)
            r1 = 16
            int r1 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r1)
            int r1 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r1)
            java.lang.String r1 = java.lang.Integer.toString(r8, r1)
            java.lang.String r2 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r1.<init>(r0)
            throw r1
        L_0x0057:
            j.f r0 = r10.f2920a
            long r0 = r0.mo29160g()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p042j.C2085t.mo29160g():long");
    }

    public C2068f getBuffer() {
        return this.f2920a;
    }

    public boolean isOpen() {
        return !this.f2921b;
    }

    /* renamed from: j */
    public C2073i mo29169j() {
        this.f2920a.mo29135a(this.f2922c);
        return this.f2920a.mo29169j();
    }

    /* renamed from: k */
    public String mo29171k() {
        return mo29148b(LongCompanionObject.MAX_VALUE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long mo29173m() {
        /*
            r5 = this;
            r0 = 1
            r5.mo29159f(r0)
            r0 = 0
        L_0x0006:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r5.mo29155d(r2)
            if (r2 == 0) goto L_0x0060
            j.f r2 = r5.f2920a
            long r3 = (long) r0
            byte r2 = r2.mo29163h(r3)
            r3 = 48
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0020
            r3 = 57
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
        L_0x0020:
            r3 = 97
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x002a
            r3 = 102(0x66, float:1.43E-43)
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
        L_0x002a:
            r3 = 65
            byte r3 = (byte) r3
            if (r2 < r3) goto L_0x0037
            r3 = 70
            byte r3 = (byte) r3
            if (r2 <= r3) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r0 = r1
            goto L_0x0006
        L_0x0037:
            if (r0 == 0) goto L_0x003a
            goto L_0x0060
        L_0x003a:
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r0 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r0)
            r1 = 16
            int r1 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r1)
            int r1 = kotlin.text.CharsKt__CharJVMKt.checkRadix(r1)
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)
            java.lang.String r2 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r1.<init>(r0)
            throw r1
        L_0x0060:
            j.f r0 = r5.f2920a
            long r0 = r0.mo29173m()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p042j.C2085t.mo29173m():long");
    }

    /* renamed from: n */
    public InputStream mo29174n() {
        return new C2086a(this);
    }

    public int read(ByteBuffer byteBuffer) {
        Intrinsics.checkParameterIsNotNull(byteBuffer, "sink");
        if (this.f2920a.size() == 0 && this.f2922c.read(this.f2920a, (long) 8192) == -1) {
            return -1;
        }
        return this.f2920a.read(byteBuffer);
    }

    public long read(C2068f fVar, long j) {
        Intrinsics.checkParameterIsNotNull(fVar, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(C0681a.m318a("byteCount < 0: ", j).toString());
        } else if (!(!this.f2921b)) {
            throw new IllegalStateException("closed".toString());
        } else if (this.f2920a.size() == 0 && this.f2922c.read(this.f2920a, (long) 8192) == -1) {
            return -1;
        } else {
            return this.f2920a.read(fVar, Math.min(j, this.f2920a.size()));
        }
    }

    public byte readByte() {
        mo29159f(1);
        return this.f2920a.readByte();
    }

    public int readInt() {
        mo29159f(4);
        return this.f2920a.readInt();
    }

    public short readShort() {
        mo29159f(2);
        return this.f2920a.readShort();
    }

    public void skip(long j) {
        if (!this.f2921b) {
            while (j > 0) {
                if (this.f2920a.size() == 0 && this.f2922c.read(this.f2920a, (long) 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.f2920a.size());
                this.f2920a.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    public C2057A timeout() {
        return this.f2922c.timeout();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("buffer(");
        a.append(this.f2922c);
        a.append(')');
        return a.toString();
    }

    /* renamed from: a */
    public C2073i mo29142a(long j) {
        if (mo29155d(j)) {
            return this.f2920a.mo29142a(j);
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public int mo29132a(C2081q qVar) {
        Intrinsics.checkParameterIsNotNull(qVar, "options");
        if (!this.f2921b) {
            while (true) {
                int a = C2059a.m3453a(this.f2920a, qVar, true);
                if (a == -2) {
                    if (this.f2922c.read(this.f2920a, (long) 8192) == -1) {
                        break;
                    }
                } else if (a != -1) {
                    this.f2920a.skip((long) qVar.mo29226a()[a].mo29212d());
                    return a;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }
}
