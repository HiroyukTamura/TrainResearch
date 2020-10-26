/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.commuterpager.a;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.common.f;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2={"Ljp/co/jreast/jreastapp/commuter/commuterpager/favoriteroutedetail/FavoriteRouteDetailLineIconPositionProvider;", "", "()V", "getLineIconPosition", "Ljp/co/jreast/jreastapp/commuter/common/LineIconPosition;", "position", "", "route", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e {
    /*
     * Enabled aggressive block sorting
     */
    public final f a(int n2, Route serializable) {
        j.b(serializable, "route");
        int n3 = ((Collection)((Route)serializable).getLines()).size();
        serializable = ((Route)serializable).getLines().get(n2);
        if (!((RailwayLine)serializable).getDirectOperationDeparture() && ((RailwayLine)serializable).getDirectOperationArrival()) {
            return f.c;
        }
        if (((RailwayLine)serializable).getDirectOperationDeparture() && !((RailwayLine)serializable).getDirectOperationArrival()) {
            return f.a;
        }
        if (n2 == 0) {
            if (n3 != 1) return f.a;
            return f.b;
        }
        if (n2 >= n3 - 1) return f.c;
        return f.b;
    }
}

