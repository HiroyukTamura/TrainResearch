/*
 * Decompiled with CFR 0.139.
 */
package androidx.a.a.a;

import androidx.a.a.a.b;
import androidx.a.a.a.c;
import java.util.concurrent.Executor;

public class a
extends c {
    private static volatile a a;
    private static final Executor d;
    private static final Executor e;
    private c b;
    private c c;

    static {
        d = new Executor(){

            @Override
            public void execute(Runnable runnable) {
                a.a().b(runnable);
            }
        };
        e = new Executor(){

            @Override
            public void execute(Runnable runnable) {
                a.a().a(runnable);
            }
        };
    }

    private a() {
        this.b = this.c = new b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        if (a != null) {
            return a;
        }
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            return a;
        }
    }

    @Override
    public void a(Runnable runnable) {
        this.b.a(runnable);
    }

    @Override
    public void b(Runnable runnable) {
        this.b.b(runnable);
    }

    @Override
    public boolean b() {
        return this.b.b();
    }

}

