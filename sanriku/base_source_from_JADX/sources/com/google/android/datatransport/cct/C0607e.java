package com.google.android.datatransport.cct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006b.C0570a;
import com.google.android.datatransport.cct.p006b.C0572b;
import com.google.android.datatransport.cct.p006b.C0591j;
import com.google.android.datatransport.cct.p006b.C0592k;
import com.google.android.datatransport.cct.p006b.C0595l;
import com.google.android.datatransport.cct.p006b.C0597m;
import com.google.android.datatransport.cct.p006b.C0600o;
import com.google.android.datatransport.cct.p006b.C0604p;
import com.google.android.datatransport.runtime.backends.C0618f;
import com.google.android.datatransport.runtime.backends.C0620g;
import com.google.android.datatransport.runtime.backends.C0628m;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.C0875b;
import p009e.p028d.p030b.p031a.p032i.C0895f;
import p009e.p028d.p030b.p031a.p032i.C0896g;
import p009e.p028d.p030b.p031a.p032i.p033s.C0913a;
import p009e.p028d.p030b.p031a.p032i.p034t.C0914a;
import p009e.p028d.p030b.p031a.p032i.p034t.C0915b;
import p009e.p028d.p030b.p031a.p032i.p038w.C0968a;

/* renamed from: com.google.android.datatransport.cct.e */
final class C0607e implements C0628m {

    /* renamed from: a */
    private final DataEncoder f245a = new JsonDataEncoderBuilder().configureWith(C0572b.f129a).ignoreNullValues(true).build();

    /* renamed from: b */
    private final ConnectivityManager f246b;

    /* renamed from: c */
    final URL f247c;

    /* renamed from: d */
    private final C0968a f248d;

    /* renamed from: e */
    private final C0968a f249e;

    /* renamed from: f */
    private final int f250f;

    /* renamed from: com.google.android.datatransport.cct.e$a */
    static final class C0608a {

        /* renamed from: a */
        final URL f251a;

        /* renamed from: b */
        final C0591j f252b;
        @Nullable

        /* renamed from: c */
        final String f253c;

        C0608a(URL url, C0591j jVar, @Nullable String str) {
            this.f251a = url;
            this.f252b = jVar;
            this.f253c = str;
        }
    }

    /* renamed from: com.google.android.datatransport.cct.e$b */
    static final class C0609b {

        /* renamed from: a */
        final int f254a;
        @Nullable

        /* renamed from: b */
        final URL f255b;

        /* renamed from: c */
        final long f256c;

        C0609b(int i, @Nullable URL url, long j) {
            this.f254a = i;
            this.f255b = url;
            this.f256c = j;
        }
    }

    C0607e(Context context, C0968a aVar, C0968a aVar2) {
        this.f246b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f247c = m194a(C0569a.f122c);
        this.f248d = aVar2;
        this.f249e = aVar;
        this.f250f = 40000;
    }

    /* renamed from: a */
    private static URL m194a(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(C0681a.m320a("Invalid url: ", str), e);
        }
    }

    /* renamed from: a */
    public C0620g mo9523a(C0618f fVar) {
        Object a;
        C0595l.C0596a aVar;
        HashMap hashMap = new HashMap();
        for (C0896g next : fVar.mo9526a()) {
            String f = next.mo20295f();
            if (!hashMap.containsKey(f)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                hashMap.put(f, arrayList);
            } else {
                ((List) hashMap.get(f)).add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            C0896g gVar = (C0896g) ((List) entry.getValue()).get(0);
            C0597m.C0598a h = C0597m.m161h();
            h.mo9499a(C0604p.DEFAULT);
            h.mo9497a(this.f249e.mo20396a());
            h.mo9504b(this.f248d.mo20396a());
            C0592k.C0593a c = C0592k.m140c();
            c.mo9467a(C0592k.C0594b.ANDROID_FIREBASE);
            C0570a.C0571a i = C0570a.m61i();
            i.mo9443a(Integer.valueOf(gVar.mo20340b("sdk-version")));
            i.mo9449e(gVar.mo20339a("model"));
            i.mo9447c(gVar.mo20339a("hardware"));
            i.mo9444a(gVar.mo20339a("device"));
            i.mo9451g(gVar.mo20339a("product"));
            i.mo9450f(gVar.mo20339a("os-uild"));
            i.mo9448d(gVar.mo20339a("manufacturer"));
            i.mo9446b(gVar.mo20339a("fingerprint"));
            c.mo9466a(i.mo9445a());
            h.mo9498a(c.mo9468a());
            try {
                h.mo9517a(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                h.mo9518b((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (C0896g gVar2 : (List) entry.getValue()) {
                C0895f c2 = gVar2.mo20292c();
                C0875b b = c2.mo20335b();
                if (b.equals(C0875b.m1149a("proto"))) {
                    aVar = C0595l.m147a(c2.mo20334a());
                } else if (b.equals(C0875b.m1149a("json"))) {
                    aVar = C0595l.m146a(new String(c2.mo20334a(), Charset.forName("UTF-8")));
                } else {
                    C0913a.m1252b("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b);
                }
                aVar.mo9479a(gVar2.mo20293d());
                aVar.mo9485b(gVar2.mo20296g());
                aVar.mo9486c(gVar2.mo20341c("tz-offset"));
                C0600o.C0601a c3 = C0600o.m181c();
                c3.mo9515a(C0600o.C0603c.m188a(gVar2.mo20340b("net-type")));
                c3.mo9514a(C0600o.C0602b.m187a(gVar2.mo20340b("mobile-subtype")));
                aVar.mo9480a(c3.mo9516a());
                if (gVar2.mo20291b() != null) {
                    aVar.mo9481a(gVar2.mo20291b());
                }
                arrayList3.add(aVar.mo9484a());
            }
            h.mo9502a((List<C0595l>) arrayList3);
            arrayList2.add(h.mo9503a());
        }
        C0591j a2 = C0591j.m138a(arrayList2);
        String str = null;
        URL url = this.f247c;
        if (fVar.mo9527b() != null) {
            try {
                C0569a a3 = C0569a.m57a(fVar.mo9527b());
                if (a3.mo9431b() != null) {
                    str = a3.mo9431b();
                }
                if (a3.mo9432c() != null) {
                    url = m194a(a3.mo9432c());
                }
            } catch (IllegalArgumentException unused2) {
                return C0620g.m215c();
            }
        }
        int i2 = 5;
        try {
            Object aVar2 = new C0608a(url, a2, str);
            C0914a a4 = C0605c.m189a(this);
            C0915b a5 = C0606d.m191a();
            do {
                a = ((C0605c) a4).mo9521a(aVar2);
                aVar2 = ((C0606d) a5).mo9522a(aVar2, a);
                if (aVar2 == null || i2 - 1 < 1) {
                    C0609b bVar = (C0609b) a;
                }
                a = ((C0605c) a4).mo9521a(aVar2);
                aVar2 = ((C0606d) a5).mo9522a(aVar2, a);
                break;
            } while (i2 - 1 < 1);
            C0609b bVar2 = (C0609b) a;
            if (bVar2.f254a == 200) {
                return C0620g.m214a(bVar2.f256c);
            }
            int i3 = bVar2.f254a;
            if (i3 < 500) {
                if (i3 != 404) {
                    return C0620g.m215c();
                }
            }
            return C0620g.m216d();
        } catch (IOException e) {
            C0913a.m1250a("CctTransportBackend", "Could not make request to the backend", (Throwable) e);
            return C0620g.m216d();
        }
    }

    /* renamed from: a */
    public C0896g mo9524a(C0896g gVar) {
        int i;
        C0600o.C0602b bVar;
        NetworkInfo activeNetworkInfo = this.f246b.getActiveNetworkInfo();
        C0896g.C0897a h = gVar.mo20343h();
        h.mo20344a("sdk-version", Build.VERSION.SDK_INT);
        h.mo20346a("model", Build.MODEL);
        h.mo20346a("hardware", Build.HARDWARE);
        h.mo20346a("device", Build.DEVICE);
        h.mo20346a("product", Build.PRODUCT);
        h.mo20346a("os-uild", Build.ID);
        h.mo20346a("manufacturer", Build.MANUFACTURER);
        h.mo20346a("fingerprint", Build.FINGERPRINT);
        Calendar.getInstance();
        h.mo20345a("tz-offset", (long) (TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000));
        h.mo20344a("net-type", activeNetworkInfo == null ? C0600o.C0603c.NONE.zza() : activeNetworkInfo.getType());
        if (activeNetworkInfo == null) {
            bVar = C0600o.C0602b.UNKNOWN_MOBILE_SUBTYPE;
        } else {
            i = activeNetworkInfo.getSubtype();
            if (i == -1) {
                bVar = C0600o.C0602b.COMBINED;
            } else {
                if (C0600o.C0602b.m187a(i) == null) {
                    i = 0;
                }
                h.mo20344a("mobile-subtype", i);
                return h.mo20304a();
            }
        }
        i = bVar.zza();
        h.mo20344a("mobile-subtype", i);
        return h.mo20304a();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x011a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0138 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x013f */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.google.android.datatransport.cct.C0607e.C0609b m193a(com.google.android.datatransport.cct.C0607e r12, com.google.android.datatransport.cct.C0607e.C0608a r13) {
        /*
            r0 = 0
            if (r12 == 0) goto L_0x0160
            java.net.URL r1 = r13.f251a
            java.lang.String r2 = "CctTransportBackend"
            java.lang.String r3 = "Making request to: %s"
            p009e.p028d.p030b.p031a.p032i.p033s.C0913a.m1249a((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r1)
            java.net.URL r1 = r13.f251a
            java.net.URLConnection r1 = r1.openConnection()
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
            r3 = 30000(0x7530, float:4.2039E-41)
            r1.setConnectTimeout(r3)
            int r3 = r12.f250f
            r1.setReadTimeout(r3)
            r3 = 1
            r1.setDoOutput(r3)
            r4 = 0
            r1.setInstanceFollowRedirects(r4)
            java.lang.String r5 = "POST"
            r1.setRequestMethod(r5)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r5 = "2.3.0"
            r3[r4] = r5
            java.lang.String r4 = "datatransport/%s android/"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            java.lang.String r4 = "User-Agent"
            r1.setRequestProperty(r4, r3)
            java.lang.String r3 = "gzip"
            java.lang.String r4 = "Content-Encoding"
            r1.setRequestProperty(r4, r3)
            java.lang.String r5 = "Content-Type"
            java.lang.String r6 = "application/json"
            r1.setRequestProperty(r5, r6)
            java.lang.String r6 = "Accept-Encoding"
            r1.setRequestProperty(r6, r3)
            java.lang.String r6 = r13.f253c
            if (r6 == 0) goto L_0x0058
            java.lang.String r7 = "X-Goog-Api-Key"
            r1.setRequestProperty(r7, r6)
        L_0x0058:
            r6 = 0
            java.io.OutputStream r8 = r1.getOutputStream()     // Catch:{ ConnectException -> 0x0152, UnknownHostException -> 0x0150, EncodingException -> 0x0142, IOException -> 0x0140 }
            java.util.zip.GZIPOutputStream r9 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0139 }
            r9.<init>(r8)     // Catch:{ all -> 0x0139 }
            com.google.firebase.encoders.DataEncoder r12 = r12.f245a     // Catch:{ all -> 0x0134 }
            com.google.android.datatransport.cct.b.j r13 = r13.f252b     // Catch:{ all -> 0x0134 }
            java.io.BufferedWriter r10 = new java.io.BufferedWriter     // Catch:{ all -> 0x0134 }
            java.io.OutputStreamWriter r11 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0134 }
            r11.<init>(r9)     // Catch:{ all -> 0x0134 }
            r10.<init>(r11)     // Catch:{ all -> 0x0134 }
            r12.encode(r13, r10)     // Catch:{ all -> 0x0134 }
            r9.close()     // Catch:{ all -> 0x0139 }
            if (r8 == 0) goto L_0x007c
            r8.close()     // Catch:{ ConnectException -> 0x0152, UnknownHostException -> 0x0150, EncodingException -> 0x0142, IOException -> 0x0140 }
        L_0x007c:
            int r12 = r1.getResponseCode()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r8 = "Status Code: "
            r13.append(r8)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            p009e.p028d.p030b.p031a.p032i.p033s.C0913a.m1248a(r2, r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r8 = "Content-Type: "
            r13.append(r8)
            java.lang.String r5 = r1.getHeaderField(r5)
            r13.append(r5)
            java.lang.String r13 = r13.toString()
            p009e.p028d.p030b.p031a.p032i.p033s.C0913a.m1248a(r2, r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r5 = "Content-Encoding: "
            r13.append(r5)
            java.lang.String r5 = r1.getHeaderField(r4)
            r13.append(r5)
            java.lang.String r13 = r13.toString()
            p009e.p028d.p030b.p031a.p032i.p033s.C0913a.m1248a(r2, r13)
            r13 = 302(0x12e, float:4.23E-43)
            if (r12 == r13) goto L_0x0122
            r13 = 301(0x12d, float:4.22E-43)
            if (r12 == r13) goto L_0x0122
            r13 = 307(0x133, float:4.3E-43)
            if (r12 != r13) goto L_0x00d1
            goto L_0x0122
        L_0x00d1:
            r13 = 200(0xc8, float:2.8E-43)
            if (r12 == r13) goto L_0x00dc
            com.google.android.datatransport.cct.e$b r13 = new com.google.android.datatransport.cct.e$b
            r13.<init>(r12, r0, r6)
            goto L_0x015f
        L_0x00dc:
            java.io.InputStream r13 = r1.getInputStream()
            java.lang.String r1 = r1.getHeaderField(r4)     // Catch:{ all -> 0x011b }
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x011b }
            if (r1 == 0) goto L_0x00f0
            java.util.zip.GZIPInputStream r1 = new java.util.zip.GZIPInputStream     // Catch:{ all -> 0x011b }
            r1.<init>(r13)     // Catch:{ all -> 0x011b }
            goto L_0x00f1
        L_0x00f0:
            r1 = r13
        L_0x00f1:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0114 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0114 }
            r3.<init>(r1)     // Catch:{ all -> 0x0114 }
            r2.<init>(r3)     // Catch:{ all -> 0x0114 }
            com.google.android.datatransport.cct.b.n r2 = com.google.android.datatransport.cct.p006b.C0599n.m179a(r2)     // Catch:{ all -> 0x0114 }
            long r2 = r2.mo9505a()     // Catch:{ all -> 0x0114 }
            com.google.android.datatransport.cct.e$b r4 = new com.google.android.datatransport.cct.e$b     // Catch:{ all -> 0x0114 }
            r4.<init>(r12, r0, r2)     // Catch:{ all -> 0x0114 }
            if (r1 == 0) goto L_0x010d
            r1.close()     // Catch:{ all -> 0x011b }
        L_0x010d:
            if (r13 == 0) goto L_0x0112
            r13.close()
        L_0x0112:
            r13 = r4
            goto L_0x015f
        L_0x0114:
            r12 = move-exception
            if (r1 == 0) goto L_0x011a
            r1.close()     // Catch:{ all -> 0x011a }
        L_0x011a:
            throw r12     // Catch:{ all -> 0x011b }
        L_0x011b:
            r12 = move-exception
            if (r13 == 0) goto L_0x0121
            r13.close()     // Catch:{ all -> 0x0121 }
        L_0x0121:
            throw r12
        L_0x0122:
            java.lang.String r13 = "Location"
            java.lang.String r13 = r1.getHeaderField(r13)
            com.google.android.datatransport.cct.e$b r0 = new com.google.android.datatransport.cct.e$b
            java.net.URL r1 = new java.net.URL
            r1.<init>(r13)
            r0.<init>(r12, r1, r6)
            r13 = r0
            goto L_0x015f
        L_0x0134:
            r12 = move-exception
            r9.close()     // Catch:{ all -> 0x0138 }
        L_0x0138:
            throw r12     // Catch:{ all -> 0x0139 }
        L_0x0139:
            r12 = move-exception
            if (r8 == 0) goto L_0x013f
            r8.close()     // Catch:{ all -> 0x013f }
        L_0x013f:
            throw r12     // Catch:{ ConnectException -> 0x0152, UnknownHostException -> 0x0150, EncodingException -> 0x0142, IOException -> 0x0140 }
        L_0x0140:
            r12 = move-exception
            goto L_0x0143
        L_0x0142:
            r12 = move-exception
        L_0x0143:
            java.lang.String r13 = "Couldn't encode request, returning with 400"
            p009e.p028d.p030b.p031a.p032i.p033s.C0913a.m1250a((java.lang.String) r2, (java.lang.String) r13, (java.lang.Throwable) r12)
            com.google.android.datatransport.cct.e$b r13 = new com.google.android.datatransport.cct.e$b
            r12 = 400(0x190, float:5.6E-43)
            r13.<init>(r12, r0, r6)
            goto L_0x015f
        L_0x0150:
            r12 = move-exception
            goto L_0x0153
        L_0x0152:
            r12 = move-exception
        L_0x0153:
            java.lang.String r13 = "Couldn't open connection, returning with 500"
            p009e.p028d.p030b.p031a.p032i.p033s.C0913a.m1250a((java.lang.String) r2, (java.lang.String) r13, (java.lang.Throwable) r12)
            com.google.android.datatransport.cct.e$b r13 = new com.google.android.datatransport.cct.e$b
            r12 = 500(0x1f4, float:7.0E-43)
            r13.<init>(r12, r0, r6)
        L_0x015f:
            return r13
        L_0x0160:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.C0607e.m193a(com.google.android.datatransport.cct.e, com.google.android.datatransport.cct.e$a):com.google.android.datatransport.cct.e$b");
    }
}
