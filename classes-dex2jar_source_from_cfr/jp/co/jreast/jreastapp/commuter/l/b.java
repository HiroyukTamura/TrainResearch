/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.l;

import b.a.g.a;
import b.a.h;
import jp.co.jreast.jreastapp.commuter.l.d;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/provider/CommuterSchedulerProvider;", "Ljp/co/jreast/jreastapp/commuter/provider/SchedulerProvider;", "()V", "computation", "Lio/reactivex/Scheduler;", "io", "newThread", "trampoline", "ui", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
implements d {
    @Override
    public h a() {
        h h2 = b.a.a.b.a.a();
        j.a((Object)h2, "AndroidSchedulers.mainThread()");
        return h2;
    }

    @Override
    public h b() {
        h h2 = a.a();
        j.a((Object)h2, "Schedulers.newThread()");
        return h2;
    }
}

