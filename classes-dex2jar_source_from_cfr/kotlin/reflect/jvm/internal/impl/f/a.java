/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.reflect.jvm.internal.impl.f.e;
import kotlin.reflect.jvm.internal.impl.f.f;
import kotlin.reflect.jvm.internal.impl.f.g;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.f.w;

public abstract class a
implements q {
    protected int b = 0;

    w N() {
        return new w(this);
    }

    public void a(OutputStream object) {
        int n2 = this.i();
        object = f.a((OutputStream)object, f.a(f.q(n2) + n2));
        ((f)object).p(n2);
        this.a((f)object);
        ((f)object).a();
    }

    public static abstract class kotlin.reflect.jvm.internal.impl.f.a$a<BuilderType extends kotlin.reflect.jvm.internal.impl.f.a$a>
    implements q.a {
        protected static w a(q q2) {
            return new w(q2);
        }

        public abstract BuilderType b(e var1, g var2);

        @Override
        public /* synthetic */ q.a c(e e2, g g2) {
            return this.b(e2, g2);
        }

        public /* synthetic */ Object clone() {
            return this.k();
        }

        public abstract BuilderType k();

        static final class a
        extends FilterInputStream {
            private int a;

            a(InputStream inputStream, int n2) {
                super(inputStream);
                this.a = n2;
            }

            @Override
            public int available() {
                return Math.min(super.available(), this.a);
            }

            @Override
            public int read() {
                if (this.a <= 0) {
                    return -1;
                }
                int n2 = super.read();
                if (n2 >= 0) {
                    --this.a;
                }
                return n2;
            }

            @Override
            public int read(byte[] arrby, int n2, int n3) {
                if (this.a <= 0) {
                    return -1;
                }
                if ((n2 = super.read(arrby, n2, Math.min(n3, this.a))) >= 0) {
                    this.a -= n2;
                }
                return n2;
            }

            @Override
            public long skip(long l2) {
                if ((l2 = super.skip(Math.min(l2, (long)this.a))) >= 0L) {
                    this.a = (int)((long)this.a - l2);
                }
                return l2;
            }
        }

    }

}

