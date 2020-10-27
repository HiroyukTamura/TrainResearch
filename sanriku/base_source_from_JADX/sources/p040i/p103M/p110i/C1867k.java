package p040i.p103M.p110i;

import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p040i.p103M.C1764b;
import p041io.realm.internal.Table;
import p042j.C2071g;
import p042j.C2072h;
import p042j.C2073i;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo21739d2 = {"Lokhttp3/internal/http2/Huffman;", "", "()V", "CODES", "", "CODE_BIT_COUNTS", "", "root", "Lokhttp3/internal/http2/Huffman$Node;", "addCode", "", "symbol", "", "code", "codeBitCount", "decode", "source", "Lokio/BufferedSource;", "byteCount", "", "sink", "Lokio/BufferedSink;", "encode", "Lokio/ByteString;", "encodedLength", "bytes", "Node", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.M.i.k */
public final class C1867k {

    /* renamed from: a */
    private static final int[] f2639a = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, Table.MAX_STRING_SIZE, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, Table.MAX_BINARY_SIZE, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: b */
    private static final byte[] f2640b = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};

    /* renamed from: c */
    private static final C1868a f2641c = new C1868a();

    /* renamed from: d */
    public static final C1867k f2642d;

    /* renamed from: i.M.i.k$a */
    private static final class C1868a {

        /* renamed from: a */
        private final C1868a[] f2643a;

        /* renamed from: b */
        private final int f2644b;

        /* renamed from: c */
        private final int f2645c;

        public C1868a() {
            this.f2643a = new C1868a[256];
            this.f2644b = 0;
            this.f2645c = 0;
        }

        public C1868a(int i, int i2) {
            this.f2643a = null;
            this.f2644b = i;
            int i3 = i2 & 7;
            this.f2645c = i3 == 0 ? 8 : i3;
        }

        /* renamed from: a */
        public final C1868a[] mo27938a() {
            return this.f2643a;
        }

        /* renamed from: b */
        public final int mo27939b() {
            return this.f2644b;
        }

        /* renamed from: c */
        public final int mo27940c() {
            return this.f2645c;
        }
    }

    static {
        C1867k kVar = new C1867k();
        f2642d = kVar;
        int length = f2640b.length;
        for (int i = 0; i < length; i++) {
            kVar.m3112a(i, f2639a[i], (int) f2640b[i]);
        }
    }

    private C1867k() {
    }

    /* renamed from: a */
    private final void m3112a(int i, int i2, int i3) {
        C1868a aVar = new C1868a(i, i3);
        C1868a aVar2 = f2641c;
        while (i3 > 8) {
            i3 -= 8;
            int i4 = (i2 >>> i3) & 255;
            C1868a[] a = aVar2.mo27938a();
            if (a == null) {
                Intrinsics.throwNpe();
            }
            C1868a aVar3 = a[i4];
            if (aVar3 == null) {
                aVar3 = new C1868a();
                a[i4] = aVar3;
            }
            aVar2 = aVar3;
        }
        int i5 = 8 - i3;
        int i6 = (i2 << i5) & 255;
        int i7 = 1 << i5;
        C1868a[] a2 = aVar2.mo27938a();
        if (a2 == null) {
            Intrinsics.throwNpe();
        }
        ArraysKt___ArraysJvmKt.fill((T[]) a2, aVar, i6, i7 + i6);
    }

    /* renamed from: a */
    public final void mo27936a(C2072h hVar, long j, C2071g gVar) {
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        Intrinsics.checkParameterIsNotNull(gVar, "sink");
        C1868a aVar = f2641c;
        int i = 0;
        int i2 = 0;
        for (long j2 = 0; j2 < j; j2++) {
            i = (i << 8) | C1764b.m2604a(hVar.readByte(), 255);
            i2 += 8;
            while (i2 >= 8) {
                int i3 = i2 - 8;
                int i4 = (i >>> i3) & 255;
                C1868a[] a = aVar.mo27938a();
                if (a == null) {
                    Intrinsics.throwNpe();
                }
                aVar = a[i4];
                if (aVar == null) {
                    Intrinsics.throwNpe();
                }
                if (aVar.mo27938a() == null) {
                    gVar.writeByte(aVar.mo27939b());
                    i2 -= aVar.mo27940c();
                    aVar = f2641c;
                } else {
                    i2 = i3;
                }
            }
        }
        while (i2 > 0) {
            int i5 = (i << (8 - i2)) & 255;
            C1868a[] a2 = aVar.mo27938a();
            if (a2 == null) {
                Intrinsics.throwNpe();
            }
            C1868a aVar2 = a2[i5];
            if (aVar2 == null) {
                Intrinsics.throwNpe();
            }
            if (aVar2.mo27938a() == null && aVar2.mo27940c() <= i2) {
                gVar.writeByte(aVar2.mo27939b());
                i2 -= aVar2.mo27940c();
                aVar = f2641c;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo27937a(p042j.C2073i r10, p042j.C2071g r11) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            int r0 = r10.mo29212d()
            r1 = 0
            r2 = 0
            r3 = r2
            r2 = 0
        L_0x0013:
            r5 = 8
            if (r1 >= r0) goto L_0x003b
            byte r6 = r10.mo29201a((int) r1)
            r7 = 255(0xff, float:3.57E-43)
            int r6 = p040i.p103M.C1764b.m2604a((byte) r6, (int) r7)
            int[] r7 = f2639a
            r7 = r7[r6]
            byte[] r8 = f2640b
            byte r6 = r8[r6]
            long r3 = r3 << r6
            long r7 = (long) r7
            long r3 = r3 | r7
            int r2 = r2 + r6
        L_0x002d:
            if (r2 < r5) goto L_0x0038
            int r2 = r2 + -8
            long r6 = r3 >> r2
            int r7 = (int) r6
            r11.writeByte(r7)
            goto L_0x002d
        L_0x0038:
            int r1 = r1 + 1
            goto L_0x0013
        L_0x003b:
            if (r2 <= 0) goto L_0x0049
            int r5 = r5 - r2
            long r0 = r3 << r5
            r3 = 255(0xff, double:1.26E-321)
            long r2 = r3 >>> r2
            long r0 = r0 | r2
            int r10 = (int) r0
            r11.writeByte(r10)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p110i.C1867k.mo27937a(j.i, j.g):void");
    }

    /* renamed from: a */
    public final int mo27935a(C2073i iVar) {
        Intrinsics.checkParameterIsNotNull(iVar, "bytes");
        int d = iVar.mo29212d();
        long j = 0;
        for (int i = 0; i < d; i++) {
            j += (long) f2640b[C1764b.m2604a(iVar.mo29201a(i), 255)];
        }
        return (int) ((j + ((long) 7)) >> 3);
    }
}
