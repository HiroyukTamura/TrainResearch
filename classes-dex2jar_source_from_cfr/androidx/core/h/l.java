/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewParent
 */
package androidx.core.h;

import android.view.View;
import android.view.ViewParent;
import androidx.core.h.t;
import androidx.core.h.w;

public class l {
    private ViewParent a;
    private ViewParent b;
    private final View c;
    private boolean d;
    private int[] e;

    public l(View view) {
        this.c = view;
    }

    private void a(int n2, ViewParent viewParent) {
        switch (n2) {
            default: {
                return;
            }
            case 1: {
                this.b = viewParent;
                return;
            }
            case 0: 
        }
        this.a = viewParent;
    }

    private ViewParent d(int n2) {
        switch (n2) {
            default: {
                return null;
            }
            case 1: {
                return this.b;
            }
            case 0: 
        }
        return this.a;
    }

    public void a(boolean bl2) {
        if (this.d) {
            t.x(this.c);
        }
        this.d = bl2;
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(float f2, float f3) {
        ViewParent viewParent;
        if (this.a() && (viewParent = this.d(0)) != null) {
            return w.a(viewParent, this.c, f2, f3);
        }
        return false;
    }

    public boolean a(float f2, float f3, boolean bl2) {
        ViewParent viewParent;
        if (this.a() && (viewParent = this.d(0)) != null) {
            return w.a(viewParent, this.c, f2, f3, bl2);
        }
        return false;
    }

    public boolean a(int n2) {
        return this.d(n2) != null;
    }

    public boolean a(int n2, int n3) {
        if (this.a(n3)) {
            return true;
        }
        if (this.a()) {
            View view = this.c;
            for (ViewParent viewParent = this.c.getParent(); viewParent != null; viewParent = viewParent.getParent()) {
                if (w.a(viewParent, view, this.c, n2, n3)) {
                    this.a(n3, viewParent);
                    w.b(viewParent, view, this.c, n2, n3);
                    return true;
                }
                if (!(viewParent instanceof View)) continue;
                view = (View)viewParent;
            }
        }
        return false;
    }

    public boolean a(int n2, int n3, int n4, int n5, int[] arrn) {
        return this.a(n2, n3, n4, n5, arrn, 0);
    }

    public boolean a(int n2, int n3, int n4, int n5, int[] arrn, int n6) {
        if (this.a()) {
            ViewParent viewParent = this.d(n6);
            if (viewParent == null) {
                return false;
            }
            if (n2 == 0 && n3 == 0 && n4 == 0 && n5 == 0) {
                if (arrn != null) {
                    arrn[0] = 0;
                    arrn[1] = 0;
                    return false;
                }
            } else {
                int n7;
                int n8;
                if (arrn != null) {
                    this.c.getLocationInWindow(arrn);
                    n8 = arrn[0];
                    n7 = arrn[1];
                } else {
                    n8 = 0;
                    n7 = 0;
                }
                w.a(viewParent, this.c, n2, n3, n4, n5, n6);
                if (arrn != null) {
                    this.c.getLocationInWindow(arrn);
                    arrn[0] = arrn[0] - n8;
                    arrn[1] = arrn[1] - n7;
                }
                return true;
            }
        }
        return false;
    }

    public boolean a(int n2, int n3, int[] arrn, int[] arrn2) {
        return this.a(n2, n3, arrn, arrn2, 0);
    }

    public boolean a(int n2, int n3, int[] arrn, int[] arrn2, int n4) {
        if (this.a()) {
            ViewParent viewParent = this.d(n4);
            if (viewParent == null) {
                return false;
            }
            boolean bl2 = true;
            if (n2 == 0 && n3 == 0) {
                if (arrn2 != null) {
                    arrn2[0] = 0;
                    arrn2[1] = 0;
                    return false;
                }
            } else {
                int n5;
                int n6;
                if (arrn2 != null) {
                    this.c.getLocationInWindow(arrn2);
                    n5 = arrn2[0];
                    n6 = arrn2[1];
                } else {
                    n5 = 0;
                    n6 = 0;
                }
                int[] arrn3 = arrn;
                if (arrn == null) {
                    if (this.e == null) {
                        this.e = new int[2];
                    }
                    arrn3 = this.e;
                }
                arrn3[0] = 0;
                arrn3[1] = 0;
                w.a(viewParent, this.c, n2, n3, arrn3, n4);
                if (arrn2 != null) {
                    this.c.getLocationInWindow(arrn2);
                    arrn2[0] = arrn2[0] - n5;
                    arrn2[1] = arrn2[1] - n6;
                }
                if (arrn3[0] == 0) {
                    if (arrn3[1] != 0) {
                        return true;
                    }
                    bl2 = false;
                }
                return bl2;
            }
        }
        return false;
    }

    public boolean b() {
        return this.a(0);
    }

    public boolean b(int n2) {
        return this.a(n2, 0);
    }

    public void c() {
        this.c(0);
    }

    public void c(int n2) {
        ViewParent viewParent = this.d(n2);
        if (viewParent != null) {
            w.a(viewParent, this.c, n2);
            this.a(n2, null);
        }
    }
}

