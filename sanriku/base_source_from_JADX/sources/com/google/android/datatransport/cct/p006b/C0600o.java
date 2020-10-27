package com.google.android.datatransport.cct.p006b;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006b.C0589i;

/* renamed from: com.google.android.datatransport.cct.b.o */
public abstract class C0600o {

    /* renamed from: com.google.android.datatransport.cct.b.o$a */
    public static abstract class C0601a {
        @NonNull
        /* renamed from: a */
        public abstract C0601a mo9514a(@Nullable C0602b bVar);

        @NonNull
        /* renamed from: a */
        public abstract C0601a mo9515a(@Nullable C0603c cVar);

        @NonNull
        /* renamed from: a */
        public abstract C0600o mo9516a();
    }

    /* renamed from: com.google.android.datatransport.cct.b.o$b */
    public enum C0602b {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);
        

        /* renamed from: y */
        private static final SparseArray<C0602b> f213y = null;

        /* renamed from: a */
        private final int f214a;

        static {
            UNKNOWN_MOBILE_SUBTYPE = new C0602b("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
            GPRS = new C0602b("GPRS", 1, 1);
            EDGE = new C0602b("EDGE", 2, 2);
            UMTS = new C0602b("UMTS", 3, 3);
            CDMA = new C0602b("CDMA", 4, 4);
            EVDO_0 = new C0602b("EVDO_0", 5, 5);
            EVDO_A = new C0602b("EVDO_A", 6, 6);
            RTT = new C0602b("RTT", 7, 7);
            HSDPA = new C0602b("HSDPA", 8, 8);
            HSUPA = new C0602b("HSUPA", 9, 9);
            HSPA = new C0602b("HSPA", 10, 10);
            IDEN = new C0602b("IDEN", 11, 11);
            EVDO_B = new C0602b("EVDO_B", 12, 12);
            LTE = new C0602b("LTE", 13, 13);
            EHRPD = new C0602b("EHRPD", 14, 14);
            HSPAP = new C0602b("HSPAP", 15, 15);
            GSM = new C0602b("GSM", 16, 16);
            TD_SCDMA = new C0602b("TD_SCDMA", 17, 17);
            IWLAN = new C0602b("IWLAN", 18, 18);
            LTE_CA = new C0602b("LTE_CA", 19, 19);
            COMBINED = new C0602b("COMBINED", 20, 100);
            SparseArray<C0602b> sparseArray = new SparseArray<>();
            f213y = sparseArray;
            sparseArray.put(0, UNKNOWN_MOBILE_SUBTYPE);
            f213y.put(1, GPRS);
            f213y.put(2, EDGE);
            f213y.put(3, UMTS);
            f213y.put(4, CDMA);
            f213y.put(5, EVDO_0);
            f213y.put(6, EVDO_A);
            f213y.put(7, RTT);
            f213y.put(8, HSDPA);
            f213y.put(9, HSUPA);
            f213y.put(10, HSPA);
            f213y.put(11, IDEN);
            f213y.put(12, EVDO_B);
            f213y.put(13, LTE);
            f213y.put(14, EHRPD);
            f213y.put(15, HSPAP);
            f213y.put(16, GSM);
            f213y.put(17, TD_SCDMA);
            f213y.put(18, IWLAN);
            f213y.put(19, LTE_CA);
        }

        private C0602b(int i) {
            this.f214a = i;
        }

        @Nullable
        /* renamed from: a */
        public static C0602b m187a(int i) {
            return f213y.get(i);
        }

        public int zza() {
            return this.f214a;
        }
    }

    /* renamed from: com.google.android.datatransport.cct.b.o$c */
    public enum C0603c {
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17),
        NONE(-1);
        

        /* renamed from: w */
        private static final SparseArray<C0603c> f234w = null;

        /* renamed from: a */
        private final int f235a;

        static {
            MOBILE = new C0603c("MOBILE", 0, 0);
            WIFI = new C0603c("WIFI", 1, 1);
            MOBILE_MMS = new C0603c("MOBILE_MMS", 2, 2);
            MOBILE_SUPL = new C0603c("MOBILE_SUPL", 3, 3);
            MOBILE_DUN = new C0603c("MOBILE_DUN", 4, 4);
            MOBILE_HIPRI = new C0603c("MOBILE_HIPRI", 5, 5);
            WIMAX = new C0603c("WIMAX", 6, 6);
            BLUETOOTH = new C0603c("BLUETOOTH", 7, 7);
            DUMMY = new C0603c("DUMMY", 8, 8);
            ETHERNET = new C0603c("ETHERNET", 9, 9);
            MOBILE_FOTA = new C0603c("MOBILE_FOTA", 10, 10);
            MOBILE_IMS = new C0603c("MOBILE_IMS", 11, 11);
            MOBILE_CBS = new C0603c("MOBILE_CBS", 12, 12);
            WIFI_P2P = new C0603c("WIFI_P2P", 13, 13);
            MOBILE_IA = new C0603c("MOBILE_IA", 14, 14);
            MOBILE_EMERGENCY = new C0603c("MOBILE_EMERGENCY", 15, 15);
            PROXY = new C0603c("PROXY", 16, 16);
            VPN = new C0603c("VPN", 17, 17);
            NONE = new C0603c("NONE", 18, -1);
            SparseArray<C0603c> sparseArray = new SparseArray<>();
            f234w = sparseArray;
            sparseArray.put(0, MOBILE);
            f234w.put(1, WIFI);
            f234w.put(2, MOBILE_MMS);
            f234w.put(3, MOBILE_SUPL);
            f234w.put(4, MOBILE_DUN);
            f234w.put(5, MOBILE_HIPRI);
            f234w.put(6, WIMAX);
            f234w.put(7, BLUETOOTH);
            f234w.put(8, DUMMY);
            f234w.put(9, ETHERNET);
            f234w.put(10, MOBILE_FOTA);
            f234w.put(11, MOBILE_IMS);
            f234w.put(12, MOBILE_CBS);
            f234w.put(13, WIFI_P2P);
            f234w.put(14, MOBILE_IA);
            f234w.put(15, MOBILE_EMERGENCY);
            f234w.put(16, PROXY);
            f234w.put(17, VPN);
            f234w.put(-1, NONE);
        }

        private C0603c(int i) {
            this.f235a = i;
        }

        @Nullable
        /* renamed from: a */
        public static C0603c m188a(int i) {
            return f234w.get(i);
        }

        public int zza() {
            return this.f235a;
        }
    }

    @NonNull
    /* renamed from: c */
    public static C0601a m181c() {
        return new C0589i.C0590a();
    }

    @Nullable
    /* renamed from: a */
    public abstract C0602b mo9509a();

    @Nullable
    /* renamed from: b */
    public abstract C0603c mo9510b();
}
