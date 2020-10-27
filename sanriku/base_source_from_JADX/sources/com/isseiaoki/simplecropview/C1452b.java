package com.isseiaoki.simplecropview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* renamed from: com.isseiaoki.simplecropview.b */
class C1452b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bitmap f1518a;

    /* renamed from: b */
    final /* synthetic */ CropImageView f1519b;

    C1452b(CropImageView cropImageView, Bitmap bitmap) {
        this.f1519b = cropImageView;
        this.f1518a = bitmap;
    }

    public void run() {
        CropImageView cropImageView = this.f1519b;
        float unused = cropImageView.f1394d = (float) cropImageView.f1367C;
        CropImageView.m1916a(this.f1519b, (Drawable) new BitmapDrawable(this.f1519b.getResources(), this.f1518a));
    }
}
