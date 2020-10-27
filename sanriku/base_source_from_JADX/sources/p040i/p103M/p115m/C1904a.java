package p040i.p103M.p115m;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: i.M.m.a */
public final class C1904a extends C1906c {

    /* renamed from: a */
    private final C1908e f2699a;

    public C1904a(C1908e eVar) {
        Intrinsics.checkParameterIsNotNull(eVar, "trustRootIndex");
        this.f2699a = eVar;
    }

    /* renamed from: a */
    private final boolean m3242a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!Intrinsics.areEqual((Object) x509Certificate.getIssuerDN(), (Object) x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public List<Certificate> mo27991a(List<? extends Certificate> list, String str) throws SSLPeerUnverifiedException {
        Intrinsics.checkParameterIsNotNull(list, "chain");
        Intrinsics.checkParameterIsNotNull(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        Intrinsics.checkExpressionValueIsNotNull(removeFirst, "queue.removeFirst()");
        arrayList.add(removeFirst);
        int i = 0;
        boolean z = false;
        while (i < 9) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj != null) {
                X509Certificate x509Certificate = (X509Certificate) obj;
                X509Certificate a = this.f2699a.mo27972a(x509Certificate);
                if (a != null) {
                    if (arrayList.size() > 1 || (!Intrinsics.areEqual((Object) x509Certificate, (Object) a))) {
                        arrayList.add(a);
                    }
                    if (m3242a(a, a)) {
                        return arrayList;
                    }
                    z = true;
                } else {
                    Iterator it = arrayDeque.iterator();
                    Intrinsics.checkExpressionValueIsNotNull(it, "queue.iterator()");
                    while (it.hasNext()) {
                        Object next = it.next();
                        if (next != null) {
                            X509Certificate x509Certificate2 = (X509Certificate) next;
                            if (m3242a(x509Certificate, x509Certificate2)) {
                                it.remove();
                                arrayList.add(x509Certificate2);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                        }
                    }
                    if (z) {
                        return arrayList;
                    }
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
                i++;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C1904a) && Intrinsics.areEqual((Object) ((C1904a) obj).f2699a, (Object) this.f2699a);
    }

    public int hashCode() {
        return this.f2699a.hashCode();
    }
}
