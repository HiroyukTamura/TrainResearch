package p040i;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.p103M.C1764b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 &2\u00020\u0001:\u0001&B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b!J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¢\u0006\u0002\b\"J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\b#J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\u0017H\u0016R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078GX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u000f8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, mo21739d2 = {"Lokhttp3/Handshake;", "", "tlsVersion", "Lokhttp3/TlsVersion;", "cipherSuite", "Lokhttp3/CipherSuite;", "localCertificates", "", "Ljava/security/cert/Certificate;", "peerCertificatesFn", "Lkotlin/Function0;", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "()Lokhttp3/CipherSuite;", "()Ljava/util/List;", "localPrincipal", "Ljava/security/Principal;", "()Ljava/security/Principal;", "peerCertificates", "peerCertificates$delegate", "Lkotlin/Lazy;", "peerPrincipal", "()Lokhttp3/TlsVersion;", "name", "", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "-deprecated_cipherSuite", "equals", "", "other", "hashCode", "", "-deprecated_localCertificates", "-deprecated_localPrincipal", "-deprecated_peerCertificates", "-deprecated_peerPrincipal", "-deprecated_tlsVersion", "toString", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.x */
public final class C1950x {

    /* renamed from: a */
    private final Lazy f2843a;

    /* renamed from: b */
    private final C1761L f2844b;

    /* renamed from: c */
    private final C1931j f2845c;

    /* renamed from: d */
    private final List<Certificate> f2846d;

    /* renamed from: i.x$a */
    static final class C1951a extends Lambda implements Function0<List<? extends Certificate>> {

        /* renamed from: a */
        final /* synthetic */ Function0 f2847a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1951a(Function0 function0) {
            super(0);
            this.f2847a = function0;
        }

        public Object invoke() {
            try {
                return (List) this.f2847a.invoke();
            } catch (SSLPeerUnverifiedException unused) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
        }
    }

    public C1950x(C1761L l, C1931j jVar, List<? extends Certificate> list, Function0<? extends List<? extends Certificate>> function0) {
        Intrinsics.checkParameterIsNotNull(l, "tlsVersion");
        Intrinsics.checkParameterIsNotNull(jVar, "cipherSuite");
        Intrinsics.checkParameterIsNotNull(list, "localCertificates");
        Intrinsics.checkParameterIsNotNull(function0, "peerCertificatesFn");
        this.f2844b = l;
        this.f2845c = jVar;
        this.f2846d = list;
        this.f2843a = LazyKt__LazyJVMKt.lazy(new C1951a(function0));
    }

    @JvmStatic
    @JvmName(name = "get")
    /* renamed from: a */
    public static final C1950x m3363a(SSLSession sSLSession) throws IOException {
        List<Certificate> list;
        Intrinsics.checkParameterIsNotNull(sSLSession, "$this$handshake");
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            int hashCode = cipherSuite.hashCode();
            if (hashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : hashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException(C0681a.m320a("cipherSuite == ", cipherSuite));
            }
            C1931j a = C1931j.f2801t.mo28076a(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            } else if (!Intrinsics.areEqual((Object) "NONE", (Object) protocol)) {
                C1761L a2 = C1761L.f2211g.mo27596a(protocol);
                try {
                    list = m3365a(sSLSession.getPeerCertificates());
                } catch (SSLPeerUnverifiedException unused) {
                    list = CollectionsKt__CollectionsKt.emptyList();
                }
                return new C1950x(a2, a, m3365a(sSLSession.getLocalCertificates()), new C1949w(list));
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IllegalStateException("cipherSuite == null".toString());
        }
    }

    /* renamed from: a */
    private final String m3364a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        Intrinsics.checkExpressionValueIsNotNull(type, "type");
        return type;
    }

    /* renamed from: a */
    private static final List<Certificate> m3365a(Certificate[] certificateArr) {
        return certificateArr != null ? C1764b.m2624a((T[]) (Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : CollectionsKt__CollectionsKt.emptyList();
    }

    @JvmName(name = "cipherSuite")
    /* renamed from: a */
    public final C1931j mo28105a() {
        return this.f2845c;
    }

    @JvmName(name = "localCertificates")
    /* renamed from: b */
    public final List<Certificate> mo28106b() {
        return this.f2846d;
    }

    @JvmName(name = "peerCertificates")
    /* renamed from: c */
    public final List<Certificate> mo28107c() {
        return (List) this.f2843a.getValue();
    }

    @JvmName(name = "tlsVersion")
    /* renamed from: d */
    public final C1761L mo28108d() {
        return this.f2844b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1950x) {
            C1950x xVar = (C1950x) obj;
            return xVar.f2844b == this.f2844b && Intrinsics.areEqual((Object) xVar.f2845c, (Object) this.f2845c) && Intrinsics.areEqual((Object) xVar.mo28107c(), (Object) mo28107c()) && Intrinsics.areEqual((Object) xVar.f2846d, (Object) this.f2846d);
        }
    }

    public int hashCode() {
        int hashCode = this.f2845c.hashCode();
        int hashCode2 = mo28107c().hashCode();
        return this.f2846d.hashCode() + ((hashCode2 + ((hashCode + ((this.f2844b.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public String toString() {
        List<Certificate> c = mo28107c();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(c, 10));
        for (Certificate a : c) {
            arrayList.add(m3364a(a));
        }
        String obj = arrayList.toString();
        StringBuilder c2 = C0681a.m340c("Handshake{", "tlsVersion=");
        c2.append(this.f2844b);
        c2.append(' ');
        c2.append("cipherSuite=");
        c2.append(this.f2845c);
        c2.append(' ');
        c2.append("peerCertificates=");
        c2.append(obj);
        c2.append(' ');
        c2.append("localCertificates=");
        List<Certificate> list = this.f2846d;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Certificate a2 : list) {
            arrayList2.add(m3364a(a2));
        }
        c2.append(arrayList2);
        c2.append('}');
        return c2.toString();
    }
}
