package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.analytics.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;
import p009e.p010a.p011a.p012a.C0681a;

final class zzck extends zzan {
    /* access modifiers changed from: private */
    public static final byte[] zzabr = "\n".getBytes();
    private final String zzabp = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", zzao.VERSION, Build.VERSION.RELEASE, zzcz.zza(Locale.getDefault()), Build.MODEL, Build.ID});
    private final zzcv zzabq;

    zzck(zzap zzap) {
        super(zzap);
        this.zzabq = new zzcv(zzap.zzcn());
    }

    private final int zza(URL url) {
        Preconditions.checkNotNull(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection zzb = zzb(url);
            zzb.connect();
            zza(zzb);
            int responseCode = zzb.getResponseCode();
            if (responseCode == 200) {
                zzcs().zzcl();
            }
            zzb("GET status", Integer.valueOf(responseCode));
            zzb.disconnect();
            return responseCode;
        } catch (IOException e) {
            zzd("Network GET connection error", e);
            if (httpURLConnection == null) {
                return 0;
            }
            httpURLConnection.disconnect();
            return 0;
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075 A[SYNTHETIC, Splitter:B:27:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087 A[SYNTHETIC, Splitter:B:35:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(java.net.URL r5, byte[] r6) {
        /*
            r4 = this;
            java.lang.String r0 = "Error closing http post connection output stream"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            int r1 = r6.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "POST bytes, url"
            r4.zzb(r2, r1, r5)
            boolean r1 = com.google.android.gms.internal.gtm.zzam.zzda()
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = new java.lang.String
            r1.<init>(r6)
            java.lang.String r2 = "Post payload\n"
            r4.zza(r2, r1)
        L_0x0022:
            r1 = 0
            android.content.Context r2 = r4.getContext()     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            r2.getPackageName()     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            java.net.HttpURLConnection r5 = r4.zzb((java.net.URL) r5)     // Catch:{ IOException -> 0x006c, all -> 0x0069 }
            r2 = 1
            r5.setDoOutput(r2)     // Catch:{ IOException -> 0x0067 }
            int r2 = r6.length     // Catch:{ IOException -> 0x0067 }
            r5.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x0067 }
            r5.connect()     // Catch:{ IOException -> 0x0067 }
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch:{ IOException -> 0x0067 }
            r1.write(r6)     // Catch:{ IOException -> 0x0067 }
            r4.zza((java.net.HttpURLConnection) r5)     // Catch:{ IOException -> 0x0067 }
            int r6 = r5.getResponseCode()     // Catch:{ IOException -> 0x0067 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r6 != r2) goto L_0x0052
            com.google.android.gms.internal.gtm.zzae r2 = r4.zzcs()     // Catch:{ IOException -> 0x0067 }
            r2.zzcl()     // Catch:{ IOException -> 0x0067 }
        L_0x0052:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0067 }
            r4.zzb(r2, r3)     // Catch:{ IOException -> 0x0067 }
            r1.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r1 = move-exception
            r4.zze(r0, r1)
        L_0x0063:
            r5.disconnect()
            return r6
        L_0x0067:
            r6 = move-exception
            goto L_0x006e
        L_0x0069:
            r6 = move-exception
            r5 = r1
            goto L_0x0085
        L_0x006c:
            r6 = move-exception
            r5 = r1
        L_0x006e:
            java.lang.String r2 = "Network POST connection error"
            r4.zzd(r2, r6)     // Catch:{ all -> 0x0084 }
            if (r1 == 0) goto L_0x007d
            r1.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007d
        L_0x0079:
            r6 = move-exception
            r4.zze(r0, r6)
        L_0x007d:
            if (r5 == 0) goto L_0x0082
            r5.disconnect()
        L_0x0082:
            r5 = 0
            return r5
        L_0x0084:
            r6 = move-exception
        L_0x0085:
            if (r1 == 0) goto L_0x008f
            r1.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r1 = move-exception
            r4.zze(r0, r1)
        L_0x008f:
            if (r5 == 0) goto L_0x0094
            r5.disconnect()
        L_0x0094:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zza(java.net.URL, byte[]):int");
    }

    private static void zza(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append(Typography.amp);
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x001f A[SYNTHETIC, Splitter:B:18:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.net.HttpURLConnection r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "Error closing http connection input stream"
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x001b }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0019 }
        L_0x000a:
            int r2 = r4.read(r1)     // Catch:{ all -> 0x0019 }
            if (r2 > 0) goto L_0x000a
            r4.close()     // Catch:{ IOException -> 0x0014 }
            return
        L_0x0014:
            r4 = move-exception
            r3.zze(r0, r4)
            return
        L_0x0019:
            r1 = move-exception
            goto L_0x001d
        L_0x001b:
            r1 = move-exception
            r4 = 0
        L_0x001d:
            if (r4 == 0) goto L_0x0027
            r4.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r4 = move-exception
            r3.zze(r0, r4)
        L_0x0027:
            goto L_0x0029
        L_0x0028:
            throw r1
        L_0x0029:
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zza(java.net.HttpURLConnection):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d4 A[SYNTHETIC, Splitter:B:41:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e6 A[SYNTHETIC, Splitter:B:49:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzb(java.net.URL r11, byte[] r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Error closing http compressed post connection output stream"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)
            r1 = 0
            android.content.Context r2 = r10.getContext()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r2.getPackageName()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r2.<init>()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r3.write(r12)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r3.close()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r2.close()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            byte[] r2 = r2.toByteArray()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            java.lang.String r3 = "POST compressed size, ratio %, url"
            int r4 = r2.length     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r5 = 100
            int r7 = r2.length     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            long r7 = (long) r7     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            long r7 = r7 * r5
            int r5 = r12.length     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            long r5 = (long) r5     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            long r7 = r7 / r5
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r10.zza(r3, r4, r5, r11)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            int r3 = r2.length     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            int r4 = r12.length     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            if (r3 <= r4) goto L_0x0051
            java.lang.String r3 = "Compressed payload is larger then uncompressed. compressed, uncompressed"
            int r4 = r2.length     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            int r5 = r12.length     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r10.zzc(r3, r4, r5)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
        L_0x0051:
            boolean r3 = com.google.android.gms.internal.gtm.zzam.zzda()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            if (r3 == 0) goto L_0x0073
            java.lang.String r3 = "Post payload"
            java.lang.String r4 = "\n"
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r5.<init>(r12)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            int r12 = r5.length()     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            if (r12 == 0) goto L_0x006b
            java.lang.String r12 = r4.concat(r5)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            goto L_0x0070
        L_0x006b:
            java.lang.String r12 = new java.lang.String     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r12.<init>(r4)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
        L_0x0070:
            r10.zza(r3, r12)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
        L_0x0073:
            java.net.HttpURLConnection r11 = r10.zzb((java.net.URL) r11)     // Catch:{ IOException -> 0x00cb, all -> 0x00c8 }
            r12 = 1
            r11.setDoOutput(r12)     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            java.lang.String r12 = "Content-Encoding"
            java.lang.String r3 = "gzip"
            r11.addRequestProperty(r12, r3)     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            int r12 = r2.length     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            r11.setFixedLengthStreamingMode(r12)     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            r11.connect()     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            java.io.OutputStream r12 = r11.getOutputStream()     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            r12.write(r2)     // Catch:{ IOException -> 0x00b8, all -> 0x00b2 }
            r12.close()     // Catch:{ IOException -> 0x00b8, all -> 0x00b2 }
            r10.zza((java.net.HttpURLConnection) r11)     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            int r12 = r11.getResponseCode()     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            r2 = 200(0xc8, float:2.8E-43)
            if (r12 != r2) goto L_0x00a5
            com.google.android.gms.internal.gtm.zzae r2 = r10.zzcs()     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            r2.zzcl()     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
        L_0x00a5:
            java.lang.String r2 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            r10.zzb(r2, r3)     // Catch:{ IOException -> 0x00c3, all -> 0x00be }
            r11.disconnect()
            return r12
        L_0x00b2:
            r1 = move-exception
            r9 = r12
            r12 = r11
            r11 = r1
            r1 = r9
            goto L_0x00e4
        L_0x00b8:
            r1 = move-exception
            r9 = r12
            r12 = r11
            r11 = r1
            r1 = r9
            goto L_0x00cd
        L_0x00be:
            r12 = move-exception
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x00e4
        L_0x00c3:
            r12 = move-exception
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x00cd
        L_0x00c8:
            r11 = move-exception
            r12 = r1
            goto L_0x00e4
        L_0x00cb:
            r11 = move-exception
            r12 = r1
        L_0x00cd:
            java.lang.String r2 = "Network compressed POST connection error"
            r10.zzd(r2, r11)     // Catch:{ all -> 0x00e3 }
            if (r1 == 0) goto L_0x00dc
            r1.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00dc
        L_0x00d8:
            r11 = move-exception
            r10.zze(r0, r11)
        L_0x00dc:
            if (r12 == 0) goto L_0x00e1
            r12.disconnect()
        L_0x00e1:
            r11 = 0
            return r11
        L_0x00e3:
            r11 = move-exception
        L_0x00e4:
            if (r1 == 0) goto L_0x00ee
            r1.close()     // Catch:{ IOException -> 0x00ea }
            goto L_0x00ee
        L_0x00ea:
            r1 = move-exception
            r10.zze(r0, r1)
        L_0x00ee:
            if (r12 == 0) goto L_0x00f3
            r12.disconnect()
        L_0x00f3:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zzb(java.net.URL, byte[]):int");
    }

    @VisibleForTesting
    private final HttpURLConnection zzb(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(zzby.zzaad.get().intValue());
            httpURLConnection.setReadTimeout(zzby.zzaae.get().intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, this.zzabp);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    private final URL zzb(zzcd zzcd, String str) {
        String str2;
        StringBuilder sb;
        String str3;
        if (zzcd.zzfj()) {
            str2 = zzbq.zzet();
            str3 = zzbq.zzev();
            sb = new StringBuilder(C0681a.m336b(str, C0681a.m336b(str3, C0681a.m336b(str2, 1))));
        } else {
            str2 = zzbq.zzeu();
            str3 = zzbq.zzev();
            sb = new StringBuilder(C0681a.m336b(str, C0681a.m336b(str3, C0681a.m336b(str2, 1))));
        }
        sb.append(str2);
        sb.append(str3);
        sb.append("?");
        sb.append(str);
        try {
            return new URL(sb.toString());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzd(zzcd zzcd) {
        String str;
        String valueOf;
        String valueOf2;
        String str2;
        if (zzcd.zzfj()) {
            valueOf = String.valueOf(zzbq.zzet());
            valueOf2 = String.valueOf(zzbq.zzev());
            if (valueOf2.length() == 0) {
                str2 = new String(valueOf);
                str = str2;
                return new URL(str);
            }
        } else {
            valueOf = String.valueOf(zzbq.zzeu());
            valueOf2 = String.valueOf(zzbq.zzev());
            if (valueOf2.length() == 0) {
                str2 = new String(valueOf);
                str = str2;
                return new URL(str);
            }
        }
        str = valueOf.concat(valueOf2);
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private final URL zzfs() {
        String valueOf = String.valueOf(zzbq.zzet());
        String valueOf2 = String.valueOf(zzby.zzzs.get());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final String zza(zzcd zzcd, boolean z) {
        Preconditions.checkNotNull(zzcd);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : zzcd.zzdm().entrySet()) {
                String str = (String) next.getKey();
                if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str) && !"z".equals(str) && !"_gmsv".equals(str)) {
                    zza(sb, str, (String) next.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzcd.zzfh()));
            zza(sb, "qt", String.valueOf(zzcn().currentTimeMillis() - zzcd.zzfh()));
            if (z) {
                long zzfk = zzcd.zzfk();
                zza(sb, "z", zzfk != 0 ? String.valueOf(zzfk) : String.valueOf(zzcd.zzfg()));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaw() {
        zza("Network initialized. User agent", this.zzabp);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0153, code lost:
        if (zza(r5) == 200) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x018c, code lost:
        if (zza(r6, r5) == 200) goto L_0x012f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01a6 A[EDGE_INSN: B:73:0x01a6->B:70:0x01a6 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.Long> zzb(java.util.List<com.google.android.gms.internal.gtm.zzcd> r9) {
        /*
            r8 = this;
            com.google.android.gms.analytics.zzk.zzav()
            r8.zzdb()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            com.google.android.gms.internal.gtm.zzbq r0 = r8.zzcp()
            java.util.Set r0 = r0.zzew()
            boolean r0 = r0.isEmpty()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0058
            com.google.android.gms.internal.gtm.zzcv r0 = r8.zzabq
            com.google.android.gms.internal.gtm.zzbz<java.lang.Integer> r3 = com.google.android.gms.internal.gtm.zzby.zzaab
            java.lang.Object r3 = r3.get()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            long r3 = (long) r3
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 * r5
            boolean r0 = r0.zzj(r3)
            if (r0 != 0) goto L_0x0033
            goto L_0x0058
        L_0x0033:
            com.google.android.gms.internal.gtm.zzbz<java.lang.String> r0 = com.google.android.gms.internal.gtm.zzby.zzzu
            java.lang.Object r0 = r0.get()
            java.lang.String r0 = (java.lang.String) r0
            com.google.android.gms.internal.gtm.zzbg r0 = com.google.android.gms.internal.gtm.zzbg.zzz(r0)
            com.google.android.gms.internal.gtm.zzbg r3 = com.google.android.gms.internal.gtm.zzbg.NONE
            if (r0 == r3) goto L_0x0045
            r0 = 1
            goto L_0x0046
        L_0x0045:
            r0 = 0
        L_0x0046:
            com.google.android.gms.internal.gtm.zzbz<java.lang.String> r3 = com.google.android.gms.internal.gtm.zzby.zzzv
            java.lang.Object r3 = r3.get()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.internal.gtm.zzbm r3 = com.google.android.gms.internal.gtm.zzbm.zzaa(r3)
            com.google.android.gms.internal.gtm.zzbm r4 = com.google.android.gms.internal.gtm.zzbm.GZIP
            if (r3 != r4) goto L_0x0059
            r3 = 1
            goto L_0x005a
        L_0x0058:
            r0 = 0
        L_0x0059:
            r3 = 0
        L_0x005a:
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 == 0) goto L_0x00ff
            boolean r0 = r9.isEmpty()
            r0 = r0 ^ r2
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            int r1 = r9.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "Uploading batched hits. compression, count"
            r8.zza(r2, r0, r1)
            com.google.android.gms.internal.gtm.zzcl r0 = new com.google.android.gms.internal.gtm.zzcl
            r0.<init>(r8)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x0085:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x00a3
            java.lang.Object r2 = r9.next()
            com.google.android.gms.internal.gtm.zzcd r2 = (com.google.android.gms.internal.gtm.zzcd) r2
            boolean r5 = r0.zze(r2)
            if (r5 == 0) goto L_0x00a3
            long r5 = r2.zzfg()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            r1.add(r2)
            goto L_0x0085
        L_0x00a3:
            int r9 = r0.zzfu()
            if (r9 != 0) goto L_0x00aa
            return r1
        L_0x00aa:
            java.net.URL r9 = r8.zzfs()
            if (r9 != 0) goto L_0x00b6
            java.lang.String r9 = "Failed to build batching endpoint url"
            r8.zzu(r9)
            goto L_0x00fa
        L_0x00b6:
            byte[] r2 = r0.getPayload()
            if (r3 == 0) goto L_0x00c1
            int r9 = r8.zzb((java.net.URL) r9, (byte[]) r2)
            goto L_0x00c5
        L_0x00c1:
            int r9 = r8.zza((java.net.URL) r9, (byte[]) r2)
        L_0x00c5:
            if (r4 != r9) goto L_0x00d5
            int r9 = r0.zzfu()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = "Batched upload completed. Hits batched"
            r8.zza(r0, r9)
            return r1
        L_0x00d5:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            java.lang.String r1 = "Network error uploading hits. status code"
            r8.zza(r1, r0)
            com.google.android.gms.internal.gtm.zzbq r0 = r8.zzcp()
            java.util.Set r0 = r0.zzew()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            boolean r9 = r0.contains(r9)
            if (r9 == 0) goto L_0x00fa
            java.lang.String r9 = "Server instructed the client to stop batching"
            r8.zzt(r9)
            com.google.android.gms.internal.gtm.zzcv r9 = r8.zzabq
            r9.start()
        L_0x00fa:
            java.util.List r9 = java.util.Collections.emptyList()
            return r9
        L_0x00ff:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r3 = r9.size()
            r0.<init>(r3)
            java.util.Iterator r9 = r9.iterator()
        L_0x010c:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L_0x01a6
            java.lang.Object r3 = r9.next()
            com.google.android.gms.internal.gtm.zzcd r3 = (com.google.android.gms.internal.gtm.zzcd) r3
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            boolean r5 = r3.zzfj()
            r5 = r5 ^ r2
            java.lang.String r5 = r8.zza((com.google.android.gms.internal.gtm.zzcd) r3, (boolean) r5)
            if (r5 != 0) goto L_0x0131
            com.google.android.gms.internal.gtm.zzci r5 = r8.zzco()
            java.lang.String r6 = "Error formatting hit for upload"
        L_0x012c:
            r5.zza((com.google.android.gms.internal.gtm.zzcd) r3, (java.lang.String) r6)
        L_0x012f:
            r5 = 1
            goto L_0x018f
        L_0x0131:
            int r6 = r5.length()
            com.google.android.gms.internal.gtm.zzbz<java.lang.Integer> r7 = com.google.android.gms.internal.gtm.zzby.zzzt
            java.lang.Object r7 = r7.get()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r6 > r7) goto L_0x0158
            java.net.URL r5 = r8.zzb((com.google.android.gms.internal.gtm.zzcd) r3, (java.lang.String) r5)
            if (r5 != 0) goto L_0x014f
            java.lang.String r5 = "Failed to build collect GET endpoint url"
        L_0x014b:
            r8.zzu(r5)
            goto L_0x0156
        L_0x014f:
            int r5 = r8.zza((java.net.URL) r5)
            if (r5 != r4) goto L_0x0156
        L_0x0155:
            goto L_0x012f
        L_0x0156:
            r5 = 0
            goto L_0x018f
        L_0x0158:
            java.lang.String r5 = r8.zza((com.google.android.gms.internal.gtm.zzcd) r3, (boolean) r1)
            if (r5 != 0) goto L_0x0165
            com.google.android.gms.internal.gtm.zzci r5 = r8.zzco()
            java.lang.String r6 = "Error formatting hit for POST upload"
            goto L_0x012c
        L_0x0165:
            byte[] r5 = r5.getBytes()
            int r6 = r5.length
            com.google.android.gms.internal.gtm.zzbz<java.lang.Integer> r7 = com.google.android.gms.internal.gtm.zzby.zzzy
            java.lang.Object r7 = r7.get()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            if (r6 <= r7) goto L_0x017f
            com.google.android.gms.internal.gtm.zzci r5 = r8.zzco()
            java.lang.String r6 = "Hit payload exceeds size limit"
            goto L_0x012c
        L_0x017f:
            java.net.URL r6 = r8.zzd(r3)
            if (r6 != 0) goto L_0x0188
            java.lang.String r5 = "Failed to build collect POST endpoint url"
            goto L_0x014b
        L_0x0188:
            int r5 = r8.zza((java.net.URL) r6, (byte[]) r5)
            if (r5 != r4) goto L_0x0156
            goto L_0x0155
        L_0x018f:
            if (r5 == 0) goto L_0x01a6
            long r5 = r3.zzfg()
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            r0.add(r3)
            int r3 = r0.size()
            int r5 = com.google.android.gms.internal.gtm.zzbq.zzer()
            if (r3 < r5) goto L_0x010c
        L_0x01a6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzck.zzb(java.util.List):java.util.List");
    }

    public final boolean zzfr() {
        NetworkInfo networkInfo;
        zzk.zzav();
        zzdb();
        try {
            networkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzq("No network connectivity");
        return false;
    }
}
