/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.f.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.f.a.d;
import androidx.f.a.i;
import androidx.f.a.p;
import androidx.viewpager.widget.a;
import java.util.ArrayList;
import java.util.Set;

public abstract class o
extends a {
    private final i a;
    private p b = null;
    private ArrayList<d.d> c = new ArrayList();
    private ArrayList<d> d = new ArrayList();
    private d e = null;

    public o(i i2) {
        this.a = i2;
    }

    @Override
    public Parcelable a() {
        Object object;
        Bundle bundle;
        if (this.c.size() > 0) {
            object = new Bundle();
            bundle = new d.d[this.c.size()];
            this.c.toArray((T[])bundle);
            object.putParcelableArray("states", (Parcelable[])bundle);
        } else {
            object = null;
        }
        for (int i2 = 0; i2 < this.d.size(); ++i2) {
            d d2 = this.d.get(i2);
            bundle = object;
            if (d2 != null) {
                bundle = object;
                if (d2.v()) {
                    bundle = object;
                    if (object == null) {
                        bundle = new Bundle();
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("f");
                    ((StringBuilder)object).append(i2);
                    object = ((StringBuilder)object).toString();
                    this.a.a(bundle, (String)object, d2);
                }
            }
            object = bundle;
        }
        return object;
    }

    public abstract d a(int var1);

    @Override
    public Object a(ViewGroup viewGroup, int n2) {
        d.d d2;
        d d3;
        if (this.d.size() > n2 && (d3 = this.d.get(n2)) != null) {
            return d3;
        }
        if (this.b == null) {
            this.b = this.a.a();
        }
        d3 = this.a(n2);
        if (this.c.size() > n2 && (d2 = this.c.get(n2)) != null) {
            d3.a(d2);
        }
        while (this.d.size() <= n2) {
            this.d.add(null);
        }
        d3.c(false);
        d3.d(false);
        this.d.set(n2, d3);
        this.b.a(viewGroup.getId(), d3);
        return d3;
    }

    @Override
    public void a(Parcelable parcelable, ClassLoader object) {
        if (parcelable != null) {
            int n2;
            parcelable = (Bundle)parcelable;
            parcelable.setClassLoader((ClassLoader)object);
            object = parcelable.getParcelableArray("states");
            this.c.clear();
            this.d.clear();
            if (object != null) {
                for (n2 = 0; n2 < ((Parcelable[])object).length; ++n2) {
                    this.c.add((d.d)object[n2]);
                }
            }
            for (String string2 : parcelable.keySet()) {
                if (!string2.startsWith("f")) continue;
                n2 = Integer.parseInt(string2.substring(1));
                Object object2 = this.a.a((Bundle)parcelable, string2);
                if (object2 != null) {
                    while (this.d.size() <= n2) {
                        this.d.add(null);
                    }
                    ((d)object2).c(false);
                    this.d.set(n2, (d)object2);
                    continue;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Bad fragment at key ");
                ((StringBuilder)object2).append(string2);
                Log.w((String)"FragmentStatePagerAdapt", (String)((StringBuilder)object2).toString());
            }
        }
    }

    @Override
    public void a(ViewGroup object) {
        if (object.getId() != -1) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("ViewPager with adapter ");
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" requires a view id");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    @Override
    public void a(ViewGroup object, int n2, Object object2) {
        object2 = (d)object2;
        if (this.b == null) {
            this.b = this.a.a();
        }
        while (this.c.size() <= n2) {
            this.c.add(null);
        }
        ArrayList<d.d> arrayList = this.c;
        object = ((d)object2).v() ? this.a.a((d)object2) : null;
        arrayList.set(n2, (d.d)object);
        this.d.set(n2, null);
        this.b.a((d)object2);
    }

    @Override
    public boolean a(View view, Object object) {
        return ((d)object).y() == view;
    }

    @Override
    public void b(ViewGroup viewGroup) {
        if (this.b != null) {
            this.b.f();
            this.b = null;
        }
    }

    @Override
    public void b(ViewGroup object, int n2, Object object2) {
        object = (d)object2;
        if (object != this.e) {
            if (this.e != null) {
                this.e.c(false);
                this.e.d(false);
            }
            ((d)object).c(true);
            ((d)object).d(true);
            this.e = object;
        }
    }
}

