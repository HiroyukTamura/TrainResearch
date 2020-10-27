package p042j;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: j.m */
public final class C2077m implements C1016z {

    /* renamed from: a */
    private byte f2901a;

    /* renamed from: b */
    private final C2085t f2902b;

    /* renamed from: c */
    private final Inflater f2903c;

    /* renamed from: d */
    private final C2078n f2904d;

    /* renamed from: e */
    private final CRC32 f2905e = new CRC32();

    public C2077m(C1016z zVar) {
        Intrinsics.checkParameterIsNotNull(zVar, FirebaseAnalytics.Param.SOURCE);
        this.f2902b = new C2085t(zVar);
        Inflater inflater = new Inflater(true);
        this.f2903c = inflater;
        this.f2904d = new C2078n(this.f2902b, inflater);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x001a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0012  */
    /* renamed from: a */
    private final void m3575a(p042j.C2068f r6, long r7, long r9) {
        /*
            r5 = this;
            j.u r6 = r6.f2890a
            if (r6 != 0) goto L_0x0007
        L_0x0004:
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0007:
            int r0 = r6.f2926c
            int r1 = r6.f2925b
            int r2 = r0 - r1
            long r2 = (long) r2
            int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x001a
            int r0 = r0 - r1
            long r0 = (long) r0
            long r7 = r7 - r0
            j.u r6 = r6.f2929f
            if (r6 != 0) goto L_0x0007
            goto L_0x0004
        L_0x001a:
            r0 = 0
        L_0x001c:
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0040
            int r2 = r6.f2925b
            long r2 = (long) r2
            long r2 = r2 + r7
            int r7 = (int) r2
            int r8 = r6.f2926c
            int r8 = r8 - r7
            long r2 = (long) r8
            long r2 = java.lang.Math.min(r2, r9)
            int r8 = (int) r2
            java.util.zip.CRC32 r2 = r5.f2905e
            byte[] r3 = r6.f2924a
            r2.update(r3, r7, r8)
            long r7 = (long) r8
            long r9 = r9 - r7
            j.u r6 = r6.f2929f
            if (r6 != 0) goto L_0x003e
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x003e:
            r7 = r0
            goto L_0x001c
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p042j.C2077m.m3575a(j.f, long, long):void");
    }

    /* renamed from: a */
    private final void m3576a(String str, int i, int i2) {
        if (i2 != i) {
            throw new IOException(C0681a.m328a(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3, "%s: actual 0x%08x != expected 0x%08x", "java.lang.String.format(this, *args)"));
        }
    }

    public void close() throws IOException {
        this.f2904d.close();
    }

    public long read(C2068f fVar, long j) throws IOException {
        long j2;
        C2068f fVar2 = fVar;
        long j3 = j;
        Intrinsics.checkParameterIsNotNull(fVar2, "sink");
        boolean z = false;
        if (!(j3 >= 0)) {
            throw new IllegalArgumentException(C0681a.m318a("byteCount < 0: ", j3).toString());
        } else if (j3 == 0) {
            return 0;
        } else {
            if (this.f2901a == 0) {
                this.f2902b.mo29159f(10);
                byte h = this.f2902b.f2920a.mo29163h(3);
                boolean z2 = ((h >> 1) & 1) == 1;
                if (z2) {
                    m3575a(this.f2902b.f2920a, 0, 10);
                }
                C2085t tVar = this.f2902b;
                tVar.mo29159f(2);
                m3576a("ID1ID2", 8075, (int) tVar.f2920a.readShort());
                this.f2902b.skip(8);
                if (((h >> 2) & 1) == 1) {
                    this.f2902b.mo29159f(2);
                    if (z2) {
                        m3575a(this.f2902b.f2920a, 0, 2);
                    }
                    long l = (long) this.f2902b.f2920a.mo29172l();
                    this.f2902b.mo29159f(l);
                    if (z2) {
                        j2 = l;
                        m3575a(this.f2902b.f2920a, 0, l);
                    } else {
                        j2 = l;
                    }
                    this.f2902b.skip(j2);
                }
                if (((h >> 3) & 1) == 1) {
                    long a = this.f2902b.mo29238a((byte) 0, 0, LongCompanionObject.MAX_VALUE);
                    if (a != -1) {
                        if (z2) {
                            m3575a(this.f2902b.f2920a, 0, a + 1);
                        }
                        this.f2902b.skip(a + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (((h >> 4) & 1) == 1) {
                    z = true;
                }
                if (z) {
                    long a2 = this.f2902b.mo29238a((byte) 0, 0, LongCompanionObject.MAX_VALUE);
                    if (a2 != -1) {
                        if (z2) {
                            m3575a(this.f2902b.f2920a, 0, a2 + 1);
                        }
                        this.f2902b.skip(a2 + 1);
                    } else {
                        throw new EOFException();
                    }
                }
                if (z2) {
                    C2085t tVar2 = this.f2902b;
                    tVar2.mo29159f(2);
                    m3576a("FHCRC", (int) tVar2.f2920a.mo29172l(), (int) (short) ((int) this.f2905e.getValue()));
                    this.f2905e.reset();
                }
                this.f2901a = 1;
            }
            if (this.f2901a == 1) {
                long size = fVar.size();
                long read = this.f2904d.read(fVar2, j3);
                if (read != -1) {
                    m3575a(fVar, size, read);
                    return read;
                }
                this.f2901a = 2;
            }
            if (this.f2901a == 2) {
                m3576a("CRC", this.f2902b.mo29239d(), (int) this.f2905e.getValue());
                m3576a("ISIZE", this.f2902b.mo29239d(), (int) this.f2903c.getBytesWritten());
                this.f2901a = 3;
                if (!this.f2902b.mo29152c()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public C2057A timeout() {
        return this.f2902b.timeout();
    }
}
