/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m;

import b.a.e;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.j.a;
import jp.co.jreast.jreastapp.commuter.model.Route;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/RouteSearchRepository;", "", "searchRoutes", "Lio/reactivex/Observable;", "", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "requestParameter", "Ljp/co/jreast/jreastapp/commuter/http/CommuterRequestParameter;", "baseUrl", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public interface o {
    public e<List<Route>> a(a var1, String var2);
}

