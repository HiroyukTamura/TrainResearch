/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.AbsListView
 *  android.widget.AbsListView$SelectionBoundsAdjuster
 *  android.widget.CheckBox
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.RadioButton
 *  android.widget.TextView
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ao;
import androidx.core.h.t;

public class ListMenuItemView
extends LinearLayout
implements AbsListView.SelectionBoundsAdjuster,
p.a {
    private j a;
    private ImageView b;
    private RadioButton c;
    private TextView d;
    private CheckBox e;
    private TextView f;
    private ImageView g;
    private ImageView h;
    private LinearLayout i;
    private Drawable j;
    private int k;
    private Context l;
    private boolean m;
    private Drawable n;
    private boolean o;
    private int p;
    private LayoutInflater q;
    private boolean r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet object, int n2) {
        super(context, (AttributeSet)object);
        object = ao.a(this.getContext(), (AttributeSet)object, a.j.MenuView, n2, 0);
        this.j = ((ao)object).a(a.j.MenuView_android_itemBackground);
        this.k = ((ao)object).g(a.j.MenuView_android_itemTextAppearance, -1);
        this.m = ((ao)object).a(a.j.MenuView_preserveIconSpacing, false);
        this.l = context;
        this.n = ((ao)object).a(a.j.MenuView_subMenuArrow);
        context = context.getTheme();
        n2 = a.a.dropDownListViewStyle;
        context = context.obtainStyledAttributes(null, new int[]{16843049}, n2, 0);
        this.o = context.hasValue(0);
        ((ao)object).a();
        context.recycle();
    }

    private void a(View view) {
        this.a(view, -1);
    }

    private void a(View view, int n2) {
        if (this.i != null) {
            this.i.addView(view, n2);
            return;
        }
        this.addView(view, n2);
    }

    private void b() {
        this.b = (ImageView)this.getInflater().inflate(a.g.abc_list_menu_item_icon, (ViewGroup)this, false);
        this.a((View)this.b, 0);
    }

    private void c() {
        this.c = (RadioButton)this.getInflater().inflate(a.g.abc_list_menu_item_radio, (ViewGroup)this, false);
        this.a((View)this.c);
    }

    private void d() {
        this.e = (CheckBox)this.getInflater().inflate(a.g.abc_list_menu_item_checkbox, (ViewGroup)this, false);
        this.a((View)this.e);
    }

    private LayoutInflater getInflater() {
        if (this.q == null) {
            this.q = LayoutInflater.from((Context)this.getContext());
        }
        return this.q;
    }

    private void setSubMenuArrowVisible(boolean bl2) {
        if (this.g != null) {
            ImageView imageView = this.g;
            int n2 = bl2 ? 0 : 8;
            imageView.setVisibility(n2);
        }
    }

    @Override
    public void a(j j2, int n2) {
        this.a = j2;
        this.p = n2;
        n2 = j2.isVisible() ? 0 : 8;
        this.setVisibility(n2);
        this.setTitle(j2.a(this));
        this.setCheckable(j2.isCheckable());
        this.a(j2.f(), j2.d());
        this.setIcon(j2.getIcon());
        this.setEnabled(j2.isEnabled());
        this.setSubMenuArrowVisible(j2.hasSubMenu());
        this.setContentDescription(j2.getContentDescription());
    }

    public void a(boolean bl2, char c2) {
        c2 = bl2 && this.a.f() ? (char)'\u0000' : (char)8;
        if (c2 == '\u0000') {
            this.f.setText((CharSequence)this.a.e());
        }
        if (this.f.getVisibility() != c2) {
            this.f.setVisibility((int)c2);
        }
    }

    @Override
    public boolean a() {
        return false;
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        if (this.h != null && this.h.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.h.getLayoutParams();
            rect.top += this.h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    @Override
    public j getItemData() {
        return this.a;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        t.a((View)this, this.j);
        this.d = (TextView)this.findViewById(a.f.title);
        if (this.k != -1) {
            this.d.setTextAppearance(this.l, this.k);
        }
        this.f = (TextView)this.findViewById(a.f.shortcut);
        this.g = (ImageView)this.findViewById(a.f.submenuarrow);
        if (this.g != null) {
            this.g.setImageDrawable(this.n);
        }
        this.h = (ImageView)this.findViewById(a.f.group_divider);
        this.i = (LinearLayout)this.findViewById(a.f.content);
    }

    protected void onMeasure(int n2, int n3) {
        if (this.b != null && this.m) {
            ViewGroup.LayoutParams layoutParams = this.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(n2, n3);
    }

    public void setCheckable(boolean bl2) {
        CheckBox checkBox;
        RadioButton radioButton;
        if (!bl2 && this.c == null && this.e == null) {
            return;
        }
        if (this.a.g()) {
            if (this.c == null) {
                this.c();
            }
            radioButton = this.c;
            checkBox = this.e;
        } else {
            if (this.e == null) {
                this.d();
            }
            radioButton = this.e;
            checkBox = this.c;
        }
        if (bl2) {
            radioButton.setChecked(this.a.isChecked());
            if (radioButton.getVisibility() != 0) {
                radioButton.setVisibility(0);
            }
            if (checkBox != null && checkBox.getVisibility() != 8) {
                checkBox.setVisibility(8);
                return;
            }
        } else {
            if (this.e != null) {
                this.e.setVisibility(8);
            }
            if (this.c != null) {
                this.c.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean bl2) {
        RadioButton radioButton;
        if (this.a.g()) {
            if (this.c == null) {
                this.c();
            }
            radioButton = this.c;
        } else {
            if (this.e == null) {
                this.d();
            }
            radioButton = this.e;
        }
        radioButton.setChecked(bl2);
    }

    public void setForceShowIcon(boolean bl2) {
        this.r = bl2;
        this.m = bl2;
    }

    public void setGroupDividerEnabled(boolean bl2) {
        if (this.h != null) {
            ImageView imageView = this.h;
            int n2 = !this.o && bl2 ? 0 : 8;
            imageView.setVisibility(n2);
        }
    }

    public void setIcon(Drawable drawable2) {
        boolean bl2 = this.a.i() || this.r;
        if (!bl2 && !this.m) {
            return;
        }
        if (this.b == null && drawable2 == null && !this.m) {
            return;
        }
        if (this.b == null) {
            this.b();
        }
        if (drawable2 == null && !this.m) {
            this.b.setVisibility(8);
            return;
        }
        ImageView imageView = this.b;
        if (!bl2) {
            drawable2 = null;
        }
        imageView.setImageDrawable(drawable2);
        if (this.b.getVisibility() != 0) {
            this.b.setVisibility(0);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setTitle(CharSequence charSequence) {
        int n2;
        if (charSequence != null) {
            this.d.setText(charSequence);
            if (this.d.getVisibility() == 0) {
                return;
            }
            charSequence = this.d;
            n2 = 0;
        } else {
            int n3 = this.d.getVisibility();
            n2 = 8;
            if (n3 == 8) return;
            charSequence = this.d;
        }
        charSequence.setVisibility(n2);
    }
}

