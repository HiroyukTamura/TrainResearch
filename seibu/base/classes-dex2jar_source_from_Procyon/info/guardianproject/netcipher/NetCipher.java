// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher;

import android.text.TextUtils;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLSocketFactory;
import info.guardianproject.netcipher.client.TlsOnlySocketFactory;
import java.security.SecureRandom;
import javax.net.ssl.TrustManager;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import java.net.URI;
import android.net.Uri;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class NetCipher
{
    public static final Proxy ORBOT_HTTP_PROXY;
    private static Proxy proxy;
    
    static {
        ORBOT_HTTP_PROXY = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8118));
    }
    
    private NetCipher() {
    }
    
    public static HttpURLConnection getCompatibleHttpURLConnection(final URL url) throws IOException {
        return getHttpURLConnection(url, true);
    }
    
    public static HttpsURLConnection getCompatibleHttpsURLConnection(final URL url) throws IOException {
        return getHttpsURLConnection(url, true);
    }
    
    public static HttpURLConnection getHttpURLConnection(final Uri uri) throws IOException {
        return getHttpURLConnection(uri.toString());
    }
    
    public static HttpURLConnection getHttpURLConnection(final String spec) throws IOException {
        return getHttpURLConnection(new URL(spec));
    }
    
    public static HttpURLConnection getHttpURLConnection(final URI uri) throws IOException {
        return getHttpURLConnection(uri.toURL());
    }
    
    public static HttpURLConnection getHttpURLConnection(final URL url) throws IOException {
        return getHttpURLConnection(url, false);
    }
    
    public static HttpURLConnection getHttpURLConnection(final URL url, final boolean b) throws IOException {
        try {
            final SSLContext instance = SSLContext.getInstance("TLSv1");
            instance.init(null, null, null);
            HttpsURLConnection.setDefaultSSLSocketFactory(new TlsOnlySocketFactory(instance.getSocketFactory(), b));
            if (NetCipher.proxy != null) {
                return (HttpURLConnection)url.openConnection(NetCipher.proxy);
            }
        }
        catch (NoSuchAlgorithmException cause) {
            throw new IllegalArgumentException(cause);
        }
        catch (KeyManagementException cause2) {
            throw new IllegalArgumentException(cause2);
        }
        return (HttpURLConnection)url.openConnection();
    }
    
    public static HttpsURLConnection getHttpsURLConnection(final Uri uri) throws IOException {
        return getHttpsURLConnection(uri.toString());
    }
    
    public static HttpsURLConnection getHttpsURLConnection(final String spec) throws IOException {
        spec.replaceFirst("^[Hh][Tt][Tt][Pp]:", "https:");
        return getHttpsURLConnection(new URL(spec), false);
    }
    
    public static HttpsURLConnection getHttpsURLConnection(final URI uri) throws IOException {
        if (TextUtils.equals((CharSequence)uri.getScheme(), (CharSequence)"https")) {
            return getHttpsURLConnection(uri.toURL(), false);
        }
        return getHttpsURLConnection(uri.toString());
    }
    
    public static HttpsURLConnection getHttpsURLConnection(final URL url) throws IOException {
        return getHttpsURLConnection(url, false);
    }
    
    public static HttpsURLConnection getHttpsURLConnection(final URL url, final boolean b) throws IOException {
        final HttpURLConnection httpURLConnection = getHttpURLConnection(url, b);
        if (httpURLConnection instanceof HttpsURLConnection) {
            return (HttpsURLConnection)httpURLConnection;
        }
        throw new IllegalArgumentException("not an HTTPS connection!");
    }
    
    public static Proxy getProxy() {
        return NetCipher.proxy;
    }
    
    public static void setProxy(final String hostname, final int port) {
        if (hostname != null && port > 0) {
            NetCipher.proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(hostname, port));
            return;
        }
        NetCipher.proxy = null;
    }
    
    public static void setProxy(final Proxy proxy) {
        NetCipher.proxy = proxy;
    }
    
    public static void useTor() {
        setProxy(NetCipher.ORBOT_HTTP_PROXY);
    }
}
