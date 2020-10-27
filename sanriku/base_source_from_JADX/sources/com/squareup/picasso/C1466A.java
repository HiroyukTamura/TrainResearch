package com.squareup.picasso;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1530z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;
import p042j.C1016z;

/* renamed from: com.squareup.picasso.A */
class C1466A extends C1530z {

    /* renamed from: a */
    private final Context f1536a;

    C1466A(Context context) {
        this.f1536a = context;
    }

    /* renamed from: a */
    public C1530z.C1531a mo27173a(C1526x xVar, int i) throws IOException {
        int i2;
        Uri uri;
        Resources a = C1474G.m2003a(this.f1536a, xVar);
        boolean z = true;
        if (xVar.f1718e != 0 || (uri = xVar.f1717d) == null) {
            i2 = xVar.f1718e;
        } else {
            String authority = uri.getAuthority();
            if (authority != null) {
                List<String> pathSegments = xVar.f1717d.getPathSegments();
                if (pathSegments == null || pathSegments.isEmpty()) {
                    StringBuilder a2 = C0681a.m330a("No path segments: ");
                    a2.append(xVar.f1717d);
                    throw new FileNotFoundException(a2.toString());
                } else if (pathSegments.size() == 1) {
                    try {
                        i2 = Integer.parseInt(pathSegments.get(0));
                    } catch (NumberFormatException unused) {
                        StringBuilder a3 = C0681a.m330a("Last path segment is not a resource ID: ");
                        a3.append(xVar.f1717d);
                        throw new FileNotFoundException(a3.toString());
                    }
                } else if (pathSegments.size() == 2) {
                    i2 = a.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                } else {
                    StringBuilder a4 = C0681a.m330a("More than two path segments: ");
                    a4.append(xVar.f1717d);
                    throw new FileNotFoundException(a4.toString());
                }
            } else {
                StringBuilder a5 = C0681a.m330a("No package provided: ");
                a5.append(xVar.f1717d);
                throw new FileNotFoundException(a5.toString());
            }
        }
        BitmapFactory.Options b = C1530z.m2109b(xVar);
        if (b == null || !b.inJustDecodeBounds) {
            z = false;
        }
        if (z) {
            BitmapFactory.decodeResource(a, i2, b);
            C1530z.m2108a(xVar.f1721h, xVar.f1722i, b, xVar);
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(a, i2, b);
        C1513u.C1519e eVar = C1513u.C1519e.DISK;
        C1474G.m2005a(decodeResource, "bitmap == null");
        return new C1530z.C1531a(decodeResource, (C1016z) null, eVar, 0);
    }

    /* renamed from: a */
    public boolean mo27174a(C1526x xVar) {
        if (xVar.f1718e != 0) {
            return true;
        }
        return "android.resource".equals(xVar.f1717d.getScheme());
    }
}
