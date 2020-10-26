// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import okhttp3.Call;
import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import javax.net.ssl.SSLSession;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import java.security.SecureRandom;
import javax.net.ssl.TrustManager;
import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import okhttp3.Response;
import okhttp3.Request;
import java.io.IOException;
import jp.co.ncdc.apppot.stew.log.Logger;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody$Builder;
import java.io.File;
import android.content.Context;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import jp.co.ncdc.apppot.stew.json.AJSONObject;
import okhttp3.Request$Builder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

class APHttpClient
{
    private static int REQUEST_SEC_TIME_OUT = 0;
    private static int REQUEST_TIME_OUT = 0;
    private static final String TAG = "APHttpClient";
    private static APHttpClient _instance;
    private OkHttpClient mHttpClient;
    
    static {
        APHttpClient.REQUEST_SEC_TIME_OUT = 60;
        APHttpClient.REQUEST_TIME_OUT = 60000;
        APHttpClient._instance = null;
    }
    
    private APHttpClient() {
        this.mHttpClient = null;
        final APServerInfo serverInfo = APService.getInstance().getServerInfo();
        final OkHttpClient.Builder sslSetting = new OkHttpClient.Builder();
        sslSetting.connectTimeout(APHttpClient.REQUEST_SEC_TIME_OUT, TimeUnit.SECONDS);
        Object setSSLSetting = sslSetting;
        if (serverInfo.isUseSSL) {
            setSSLSetting = this.setSSLSetting(sslSetting);
        }
        this.mHttpClient = ((OkHttpClient.Builder)setSSLSetting).build();
    }
    
    private Request$Builder builder(final String s, final String s2) {
        Request$Builder request$Builder2;
        final Request$Builder request$Builder = request$Builder2 = new Request$Builder().url(s).addHeader("Content-Type", "application/json");
        if (s2 != null) {
            request$Builder2 = request$Builder;
            if (s2.length() > 0) {
                request$Builder2 = request$Builder.addHeader("apppot-token", s2);
            }
        }
        return request$Builder2;
    }
    
    private RequestBody createRequestBody(final AJSONObject ajsonObject) {
        if (ajsonObject == null) {
            return null;
        }
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), ajsonObject.toString());
    }
    
    private void file(final String s, final Context context, final String url, final String s2, final APResponseHandler apResponseHandler) {
        if (!this.isOnline(context)) {
            apResponseHandler.onError("Network is offline", new APException("Network is offline"));
            return;
        }
        apResponseHandler.url = url;
        new Thread(new Runnable() {
            @Override
            public void run() {
                final File file = new File(s2);
                final long currentTimeMillis = System.currentTimeMillis();
                final MediaType parse = MediaType.parse("application/octet-stream");
                final AJSONObject ajsonObject = new AJSONObject();
                ajsonObject.put("name", file.getName());
                final Request build = new Request$Builder().url(url).method(s, (RequestBody)new MultipartBody$Builder(String.valueOf(currentTimeMillis)).setType(MultipartBody.FORM).addFormDataPart("file", s2, RequestBody.create(parse, file)).addFormDataPart("entity", ajsonObject.toString()).build()).build();
                try {
                    final Response execute = APHttpClient.this.mHttpClient.newCall(build).execute();
                    apResponseHandler.onSuccess(execute.code(), execute.body().string());
                }
                catch (IOException ex) {
                    Logger.d("APHttpClient", "Error:" + ex.getLocalizedMessage());
                }
                finally {
                    apResponseHandler.countDown();
                }
            }
        }).start();
        apResponseHandler.ifNeedWait();
    }
    
    static APHttpClient getInstance() {
        if (APHttpClient._instance == null) {
            APHttpClient._instance = new APHttpClient();
        }
        return APHttpClient._instance;
    }
    
    private Request methodRequest(final String s, final String s2, final String s3, final AJSONObject ajsonObject) {
        return this.builder(s2, s3).method(s, this.createRequestBody(ajsonObject)).build();
    }
    
    private OkHttpClient.Builder setSSLSetting(final OkHttpClient.Builder builder) {
        try {
            final X509TrustManager x509TrustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(final X509Certificate[] array, final String s) throws CertificateException {
                }
                
                @Override
                public void checkServerTrusted(final X509Certificate[] array, final String s) throws CertificateException {
                }
                
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            final SSLContext instance = SSLContext.getInstance("SSL");
            instance.init(null, new TrustManager[] { x509TrustManager }, new SecureRandom());
            builder.sslSocketFactory(instance.getSocketFactory(), x509TrustManager).hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(final String s, final SSLSession sslSession) {
                    return true;
                }
            });
            return builder;
        }
        catch (Exception ex) {
            Logger.e("APHttpClient", "[setSSLSetting]:" + ex.getLocalizedMessage());
            ex.printStackTrace();
            return builder;
        }
    }
    
    void delete(final Context context, final String s, final APResponseHandler apResponseHandler) {
        Logger.d("APHttpClient", "[delete]start" + s);
        this.requestWithToken(context, null, s, null, "DELETE", apResponseHandler);
        Logger.d("APHttpClient", "[delete]end" + s);
    }
    
    void fileGet(final Context context, final String s, final APResponseHandler apResponseHandler) {
        Logger.d("APHttpClient", "[fileGet]start:" + s);
        if (!this.isOnline(context)) {
            apResponseHandler.onError("Network is offline", new APException("Network is offline"));
            return;
        }
        this.get(context, s, apResponseHandler);
        Logger.d("APHttpClient", "[fileGet]end:" + s);
    }
    
    void fileUpdate(final Context context, final String s, final String s2, final APResponseHandler apResponseHandler) {
        Logger.d("APHttpClient", "[fileUpload]start:" + s);
        this.file("PUT", context, s, s2, apResponseHandler);
        Logger.d("APHttpClient", "[fileUpload]end:" + s);
    }
    
    void fileUpload(final Context context, final String s, final String s2, final APResponseHandler apResponseHandler) {
        Logger.d("APHttpClient", "[fileUpload]start:" + s);
        this.file("POST", context, s, s2, apResponseHandler);
        Logger.d("APHttpClient", "[fileUpload]end:" + s);
    }
    
    void get(final Context context, final String s, final APResponseHandler apResponseHandler) {
        Logger.d("APHttpClient", "[get]start:" + s);
        this.requestWithToken(context, null, s, null, "GET", apResponseHandler);
        Logger.d("APHttpClient", "[get]end:" + s);
    }
    
    boolean isOnline(final Context context) {
        final NetworkInfo activeNetworkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
    
    void postForSelectWithToken(final Context context, final String s, final String s2, final AJSONObject ajsonObject, final APResponseSelectHandler apResponseSelectHandler) {
        Logger.d("APHttpClient", "[postForSelect]start:" + s2);
        if (!this.isOnline(context)) {
            apResponseSelectHandler.onFailure(new APError("Network is offline", -1));
            return;
        }
        apResponseSelectHandler.url = s2;
        final Call call = this.mHttpClient.newCall(this.methodRequest("POST", s2, s, ajsonObject));
        if (apResponseSelectHandler.getUseSynchronousMode()) {
            apResponseSelectHandler.setCountDownLatch(1);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Response execute = call.execute();
                    if (execute.isSuccessful()) {
                        apResponseSelectHandler.onSuccess(execute.code(), execute.body().string());
                        return;
                    }
                    apResponseSelectHandler.onFailure(new APError("Fail Request:" + s2, execute.code()));
                }
                catch (IOException ex) {
                    apResponseSelectHandler.onFailure(new APError(ex.getMessage(), ex.hashCode()));
                }
            }
        }).start();
        apResponseSelectHandler.ifNeedWait();
    }
    
    void postWithToken(final Context context, final String s, final String s2, final AJSONObject ajsonObject, final APResponseHandler apResponseHandler) {
        Logger.d("APHttpClient", "[post]start:" + s2);
        this.requestWithToken(context, s, s2, ajsonObject, "POST", apResponseHandler);
        Logger.d("APHttpClient", "[post]end:" + s2);
    }
    
    void putWithToken(final Context context, final String s, final String s2, final AJSONObject ajsonObject, final APResponseHandler apResponseHandler) {
        Logger.d("APHttpClient", "[put]start:" + s2);
        this.requestWithToken(context, s, s2, ajsonObject, "PUT", apResponseHandler);
        Logger.d("APHttpClient", "[put]end:" + s2);
    }
    
    void requestWithToken(final Context context, final String s, final String url, final AJSONObject ajsonObject, final String s2, final APResponseHandler apResponseHandler) {
        if (!this.isOnline(context)) {
            apResponseHandler.onError("Network is offline", new APException("Network is offline"));
            return;
        }
        apResponseHandler.url = url;
        final Call call = this.mHttpClient.newCall(this.methodRequest(s2, url, s, ajsonObject));
        if (apResponseHandler.getUseSynchronousMode()) {
            apResponseHandler.setCountDownLatch(1);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Response execute = call.execute();
                    apResponseHandler.onSuccess(execute.code(), execute.body().string());
                }
                catch (IOException ex) {
                    Logger.d("APHttpClient", "Error:" + ex.getLocalizedMessage());
                }
                finally {
                    apResponseHandler.countDown();
                }
            }
        }).start();
        apResponseHandler.ifNeedWait();
    }
}
