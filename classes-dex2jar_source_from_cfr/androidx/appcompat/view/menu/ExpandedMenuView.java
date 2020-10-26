/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.MenuItem
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListAdapter
 *  android.widget.ListView
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.widget.ao;

public final class ExpandedMenuView
extends ListView
implements AdapterView.OnItemClickListener,
h.b,
p {
    private static final int[] a = new int[]{16842964, 16843049};
    private h b;
    private int c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context object, AttributeSet attributeSet, int n2) {
        super((Context)object, attributeSet);
        this.setOnItemClickListener((AdapterView.OnItemClickListener)this);
        object = ao.a((Context)object, attributeSet, a, n2, 0);
        if (((ao)object).g(0)) {
            this.setBackgroundDrawable(((ao)object).a(0));
        }
        if (((ao)object).g(1)) {
            this.setDivider(((ao)object).a(1));
        }
        ((ao)object).a();
    }

    @Override
    public void a(h h2) {
        this.b = h2;
    }

    @Override
    public boolean a(j j2) {
        return this.b.a(j2, 0);
    }

    public int getWindowAnimations() {
        return this.c;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int n2, long l2) {
        this.a((j)this.getAdapter().getItem(n2));
    }
}

