/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.WindowManager
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.t;
import androidx.core.h.d;

public class n {
    private final Context a;
    private final h b;
    private final boolean c;
    private final int d;
    private final int e;
    private View f;
    private int g = 8388611;
    private boolean h;
    private o.a i;
    private m j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l = new PopupWindow.OnDismissListener(){

        public void onDismiss() {
            n.this.e();
        }
    };

    public n(Context context, h h2, View view, boolean bl2, int n2) {
        this(context, h2, view, bl2, n2, 0);
    }

    public n(Context context, h h2, View view, boolean bl2, int n2, int n3) {
        this.a = context;
        this.b = h2;
        this.f = view;
        this.c = bl2;
        this.d = n2;
        this.e = n3;
    }

    private void a(int n2, int n3, boolean bl2, boolean bl3) {
        m m2 = this.b();
        m2.c(bl3);
        if (bl2) {
            int n4 = n2;
            if ((d.a(this.g, androidx.core.h.t.f(this.f)) & 7) == 5) {
                n4 = n2 - this.f.getWidth();
            }
            m2.b(n4);
            m2.c(n3);
            n2 = (int)(this.a.getResources().getDisplayMetrics().density * 48.0f / 2.0f);
            m2.a(new Rect(n4 - n2, n3 - n2, n4 + n2, n3 + n2));
        }
        m2.a();
    }

    private m g() {
        Object object = ((WindowManager)this.a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            object.getRealSize(point);
        } else {
            object.getSize(point);
        }
        boolean bl2 = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(a.d.abc_cascading_menus_min_smallest_width);
        object = bl2 ? new e(this.a, this.f, this.d, this.e, this.c) : new t(this.a, this.b, this.f, this.d, this.e, this.c);
        ((m)object).a(this.b);
        ((m)object).a(this.l);
        ((m)object).a(this.f);
        object.a(this.i);
        ((m)object).b(this.h);
        ((m)object).a(this.g);
        return object;
    }

    public void a() {
        if (this.c()) {
            return;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    public void a(int n2) {
        this.g = n2;
    }

    public void a(View view) {
        this.f = view;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public void a(o.a a2) {
        this.i = a2;
        if (this.j != null) {
            this.j.a(a2);
        }
    }

    public void a(boolean bl2) {
        this.h = bl2;
        if (this.j != null) {
            this.j.b(bl2);
        }
    }

    public boolean a(int n2, int n3) {
        if (this.f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        this.a(n2, n3, true, true);
        return true;
    }

    public m b() {
        if (this.j == null) {
            this.j = this.g();
        }
        return this.j;
    }

    public boolean c() {
        if (this.f()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        this.a(0, 0, false, false);
        return true;
    }

    public void d() {
        if (this.f()) {
            this.j.c();
        }
    }

    protected void e() {
        this.j = null;
        if (this.k != null) {
            this.k.onDismiss();
        }
    }

    public boolean f() {
        return this.j != null && this.j.d();
    }

}

