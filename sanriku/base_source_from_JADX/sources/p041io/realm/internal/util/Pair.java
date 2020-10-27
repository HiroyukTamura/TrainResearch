package p041io.realm.internal.util;

import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: io.realm.internal.util.Pair */
public class Pair<F, S> {
    public F first;
    public S second;

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public static <A, B> Pair<A, B> create(A a, B b) {
        return new Pair<>(a, b);
    }

    private boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return equals(pair.first, this.first) && equals(pair.second, this.second);
    }

    public int hashCode() {
        F f = this.first;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.second;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("Pair{");
        a.append(String.valueOf(this.first));
        a.append(" ");
        a.append(String.valueOf(this.second));
        a.append("}");
        return a.toString();
    }
}
