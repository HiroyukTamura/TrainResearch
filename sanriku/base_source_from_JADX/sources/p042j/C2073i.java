package p042j;

import com.google.android.gms.fitness.FitnessActivities;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;
import p042j.p118B.C2060b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 Z2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001ZB\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0002J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u001dJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0000J\u0013\u0010!\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\"H\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0002¢\u0006\u0002\b&J\u0015\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\tH\u0007¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\tH\u0010¢\u0006\u0002\b)J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u001d\u0010+\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0000H\u0010¢\u0006\u0002\b-J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\u0016J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00101\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\r\u00103\u001a\u00020\u0004H\u0010¢\u0006\u0002\b4J\u0015\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\tH\u0010¢\u0006\u0002\b7J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\tH\u0017J\u001a\u00108\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\tH\u0007J\b\u00109\u001a\u00020\u0000H\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J(\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0016J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020\u0000H\u0016J\b\u0010C\u001a\u00020\u0000H\u0016J\b\u0010D\u001a\u00020\u0000H\u0016J\r\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\bEJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0004J\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0000J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020JH\u0016J\u001c\u0010K\u001a\u00020\u00002\b\b\u0002\u0010L\u001a\u00020\t2\b\b\u0002\u0010M\u001a\u00020\tH\u0017J\b\u0010N\u001a\u00020\u0000H\u0016J\b\u0010O\u001a\u00020\u0000H\u0016J\b\u0010P\u001a\u00020\u0004H\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010R\u001a\u00020?2\u0006\u0010S\u001a\u00020TH\u0016J%\u0010R\u001a\u00020?2\u0006\u0010U\u001a\u00020V2\u0006\u0010;\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0010¢\u0006\u0002\bWJ\u0010\u0010X\u001a\u00020?2\u0006\u0010S\u001a\u00020YH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006["}, mo21739d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "digest", "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", "pos", "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "offset", "otherOffset", "byteCount", "readObject", "", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", "string", "charset", "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", "write", "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: j.i */
public class C2073i implements Serializable, Comparable<C2073i> {
    @JvmField

    /* renamed from: d */
    public static final C2073i f2894d = new C2073i(new byte[0]);

    /* renamed from: e */
    public static final C2074a f2895e = new C2074a((DefaultConstructorMarker) null);

    /* renamed from: a */
    private transient int f2896a;

    /* renamed from: b */
    private transient String f2897b;

    /* renamed from: c */
    private final byte[] f2898c;

    /* renamed from: j.i$a */
    public static final class C2074a {
        public /* synthetic */ C2074a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static /* synthetic */ C2073i m3561a(C2074a aVar, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = bArr.length;
            }
            if (aVar != null) {
                Intrinsics.checkParameterIsNotNull(bArr, "$this$toByteString");
                C1532a.m2135a((long) bArr.length, (long) i, (long) i2);
                return new C2073i(ArraysKt___ArraysJvmKt.copyOfRange(bArr, i, i2 + i));
            }
            throw null;
        }

        @JvmStatic
        /* renamed from: a */
        public final C2073i mo29220a(String str) {
            Intrinsics.checkParameterIsNotNull(str, "$this$decodeHex");
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    bArr[i] = (byte) (C2060b.m3456a(str.charAt(i2 + 1)) + (C2060b.m3456a(str.charAt(i2)) << 4));
                }
                return new C2073i(bArr);
            }
            throw new IllegalArgumentException(C0681a.m320a("Unexpected hex string: ", str).toString());
        }

        @JvmStatic
        /* renamed from: b */
        public final C2073i mo29221b(String str) {
            Intrinsics.checkParameterIsNotNull(str, "$this$encodeUtf8");
            Intrinsics.checkParameterIsNotNull(str, "$this$asUtf8ToByteArray");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            C2073i iVar = new C2073i(bytes);
            iVar.mo29208b(str);
            return iVar;
        }
    }

    public C2073i(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "data");
        this.f2898c = bArr;
    }

    /* renamed from: a */
    public C2073i mo29202a(String str) {
        Intrinsics.checkParameterIsNotNull(str, "algorithm");
        byte[] digest = MessageDigest.getInstance(str).digest(this.f2898c);
        Intrinsics.checkExpressionValueIsNotNull(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new C2073i(digest);
    }

    /* renamed from: a */
    public String mo29203a() {
        return C2061a.m3458a(this.f2898c, (byte[]) null, 1);
    }

    /* renamed from: b */
    public final void mo29207b(int i) {
        this.f2896a = i;
    }

    /* renamed from: b */
    public final void mo29208b(String str) {
        this.f2897b = str;
    }

    /* renamed from: b */
    public final byte[] mo29209b() {
        return this.f2898c;
    }

    /* renamed from: c */
    public final int mo29210c() {
        return this.f2896a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0032 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(java.lang.Object r8) {
        /*
            r7 = this;
            j.i r8 = (p042j.C2073i) r8
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r8, r0)
            int r0 = r7.mo29212d()
            int r1 = r8.mo29212d()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L_0x0015:
            if (r4 >= r2) goto L_0x002b
            byte r5 = r7.mo29201a((int) r4)
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r6 = r8.mo29201a((int) r4)
            r6 = r6 & 255(0xff, float:3.57E-43)
            if (r5 != r6) goto L_0x0028
            int r4 = r4 + 1
            goto L_0x0015
        L_0x0028:
            if (r5 >= r6) goto L_0x0032
            goto L_0x0030
        L_0x002b:
            if (r0 != r1) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            if (r0 >= r1) goto L_0x0032
        L_0x0030:
            r3 = -1
            goto L_0x0033
        L_0x0032:
            r3 = 1
        L_0x0033:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p042j.C2073i.compareTo(java.lang.Object):int");
    }

    /* renamed from: d */
    public int mo29212d() {
        return this.f2898c.length;
    }

    /* renamed from: e */
    public String mo29213e() {
        byte[] bArr = this.f2898c;
        char[] cArr = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr[i] = C2060b.m3457a()[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = C2060b.m3457a()[b & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2073i) {
            C2073i iVar = (C2073i) obj;
            int d = iVar.mo29212d();
            byte[] bArr = this.f2898c;
            if (d != bArr.length || !iVar.mo29206a(0, bArr, 0, bArr.length)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public byte[] mo29215f() {
        return this.f2898c;
    }

    /* renamed from: g */
    public C2073i mo29216g() {
        byte b;
        int i = 0;
        while (true) {
            byte[] bArr = this.f2898c;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            byte b3 = (byte) 65;
            if (b2 < b3 || b2 > (b = (byte) 90)) {
                i++;
            } else {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                Intrinsics.checkExpressionValueIsNotNull(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new C2073i(copyOf);
            }
        }
    }

    /* renamed from: h */
    public String mo29217h() {
        String str = this.f2897b;
        if (str != null) {
            return str;
        }
        byte[] f = mo29215f();
        Intrinsics.checkParameterIsNotNull(f, "$this$toUtf8String");
        String str2 = new String(f, Charsets.UTF_8);
        this.f2897b = str2;
        return str2;
    }

    public int hashCode() {
        int i = this.f2896a;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f2898c);
        this.f2896a = hashCode;
        return hashCode;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0122, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0160, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0173, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0184, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0193, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x01a9, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x01b1, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x01b8, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x01ed, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x01f0, code lost:
        r5 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x008b, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x009c, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00a7, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00e5, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00f8, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0107, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0119, code lost:
        if (r4 == 64) goto L_0x01f1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r21 = this;
            r0 = r21
            byte[] r1 = r0.f2898c
            int r1 = r1.length
            if (r1 != 0) goto L_0x0009
            r1 = 1
            goto L_0x000a
        L_0x0009:
            r1 = 0
        L_0x000a:
            if (r1 == 0) goto L_0x0010
            java.lang.String r1 = "[size=0]"
            goto L_0x02c3
        L_0x0010:
            byte[] r1 = r0.f2898c
            int r2 = r1.length
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0016:
            r6 = 64
            if (r3 >= r2) goto L_0x01f1
            byte r7 = r1[r3]
            r8 = 13
            r9 = 10
            r10 = 31
            r11 = 127(0x7f, float:1.78E-43)
            r12 = 159(0x9f, float:2.23E-43)
            r13 = 65533(0xfffd, float:9.1831E-41)
            r14 = 65536(0x10000, float:9.18355E-41)
            if (r7 < 0) goto L_0x0080
            int r15 = r4 + 1
            if (r4 != r6) goto L_0x0033
            goto L_0x01f1
        L_0x0033:
            if (r7 == r9) goto L_0x0045
            if (r7 == r8) goto L_0x0045
            if (r7 < 0) goto L_0x003b
            if (r10 >= r7) goto L_0x0040
        L_0x003b:
            if (r11 <= r7) goto L_0x003e
            goto L_0x0042
        L_0x003e:
            if (r12 < r7) goto L_0x0042
        L_0x0040:
            r4 = 1
            goto L_0x0043
        L_0x0042:
            r4 = 0
        L_0x0043:
            if (r4 != 0) goto L_0x01f0
        L_0x0045:
            if (r7 != r13) goto L_0x0049
            goto L_0x01f0
        L_0x0049:
            if (r7 >= r14) goto L_0x004d
            r4 = 1
            goto L_0x004e
        L_0x004d:
            r4 = 2
        L_0x004e:
            int r5 = r5 + r4
            int r3 = r3 + 1
        L_0x0051:
            r4 = r15
            if (r3 >= r2) goto L_0x0016
            byte r7 = r1[r3]
            if (r7 < 0) goto L_0x0016
            int r7 = r3 + 1
            byte r3 = r1[r3]
            int r15 = r4 + 1
            if (r4 != r6) goto L_0x0062
            goto L_0x01f1
        L_0x0062:
            if (r3 == r9) goto L_0x0074
            if (r3 == r8) goto L_0x0074
            if (r3 < 0) goto L_0x006a
            if (r10 >= r3) goto L_0x006f
        L_0x006a:
            if (r11 <= r3) goto L_0x006d
            goto L_0x0071
        L_0x006d:
            if (r12 < r3) goto L_0x0071
        L_0x006f:
            r4 = 1
            goto L_0x0072
        L_0x0071:
            r4 = 0
        L_0x0072:
            if (r4 != 0) goto L_0x01f0
        L_0x0074:
            if (r3 != r13) goto L_0x0078
            goto L_0x01f0
        L_0x0078:
            if (r3 >= r14) goto L_0x007c
            r3 = 1
            goto L_0x007d
        L_0x007c:
            r3 = 2
        L_0x007d:
            int r5 = r5 + r3
            r3 = r7
            goto L_0x0051
        L_0x0080:
            int r13 = r7 >> 5
            r14 = -2
            r15 = 128(0x80, float:1.794E-43)
            if (r13 != r14) goto L_0x00d7
            int r7 = r3 + 1
            if (r2 > r7) goto L_0x008f
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x008f:
            byte r13 = r1[r3]
            byte r7 = r1[r7]
            r14 = r7 & 192(0xc0, float:2.69E-43)
            if (r14 != r15) goto L_0x0099
            r14 = 1
            goto L_0x009a
        L_0x0099:
            r14 = 0
        L_0x009a:
            if (r14 != 0) goto L_0x00a0
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x00a0:
            r7 = r7 ^ 3968(0xf80, float:5.56E-42)
            int r13 = r13 << 6
            r7 = r7 ^ r13
            if (r7 >= r15) goto L_0x00ab
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x00ab:
            int r13 = r4 + 1
            if (r4 != r6) goto L_0x00b1
            goto L_0x01f1
        L_0x00b1:
            if (r7 == r9) goto L_0x00c3
            if (r7 == r8) goto L_0x00c3
            if (r7 < 0) goto L_0x00b9
            if (r10 >= r7) goto L_0x00be
        L_0x00b9:
            if (r11 <= r7) goto L_0x00bc
            goto L_0x00c0
        L_0x00bc:
            if (r12 < r7) goto L_0x00c0
        L_0x00be:
            r4 = 1
            goto L_0x00c1
        L_0x00c0:
            r4 = 0
        L_0x00c1:
            if (r4 != 0) goto L_0x01f0
        L_0x00c3:
            r4 = 65533(0xfffd, float:9.1831E-41)
            if (r7 != r4) goto L_0x00ca
            goto L_0x01f0
        L_0x00ca:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r7 >= r4) goto L_0x00d0
            r15 = 1
            goto L_0x00d1
        L_0x00d0:
            r15 = 2
        L_0x00d1:
            int r5 = r5 + r15
            int r3 = r3 + 2
            r4 = r13
            goto L_0x0016
        L_0x00d7:
            int r10 = r7 >> 4
            r11 = 55296(0xd800, float:7.7486E-41)
            r12 = 57343(0xdfff, float:8.0355E-41)
            if (r10 != r14) goto L_0x0158
            int r7 = r3 + 2
            if (r2 > r7) goto L_0x00e9
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x00e9:
            byte r10 = r1[r3]
            int r13 = r3 + 1
            byte r13 = r1[r13]
            r14 = r13 & 192(0xc0, float:2.69E-43)
            if (r14 != r15) goto L_0x00f5
            r14 = 1
            goto L_0x00f6
        L_0x00f5:
            r14 = 0
        L_0x00f6:
            if (r14 != 0) goto L_0x00fc
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x00fc:
            byte r7 = r1[r7]
            r14 = r7 & 192(0xc0, float:2.69E-43)
            if (r14 != r15) goto L_0x0104
            r14 = 1
            goto L_0x0105
        L_0x0104:
            r14 = 0
        L_0x0105:
            if (r14 != 0) goto L_0x010b
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x010b:
            r14 = -123008(0xfffffffffffe1f80, float:NaN)
            r7 = r7 ^ r14
            int r13 = r13 << 6
            r7 = r7 ^ r13
            int r10 = r10 << 12
            r7 = r7 ^ r10
            r10 = 2048(0x800, float:2.87E-42)
            if (r7 >= r10) goto L_0x011d
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x011d:
            if (r11 <= r7) goto L_0x0120
            goto L_0x0126
        L_0x0120:
            if (r12 < r7) goto L_0x0126
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x0126:
            int r10 = r4 + 1
            if (r4 != r6) goto L_0x012c
            goto L_0x01f1
        L_0x012c:
            if (r7 == r9) goto L_0x0144
            if (r7 == r8) goto L_0x0144
            if (r7 < 0) goto L_0x0136
            r4 = 31
            if (r4 >= r7) goto L_0x013f
        L_0x0136:
            r4 = 127(0x7f, float:1.78E-43)
            if (r4 <= r7) goto L_0x013b
            goto L_0x0141
        L_0x013b:
            r4 = 159(0x9f, float:2.23E-43)
            if (r4 < r7) goto L_0x0141
        L_0x013f:
            r4 = 1
            goto L_0x0142
        L_0x0141:
            r4 = 0
        L_0x0142:
            if (r4 != 0) goto L_0x01f0
        L_0x0144:
            r4 = 65533(0xfffd, float:9.1831E-41)
            if (r7 != r4) goto L_0x014b
            goto L_0x01f0
        L_0x014b:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r7 >= r4) goto L_0x0151
            r15 = 1
            goto L_0x0152
        L_0x0151:
            r15 = 2
        L_0x0152:
            int r5 = r5 + r15
            int r3 = r3 + 3
            r4 = r10
            goto L_0x0016
        L_0x0158:
            int r7 = r7 >> 3
            if (r7 != r14) goto L_0x01ed
            int r7 = r3 + 3
            if (r2 > r7) goto L_0x0164
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x0164:
            byte r8 = r1[r3]
            int r10 = r3 + 1
            byte r10 = r1[r10]
            r13 = r10 & 192(0xc0, float:2.69E-43)
            if (r13 != r15) goto L_0x0170
            r13 = 1
            goto L_0x0171
        L_0x0170:
            r13 = 0
        L_0x0171:
            if (r13 != 0) goto L_0x0177
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x0177:
            int r13 = r3 + 2
            byte r13 = r1[r13]
            r14 = r13 & 192(0xc0, float:2.69E-43)
            if (r14 != r15) goto L_0x0181
            r14 = 1
            goto L_0x0182
        L_0x0181:
            r14 = 0
        L_0x0182:
            if (r14 != 0) goto L_0x0188
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x0188:
            byte r7 = r1[r7]
            r14 = r7 & 192(0xc0, float:2.69E-43)
            if (r14 != r15) goto L_0x0190
            r14 = 1
            goto L_0x0191
        L_0x0190:
            r14 = 0
        L_0x0191:
            if (r14 != 0) goto L_0x0197
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x0197:
            r14 = 3678080(0x381f80, float:5.154088E-39)
            r7 = r7 ^ r14
            int r13 = r13 << 6
            r7 = r7 ^ r13
            int r10 = r10 << 12
            r7 = r7 ^ r10
            int r8 = r8 << 18
            r7 = r7 ^ r8
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r7 <= r8) goto L_0x01ac
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x01ac:
            if (r11 <= r7) goto L_0x01af
            goto L_0x01b4
        L_0x01af:
            if (r12 < r7) goto L_0x01b4
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x01b4:
            r8 = 65536(0x10000, float:9.18355E-41)
            if (r7 >= r8) goto L_0x01bb
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x01bb:
            int r8 = r4 + 1
            if (r4 != r6) goto L_0x01c0
            goto L_0x01f1
        L_0x01c0:
            if (r7 == r9) goto L_0x01da
            r4 = 13
            if (r7 == r4) goto L_0x01da
            if (r7 < 0) goto L_0x01cc
            r4 = 31
            if (r4 >= r7) goto L_0x01d5
        L_0x01cc:
            r4 = 127(0x7f, float:1.78E-43)
            if (r4 <= r7) goto L_0x01d1
            goto L_0x01d7
        L_0x01d1:
            r4 = 159(0x9f, float:2.23E-43)
            if (r4 < r7) goto L_0x01d7
        L_0x01d5:
            r4 = 1
            goto L_0x01d8
        L_0x01d7:
            r4 = 0
        L_0x01d8:
            if (r4 != 0) goto L_0x01f0
        L_0x01da:
            r4 = 65533(0xfffd, float:9.1831E-41)
            if (r7 != r4) goto L_0x01e0
            goto L_0x01f0
        L_0x01e0:
            r4 = 65536(0x10000, float:9.18355E-41)
            if (r7 >= r4) goto L_0x01e6
            r15 = 1
            goto L_0x01e7
        L_0x01e6:
            r15 = 2
        L_0x01e7:
            int r5 = r5 + r15
            int r3 = r3 + 4
            r4 = r8
            goto L_0x0016
        L_0x01ed:
            if (r4 != r6) goto L_0x01f0
            goto L_0x01f1
        L_0x01f0:
            r5 = -1
        L_0x01f1:
            java.lang.String r1 = "…]"
            r2 = 93
            java.lang.String r3 = "[size="
            r4 = -1
            if (r5 != r4) goto L_0x025f
            byte[] r4 = r0.f2898c
            int r4 = r4.length
            if (r4 > r6) goto L_0x020e
            java.lang.String r1 = "[hex="
            java.lang.StringBuilder r1 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r1)
            java.lang.String r3 = r21.mo29213e()
            r1.append(r3)
            goto L_0x02bc
        L_0x020e:
            java.lang.StringBuilder r2 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r3)
            byte[] r3 = r0.f2898c
            int r3 = r3.length
            r2.append(r3)
            java.lang.String r3 = " hex="
            r2.append(r3)
            byte[] r3 = r0.f2898c
            int r3 = r3.length
            if (r6 > r3) goto L_0x0224
            r3 = 1
            goto L_0x0225
        L_0x0224:
            r3 = 0
        L_0x0225:
            if (r3 == 0) goto L_0x0240
            byte[] r3 = r0.f2898c
            int r4 = r3.length
            if (r6 != r4) goto L_0x022e
            r4 = r0
            goto L_0x0238
        L_0x022e:
            r4 = 0
            byte[] r3 = kotlin.collections.ArraysKt___ArraysJvmKt.copyOfRange((byte[]) r3, (int) r4, (int) r6)
            j.i r4 = new j.i
            r4.<init>(r3)
        L_0x0238:
            java.lang.String r3 = r4.mo29213e()
            r2.append(r3)
            goto L_0x02ae
        L_0x0240:
            java.lang.String r1 = "endIndex > length("
            java.lang.StringBuilder r1 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r1)
            byte[] r2 = r0.f2898c
            int r2 = r2.length
            r1.append(r2)
            r2 = 41
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x025f:
            java.lang.String r4 = r21.mo29217h()
            if (r4 == 0) goto L_0x02c4
            r6 = 0
            java.lang.String r7 = r4.substring(r6, r5)
            java.lang.String r6 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r6)
            r6 = 0
            r13 = 4
            r14 = 0
            java.lang.String r8 = "\\"
            java.lang.String r9 = "\\\\"
            r10 = r6
            r11 = r13
            r12 = r14
            java.lang.String r15 = kotlin.text.StringsKt__StringsJVMKt.replace$default((java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (boolean) r10, (int) r11, (java.lang.Object) r12)
            r18 = 0
            r19 = 4
            r20 = 0
            java.lang.String r16 = "\n"
            java.lang.String r17 = "\\n"
            java.lang.String r8 = kotlin.text.StringsKt__StringsJVMKt.replace$default((java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (boolean) r18, (int) r19, (java.lang.Object) r20)
            java.lang.String r9 = "\r"
            java.lang.String r10 = "\\r"
            r11 = r6
            r12 = r13
            r13 = r14
            java.lang.String r6 = kotlin.text.StringsKt__StringsJVMKt.replace$default((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (boolean) r11, (int) r12, (java.lang.Object) r13)
            int r4 = r4.length()
            if (r5 >= r4) goto L_0x02b6
            java.lang.StringBuilder r2 = p009e.p010a.p011a.p012a.C0681a.m330a((java.lang.String) r3)
            byte[] r3 = r0.f2898c
            int r3 = r3.length
            r2.append(r3)
            java.lang.String r3 = " text="
            r2.append(r3)
            r2.append(r6)
        L_0x02ae:
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x02c3
        L_0x02b6:
            java.lang.String r1 = "[text="
            java.lang.StringBuilder r1 = p009e.p010a.p011a.p012a.C0681a.m340c(r1, r6)
        L_0x02bc:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x02c3:
            return r1
        L_0x02c4:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r1.<init>(r2)
            goto L_0x02cd
        L_0x02cc:
            throw r1
        L_0x02cd:
            goto L_0x02cc
        */
        throw new UnsupportedOperationException("Method not decompiled: p042j.C2073i.toString():java.lang.String");
    }

    /* renamed from: a */
    public byte mo29201a(int i) {
        return this.f2898c[i];
    }

    /* renamed from: a */
    public boolean mo29205a(int i, C2073i iVar, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(iVar, FitnessActivities.OTHER);
        return iVar.mo29206a(i2, this.f2898c, i, i3);
    }

    /* renamed from: a */
    public boolean mo29206a(int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(bArr, FitnessActivities.OTHER);
        if (i >= 0) {
            byte[] bArr2 = this.f2898c;
            return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && C1532a.m2144a(bArr2, i, bArr, i2, i3);
        }
    }

    /* renamed from: a */
    public void mo29204a(C2068f fVar, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(fVar, "buffer");
        Intrinsics.checkParameterIsNotNull(this, "$this$commonWrite");
        Intrinsics.checkParameterIsNotNull(fVar, "buffer");
        fVar.write(mo29209b(), i, i2);
    }
}
