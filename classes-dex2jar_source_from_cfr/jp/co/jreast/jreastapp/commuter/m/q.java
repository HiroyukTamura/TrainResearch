/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.m;

import com.b.a.f;
import com.b.a.s;
import com.b.a.u;
import d.d;
import d.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.l.a;
import jp.co.jreast.jreastapp.commuter.m.a.b;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.FavoriteRoute;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.model.ServiceStatus;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.e.b.z;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001cJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0$0#H\u0002J\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010&\u001a\u00020\u0014H\u0002J\u000e\u0010'\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010(\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\rJ\u0016\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001cJ\u000e\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rJ\b\u0010-\u001a\u00020\u0019H\u0002J\u0016\u0010.\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u00060"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/UserFavoriteRouteRepository;", "", "saveDir", "Ljava/io/File;", "okioUtil", "Ljp/co/jreast/jreastapp/commuter/repository/di/OkioUtil;", "analyticsProvider", "Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "(Ljava/io/File;Ljp/co/jreast/jreastapp/commuter/repository/di/OkioUtil;Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;)V", "getAnalyticsProvider", "()Ljp/co/jreast/jreastapp/commuter/provider/AnalyticsProvider;", "favoriteRoutes", "", "Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "saveFileName", "", "saveFilePath", "getSaveFilePath", "()Ljava/io/File;", "areSame", "", "route", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "otherRoute", "clearServiceStatus", "", "favoriteRoute", "count", "", "delete", "position", "get", "index", "getAll", "getMoshiAdaptor", "Lcom/squareup/moshi/JsonAdapter;", "", "getRegisterTextResourceId", "isMaxRegisterd", "isRegistered", "migrate", "reOrder", "fromPosition", "toPosition", "register", "save", "update", "name", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class q {
    private final String a;
    private final File b;
    private List<FavoriteRoute> c;
    private final b d;
    private final a e;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public q(File list, b object, a a2) {
        block5 : {
            j.b(list, "saveDir");
            j.b(object, "okioUtil");
            this.d = object;
            this.e = a2;
            this.a = "favoriteRoutes.json";
            this.b = new File((File)((Object)list), this.a);
            try {
                list = this.d.b(this.b).p();
                break block5;
            }
            catch (FileNotFoundException fileNotFoundException) {}
            list = "";
        }
        object = (CharSequence)((Object)list);
        boolean bl2 = object == null || object.length() == 0;
        if (bl2) {
            list = new ArrayList();
        } else {
            list = this.e().a((String)((Object)list));
            if (list == null) {
                throw new t("null cannot be cast to non-null type kotlin.collections.MutableList<jp.co.jreast.jreastapp.commuter.model.FavoriteRoute>");
            }
            list = z.a(list);
        }
        this.c = list;
    }

    private final boolean a(Route object, Route route) {
        if (((Route)object).getLines().size() != route.getLines().size()) {
            return false;
        }
        object = ((Iterable)((Route)object).getLines()).iterator();
        int n2 = 0;
        while (object.hasNext()) {
            RailwayLine railwayLine = (RailwayLine)object.next();
            RailwayLine railwayLine2 = route.getLines().get(n2);
            if (!(j.a((Object)railwayLine.getFrom().getCode(), (Object)railwayLine2.getFrom().getCode()) ^ true) && !(j.a((Object)railwayLine.getTo().getCode(), (Object)railwayLine2.getTo().getCode()) ^ true)) {
                if (j.a((Object)railwayLine.getName(), (Object)railwayLine2.getName()) ^ true) {
                    return false;
                }
                ++n2;
                continue;
            }
            return false;
        }
        return true;
    }

    private final void c() {
        Object object = this.e().a(this.c);
        d d2 = this.d.a(this.b);
        d2.b((String)object);
        d2.flush();
        d2.close();
        object = this.e;
        if (object != null) {
            object.c(this.c.size());
        }
        if ((object = this.e) != null) {
            object.a(this.c);
        }
    }

    private final void c(FavoriteRoute object) {
        object = ((Iterable)((FavoriteRoute)object).getRoute().getLines()).iterator();
        while (object.hasNext()) {
            ((RailwayLine)object.next()).getServiceStatus().clearStatus();
        }
    }

    private final boolean d() {
        return ((Collection)this.c).size() >= 20;
    }

    private final f<List<FavoriteRoute>> e() {
        f<List<FavoriteRoute>> f2 = new s.a().a(new com.b.a.b.a.b()).a().a(u.a((Type)((Object)List.class), new Type[]{(Type)((Object)FavoriteRoute.class)}));
        j.a(f2, "moshi.adapter<List<FavoriteRoute>>(type)");
        return f2;
    }

    public final int a() {
        return ((Collection)this.c).size();
    }

    public final FavoriteRoute a(int n2) {
        return FavoriteRoute.copy$default(this.c.get(n2), null, null, 3, null);
    }

    public final void a(int n2, int n3) {
        if (n2 == n3) {
            return;
        }
        FavoriteRoute favoriteRoute = this.c.get(n2);
        this.c.remove(n2);
        this.c.add(n3, favoriteRoute);
        this.c();
    }

    public final void a(int n2, String string2) {
        j.b(string2, "name");
        if (j.a((Object)this.c.get(n2).getName(), (Object)string2) ^ true) {
            this.c.get(n2).setName(string2);
            this.c();
        }
    }

    public final void a(int n2, FavoriteRoute favoriteRoute) {
        j.b(favoriteRoute, "favoriteRoute");
        this.c.remove(n2);
        this.c(favoriteRoute);
        this.c.add(n2, favoriteRoute);
        this.c();
    }

    public final void a(FavoriteRoute favoriteRoute) {
        j.b(favoriteRoute, "favoriteRoute");
        this.c(favoriteRoute);
        this.c.add(favoriteRoute);
        this.c();
    }

    public final boolean a(Route route) {
        boolean bl2;
        j.b(route, "route");
        int n2 = this.b(route);
        boolean bl3 = bl2 = true;
        if (n2 != 2131558525) {
            bl3 = bl2;
            switch (n2) {
                default: {
                    bl3 = false;
                }
                case 2131558554: 
            }
        }
        return bl3;
    }

    public final int b(Route route) {
        j.b(route, "route");
        Iterator iterator = ((Iterable)this.c).iterator();
        while (iterator.hasNext()) {
            if (!this.a(route, ((FavoriteRoute)iterator.next()).getRoute())) continue;
            return 2131558554;
        }
        if (this.d()) {
            return 2131558525;
        }
        return 2131558553;
    }

    public final List<FavoriteRoute> b() {
        a a2 = this.e;
        if (a2 != null) {
            a2.a(this.c);
        }
        return this.c;
    }

    public final void b(int n2) {
        this.b(this.a(n2));
    }

    public final void b(FavoriteRoute object) {
        j.b(object, "favoriteRoute");
        if (this.c.remove(object)) {
            object = this.e;
            if (object != null) {
                object.h();
            }
            this.c();
        }
    }
}

