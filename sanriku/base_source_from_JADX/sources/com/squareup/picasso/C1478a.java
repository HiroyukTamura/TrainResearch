package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.C1513u;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.squareup.picasso.a */
abstract class C1478a<T> {

    /* renamed from: a */
    final C1513u f1571a;

    /* renamed from: b */
    final C1526x f1572b;

    /* renamed from: c */
    final WeakReference<T> f1573c;

    /* renamed from: d */
    final boolean f1574d;

    /* renamed from: e */
    final int f1575e;

    /* renamed from: f */
    final int f1576f;

    /* renamed from: g */
    final int f1577g;

    /* renamed from: h */
    final Drawable f1578h;

    /* renamed from: i */
    final String f1579i;

    /* renamed from: j */
    final Object f1580j;

    /* renamed from: k */
    boolean f1581k;

    /* renamed from: l */
    boolean f1582l;

    /* renamed from: com.squareup.picasso.a$a */
    static class C1479a<M> extends WeakReference<M> {

        /* renamed from: a */
        final C1478a f1583a;

        C1479a(C1478a aVar, M m, ReferenceQueue<? super M> referenceQueue) {
            super(m, referenceQueue);
            this.f1583a = aVar;
        }
    }

    C1478a(C1513u uVar, T t, C1526x xVar, int i, int i2, int i3, Drawable drawable, String str, Object obj, boolean z) {
        this.f1571a = uVar;
        this.f1572b = xVar;
        this.f1573c = t == null ? null : new C1479a(this, t, uVar.f1683k);
        this.f1575e = i;
        this.f1576f = i2;
        this.f1574d = z;
        this.f1577g = i3;
        this.f1578h = drawable;
        this.f1579i = str;
        this.f1580j = obj == null ? this : obj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo27196a() {
        this.f1582l = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo27183a(Bitmap bitmap, C1513u.C1519e eVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo27184a(Exception exc);

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public T mo27197b() {
        WeakReference<T> weakReference = this.f1573c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
