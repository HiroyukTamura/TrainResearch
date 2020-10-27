package p042j;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j.n */
public final class C2078n implements C1016z {

    /* renamed from: a */
    private int f2906a;

    /* renamed from: b */
    private boolean f2907b;

    /* renamed from: c */
    private final C2072h f2908c;

    /* renamed from: d */
    private final Inflater f2909d;

    public C2078n(C2072h hVar, Inflater inflater) {
        Intrinsics.checkParameterIsNotNull(hVar, FirebaseAnalytics.Param.SOURCE);
        Intrinsics.checkParameterIsNotNull(inflater, "inflater");
        this.f2908c = hVar;
        this.f2909d = inflater;
    }

    public void close() throws IOException {
        if (!this.f2907b) {
            this.f2909d.end();
            this.f2907b = true;
            this.f2908c.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long read(p042j.C2068f r10, long r11) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
        L_0x0005:
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r10, r0)
            r1 = 0
            r3 = 1
            int r4 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r4 < 0) goto L_0x0011
            r4 = 1
            goto L_0x0012
        L_0x0011:
            r4 = 0
        L_0x0012:
            if (r4 == 0) goto L_0x00dc
            boolean r4 = r9.f2907b
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x00d0
            int r4 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x001f
            goto L_0x009d
        L_0x001f:
            j.u r3 = r10.mo29147b((int) r3)     // Catch:{ DataFormatException -> 0x00c9 }
            int r4 = r3.f2926c     // Catch:{ DataFormatException -> 0x00c9 }
            int r4 = 8192 - r4
            long r4 = (long) r4     // Catch:{ DataFormatException -> 0x00c9 }
            long r4 = java.lang.Math.min(r11, r4)     // Catch:{ DataFormatException -> 0x00c9 }
            int r5 = (int) r4     // Catch:{ DataFormatException -> 0x00c9 }
            java.util.zip.Inflater r4 = r9.f2909d     // Catch:{ DataFormatException -> 0x00c9 }
            boolean r4 = r4.needsInput()     // Catch:{ DataFormatException -> 0x00c9 }
            if (r4 != 0) goto L_0x0036
            goto L_0x005a
        L_0x0036:
            j.h r4 = r9.f2908c     // Catch:{ DataFormatException -> 0x00c9 }
            boolean r4 = r4.mo29152c()     // Catch:{ DataFormatException -> 0x00c9 }
            if (r4 == 0) goto L_0x003f
            goto L_0x005a
        L_0x003f:
            j.h r4 = r9.f2908c     // Catch:{ DataFormatException -> 0x00c9 }
            j.f r4 = r4.getBuffer()     // Catch:{ DataFormatException -> 0x00c9 }
            j.u r4 = r4.f2890a     // Catch:{ DataFormatException -> 0x00c9 }
            if (r4 != 0) goto L_0x004c
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch:{ DataFormatException -> 0x00c9 }
        L_0x004c:
            int r6 = r4.f2926c     // Catch:{ DataFormatException -> 0x00c9 }
            int r7 = r4.f2925b     // Catch:{ DataFormatException -> 0x00c9 }
            int r6 = r6 - r7
            r9.f2906a = r6     // Catch:{ DataFormatException -> 0x00c9 }
            java.util.zip.Inflater r8 = r9.f2909d     // Catch:{ DataFormatException -> 0x00c9 }
            byte[] r4 = r4.f2924a     // Catch:{ DataFormatException -> 0x00c9 }
            r8.setInput(r4, r7, r6)     // Catch:{ DataFormatException -> 0x00c9 }
        L_0x005a:
            java.util.zip.Inflater r4 = r9.f2909d     // Catch:{ DataFormatException -> 0x00c9 }
            byte[] r6 = r3.f2924a     // Catch:{ DataFormatException -> 0x00c9 }
            int r7 = r3.f2926c     // Catch:{ DataFormatException -> 0x00c9 }
            int r4 = r4.inflate(r6, r7, r5)     // Catch:{ DataFormatException -> 0x00c9 }
            int r5 = r9.f2906a     // Catch:{ DataFormatException -> 0x00c9 }
            if (r5 != 0) goto L_0x0069
            goto L_0x007b
        L_0x0069:
            java.util.zip.Inflater r6 = r9.f2909d     // Catch:{ DataFormatException -> 0x00c9 }
            int r6 = r6.getRemaining()     // Catch:{ DataFormatException -> 0x00c9 }
            int r5 = r5 - r6
            int r6 = r9.f2906a     // Catch:{ DataFormatException -> 0x00c9 }
            int r6 = r6 - r5
            r9.f2906a = r6     // Catch:{ DataFormatException -> 0x00c9 }
            j.h r6 = r9.f2908c     // Catch:{ DataFormatException -> 0x00c9 }
            long r7 = (long) r5     // Catch:{ DataFormatException -> 0x00c9 }
            r6.skip(r7)     // Catch:{ DataFormatException -> 0x00c9 }
        L_0x007b:
            if (r4 <= 0) goto L_0x008c
            int r5 = r3.f2926c     // Catch:{ DataFormatException -> 0x00c9 }
            int r5 = r5 + r4
            r3.f2926c = r5     // Catch:{ DataFormatException -> 0x00c9 }
            long r5 = r10.size()     // Catch:{ DataFormatException -> 0x00c9 }
            long r3 = (long) r4     // Catch:{ DataFormatException -> 0x00c9 }
            long r5 = r5 + r3
            r10.mo29170j(r5)     // Catch:{ DataFormatException -> 0x00c9 }
            goto L_0x009e
        L_0x008c:
            int r4 = r3.f2925b     // Catch:{ DataFormatException -> 0x00c9 }
            int r5 = r3.f2926c     // Catch:{ DataFormatException -> 0x00c9 }
            if (r4 != r5) goto L_0x009d
            j.u r4 = r3.mo29248a()     // Catch:{ DataFormatException -> 0x00c9 }
            r10.f2890a = r4     // Catch:{ DataFormatException -> 0x00c9 }
            j.v r4 = p042j.C2088v.f2933c     // Catch:{ DataFormatException -> 0x00c9 }
            r4.mo29253a(r3)     // Catch:{ DataFormatException -> 0x00c9 }
        L_0x009d:
            r3 = r1
        L_0x009e:
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 <= 0) goto L_0x00a3
            return r3
        L_0x00a3:
            java.util.zip.Inflater r1 = r9.f2909d
            boolean r1 = r1.finished()
            if (r1 != 0) goto L_0x00c6
            java.util.zip.Inflater r1 = r9.f2909d
            boolean r1 = r1.needsDictionary()
            if (r1 == 0) goto L_0x00b4
            goto L_0x00c6
        L_0x00b4:
            j.h r1 = r9.f2908c
            boolean r1 = r1.mo29152c()
            if (r1 != 0) goto L_0x00be
            goto L_0x0005
        L_0x00be:
            java.io.EOFException r10 = new java.io.EOFException
            java.lang.String r11 = "source exhausted prematurely"
            r10.<init>(r11)
            throw r10
        L_0x00c6:
            r10 = -1
            return r10
        L_0x00c9:
            r10 = move-exception
            java.io.IOException r11 = new java.io.IOException
            r11.<init>(r10)
            throw r11
        L_0x00d0:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "closed"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L_0x00dc:
            java.lang.String r10 = "byteCount < 0: "
            java.lang.String r10 = p009e.p010a.p011a.p012a.C0681a.m318a((java.lang.String) r10, (long) r11)
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            goto L_0x00ed
        L_0x00ec:
            throw r11
        L_0x00ed:
            goto L_0x00ec
        */
        throw new UnsupportedOperationException("Method not decompiled: p042j.C2078n.read(j.f, long):long");
    }

    public C2057A timeout() {
        return this.f2908c.timeout();
    }
}
