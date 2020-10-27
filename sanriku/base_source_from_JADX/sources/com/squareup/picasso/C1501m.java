package com.squareup.picasso;

import android.util.LruCache;
import com.squareup.picasso.C1502n;

/* renamed from: com.squareup.picasso.m */
class C1501m extends LruCache<String, C1502n.C1503a> {
    C1501m(C1502n nVar, int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public int sizeOf(Object obj, Object obj2) {
        String str = (String) obj;
        return ((C1502n.C1503a) obj2).f1643b;
    }
}
