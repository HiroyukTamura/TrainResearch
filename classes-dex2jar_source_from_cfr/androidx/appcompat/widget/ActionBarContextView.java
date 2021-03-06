/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityEvent
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.b;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.a;
import androidx.appcompat.widget.ao;
import androidx.appcompat.widget.au;
import androidx.appcompat.widget.c;
import androidx.core.h.t;
import androidx.core.h.x;

public class ActionBarContextView
extends a {
    private CharSequence g;
    private CharSequence h;
    private View i;
    private View j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private int n;
    private int o;
    private boolean p;
    private int q;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.actionModeStyle);
    }

    public ActionBarContextView(Context object, AttributeSet attributeSet, int n2) {
        super((Context)object, attributeSet, n2);
        object = ao.a((Context)object, attributeSet, a.j.ActionMode, n2, 0);
        t.a((View)this, ((ao)object).a(a.j.ActionMode_background));
        this.n = ((ao)object).g(a.j.ActionMode_titleTextStyle, 0);
        this.o = ((ao)object).g(a.j.ActionMode_subtitleTextStyle, 0);
        this.e = ((ao)object).f(a.j.ActionMode_height, 0);
        this.q = ((ao)object).g(a.j.ActionMode_closeItemLayout, a.g.abc_action_mode_close_item_material);
        ((ao)object).a();
    }

    private void e() {
        TextView textView;
        int n2;
        block8 : {
            block7 : {
                if (this.k == null) {
                    LayoutInflater.from((Context)this.getContext()).inflate(a.g.abc_action_bar_title_item, (ViewGroup)this);
                    this.k = (LinearLayout)this.getChildAt(this.getChildCount() - 1);
                    this.l = (TextView)this.k.findViewById(a.f.action_bar_title);
                    this.m = (TextView)this.k.findViewById(a.f.action_bar_subtitle);
                    if (this.n != 0) {
                        this.l.setTextAppearance(this.getContext(), this.n);
                    }
                    if (this.o != 0) {
                        this.m.setTextAppearance(this.getContext(), this.o);
                    }
                }
                this.l.setText(this.g);
                this.m.setText(this.h);
                boolean bl2 = TextUtils.isEmpty((CharSequence)this.g);
                boolean bl3 = TextUtils.isEmpty((CharSequence)this.h) ^ true;
                textView = this.m;
                int n3 = 8;
                n2 = bl3 ? 0 : 8;
                textView.setVisibility(n2);
                textView = this.k;
                if (bl2 ^ true) break block7;
                n2 = n3;
                if (!bl3) break block8;
            }
            n2 = 0;
        }
        textView.setVisibility(n2);
        if (this.k.getParent() == null) {
            this.addView((View)this.k);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(b object) {
        block6 : {
            block5 : {
                block4 : {
                    if (this.i != null) break block4;
                    this.i = LayoutInflater.from((Context)this.getContext()).inflate(this.q, (ViewGroup)this, false);
                    break block5;
                }
                if (this.i.getParent() != null) break block6;
            }
            this.addView(this.i);
        }
        this.i.findViewById(a.f.action_mode_close_button).setOnClickListener(new View.OnClickListener((b)object){
            final /* synthetic */ b a;
            {
                this.a = b2;
            }

            public void onClick(View view) {
                this.a.c();
            }
        });
        object = (h)((b)object).b();
        if (this.d != null) {
            this.d.f();
        }
        this.d = new c(this.getContext());
        this.d.b(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        ((h)object).a(this.d, this.b);
        this.c = (ActionMenuView)this.d.a(this);
        t.a((View)this.c, null);
        this.addView((View)this.c, layoutParams);
    }

    @Override
    public boolean a() {
        if (this.d != null) {
            return this.d.d();
        }
        return false;
    }

    public void b() {
        if (this.i == null) {
            this.c();
        }
    }

    public void c() {
        this.removeAllViews();
        this.j = null;
        this.c = null;
    }

    public boolean d() {
        return this.p;
    }

    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(this.getContext(), attributeSet);
    }

    public CharSequence getSubtitle() {
        return this.h;
    }

    public CharSequence getTitle() {
        return this.g;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.e();
            this.d.g();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource((View)this);
            accessibilityEvent.setClassName((CharSequence)((Object)((Object)this)).getClass().getName());
            accessibilityEvent.setPackageName((CharSequence)this.getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    protected void onLayout(boolean bl2, int n2, int n3, int n4, int n5) {
        bl2 = au.a((View)this);
        int n6 = bl2 ? n4 - n2 - this.getPaddingRight() : this.getPaddingLeft();
        int n7 = this.getPaddingTop();
        int n8 = n5 - n3 - this.getPaddingTop() - this.getPaddingBottom();
        if (this.i != null && this.i.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
            n3 = bl2 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            n5 = bl2 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            n3 = ActionBarContextView.a(n6, n3, bl2);
            n3 = ActionBarContextView.a(n3 + this.a(this.i, n3, n7, n8, bl2), n5, bl2);
        } else {
            n3 = n6;
        }
        n5 = n3;
        if (this.k != null) {
            n5 = n3;
            if (this.j == null) {
                n5 = n3;
                if (this.k.getVisibility() != 8) {
                    n5 = n3 + this.a((View)this.k, n3, n7, n8, bl2);
                }
            }
        }
        if (this.j != null) {
            this.a(this.j, n5, n7, n8, bl2);
        }
        n2 = bl2 ? this.getPaddingLeft() : n4 - n2 - this.getPaddingRight();
        if (this.c != null) {
            this.a((View)this.c, n2, n7, n8, bl2 ^ true);
        }
    }

    protected void onMeasure(int n2, int n3) {
        int n4 = View.MeasureSpec.getMode((int)n2);
        int n5 = 1073741824;
        if (n4 == 1073741824) {
            if (View.MeasureSpec.getMode((int)n3) != 0) {
                int n6 = View.MeasureSpec.getSize((int)n2);
                n4 = this.e > 0 ? this.e : View.MeasureSpec.getSize((int)n3);
                int n7 = this.getPaddingTop() + this.getPaddingBottom();
                n2 = n6 - this.getPaddingLeft() - this.getPaddingRight();
                int n8 = n4 - n7;
                int n9 = View.MeasureSpec.makeMeasureSpec((int)n8, (int)Integer.MIN_VALUE);
                View view = this.i;
                int n10 = 0;
                n3 = n2;
                if (view != null) {
                    n2 = this.a(this.i, n2, n9, 0);
                    view = (ViewGroup.MarginLayoutParams)this.i.getLayoutParams();
                    n3 = n2 - (view.leftMargin + view.rightMargin);
                }
                n2 = n3;
                if (this.c != null) {
                    n2 = n3;
                    if (this.c.getParent() == this) {
                        n2 = this.a((View)this.c, n3, n9, 0);
                    }
                }
                n3 = n2;
                if (this.k != null) {
                    n3 = n2;
                    if (this.j == null) {
                        if (this.p) {
                            n3 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                            this.k.measure(n3, n9);
                            int n11 = this.k.getMeasuredWidth();
                            n9 = n11 <= n2 ? 1 : 0;
                            n3 = n2;
                            if (n9 != 0) {
                                n3 = n2 - n11;
                            }
                            view = this.k;
                            n2 = n9 != 0 ? 0 : 8;
                            view.setVisibility(n2);
                        } else {
                            n3 = this.a((View)this.k, n2, n9, 0);
                        }
                    }
                }
                if (this.j != null) {
                    view = this.j.getLayoutParams();
                    n2 = view.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                    n9 = n3;
                    if (view.width >= 0) {
                        n9 = Math.min(view.width, n3);
                    }
                    n3 = view.height != -2 ? n5 : Integer.MIN_VALUE;
                    n5 = n8;
                    if (view.height >= 0) {
                        n5 = Math.min(view.height, n8);
                    }
                    this.j.measure(View.MeasureSpec.makeMeasureSpec((int)n9, (int)n2), View.MeasureSpec.makeMeasureSpec((int)n5, (int)n3));
                }
                if (this.e <= 0) {
                    n5 = this.getChildCount();
                    n3 = 0;
                    for (n2 = n10; n2 < n5; ++n2) {
                        n9 = this.getChildAt(n2).getMeasuredHeight() + n7;
                        n4 = n3;
                        if (n9 > n3) {
                            n4 = n9;
                        }
                        n3 = n4;
                    }
                    this.setMeasuredDimension(n6, n3);
                    return;
                }
                this.setMeasuredDimension(n6, n4);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(((Object)((Object)this)).getClass().getSimpleName());
            stringBuilder.append(" can only be used ");
            stringBuilder.append("with android:layout_height=\"wrap_content\"");
            throw new IllegalStateException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Object)((Object)this)).getClass().getSimpleName());
        stringBuilder.append(" can only be used ");
        stringBuilder.append("with android:layout_width=\"match_parent\" (or fill_parent)");
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public void setContentHeight(int n2) {
        this.e = n2;
    }

    public void setCustomView(View view) {
        if (this.j != null) {
            this.removeView(this.j);
        }
        this.j = view;
        if (view != null && this.k != null) {
            this.removeView((View)this.k);
            this.k = null;
        }
        if (view != null) {
            this.addView(view);
        }
        this.requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.h = charSequence;
        this.e();
    }

    public void setTitle(CharSequence charSequence) {
        this.g = charSequence;
        this.e();
    }

    public void setTitleOptional(boolean bl2) {
        if (bl2 != this.p) {
            this.requestLayout();
        }
        this.p = bl2;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

}

