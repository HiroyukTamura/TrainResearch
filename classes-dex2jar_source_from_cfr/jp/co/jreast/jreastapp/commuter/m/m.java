/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m;

import b.a.e;
import com.b.a.b.a.b;
import com.b.a.f;
import com.b.a.s;
import f.a.a.h;
import f.c;
import f.e;
import f.n;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import jp.co.jreast.jreastapp.commuter.api.NorikaeApi;
import jp.co.jreast.jreastapp.commuter.j.a;
import jp.co.jreast.jreastapp.commuter.l.d;
import jp.co.jreast.jreastapp.commuter.m.o;
import jp.co.jreast.jreastapp.commuter.model.Route;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/NetworkTimetableSearchRepository;", "Ljp/co/jreast/jreastapp/commuter/repository/RouteSearchRepository;", "retrofitBuilder", "Lretrofit2/Retrofit$Builder;", "schedulerProvider", "Ljp/co/jreast/jreastapp/commuter/provider/SchedulerProvider;", "(Lretrofit2/Retrofit$Builder;Ljp/co/jreast/jreastapp/commuter/provider/SchedulerProvider;)V", "searchRoutes", "Lio/reactivex/Observable;", "", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "requestParameter", "Ljp/co/jreast/jreastapp/commuter/http/CommuterRequestParameter;", "baseUrl", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class m
implements o {
    private final n.a a;
    private final d b;

    public m(n.a a2, d d2) {
        j.b(a2, "retrofitBuilder");
        j.b(d2, "schedulerProvider");
        this.a = a2;
        this.b = d2;
    }

    @Override
    public e<List<Route>> a(a object, String string2) {
        j.b(object, "requestParameter");
        j.b(string2, "baseUrl");
        s s2 = new s.a().a(new b()).a();
        object = this.a.a(string2).a(Executors.newSingleThreadExecutor()).a(h.a()).a(f.b.a.a.a(s2)).a().a(NorikaeApi.class).searchUpcomingRoutes(object.a()).b(this.b.b()).a(this.b.a());
        j.a(object, "service.searchUpcomingRo\u2026n(schedulerProvider.ui())");
        return object;
    }
}

