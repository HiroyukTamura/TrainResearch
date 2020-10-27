package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Log;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public final class zznx implements zznu {
    private static final Pattern zzbfo = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference<byte[]> zzbfp = new AtomicReference<>();
    private final boolean zzbfq;
    private final int zzbfr;
    private final int zzbfs;
    private final String zzbft;
    private final zzou<String> zzbfu = null;
    private final zzoc zzbfv;
    private final zzoc zzbfw;
    private final zzoi<? super zznx> zzbfx;
    private zznv zzbfy;
    private HttpURLConnection zzbfz;
    private InputStream zzbga;
    private boolean zzbgb;
    private long zzbgc;
    private long zzbgd;
    private long zzbge;
    private long zzcf;

    public zznx(String str, zzou<String> zzou, zzoi<? super zznx> zzoi, int i, int i2, boolean z, zzoc zzoc) {
        this.zzbft = zzoh.checkNotEmpty(str);
        this.zzbfx = zzoi;
        this.zzbfw = new zzoc();
        this.zzbfr = i;
        this.zzbfs = i2;
        this.zzbfq = true;
        this.zzbfv = null;
    }

    private final HttpURLConnection zza(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.zzbfr);
        httpURLConnection.setReadTimeout(this.zzbfs);
        for (Map.Entry next : this.zzbfw.zzis().entrySet()) {
            httpURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            String sb2 = sb.toString();
            if (j2 != -1) {
                String valueOf = String.valueOf(sb2);
                StringBuilder sb3 = new StringBuilder(valueOf.length() + 20);
                sb3.append(valueOf);
                sb3.append((j + j2) - 1);
                sb2 = sb3.toString();
            }
            httpURLConnection.setRequestProperty("Range", sb2);
        }
        httpURLConnection.setRequestProperty(AbstractSpiCall.HEADER_USER_AGENT, this.zzbft);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long zzc(java.net.HttpURLConnection r10) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r10.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            java.lang.String r3 = "DefaultHttpDataSource"
            if (r1 != 0) goto L_0x0032
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x0015 }
            goto L_0x0034
        L_0x0015:
            r1 = 28
            int r1 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r0, (int) r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = "Unexpected Content-Length ["
            r4.append(r1)
            r4.append(r0)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            android.util.Log.e(r3, r1)
        L_0x0032:
            r4 = -1
        L_0x0034:
            java.lang.String r1 = "Content-Range"
            java.lang.String r10 = r10.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x00c2
            java.util.regex.Pattern r1 = zzbfo
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r6 = r1.find()
            if (r6 == 0) goto L_0x00c2
            r6 = 2
            java.lang.String r6 = r1.group(r6)     // Catch:{ NumberFormatException -> 0x00a5 }
            long r6 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x00a5 }
            r8 = 1
            java.lang.String r1 = r1.group(r8)     // Catch:{ NumberFormatException -> 0x00a5 }
            long r8 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x00a5 }
            long r6 = r6 - r8
            r8 = 1
            long r6 = r6 + r8
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x006a
            r4 = r6
            goto L_0x00c2
        L_0x006a:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x00c2
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x00a5 }
            int r1 = r1.length()     // Catch:{ NumberFormatException -> 0x00a5 }
            int r1 = r1 + 26
            java.lang.String r8 = java.lang.String.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00a5 }
            int r8 = r8.length()     // Catch:{ NumberFormatException -> 0x00a5 }
            int r1 = r1 + r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00a5 }
            r8.<init>(r1)     // Catch:{ NumberFormatException -> 0x00a5 }
            java.lang.String r1 = "Inconsistent headers ["
            r8.append(r1)     // Catch:{ NumberFormatException -> 0x00a5 }
            r8.append(r0)     // Catch:{ NumberFormatException -> 0x00a5 }
            java.lang.String r0 = "] ["
            r8.append(r0)     // Catch:{ NumberFormatException -> 0x00a5 }
            r8.append(r10)     // Catch:{ NumberFormatException -> 0x00a5 }
            r8.append(r2)     // Catch:{ NumberFormatException -> 0x00a5 }
            java.lang.String r0 = r8.toString()     // Catch:{ NumberFormatException -> 0x00a5 }
            android.util.Log.w(r3, r0)     // Catch:{ NumberFormatException -> 0x00a5 }
            long r4 = java.lang.Math.max(r4, r6)     // Catch:{ NumberFormatException -> 0x00a5 }
            goto L_0x00c2
        L_0x00a5:
            r0 = 27
            int r0 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r10, (int) r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Unexpected Content-Range ["
            r1.append(r0)
            r1.append(r10)
            r1.append(r2)
            java.lang.String r10 = r1.toString()
            android.util.Log.e(r3, r10)
        L_0x00c2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznx.zzc(java.net.HttpURLConnection):long");
    }

    private final void zzip() {
        HttpURLConnection httpURLConnection = this.zzbfz;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.zzbfz = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:4|(1:6)(1:7)|8|(5:13|14|(2:16|(1:18))(1:19)|21|(1:25))|26|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r3 > android.support.p001v4.media.session.PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) goto L_0x003a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() throws com.google.android.gms.internal.ads.zzoa {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r9.zzbga     // Catch:{ all -> 0x008e }
            if (r2 == 0) goto L_0x007b
            java.net.HttpURLConnection r2 = r9.zzbfz     // Catch:{ all -> 0x008e }
            long r3 = r9.zzbgd     // Catch:{ all -> 0x008e }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0013
            long r3 = r9.zzbgd     // Catch:{ all -> 0x008e }
            goto L_0x0018
        L_0x0013:
            long r3 = r9.zzbgd     // Catch:{ all -> 0x008e }
            long r7 = r9.zzcf     // Catch:{ all -> 0x008e }
            long r3 = r3 - r7
        L_0x0018:
            int r7 = com.google.android.gms.internal.ads.zzov.SDK_INT     // Catch:{ all -> 0x008e }
            r8 = 19
            if (r7 == r8) goto L_0x0024
            int r7 = com.google.android.gms.internal.ads.zzov.SDK_INT     // Catch:{ all -> 0x008e }
            r8 = 20
            if (r7 != r8) goto L_0x006b
        L_0x0024:
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x006b }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0034
            int r3 = r2.read()     // Catch:{ Exception -> 0x006b }
            r4 = -1
            if (r3 != r4) goto L_0x003a
            goto L_0x006b
        L_0x0034:
            r5 = 2048(0x800, double:1.0118E-320)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x006b
        L_0x003a:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = r3.getName()     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r3.equals(r4)     // Catch:{ Exception -> 0x006b }
            if (r4 != 0) goto L_0x0052
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r3.equals(r4)     // Catch:{ Exception -> 0x006b }
            if (r3 == 0) goto L_0x006b
        L_0x0052:
            java.lang.Class r3 = r2.getClass()     // Catch:{ Exception -> 0x006b }
            java.lang.Class r3 = r3.getSuperclass()     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x006b }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch:{ Exception -> 0x006b }
            r4 = 1
            r3.setAccessible(r4)     // Catch:{ Exception -> 0x006b }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x006b }
            r3.invoke(r2, r4)     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            java.io.InputStream r2 = r9.zzbga     // Catch:{ IOException -> 0x0071 }
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x007b
        L_0x0071:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzoa r3 = new com.google.android.gms.internal.ads.zzoa     // Catch:{ all -> 0x008e }
            com.google.android.gms.internal.ads.zznv r4 = r9.zzbfy     // Catch:{ all -> 0x008e }
            r5 = 3
            r3.<init>((java.io.IOException) r2, (com.google.android.gms.internal.ads.zznv) r4, (int) r5)     // Catch:{ all -> 0x008e }
            throw r3     // Catch:{ all -> 0x008e }
        L_0x007b:
            r9.zzbga = r0
            r9.zzip()
            boolean r0 = r9.zzbgb
            if (r0 == 0) goto L_0x008d
            r9.zzbgb = r1
            com.google.android.gms.internal.ads.zzoi<? super com.google.android.gms.internal.ads.zznx> r0 = r9.zzbfx
            if (r0 == 0) goto L_0x008d
            r0.zze(r9)
        L_0x008d:
            return
        L_0x008e:
            r2 = move-exception
            r9.zzbga = r0
            r9.zzip()
            boolean r0 = r9.zzbgb
            if (r0 == 0) goto L_0x00a1
            r9.zzbgb = r1
            com.google.android.gms.internal.ads.zzoi<? super com.google.android.gms.internal.ads.zznx> r0 = r9.zzbfx
            if (r0 == 0) goto L_0x00a1
            r0.zze(r9)
        L_0x00a1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznx.close():void");
    }

    public final Map<String, List<String>> getResponseHeaders() {
        HttpURLConnection httpURLConnection = this.zzbfz;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    public final Uri getUri() {
        HttpURLConnection httpURLConnection = this.zzbfz;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final int read(byte[] bArr, int i, int i2) throws zzoa {
        try {
            if (this.zzbge != this.zzbgc) {
                byte[] andSet = zzbfp.getAndSet((Object) null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (this.zzbge != this.zzbgc) {
                    int read = this.zzbga.read(andSet, 0, (int) Math.min(this.zzbgc - this.zzbge, (long) andSet.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    } else if (read != -1) {
                        this.zzbge += (long) read;
                        if (this.zzbfx != null) {
                            this.zzbfx.zzc(this, read);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
                zzbfp.set(andSet);
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.zzbgd != -1) {
                long j = this.zzbgd - this.zzcf;
                if (j == 0) {
                    return -1;
                }
                i2 = (int) Math.min((long) i2, j);
            }
            int read2 = this.zzbga.read(bArr, i, i2);
            if (read2 != -1) {
                this.zzcf += (long) read2;
                if (this.zzbfx != null) {
                    this.zzbfx.zzc(this, read2);
                }
                return read2;
            } else if (this.zzbgd == -1) {
                return -1;
            } else {
                throw new EOFException();
            }
        } catch (IOException e) {
            throw new zzoa(e, this.zzbfy, 2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zznv r25) throws com.google.android.gms.internal.ads.zzoa {
        /*
            r24 = this;
            r10 = r24
            r11 = r25
            java.lang.String r12 = "Unable to connect to "
            r10.zzbfy = r11
            r13 = 0
            r10.zzcf = r13
            r10.zzbge = r13
            r15 = 1
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x018c }
            android.net.Uri r0 = r11.uri     // Catch:{ IOException -> 0x018c }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x018c }
            r2.<init>(r0)     // Catch:{ IOException -> 0x018c }
            byte[] r3 = r11.zzbfm     // Catch:{ IOException -> 0x018c }
            long r8 = r11.position     // Catch:{ IOException -> 0x018c }
            long r6 = r11.zzce     // Catch:{ IOException -> 0x018c }
            boolean r0 = r11.isFlagSet(r15)     // Catch:{ IOException -> 0x018c }
            boolean r1 = r10.zzbfq     // Catch:{ IOException -> 0x018c }
            r4 = 0
            if (r1 != 0) goto L_0x0036
            r16 = 1
            r1 = r24
            r4 = r8
            r8 = r0
            r9 = r16
            java.net.HttpURLConnection r0 = r1.zza(r2, r3, r4, r6, r8, r9)     // Catch:{ IOException -> 0x018c }
            goto L_0x0078
        L_0x0036:
            r4 = r2
            r16 = r3
            r1 = 0
        L_0x003a:
            int r5 = r1 + 1
            r2 = 20
            if (r1 > r2) goto L_0x016f
            r17 = 0
            r1 = r24
            r2 = r4
            r3 = r16
            r19 = r4
            r18 = r5
            r4 = r8
            r20 = r6
            r22 = r8
            r8 = r0
            r9 = r17
            java.net.HttpURLConnection r1 = r1.zza(r2, r3, r4, r6, r8, r9)     // Catch:{ IOException -> 0x018c }
            int r2 = r1.getResponseCode()     // Catch:{ IOException -> 0x018c }
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 == r3) goto L_0x011a
            r3 = 301(0x12d, float:4.22E-43)
            if (r2 == r3) goto L_0x011a
            r3 = 302(0x12e, float:4.23E-43)
            if (r2 == r3) goto L_0x011a
            r3 = 303(0x12f, float:4.25E-43)
            if (r2 == r3) goto L_0x011a
            if (r16 != 0) goto L_0x0077
            r3 = 307(0x133, float:4.3E-43)
            if (r2 == r3) goto L_0x011a
            r3 = 308(0x134, float:4.32E-43)
            if (r2 != r3) goto L_0x0077
            goto L_0x011a
        L_0x0077:
            r0 = r1
        L_0x0078:
            r10.zzbfz = r0     // Catch:{ IOException -> 0x018c }
            int r0 = r0.getResponseCode()     // Catch:{ IOException -> 0x00f5 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 < r1) goto L_0x00d9
            r2 = 299(0x12b, float:4.19E-43)
            if (r0 <= r2) goto L_0x0087
            goto L_0x00d9
        L_0x0087:
            java.net.HttpURLConnection r2 = r10.zzbfz
            r2.getContentType()
            if (r0 != r1) goto L_0x0095
            long r0 = r11.position
            int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r2 == 0) goto L_0x0095
            r13 = r0
        L_0x0095:
            r10.zzbgc = r13
            boolean r0 = r11.isFlagSet(r15)
            if (r0 != 0) goto L_0x00b7
            long r0 = r11.zzce
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00a6
            goto L_0x00b9
        L_0x00a6:
            java.net.HttpURLConnection r0 = r10.zzbfz
            long r0 = zzc(r0)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00b4
            long r2 = r10.zzbgc
            long r2 = r0 - r2
        L_0x00b4:
            r10.zzbgd = r2
            goto L_0x00bb
        L_0x00b7:
            long r0 = r11.zzce
        L_0x00b9:
            r10.zzbgd = r0
        L_0x00bb:
            java.net.HttpURLConnection r0 = r10.zzbfz     // Catch:{ IOException -> 0x00cf }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x00cf }
            r10.zzbga = r0     // Catch:{ IOException -> 0x00cf }
            r10.zzbgb = r15
            com.google.android.gms.internal.ads.zzoi<? super com.google.android.gms.internal.ads.zznx> r0 = r10.zzbfx
            if (r0 == 0) goto L_0x00cc
            r0.zza(r10, r11)
        L_0x00cc:
            long r0 = r10.zzbgd
            return r0
        L_0x00cf:
            r0 = move-exception
            r24.zzip()
            com.google.android.gms.internal.ads.zzoa r1 = new com.google.android.gms.internal.ads.zzoa
            r1.<init>((java.io.IOException) r0, (com.google.android.gms.internal.ads.zznv) r11, (int) r15)
            throw r1
        L_0x00d9:
            java.net.HttpURLConnection r1 = r10.zzbfz
            java.util.Map r1 = r1.getHeaderFields()
            r24.zzip()
            com.google.android.gms.internal.ads.zznz r2 = new com.google.android.gms.internal.ads.zznz
            r2.<init>(r0, r1, r11)
            r1 = 416(0x1a0, float:5.83E-43)
            if (r0 != r1) goto L_0x00f4
            com.google.android.gms.internal.ads.zznw r0 = new com.google.android.gms.internal.ads.zznw
            r3 = 0
            r0.<init>(r3)
            r2.initCause(r0)
        L_0x00f4:
            throw r2
        L_0x00f5:
            r0 = move-exception
            r1 = r0
            r24.zzip()
            com.google.android.gms.internal.ads.zzoa r0 = new com.google.android.gms.internal.ads.zzoa
            android.net.Uri r2 = r11.uri
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x0111
            java.lang.String r2 = r12.concat(r2)
            goto L_0x0116
        L_0x0111:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r12)
        L_0x0116:
            r0.<init>(r2, r1, r11, r15)
            throw r0
        L_0x011a:
            r3 = 0
            r16 = 0
            java.lang.String r2 = "Location"
            java.lang.String r2 = r1.getHeaderField(r2)     // Catch:{ IOException -> 0x018c }
            r1.disconnect()     // Catch:{ IOException -> 0x018c }
            if (r2 == 0) goto L_0x0167
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x018c }
            r1 = r19
            r4.<init>(r1, r2)     // Catch:{ IOException -> 0x018c }
            java.lang.String r1 = r4.getProtocol()     // Catch:{ IOException -> 0x018c }
            java.lang.String r2 = "https"
            boolean r2 = r2.equals(r1)     // Catch:{ IOException -> 0x018c }
            if (r2 != 0) goto L_0x015f
            java.lang.String r2 = "http"
            boolean r2 = r2.equals(r1)     // Catch:{ IOException -> 0x018c }
            if (r2 != 0) goto L_0x015f
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x018c }
            java.lang.String r2 = "Unsupported protocol redirect: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x018c }
            int r3 = r1.length()     // Catch:{ IOException -> 0x018c }
            if (r3 == 0) goto L_0x0156
            java.lang.String r1 = r2.concat(r1)     // Catch:{ IOException -> 0x018c }
            goto L_0x015b
        L_0x0156:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x018c }
            r1.<init>(r2)     // Catch:{ IOException -> 0x018c }
        L_0x015b:
            r0.<init>(r1)     // Catch:{ IOException -> 0x018c }
            throw r0     // Catch:{ IOException -> 0x018c }
        L_0x015f:
            r1 = r18
            r6 = r20
            r8 = r22
            goto L_0x003a
        L_0x0167:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x018c }
            java.lang.String r1 = "Null location redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x018c }
            throw r0     // Catch:{ IOException -> 0x018c }
        L_0x016f:
            r18 = r5
            java.net.NoRouteToHostException r0 = new java.net.NoRouteToHostException     // Catch:{ IOException -> 0x018c }
            r1 = 31
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018c }
            r2.<init>(r1)     // Catch:{ IOException -> 0x018c }
            java.lang.String r1 = "Too many redirects: "
            r2.append(r1)     // Catch:{ IOException -> 0x018c }
            r1 = r18
            r2.append(r1)     // Catch:{ IOException -> 0x018c }
            java.lang.String r1 = r2.toString()     // Catch:{ IOException -> 0x018c }
            r0.<init>(r1)     // Catch:{ IOException -> 0x018c }
            throw r0     // Catch:{ IOException -> 0x018c }
        L_0x018c:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzoa r1 = new com.google.android.gms.internal.ads.zzoa
            android.net.Uri r2 = r11.uri
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x01a4
            java.lang.String r2 = r12.concat(r2)
            goto L_0x01a9
        L_0x01a4:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r12)
        L_0x01a9:
            r1.<init>(r2, r0, r11, r15)
            goto L_0x01ae
        L_0x01ad:
            throw r1
        L_0x01ae:
            goto L_0x01ad
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznx.zza(com.google.android.gms.internal.ads.zznv):long");
    }
}
