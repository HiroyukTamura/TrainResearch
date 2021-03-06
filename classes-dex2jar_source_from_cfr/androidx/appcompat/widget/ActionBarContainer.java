/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.util.AttributeSet
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.a;
import androidx.appcompat.widget.ah;
import androidx.appcompat.widget.b;
import androidx.core.h.t;

public class ActionBarContainer
extends FrameLayout {
    Drawable a;
    Drawable b;
    Drawable c;
    boolean d;
    boolean e;
    private boolean f;
    private View g;
    private View h;
    private View i;
    private int j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        boolean bl2;
        block5 : {
            block6 : {
                boolean bl3;
                block4 : {
                    super(context, attributeSet);
                    t.a((View)this, new b(this));
                    context = context.obtainStyledAttributes(attributeSet, a.j.ActionBar);
                    this.a = context.getDrawable(a.j.ActionBar_background);
                    this.b = context.getDrawable(a.j.ActionBar_backgroundStacked);
                    this.j = context.getDimensionPixelSize(a.j.ActionBar_height, -1);
                    if (this.getId() == a.f.split_action_bar) {
                        this.d = true;
                        this.c = context.getDrawable(a.j.ActionBar_backgroundSplit);
                    }
                    context.recycle();
                    bl2 = this.d;
                    bl3 = false;
                    if (!bl2) break block4;
                    bl2 = bl3;
                    if (this.c != null) break block5;
                    break block6;
                }
                bl2 = bl3;
                if (this.a != null) break block5;
                bl2 = bl3;
                if (this.b != null) break block5;
            }
            bl2 = true;
        }
        this.setWillNotDraw(bl2);
    }

    private boolean a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
        {
        }
    }

    private int b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.a != null && this.a.isStateful()) {
            this.a.setState(this.getDrawableState());
        }
        if (this.b != null && this.b.isStateful()) {
            this.b.setState(this.getDrawableState());
        }
        if (this.c != null && this.c.isStateful()) {
            this.c.setState(this.getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.g;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.a != null) {
            this.a.jumpToCurrentState();
        }
        if (this.b != null) {
            this.b.jumpToCurrentState();
        }
        if (this.c != null) {
            this.c.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.h = this.findViewById(a.f.action_bar);
        this.i = this.findViewById(a.f.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f || super.onInterceptTouchEvent(motionEvent);
        {
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onLayout(boolean var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block7 : {
            block8 : {
                block9 : {
                    block6 : {
                        super.onLayout(var1_1, var2_2, var3_3, var4_4, var5_5);
                        var9_6 = this.g;
                        var5_5 = 1;
                        var3_3 = 0;
                        var1_1 = var9_6 != null && var9_6.getVisibility() != 8;
                        if (var9_6 != null && var9_6.getVisibility() != 8) {
                            var6_7 = this.getMeasuredHeight();
                            var7_8 = (FrameLayout.LayoutParams)var9_6.getLayoutParams();
                            var9_6.layout(var2_2, var6_7 - var9_6.getMeasuredHeight() - var7_8.bottomMargin, var4_4, var6_7 - var7_8.bottomMargin);
                        }
                        if (!this.d) break block6;
                        if (this.c != null) {
                            this.c.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
                            var2_2 = var5_5;
                        } else {
                            var2_2 = 0;
                        }
                        break block7;
                    }
                    var2_2 = var3_3;
                    if (this.a == null) break block8;
                    if (this.h.getVisibility() != 0) break block9;
                    var8_9 = this.a;
                    var3_3 = this.h.getLeft();
                    var4_4 = this.h.getTop();
                    var2_2 = this.h.getRight();
                    var7_8 = this.h;
                    ** GOTO lbl34
                }
                if (this.i != null && this.i.getVisibility() == 0) {
                    var8_9 = this.a;
                    var3_3 = this.i.getLeft();
                    var4_4 = this.i.getTop();
                    var2_2 = this.i.getRight();
                    var7_8 = this.i;
lbl34: // 2 sources:
                    var8_9.setBounds(var3_3, var4_4, var2_2, var7_8.getBottom());
                } else {
                    this.a.setBounds(0, 0, 0, 0);
                }
                var2_2 = 1;
            }
            this.e = var1_1;
            if (var1_1 && this.b != null) {
                this.b.setBounds(var9_6.getLeft(), var9_6.getTop(), var9_6.getRight(), var9_6.getBottom());
                var2_2 = var5_5;
            }
        }
        if (var2_2 == 0) return;
        this.invalidate();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void onMeasure(int var1_1, int var2_2) {
        block6 : {
            var3_3 = var2_2;
            if (this.h == null) {
                var3_3 = var2_2;
                if (View.MeasureSpec.getMode((int)var2_2) == Integer.MIN_VALUE) {
                    var3_3 = var2_2;
                    if (this.j >= 0) {
                        var3_3 = View.MeasureSpec.makeMeasureSpec((int)Math.min(this.j, View.MeasureSpec.getSize((int)var2_2)), (int)Integer.MIN_VALUE);
                    }
                }
            }
            super.onMeasure(var1_1, var3_3);
            if (this.h == null) {
                return;
            }
            var2_2 = View.MeasureSpec.getMode((int)var3_3);
            if (this.g == null) return;
            if (this.g.getVisibility() == 8) return;
            if (var2_2 == 1073741824) return;
            if (this.a(this.h)) break block6;
            var4_4 = this.h;
            ** GOTO lbl21
        }
        if (!this.a(this.i)) {
            var4_4 = this.i;
lbl21: // 2 sources:
            var1_1 = this.b(var4_4);
        } else {
            var1_1 = 0;
        }
        var2_2 = var2_2 == Integer.MIN_VALUE ? View.MeasureSpec.getSize((int)var3_3) : Integer.MAX_VALUE;
        this.setMeasuredDimension(this.getMeasuredWidth(), Math.min(var1_1 + this.b(this.g), var2_2));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setPrimaryBackground(Drawable drawable2) {
        boolean bl2;
        block7 : {
            block8 : {
                boolean bl3;
                block6 : {
                    if (this.a != null) {
                        this.a.setCallback(null);
                        this.unscheduleDrawable(this.a);
                    }
                    this.a = drawable2;
                    if (drawable2 != null) {
                        drawable2.setCallback((Drawable.Callback)this);
                        if (this.h != null) {
                            this.a.setBounds(this.h.getLeft(), this.h.getTop(), this.h.getRight(), this.h.getBottom());
                        }
                    }
                    bl2 = this.d;
                    bl3 = false;
                    if (!bl2) break block6;
                    bl2 = bl3;
                    if (this.c != null) break block7;
                    break block8;
                }
                bl2 = bl3;
                if (this.a != null) break block7;
                bl2 = bl3;
                if (this.b != null) break block7;
            }
            bl2 = true;
        }
        this.setWillNotDraw(bl2);
        this.invalidate();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setSplitBackground(Drawable drawable2) {
        boolean bl2;
        block7 : {
            block8 : {
                boolean bl3;
                block6 : {
                    if (this.c != null) {
                        this.c.setCallback(null);
                        this.unscheduleDrawable(this.c);
                    }
                    this.c = drawable2;
                    bl3 = false;
                    if (drawable2 != null) {
                        drawable2.setCallback((Drawable.Callback)this);
                        if (this.d && this.c != null) {
                            this.c.setBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight());
                        }
                    }
                    if (!this.d) break block6;
                    bl2 = bl3;
                    if (this.c != null) break block7;
                    break block8;
                }
                bl2 = bl3;
                if (this.a != null) break block7;
                bl2 = bl3;
                if (this.b != null) break block7;
            }
            bl2 = true;
        }
        this.setWillNotDraw(bl2);
        this.invalidate();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setStackedBackground(Drawable drawable2) {
        boolean bl2;
        block7 : {
            block8 : {
                boolean bl3;
                block6 : {
                    if (this.b != null) {
                        this.b.setCallback(null);
                        this.unscheduleDrawable(this.b);
                    }
                    this.b = drawable2;
                    if (drawable2 != null) {
                        drawable2.setCallback((Drawable.Callback)this);
                        if (this.e && this.b != null) {
                            this.b.setBounds(this.g.getLeft(), this.g.getTop(), this.g.getRight(), this.g.getBottom());
                        }
                    }
                    bl2 = this.d;
                    bl3 = false;
                    if (!bl2) break block6;
                    bl2 = bl3;
                    if (this.c != null) break block7;
                    break block8;
                }
                bl2 = bl3;
                if (this.a != null) break block7;
                bl2 = bl3;
                if (this.b != null) break block7;
            }
            bl2 = true;
        }
        this.setWillNotDraw(bl2);
        this.invalidate();
    }

    public void setTabContainer(ah ah2) {
        if (this.g != null) {
            this.removeView(this.g);
        }
        this.g = ah2;
        if (ah2 != null) {
            this.addView((View)ah2);
            ViewGroup.LayoutParams layoutParams = ah2.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            ah2.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean bl2) {
        this.f = bl2;
        int n2 = bl2 ? 393216 : 262144;
        this.setDescendantFocusability(n2);
    }

    public void setVisibility(int n2) {
        super.setVisibility(n2);
        boolean bl2 = n2 == 0;
        if (this.a != null) {
            this.a.setVisible(bl2, false);
        }
        if (this.b != null) {
            this.b.setVisible(bl2, false);
        }
        if (this.c != null) {
            this.c.setVisible(bl2, false);
        }
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int n2) {
        if (n2 != 0) {
            return super.startActionModeForChild(view, callback, n2);
        }
        return null;
    }

    protected boolean verifyDrawable(Drawable drawable2) {
        return drawable2 == this.a && !this.d || drawable2 == this.b && this.e || drawable2 == this.c && this.d || super.verifyDrawable(drawable2);
    }
}

