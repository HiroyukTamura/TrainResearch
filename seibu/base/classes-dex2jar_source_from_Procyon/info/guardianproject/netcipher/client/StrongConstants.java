// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.client;

public class StrongConstants
{
    public static final String[] ENABLED_CIPHERS;
    public static final String[] ENABLED_PROTOCOLS;
    
    static {
        ENABLED_CIPHERS = new String[] { "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "SSL_RSA_WITH_3DES_EDE_CBC_SHA", "SSL_RSA_WITH_RC4_128_SHA", "SSL_RSA_WITH_RC4_128_MD5" };
        ENABLED_PROTOCOLS = new String[] { "TLSv1.2", "TLSv1.1", "TLSv1" };
    }
}
