/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.skewscroll;

import java.util.List;
import jp.co.jreast.jreastapp.commuter.model.Route;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\u0006\u0010\u000b\u001a\u00020\u0003J\u001e\u0010\f\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\u0003H&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Ljp/co/jreast/jreastapp/commuter/skewscroll/SkewScrollRecyclerViewDataSource;", "", "scaleDensity", "", "(F)V", "calculatePixelForMinute", "viewHeight", "", "routes", "", "Ljp/co/jreast/jreastapp/commuter/model/Route;", "getScaleDensity", "getTopMargin", "pixelForMinute", "app_productRelease"}, k=1, mv={1, 1, 11})
public abstract class e {
    private final float a;

    public e(float f2) {
        this.a = f2;
    }

    public final float a() {
        return this.a;
    }

    public abstract float a(int var1, List<Route> var2);

    public abstract float a(List<Route> var1, float var2);
}

