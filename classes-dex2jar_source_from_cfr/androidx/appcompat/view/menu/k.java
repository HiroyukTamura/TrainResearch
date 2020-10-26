/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.Log
 *  android.view.ActionProvider
 *  android.view.CollapsibleActionView
 *  android.view.ContextMenu
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  android.widget.FrameLayout
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

public class k
extends androidx.appcompat.view.menu.c<androidx.core.b.a.b>
implements MenuItem {
    private Method c;

    k(Context context, androidx.core.b.a.b b2) {
        super(context, b2);
    }

    a a(ActionProvider actionProvider) {
        return new a(this.a, actionProvider);
    }

    public void a(boolean bl2) {
        try {
            if (this.c == null) {
                this.c = ((androidx.core.b.a.b)this.b).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.c.invoke(this.b, bl2);
            return;
        }
        catch (Exception exception) {
            Log.w((String)"MenuItemWrapper", (String)"Error while calling setExclusiveCheckable", (Throwable)exception);
            return;
        }
    }

    public boolean collapseActionView() {
        return ((androidx.core.b.a.b)this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((androidx.core.b.a.b)this.b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        androidx.core.h.b b2 = ((androidx.core.b.a.b)this.b).a();
        if (b2 instanceof a) {
            return ((a)b2).a;
        }
        return null;
    }

    public View getActionView() {
        View view;
        View view2 = view = ((androidx.core.b.a.b)this.b).getActionView();
        if (view instanceof b) {
            view2 = ((b)view).c();
        }
        return view2;
    }

    public int getAlphabeticModifiers() {
        return ((androidx.core.b.a.b)this.b).getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return ((androidx.core.b.a.b)this.b).getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return ((androidx.core.b.a.b)this.b).getContentDescription();
    }

    public int getGroupId() {
        return ((androidx.core.b.a.b)this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((androidx.core.b.a.b)this.b).getIcon();
    }

    public ColorStateList getIconTintList() {
        return ((androidx.core.b.a.b)this.b).getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return ((androidx.core.b.a.b)this.b).getIconTintMode();
    }

    public Intent getIntent() {
        return ((androidx.core.b.a.b)this.b).getIntent();
    }

    public int getItemId() {
        return ((androidx.core.b.a.b)this.b).getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((androidx.core.b.a.b)this.b).getMenuInfo();
    }

    public int getNumericModifiers() {
        return ((androidx.core.b.a.b)this.b).getNumericModifiers();
    }

    public char getNumericShortcut() {
        return ((androidx.core.b.a.b)this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((androidx.core.b.a.b)this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return this.a(((androidx.core.b.a.b)this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((androidx.core.b.a.b)this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((androidx.core.b.a.b)this.b).getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return ((androidx.core.b.a.b)this.b).getTooltipText();
    }

    public boolean hasSubMenu() {
        return ((androidx.core.b.a.b)this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((androidx.core.b.a.b)this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((androidx.core.b.a.b)this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((androidx.core.b.a.b)this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((androidx.core.b.a.b)this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((androidx.core.b.a.b)this.b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider object) {
        androidx.core.b.a.b b2 = (androidx.core.b.a.b)this.b;
        object = object != null ? this.a((ActionProvider)object) : null;
        b2.a((androidx.core.h.b)object);
        return this;
    }

    public MenuItem setActionView(int n2) {
        ((androidx.core.b.a.b)this.b).setActionView(n2);
        View view = ((androidx.core.b.a.b)this.b).getActionView();
        if (view instanceof CollapsibleActionView) {
            ((androidx.core.b.a.b)this.b).setActionView((View)new b(view));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        Object object = view;
        if (view instanceof CollapsibleActionView) {
            object = new b(view);
        }
        ((androidx.core.b.a.b)this.b).setActionView((View)object);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        ((androidx.core.b.a.b)this.b).setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int n2) {
        ((androidx.core.b.a.b)this.b).setAlphabeticShortcut(c2, n2);
        return this;
    }

    public MenuItem setCheckable(boolean bl2) {
        ((androidx.core.b.a.b)this.b).setCheckable(bl2);
        return this;
    }

    public MenuItem setChecked(boolean bl2) {
        ((androidx.core.b.a.b)this.b).setChecked(bl2);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        ((androidx.core.b.a.b)this.b).a(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean bl2) {
        ((androidx.core.b.a.b)this.b).setEnabled(bl2);
        return this;
    }

    public MenuItem setIcon(int n2) {
        ((androidx.core.b.a.b)this.b).setIcon(n2);
        return this;
    }

    public MenuItem setIcon(Drawable drawable2) {
        ((androidx.core.b.a.b)this.b).setIcon(drawable2);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((androidx.core.b.a.b)this.b).setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        ((androidx.core.b.a.b)this.b).setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((androidx.core.b.a.b)this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        ((androidx.core.b.a.b)this.b).setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int n2) {
        ((androidx.core.b.a.b)this.b).setNumericShortcut(c2, n2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        androidx.core.b.a.b b2 = (androidx.core.b.a.b)this.b;
        onActionExpandListener = onActionExpandListener != null ? new c(onActionExpandListener) : null;
        b2.setOnActionExpandListener(onActionExpandListener);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        androidx.core.b.a.b b2 = (androidx.core.b.a.b)this.b;
        onMenuItemClickListener = onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null;
        b2.setOnMenuItemClickListener(onMenuItemClickListener);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        ((androidx.core.b.a.b)this.b).setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int n2, int n3) {
        ((androidx.core.b.a.b)this.b).setShortcut(c2, c3, n2, n3);
        return this;
    }

    public void setShowAsAction(int n2) {
        ((androidx.core.b.a.b)this.b).setShowAsAction(n2);
    }

    public MenuItem setShowAsActionFlags(int n2) {
        ((androidx.core.b.a.b)this.b).setShowAsActionFlags(n2);
        return this;
    }

    public MenuItem setTitle(int n2) {
        ((androidx.core.b.a.b)this.b).setTitle(n2);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((androidx.core.b.a.b)this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((androidx.core.b.a.b)this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        ((androidx.core.b.a.b)this.b).b(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean bl2) {
        return ((androidx.core.b.a.b)this.b).setVisible(bl2);
    }

    class a
    extends androidx.core.h.b {
        final ActionProvider a;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.a = actionProvider;
        }

        @Override
        public View a() {
            return this.a.onCreateActionView();
        }

        @Override
        public void a(SubMenu subMenu) {
            this.a.onPrepareSubMenu(k.this.a(subMenu));
        }

        @Override
        public boolean b() {
            return this.a.onPerformDefaultAction();
        }

        @Override
        public boolean c() {
            return this.a.hasSubMenu();
        }
    }

    static class b
    extends FrameLayout
    implements androidx.appcompat.view.c {
        final CollapsibleActionView a;

        b(View view) {
            super(view.getContext());
            this.a = (CollapsibleActionView)view;
            this.addView(view);
        }

        @Override
        public void a() {
            this.a.onActionViewExpanded();
        }

        @Override
        public void b() {
            this.a.onActionViewCollapsed();
        }

        View c() {
            return (View)this.a;
        }
    }

    private class c
    extends androidx.appcompat.view.menu.d<MenuItem.OnActionExpandListener>
    implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener)this.b).onMenuItemActionCollapse(k.this.a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener)this.b).onMenuItemActionExpand(k.this.a(menuItem));
        }
    }

    private class d
    extends androidx.appcompat.view.menu.d<MenuItem.OnMenuItemClickListener>
    implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener)this.b).onMenuItemClick(k.this.a(menuItem));
        }
    }

}

