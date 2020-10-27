package com.squareup.picasso;

/* renamed from: com.squareup.picasso.q */
public enum C1507q {
    NO_CACHE(1),
    NO_STORE(2);
    

    /* renamed from: a */
    final int f1660a;

    static {
        NO_CACHE = new C1507q("NO_CACHE", 0, 1);
        NO_STORE = new C1507q("NO_STORE", 1, 2);
    }

    private C1507q(int i) {
        this.f1660a = i;
    }

    /* renamed from: a */
    static boolean m2061a(int i) {
        return (i & NO_CACHE.f1660a) == 0;
    }
}
