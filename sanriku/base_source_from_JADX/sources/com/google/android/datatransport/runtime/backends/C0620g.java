package com.google.android.datatransport.runtime.backends;

/* renamed from: com.google.android.datatransport.runtime.backends.g */
public abstract class C0620g {

    /* renamed from: com.google.android.datatransport.runtime.backends.g$a */
    public enum C0621a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR;

        static {
            OK = new C0621a("OK", 0);
            TRANSIENT_ERROR = new C0621a("TRANSIENT_ERROR", 1);
            FATAL_ERROR = new C0621a("FATAL_ERROR", 2);
        }
    }

    /* renamed from: a */
    public static C0620g m214a(long j) {
        return new C0614b(C0621a.OK, j);
    }

    /* renamed from: c */
    public static C0620g m215c() {
        return new C0614b(C0621a.FATAL_ERROR, -1);
    }

    /* renamed from: d */
    public static C0620g m216d() {
        return new C0614b(C0621a.TRANSIENT_ERROR, -1);
    }

    /* renamed from: a */
    public abstract long mo9534a();

    /* renamed from: b */
    public abstract C0621a mo9535b();
}
