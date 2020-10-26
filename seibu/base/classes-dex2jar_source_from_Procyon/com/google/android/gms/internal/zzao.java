// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import java.util.List;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.ProtocolVersion;
import java.net.URL;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import java.util.Map;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.IOException;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.HttpEntity;
import java.net.HttpURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzao implements zzan
{
    private final zzap zzaB;
    private final SSLSocketFactory zzaC;
    
    public zzao() {
        this(null);
    }
    
    private zzao(final zzap zzap) {
        this(null, null);
    }
    
    private zzao(final zzap zzap, final SSLSocketFactory sslSocketFactory) {
        this.zzaB = null;
        this.zzaC = null;
    }
    
    private static HttpEntity zza(final HttpURLConnection httpURLConnection) {
        final BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        while (true) {
            try {
                final InputStream content = httpURLConnection.getInputStream();
                basicHttpEntity.setContent(content);
                basicHttpEntity.setContentLength((long)httpURLConnection.getContentLength());
                basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
                basicHttpEntity.setContentType(httpURLConnection.getContentType());
                return (HttpEntity)basicHttpEntity;
            }
            catch (IOException ex) {
                final InputStream content = httpURLConnection.getErrorStream();
                continue;
            }
            break;
        }
    }
    
    private static void zza(final HttpURLConnection httpURLConnection, final zzp<?> zzp) throws IOException, zza {
        final byte[] zzg = zzp.zzg();
        if (zzg != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", zzp.zzf());
            final DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzg);
            dataOutputStream.close();
        }
    }
    
    @Override
    public final HttpResponse zza(final zzp<?> zzp, final Map<String, String> m) throws IOException, zza {
        final String url = zzp.getUrl();
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.putAll(zzp.getHeaders());
        hashMap.putAll(m);
        String zzg;
        if (this.zzaB != null) {
            if ((zzg = this.zzaB.zzg(url)) == null) {
                final String value = String.valueOf(url);
                String concat;
                if (value.length() != 0) {
                    concat = "URL blocked by rewriter: ".concat(value);
                }
                else {
                    concat = new String("URL blocked by rewriter: ");
                }
                throw new IOException(concat);
            }
        }
        else {
            zzg = url;
        }
        final URL url2 = new URL(zzg);
        final HttpURLConnection httpURLConnection = (HttpURLConnection)url2.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        final int zzi = zzp.zzi();
        httpURLConnection.setConnectTimeout(zzi);
        httpURLConnection.setReadTimeout(zzi);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        "https".equals(url2.getProtocol());
        for (final String s : hashMap.keySet()) {
            httpURLConnection.addRequestProperty(s, hashMap.get(s));
        }
        Label_0288: {
            switch (zzp.getMethod()) {
                default: {
                    throw new IllegalStateException("Unknown method type.");
                }
                case 0: {
                    httpURLConnection.setRequestMethod("GET");
                    break Label_0288;
                }
                case 7: {
                    httpURLConnection.setRequestMethod("PATCH");
                    zza(httpURLConnection, zzp);
                    break Label_0288;
                }
                case 6: {
                    httpURLConnection.setRequestMethod("TRACE");
                    break Label_0288;
                }
                case 5: {
                    httpURLConnection.setRequestMethod("OPTIONS");
                    break Label_0288;
                }
                case 4: {
                    httpURLConnection.setRequestMethod("HEAD");
                    break Label_0288;
                }
                case 2: {
                    httpURLConnection.setRequestMethod("PUT");
                    zza(httpURLConnection, zzp);
                    break Label_0288;
                }
                case 1: {
                    httpURLConnection.setRequestMethod("POST");
                    zza(httpURLConnection, zzp);
                    break Label_0288;
                }
                case 3: {
                    httpURLConnection.setRequestMethod("DELETE");
                }
                case -1: {
                    final ProtocolVersion protocolVersion = new ProtocolVersion("HTTP", 1, 1);
                    if (httpURLConnection.getResponseCode() == -1) {
                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                    }
                    final BasicStatusLine basicStatusLine = new BasicStatusLine(protocolVersion, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage());
                    final BasicHttpResponse basicHttpResponse = new BasicHttpResponse((StatusLine)basicStatusLine);
                    final int method = zzp.getMethod();
                    final int statusCode = ((StatusLine)basicStatusLine).getStatusCode();
                    int n;
                    if (method != 4 && (100 > statusCode || statusCode >= 200) && statusCode != 204 && statusCode != 304) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    if (n != 0) {
                        basicHttpResponse.setEntity(zza(httpURLConnection));
                    }
                    for (final Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                        if (entry.getKey() != null) {
                            basicHttpResponse.addHeader((Header)new BasicHeader((String)entry.getKey(), (String)entry.getValue().get(0)));
                        }
                    }
                    return (HttpResponse)basicHttpResponse;
                }
            }
        }
    }
}
