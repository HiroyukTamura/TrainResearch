package p040i;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.p115m.C1906c;
import p042j.C2073i;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B!\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011H\u0000¢\u0006\u0002\b\u0014J)\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u0016\"\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0012J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, mo21739d2 = {"Lokhttp3/CertificatePinner;", "", "pins", "", "Lokhttp3/CertificatePinner$Pin;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "getPins", "()Ljava/util/Set;", "check", "", "hostname", "", "cleanedPeerCertificatesFn", "Lkotlin/Function0;", "", "Ljava/security/cert/X509Certificate;", "check$okhttp", "peerCertificates", "", "Ljava/security/cert/Certificate;", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "equals", "", "other", "findMatchingPins", "hashCode", "", "withCertificateChainCleaner", "withCertificateChainCleaner$okhttp", "Builder", "Companion", "Pin", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.h */
public final class C1926h {
    @JvmField

    /* renamed from: c */
    public static final C1926h f2770c = new C1927a().mo28063a();

    /* renamed from: d */
    public static final C1926h f2771d = null;

    /* renamed from: a */
    private final Set<C1928b> f2772a;

    /* renamed from: b */
    private final C1906c f2773b;

    /* renamed from: i.h$a */
    public static final class C1927a {

        /* renamed from: a */
        private final List<C1928b> f2774a = new ArrayList();

        /* renamed from: a */
        public final C1926h mo28063a() {
            return new C1926h(CollectionsKt___CollectionsKt.toSet(this.f2774a), (C1906c) null, 2);
        }
    }

    /* renamed from: i.h$b */
    public static final class C1928b {

        /* renamed from: a */
        private final String f2775a;

        /* renamed from: b */
        private final String f2776b;

        /* renamed from: c */
        private final C2073i f2777c;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C1928b)) {
                return false;
            }
            C1928b bVar = (C1928b) obj;
            return !(Intrinsics.areEqual((Object) null, (Object) bVar.f2775a) ^ true) && !(Intrinsics.areEqual((Object) null, (Object) bVar.f2776b) ^ true) && !(Intrinsics.areEqual((Object) null, (Object) bVar.f2777c) ^ true);
        }

        public int hashCode() {
            throw null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append((String) null);
            sb.append('/');
            throw null;
        }
    }

    /* renamed from: i.h$c */
    static final class C1929c extends Lambda implements Function0<List<? extends X509Certificate>> {

        /* renamed from: a */
        final /* synthetic */ C1926h f2778a;

        /* renamed from: b */
        final /* synthetic */ List f2779b;

        /* renamed from: c */
        final /* synthetic */ String f2780c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1929c(C1926h hVar, List list, String str) {
            super(0);
            this.f2778a = hVar;
            this.f2779b = list;
            this.f2780c = str;
        }

        public Object invoke() {
            List<Certificate> list;
            C1906c a = this.f2778a.mo28057a();
            if (a == null || (list = a.mo27991a(this.f2779b, this.f2780c)) == null) {
                list = this.f2779b;
            }
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (Certificate certificate : list) {
                if (certificate != null) {
                    arrayList.add((X509Certificate) certificate);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
            }
            return arrayList;
        }
    }

    public C1926h(Set<C1928b> set, C1906c cVar) {
        Intrinsics.checkParameterIsNotNull(set, "pins");
        this.f2772a = set;
        this.f2773b = cVar;
    }

    public /* synthetic */ C1926h(Set set, C1906c cVar, int i) {
        cVar = (i & 2) != 0 ? null : cVar;
        Intrinsics.checkParameterIsNotNull(set, "pins");
        this.f2772a = set;
        this.f2773b = cVar;
    }

    @JvmStatic
    /* renamed from: a */
    public static final String m3313a(Certificate certificate) {
        Intrinsics.checkParameterIsNotNull(certificate, "certificate");
        if (certificate instanceof X509Certificate) {
            StringBuilder a = C0681a.m330a("sha256/");
            a.append(m3312a((X509Certificate) certificate).mo29203a());
            return a.toString();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
    }

    /* renamed from: a */
    public final C1906c mo28057a() {
        return this.f2773b;
    }

    /* renamed from: a */
    public final C1926h mo28058a(C1906c cVar) {
        Intrinsics.checkParameterIsNotNull(cVar, "certificateChainCleaner");
        return Intrinsics.areEqual((Object) this.f2773b, (Object) cVar) ? this : new C1926h(this.f2772a, cVar);
    }

    /* renamed from: a */
    public final void mo28059a(String str, List<? extends Certificate> list) throws SSLPeerUnverifiedException {
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        Intrinsics.checkParameterIsNotNull(list, "peerCertificates");
        mo28060a(str, (Function0<? extends List<? extends X509Certificate>>) new C1929c(this, list, str));
    }

    /* renamed from: a */
    public final void mo28060a(String str, Function0<? extends List<? extends X509Certificate>> function0) {
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        Intrinsics.checkParameterIsNotNull(function0, "cleanedPeerCertificatesFn");
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        Set<C1928b> set = this.f2772a;
        List<C1928b> emptyList = CollectionsKt__CollectionsKt.emptyList();
        for (T next : set) {
            if (((C1928b) next) != null) {
                Intrinsics.checkParameterIsNotNull(str, "hostname");
                if (StringsKt__StringsJVMKt.startsWith$default((String) null, "**.", false, 2, (Object) null)) {
                    throw null;
                } else if (StringsKt__StringsJVMKt.startsWith$default((String) null, "*.", false, 2, (Object) null)) {
                    throw null;
                } else if (Intrinsics.areEqual((Object) str, (Object) null)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    TypeIntrinsics.asMutableList(emptyList).add(next);
                }
            } else {
                throw null;
            }
        }
        if (!emptyList.isEmpty()) {
            List<X509Certificate> list = (List) function0.invoke();
            for (X509Certificate x509Certificate : list) {
                Iterator it = emptyList.iterator();
                if (it.hasNext()) {
                    if (((C1928b) it.next()) != null) {
                        throw null;
                    }
                    throw null;
                }
            }
            StringBuilder c = C0681a.m340c("Certificate pinning failure!", "\n  Peer certificate chain:");
            for (X509Certificate x509Certificate2 : list) {
                c.append("\n    ");
                c.append(m3313a((Certificate) x509Certificate2));
                c.append(": ");
                Principal subjectDN = x509Certificate2.getSubjectDN();
                Intrinsics.checkExpressionValueIsNotNull(subjectDN, "element.subjectDN");
                c.append(subjectDN.getName());
            }
            c.append("\n  Pinned certificates for ");
            c.append(str);
            c.append(":");
            for (C1928b append : emptyList) {
                c.append("\n    ");
                c.append(append);
            }
            String sb = c.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb, "StringBuilder().apply(builderAction).toString()");
            throw new SSLPeerUnverifiedException(sb);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1926h) {
            C1926h hVar = (C1926h) obj;
            return Intrinsics.areEqual((Object) hVar.f2772a, (Object) this.f2772a) && Intrinsics.areEqual((Object) hVar.f2773b, (Object) this.f2773b);
        }
    }

    public int hashCode() {
        int hashCode = (this.f2772a.hashCode() + 1517) * 41;
        C1906c cVar = this.f2773b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    @JvmStatic
    /* renamed from: a */
    public static final C2073i m3312a(X509Certificate x509Certificate) {
        Intrinsics.checkParameterIsNotNull(x509Certificate, "$this$sha256Hash");
        C2073i.C2074a aVar = C2073i.f2895e;
        PublicKey publicKey = x509Certificate.getPublicKey();
        Intrinsics.checkExpressionValueIsNotNull(publicKey, "publicKey");
        byte[] encoded = publicKey.getEncoded();
        Intrinsics.checkExpressionValueIsNotNull(encoded, "publicKey.encoded");
        return C2073i.C2074a.m3561a(aVar, encoded, 0, 0, 3).mo29202a("SHA-256");
    }
}
