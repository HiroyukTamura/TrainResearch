package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzbdw extends zzbdl {
    private static final Set<String> zzeha = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzehb = new DecimalFormat("#,###");
    private File zzco;
    private boolean zzehc;

    public zzbdw(zzbbx zzbbx) {
        super(zzbbx);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzazw.zzfc("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(cacheDir, "admobVideoStreams");
        this.zzco = file;
        if (!file.isDirectory() && !this.zzco.mkdirs()) {
            String valueOf = String.valueOf(this.zzco.getAbsolutePath());
            zzazw.zzfc(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzco = null;
        } else if (!this.zzco.setReadable(true, false) || !this.zzco.setExecutable(true, false)) {
            String valueOf2 = String.valueOf(this.zzco.getAbsolutePath());
            zzazw.zzfc(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzco = null;
        }
    }

    private final File zzc(File file) {
        return new File(this.zzco, String.valueOf(file.getName()).concat(".done"));
    }

    public final void abort() {
        this.zzehc = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01e9, code lost:
        if (r3 < 400) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01eb, code lost:
        r12 = "badUrl";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01fb, code lost:
        if (r2.length() == 0) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01fd, code lost:
        r2 = "HTTP request failed. Code: ".concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0203, code lost:
        r2 = new java.lang.String("HTTP request failed. Code: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        r5 = new java.lang.StringBuilder(java.lang.String.valueOf(r30).length() + 32);
        r5.append("HTTP status code ");
        r5.append(r3);
        r5.append(" at ");
        r5.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0230, code lost:
        throw new java.io.IOException(r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0231, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r14 = r13.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x023b, code lost:
        if (r14 >= 0) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
        r3 = java.lang.String.valueOf(r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0247, code lost:
        if (r3.length() == 0) goto L_0x024e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0249, code lost:
        r0 = "Stream cache aborted, missing content-length header at ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x024e, code lost:
        r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0254, code lost:
        com.google.android.gms.internal.ads.zzazw.zzfc(r0);
        zza(r9, r10.getAbsolutePath(), "contentLengthMissing", (java.lang.String) null);
        zzeha.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0265, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
        r3 = zzehb.format((long) r14);
        r15 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzvj.zzpv().zzd(com.google.android.gms.internal.ads.zzzz.zzcji)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x027d, code lost:
        if (r14 <= r15) goto L_0x02d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:?, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r3).length() + 33) + java.lang.String.valueOf(r30).length());
        r4.append("Content length ");
        r4.append(r3);
        r4.append(" exceeds limit at ");
        r4.append(r9);
        com.google.android.gms.internal.ads.zzazw.zzfc(r4.toString());
        r3 = java.lang.String.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02b8, code lost:
        if (r3.length() == 0) goto L_0x02bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02ba, code lost:
        r0 = "File too big for full file cache. Size: ".concat(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02bf, code lost:
        r0 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02c5, code lost:
        zza(r9, r10.getAbsolutePath(), "sizeExceeded", r0);
        zzeha.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02d3, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02d4, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:?, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r3).length() + 20) + java.lang.String.valueOf(r30).length());
        r4.append("Caching ");
        r4.append(r3);
        r4.append(" bytes from ");
        r4.append(r9);
        com.google.android.gms.internal.ads.zzazw.zzed(r4.toString());
        r13 = java.nio.channels.Channels.newChannel(r13.getInputStream());
        r7 = new java.io.FileOutputStream(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:?, code lost:
        r6 = r7.getChannel();
        r5 = java.nio.ByteBuffer.allocate(1048576);
        r16 = com.google.android.gms.ads.internal.zzq.zzld();
        r17 = r16.currentTimeMillis();
        r1 = new com.google.android.gms.internal.ads.zzazc(((java.lang.Long) com.google.android.gms.internal.ads.zzvj.zzpv().zzd(com.google.android.gms.internal.ads.zzzz.zzcjl)).longValue());
        r19 = ((java.lang.Long) com.google.android.gms.internal.ads.zzvj.zzpv().zzd(com.google.android.gms.internal.ads.zzzz.zzcjk)).longValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0349, code lost:
        r3 = r13.read(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x034d, code lost:
        if (r3 < 0) goto L_0x043e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x034f, code lost:
        r4 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0351, code lost:
        if (r4 <= r15) goto L_0x0384;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0353, code lost:
        r12 = "sizeExceeded";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0363, code lost:
        if (r1.length() == 0) goto L_0x036b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0365, code lost:
        r1 = "File too big for full file cache. Size: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x036b, code lost:
        r1 = new java.lang.String("File too big for full file cache. Size: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0377, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0378, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x037c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x037f, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0380, code lost:
        r2 = r1;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:?, code lost:
        r5.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x038b, code lost:
        if (r6.write(r5) > 0) goto L_0x0387;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x038d, code lost:
        r5.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x039c, code lost:
        if ((r16.currentTimeMillis() - r17) > (1000 * r19)) goto L_0x0406;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03a0, code lost:
        if (r8.zzehc != false) goto L_0x03f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03a6, code lost:
        if (r1.tryAcquire() == false) goto L_0x03de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03a8, code lost:
        r21 = r10.getAbsolutePath();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03b0, code lost:
        r23 = r1;
        r1 = r1;
        r24 = r1;
        r2 = r29;
        r25 = com.google.android.gms.internal.ads.zzazm.zzzn;
        r26 = r4;
        r4 = r21;
        r21 = r5;
        r27 = r6;
        r28 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:?, code lost:
        r1 = new com.google.android.gms.internal.ads.zzbdo(r2, r30, r4, r26, r14, false);
        r25.post(r24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03d7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x03d8, code lost:
        r28 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03dc, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03de, code lost:
        r23 = r1;
        r26 = r4;
        r21 = r5;
        r27 = r6;
        r28 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03e8, code lost:
        r5 = r21;
        r1 = r23;
        r2 = r26;
        r6 = r27;
        r7 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03f4, code lost:
        r28 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03ff, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0400, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0401, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0406, code lost:
        r28 = r7;
        r12 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:?, code lost:
        r0 = java.lang.Long.toString(r19);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
        r2 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0435, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0436, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x043a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x043c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x043e, code lost:
        r28 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:?, code lost:
        r28.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0448, code lost:
        if (com.google.android.gms.internal.ads.zzazw.isLoggable(3) == false) goto L_0x0480;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x044a, code lost:
        r1 = zzehb.format((long) r2);
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r30).length());
        r4.append("Preloaded ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r9);
        com.google.android.gms.internal.ads.zzazw.zzed(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0480, code lost:
        r10.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0489, code lost:
        if (r0.isFile() == false) goto L_0x0493;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x048b, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:?, code lost:
        r0.createNewFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:?, code lost:
        zza(r9, r10.getAbsolutePath(), r2);
        zzeha.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04a2, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04a4, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04a5, code lost:
        r1 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x04af, code lost:
        throw new java.io.IOException("Invalid protocol.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x04b7, code lost:
        throw new java.io.IOException("Too many redirects (20)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x04b8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04bb, code lost:
        r2 = null;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04bf, code lost:
        if ((r0 instanceof java.lang.RuntimeException) != false) goto L_0x04c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x04c1, code lost:
        com.google.android.gms.ads.internal.zzq.zzla().zza(r0, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x04d1, code lost:
        if (r8.zzehc != false) goto L_0x04d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x04d3, code lost:
        r1 = new java.lang.StringBuilder(p009e.p010a.p011a.p012a.C0681a.m336b(r9, 26));
        r1.append("Preload aborted for URL \"");
        r1.append(r9);
        r1.append("\"");
        com.google.android.gms.internal.ads.zzazw.zzfb(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x04f3, code lost:
        r3 = new java.lang.StringBuilder(p009e.p010a.p011a.p012a.C0681a.m336b(r9, 25));
        r3.append("Preload failed for URL \"");
        r3.append(r9);
        r3.append("\"");
        com.google.android.gms.internal.ads.zzazw.zzd(r3.toString(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x051e, code lost:
        r1 = java.lang.String.valueOf(r10.getAbsolutePath());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x052c, code lost:
        if (r1.length() != 0) goto L_0x052e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x052e, code lost:
        r0 = "Could not delete partial cache file at ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0533, code lost:
        r0 = new java.lang.String("Could not delete partial cache file at ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0539, code lost:
        com.google.android.gms.internal.ads.zzazw.zzfc(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x053c, code lost:
        zza(r9, r10.getAbsolutePath(), r12, r2);
        zzeha.remove(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0549, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012e, code lost:
        r12 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        com.google.android.gms.ads.internal.zzq.zzli();
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzvj.zzpv().zzd(com.google.android.gms.internal.ads.zzzz.zzcjm)).intValue();
        r5 = new java.net.URL(r9);
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0149, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014c, code lost:
        if (r6 > 20) goto L_0x04b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014e, code lost:
        r13 = r5.openConnection();
        r13.setConnectTimeout(r3);
        r13.setReadTimeout(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015a, code lost:
        if ((r13 instanceof java.net.HttpURLConnection) == false) goto L_0x04a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x015c, code lost:
        r13 = (java.net.HttpURLConnection) r13;
        r14 = new com.google.android.gms.internal.ads.zzazq();
        r14.zza(r13, (byte[]) null);
        r13.setInstanceFollowRedirects(false);
        r15 = r13.getResponseCode();
        r14.zza(r13, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0173, code lost:
        if ((r15 / 100) != 3) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r7 = r13.getHeaderField("Location");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x017b, code lost:
        if (r7 == null) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x017d, code lost:
        r14 = new java.net.URL(r5, r7);
        r5 = r14.getProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0186, code lost:
        if (r5 == null) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x018e, code lost:
        if (r5.equals("http") != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0196, code lost:
        if (r5.equals("https") != false) goto L_0x01b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a0, code lost:
        if (r5.length() == 0) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01a2, code lost:
        r2 = "Unsupported scheme: ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01a7, code lost:
        r2 = new java.lang.String("Unsupported scheme: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b0, code lost:
        throw new java.io.IOException(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01b7, code lost:
        if (r7.length() == 0) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b9, code lost:
        r5 = "Redirecting to ".concat(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01be, code lost:
        r5 = new java.lang.String("Redirecting to ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01c4, code lost:
        com.google.android.gms.internal.ads.zzazw.zzed(r5);
        r13.disconnect();
        r5 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01d4, code lost:
        throw new java.io.IOException("Protocol is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01dc, code lost:
        throw new java.io.IOException("Missing Location header in redirect");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01dd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        r3 = r13.getResponseCode();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:200:0x0496 */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x043a A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r12 r28 
      PHI: (r12v5 java.lang.String) = (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v0 java.lang.String), (r12v7 java.lang.String), (r12v0 java.lang.String) binds: [B:136:0x0312, B:191:0x0441, B:200:0x0496, B:201:?, B:198:0x0493, B:199:?, B:182:0x040a, B:167:0x03cc] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r28v3 java.io.FileOutputStream) = (r28v5 java.io.FileOutputStream), (r28v5 java.io.FileOutputStream), (r28v5 java.io.FileOutputStream), (r28v5 java.io.FileOutputStream), (r28v5 java.io.FileOutputStream), (r28v6 java.io.FileOutputStream), (r28v10 java.io.FileOutputStream) binds: [B:191:0x0441, B:200:0x0496, B:201:?, B:198:0x0493, B:199:?, B:182:0x040a, B:167:0x03cc] A[DONT_GENERATE, DONT_INLINE], Splitter:B:167:0x03cc] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x04c1  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x04d3  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x04f3  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x0533  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfl(java.lang.String r30) {
        /*
            r29 = this;
            r8 = r29
            r9 = r30
            java.io.File r0 = r8.zzco
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L_0x000e
            java.lang.String r0 = "noCacheDir"
            goto L_0x0091
        L_0x000e:
            java.io.File r0 = r8.zzco
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0031
        L_0x0014:
            java.io.File[] r0 = r0.listFiles()
            int r3 = r0.length
            r4 = 0
            r5 = 0
        L_0x001b:
            if (r4 >= r3) goto L_0x0030
            r6 = r0[r4]
            java.lang.String r6 = r6.getName()
            java.lang.String r7 = ".done"
            boolean r6 = r6.endsWith(r7)
            if (r6 != 0) goto L_0x002d
            int r5 = r5 + 1
        L_0x002d:
            int r4 = r4 + 1
            goto L_0x001b
        L_0x0030:
            r0 = r5
        L_0x0031:
            com.google.android.gms.internal.ads.zzzk<java.lang.Integer> r3 = com.google.android.gms.internal.ads.zzzz.zzcjh
            com.google.android.gms.internal.ads.zzzv r4 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r0 <= r3) goto L_0x0095
            java.io.File r0 = r8.zzco
            if (r0 != 0) goto L_0x0048
            goto L_0x0087
        L_0x0048:
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.io.File[] r0 = r0.listFiles()
            int r5 = r0.length
            r6 = 0
            r7 = r1
        L_0x0054:
            if (r6 >= r5) goto L_0x0071
            r10 = r0[r6]
            java.lang.String r11 = r10.getName()
            java.lang.String r12 = ".done"
            boolean r11 = r11.endsWith(r12)
            if (r11 != 0) goto L_0x006e
            long r11 = r10.lastModified()
            int r13 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x006e
            r7 = r10
            r3 = r11
        L_0x006e:
            int r6 = r6 + 1
            goto L_0x0054
        L_0x0071:
            if (r7 == 0) goto L_0x0087
            boolean r0 = r7.delete()
            java.io.File r3 = r8.zzc(r7)
            boolean r4 = r3.isFile()
            if (r4 == 0) goto L_0x0088
            boolean r3 = r3.delete()
            r0 = r0 & r3
            goto L_0x0088
        L_0x0087:
            r0 = 0
        L_0x0088:
            if (r0 != 0) goto L_0x000e
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.internal.ads.zzazw.zzfc(r0)
            java.lang.String r0 = "expireFailed"
        L_0x0091:
            r8.zza(r9, r1, r0, r1)
            return r2
        L_0x0095:
            java.lang.String r0 = r29.zzfm(r30)
            java.io.File r10 = new java.io.File
            java.io.File r3 = r8.zzco
            r10.<init>(r3, r0)
            java.io.File r0 = r8.zzc(r10)
            boolean r3 = r10.isFile()
            r4 = 1
            if (r3 == 0) goto L_0x00d8
            boolean r3 = r0.isFile()
            if (r3 == 0) goto L_0x00d8
            long r0 = r10.length()
            int r1 = (int) r0
            java.lang.String r0 = "Stream cache hit at "
            java.lang.String r2 = java.lang.String.valueOf(r30)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00c7
            java.lang.String r0 = r0.concat(r2)
            goto L_0x00cd
        L_0x00c7:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0)
            r0 = r2
        L_0x00cd:
            com.google.android.gms.internal.ads.zzazw.zzed(r0)
            java.lang.String r0 = r10.getAbsolutePath()
            r8.zza((java.lang.String) r9, (java.lang.String) r0, (int) r1)
            return r4
        L_0x00d8:
            java.io.File r3 = r8.zzco
            java.lang.String r3 = r3.getAbsolutePath()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = java.lang.String.valueOf(r30)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x00f2
            java.lang.String r3 = r3.concat(r5)
            r11 = r3
            goto L_0x00f8
        L_0x00f2:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r3)
            r11 = r5
        L_0x00f8:
            java.util.Set<java.lang.String> r3 = zzeha
            monitor-enter(r3)
            java.util.Set<java.lang.String> r5 = zzeha     // Catch:{ all -> 0x054a }
            boolean r5 = r5.contains(r11)     // Catch:{ all -> 0x054a }
            if (r5 == 0) goto L_0x0128
            java.lang.String r0 = "Stream cache already in progress at "
            java.lang.String r4 = java.lang.String.valueOf(r30)     // Catch:{ all -> 0x054a }
            int r5 = r4.length()     // Catch:{ all -> 0x054a }
            if (r5 == 0) goto L_0x0114
            java.lang.String r0 = r0.concat(r4)     // Catch:{ all -> 0x054a }
            goto L_0x011a
        L_0x0114:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x054a }
            r4.<init>(r0)     // Catch:{ all -> 0x054a }
            r0 = r4
        L_0x011a:
            com.google.android.gms.internal.ads.zzazw.zzfc(r0)     // Catch:{ all -> 0x054a }
            java.lang.String r0 = r10.getAbsolutePath()     // Catch:{ all -> 0x054a }
            java.lang.String r4 = "inProgress"
            r8.zza(r9, r0, r4, r1)     // Catch:{ all -> 0x054a }
            monitor-exit(r3)     // Catch:{ all -> 0x054a }
            return r2
        L_0x0128:
            java.util.Set<java.lang.String> r5 = zzeha     // Catch:{ all -> 0x054a }
            r5.add(r11)     // Catch:{ all -> 0x054a }
            monitor-exit(r3)     // Catch:{ all -> 0x054a }
            java.lang.String r12 = "error"
            com.google.android.gms.ads.internal.zzq.zzli()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            com.google.android.gms.internal.ads.zzzk<java.lang.Integer> r3 = com.google.android.gms.internal.ads.zzzz.zzcjm     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            com.google.android.gms.internal.ads.zzzv r5 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.lang.Object r3 = r5.zzd(r3)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            int r3 = r3.intValue()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.net.URL r5 = new java.net.URL     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r5.<init>(r9)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r6 = 0
        L_0x0149:
            int r6 = r6 + r4
            r7 = 20
            if (r6 > r7) goto L_0x04b0
            java.net.URLConnection r13 = r5.openConnection()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r13.setConnectTimeout(r3)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r13.setReadTimeout(r3)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            boolean r14 = r13 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            if (r14 == 0) goto L_0x04a8
            java.net.HttpURLConnection r13 = (java.net.HttpURLConnection) r13     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            com.google.android.gms.internal.ads.zzazq r14 = new com.google.android.gms.internal.ads.zzazq     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r14.<init>()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r14.zza((java.net.HttpURLConnection) r13, (byte[]) r1)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r13.setInstanceFollowRedirects(r2)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            int r15 = r13.getResponseCode()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r14.zza((java.net.HttpURLConnection) r13, (int) r15)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            int r15 = r15 / 100
            r14 = 3
            if (r15 != r14) goto L_0x01e3
            java.lang.String r7 = "Location"
            java.lang.String r7 = r13.getHeaderField(r7)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            if (r7 == 0) goto L_0x01d5
            java.net.URL r14 = new java.net.URL     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r14.<init>(r5, r7)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r5 = r14.getProtocol()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            if (r5 == 0) goto L_0x01cd
            java.lang.String r15 = "http"
            boolean r15 = r5.equals(r15)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            if (r15 != 0) goto L_0x01b1
            java.lang.String r15 = "https"
            boolean r15 = r5.equals(r15)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            if (r15 != 0) goto L_0x01b1
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r2 = "Unsupported scheme: "
            int r3 = r5.length()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            if (r3 == 0) goto L_0x01a7
            java.lang.String r2 = r2.concat(r5)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            goto L_0x01ad
        L_0x01a7:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r3.<init>(r2)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r2 = r3
        L_0x01ad:
            r0.<init>(r2)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            throw r0     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
        L_0x01b1:
            java.lang.String r5 = "Redirecting to "
            int r15 = r7.length()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            if (r15 == 0) goto L_0x01be
            java.lang.String r5 = r5.concat(r7)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            goto L_0x01c4
        L_0x01be:
            java.lang.String r7 = new java.lang.String     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r7.<init>(r5)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r5 = r7
        L_0x01c4:
            com.google.android.gms.internal.ads.zzazw.zzed(r5)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r13.disconnect()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r5 = r14
            goto L_0x0149
        L_0x01cd:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r2 = "Protocol is null"
            r0.<init>(r2)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            throw r0     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
        L_0x01d5:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r2 = "Missing Location header in redirect"
            r0.<init>(r2)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            throw r0     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
        L_0x01dd:
            r0 = move-exception
            goto L_0x02d4
        L_0x01e0:
            r0 = move-exception
            goto L_0x02d4
        L_0x01e3:
            int r3 = r13.getResponseCode()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r4 = 400(0x190, float:5.6E-43)
            if (r3 < r4) goto L_0x0237
            java.lang.String r12 = "badUrl"
            java.lang.String r0 = "HTTP request failed. Code: "
            java.lang.String r2 = java.lang.Integer.toString(r3)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            int r4 = r2.length()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            if (r4 == 0) goto L_0x0203
            java.lang.String r0 = r0.concat(r2)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r2 = r0
            goto L_0x0208
        L_0x0203:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
        L_0x0208:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            java.lang.String r4 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            int r4 = r4.length()     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            int r4 = r4 + 32
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            java.lang.String r4 = "HTTP status code "
            r5.append(r4)     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            r5.append(r3)     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            java.lang.String r3 = " at "
            r5.append(r3)     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            r5.append(r9)     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            java.lang.String r3 = r5.toString()     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
            throw r0     // Catch:{ IOException -> 0x0234, RuntimeException -> 0x0231 }
        L_0x0231:
            r0 = move-exception
            goto L_0x04bd
        L_0x0234:
            r0 = move-exception
            goto L_0x04bd
        L_0x0237:
            int r14 = r13.getContentLength()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            if (r14 >= 0) goto L_0x0266
            java.lang.String r0 = "Stream cache aborted, missing content-length header at "
            java.lang.String r3 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            int r4 = r3.length()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            if (r4 == 0) goto L_0x024e
            java.lang.String r0 = r0.concat(r3)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            goto L_0x0254
        L_0x024e:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r3.<init>(r0)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r0 = r3
        L_0x0254:
            com.google.android.gms.internal.ads.zzazw.zzfc(r0)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r0 = r10.getAbsolutePath()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r3 = "contentLengthMissing"
            r8.zza(r9, r0, r3, r1)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.util.Set<java.lang.String> r0 = zzeha     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r0.remove(r11)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            return r2
        L_0x0266:
            java.text.DecimalFormat r3 = zzehb     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            long r4 = (long) r14     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.lang.String r3 = r3.format(r4)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            com.google.android.gms.internal.ads.zzzk<java.lang.Integer> r4 = com.google.android.gms.internal.ads.zzzz.zzcji     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            com.google.android.gms.internal.ads.zzzv r5 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            int r15 = r4.intValue()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            if (r14 <= r15) goto L_0x02d7
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            int r0 = r0.length()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            int r0 = r0 + 33
            java.lang.String r4 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            int r4 = r4.length()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            int r0 = r0 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r4.<init>(r0)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r0 = "Content length "
            r4.append(r0)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r4.append(r3)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r0 = " exceeds limit at "
            r4.append(r0)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r4.append(r9)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            com.google.android.gms.internal.ads.zzazw.zzfc(r0)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            int r4 = r3.length()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            if (r4 == 0) goto L_0x02bf
            java.lang.String r0 = r0.concat(r3)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            goto L_0x02c5
        L_0x02bf:
            java.lang.String r3 = new java.lang.String     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r3.<init>(r0)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r0 = r3
        L_0x02c5:
            java.lang.String r3 = r10.getAbsolutePath()     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.lang.String r4 = "sizeExceeded"
            r8.zza(r9, r3, r4, r0)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            java.util.Set<java.lang.String> r0 = zzeha     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            r0.remove(r11)     // Catch:{ IOException -> 0x01e0, RuntimeException -> 0x01dd }
            return r2
        L_0x02d4:
            r2 = r1
            goto L_0x04bd
        L_0x02d7:
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            int r1 = r1.length()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            int r1 = r1 + r7
            java.lang.String r4 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            int r4 = r4.length()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            int r1 = r1 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.lang.String r1 = "Caching "
            r4.append(r1)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r4.append(r3)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.lang.String r1 = " bytes from "
            r4.append(r1)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r4.append(r9)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            com.google.android.gms.internal.ads.zzazw.zzed(r1)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.io.InputStream r1 = r13.getInputStream()     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.nio.channels.ReadableByteChannel r13 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            r7.<init>(r10)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.nio.channels.FileChannel r6 = r7.getChannel()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzq.zzld()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            long r17 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzzz.zzcjl     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            com.google.android.gms.internal.ads.zzzv r3 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            java.lang.Object r1 = r3.zzd(r1)     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            long r3 = r1.longValue()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            com.google.android.gms.internal.ads.zzazc r1 = new com.google.android.gms.internal.ads.zzazc     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            r1.<init>(r3)     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            com.google.android.gms.internal.ads.zzzk<java.lang.Long> r3 = com.google.android.gms.internal.ads.zzzz.zzcjk     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            com.google.android.gms.internal.ads.zzzv r4 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            java.lang.Object r3 = r4.zzd(r3)     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            long r19 = r3.longValue()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
        L_0x0349:
            int r3 = r13.read(r5)     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            if (r3 < 0) goto L_0x043e
            int r4 = r2 + r3
            if (r4 <= r15) goto L_0x0384
            java.lang.String r12 = "sizeExceeded"
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.Integer.toString(r4)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            int r2 = r1.length()     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            if (r2 == 0) goto L_0x036b
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r1 = r0
            goto L_0x0370
        L_0x036b:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
            r1.<init>(r0)     // Catch:{ IOException -> 0x037e, RuntimeException -> 0x037c }
        L_0x0370:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            java.lang.String r2 = "stream cache file size limit exceeded"
            r0.<init>(r2)     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            throw r0     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
        L_0x0378:
            r0 = move-exception
            goto L_0x0380
        L_0x037a:
            r0 = move-exception
            goto L_0x0380
        L_0x037c:
            r0 = move-exception
            goto L_0x037f
        L_0x037e:
            r0 = move-exception
        L_0x037f:
            r1 = 0
        L_0x0380:
            r2 = r1
            r1 = r7
            goto L_0x04bd
        L_0x0384:
            r5.flip()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
        L_0x0387:
            int r2 = r6.write(r5)     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            if (r2 > 0) goto L_0x0387
            r5.clear()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            long r2 = r16.currentTimeMillis()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            long r2 = r2 - r17
            r21 = 1000(0x3e8, double:4.94E-321)
            long r21 = r21 * r19
            int r23 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r23 > 0) goto L_0x0406
            boolean r2 = r8.zzehc     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            if (r2 != 0) goto L_0x03f4
            boolean r2 = r1.tryAcquire()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            if (r2 == 0) goto L_0x03de
            java.lang.String r21 = r10.getAbsolutePath()     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            android.os.Handler r3 = com.google.android.gms.internal.ads.zzazm.zzzn     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            com.google.android.gms.internal.ads.zzbdo r2 = new com.google.android.gms.internal.ads.zzbdo     // Catch:{ IOException -> 0x03dc, RuntimeException -> 0x03d7 }
            r22 = 0
            r23 = r1
            r1 = r2
            r24 = r2
            r2 = r29
            r25 = r3
            r3 = r30
            r26 = r4
            r4 = r21
            r21 = r5
            r5 = r26
            r27 = r6
            r6 = r14
            r28 = r7
            r7 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            r2 = r24
            r1 = r25
            r1.post(r2)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            goto L_0x03e8
        L_0x03d7:
            r0 = move-exception
        L_0x03d8:
            r28 = r7
            goto L_0x04a4
        L_0x03dc:
            r0 = move-exception
            goto L_0x03d8
        L_0x03de:
            r23 = r1
            r26 = r4
            r21 = r5
            r27 = r6
            r28 = r7
        L_0x03e8:
            r5 = r21
            r1 = r23
            r2 = r26
            r6 = r27
            r7 = r28
            goto L_0x0349
        L_0x03f4:
            r28 = r7
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0404, RuntimeException -> 0x0400 }
            java.lang.String r2 = "abort requested"
            r0.<init>(r2)     // Catch:{ IOException -> 0x0404, RuntimeException -> 0x0400 }
            throw r0     // Catch:{ IOException -> 0x0404, RuntimeException -> 0x0400 }
        L_0x0400:
            r0 = move-exception
        L_0x0401:
            r12 = r1
            goto L_0x04a4
        L_0x0404:
            r0 = move-exception
            goto L_0x0401
        L_0x0406:
            r28 = r7
            java.lang.String r12 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r19)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            int r1 = r1.length()     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            int r1 = r1 + 29
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            r2.<init>(r1)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r2.append(r1)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            r2.append(r0)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.lang.String r0 = " sec"
            r2.append(r0)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0438, RuntimeException -> 0x0436 }
            java.lang.String r1 = "stream cache time limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0438, RuntimeException -> 0x0436 }
            throw r0     // Catch:{ IOException -> 0x0438, RuntimeException -> 0x0436 }
        L_0x0436:
            r0 = move-exception
            goto L_0x04a5
        L_0x0438:
            r0 = move-exception
            goto L_0x04a5
        L_0x043a:
            r0 = move-exception
            goto L_0x04a4
        L_0x043c:
            r0 = move-exception
            goto L_0x04a4
        L_0x043e:
            r28 = r7
            r1 = 3
            r28.close()     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            boolean r1 = com.google.android.gms.internal.ads.zzazw.isLoggable(r1)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            if (r1 == 0) goto L_0x0480
            java.text.DecimalFormat r1 = zzehb     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            long r3 = (long) r2     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.lang.String r1 = r1.format(r3)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            int r3 = r3.length()     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            int r3 = r3 + 22
            java.lang.String r4 = java.lang.String.valueOf(r30)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            int r4 = r4.length()     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            r4.<init>(r3)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.lang.String r3 = "Preloaded "
            r4.append(r3)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            r4.append(r1)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.lang.String r1 = " bytes from "
            r4.append(r1)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            r4.append(r9)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            com.google.android.gms.internal.ads.zzazw.zzed(r1)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
        L_0x0480:
            r1 = 1
            r3 = 0
            r10.setReadable(r1, r3)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            boolean r1 = r0.isFile()     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            if (r1 == 0) goto L_0x0493
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            r0.setLastModified(r3)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            goto L_0x0496
        L_0x0493:
            r0.createNewFile()     // Catch:{ IOException -> 0x0496, RuntimeException -> 0x043a }
        L_0x0496:
            java.lang.String r0 = r10.getAbsolutePath()     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            r8.zza((java.lang.String) r9, (java.lang.String) r0, (int) r2)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            java.util.Set<java.lang.String> r0 = zzeha     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            r0.remove(r11)     // Catch:{ IOException -> 0x043c, RuntimeException -> 0x043a }
            r0 = 1
            return r0
        L_0x04a4:
            r2 = 0
        L_0x04a5:
            r1 = r28
            goto L_0x04bd
        L_0x04a8:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.lang.String r1 = "Invalid protocol."
            r0.<init>(r1)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            throw r0     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
        L_0x04b0:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            java.lang.String r1 = "Too many redirects (20)"
            r0.<init>(r1)     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
            throw r0     // Catch:{ IOException -> 0x04ba, RuntimeException -> 0x04b8 }
        L_0x04b8:
            r0 = move-exception
            goto L_0x04bb
        L_0x04ba:
            r0 = move-exception
        L_0x04bb:
            r2 = 0
            r1 = 0
        L_0x04bd:
            boolean r3 = r0 instanceof java.lang.RuntimeException
            if (r3 == 0) goto L_0x04ca
            com.google.android.gms.internal.ads.zzawd r3 = com.google.android.gms.ads.internal.zzq.zzla()
            java.lang.String r4 = "VideoStreamFullFileCache.preload"
            r3.zza(r0, r4)
        L_0x04ca:
            r1.close()     // Catch:{ IOException | NullPointerException -> 0x04ce }
            goto L_0x04cf
        L_0x04ce:
        L_0x04cf:
            boolean r1 = r8.zzehc
            if (r1 == 0) goto L_0x04f3
            r0 = 26
            int r0 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r9, (int) r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Preload aborted for URL \""
            r1.append(r0)
            r1.append(r9)
            java.lang.String r0 = "\""
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzazw.zzfb(r0)
            goto L_0x0512
        L_0x04f3:
            r1 = 25
            int r1 = p009e.p010a.p011a.p012a.C0681a.m336b((java.lang.String) r9, (int) r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = "Preload failed for URL \""
            r3.append(r1)
            r3.append(r9)
            java.lang.String r1 = "\""
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzazw.zzd(r1, r0)
        L_0x0512:
            boolean r0 = r10.exists()
            if (r0 == 0) goto L_0x053c
            boolean r0 = r10.delete()
            if (r0 != 0) goto L_0x053c
            java.lang.String r0 = "Could not delete partial cache file at "
            java.lang.String r1 = r10.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r3 = r1.length()
            if (r3 == 0) goto L_0x0533
            java.lang.String r0 = r0.concat(r1)
            goto L_0x0539
        L_0x0533:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r0)
            r0 = r1
        L_0x0539:
            com.google.android.gms.internal.ads.zzazw.zzfc(r0)
        L_0x053c:
            java.lang.String r0 = r10.getAbsolutePath()
            r8.zza(r9, r0, r12, r2)
            java.util.Set<java.lang.String> r0 = zzeha
            r0.remove(r11)
            r0 = 0
            return r0
        L_0x054a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x054a }
            goto L_0x054e
        L_0x054d:
            throw r0
        L_0x054e:
            goto L_0x054d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdw.zzfl(java.lang.String):boolean");
    }
}
