/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.skewscroll;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.model.BoardingStation;
import jp.co.jreast.jreastapp.commuter.model.RailwayLine;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.skewscroll.b;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001b\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0000\u00a2\u0006\u0002\b\nJ\u0014\u0010\u000b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\f\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a8\u0006\r"}, d2={"Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewCalculator;", "", "()V", "bottomMarginMinute", "", "routes", "", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "maxAccuracyMinutes", "", "maxAccuracyMinutes$app_productRelease", "maxTravelHeight", "topMarginMinute", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d {
    private final float d(List<Route> list) {
        float f2 = (new b().a() + new b().b()) * (float)(list.size() - 1);
        float f3 = m.f(list).minutesUntilDepartureOf(m.h(list));
        float f4 = 0.0f;
        f2 = f2 == 0.0f ? 0.0f : f3 / f2;
        int n2 = 0;
        for (Route route : (Iterable)list) {
            float f5 = (new b().a() + new b().b()) * (float)n2 * f2;
            float f6 = m.f(list).minutesUntilArrivalOf(route);
            f3 = f4;
            if (f6 > f5) {
                f5 = f6 - f5;
                f3 = f4;
                if (f5 > f4) {
                    f3 = f5;
                }
            }
            ++n2;
            f4 = f3;
        }
        return f4;
    }

    public final float a(List<Route> list) {
        j.b(list, "routes");
        float f2 = (new b().a() + new b().b()) * (float)(list.size() - 1);
        float f3 = m.f(list).minutesUntilDepartureOf(m.h(list));
        float f4 = 0.0f;
        f2 = f2 == 0.0f ? 0.0f : f3 / f2;
        int n2 = 0;
        for (Route route : (Iterable)list) {
            float f5 = m.f(list).minutesUntilDepartureOf(route);
            float f6 = (new b().a() + new b().b()) * (float)n2 * f2;
            f3 = f4;
            if (f5 < f6) {
                f5 = f6 - f5;
                f3 = f4;
                if (f5 > f4) {
                    f3 = f5;
                }
            }
            ++n2;
            f4 = f3;
        }
        return f4;
    }

    public final int b(List<Route> list) {
        j.b(list, "routes");
        return m.f(list).travelTime() + (int)(this.a(list) + this.d(list));
    }

    public final int c(List<Route> object) {
        long l2;
        Object object2;
        int n2;
        long l3;
        j.b(object, "routes");
        if (object.isEmpty()) {
            return 1;
        }
        Object object3 = (Iterable)object;
        Iterator iterator = object3.iterator();
        boolean bl2 = iterator.hasNext();
        Calendar calendar = null;
        if (!bl2) {
            object2 = null;
        } else {
            object = iterator.next();
            object2 = m.f(((Route)object).getLines()).getFrom().dateTime();
            if (object2 == null) {
                j.a();
            }
            l2 = ((Calendar)object2).getTimeInMillis();
            do {
                object2 = object;
                if (!iterator.hasNext()) break;
                object2 = iterator.next();
                Calendar calendar2 = m.f(((Route)object2).getLines()).getFrom().dateTime();
                if (calendar2 == null) {
                    j.a();
                }
                if (l2 <= (l3 = calendar2.getTimeInMillis())) continue;
                object = object2;
                l2 = l3;
            } while (true);
        }
        if (object2 == null) {
            j.a();
        }
        if ((object = m.f(((Route)object2).getLines()).getFrom().dateTime()) == null) {
            j.a();
        }
        long l4 = ((Calendar)object).getTimeInMillis();
        if (!(object3 = object3.iterator()).hasNext()) {
            object2 = calendar;
        } else {
            object = object3.next();
            object2 = m.h(((Route)object).getLines()).getTo().dateTime();
            if (object2 == null) {
                j.a();
            }
            l2 = ((Calendar)object2).getTimeInMillis();
            do {
                object2 = object;
                if (!object3.hasNext()) break;
                object2 = object3.next();
                calendar = m.h(((Route)object2).getLines()).getTo().dateTime();
                if (calendar == null) {
                    j.a();
                }
                if (l2 >= (l3 = calendar.getTimeInMillis())) continue;
                object = object2;
                l2 = l3;
            } while (true);
        }
        if (object2 == null) {
            j.a();
        }
        if ((object = m.h(((Route)object2).getLines()).getTo().dateTime()) == null) {
            j.a();
        }
        if ((n2 = (int)((((Calendar)object).getTimeInMillis() - l4) / (long)1000 / (long)60)) != 0) {
            return n2;
        }
        return 1;
    }
}

