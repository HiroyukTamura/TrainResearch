package com.isseiaoki.simplecropview;

import android.net.Uri;
import com.isseiaoki.simplecropview.p052h.C1462b;

/* renamed from: com.isseiaoki.simplecropview.c */
public class C1453c {

    /* renamed from: a */
    private CropImageView f1520a;

    /* renamed from: b */
    private Uri f1521b;

    public C1453c(CropImageView cropImageView, Uri uri) {
        this.f1520a = cropImageView;
        this.f1521b = uri;
    }

    /* renamed from: a */
    public void mo27155a(C1462b bVar) {
        this.f1520a.mo27125b(0, 0);
        this.f1520a.mo27121a(this.f1521b, bVar);
    }
}
