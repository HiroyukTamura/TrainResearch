/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import androidx.appcompat.view.menu.p;
import androidx.appcompat.view.menu.u;
import java.util.ArrayList;

public abstract class b
implements o {
    protected Context a;
    protected Context b;
    protected h c;
    protected LayoutInflater d;
    protected LayoutInflater e;
    protected p f;
    private o.a g;
    private int h;
    private int i;
    private int j;

    public b(Context context, int n2, int n3) {
        this.a = context;
        this.d = LayoutInflater.from((Context)context);
        this.h = n2;
        this.i = n3;
    }

    public View a(j j2, View object, ViewGroup viewGroup) {
        object = object instanceof p.a ? (p.a)object : this.b(viewGroup);
        this.a(j2, (p.a)object);
        return object;
    }

    public o.a a() {
        return this.g;
    }

    public p a(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = (p)this.d.inflate(this.h, viewGroup, false);
            this.f.a(this.c);
            this.a(true);
        }
        return this.f;
    }

    public void a(int n2) {
        this.j = n2;
    }

    @Override
    public void a(Context context, h h2) {
        this.b = context;
        this.e = LayoutInflater.from((Context)this.b);
        this.c = h2;
    }

    protected void a(View view, int n2) {
        ViewGroup viewGroup = (ViewGroup)view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup)this.f).addView(view, n2);
    }

    @Override
    public void a(h h2, boolean bl2) {
        if (this.g != null) {
            this.g.a(h2, bl2);
        }
    }

    public abstract void a(j var1, p.a var2);

    @Override
    public void a(o.a a2) {
        this.g = a2;
    }

    @Override
    public void a(boolean bl2) {
        ViewGroup viewGroup = (ViewGroup)this.f;
        if (viewGroup == null) {
            return;
        }
        Object object = this.c;
        int n2 = 0;
        if (object != null) {
            this.c.k();
            ArrayList<j> arrayList = this.c.j();
            int n3 = arrayList.size();
            n2 = 0;
            for (int i2 = 0; i2 < n3; ++i2) {
                j j2 = arrayList.get(i2);
                int n4 = n2;
                if (this.a(n2, j2)) {
                    View view = viewGroup.getChildAt(n2);
                    object = view instanceof p.a ? ((p.a)view).getItemData() : null;
                    View view2 = this.a(j2, view, viewGroup);
                    if (j2 != object) {
                        view2.setPressed(false);
                        view2.jumpDrawablesToCurrentState();
                    }
                    if (view2 != view) {
                        this.a(view2, n2);
                    }
                    n4 = n2 + 1;
                }
                n2 = n4;
            }
        }
        while (n2 < viewGroup.getChildCount()) {
            if (this.a(viewGroup, n2)) continue;
            ++n2;
        }
    }

    public boolean a(int n2, j j2) {
        return true;
    }

    protected boolean a(ViewGroup viewGroup, int n2) {
        viewGroup.removeViewAt(n2);
        return true;
    }

    @Override
    public boolean a(h h2, j j2) {
        return false;
    }

    @Override
    public boolean a(u u2) {
        if (this.g != null) {
            return this.g.a(u2);
        }
        return false;
    }

    public p.a b(ViewGroup viewGroup) {
        return (p.a)this.d.inflate(this.i, viewGroup, false);
    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public boolean b(h h2, j j2) {
        return false;
    }
}

