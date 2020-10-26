// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote;

import javax.net.ssl.SSLSession;
import java.io.IOException;
import android.os.Build$VERSION;
import java.net.HttpURLConnection;
import org.androidannotations.annotations.AfterInject;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import java.security.SecureRandom;
import javax.net.ssl.TrustManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.androidannotations.annotations.EBean;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.HostnameVerifier;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

@EBean
public class SSLRequestFactory extends SimpleClientHttpRequestFactory implements HostnameVerifier, X509TrustManager
{
    private SSLSocketFactory properSocketFactory;
    private final CertStrategy strategy;
    
    public SSLRequestFactory() {
        this.strategy = CertStrategy.TRUST_SYSTEM;
        this.trustAllHosts();
    }
    
    private void trustAllHosts() {
        try {
            final SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, new TrustManager[] { this }, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void trustOnlyKnownCerts() {
        try {
            HttpsURLConnection.setDefaultSSLSocketFactory(this.properSocketFactory);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void checkClientTrusted(final X509Certificate[] array, final String s) throws CertificateException {
    }
    
    public void checkServerTrusted(final X509Certificate[] array, final String s) throws CertificateException {
    }
    
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
    
    @AfterInject
    void init() {
        this.properSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
        switch (this.strategy) {
            default: {}
            case TRUST_SYSTEM: {
                this.trustOnlyKnownCerts();
            }
        }
    }
    
    protected void prepareConnection(final HttpURLConnection httpURLConnection, final String s) throws IOException {
        if (this.strategy == CertStrategy.TRUST_ALL && httpURLConnection instanceof HttpsURLConnection) {
            ((HttpsURLConnection)httpURLConnection).setHostnameVerifier(this);
        }
        super.prepareConnection(httpURLConnection, s);
        if (Build$VERSION.SDK_INT >= 21) {
            if (!"PUT".equals(s) && !"POST".equals(s) && !"PATCH".equals(s) && !"DELETE".equals(s)) {
                httpURLConnection.setDoOutput(false);
                return;
            }
            httpURLConnection.setDoOutput(true);
        }
    }
    
    public boolean verify(final String s, final SSLSession sslSession) {
        return true;
    }
    
    public enum CertStrategy
    {
        TRUST_ALL, 
        TRUST_CUSTOM, 
        TRUST_SYSTEM;
    }
}
