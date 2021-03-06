/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.a;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.c;
import androidx.core.h.t;
import androidx.core.h.x;
import androidx.core.h.y;

abstract class a
extends ViewGroup {
    protected final a a = new a();
    protected final Context b;
    protected ActionMenuView c;
    protected c d;
    protected int e;
    protected x f;
    private boolean g;
    private boolean h;

    a(Context context) {
        this(context, null);
    }

    a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    a(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        attributeSet = new TypedValue();
        if (context.getTheme().resolveAttribute(a.a.actionBarPopupTheme, (TypedValue)attributeSet, true) && attributeSet.resourceId != 0) {
            this.b = new ContextThemeWrapper(context, attributeSet.resourceId);
            return;
        }
        this.b = context;
    }

    protected static int a(int n2, int n3, boolean bl2) {
        if (bl2) {
            return n2 - n3;
        }
        return n2 + n3;
    }

    protected int a(View view, int n2, int n3, int n4) {
        view.measure(View.MeasureSpec.makeMeasureSpec((int)n2, (int)Integer.MIN_VALUE), n3);
        return Math.max(0, n2 - view.getMeasuredWidth() - n4);
    }

    protected int a(View view, int n2, int n3, int n4, boolean bl2) {
        int n5 = view.getMeasuredWidth();
        int n6 = view.getMeasuredHeight();
        n3 += (n4 - n6) / 2;
        if (bl2) {
            view.layout(n2 - n5, n3, n2, n6 + n3);
        } else {
            view.layout(n2, n3, n2 + n5, n6 + n3);
        }
        n2 = n5;
        if (bl2) {
            n2 = -n5;
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public x a(int n2, long l2) {
        x x2;
        if (this.f != null) {
            this.f.b();
        }
        if (n2 == 0) {
            if (this.getVisibility() != 0) {
                this.setAlpha(0.0f);
            }
            x2 = t.m((View)this).a(1.0f);
        } else {
            x2 = t.m((View)this).a(0.0f);
        }
        x2.a(l2);
        x2.a(this.a.a(x2, n2));
        return x2;
    }

    public boolean a() {
        if (this.d != null) {
            return this.d.d();
        }
        return false;
    }

    public int getAnimatedVisibility() {
        if (this.f != null) {
            return this.a.a;
        }
        return this.getVisibility();
    }

    public int getContentHeight() {
        return this.e;
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArray = this.getContext().obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
        this.setContentHeight(typedArray.getLayoutDimension(a.j.ActionBar_height, 0));
        typedArray.recycle();
        if (this.d != null) {
            this.d.a(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionMasked();
        if (n2 == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean bl2 = super.onHoverEvent(motionEvent);
            if (n2 == 9 && !bl2) {
                this.h = true;
            }
        }
        if (n2 == 10 || n2 == 3) {
            this.h = false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n2 = motionEvent.getActionMasked();
        if (n2 == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean bl2 = super.onTouchEvent(motionEvent);
            if (n2 == 0 && !bl2) {
                this.g = true;
            }
        }
        if (n2 == 1 || n2 == 3) {
            this.g = false;
        }
        return true;
    }

    public void setContentHeight(int n2) {
        this.e = n2;
        this.requestLayout();
    }

    public void setVisibility(int n2) {
        if (n2 != this.getVisibility()) {
            if (this.f != null) {
                this.f.b();
            }
            super.setVisibility(n2);
        }
    }

    protected class a
    implements y {
        int a;
        private boolean c = false;

        protected a() {
        }

        public a a(x x2, int n2) {
            a.this.f = x2;
            this.a = n2;
            return this;
        }

        @Override
        public void a(View view) {
            a.super.setVisibility(0);
            this.c = false;
        }

        @Override
        public void b(View view) {
            if (this.c) {
                return;
            }
            a.this.f = null;
            a.super.setVisibility(this.a);
        }

        @Override
        public void c(View view) {
            this.c = true;
        }
    }

}

