/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.e.a.a;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;

public final class BuiltInsInitializer<T extends KotlinBuiltIns> {
    private volatile T a;
    private volatile boolean b;
    private Throwable c;
    private final a<T> d;

    public BuiltInsInitializer(a<? extends T> a2) {
        j.b(a2, "constructor");
        this.d = a2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final void a() {
        Throwable throwable3222;
        // MONITORENTER : this
        if (this.a != null) {
            // MONITOREXIT : this
            return;
        }
        if (this.c != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Built-in library initialization failed previously: ");
            Throwable throwable2 = this.c;
            if (throwable2 == null) {
                j.a();
            }
            stringBuilder.append(throwable2);
            throw (Throwable)new IllegalStateException(stringBuilder.toString(), this.c);
        }
        if (this.b) throw (Throwable)new IllegalStateException("Built-in library initialization loop");
        this.b = true;
        this.a = (KotlinBuiltIns)this.d.a();
        this.b = false;
        return;
        {
            catch (Throwable throwable3222) {
            }
            catch (Throwable throwable4) {}
            {
                this.c = throwable4;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Built-in library initialization failed. Please ensure you have kotlin-runtime.jar in the classpath: ");
                stringBuilder.append(throwable4);
                throw (Throwable)new IllegalStateException(stringBuilder.toString(), throwable4);
            }
        }
        this.b = false;
        throw throwable3222;
    }

    public final T get() {
        T t2;
        if (this.b) {
            synchronized (this) {
                block7 : {
                    T t3 = this.a;
                    if (t3 == null) break block7;
                    return t3;
                }
                throw (Throwable)((Object)new AssertionError((Object)"Built-ins are not initialized (note: We are under the same lock as initializing and instance)"));
            }
        }
        if (this.a == null) {
            this.a();
        }
        if ((t2 = this.a) == null) {
            j.a();
        }
        return t2;
    }
}

