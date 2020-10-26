/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import java.io.Serializable;
import jp.co.jreast.jreastapp.commuter.model.Route;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/FavoriteRoute;", "Ljava/io/Serializable;", "name", "", "route", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "(Ljava/lang/String;Ljp/co/jreast/jreastapp/commuter/model/Route;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getRoute", "()Ljp/co/jreast/jreastapp/commuter/model/Route;", "setRoute", "(Ljp/co/jreast/jreastapp/commuter/model/Route;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class FavoriteRoute
implements Serializable {
    private String name;
    private Route route;

    public FavoriteRoute(String string2, Route route) {
        j.b(string2, "name");
        j.b(route, "route");
        this.name = string2;
        this.route = route;
    }

    public static /* synthetic */ FavoriteRoute copy$default(FavoriteRoute favoriteRoute, String string2, Route route, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string2 = favoriteRoute.name;
        }
        if ((n2 & 2) != 0) {
            route = favoriteRoute.route;
        }
        return favoriteRoute.copy(string2, route);
    }

    public final String component1() {
        return this.name;
    }

    public final Route component2() {
        return this.route;
    }

    public final FavoriteRoute copy(String string2, Route route) {
        j.b(string2, "name");
        j.b(route, "route");
        return new FavoriteRoute(string2, route);
    }

    public boolean equals(Object object) {
        block2 : {
            block3 : {
                if (this == object) break block2;
                if (!(object instanceof FavoriteRoute)) break block3;
                object = (FavoriteRoute)object;
                if (j.a((Object)this.name, (Object)((FavoriteRoute)object).name) && j.a((Object)this.route, (Object)((FavoriteRoute)object).route)) break block2;
            }
            return false;
        }
        return true;
    }

    public final String getName() {
        return this.name;
    }

    public final Route getRoute() {
        return this.route;
    }

    public int hashCode() {
        Object object = this.name;
        int n2 = 0;
        int n3 = object != null ? object.hashCode() : 0;
        object = this.route;
        if (object != null) {
            n2 = object.hashCode();
        }
        return n3 * 31 + n2;
    }

    public final void setName(String string2) {
        j.b(string2, "<set-?>");
        this.name = string2;
    }

    public final void setRoute(Route route) {
        j.b(route, "<set-?>");
        this.route = route;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FavoriteRoute(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", route=");
        stringBuilder.append(this.route);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

