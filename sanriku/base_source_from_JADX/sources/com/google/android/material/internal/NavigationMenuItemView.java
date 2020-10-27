package com.google.android.material.internal;

import android.content.Context;
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
import androidx.annotation.RestrictTo;
import androidx.appcompat.C0043R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import p043jp.reifrontier.sanriku.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends C1192b implements MenuView.ItemView {

    /* renamed from: o */
    private static final int[] f1205o = {16842912};

    /* renamed from: g */
    private final int f1206g;

    /* renamed from: h */
    boolean f1207h;

    /* renamed from: i */
    private final CheckedTextView f1208i;

    /* renamed from: l */
    private FrameLayout f1209l;

    /* renamed from: m */
    private MenuItemImpl f1210m;

    /* renamed from: n */
    private final AccessibilityDelegateCompat f1211n;

    /* renamed from: com.google.android.material.internal.NavigationMenuItemView$a */
    class C1190a extends AccessibilityDelegateCompat {
        C1190a() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.f1207h);
        }
    }

    public NavigationMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1211n = new C1190a();
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, this, true);
        this.f1206g = context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size);
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.f1208i = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(this.f1208i, this.f1211n);
    }

    public MenuItemImpl getItemData() {
        return this.f1210m;
    }

    public void initialize(MenuItemImpl menuItemImpl, int i) {
        int i2;
        LinearLayoutCompat.LayoutParams layoutParams;
        StateListDrawable stateListDrawable;
        this.f1210m = menuItemImpl;
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        boolean z = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(C0043R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f1205o, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            ViewCompat.setBackground(this, stateListDrawable);
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        View actionView = menuItemImpl.getActionView();
        if (actionView != null) {
            if (this.f1209l == null) {
                this.f1209l = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f1209l.removeAllViews();
            this.f1209l.addView(actionView);
        }
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        if (!(this.f1210m.getTitle() == null && this.f1210m.getIcon() == null && this.f1210m.getActionView() != null)) {
            z = false;
        }
        if (z) {
            this.f1208i.setVisibility(8);
            FrameLayout frameLayout = this.f1209l;
            if (frameLayout != null) {
                layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                i2 = -1;
            } else {
                return;
            }
        } else {
            this.f1208i.setVisibility(0);
            FrameLayout frameLayout2 = this.f1209l;
            if (frameLayout2 != null) {
                layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
                i2 = -2;
            } else {
                return;
            }
        }
        layoutParams.width = i2;
        this.f1209l.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        MenuItemImpl menuItemImpl = this.f1210m;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f1210m.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, f1205o);
        }
        return onCreateDrawableState;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f1207h != z) {
            this.f1207h = z;
            this.f1211n.sendAccessibilityEvent(this.f1208i, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f1208i.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            int i = this.f1206g;
            drawable.setBounds(0, 0, i, i);
        }
        TextViewCompat.setCompoundDrawablesRelative(this.f1208i, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        this.f1208i.setText(charSequence);
    }

    public boolean showsIcon() {
        return true;
    }
}
