package com.squareup.picasso;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1530z;
import java.io.IOException;
import p042j.C2080p;

/* renamed from: com.squareup.picasso.b */
class C1480b extends C1530z {

    /* renamed from: a */
    private final Context f1584a;

    /* renamed from: b */
    private final Object f1585b = new Object();

    /* renamed from: c */
    private AssetManager f1586c;

    C1480b(Context context) {
        this.f1584a = context;
    }

    /* renamed from: a */
    public C1530z.C1531a mo27173a(C1526x xVar, int i) throws IOException {
        if (this.f1586c == null) {
            synchronized (this.f1585b) {
                if (this.f1586c == null) {
                    this.f1586c = this.f1584a.getAssets();
                }
            }
        }
        return new C1530z.C1531a(C2080p.m3583a(this.f1586c.open(xVar.f1717d.toString().substring(22))), C1513u.C1519e.DISK);
    }

    /* renamed from: a */
    public boolean mo27174a(C1526x xVar) {
        Uri uri = xVar.f1717d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
