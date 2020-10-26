/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import java.util.HashSet;
import java.util.Iterator;

public class p {
    HashSet<p> h = new HashSet(2);
    int i = 0;

    public void a() {
    }

    public void a(p p2) {
        this.h.add(p2);
    }

    public void b() {
        this.i = 0;
        this.h.clear();
    }

    public void e() {
        this.i = 0;
        Iterator<p> iterator = this.h.iterator();
        while (iterator.hasNext()) {
            iterator.next().e();
        }
    }

    public void f() {
        this.i = 1;
        Iterator<p> iterator = this.h.iterator();
        while (iterator.hasNext()) {
            iterator.next().a();
        }
    }

    public boolean g() {
        return this.i == 1;
    }
}

