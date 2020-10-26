/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package androidx.j;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.h.t;
import androidx.j.ac;
import androidx.j.u;
import java.lang.reflect.Method;
import java.util.ArrayList;

class aa
implements ac {
    protected a a;

    aa(Context context, ViewGroup viewGroup, View view) {
        this.a = new a(context, viewGroup, view, this);
    }

    static ViewGroup c(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && view instanceof ViewGroup) {
                return (ViewGroup)view;
            }
            if (!(view.getParent() instanceof ViewGroup)) continue;
            view = (ViewGroup)view.getParent();
        }
        return null;
    }

    static aa d(View view) {
        ViewGroup viewGroup = aa.c(view);
        if (viewGroup != null) {
            int n2 = viewGroup.getChildCount();
            for (int i2 = 0; i2 < n2; ++i2) {
                View view2 = viewGroup.getChildAt(i2);
                if (!(view2 instanceof a)) continue;
                return ((a)view2).e;
            }
            return new u(viewGroup.getContext(), viewGroup, view);
        }
        return null;
    }

    @Override
    public void a(Drawable drawable2) {
        this.a.a(drawable2);
    }

    @Override
    public void b(Drawable drawable2) {
        this.a.b(drawable2);
    }

    static class a
    extends ViewGroup {
        static Method a;
        ViewGroup b;
        View c;
        ArrayList<Drawable> d = null;
        aa e;

        static {
            try {
                a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            }
            catch (NoSuchMethodException noSuchMethodException) {}
        }

        a(Context context, ViewGroup viewGroup, View view, aa aa2) {
            super(context);
            this.b = viewGroup;
            this.c = view;
            this.setRight(viewGroup.getWidth());
            this.setBottom(viewGroup.getHeight());
            viewGroup.addView((View)this);
            this.e = aa2;
        }

        private void a(int[] arrn) {
            int[] arrn2 = new int[2];
            int[] arrn3 = new int[2];
            this.b.getLocationOnScreen(arrn2);
            this.c.getLocationOnScreen(arrn3);
            arrn[0] = arrn3[0] - arrn2[0];
            arrn[1] = arrn3[1] - arrn2[1];
        }

        public void a(Drawable drawable2) {
            if (this.d == null) {
                this.d = new ArrayList();
            }
            if (!this.d.contains((Object)drawable2)) {
                this.d.add(drawable2);
                this.invalidate(drawable2.getBounds());
                drawable2.setCallback((Drawable.Callback)this);
            }
        }

        public void a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup)view.getParent();
                if (viewGroup != this.b && viewGroup.getParent() != null && t.B((View)viewGroup)) {
                    int[] arrn = new int[2];
                    int[] arrn2 = new int[2];
                    viewGroup.getLocationOnScreen(arrn);
                    this.b.getLocationOnScreen(arrn2);
                    t.f(view, arrn[0] - arrn2[0]);
                    t.e(view, arrn[1] - arrn2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, this.getChildCount() - 1);
        }

        boolean a() {
            return this.getChildCount() == 0 && (this.d == null || this.d.size() == 0);
        }

        public void b(Drawable drawable2) {
            if (this.d != null) {
                this.d.remove((Object)drawable2);
                this.invalidate(drawable2.getBounds());
                drawable2.setCallback(null);
            }
        }

        public void b(View view) {
            super.removeView(view);
            if (this.a()) {
                this.b.removeView((View)this);
            }
        }

        protected void dispatchDraw(Canvas canvas) {
            int[] arrn = new int[2];
            int[] arrn2 = new int[2];
            this.b.getLocationOnScreen(arrn);
            this.c.getLocationOnScreen(arrn2);
            canvas.translate((float)(arrn2[0] - arrn[0]), (float)(arrn2[1] - arrn[1]));
            canvas.clipRect(new Rect(0, 0, this.c.getWidth(), this.c.getHeight()));
            super.dispatchDraw(canvas);
            int n2 = this.d == null ? 0 : this.d.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.d.get(i2).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public ViewParent invalidateChildInParent(int[] arrn, Rect rect) {
            if (this.b != null) {
                rect.offset(arrn[0], arrn[1]);
                if (this.b instanceof ViewGroup) {
                    arrn[0] = 0;
                    arrn[1] = 0;
                    int[] arrn2 = new int[2];
                    this.a(arrn2);
                    rect.offset(arrn2[0], arrn2[1]);
                    return super.invalidateChildInParent(arrn, rect);
                }
                this.invalidate(rect);
            }
            return null;
        }

        public void invalidateDrawable(Drawable drawable2) {
            this.invalidate(drawable2.getBounds());
        }

        protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        }

        protected boolean verifyDrawable(Drawable drawable2) {
            return super.verifyDrawable(drawable2) || this.d != null && this.d.contains((Object)drawable2);
            {
            }
        }
    }

}

