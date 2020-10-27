package p040i.p103M.p115m;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: i.M.m.d */
public final class C1907d implements HostnameVerifier {

    /* renamed from: a */
    public static final C1907d f2701a = new C1907d();

    private C1907d() {
    }

    /* renamed from: a */
    private final List<String> m3246a(X509Certificate x509Certificate, int i) {
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (List next : subjectAlternativeNames) {
                if (next != null) {
                    if (next.size() >= 2) {
                        if (!(!Intrinsics.areEqual(next.get(0), (Object) Integer.valueOf(i)))) {
                            Object obj = next.get(1);
                            if (obj != null) {
                                arrayList.add((String) obj);
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }

    /* renamed from: a */
    public final List<String> mo28002a(X509Certificate x509Certificate) {
        Intrinsics.checkParameterIsNotNull(x509Certificate, "certificate");
        return CollectionsKt___CollectionsKt.plus(m3246a(x509Certificate, 7), m3246a(x509Certificate, 2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0151 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo28003a(java.lang.String r21, java.security.cert.X509Certificate r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "host"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r3)
            java.lang.String r3 = "certificate"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r3)
            boolean r3 = p040i.p103M.C1764b.m2633a((java.lang.String) r21)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0049
            java.lang.String r1 = p040i.p103M.C1763a.m2602a(r21)
            r3 = 7
            java.util.List r2 = r0.m3246a((java.security.cert.X509Certificate) r2, (int) r3)
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L_0x002d
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x002d
            goto L_0x0150
        L_0x002d:
            java.util.Iterator r2 = r2.iterator()
        L_0x0031:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0150
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = p040i.p103M.C1763a.m2602a(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0031
            goto L_0x0151
        L_0x0049:
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r6 = "Locale.US"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r6)
            java.lang.String r7 = "null cannot be cast to non-null type java.lang.String"
            if (r1 == 0) goto L_0x0152
            java.lang.String r1 = r1.toLowerCase(r3)
            java.lang.String r3 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            r8 = 2
            java.util.List r2 = r0.m3246a((java.security.cert.X509Certificate) r2, (int) r8)
            boolean r9 = r2 instanceof java.util.Collection
            if (r9 == 0) goto L_0x006e
            boolean r9 = r2.isEmpty()
            if (r9 == 0) goto L_0x006e
            goto L_0x0150
        L_0x006e:
            java.util.Iterator r2 = r2.iterator()
        L_0x0072:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x0150
            java.lang.Object r9 = r2.next()
            java.lang.String r9 = (java.lang.String) r9
            int r10 = r1.length()
            if (r10 != 0) goto L_0x0086
            r10 = 1
            goto L_0x0087
        L_0x0086:
            r10 = 0
        L_0x0087:
            if (r10 != 0) goto L_0x014c
            java.lang.String r10 = "."
            r11 = 0
            boolean r12 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r1, r10, r5, r8, r11)
            if (r12 != 0) goto L_0x014c
            java.lang.String r12 = ".."
            boolean r13 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r1, r12, r5, r8, r11)
            if (r13 == 0) goto L_0x009c
            goto L_0x014c
        L_0x009c:
            if (r9 == 0) goto L_0x00a7
            int r13 = r9.length()
            if (r13 != 0) goto L_0x00a5
            goto L_0x00a7
        L_0x00a5:
            r13 = 0
            goto L_0x00a8
        L_0x00a7:
            r13 = 1
        L_0x00a8:
            if (r13 != 0) goto L_0x014c
            boolean r13 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r9, r10, r5, r8, r11)
            if (r13 != 0) goto L_0x014c
            boolean r12 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r9, r12, r5, r8, r11)
            if (r12 == 0) goto L_0x00b8
            goto L_0x014c
        L_0x00b8:
            boolean r12 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r1, r10, r5, r8, r11)
            if (r12 != 0) goto L_0x00c4
            java.lang.String r12 = p009e.p010a.p011a.p012a.C0681a.m320a((java.lang.String) r1, (java.lang.String) r10)
            r13 = r12
            goto L_0x00c5
        L_0x00c4:
            r13 = r1
        L_0x00c5:
            boolean r12 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r9, r10, r5, r8, r11)
            if (r12 != 0) goto L_0x00cf
            java.lang.String r9 = p009e.p010a.p011a.p012a.C0681a.m320a((java.lang.String) r9, (java.lang.String) r10)
        L_0x00cf:
            java.util.Locale r10 = java.util.Locale.US
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r6)
            if (r9 == 0) goto L_0x0146
            java.lang.String r9 = r9.toLowerCase(r10)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r3)
            java.lang.String r10 = "*"
            boolean r10 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r9, (java.lang.CharSequence) r10, (boolean) r5, (int) r8, (java.lang.Object) r11)
            if (r10 != 0) goto L_0x00ea
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r9)
            goto L_0x014d
        L_0x00ea:
            java.lang.String r10 = "*."
            boolean r12 = kotlin.text.StringsKt__StringsJVMKt.startsWith$default(r9, r10, r5, r8, r11)
            if (r12 == 0) goto L_0x014c
            r15 = 42
            r16 = 1
            r17 = 0
            r18 = 4
            r19 = 0
            r14 = r9
            int r12 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r14, (char) r15, (int) r16, (boolean) r17, (int) r18, (java.lang.Object) r19)
            r14 = -1
            if (r12 == r14) goto L_0x0105
            goto L_0x014c
        L_0x0105:
            int r12 = r13.length()
            int r14 = r9.length()
            if (r12 >= r14) goto L_0x0110
            goto L_0x014c
        L_0x0110:
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r9)
            if (r10 == 0) goto L_0x0117
            goto L_0x014c
        L_0x0117:
            java.lang.String r9 = r9.substring(r4)
            java.lang.String r10 = "(this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r10)
            boolean r10 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r13, r9, r5, r8, r11)
            if (r10 != 0) goto L_0x0127
            goto L_0x014c
        L_0x0127:
            int r10 = r13.length()
            int r9 = r9.length()
            int r10 = r10 - r9
            if (r10 <= 0) goto L_0x0144
            r14 = 46
            int r15 = r10 + -1
            r16 = 0
            r17 = 4
            r18 = 0
            r9 = -1
            int r10 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r13, (char) r14, (int) r15, (boolean) r16, (int) r17, (java.lang.Object) r18)
            if (r10 == r9) goto L_0x0144
            goto L_0x014c
        L_0x0144:
            r9 = 1
            goto L_0x014d
        L_0x0146:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            r1.<init>(r7)
            throw r1
        L_0x014c:
            r9 = 0
        L_0x014d:
            if (r9 == 0) goto L_0x0072
            goto L_0x0151
        L_0x0150:
            r4 = 0
        L_0x0151:
            return r4
        L_0x0152:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            r1.<init>(r7)
            goto L_0x0159
        L_0x0158:
            throw r1
        L_0x0159:
            goto L_0x0158
        */
        throw new UnsupportedOperationException("Method not decompiled: p040i.p103M.p115m.C1907d.mo28003a(java.lang.String, java.security.cert.X509Certificate):boolean");
    }

    public boolean verify(String str, SSLSession sSLSession) {
        Intrinsics.checkParameterIsNotNull(str, "host");
        Intrinsics.checkParameterIsNotNull(sSLSession, "session");
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate != null) {
                return mo28003a(str, (X509Certificate) certificate);
            }
            throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
