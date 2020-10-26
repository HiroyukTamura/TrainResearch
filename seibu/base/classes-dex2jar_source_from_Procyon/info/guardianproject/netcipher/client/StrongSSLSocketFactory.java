// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.client;

import ch.boye.httpclientandroidlib.params.HttpParams;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import javax.net.ssl.SSLSocket;
import java.net.Socket;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import java.security.KeyStore;
import javax.net.ssl.TrustManager;
import android.content.Context;
import java.net.Proxy;
import ch.boye.httpclientandroidlib.conn.scheme.LayeredSchemeSocketFactory;
import ch.boye.httpclientandroidlib.conn.ssl.SSLSocketFactory;

public class StrongSSLSocketFactory extends SSLSocketFactory implements LayeredSchemeSocketFactory
{
    public static final String SSL = "SSL";
    public static final String SSLV2 = "SSLv2";
    public static final String TLS = "TLS";
    private String[] mCipherSuites;
    private boolean mEnableStongerDefaultProtocalVersion;
    private boolean mEnableStongerDefaultSSLCipherSuite;
    private javax.net.ssl.SSLSocketFactory mFactory;
    private String[] mProtocols;
    private Proxy mProxy;
    
    public StrongSSLSocketFactory(final Context context, final TrustManager[] tm, final KeyStore keyStore, final String s) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        super(keyStore);
        this.mFactory = null;
        this.mProxy = null;
        this.mEnableStongerDefaultSSLCipherSuite = true;
        this.mEnableStongerDefaultProtocalVersion = true;
        final SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(this.createKeyManagers(keyStore, s), tm, new SecureRandom());
        this.mFactory = instance.getSocketFactory();
    }
    
    private KeyManager[] createKeyManagers(final KeyStore ks, final String s) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (ks == null) {
            throw new IllegalArgumentException("Keystore may not be null");
        }
        final KeyManagerFactory instance = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        char[] charArray;
        if (s != null) {
            charArray = s.toCharArray();
        }
        else {
            charArray = null;
        }
        instance.init(ks, charArray);
        return instance.getKeyManagers();
    }
    
    private void enableStrongerDefaults(final Socket socket) {
        if (this.isSecure(socket)) {
            final SSLSocket sslSocket = (SSLSocket)socket;
            this.readSSLParameters(sslSocket);
            if (this.mEnableStongerDefaultProtocalVersion && this.mProtocols != null) {
                sslSocket.setEnabledProtocols(this.mProtocols);
            }
            if (this.mEnableStongerDefaultSSLCipherSuite && this.mCipherSuites != null) {
                sslSocket.setEnabledCipherSuites(this.mCipherSuites);
            }
        }
    }
    
    private void readSSLParameters(final SSLSocket sslSocket) {
        final ArrayList<String> list = new ArrayList<String>();
        final List<String> list2 = Arrays.asList(sslSocket.getSupportedProtocols());
        final String[] enabled_PROTOCOLS = StrongConstants.ENABLED_PROTOCOLS;
        for (int length = enabled_PROTOCOLS.length, i = 0; i < length; ++i) {
            final String s = enabled_PROTOCOLS[i];
            if (list2.contains(s)) {
                list.add(s);
            }
        }
        this.mProtocols = list.toArray(new String[list.size()]);
        final ArrayList<String> list3 = new ArrayList<String>();
        final List<String> list4 = Arrays.asList(sslSocket.getSupportedCipherSuites());
        final String[] enabled_CIPHERS = StrongConstants.ENABLED_CIPHERS;
        for (int length2 = enabled_CIPHERS.length, j = 0; j < length2; ++j) {
            final String s2 = enabled_CIPHERS[j];
            if (list4.contains(s2)) {
                list3.add(s2);
            }
        }
        this.mCipherSuites = list3.toArray(new String[list3.size()]);
    }
    
    public Socket createLayeredSocket(final Socket socket, final String s, final int n, final boolean b) throws IOException, UnknownHostException {
        return ((LayeredSchemeSocketFactory)this.mFactory).createLayeredSocket(socket, s, n, b);
    }
    
    public Socket createSocket() throws IOException {
        final Socket socket = this.mFactory.createSocket();
        this.enableStrongerDefaults(socket);
        return socket;
    }
    
    public Socket createSocket(final HttpParams httpParams) throws IOException {
        final Socket socket = this.mFactory.createSocket();
        this.enableStrongerDefaults(socket);
        return socket;
    }
    
    public Socket createSocket(Socket socket, final String s, final int n, final boolean b) throws IOException, UnknownHostException {
        socket = this.mFactory.createSocket(socket, s, n, b);
        this.enableStrongerDefaults(socket);
        return socket;
    }
    
    public Proxy getProxy() {
        return this.mProxy;
    }
    
    public boolean isEnableStongerDefaultProtocalVersion() {
        return this.mEnableStongerDefaultProtocalVersion;
    }
    
    public boolean isEnableStongerDefaultSSLCipherSuite() {
        return this.mEnableStongerDefaultSSLCipherSuite;
    }
    
    public boolean isSecure(final Socket socket) throws IllegalArgumentException {
        return socket instanceof SSLSocket;
    }
    
    public void setEnableStongerDefaultProtocalVersion(final boolean mEnableStongerDefaultProtocalVersion) {
        this.mEnableStongerDefaultProtocalVersion = mEnableStongerDefaultProtocalVersion;
    }
    
    public void setEnableStongerDefaultSSLCipherSuite(final boolean mEnableStongerDefaultSSLCipherSuite) {
        this.mEnableStongerDefaultSSLCipherSuite = mEnableStongerDefaultSSLCipherSuite;
    }
    
    public void setProxy(final Proxy mProxy) {
        this.mProxy = mProxy;
    }
}
