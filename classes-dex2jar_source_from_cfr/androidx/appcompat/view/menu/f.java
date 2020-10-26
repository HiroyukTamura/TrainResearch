/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.view.ContextThemeWrapper
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.BaseAdapter
 *  android.widget.ListAdapter
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.a;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.u;
import java.util.ArrayList;

public class f
implements AdapterView.OnItemClickListener,
o {
    Context a;
    LayoutInflater b;
    h c;
    ExpandedMenuView d;
    int e;
    int f;
    int g;
    a h;
    private o.a i;

    public f(int n2, int n3) {
        this.g = n2;
        this.f = n3;
    }

    public f(Context context, int n2) {
        this(n2, 0);
        this.a = context;
        this.b = LayoutInflater.from((Context)this.a);
    }

    public ListAdapter a() {
        if (this.h == null) {
            this.h = new a();
        }
        return this.h;
    }

    public p a(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView)this.b.inflate(a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.h == null) {
                this.h = new a();
            }
            this.d.setAdapter((ListAdapter)this.h);
            this.d.setOnItemClickListener((AdapterView.OnItemClickListener)this);
        }
        return this.d;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(Context context, h h2) {
        block6 : {
            block5 : {
                block4 : {
                    if (this.f == 0) break block4;
                    this.a = new ContextThemeWrapper(context, this.f);
                    break block5;
                }
                if (this.a == null) break block6;
                this.a = context;
                if (this.b != null) break block6;
            }
            this.b = LayoutInflater.from((Context)this.a);
        }
        this.c = h2;
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    @Override
    public void a(h h2, boolean bl2) {
        if (this.i != null) {
            this.i.a(h2, bl2);
        }
    }

    @Override
    public void a(o.a a2) {
        this.i = a2;
    }

    @Override
    public void a(boolean bl2) {
        if (this.h != null) {
            this.h.notifyDataSetChanged();
        }
    }

    @Override
    public boolean a(h h2, j j2) {
        return false;
    }

    @Override
    public boolean a(u u2) {
        if (!u2.hasVisibleItems()) {
            return false;
        }
        new i(u2).a((IBinder)null);
        if (this.i != null) {
            this.i.a(u2);
        }
        return true;
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public boolean b(h h2, j j2) {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int n2, long l2) {
        this.c.a(this.h.a(n2), this, 0);
    }

    private class a
    extends BaseAdapter {
        private int b = -1;

        public a() {
            this.a();
        }

        public j a(int n2) {
            int n3;
            ArrayList<j> arrayList = f.this.c.m();
            n2 = n3 = n2 + f.this.e;
            if (this.b >= 0) {
                n2 = n3;
                if (n3 >= this.b) {
                    n2 = n3 + 1;
                }
            }
            return arrayList.get(n2);
        }

        void a() {
            j j2 = f.this.c.s();
            if (j2 != null) {
                ArrayList<j> arrayList = f.this.c.m();
                int n2 = arrayList.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (arrayList.get(i2) != j2) continue;
                    this.b = i2;
                    return;
                }
            }
            this.b = -1;
        }

        public int getCount() {
            int n2 = f.this.c.m().size() - f.this.e;
            if (this.b < 0) {
                return n2;
            }
            return n2 - 1;
        }

        public /* synthetic */ Object getItem(int n2) {
            return this.a(n2);
        }

        public long getItemId(int n2) {
            return n2;
        }

        public View getView(int n2, View view, ViewGroup viewGroup) {
            View view2 = view;
            if (view == null) {
                view2 = f.this.b.inflate(f.this.g, viewGroup, false);
            }
            ((p.a)view2).a(this.a(n2), 0);
            return view2;
        }

        public void notifyDataSetChanged() {
            this.a();
            super.notifyDataSetChanged();
        }
    }

}

