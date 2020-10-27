package com.squareup.picasso;

/* renamed from: com.squareup.picasso.r */
public enum C1508r {
    NO_CACHE(1),
    NO_STORE(2),
    OFFLINE(4);
    

    /* renamed from: a */
    final int f1664a;

    static {
        NO_CACHE = new C1508r("NO_CACHE", 0, 1);
        NO_STORE = new C1508r("NO_STORE", 1, 2);
        OFFLINE = new C1508r("OFFLINE", 2, 4);
    }

    private C1508r(int i) {
        this.f1664a = i;
    }
}
