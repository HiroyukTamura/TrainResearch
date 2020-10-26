/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.f.a;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.f.a.d;
import androidx.f.a.i;
import androidx.f.a.p;
import androidx.viewpager.widget.a;

public abstract class m
extends a {
    private final i a;
    private p b = null;
    private d c = null;

    public m(i i2) {
        this.a = i2;
    }

    private static String a(int n2, long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android:switcher:");
        stringBuilder.append(n2);
        stringBuilder.append(":");
        stringBuilder.append(l2);
        return stringBuilder.toString();
    }

    @Override
    public Parcelable a() {
        return null;
    }

    public abstract d a(int var1);

    @Override
    public Object a(ViewGroup object, int n2) {
        if (this.b == null) {
            this.b = this.a.a();
        }
        long l2 = this.b(n2);
        Object object2 = m.a(object.getId(), l2);
        if ((object2 = this.a.a((String)object2)) != null) {
            this.b.c((d)object2);
            object = object2;
        } else {
            object2 = this.a(n2);
            this.b.a(object.getId(), (d)object2, m.a(object.getId(), l2));
            object = object2;
        }
        if (object != this.c) {
            ((d)object).c(false);
            ((d)object).d(false);
        }
        return object;
    }

    @Override
    public void a(Parcelable parcelable, ClassLoader classLoader) {
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
    public void a(ViewGroup viewGroup, int n2, Object object) {
        if (this.b == null) {
            this.b = this.a.a();
        }
        this.b.b((d)object);
    }

    @Override
    public boolean a(View view, Object object) {
        return ((d)object).y() == view;
    }

    public long b(int n2) {
        return n2;
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
        if (object != this.c) {
            if (this.c != null) {
                this.c.c(false);
                this.c.d(false);
            }
            ((d)object).c(true);
            ((d)object).d(true);
            this.c = object;
        }
    }
}

