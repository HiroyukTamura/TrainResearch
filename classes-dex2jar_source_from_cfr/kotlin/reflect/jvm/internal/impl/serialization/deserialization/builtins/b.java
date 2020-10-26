/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.Closeable;
import java.io.InputStream;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.d.a;
import kotlin.reflect.jvm.internal.impl.d.a.a;
import kotlin.reflect.jvm.internal.impl.f.g;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.a.f;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.o;

public final class b
extends o
implements BuiltInsPackageFragment {
    public static final a a = new a(null);

    private b(kotlin.reflect.jvm.internal.impl.e.b b2, i i2, y y2, a.t t2, kotlin.reflect.jvm.internal.impl.d.a.a a2) {
        super(b2, i2, y2, t2, a2, null);
    }

    public /* synthetic */ b(kotlin.reflect.jvm.internal.impl.e.b b2, i i2, y y2, a.t t2, kotlin.reflect.jvm.internal.impl.d.a.a a2, kotlin.e.b.g g2) {
        this(b2, i2, y2, t2, a2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public final b a(kotlin.reflect.jvm.internal.impl.e.b object, i i2, y y2, InputStream object2) {
            Closeable closeable;
            Throwable throwable3222;
            block7 : {
                kotlin.reflect.jvm.internal.impl.d.a.a a2;
                Throwable throwable2;
                block6 : {
                    j.b(object, "fqName");
                    j.b(i2, "storageManager");
                    j.b(y2, "module");
                    j.b(object2, "inputStream");
                    closeable = (Closeable)object2;
                    throwable2 = null;
                    object2 = throwable2;
                    Object object3 = (InputStream)closeable;
                    object2 = throwable2;
                    a2 = kotlin.reflect.jvm.internal.impl.d.a.a.c.a((InputStream)object3);
                    if (a2 == null) {
                        object2 = throwable2;
                        j.b("version");
                    }
                    object2 = throwable2;
                    if (!a2.a()) break block6;
                    object2 = throwable2;
                    object3 = a.t.a((InputStream)object3, kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.a.a());
                    kotlin.d.b.a(closeable, throwable2);
                    j.a(object3, "proto");
                    return new b((kotlin.reflect.jvm.internal.impl.e.b)object, i2, y2, (a.t)object3, a2, null);
                }
                object2 = throwable2;
                try {
                    object = new StringBuilder();
                    object2 = throwable2;
                    ((StringBuilder)object).append("Kotlin built-in definition format version is not supported: ");
                    object2 = throwable2;
                    ((StringBuilder)object).append("expected ");
                    object2 = throwable2;
                    ((StringBuilder)object).append(kotlin.reflect.jvm.internal.impl.d.a.a.a);
                    object2 = throwable2;
                    ((StringBuilder)object).append(", actual ");
                    object2 = throwable2;
                    ((StringBuilder)object).append(a2);
                    object2 = throwable2;
                    ((StringBuilder)object).append(". ");
                    object2 = throwable2;
                    ((StringBuilder)object).append("Please update Kotlin");
                    object2 = throwable2;
                    throw (Throwable)new UnsupportedOperationException(((StringBuilder)object).toString());
                }
                catch (Throwable throwable3222) {
                    break block7;
                }
                catch (Throwable throwable4) {
                    object2 = throwable4;
                    throw throwable4;
                }
            }
            kotlin.d.b.a(closeable, (Throwable)object2);
            throw throwable3222;
        }
    }

}

