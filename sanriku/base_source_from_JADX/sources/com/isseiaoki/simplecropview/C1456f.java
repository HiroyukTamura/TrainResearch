package com.isseiaoki.simplecropview;

import android.graphics.Bitmap;
import android.net.Uri;
import com.isseiaoki.simplecropview.p052h.C1464d;

/* renamed from: com.isseiaoki.simplecropview.f */
public class C1456f {

    /* renamed from: a */
    private CropImageView f1528a;

    /* renamed from: b */
    private Bitmap f1529b;

    /* renamed from: c */
    private Bitmap.CompressFormat f1530c;

    /* renamed from: d */
    private int f1531d = -1;

    public C1456f(CropImageView cropImageView, Bitmap bitmap) {
        this.f1528a = cropImageView;
        this.f1529b = bitmap;
    }

    /* renamed from: a */
    public C1456f mo27159a(Bitmap.CompressFormat compressFormat) {
        this.f1530c = compressFormat;
        return this;
    }

    /* renamed from: a */
    public void mo27160a(Uri uri, C1464d dVar) {
        Bitmap.CompressFormat compressFormat = this.f1530c;
        if (compressFormat != null) {
            this.f1528a.mo27119a(compressFormat);
        }
        int i = this.f1531d;
        if (i >= 0) {
            this.f1528a.mo27117a(i);
        }
        this.f1528a.mo27120a(uri, this.f1529b, dVar);
    }
}
