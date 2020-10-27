package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.squareup.picasso.C1513u;
import java.io.IOException;
import p042j.C1016z;

/* renamed from: com.squareup.picasso.z */
public abstract class C1530z {

    /* renamed from: com.squareup.picasso.z$a */
    public static final class C1531a {

        /* renamed from: a */
        private final C1513u.C1519e f1754a;

        /* renamed from: b */
        private final Bitmap f1755b;

        /* renamed from: c */
        private final C1016z f1756c;

        /* renamed from: d */
        private final int f1757d;

        C1531a(@Nullable Bitmap bitmap, @Nullable C1016z zVar, @NonNull C1513u.C1519e eVar, int i) {
            if ((bitmap != null) != (zVar == null ? false : true)) {
                this.f1755b = bitmap;
                this.f1756c = zVar;
                C1474G.m2005a(eVar, "loadedFrom == null");
                this.f1754a = eVar;
                this.f1757d = i;
                return;
            }
            throw new AssertionError();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public C1531a(@NonNull C1016z zVar, @NonNull C1513u.C1519e eVar) {
            this((Bitmap) null, zVar, eVar, 0);
            C1474G.m2005a(zVar, "source == null");
        }

        @Nullable
        /* renamed from: a */
        public Bitmap mo27286a() {
            return this.f1755b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo27287b() {
            return this.f1757d;
        }

        @NonNull
        /* renamed from: c */
        public C1513u.C1519e mo27288c() {
            return this.f1754a;
        }

        @Nullable
        /* renamed from: d */
        public C1016z mo27289d() {
            return this.f1756c;
        }
    }

    /* renamed from: a */
    static void m2107a(int i, int i2, int i3, int i4, BitmapFactory.Options options, C1526x xVar) {
        int i5;
        double d;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                d = (double) (((float) i3) / ((float) i));
            } else if (i == 0) {
                d = (double) (((float) i4) / ((float) i2));
            } else {
                int floor = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor2 = (int) Math.floor((double) (((float) i3) / ((float) i)));
                i5 = xVar.f1725l ? Math.max(floor, floor2) : Math.min(floor, floor2);
            }
            i5 = (int) Math.floor(d);
        } else {
            i5 = 1;
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }

    /* renamed from: a */
    static void m2108a(int i, int i2, BitmapFactory.Options options, C1526x xVar) {
        m2107a(i, i2, options.outWidth, options.outHeight, options, xVar);
    }

    /* renamed from: b */
    static BitmapFactory.Options m2109b(C1526x xVar) {
        boolean a = xVar.mo27265a();
        boolean z = xVar.f1732s != null;
        BitmapFactory.Options options = null;
        if (a || z || xVar.f1731r) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = a;
            boolean z2 = xVar.f1731r;
            options.inInputShareable = z2;
            options.inPurgeable = z2;
            if (z) {
                options.inPreferredConfig = xVar.f1732s;
            }
        }
        return options;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo27240a() {
        return 0;
    }

    @Nullable
    /* renamed from: a */
    public abstract C1531a mo27173a(C1526x xVar, int i) throws IOException;

    /* renamed from: a */
    public abstract boolean mo27174a(C1526x xVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo27241a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo27242b() {
        return false;
    }
}
