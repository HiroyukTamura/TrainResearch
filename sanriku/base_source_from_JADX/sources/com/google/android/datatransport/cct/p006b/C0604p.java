package com.google.android.datatransport.cct.p006b;

import android.util.SparseArray;

/* renamed from: com.google.android.datatransport.cct.b.p */
public enum C0604p {
    DEFAULT,
    UNMETERED_ONLY,
    UNMETERED_OR_DAILY,
    FAST_IF_RADIO_AWAKE,
    NEVER,
    UNRECOGNIZED;
    

    /* renamed from: g */
    private static final SparseArray<C0604p> f242g = null;

    static {
        DEFAULT = new C0604p("DEFAULT", 0);
        UNMETERED_ONLY = new C0604p("UNMETERED_ONLY", 1);
        UNMETERED_OR_DAILY = new C0604p("UNMETERED_OR_DAILY", 2);
        FAST_IF_RADIO_AWAKE = new C0604p("FAST_IF_RADIO_AWAKE", 3);
        NEVER = new C0604p("NEVER", 4);
        UNRECOGNIZED = new C0604p("UNRECOGNIZED", 5);
        SparseArray<C0604p> sparseArray = new SparseArray<>();
        f242g = sparseArray;
        sparseArray.put(0, DEFAULT);
        f242g.put(1, UNMETERED_ONLY);
        f242g.put(2, UNMETERED_OR_DAILY);
        f242g.put(3, FAST_IF_RADIO_AWAKE);
        f242g.put(4, NEVER);
        f242g.put(-1, UNRECOGNIZED);
    }
}
