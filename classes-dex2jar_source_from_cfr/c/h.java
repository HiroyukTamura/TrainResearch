/*
 * Decompiled with CFR 0.139.
 */
package c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class h {
    public static final h A;
    public static final h B;
    public static final h C;
    public static final h D;
    public static final h E;
    public static final h F;
    public static final h G;
    public static final h H;
    public static final h I;
    public static final h J;
    public static final h K;
    public static final h L;
    public static final h M;
    public static final h N;
    public static final h O;
    public static final h P;
    public static final h Q;
    public static final h R;
    public static final h S;
    public static final h T;
    public static final h U;
    public static final h V;
    public static final h W;
    public static final h X;
    public static final h Y;
    public static final h Z;
    static final Comparator<String> a;
    public static final h aA;
    public static final h aB;
    public static final h aC;
    public static final h aD;
    public static final h aE;
    public static final h aF;
    public static final h aG;
    public static final h aH;
    public static final h aI;
    public static final h aJ;
    public static final h aK;
    public static final h aL;
    public static final h aM;
    public static final h aN;
    public static final h aO;
    public static final h aP;
    public static final h aQ;
    public static final h aR;
    public static final h aS;
    public static final h aT;
    public static final h aU;
    public static final h aV;
    public static final h aW;
    public static final h aX;
    public static final h aY;
    public static final h aZ;
    public static final h aa;
    public static final h ab;
    public static final h ac;
    public static final h ad;
    public static final h ae;
    public static final h af;
    public static final h ag;
    public static final h ah;
    public static final h ai;
    public static final h aj;
    public static final h ak;
    public static final h al;
    public static final h am;
    public static final h an;
    public static final h ao;
    public static final h ap;
    public static final h aq;
    public static final h ar;
    public static final h as;
    public static final h at;
    public static final h au;
    public static final h av;
    public static final h aw;
    public static final h ax;
    public static final h ay;
    public static final h az;
    public static final h b;
    public static final h ba;
    public static final h bb;
    public static final h bc;
    public static final h bd;
    public static final h be;
    public static final h bf;
    public static final h bg;
    public static final h bh;
    public static final h bi;
    private static final Map<String, h> bk;
    public static final h c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    public static final h i;
    public static final h j;
    public static final h k;
    public static final h l;
    public static final h m;
    public static final h n;
    public static final h o;
    public static final h p;
    public static final h q;
    public static final h r;
    public static final h s;
    public static final h t;
    public static final h u;
    public static final h v;
    public static final h w;
    public static final h x;
    public static final h y;
    public static final h z;
    final String bj;

    static {
        a = new Comparator<String>(){

            public int a(String string2, String string3) {
                int n2;
                int n3 = Math.min(string2.length(), string3.length());
                for (n2 = 4; n2 < n3; ++n2) {
                    char c2;
                    char c3 = string2.charAt(n2);
                    if (c3 == (c2 = string3.charAt(n2))) continue;
                    if (c3 < c2) {
                        return -1;
                    }
                    return 1;
                }
                n2 = string2.length();
                if (n2 != (n3 = string3.length())) {
                    if (n2 < n3) {
                        return -1;
                    }
                    return 1;
                }
                return 0;
            }

            @Override
            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((String)object, (String)object2);
            }
        };
        bk = new TreeMap<String, h>(a);
        b = h.a("SSL_RSA_WITH_NULL_MD5", 1);
        c = h.a("SSL_RSA_WITH_NULL_SHA", 2);
        d = h.a("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        e = h.a("SSL_RSA_WITH_RC4_128_MD5", 4);
        f = h.a("SSL_RSA_WITH_RC4_128_SHA", 5);
        g = h.a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        h = h.a("SSL_RSA_WITH_DES_CBC_SHA", 9);
        i = h.a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        j = h.a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        k = h.a("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        l = h.a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        m = h.a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        n = h.a("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        o = h.a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        p = h.a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        q = h.a("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        r = h.a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        s = h.a("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        t = h.a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        u = h.a("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        v = h.a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        w = h.a("TLS_KRB5_WITH_RC4_128_SHA", 32);
        x = h.a("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        y = h.a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        z = h.a("TLS_KRB5_WITH_RC4_128_MD5", 36);
        A = h.a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        B = h.a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        C = h.a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        D = h.a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        E = h.a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        F = h.a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        G = h.a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        H = h.a("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        I = h.a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        J = h.a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        K = h.a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        L = h.a("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        M = h.a("TLS_RSA_WITH_NULL_SHA256", 59);
        N = h.a("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        O = h.a("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        P = h.a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        Q = h.a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        R = h.a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        S = h.a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        T = h.a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        U = h.a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        V = h.a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        W = h.a("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        X = h.a("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        Y = h.a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        Z = h.a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        aa = h.a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        ab = h.a("TLS_PSK_WITH_RC4_128_SHA", 138);
        ac = h.a("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        ad = h.a("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        ae = h.a("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        af = h.a("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        ag = h.a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        ah = h.a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        ai = h.a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        aj = h.a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        ak = h.a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        al = h.a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        am = h.a("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        an = h.a("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        ao = h.a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        ap = h.a("TLS_FALLBACK_SCSV", 22016);
        aq = h.a("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        ar = h.a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        as = h.a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        at = h.a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        au = h.a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        av = h.a("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        aw = h.a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        ax = h.a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        ay = h.a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        az = h.a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        aA = h.a("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        aB = h.a("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        aC = h.a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        aD = h.a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        aE = h.a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        aF = h.a("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        aG = h.a("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        aH = h.a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        aI = h.a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        aJ = h.a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        aK = h.a("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        aL = h.a("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        aM = h.a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        aN = h.a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        aO = h.a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        aP = h.a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        aQ = h.a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        aR = h.a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        aS = h.a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        aT = h.a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        aU = h.a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        aV = h.a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        aW = h.a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        aX = h.a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        aY = h.a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        aZ = h.a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        ba = h.a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        bb = h.a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        bc = h.a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        bd = h.a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        be = h.a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        bf = h.a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        bg = h.a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        bh = h.a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        bi = h.a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    }

    private h(String string2) {
        if (string2 != null) {
            this.bj = string2;
            return;
        }
        throw new NullPointerException();
    }

    public static h a(String string2) {
        synchronized (h.class) {
            h h2;
            block5 : {
                h h3;
                h2 = h3 = bk.get(string2);
                if (h3 != null) break block5;
                h2 = new h(string2);
                bk.put(string2, h2);
            }
            return h2;
            finally {
            }
        }
    }

    private static h a(String string2, int n2) {
        return h.a(string2);
    }

    static /* varargs */ List<h> a(String ... arrstring) {
        ArrayList<h> arrayList = new ArrayList<h>(arrstring.length);
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrayList.add(h.a(arrstring[i2]));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String toString() {
        return this.bj;
    }

}

