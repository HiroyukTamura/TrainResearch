package p009e.p028d.p030b.p031a.p032i.p033s;

import android.util.Log;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: e.d.b.a.i.s.a */
public final class C0913a {
    /* renamed from: a */
    private static String m1247a(String str) {
        return C0681a.m320a("TransportRuntime.", str);
    }

    /* renamed from: a */
    public static void m1248a(String str, String str2) {
        Log.i(m1247a(str), str2);
    }

    /* renamed from: a */
    public static void m1249a(String str, String str2, Object obj) {
        Log.d(m1247a(str), String.format(str2, new Object[]{obj}));
    }

    /* renamed from: a */
    public static void m1250a(String str, String str2, Throwable th) {
        Log.e(m1247a(str), str2, th);
    }

    /* renamed from: a */
    public static void m1251a(String str, String str2, Object... objArr) {
        Log.d(m1247a(str), String.format(str2, objArr));
    }

    /* renamed from: b */
    public static void m1252b(String str, String str2, Object obj) {
        Log.w(m1247a(str), String.format(str2, new Object[]{obj}));
    }
}
