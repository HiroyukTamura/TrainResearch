/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 */
package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.p;
import java.util.ArrayList;

public class g
extends BaseAdapter {
    h a;
    private int b = -1;
    private boolean c;
    private final boolean d;
    private final LayoutInflater e;
    private final int f;

    public g(h h2, LayoutInflater layoutInflater, boolean bl2, int n2) {
        this.d = bl2;
        this.e = layoutInflater;
        this.a = h2;
        this.f = n2;
        this.b();
    }

    public h a() {
        return this.a;
    }

    public j a(int n2) {
        ArrayList<j> arrayList = this.d ? this.a.m() : this.a.j();
        int n3 = n2;
        if (this.b >= 0) {
            n3 = n2;
            if (n2 >= this.b) {
                n3 = n2 + 1;
            }
        }
        return arrayList.get(n3);
    }

    public void a(boolean bl2) {
        this.c = bl2;
    }

    void b() {
        j j2 = this.a.s();
        if (j2 != null) {
            ArrayList<j> arrayList = this.a.m();
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
        ArrayList<j> arrayList = this.d ? this.a.m() : this.a.j();
        if (this.b < 0) {
            return arrayList.size();
        }
        return arrayList.size() - 1;
    }

    public /* synthetic */ Object getItem(int n2) {
        return this.a(n2);
    }

    public long getItemId(int n2) {
        return n2;
    }

    public View getView(int n2, View object, ViewGroup object2) {
        View view = object;
        if (object == null) {
            view = this.e.inflate(this.f, (ViewGroup)object2, false);
        }
        int n3 = this.a(n2).getGroupId();
        int n4 = n2 - 1;
        n4 = n4 >= 0 ? this.a(n4).getGroupId() : n3;
        object = (ListMenuItemView)view;
        boolean bl2 = this.a.b() && n3 != n4;
        ((ListMenuItemView)object).setGroupDividerEnabled(bl2);
        object2 = (p.a)view;
        if (this.c) {
            ((ListMenuItemView)object).setForceShowIcon(true);
        }
        object2.a(this.a(n2), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        this.b();
        super.notifyDataSetChanged();
    }
}

