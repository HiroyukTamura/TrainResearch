/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.api;

import b.a.e;
import f.c.f;
import f.c.u;
import java.util.List;
import java.util.Map;
import jp.co.jreast.jreastapp.commuter.model.Route;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J*\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'J*\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H'\u00a8\u0006\u000b"}, d2={"Ljp/co/jreast/jreastapp/commuter/api/NorikaeApi;", "", "searchRoutes", "Lio/reactivex/Observable;", "", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "paramMap", "", "", "searchUpcomingRoutes", "searchUpdateRoute", "app_productRelease"}, k=1, mv={1, 1, 11})
public interface NorikaeApi {
    @f(a="routes")
    public e<List<Route>> searchRoutes(@u(a=true) Map<String, String> var1);

    @f(a="upcomingRoutes")
    public e<List<Route>> searchUpcomingRoutes(@u(a=true) Map<String, String> var1);

    @f(a="updateRoute")
    public e<List<Route>> searchUpdateRoute(@u(a=true) Map<String, String> var1);
}

