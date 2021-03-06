/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.StateListDrawable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewStub
 *  android.widget.CheckedTextView
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ab;
import androidx.appcompat.widget.aq;
import androidx.core.a.a.f;
import androidx.core.h.a.b;
import androidx.core.h.t;
import androidx.core.widget.i;
import com.google.android.material.a;
import com.google.android.material.internal.d;

public class NavigationMenuItemView
extends d
implements p.a {
    private static final int[] d = new int[]{16842912};
    boolean c;
    private int e;
    private boolean f;
    private final CheckedTextView g;
    private FrameLayout h;
    private j i;
    private ColorStateList j;
    private boolean k;
    private Drawable l;
    private final androidx.core.h.a m = new androidx.core.h.a(){

        @Override
        public void a(View view, b b2) {
            super.a(view, b2);
            b2.a(NavigationMenuItemView.this.c);
        }
    };

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.setOrientation(0);
        LayoutInflater.from((Context)context).inflate(a.g.design_navigation_menu_item, (ViewGroup)this, true);
        this.setIconSize(context.getResources().getDimensionPixelSize(a.c.design_navigation_icon_size));
        this.g = (CheckedTextView)this.findViewById(a.e.design_menu_item_text);
        this.g.setDuplicateParentStateEnabled(true);
        t.a((View)this.g, this.m);
    }

    private boolean b() {
        return this.i.getTitle() == null && this.i.getIcon() == null && this.i.getActionView() != null;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c() {
        block3 : {
            ab.a a2;
            int n2;
            block4 : {
                block2 : {
                    if (!this.b()) break block2;
                    this.g.setVisibility(8);
                    if (this.h == null) break block3;
                    a2 = (ab.a)this.h.getLayoutParams();
                    n2 = -1;
                    break block4;
                }
                this.g.setVisibility(0);
                if (this.h == null) break block3;
                a2 = (ab.a)this.h.getLayoutParams();
                n2 = -2;
            }
            a2.width = n2;
            this.h.setLayoutParams((ViewGroup.LayoutParams)a2);
            return;
        }
    }

    private StateListDrawable d() {
        TypedValue typedValue = new TypedValue();
        if (this.getContext().getTheme().resolveAttribute(a.a.colorControlHighlight, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(d, (Drawable)new ColorDrawable(typedValue.data));
            stateListDrawable.addState(EMPTY_STATE_SET, (Drawable)new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.h == null) {
                this.h = (FrameLayout)((ViewStub)this.findViewById(a.e.design_menu_item_action_area_stub)).inflate();
            }
            this.h.removeAllViews();
            this.h.addView(view);
        }
    }

    @Override
    public void a(j j2, int n2) {
        this.i = j2;
        n2 = j2.isVisible() ? 0 : 8;
        this.setVisibility(n2);
        if (this.getBackground() == null) {
            t.a((View)this, (Drawable)this.d());
        }
        this.setCheckable(j2.isCheckable());
        this.setChecked(j2.isChecked());
        this.setEnabled(j2.isEnabled());
        this.setTitle(j2.getTitle());
        this.setIcon(j2.getIcon());
        this.setActionView(j2.getActionView());
        this.setContentDescription(j2.getContentDescription());
        aq.a((View)this, j2.getTooltipText());
        this.c();
    }

    @Override
    public boolean a() {
        return false;
    }

    @Override
    public j getItemData() {
        return this.i;
    }

    protected int[] onCreateDrawableState(int n2) {
        int[] arrn = super.onCreateDrawableState(n2 + 1);
        if (this.i != null && this.i.isCheckable() && this.i.isChecked()) {
            NavigationMenuItemView.mergeDrawableStates((int[])arrn, (int[])d);
        }
        return arrn;
    }

    public void setCheckable(boolean bl2) {
        this.refreshDrawableState();
        if (this.c != bl2) {
            this.c = bl2;
            this.m.a((View)this.g, 2048);
        }
    }

    public void setChecked(boolean bl2) {
        this.refreshDrawableState();
        this.g.setChecked(bl2);
    }

    public void setHorizontalPadding(int n2) {
        this.setPadding(n2, 0, n2, 0);
    }

    public void setIcon(Drawable drawable2) {
        if (drawable2 != null) {
            Drawable drawable3 = drawable2;
            if (this.k) {
                drawable3 = drawable2.getConstantState();
                if (drawable3 != null) {
                    drawable2 = drawable3.newDrawable();
                }
                drawable3 = androidx.core.graphics.drawable.a.g(drawable2).mutate();
                androidx.core.graphics.drawable.a.a(drawable3, this.j);
            }
            drawable3.setBounds(0, 0, this.e, this.e);
            drawable2 = drawable3;
        } else if (this.f) {
            if (this.l == null) {
                this.l = f.a(this.getResources(), a.d.navigation_empty_icon, this.getContext().getTheme());
                if (this.l != null) {
                    this.l.setBounds(0, 0, this.e, this.e);
                }
            }
            drawable2 = this.l;
        }
        i.a((TextView)this.g, drawable2, null, null, null);
    }

    public void setIconPadding(int n2) {
        this.g.setCompoundDrawablePadding(n2);
    }

    public void setIconSize(int n2) {
        this.e = n2;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        boolean bl2 = this.j != null;
        this.k = bl2;
        if (this.i != null) {
            this.setIcon(this.i.getIcon());
        }
    }

    public void setNeedsEmptyIcon(boolean bl2) {
        this.f = bl2;
    }

    public void setTextAppearance(int n2) {
        i.a((TextView)this.g, n2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.g.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.g.setText(charSequence);
    }

}

