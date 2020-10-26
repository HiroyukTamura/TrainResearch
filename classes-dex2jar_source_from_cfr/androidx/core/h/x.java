/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.graphics.Paint
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  android.view.animation.Interpolator
 */
package androidx.core.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.core.h.aa;
import androidx.core.h.y;
import java.lang.ref.WeakReference;

public final class x {
    Runnable a = null;
    Runnable b = null;
    int c = -1;
    private WeakReference<View> d;

    x(View view) {
        this.d = new WeakReference<View>(view);
    }

    private void a(final View view, final y y2) {
        if (y2 != null) {
            view.animate().setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(){

                public void onAnimationCancel(Animator animator) {
                    y2.c(view);
                }

                public void onAnimationEnd(Animator animator) {
                    y2.b(view);
                }

                public void onAnimationStart(Animator animator) {
                    y2.a(view);
                }
            });
            return;
        }
        view.animate().setListener(null);
    }

    public long a() {
        View view = (View)this.d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public x a(float f2) {
        View view = (View)this.d.get();
        if (view != null) {
            view.animate().alpha(f2);
        }
        return this;
    }

    public x a(long l2) {
        View view = (View)this.d.get();
        if (view != null) {
            view.animate().setDuration(l2);
        }
        return this;
    }

    public x a(Interpolator interpolator) {
        View view = (View)this.d.get();
        if (view != null) {
            view.animate().setInterpolator((TimeInterpolator)interpolator);
        }
        return this;
    }

    public x a(final aa aa2) {
        final View view = (View)this.d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            if (aa2 != null) {
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener(){

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        aa2.a(view);
                    }
                };
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public x a(y y2) {
        View view = (View)this.d.get();
        if (view == null) {
            return this;
        }
        if (Build.VERSION.SDK_INT < 16) {
            view.setTag(2113929216, (Object)y2);
            y2 = new a(this);
        }
        this.a(view, y2);
        return this;
    }

    public x b(float f2) {
        View view = (View)this.d.get();
        if (view != null) {
            view.animate().translationY(f2);
        }
        return this;
    }

    public x b(long l2) {
        View view = (View)this.d.get();
        if (view != null) {
            view.animate().setStartDelay(l2);
        }
        return this;
    }

    public void b() {
        View view = (View)this.d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public void c() {
        View view = (View)this.d.get();
        if (view != null) {
            view.animate().start();
        }
    }

    static class a
    implements y {
        x a;
        boolean b;

        a(x x2) {
            this.a = x2;
        }

        @Override
        public void a(View view) {
            Object object;
            this.b = false;
            int n2 = this.a.c;
            y y2 = null;
            if (n2 > -1) {
                view.setLayerType(2, null);
            }
            if (this.a.a != null) {
                object = this.a.a;
                this.a.a = null;
                object.run();
            }
            if ((object = view.getTag(2113929216)) instanceof y) {
                y2 = (y)object;
            }
            if (y2 != null) {
                y2.a(view);
            }
        }

        @Override
        public void b(View view) {
            int n2 = this.a.c;
            y y2 = null;
            if (n2 > -1) {
                view.setLayerType(this.a.c, null);
                this.a.c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                Object object;
                if (this.a.b != null) {
                    object = this.a.b;
                    this.a.b = null;
                    object.run();
                }
                if ((object = view.getTag(2113929216)) instanceof y) {
                    y2 = (y)object;
                }
                if (y2 != null) {
                    y2.b(view);
                }
                this.b = true;
            }
        }

        @Override
        public void c(View view) {
            Object object = view.getTag(2113929216);
            object = object instanceof y ? (y)object : null;
            if (object != null) {
                object.c(view);
            }
        }
    }

}

