/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Rect
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 */
package com.google.android.material.d;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.d.d;

public class c {
    public static final int a;
    private final a b;
    private final View c;
    private final Path d;
    private final Paint e;
    private final Paint f;
    private d.d g;
    private Drawable h;
    private boolean i;
    private boolean j;

    /*
     * Enabled aggressive block sorting
     */
    static {
        int n2 = Build.VERSION.SDK_INT >= 21 ? 2 : (Build.VERSION.SDK_INT >= 18 ? 1 : 0);
        a = n2;
    }

    private float b(d.d d2) {
        return com.google.android.material.g.a.a(d2.a, d2.b, 0.0f, 0.0f, this.c.getWidth(), this.c.getHeight());
    }

    private void b(Canvas canvas) {
        if (this.j()) {
            Rect rect = this.h.getBounds();
            float f2 = this.g.a - (float)rect.width() / 2.0f;
            float f3 = this.g.b - (float)rect.height() / 2.0f;
            canvas.translate(f2, f3);
            this.h.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void g() {
        if (a == 1) {
            this.d.rewind();
            if (this.g != null) {
                this.d.addCircle(this.g.a, this.g.b, this.g.c, Path.Direction.CW);
            }
        }
        this.c.invalidate();
    }

    private boolean h() {
        d.d d2 = this.g;
        boolean bl2 = false;
        boolean bl3 = d2 == null || this.g.a();
        if (a == 0) {
            boolean bl4 = bl2;
            if (!bl3) {
                bl4 = bl2;
                if (this.j) {
                    bl4 = true;
                }
            }
            return bl4;
        }
        return bl3 ^ true;
    }

    private boolean i() {
        return !this.i && Color.alpha((int)this.f.getColor()) != 0;
    }

    private boolean j() {
        return !this.i && this.h != null && this.g != null;
    }

    public void a() {
        if (a == 0) {
            Bitmap bitmap;
            this.i = true;
            this.j = false;
            this.c.buildDrawingCache();
            Bitmap bitmap2 = bitmap = this.c.getDrawingCache();
            if (bitmap == null) {
                bitmap2 = bitmap;
                if (this.c.getWidth() != 0) {
                    bitmap2 = bitmap;
                    if (this.c.getHeight() != 0) {
                        bitmap2 = Bitmap.createBitmap((int)this.c.getWidth(), (int)this.c.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                        bitmap = new Canvas(bitmap2);
                        this.c.draw((Canvas)bitmap);
                    }
                }
            }
            if (bitmap2 != null) {
                this.e.setShader((Shader)new BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            }
            this.i = false;
            this.j = true;
        }
    }

    public void a(int n2) {
        this.f.setColor(n2);
        this.c.invalidate();
    }

    public void a(Canvas object) {
        block13 : {
            block14 : {
                block12 : {
                    if (!this.h()) break block12;
                    switch (a) {
                        default: {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Unsupported strategy ");
                            ((StringBuilder)object).append(a);
                            throw new IllegalStateException(((StringBuilder)object).toString());
                        }
                        case 2: {
                            this.b.a((Canvas)object);
                            if (!this.i()) break block13;
                            break block14;
                        }
                        case 1: {
                            int n2 = object.save();
                            object.clipPath(this.d);
                            this.b.a((Canvas)object);
                            if (this.i()) {
                                object.drawRect(0.0f, 0.0f, (float)this.c.getWidth(), (float)this.c.getHeight(), this.f);
                            }
                            object.restoreToCount(n2);
                            break;
                        }
                        case 0: {
                            object.drawCircle(this.g.a, this.g.b, this.g.c, this.e);
                            if (this.i()) {
                                object.drawCircle(this.g.a, this.g.b, this.g.c, this.f);
                                break;
                            }
                            break block13;
                        }
                    }
                    break block13;
                }
                this.b.a((Canvas)object);
                if (!this.i()) break block13;
            }
            object.drawRect(0.0f, 0.0f, (float)this.c.getWidth(), (float)this.c.getHeight(), this.f);
        }
        this.b((Canvas)object);
    }

    public void a(Drawable drawable2) {
        this.h = drawable2;
        this.c.invalidate();
    }

    public void a(d.d d2) {
        if (d2 == null) {
            this.g = null;
        } else {
            if (this.g == null) {
                this.g = new d.d(d2);
            } else {
                this.g.a(d2);
            }
            if (com.google.android.material.g.a.b(d2.c, this.b(d2), 1.0E-4f)) {
                this.g.c = Float.MAX_VALUE;
            }
        }
        this.g();
    }

    public void b() {
        if (a == 0) {
            this.j = false;
            this.c.destroyDrawingCache();
            this.e.setShader(null);
            this.c.invalidate();
        }
    }

    public d.d c() {
        if (this.g == null) {
            return null;
        }
        d.d d2 = new d.d(this.g);
        if (d2.a()) {
            d2.c = this.b(d2);
        }
        return d2;
    }

    public int d() {
        return this.f.getColor();
    }

    public Drawable e() {
        return this.h;
    }

    public boolean f() {
        return this.b.c() && !this.h();
    }

    static interface a {
        public void a(Canvas var1);

        public boolean c();
    }

}

