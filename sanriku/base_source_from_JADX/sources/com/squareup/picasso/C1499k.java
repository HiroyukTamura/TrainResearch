package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1530z;
import java.io.IOException;
import p042j.C2080p;

/* renamed from: com.squareup.picasso.k */
class C1499k extends C1491g {
    C1499k(Context context) {
        super(context);
    }

    /* renamed from: a */
    public C1530z.C1531a mo27173a(C1526x xVar, int i) throws IOException {
        return new C1530z.C1531a((Bitmap) null, C2080p.m3583a(this.f1617a.getContentResolver().openInputStream(xVar.f1717d)), C1513u.C1519e.DISK, new ExifInterface(xVar.f1717d.getPath()).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1));
    }

    /* renamed from: a */
    public boolean mo27174a(C1526x xVar) {
        return "file".equals(xVar.f1717d.getScheme());
    }
}
