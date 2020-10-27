package com.squareup.picasso;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import p040i.C1752D;
import p040i.C1915d;
import p040i.C1923f;

/* renamed from: com.squareup.picasso.t */
public final class C1512t implements C1498j {
    @VisibleForTesting

    /* renamed from: a */
    final C1923f.C1924a f1669a;

    /* renamed from: b */
    private final C1915d f1670b;

    public C1512t(Context context) {
        File b = C1474G.m2013b(context);
        long a = C1474G.m2002a(b);
        C1752D.C1753a aVar = new C1752D.C1753a();
        aVar.mo27502a(new C1915d(b, a));
        C1752D d = new C1752D(aVar);
        this.f1669a = d;
        this.f1670b = d.mo27470b();
    }
}
