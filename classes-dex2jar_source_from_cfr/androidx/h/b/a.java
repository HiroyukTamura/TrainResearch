/*
 * Decompiled with CFR 0.139.
 */
package androidx.h.b;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class a<D> {
    int a;
    a<D> b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    boolean g;

    public String a(D d2) {
        StringBuilder stringBuilder = new StringBuilder(64);
        androidx.core.g.a.a(d2, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void a() {
        this.c = true;
        this.e = false;
        this.d = false;
        this.b();
    }

    public void a(a<D> a2) {
        if (this.b != null) {
            if (this.b == a2) {
                this.b = null;
                return;
            }
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        throw new IllegalStateException("No listener register");
    }

    @Deprecated
    public void a(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        printWriter.print(string2);
        printWriter.print("mId=");
        printWriter.print(this.a);
        printWriter.print(" mListener=");
        printWriter.println(this.b);
        if (this.c || this.f || this.g) {
            printWriter.print(string2);
            printWriter.print("mStarted=");
            printWriter.print(this.c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.g);
        }
        if (this.d || this.e) {
            printWriter.print(string2);
            printWriter.print("mAbandoned=");
            printWriter.print(this.d);
            printWriter.print(" mReset=");
            printWriter.println(this.e);
        }
    }

    protected void b() {
    }

    public boolean c() {
        return this.d();
    }

    protected boolean d() {
        return false;
    }

    public void e() {
        this.c = false;
        this.f();
    }

    protected void f() {
    }

    public void g() {
        this.d = true;
        this.h();
    }

    protected void h() {
    }

    public void i() {
        this.j();
        this.e = true;
        this.c = false;
        this.d = false;
        this.f = false;
        this.g = false;
    }

    protected void j() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        androidx.core.g.a.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static interface a<D> {
    }

}

