package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.C0042Px;
import androidx.annotation.NonNull;
import com.squareup.picasso.C1513u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.squareup.picasso.x */
public final class C1526x {

    /* renamed from: u */
    private static final long f1713u = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a */
    int f1714a;

    /* renamed from: b */
    long f1715b;

    /* renamed from: c */
    int f1716c;

    /* renamed from: d */
    public final Uri f1717d;

    /* renamed from: e */
    public final int f1718e;

    /* renamed from: f */
    public final String f1719f;

    /* renamed from: g */
    public final List<C1473F> f1720g;

    /* renamed from: h */
    public final int f1721h;

    /* renamed from: i */
    public final int f1722i;

    /* renamed from: j */
    public final boolean f1723j;

    /* renamed from: k */
    public final int f1724k;

    /* renamed from: l */
    public final boolean f1725l;

    /* renamed from: m */
    public final boolean f1726m;

    /* renamed from: n */
    public final float f1727n;

    /* renamed from: o */
    public final float f1728o;

    /* renamed from: p */
    public final float f1729p;

    /* renamed from: q */
    public final boolean f1730q;

    /* renamed from: r */
    public final boolean f1731r;

    /* renamed from: s */
    public final Bitmap.Config f1732s;

    /* renamed from: t */
    public final C1513u.C1520f f1733t;

    /* renamed from: com.squareup.picasso.x$b */
    public static final class C1528b {

        /* renamed from: a */
        private Uri f1734a;

        /* renamed from: b */
        private int f1735b;

        /* renamed from: c */
        private int f1736c;

        /* renamed from: d */
        private int f1737d;

        /* renamed from: e */
        private boolean f1738e;

        /* renamed from: f */
        private int f1739f;

        /* renamed from: g */
        private float f1740g;

        /* renamed from: h */
        private float f1741h;

        /* renamed from: i */
        private float f1742i;

        /* renamed from: j */
        private List<C1473F> f1743j;

        /* renamed from: k */
        private Bitmap.Config f1744k;

        /* renamed from: l */
        private C1513u.C1520f f1745l;

        C1528b(Uri uri, int i, Bitmap.Config config) {
            this.f1734a = uri;
            this.f1735b = i;
            this.f1744k = config;
        }

        /* renamed from: a */
        public C1528b mo27270a(int i) {
            this.f1738e = true;
            this.f1739f = i;
            return this;
        }

        /* renamed from: a */
        public C1528b mo27271a(@C0042Px int i, @C0042Px int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i2 == 0 && i == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f1736c = i;
                this.f1737d = i2;
                return this;
            }
        }

        /* renamed from: a */
        public C1528b mo27272a(@NonNull C1473F f) {
            if (f == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (f.key() != null) {
                if (this.f1743j == null) {
                    this.f1743j = new ArrayList(2);
                }
                this.f1743j.add(f);
                return this;
            } else {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
        }

        /* renamed from: a */
        public C1526x mo27273a() {
            if (this.f1738e && this.f1736c == 0 && this.f1737d == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            }
            if (this.f1745l == null) {
                this.f1745l = C1513u.C1520f.NORMAL;
            }
            return new C1526x(this.f1734a, this.f1735b, (String) null, this.f1743j, this.f1736c, this.f1737d, this.f1738e, false, this.f1739f, false, this.f1740g, this.f1741h, this.f1742i, false, false, this.f1744k, this.f1745l, (C1527a) null);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo27274b() {
            return (this.f1734a == null && this.f1735b == 0) ? false : true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo27275c() {
            return (this.f1736c == 0 && this.f1737d == 0) ? false : true;
        }
    }

    /* synthetic */ C1526x(Uri uri, int i, String str, List list, int i2, int i3, boolean z, boolean z2, int i4, boolean z3, float f, float f2, float f3, boolean z4, boolean z5, Bitmap.Config config, C1513u.C1520f fVar, C1527a aVar) {
        this.f1717d = uri;
        this.f1718e = i;
        this.f1719f = str;
        this.f1720g = list == null ? null : Collections.unmodifiableList(list);
        this.f1721h = i2;
        this.f1722i = i3;
        this.f1723j = z;
        this.f1725l = z2;
        this.f1724k = i4;
        this.f1726m = z3;
        this.f1727n = f;
        this.f1728o = f2;
        this.f1729p = f3;
        this.f1730q = z4;
        this.f1731r = z5;
        this.f1732s = config;
        this.f1733t = fVar;
    }

    /* renamed from: a */
    public boolean mo27265a() {
        return (this.f1721h == 0 && this.f1722i == 0) ? false : true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo27266b() {
        StringBuilder sb;
        long nanoTime = System.nanoTime() - this.f1715b;
        if (nanoTime > f1713u) {
            sb.append(mo27268d());
            sb.append('+');
            sb.append(TimeUnit.NANOSECONDS.toSeconds(nanoTime));
            sb.append('s');
        } else {
            sb = new StringBuilder();
            sb.append(mo27268d());
            sb.append('+');
            sb.append(TimeUnit.NANOSECONDS.toMillis(nanoTime));
            sb.append("ms");
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo27267c() {
        return mo27265a() || this.f1727n != 0.0f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo27268d() {
        StringBuilder a = C0681a.m330a("[R");
        a.append(this.f1714a);
        a.append(']');
        return a.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i = this.f1718e;
        if (i > 0) {
            sb.append(i);
        } else {
            sb.append(this.f1717d);
        }
        List<C1473F> list = this.f1720g;
        if (list != null && !list.isEmpty()) {
            for (C1473F key : this.f1720g) {
                sb.append(' ');
                sb.append(key.key());
            }
        }
        if (this.f1719f != null) {
            sb.append(" stableKey(");
            sb.append(this.f1719f);
            sb.append(')');
        }
        if (this.f1721h > 0) {
            sb.append(" resize(");
            sb.append(this.f1721h);
            sb.append(',');
            sb.append(this.f1722i);
            sb.append(')');
        }
        if (this.f1723j) {
            sb.append(" centerCrop");
        }
        if (this.f1725l) {
            sb.append(" centerInside");
        }
        if (this.f1727n != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.f1727n);
            if (this.f1730q) {
                sb.append(" @ ");
                sb.append(this.f1728o);
                sb.append(',');
                sb.append(this.f1729p);
            }
            sb.append(')');
        }
        if (this.f1731r) {
            sb.append(" purgeable");
        }
        if (this.f1732s != null) {
            sb.append(' ');
            sb.append(this.f1732s);
        }
        sb.append('}');
        return sb.toString();
    }
}
