/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.n;

import e.a.a;
import java.lang.ref.WeakReference;
import jp.co.jreast.jreastapp.commuter.n.e;
import jp.co.jreast.jreastapp.commuter.n.g;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailFragmentCaptureScreenPermissionRequest;", "Lpermissions/dispatcher/PermissionRequest;", "target", "Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailFragment;", "(Ljp/co/jreast/jreastapp/commuter/routedetail/RouteDetailFragment;)V", "weakTarget", "Ljava/lang/ref/WeakReference;", "cancel", "", "proceed", "app_productRelease"}, k=1, mv={1, 1, 11})
final class f
implements a {
    private final WeakReference<e> a;

    public f(e e2) {
        j.b(e2, "target");
        this.a = new WeakReference<e>(e2);
    }

    @Override
    public void a() {
        e e2 = (e)this.a.get();
        if (e2 != null) {
            e2.a(g.a(), g.b());
        }
    }
}

