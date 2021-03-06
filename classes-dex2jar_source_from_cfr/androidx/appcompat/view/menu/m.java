/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.Adapter
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.HeaderViewListAdapter
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.s;

abstract class m
implements AdapterView.OnItemClickListener,
o,
s {
    private Rect a;

    m() {
    }

    protected static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int n2) {
        int n3 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n4 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
        int n5 = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        viewGroup = null;
        int n6 = 0;
        int n7 = 0;
        for (int i2 = 0; i2 < n5; ++i2) {
            int n8 = listAdapter.getItemViewType(i2);
            int n9 = n6;
            if (n8 != n6) {
                viewGroup = null;
                n9 = n8;
            }
            ViewGroup viewGroup3 = viewGroup2;
            if (viewGroup2 == null) {
                viewGroup3 = new FrameLayout(context);
            }
            viewGroup = listAdapter.getView(i2, (View)viewGroup, viewGroup3);
            viewGroup.measure(n3, n4);
            n8 = viewGroup.getMeasuredWidth();
            if (n8 >= n2) {
                return n2;
            }
            n6 = n7;
            if (n8 > n7) {
                n6 = n8;
            }
            n7 = n6;
            viewGroup2 = viewGroup3;
            n6 = n9;
        }
        return n7;
    }

    protected static g a(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (g)((HeaderViewListAdapter)listAdapter).getWrappedAdapter();
        }
        return (g)listAdapter;
    }

    protected static boolean b(h h2) {
        int n2 = h2.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            MenuItem menuItem = h2.getItem(i2);
            if (!menuItem.isVisible() || menuItem.getIcon() == null) continue;
            return true;
        }
        return false;
    }

    public abstract void a(int var1);

    @Override
    public void a(Context context, h h2) {
    }

    public void a(Rect rect) {
        this.a = rect;
    }

    public abstract void a(View var1);

    public abstract void a(PopupWindow.OnDismissListener var1);

    public abstract void a(h var1);

    @Override
    public boolean a(h h2, j j2) {
        return false;
    }

    public abstract void b(int var1);

    public abstract void b(boolean var1);

    @Override
    public boolean b(h h2, j j2) {
        return false;
    }

    public abstract void c(int var1);

    public abstract void c(boolean var1);

    protected boolean f() {
        return true;
    }

    public Rect g() {
        return this.a;
    }

    public void onItemClick(AdapterView<?> object, View view, int n2, long l2) {
        view = (ListAdapter)object.getAdapter();
        object = m.a((ListAdapter)view).a;
        view = (MenuItem)view.getItem(n2);
        n2 = this.f() ? 0 : 4;
        ((h)object).a((MenuItem)view, this, n2);
    }
}

