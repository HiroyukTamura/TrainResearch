/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObservable
 *  android.database.DataSetObserver
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class a {
    private final DataSetObservable a = new DataSetObservable();
    private DataSetObserver b;

    public int a(Object object) {
        return -1;
    }

    public Parcelable a() {
        return null;
    }

    @Deprecated
    public Object a(View view, int n2) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object a(ViewGroup viewGroup, int n2) {
        return this.a((View)viewGroup, n2);
    }

    public void a(DataSetObserver dataSetObserver) {
        this.a.registerObserver((Object)dataSetObserver);
    }

    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    public void a(View view) {
    }

    @Deprecated
    public void a(View view, int n2, Object object) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void a(ViewGroup viewGroup) {
        this.a((View)viewGroup);
    }

    public void a(ViewGroup viewGroup, int n2, Object object) {
        this.a((View)viewGroup, n2, object);
    }

    public abstract boolean a(View var1, Object var2);

    public abstract int b();

    public void b(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver((Object)dataSetObserver);
    }

    @Deprecated
    public void b(View view) {
    }

    @Deprecated
    public void b(View view, int n2, Object object) {
    }

    public void b(ViewGroup viewGroup) {
        this.b((View)viewGroup);
    }

    public void b(ViewGroup viewGroup, int n2, Object object) {
        this.b((View)viewGroup, n2, object);
    }

    public CharSequence c(int n2) {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        synchronized (this) {
            if (this.b != null) {
                this.b.onChanged();
            }
        }
        this.a.notifyChanged();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.b = dataSetObserver;
            return;
        }
    }

    public float d(int n2) {
        return 1.0f;
    }
}

