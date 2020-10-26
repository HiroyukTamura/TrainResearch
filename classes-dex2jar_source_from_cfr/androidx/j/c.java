/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TypeEvaluator
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package androidx.j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.h.t;
import androidx.j.ad;
import androidx.j.f;
import androidx.j.g;
import androidx.j.i;
import androidx.j.k;
import androidx.j.m;
import androidx.j.n;
import androidx.j.r;
import androidx.j.s;
import androidx.j.x;
import java.util.Map;

public class c
extends m {
    private static final String[] h = new String[]{"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property<Drawable, PointF> i = new Property<Drawable, PointF>(PointF.class, "boundsOrigin"){
        private Rect a = new Rect();

        public PointF a(Drawable drawable2) {
            drawable2.copyBounds(this.a);
            return new PointF((float)this.a.left, (float)this.a.top);
        }

        public void a(Drawable drawable2, PointF pointF) {
            drawable2.copyBounds(this.a);
            this.a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable2.setBounds(this.a);
        }

        public /* synthetic */ Object get(Object object) {
            return this.a((Drawable)object);
        }

        public /* synthetic */ void set(Object object, Object object2) {
            this.a((Drawable)object, (PointF)object2);
        }
    };
    private static final Property<a, PointF> j = new Property<a, PointF>(PointF.class, "topLeft"){

        public PointF a(a a2) {
            return null;
        }

        public void a(a a2, PointF pointF) {
            a2.a(pointF);
        }

        public /* synthetic */ Object get(Object object) {
            return this.a((a)object);
        }

        public /* synthetic */ void set(Object object, Object object2) {
            this.a((a)object, (PointF)object2);
        }
    };
    private static final Property<a, PointF> k = new Property<a, PointF>(PointF.class, "bottomRight"){

        public PointF a(a a2) {
            return null;
        }

        public void a(a a2, PointF pointF) {
            a2.b(pointF);
        }

        public /* synthetic */ Object get(Object object) {
            return this.a((a)object);
        }

        public /* synthetic */ void set(Object object, Object object2) {
            this.a((a)object, (PointF)object2);
        }
    };
    private static final Property<View, PointF> l = new Property<View, PointF>(PointF.class, "bottomRight"){

        public PointF a(View view) {
            return null;
        }

        public void a(View view, PointF pointF) {
            ad.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }

        public /* synthetic */ Object get(Object object) {
            return this.a((View)object);
        }

        public /* synthetic */ void set(Object object, Object object2) {
            this.a((View)object, (PointF)object2);
        }
    };
    private static final Property<View, PointF> m = new Property<View, PointF>(PointF.class, "topLeft"){

        public PointF a(View view) {
            return null;
        }

        public void a(View view, PointF pointF) {
            ad.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }

        public /* synthetic */ Object get(Object object) {
            return this.a((View)object);
        }

        public /* synthetic */ void set(Object object, Object object2) {
            this.a((View)object, (PointF)object2);
        }
    };
    private static final Property<View, PointF> n = new Property<View, PointF>(PointF.class, "position"){

        public PointF a(View view) {
            return null;
        }

        public void a(View view, PointF pointF) {
            int n2 = Math.round(pointF.x);
            int n3 = Math.round(pointF.y);
            ad.a(view, n2, n3, view.getWidth() + n2, view.getHeight() + n3);
        }

        public /* synthetic */ Object get(Object object) {
            return this.a((View)object);
        }

        public /* synthetic */ void set(Object object, Object object2) {
            this.a((View)object, (PointF)object2);
        }
    };
    private static k r = new k();
    private int[] o = new int[2];
    private boolean p = false;
    private boolean q = false;

    private boolean a(View view, View view2) {
        if (this.q) {
            s s2 = this.b(view, true);
            return s2 == null ? view == view2 : view2 == s2.b;
        }
        return true;
    }

    private void d(s s2) {
        View view = s2.b;
        if (t.y(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            s2.a.put("android:changeBounds:bounds", (Object)new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            s2.a.put("android:changeBounds:parent", (Object)s2.b.getParent());
            if (this.q) {
                s2.b.getLocationInWindow(this.o);
                s2.a.put("android:changeBounds:windowX", this.o[0]);
                s2.a.put("android:changeBounds:windowY", this.o[1]);
            }
            if (this.p) {
                s2.a.put("android:changeBounds:clip", (Object)t.A(view));
            }
        }
    }

    @Override
    public Animator a(final ViewGroup viewGroup, s rect, s s2) {
        block18 : {
            block19 : {
                int n2;
                int n3;
                View view;
                int n4;
                int n5;
                block32 : {
                    block26 : {
                        block20 : {
                            block31 : {
                                int n6;
                                int n7;
                                int n8;
                                int n9;
                                int n10;
                                int n11;
                                int n12;
                                int n13;
                                int n14;
                                ViewGroup viewGroup2;
                                ViewGroup viewGroup3;
                                int n15;
                                block27 : {
                                    block30 : {
                                        int n16;
                                        int n17;
                                        block28 : {
                                            block29 : {
                                                int n18;
                                                block25 : {
                                                    int n19;
                                                    block24 : {
                                                        block23 : {
                                                            block21 : {
                                                                block22 : {
                                                                    if (rect == null || s2 == null) break block18;
                                                                    viewGroup2 = rect.a;
                                                                    view = s2.a;
                                                                    viewGroup2 = (ViewGroup)viewGroup2.get("android:changeBounds:parent");
                                                                    viewGroup3 = (ViewGroup)view.get("android:changeBounds:parent");
                                                                    if (viewGroup2 == null || viewGroup3 == null) break block19;
                                                                    view = s2.b;
                                                                    if (!this.a((View)viewGroup2, (View)viewGroup3)) break block20;
                                                                    viewGroup = (Rect)rect.a.get("android:changeBounds:bounds");
                                                                    viewGroup2 = (Rect)s2.a.get("android:changeBounds:bounds");
                                                                    n13 = viewGroup.left;
                                                                    n7 = viewGroup2.left;
                                                                    n10 = viewGroup.top;
                                                                    n11 = viewGroup2.top;
                                                                    n17 = viewGroup.right;
                                                                    n9 = viewGroup2.right;
                                                                    n16 = viewGroup.bottom;
                                                                    n12 = viewGroup2.bottom;
                                                                    n14 = n17 - n13;
                                                                    n15 = n16 - n10;
                                                                    n8 = n9 - n7;
                                                                    n6 = n12 - n11;
                                                                    rect = (Rect)rect.a.get("android:changeBounds:clip");
                                                                    viewGroup2 = (Rect)s2.a.get("android:changeBounds:clip");
                                                                    if ((n14 == 0 || n15 == 0) && (n8 == 0 || n6 == 0)) break block21;
                                                                    n18 = n13 == n7 && n10 == n11 ? 0 : 1;
                                                                    if (n17 != n9) break block22;
                                                                    n19 = n18;
                                                                    if (n16 == n12) break block23;
                                                                }
                                                                n19 = n18 + 1;
                                                                break block23;
                                                            }
                                                            n19 = 0;
                                                        }
                                                        if (rect != null && !rect.equals((Object)viewGroup2)) break block24;
                                                        n18 = n19;
                                                        if (rect != null) break block25;
                                                        n18 = n19;
                                                        if (viewGroup2 == null) break block25;
                                                    }
                                                    n18 = n19 + 1;
                                                }
                                                if (n18 <= 0) break block26;
                                                if (this.p) break block27;
                                                s2 = view;
                                                ad.a((View)s2, n13, n10, n17, n16);
                                                if (n18 != 2) break block28;
                                                if (n14 != n8 || n15 != n6) break block29;
                                                viewGroup = this.l().a(n13, n10, n7, n11);
                                                rect = n;
                                                break block30;
                                            }
                                            rect = new a((View)s2);
                                            viewGroup = this.l().a(n13, n10, n7, n11);
                                            s2 = f.a(rect, j, (Path)viewGroup);
                                            viewGroup = this.l().a(n17, n16, n9, n12);
                                            viewGroup2 = f.a(rect, k, (Path)viewGroup);
                                            viewGroup = new AnimatorSet();
                                            viewGroup.playTogether(new Animator[]{s2, viewGroup2});
                                            viewGroup.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter((a)rect){
                                                final /* synthetic */ a a;
                                                private a mViewBounds;
                                                {
                                                    this.a = a2;
                                                    this.mViewBounds = this.a;
                                                }
                                            });
                                            break block31;
                                        }
                                        if (n13 == n7 && n10 == n11) {
                                            viewGroup = this.l().a(n17, n16, n9, n12);
                                            rect = l;
                                        } else {
                                            viewGroup = this.l().a(n13, n10, n7, n11);
                                            rect = m;
                                        }
                                    }
                                    viewGroup = f.a(s2, rect, (Path)viewGroup);
                                    break block31;
                                }
                                viewGroup3 = view;
                                ad.a((View)viewGroup3, n13, n10, Math.max(n14, n8) + n13, Math.max(n15, n6) + n10);
                                if (n13 == n7 && n10 == n11) {
                                    viewGroup = null;
                                } else {
                                    viewGroup = this.l().a(n13, n10, n7, n11);
                                    viewGroup = f.a(viewGroup3, n, (Path)viewGroup);
                                }
                                if (rect == null) {
                                    rect = new Rect(0, 0, n14, n15);
                                }
                                if (!rect.equals((Object)(s2 = viewGroup2 == null ? new Rect(0, 0, n8, n6) : viewGroup2))) {
                                    t.a((View)viewGroup3, rect);
                                    rect = ObjectAnimator.ofObject((Object)viewGroup3, (String)"clipBounds", (TypeEvaluator)r, (Object[])new Object[]{rect, s2});
                                    rect.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter((View)viewGroup3, (Rect)viewGroup2, n7, n11, n9, n12){
                                        final /* synthetic */ View a;
                                        final /* synthetic */ Rect b;
                                        final /* synthetic */ int c;
                                        final /* synthetic */ int d;
                                        final /* synthetic */ int e;
                                        final /* synthetic */ int f;
                                        private boolean h;
                                        {
                                            this.a = view;
                                            this.b = rect;
                                            this.c = n2;
                                            this.d = n3;
                                            this.e = n4;
                                            this.f = n5;
                                        }

                                        public void onAnimationCancel(Animator animator) {
                                            this.h = true;
                                        }

                                        public void onAnimationEnd(Animator animator) {
                                            if (!this.h) {
                                                t.a(this.a, this.b);
                                                ad.a(this.a, this.c, this.d, this.e, this.f);
                                            }
                                        }
                                    });
                                } else {
                                    rect = null;
                                }
                                viewGroup = r.a((Animator)viewGroup, (Animator)rect);
                            }
                            if (view.getParent() instanceof ViewGroup) {
                                rect = (ViewGroup)view.getParent();
                                x.a((ViewGroup)rect, true);
                                this.a(new n((ViewGroup)rect){
                                    boolean a = false;
                                    final /* synthetic */ ViewGroup b;
                                    {
                                        this.b = viewGroup;
                                    }

                                    @Override
                                    public void a(m m2) {
                                        if (!this.a) {
                                            x.a(this.b, false);
                                        }
                                        m2.b(this);
                                    }

                                    @Override
                                    public void b(m m2) {
                                        x.a(this.b, false);
                                    }

                                    @Override
                                    public void c(m m2) {
                                        x.a(this.b, true);
                                    }
                                });
                            }
                            return viewGroup;
                        }
                        n3 = (Integer)rect.a.get("android:changeBounds:windowX");
                        n2 = (Integer)rect.a.get("android:changeBounds:windowY");
                        n4 = (Integer)s2.a.get("android:changeBounds:windowX");
                        n5 = (Integer)s2.a.get("android:changeBounds:windowY");
                        if (n3 != n4 || n2 != n5) break block32;
                    }
                    return null;
                }
                viewGroup.getLocationInWindow(this.o);
                rect = Bitmap.createBitmap((int)view.getWidth(), (int)view.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                view.draw(new Canvas((Bitmap)rect));
                rect = new BitmapDrawable((Bitmap)rect);
                float f2 = ad.c(view);
                ad.a(view, 0.0f);
                ad.a((View)viewGroup).a((Drawable)rect);
                s2 = this.l().a(n3 - this.o[0], n2 - this.o[1], n4 - this.o[0], n5 - this.o[1]);
                s2 = ObjectAnimator.ofPropertyValuesHolder((Object)rect, (PropertyValuesHolder[])new PropertyValuesHolder[]{i.a(i, (Path)s2)});
                s2.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter((BitmapDrawable)rect, view, f2){
                    final /* synthetic */ BitmapDrawable b;
                    final /* synthetic */ View c;
                    final /* synthetic */ float d;
                    {
                        this.b = bitmapDrawable;
                        this.c = view;
                        this.d = f2;
                    }

                    public void onAnimationEnd(Animator animator) {
                        ad.a((View)viewGroup).b((Drawable)this.b);
                        ad.a(this.c, this.d);
                    }
                });
                return s2;
            }
            return null;
        }
        return null;
    }

    @Override
    public void a(s s2) {
        this.d(s2);
    }

    @Override
    public String[] a() {
        return h;
    }

    @Override
    public void b(s s2) {
        this.d(s2);
    }

    private static class a {
        private int a;
        private int b;
        private int c;
        private int d;
        private View e;
        private int f;
        private int g;

        a(View view) {
            this.e = view;
        }

        private void a() {
            ad.a(this.e, this.a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }

        void a(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            ++this.f;
            if (this.f == this.g) {
                this.a();
            }
        }

        void b(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            ++this.g;
            if (this.f == this.g) {
                this.a();
            }
        }
    }

}

