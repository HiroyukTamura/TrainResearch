/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.a;

import b.a.b.b;
import b.a.e.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
implements b,
a {
    List<b> a;
    volatile boolean b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a() {
        List<b> list;
        if (this.b) {
            return;
        }
        synchronized (this) {
            if (this.b) {
                return;
            }
            this.b = true;
            list = this.a;
            this.a = null;
        }
        this.a(list);
    }

    void a(List<b> list) {
        if (list == null) {
            return;
        }
        ArrayList<b> arrayList = null;
        Iterator<b> iterator = list.iterator();
        list = arrayList;
        while (iterator.hasNext()) {
            arrayList = iterator.next();
            try {
                arrayList.a();
            }
            catch (Throwable throwable) {
                b.a.c.b.b(throwable);
                arrayList = list;
                if (list == null) {
                    arrayList = new ArrayList<b>();
                }
                arrayList.add((b)((Object)throwable));
                list = arrayList;
            }
        }
        if (list != null) {
            if (list.size() == 1) {
                throw b.a.e.h.a.a((Throwable)((Object)list.get(0)));
            }
            throw new b.a.c.a(list);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean a(b b2) {
        b.a.e.b.b.a(b2, "d is null");
        if (!this.b) {
            synchronized (this) {
                if (!this.b) {
                    List<b> list;
                    List<b> list2 = list = this.a;
                    if (list == null) {
                        this.a = list2 = new LinkedList<b>();
                    }
                    list2.add(b2);
                    return true;
                }
            }
        }
        b2.a();
        return false;
    }

    @Override
    public boolean b(b b2) {
        if (this.c(b2)) {
            b2.a();
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public boolean c(b b2) {
        b.a.e.b.b.a(b2, "Disposable item is null");
        if (this.b) {
            return false;
        }
        synchronized (this) {
            if (this.b) {
                return false;
            }
            List<b> list = this.a;
            return list != null && list.remove(b2);
            {
            }
        }
    }
}

