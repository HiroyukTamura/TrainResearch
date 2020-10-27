package com.isseiaoki.simplecropview;

import com.isseiaoki.simplecropview.p052h.C1461a;

/* renamed from: com.isseiaoki.simplecropview.a */
class C1451a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C1461a f1515a;

    /* renamed from: b */
    final /* synthetic */ Throwable f1516b;

    /* renamed from: c */
    final /* synthetic */ CropImageView f1517c;

    C1451a(CropImageView cropImageView, C1461a aVar, Throwable th) {
        this.f1517c = cropImageView;
        this.f1515a = aVar;
        this.f1516b = th;
    }

    public void run() {
        this.f1515a.onError(this.f1516b);
    }
}
