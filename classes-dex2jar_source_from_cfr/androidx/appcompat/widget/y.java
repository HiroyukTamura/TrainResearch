/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AbsListView
 *  android.widget.ListAdapter
 *  android.widget.ListView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.a;
import androidx.appcompat.b.a.c;
import androidx.core.h.x;
import androidx.core.widget.f;
import java.lang.reflect.Field;

class y
extends ListView {
    b a;
    private final Rect b = new Rect();
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g;
    private Field h;
    private a i;
    private boolean j;
    private boolean k;
    private boolean l;
    private x m;
    private f n;

    y(Context context, boolean bl2) {
        super(context, null, a.a.dropDownListViewStyle);
        this.k = bl2;
        this.setCacheColorHint(0);
        try {
            this.h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.h.setAccessible(true);
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
            return;
        }
    }

    private void a() {
        Drawable drawable2 = this.getSelector();
        if (drawable2 != null && this.c() && this.isPressed()) {
            drawable2.setState(this.getDrawableState());
        }
    }

    private void a(int n2, View view) {
        Drawable drawable2 = this.getSelector();
        boolean bl2 = true;
        boolean bl3 = drawable2 != null && n2 != -1;
        if (bl3) {
            drawable2.setVisible(false, false);
        }
        this.b(n2, view);
        if (bl3) {
            view = this.b;
            float f2 = view.exactCenterX();
            float f3 = view.exactCenterY();
            if (this.getVisibility() != 0) {
                bl2 = false;
            }
            drawable2.setVisible(bl2, false);
            androidx.core.graphics.drawable.a.a(drawable2, f2, f3);
        }
    }

    private void a(int n2, View view, float f2, float f3) {
        this.a(n2, view);
        view = this.getSelector();
        if (view != null && n2 != -1) {
            androidx.core.graphics.drawable.a.a((Drawable)view, f2, f3);
        }
    }

    private void a(Canvas canvas) {
        Drawable drawable2;
        if (!this.b.isEmpty() && (drawable2 = this.getSelector()) != null) {
            drawable2.setBounds(this.b);
            drawable2.draw(canvas);
        }
    }

    private void a(View view, int n2) {
        this.performItemClick(view, n2, this.getItemIdAtPosition(n2));
    }

    private void a(View view, int n2, float f2, float f3) {
        View view2;
        this.l = true;
        if (Build.VERSION.SDK_INT >= 21) {
            this.drawableHotspotChanged(f2, f3);
        }
        if (!this.isPressed()) {
            this.setPressed(true);
        }
        this.layoutChildren();
        if (this.g != -1 && (view2 = this.getChildAt(this.g - this.getFirstVisiblePosition())) != null && view2 != view && view2.isPressed()) {
            view2.setPressed(false);
        }
        this.g = n2;
        float f4 = view.getLeft();
        float f5 = view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(f2 - f4, f3 - f5);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        this.a(n2, view, f2, f3);
        this.setSelectorEnabled(false);
        this.refreshDrawableState();
    }

    private void b() {
        this.l = false;
        this.setPressed(false);
        this.drawableStateChanged();
        View view = this.getChildAt(this.g - this.getFirstVisiblePosition());
        if (view != null) {
            view.setPressed(false);
        }
        if (this.m != null) {
            this.m.b();
            this.m = null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void b(int n2, View view) {
        Rect rect = this.b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.c;
        rect.top -= this.d;
        rect.right += this.e;
        rect.bottom += this.f;
        boolean bl2 = this.h.getBoolean((Object)this);
        if (view.isEnabled() == bl2) return;
        this.h.set((Object)this, bl2 ^ true);
        if (n2 == -1) return;
        try {
            this.refreshDrawableState();
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
    }

    private boolean c() {
        return this.l;
    }

    private void setSelectorEnabled(boolean bl2) {
        if (this.i != null) {
            this.i.a(bl2);
        }
    }

    public int a(int n2, int n3, int n4, int n5, int n6) {
        n3 = this.getListPaddingTop();
        n4 = this.getListPaddingBottom();
        this.getListPaddingLeft();
        this.getListPaddingRight();
        int n7 = this.getDividerHeight();
        Drawable drawable2 = this.getDivider();
        ListAdapter listAdapter = this.getAdapter();
        if (listAdapter == null) {
            return n3 + n4;
        }
        if (n7 <= 0 || drawable2 == null) {
            n7 = 0;
        }
        int n8 = listAdapter.getCount();
        n4 = n3 + n4;
        drawable2 = null;
        int n9 = 0;
        n3 = 0;
        for (int i2 = 0; i2 < n8; ++i2) {
            int n10 = listAdapter.getItemViewType(i2);
            int n11 = n9;
            if (n10 != n9) {
                drawable2 = null;
                n11 = n10;
            }
            View view = listAdapter.getView(i2, (View)drawable2, (ViewGroup)this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            drawable2 = layoutParams;
            if (layoutParams == null) {
                drawable2 = this.generateDefaultLayoutParams();
                view.setLayoutParams((ViewGroup.LayoutParams)drawable2);
            }
            n9 = drawable2.height > 0 ? View.MeasureSpec.makeMeasureSpec((int)drawable2.height, (int)1073741824) : View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
            view.measure(n2, n9);
            view.forceLayout();
            n9 = n4;
            if (i2 > 0) {
                n9 = n4 + n7;
            }
            if ((n4 = n9 + view.getMeasuredHeight()) >= n5) {
                n2 = n5;
                if (n6 >= 0) {
                    n2 = n5;
                    if (i2 > n6) {
                        n2 = n5;
                        if (n3 > 0) {
                            n2 = n5;
                            if (n4 != n5) {
                                n2 = n3;
                            }
                        }
                    }
                }
                return n2;
            }
            n10 = n3;
            if (n6 >= 0) {
                n10 = n3;
                if (i2 >= n6) {
                    n10 = n4;
                }
            }
            n9 = n11;
            drawable2 = view;
            n3 = n10;
        }
        return n4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean a(MotionEvent var1_1, int var2_2) {
        block12 : {
            block11 : {
                var3_3 = var1_1.getActionMasked();
                switch (var3_3) {
                    default: {
                        ** GOTO lbl27
                    }
                    case 3: {
                        break;
                    }
                    case 2: {
                        var6_4 = true;
                        ** break;
                    }
                    case 1: {
                        var6_4 = false;
lbl12: // 2 sources:
                        var4_5 = var1_1.findPointerIndex(var2_2);
                        if (var4_5 >= 0) break block11;
                    }
                }
                var2_2 = 0;
                var6_4 = false;
                break block12;
            }
            var2_2 = (int)var1_1.getX(var4_5);
            var5_6 = this.pointToPosition(var2_2, var4_5 = (int)var1_1.getY(var4_5));
            if (var5_6 == -1) {
                var2_2 = 1;
            } else {
                var7_7 = this.getChildAt(var5_6 - this.getFirstVisiblePosition());
                this.a(var7_7, var5_6, (float)var2_2, (float)var4_5);
                if (var3_3 == 1) {
                    this.a(var7_7, var5_6);
                }
lbl27: // 4 sources:
                var2_2 = 0;
                var6_4 = true;
            }
        }
        if (!var6_4 || var2_2 != 0) {
            this.b();
        }
        if (!var6_4) {
            if (this.n == null) return var6_4;
            this.n.a(false);
            return var6_4;
        }
        if (this.n == null) {
            this.n = new f(this);
        }
        this.n.a(true);
        this.n.onTouch((View)this, var1_1);
        return var6_4;
    }

    protected void dispatchDraw(Canvas canvas) {
        this.a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        if (this.a != null) {
            return;
        }
        super.drawableStateChanged();
        this.setSelectorEnabled(true);
        this.a();
    }

    public boolean hasFocus() {
        return this.k || super.hasFocus();
        {
        }
    }

    public boolean hasWindowFocus() {
        return this.k || super.hasWindowFocus();
        {
        }
    }

    public boolean isFocused() {
        return this.k || super.isFocused();
        {
        }
    }

    public boolean isInTouchMode() {
        return this.k && this.j || super.isInTouchMode();
    }

    protected void onDetachedFromWindow() {
        this.a = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int n2 = motionEvent.getActionMasked();
        if (n2 == 10 && this.a == null) {
            this.a = new b();
            this.a.b();
        }
        boolean bl2 = super.onHoverEvent(motionEvent);
        if (n2 != 9 && n2 != 7) {
            this.setSelection(-1);
            return bl2;
        }
        n2 = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
        if (n2 != -1 && n2 != this.getSelectedItemPosition()) {
            motionEvent = this.getChildAt(n2 - this.getFirstVisiblePosition());
            if (motionEvent.isEnabled()) {
                this.setSelectionFromTop(n2, motionEvent.getTop() - this.getTop());
            }
            this.a();
        }
        return bl2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.g = this.pointToPosition((int)motionEvent.getX(), (int)motionEvent.getY());
        }
        if (this.a != null) {
            this.a.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean bl2) {
        this.j = bl2;
    }

    public void setSelector(Drawable drawable2) {
        a a2 = drawable2 != null ? new a(drawable2) : null;
        this.i = a2;
        super.setSelector((Drawable)this.i);
        a2 = new Rect();
        if (drawable2 != null) {
            drawable2.getPadding((Rect)a2);
        }
        this.c = ((Rect)a2).left;
        this.d = ((Rect)a2).top;
        this.e = ((Rect)a2).right;
        this.f = ((Rect)a2).bottom;
    }

    private static class a
    extends c {
        private boolean a = true;

        a(Drawable drawable2) {
            super(drawable2);
        }

        void a(boolean bl2) {
            this.a = bl2;
        }

        @Override
        public void draw(Canvas canvas) {
            if (this.a) {
                super.draw(canvas);
            }
        }

        @Override
        public void setHotspot(float f2, float f3) {
            if (this.a) {
                super.setHotspot(f2, f3);
            }
        }

        @Override
        public void setHotspotBounds(int n2, int n3, int n4, int n5) {
            if (this.a) {
                super.setHotspotBounds(n2, n3, n4, n5);
            }
        }

        @Override
        public boolean setState(int[] arrn) {
            if (this.a) {
                return super.setState(arrn);
            }
            return false;
        }

        @Override
        public boolean setVisible(boolean bl2, boolean bl3) {
            if (this.a) {
                return super.setVisible(bl2, bl3);
            }
            return false;
        }
    }

    private class b
    implements Runnable {
        b() {
        }

        public void a() {
            y.this.a = null;
            y.this.removeCallbacks((Runnable)this);
        }

        public void b() {
            y.this.post((Runnable)this);
        }

        @Override
        public void run() {
            y.this.a = null;
            y.this.drawableStateChanged();
        }
    }

}

