/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  android.util.DisplayMetrics
 *  android.util.SparseArray
 */
package androidx.appcompat.b.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.SparseArray;

class b
extends Drawable
implements Drawable.Callback {
    private b a;
    private Rect b;
    private Drawable c;
    private Drawable d;
    private int e = 255;
    private boolean f;
    private int g = -1;
    private int h = -1;
    private boolean i;
    private Runnable j;
    private long k;
    private long l;
    private a m;

    b() {
    }

    static int a(Resources resources, int n2) {
        if (resources != null) {
            n2 = resources.getDisplayMetrics().densityDpi;
        }
        int n3 = n2;
        if (n2 == 0) {
            n3 = 160;
        }
        return n3;
    }

    private void a(Drawable drawable2) {
        block12 : {
            if (this.m == null) {
                this.m = new a();
            }
            drawable2.setCallback((Drawable.Callback)this.m.a(drawable2.getCallback()));
            if (this.a.C <= 0 && this.f) {
                drawable2.setAlpha(this.e);
            }
            if (this.a.G) {
                drawable2.setColorFilter(this.a.F);
            } else {
                if (this.a.J) {
                    androidx.core.graphics.drawable.a.a(drawable2, this.a.H);
                }
                if (this.a.K) {
                    androidx.core.graphics.drawable.a.a(drawable2, this.a.I);
                }
            }
            drawable2.setVisible(this.isVisible(), true);
            drawable2.setDither(this.a.z);
            drawable2.setState(this.getState());
            drawable2.setLevel(this.getLevel());
            drawable2.setBounds(this.getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable2.setLayoutDirection(this.getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable2.setAutoMirrored(this.a.E);
            }
            Rect rect = this.b;
            if (Build.VERSION.SDK_INT < 21 || rect == null) break block12;
            drawable2.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
        }
        return;
        finally {
            drawable2.setCallback(this.m.a());
        }
    }

    @SuppressLint(value={"WrongConstant"})
    @TargetApi(value=23)
    private boolean a() {
        return this.isAutoMirrored() && this.getLayoutDirection() == 1;
    }

    final void a(Resources resources) {
        this.a.a(resources);
    }

    protected void a(b b2) {
        this.a = b2;
        if (this.g >= 0) {
            this.c = b2.b(this.g);
            if (this.c != null) {
                this.a(this.c);
            }
        }
        this.h = -1;
        this.d = null;
    }

    /*
     * Exception decompiling
     */
    void a(boolean var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    boolean a(int n2) {
        if (n2 == this.g) {
            return false;
        }
        long l2 = SystemClock.uptimeMillis();
        if (this.a.D > 0) {
            if (this.d != null) {
                this.d.setVisible(false, false);
            }
            if (this.c != null) {
                this.d = this.c;
                this.h = this.g;
                this.l = (long)this.a.D + l2;
            } else {
                this.d = null;
                this.h = -1;
                this.l = 0L;
            }
        } else if (this.c != null) {
            this.c.setVisible(false, false);
        }
        if (n2 >= 0 && n2 < this.a.j) {
            Drawable drawable2;
            this.c = drawable2 = this.a.b(n2);
            this.g = n2;
            if (drawable2 != null) {
                if (this.a.C > 0) {
                    this.k = l2 + (long)this.a.C;
                }
                this.a(drawable2);
            }
        } else {
            this.c = null;
            this.g = -1;
        }
        if (this.k != 0L || this.l != 0L) {
            if (this.j == null) {
                this.j = new Runnable(){

                    @Override
                    public void run() {
                        b.this.a(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                this.unscheduleSelf(this.j);
            }
            this.a(true);
        }
        this.invalidateSelf();
        return true;
    }

    public void applyTheme(Resources.Theme theme) {
        this.a.a(theme);
    }

    b c() {
        return this.a;
    }

    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    int d() {
        return this.g;
    }

    public void draw(Canvas canvas) {
        if (this.c != null) {
            this.c.draw(canvas);
        }
        if (this.d != null) {
            this.d.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.e;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.a.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.a.n()) {
            this.a.f = this.getChangingConfigurations();
            return this.a;
        }
        return null;
    }

    public Drawable getCurrent() {
        return this.c;
    }

    public void getHotspotBounds(Rect rect) {
        if (this.b != null) {
            rect.set(this.b);
            return;
        }
        super.getHotspotBounds(rect);
    }

    public int getIntrinsicHeight() {
        if (this.a.f()) {
            return this.a.h();
        }
        if (this.c != null) {
            return this.c.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.a.f()) {
            return this.a.g();
        }
        if (this.c != null) {
            return this.c.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.a.f()) {
            return this.a.j();
        }
        if (this.c != null) {
            return this.c.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.a.f()) {
            return this.a.i();
        }
        if (this.c != null) {
            return this.c.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        if (this.c != null && this.c.isVisible()) {
            return this.a.l();
        }
        return -2;
    }

    public void getOutline(Outline outline) {
        if (this.c != null) {
            this.c.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean bl2;
        int n2;
        Rect rect2 = this.a.e();
        if (rect2 != null) {
            rect.set(rect2);
            n2 = rect2.left;
            int n3 = rect2.top;
            int n4 = rect2.bottom;
            bl2 = (rect2.right | (n2 | n3 | n4)) != 0;
        } else {
            bl2 = this.c != null ? this.c.getPadding(rect) : super.getPadding(rect);
        }
        if (this.a()) {
            n2 = rect.left;
            rect.left = rect.right;
            rect.right = n2;
        }
        return bl2;
    }

    public void invalidateDrawable(Drawable drawable2) {
        if (this.a != null) {
            this.a.b();
        }
        if (drawable2 == this.c && this.getCallback() != null) {
            this.getCallback().invalidateDrawable((Drawable)this);
        }
    }

    public boolean isAutoMirrored() {
        return this.a.E;
    }

    public boolean isStateful() {
        return this.a.m();
    }

    public void jumpToCurrentState() {
        boolean bl2;
        if (this.d != null) {
            this.d.jumpToCurrentState();
            this.d = null;
            this.h = -1;
            bl2 = true;
        } else {
            bl2 = false;
        }
        if (this.c != null) {
            this.c.jumpToCurrentState();
            if (this.f) {
                this.c.setAlpha(this.e);
            }
        }
        if (this.l != 0L) {
            this.l = 0L;
            bl2 = true;
        }
        if (this.k != 0L) {
            this.k = 0L;
            bl2 = true;
        }
        if (bl2) {
            this.invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.i && super.mutate() == this) {
            b b2 = this.c();
            b2.a();
            this.a(b2);
            this.i = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.d != null) {
            this.d.setBounds(rect);
        }
        if (this.c != null) {
            this.c.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int n2) {
        return this.a.d(n2, this.d());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected boolean onLevelChange(int n2) {
        Drawable drawable2;
        if (this.d != null) {
            drawable2 = this.d;
            do {
                return drawable2.setLevel(n2);
                break;
            } while (true);
        }
        if (this.c == null) return false;
        drawable2 = this.c;
        return drawable2.setLevel(n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected boolean onStateChange(int[] arrn) {
        Drawable drawable2;
        if (this.d != null) {
            drawable2 = this.d;
            do {
                return drawable2.setState(arrn);
                break;
            } while (true);
        }
        if (this.c == null) return false;
        drawable2 = this.c;
        return drawable2.setState(arrn);
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l2) {
        if (drawable2 == this.c && this.getCallback() != null) {
            this.getCallback().scheduleDrawable((Drawable)this, runnable, l2);
        }
    }

    public void setAlpha(int n2) {
        if (!this.f || this.e != n2) {
            this.f = true;
            this.e = n2;
            if (this.c != null) {
                if (this.k == 0L) {
                    this.c.setAlpha(n2);
                    return;
                }
                this.a(false);
            }
        }
    }

    public void setAutoMirrored(boolean bl2) {
        if (this.a.E != bl2) {
            this.a.E = bl2;
            if (this.c != null) {
                androidx.core.graphics.drawable.a.a(this.c, this.a.E);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.G = true;
        if (this.a.F != colorFilter) {
            this.a.F = colorFilter;
            if (this.c != null) {
                this.c.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean bl2) {
        if (this.a.z != bl2) {
            this.a.z = bl2;
            if (this.c != null) {
                this.c.setDither(this.a.z);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, f2, f3);
        }
    }

    public void setHotspotBounds(int n2, int n3, int n4, int n5) {
        if (this.b == null) {
            this.b = new Rect(n2, n3, n4, n5);
        } else {
            this.b.set(n2, n3, n4, n5);
        }
        if (this.c != null) {
            androidx.core.graphics.drawable.a.a(this.c, n2, n3, n4, n5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        this.a.J = true;
        if (this.a.H != colorStateList) {
            this.a.H = colorStateList;
            androidx.core.graphics.drawable.a.a(this.c, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.a.K = true;
        if (this.a.I != mode) {
            this.a.I = mode;
            androidx.core.graphics.drawable.a.a(this.c, mode);
        }
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        boolean bl4 = super.setVisible(bl2, bl3);
        if (this.d != null) {
            this.d.setVisible(bl2, bl3);
        }
        if (this.c != null) {
            this.c.setVisible(bl2, bl3);
        }
        return bl4;
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        if (drawable2 == this.c && this.getCallback() != null) {
            this.getCallback().unscheduleDrawable((Drawable)this, runnable);
        }
    }

    static class a
    implements Drawable.Callback {
        private Drawable.Callback a;

        a() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.a;
            this.a = null;
            return callback;
        }

        public a a(Drawable.Callback callback) {
            this.a = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable2) {
        }

        public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l2) {
            if (this.a != null) {
                this.a.scheduleDrawable(drawable2, runnable, l2);
            }
        }

        public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
            if (this.a != null) {
                this.a.unscheduleDrawable(drawable2, runnable);
            }
        }
    }

    static abstract class b
    extends Drawable.ConstantState {
        boolean A;
        int B;
        int C;
        int D;
        boolean E;
        ColorFilter F;
        boolean G;
        ColorStateList H;
        PorterDuff.Mode I;
        boolean J;
        boolean K;
        final b c;
        Resources d;
        int e = 160;
        int f;
        int g;
        SparseArray<Drawable.ConstantState> h;
        Drawable[] i;
        int j;
        boolean k;
        boolean l;
        Rect m;
        boolean n;
        boolean o;
        int p;
        int q;
        int r;
        int s;
        boolean t;
        int u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        boolean z;

        /*
         * Enabled aggressive block sorting
         */
        b(b sparseArray, b object, Resources resources) {
            void var3_8;
            void var2_6;
            int n2 = 0;
            this.k = false;
            this.n = false;
            this.z = true;
            this.C = 0;
            this.D = 0;
            this.c = object;
            if (var3_8 != null) {
                void var2_3 = var3_8;
            } else if (sparseArray != null) {
                Resources resources2 = sparseArray.d;
            } else {
                Object var2_5 = null;
            }
            this.d = var2_6;
            int n3 = sparseArray != null ? sparseArray.e : 0;
            this.e = b.a((Resources)var3_8, n3);
            if (sparseArray == null) {
                this.i = new Drawable[10];
                this.j = 0;
                return;
            } else {
                this.f = sparseArray.f;
                this.g = sparseArray.g;
                this.x = true;
                this.y = true;
                this.k = sparseArray.k;
                this.n = sparseArray.n;
                this.z = sparseArray.z;
                this.A = sparseArray.A;
                this.B = sparseArray.B;
                this.C = sparseArray.C;
                this.D = sparseArray.D;
                this.E = sparseArray.E;
                this.F = sparseArray.F;
                this.G = sparseArray.G;
                this.H = sparseArray.H;
                this.I = sparseArray.I;
                this.J = sparseArray.J;
                this.K = sparseArray.K;
                if (sparseArray.e == this.e) {
                    if (sparseArray.l) {
                        this.m = new Rect(sparseArray.m);
                        this.l = true;
                    }
                    if (sparseArray.o) {
                        this.p = sparseArray.p;
                        this.q = sparseArray.q;
                        this.r = sparseArray.r;
                        this.s = sparseArray.s;
                        this.o = true;
                    }
                }
                if (sparseArray.t) {
                    this.u = sparseArray.u;
                    this.t = true;
                }
                if (sparseArray.v) {
                    this.w = sparseArray.w;
                    this.v = true;
                }
                Drawable[] arrdrawable = sparseArray.i;
                this.i = new Drawable[arrdrawable.length];
                this.j = sparseArray.j;
                sparseArray = sparseArray.h;
                sparseArray = sparseArray != null ? sparseArray.clone() : new SparseArray(this.j);
                this.h = sparseArray;
                int n4 = this.j;
                for (n3 = n2; n3 < n4; ++n3) {
                    if (arrdrawable[n3] == null) continue;
                    sparseArray = arrdrawable[n3].getConstantState();
                    if (sparseArray != null) {
                        this.h.put(n3, (Object)sparseArray);
                        continue;
                    }
                    this.i[n3] = arrdrawable[n3];
                }
            }
        }

        private Drawable b(Drawable drawable2) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable2.setLayoutDirection(this.B);
            }
            drawable2 = drawable2.mutate();
            drawable2.setCallback((Drawable.Callback)this.c);
            return drawable2;
        }

        private void o() {
            if (this.h != null) {
                int n2 = this.h.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    int n3 = this.h.keyAt(i2);
                    Drawable.ConstantState constantState = (Drawable.ConstantState)this.h.valueAt(i2);
                    this.i[n3] = this.b(constantState.newDrawable(this.d));
                }
                this.h = null;
            }
        }

        public final int a(Drawable drawable2) {
            int n2 = this.j;
            if (n2 >= this.i.length) {
                this.e(n2, n2 + 10);
            }
            drawable2.mutate();
            drawable2.setVisible(false, true);
            drawable2.setCallback((Drawable.Callback)this.c);
            this.i[n2] = drawable2;
            ++this.j;
            int n3 = this.g;
            this.g = drawable2.getChangingConfigurations() | n3;
            this.b();
            this.m = null;
            this.l = false;
            this.o = false;
            this.x = false;
            return n2;
        }

        void a() {
            int n2 = this.j;
            Drawable[] arrdrawable = this.i;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (arrdrawable[i2] == null) continue;
                arrdrawable[i2].mutate();
            }
            this.A = true;
        }

        final void a(Resources.Theme theme) {
            if (theme != null) {
                this.o();
                int n2 = this.j;
                Drawable[] arrdrawable = this.i;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (arrdrawable[i2] == null || !arrdrawable[i2].canApplyTheme()) continue;
                    arrdrawable[i2].applyTheme(theme);
                    this.g |= arrdrawable[i2].getChangingConfigurations();
                }
                this.a(theme.getResources());
            }
        }

        final void a(Resources resources) {
            if (resources != null) {
                this.d = resources;
                int n2 = b.a(resources, this.e);
                int n3 = this.e;
                this.e = n2;
                if (n3 != n2) {
                    this.o = false;
                    this.l = false;
                }
            }
        }

        public final void a(boolean bl2) {
            this.k = bl2;
        }

        public final Drawable b(int n2) {
            int n3;
            Drawable drawable2 = this.i[n2];
            if (drawable2 != null) {
                return drawable2;
            }
            if (this.h != null && (n3 = this.h.indexOfKey(n2)) >= 0) {
                this.i[n2] = drawable2 = this.b(((Drawable.ConstantState)this.h.valueAt(n3)).newDrawable(this.d));
                this.h.removeAt(n3);
                if (this.h.size() == 0) {
                    this.h = null;
                }
                return drawable2;
            }
            return null;
        }

        void b() {
            this.t = false;
            this.v = false;
        }

        public final void b(boolean bl2) {
            this.n = bl2;
        }

        final int c() {
            return this.i.length;
        }

        public final void c(int n2) {
            this.C = n2;
        }

        public boolean canApplyTheme() {
            int n2 = this.j;
            Drawable[] arrdrawable = this.i;
            for (int i2 = 0; i2 < n2; ++i2) {
                Drawable drawable2 = arrdrawable[i2];
                if (!(drawable2 != null ? drawable2.canApplyTheme() : (drawable2 = (Drawable.ConstantState)this.h.get(i2)) != null && drawable2.canApplyTheme())) continue;
                return true;
            }
            return false;
        }

        public final int d() {
            return this.j;
        }

        public final void d(int n2) {
            this.D = n2;
        }

        final boolean d(int n2, int n3) {
            int n4 = this.j;
            Drawable[] arrdrawable = this.i;
            boolean bl2 = false;
            for (int i2 = 0; i2 < n4; ++i2) {
                boolean bl3 = bl2;
                if (arrdrawable[i2] != null) {
                    boolean bl4 = Build.VERSION.SDK_INT >= 23 ? arrdrawable[i2].setLayoutDirection(n2) : false;
                    bl3 = bl2;
                    if (i2 == n3) {
                        bl3 = bl4;
                    }
                }
                bl2 = bl3;
            }
            this.B = n2;
            return bl2;
        }

        public final Rect e() {
            if (this.k) {
                return null;
            }
            if (this.m == null && !this.l) {
                this.o();
                Rect rect = new Rect();
                int n2 = this.j;
                Drawable[] arrdrawable = this.i;
                Rect rect2 = null;
                for (int i2 = 0; i2 < n2; ++i2) {
                    Rect rect3 = rect2;
                    if (arrdrawable[i2].getPadding(rect)) {
                        Rect rect4 = rect2;
                        if (rect2 == null) {
                            rect4 = new Rect(0, 0, 0, 0);
                        }
                        if (rect.left > rect4.left) {
                            rect4.left = rect.left;
                        }
                        if (rect.top > rect4.top) {
                            rect4.top = rect.top;
                        }
                        if (rect.right > rect4.right) {
                            rect4.right = rect.right;
                        }
                        rect3 = rect4;
                        if (rect.bottom > rect4.bottom) {
                            rect4.bottom = rect.bottom;
                            rect3 = rect4;
                        }
                    }
                    rect2 = rect3;
                }
                this.l = true;
                this.m = rect2;
                return rect2;
            }
            return this.m;
        }

        public void e(int n2, int n3) {
            Drawable[] arrdrawable = new Drawable[n3];
            System.arraycopy(this.i, 0, arrdrawable, 0, n2);
            this.i = arrdrawable;
        }

        public final boolean f() {
            return this.n;
        }

        public final int g() {
            if (!this.o) {
                this.k();
            }
            return this.p;
        }

        public int getChangingConfigurations() {
            return this.f | this.g;
        }

        public final int h() {
            if (!this.o) {
                this.k();
            }
            return this.q;
        }

        public final int i() {
            if (!this.o) {
                this.k();
            }
            return this.r;
        }

        public final int j() {
            if (!this.o) {
                this.k();
            }
            return this.s;
        }

        protected void k() {
            this.o = true;
            this.o();
            int n2 = this.j;
            Drawable[] arrdrawable = this.i;
            this.q = -1;
            this.p = -1;
            this.s = 0;
            this.r = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                Drawable drawable2 = arrdrawable[i2];
                int n3 = drawable2.getIntrinsicWidth();
                if (n3 > this.p) {
                    this.p = n3;
                }
                if ((n3 = drawable2.getIntrinsicHeight()) > this.q) {
                    this.q = n3;
                }
                if ((n3 = drawable2.getMinimumWidth()) > this.r) {
                    this.r = n3;
                }
                if ((n3 = drawable2.getMinimumHeight()) <= this.s) continue;
                this.s = n3;
            }
        }

        public final int l() {
            if (this.t) {
                return this.u;
            }
            this.o();
            int n2 = this.j;
            Drawable[] arrdrawable = this.i;
            int n3 = n2 > 0 ? arrdrawable[0].getOpacity() : -2;
            int n4 = 1;
            int n5 = n3;
            for (n3 = n4; n3 < n2; ++n3) {
                n5 = Drawable.resolveOpacity((int)n5, (int)arrdrawable[n3].getOpacity());
            }
            this.u = n5;
            this.t = true;
            return n5;
        }

        public final boolean m() {
            boolean bl2;
            if (this.v) {
                return this.w;
            }
            this.o();
            int n2 = this.j;
            Drawable[] arrdrawable = this.i;
            boolean bl3 = false;
            int n3 = 0;
            do {
                bl2 = bl3;
                if (n3 >= n2) break;
                if (arrdrawable[n3].isStateful()) {
                    bl2 = true;
                    break;
                }
                ++n3;
            } while (true);
            this.w = bl2;
            this.v = true;
            return bl2;
        }

        public boolean n() {
            synchronized (this) {
                block7 : {
                    if (!this.x) break block7;
                    boolean bl2 = this.y;
                    return bl2;
                }
                this.o();
                this.x = true;
                int n2 = this.j;
                Drawable[] arrdrawable = this.i;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (arrdrawable[i2].getConstantState() != null) continue;
                    this.y = false;
                    return false;
                }
                this.y = true;
                return true;
            }
        }
    }

}

