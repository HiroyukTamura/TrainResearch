/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 */
package androidx.h.a;

import android.os.Bundle;
import android.util.Log;
import androidx.c.h;
import androidx.h.a.a;
import androidx.h.b.a;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class b
extends androidx.h.a.a {
    static boolean a = false;
    private final j b;
    private final c c;

    b(j j2, y y2) {
        this.b = j2;
        this.c = c.a(y2);
    }

    @Override
    public void a() {
        this.c.b();
    }

    @Deprecated
    @Override
    public void a(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
        this.c.a(string2, fileDescriptor, printWriter, arrstring);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        androidx.core.g.a.a(this.b, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public static class a<D>
    extends p<D>
    implements a.a<D> {
        private final int e;
        private final Bundle f;
        private final androidx.h.b.a<D> g;
        private j h;
        private b<D> i;
        private androidx.h.b.a<D> j;

        androidx.h.b.a<D> a(boolean bl2) {
            Object object;
            if (b.a) {
                object = new StringBuilder();
                ((StringBuilder)object).append("  Destroying: ");
                ((StringBuilder)object).append(this);
                Log.v((String)"LoaderManager", (String)((StringBuilder)object).toString());
            }
            this.g.c();
            this.g.g();
            object = this.i;
            if (object != null) {
                this.b(object);
                if (bl2) {
                    ((b)object).b();
                }
            }
            this.g.a(this);
            if (object != null && !((b)object).a() || bl2) {
                this.g.i();
                return this.j;
            }
            return this.g;
        }

        public void a(String string2, FileDescriptor object, PrintWriter printWriter, String[] object2) {
            printWriter.print(string2);
            printWriter.print("mId=");
            printWriter.print(this.e);
            printWriter.print(" mArgs=");
            printWriter.println((Object)this.f);
            printWriter.print(string2);
            printWriter.print("mLoader=");
            printWriter.println(this.g);
            androidx.h.b.a<D> a2 = this.g;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("  ");
            a2.a(stringBuilder.toString(), (FileDescriptor)object, printWriter, (String[])object2);
            if (this.i != null) {
                printWriter.print(string2);
                printWriter.print("mCallbacks=");
                printWriter.println(this.i);
                object = this.i;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append("  ");
                ((b)object).a(((StringBuilder)object2).toString(), printWriter);
            }
            printWriter.print(string2);
            printWriter.print("mData=");
            printWriter.println(this.f().a(this.a()));
            printWriter.print(string2);
            printWriter.print("mStarted=");
            printWriter.println(this.e());
        }

        @Override
        public void b(q<? super D> q2) {
            super.b(q2);
            this.h = null;
            this.i = null;
        }

        @Override
        public void b(D d2) {
            super.b(d2);
            if (this.j != null) {
                this.j.i();
                this.j = null;
            }
        }

        @Override
        protected void c() {
            if (b.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Starting: ");
                stringBuilder.append(this);
                Log.v((String)"LoaderManager", (String)stringBuilder.toString());
            }
            this.g.a();
        }

        @Override
        protected void d() {
            if (b.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  Stopping: ");
                stringBuilder.append(this);
                Log.v((String)"LoaderManager", (String)stringBuilder.toString());
            }
            this.g.e();
        }

        androidx.h.b.a<D> f() {
            return this.g;
        }

        void g() {
            j j2 = this.h;
            b<D> b2 = this.i;
            if (j2 != null && b2 != null) {
                super.b(b2);
                this.a(j2, b2);
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.e);
            stringBuilder.append(" : ");
            androidx.core.g.a.a(this.g, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }
    }

    static class b<D>
    implements q<D> {
        private final androidx.h.b.a<D> a;
        private final a.a<D> b;
        private boolean c;

        @Override
        public void a(D d2) {
            if (b.a) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("  onLoadFinished in ");
                stringBuilder.append(this.a);
                stringBuilder.append(": ");
                stringBuilder.append(this.a.a(d2));
                Log.v((String)"LoaderManager", (String)stringBuilder.toString());
            }
            this.b.a(this.a, d2);
            this.c = true;
        }

        public void a(String string2, PrintWriter printWriter) {
            printWriter.print(string2);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }

        boolean a() {
            return this.c;
        }

        void b() {
            if (this.c) {
                if (b.a) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("  Resetting: ");
                    stringBuilder.append(this.a);
                    Log.v((String)"LoaderManager", (String)stringBuilder.toString());
                }
                this.b.a(this.a);
            }
        }

        public String toString() {
            return this.b.toString();
        }
    }

    static class c
    extends v {
        private static final w.b a = new w.b(){

            @Override
            public <T extends v> T a(Class<T> class_) {
                return (T)new c();
            }
        };
        private h<a> b = new h();
        private boolean c = false;

        c() {
        }

        static c a(y y2) {
            return new w(y2, a).a(c.class);
        }

        @Override
        protected void a() {
            super.a();
            int n2 = this.b.b();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.b.e(i2).a(true);
            }
            this.b.c();
        }

        public void a(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] arrstring) {
            if (this.b.b() > 0) {
                printWriter.print(string2);
                printWriter.println("Loaders:");
                CharSequence charSequence = new StringBuilder();
                charSequence.append(string2);
                charSequence.append("    ");
                charSequence = charSequence.toString();
                for (int i2 = 0; i2 < this.b.b(); ++i2) {
                    a a2 = this.b.e(i2);
                    printWriter.print(string2);
                    printWriter.print("  #");
                    printWriter.print(this.b.d(i2));
                    printWriter.print(": ");
                    printWriter.println(a2.toString());
                    a2.a((String)charSequence, fileDescriptor, printWriter, arrstring);
                }
            }
        }

        void b() {
            int n2 = this.b.b();
            for (int i2 = 0; i2 < n2; ++i2) {
                this.b.e(i2).g();
            }
        }

    }

}

