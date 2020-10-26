// 
// Decompiled by Procyon v0.5.36
// 

package okhttp3;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import okhttp3.internal.Util;
import java.util.Arrays;
import javax.net.ssl.SSLPeerUnverifiedException;
import java.util.List;
import okio.ByteString;
import java.security.cert.X509Certificate;
import java.security.cert.Certificate;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.internal.tls.CertificateChainCleaner;

public final class CertificatePinner
{
    public static final CertificatePinner DEFAULT;
    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<CertificatePinner.CertificatePinner$Pin> pins;
    
    static {
        DEFAULT = new CertificatePinner.CertificatePinner$Builder().build();
    }
    
    CertificatePinner(final Set<CertificatePinner.CertificatePinner$Pin> pins, @Nullable final CertificateChainCleaner certificateChainCleaner) {
        this.pins = pins;
        this.certificateChainCleaner = certificateChainCleaner;
    }
    
    public static String pin(final Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + sha256((X509Certificate)certificate).base64();
    }
    
    static ByteString sha1(final X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }
    
    static ByteString sha256(final X509Certificate x509Certificate) {
        return ByteString.of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }
    
    public void check(final String str, final List<Certificate> list) throws SSLPeerUnverifiedException {
        final List<CertificatePinner.CertificatePinner$Pin> matchingPins = this.findMatchingPins(str);
        if (!matchingPins.isEmpty()) {
            List<X509Certificate> clean = (List<X509Certificate>)list;
            if (this.certificateChainCleaner != null) {
                clean = (List<X509Certificate>)this.certificateChainCleaner.clean((List)list, str);
            }
            for (int i = 0; i < clean.size(); ++i) {
                final X509Certificate x509Certificate = clean.get(i);
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int j = 0; j < matchingPins.size(); ++j) {
                    final CertificatePinner.CertificatePinner$Pin certificatePinner$Pin = matchingPins.get(j);
                    if (certificatePinner$Pin.hashAlgorithm.equals("sha256/")) {
                        ByteString sha256;
                        if ((sha256 = byteString2) == null) {
                            sha256 = sha256(x509Certificate);
                        }
                        if (certificatePinner$Pin.hash.equals(sha256)) {
                            return;
                        }
                        byteString2 = sha256;
                    }
                    else {
                        if (!certificatePinner$Pin.hashAlgorithm.equals("sha1/")) {
                            throw new AssertionError((Object)("unsupported hashAlgorithm: " + certificatePinner$Pin.hashAlgorithm));
                        }
                        ByteString sha257;
                        if ((sha257 = byteString) == null) {
                            sha257 = sha1(x509Certificate);
                        }
                        byteString = sha257;
                        if (certificatePinner$Pin.hash.equals(sha257)) {
                            return;
                        }
                    }
                }
            }
            final StringBuilder append = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
            for (int k = 0; k < clean.size(); ++k) {
                final X509Certificate x509Certificate2 = clean.get(k);
                append.append("\n    ").append(pin(x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
            }
            append.append("\n  Pinned certificates for ").append(str).append(":");
            for (int l = 0; l < matchingPins.size(); ++l) {
                append.append("\n    ").append(matchingPins.get(l));
            }
            throw new SSLPeerUnverifiedException(append.toString());
        }
    }
    
    public void check(final String s, final Certificate... a) throws SSLPeerUnverifiedException {
        this.check(s, Arrays.asList(a));
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o == this || (o instanceof CertificatePinner && Util.equal(this.certificateChainCleaner, ((CertificatePinner)o).certificateChainCleaner) && this.pins.equals(((CertificatePinner)o).pins));
    }
    
    List<CertificatePinner.CertificatePinner$Pin> findMatchingPins(final String s) {
        List<CertificatePinner.CertificatePinner$Pin> emptyList = Collections.emptyList();
        for (final CertificatePinner.CertificatePinner$Pin certificatePinner$Pin : this.pins) {
            if (certificatePinner$Pin.matches(s)) {
                List<CertificatePinner.CertificatePinner$Pin> list = emptyList;
                if (emptyList.isEmpty()) {
                    list = new ArrayList<CertificatePinner.CertificatePinner$Pin>();
                }
                list.add(certificatePinner$Pin);
                emptyList = list;
            }
        }
        return emptyList;
    }
    
    @Override
    public int hashCode() {
        int hashCode;
        if (this.certificateChainCleaner != null) {
            hashCode = this.certificateChainCleaner.hashCode();
        }
        else {
            hashCode = 0;
        }
        return hashCode * 31 + this.pins.hashCode();
    }
    
    CertificatePinner withCertificateChainCleaner(@Nullable final CertificateChainCleaner certificateChainCleaner) {
        if (Util.equal(this.certificateChainCleaner, certificateChainCleaner)) {
            return this;
        }
        return new CertificatePinner(this.pins, certificateChainCleaner);
    }
}
