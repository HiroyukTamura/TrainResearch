// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.client;

import ch.boye.httpclientandroidlib.conn.ClientConnectionOperator;
import ch.boye.httpclientandroidlib.params.HttpParams;
import android.util.Log;
import ch.boye.httpclientandroidlib.impl.conn.tsccm.ThreadSafeClientConnManager;
import ch.boye.httpclientandroidlib.conn.ClientConnectionManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.NoSuchAlgorithmException;
import java.security.KeyStoreException;
import info.guardianproject.onionkit.R;
import java.security.KeyStore;
import javax.net.ssl.TrustManagerFactory;
import ch.boye.httpclientandroidlib.conn.scheme.SchemeSocketFactory;
import ch.boye.httpclientandroidlib.conn.scheme.Scheme;
import ch.boye.httpclientandroidlib.conn.scheme.PlainSocketFactory;
import ch.boye.httpclientandroidlib.HttpHost;
import ch.boye.httpclientandroidlib.conn.scheme.SchemeRegistry;
import android.content.Context;
import ch.boye.httpclientandroidlib.impl.client.DefaultHttpClient;

public class StrongHttpsClient extends DefaultHttpClient
{
    private static final String TRUSTSTORE_PASSWORD = "changeit";
    private static final String TRUSTSTORE_TYPE = "BKS";
    public static final String TYPE_HTTP = "http";
    public static final String TYPE_SOCKS = "socks";
    final Context context;
    private SchemeRegistry mRegistry;
    private HttpHost proxyHost;
    private String proxyType;
    private StrongSSLSocketFactory sFactory;
    
    public StrongHttpsClient(final Context context) {
        this.context = context;
        (this.mRegistry = new SchemeRegistry()).register(new Scheme("http", 80, (SchemeSocketFactory)PlainSocketFactory.getSocketFactory()));
        try {
            final KeyStore loadKeyStore = this.loadKeyStore();
            final TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(loadKeyStore);
            this.sFactory = new StrongSSLSocketFactory(context, instance.getTrustManagers(), loadKeyStore, "changeit");
            this.mRegistry.register(new Scheme("https", 443, (SchemeSocketFactory)this.sFactory));
        }
        catch (Exception detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    public StrongHttpsClient(final Context context, final KeyStore keyStore) {
        this.context = context;
        (this.mRegistry = new SchemeRegistry()).register(new Scheme("http", 80, (SchemeSocketFactory)PlainSocketFactory.getSocketFactory()));
        try {
            this.sFactory = new StrongSSLSocketFactory(context, TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm()).getTrustManagers(), keyStore, "changeit");
            this.mRegistry.register(new Scheme("https", 443, (SchemeSocketFactory)this.sFactory));
        }
        catch (Exception detailMessage) {
            throw new AssertionError((Object)detailMessage);
        }
    }
    
    private KeyStore loadKeyStore() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        final KeyStore instance = KeyStore.getInstance("BKS");
        instance.load(this.context.getResources().openRawResource(R.raw.debiancacerts), "changeit".toCharArray());
        return instance;
    }
    
    protected ThreadSafeClientConnManager createClientConnectionManager() {
        if (this.proxyHost == null && this.proxyType == null) {
            Log.d("StrongHTTPS", "not proxying");
            return new MyThreadSafeClientConnManager(this.getParams(), this.mRegistry);
        }
        if (this.proxyHost != null && this.proxyType.equalsIgnoreCase("socks")) {
            Log.d("StrongHTTPS", "proxying using: " + this.proxyType);
            return new MyThreadSafeClientConnManager(this.getParams(), this.mRegistry) {
                @Override
                protected ClientConnectionOperator createConnectionOperator(final SchemeRegistry schemeRegistry) {
                    return (ClientConnectionOperator)new SocksProxyClientConnOperator(schemeRegistry, StrongHttpsClient.this.proxyHost.getHostName(), StrongHttpsClient.this.proxyHost.getPort());
                }
            };
        }
        Log.d("StrongHTTPS", "proxying with: " + this.proxyType);
        return new MyThreadSafeClientConnManager(this.getParams(), this.mRegistry);
    }
    
    public void disableProxy() {
        this.getParams().removeParameter("http.route.default-proxy");
        this.proxyHost = null;
    }
    
    public void useProxy(final boolean b, final String proxyType, final String s, final int n) {
        if (!b) {
            this.getParams().removeParameter("http.route.default-proxy");
            this.proxyHost = null;
            return;
        }
        this.proxyType = proxyType;
        if (proxyType.equalsIgnoreCase("socks")) {
            this.proxyHost = new HttpHost(s, n);
            return;
        }
        this.proxyHost = new HttpHost(s, n, proxyType);
        this.getParams().setParameter("http.route.default-proxy", (Object)this.proxyHost);
    }
}
