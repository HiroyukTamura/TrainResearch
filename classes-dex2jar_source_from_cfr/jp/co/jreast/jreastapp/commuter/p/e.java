/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.p;

import java.util.List;
import jp.co.jreast.jreastapp.commuter.model.Route;
import jp.co.jreast.jreastapp.commuter.skewscroll.d;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001e\u0010\r\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Ljp/co/jreast/jreastapp/commuter/timetable/TimetableViewDataSource;", "Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewDataSource;", "scaleDensity", "", "skewScrollRecyclerViewCalculator", "Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewCalculator;", "(FLjp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewCalculator;)V", "calculatePixelForMinute", "viewHeight", "", "routes", "", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "getTopMargin", "pixelForMinute", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e
extends jp.co.jreast.jreastapp.commuter.skewscroll.e {
    private final d a;

    public e(float f2, d d2) {
        j.b(d2, "skewScrollRecyclerViewCalculator");
        super(f2);
        this.a = d2;
    }

    public /* synthetic */ e(float f2, d d2, int n2, g g2) {
        if ((n2 & 2) != 0) {
            d2 = new d();
        }
        this(f2, d2);
    }

    @Override
    public float a(int n2, List<Route> list) {
        j.b(list, "routes");
        return (float)(n2 - (int)((float)177 * this.a() + 0.5f)) / (float)this.a.b(list) * 0.7f;
    }

    @Override
    public float a(List<Route> list, float f2) {
        j.b(list, "routes");
        return this.a.a(list) * f2;
    }
}

