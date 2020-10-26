/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.google.android.material.l;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.google.android.material.l.b;
import com.google.android.material.l.e;
import com.google.android.material.l.f;

public class c
extends Drawable
implements androidx.core.graphics.drawable.b {
    private int A;
    private int B;
    private int C;
    private int D;
    private float E;
    private Paint.Style F;
    private PorterDuffColorFilter G;
    private PorterDuff.Mode H;
    private ColorStateList I;
    private PorterDuffColorFilter J;
    private final Paint K;
    private ColorStateList L;
    private final Paint M;
    private final com.google.android.material.k.b N;
    private final Paint a;
    private ColorStateList b;
    private ColorStateList c;
    private final a d;
    private final Matrix[] e;
    private final Matrix[] f;
    private final f[] g;
    private final f.f[] h;
    private final f.f[] i;
    private final Matrix j;
    private final Path k;
    private final Path l;
    private final PointF m;
    private final RectF n;
    private final RectF o;
    private final f p;
    private final Region q;
    private final Region r;
    private final float[] s;
    private final float[] t;
    private e u;
    private int v;
    private boolean w;
    private boolean x;
    private float y;
    private int z;

    private static int a(int n2, int n3) {
        return n2 * (n3 + (n3 >>> 7)) >>> 8;
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(this.getState(), 0), mode);
        }
        return null;
    }

    private void a(float f2, float f3, float f4, float f5) {
        this.u.a().a(f2);
        this.u.b().a(f3);
        this.u.c().a(f4);
        this.u.d().a(f5);
    }

    private void a(int n2, Path path) {
        this.s[0] = this.g[n2].a;
        this.s[1] = this.g[n2].b;
        this.e[n2].mapPoints(this.s);
        if (n2 == 0) {
            path.moveTo(this.s[0], this.s[1]);
        } else {
            path.lineTo(this.s[0], this.s[1]);
        }
        this.g[n2].a(this.e[n2], path);
        this.h[n2] = this.g[n2].a();
    }

    private void a(int n2, RectF rectF) {
        this.d(n2).a(90.0f, this.y, this.g[n2]);
        float f2 = this.f(n2);
        this.e[n2].reset();
        this.a(n2, rectF, this.m);
        this.e[n2].setTranslate(this.m.x, this.m.y);
        this.e[n2].preRotate(f2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(int var1_1, RectF var2_2, PointF var3_3) {
        block5 : {
            switch (var1_1) {
                default: {
                    var4_4 = var2_2.right;
                    ** GOTO lbl7
                }
                case 3: {
                    var4_4 = var2_2.left;
lbl7: // 2 sources:
                    var5_5 = var2_2.top;
                    break block5;
                }
                case 2: {
                    var4_4 = var2_2.left;
                    ** break;
                }
                case 1: 
            }
            var4_4 = var2_2.right;
lbl14: // 2 sources:
            var5_5 = var2_2.bottom;
        }
        var3_3.set(var4_4, var5_5);
    }

    private void a(Canvas canvas) {
        this.a(canvas, this.a, this.k, this.c());
    }

    private void a(RectF rectF, Path path) {
        path.rewind();
        int n2 = 0;
        int n3 = 0;
        do {
            if (n3 >= 4) break;
            this.a(n3, rectF);
            this.b(n3);
            ++n3;
        } while (true);
        for (int i2 = n2; i2 < 4; ++i2) {
            this.a(i2, path);
            this.b(i2, path);
        }
        path.close();
    }

    private boolean a(int[] arrn, boolean bl2) {
        int n2;
        int n3;
        boolean bl3 = bl2;
        if (this.b != null) {
            n3 = this.a.getColor();
            n2 = this.b.getColorForState(arrn, n3);
            bl3 = bl2;
            if (n3 != n2) {
                this.a.setColor(n2);
                bl3 = true;
            }
        }
        bl2 = bl3;
        if (this.c != null) {
            n3 = this.K.getColor();
            n2 = this.c.getColorForState(arrn, n3);
            bl2 = bl3;
            if (n3 != n2) {
                this.K.setColor(n2);
                bl2 = true;
            }
        }
        return bl2;
    }

    private float b(float f2) {
        return Math.max(f2 - this.i(), 0.0f);
    }

    private void b(int n2) {
        this.s[0] = this.g[n2].c;
        this.s[1] = this.g[n2].d;
        this.e[n2].mapPoints(this.s);
        float f2 = this.f(n2);
        this.f[n2].reset();
        this.f[n2].setTranslate(this.s[0], this.s[1]);
        this.f[n2].preRotate(f2);
    }

    private void b(int n2, Path path) {
        int n3 = (n2 + 1) % 4;
        this.s[0] = this.g[n2].c;
        this.s[1] = this.g[n2].d;
        this.e[n2].mapPoints(this.s);
        this.t[0] = this.g[n3].a;
        this.t[1] = this.g[n3].b;
        this.e[n3].mapPoints(this.t);
        float f2 = (float)Math.hypot(this.s[0] - this.t[0], this.s[1] - this.t[1]);
        float f3 = this.c(n2);
        this.p.a(0.0f, 0.0f);
        this.e(n2).a(f2, f3, this.y, this.p);
        this.p.a(this.f[n2], path);
        this.i[n2] = this.p.a();
    }

    private void b(Canvas canvas) {
        this.c(canvas);
    }

    private void b(RectF rectF, Path path) {
        this.a(rectF, path);
        if (this.E == 1.0f) {
            return;
        }
        this.j.reset();
        this.j.setScale(this.E, this.E, rectF.width() / 2.0f, rectF.height() / 2.0f);
        path.transform(this.j);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private float c(int n2) {
        float f2;
        float f3;
        this.s[0] = this.g[n2].c;
        this.s[1] = this.g[n2].d;
        this.e[n2].mapPoints(this.s);
        if (n2 != 1 && n2 != 3) {
            f3 = this.c().centerY();
            f2 = this.s[1];
            do {
                return Math.abs(f3 - f2);
                break;
            } while (true);
        }
        f3 = this.c().centerX();
        f2 = this.s[0];
        return Math.abs(f3 - f2);
    }

    private void c(Canvas canvas) {
        float f2 = this.a().a().a;
        float f3 = this.a().b().a;
        float f4 = this.a().c().a;
        float f5 = this.a().d().a;
        this.a(this.b(f2), this.b(f3), this.b(f4), this.b(f5));
        RectF rectF = this.j();
        this.b(rectF, this.l);
        this.a(canvas, this.K, this.l, rectF);
        this.a(f2, f3, f4, f5);
    }

    private com.google.android.material.l.a d(int n2) {
        switch (n2) {
            default: {
                return this.u.b();
            }
            case 3: {
                return this.u.a();
            }
            case 2: {
                return this.u.d();
            }
            case 1: 
        }
        return this.u.c();
    }

    private void d(Canvas canvas) {
        int n2 = (int)((double)this.B * Math.sin(Math.toRadians(this.C)));
        int n3 = (int)((double)this.B * Math.cos(Math.toRadians(this.C)));
        Rect rect = canvas.getClipBounds();
        rect.inset(-this.A, -this.A);
        rect.inset(-Math.abs(n2), -Math.abs(n3));
        canvas.clipRect(rect, Region.Op.REPLACE);
        canvas.translate((float)n2, (float)n3);
    }

    private boolean d() {
        return Build.VERSION.SDK_INT < 21 || !this.k.isConvex();
        {
        }
    }

    private b e(int n2) {
        switch (n2) {
            default: {
                return this.u.f();
            }
            case 3: {
                return this.u.e();
            }
            case 2: {
                return this.u.h();
            }
            case 1: 
        }
        return this.u.g();
    }

    private void e(Canvas canvas) {
        int n2;
        if (this.B != 0) {
            canvas.drawPath(this.k, this.N.a());
        }
        for (n2 = 0; n2 < 4; ++n2) {
            this.h[n2].a(this.e[n2], this.N, this.A, canvas);
            this.i[n2].a(this.f[n2], this.N, this.A, canvas);
        }
        n2 = (int)((double)this.B * Math.sin(Math.toRadians(this.C)));
        int n3 = (int)((double)this.B * Math.cos(Math.toRadians(this.C)));
        canvas.translate((float)(-n2), (float)(-n3));
        canvas.drawPath(this.k, this.M);
        canvas.translate((float)n2, (float)n3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean e() {
        int n2 = this.v;
        boolean bl2 = true;
        if (n2 == 1) return false;
        if (this.A <= 0) return false;
        if (this.v == 2) return bl2;
        if (!this.d()) return false;
        return true;
    }

    private float f(int n2) {
        return (n2 + 1) * 90;
    }

    private boolean f() {
        return this.F == Paint.Style.FILL_AND_STROKE || this.F == Paint.Style.FILL;
        {
        }
    }

    private boolean g() {
        return (this.F == Paint.Style.FILL_AND_STROKE || this.F == Paint.Style.STROKE) && this.K.getStrokeWidth() > 0.0f;
    }

    private void h() {
        this.G = this.a(this.I, this.H);
        this.J = this.a(this.L, this.H);
        if (this.x) {
            this.N.a(this.I.getColorForState(this.getState(), 0));
        }
    }

    private float i() {
        if (this.g()) {
            return this.K.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private RectF j() {
        RectF rectF = this.c();
        float f2 = this.i();
        this.o.set(rectF.left + f2, rectF.top + f2, rectF.right - f2, rectF.bottom - f2);
        return this.o;
    }

    public e a() {
        return this.u;
    }

    public void a(float f2) {
        if (this.y != f2) {
            this.y = f2;
            this.invalidateSelf();
        }
    }

    public void a(int n2) {
        if (this.z != n2) {
            this.A = n2;
            this.z = n2;
            this.invalidateSelf();
        }
    }

    protected void a(Canvas canvas, Paint paint, Path path, RectF rectF) {
        if (this.u.i()) {
            float f2 = this.u.b().a();
            canvas.drawRoundRect(rectF, f2, f2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    public ColorStateList b() {
        return this.I;
    }

    protected RectF c() {
        Rect rect = this.getBounds();
        this.n.set((float)rect.left, (float)rect.top, (float)rect.right, (float)rect.bottom);
        return this.n;
    }

    public void draw(Canvas canvas) {
        this.a.setColorFilter((ColorFilter)this.G);
        int n2 = this.a.getAlpha();
        this.a.setAlpha(c.a(n2, this.D));
        this.K.setColorFilter((ColorFilter)this.J);
        int n3 = this.K.getAlpha();
        this.K.setAlpha(c.a(n3, this.D));
        if (this.z > 0 && this.w) {
            this.a.setShadowLayer((float)this.A, 0.0f, (float)this.z, -16777216);
        }
        this.b(this.c(), this.k);
        if (this.e()) {
            canvas.save();
            this.d(canvas);
            Bitmap bitmap = Bitmap.createBitmap((int)(this.getBounds().width() + this.A * 2), (int)(this.getBounds().height() + this.A * 2), (Bitmap.Config)Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmap);
            canvas2.translate((float)this.A, (float)this.A);
            this.e(canvas2);
            canvas.drawBitmap(bitmap, (float)(-this.A), (float)(-this.A), null);
            bitmap.recycle();
            canvas.restore();
        }
        if (this.f()) {
            this.a(canvas);
        }
        if (this.g()) {
            this.b(canvas);
        }
        this.a.setAlpha(n2);
        this.K.setAlpha(n3);
    }

    public Drawable.ConstantState getConstantState() {
        return this.d;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(value=21)
    public void getOutline(Outline outline) {
        if (this.v == 2) {
            return;
        }
        if (this.u.i()) {
            float f2 = this.u.a().a();
            outline.setRoundRect(this.getBounds(), f2);
            return;
        }
        this.b(this.c(), this.k);
        if (this.k.isConvex()) {
            outline.setConvexPath(this.k);
        }
    }

    public Region getTransparentRegion() {
        Rect rect = this.getBounds();
        this.q.set(rect);
        this.b(this.c(), this.k);
        this.r.setPath(this.k, this.q);
        this.q.op(this.r, Region.Op.DIFFERENCE);
        return this.q;
    }

    public boolean isStateful() {
        return super.isStateful() || this.I != null && this.I.isStateful() || this.L != null && this.L.isStateful() || this.c != null && this.c.isStateful() || this.b != null && this.b.isStateful();
        {
        }
    }

    protected boolean onStateChange(int[] arrn) {
        boolean bl2 = super.onStateChange(arrn);
        this.a(arrn, bl2);
        this.h();
        return bl2;
    }

    public void setAlpha(int n2) {
        if (this.D != n2) {
            this.D = n2;
            this.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        this.K.setColorFilter(colorFilter);
        this.invalidateSelf();
    }

    @Override
    public void setTint(int n2) {
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    @Override
    public void setTintList(ColorStateList colorStateList) {
        this.I = colorStateList;
        this.h();
        this.invalidateSelf();
    }

    @Override
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.H != mode) {
            this.H = mode;
            this.h();
            this.invalidateSelf();
        }
    }

    private class a
    extends Drawable.ConstantState {
        final /* synthetic */ c a;

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return this.a;
        }
    }

}

