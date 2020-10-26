/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.k;

import b.a.b.b;
import b.a.e;
import b.a.g;
import java.util.Date;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.m.h;
import jp.co.jreast.jreastapp.commuter.m.q;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.p.d;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2={"Ljp/co/jreast/jreastapp/commuter/migrate/MigrateMyRoutes;", "", "networkMigrateMyRouteRepository", "Ljp/co/jreast/jreastapp/commuter/repository/NetworkMigrateMyRouteRepository;", "userFavoriteRouteRepository", "Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "dateTimeUtil", "Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "(Ljp/co/jreast/jreastapp/commuter/repository/NetworkMigrateMyRouteRepository;Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;)V", "getDateTimeUtil", "()Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "setDateTimeUtil", "(Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;)V", "getNetworkMigrateMyRouteRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/NetworkMigrateMyRouteRepository;", "setNetworkMigrateMyRouteRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/NetworkMigrateMyRouteRepository;)V", "getUserFavoriteRouteRepository", "()Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "setUserFavoriteRouteRepository", "(Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;)V", "migrateMyRoutes", "", "updateMyRoutes", "index", "", "favoriteRoute", "Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a {
    private h a;
    private q b;
    private jp.co.jreast.jreastapp.commuter.d.a c;

    public a(h h2, q q2, jp.co.jreast.jreastapp.commuter.d.a a2) {
        j.b(h2, "networkMigrateMyRouteRepository");
        j.b(q2, "userFavoriteRouteRepository");
        j.b(a2, "dateTimeUtil");
        this.a = h2;
        this.b = q2;
        this.c = a2;
    }

    private final void a(final int n2, final FavoriteRoute favoriteRoute) {
        e<List<Route>> e2 = this.a.a(new d(favoriteRoute.getRoute().getPreviousNextKey(), this.c.a()), "https://rp.cloudrail.jp/com/api/");
        if (e2 == null) {
            j.a();
        }
        e2.a((g<List<Route>>)new g<List<? extends Route>>(){

            @Override
            public void a(b b2) {
                j.b(b2, "d");
            }

            @Override
            public void a(Throwable throwable) {
                j.b(throwable, "e");
            }

            public void a(List<Route> list) {
                j.b(list, "resultList");
                if (list.isEmpty()) {
                    return;
                }
                favoriteRoute.setRoute(list.get(0));
                this.b().a(n2, favoriteRoute);
            }

            @Override
            public /* synthetic */ void a_(Object object) {
                this.a((List)object);
            }

            @Override
            public void b_() {
            }
        });
    }

    public final void a() {
        int n2 = this.b.a() - 1;
        if (n2 >= 0) {
            int n3 = 0;
            do {
                this.a(n3, this.b.a(n3));
                if (n3 == n2) break;
                ++n3;
            } while (true);
        }
    }

    public final q b() {
        return this.b;
    }

}

