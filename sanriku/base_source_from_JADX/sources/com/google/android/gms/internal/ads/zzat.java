package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

public final class zzat extends zzah {
    private final zzav zzck;
    private final SSLSocketFactory zzcl;

    public zzat() {
        this((zzav) null);
    }

    private zzat(zzav zzav) {
        this((zzav) null, (SSLSocketFactory) null);
    }

    private zzat(zzav zzav, SSLSocketFactory sSLSocketFactory) {
        this.zzck = null;
        this.zzcl = null;
    }

    /* access modifiers changed from: private */
    public static InputStream zza(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    @VisibleForTesting
    private static List<zzk> zza(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() != null) {
                for (String zzk : (List) next.getValue()) {
                    arrayList.add(new zzk((String) next.getKey(), zzk));
                }
            }
        }
        return arrayList;
    }

    private static void zza(HttpURLConnection httpURLConnection, zzq<?> zzq) throws IOException, zzb {
        byte[] zzg = zzq.zzg();
        if (zzg != null) {
            httpURLConnection.setDoOutput(true);
            if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                httpURLConnection.setRequestProperty("Content-Type", "UTF-8".length() != 0 ? "application/x-www-form-urlencoded; charset=".concat("UTF-8") : new String("application/x-www-form-urlencoded; charset="));
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzg);
            dataOutputStream.close();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0096, code lost:
        zza(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009c, code lost:
        r0.setRequestMethod(r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzar zza(com.google.android.gms.internal.ads.zzq<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException, com.google.android.gms.internal.ads.zzb {
        /*
            r6 = this;
            java.lang.String r0 = r7.getUrl()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.putAll(r8)
            java.util.Map r8 = r7.getHeaders()
            r1.putAll(r8)
            com.google.android.gms.internal.ads.zzav r8 = r6.zzck
            if (r8 == 0) goto L_0x003b
            java.lang.String r8 = r8.zzg(r0)
            if (r8 != 0) goto L_0x003a
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r8 = "URL blocked by rewriter: "
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x0030
            java.lang.String r8 = r8.concat(r0)
            goto L_0x0036
        L_0x0030:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r8)
            r8 = r0
        L_0x0036:
            r7.<init>(r8)
            throw r7
        L_0x003a:
            r0 = r8
        L_0x003b:
            java.net.URL r8 = new java.net.URL
            r8.<init>(r0)
            java.net.URLConnection r0 = r8.openConnection()
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
            boolean r2 = java.net.HttpURLConnection.getFollowRedirects()
            r0.setInstanceFollowRedirects(r2)
            int r2 = r7.zzi()
            r0.setConnectTimeout(r2)
            r0.setReadTimeout(r2)
            r2 = 0
            r0.setUseCaches(r2)
            r3 = 1
            r0.setDoInput(r3)
            java.lang.String r8 = r8.getProtocol()
            java.lang.String r4 = "https"
            r4.equals(r8)
            java.util.Set r8 = r1.keySet()     // Catch:{ all -> 0x0114 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0114 }
        L_0x0070:
            boolean r4 = r8.hasNext()     // Catch:{ all -> 0x0114 }
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r8.next()     // Catch:{ all -> 0x0114 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0114 }
            java.lang.Object r5 = r1.get(r4)     // Catch:{ all -> 0x0114 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0114 }
            r0.setRequestProperty(r4, r5)     // Catch:{ all -> 0x0114 }
            goto L_0x0070
        L_0x0086:
            int r8 = r7.getMethod()     // Catch:{ all -> 0x0114 }
            switch(r8) {
                case -1: goto L_0x00b8;
                case 0: goto L_0x00b5;
                case 1: goto L_0x00af;
                case 2: goto L_0x00a9;
                case 3: goto L_0x00a6;
                case 4: goto L_0x00a3;
                case 5: goto L_0x00a0;
                case 6: goto L_0x009a;
                case 7: goto L_0x0091;
                default: goto L_0x008d;
            }     // Catch:{ all -> 0x0114 }
        L_0x008d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0114 }
            goto L_0x010e
        L_0x0091:
            java.lang.String r8 = "PATCH"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x0114 }
        L_0x0096:
            zza((java.net.HttpURLConnection) r0, (com.google.android.gms.internal.ads.zzq<?>) r7)     // Catch:{ all -> 0x0114 }
            goto L_0x00b8
        L_0x009a:
            java.lang.String r8 = "TRACE"
        L_0x009c:
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x0114 }
            goto L_0x00b8
        L_0x00a0:
            java.lang.String r8 = "OPTIONS"
            goto L_0x009c
        L_0x00a3:
            java.lang.String r8 = "HEAD"
            goto L_0x009c
        L_0x00a6:
            java.lang.String r8 = "DELETE"
            goto L_0x009c
        L_0x00a9:
            java.lang.String r8 = "PUT"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x0114 }
            goto L_0x0096
        L_0x00af:
            java.lang.String r8 = "POST"
            r0.setRequestMethod(r8)     // Catch:{ all -> 0x0114 }
            goto L_0x0096
        L_0x00b5:
            java.lang.String r8 = "GET"
            goto L_0x009c
        L_0x00b8:
            int r8 = r0.getResponseCode()     // Catch:{ all -> 0x0114 }
            r1 = -1
            if (r8 == r1) goto L_0x0106
            int r7 = r7.getMethod()     // Catch:{ all -> 0x0114 }
            r1 = 4
            if (r7 == r1) goto L_0x00d8
            r7 = 100
            if (r7 > r8) goto L_0x00ce
            r7 = 200(0xc8, float:2.8E-43)
            if (r8 < r7) goto L_0x00d8
        L_0x00ce:
            r7 = 204(0xcc, float:2.86E-43)
            if (r8 == r7) goto L_0x00d8
            r7 = 304(0x130, float:4.26E-43)
            if (r8 == r7) goto L_0x00d8
            r7 = 1
            goto L_0x00d9
        L_0x00d8:
            r7 = 0
        L_0x00d9:
            if (r7 != 0) goto L_0x00ec
            com.google.android.gms.internal.ads.zzar r7 = new com.google.android.gms.internal.ads.zzar     // Catch:{ all -> 0x0114 }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ all -> 0x0114 }
            java.util.List r1 = zza((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r1)     // Catch:{ all -> 0x0114 }
            r7.<init>(r8, r1)     // Catch:{ all -> 0x0114 }
            r0.disconnect()
            return r7
        L_0x00ec:
            com.google.android.gms.internal.ads.zzar r7 = new com.google.android.gms.internal.ads.zzar     // Catch:{ all -> 0x0103 }
            java.util.Map r1 = r0.getHeaderFields()     // Catch:{ all -> 0x0103 }
            java.util.List r1 = zza((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r1)     // Catch:{ all -> 0x0103 }
            int r2 = r0.getContentLength()     // Catch:{ all -> 0x0103 }
            com.google.android.gms.internal.ads.zzaw r4 = new com.google.android.gms.internal.ads.zzaw     // Catch:{ all -> 0x0103 }
            r4.<init>(r0)     // Catch:{ all -> 0x0103 }
            r7.<init>(r8, r1, r2, r4)     // Catch:{ all -> 0x0103 }
            return r7
        L_0x0103:
            r7 = move-exception
            r2 = 1
            goto L_0x0115
        L_0x0106:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0114 }
            java.lang.String r8 = "Could not retrieve response code from HttpUrlConnection."
            r7.<init>(r8)     // Catch:{ all -> 0x0114 }
            throw r7     // Catch:{ all -> 0x0114 }
        L_0x010e:
            java.lang.String r8 = "Unknown method type."
            r7.<init>(r8)     // Catch:{ all -> 0x0114 }
            throw r7     // Catch:{ all -> 0x0114 }
        L_0x0114:
            r7 = move-exception
        L_0x0115:
            if (r2 != 0) goto L_0x011a
            r0.disconnect()
        L_0x011a:
            goto L_0x011c
        L_0x011b:
            throw r7
        L_0x011c:
            goto L_0x011b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzat.zza(com.google.android.gms.internal.ads.zzq, java.util.Map):com.google.android.gms.internal.ads.zzar");
    }
}
