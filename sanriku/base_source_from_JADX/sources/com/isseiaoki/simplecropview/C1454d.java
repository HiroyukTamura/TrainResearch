package com.isseiaoki.simplecropview;

import android.graphics.RectF;
import android.net.Uri;
import com.isseiaoki.simplecropview.p052h.C1463c;

/* renamed from: com.isseiaoki.simplecropview.d */
public class C1454d {

    /* renamed from: a */
    private float f1522a;

    /* renamed from: b */
    private RectF f1523b;

    /* renamed from: c */
    private boolean f1524c;

    /* renamed from: d */
    private CropImageView f1525d;

    /* renamed from: e */
    private Uri f1526e;

    public C1454d(CropImageView cropImageView, Uri uri) {
        this.f1525d = cropImageView;
        this.f1526e = uri;
    }

    /* renamed from: a */
    public C1454d mo27156a(RectF rectF) {
        this.f1523b = rectF;
        return this;
    }

    /* renamed from: a */
    public C1454d mo27157a(boolean z) {
        this.f1524c = z;
        return this;
    }

    /* renamed from: a */
    public void mo27158a(C1463c cVar) {
        if (this.f1523b == null) {
            this.f1525d.mo27116a(this.f1522a);
        }
        this.f1525d.mo27122a(this.f1526e, this.f1524c, this.f1523b, cVar);
    }
}
