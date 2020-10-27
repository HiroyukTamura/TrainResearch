package p040i.p103M.p108g;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import p040i.C0976G;
import p040i.C0980J;
import p040i.C1744A;
import p040i.C1752D;
import p040i.C1755F;
import p040i.C1758I;
import p040i.p103M.C1764b;
import p040i.p103M.p107f.C1795c;
import p040i.p103M.p107f.C1799e;
import p040i.p103M.p107f.C1810l;
import p040i.p103M.p110i.C1833a;

/* renamed from: i.M.g.i */
public final class C1823i implements C1744A {

    /* renamed from: a */
    private final C1752D f2438a;

    public C1823i(C1752D d) {
        Intrinsics.checkParameterIsNotNull(d, "client");
        this.f2438a = d;
    }

    /* renamed from: a */
    private final int m2886a(C1758I i, int i2) {
        String a = C1758I.m2561a(i, "Retry-After", (String) null, 2);
        if (a == null) {
            return i2;
        }
        if (!new Regex("\\d+").matches(a)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(a);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "Integer.valueOf(header)");
        return valueOf.intValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r13.mo27694f();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final p040i.C1755F m2887a(p040i.C1758I r12, p040i.p103M.p107f.C1795c r13) throws java.io.IOException {
        /*
            r11 = this;
            r0 = 0
            if (r13 == 0) goto L_0x000e
            i.M.f.i r1 = r13.mo27694f()
            if (r1 == 0) goto L_0x000e
            i.K r1 = r1.mo27762l()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            int r2 = r12.mo27558o()
            i.F r3 = r12.mo27569y()
            java.lang.String r3 = r3.mo27541f()
            r4 = 0
            r5 = 308(0x134, float:4.32E-43)
            r6 = 307(0x133, float:4.3E-43)
            if (r2 == r6) goto L_0x00e1
            if (r2 == r5) goto L_0x00e1
            r7 = 401(0x191, float:5.62E-43)
            if (r2 == r7) goto L_0x00d6
            r7 = 421(0x1a5, float:5.9E-43)
            if (r2 == r7) goto L_0x00af
            r13 = 503(0x1f7, float:7.05E-43)
            if (r2 == r13) goto L_0x0093
            r13 = 407(0x197, float:5.7E-43)
            if (r2 == r13) goto L_0x006f
            r13 = 408(0x198, float:5.72E-43)
            if (r2 == r13) goto L_0x003c
            switch(r2) {
                case 300: goto L_0x00e1;
                case 301: goto L_0x00e1;
                case 302: goto L_0x00e1;
                case 303: goto L_0x00e1;
                default: goto L_0x003b;
            }
        L_0x003b:
            return r0
        L_0x003c:
            i.D r1 = r11.f2438a
            boolean r1 = r1.mo27495z()
            if (r1 != 0) goto L_0x0045
            return r0
        L_0x0045:
            i.F r1 = r12.mo27569y()
            i.G r1 = r1.mo27533a()
            if (r1 == 0) goto L_0x0056
            boolean r1 = r1.isOneShot()
            if (r1 == 0) goto L_0x0056
            return r0
        L_0x0056:
            i.I r1 = r12.mo27566v()
            if (r1 == 0) goto L_0x0063
            int r1 = r1.mo27558o()
            if (r1 != r13) goto L_0x0063
            return r0
        L_0x0063:
            int r13 = r11.m2886a((p040i.C1758I) r12, (int) r4)
            if (r13 <= 0) goto L_0x006a
            return r0
        L_0x006a:
            i.F r12 = r12.mo27569y()
            return r12
        L_0x006f:
            if (r1 != 0) goto L_0x0074
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0074:
            java.net.Proxy r13 = r1.mo27589b()
            java.net.Proxy$Type r13 = r13.type()
            java.net.Proxy$Type r0 = java.net.Proxy.Type.HTTP
            if (r13 != r0) goto L_0x008b
            i.D r13 = r11.f2438a
            i.c r13 = r13.mo27492w()
            i.F r12 = r13.mo27599a(r1, r12)
            return r12
        L_0x008b:
            java.net.ProtocolException r12 = new java.net.ProtocolException
            java.lang.String r13 = "Received HTTP_PROXY_AUTH (407) code while not using proxy"
            r12.<init>(r13)
            throw r12
        L_0x0093:
            i.I r1 = r12.mo27566v()
            if (r1 == 0) goto L_0x00a0
            int r1 = r1.mo27558o()
            if (r1 != r13) goto L_0x00a0
            return r0
        L_0x00a0:
            r13 = 2147483647(0x7fffffff, float:NaN)
            int r13 = r11.m2886a((p040i.C1758I) r12, (int) r13)
            if (r13 != 0) goto L_0x00ae
            i.F r12 = r12.mo27569y()
            return r12
        L_0x00ae:
            return r0
        L_0x00af:
            i.F r1 = r12.mo27569y()
            i.G r1 = r1.mo27533a()
            if (r1 == 0) goto L_0x00c0
            boolean r1 = r1.isOneShot()
            if (r1 == 0) goto L_0x00c0
            return r0
        L_0x00c0:
            if (r13 == 0) goto L_0x00d5
            boolean r1 = r13.mo27697i()
            if (r1 != 0) goto L_0x00c9
            goto L_0x00d5
        L_0x00c9:
            i.M.f.i r13 = r13.mo27694f()
            r13.mo27760j()
            i.F r12 = r12.mo27569y()
            return r12
        L_0x00d5:
            return r0
        L_0x00d6:
            i.D r13 = r11.f2438a
            i.c r13 = r13.mo27468a()
            i.F r12 = r13.mo27599a(r1, r12)
            return r12
        L_0x00e1:
            i.D r13 = r11.f2438a
            boolean r13 = r13.mo27482m()
            if (r13 != 0) goto L_0x00eb
            goto L_0x01a5
        L_0x00eb:
            r13 = 2
            java.lang.String r1 = "Location"
            java.lang.String r13 = p040i.C1758I.m2561a(r12, r1, r0, r13)
            if (r13 == 0) goto L_0x01a5
            i.F r1 = r12.mo27569y()
            i.z r1 = r1.mo27542g()
            if (r1 == 0) goto L_0x01a4
            java.lang.String r2 = "link"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r13, r2)
            i.z$a r13 = r1.mo28131a(r13)
            if (r13 == 0) goto L_0x010e
            i.z r13 = r13.mo28154a()
            goto L_0x010f
        L_0x010e:
            r13 = r0
        L_0x010f:
            if (r13 == 0) goto L_0x01a5
            java.lang.String r1 = r13.mo28146m()
            i.F r2 = r12.mo27569y()
            i.z r2 = r2.mo27542g()
            java.lang.String r2 = r2.mo28146m()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x0131
            i.D r1 = r11.f2438a
            boolean r1 = r1.mo27483n()
            if (r1 != 0) goto L_0x0131
            goto L_0x01a5
        L_0x0131:
            i.F r1 = r12.mo27569y()
            if (r1 == 0) goto L_0x01a3
            i.F$a r2 = new i.F$a
            r2.<init>(r1)
            boolean r1 = p040i.p103M.p108g.C1820f.m2874a(r3)
            if (r1 == 0) goto L_0x0188
            int r1 = r12.mo27558o()
            java.lang.String r7 = "method"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r7)
            java.lang.String r8 = "PROPFIND"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r8)
            r10 = 1
            if (r9 != 0) goto L_0x0158
            if (r1 == r5) goto L_0x0158
            if (r1 != r6) goto L_0x0159
        L_0x0158:
            r4 = 1
        L_0x0159:
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r7)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r8)
            r7 = r7 ^ r10
            if (r7 == 0) goto L_0x016a
            if (r1 == r5) goto L_0x016a
            if (r1 == r6) goto L_0x016a
            java.lang.String r3 = "GET"
            goto L_0x0174
        L_0x016a:
            if (r4 == 0) goto L_0x0174
            i.F r0 = r12.mo27569y()
            i.G r0 = r0.mo27533a()
        L_0x0174:
            r2.mo27549a((java.lang.String) r3, (p040i.C0976G) r0)
            if (r4 != 0) goto L_0x0188
            java.lang.String r0 = "Transfer-Encoding"
            r2.mo27548a((java.lang.String) r0)
            java.lang.String r0 = "Content-Length"
            r2.mo27548a((java.lang.String) r0)
            java.lang.String r0 = "Content-Type"
            r2.mo27548a((java.lang.String) r0)
        L_0x0188:
            i.F r12 = r12.mo27569y()
            i.z r12 = r12.mo27542g()
            boolean r12 = p040i.p103M.C1764b.m2631a((p040i.C1955z) r12, (p040i.C1955z) r13)
            if (r12 != 0) goto L_0x019b
            java.lang.String r12 = "Authorization"
            r2.mo27548a((java.lang.String) r12)
        L_0x019b:
            r2.mo27546a((p040i.C1955z) r13)
            i.F r0 = r2.mo27551a()
            goto L_0x01a5
        L_0x01a3:
            throw r0
        L_0x01a4:
            throw r0
        L_0x01a5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p108g.C1823i.m2887a(i.I, i.M.f.c):i.F");
    }

    public C1758I intercept(C1744A.C1745a aVar) throws IOException {
        IOException e;
        Intrinsics.checkParameterIsNotNull(aVar, "chain");
        C1821g gVar = (C1821g) aVar;
        C1755F f = gVar.mo27794f();
        C1799e b = gVar.mo27790b();
        List emptyList = CollectionsKt__CollectionsKt.emptyList();
        C1758I i = null;
        boolean z = true;
        int i2 = 0;
        while (true) {
            b.mo27713a(f, z);
            try {
                if (!b.isCanceled()) {
                    C1758I a = gVar.mo27450a(f);
                    if (i != null) {
                        if (a != null) {
                            C1758I.C1759a aVar2 = new C1758I.C1759a(a);
                            C1758I.C1759a aVar3 = new C1758I.C1759a(i);
                            aVar3.mo27576a((C0980J) null);
                            aVar2.mo27587c(aVar3.mo27581a());
                            a = aVar2.mo27581a();
                        } else {
                            throw null;
                        }
                    }
                    i = a;
                    C1795c d = b.mo27721d();
                    C1755F a2 = m2887a(i, d);
                    if (a2 == null) {
                        if (d != null && d.mo27698j()) {
                            b.mo27729j();
                        }
                        b.mo27716a(false);
                        return i;
                    }
                    C0976G a3 = a2.mo27533a();
                    if (a3 == null || !a3.isOneShot()) {
                        C0980J d2 = i.mo27554d();
                        if (d2 != null) {
                            C1764b.m2629a((Closeable) d2);
                        }
                        i2++;
                        if (i2 <= 20) {
                            b.mo27716a(true);
                            f = a2;
                            z = true;
                        } else {
                            throw new ProtocolException("Too many follow-up requests: " + i2);
                        }
                    } else {
                        b.mo27716a(false);
                        return i;
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } catch (C1810l e2) {
                if (m2888a(e2.mo27774b(), b, f, false)) {
                    e = e2.mo27772a();
                    emptyList = CollectionsKt___CollectionsKt.plus(emptyList, e);
                    b.mo27716a(true);
                    z = false;
                } else {
                    IOException a4 = e2.mo27772a();
                    C1764b.m2622a((Exception) a4, (List<? extends Exception>) emptyList);
                    throw a4;
                }
            } catch (IOException e3) {
                e = e3;
                if (m2888a(e, b, f, !(e instanceof C1833a))) {
                    emptyList = CollectionsKt___CollectionsKt.plus(emptyList, e);
                    b.mo27716a(true);
                    z = false;
                } else {
                    C1764b.m2622a((Exception) e, (List<? extends Exception>) emptyList);
                    throw e;
                }
            } catch (Throwable th) {
                b.mo27716a(true);
                throw th;
            }
        }
    }

    /* renamed from: a */
    private final boolean m2888a(IOException iOException, C1799e eVar, C1755F f, boolean z) {
        if (!this.f2438a.mo27495z()) {
            return false;
        }
        if (z) {
            C0976G a = f.mo27533a();
            if ((a != null && a.isOneShot()) || (iOException instanceof FileNotFoundException)) {
                return false;
            }
        }
        return (!(iOException instanceof ProtocolException) && (!(iOException instanceof InterruptedIOException) ? (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException) : (iOException instanceof SocketTimeoutException) && !z)) && eVar.mo27727i();
    }
}
