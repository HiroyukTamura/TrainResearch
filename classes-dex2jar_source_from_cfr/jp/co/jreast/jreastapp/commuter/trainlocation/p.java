/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 */
package jp.co.jreast.jreastapp.commuter.trainlocation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.v;
import java.util.List;
import jp.co.jreast.jreastapp.commuter.m.b;
import jp.co.jreast.jreastapp.commuter.m.f;
import jp.co.jreast.jreastapp.commuter.model.RailwayLineInformation;
import jp.co.jreast.jreastapp.commuter.trainlocation.m;
import jp.co.jreast.jreastapp.commuter.trainlocation.y;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000fJ\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Ljp/co/jreast/jreastapp/commuter/trainlocation/RailwayListViewModel;", "Landroidx/lifecycle/ViewModel;", "railwayRepository", "Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;", "drawableRepository", "Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;", "(Ljp/co/jreast/jreastapp/commuter/repository/LocalRailwayRepository;Ljp/co/jreast/jreastapp/commuter/repository/DrawableRepository;)V", "list", "", "Ljp/co/jreast/jreastapp/commuter/model/RailwayLineInformation;", "getList$app_productRelease", "()Ljava/util/List;", "setList$app_productRelease", "(Ljava/util/List;)V", "value", "", "pageType", "getPageType", "()I", "setPageType", "(I)V", "getAdapter", "Ljp/co/jreast/jreastapp/commuter/trainlocation/RailwayListAdapter;", "context", "Landroid/content/Context;", "pagerViewModel", "Ljp/co/jreast/jreastapp/commuter/trainlocation/TrainLocationPagerViewModel;", "getLineIcon", "Landroid/graphics/drawable/Drawable;", "lineInformation", "getNumberOfRailways", "getRailway", "position", "getRailwayType", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class p
extends v {
    private int a;
    private List<RailwayLineInformation> b;
    private final f c;
    private final b d;

    public p(f f2, b b2) {
        j.b(f2, "railwayRepository");
        j.b(b2, "drawableRepository");
        this.c = f2;
        this.d = b2;
        this.a = 1;
        this.b = kotlin.a.m.a();
    }

    public final Drawable a(RailwayLineInformation railwayLineInformation) {
        j.b(railwayLineInformation, "lineInformation");
        return this.d.a(railwayLineInformation);
    }

    public final m a(Context context, y y2) {
        j.b((Object)context, "context");
        j.b(y2, "pagerViewModel");
        return new m(context, y2, this);
    }

    public final void a(int n2) {
        this.b = this.c.a(n2);
    }

    public final int b() {
        return this.b.size();
    }

    public final RailwayLineInformation b(int n2) {
        return this.b.get(n2);
    }

    public final int c(int n2) {
        return this.b.get(n2).getDisplayType();
    }
}

