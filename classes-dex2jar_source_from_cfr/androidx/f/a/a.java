/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 */
package androidx.f.a;

import android.util.Log;
import android.view.View;
import androidx.core.g.b;
import androidx.f.a.d;
import androidx.f.a.i;
import androidx.f.a.j;
import androidx.f.a.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

final class a
extends p
implements i.a,
j.h {
    final j a;
    ArrayList<a> b = new ArrayList();
    int c;
    int d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    boolean j = true;
    String k;
    boolean l;
    int m = -1;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    boolean t = false;
    ArrayList<Runnable> u;

    public a(j j2) {
        this.a = j2;
    }

    private void a(int n2, d object, String charSequence, int n3) {
        Serializable serializable = object.getClass();
        int n4 = ((Class)serializable).getModifiers();
        if (!((Class)serializable).isAnonymousClass() && Modifier.isPublic(n4) && (!((Class)serializable).isMemberClass() || Modifier.isStatic(n4))) {
            ((d)object).B = this.a;
            if (charSequence != null) {
                if (((d)object).J != null && !((String)charSequence).equals(((d)object).J)) {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("Can't change tag of fragment ");
                    ((StringBuilder)serializable).append(object);
                    ((StringBuilder)serializable).append(": was ");
                    ((StringBuilder)serializable).append(((d)object).J);
                    ((StringBuilder)serializable).append(" now ");
                    ((StringBuilder)serializable).append((String)charSequence);
                    throw new IllegalStateException(((StringBuilder)serializable).toString());
                }
                ((d)object).J = charSequence;
            }
            if (n2 != 0) {
                if (n2 != -1) {
                    if (((d)object).H != 0 && ((d)object).H != n2) {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("Can't change container ID of fragment ");
                        ((StringBuilder)charSequence).append(object);
                        ((StringBuilder)charSequence).append(": was ");
                        ((StringBuilder)charSequence).append(((d)object).H);
                        ((StringBuilder)charSequence).append(" now ");
                        ((StringBuilder)charSequence).append(n2);
                        throw new IllegalStateException(((StringBuilder)charSequence).toString());
                    }
                    ((d)object).H = n2;
                    ((d)object).I = n2;
                } else {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("Can't add fragment ");
                    ((StringBuilder)serializable).append(object);
                    ((StringBuilder)serializable).append(" with tag ");
                    ((StringBuilder)serializable).append((String)charSequence);
                    ((StringBuilder)serializable).append(" to container view with no id");
                    throw new IllegalArgumentException(((StringBuilder)serializable).toString());
                }
            }
            this.a(new a(n3, (d)object));
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        ((StringBuilder)object).append(((Class)serializable).getCanonicalName());
        ((StringBuilder)object).append(" must be a public static class to be  properly recreated from");
        ((StringBuilder)object).append(" instance state.");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    private static boolean b(a object) {
        object = ((a)object).b;
        return object != null && ((d)object).u && ((d)object).S != null && !((d)object).L && !((d)object).K && ((d)object).ag();
    }

    @Override
    public int a() {
        return this.m;
    }

    /*
     * Enabled aggressive block sorting
     */
    int a(boolean bl2) {
        if (this.l) {
            throw new IllegalStateException("commit already called");
        }
        if (j.a) {
            Appendable appendable = new StringBuilder();
            ((StringBuilder)appendable).append("Commit: ");
            ((StringBuilder)appendable).append(this);
            Log.v((String)"FragmentManager", (String)((StringBuilder)appendable).toString());
            appendable = new PrintWriter(new b("FragmentManager"));
            this.a("  ", null, (PrintWriter)appendable, null);
            ((PrintWriter)appendable).close();
        }
        this.l = true;
        int n2 = this.i ? this.a.a(this) : -1;
        this.m = n2;
        this.a.a(this, bl2);
        return this.m;
    }

    d a(ArrayList<d> arrayList, d object) {
        int n2 = 0;
        d d2 = object;
        while (n2 < this.b.size()) {
            int n3;
            a a2 = this.b.get(n2);
            switch (a2.a) {
                default: {
                    object = d2;
                    n3 = n2;
                    break;
                }
                case 8: {
                    this.b.add(n2, new a(9, d2));
                    n3 = n2 + 1;
                    object = a2.b;
                    break;
                }
                case 3: 
                case 6: {
                    arrayList.remove(a2.b);
                    object = d2;
                    n3 = n2;
                    if (a2.b != d2) break;
                    this.b.add(n2, new a(9, a2.b));
                    n3 = n2 + 1;
                    object = null;
                    break;
                }
                case 2: {
                    d d3 = a2.b;
                    int n4 = d3.I;
                    object = d2;
                    boolean bl2 = false;
                    for (n3 = arrayList.size() - 1; n3 >= 0; --n3) {
                        d d4 = arrayList.get(n3);
                        int n5 = n2;
                        d2 = object;
                        boolean bl3 = bl2;
                        if (d4.I == n4) {
                            if (d4 == d3) {
                                bl3 = true;
                                n5 = n2;
                                d2 = object;
                            } else {
                                n5 = n2;
                                d2 = object;
                                if (d4 == object) {
                                    this.b.add(n2, new a(9, d4));
                                    n5 = n2 + 1;
                                    d2 = null;
                                }
                                object = new a(3, d4);
                                ((a)object).c = a2.c;
                                ((a)object).e = a2.e;
                                ((a)object).d = a2.d;
                                ((a)object).f = a2.f;
                                this.b.add(n5, (a)object);
                                arrayList.remove(d4);
                                bl3 = bl2;
                            }
                        }
                        n2 = ++n5;
                        object = d2;
                        bl2 = bl3;
                    }
                    if (bl2) {
                        this.b.remove(n2);
                        --n2;
                    } else {
                        a2.a = 1;
                        arrayList.add(d3);
                    }
                    n3 = n2;
                    break;
                }
                case 1: 
                case 7: {
                    arrayList.add(a2.b);
                    n3 = n2;
                    object = d2;
                }
            }
            n2 = n3 + 1;
            d2 = object;
        }
        return d2;
    }

    @Override
    public p a(int n2, d d2) {
        this.a(n2, d2, null, 1);
        return this;
    }

    @Override
    public p a(int n2, d d2, String string2) {
        this.a(n2, d2, string2, 1);
        return this;
    }

    @Override
    public p a(d d2) {
        this.a(new a(3, d2));
        return this;
    }

    @Override
    public p a(d d2, String string2) {
        this.a(0, d2, string2, 1);
        return this;
    }

    @Override
    public p a(String string2) {
        if (this.j) {
            this.i = true;
            this.k = string2;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    void a(int n2) {
        Object object;
        if (!this.i) {
            return;
        }
        if (j.a) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Bump nesting in ");
            ((StringBuilder)object).append(this);
            ((StringBuilder)object).append(" by ");
            ((StringBuilder)object).append(n2);
            Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
        }
        int n3 = this.b.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            object = this.b.get(i2);
            if (((a)object).b == null) continue;
            Object object2 = ((a)object).b;
            ((d)object2).A += n2;
            if (!j.a) continue;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Bump nesting of ");
            ((StringBuilder)object2).append(((a)object).b);
            ((StringBuilder)object2).append(" to ");
            ((StringBuilder)object2).append(object.b.A);
            Log.v((String)"FragmentManager", (String)((StringBuilder)object2).toString());
        }
    }

    void a(a a2) {
        this.b.add(a2);
        a2.c = this.c;
        a2.d = this.d;
        a2.e = this.e;
        a2.f = this.f;
    }

    void a(d.c c2) {
        for (int i2 = 0; i2 < this.b.size(); ++i2) {
            a a2 = this.b.get(i2);
            if (!a.b(a2)) continue;
            a2.b.a(c2);
        }
    }

    public void a(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        this.a(string2, printWriter, true);
    }

    public void a(String string2, PrintWriter printWriter, boolean bl2) {
        if (bl2) {
            printWriter.print(string2);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.g != 0) {
                printWriter.print(string2);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.h));
            }
            if (this.c != 0 || this.d != 0) {
                printWriter.print(string2);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.d));
            }
            if (this.e != 0 || this.f != 0) {
                printWriter.print(string2);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(string2);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (this.p != 0 || this.q != null) {
                printWriter.print(string2);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (!this.b.isEmpty()) {
            printWriter.print(string2);
            printWriter.println("Operations:");
            CharSequence charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append("    ");
            ((StringBuilder)charSequence).toString();
            int n2 = this.b.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                a a2 = this.b.get(i2);
                switch (a2.a) {
                    default: {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("cmd=");
                        ((StringBuilder)charSequence).append(a2.a);
                        charSequence = ((StringBuilder)charSequence).toString();
                        break;
                    }
                    case 9: {
                        charSequence = "UNSET_PRIMARY_NAV";
                        break;
                    }
                    case 8: {
                        charSequence = "SET_PRIMARY_NAV";
                        break;
                    }
                    case 7: {
                        charSequence = "ATTACH";
                        break;
                    }
                    case 6: {
                        charSequence = "DETACH";
                        break;
                    }
                    case 5: {
                        charSequence = "SHOW";
                        break;
                    }
                    case 4: {
                        charSequence = "HIDE";
                        break;
                    }
                    case 3: {
                        charSequence = "REMOVE";
                        break;
                    }
                    case 2: {
                        charSequence = "REPLACE";
                        break;
                    }
                    case 1: {
                        charSequence = "ADD";
                        break;
                    }
                    case 0: {
                        charSequence = "NULL";
                    }
                }
                printWriter.print(string2);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print((String)charSequence);
                printWriter.print(" ");
                printWriter.println(a2.b);
                if (!bl2) continue;
                if (a2.c != 0 || a2.d != 0) {
                    printWriter.print(string2);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(a2.c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(a2.d));
                }
                if (a2.e == 0 && a2.f == 0) continue;
                printWriter.print(string2);
                printWriter.print("popEnterAnim=#");
                printWriter.print(Integer.toHexString(a2.e));
                printWriter.print(" popExitAnim=#");
                printWriter.println(Integer.toHexString(a2.f));
            }
        }
    }

    boolean a(ArrayList<a> arrayList, int n2, int n3) {
        if (n3 == n2) {
            return false;
        }
        int n4 = this.b.size();
        int n5 = -1;
        for (int i2 = 0; i2 < n4; ++i2) {
            Object object = this.b.get(i2);
            int n6 = ((a)object).b != null ? object.b.I : 0;
            int n7 = n5;
            if (n6 != 0) {
                n7 = n5;
                if (n6 != n5) {
                    for (n5 = n2; n5 < n3; ++n5) {
                        object = arrayList.get(n5);
                        int n8 = ((a)object).b.size();
                        for (n7 = 0; n7 < n8; ++n7) {
                            a a2 = ((a)object).b.get(n7);
                            int n9 = a2.b != null ? a2.b.I : 0;
                            if (n9 != n6) continue;
                            return true;
                        }
                    }
                    n7 = n6;
                }
            }
            n5 = n7;
        }
        return false;
    }

    @Override
    public boolean a(ArrayList<a> arrayList, ArrayList<Boolean> arrayList2) {
        if (j.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Run: ");
            stringBuilder.append(this);
            Log.v((String)"FragmentManager", (String)stringBuilder.toString());
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (this.i) {
            this.a.b(this);
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    d b(ArrayList<d> var1_1, d var2_2) {
        var3_3 = 0;
        while (var3_3 < this.b.size()) {
            block7 : {
                var5_5 = this.b.get(var3_3);
                var4_4 = var5_5.a;
                if (var4_4 == 1) break block7;
                if (var4_4 == 3) ** GOTO lbl-1000
                switch (var4_4) {
                    default: {
                        ** break;
                    }
                    case 9: {
                        var2_2 = var5_5.b;
                        ** break;
                    }
                    case 8: {
                        var2_2 = null;
                        ** break;
                    }
                    case 6: lbl-1000: // 2 sources:
                    {
                        var1_1.add(var5_5.b);
                        ** break;
                    }
                    case 7: 
                }
            }
            var1_1.remove(var5_5.b);
lbl22: // 5 sources:
            ++var3_3;
        }
        return var2_2;
    }

    public p b() {
        if (!this.i) {
            this.j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @Override
    public p b(int n2, d d2) {
        return this.b(n2, d2, null);
    }

    @Override
    public p b(int n2, d d2, String string2) {
        if (n2 != 0) {
            this.a(n2, d2, string2, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @Override
    public p b(d d2) {
        this.a(new a(6, d2));
        return this;
    }

    void b(boolean bl2) {
        for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
            int n2;
            a a2 = this.b.get(i2);
            Object object = a2.b;
            if (object != null) {
                ((d)object).a(j.e(this.g), this.h);
            }
            if ((n2 = a2.a) != 1) {
                switch (n2) {
                    default: {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Unknown cmd: ");
                        ((StringBuilder)object).append(a2.a);
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    case 9: {
                        this.a.p((d)object);
                        break;
                    }
                    case 8: {
                        this.a.p(null);
                        break;
                    }
                    case 7: {
                        ((d)object).a(a2.f);
                        this.a.l((d)object);
                        break;
                    }
                    case 6: {
                        ((d)object).a(a2.e);
                        this.a.m((d)object);
                        break;
                    }
                    case 5: {
                        ((d)object).a(a2.f);
                        this.a.j((d)object);
                        break;
                    }
                    case 4: {
                        ((d)object).a(a2.e);
                        this.a.k((d)object);
                        break;
                    }
                    case 3: {
                        ((d)object).a(a2.e);
                        this.a.a((d)object, false);
                        break;
                    }
                }
            } else {
                ((d)object).a(a2.f);
                this.a.i((d)object);
            }
            if (this.t || a2.a == 3 || object == null) continue;
            this.a.f((d)object);
        }
        if (!this.t && bl2) {
            this.a.a(this.a.l, true);
        }
    }

    boolean b(int n2) {
        int n3 = this.b.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            a a2 = this.b.get(i2);
            int n4 = a2.b != null ? a2.b.I : 0;
            if (n4 == 0 || n4 != n2) continue;
            return true;
        }
        return false;
    }

    @Override
    public p c(d d2) {
        this.a(new a(7, d2));
        return this;
    }

    public void c() {
        if (this.u != null) {
            int n2 = this.u.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.u.get(i2).run();
            }
            this.u = null;
        }
    }

    @Override
    public int d() {
        return this.a(false);
    }

    @Override
    public int e() {
        return this.a(true);
    }

    @Override
    public void f() {
        this.b();
        this.a.b(this, true);
    }

    void g() {
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3;
            a a2 = this.b.get(i2);
            Object object = a2.b;
            if (object != null) {
                ((d)object).a(this.g, this.h);
            }
            if ((n3 = a2.a) != 1) {
                switch (n3) {
                    default: {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Unknown cmd: ");
                        ((StringBuilder)object).append(a2.a);
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }
                    case 9: {
                        this.a.p(null);
                        break;
                    }
                    case 8: {
                        this.a.p((d)object);
                        break;
                    }
                    case 7: {
                        ((d)object).a(a2.c);
                        this.a.m((d)object);
                        break;
                    }
                    case 6: {
                        ((d)object).a(a2.d);
                        this.a.l((d)object);
                        break;
                    }
                    case 5: {
                        ((d)object).a(a2.c);
                        this.a.k((d)object);
                        break;
                    }
                    case 4: {
                        ((d)object).a(a2.d);
                        this.a.j((d)object);
                        break;
                    }
                    case 3: {
                        ((d)object).a(a2.d);
                        this.a.i((d)object);
                        break;
                    }
                }
            } else {
                ((d)object).a(a2.c);
                this.a.a((d)object, false);
            }
            if (this.t || a2.a == 1 || object == null) continue;
            this.a.f((d)object);
        }
        if (!this.t) {
            this.a.a(this.a.l, true);
        }
    }

    boolean h() {
        for (int i2 = 0; i2 < this.b.size(); ++i2) {
            if (!a.b(this.b.get(i2))) continue;
            return true;
        }
        return false;
    }

    public String i() {
        return this.k;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.m);
        }
        if (this.k != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.k);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    static final class a {
        int a;
        d b;
        int c;
        int d;
        int e;
        int f;

        a() {
        }

        a(int n2, d d2) {
            this.a = n2;
            this.b = d2;
        }
    }

}

