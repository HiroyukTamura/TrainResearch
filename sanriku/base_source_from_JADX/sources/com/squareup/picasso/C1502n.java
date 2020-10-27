package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: com.squareup.picasso.n */
public final class C1502n implements C1488d {

    /* renamed from: a */
    final LruCache<String, C1503a> f1641a;

    /* renamed from: com.squareup.picasso.n$a */
    static final class C1503a {

        /* renamed from: a */
        final Bitmap f1642a;

        /* renamed from: b */
        final int f1643b;

        C1503a(Bitmap bitmap, int i) {
            this.f1642a = bitmap;
            this.f1643b = i;
        }
    }

    public C1502n(@NonNull Context context) {
        this.f1641a = new C1501m(this, C1474G.m2000a(context));
    }

    /* renamed from: a */
    public int mo27207a() {
        return this.f1641a.maxSize();
    }

    /* renamed from: a */
    public void mo27208a(String str) {
        for (String next : this.f1641a.snapshot().keySet()) {
            if (next.startsWith(str) && next.length() > str.length() && next.charAt(str.length()) == 10) {
                this.f1641a.remove(next);
            }
        }
    }

    /* renamed from: a */
    public void mo27209a(@NonNull String str, @NonNull Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int a = C1474G.m2001a(bitmap);
        if (a > this.f1641a.maxSize()) {
            this.f1641a.remove(str);
        } else {
            this.f1641a.put(str, new C1503a(bitmap, a));
        }
    }

    @Nullable
    public Bitmap get(@NonNull String str) {
        C1503a aVar = this.f1641a.get(str);
        if (aVar != null) {
            return aVar.f1642a;
        }
        return null;
    }

    public int size() {
        return this.f1641a.size();
    }
}
