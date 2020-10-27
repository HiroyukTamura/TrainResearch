package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.squareup.picasso.C1513u;
import com.squareup.picasso.C1526x;
import java.util.concurrent.atomic.AtomicInteger;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: com.squareup.picasso.y */
public class C1529y {

    /* renamed from: h */
    private static final AtomicInteger f1746h = new AtomicInteger();

    /* renamed from: a */
    private final C1513u f1747a;

    /* renamed from: b */
    private final C1526x.C1528b f1748b;

    /* renamed from: c */
    private boolean f1749c;

    /* renamed from: d */
    private boolean f1750d = true;

    /* renamed from: e */
    private int f1751e;

    /* renamed from: f */
    private int f1752f;

    /* renamed from: g */
    private Object f1753g;

    C1529y(C1513u uVar, Uri uri, int i) {
        if (!uVar.f1687o) {
            this.f1747a = uVar;
            this.f1748b = new C1526x.C1528b(uri, i, uVar.f1684l);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    /* renamed from: a */
    private C1526x m2095a(long j) {
        int andIncrement = f1746h.getAndIncrement();
        C1526x a = this.f1748b.mo27273a();
        a.f1714a = andIncrement;
        a.f1715b = j;
        boolean z = this.f1747a.f1686n;
        if (z) {
            C1474G.m2011a("Main", "created", a.mo27268d(), a.toString());
        }
        this.f1747a.mo27243a(a);
        if (a != a) {
            a.f1714a = andIncrement;
            a.f1715b = j;
            if (z) {
                String b = a.mo27266b();
                C1474G.m2011a("Main", "changed", b, "into " + a);
            }
        }
        return a;
    }

    /* renamed from: e */
    private Drawable m2096e() {
        int i = this.f1751e;
        if (i != 0) {
            return Build.VERSION.SDK_INT >= 21 ? this.f1747a.f1677e.getDrawable(i) : this.f1747a.f1677e.getResources().getDrawable(this.f1751e);
        }
        return null;
    }

    /* renamed from: a */
    public C1529y mo27276a() {
        this.f1748b.mo27270a(17);
        return this;
    }

    /* renamed from: a */
    public C1529y mo27277a(@DrawableRes int i) {
        if (!this.f1750d) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i != 0) {
            this.f1751e = i;
            return this;
        } else {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        }
    }

    /* renamed from: a */
    public C1529y mo27278a(int i, int i2) {
        this.f1748b.mo27271a(i, i2);
        return this;
    }

    /* renamed from: a */
    public C1529y mo27279a(@NonNull C1473F f) {
        this.f1748b.mo27272a(f);
        return this;
    }

    /* renamed from: a */
    public C1529y mo27280a(@NonNull C1508r rVar, @NonNull C1508r... rVarArr) {
        if (rVar != null) {
            this.f1752f = rVar.f1664a | this.f1752f;
            if (rVarArr != null) {
                if (rVarArr.length > 0) {
                    int length = rVarArr.length;
                    int i = 0;
                    while (i < length) {
                        C1508r rVar2 = rVarArr[i];
                        if (rVar2 != null) {
                            this.f1752f = rVar2.f1664a | this.f1752f;
                            i++;
                        } else {
                            throw new IllegalArgumentException("Network policy cannot be null.");
                        }
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Network policy cannot be null.");
        }
        throw new IllegalArgumentException("Network policy cannot be null.");
    }

    /* renamed from: a */
    public void mo27281a(ImageView imageView, C1489e eVar) {
        Bitmap c;
        ImageView imageView2 = imageView;
        C1489e eVar2 = eVar;
        long nanoTime = System.nanoTime();
        C1474G.m2009a();
        if (imageView2 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f1748b.mo27274b()) {
            C1513u uVar = this.f1747a;
            if (uVar != null) {
                uVar.mo27249a((Object) imageView2);
                if (this.f1750d) {
                    C1523v.m2084a(imageView2, m2096e());
                    return;
                }
                return;
            }
            throw null;
        } else {
            if (this.f1749c) {
                if (!this.f1748b.mo27275c()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0) {
                        if (this.f1750d) {
                            C1523v.m2084a(imageView2, m2096e());
                        }
                        C1513u uVar2 = this.f1747a;
                        C1492h hVar = new C1492h(this, imageView2, eVar2);
                        if (uVar2.f1682j.containsKey(imageView2)) {
                            uVar2.mo27249a((Object) imageView2);
                        }
                        uVar2.f1682j.put(imageView2, hVar);
                        return;
                    }
                    this.f1748b.mo27271a(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            C1526x a = m2095a(nanoTime);
            String a2 = C1474G.m2008a(a);
            if (!C1507q.m2061a(0) || (c = this.f1747a.mo27253c(a2)) == null) {
                if (this.f1750d) {
                    C1523v.m2084a(imageView2, m2096e());
                }
                this.f1747a.mo27247a((C1478a) new C1500l(this.f1747a, imageView, a, 0, this.f1752f, 0, (Drawable) null, a2, this.f1753g, eVar, false));
                return;
            }
            C1513u uVar3 = this.f1747a;
            if (uVar3 != null) {
                uVar3.mo27249a((Object) imageView2);
                C1513u uVar4 = this.f1747a;
                C1523v.m2083a(imageView, uVar4.f1677e, c, C1513u.C1519e.MEMORY, false, uVar4.f1685m);
                if (this.f1747a.f1686n) {
                    String d = a.mo27268d();
                    StringBuilder a3 = C0681a.m330a("from ");
                    a3.append(C1513u.C1519e.MEMORY);
                    C1474G.m2011a("Main", "completed", d, a3.toString());
                }
                if (eVar2 != null) {
                    eVar.onSuccess();
                    return;
                }
                return;
            }
            throw null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1529y mo27283b() {
        this.f1753g = null;
        return this;
    }

    /* renamed from: c */
    public C1529y mo27284c() {
        this.f1749c = true;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C1529y mo27285d() {
        this.f1749c = false;
        return this;
    }

    /* renamed from: a */
    public void mo27282a(@NonNull C1471D d) {
        Bitmap c;
        long nanoTime = System.nanoTime();
        C1474G.m2009a();
        if (d == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f1749c) {
            Drawable drawable = null;
            if (!this.f1748b.mo27274b()) {
                C1513u uVar = this.f1747a;
                if (uVar != null) {
                    uVar.mo27249a((Object) d);
                    if (this.f1750d) {
                        drawable = m2096e();
                    }
                    d.onPrepareLoad(drawable);
                    return;
                }
                throw null;
            }
            C1526x a = m2095a(nanoTime);
            String a2 = C1474G.m2008a(a);
            if (!C1507q.m2061a(0) || (c = this.f1747a.mo27253c(a2)) == null) {
                if (this.f1750d) {
                    drawable = m2096e();
                }
                d.onPrepareLoad(drawable);
                this.f1747a.mo27247a((C1478a) new C1472E(this.f1747a, d, a, 0, this.f1752f, (Drawable) null, a2, this.f1753g, 0));
                return;
            }
            C1513u uVar2 = this.f1747a;
            if (uVar2 != null) {
                uVar2.mo27249a((Object) d);
                d.onBitmapLoaded(c, C1513u.C1519e.MEMORY);
                return;
            }
            throw null;
        } else {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
    }
}
