package p040i;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.BuildConfig;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\t"}, mo21739d2 = {"Lokhttp3/CipherSuite;", "", "javaName", "", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "toString", "Companion", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.j */
public final class C1931j {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Comparator<String> f2783b = new C1932a();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Map<String, C1931j> f2784c = new LinkedHashMap();
    @JvmField

    /* renamed from: d */
    public static final C1931j f2785d = C1933b.m3325a(f2801t, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    @JvmField

    /* renamed from: e */
    public static final C1931j f2786e = C1933b.m3325a(f2801t, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    @JvmField

    /* renamed from: f */
    public static final C1931j f2787f = C1933b.m3325a(f2801t, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    @JvmField

    /* renamed from: g */
    public static final C1931j f2788g = C1933b.m3325a(f2801t, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    @JvmField

    /* renamed from: h */
    public static final C1931j f2789h = C1933b.m3325a(f2801t, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    @JvmField

    /* renamed from: i */
    public static final C1931j f2790i = C1933b.m3325a(f2801t, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    @JvmField

    /* renamed from: j */
    public static final C1931j f2791j = C1933b.m3325a(f2801t, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    @JvmField

    /* renamed from: k */
    public static final C1931j f2792k = C1933b.m3325a(f2801t, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    @JvmField

    /* renamed from: l */
    public static final C1931j f2793l = C1933b.m3325a(f2801t, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    @JvmField

    /* renamed from: m */
    public static final C1931j f2794m = C1933b.m3325a(f2801t, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    @JvmField

    /* renamed from: n */
    public static final C1931j f2795n = C1933b.m3325a(f2801t, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    @JvmField

    /* renamed from: o */
    public static final C1931j f2796o = C1933b.m3325a(f2801t, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    @JvmField

    /* renamed from: p */
    public static final C1931j f2797p = C1933b.m3325a(f2801t, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    @JvmField

    /* renamed from: q */
    public static final C1931j f2798q = C1933b.m3325a(f2801t, "TLS_AES_128_GCM_SHA256", 4865);
    @JvmField

    /* renamed from: r */
    public static final C1931j f2799r = C1933b.m3325a(f2801t, "TLS_AES_256_GCM_SHA384", 4866);
    @JvmField

    /* renamed from: s */
    public static final C1931j f2800s = C1933b.m3325a(f2801t, "TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* renamed from: t */
    public static final C1933b f2801t = new C1933b((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final String f2802a;

    /* renamed from: i.j$a */
    public static final class C1932a implements Comparator<String> {
        C1932a() {
        }

        public int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            Intrinsics.checkParameterIsNotNull(str, "a");
            Intrinsics.checkParameterIsNotNull(str2, "b");
            int min = Math.min(str.length(), str2.length());
            int i = 4;
            while (true) {
                if (i < min) {
                    char charAt = str.charAt(i);
                    char charAt2 = str2.charAt(i);
                    if (charAt == charAt2) {
                        i++;
                    } else if (charAt < charAt2) {
                        return -1;
                    }
                } else {
                    int length = str.length();
                    int length2 = str2.length();
                    if (length == length2) {
                        return 0;
                    }
                    if (length < length2) {
                        return -1;
                    }
                }
            }
            return 1;
        }
    }

    /* renamed from: i.j$b */
    public static final class C1933b {
        public /* synthetic */ C1933b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static final /* synthetic */ C1931j m3325a(C1933b bVar, String str, int i) {
            if (bVar != null) {
                C1931j jVar = new C1931j(str, (DefaultConstructorMarker) null);
                C1931j.f2784c.put(str, jVar);
                return jVar;
            }
            throw null;
        }

        /* renamed from: b */
        private final String m3326b(String str) {
            StringBuilder sb;
            if (StringsKt__StringsJVMKt.startsWith$default(str, "TLS_", false, 2, (Object) null)) {
                sb = C0681a.m330a("SSL_");
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (!StringsKt__StringsJVMKt.startsWith$default(str, "SSL_", false, 2, (Object) null)) {
                return str;
            } else {
                sb = C0681a.m330a("TLS_");
                if (str == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            String substring = str.substring(4);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            return sb.toString();
        }

        @JvmStatic
        /* renamed from: a */
        public final synchronized C1931j mo28076a(String str) {
            C1931j jVar;
            Intrinsics.checkParameterIsNotNull(str, "javaName");
            jVar = (C1931j) C1931j.f2784c.get(str);
            if (jVar == null) {
                jVar = (C1931j) C1931j.f2784c.get(m3326b(str));
                if (jVar == null) {
                    jVar = new C1931j(str, (DefaultConstructorMarker) null);
                }
                C1931j.f2784c.put(str, jVar);
            }
            return jVar;
        }
    }

    static {
        C1933b.m3325a(f2801t, "SSL_RSA_WITH_NULL_MD5", 1);
        C1933b.m3325a(f2801t, "SSL_RSA_WITH_NULL_SHA", 2);
        C1933b.m3325a(f2801t, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        C1933b.m3325a(f2801t, "SSL_RSA_WITH_RC4_128_MD5", 4);
        C1933b.m3325a(f2801t, "SSL_RSA_WITH_RC4_128_SHA", 5);
        C1933b.m3325a(f2801t, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        C1933b.m3325a(f2801t, "SSL_RSA_WITH_DES_CBC_SHA", 9);
        C1933b.m3325a(f2801t, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        C1933b.m3325a(f2801t, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        C1933b.m3325a(f2801t, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        C1933b.m3325a(f2801t, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        C1933b.m3325a(f2801t, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        C1933b.m3325a(f2801t, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        C1933b.m3325a(f2801t, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        C1933b.m3325a(f2801t, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
        C1933b.m3325a(f2801t, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        C1933b.m3325a(f2801t, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        C1933b.m3325a(f2801t, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        C1933b.m3325a(f2801t, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
        C1933b.m3325a(f2801t, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        C1933b.m3325a(f2801t, "TLS_KRB5_WITH_RC4_128_SHA", 32);
        C1933b.m3325a(f2801t, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
        C1933b.m3325a(f2801t, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        C1933b.m3325a(f2801t, "TLS_KRB5_WITH_RC4_128_MD5", 36);
        C1933b.m3325a(f2801t, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        C1933b.m3325a(f2801t, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        C1933b.m3325a(f2801t, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        C1933b.m3325a(f2801t, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        C1933b.m3325a(f2801t, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        C1933b.m3325a(f2801t, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        C1933b.m3325a(f2801t, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        C1933b.m3325a(f2801t, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        C1933b.m3325a(f2801t, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        C1933b.m3325a(f2801t, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        C1933b.m3325a(f2801t, "TLS_RSA_WITH_NULL_SHA256", 59);
        C1933b.m3325a(f2801t, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        C1933b.m3325a(f2801t, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        C1933b.m3325a(f2801t, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        C1933b.m3325a(f2801t, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        C1933b.m3325a(f2801t, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        C1933b.m3325a(f2801t, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        C1933b.m3325a(f2801t, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        C1933b.m3325a(f2801t, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        C1933b.m3325a(f2801t, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        C1933b.m3325a(f2801t, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        C1933b.m3325a(f2801t, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        C1933b.m3325a(f2801t, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        C1933b.m3325a(f2801t, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        C1933b.m3325a(f2801t, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", BuildConfig.VERSION_CODE);
        C1933b.m3325a(f2801t, "TLS_PSK_WITH_RC4_128_SHA", 138);
        C1933b.m3325a(f2801t, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        C1933b.m3325a(f2801t, "TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        C1933b.m3325a(f2801t, "TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        C1933b.m3325a(f2801t, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
        C1933b.m3325a(f2801t, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        C1933b.m3325a(f2801t, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        C1933b.m3325a(f2801t, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        C1933b.m3325a(f2801t, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        C1933b.m3325a(f2801t, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        C1933b.m3325a(f2801t, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        C1933b.m3325a(f2801t, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        C1933b.m3325a(f2801t, "TLS_FALLBACK_SCSV", 22016);
        C1933b.m3325a(f2801t, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        C1933b.m3325a(f2801t, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        C1933b.m3325a(f2801t, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        C1933b.m3325a(f2801t, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        C1933b.m3325a(f2801t, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        C1933b.m3325a(f2801t, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        C1933b.m3325a(f2801t, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        C1933b.m3325a(f2801t, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        C1933b.m3325a(f2801t, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        C1933b.m3325a(f2801t, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        C1933b.m3325a(f2801t, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        C1933b.m3325a(f2801t, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        C1933b.m3325a(f2801t, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        C1933b.m3325a(f2801t, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        C1933b.m3325a(f2801t, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        C1933b.m3325a(f2801t, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        C1933b.m3325a(f2801t, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        C1933b.m3325a(f2801t, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        C1933b.m3325a(f2801t, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        C1933b.m3325a(f2801t, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        C1933b.m3325a(f2801t, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        C1933b.m3325a(f2801t, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        C1933b.m3325a(f2801t, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        C1933b.m3325a(f2801t, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        C1933b.m3325a(f2801t, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        C1933b.m3325a(f2801t, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        C1933b.m3325a(f2801t, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        C1933b.m3325a(f2801t, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        C1933b.m3325a(f2801t, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        C1933b.m3325a(f2801t, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        C1933b.m3325a(f2801t, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        C1933b.m3325a(f2801t, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        C1933b.m3325a(f2801t, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        C1933b.m3325a(f2801t, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        C1933b.m3325a(f2801t, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        C1933b.m3325a(f2801t, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        C1933b.m3325a(f2801t, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        C1933b.m3325a(f2801t, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        C1933b.m3325a(f2801t, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        C1933b.m3325a(f2801t, "TLS_AES_128_CCM_SHA256", 4868);
        C1933b.m3325a(f2801t, "TLS_AES_128_CCM_8_SHA256", 4869);
    }

    public /* synthetic */ C1931j(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f2802a = str;
    }

    @JvmName(name = "javaName")
    /* renamed from: a */
    public final String mo28073a() {
        return this.f2802a;
    }

    public String toString() {
        return this.f2802a;
    }
}
