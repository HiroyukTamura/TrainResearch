/*
 * Decompiled with CFR 0.139.
 */
package androidx.coordinatorlayout.widget;

import androidx.c.g;
import androidx.core.g.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class a<T> {
    private final d.a<ArrayList<T>> a = new d.b<ArrayList<T>>(10);
    private final g<T, ArrayList<T>> b = new g();
    private final ArrayList<T> c = new ArrayList();
    private final HashSet<T> d = new HashSet();

    private void a(T t2, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t2)) {
            return;
        }
        if (!hashSet.contains(t2)) {
            hashSet.add(t2);
            ArrayList<T> arrayList2 = this.b.get(t2);
            if (arrayList2 != null) {
                int n2 = arrayList2.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    this.a(arrayList2.get(i2), arrayList, hashSet);
                }
            }
            hashSet.remove(t2);
            arrayList.add(t2);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    private void a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.a.a(arrayList);
    }

    private ArrayList<T> c() {
        ArrayList<T> arrayList;
        ArrayList<Object> arrayList2 = arrayList = this.a.a();
        if (arrayList == null) {
            arrayList2 = new ArrayList();
        }
        return arrayList2;
    }

    public void a() {
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ArrayList<T> arrayList = this.b.c(i2);
            if (arrayList == null) continue;
            this.a((T)arrayList);
        }
        this.b.clear();
    }

    public void a(T t2) {
        if (!this.b.containsKey(t2)) {
            this.b.put(t2, null);
        }
    }

    public void a(T t2, T t3) {
        if (this.b.containsKey(t2) && this.b.containsKey(t3)) {
            ArrayList<T> arrayList;
            ArrayList<T> arrayList2 = arrayList = this.b.get(t2);
            if (arrayList == null) {
                arrayList2 = this.c();
                this.b.put(t2, arrayList2);
            }
            arrayList2.add(t3);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public ArrayList<T> b() {
        this.c.clear();
        this.d.clear();
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a(this.b.b(i2), this.c, this.d);
        }
        return this.c;
    }

    public boolean b(T t2) {
        return this.b.containsKey(t2);
    }

    public List c(T t2) {
        return this.b.get(t2);
    }

    public List<T> d(T t2) {
        int n2 = this.b.size();
        ArrayList<T> arrayList = null;
        for (int i2 = 0; i2 < n2; ++i2) {
            ArrayList<T> arrayList2 = this.b.c(i2);
            ArrayList<T> arrayList3 = arrayList;
            if (arrayList2 != null) {
                arrayList3 = arrayList;
                if (arrayList2.contains(t2)) {
                    arrayList3 = arrayList;
                    if (arrayList == null) {
                        arrayList3 = new ArrayList<T>();
                    }
                    arrayList3.add(this.b.b(i2));
                }
            }
            arrayList = arrayList3;
        }
        return arrayList;
    }

    public boolean e(T t2) {
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ArrayList<T> arrayList = this.b.c(i2);
            if (arrayList == null || !arrayList.contains(t2)) continue;
            return true;
        }
        return false;
    }
}

