/*
 * Decompiled with CFR 0.139.
 */
package androidx.constraintlayout.b.a;

import androidx.constraintlayout.b.a.f;
import java.util.HashSet;
import java.util.List;

public class h {
    public List<f> a;
    int b = -1;
    int c = -1;
    public final int[] d = new int[]{this.b, this.c};
    HashSet<f> e = new HashSet();
    HashSet<f> f = new HashSet();
    HashSet<f> g = new HashSet();
    HashSet<f> h = new HashSet();

    h(List<f> list) {
        this.a = list;
    }

    public HashSet<f> a(int n2) {
        if (n2 == 0) {
            return this.e;
        }
        if (n2 == 1) {
            return this.f;
        }
        return null;
    }

    public HashSet<f> b(int n2) {
        if (n2 == 0) {
            return this.g;
        }
        if (n2 == 1) {
            return this.h;
        }
        return null;
    }
}

