package com.squareup.picasso;

import android.content.Context;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1530z;
import java.io.IOException;
import p042j.C2080p;

/* renamed from: com.squareup.picasso.g */
class C1491g extends C1530z {

    /* renamed from: a */
    final Context f1617a;

    C1491g(Context context) {
        this.f1617a = context;
    }

    /* renamed from: a */
    public C1530z.C1531a mo27173a(C1526x xVar, int i) throws IOException {
        return new C1530z.C1531a(C2080p.m3583a(this.f1617a.getContentResolver().openInputStream(xVar.f1717d)), C1513u.C1519e.DISK);
    }

    /* renamed from: a */
    public boolean mo27174a(C1526x xVar) {
        return FirebaseAnalytics.Param.CONTENT.equals(xVar.f1717d.getScheme());
    }
}
