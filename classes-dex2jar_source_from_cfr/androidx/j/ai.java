/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.j.a;
import androidx.j.ad;
import androidx.j.m;
import androidx.j.r;
import androidx.j.s;
import androidx.j.w;
import androidx.j.x;
import java.util.Map;

public abstract class ai
extends m {
    private static final String[] h = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    private int i = 3;

    /*
     * Enabled aggressive block sorting
     */
    private b b(s s2, s s3) {
        b b2;
        block11 : {
            block14 : {
                block10 : {
                    block13 : {
                        block12 : {
                            block8 : {
                                block9 : {
                                    b2 = new b();
                                    b2.a = false;
                                    b2.b = false;
                                    ViewGroup viewGroup = null;
                                    if (s2 != null && s2.a.containsKey("android:visibility:visibility")) {
                                        b2.c = (Integer)s2.a.get("android:visibility:visibility");
                                        b2.e = (ViewGroup)s2.a.get("android:visibility:parent");
                                    } else {
                                        b2.c = -1;
                                        b2.e = null;
                                    }
                                    if (s3 != null && s3.a.containsKey("android:visibility:visibility")) {
                                        b2.d = (Integer)s3.a.get("android:visibility:visibility");
                                        viewGroup = (ViewGroup)s3.a.get("android:visibility:parent");
                                    } else {
                                        b2.d = -1;
                                    }
                                    b2.f = viewGroup;
                                    if (s2 == null || s3 == null) break block8;
                                    if (b2.c == b2.d && b2.e == b2.f) {
                                        return b2;
                                    }
                                    if (b2.c == b2.d) break block9;
                                    if (b2.c == 0) break block10;
                                    if (b2.d != 0) break block11;
                                    break block12;
                                }
                                if (b2.f == null) break block10;
                                if (b2.e != null) break block11;
                                break block12;
                            }
                            if (s2 != null || b2.d != 0) break block13;
                        }
                        b2.b = true;
                        break block14;
                    }
                    if (s3 != null || b2.c != 0) break block11;
                }
                b2.b = false;
            }
            b2.a = true;
            return b2;
        }
        return b2;
    }

    private void d(s s2) {
        int n2 = s2.b.getVisibility();
        s2.a.put("android:visibility:visibility", n2);
        s2.a.put("android:visibility:parent", (Object)s2.b.getParent());
        int[] arrn = new int[2];
        s2.b.getLocationOnScreen(arrn);
        s2.a.put("android:visibility:screenLocation", arrn);
    }

    public Animator a(ViewGroup viewGroup, View view, s s2, s s3) {
        return null;
    }

    public Animator a(ViewGroup viewGroup, s s2, int n2, s s3, int n3) {
        if ((this.i & 1) == 1) {
            if (s3 == null) {
                return null;
            }
            if (s2 == null) {
                View view = (View)s3.b.getParent();
                if (this.b((s)this.b((View)view, (boolean)false), (s)this.a((View)view, (boolean)false)).a) {
                    return null;
                }
            }
            return this.a(viewGroup, s3.b, s2, s3);
        }
        return null;
    }

    @Override
    public Animator a(ViewGroup viewGroup, s s2, s s3) {
        b b2 = this.b(s2, s3);
        if (b2.a && (b2.e != null || b2.f != null)) {
            if (b2.b) {
                return this.a(viewGroup, s2, b2.c, s3, b2.d);
            }
            return this.b(viewGroup, s2, b2.c, s3, b2.d);
        }
        return null;
    }

    public void a(int n2) {
        if ((n2 & -4) == 0) {
            this.i = n2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override
    public void a(s s2) {
        this.d(s2);
    }

    @Override
    public boolean a(s object, s s2) {
        boolean bl2;
        block5 : {
            block6 : {
                boolean bl3 = false;
                if (object == null && s2 == null) {
                    return false;
                }
                if (object != null && s2 != null && s2.a.containsKey("android:visibility:visibility") != ((s)object).a.containsKey("android:visibility:visibility")) {
                    return false;
                }
                object = this.b((s)object, s2);
                bl2 = bl3;
                if (!((b)object).a) break block5;
                if (((b)object).c == 0) break block6;
                bl2 = bl3;
                if (((b)object).d != 0) break block5;
            }
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public String[] a() {
        return h;
    }

    public Animator b(ViewGroup viewGroup, View view, s s2, s s3) {
        return null;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public Animator b(ViewGroup var1_1, s var2_2, int var3_3, s var4_4, int var5_5) {
        block9 : {
            block12 : {
                block11 : {
                    block13 : {
                        block10 : {
                            block7 : {
                                block8 : {
                                    if ((this.i & 2) != 2) {
                                        return null;
                                    }
                                    var7_6 = var2_2 != null ? var2_2.b : null;
                                    var6_7 /* !! */  = var4_4 != null ? var4_4.b : null;
                                    if (var6_7 /* !! */  == null || var6_7 /* !! */ .getParent() == null) break block7;
                                    if (var5_5 != 4 && var7_6 != var6_7 /* !! */ ) break block8;
                                    var8_8 = null;
                                    var7_6 = var6_7 /* !! */ ;
                                    var6_7 /* !! */  = var8_8;
                                    break block9;
                                }
                                if (this.e) break block10;
                                var6_7 /* !! */  = (View)var7_6.getParent();
                                ** GOTO lbl-1000
                            }
                            if (var6_7 /* !! */  != null) break block11;
                            if (var7_6 == null) break block12;
                            if (var7_6.getParent() != null) break block13;
                        }
                        var6_7 /* !! */  = var7_6;
                        break block11;
                    }
                    if (var7_6.getParent() instanceof View) {
                        var6_7 /* !! */  = (View)var7_6.getParent();
                        ** if (this.b((s)this.a((View)var6_7 /* !! */ , (boolean)true), (s)this.b((View)var6_7 /* !! */ , (boolean)true)).a) goto lbl-1000
                    }
                    break block12;
lbl-1000: // 2 sources:
                    {
                        var6_7 /* !! */  = r.a(var1_1, (View)var7_6, (View)var6_7 /* !! */ );
                        ** GOTO lbl30
                    }
lbl-1000: // 1 sources:
                    {
                        var6_7 /* !! */  = var6_7 /* !! */ .getParent() == null && (var3_3 = var6_7 /* !! */ .getId()) != -1 && var1_1.findViewById(var3_3) != null && this.e != false ? var7_6 : null;
                    }
                }
                var7_6 = null;
                break block9;
            }
            var6_7 /* !! */  = null;
            var7_6 = var6_7 /* !! */ ;
        }
        if (var6_7 /* !! */  != null && var2_2 != null) {
            var7_6 = (int[])var2_2.a.get("android:visibility:screenLocation");
            var3_3 = var7_6[0];
            var5_5 = var7_6[1];
            var7_6 = new int[2];
            var1_1.getLocationOnScreen((int[])var7_6);
            var6_7 /* !! */ .offsetLeftAndRight(var3_3 - var7_6[0] - var6_7 /* !! */ .getLeft());
            var6_7 /* !! */ .offsetTopAndBottom(var5_5 - var7_6[1] - var6_7 /* !! */ .getTop());
            var7_6 = x.a(var1_1);
            var7_6.a((View)var6_7 /* !! */ );
            var1_1 = this.b(var1_1, (View)var6_7 /* !! */ , (s)var2_2, var4_4);
            if (var1_1 == null) {
                var7_6.b((View)var6_7 /* !! */ );
                return var1_1;
            }
            var1_1.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter((w)var7_6, (View)var6_7 /* !! */ ){
                final /* synthetic */ w a;
                final /* synthetic */ View b;
                {
                    this.a = w2;
                    this.b = view;
                }

                public void onAnimationEnd(Animator animator) {
                    this.a.b(this.b);
                }
            });
            return var1_1;
        }
        if (var7_6 == null) return null;
        var3_3 = var7_6.getVisibility();
        ad.a((View)var7_6, 0);
        var1_1 = this.b(var1_1, (View)var7_6, (s)var2_2, var4_4);
        if (var1_1 != null) {
            var2_2 = new a((View)var7_6, var5_5, true);
            var1_1.addListener((Animator.AnimatorListener)var2_2);
            androidx.j.a.a((Animator)var1_1, (AnimatorListenerAdapter)var2_2);
            this.a((m.c)var2_2);
            return var1_1;
        }
        ad.a((View)var7_6, var3_3);
        return var1_1;
    }

    @Override
    public void b(s s2) {
        this.d(s2);
    }

    private static class a
    extends AnimatorListenerAdapter
    implements a.a,
    m.c {
        boolean a = false;
        private final View b;
        private final int c;
        private final ViewGroup d;
        private final boolean e;
        private boolean f;

        a(View view, int n2, boolean bl2) {
            this.b = view;
            this.c = n2;
            this.d = (ViewGroup)view.getParent();
            this.e = bl2;
            this.a(true);
        }

        private void a() {
            if (!this.a) {
                ad.a(this.b, this.c);
                if (this.d != null) {
                    this.d.invalidate();
                }
            }
            this.a(false);
        }

        private void a(boolean bl2) {
            if (this.e && this.f != bl2 && this.d != null) {
                this.f = bl2;
                x.a(this.d, bl2);
            }
        }

        @Override
        public void a(m m2) {
            this.a();
            m2.b(this);
        }

        @Override
        public void b(m m2) {
            this.a(false);
        }

        @Override
        public void c(m m2) {
            this.a(true);
        }

        @Override
        public void d(m m2) {
        }

        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        public void onAnimationEnd(Animator animator) {
            this.a();
        }

        @Override
        public void onAnimationPause(Animator animator) {
            if (!this.a) {
                ad.a(this.b, this.c);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        @Override
        public void onAnimationResume(Animator animator) {
            if (!this.a) {
                ad.a(this.b, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    private static class b {
        boolean a;
        boolean b;
        int c;
        int d;
        ViewGroup e;
        ViewGroup f;

        b() {
        }
    }

}

